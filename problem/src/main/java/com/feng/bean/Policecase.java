package com.feng.bean;

import javax.xml.bind.annotation.*;

/**
 * @author
 * @time 2022/11/15 15:29
 * @Description- xml的内部数据属性对象
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"msgId","createTime"})
public class Policecase {

    private String msgId;

    private String createTime;

    @XmlElement(name = "MsgId")
    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    @XmlElement(name = "CreateTime")
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
