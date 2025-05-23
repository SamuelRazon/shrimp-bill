import { ComponentFixture, TestBed } from '@angular/core/testing';
import { BarcodeFormat } from '@zxing/library';
import { ScanQrComponent } from './scan-qr.component';

describe('ScanQrComponent', () => {
  let component: ScanQrComponent;
  let fixture: ComponentFixture<ScanQrComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ScanQrComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ScanQrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
