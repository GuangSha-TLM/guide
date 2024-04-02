<!--
 * @Author: tianleiyu
 * @Date: 2023-10-29 10:33:58
 * @LastEditTime: 2023-12-04 15:35:13
 * @LastEditors: tianleiyu
 * @Description:
 * @FilePath: /community-ui/src/components/fream/LoginTop.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
    <div class="top">
        <div class="modal fade" tabindex="-1" role="dialog" id="modal-cookies" data-backdrop="false"
            aria-labelledby="modal-cookies" aria-hidden="true">
            <div class="modal-dialog modal-dialog-aside left-4 right-4 bottom-4">
                <div class="modal-content bg-dark-dark">
                    <div class="modal-body">
                        <!-- Text -->
                        <p class="text-sm text-white mb-3">
                            We use cookies so that our themes work for you. By using our website, you agree to our use of
                            cookies.
                        </p>
                        <!-- Buttons -->
                        <a class="btn btn-sm btn-white" target="_blank">Learn more</a>
                        <button type="button" class="btn btn-sm btn-primary mr-2" data-dismiss="modal">OK</button>
                    </div>
                </div>
            </div>
        </div>
        <a class="btn btn-block btn-dark text-truncate rounded-0 py-2 d-none d-lg-block"
            style="z-index: 1000;color:aliceblue" target="_blank">
            哈尔滨广厦学院 <strong>社团管理系统 </strong> 测试版本 v0.1
        </a>

        <div>
            <nav class="navbar navbar-expand-lg navbar-light bg-white">
                <div class="container">
                    <!-- Brand -->
                    <a class="navbar-brand item" href="/h">
                        <img alt="Image placeholder" style="height:3.4rem" src="#" id="navbar-logo">
                    </a>
                    

                    <!-- Toggler -->
                    <button class="navbar-toggler item" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                        aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>


                    <!-- Collapse -->

                </div>
                <div class="collapse navbar-collapse" id="navbarCollapse">

                    <ul class="navbar-nav mt-4 mt-lg-0 ml-auto" >
                        <el-dropdown>
                            <router-link to="/UserCenter">
                                <li class="nav-item ">
                                    {{ username }}
                                </li>
                            </router-link>
                            <el-dropdown-menu slot="dropdown">
                                <router-link to="/MessageLists">
                                    <el-dropdown-item>
                                        <el-badge :value="count">
                                            消息
                                        </el-badge>
                                    </el-dropdown-item>
                                </router-link>
                                <div @click="loginOut()">
                                    <el-dropdown-item>退出登陆</el-dropdown-item>
                                </div>
                            </el-dropdown-menu>
                        </el-dropdown>
                    </ul>

                    <ul class="navbar-nav mt-4 mt-lg-0 ml-auto">
                        <li class="nav-item ">
                            <a class="nav-link" href="#">Help </a>
                        </li>
                        <li class="nav-item ">
                            <router-link class="nav-link" to="/Login">登入 </router-link>
                        </li>
                        <li class="nav-item ">
                            <router-link class="nav-link" to="/UserReg">注册 </router-link>
                        </li>
                    </ul>


                </div>
            </nav>

            <div class="result">
                <div class="result-item">
                    <div>{{ item.title }}</div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>



</script>

<style scoped>
.container {
    width: 100%;
    flex-wrap: nowrap;
}

.item {
    width: 33.333%;
}

/deep/ .el-input-group {
    width: 50%;
}

.ml-auto {
    margin-right: auto;
}
</style>
