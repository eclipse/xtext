/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist.antlr;

import org.antlr.runtime.RecognizerSharedState;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ObservableXtextTokenStream.StreamListener;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.BaseInternalContentAssistParser;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.14
 */
public class EofListener implements StreamListener, AbstractInternalContentAssistParser.RecoveryListener {
	public final RecognizerSharedState parserState;
	
	public boolean wasEof = false;
	public boolean announcedEofWithLA = false;
	public boolean consumedSomething = true;
	public boolean wasRecovering = false;
	
	public int startedErrorRecoveryAt;
	
	private final BaseInternalContentAssistParser<?, ?> parser;
	private final AbstractElement elementToParse;

	protected EofListener(BaseInternalContentAssistParser<?, ?> parser, AbstractElement elementToParse) {
		this.parser = parser;
		this.elementToParse = elementToParse;
		this.parserState = parser.getInternalRecognizerSharedState();
		
		registerAsListenerAt(parser);
	}

	protected void registerAsListenerAt(BaseInternalContentAssistParser<?, ?> parser) {
		ObservableXtextTokenStream stream = (ObservableXtextTokenStream) parser.getTokenStream();
		stream.setListener(this);
		parser.setRecoveryListener(this);
	}

	@Override
	public void announceEof(int lookAhead) {
		if (!wasRecovering) {
			parser.announceEof(lookAhead);
			if (lookAhead > 1)
				announcedEofWithLA = true;
		}
		if (parser.isDFAPrediction()) {
			int lastGrammarElement = parser.getGrammarElements().size() - 1;
			if (elementToParse instanceof UnorderedGroup && parser.getGrammarElements().get(lastGrammarElement) == elementToParse) {
				IUnorderedGroupHelper helper = parser.getUnorderedGroupHelper();
				if (!helper.canLeave((UnorderedGroup) elementToParse)) {
					wasEof = true;		
				}
			}
		} else {
			wasEof = true;
		}
	}

	@Override
	public void announceConsume() {
		parser.announceConsume();
		if (!wasRecovering)
			consumedSomething = true;
	}

	@Override
	public void announceMark(int marker) {
		parser.announceMark(marker);
	}

	@Override
	public void announceRewind(int marker) {
		parser.announceRewind(marker);
	}
	
	@Override
	public void endErrorRecovery() {
		if (!wasEof && !parserState.failed && startedErrorRecoveryAt == parser.input.index()) {
			wasRecovering = false;
		}
	}
	
	@Override
	public void beginErrorRecovery() {
		startedErrorRecoveryAt = parser.input.index();
		wasRecovering = true;
	}

	public void reset() {
		consumedSomething = false;
		announcedEofWithLA = false;
		wasRecovering = false;
	}
	
	protected AbstractElement getElementToParse() {
		return elementToParse;
	}
	
	protected BaseInternalContentAssistParser<?, ?> getParser() {
		return parser;
	}
	
	protected RecognizerSharedState getParserState() {
		return parserState;
	}
	
}