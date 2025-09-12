import { Component } from '@angular/core';
import { MatDialogModule } from '@angular/material/dialog';

@Component({
  selector: 'app-my-dialog',
  imports: [MatDialogModule],
  template: `
    <h1 mat-dialog-title>Popup Title</h1>
    <div mat-dialog-content>
      <p>This is the content of the popup!</p>
    </div>
    <div mat-dialog-actions>
      <button mat-button mat-dialog-close>Close</button>
    </div>
  `
})
export class MyDialogComponent {}
