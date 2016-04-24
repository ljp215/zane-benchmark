package com.zane.test.common.practice.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: luojinping
 * Date: 15/3/4
 * Time: 下午1:23
 */
public class DogStrategy {
    private static final Logger LOG = LoggerFactory.getLogger(DogStrategy.class);

    private GoldenRetriever goldenRetriever;

    public GoldenRetriever getGoldenRetriever() {
        return goldenRetriever;
    }

    public void setGoldenRetriever(GoldenRetriever goldenRetriever) {
        this.goldenRetriever = goldenRetriever;
    }

    public void goldenRetrieverBark() {
        LOG.info("bark: {}", goldenRetriever.bark());
    }
}
