/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestGrammarAccess;
import org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestGrammarAccess.TestOptionalElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;

public final class TransientValuesTestTestOptionalConsumer extends NonTerminalConsumer {

	private XtextBuiltinINTConsumer intConsumer;

	public TransientValuesTestTestOptionalConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		GROUP$1SUCCESS: {
			IMarker mGROUP$1 = mark();
			GROUP$1FAILURE: {
				GROUP$2SUCCESS: {
					IMarker mGROUP$2 = mark();
					GROUP$2FAILURE: {
						KEYWORD$3SUCCESS: {
							if (!consumeKeyword(getRule().ele00KeywordOptional(), null, false, false))
								break KEYWORD$3SUCCESS;
							break GROUP$2FAILURE;
						}
						mGROUP$2.rollback();
						break GROUP$2SUCCESS;
					}
					GROUP$2FAILURE: {
						ASSIGNMENT$4SUCCESS: {
							ASSIGNMENT$4FAILURE: {
								if (consumeTerminal(intConsumer, "opt1", false, false, getRule().ele010LexerRuleCallINT()))
									break ASSIGNMENT$4FAILURE;
								break ASSIGNMENT$4SUCCESS;
							}
							break GROUP$2FAILURE;
						}
					}
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				GROUP$6SUCCESS: {
					IMarker mGROUP$6 = mark();
					GROUP$6FAILURE: {
						KEYWORD$7SUCCESS: {
							if (!consumeKeyword(getRule().ele10KeywordColon(), null, false, false))
								break KEYWORD$7SUCCESS;
							break GROUP$6FAILURE;
						}
						mGROUP$6.rollback();
						break GROUP$6SUCCESS;
					}
					GROUP$6FAILURE: {
						ASSIGNMENT$8SUCCESS: {
							ASSIGNMENT$8FAILURE: {
								if (consumeTerminal(intConsumer, "opt2", false, false, getRule().ele110LexerRuleCallINT()))
									break ASSIGNMENT$8FAILURE;
								mGROUP$6.rollback();
								break ASSIGNMENT$8SUCCESS;
							}
							break GROUP$6FAILURE;
						}
						mGROUP$6.rollback();
						break GROUP$6SUCCESS;
					}
					break GROUP$1FAILURE;
				}
			}
			return true;
		}
		return false;
	}

	public TestOptionalElements getRule() {
		return TransientValuesTestGrammarAccess.INSTANCE.prTestOptional();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TestOptional";
	}
	
	public void setIntConsumer(XtextBuiltinINTConsumer intConsumer) {
		this.intConsumer = intConsumer;
	}
	

}
