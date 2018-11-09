package com.smart.im.server.main.entity.reponse;

import com.smart.im.server.main.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author : lichen
 * @date : 2018/10/23 下午2:35
 * @email : 1960003945@qq.com
 * @descriotion :
 */
@Data
public class LoginResponse {

    @ApiModelProperty(notes = "登陆token")
    private String token;
    private User user;
}
