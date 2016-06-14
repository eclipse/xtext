/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @since 2.9
 */
@Accessors
@SuppressWarnings("all")
public class GeneratorContext implements IGeneratorContext {
  private CancelIndicator cancelIndicator;
  
  @Pure
  public CancelIndicator getCancelIndicator() {
    return this.cancelIndicator;
  }
  
  public void setCancelIndicator(final CancelIndicator cancelIndicator) {
    this.cancelIndicator = cancelIndicator;
  }
}
