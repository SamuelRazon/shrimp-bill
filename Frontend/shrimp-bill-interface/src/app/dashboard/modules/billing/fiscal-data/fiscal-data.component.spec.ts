import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FiscalDataComponent } from './fiscal-data.component';

describe('FiscalDataComponent', () => {
  let component: FiscalDataComponent;
  let fixture: ComponentFixture<FiscalDataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FiscalDataComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FiscalDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
