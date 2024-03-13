package com.gsxy.guide.dao;

import com.gsxy.guide.entity.Guide;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 向导访问层
 *
 * @author Oh...Yeah!!!
 * @since 2024-03-13 17:35:24
 */
public interface GuideDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Guide queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param guide 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Guide> queryAllByLimit(Guide guide, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param guide 查询条件
     * @return 总行数
     */
    long count(Guide guide);

    /**
     * 新增数据
     *
     * @param guide 实例对象
     * @return 影响行数
     */
    int insert(Guide guide);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Guide> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Guide> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Guide> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Guide> entities);

    /**
     * 修改数据
     *
     * @param guide 实例对象
     * @return 影响行数
     */
    int update(Guide guide);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

