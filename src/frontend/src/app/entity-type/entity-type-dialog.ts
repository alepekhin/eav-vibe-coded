import { MatDialogModule } from '@angular/material/dialog';
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { EntityTypeService, EntityType } from './entity-type-service';
import { MatDialogRef } from '@angular/material/dialog';  
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Inject } from '@angular/core';

@Component({
  selector: 'app-my-dialog',
  imports: [
    CommonModule,  
    FormsModule,
    MatDialogModule,
  ],
  templateUrl: './entity-type-dialog.html',
})
export class MyDialogComponent {

  constructor(private entityTypeService: EntityTypeService, 
              private dialogRef: MatDialogRef<MyDialogComponent>,
              @Inject(MAT_DIALOG_DATA) public entityType: EntityType) { }

  saveEntityType(): void {
      console.log('saving'+this.entityType.name+' id '+this.entityType.id);
       this.entityTypeService.save(this.entityType).subscribe(() => {
           this.dialogRef.close(/* optional result data */);
      });
  }

  closeDialog(event: Event) {
    event.preventDefault(); // Prevent default href behavior
    this.dialogRef.close(); // Close the dialog
  }

}
