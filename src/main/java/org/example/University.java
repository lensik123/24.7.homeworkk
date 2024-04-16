package org.example;

//lombok библиотека, использовал готовый билдер из этой библиотеки.
import lombok.Builder;


@Builder
public class University {
    String id, fullName, shortName;
    int yearOfFoundation;
    StudyProfile mainProfile;

    public University() {
    }

    enum StudyProfile {
        MEDICINE("Медицина"),
        ENGINEERING("Инженерия"),
        COMPUTER_SCIENCE("Информатика"),
        LAW("Юриспруденция");

        private final String profileName;

        StudyProfile(String profileName) {
            this.profileName = profileName;
        }
    }

    @Override
    public String toString() {
        return "University:" +
                "{\nId: " + this.id +
                "\nFull name: " + this.fullName +
                "\nShort name: " + this.shortName +
                "\nYear of foundation: " + this.yearOfFoundation +
                "\nMain profile: " + this.mainProfile +
                "\n}";
    }

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
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
}
