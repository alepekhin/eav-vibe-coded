import { Component } from '@angular/core';
import { EntityTypeComponent } from './components/entity-type/entity-type.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [EntityTypeComponent],
  templateUrl: 'app.component.html',
  styleUrls: ['./components/entity-type/entity-type.component.css'],
})
export class AppComponent {
  title = 'no title';
}
