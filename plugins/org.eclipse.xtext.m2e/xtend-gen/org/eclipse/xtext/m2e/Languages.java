package org.eclipse.xtext.m2e;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import org.eclipse.xtext.m2e.Language;

@SuppressWarnings("all")
public class Languages implements Iterable<Language> {
  private ArrayList<Language> languages = Lists.<Language>newArrayList();
  
  public void addLanguage(final Language lang) {
    this.languages.add(lang);
  }
  
  public Iterator<Language> iterator() {
    Iterator<Language> _iterator = this.languages.iterator();
    return _iterator;
  }
}
