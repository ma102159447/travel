package com.travel.travel.entity.ext;

import com.travel.travel.entity.Userinfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class WhiteListExt extends Userinfo {
    private String id;

    private String insertUserId;

    private String blacklistUserId;
}
