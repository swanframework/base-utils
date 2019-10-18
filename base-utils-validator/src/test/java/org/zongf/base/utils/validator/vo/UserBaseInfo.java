package org.zongf.base.utils.validator.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserBaseInfo {

    @Max(value = 150, message = "最大年龄不能超过150")
    @Min(value = 18, message = "最小年龄不能低于10,{0}")
    private int age =8;

    @NotEmpty
    @Size(min = 3, max = 3)
    private String sex;

    public UserBaseInfo() {
    }

    public UserBaseInfo(@Max(value = 150, message = "最大年龄不能超过150") @Min(value = 18, message = "最小年龄不能低于10,{0}") int age, @NotEmpty @Size(min = 3, max = 3) String sex) {
        this.age = age;
        this.sex = sex;
    }
}