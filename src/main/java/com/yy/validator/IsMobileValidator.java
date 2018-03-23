package com.yy.validator;

import com.yy.util.ValidateUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by yy on 2018/3/21.
 */
public class IsMobileValidator implements ConstraintValidator<IsMobile,String> {

    boolean required;
    @Override
    public void initialize(IsMobile isMobile) {
        required=isMobile.required();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(required){
            return ValidateUtil.isMobile(s);
        }else{
            if(StringUtils.isEmpty(s)){
                return true;
            }else{
                return ValidateUtil.isMobile(s);
            }
        }
    }
}
