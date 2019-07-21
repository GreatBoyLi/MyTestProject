package com.peng.wen.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 课程对象Model
 * @author liwpb
 */
@Getter
@Setter
public class Course {

    /**
     * 课程ID
     */
    private Integer courseId;

    /**
     * 课程名称
     */
    private String title;

    /**
     * 图片路径
     */
    private String impPath;

    /**
     * 学习人数
     */
    private Integer learningNum;

    /**
     * 课程时长
     */
    Long duration;

    /**
     * 课程难度
     */
    private Integer level;

    /**
     * 课程难度描述
     */
    private String levelDesc;

    /**
     * 课程介绍
     */
    private String descr;

    /**
     * 课程题纲
     */
    private List<Chapter> chapterList;
}
