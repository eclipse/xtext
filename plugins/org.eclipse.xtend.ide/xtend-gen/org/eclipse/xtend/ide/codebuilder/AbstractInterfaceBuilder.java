package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.xtend.ide.codebuilder.AbstractCodeBuilder;
import org.eclipse.xtend.lib.Property;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public abstract class AbstractInterfaceBuilder extends AbstractCodeBuilder {
  @Property
  private String _interfaceName;
  
  public String getImage() {
    return "newint_wiz.gif";
  }
  
  @Pure
  public String getInterfaceName() {
    return this._interfaceName;
  }
  
  public void setInterfaceName(final String interfaceName) {
    this._interfaceName = interfaceName;
  }
}
