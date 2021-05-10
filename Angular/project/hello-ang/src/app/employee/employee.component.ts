import { Component, OnInit } from '@angular/core';
import { Employee } from './Employee';
import { EmployeeService } from '../services/emp.service'
import { ApiResponse } from '../models/ApiResponse';
@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {
  employees: Array<Employee> = new Array();
  employee: Employee = new Employee();
  employeesCount: number = this.employees.length;
  ageCounter: number = 0;
  apiResponse: ApiResponse = new ApiResponse();
  // name: string = "Hadeer";
  // lastName: string = "Elnaggar";
  constructor(private _employeeService: EmployeeService) { }

  employeeExists(name): boolean {
    this.employees.forEach(emp => {
      if (emp.Name === name) {
        return true;
      }
    });
    return false;
  }

  allEmployees(): string {
    let temp: string = "";
    this.employees.forEach(emp => {
      temp += emp.FirstName + ", ";
    });
    return temp;
  }
  addEmployee(name: string, lastName:string, email: string, age: number, mobile: string): void {
    if (!this.employeeExists(name)) {
      let empl: Employee = new Employee(name, lastName, email, age, mobile);
      this._employeeService.post(empl).subscribe(
        response => {
          this.apiResponse = response
          if(this.apiResponse.Success===true){
            empl.ID = this.apiResponse.Data as number;
            this.employees.push(empl);
            this.employeesCount++;
          }
          
        },
        error => {
          this.apiResponse = error
          alert(this.apiResponse.Message);
         });
    }

  }
  ngOnInit(): void {
    this._employeeService.get().subscribe(
      response => {
        this.apiResponse = response;
        if (this.apiResponse.Success === true) {
          this.employees = this.apiResponse.Data;
        }
      },
      error => {
        alert("Error occured");
      });
  }

  incrementCounter(): void {
    this.ageCounter++;
  }

  zeroAgeCounter(): void {
    this.ageCounter = 0;
  }

  deleteEmployee(index: number): void {
    this._employeeService.delete(this.employees[index].ID).subscribe(
      response=>{
        this.employees.splice(index, 1);
      },
      error=>{
        alert("error");
      }
    );
    
  }

  getEmployeeCounter(): number {
    return this.employees.filter(value => value.Age < 20).length;
  }

}
