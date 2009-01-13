/*
Generated with Xtext
*/
package org.eclipse.xtext.crossrefs.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.crossrefs.services.ImportUriTestLanguageGrammarAccess;
import org.eclipse.xtext.crossrefs.services.ImportUriTestLanguageGrammarAccess.MainElements;

import org.eclipse.xtext.crossrefs.parser.packrat.consumers.ImportUriTestLanguageTypeConsumer;
import org.eclipse.xtext.crossrefs.parser.packrat.consumers.ImportUriTestLanguageImportConsumer;

public final class ImportUriTestLanguageMainConsumer extends NonTerminalConsumer {

	private ImportUriTestLanguageTypeConsumer typeConsumer;
	private ImportUriTestLanguageImportConsumer importConsumer;

	public ImportUriTestLanguageMainConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	@SuppressWarnings("unused")
	protected boolean doConsume() throws Exception {
		GROUP$1SUCCESS: {
			IMarker mGROUP$1 = mark();
			GROUP$1FAILURE: {
				ASSIGNMENT$2SUCCESS: while(true) {
					ASSIGNMENT$2FAILURE: {
						if (consumeNonTerminal(importConsumer, "imports", true, false , getRule().ele00ParserRuleCallImport()))
							break ASSIGNMENT$2FAILURE;
						break ASSIGNMENT$2SUCCESS;
					}
					continue ASSIGNMENT$2SUCCESS;
				}
			}
			GROUP$1FAILURE: {
				ASSIGNMENT$4SUCCESS: while(true) {
					ASSIGNMENT$4FAILURE: {
						if (consumeNonTerminal(typeConsumer, "types", true, false , getRule().ele10ParserRuleCallType()))
							break ASSIGNMENT$4FAILURE;
						break ASSIGNMENT$4SUCCESS;
					}
					continue ASSIGNMENT$4SUCCESS;
				}
			}
		}
		return true;
	}

	public MainElements getRule() {
		return ImportUriTestLanguageGrammarAccess.INSTANCE.prMain();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Main";
	}
	
	public void setTypeConsumer(ImportUriTestLanguageTypeConsumer typeConsumer) {
		this.typeConsumer = typeConsumer;
	}
	
	public void setImportConsumer(ImportUriTestLanguageImportConsumer importConsumer) {
		this.importConsumer = importConsumer;
	}
	

}
