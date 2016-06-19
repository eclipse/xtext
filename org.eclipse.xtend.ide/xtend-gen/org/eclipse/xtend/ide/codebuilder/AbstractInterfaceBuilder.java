/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.xtend.ide.codebuilder.AbstractCodeBuilder;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractInterfaceBuilder extends AbstractCodeBuilder {
  @Accessors
  private String interfaceName;
  
  @Override
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
