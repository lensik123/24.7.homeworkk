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
@AllArgsConstructor
@NoArgsConstructor
@ToString

@XmlRootElement(name = "universityEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public class University {

  @XmlElement(name = "universityId")
  @SerializedName("ID")
  String id;

  @XmlElement(name = "universityName")
  @SerializedName("Name of University")
  String fullName;

  @XmlTransient
  @SerializedName("Shortname")
  String shortName;

  @XmlTransient
  @SerializedName("Year of foundation")
  int yearOfFoundation;

  @XmlElement(name = "universityProfile")
  @SerializedName("Main profile of university")
  StudyProfile mainProfile;

  public String getMainProfileName() {
    return mainProfile.profileName;
  }

  public enum StudyProfile {
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
