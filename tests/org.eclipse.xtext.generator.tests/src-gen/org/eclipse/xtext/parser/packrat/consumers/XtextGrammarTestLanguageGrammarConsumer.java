/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.GrammarElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageAbstractRuleConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageAbstractMetamodelDeclarationConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

public final class XtextGrammarTestLanguageGrammarConsumer extends NonTerminalConsumer {

	private XtextGrammarTestLanguageAbstractRuleConsumer abstractRuleConsumer;
	private XtextGrammarTestLanguageAbstractMetamodelDeclarationConsumer abstractMetamodelDeclarationConsumer;
	private XtextBuiltinIDConsumer idConsumer;

	public XtextGrammarTestLanguageGrammarConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
												ALTERNATIVES$6SUCCESS: {
													ALTERNATIVES$6FAILURE: {
														ASSIGNMENT$7SUCCESS: {
															ASSIGNMENT$7FAILURE: {
																if (consumeKeyword(getRule().ele0000000KeywordAbstractLanguage(), "abstract", false, true))
																	break ASSIGNMENT$7FAILURE;
																break ASSIGNMENT$7SUCCESS;
															}
															break ALTERNATIVES$6FAILURE;
														}
														KEYWORD$9SUCCESS: {
															if (!consumeKeyword(getRule().ele000001KeywordLanguage(), null, false, false))
																break KEYWORD$9SUCCESS;
															break ALTERNATIVES$6FAILURE;
														}
														mGROUP$5.rollback();
														break ALTERNATIVES$6SUCCESS;
													}
													break GROUP$5FAILURE;
												}
												mGROUP$5.rollback();
												break GROUP$5SUCCESS;
											}
											GROUP$5FAILURE: {
												ASSIGNMENT$10SUCCESS: {
													ASSIGNMENT$10FAILURE: {
														if (consumeTerminal(idConsumer, "idElements", true, false, getRule().ele000010LexerRuleCallID()))
															break ASSIGNMENT$10FAILURE;
														mGROUP$5.rollback();
														break ASSIGNMENT$10SUCCESS;
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
										GROUP$12SUCCESS: while(true) {
											IMarker mGROUP$12 = mark();
											GROUP$12FAILURE: {
												KEYWORD$13SUCCESS: {
													if (!consumeKeyword(getRule().ele00010KeywordFullStop(), null, false, false))
														break KEYWORD$13SUCCESS;
													break GROUP$12FAILURE;
												}
												mGROUP$12.rollback();
												break GROUP$12SUCCESS;
											}
											GROUP$12FAILURE: {
												ASSIGNMENT$14SUCCESS: {
													ASSIGNMENT$14FAILURE: {
														if (consumeTerminal(idConsumer, "idElements", true, false, getRule().ele000110LexerRuleCallID()))
															break ASSIGNMENT$14FAILURE;
														mGROUP$12.rollback();
														break ASSIGNMENT$14SUCCESS;
													}
													break GROUP$12FAILURE;
												}
												mGROUP$12.rollback();
												break GROUP$12SUCCESS;
											}
											continue GROUP$12SUCCESS;
										}
									}
									break GROUP$3FAILURE;
								}
								mGROUP$3.rollback();
								break GROUP$3SUCCESS;
							}
							GROUP$3FAILURE: {
								GROUP$16SUCCESS: {
									IMarker mGROUP$16 = mark();
									GROUP$16FAILURE: {
										GROUP$17SUCCESS: {
											IMarker mGROUP$17 = mark();
											GROUP$17FAILURE: {
												KEYWORD$18SUCCESS: {
													if (!consumeKeyword(getRule().ele00100KeywordExtends(), null, false, false))
														break KEYWORD$18SUCCESS;
													break GROUP$17FAILURE;
												}
												mGROUP$17.rollback();
												break GROUP$17SUCCESS;
											}
											GROUP$17FAILURE: {
												ASSIGNMENT$19SUCCESS: {
													ASSIGNMENT$19FAILURE: {
														if (consumeTerminal(idConsumer, "superGrammarIdElements", true, false, getRule().ele001010LexerRuleCallID()))
															break ASSIGNMENT$19FAILURE;
														mGROUP$17.rollback();
														break ASSIGNMENT$19SUCCESS;
													}
													break GROUP$17FAILURE;
												}
												mGROUP$17.rollback();
												break GROUP$17SUCCESS;
											}
											break GROUP$16FAILURE;
										}
										mGROUP$16.rollback();
										break GROUP$16SUCCESS;
									}
									GROUP$16FAILURE: {
										GROUP$21SUCCESS: while(true) {
											IMarker mGROUP$21 = mark();
											GROUP$21FAILURE: {
												KEYWORD$22SUCCESS: {
													if (!consumeKeyword(getRule().ele00110KeywordFullStop(), null, false, false))
														break KEYWORD$22SUCCESS;
													break GROUP$21FAILURE;
												}
												mGROUP$21.rollback();
												break GROUP$21SUCCESS;
											}
											GROUP$21FAILURE: {
												ASSIGNMENT$23SUCCESS: {
													ASSIGNMENT$23FAILURE: {
														if (consumeTerminal(idConsumer, "superGrammarIdElements", true, false, getRule().ele001110LexerRuleCallID()))
															break ASSIGNMENT$23FAILURE;
														mGROUP$21.rollback();
														break ASSIGNMENT$23SUCCESS;
													}
													break GROUP$21FAILURE;
												}
												mGROUP$21.rollback();
												break GROUP$21SUCCESS;
											}
											continue GROUP$21SUCCESS;
										}
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
						ASSIGNMENT$25SUCCESS: while(true) {
							ASSIGNMENT$25FAILURE: {
								if (consumeNonTerminal(abstractMetamodelDeclarationConsumer, "metamodelDeclarations", true, false , getRule().ele010ParserRuleCallAbstractMetamodelDeclaration()))
									break ASSIGNMENT$25FAILURE;
								break ASSIGNMENT$25SUCCESS;
							}
							continue ASSIGNMENT$25SUCCESS;
						}
					}
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				ASSIGNMENT$27SUCCESS: {
					ASSIGNMENT$27FAILURE: {
						if (!consumeNonTerminal(abstractRuleConsumer, "rules", true, false , getRule().ele10ParserRuleCallAbstractRule()))
							break ASSIGNMENT$27SUCCESS;
						while(consumeNonTerminal(abstractRuleConsumer, "rules", true, false , getRule().ele10ParserRuleCallAbstractRule()));
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

	public GrammarElements getRule() {
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prGrammar();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Grammar";
	}
	
	public void setAbstractRuleConsumer(XtextGrammarTestLanguageAbstractRuleConsumer abstractRuleConsumer) {
		this.abstractRuleConsumer = abstractRuleConsumer;
	}
	
	public void setAbstractMetamodelDeclarationConsumer(XtextGrammarTestLanguageAbstractMetamodelDeclarationConsumer abstractMetamodelDeclarationConsumer) {
		this.abstractMetamodelDeclarationConsumer = abstractMetamodelDeclarationConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	

}
