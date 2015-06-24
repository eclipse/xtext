package org.eclipse.xtext.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextGrammarTestLanguageFileType;
import org.eclipse.xtext.idea.lang.XtextGrammarTestLanguageLanguage;

@SuppressWarnings("all")
public class XtextGrammarTestLanguageFileType extends AbstractXtextGrammarTestLanguageFileType {
  public final static XtextGrammarTestLanguageFileType INSTANCE = new XtextGrammarTestLanguageFileType();
  
  public XtextGrammarTestLanguageFileType() {
    super(XtextGrammarTestLanguageLanguage.INSTANCE);
  }
}
