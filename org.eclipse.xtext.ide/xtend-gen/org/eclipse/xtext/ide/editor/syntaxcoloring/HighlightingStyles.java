/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.editor.syntaxcoloring;

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.9
 */
@SuppressWarnings("all")
public interface HighlightingStyles {
  public static final String KEYWORD_ID = "keyword";
  
  public static final String PUNCTUATION_ID = "punctuation";
  
  public static final String COMMENT_ID = "comment";
  
  public static final String STRING_ID = "string";
  
  public static final String NUMBER_ID = "number";
  
  public static final String DEFAULT_ID = "default";
  
  public static final String INVALID_TOKEN_ID = "error";
  
  public static final String TASK_ID = "task";
}
