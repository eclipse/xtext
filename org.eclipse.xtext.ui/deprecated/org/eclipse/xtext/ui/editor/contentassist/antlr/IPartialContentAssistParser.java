/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist.antlr;

import java.util.Collection;

import org.eclipse.xtext.parser.IParseResult;

/**
 * A content assist parser that can skip parts of the document for faster parsing
 * @since 2.7
 */
public interface IPartialContentAssistParser extends IContentAssistParser {

	/**
	 * @param strict if <code>true</code>
	 * the parser will not use error recovery on the very last token of the input.
	 */
	public Collection<FollowElement> getFollowElements(IParseResult parseResult, int offset, boolean strict);

}