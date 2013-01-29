package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.xtend.ide.codebuilder.AbstractCodeBuilder;

@SuppressWarnings("all")
public abstract class AbstractInterfaceBuilder extends AbstractCodeBuilder {
  private String _interfaceName;
  
  public String getInterfaceName() {
    return this._interfaceName;
  }
  
  public void setInterfaceName(final String interfaceName) {
    this._interfaceName = interfaceName;
  }
  
  public String getImage() {
    return "newint_wiz.gif";
  }
}
