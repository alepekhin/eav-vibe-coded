import { Component, signal } from '@angular/core';
//import { RouterOutlet } from '@angular/router';
import { EntityType } from './entity-type/entity-type';

@Component({
  selector: 'app-root',
  imports: [
//      RouterOutlet,
      EntityType,
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');
}
