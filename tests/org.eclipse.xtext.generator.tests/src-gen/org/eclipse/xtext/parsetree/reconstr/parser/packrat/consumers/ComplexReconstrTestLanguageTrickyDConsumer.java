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
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess.TrickyDElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

public final class ComplexReconstrTestLanguageTrickyDConsumer extends NonTerminalConsumer {

	private XtextBuiltinSTRINGConsumer stringConsumer;
	private XtextBuiltinINTConsumer intConsumer;
	private XtextBuiltinIDConsumer idConsumer;

	public ComplexReconstrTestLanguageTrickyDConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
								KEYWORD$4SUCCESS: {
									if (!consumeKeyword(getRule().ele000KeywordTD(), null, false, false))
										break KEYWORD$4SUCCESS;
									break GROUP$3FAILURE;
								}
								mGROUP$3.rollback();
								break GROUP$3SUCCESS;
							}
							GROUP$3FAILURE: {
								GROUP$5SUCCESS: {
									IMarker mGROUP$5 = mark();
									GROUP$5FAILURE: {
										GROUP$6SUCCESS: {
											IMarker mGROUP$6 = mark();
											GROUP$6FAILURE: {
												ASSIGNMENT$7SUCCESS: {
													ASSIGNMENT$7FAILURE: {
														if (consumeTerminal(intConsumer, "name", true, false, getRule().ele001000LexerRuleCallINT()))
															break ASSIGNMENT$7FAILURE;
														mGROUP$6.rollback();
														break ASSIGNMENT$7SUCCESS;
													}
													break GROUP$6FAILURE;
												}
												mGROUP$6.rollback();
												break GROUP$6SUCCESS;
											}
											GROUP$6FAILURE: {
												ASSIGNMENT$9SUCCESS: {
													ASSIGNMENT$9FAILURE: {
														if (consumeTerminal(stringConsumer, "foo", false, false, getRule().ele001010LexerRuleCallSTRING()))
															break ASSIGNMENT$9FAILURE;
														mGROUP$6.rollback();
														break ASSIGNMENT$9SUCCESS;
													}
													break GROUP$6FAILURE;
												}
												mGROUP$6.rollback();
												break GROUP$6SUCCESS;
											}
											break GROUP$5FAILURE;
										}
										mGROUP$5.rollback();
										break GROUP$5SUCCESS;
									}
									GROUP$5FAILURE: {
										ASSIGNMENT$11SUCCESS: {
											ASSIGNMENT$11FAILURE: {
												if (consumeTerminal(idConsumer, "type", true, false, getRule().ele00110LexerRuleCallID()))
													break ASSIGNMENT$11FAILURE;
												mGROUP$5.rollback();
												break ASSIGNMENT$11SUCCESS;
											}
											break GROUP$5FAILURE;
										}
										mGROUP$5.rollback();
										break GROUP$5SUCCESS;
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
						GROUP$13SUCCESS: {
							IMarker mGROUP$13 = mark();
							GROUP$13FAILURE: {
								ASSIGNMENT$14SUCCESS: {
									ASSIGNMENT$14FAILURE: {
										if (consumeTerminal(intConsumer, "name", true, false, getRule().ele0100LexerRuleCallINT()))
											break ASSIGNMENT$14FAILURE;
										mGROUP$13.rollback();
										break ASSIGNMENT$14SUCCESS;
									}
									break GROUP$13FAILURE;
								}
								mGROUP$13.rollback();
								break GROUP$13SUCCESS;
							}
							GROUP$13FAILURE: {
								ASSIGNMENT$16SUCCESS: {
									ASSIGNMENT$16FAILURE: {
										if (consumeTerminal(idConsumer, "type", true, false, getRule().ele0110LexerRuleCallID()))
											break ASSIGNMENT$16FAILURE;
										mGROUP$13.rollback();
										break ASSIGNMENT$16SUCCESS;
									}
									break GROUP$13FAILURE;
								}
								mGROUP$13.rollback();
								break GROUP$13SUCCESS;
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
				ASSIGNMENT$18SUCCESS: while(true) {
					ASSIGNMENT$18FAILURE: {
						if (consumeTerminal(idConsumer, "type", true, false, getRule().ele10LexerRuleCallID()))
							break ASSIGNMENT$18FAILURE;
						break ASSIGNMENT$18SUCCESS;
					}
					continue ASSIGNMENT$18SUCCESS;
				}
			}
			return true;
		}
		return false;
	}

	public TrickyDElements getRule() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyD();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TrickyD";
	}
	
	public void setStringConsumer(XtextBuiltinSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public void setIntConsumer(XtextBuiltinINTConsumer intConsumer) {
		this.intConsumer = intConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	

}
