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
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.AssignmentElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageAbstractTerminalConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

public final class XtextGrammarTestLanguageAssignmentConsumer extends NonTerminalConsumer {

	private XtextGrammarTestLanguageAbstractTerminalConsumer abstractTerminalConsumer;
	private XtextBuiltinIDConsumer idConsumer;

	public XtextGrammarTestLanguageAssignmentConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
						ASSIGNMENT$3SUCCESS: {
							ASSIGNMENT$3FAILURE: {
								if (consumeTerminal(idConsumer, "feature", false, false, getRule().ele000LexerRuleCallID()))
									break ASSIGNMENT$3FAILURE;
								mGROUP$2.rollback();
								break ASSIGNMENT$3SUCCESS;
							}
							break GROUP$2FAILURE;
						}
						mGROUP$2.rollback();
						break GROUP$2SUCCESS;
					}
					GROUP$2FAILURE: {
						ASSIGNMENT$5SUCCESS: {
							ASSIGNMENT$5FAILURE: {
								if (consumeKeyword(getRule().ele01000KeywordPlusSignEqualsSign(), "operator", false, false))
									break ASSIGNMENT$5FAILURE;
								if (consumeKeyword(getRule().ele01001KeywordEqualsSign(), "operator", false, false))
									break ASSIGNMENT$5FAILURE;
								if (consumeKeyword(getRule().ele0101KeywordQuestionMarkEqualsSign(), "operator", false, false))
									break ASSIGNMENT$5FAILURE;
								mGROUP$2.rollback();
								break ASSIGNMENT$5SUCCESS;
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
				ASSIGNMENT$11SUCCESS: {
					ASSIGNMENT$11FAILURE: {
						if (consumeNonTerminal(abstractTerminalConsumer, "terminal", false, false , getRule().ele10ParserRuleCallAbstractTerminal()))
							break ASSIGNMENT$11FAILURE;
						mGROUP$1.rollback();
						break ASSIGNMENT$11SUCCESS;
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

	public AssignmentElements getRule() {
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prAssignment();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Assignment";
	}
	
	public void setAbstractTerminalConsumer(XtextGrammarTestLanguageAbstractTerminalConsumer abstractTerminalConsumer) {
		this.abstractTerminalConsumer = abstractTerminalConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	

}
