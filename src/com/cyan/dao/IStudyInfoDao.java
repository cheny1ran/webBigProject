package com.cyan.dao;

import com.cyan.entity.StudyInfo;

import java.util.List;

/**
 * 功能描述:
 *
 * @Author cyan
 * @Date 16/7/7.
 */
public interface IStudyInfoDao {

    public List<StudyInfo> selectByClzName(String clzName);

    public List<StudyInfo> selectByClzId(String clzId);

    public List<StudyInfo> selectByStuId(String stuId);

    public List<StudyInfo> selectByClbName(String clbName);

    public StudyInfo check(String stuId,Integer clzId);

    public void insert(StudyInfo studyInfo);

}
