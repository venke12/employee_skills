<template>
    <div class="addEmployee">
        <h1>Add Employee</h1>
        <table class='employee'>
            <tr>
                <td>First name:</td> 
                <td><label for = 'enter employee first name'></label>
                    <input type = "text" id = 'firstname'
                    v-model = 'employee.firstname' 
                    placeholder="enter employee first name">
                </td>
            </tr>
            <tr>
                <td>Last name:</td>
                <td><label for = 'enter employee last name'></label>
                    <input type = "text" id = 'lastname'
                    v-model = 'employee.lastname' 
                    placeholder="enter employee last name"></td>
            </tr>
           <tr>
                <td>Birth date:</td>
                <td><label for = 'enter employee birthdate'></label>
                    <input type = "text" id = 'birthdate'
                    v-model = 'employee.birthdate' 
                    placeholder="enter employee birthdate"></td>
            </tr>
            <tr>
                <td>Hire date:</td>
                <td><label for = 'enter employee hiredate'></label>
                    <input type = "text" id = 'hiredate'
                    v-model = 'employee.hiredate' 
                    placeholder="enter employee hiredate"></td>
            </tr>
            <tr>
                <td>Street:</td>
                <td><label for = 'enter employee street'></label>
                    <input type = "text" id = 'street'
                    v-model = 'employee.address.street' 
                    placeholder="enter employee street"></td>
            </tr>
            <tr>
                <td>Suite:</td>
                <td><label for = 'enter employee suite'></label>
                    <input type = "text" id = 'suite'
                    v-model = 'employee.address.suite' 
                    placeholder="enter employee suite"></td>
            </tr>
            <tr>
                <td>City:</td>
                <td><label for = 'enter employee city'></label>
                    <input type = "text" id = 'city'
                    v-model = 'employee.address.city' 
                    placeholder="enter employee city"></td>
            </tr>
             <tr>
                <td>State:</td>
                <td><label for = 'enter employee state_region'></label>
                    <input type = "text" id = 'state_region'
                    v-model = 'employee.address.state_region' 
                    placeholder="enter employee state_region"></td>
            </tr>
             <tr>
                <td>Zip:</td>
                <td><label for = 'enter employee zip'></label>
                    <input type = "text" id = 'zip'
                    v-model = 'employee.address.zip' 
                    placeholder="enter employee zip"></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><label for = 'enter employee country'></label>
                    <input type = "text" id = 'country'
                    v-model = 'employee.address.country' 
                    placeholder="enter employee country"></td>
            </tr>
            <tr>
                <td> Role id:</td>
                <td><label for = 'enter employee role.id'></label>
                    <input type = "text" id = 'role.id'
                    v-model = 'employee.role.id' 
                    placeholder="enter employee role_id"></td>
            </tr>
            <button class = 'sub-button' 
                v-on:click.prevent='createEmployee'>Submit</button>
        
        </table>
    </div>
</template>

<script>

import employeeService from '@/services/EmployeeService.js'
export default {
    name: 'add-employee',
    data(){
      return{
          employee:{
              firstname:"",
              lastname:"",
              address:{
                street:"",
                suite:"",
                city:"",
                state_region:"",
                zip:"",
              country:""
              },
              birthdate:"",
              hiredate:"",
              role:{
                  id:""
              }
          }
      }
    },
    methods:{
    createEmployee() {
        
        employeeService.createEmployee(this.employee).then((response) => {
            if(response.status === 201) {
                alert("Employee added");
            }
            this.employee = {
              firstname:"",
              lastname:"",
              address:{
                street:"",
                suite:"",
                city:"",
                state_region:"",
                zip:"",
              country:""
              },
              birthdate:"",
              hiredate:"",
              role:{
                  id:""
              }
          
            };
           this.$forceUpdate();
        })
        .catch((err) => {
            console.error(err + "employee not added")
        })

    }
    }
}
</script>

<style scoped>
.h1 {
  color: rgb(81, 88, 18);
  margin-left: 35px;
}
.employee {
  padding-top: 3px;
  padding-left: 5px;
  margin-left: 5px;
  background: cornflowerblue;
}

table.emplpoyee {
    table-layout: fixed;
    width:380px;
}
input {
    width: 300px;
    border-radius: 4px;
    color: navy;
    border-color:darkblue;

}
td{
    font-size: 18px;
    color: purple;
    font-weight: bold;
}
.sub-button {
  color: rgb(112, 18, 189);
  font-size: 11pt;
  font-weight: bold;
  text-decoration-line: none;
  margin-bottom: 5px;
}
.button {
    border-radius: 5px;
    
}
</style>