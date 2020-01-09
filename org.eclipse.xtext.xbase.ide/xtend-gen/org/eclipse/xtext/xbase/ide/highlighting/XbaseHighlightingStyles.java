/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ide.highlighting;

import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Christian Schneider
 */
@SuppressWarnings("all")
public interface XbaseHighlightingStyles extends HighlightingStyles {
  static final String INTERFACE = "xbase.interface";
  
  static final String ENUM = "xbase.enum";
  
  static final String CLASS = "xbase.class";
  
  static final String ABSTRACT_CLASS = "xbase.abstract.class";
  
  static final String ANNOTATION = "xbase.annotation";
  
  static final String FIELD = "xbase.field";
  
  static final String STATIC_FIELD = "xbase.static.field";
  
  static final String STATIC_FINAL_FIELD = "xbase.static.final.field";
  
  static final String METHOD = "xbase.method";
  
  static final String STATIC_METHOD_INVOCATION = "xbase.static.method.invocation";
  
  static final String ABSTRACT_METHOD_INVOCATION = "xbase.abstract.method.invocation";
  
  static final String EXTENSION_METHOD_INVOCATION = "xbase.extension.method.invacation";
  
  static final String DEPRECATED_MEMBERS = "xbase.deprecated.members";
  
  static final String LOCAL_VARIABLE = "xbase.local.variable";
  
  static final String LOCAL_VARIABLE_DECLARATION = "xbase.local.variable.declaration";
  
  static final String LOCAL_FINAL_VARIABLE = "xbase.local.final.variable";
  
  static final String LOCAL_FINAL_VARIABLE_DECLARATION = "xbase.local.final.variable.declaration";
  
  static final String PARAMETER_VARIABLE = "xbase.parameter.variable";
  
  static final String TYPE_VARIABLE = "xbase.type.variable";
  
  static final String TYPE_ARGUMENT = "xbase.type.argument";
}
