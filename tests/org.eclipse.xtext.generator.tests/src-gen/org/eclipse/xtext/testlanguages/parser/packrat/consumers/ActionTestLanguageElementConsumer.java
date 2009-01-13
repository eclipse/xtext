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
import org.eclipse.xtext.testlanguages.services.ActionTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.ActionTestLanguageGrammarAccess.ElementElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ActionTestLanguageItemConsumer;

public final class ActionTestLanguageElementConsumer extends NonTerminalConsumer {

	private ActionTestLanguageItemConsumer itemConsumer;

	public ActionTestLanguageElementConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		GROUP$1SUCCESS: {
			IMarker mGROUP$1 = mark();
			GROUP$1FAILURE: {
				RULECALL$2SUCCESS: {
					if (!consumeNonTerminal(itemConsumer, null, false, false,  getRule().ele0ParserRuleCallItem()))
						break RULECALL$2SUCCESS;
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				GROUP$3SUCCESS: {
					IMarker mGROUP$3 = mark();
					GROUP$3FAILURE: {
						ACTION$4SUCCESS: {
							consumeAction("Item", "items", true);
							break GROUP$3FAILURE;
						}
					}
					GROUP$3FAILURE: {
						ASSIGNMENT$6SUCCESS: {
							ASSIGNMENT$6FAILURE: {
								if (consumeNonTerminal(itemConsumer, "items", true, false , getRule().ele110ParserRuleCallItem()))
									break ASSIGNMENT$6FAILURE;
								mGROUP$3.rollback();
								break ASSIGNMENT$6SUCCESS;
							}
							break GROUP$3FAILURE;
						}
						mGROUP$3.rollback();
						break GROUP$3SUCCESS;
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

	public ElementElements getRule() {
		return ActionTestLanguageGrammarAccess.INSTANCE.prElement();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Type";
	}
	
	public void setItemConsumer(ActionTestLanguageItemConsumer itemConsumer) {
		this.itemConsumer = itemConsumer;
	}
	

}
