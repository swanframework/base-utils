package org.zongf.base.utils.validator.exception;

import org.zongf.base.utils.validator.model.IllegalConstraint;
import java.util.ArrayList;
import java.util.List;

/** 约束异常
 * @since 1.0
 * @author zongf
 * @created 2019-10-18
 */
public class ConstraintException extends RuntimeException {

    // 非法约束列表
    private List<IllegalConstraint> illegalConstraints;

    public ConstraintException() {
        super();
    }

    public ConstraintException(String message) {
        super(message);
    }

    public ConstraintException(String message, IllegalConstraint... illegalConstraintResult) {
        super(message);
        this.illegalConstraints = new ArrayList<>();
        this.illegalConstraints.forEach(illegalConstraints::add);
    }

    public ConstraintException(String message, List<IllegalConstraint> illegalConstraintResults) {
        super(message);
        this.illegalConstraints = illegalConstraintResults;
    }

    public List<IllegalConstraint> getIllegalConstraints() {
        return illegalConstraints;
    }

    public void setIllegalConstraints(List<IllegalConstraint> illegalConstraints) {
        this.illegalConstraints = illegalConstraints;
    }
}