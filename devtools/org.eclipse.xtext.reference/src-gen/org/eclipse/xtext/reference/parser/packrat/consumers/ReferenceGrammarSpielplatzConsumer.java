/*
Generated with Xtext
*/
package org.eclipse.xtext.reference.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.reference.services.ReferenceGrammarGrammarAccess;
import org.eclipse.xtext.reference.services.ReferenceGrammarGrammarAccess.SpielplatzElements;

import org.eclipse.xtext.reference.parser.packrat.consumers.ReferenceGrammarErwachsenerConsumer;
import org.eclipse.xtext.reference.parser.packrat.consumers.ReferenceGrammarSpielzeugConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.reference.parser.packrat.consumers.ReferenceGrammarFamilieConsumer;
import org.eclipse.xtext.reference.parser.packrat.consumers.ReferenceGrammarKindConsumer;
import org.eclipse.xtext.reference.parser.packrat.consumers.ReferenceGrammarCustomTypeParserRuleConsumer;

public final class ReferenceGrammarSpielplatzConsumer extends NonTerminalConsumer {

	private ReferenceGrammarErwachsenerConsumer erwachsenerConsumer;
	private ReferenceGrammarSpielzeugConsumer spielzeugConsumer;
	private XtextBuiltinINTConsumer intConsumer;
	private XtextBuiltinSTRINGConsumer stringConsumer;
	private ReferenceGrammarFamilieConsumer familieConsumer;
	private ReferenceGrammarKindConsumer kindConsumer;
	private ReferenceGrammarCustomTypeParserRuleConsumer customTypeParserRuleConsumer;

	public ReferenceGrammarSpielplatzConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
												ALTERNATIVES$15SUCCESS: {
													ALTERNATIVES$15FAILURE: {
														ASSIGNMENT$16SUCCESS: {
															ASSIGNMENT$16FAILURE: {
																if (consumeNonTerminal(kindConsumer, "kinder", true, false , getRule().ele0100000ParserRuleCallKind()))
																	break ASSIGNMENT$16FAILURE;
																break ASSIGNMENT$16SUCCESS;
															}
															break ALTERNATIVES$15FAILURE;
														}
														ASSIGNMENT$18SUCCESS: {
															ASSIGNMENT$18FAILURE: {
																if (consumeNonTerminal(erwachsenerConsumer, "erzieher", true, false , getRule().ele0100010ParserRuleCallErwachsener()))
																	break ASSIGNMENT$18FAILURE;
																break ASSIGNMENT$18SUCCESS;
															}
															break ALTERNATIVES$15FAILURE;
														}
														break ALTERNATIVES$15SUCCESS;
													}
													break ALTERNATIVES$14FAILURE;
												}
												ASSIGNMENT$20SUCCESS: {
													ASSIGNMENT$20FAILURE: {
														if (consumeNonTerminal(spielzeugConsumer, "spielzeuge", true, false , getRule().ele010010ParserRuleCallSpielzeug()))
															break ASSIGNMENT$20FAILURE;
														break ASSIGNMENT$20SUCCESS;
													}
													break ALTERNATIVES$14FAILURE;
												}
												break ALTERNATIVES$14SUCCESS;
											}
											break ALTERNATIVES$13FAILURE;
										}
										ASSIGNMENT$22SUCCESS: {
											ASSIGNMENT$22FAILURE: {
												if (consumeNonTerminal(familieConsumer, "familie", true, false , getRule().ele01010ParserRuleCallFamilie()))
													break ASSIGNMENT$22FAILURE;
												break ASSIGNMENT$22SUCCESS;
											}
											break ALTERNATIVES$13FAILURE;
										}
										break ALTERNATIVES$13SUCCESS;
									}
									break ALTERNATIVES$12FAILURE;
								}
								ASSIGNMENT$24SUCCESS: {
									ASSIGNMENT$24FAILURE: {
										if (consumeNonTerminal(customTypeParserRuleConsumer, "types", true, false , getRule().ele0110ParserRuleCallCustomTypeParserRule()))
											break ASSIGNMENT$24FAILURE;
										break ASSIGNMENT$24SUCCESS;
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
				KEYWORD$26SUCCESS: {
					if (!consumeKeyword(getRule().ele1KeywordRightCurlyBracket(), null, false, false))
						break KEYWORD$26SUCCESS;
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
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielplatz();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Spielplatz";
	}
	
	public void setErwachsenerConsumer(ReferenceGrammarErwachsenerConsumer erwachsenerConsumer) {
		this.erwachsenerConsumer = erwachsenerConsumer;
	}
	
	public void setSpielzeugConsumer(ReferenceGrammarSpielzeugConsumer spielzeugConsumer) {
		this.spielzeugConsumer = spielzeugConsumer;
	}
	
	public void setIntConsumer(XtextBuiltinINTConsumer intConsumer) {
		this.intConsumer = intConsumer;
	}
	
	public void setStringConsumer(XtextBuiltinSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public void setFamilieConsumer(ReferenceGrammarFamilieConsumer familieConsumer) {
		this.familieConsumer = familieConsumer;
	}
	
	public void setKindConsumer(ReferenceGrammarKindConsumer kindConsumer) {
		this.kindConsumer = kindConsumer;
	}
	
	public void setCustomTypeParserRuleConsumer(ReferenceGrammarCustomTypeParserRuleConsumer customTypeParserRuleConsumer) {
		this.customTypeParserRuleConsumer = customTypeParserRuleConsumer;
	}
	

}
