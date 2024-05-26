package org.example.model;

import com.google.gson.annotations.SerializedName;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {

  @XmlElement(name = "universityProfile")
  @SerializedName("Main profile of university")
  private University.StudyProfile profileName;

  @XmlElement(name = "avgScore")
  @SerializedName("Average exam score")
  private double avgExamScore;

  @XmlTransient
  @SerializedName("Number of students")
  private int numberOfStudents;

  @XmlTransient
  @SerializedName("Number of universities")
  private int universityCount;

  @XmlTransient
  @SerializedName("University names")
  private String universityNames;

}
