<!--
 * @Author: Oh...Yeah!!! 614988210@qq.com
 * @Date: 2024-04-05 21:01:38
 * @LastEditors: Oh...Yeah!!! 614988210@qq.com
 * @LastEditTime: 2024-04-06 00:26:11
 * @FilePath: \guide-vue\src\views\guide\Update.vue
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
<template>
    <div class="box">
        <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="本信息id">
                <el-input :value="form.id" disabled="flag"></el-input>
            </el-form-item>
            <el-form-item label="网站名称">
                <el-input v-model="form.name"></el-input>
            </el-form-item>
            <el-form-item label="网站链接">
                <el-input v-model="form.toLink"></el-input>
            </el-form-item>
            <el-form-item label="创建人id">
                <el-input v-model="form.createBy" disabled="flag"></el-input>
            </el-form-item>
            <el-form-item label="创建时间">
                <el-col :span="11">
                    <el-date-picker type="date" placeholder="选择日期" v-model="form.createTime"
                        style="width: 100%"></el-date-picker>
                </el-col>
                <el-col class="line" :span="2">-</el-col>
                <el-col :span="11">
                    <el-time-picker placeholder="选择时间" v-model="form.createTime" style="width: 100%"></el-time-picker>
                </el-col>
            </el-form-item>
            <el-form-item label="修改时间">
                <el-col :span="11">
                    <el-date-picker type="date" placeholder="选择日期" v-model="form.updateTime"
                        style="width: 100%"></el-date-picker>
                </el-col>
                <el-col class="line" :span="2">-</el-col>
                <el-col :span="11">
                    <el-time-picker placeholder="选择时间" v-model="form.updateTime" style="width: 100%"></el-time-picker>
                </el-col>
            </el-form-item>
            <el-form-item label="修改人id">
                <el-input v-model="form.updateBy"></el-input>
            </el-form-item>
            <el-form-item label="信息状态">
                <el-select v-model="form.status" placeholder="请选择该信息的状态情况">
                    <el-option label="正常状态" value="0"></el-option>
                    <el-option label="特殊状态" value="1"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="逻辑删除">
                <el-select v-model="form.delFlag"  placeholder="请选择删除情况">
                    <el-option label="未删除" value="0"></el-option>
                    <el-option label="已删除" value="1"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit">立即修改</el-button>
                <el-button>取消</el-button>
            </el-form-item>
        </el-form>

    </div>
</template>

<script>
import {
    guideGet,
    guideUpdate
} from "@/api/guide";

export default {
    data() {
        return {
            flag: false,
            statusValue: "",
            delFlagValue: "",
            form: {
                id: "",
                name: "",
                toLink: "",
                createBy: "",
                createTime: "",
                updateBy: "",
                updateTime: "",
                delFlag: "",
                status: "",
            },
        };
    },
    created() {
        //从跳转的链接中获取传入的参数
        // this.form.id = this.$route.params.id;
        // console.log(this.form.id);
 
        //从本地存储中获取
        this.form.id = localStorage.getItem("updateGuide");

        const _this = this;
            guideGet(this.form.id).then((res) => {
                // console.log("???");
                // console.log(res);
                _this.form.name = res.data.data.name;
                _this.form.toLink = res.data.data.toLink;
                _this.form.createBy = res.data.data.createBy; 
                _this.form.createTime = res.data.data.createTime;
                _this.form.updateBy = res.data.data.updateBy;
                _this.form.updateTime = res.data.data.updateTime;
                _this.form.delFlag = res.data.data.delFlag; 
                _this.form.status = res.data.data.status;
        })

        _this.flag = true;
    },
    mounted() { },

    methods: {
        onSubmit() {
            console.log("submit!");
            guideUpdate(this.form).then((res) => {
                if (res.data.code === '0x200') {
                    this.$message({
                        showClose: true,
                        message: '修改成功!',
                        type: 'success'
                    });
                } else {
                    this.$message({
                        showClose: true,
                        message: res.data.message,
                        type: 'error'
                    }); 
                }

                location.reload()
            })
        },
    }
};
</script>

<style lang="scss" scoped>
.box {
    width: 100%;
    margin-top: 5%;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    align-content: center;

}
</style>