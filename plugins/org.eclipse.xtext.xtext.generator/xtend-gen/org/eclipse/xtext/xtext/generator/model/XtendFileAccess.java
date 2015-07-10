/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model;

import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

@SuppressWarnings("all")
public class XtendFileAccess extends JavaFileAccess {
  protected XtendFileAccess(final TypeReference typeRef, final CodeConfig codeConfig, final IEncodingProvider encodingProvider) {
    super(typeRef, codeConfig, encodingProvider);
  }
  
  @Override
  protected String getFileExtension() {
    return "xtend";
  }
  
  @Override
  protected boolean appendSemicolons() {
    return false;
  }
}
