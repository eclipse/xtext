package org.eclipse.xtext.xbase.idea.lang;

import org.eclipse.xtext.xbase.idea.lang.AbstractXbaseFileType;
import org.eclipse.xtext.xbase.idea.lang.XbaseLanguage;

@SuppressWarnings("all")
public class XbaseFileType extends AbstractXbaseFileType {
  public final static XbaseFileType INSTANCE = new XbaseFileType();
  
  public XbaseFileType() {
    super(XbaseLanguage.INSTANCE);
  }
}
