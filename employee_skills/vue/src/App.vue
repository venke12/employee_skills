<template>
  <div id="app">
    <div id="nav">
      <ul>
      <li><router-link v-bind:to="{ name: 'home' }">Home</router-link></li>
      <li><router-link v-bind:to="{ name: 'display' }">List All Employees</router-link></li>
      <li><router-link v-bind:to="{ name: 'displayById'}">Employee Detail By Id</router-link></li>
      <li><router-link v-bind:to="{ name: 'add' }">Add Employee</router-link></li>
      <li><router-link v-bind:to="{ name: 'delete' }">Delete Employee</router-link></li>
      </ul>
    </div>
    <router-view />
  </div>
</template>


<style scoped>
ul {
  align-items: flex-start;
  list-style-type: none;
  margin: 0px;
  padding: 25px;
  height: 20px;
  background-color: #94c0e4;
}

li {
  display: inline;
  color: #000;
  width: 180px;
  height: 30px;
  margin: 10px;
  padding: 20px;
  text-decoration: none;
  font-size: 16pt;
}

/* Change the link color on hover */
li :hover {
  background-color: rgb(123, 149, 182);
  color: white;
  font-weight: bold;

}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  text-align: left;
  color: #2c3e50;
}
#nav {
  margin-left:10px;
  padding: 5px 0px 0px 0px;
}
</style>
