/*
Generated with Xtext
*/
package org.eclipse.xtext.metamodelreferencing.tests.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.metamodelreferencing.tests.services.MultiGenMMTestLanguageGrammarAccess;
import org.eclipse.xtext.metamodelreferencing.tests.services.MultiGenMMTestLanguageGrammarAccess.FooElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.metamodelreferencing.tests.parser.packrat.consumers.MultiGenMMTestLanguageNameRefConsumer;

public final class MultiGenMMTestLanguageFooConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private MultiGenMMTestLanguageNameRefConsumer nameRefConsumer;

	public MultiGenMMTestLanguageFooConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		GROUP$1SUCCESS: {
			IMarker mGROUP$1 = mark();
			GROUP$1FAILURE: {
				ASSIGNMENT$2SUCCESS: {
					ASSIGNMENT$2FAILURE: {
						if (consumeTerminal(idConsumer, "name", false, false, getRule().ele00LexerRuleCallID()))
							break ASSIGNMENT$2FAILURE;
						mGROUP$1.rollback();
						break ASSIGNMENT$2SUCCESS;
					}
					break GROUP$1FAILURE;
				}
				mGROUP$1.rollback();
				break GROUP$1SUCCESS;
			}
			GROUP$1FAILURE: {
				ASSIGNMENT$4SUCCESS: while(true) {
					ASSIGNMENT$4FAILURE: {
						if (consumeNonTerminal(nameRefConsumer, "nameRefs", true, false , getRule().ele10ParserRuleCallNameRef()))
							break ASSIGNMENT$4FAILURE;
						break ASSIGNMENT$4SUCCESS;
					}
					continue ASSIGNMENT$4SUCCESS;
				}
			}
			return true;
		}
		return false;
	}

	public FooElements getRule() {
		return MultiGenMMTestLanguageGrammarAccess.INSTANCE.prFoo();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Foo";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setNameRefConsumer(MultiGenMMTestLanguageNameRefConsumer nameRefConsumer) {
		this.nameRefConsumer = nameRefConsumer;
	}
	

}
