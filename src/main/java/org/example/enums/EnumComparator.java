package org.example.enums;

import org.example.comparator.student.comparator.SortByAvgExamScore;
import org.example.comparator.student.comparator.SortByCurrentCourseNumber;
import org.example.comparator.student.comparator.SortByFullName;
import org.example.comparator.student.comparator.SortByUniversityId;
import org.example.comparator.student.comparator.StudentComparator;
import org.example.comparator.university.comparator.SortById;
import org.example.comparator.university.comparator.SortByMainProfile;
import org.example.comparator.university.comparator.SortByShortName;
import org.example.comparator.university.comparator.SortByYearOfFoundation;
import org.example.comparator.university.comparator.UniversityComparator;

public class EnumComparator {


  private EnumComparator() {
  }

  public static StudentComparator getStudentComparator(
      StudentComparatorEnum studentComparatorEnum) {

    switch (studentComparatorEnum) {
      case AVG_EXAM_SCORE:
        return new SortByAvgExamScore();
      case CURRENT_COURSE_NUMBER:
        return new SortByCurrentCourseNumber();
      case FULL_NAME:
        return new SortByFullName();
      case UNIVERSITY_ID:
        return new SortByUniversityId();
    }

    return null;
  }

  public static UniversityComparator getUniversityComparator(
      UniversityComparatorEnum universityComparatorEnum) {
    switch (universityComparatorEnum) {
      case ID:
        return new SortById();
      case FULL_NAME:
        return new org.example.comparator.university.comparator.SortByFullName();
      case SHORT_NAME:
        return new SortByShortName();
      case YEARS_OF_FOUNDATION:
        return new SortByYearOfFoundation();
      case MAIN_PROFILE:
        return new SortByMainProfile();
    }

    return null;
  }

}
