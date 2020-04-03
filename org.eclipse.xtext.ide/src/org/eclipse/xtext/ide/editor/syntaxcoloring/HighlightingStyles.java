/*******************************************************************************
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.syntaxcoloring;

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.9
 */
public interface HighlightingStyles {

	String KEYWORD_ID = "keyword";
	String PUNCTUATION_ID = "punctuation";
	String COMMENT_ID = "comment";
	String STRING_ID = "string";
	String NUMBER_ID = "number";
	String DEFAULT_ID = "default";
	String INVALID_TOKEN_ID = "error";
	String TASK_ID = "task";

}
