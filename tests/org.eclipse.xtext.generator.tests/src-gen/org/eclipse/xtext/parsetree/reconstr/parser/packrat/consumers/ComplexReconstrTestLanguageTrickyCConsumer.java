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
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess.TrickyCElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

public final class ComplexReconstrTestLanguageTrickyCConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;

	public ComplexReconstrTestLanguageTrickyCConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
											if (!consumeKeyword(getRule().ele0000KeywordTC(), null, false, false))
												break KEYWORD$5SUCCESS;
											break GROUP$4FAILURE;
										}
										mGROUP$4.rollback();
										break GROUP$4SUCCESS;
									}
									GROUP$4FAILURE: {
										ASSIGNMENT$6SUCCESS: {
											ASSIGNMENT$6FAILURE: {
												if (consumeTerminal(idConsumer, "name", false, false, getRule().ele00010LexerRuleCallID()))
													break ASSIGNMENT$6FAILURE;
												mGROUP$4.rollback();
												break ASSIGNMENT$6SUCCESS;
											}
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
								GROUP$8SUCCESS: {
									IMarker mGROUP$8 = mark();
									GROUP$8FAILURE: {
										ACTION$9SUCCESS: {
											consumeAction("C1", "x", false);
											break GROUP$8FAILURE;
										}
									}
									GROUP$8FAILURE: {
										KEYWORD$11SUCCESS: {
											if (!consumeKeyword(getRule().ele0011KeywordX(), null, false, false))
												break KEYWORD$11SUCCESS;
											break GROUP$8FAILURE;
										}
										mGROUP$8.rollback();
										break GROUP$8SUCCESS;
									}
									break GROUP$3FAILURE;
								}
							}
							break GROUP$2FAILURE;
						}
						mGROUP$2.rollback();
						break GROUP$2SUCCESS;
					}
					GROUP$2FAILURE: {
						GROUP$12SUCCESS: {
							IMarker mGROUP$12 = mark();
							GROUP$12FAILURE: {
								ACTION$13SUCCESS: {
									consumeAction("C2", "y", false);
									break GROUP$12FAILURE;
								}
							}
							GROUP$12FAILURE: {
								KEYWORD$15SUCCESS: {
									if (!consumeKeyword(getRule().ele011KeywordY(), null, false, false))
										break KEYWORD$15SUCCESS;
									break GROUP$12FAILURE;
								}
								mGROUP$12.rollback();
								break GROUP$12SUCCESS;
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
				GROUP$16SUCCESS: {
					IMarker mGROUP$16 = mark();
					GROUP$16FAILURE: {
						ACTION$17SUCCESS: {
							consumeAction("C3", "z", false);
							break GROUP$16FAILURE;
						}
					}
					GROUP$16FAILURE: {
						KEYWORD$19SUCCESS: {
							if (!consumeKeyword(getRule().ele11KeywordZ(), null, false, false))
								break KEYWORD$19SUCCESS;
							break GROUP$16FAILURE;
						}
						mGROUP$16.rollback();
						break GROUP$16SUCCESS;
					}
					break GROUP$1FAILURE;
				}
			}
			return true;
		}
		return false;
	}

	public TrickyCElements getRule() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyC();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TrickyC";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	

}
