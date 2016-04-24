package com.zane.test.webapp.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author: luojinping
 * Date: 15/2/28
 * Time: 下午2:55
 */
@Controller
@RequestMapping("/")
public class ZaneTestController {

    private static final Logger LOG = LoggerFactory.getLogger(ZaneTestController.class);

    private static final String ID_PARAM = "id";

    private static final String URL_PARAM = "url";

    private static final String PACKAGE_NAME_PARAM = "packageName";

    @RequestMapping(value = "/test", produces = "application/json; charset=utf-8", method =
            RequestMethod.GET)
    public ResponseEntity<String> testAction(
            @RequestParam(value = URL_PARAM, required = false, defaultValue = StringUtils.EMPTY) String url,
            @RequestParam(value = PACKAGE_NAME_PARAM, required = true) String packageName,
            @RequestParam(value = ID_PARAM, required = false, defaultValue = StringUtils.EMPTY) Integer id,
            HttpServletResponse resp) {
        if (StringUtils.isEmpty(packageName)) {
            LOG.error("packageName is null");
            return new ResponseEntity<String>("ERROR", HttpStatus.OK);
        }

        int testId = 0;
        if (id != null) {
            try {
                LOG.info("id:{}", id);
            } catch (Exception e) {
                LOG.error("weight is not a integer type, testId:{}", testId);
                return new ResponseEntity<String>("ERROR", HttpStatus.OK);
            }
        }

        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }
}
