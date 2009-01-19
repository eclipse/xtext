/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers;

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

import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess.TypeRefElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageIDConsumer;

@SuppressWarnings("unused")
public final class XtextTerminalsTestLanguageTypeRefConsumer extends NonTerminalConsumer {

	private XtextTerminalsTestLanguageIDConsumer idConsumer;

	private ICharacterClass keyword$6$Delimiter;
	
	private ISequenceMatcher crossReference$8$Delimiter;
	
	private ISequenceMatcher crossReference$4$Delimiter;
	
	public XtextTerminalsTestLanguageTypeRefConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$6$Delimiter = ICharacterClass.Factory.nullClass();
		crossReference$8$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		crossReference$4$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeGroup$2()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$7()) {
			marker.rollback();
			return false;
		}
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
			return false;
		}
		if (!consumeKeyword$6()) {
			marker.rollback();
			return false;
		}
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTypeRef();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TypeRef";
	}
	
	public void setIdConsumer(XtextTerminalsTestLanguageIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public ICharacterClass getKeyword$6$Delimiter() {
		return keyword$6$Delimiter;
	}
	
	public void setKeyword$6$Delimiter(ICharacterClass characterClass) {
		keyword$6$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getCrossReference$8$Delimiter() {
		return crossReference$8$Delimiter;
	}
	
	public void setCrossReference$8$Delimiter(ISequenceMatcher matcher) {
		crossReference$8$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getCrossReference$4$Delimiter() {
		return crossReference$4$Delimiter;
	}
	
	public void setCrossReference$4$Delimiter(ISequenceMatcher matcher) {
		crossReference$4$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}
