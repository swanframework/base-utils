package org.zongf.base.utils.validator;

import javax.validation.ConstraintViolation;

public class IllegalConstraint implements Comparable<IllegalConstraint>{

    private String propertyName;

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