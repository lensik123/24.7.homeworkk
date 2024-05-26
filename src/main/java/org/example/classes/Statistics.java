package org.example.classes;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Statistics {
    private University.StudyProfile profileName;
    private double avgExamScore;
    private int numberOfStudents;
    private int universityCount;
    private String universityNames;
}
