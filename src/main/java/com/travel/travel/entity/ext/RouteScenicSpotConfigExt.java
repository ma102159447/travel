package com.travel.travel.entity.ext;

import com.travel.travel.entity.ScenicSpot;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RouteScenicSpotConfigExt extends ScenicSpot {
    private static final long serialVersionUID = 1L;

    private String id;

    private String routeId;

    private String scenicSpotId;

    private Integer order;
}
