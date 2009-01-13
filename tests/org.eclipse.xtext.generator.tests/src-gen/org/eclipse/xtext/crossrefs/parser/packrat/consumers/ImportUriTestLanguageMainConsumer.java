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

import org.eclipse.xtext.crossrefs.parser.packrat.ImportUriTestLanguageDelimiters;

import org.eclipse.xtext.crossrefs.parser.packrat.consumers.ImportUriTestLanguageTypeConsumer;
import org.eclipse.xtext.crossrefs.parser.packrat.consumers.ImportUriTestLanguageImportConsumer;

@SuppressWarnings("unused")
public final class ImportUriTestLanguageMainConsumer extends NonTerminalConsumer {

	private ImportUriTestLanguageTypeConsumer typeConsumer;
	private ImportUriTestLanguageImportConsumer importConsumer;

	public ImportUriTestLanguageMainConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeAssignment$2()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$4()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeAssignment$2() throws Exception {
		while(doConsumeAssignment$2()) {}
		return true;
	}

	protected boolean doConsumeAssignment$2() throws Exception {
		if (consumeNonTerminal(importConsumer, "imports", true, false, getRule().ele00ParserRuleCallImport()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$4() throws Exception {
		while(doConsumeAssignment$4()) {}
		return true;
	}

	protected boolean doConsumeAssignment$4() throws Exception {
		if (consumeNonTerminal(typeConsumer, "types", true, false, getRule().ele10ParserRuleCallType()))
			return true;
		return false;
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
