package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.xtend.ide.codebuilder.AbstractCodeBuilder;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public abstract class AbstractClassBuilder extends AbstractCodeBuilder {
  @Accessors
  private String className;
  
  public String getImage() {
    return "newclass_wiz.gif";
  }
  
  @Pure
  public String getClassName() {
    return this.className;
  }
  
  public void setClassName(final String className) {
    this.className = className;
  }
}
