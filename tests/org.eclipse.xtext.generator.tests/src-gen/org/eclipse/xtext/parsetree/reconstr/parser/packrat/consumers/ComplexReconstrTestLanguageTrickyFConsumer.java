/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess.TrickyFElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

public final class ComplexReconstrTestLanguageTrickyFConsumer extends NonTerminalConsumer {

	private XtextBuiltinINTConsumer intConsumer;
	private XtextBuiltinIDConsumer idConsumer;

	public ComplexReconstrTestLanguageTrickyFConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
							if (!consumeKeyword(getRule().ele00KeywordTF(), null, false, false))
								break KEYWORD$3SUCCESS;
							break GROUP$2FAILURE;
						}
						mGROUP$2.rollback();
						break GROUP$2SUCCESS;
					}
					GROUP$2FAILURE: {
						GROUP$4SUCCESS: while(true) {
							IMarker mGROUP$4 = mark();
							GROUP$4FAILURE: {
								ASSIGNMENT$5SUCCESS: {
									ASSIGNMENT$5FAILURE: {
										if (consumeTerminal(idConsumer, "name", true, false, getRule().ele0100LexerRuleCallID()))
											break ASSIGNMENT$5FAILURE;
										mGROUP$4.rollback();
										break ASSIGNMENT$5SUCCESS;
									}
									break GROUP$4FAILURE;
								}
								mGROUP$4.rollback();
								break GROUP$4SUCCESS;
							}
							GROUP$4FAILURE: {
								ASSIGNMENT$7SUCCESS: {
									ASSIGNMENT$7FAILURE: {
										if (consumeTerminal(intConsumer, "type", true, false, getRule().ele0110LexerRuleCallINT()))
											break ASSIGNMENT$7FAILURE;
										mGROUP$4.rollback();
										break ASSIGNMENT$7SUCCESS;
									}
									break GROUP$4FAILURE;
								}
								mGROUP$4.rollback();
								break GROUP$4SUCCESS;
							}
							continue GROUP$4SUCCESS;
						}
					}
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				ALTERNATIVES$9SUCCESS: {
					ALTERNATIVES$9FAILURE: {
						ASSIGNMENT$10SUCCESS: {
							ASSIGNMENT$10FAILURE: {
								if (consumeTerminal(idConsumer, "name", true, false, getRule().ele100LexerRuleCallID()))
									break ASSIGNMENT$10FAILURE;
								break ASSIGNMENT$10SUCCESS;
							}
							break ALTERNATIVES$9FAILURE;
						}
						ASSIGNMENT$12SUCCESS: {
							ASSIGNMENT$12FAILURE: {
								if (consumeTerminal(intConsumer, "type", true, false, getRule().ele110LexerRuleCallINT()))
									break ASSIGNMENT$12FAILURE;
								break ASSIGNMENT$12SUCCESS;
							}
							break ALTERNATIVES$9FAILURE;
						}
						mGROUP$1.rollback();
						break ALTERNATIVES$9SUCCESS;
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

	public TrickyFElements getRule() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyF();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TrickyF";
	}
	
	public void setIntConsumer(XtextBuiltinINTConsumer intConsumer) {
		this.intConsumer = intConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	

}
