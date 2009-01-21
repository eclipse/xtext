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
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.TypeRefElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class XtextGrammarTestLanguageTypeRefConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;

	private ISequenceMatcher crossReference$4$Delimiter;
	
	private ISequenceMatcher crossReference$8$Delimiter;
	
	private ICharacterClass keyword$6$Delimiter;
	
	public XtextGrammarTestLanguageTypeRefConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		crossReference$4$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		crossReference$8$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		keyword$6$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeGroup$2()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeAssignment$7()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}

	protected boolean consumeGroup$2() throws Exception {
		doConsumeGroup$2();
		return true;
	}

	protected boolean doConsumeGroup$2() throws Exception {
		final IMarker marker = mark();
		if (!consumeAssignment$3()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeKeyword$6()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}

	protected boolean consumeAssignment$3() throws Exception {
		if (consumeTerminal(idConsumer, null, false, false, getRule().ele000CrossReferenceEStringAbstractMetamodelDeclaration(), getCrossReference$4$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$6() throws Exception {
		return consumeKeyword(getRule().ele01KeywordColonColon(), null, false, false, getKeyword$6$Delimiter());
	}

	protected boolean consumeAssignment$7() throws Exception {
		if (consumeTerminal(idConsumer, null, false, false, getRule().ele10CrossReferenceEStringEClassifier(), getCrossReference$8$Delimiter()))
			return true;
		return false;
	}

	public TypeRefElements getRule() {
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prTypeRef();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TypeRef";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public ISequenceMatcher getCrossReference$4$Delimiter() {
		return crossReference$4$Delimiter;
	}
	
	public void setCrossReference$4$Delimiter(ISequenceMatcher matcher) {
		crossReference$4$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getCrossReference$8$Delimiter() {
		return crossReference$8$Delimiter;
	}
	
	public void setCrossReference$8$Delimiter(ISequenceMatcher matcher) {
		crossReference$8$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ICharacterClass getKeyword$6$Delimiter() {
		return keyword$6$Delimiter;
	}
	
	public void setKeyword$6$Delimiter(ICharacterClass characterClass) {
		keyword$6$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}
