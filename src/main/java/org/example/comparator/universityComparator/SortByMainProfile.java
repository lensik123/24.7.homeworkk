package org.example.comparator.universityComparator;

import org.apache.commons.lang3.StringUtils;
import org.example.classes.University;

import java.util.Comparator;

public class SortByMainProfile implements UniversityComparator {

  @Override
  public int compare(University o1, University o2) {
    return StringUtils.compare(o1.getMainProfileName(), o2.getMainProfileName());
  }
}
