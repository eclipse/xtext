package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.xtend.ide.codebuilder.AbstractCodeBuilder;
import org.eclipse.xtend.lib.Property;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public abstract class AbstractClassBuilder extends AbstractCodeBuilder {
  @Property
  private String _className;
  
  public String getImage() {
    return "newclass_wiz.gif";
  }
  
  @Pure
  public String getClassName() {
    return this._className;
  }
  
  public void setClassName(final String className) {
    this._className = className;
  }
}
