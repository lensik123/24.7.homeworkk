package org.example.comparator.universityComparator;

import org.apache.commons.lang3.StringUtils;
import org.example.classes.University;

public class SortByFullName implements UniversityComparator{

  @Override
  public int compare(University o1, University o2) {
    return StringUtils.compare(o1.getFullName(), o2.getFullName());
  }
}
