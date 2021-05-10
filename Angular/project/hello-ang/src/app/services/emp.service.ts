import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from '../employee/Employee';
import { Observable } from 'rxjs';
import { ApiResponse } from '../models/ApiResponse';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private _httpClient:HttpClient) { }

  get():Observable<any>{
   return this._httpClient.get("http://api.mohamed-sadek.com/Student/Get");
  }

  delete(id:number):Observable<any>{
    return this._httpClient.delete("http://api.mohamed-sadek.com/Student/delete?id="+id);
  }
   
  post(employee:Employee):Observable<any>{
    return this._httpClient.post("http://api.mohamed-sadek.com/Student/Post",employee);
   }


}