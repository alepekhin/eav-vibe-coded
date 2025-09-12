// entity-type.component.ts

import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { EntityTypeService, EntityType } from './entity-type-service';
import { MatTableModule } from '@angular/material/table';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { CdkColumnDef } from '@angular/cdk/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSortModule, MatSort } from '@angular/material/sort';
import { ViewChild } from '@angular/core'
//import { BrowserModule } from '@angular/platform-browser';    
//import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@Component({
  selector: 'app-entity-type',
  imports: [
    CommonModule,  
    FormsModule,
    MatTableModule,
    MatPaginatorModule,
    MatFormFieldModule,
    MatInputModule,
    MatPaginator,
    MatSortModule,
   // BrowserModule,
   // BrowserAnimationsModule,
  ],
  templateUrl: './entity-type.html',
  styleUrls: ['./entity-type.css'],
  providers: [CdkColumnDef],
})
export class EntityTypeComponent implements OnInit {

  entityTypes: EntityType[] = [];
  selectedEntityType: EntityType = {id: 0, name: ''};
  newEntityType: EntityType = { name: '' };
  displayedColumns: string[] = ['id', 'name'];
  dataSource = new MatTableDataSource<EntityType>(this.entityTypes);
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private entityTypeService: EntityTypeService) { }


  ngOnInit(): void {
    this.getAllEntityTypes();
  }
  
  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
  }

  selectEntityType(entityType: EntityType) {
    this.selectedEntityType = { ...entityType };
  }

  // Fetch all entity types
  getAllEntityTypes(): void {
    this.entityTypeService.getAll().subscribe(data => {
      this.entityTypes = data;
      setTimeout( () => {
        this.dataSource = new MatTableDataSource<EntityType>(this.entityTypes);
        this.dataSource.paginator = this.paginator; 
        this.dataSource.sort = this.sort;
      }, 1000  );
    });
  }

  // Save a new EntityType
  saveEntityType(): void {
       this.entityTypeService.save(this.newEntityType).subscribe(() => {
        this.getAllEntityTypes();
        this.newEntityType = { name: '' };
      });
  }

  // Update EntityType
  updateEntityType(): void {
      this.entityTypeService.save(this.selectedEntityType).subscribe(() => {
        this.getAllEntityTypes();
        this.newEntityType = { name: '' };
      });
  }

  // Delete an EntityType
  deleteEntityType(id: number): void {
    if (id) {
      this.entityTypeService.delete(id).subscribe(() => {
        this.getAllEntityTypes();
      });
    }
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}
