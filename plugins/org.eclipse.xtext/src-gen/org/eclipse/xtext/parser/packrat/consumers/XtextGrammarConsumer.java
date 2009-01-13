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
import org.eclipse.xtext.services.XtextGrammarAccess.GrammarElements;

import org.eclipse.xtext.parser.packrat.XtextDelimiters;

import org.eclipse.xtext.parser.packrat.consumers.XtextAbstractMetamodelDeclarationConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextAbstractRuleConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class XtextGrammarConsumer extends NonTerminalConsumer {

	private XtextAbstractMetamodelDeclarationConsumer abstractMetamodelDeclarationConsumer;
	private XtextAbstractRuleConsumer abstractRuleConsumer;
	private XtextBuiltinIDConsumer idConsumer;

	public XtextGrammarConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeAlternatives$6()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$10()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$12()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$16()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$25()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$27()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeAlternatives$6() throws Exception {
		if (consumeAssignment$7())
			return true;
		if (consumeKeyword$9())
			return true;
		return false;
	}

	protected boolean consumeAssignment$7() throws Exception {
		if (consumeKeyword(getRule().ele0000000KeywordAbstractLanguage(), "abstract", false, true, XtextDelimiters.ID_DELIMITER))
			return true;
		return false;
	}

	protected boolean consumeKeyword$9() throws Exception {
		return consumeKeyword(getRule().ele000001KeywordLanguage(), null, false, false, XtextDelimiters.ID_DELIMITER);
	}

	protected boolean consumeAssignment$10() throws Exception {
		if (consumeTerminal(idConsumer, "idElements", true, false, getRule().ele000010LexerRuleCallID(), XtextDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeGroup$12() throws Exception {
		while(doConsumeGroup$12()) {}
		return true;
	}

	protected boolean doConsumeGroup$12() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$13()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$14()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$13() throws Exception {
		return consumeKeyword(getRule().ele00010KeywordFullStop(), null, false, false, XtextDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$14() throws Exception {
		if (consumeTerminal(idConsumer, "idElements", true, false, getRule().ele000110LexerRuleCallID(), XtextDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeGroup$16() throws Exception {
		doConsumeGroup$16();
		return true;
	}

	protected boolean doConsumeGroup$16() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$18()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$19()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$21()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$18() throws Exception {
		return consumeKeyword(getRule().ele00100KeywordExtends(), null, false, false, XtextDelimiters.ID_DELIMITER);
	}

	protected boolean consumeAssignment$19() throws Exception {
		if (consumeTerminal(idConsumer, "superGrammarIdElements", true, false, getRule().ele001010LexerRuleCallID(), XtextDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeGroup$21() throws Exception {
		while(doConsumeGroup$21()) {}
		return true;
	}

	protected boolean doConsumeGroup$21() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$22()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$23()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$22() throws Exception {
		return consumeKeyword(getRule().ele00110KeywordFullStop(), null, false, false, XtextDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$23() throws Exception {
		if (consumeTerminal(idConsumer, "superGrammarIdElements", true, false, getRule().ele001110LexerRuleCallID(), XtextDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeAssignment$25() throws Exception {
		while(doConsumeAssignment$25()) {}
		return true;
	}

	protected boolean doConsumeAssignment$25() throws Exception {
		if (consumeNonTerminal(abstractMetamodelDeclarationConsumer, "metamodelDeclarations", true, false, getRule().ele010ParserRuleCallAbstractMetamodelDeclaration()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$27() throws Exception {
		if (doConsumeAssignment$27()) {
			while(doConsumeAssignment$27()) {}
			return true;
		}
		return false;
	}

	protected boolean doConsumeAssignment$27() throws Exception {
		if (consumeNonTerminal(abstractRuleConsumer, "rules", true, false, getRule().ele10ParserRuleCallAbstractRule()))
			return true;
		return false;
	}

	public GrammarElements getRule() {
		return XtextGrammarAccess.INSTANCE.prGrammar();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Grammar";
	}
	
	public void setAbstractMetamodelDeclarationConsumer(XtextAbstractMetamodelDeclarationConsumer abstractMetamodelDeclarationConsumer) {
		this.abstractMetamodelDeclarationConsumer = abstractMetamodelDeclarationConsumer;
	}
	
	public void setAbstractRuleConsumer(XtextAbstractRuleConsumer abstractRuleConsumer) {
		this.abstractRuleConsumer = abstractRuleConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
}
