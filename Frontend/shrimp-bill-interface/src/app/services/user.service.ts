import { Injectable } from '@angular/core';
import { ProfileResponse } from './auth.service';

@Injectable({ providedIn: 'root' })
export class UserService {
  private userProfile?: ProfileResponse;

  setProfile(profile: ProfileResponse) {
    this.userProfile = profile;
  }

  getProfile(): ProfileResponse | undefined {
    return this.userProfile;
  }

  getUserName(): string {
    return this.userProfile?.nombre ?? 'Usuario';
  }

  clearProfile() {
    this.userProfile = undefined;
  }
}
