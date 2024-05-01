package org.example.Enum;

import org.example.comparator.studentComparator.SortByAvgExamScore;
import org.example.comparator.studentComparator.SortByCurrentCourseNumber;
import org.example.comparator.studentComparator.SortByFullName;
import org.example.comparator.studentComparator.SortByUniversityId;
import org.example.comparator.studentComparator.StudentComparator;
import org.example.comparator.universityComparator.SortById;
import org.example.comparator.universityComparator.SortByMainProfile;
import org.example.comparator.universityComparator.SortByShortName;
import org.example.comparator.universityComparator.SortByYearOfFoundation;
import org.example.comparator.universityComparator.UniversityComparator;

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
        return new org.example.comparator.universityComparator.SortByFullName();
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
