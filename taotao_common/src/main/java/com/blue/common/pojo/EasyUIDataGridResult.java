package com.blue.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author gzk
 * @version 1.0
 * @description com.blue.common.pojo
 * @date 2018/1/26
 */
//不同系统之间传输对象,必须序列化(通过流,序列化成0 1 码才可)(如果有泛型也需要序列化)
public class EasyUIDataGridResult implements Serializable{
    private long total;//总记录数
    private List rows;//对象的列表  可以是商品列表或者其他

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
