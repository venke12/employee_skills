<template>
  <div class="EmployeeById">
    <h1>Employee By Id</h1>
      <form class='form-input' v-on:submit.prevent='getEmployee'>
        <label for = 'enter employee id'>Employee Number:   </label>
        <input type = "number" min=1 id = 'employee_id'
        class = 'form-control' v-model = 'employeeId' 
        placeholder="enter employee number">
        <button class = 'sub-button'>Submit</button>
      </form>    
    <div class='left-bar'>
    <div class = 'employee' v-if='employee.id'>
        <br/>
    <table>
      <tr>
        <td> Employee id:</td>
        <td>{{employee.id}}</td>
      </tr>
      <tr>
        <td>Name:</td>
        <td>{{(employee.firstname + ' ' + employee.lastname).trim()}}</td>
      </tr>
        <td>Birthdate:</td>
        <td>{{employee.birthdate}}</td>
      <tr>
        <td>Hiredate:</td>
        <td>{{employee.hiredate}}</td>
      </tr>
      <tr>
        <td>Address id:</td>
        <td>{{employee.address.id}}</td>
      </tr>
      <tr>
        <td>Street:</td>
        <td>{{employee.address.street}}</td>
      </tr>
      <tr>
        <td>Suite:</td>
        <td>{{employee.address.suite}}</td>
      </tr>
      <tr>
        <td>City, State Zip:</td>
        <td>{{(employee.address.city + ', ' + employee.address.state_region + ' ' + employee.address.zip).trim()}}</td>
      </tr>
      <tr>
        <td>Country:</td>
        <td>{{employee.address.country}}</td>
      </tr>
      <tr>
        <td> Role id:</td>
        <td>{{employee.role.id}}</td>
      </tr>
      <tr>
        <td>Role:</td>
        <td>{{employee.role.name}}</td>
      </tr>
      <tr>
        <td>Description:</td>
        <td>{{employee.role.description}}</td>
      </tr>
    </table>
      </div>
  </div>
  </div>
</template>

<script>
import employeeService from '@/services/EmployeeService.js'
export default {
    name: 'employee-by-id',
    data(){
      return{
          employee:{
          },
         employeeId: ''
      } 
    },
    methods:{
    getEmployee() {
        employeeService.getEmployeeById(this.employeeId).then((response) => {
            this.employee = response.data;
        })
    }
    }
}
</script>

<style>
.h1 {
  color: rgb(68, 5, 168);
  margin-left: 35px;
}
.form-input {
    margin-left:35px;
    margin-bottom: 12px;
  list-style-type: none;
  color:navy;
   font-size: 16px;
   font-weight:bold;
}
.employee {
  
  padding-left: 5px;
  margin-left: 5px;
  background: cornsilk;
  border:#94c0e4;
  border-style: solid;
  border-width: 9px;
}
input[type=text], select {
  width: 100%;
  padding: 5px;
  margin: 3px ;
  display: inline-block;
  border: 2px solid #ccc;
  border-radius: 12px;
  box-sizing: border-box;
}
input[type=submit] {
    color:blue;
  width: 100%;
  background-color: #1fbe25;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
input[type=submit]:hover {
  background-color: #45a049;
}
.sub-button {
  color: rgb(112, 18, 189);
  font-size: 11pt;
  font-weight: bold;
  text-decoration-line: none;
}
.button {
  margin-bottom: 5px;
  border: none;
  color: white;
  padding: 15px 12px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 2px ;
  cursor:pointer;
}
</style>