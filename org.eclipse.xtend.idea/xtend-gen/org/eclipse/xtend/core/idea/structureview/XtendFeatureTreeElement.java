/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.structureview;

import org.eclipse.xtend.core.idea.structureview.XtendEObjectTreeElement;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendFeatureTreeElement extends XtendEObjectTreeElement {
  private boolean isDispatch;
  
  @Accessors
  private boolean synthetic;
  
  public void setDispatch(final boolean isDispatch) {
    this.isDispatch = isDispatch;
  }
  
  public boolean isDispatch() {
    return this.isDispatch;
  }
  
  @Pure
  public boolean isSynthetic() {
    return this.synthetic;
  }
  
  public void setSynthetic(final boolean synthetic) {
    this.synthetic = synthetic;
  }
}
