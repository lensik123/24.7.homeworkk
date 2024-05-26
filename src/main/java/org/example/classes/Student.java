package org.example.classes;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

  @SerializedName("Student Name")
  String fullName;

  @SerializedName("ID of University")
  String universityId;

  @SerializedName("Current course number")
  int currentCourseNumber;

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
