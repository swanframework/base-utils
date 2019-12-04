package org.zongf.base.utils.validator.anno;

import org.zongf.base.utils.validator.anno.validator.ListNotEmptyValidator;
import org.zongf.base.utils.validator.anno.validator.SetNotEmptyValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zongf
 * @date 2019-12-04
 */
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ListNotEmptyValidator.class, SetNotEmptyValidator.class})
public @interface ListNotEmpty {

    String message() default "不能为空";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
