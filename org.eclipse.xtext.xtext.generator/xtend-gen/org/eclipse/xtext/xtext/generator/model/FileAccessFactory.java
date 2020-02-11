/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.model;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.model.BinaryFileAccess;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.TextFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.XtendFileAccess;

/**
 * Factory for creating text files, Java files, and Xtend files.
 */
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
    return new JavaFileAccess(typeRef, this.codeConfig);
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
    return new GeneratedJavaFileAccess(typeRef, this.codeConfig);
  }
  
  public BinaryFileAccess createBinaryFile() {
    return new BinaryFileAccess();
  }
  
  public BinaryFileAccess createBinaryFile(final String path) {
    final BinaryFileAccess result = this.createBinaryFile();
    result.setPath(path);
    return result;
  }
}
