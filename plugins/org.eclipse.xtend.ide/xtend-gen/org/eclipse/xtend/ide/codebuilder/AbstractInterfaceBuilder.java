package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.xtend.ide.codebuilder.AbstractCodeBuilder;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public abstract class AbstractInterfaceBuilder extends AbstractCodeBuilder {
  @Accessors
  private String interfaceName;
  
  public String getImage() {
    return "newint_wiz.gif";
  }
  
  @Pure
  public String getInterfaceName() {
    return this.interfaceName;
  }
  
  public void setInterfaceName(final String interfaceName) {
    this.interfaceName = interfaceName;
  }
}
