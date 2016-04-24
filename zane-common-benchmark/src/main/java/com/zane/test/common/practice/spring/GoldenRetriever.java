package com.zane.test.common.practice.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Author: luojinping
 * Date: 15/3/4
 * Time: 下午1:14
 */
@Component
@Qualifier("goldenRetriever")
public class GoldenRetriever {
    private static final Logger LOG = LoggerFactory.getLogger(GoldenRetriever.class);

    public String bark(){
        return "goldenRetriever barking";
    }
}
