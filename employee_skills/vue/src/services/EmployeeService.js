import axios from 'axios';

const http=axios.create({
    baseURL: 'http://localhost:8080'
});

export default{
    getAllEmployees(){
        return http.get('/employee/');
    },
    getEmployeeById(id){
        return http.get(`/employee/${id}`);
    },
    createEmployee(employee){
        return http.post('/employee/', employee);
    }
    
    // need code to pre-populate and submit when the the id is passed to 
    //the employee by id page
}