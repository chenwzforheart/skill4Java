package com.cwzsmile.redis.validation;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created by csh9016 on 2019/3/4.
 */
@Getter
@Setter
public class AddAndUpdateIVO {
    @NotNull(groups = Add.class)

    private Long id;

    @NotNull
    private String name;
}
