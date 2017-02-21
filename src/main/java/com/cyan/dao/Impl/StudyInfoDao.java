package com.cyan.dao.Impl;

import com.cyan.dao.IStudyInfoDao;
import com.cyan.entity.StudyInfo;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能描述:
 *
 * @Author cyan
 * @Date 16/7/7.
 */

@Repository
public class StudyInfoDao extends SqlSessionDaoSupport implements IStudyInfoDao {

    private static final String SQL_NAMESPACE = "StudyInfo";

    @Override
    public List<StudyInfo> selectByClzId(Integer clzId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("clzId", clzId);
        return this.getSqlSession().selectList(SQL_NAMESPACE + ".selectByClzId", map);
    }

    @Override
    public List<StudyInfo> selectByStuId(String stuId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("stuId", stuId);
        return this.getSqlSession().selectList(SQL_NAMESPACE + ".selectByStuId", map);
    }

    @Override
    public StudyInfo check(String stuId, Integer clzId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("stuId", stuId);
        map.put("clzId", clzId);

        return this.getSqlSession().selectOne(SQL_NAMESPACE + ".selectByStuIdAndClzId", map);
    }

    @Override
    public void insert(StudyInfo studyInfo) {
        this.getSqlSession().insert(SQL_NAMESPACE + ".insert", studyInfo);
    }

    @Override
    public void delete(String stuId, Integer clzId) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("stuId", stuId);
        map.put("clzId", clzId);

        this.getSqlSession().delete(SQL_NAMESPACE + ".delete", map);
    }

}
