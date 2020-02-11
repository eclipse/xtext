/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.syntaxcoloring

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.9
 */
interface HighlightingStyles {

	val KEYWORD_ID = "keyword"
	val PUNCTUATION_ID = "punctuation"
	val COMMENT_ID = "comment"
	val STRING_ID = "string"
	val NUMBER_ID = "number"
	val DEFAULT_ID = "default"
	val INVALID_TOKEN_ID = "error"
	val TASK_ID = "task"

}
