<template>
  <div class = 'employees'>
    <h1>Employees</h1>
    <div class = 'employee' v-for='employee in employees' 
    v-bind:key="employee.id">
    <!-- employee id is transferred to the url, but not the 
    input field -->
    <table id = "empl_table">
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
        <td>City, State zip:</td>
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
      <div class='empl-button'>
        <button>
        <router-link class = 'h-link' v-bind:to="{ name: 'display-detail', params: { id: employee.id }}"
          >View Employee Data</router-link>
        </button>
      </div>
    
  </div>
  </div>
</template>

<script>
import employeeService from '@/services/EmployeeService.js'
export default {
    props:{
      
    },
    data(){
      return{
          employees:[]
      } 
    },
    created() {
        employeeService.getAllEmployees().then((response) => {
            this.employees = response.data;
        })

        //,
        // this is for a hyperlink in employees to 
        // jump directly to employee by id
    // created() {
    //     employeeService.getEmployeeById().then((response) => {
    //         this.id = response.data;
    //     })
      .catch((err) => {
        console.error(err + "missing data");
      });   
    }

}
</script>

<style scoped>
.h1 {
  color: rgb(81, 88, 18);
  margin-left: 35px;
}

.employees {
  
  padding-left: px;
  margin-left: 5px;
  border-radius: 0px;
}
.employee {
  padding-top: 3px;
  padding-left: 5px;
  margin-left: 5px;
  background: cornsilk;
  border:#94c0e4;
  border-style: solid;
  border-width: 9px;
  margin-bottom: 9px;

}
.h-link {
  color: rgb(112, 18, 189);
  font-size: 11pt;
  font-weight: bold;
  text-decoration-line: none;
}
.empl-button {
  border-radius: 5px;
  background-color: cornsilk;
  padding: 7px;
  text-decoration: none;
}
.button {
  background-color:cornsilk;
  border: none;
  color: white;
  text-align: center;
  display: inline-block;
  font-size: 16px;
  margin: 2px ;
  cursor: pointer;
}
</style>