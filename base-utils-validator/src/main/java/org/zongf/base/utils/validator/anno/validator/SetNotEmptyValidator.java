package org.zongf.base.utils.validator.anno.validator;

import org.zongf.base.utils.validator.anno.ListNotEmpty;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Set;

/**
 * @author zongf
 * @date 2019-12-04
 */
public class SetNotEmptyValidator implements ConstraintValidator<ListNotEmpty, Set> {
    @Override
    public boolean isValid(Set list, ConstraintValidatorContext constraintValidatorContext) {
        if(list != null && list.size() > 0 ) return true;
        return false;
    }
}
