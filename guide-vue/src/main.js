import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
var VueCookie = require('vue-cookie');
Vue.config.productionTip = false

new Vue({
  router,
  store,
  ElementUI,
  VueCookie,
  render: h => h(App)
}).$mount('#app')
