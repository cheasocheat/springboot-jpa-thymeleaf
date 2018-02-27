package com.glf.test.glftest.util;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 09:46
 */
public enum RecordStatus {
    PUB("PUB", "Publish"),
    UNPUB("UNPUB", "Un Publish"),
    RECYC("RECYC", "Recycle");

    private String code;
    private String desc;

    RecordStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
