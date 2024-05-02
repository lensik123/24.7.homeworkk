package org.example.comparator.universitycomparator;

import org.apache.commons.lang3.StringUtils;
import org.example.classes.University;

public class SortById implements UniversityComparator {

  @Override
  public int compare(University o1, University o2) {
    return StringUtils.compare(o1.getId(), o2.getId());
  }
}
