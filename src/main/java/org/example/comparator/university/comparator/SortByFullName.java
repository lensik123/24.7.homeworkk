package org.example.comparator.university.comparator;

import org.apache.commons.lang3.StringUtils;
import org.example.model.University;

public class SortByFullName implements UniversityComparator {

  @Override
  public int compare(University o1, University o2) {
    return StringUtils.compare(o1.getFullName(), o2.getFullName());
  }
}
