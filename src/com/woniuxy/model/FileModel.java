package com.woniuxy.model;

import java.io.Serializable;

/**
 * Description:
 *
 * @Author: Zh_o.
 * @Date: 2020/8/7 16:43
 */
public class FileModel implements Serializable {

    private static final long serialVersionUID = -2567011037214785978L;

    private int id;
    private String file;

    public FileModel() {
    }



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "FileModel{" +
                "id=" + id +
                ", file='" + file + '\'' +
                '}';
    }
}
