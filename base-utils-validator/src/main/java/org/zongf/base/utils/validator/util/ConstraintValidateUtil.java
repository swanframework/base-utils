package org.zongf.base.utils.validator.util;

import org.hibernate.validator.HibernateValidator;
import org.zongf.base.utils.validator.model.IllegalConstraint;
import org.zongf.base.utils.validator.exception.ConstraintException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/** 字段约束校验
 * @author zongf
 * @date 2019-10-18
 */
public class ConstraintValidateUtil {

    // 标准校验器
    private static final Validator VALIDATOR;

    // 短路校验器
    private static final Validator FAST_VALIDATOR;

    static {
        VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();
        FAST_VALIDATOR = Validation.byProvider(HibernateValidator.class).configure()
                .failFast(true).buildValidatorFactory().getValidator();
    }

    /** 校验字段约束，会校验所有字段的约束行为.
     * @param object 使用javax.validation.constraints.*注解修饰的java 对象
     * @throws ValidationException 有字段违背约束时, 抛出异常
     * @since 1.0
     * @author zongf
     * @created 2019-10-18
     */
    public static void validate(Object object) throws ValidationException{
        validate(object, VALIDATOR);
    }

    /** 短路校验字段约束，遇到第一个违约字段便终止其它字段的校验
     * @param object 使用javax.validation.constraints.*注解修饰的java 对象
     * @throws ValidationException 有字段违背约束时, 抛出异常
     * @since 1.0
     * @author zongf
     * @created 2019-10-18
     */
    public static void fastValidate(Object object) throws ValidationException{
        validate(object, FAST_VALIDATOR);
    }

    /** 检查对象字段约束, 返回所有违约字段的违背详情 <br/>
     *  如果没有字段违约, 则返回null
     * @param object 使用javax.validation.constraints.*注解修饰的java 对象
     * @return List<IllegalConstraint> 违约字段信息
     * @since 1.0
     * @author zongf
     * @created 2019-10-18
     */
    public static List<IllegalConstraint> check(Object object){
        return check(object, VALIDATOR);
    }

    /** 短路检查对象字段约束, 返回第一个违背字段的违背信息。<br/>
     *  如果没有字段违约, 则返回null
     * @param object 使用javax.validation.constraints.*注解修饰的java 对象
     * @return List<IllegalConstraint> 违约字段信息
     * @since 1.0
     * @author zongf
     * @created 2019-10-18
     */
    public static List<IllegalConstraint> fastCheck(Object object){
        return check(object, FAST_VALIDATOR);
    }

    /** 校验对象的字段约束, 存在违背约束时, 抛出异常
     * @param object 使用javax.validation.constraints.*注解修饰的java 对象
     * @param validator 约束校验器
     * @since 1.0
     * @author zongf
     * @created 2019-10-18
     */
    private static void validate(Object object, Validator validator) throws ValidationException{
        List<IllegalConstraint> list = check(object, validator);
        if (list != null) {
            throw new ConstraintException("字段约束校验异常!", list);
        }
    }

    /** 检查对象字段约束, 返回字段违约信息
     * @param object 使用javax.validation.constraints.*注解修饰的java 对象
     * @param validator 约束校验器
     * @return List<IllegalConstraint> 违背约束的字段信息
     * @since 1.0
     * @author zongf
     * @created 2019-10-18
     */
    private static List<IllegalConstraint> check(Object object, Validator validator){

        // 校验字段
        Set<ConstraintViolation<Object>> validateResults = validator.validate(object);

        if (validateResults != null) {
            List<IllegalConstraint> list = new ArrayList<>();
            for (ConstraintViolation<Object> validateResult : validateResults) {
                list.add(new IllegalConstraint(validateResult));
            }

            // 按字段名进行排序
            Collections.sort(list);
            return list;
        }
        return null;
    }
}