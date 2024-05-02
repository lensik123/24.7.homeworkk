package org.example.classes;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

@Builder
public class Student {

  @SerializedName("Student Name")
  String fullName;

  @SerializedName("ID of University")
  String universityId;

  @SerializedName("Current course number")
  int currentCourseNumber;

  @SerializedName("Average exam score")
  float avgExamScore;

  public Student() {
  }

  public Student(String fullName, String universityId, int currentCourseNumber,
      float avgExamScore) {
    this.fullName = fullName;
    this.universityId = universityId;
    this.currentCourseNumber = currentCourseNumber;
    this.avgExamScore = avgExamScore;
  }

  public String getFullName() {
    return fullName;
  }

  public String getUniversityId() {
    return universityId;
  }

  public int getCurrentCourseNumber() {
    return currentCourseNumber;
  }

  public float getAvgExamScore() {
    return avgExamScore;
  }

  @Override
  public String toString() {
    return "Student: { Name: " + fullName +
        ", University id: " + universityId +
        ", Current course number: " + currentCourseNumber +
        ", Average exam score: " + avgExamScore + " }";
  }
}
