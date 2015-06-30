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
 */
@SuppressWarnings("all")
public interface XbaseHighlightingStyles extends HighlightingStyles {
  public final static String STATIC_METHOD_INVOCATION = "xbase.static.method.invocation";
  
  public final static String STATIC_FIELD = "xbase.static.field";
  
  public final static String FIELD = "xbase.field";
  
  public final static String ANNOTATION = "xbase.annotation";
  
  public final static String EXTENSION_METHOD_INVOCATION = "xbase.extension.method.invacation";
  
  public final static String DEPRECATED_MEMBERS = "xbase.deprecated.members";
}
