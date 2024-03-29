package com.gsxy.guide.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.guide.domain.Guide;
import com.gsxy.guide.domain.bo.GuidePagingToGetDataBo;
import com.gsxy.guide.domain.vo.ResponseVo;
import com.gsxy.guide.service.GuideService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 向导
 *
 * @author Oh...Yeah!!!
 * @since 2024-03-13 17:35:24
 */
@RestController
@RequestMapping("guide")
public class GuideController {
    /**
     * 服务对象
     */
    @Resource
    private GuideService guideService;

    /**
     * 分页查询
     *
     * @param guide 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @PostMapping("/queryByPage")
    public String queryByPage(@RequestBody GuidePagingToGetDataBo guidePagingToGetDataBo) {

        return JSONArray.toJSONString(guideService.queryByPage(guidePagingToGetDataBo));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseVo queryById(@PathVariable("id") Long id) {
        return guideService.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param guide 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseVo add(@RequestBody Guide guide) {
        return guideService.insert(guide);
    }

    /**
     * 编辑数据
     *
     * @param guide 实体
     * @return 编辑结果
     */
    @PutMapping("/edit")
    public ResponseVo edit(@RequestBody Guide guide) {
        return guideService.update(guide);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/deleteById")
    public ResponseVo deleteById(@RequestParam("id")  Long id) {
        return guideService.deleteById(id);
    }

}

