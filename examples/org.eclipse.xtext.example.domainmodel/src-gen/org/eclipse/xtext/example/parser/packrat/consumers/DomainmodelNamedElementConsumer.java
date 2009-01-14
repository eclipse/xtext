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
import org.eclipse.xtext.example.services.DomainmodelGrammarAccess.NamedElementElements;

import org.eclipse.xtext.example.parser.packrat.DomainmodelDelimiters;

import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelPackageConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelTypeConsumer;

@SuppressWarnings("unused")
public final class DomainmodelNamedElementConsumer extends NonTerminalConsumer {

	private DomainmodelPackageConsumer packageConsumer;
	private DomainmodelTypeConsumer typeConsumer;

	public DomainmodelNamedElementConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeAlternatives$1();
	}

	protected boolean consumeAlternatives$1() throws Exception {
		if (consumeRuleCall$2())
			return true;
		if (consumeRuleCall$3())
			return true;
		return false;
	}

	protected boolean consumeRuleCall$2() throws Exception {
		return consumeNonTerminal(packageConsumer, null, false, false, getRule().ele0ParserRuleCallPackage());
	}

	protected boolean consumeRuleCall$3() throws Exception {
		return consumeNonTerminal(typeConsumer, null, false, false, getRule().ele1ParserRuleCallType());
	}

	public NamedElementElements getRule() {
		return DomainmodelGrammarAccess.INSTANCE.prNamedElement();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "NamedElement";
	}
	
	public void setPackageConsumer(DomainmodelPackageConsumer packageConsumer) {
		this.packageConsumer = packageConsumer;
	}
	
	public void setTypeConsumer(DomainmodelTypeConsumer typeConsumer) {
		this.typeConsumer = typeConsumer;
	}
	
}
