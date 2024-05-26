package org.example.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.example.model.Statistics;
import org.example.model.Student;
import org.example.model.University;

public class StatisticsUtil {

  private static final Logger logger = Logger.getLogger(StatisticsUtil.class.getName());

  public static List<Statistics> computeStats(List<Student> students,
      List<University> universities) {
    List<Statistics> statisticsList = new ArrayList<>();

    logger.info("Сбор статистики по студентам и университетам");
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
          .avgExamScore((float) BigDecimal.valueOf(avgExamScore).setScale(2, RoundingMode.HALF_UP)
              .doubleValue())
          .build();

      statisticsList.add(statistics);
    });

    logger.info("Статистика собрана");
    return statisticsList;
  }
}
