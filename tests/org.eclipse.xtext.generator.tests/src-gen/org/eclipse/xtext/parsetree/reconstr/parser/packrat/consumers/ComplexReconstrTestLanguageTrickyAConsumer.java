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
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess.TrickyAElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageTrickyA1Consumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

public final class ComplexReconstrTestLanguageTrickyAConsumer extends NonTerminalConsumer {

	private XtextBuiltinSTRINGConsumer stringConsumer;
	private ComplexReconstrTestLanguageTrickyA1Consumer trickyA1Consumer;
	private XtextBuiltinIDConsumer idConsumer;

	public ComplexReconstrTestLanguageTrickyAConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
						GROUP$3SUCCESS: {
							IMarker mGROUP$3 = mark();
							GROUP$3FAILURE: {
								GROUP$4SUCCESS: {
									IMarker mGROUP$4 = mark();
									GROUP$4FAILURE: {
										KEYWORD$5SUCCESS: {
											if (!consumeKeyword(getRule().ele0000KeywordTA(), null, false, false))
												break KEYWORD$5SUCCESS;
											break GROUP$4FAILURE;
										}
										mGROUP$4.rollback();
										break GROUP$4SUCCESS;
									}
									GROUP$4FAILURE: {
										RULECALL$6SUCCESS: {
											if (!consumeNonTerminal(trickyA1Consumer, null, false, false,  getRule().ele0001ParserRuleCallTrickyA1()))
												break RULECALL$6SUCCESS;
											break GROUP$4FAILURE;
										}
										mGROUP$4.rollback();
										break GROUP$4SUCCESS;
									}
									break GROUP$3FAILURE;
								}
								mGROUP$3.rollback();
								break GROUP$3SUCCESS;
							}
							GROUP$3FAILURE: {
								ASSIGNMENT$7SUCCESS: while(true) {
									ASSIGNMENT$7FAILURE: {
										if (consumeTerminal(idConsumer, "name", true, false, getRule().ele0010LexerRuleCallID()))
											break ASSIGNMENT$7FAILURE;
										break ASSIGNMENT$7SUCCESS;
									}
									continue ASSIGNMENT$7SUCCESS;
								}
							}
							break GROUP$2FAILURE;
						}
						mGROUP$2.rollback();
						break GROUP$2SUCCESS;
					}
					GROUP$2FAILURE: {
						ALTERNATIVES$9SUCCESS: {
							ALTERNATIVES$9FAILURE: {
								GROUP$10SUCCESS: {
									IMarker mGROUP$10 = mark();
									GROUP$10FAILURE: {
										ACTION$11SUCCESS: {
											consumeAction("TypeB", "x", false);
											break GROUP$10FAILURE;
										}
									}
									GROUP$10FAILURE: {
										KEYWORD$13SUCCESS: {
											if (!consumeKeyword(getRule().ele0101KeywordX(), null, false, false))
												break KEYWORD$13SUCCESS;
											break GROUP$10FAILURE;
										}
										mGROUP$10.rollback();
										break GROUP$10SUCCESS;
									}
									break ALTERNATIVES$9FAILURE;
								}
								GROUP$14SUCCESS: {
									IMarker mGROUP$14 = mark();
									GROUP$14FAILURE: {
										ACTION$15SUCCESS: {
											consumeAction("TypeC", "x", false);
											break GROUP$14FAILURE;
										}
									}
									GROUP$14FAILURE: {
										KEYWORD$17SUCCESS: {
											if (!consumeKeyword(getRule().ele0111KeywordY(), null, false, false))
												break KEYWORD$17SUCCESS;
											break GROUP$14FAILURE;
										}
										mGROUP$14.rollback();
										break GROUP$14SUCCESS;
									}
									break ALTERNATIVES$9FAILURE;
								}
								break ALTERNATIVES$9SUCCESS;
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
				ASSIGNMENT$18SUCCESS: {
					ASSIGNMENT$18FAILURE: {
						if (consumeTerminal(stringConsumer, "name", true, false, getRule().ele10LexerRuleCallSTRING()))
							break ASSIGNMENT$18FAILURE;
						mGROUP$1.rollback();
						break ASSIGNMENT$18SUCCESS;
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

	public TrickyAElements getRule() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyA();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TypeA1";
	}
	
	public void setStringConsumer(XtextBuiltinSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public void setTrickyA1Consumer(ComplexReconstrTestLanguageTrickyA1Consumer trickyA1Consumer) {
		this.trickyA1Consumer = trickyA1Consumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	

}
