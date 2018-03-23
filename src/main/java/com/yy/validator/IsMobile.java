package com.yy.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by yy on 2018/3/21.
 */

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {IsMobileValidator.class}
)//添加校验器
public @interface IsMobile {

    boolean required() default true;//自增

    String message() default "手机号码格式错误";//出错提示信息

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
