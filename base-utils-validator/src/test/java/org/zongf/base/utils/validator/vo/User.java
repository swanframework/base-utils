package org.zongf.base.utils.validator.vo;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class User {

    @NotNull(message = "用户id不能为空")
    private Integer id;

    @NotEmpty
    @NotBlank
    @NotNull
    private String username;

    @Valid
    @NotNull
    private UserBaseInfo baseInfo = new UserBaseInfo();

    public User() {
    }

    public User( Integer id, String username, UserBaseInfo userBaseInfo) {
        this.id = id;
        this.username = username;
        this.baseInfo = userBaseInfo;
    }
}
