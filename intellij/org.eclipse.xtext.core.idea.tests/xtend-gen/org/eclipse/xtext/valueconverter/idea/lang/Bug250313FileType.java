package org.eclipse.xtext.valueconverter.idea.lang;

import org.eclipse.xtext.valueconverter.idea.lang.AbstractBug250313FileType;
import org.eclipse.xtext.valueconverter.idea.lang.Bug250313Language;

@SuppressWarnings("all")
public class Bug250313FileType extends AbstractBug250313FileType {
  public final static Bug250313FileType INSTANCE = new Bug250313FileType();
  
  public Bug250313FileType() {
    super(Bug250313Language.INSTANCE);
  }
}
