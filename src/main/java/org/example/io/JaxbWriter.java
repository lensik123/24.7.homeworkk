package org.example.io;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.example.model.XmlAndJsonStructure;

public class JaxbWriter {

  public static void jaxbWrite(XmlAndJsonStructure xmlAndJsonStructure) throws JAXBException {
    File directory = new File("S:\\Java\\xmlReqs");
    if (!directory.exists()) {
      directory.mkdir();
    }
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd HH_mm_ss");
    xmlAndJsonStructure.setProcessedAt(formatter.format(now));

    String fileName = "req_" + formatter.format(now) + ".xml";
    File file = new File(directory, fileName);

    JAXBContext context = JAXBContext.newInstance(XmlAndJsonStructure.class);
    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    marshaller.marshal(xmlAndJsonStructure, file);
    marshaller.marshal(xmlAndJsonStructure, System.out);

  }
}
