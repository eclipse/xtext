package org.eclipse.xtext.xbase.annotations.idea.lang;

import org.eclipse.xtext.xbase.annotations.idea.lang.AbstractXbaseWithAnnotationsFileType;
import org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsLanguage;

@SuppressWarnings("all")
public class XbaseWithAnnotationsFileType extends AbstractXbaseWithAnnotationsFileType {
  public final static XbaseWithAnnotationsFileType INSTANCE = new XbaseWithAnnotationsFileType();
  
  public XbaseWithAnnotationsFileType() {
    super(XbaseWithAnnotationsLanguage.INSTANCE);
  }
}
