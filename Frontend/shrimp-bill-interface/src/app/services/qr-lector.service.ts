import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class QrLectorService {
  private readonly storagekey = 'qrData';

  save(data: { token: string, date: string, time: string}) {
    sessionStorage.setItem(this.storagekey, JSON.stringify(data));
  }

  get(): { token: string, date: string, time:string } | null {
    const json = sessionStorage.getItem(this.storagekey);
    return json ? JSON.parse(json) : null;
  }
  
  clear(){
    sessionStorage.removeItem(this.storagekey)
  }
  constructor() { }
}
