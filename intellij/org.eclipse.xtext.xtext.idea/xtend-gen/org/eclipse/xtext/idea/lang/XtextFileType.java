package org.eclipse.xtext.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextFileType;
import org.eclipse.xtext.idea.lang.XtextLanguage;

@SuppressWarnings("all")
public class XtextFileType extends AbstractXtextFileType {
  public final static XtextFileType INSTANCE = new XtextFileType();
  
  public XtextFileType() {
    super(XtextLanguage.INSTANCE);
  }
}
