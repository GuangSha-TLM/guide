<!--
 * @Author: tianleiyu 
 * @Date: 2024-04-04 16:04:06
 * @LastEditTime: 2024-04-06 11:50:13
 * @LastEditors: Oh...Yeah!!! 614988210@qq.com
 * @Description: 
 * @FilePath: /guide-vue/src/views/guide/GuideList.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
  <div class="receptacle">
    <div class="target">
      <el-row>
        <el-button @click="refresh" type="primary">页面刷新</el-button>
      </el-row>

      <el-table :data="tableData" border>
        <el-table-column prop="id" label="序号" width="180" align="center">
        </el-table-column>
        <el-table-column prop="name" label="姓名" width="180" align="center">
        </el-table-column>

        <el-table-column prop="toLink" @click="toPage(id)" label="链接" width="180" align="center">
        </el-table-column>

        <el-table-column prop="updateTime" label="更新时间" width="180" align="center">
        </el-table-column>
        <el-table-column label="操作" width="150px" align="center">
          <template slot-scope="scope">
            <el-button @click="handleGet(scope.$index, scope.row)" type="text" size="small">查看
            </el-button>
            <el-button @click="handleUpdate(scope.$index, scope.row)" type="text" size="small">编辑</el-button>
            <el-button @click="handleDelete(scope.$index, scope.row)" type="text" size="small">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import {
  guideList,
  guideDelete,
  guideUpdate,
  guideAdd,
  guideGet,
} from "@/api/guide";

export default {
  data() {
    return {
      target: {},
      listMessage: {
        start: 0,
        size: 10,
        guide: {},
      },
      message: "",
      tableData: [],
    };
  },
  //页面直接获取数据并刷新
  created() {
    const _this = this;
    const resp = guideList(this.listMessage).then((res) => {
      if (res.data.code === "0x200") {
        this.$message({
          showClose: true,
          message: "查询成功!",
          type: "success",
        });
      }
      _this.tableData = res.data.data.list;
      // console.log("???");
      // console.log(_this.tableData);
    });
  },
  methods: {
    //index:元素在数组中的索引
    //row:元素本身
    handleGet(index, row) {
      // console.log(index, row);
      // console.log(row.id);
      // console.log(row.name);
      guideGet(row.id).then((res) => {
        // console.log(res);
        // console.log(res.data.data);
        this.target = res.data.data;
        // console.log("aaa");
        // console.log(this.target);
        console.log("???");
        console.log(this.target.createTime);
        this.$alert(
        
          `<div><form>  <h5>网站信息</h5> 
                  <label>编号：</label>     <input value = ${this.target.id}         type="text" disabled="true" >   
            <br>   <label>名字：</label>     <input value = ${this.target.name}       type="text"  disabled="true" >
            <br>   <label>链接：</label>     <input value = ${this.target.toLink}     type="text"  disabled="true" >  
            <br>   <label>创建时间：</label> <input value = ${this.target.createTime}  type="date" disabled="true" > 
            <br>   <label>创建人：</label>   <input value = ${this.target.createBy}    type="text" disabled="true" >
            <br>   <label>修改时间：</label> <input value = ${this.target.updateTime}  type="date" disabled="true" >
            <br>   <label>修改人：</label>   <input value = ${this.target.updateBy}    type="text" disabled="true" >
            <br>   <label>状态：</label>     <input value = ${this.target.delFlag === 0 ? "未删除" : "已删除"}     type="text" disabled="true" >
            <br>   <label>逻辑删除：</label>  <input value = ${this.target.status === 0 ? "正常状态" : "特殊状态"}      type="text" disabled="true" >
            </form></div>`

          , row.name,

          {
            dangerouslyUseHTMLString: true
          }).then(() => {
 
          }).catch(() => { }) // 添加错误捕获
        


        // this.$alert(
        //   `
        //     id：${row.id}   
        //     name：${row.name}   
        //     toLink：${row.toLink}   
        //     createTime：${row.createTime}   
        //     createBy：${row.createBy}   
        //     updateBy：${row.updateBy}   
        //     updateTime：${row.updateTime}    
        //     delFlag：${row.delFlag}   
        //     status：${row.status}   
        //   `,
        //   row.name,
        //   {
        //     confirmButtonText: "确定",
        //     callback: (action) => {
        //       this.$message({
        //         type: "info",
        //         message: `action: ${action}`,
        //       });
        //     },
        //   }
        // );



      });
    },
    handleUpdate(index, row) {
      console.log(index, row);

      //直接跳转到编辑页面 
      // this.$router.push('/guideUpdate')

      //在页面跳转时传递参数
      // this.$router.push({
      //   name: 'guideUpdate',
      //   params: { id: row.id }
      // })

      //跳转并将参数存储到本地
      localStorage.setItem('updateGuide', row.id)
      this.$router.push('/guideUpdate')


    },
    handleDelete(index, row) {
      console.log(index, row);

      console.log(row.id);
      this.$confirm('此操作将永久删除该网页信息, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        console.log(row.id);
        console.log("???");
        const resp = guideDelete(row.id).then((res) => {
          if (res.data.code === "0x200") {
            this.$message({
              showClose: true,
              message: "删除成功!",
              type: "success",
            });
          }
        })

        location.reload()

      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });

    },
    refresh() {
      const resp = guideList(this.listMessage).then((res) => {
        if (res.data.code === "0x200") {
          this.$message({
            showClose: true,
            message: "查询成功!",
            type: "success",
          });
        }
        this.tableData = res.data.data.list;
        console.log(this.tableData);
      });
    },

  },
};
</script>

<style lang="scss">
.receptacle {
  width: 100%;
  display: flex;
  height: 100%;
  align-items: center;
  justify-content: center;
}
</style>
