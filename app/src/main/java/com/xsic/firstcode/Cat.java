package com.xsic.firstcode;

/**
 * ListView数据实体
 */
public class Cat {
    private String name;
    private int imageId;

    public Cat(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName(){
        return this.name;
    }

    public int getImageId(){
        return this.imageId;
    }
}
