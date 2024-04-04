import Vue from "vue";
import VueRouter from "vue-router";
var VueCookie = require('vue-cookie');
import HomeView from "../views/HomeView.vue";
import Login from "@/components/Login.vue";
import UserReg from "@/components/UserReg.vue"; 

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
  {
    path: "/login",
    name: "login",
    // 登录页面一
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/user/Login.vue"),
  },
  {
    // 注册页面一
    path: "/register",
    name: "register",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/user/Register.vue"),
  },
  {
    // 导航列表
    path: "/guideList",
    name: "guideList",
    component: () =>
      import(/* webpackChunkName: "about" */ "@/views/guide/GuideList.vue"),
  },
  {
    // 登录页面二
    path: "/LoginTwo",
    name: "LoginTwo",
    component: Login,
  },
  // 注册页面二
  {
    path: "/UserReg",
    name: "UserReg",
    component: UserReg,
  },
];



const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});


//路由前置守卫
router.beforeEach((to, from, next) => {
  const isLogin = VueCookie.get("token") ? true : false;
  if (to.path == "/login" || to.path == "/register") {
    next();
  } else {
    isLogin ? next() : next("/login");
  }
})

export default router;
