package org.eclipse.xtext.idea.lang;

import javax.swing.Icon;
import org.eclipse.xtext.idea.XtextXtextIcons;
import org.eclipse.xtext.idea.lang.AbstractXtextFileType;
import org.eclipse.xtext.idea.lang.XtextLanguage;

@SuppressWarnings("all")
public class XtextFileType extends AbstractXtextFileType {
  public final static XtextFileType INSTANCE = new XtextFileType();
  
  public XtextFileType() {
    super(XtextLanguage.INSTANCE);
  }
  
  @Override
  public Icon getIcon() {
    return XtextXtextIcons.GRAMMAR_FILE_TYPE;
  }
}
