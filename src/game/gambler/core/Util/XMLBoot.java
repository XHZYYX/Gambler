package game.gambler.core.Util;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XMLBoot {

    public static Document getXMLWritableDocument(String xmlpath){
        if(xmlpath==null){
            Document doc= DocumentHelper.createDocument();
            doc.addElement("root");
            return doc;
        }

        File file = new File(xmlpath);
        if(!file.exists()){
            Document doc=DocumentHelper.createDocument();
            doc.addElement("root");
            return doc;
        }
        SAXReader reader =new SAXReader();
        Document doc;
        try{
            doc = reader.read(file);
            System.out.println("root : "+doc.getRootElement().getName());
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return doc;
    }
    public static Document readXMLFileDocument(String xmlpath){
        if(xmlpath==null){
            Debug.log("read xml can not null!");
            return null;
        }

        File file = new File(xmlpath);
        if(!file.exists()){
            Debug.log("the xml file - "+xmlpath+" is not exist.");
            return null;
        }
        SAXReader reader =new SAXReader();
        Document doc;
        try{
            doc = reader.read(file);
            System.out.println("root : "+doc.getRootElement().getName());
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return doc;
    }
    public static void writeXMLFile(String xmlpath,Document doc){
        FileOutputStream out =null;
        try {
            out = new FileOutputStream(xmlpath);
            OutputFormat format=OutputFormat.createPrettyPrint();   //漂亮格式：有空格换行
            format.setEncoding("UTF-8");
            XMLWriter writer=new XMLWriter(out,format);
            //2.写出Document对象
            writer.write(doc);
            //3.关闭流
            writer.close();
        } catch (Exception ex) {
            Logger.getLogger(XMLBoot.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(XMLBoot.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static Object instanceObj(String classpath){
        try{
            Class<?> cls = Class.forName(classpath);
            Object obj=cls.newInstance();
            return obj;
        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException e){
            Debug.log("Class Not Found : "+classpath);
            return null;
        }
    }
}
