// entity-type.component.ts

import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { EntityTypeService, EntityType } from './entity-type-service';

@Component({
  selector: 'app-entity-type',
  imports: [
    CommonModule,  
    FormsModule,
  ],
  templateUrl: './entity-type.html',
  styleUrls: ['./entity-type.css']
})
export class EntityTypeComponent implements OnInit {

  entityTypes: EntityType[] = [];
  selectedEntityType: EntityType = {id: 0, name: ''};
  newEntityType: EntityType = { name: '' };

  constructor(private entityTypeService: EntityTypeService) { }


  ngOnInit(): void {
    this.getAllEntityTypes();
  }

  selectEntityType(entityType: EntityType) {
    this.selectedEntityType = { ...entityType };
  }

  // Fetch all entity types
  getAllEntityTypes(): void {
    this.entityTypeService.getAll().subscribe(data => {
      this.entityTypes = data;
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

}
