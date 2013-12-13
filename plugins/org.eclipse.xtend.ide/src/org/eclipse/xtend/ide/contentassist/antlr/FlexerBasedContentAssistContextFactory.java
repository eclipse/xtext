/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.contentassist.antlr;

import java.io.IOException;
import java.io.StringReader;
import java.util.Collection;

import org.antlr.runtime.Token;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtend.core.parser.antlr.internal.FlexerFactory;
import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendFlexer;
import org.eclipse.xtend.ide.contentassist.antlr.internal.InternalXtendParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FlexerBasedContentAssistContextFactory extends ParserBasedContentAssistContextFactory.StatefulFactory {

	private static final Logger log = Logger.getLogger(FlexerBasedContentAssistContextFactory.class);
	
	@Inject
	private FlexerFactory flexerFactory;
	
	@Override
	protected void createContextsForLastCompleteNode(EObject previousModel, boolean strict) throws BadLocationException {
		String currentNodePrefix = getPrefix(currentNode);
		if (!Strings.isEmpty(currentNodePrefix) && !currentNode.getText().equals(currentNodePrefix)) {
			InternalXtendFlexer flexer = flexerFactory.createFlexer(new StringReader(currentNodePrefix));
			try {
				int token = flexer.advance();
				if (token == Token.EOF) { // error case - nothing could be parsed
					return;
				}
				while(token != Token.EOF) {
					if (isErrorToken(token))
						return;
					token = flexer.advance();
				}
			} catch (IOException e) {
				log.error(e.getMessage(), e);
				return;
			}
		}
		String prefix = "";
		String completeInput = viewer.getDocument().get(0, completionOffset);
		Collection<FollowElement> followElements = parser.getFollowElements(completeInput, strict);
		doCreateContexts(lastCompleteNode, currentNode, prefix, previousModel, followElements);
	}
	
	protected boolean isErrorToken(int token) {
		return InternalXtendParser.RULE_ANY_OTHER == token;
	}
	
}
