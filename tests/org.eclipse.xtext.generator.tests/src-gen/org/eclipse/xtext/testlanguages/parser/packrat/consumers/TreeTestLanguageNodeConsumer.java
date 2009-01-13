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
import org.eclipse.xtext.testlanguages.services.TreeTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.TreeTestLanguageGrammarAccess.NodeElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.TreeTestLanguageNodeConsumer;

public final class TreeTestLanguageNodeConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private XtextBuiltinSTRINGConsumer stringConsumer;
	private TreeTestLanguageNodeConsumer nodeConsumer;

	public TreeTestLanguageNodeConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
												GROUP$6SUCCESS: {
													IMarker mGROUP$6 = mark();
													GROUP$6FAILURE: {
														ASSIGNMENT$7SUCCESS: {
															ASSIGNMENT$7FAILURE: {
																if (consumeTerminal(idConsumer, "name", false, false, getRule().ele0000000LexerRuleCallID()))
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
														KEYWORD$9SUCCESS: {
															if (!consumeKeyword(getRule().ele000001KeywordLeftParenthesis(), null, false, false))
																break KEYWORD$9SUCCESS;
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
												ASSIGNMENT$10SUCCESS: {
													ASSIGNMENT$10FAILURE: {
														if (consumeTerminal(stringConsumer, "attrib", false, false, getRule().ele000010LexerRuleCallSTRING()))
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
										KEYWORD$12SUCCESS: {
											if (!consumeKeyword(getRule().ele0001KeywordRightParenthesis(), null, false, false))
												break KEYWORD$12SUCCESS;
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
								KEYWORD$13SUCCESS: {
									if (!consumeKeyword(getRule().ele001KeywordLeftCurlyBracket(), null, false, false))
										break KEYWORD$13SUCCESS;
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
						ASSIGNMENT$14SUCCESS: while(true) {
							ASSIGNMENT$14FAILURE: {
								if (consumeNonTerminal(nodeConsumer, "children", true, false , getRule().ele010ParserRuleCallNode()))
									break ASSIGNMENT$14FAILURE;
								break ASSIGNMENT$14SUCCESS;
							}
							continue ASSIGNMENT$14SUCCESS;
						}
					}
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				KEYWORD$16SUCCESS: {
					if (!consumeKeyword(getRule().ele1KeywordRightCurlyBracketSemicolon(), null, false, false))
						break KEYWORD$16SUCCESS;
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			return true;
		}
		return false;
	}

	public NodeElements getRule() {
		return TreeTestLanguageGrammarAccess.INSTANCE.prNode();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Node";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setStringConsumer(XtextBuiltinSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public void setNodeConsumer(TreeTestLanguageNodeConsumer nodeConsumer) {
		this.nodeConsumer = nodeConsumer;
	}
	

}
