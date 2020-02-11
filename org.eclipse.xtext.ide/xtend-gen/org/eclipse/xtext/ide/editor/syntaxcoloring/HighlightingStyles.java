/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.syntaxcoloring;

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.9
 */
@SuppressWarnings("all")
public interface HighlightingStyles {
  static final String KEYWORD_ID = "keyword";
  
  static final String PUNCTUATION_ID = "punctuation";
  
  static final String COMMENT_ID = "comment";
  
  static final String STRING_ID = "string";
  
  static final String NUMBER_ID = "number";
  
  static final String DEFAULT_ID = "default";
  
  static final String INVALID_TOKEN_ID = "error";
  
  static final String TASK_ID = "task";
}
