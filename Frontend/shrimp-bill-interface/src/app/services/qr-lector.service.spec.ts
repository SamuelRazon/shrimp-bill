import { TestBed } from '@angular/core/testing';

import { QrLectorService } from './qr-lector.service';

describe('QrLectorService', () => {
  let service: QrLectorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(QrLectorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
