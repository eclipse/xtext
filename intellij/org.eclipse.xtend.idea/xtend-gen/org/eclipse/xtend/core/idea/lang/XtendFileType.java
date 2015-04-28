package org.eclipse.xtend.core.idea.lang;

import javax.swing.Icon;
import org.eclipse.xtend.core.idea.icons.XtendIcons;
import org.eclipse.xtend.core.idea.lang.AbstractXtendFileType;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;

@SuppressWarnings("all")
public class XtendFileType extends AbstractXtendFileType {
  public final static XtendFileType INSTANCE = new XtendFileType();
  
  public XtendFileType() {
    super(XtendLanguage.INSTANCE);
  }
  
  @Override
  public Icon getIcon() {
    return XtendIcons.Xtend_FILETYPE;
  }
}
