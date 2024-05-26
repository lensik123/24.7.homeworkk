package org.example.io;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.example.model.XmlStructure;

public class JaxbWriter {

  public static void jaxbWrite(XmlStructure xmlStructure) throws JAXBException {
    File directory = new File("S:\\Java\\xmlReqs");
    if (!directory.exists()) {
      directory.mkdir();
    }
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd HH_mm_ss");
    xmlStructure.setProcessedAt(formatter.format(now));

    String fileName = "req_" + formatter.format(now) + ".xml";
    File file = new File(directory, fileName);

    JAXBContext context = JAXBContext.newInstance(XmlStructure.class);
    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    marshaller.marshal(xmlStructure, file);
    marshaller.marshal(xmlStructure, System.out);

  }
}
