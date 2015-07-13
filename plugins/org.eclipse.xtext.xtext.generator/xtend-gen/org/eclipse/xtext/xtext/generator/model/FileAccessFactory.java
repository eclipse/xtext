/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.LanguageConfig2;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.TextFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;
import org.eclipse.xtext.xtext.generator.model.XtendFileAccess;

@SuppressWarnings("all")
public class FileAccessFactory {
  @Inject
  private CodeConfig codeConfig;
  
  @Inject
  private IEncodingProvider encodingProvider;
  
  @Inject
  private Provider<ResourceSet> resourceSetProvider;
  
  public TextFileAccess createTextFile() {
    return new TextFileAccess(this.encodingProvider);
  }
  
  public JavaFileAccess createJavaFile(final TypeReference typeRef) {
    final JavaFileAccess file = new JavaFileAccess(typeRef, this.codeConfig, this.encodingProvider);
    ResourceSet _get = this.resourceSetProvider.get();
    file.setResourceSet(_get);
    return file;
  }
  
  public XtendFileAccess createXtendFile(final TypeReference typeRef) {
    final XtendFileAccess file = new XtendFileAccess(typeRef, this.codeConfig, this.encodingProvider);
    ResourceSet _get = this.resourceSetProvider.get();
    file.setResourceSet(_get);
    return file;
  }
  
  public FileAccessFactory with(final LanguageConfig2 language) {
    final FileAccessFactory result = new FileAccessFactory();
    result.codeConfig = this.codeConfig;
    result.encodingProvider = this.encodingProvider;
    final Provider<ResourceSet> _function = new Provider<ResourceSet>() {
      @Override
      public ResourceSet get() {
        return language.getResourceSet();
      }
    };
    result.resourceSetProvider = _function;
    return result;
  }
}
