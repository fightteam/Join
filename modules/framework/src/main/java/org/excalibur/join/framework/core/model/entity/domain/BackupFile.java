package org.excalibur.join.framework.core.model.entity.domain;

import java.util.Date;

/**
 * author: excalibur
 * Date: 13-4-29
 * Time: 下午9:17
 * 数据备份对象
 */
public class BackupFile implements Comparable<BackupFile> {
    private String name;
    private Date createDate;
    private long size;
    private int kSize;

    public int getkSize() {
        return kSize;
    }

    public void setkSize(int kSize) {
        this.kSize = kSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public int compareTo(BackupFile o) {
        return this.createDate.compareTo(o.getCreateDate());
    }
}
