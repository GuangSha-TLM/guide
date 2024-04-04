<template>
  <div class="target">
    <el-row>

      <el-button @click="refresh" type="primary">页面刷新</el-button>


    </el-row>
 
    <el-input v-model="message" placeholder="请输入内容"></el-input>

    <el-table :data="tableData" border>
      <el-table-column prop="id" label="序号" width="180"> </el-table-column>
      <el-table-column prop="name" label="姓名" width="180"> </el-table-column>

      <el-table-column
        prop="toLink"
        @click="toPage(id)"
        label="链接"
        width="180"
      >
      </el-table-column>

      <el-table-column prop="updateTime" label="更新时间" width="180">
      </el-table-column>
      <el-table-column fixed="right" label="操作" width="150px">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small"
            >查看
          </el-button>
          <el-button type="text" size="small">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { guideList } from "@/api/guide";
export default {
  data() {
    return { 
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
      const listMessage = {
        start: 0,
        size: 5,
        guide: {},
      };
      const resp = guideList(listMessage).then(res => {
            if (res.data.code === '0x200') {
              this.$message({
                showClose: true,
                message: '查询成功!',
                type: 'success'
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

<style>
.target {
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}

.skip {
  background-color: blue;
  cursor: pointer;
}

.cell {
  text-align: center;
}
</style>
