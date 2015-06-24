package org.eclipse.xtext.linking.idea.lang;

import org.eclipse.xtext.linking.idea.lang.AbstractBug362902FileType;
import org.eclipse.xtext.linking.idea.lang.Bug362902Language;

@SuppressWarnings("all")
public class Bug362902FileType extends AbstractBug362902FileType {
  public final static Bug362902FileType INSTANCE = new Bug362902FileType();
  
  public Bug362902FileType() {
    super(Bug362902Language.INSTANCE);
  }
}
