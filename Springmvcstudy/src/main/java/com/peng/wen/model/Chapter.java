package com.peng.wen.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 课程章节
 */
@Setter
@Getter
public class Chapter {

    private Integer id;
    private Integer courseId;
    private Integer order;
    private String title;
    private String descr;
}
