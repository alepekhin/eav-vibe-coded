import { Component, OnInit } from '@angular/core';
import { EntityTypeService, EntityType } from '../../services/entity-type.service';

import { CommonModule } from '@angular/common'
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-entity-type',
  imports: [CommonModule, FormsModule],
  templateUrl: './entity-type.component.html',
  styleUrls: ['./entity-type.component.css'],
  standalone: true
})
export class EntityTypeComponent implements OnInit {
  entityTypes: EntityType[] = [];
  selectedEntityType: EntityType = {id: 0, name: ''};
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

  createEntityType() {
      this.entityTypeService.save(this.newEntityType).subscribe(() => {
        this.loadEntityTypes();
        this.newEntityType = { name: '' };
      });
  }

  updateEntityType() {
      this.entityTypeService.save(this.selectedEntityType).subscribe(() => {
        this.loadEntityTypes();
        this.newEntityType = { name: '' };
      });
  }

  deleteEntityType(id?: number) {
    if (id) {
      this.entityTypeService.delete(id).subscribe(() => {
        this.loadEntityTypes();
      });
    }
  }

  cancel() {
    this.newEntityType = { name: '' };
  }
}


