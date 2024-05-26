package org.example.classes;

//lombok библиотека, использовал готовый билдер из этой библиотеки.

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
