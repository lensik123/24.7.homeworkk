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


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@XmlRootElement(name = "studentEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

  @XmlElement(name = "studentName")
  @SerializedName("Student Name")
  String fullName;

  @XmlElement(name = "universityId")
  @SerializedName("ID of University")
  String universityId;

  @XmlTransient
  @SerializedName("Current course number")
  int currentCourseNumber;

  @XmlElement(name = "avgScore")
  @SerializedName("Average exam score")
  float avgExamScore;

  @Override
  public String toString() {
    return "Student: { Name: " + fullName +
        ", University id: " + universityId +
        ", Current course number: " + currentCourseNumber +
        ", Average exam score: " + avgExamScore + " }";
  }
}
