package org.zongf.base.utils.validator.model;

import javax.validation.ConstraintViolation;

/** 非法约束
 * @since 1.0
 * @author zongf
 * @created 2019-10-18
 */
public class IllegalConstraint implements Comparable<IllegalConstraint>{

    // 非法约束属性名
    private String propertyName;

    // 非法约束描述信息
    private String message;

    public IllegalConstraint() {
    }

    public IllegalConstraint(ConstraintViolation constraintViolation) {
        this.propertyName = constraintViolation.getPropertyPath().toString();
        this.message =  constraintViolation.getMessage();
    }

    public IllegalConstraint(String propertyName, String message) {
        this.propertyName = propertyName;
        this.message = message;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int compareTo(IllegalConstraint constraint) {
        return this.propertyName.compareTo(constraint.message);
    }

    @Override
    public String toString() {
        return "IllegalConstraint{" +
                "propertyName='" + propertyName + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}