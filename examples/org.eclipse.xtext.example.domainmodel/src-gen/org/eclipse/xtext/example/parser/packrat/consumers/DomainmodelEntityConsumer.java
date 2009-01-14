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
import org.eclipse.xtext.example.services.DomainmodelGrammarAccess.EntityElements;

import org.eclipse.xtext.example.parser.packrat.DomainmodelDelimiters;

import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelFeatureConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class DomainmodelEntityConsumer extends NonTerminalConsumer {

	private DomainmodelFeatureConsumer featureConsumer;
	private XtextBuiltinIDConsumer idConsumer;

	public DomainmodelEntityConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$6()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$7()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$9()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$14()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$15()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$17()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$6() throws Exception {
		return consumeKeyword(getRule().ele00000KeywordEntity(), null, false, false, DomainmodelDelimiters.ID_DELIMITER);
	}

	protected boolean consumeAssignment$7() throws Exception {
		if (consumeTerminal(idConsumer, "name", false, false, getRule().ele000010LexerRuleCallID(), DomainmodelDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeGroup$9() throws Exception {
		doConsumeGroup$9();
		return true;
	}

	protected boolean doConsumeGroup$9() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$10()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$11()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$10() throws Exception {
		return consumeKeyword(getRule().ele00010KeywordExtends(), null, false, false, DomainmodelDelimiters.ID_DELIMITER);
	}

	protected boolean consumeAssignment$11() throws Exception {
		if (consumeTerminal(idConsumer, null, false, false, getRule().ele000110CrossReferenceEStringEntity(), DomainmodelDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeKeyword$14() throws Exception {
		return consumeKeyword(getRule().ele001KeywordLeftCurlyBracket(), null, false, false, DomainmodelDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$15() throws Exception {
		while(doConsumeAssignment$15()) {}
		return true;
	}

	protected boolean doConsumeAssignment$15() throws Exception {
		if (consumeNonTerminal(featureConsumer, "features", true, false, getRule().ele010ParserRuleCallFeature()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$17() throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightCurlyBracket(), null, false, false, DomainmodelDelimiters.ANY_OTHER_DELIMITER);
	}

	public EntityElements getRule() {
		return DomainmodelGrammarAccess.INSTANCE.prEntity();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Entity";
	}
	
	public void setFeatureConsumer(DomainmodelFeatureConsumer featureConsumer) {
		this.featureConsumer = featureConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
}
