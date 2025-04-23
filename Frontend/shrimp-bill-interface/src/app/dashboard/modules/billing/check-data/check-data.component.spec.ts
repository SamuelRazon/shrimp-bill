import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckDataComponent } from './check-data.component';

describe('CheckDataComponent', () => {
  let component: CheckDataComponent;
  let fixture: ComponentFixture<CheckDataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CheckDataComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CheckDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
