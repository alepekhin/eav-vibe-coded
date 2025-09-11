import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EntityType } from './entity-type';

describe('EntityType', () => {
  let component: EntityType;
  let fixture: ComponentFixture<EntityType>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EntityType]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EntityType);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
