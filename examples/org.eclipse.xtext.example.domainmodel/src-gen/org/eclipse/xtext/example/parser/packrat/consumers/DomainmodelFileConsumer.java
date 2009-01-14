/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.example.services.DomainmodelGrammarAccess;
import org.eclipse.xtext.example.services.DomainmodelGrammarAccess.FileElements;

import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelImportConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelNamedElementConsumer;

@SuppressWarnings("unused")
public final class DomainmodelFileConsumer extends NonTerminalConsumer {

	private DomainmodelImportConsumer importConsumer;
	private DomainmodelNamedElementConsumer namedElementConsumer;

	public DomainmodelFileConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		if (consumeNonTerminal(namedElementConsumer, "namedElements", true, false, getRule().ele10ParserRuleCallNamedElement()))
			return true;
		return false;
	}

	public FileElements getRule() {
		return DomainmodelGrammarAccess.INSTANCE.prFile();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "File";
	}
	
	public void setImportConsumer(DomainmodelImportConsumer importConsumer) {
		this.importConsumer = importConsumer;
	}
	
	public void setNamedElementConsumer(DomainmodelNamedElementConsumer namedElementConsumer) {
		this.namedElementConsumer = namedElementConsumer;
	}
	
}
