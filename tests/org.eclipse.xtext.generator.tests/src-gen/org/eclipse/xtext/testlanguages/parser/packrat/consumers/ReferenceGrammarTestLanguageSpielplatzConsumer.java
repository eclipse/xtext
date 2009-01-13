/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess.SpielplatzElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ReferenceGrammarTestLanguageFamilieConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ReferenceGrammarTestLanguageSpielzeugConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ReferenceGrammarTestLanguageErwachsenerConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ReferenceGrammarTestLanguageKindConsumer;

public final class ReferenceGrammarTestLanguageSpielplatzConsumer extends NonTerminalConsumer {

	private XtextBuiltinINTConsumer intConsumer;
	private XtextBuiltinSTRINGConsumer stringConsumer;
	private ReferenceGrammarTestLanguageFamilieConsumer familieConsumer;
	private ReferenceGrammarTestLanguageSpielzeugConsumer spielzeugConsumer;
	private ReferenceGrammarTestLanguageErwachsenerConsumer erwachsenerConsumer;
	private ReferenceGrammarTestLanguageKindConsumer kindConsumer;

	public ReferenceGrammarTestLanguageSpielplatzConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
										GROUP$5SUCCESS: {
											IMarker mGROUP$5 = mark();
											GROUP$5FAILURE: {
												KEYWORD$6SUCCESS: {
													if (!consumeKeyword(getRule().ele00000KeywordSpielplatz(), null, false, false))
														break KEYWORD$6SUCCESS;
													break GROUP$5FAILURE;
												}
												mGROUP$5.rollback();
												break GROUP$5SUCCESS;
											}
											GROUP$5FAILURE: {
												ASSIGNMENT$7SUCCESS: {
													ASSIGNMENT$7FAILURE: {
														if (consumeTerminal(intConsumer, "groesse", false, false, getRule().ele000010LexerRuleCallINT()))
															break ASSIGNMENT$7FAILURE;
														mGROUP$5.rollback();
														break ASSIGNMENT$7SUCCESS;
													}
													break GROUP$5FAILURE;
												}
												mGROUP$5.rollback();
												break GROUP$5SUCCESS;
											}
											break GROUP$4FAILURE;
										}
										mGROUP$4.rollback();
										break GROUP$4SUCCESS;
									}
									GROUP$4FAILURE: {
										ASSIGNMENT$9SUCCESS: {
											ASSIGNMENT$9FAILURE: {
												if (consumeTerminal(stringConsumer, "beschreibung", false, false, getRule().ele00010LexerRuleCallSTRING()))
													break ASSIGNMENT$9FAILURE;
												break ASSIGNMENT$9SUCCESS;
											}
											break GROUP$4FAILURE;
										}
									}
									break GROUP$3FAILURE;
								}
								mGROUP$3.rollback();
								break GROUP$3SUCCESS;
							}
							GROUP$3FAILURE: {
								KEYWORD$11SUCCESS: {
									if (!consumeKeyword(getRule().ele001KeywordLeftCurlyBracket(), null, false, false))
										break KEYWORD$11SUCCESS;
									break GROUP$3FAILURE;
								}
								mGROUP$3.rollback();
								break GROUP$3SUCCESS;
							}
							break GROUP$2FAILURE;
						}
						mGROUP$2.rollback();
						break GROUP$2SUCCESS;
					}
					GROUP$2FAILURE: {
						ALTERNATIVES$12SUCCESS: while(true) {
							ALTERNATIVES$12FAILURE: {
								ALTERNATIVES$13SUCCESS: {
									ALTERNATIVES$13FAILURE: {
										ALTERNATIVES$14SUCCESS: {
											ALTERNATIVES$14FAILURE: {
												ASSIGNMENT$15SUCCESS: {
													ASSIGNMENT$15FAILURE: {
														if (consumeNonTerminal(kindConsumer, "kinder", true, false , getRule().ele010000ParserRuleCallKind()))
															break ASSIGNMENT$15FAILURE;
														break ASSIGNMENT$15SUCCESS;
													}
													break ALTERNATIVES$14FAILURE;
												}
												ASSIGNMENT$17SUCCESS: {
													ASSIGNMENT$17FAILURE: {
														if (consumeNonTerminal(erwachsenerConsumer, "erzieher", true, false , getRule().ele010010ParserRuleCallErwachsener()))
															break ASSIGNMENT$17FAILURE;
														break ASSIGNMENT$17SUCCESS;
													}
													break ALTERNATIVES$14FAILURE;
												}
												break ALTERNATIVES$14SUCCESS;
											}
											break ALTERNATIVES$13FAILURE;
										}
										ASSIGNMENT$19SUCCESS: {
											ASSIGNMENT$19FAILURE: {
												if (consumeNonTerminal(spielzeugConsumer, "spielzeuge", true, false , getRule().ele01010ParserRuleCallSpielzeug()))
													break ASSIGNMENT$19FAILURE;
												break ASSIGNMENT$19SUCCESS;
											}
											break ALTERNATIVES$13FAILURE;
										}
										break ALTERNATIVES$13SUCCESS;
									}
									break ALTERNATIVES$12FAILURE;
								}
								ASSIGNMENT$21SUCCESS: {
									ASSIGNMENT$21FAILURE: {
										if (consumeNonTerminal(familieConsumer, "familie", true, false , getRule().ele0110ParserRuleCallFamilie()))
											break ASSIGNMENT$21FAILURE;
										break ASSIGNMENT$21SUCCESS;
									}
									break ALTERNATIVES$12FAILURE;
								}
								break ALTERNATIVES$12SUCCESS;
							}
							continue ALTERNATIVES$12SUCCESS;
						}
					}
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				KEYWORD$23SUCCESS: {
					if (!consumeKeyword(getRule().ele1KeywordRightCurlyBracket(), null, false, false))
						break KEYWORD$23SUCCESS;
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			return true;
		}
		return true;
	}

	public SpielplatzElements getRule() {
		return ReferenceGrammarTestLanguageGrammarAccess.INSTANCE.prSpielplatz();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Spielplatz";
	}
	
	public void setIntConsumer(XtextBuiltinINTConsumer intConsumer) {
		this.intConsumer = intConsumer;
	}
	
	public void setStringConsumer(XtextBuiltinSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public void setFamilieConsumer(ReferenceGrammarTestLanguageFamilieConsumer familieConsumer) {
		this.familieConsumer = familieConsumer;
	}
	
	public void setSpielzeugConsumer(ReferenceGrammarTestLanguageSpielzeugConsumer spielzeugConsumer) {
		this.spielzeugConsumer = spielzeugConsumer;
	}
	
	public void setErwachsenerConsumer(ReferenceGrammarTestLanguageErwachsenerConsumer erwachsenerConsumer) {
		this.erwachsenerConsumer = erwachsenerConsumer;
	}
	
	public void setKindConsumer(ReferenceGrammarTestLanguageKindConsumer kindConsumer) {
		this.kindConsumer = kindConsumer;
	}
	

}
