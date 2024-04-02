<!--
 * @Author: tianleiyu 
 * @Date: 2024-04-01 16:11:21
 * @LastEditTime: 2024-04-01 17:09:07
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /guide-vue/src/views/user/Login.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->

<template>
    <div class="container">
        <div class="login-wrapper">
            <el-form :model="user" :rules="rules" ref="user" class="demo-ruleForm">
                <div class="form-wrapper">
                    <div class="header">Login</div>
                    <el-form-item prop="username">
                        <el-input v-model="user.username" placeholder="username" class="input-item"></el-input>
                    </el-form-item>
                    <el-form-item prop="password">
                        <el-input v-model="user.password" placeholder="password" class="input-item"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button class="btn" type="primary" @click="submitForm('user')">登陆</el-button>
                    </el-form-item>
                </div>
            </el-form>
            <div class="msg">
                <router-link to="/register">去注册--></router-link>
            </div>
        </div>
    </div>

</template>

<script>
import { userLogin } from '@/api/user';
export default {
    name: 'HomeView',
    data() {
        return {
            user: {
                username: '',
                password: ''
            },
            rules: {
                username: [
                    { required: true, message: '请输入用户名', trigger: 'blur' },
                    // { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                ],
                password: [
                    { required: true, message: '请输入密码', trigger: 'blur' },
                    // { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                ],
            }
        }
    },
    methods: {  
        submitForm(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    userLogin(this.user).then(res => {
                        if (res.data.code === '0x200') {
                            this.$message({
                                showClose: true,
                                message: '登陆成功!',
                                type: 'success'
                            });
                            this.$cookie.set('token', res.data.token);
                            // this.$router.push('/aisle')
                        } else {
                            this.$message({
                                showClose: true,
                                message: res.data.message,
                                type: 'error'
                            });
                            this.user.username = ''
                            this.user.password = ''
                        }
                    })
                } else {
                    return false;
                }
            });
        },
    }
}
</script>

<style lang="scss" scoped>
/*
      这里写PC端的样式
    */
.container {
    height: 100%;
    background-color: #f7f7f7;
    // background-image: linear-gradient(to right, #fbc2eb, #a6c1ee);
}

.login-wrapper {
    background-color: #fff;
    width: 358Px;
    height: 588Px;
    border-radius: 15Px;
    padding: 0 50Px;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
}

.header {
    font-size: 38Px;
    font-weight: bold;
    text-align: center;
    line-height: 200Px;
}

.input-item {
    display: block;
    width: 100%;
    margin-bottom: 20Px;
    border: 0;
    padding: 10Px;
    border-bottom: 1Px solid rgb(128, 125, 125);
    font-size: 15Px;
    outline: none;
}

.input-item:placeholder {
    text-transform: uppercase;
}

.btn {
    text-align: center;
    padding: 15Px;
    width: 100%;
    margin-top: 25Px;
    background-color: #abc1ee;
    // background-image: linear-gradient(to right, #a6c1ee, #fbc2eb);
    color: #fff;
}

.msg {
    text-align: center;
    line-height: 88Px;
}

a {
    text-decoration-line: none;
    color: #abc1ee;
}

::v-deep .el-input__inner {
    border: 0;
    padding: 0;
}


::v-deep .el-button--primary {
    border: 0;
}
</style>./login.vue