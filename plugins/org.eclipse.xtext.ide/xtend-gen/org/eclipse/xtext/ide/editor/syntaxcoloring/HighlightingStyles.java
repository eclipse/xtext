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
  public final static String KEYWORD_ID = "keyword";
  
  public final static String PUNCTUATION_ID = "punctuation";
  
  public final static String COMMENT_ID = "comment";
  
  public final static String STRING_ID = "string";
  
  public final static String NUMBER_ID = "number";
  
  public final static String DEFAULT_ID = "default";
  
  public final static String INVALID_TOKEN_ID = "error";
  
  public final static String TASK_ID = "task";
}
