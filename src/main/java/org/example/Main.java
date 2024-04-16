package org.example;

import lombok.Builder;

public class Main {
    public static void main(String[] args) {
        Student student = new Student().builder()
                .fullName("Turpal Baysarov")
                .universityId("MGU")
                .currentCourseNumber(3)
                .avgExamScore(4.6f)
                .build();

        University university = new University().builder()
                .fullName("Moscow university")
                .mainProfile(University.StudyProfile.MEDICINE)
                .id("Mgu")
                .yearOfFoundation(1985)
                .shortName("mgu")
                .build();

        System.out.println(student);
        System.out.println("\n" + university);
    }
}
