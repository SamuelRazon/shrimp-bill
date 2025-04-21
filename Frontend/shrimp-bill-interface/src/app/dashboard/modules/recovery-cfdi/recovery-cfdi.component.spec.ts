import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecoveryCfdiComponent } from './recovery-cfdi.component';

describe('RecoveryCfdiComponent', () => {
  let component: RecoveryCfdiComponent;
  let fixture: ComponentFixture<RecoveryCfdiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RecoveryCfdiComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RecoveryCfdiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
