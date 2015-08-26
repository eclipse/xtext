/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator.model;

import java.util.Collections;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xtext.generator.CodeConfig;
import org.eclipse.xtext.xtext.generator.model.JavaFileAccess;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

@SuppressWarnings("all")
public class XtendFileAccess extends JavaFileAccess {
  /**
   * A list of keywords in the Xtend language. Use this to avoid illegal variable names.
   */
  public final static Set<String> XTEND_KEYWORDS = Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("abstract", "for", "new", "switch", "default", "package", "synchronized", "boolean", "do", "if", "private", "this", "double", "implements", "protected", "throw", "byte", "else", "import", "public", "throws", "case", "enum", "instanceof", "return", "transient", "catch", "extends", "int", "short", "try", "char", "final", "interface", "static", "void", "class", "finally", "long", "strictfp", "volatile", "float", "native", "super", "while", "val", "var", "def", "override", "annotation", "extension", "create", "dispatch"));
  
  protected XtendFileAccess(final TypeReference typeRef, final CodeConfig codeConfig) {
    super(typeRef, codeConfig);
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
