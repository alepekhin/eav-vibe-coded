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
//import { CdkColumnDef } from '@angular/cdk/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSortModule, MatSort } from '@angular/material/sort';
import { ViewChild } from '@angular/core'
import { MatDialogModule } from '@angular/material/dialog';
import { MyDialogComponent } from './entity-type-dialog';
import { MatDialog } from '@angular/material/dialog';

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
    MatDialogModule,
  ],
  templateUrl: './entity-type.html',
  styleUrls: ['./entity-type.css'],
 // providers: [CdkColumnDef],
})
export class EntityTypeComponent implements OnInit {

  entityTypes: EntityType[] = [];
  displayedColumns: string[] = ['id', 'name', 'actions'];
  dataSource = new MatTableDataSource<EntityType>(this.entityTypes);
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private entityTypeService: EntityTypeService, 
              private dialog: MatDialog) { }


  ngOnInit(): void {
    this.getAllEntityTypes();
  }
  
  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
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

  // Create EntityType
  create(): void {
      this.openDialog({name:''});
  }

  // Update EntityType
  update(element: EntityType): void {
      this.openDialog(element);
  }

  // Delete an EntityType
  delete(id: number): void {
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
  
  openDialog(element: EntityType) {
      console.log('open dialog element '+element);
      const dialogRef = this.dialog.open(MyDialogComponent, {
      width: '400px',
      data: element
    });

    dialogRef.afterClosed().subscribe(result => {
        this.getAllEntityTypes();
      console.log('Dialog was closed');
      // You can handle the result here
      if (result) {
        // Do something based on the result
      }
    });
    //this.dialog.open(MyDialogComponent);
  }

}
