import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserInfo } from './app.component';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http: HttpClient) { }

  private api: string = '/api'

  private httpOptions: any = {

    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    }),
    body: null
  };
  /**
     * 検索
     * @param userInfo 
     */
  homeFindByParams(userInfo: UserInfo) {
    return this.http.post<UserInfo>(this.api + '/app/search', userInfo);
  }

  /**
   * 登録
   * @param userInfo 
   */
  homePost(userInfo: UserInfo) {
    return this.http.post<UserInfo>(this.api + '/Home/', userInfo);
  }
}
