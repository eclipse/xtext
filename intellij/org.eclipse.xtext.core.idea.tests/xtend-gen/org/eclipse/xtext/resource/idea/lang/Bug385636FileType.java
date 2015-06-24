package org.eclipse.xtext.resource.idea.lang;

import org.eclipse.xtext.resource.idea.lang.AbstractBug385636FileType;
import org.eclipse.xtext.resource.idea.lang.Bug385636Language;

@SuppressWarnings("all")
public class Bug385636FileType extends AbstractBug385636FileType {
  public final static Bug385636FileType INSTANCE = new Bug385636FileType();
  
  public Bug385636FileType() {
    super(Bug385636Language.INSTANCE);
  }
}
