// entity-type.component.ts

import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

// Define the EntityType interface
interface EntityType {
  id?: number;
  name: string;
  // add other properties as needed
}

@Component({
  selector: 'app-entity-type',
  imports: [
    CommonModule,  
    FormsModule,
    HttpClientModule, 
  ],
  templateUrl: './entity-type.html',
  styleUrls: ['./entity-type.css']
})
export class EntityTypeComponent implements OnInit {

  entityTypes: EntityType[] = [];
  selectedEntityType: EntityType | null = null;
  newEntityType: EntityType = { name: '' };

  private apiUrl = 'http://localhost:8080/api/entity-types';

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.getAllEntityTypes();
  }

  // Fetch all entity types
  getAllEntityTypes(): void {
    this.http.get<EntityType[]>(this.apiUrl)
      .subscribe(data => {
        this.entityTypes = data;
      });
  }

  // Save a new EntityType
  saveEntityType(): void {
    this.http.post<EntityType>(this.apiUrl, this.newEntityType)
      .subscribe(saved => {
        this.entityTypes.push(saved);
        this.newEntityType = { name: '' }; // Reset form
      });
  }

  // Update EntityType
  updateEntityType(): void {
    this.http.post<EntityType>(this.apiUrl, this.selectedEntityType)
      .subscribe(saved => {
          this.getAllEntityTypes();
      });
  }

  // Select an EntityType to view details
  selectEntityType(id: number): void {
    this.http.get<EntityType>(`${this.apiUrl}/${id}`)
      .subscribe(data => {
        this.selectedEntityType = data;
      });
  }

  // Delete an EntityType
  deleteEntityType(id: number): void {
    this.http.delete(`${this.apiUrl}/${id}`)
      .subscribe(() => {
        this.entityTypes = this.entityTypes.filter(et => et.id !== id);
        if (this.selectedEntityType && this.selectedEntityType.id === id) {
          this.selectedEntityType = null;
        }
      });
  }

}
