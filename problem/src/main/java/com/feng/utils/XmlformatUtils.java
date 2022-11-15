package com.feng.utils;

import com.feng.bean.Hiatmq;
import com.feng.bean.Policecase;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author
 * @time 2022/11/15 15:36
 * @Description- bean转xml工具类
 */
public class XmlformatUtils {

    public static final String UTF8 = "UTF-8";

    public static String objectToXmlByJaxb(Object obj,boolean output) throws Exception{
        return objectToXmlByJaxb(obj,UTF8,output,true,"","");
    }

    private static String objectToXmlByJaxb(Object obj, String encoding, boolean output, boolean fragment, String nameSpace, String schema) throws Exception {

        StringWriter sw = new StringWriter();
        JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_ENCODING,encoding);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,output);
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT,fragment);
        if (!"".equals(nameSpace)){
            marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION,nameSpace);
        }
        if (!"".equals(schema)){
            marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,schema);
        }
        marshaller.marshal(obj,sw);

        return sw.toString();
    }

    public static void main(String[] args) throws Exception {
        Hiatmq hiatmq = new Hiatmq();
        Policecase policecase = new Policecase();
        policecase.setMsgId(UUID.randomUUID().toString());
        policecase.setCreateTime(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date()));
        hiatmq.setPolicecase(policecase);
        String s = objectToXmlByJaxb(hiatmq, true);
        System.out.println(s);
    }
}
