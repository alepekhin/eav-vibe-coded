import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpClientModule } from '@angular/common/http';

export interface EntityType {
  id?: number;
  name: string;
}

@Injectable({
  providedIn: 'root'
})
export class EntityTypeService {
  private apiUrl = 'http://localhost:8080/api/entity-types';

  constructor(private http: HttpClient) { }

  getAll(): Observable<EntityType[]> {
    return this.http.get<EntityType[]>(this.apiUrl);
  }

  getById(id: number): Observable<EntityType> {
    return this.http.get<EntityType>(`${this.apiUrl}/${id}`);
  }

  save(entityType: EntityType): Observable<EntityType> {
      console.log("saving id "+entityType.id);
    return this.http.post<EntityType>(this.apiUrl, entityType);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}


