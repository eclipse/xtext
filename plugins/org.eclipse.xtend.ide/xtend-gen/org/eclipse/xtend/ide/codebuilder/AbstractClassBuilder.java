package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.xtend.ide.codebuilder.AbstractCodeBuilder;

@SuppressWarnings("all")
public abstract class AbstractClassBuilder extends AbstractCodeBuilder {
  private String _className;
  
  public String getClassName() {
    return this._className;
  }
  
  public void setClassName(final String className) {
    this._className = className;
  }
  
  public String getImage() {
    return "newclass_wiz.gif";
  }
}
