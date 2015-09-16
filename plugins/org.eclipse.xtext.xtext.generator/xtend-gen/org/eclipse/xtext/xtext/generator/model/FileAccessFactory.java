/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.TextFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.XtendFileAccess;

@SuppressWarnings("all")
public class FileAccessFactory {
  @Inject
  private CodeConfig codeConfig;
  
  public TextFileAccess createTextFile() {
    return new TextFileAccess();
  }
  
  public TextFileAccess createTextFile(final String path) {
    final TextFileAccess result = this.createTextFile();
    result.setPath(path);
    return result;
  }
  
  public TextFileAccess createTextFile(final String path, final StringConcatenationClient content) {
    final TextFileAccess result = this.createTextFile(path);
    result.setContent(content);
    return result;
  }
  
  public JavaFileAccess createJavaFile(final TypeReference typeRef) {
    final JavaFileAccess result = new JavaFileAccess(typeRef, this.codeConfig);
    return result;
  }
  
  public JavaFileAccess createJavaFile(final TypeReference typeRef, final StringConcatenationClient content) {
    final JavaFileAccess result = this.createJavaFile(typeRef);
    result.setContent(content);
    return result;
  }
  
  public XtendFileAccess createXtendFile(final TypeReference typeRef) {
    return new XtendFileAccess(typeRef, this.codeConfig);
  }
  
  public XtendFileAccess createXtendFile(final TypeReference typeRef, final StringConcatenationClient content) {
    final XtendFileAccess result = this.createXtendFile(typeRef);
    result.setContent(content);
    return result;
  }
  
  public GeneratedJavaFileAccess createGeneratedJavaFile(final TypeReference typeRef) {
    final GeneratedJavaFileAccess result = new GeneratedJavaFileAccess(typeRef, this.codeConfig);
    return result;
  }
}
