/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Injector;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xtext.xtext.generator.IGeneratorFragment2;
import org.eclipse.xtext.xtext.generator.XtextGenerator;

@SuppressWarnings("all")
public abstract class AbstractGeneratorFragment2 implements IGeneratorFragment2 {
  @Override
  public void checkConfiguration(final XtextGenerator generator, final Issues issues) {
  }
  
  @Override
  public void initialize(final Injector injector) {
    injector.injectMembers(this);
  }
}
