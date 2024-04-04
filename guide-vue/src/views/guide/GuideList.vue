<!--
 * @Author: tianleiyu 
 * @Date: 2024-04-04 16:04:06
 * @LastEditTime: 2024-04-04 16:55:34
 * @LastEditors: tianleiyu
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

        <el-table-column
          prop="toLink"
          @click="toPage(id)"
          label="链接"
          width="180"
          align="center"
        >
        </el-table-column>

        <el-table-column
          prop="updateTime"
          label="更新时间"
          width="180"
          align="center"
        >
        </el-table-column>
        <el-table-column label="操作" width="150px" align="center">
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)" type="text" size="small"
              >查看
            </el-button>
            <el-button type="text" size="small">编辑</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>

<script>
import { guideList } from "@/api/guide";
export default {
  data() {
    return {
      listMessage: {
        start: 0,
        size: 5,
        guide: {},
      },
      message: "",
      tableData: [
        {
          id: "1",
          name: "力扣",
          toLink: "https://leetcode.cn/",
          updateTime: "2016-05-02",
        },
      ],
    };
  },
  created() {},
  methods: {
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
    formatter(row, column) {
      return row.address;
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
