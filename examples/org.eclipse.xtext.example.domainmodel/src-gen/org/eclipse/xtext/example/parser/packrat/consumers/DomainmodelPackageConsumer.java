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
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.example.services.DomainmodelGrammarAccess;
import org.eclipse.xtext.example.services.DomainmodelGrammarAccess.PackageElements;

import org.eclipse.xtext.example.parser.packrat.DomainmodelDelimiters;

import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelQualifiedNameConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelNamedElementConsumer;

@SuppressWarnings("unused")
public final class DomainmodelPackageConsumer extends NonTerminalConsumer {

	private DomainmodelQualifiedNameConsumer qualifiedNameConsumer;
	private DomainmodelNamedElementConsumer namedElementConsumer;

	public DomainmodelPackageConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$5()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$6()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$8()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$9()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$11()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$5() throws Exception {
		return consumeKeyword(getRule().ele0000KeywordPackage(), null, false, false, DomainmodelDelimiters.ID_DELIMITER);
	}

	protected boolean consumeAssignment$6() throws Exception {
		if (consumeNonTerminal(qualifiedNameConsumer, "name", false, true, getRule().ele00010ParserRuleCallQualifiedName()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$8() throws Exception {
		return consumeKeyword(getRule().ele001KeywordLeftCurlyBracket(), null, false, false, DomainmodelDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$9() throws Exception {
		while(doConsumeAssignment$9()) {}
		return true;
	}

	protected boolean doConsumeAssignment$9() throws Exception {
		if (consumeNonTerminal(namedElementConsumer, "namedElements", true, false, getRule().ele010ParserRuleCallNamedElement()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightCurlyBracket(), null, false, false, DomainmodelDelimiters.ANY_OTHER_DELIMITER);
	}

	public PackageElements getRule() {
		return DomainmodelGrammarAccess.INSTANCE.prPackage();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Package";
	}
	
	public void setQualifiedNameConsumer(DomainmodelQualifiedNameConsumer qualifiedNameConsumer) {
		this.qualifiedNameConsumer = qualifiedNameConsumer;
	}
	
	public void setNamedElementConsumer(DomainmodelNamedElementConsumer namedElementConsumer) {
		this.namedElementConsumer = namedElementConsumer;
	}
	
}
