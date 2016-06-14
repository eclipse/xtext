/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist.antlr;

import java.util.Collection;

import org.eclipse.xtext.parser.IParseResult;

/**
 * A content assist parser that can skip parts of the document for faster parsing
 * @since 2.9
 */
public interface IPartialContentAssistParser extends IContentAssistParser {

	/**
	 * @param strict if <code>true</code>
	 * the parser will not use error recovery on the very last token of the input.
	 */
	public Collection<FollowElement> getFollowElements(IParseResult parseResult, int offset, boolean strict);

}