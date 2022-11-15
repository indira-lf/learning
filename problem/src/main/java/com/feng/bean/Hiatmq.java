package com.feng.bean;

import javax.xml.bind.annotation.*;

/**
 * @author
 * @time 2022/11/15 15:27
 * @Description- xml头信息配置
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "MainBody")
@XmlType(propOrder = {"policecase"})
public class Hiatmq {

    private String id = "POLICECASE";

    private String version = "1.6";

    private Policecase policecase;

    @XmlAttribute(name = "Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlAttribute(name = "Version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @XmlElement(name = "Policecase")
    public Policecase getPolicecase() {
        return policecase;
    }

    public void setPolicecase(Policecase policecase) {
        this.policecase = policecase;
    }

    @Override
    public String toString() {
        return "Hiatmq{" +
                "id='" + id + '\'' +
                ", version='" + version + '\'' +
                ", policecase=" + policecase +
                '}';
    }
}
