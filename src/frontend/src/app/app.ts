import { Component, signal } from '@angular/core';
import { EntityTypeComponent } from './entity-type/entity-type';

@Component({
  selector: 'app-root',
  imports: [
      EntityTypeComponent,
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');
}
