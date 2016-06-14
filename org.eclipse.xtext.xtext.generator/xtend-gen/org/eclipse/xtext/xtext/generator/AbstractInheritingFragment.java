/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.generator.AbstractStubGeneratingFragment;

@SuppressWarnings("all")
public abstract class AbstractInheritingFragment extends AbstractStubGeneratingFragment {
  @Accessors
  private boolean inheritImplementation = true;
  
  @Pure
  public boolean isInheritImplementation() {
    return this.inheritImplementation;
  }
  
  public void setInheritImplementation(final boolean inheritImplementation) {
    this.inheritImplementation = inheritImplementation;
  }
}
