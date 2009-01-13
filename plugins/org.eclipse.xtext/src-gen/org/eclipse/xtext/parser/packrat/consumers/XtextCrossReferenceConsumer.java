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
import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarAccess.CrossReferenceElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextTypeRefConsumer;

public final class XtextCrossReferenceConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private XtextTypeRefConsumer typeRefConsumer;

	public XtextCrossReferenceConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
									if (!consumeKeyword(getRule().ele000KeywordLeftSquareBracket(), null, false, false))
										break KEYWORD$4SUCCESS;
									break GROUP$3FAILURE;
								}
								mGROUP$3.rollback();
								break GROUP$3SUCCESS;
							}
							GROUP$3FAILURE: {
								ASSIGNMENT$5SUCCESS: {
									ASSIGNMENT$5FAILURE: {
										if (consumeNonTerminal(typeRefConsumer, "type", false, false , getRule().ele0010ParserRuleCallTypeRef()))
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
						GROUP$7SUCCESS: {
							IMarker mGROUP$7 = mark();
							GROUP$7FAILURE: {
								KEYWORD$8SUCCESS: {
									if (!consumeKeyword(getRule().ele010KeywordVerticalLine(), null, false, false))
										break KEYWORD$8SUCCESS;
									break GROUP$7FAILURE;
								}
								mGROUP$7.rollback();
								break GROUP$7SUCCESS;
							}
							GROUP$7FAILURE: {
								ASSIGNMENT$9SUCCESS: {
									ASSIGNMENT$9FAILURE: {
										if (consumeTerminal(idConsumer, null, false, false, getRule().ele0110CrossReferenceEStringAbstractRule()))
											break ASSIGNMENT$9FAILURE;
										mGROUP$7.rollback();
										break ASSIGNMENT$9SUCCESS;
									}
									break GROUP$7FAILURE;
								}
								mGROUP$7.rollback();
								break GROUP$7SUCCESS;
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
				KEYWORD$12SUCCESS: {
					if (!consumeKeyword(getRule().ele1KeywordRightSquareBracket(), null, false, false))
						break KEYWORD$12SUCCESS;
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			return true;
		}
		return false;
	}

	public CrossReferenceElements getRule() {
		return XtextGrammarAccess.INSTANCE.prCrossReference();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "CrossReference";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setTypeRefConsumer(XtextTypeRefConsumer typeRefConsumer) {
		this.typeRefConsumer = typeRefConsumer;
	}
	

}
