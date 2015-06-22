package org.eclipse.xtext.parser.terminalrules.idea.lang;

import org.eclipse.xtext.parser.terminalrules.idea.lang.AbstractXtextTerminalsTestLanguageFileType;
import org.eclipse.xtext.parser.terminalrules.idea.lang.XtextTerminalsTestLanguageLanguage;

@SuppressWarnings("all")
public class XtextTerminalsTestLanguageFileType extends AbstractXtextTerminalsTestLanguageFileType {
  public final static XtextTerminalsTestLanguageFileType INSTANCE = new XtextTerminalsTestLanguageFileType();
  
  public XtextTerminalsTestLanguageFileType() {
    super(XtextTerminalsTestLanguageLanguage.INSTANCE);
  }
}
