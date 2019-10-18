package org.zongf.base.utils.validator;

import org.junit.Test;
import org.zongf.base.utils.validator.exception.ConstraintException;
import org.zongf.base.utils.validator.model.IllegalConstraint;
import org.zongf.base.utils.validator.util.ConstraintValidateUtil;
import org.zongf.base.utils.validator.vo.User;
import org.zongf.base.utils.validator.vo.UserBaseInfo;

import java.util.List;

public class ConstraintValidateUtilTest {

    // 检查字段约束，返回违背约束字段信息
    @Test
    public void check(){
        User user = new User();
        List<IllegalConstraint> illegals = ConstraintValidateUtil.check(user);
        illegals.forEach(System.out::println);
    }

    // 短路检查字段约束信息，第一个不匹配候终止
    @Test
    public void fastCheck(){
        User user = new User();
        List<IllegalConstraint> illegals = ConstraintValidateUtil.fastCheck(user);
        illegals.forEach(System.out::println);
    }

    // 短路校验字段约束信息, 第一个违背后，即终止。异常中只包含第一个字段的违背信息
    @Test(expected = ConstraintException.class)
    public void fastValidate(){
        User user = new User();
        ConstraintValidateUtil.fastValidate(user);
    }

    // 校验字段约束信息, 有违背后抛出异常。异常中包含全部违背字段的信息
    @Test
    public void validate(){
        User user = new User();
        try {
            ConstraintValidateUtil.validate(user);
        } catch (ConstraintException ex) {
            ex.getIllegalConstraints().forEach(System.out::println);
        }
    }

    // 校验正常逻辑
    @Test
    public void validate_ok(){
        UserBaseInfo userBaseInfo = new UserBaseInfo(30, "Man");
        User user = new User(1001, "zhangsan", userBaseInfo);
        ConstraintValidateUtil.validate(user);
    }

}