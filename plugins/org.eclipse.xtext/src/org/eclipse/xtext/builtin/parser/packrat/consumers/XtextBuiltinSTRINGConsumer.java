/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builtin.parser.packrat.consumers;

import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.AbstractRuleAwareTerminalConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.services.XtextGrammarAccess;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public final class XtextBuiltinSTRINGConsumer extends AbstractRuleAwareTerminalConsumer {
	
	// ~('\\\\'|'\"')
	static final ICharacterClass STRINGConsumer$$1 = ICharacterClass.Factory.invert(ICharacterClass.Factory.create('\\', '"'));
	// ~('\\\\'|'\\'')
	static final ICharacterClass STRINGConsumer$$2 = ICharacterClass.Factory.invert(ICharacterClass.Factory.create('\\', '\''));
	
	/**
	 * @param input
	 * @param markerFactory
	 * @param tokenAcceptor
	 */
	public XtextBuiltinSTRINGConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor) {
		super(input, markerFactory, tokenAcceptor);
	}

	public boolean doConsume() {
		boolean result = true;
		// '\"' ( '\\\\' ('b'|'t'|'n'|'f'|'r'|'\\\"'|'\\''|'\\\\') | ~('\\\\'|'\"') )* '\"' | 
		// '\\'' ( '\\\\' ('b'|'t'|'n'|'f'|'r'|'\\\"'|'\\''|'\\\\') | ~('\\\\'|'\\'') )* '\\''
		// alternative 1:
		// '\"' ( '\\\\' ('b'|'t'|'n'|'f'|'r'|'\\\"'|'\\''|'\\\\') | ~('\\\\'|'\"') )* '\"'
		ALTERNATIVE$0: {
			SEQUENCE$1: {
				IMarker marker = mark(); // mark position before sequence in alternatives
				// '\"' ( '\\\\' ('b'|'t'|'n'|'f'|'r'|'\\\"'|'\\''|'\\\\') | ~('\\\\'|'\"') )* '\"'
				// sequence
				// '\"'
				if (!readChar('"')) break SEQUENCE$1;
				// ( '\\\\' ('b'|'t'|'n'|'f'|'r'|'\\\"'|'\\''|'\\\\') | ~('\\\\'|'\"') )*
				ALTERNATIVE$2: while(true) { // * cardinality - while(true)
					// alternative 1.1:
					// '\\\\' ('b'|'t'|'n'|'f'|'r'|'\\\"'|'\\''|'\\\\')
					ALTERNATIVE$3: {
						// '\\\\' ('b'|'t'|'n'|'f'|'r'|'\\\"'|'\\''|'\\\\')
						// sequence
						IMarker marker$1 = mark(); // first part of alternative is sequence, so mark the position before the sequence
						// '\\\\'
						if (!readChar('\\')) break ALTERNATIVE$3;
						if (!readAnyChar('b', 't', 'n', 'f', 'r', '"', '\'', '\\')) { 
							marker$1.rollback();
							break ALTERNATIVE$3;
						}
						continue ALTERNATIVE$2;
					}
					ALTERNATIVE$3: {
						if (!readChar(STRINGConsumer$$1)) {
							break ALTERNATIVE$3; 
						}
						continue ALTERNATIVE$2;
					}
					break ALTERNATIVE$2;
				}
				// '\"'
				if (!readChar('"')) {
					marker.rollback();
					break SEQUENCE$1;
				} 
				break ALTERNATIVE$0;
			}
			// alternative 2:
			// '\\'' ( '\\\\' ('b'|'t'|'n'|'f'|'r'|'\\\"'|'\\''|'\\\\') | ~('\\\\'|'\\'') )* '\\''
			{
				// '\\'' ( '\\\\' ('b'|'t'|'n'|'f'|'r'|'\\\"'|'\\''|'\\\\') | ~('\\\\'|'\\'') )* '\\''
				// sequence
				IMarker marker = mark(); // mark position before sequence in alternatives
				// '\\''
				result = readChar('\'');
				if (result) {
					// ( '\\\\' ('b'|'t'|'n'|'f'|'r'|'\\\"'|'\\''|'\\\\') | ~('\\\\'|'\\'') )*
					boolean result$1 = true; // alternative with sequences - use while loop
					while(result$1) {
						// alternative 1.1:
						// '\\\\' ('b'|'t'|'n'|'f'|'r'|'\\\"'|'\\''|'\\\\')
						{
							IMarker marker$$1 = mark(); // first part of alternative is sequence, so mark the position before the sequence
							// '\\\\' ('b'|'t'|'n'|'f'|'r'|'\\\"'|'\\''|'\\\\')
							// sequence
							// '\\\\'
							result$1 = readChar('\\');
							if (result$1) {
								result$1 = readAnyChar('b', 't', 'n', 'f', 'r', '"', '\'', '\\');
								if (!result$1) marker$$1.rollback();
							} else marker$$1.rollback();
						}
						if (!result$1) {
							IMarker marker$$1 = mark();
							result$1 = readChar(STRINGConsumer$$2);
							if (!result$1) marker$$1.rollback();
						}
					} 
					// '\''
					result = readChar('\'');
					if (!result) marker.rollback();
				} else marker.rollback();
			}
		}
		return result;
	}

	@Override
	protected LexerRule doGetRule() {
		return (LexerRule) GrammarUtil.findRuleForName(XtextGrammarAccess.INSTANCE.getGrammar(), "STRING");
	}
}