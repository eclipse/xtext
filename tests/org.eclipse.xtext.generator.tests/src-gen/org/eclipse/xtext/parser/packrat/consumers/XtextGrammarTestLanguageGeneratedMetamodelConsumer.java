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
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.GeneratedMetamodelElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

public final class XtextGrammarTestLanguageGeneratedMetamodelConsumer extends NonTerminalConsumer {

	private XtextBuiltinSTRINGConsumer stringConsumer;
	private XtextBuiltinIDConsumer idConsumer;

	public XtextGrammarTestLanguageGeneratedMetamodelConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
									if (!consumeKeyword(getRule().ele000KeywordGenerate(), null, false, false))
										break KEYWORD$4SUCCESS;
									break GROUP$3FAILURE;
								}
								mGROUP$3.rollback();
								break GROUP$3SUCCESS;
							}
							GROUP$3FAILURE: {
								ASSIGNMENT$5SUCCESS: {
									ASSIGNMENT$5FAILURE: {
										if (consumeTerminal(idConsumer, "name", false, false, getRule().ele0010LexerRuleCallID()))
											break ASSIGNMENT$5FAILURE;
										mGROUP$3.rollback();
										break ASSIGNMENT$5SUCCESS;
									}
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
						ASSIGNMENT$7SUCCESS: {
							ASSIGNMENT$7FAILURE: {
								if (consumeTerminal(stringConsumer, "nsURI", false, false, getRule().ele010LexerRuleCallSTRING()))
									break ASSIGNMENT$7FAILURE;
								mGROUP$2.rollback();
								break ASSIGNMENT$7SUCCESS;
							}
							break GROUP$2FAILURE;
						}
						mGROUP$2.rollback();
						break GROUP$2SUCCESS;
					}
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				GROUP$9SUCCESS: {
					IMarker mGROUP$9 = mark();
					GROUP$9FAILURE: {
						KEYWORD$10SUCCESS: {
							if (!consumeKeyword(getRule().ele10KeywordAs(), null, false, false))
								break KEYWORD$10SUCCESS;
							break GROUP$9FAILURE;
						}
						mGROUP$9.rollback();
						break GROUP$9SUCCESS;
					}
					GROUP$9FAILURE: {
						ASSIGNMENT$11SUCCESS: {
							ASSIGNMENT$11FAILURE: {
								if (consumeTerminal(idConsumer, "alias", false, false, getRule().ele110LexerRuleCallID()))
									break ASSIGNMENT$11FAILURE;
								mGROUP$9.rollback();
								break ASSIGNMENT$11SUCCESS;
							}
							break GROUP$9FAILURE;
						}
						mGROUP$9.rollback();
						break GROUP$9SUCCESS;
					}
					break GROUP$1FAILURE;
				}
			}
			return true;
		}
		return false;
	}

	public GeneratedMetamodelElements getRule() {
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prGeneratedMetamodel();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "GeneratedMetamodel";
	}
	
	public void setStringConsumer(XtextBuiltinSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	

}
