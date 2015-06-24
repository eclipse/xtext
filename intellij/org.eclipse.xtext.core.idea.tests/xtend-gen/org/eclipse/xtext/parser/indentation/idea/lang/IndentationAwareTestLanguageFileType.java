package org.eclipse.xtext.parser.indentation.idea.lang;

import org.eclipse.xtext.parser.indentation.idea.lang.AbstractIndentationAwareTestLanguageFileType;
import org.eclipse.xtext.parser.indentation.idea.lang.IndentationAwareTestLanguageLanguage;

@SuppressWarnings("all")
public class IndentationAwareTestLanguageFileType extends AbstractIndentationAwareTestLanguageFileType {
  public final static IndentationAwareTestLanguageFileType INSTANCE = new IndentationAwareTestLanguageFileType();
  
  public IndentationAwareTestLanguageFileType() {
    super(IndentationAwareTestLanguageLanguage.INSTANCE);
  }
}
