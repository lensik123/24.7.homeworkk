package org.example.model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter

@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlAndJsonStructure {

  @XmlElementWrapper(name = "studentsInfo")
  @XmlElement(name = "studentsEntry")
  List<Student> studentList;

  @XmlElementWrapper(name = "universityInfo")
  @XmlElement(name = "universityEntry")
  List<University> universityList;

  @XmlElementWrapper(name = "statisticsInfo")
  @XmlElement(name = "statisticEntry")
  List<Statistics> statisticsList;

  @XmlElement(name = "processedAt")
  String processedAt;
}
