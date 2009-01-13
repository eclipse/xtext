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
import org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestGrammarAccess.RootElements;

import org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers.TransientValuesTestTestListConsumer;
import org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers.TransientValuesTestTestRequiredConsumer;
import org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers.TransientValuesTestTestOptionalConsumer;

public final class TransientValuesTestRootConsumer extends NonTerminalConsumer {

	private TransientValuesTestTestListConsumer testListConsumer;
	private TransientValuesTestTestRequiredConsumer testRequiredConsumer;
	private TransientValuesTestTestOptionalConsumer testOptionalConsumer;

	public TransientValuesTestRootConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		GROUP$1SUCCESS: {
			IMarker mGROUP$1 = mark();
			GROUP$1FAILURE: {
				KEYWORD$2SUCCESS: {
					if (!consumeKeyword(getRule().ele0KeywordTest(), null, false, false))
						break KEYWORD$2SUCCESS;
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				ALTERNATIVES$3SUCCESS: {
					ALTERNATIVES$3FAILURE: {
						ALTERNATIVES$4SUCCESS: {
							ALTERNATIVES$4FAILURE: {
								RULECALL$5SUCCESS: {
									if (!consumeNonTerminal(testRequiredConsumer, null, false, false,  getRule().ele100ParserRuleCallTestRequired()))
										break RULECALL$5SUCCESS;
									break ALTERNATIVES$4FAILURE;
								}
								RULECALL$6SUCCESS: {
									if (!consumeNonTerminal(testOptionalConsumer, null, false, false,  getRule().ele101ParserRuleCallTestOptional()))
										break RULECALL$6SUCCESS;
									break ALTERNATIVES$4FAILURE;
								}
								break ALTERNATIVES$4SUCCESS;
							}
							break ALTERNATIVES$3FAILURE;
						}
						RULECALL$7SUCCESS: {
							if (!consumeNonTerminal(testListConsumer, null, false, false,  getRule().ele11ParserRuleCallTestList()))
								break RULECALL$7SUCCESS;
							break ALTERNATIVES$3FAILURE;
						}
						mGROUP$1.rollback();
						break ALTERNATIVES$3SUCCESS;
					}
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			return true;
		}
		return false;
	}

	public RootElements getRule() {
		return TransientValuesTestGrammarAccess.INSTANCE.prRoot();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Root";
	}
	
	public void setTestListConsumer(TransientValuesTestTestListConsumer testListConsumer) {
		this.testListConsumer = testListConsumer;
	}
	
	public void setTestRequiredConsumer(TransientValuesTestTestRequiredConsumer testRequiredConsumer) {
		this.testRequiredConsumer = testRequiredConsumer;
	}
	
	public void setTestOptionalConsumer(TransientValuesTestTestOptionalConsumer testOptionalConsumer) {
		this.testOptionalConsumer = testOptionalConsumer;
	}
	

}
