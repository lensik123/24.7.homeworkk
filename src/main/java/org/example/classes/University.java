package org.example.classes;

//lombok библиотека, использовал готовый билдер из этой библиотеки.

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

@Builder
public class University {

  @SerializedName("ID")
  String id;

  @SerializedName("Name of University")
  String fullName;

  @SerializedName("Shortname")
  String shortName;

  @SerializedName("Year of foundation")
  int yearOfFoundation;

  @SerializedName("Main profile of university")
  StudyProfile mainProfile;

  public University() {
  }

  public University(String id, String fullName, String shortName, int yearOfFoundation,
      StudyProfile mainProfile) {
    this.id = id;
    this.fullName = fullName;
    this.shortName = shortName;
    this.yearOfFoundation = yearOfFoundation;
    this.mainProfile = mainProfile;
  }

  public String getId() {
    return id;
  }

  public String getFullName() {
    return fullName;
  }

  public String getShortName() {
    return shortName;
  }

  public int getYearOfFoundation() {
    return yearOfFoundation;
  }

  public StudyProfile getMainProfile() {
    return mainProfile;
  }

  public String getMainProfileName(){
    return mainProfile.profileName;
  }

  @Override
  public String toString() {
    return "University: { Id: " + id +
        ", Full name: " + fullName +
        ", Short name: " + shortName +
        ", Year of foundation: " + yearOfFoundation +
        ", Main profile: " + mainProfile + " }";
  }


  enum StudyProfile {
    MEDICINE("Медицина"),
    ENGINEERING("Инженерия"),
    COMPUTER_SCIENCE("Информатика"),
    LAW("Юриспруденция"),
    PHYSICS("Физика"),
    MATHEMATICS("Математика"),
    LINGUISTICS("Лингвистика");

    private final String profileName;

    StudyProfile(String profileName) {
      this.profileName = profileName;
    }
  }
}
