package org.eclipse.xtext.parser.bug419429.idea.lang;

import org.eclipse.xtext.parser.bug419429.idea.lang.AbstractBug419429FileType;
import org.eclipse.xtext.parser.bug419429.idea.lang.Bug419429Language;

@SuppressWarnings("all")
public class Bug419429FileType extends AbstractBug419429FileType {
  public final static Bug419429FileType INSTANCE = new Bug419429FileType();
  
  public Bug419429FileType() {
    super(Bug419429Language.INSTANCE);
  }
}
