package com.at.ct.web.bean;

import java.util.List;

public class Student {
    private String name;
    private List<Grade> grade; // 因为grade是个数组，所以要定义成List

    public class Grade {
        private String course;
        private String score;

        public String getCourse() {
            return course;
        }

        public void setCourse(String course) {
            this.course = course;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Grade> getGrade() {
        return grade;
    }

    public void setGrade(List<Grade> grade) {
        this.grade = grade;
    }
}
