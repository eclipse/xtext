/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.antlr;

import java.util.Collection;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.contentassist.antlr.XtextGrammarUiTestLanguageParser;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParserTest extends AbstractParserTest {

	@Override
	protected Collection<FollowElement> getFollowSet(String input) throws RecognitionException {
		AbstractContentAssistParser parser = get(XtextGrammarUiTestLanguageParser.class);
		return parser.getFollowElements(input);
	}
}
