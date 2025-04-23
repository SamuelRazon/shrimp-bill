import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface RegisterRequest {
  nombre: string;
  apellidos: string;
  email: string;
  password: string;
}

export interface RegisterResponse {
  token: string;
  id: number;
  nombre: string;
  apellidos: string;
  email: string;
}

export interface LoginRequest {
  email: string;
  password: string;
}

export interface LoginResponse {
  token: string;
}

// **Interfaz para lo que retorna GET /api/auth/me**
export interface ProfileResponse {
  id: number;
  nombre: string;
  apellidos: string;
  email: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = 'http://localhost:8080/api/auth';

  constructor(private http: HttpClient) {}

  register(data: RegisterRequest): Observable<RegisterResponse> {
    return this.http.post<RegisterResponse>(`${this.baseUrl}/registro`, data);
  }

  login(data: LoginRequest): Observable<LoginResponse>{
    return this.http.post<LoginResponse>(`${this.baseUrl}/login`, data);
  }

  logout(): void {
    // 1. Borra el token de localStorage
    localStorage.removeItem('token');
    // 2. Opcional, redirige a un sitio en especifico
    // this.router.navigate(['/ubicacionquedecidamos']);
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }

    /** 
   * Llama al endpoint /me para obtener los datos del usuario
   * e incluye el header Authorization con el token guardado. 
   */
    profile(): Observable<ProfileResponse> {
      const token = this.getToken();
      if (!token) {
        throw new Error('No se encontró token de autenticación');
      }
      const headers = new HttpHeaders({
        Authorization: `Bearer ${token}`
      });
      return this.http.get<ProfileResponse>(`${this.baseUrl}/me`, { headers });
    }

}