package com.itimoshin.spring_cloud_mastering.common;

public enum ExamType {
    MATH("math-service"), THEOLOGY("theology-service");
    public final String serviceName;

    ExamType(String serviceName) {
        this.serviceName = serviceName;
    }
}
