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
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess.TrickyBElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

public final class ComplexReconstrTestLanguageTrickyBConsumer extends NonTerminalConsumer {

	private XtextBuiltinINTConsumer intConsumer;
	private XtextBuiltinIDConsumer idConsumer;

	public ComplexReconstrTestLanguageTrickyBConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
							if (!consumeKeyword(getRule().ele00KeywordTB(), null, false, false))
								break KEYWORD$3SUCCESS;
							break GROUP$2FAILURE;
						}
						mGROUP$2.rollback();
						break GROUP$2SUCCESS;
					}
					GROUP$2FAILURE: {
						GROUP$4SUCCESS: {
							IMarker mGROUP$4 = mark();
							GROUP$4FAILURE: {
								ASSIGNMENT$5SUCCESS: {
									ASSIGNMENT$5FAILURE: {
										if (consumeTerminal(idConsumer, "name", false, false, getRule().ele0100LexerRuleCallID()))
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
							break GROUP$2FAILURE;
						}
					}
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				ASSIGNMENT$9SUCCESS: while(true) {
					ASSIGNMENT$9FAILURE: {
						if (consumeTerminal(intConsumer, "type", true, false, getRule().ele10LexerRuleCallINT()))
							break ASSIGNMENT$9FAILURE;
						break ASSIGNMENT$9SUCCESS;
					}
					continue ASSIGNMENT$9SUCCESS;
				}
			}
			return true;
		}
		return false;
	}

	public TrickyBElements getRule() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyB();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TrickyB";
	}
	
	public void setIntConsumer(XtextBuiltinINTConsumer intConsumer) {
		this.intConsumer = intConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	

}
