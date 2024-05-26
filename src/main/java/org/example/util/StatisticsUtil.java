package org.example.util;

import org.apache.commons.lang3.StringUtils;
import org.example.classes.Statistics;
import org.example.classes.Student;
import org.example.classes.University;
import java.math.RoundingMode;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class StatisticsUtil {

    public static List<Statistics> computeStats(List<Student> students, List<University> universities) {
        List<Statistics> statisticsList = new ArrayList<>();

        Set<University.StudyProfile> studyProfiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        studyProfiles.forEach(profile -> {
            List<University> profileUniversities = universities.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .toList();

            List<String> profileUniversityIds = profileUniversities.stream()
                    .map(University::getId)
                    .toList();

            String universityNames = profileUniversities.stream()
                    .map(University::getFullName)
                    .collect(Collectors.joining("; "));

            List<Student> profileStudents = students.stream()
                    .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                    .toList();

            double avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average()
                    .orElse(0);

            Statistics statistics = Statistics.builder()
                    .profileName(profile)
                    .universityCount(profileUniversities.size())
                    .universityNames(universityNames)
                    .numberOfStudents(profileStudents.size())
                    .avgExamScore((float) BigDecimal.valueOf(avgExamScore).setScale(2, RoundingMode.HALF_UP).doubleValue())
                    .build();

            statisticsList.add(statistics);
        });
        return statisticsList;
    }
}
