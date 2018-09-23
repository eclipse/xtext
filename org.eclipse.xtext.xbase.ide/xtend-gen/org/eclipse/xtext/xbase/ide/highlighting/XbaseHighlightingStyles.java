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
  public static final String INTERFACE = "xbase.interface";
  
  public static final String ENUM = "xbase.enum";
  
  public static final String CLASS = "xbase.class";
  
  public static final String ABSTRACT_CLASS = "xbase.abstract.class";
  
  public static final String ANNOTATION = "xbase.annotation";
  
  public static final String FIELD = "xbase.field";
  
  public static final String STATIC_FIELD = "xbase.static.field";
  
  public static final String STATIC_FINAL_FIELD = "xbase.static.final.field";
  
  public static final String METHOD = "xbase.method";
  
  public static final String STATIC_METHOD_INVOCATION = "xbase.static.method.invocation";
  
  public static final String ABSTRACT_METHOD_INVOCATION = "xbase.abstract.method.invocation";
  
  public static final String EXTENSION_METHOD_INVOCATION = "xbase.extension.method.invacation";
  
  public static final String DEPRECATED_MEMBERS = "xbase.deprecated.members";
  
  public static final String LOCAL_VARIABLE = "xbase.local.variable";
  
  public static final String LOCAL_VARIABLE_DECLARATION = "xbase.local.variable.declaration";
  
  public static final String LOCAL_FINAL_VARIABLE = "xbase.local.final.variable";
  
  public static final String LOCAL_FINAL_VARIABLE_DECLARATION = "xbase.local.final.variable.declaration";
  
  public static final String PARAMETER_VARIABLE = "xbase.parameter.variable";
  
  public static final String TYPE_VARIABLE = "xbase.type.variable";
  
  public static final String TYPE_ARGUMENT = "xbase.type.argument";
}
