package org.zongf.base.utils.validator.vo;

import org.zongf.base.utils.validator.anno.ListNotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ListNotEmpty
    private Set<String> bookList = new HashSet<>();

    public User() {
    }

    public User( Integer id, String username, UserBaseInfo userBaseInfo) {
        this.id = id;
        this.username = username;
        this.baseInfo = userBaseInfo;
    }
}
