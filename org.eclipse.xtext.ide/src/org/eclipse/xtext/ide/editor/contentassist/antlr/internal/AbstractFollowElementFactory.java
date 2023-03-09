/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist.antlr.internal;

import java.util.Collections;
import java.util.List;

import org.antlr.runtime.Token;
import org.apache.log4j.Logger;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.ide.editor.contentassist.antlr.BaseFollowElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ILookAheadTerminal;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * @since 2.14
 */
public abstract class AbstractFollowElementFactory<FollowElement extends BaseFollowElement<LookAheadTerminal>, LookAheadTerminal extends ILookAheadTerminal> {
	
	private static final Logger logger = Logger.getLogger(AbstractFollowElementFactory.class);
	
	private final BaseInternalContentAssistParser<FollowElement, LookAheadTerminal> parser;
	
	protected AbstractFollowElementFactory(BaseInternalContentAssistParser<FollowElement, LookAheadTerminal> parser) {
		this.parser = parser;
	}
	
	protected abstract FollowElement doCreateElement();
	
	protected abstract LookAheadTerminal doCreateLookAheadTerminal(Token token);
	
	public FollowElement createFollowElement(AbstractElement current, int lookAhead) {
		if (logger.isDebugEnabled())
			logger.debug("Creating FollowElement for: " + current);
		FollowElement result = doCreateElement();
		result.setLookAhead(lookAhead);
		if (lookAhead != 1) {
			int from = parser.input.index();
			int to = parser.input.size();
			if (parser.marked > 0) {
				from = parser.firstMarker;
			}
			List<LookAheadTerminal> lookAheadTerminals = Lists.newArrayListWithExpectedSize(to - from);
			for (int tokenIndex = from; tokenIndex < to; tokenIndex++) {
				Token token = parser.input.get(tokenIndex);
				
				if (token != null) {
					LookAheadTerminal lookAheadTerminal = doCreateLookAheadTerminal(token);
					lookAheadTerminals.add(lookAheadTerminal);
				}
			}
			result.setLookAheadTerminals(lookAheadTerminals);
			result.setLookAhead(lookAheadTerminals.size() + 1);
		}
		result.setGrammarElement(current);
		result.setTrace(Lists.newArrayList(Iterators.filter(parser.grammarElements.iterator(), AbstractElement.class)));
		result.setLocalTrace(Lists.newArrayList(Iterators.filter(parser.localTrace.iterator(), AbstractElement.class)));
		result.setParamStack(Lists.newArrayList(parser.paramStack));
		if (current instanceof UnorderedGroup) {
			if (parser.indexToHandledElements != null) {
				int index = parser.grammarElements.lastIndexOf(current);
				List<AbstractElement> alreadyHandled = Lists.newArrayList(Iterators.filter(parser.indexToHandledElements.get(index).iterator(), AbstractElement.class));
				result.setHandledUnorderedGroupElements(alreadyHandled);
			} else {
				result.setHandledUnorderedGroupElements(Collections.<AbstractElement>emptyList());
			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug("FollowElement is: " + current);
			logger.debug("==================================");
		}
		return result;
	}
	
}
