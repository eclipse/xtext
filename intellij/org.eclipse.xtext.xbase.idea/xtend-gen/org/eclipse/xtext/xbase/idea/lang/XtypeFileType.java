package org.eclipse.xtext.xbase.idea.lang;

import org.eclipse.xtext.xbase.idea.lang.AbstractXtypeFileType;
import org.eclipse.xtext.xbase.idea.lang.XtypeLanguage;

@SuppressWarnings("all")
public class XtypeFileType extends AbstractXtypeFileType {
  public final static XtypeFileType INSTANCE = new XtypeFileType();
  
  public XtypeFileType() {
    super(XtypeLanguage.INSTANCE);
  }
}
