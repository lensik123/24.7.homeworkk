package org.example.comparator.universitycomparator;

import org.example.classes.University;

public class SortByYearOfFoundation implements UniversityComparator{

  @Override
  public int compare(University o1, University o2) {
    return Integer.compare(o1.getYearOfFoundation(), o2.getYearOfFoundation());
  }
}
