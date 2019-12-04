package org.zongf.base.utils.validator.anno.validator;

import org.zongf.base.utils.validator.anno.ListNotEmpty;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * @author zongf
 * @date 2019-12-04
 */
public class ListNotEmptyValidator implements ConstraintValidator<ListNotEmpty, List> {
    @Override
    public boolean isValid(List list, ConstraintValidatorContext constraintValidatorContext) {
        if(list != null && list.size() > 0 ) return true;
        return false;
    }
}
