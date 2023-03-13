/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.codebuilder;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractClassBuilder extends AbstractCodeBuilder {
  @Accessors
  private String className;

  @Accessors
  private String image = "newclass_wiz.gif";

  @Pure
  public String getClassName() {
    return this.className;
  }

  public void setClassName(final String className) {
    this.className = className;
  }

  @Pure
  @Override
  public String getImage() {
    return this.image;
  }

  public void setImage(final String image) {
    this.image = image;
  }
}
