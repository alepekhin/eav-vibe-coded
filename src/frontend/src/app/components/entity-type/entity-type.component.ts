import { Component, OnInit } from '@angular/core';
import { EntityTypeService, EntityType } from '../../services/entity-type.service';

import { CommonModule } from '@angular/common'

@Component({
  selector: 'app-entity-type',
  imports: [CommonModule],
  templateUrl: './entity-type.component.html',
  styleUrls: ['./entity-type.component.css'],
  standalone: true
})
export class EntityTypeComponent implements OnInit {
  entityTypes: EntityType[] = [];
  selectedEntityType?: EntityType;
  newEntityType: EntityType = { name: '' };

  constructor(private entityTypeService: EntityTypeService) { }

  ngOnInit(): void {
    this.loadEntityTypes();
  }

  loadEntityTypes() {
    this.entityTypeService.getAll().subscribe(data => {
      this.entityTypes = data;
    });
  }

  selectEntityType(entityType: EntityType) {
    this.selectedEntityType = { ...entityType };
  }

  saveEntityType() {
    if (this.selectedEntityType && this.selectedEntityType.id) {
      // For this API, create is only POST, so editing might need a PUT method if available.
      // Assuming create only, so editing is not implemented here.
    } else {
      this.entityTypeService.create(this.newEntityType).subscribe(() => {
        this.loadEntityTypes();
        this.newEntityType = { name: '' };
      });
    }
  }

  deleteEntityType(id?: number) {
    if (id) {
      this.entityTypeService.delete(id).subscribe(() => {
        this.loadEntityTypes();
      });
    }
  }

  cancel() {
    this.selectedEntityType = undefined;
    this.newEntityType = { name: '' };
  }
}


