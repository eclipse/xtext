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
import org.eclipse.xtext.services.XtextGrammarAccess.AbstractTokenElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextAbstractTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextAssignmentConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextActionConsumer;

public final class XtextAbstractTokenConsumer extends NonTerminalConsumer {

	private XtextAbstractTerminalConsumer abstractTerminalConsumer;
	private XtextAssignmentConsumer assignmentConsumer;
	private XtextActionConsumer actionConsumer;

	public XtextAbstractTokenConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		GROUP$1SUCCESS: {
			IMarker mGROUP$1 = mark();
			GROUP$1FAILURE: {
				ALTERNATIVES$2SUCCESS: {
					ALTERNATIVES$2FAILURE: {
						ALTERNATIVES$3SUCCESS: {
							ALTERNATIVES$3FAILURE: {
								RULECALL$4SUCCESS: {
									if (!consumeNonTerminal(assignmentConsumer, null, false, false,  getRule().ele000ParserRuleCallAssignment()))
										break RULECALL$4SUCCESS;
									break ALTERNATIVES$3FAILURE;
								}
								RULECALL$5SUCCESS: {
									if (!consumeNonTerminal(actionConsumer, null, false, false,  getRule().ele001ParserRuleCallAction()))
										break RULECALL$5SUCCESS;
									break ALTERNATIVES$3FAILURE;
								}
								break ALTERNATIVES$3SUCCESS;
							}
							break ALTERNATIVES$2FAILURE;
						}
						RULECALL$6SUCCESS: {
							if (!consumeNonTerminal(abstractTerminalConsumer, null, false, false,  getRule().ele01ParserRuleCallAbstractTerminal()))
								break RULECALL$6SUCCESS;
							break ALTERNATIVES$2FAILURE;
						}
						mGROUP$1.rollback();
						break ALTERNATIVES$2SUCCESS;
					}
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				ASSIGNMENT$7SUCCESS: {
					ASSIGNMENT$7FAILURE: {
						if (consumeKeyword(getRule().ele1000KeywordQuestionMark(), "cardinality", false, false))
							break ASSIGNMENT$7FAILURE;
						if (consumeKeyword(getRule().ele1001KeywordAsterisk(), "cardinality", false, false))
							break ASSIGNMENT$7FAILURE;
						if (consumeKeyword(getRule().ele101KeywordPlusSign(), "cardinality", false, false))
							break ASSIGNMENT$7FAILURE;
						break ASSIGNMENT$7SUCCESS;
					}
					break GROUP$1FAILURE;
				}
			}
			return true;
		}
		return false;
	}

	public AbstractTokenElements getRule() {
		return XtextGrammarAccess.INSTANCE.prAbstractToken();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setAbstractTerminalConsumer(XtextAbstractTerminalConsumer abstractTerminalConsumer) {
		this.abstractTerminalConsumer = abstractTerminalConsumer;
	}
	
	public void setAssignmentConsumer(XtextAssignmentConsumer assignmentConsumer) {
		this.assignmentConsumer = assignmentConsumer;
	}
	
	public void setActionConsumer(XtextActionConsumer actionConsumer) {
		this.actionConsumer = actionConsumer;
	}
	

}
