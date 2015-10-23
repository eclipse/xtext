/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.generator;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGenerator2;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class ArithmeticsGenerator implements IGenerator2 {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final CancelIndicator cancelIndicator) {
  }
  
  @Override
  public void beforeGenerate(final Resource resource, final IFileSystemAccess2 fsa, final CancelIndicator cancelIndicator) {
  }
  
  @Override
  public void afterGenerate(final Resource resource, final IFileSystemAccess2 fsa, final CancelIndicator cancelIndicator) {
  }
}
