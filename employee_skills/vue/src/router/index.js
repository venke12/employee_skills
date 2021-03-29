import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Display from '../views/Display.vue'
import DisplayById from '../views/DisplayById.vue'
import Add from '../views/Add.vue'




Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/home',
      name: 'home',
      component: Home
    },
    {
      path: '/display',
      name: 'display',
      component: Display
    },
    {
      path: '/display/:id',
      name: 'display-detail',
      component: DisplayById
    },
    {
      path: '/display/id',
      name: 'displayById',
      component: DisplayById
    },
    {
      path: '/add',
      name: 'add',
      component: Add
    }
   
  ]
});

export default router;
