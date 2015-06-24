package org.eclipse.xtext.parsetree.impl.idea.lang;

import org.eclipse.xtext.parsetree.impl.idea.lang.AbstractBug305397FileType;
import org.eclipse.xtext.parsetree.impl.idea.lang.Bug305397Language;

@SuppressWarnings("all")
public class Bug305397FileType extends AbstractBug305397FileType {
  public final static Bug305397FileType INSTANCE = new Bug305397FileType();
  
  public Bug305397FileType() {
    super(Bug305397Language.INSTANCE);
  }
}
