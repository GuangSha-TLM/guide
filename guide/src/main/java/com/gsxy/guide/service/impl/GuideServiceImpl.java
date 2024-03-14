package com.gsxy.guide.service.impl;

import com.gsxy.guide.entity.Guide;
import com.gsxy.guide.mapper.GuideMapper;
import com.gsxy.guide.service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

/**
 * 向导实现类
 *
 * @author Oh...Yeah!!!
 * @since 2024-03-13 17:35:43
 */
@Service("guideService")
public class GuideServiceImpl implements GuideService {
    @Autowired
    private GuideMapper guideMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Guide queryById(Long id) {
        return this.guideMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param guide 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Guide> queryByPage(Guide guide, PageRequest pageRequest) {
        long total = this.guideMapper.count(guide);
        return new PageImpl<>(this.guideMapper.queryAllByLimit(guide, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param guide 实例对象
     * @return 实例对象
     */
    @Override
    public Guide insert(Guide guide) {
        this.guideMapper.insert(guide);
        return guide;
    }

    /**
     * 修改数据
     *
     * @param guide 实例对象
     * @return 实例对象
     */
    @Override
    public Guide update(Guide guide) {
        this.guideMapper.update(guide);
        return this.queryById(guide.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.guideMapper.deleteById(id) > 0;
    }
}
