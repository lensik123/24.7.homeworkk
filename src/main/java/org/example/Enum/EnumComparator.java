package org.example.Enum;

import org.example.comparator.studentcomparator.SortByAvgExamScore;
import org.example.comparator.studentcomparator.SortByCurrentCourseNumber;
import org.example.comparator.studentcomparator.SortByFullName;
import org.example.comparator.studentcomparator.SortByUniversityId;
import org.example.comparator.studentcomparator.StudentComparator;
import org.example.comparator.universitycomparator.SortById;
import org.example.comparator.universitycomparator.SortByMainProfile;
import org.example.comparator.universitycomparator.SortByShortName;
import org.example.comparator.universitycomparator.SortByYearOfFoundation;
import org.example.comparator.universitycomparator.UniversityComparator;

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
        return new org.example.comparator.universitycomparator.SortByFullName();
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
