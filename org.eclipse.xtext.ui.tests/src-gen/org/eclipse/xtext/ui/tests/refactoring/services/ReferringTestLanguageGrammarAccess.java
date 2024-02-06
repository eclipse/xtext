/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.services.TerminalsGrammarAccess;
import org.eclipse.xtext.service.AbstractElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class ReferringTestLanguageGrammarAccess extends AbstractElementFinder.AbstractGrammarElementFinder {
	
	public class MainElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.refactoring.ReferringTestLanguage.Main");
		private final Assignment cReferencedAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cReferencedAbstractReferenceParserRuleCall_0 = (RuleCall)cReferencedAssignment.eContents().get(0);
		
		//Main:
		//    referenced+=AbstractReference*;
		@Override public ParserRule getRule() { return rule; }
		
		//referenced+=AbstractReference*
		public Assignment getReferencedAssignment() { return cReferencedAssignment; }
		
		//AbstractReference
		public RuleCall getReferencedAbstractReferenceParserRuleCall_0() { return cReferencedAbstractReferenceParserRuleCall_0; }
	}
	public class AbstractReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.refactoring.ReferringTestLanguage.AbstractReference");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cReferenceParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cReference2ParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//AbstractReference:
		//    Reference | Reference2;
		@Override public ParserRule getRule() { return rule; }
		
		//Reference | Reference2
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//Reference
		public RuleCall getReferenceParserRuleCall_0() { return cReferenceParserRuleCall_0; }
		
		//Reference2
		public RuleCall getReference2ParserRuleCall_1() { return cReference2ParserRuleCall_1; }
	}
	public class ReferenceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.refactoring.ReferringTestLanguage.Reference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cRefKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cReferencedAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cReferencedEObjectCrossReference_1_0 = (CrossReference)cReferencedAssignment_1.eContents().get(0);
		private final RuleCall cReferencedEObjectFQNParserRuleCall_1_0_1 = (RuleCall)cReferencedEObjectCrossReference_1_0.eContents().get(1);
		
		//Reference:
		//    'ref' referenced =[ecore::EObject|FQN];
		@Override public ParserRule getRule() { return rule; }
		
		//'ref' referenced =[ecore::EObject|FQN]
		public Group getGroup() { return cGroup; }
		
		//'ref'
		public Keyword getRefKeyword_0() { return cRefKeyword_0; }
		
		//referenced =[ecore::EObject|FQN]
		public Assignment getReferencedAssignment_1() { return cReferencedAssignment_1; }
		
		//[ecore::EObject|FQN]
		public CrossReference getReferencedEObjectCrossReference_1_0() { return cReferencedEObjectCrossReference_1_0; }
		
		//FQN
		public RuleCall getReferencedEObjectFQNParserRuleCall_1_0_1() { return cReferencedEObjectFQNParserRuleCall_1_0_1; }
	}
	public class Reference2Elements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.refactoring.ReferringTestLanguage.Reference2");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cNamedParserRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Keyword cEqualsSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cReferencedAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cReferencedEObjectCrossReference_2_0 = (CrossReference)cReferencedAssignment_2.eContents().get(0);
		private final RuleCall cReferencedEObjectFQNParserRuleCall_2_0_1 = (RuleCall)cReferencedEObjectCrossReference_2_0.eContents().get(1);
		
		//Reference2:
		//    Named '=' referenced =[ecore::EObject|FQN];
		@Override public ParserRule getRule() { return rule; }
		
		//Named '=' referenced =[ecore::EObject|FQN]
		public Group getGroup() { return cGroup; }
		
		//Named
		public RuleCall getNamedParserRuleCall_0() { return cNamedParserRuleCall_0; }
		
		//'='
		public Keyword getEqualsSignKeyword_1() { return cEqualsSignKeyword_1; }
		
		//referenced =[ecore::EObject|FQN]
		public Assignment getReferencedAssignment_2() { return cReferencedAssignment_2; }
		
		//[ecore::EObject|FQN]
		public CrossReference getReferencedEObjectCrossReference_2_0() { return cReferencedEObjectCrossReference_2_0; }
		
		//FQN
		public RuleCall getReferencedEObjectFQNParserRuleCall_2_0_1() { return cReferencedEObjectFQNParserRuleCall_2_0_1; }
	}
	public class NamedElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.refactoring.ReferringTestLanguage.Named");
		private final Assignment cNameAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_0 = (RuleCall)cNameAssignment.eContents().get(0);
		
		//Named:
		//    name=ID
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//name=ID
		public Assignment getNameAssignment() { return cNameAssignment; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0() { return cNameIDTerminalRuleCall_0; }
	}
	public class FQNElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.refactoring.ReferringTestLanguage.FQN");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall cIDTerminalRuleCall_0 = (RuleCall)cGroup.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final Keyword cFullStopKeyword_1_0 = (Keyword)cGroup_1.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1_1 = (RuleCall)cGroup_1.eContents().get(1);
		
		//FQN:
		//    ID ('.' ID)*;
		@Override public ParserRule getRule() { return rule; }
		
		//ID ('.' ID)*
		public Group getGroup() { return cGroup; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_0() { return cIDTerminalRuleCall_0; }
		
		//('.' ID)*
		public Group getGroup_1() { return cGroup_1; }
		
		//'.'
		public Keyword getFullStopKeyword_1_0() { return cFullStopKeyword_1_0; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_1_1() { return cIDTerminalRuleCall_1_1; }
	}
	
	
	private final MainElements pMain;
	private final AbstractReferenceElements pAbstractReference;
	private final ReferenceElements pReference;
	private final Reference2Elements pReference2;
	private final NamedElements pNamed;
	private final FQNElements pFQN;
	
	private final Grammar grammar;
	
	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public ReferringTestLanguageGrammarAccess(GrammarProvider grammarProvider,
			TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pMain = new MainElements();
		this.pAbstractReference = new AbstractReferenceElements();
		this.pReference = new ReferenceElements();
		this.pReference2 = new Reference2Elements();
		this.pNamed = new NamedElements();
		this.pFQN = new FQNElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.xtext.ui.tests.refactoring.ReferringTestLanguage".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	
	
	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//Main:
	//    referenced+=AbstractReference*;
	public MainElements getMainAccess() {
		return pMain;
	}
	
	public ParserRule getMainRule() {
		return getMainAccess().getRule();
	}
	
	//AbstractReference:
	//    Reference | Reference2;
	public AbstractReferenceElements getAbstractReferenceAccess() {
		return pAbstractReference;
	}
	
	public ParserRule getAbstractReferenceRule() {
		return getAbstractReferenceAccess().getRule();
	}
	
	//Reference:
	//    'ref' referenced =[ecore::EObject|FQN];
	public ReferenceElements getReferenceAccess() {
		return pReference;
	}
	
	public ParserRule getReferenceRule() {
		return getReferenceAccess().getRule();
	}
	
	//Reference2:
	//    Named '=' referenced =[ecore::EObject|FQN];
	public Reference2Elements getReference2Access() {
		return pReference2;
	}
	
	public ParserRule getReference2Rule() {
		return getReference2Access().getRule();
	}
	
	//Named:
	//    name=ID
	//;
	public NamedElements getNamedAccess() {
		return pNamed;
	}
	
	public ParserRule getNamedRule() {
		return getNamedAccess().getRule();
	}
	
	//FQN:
	//    ID ('.' ID)*;
	public FQNElements getFQNAccess() {
		return pFQN;
	}
	
	public ParserRule getFQNRule() {
		return getFQNAccess().getRule();
	}
	
	//terminal ID: '^'?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	}
	
	//terminal INT returns ecore::EInt: ('0'..'9')+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	}
	
	//terminal STRING:
	//            '"' ( '\\' . /* 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' */ | !('\\'|'"') )* '"' |
	//            "'" ( '\\' . /* 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' */ | !('\\'|"'") )* "'"
	//        ;
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	}
	
	//terminal ML_COMMENT : '/*' -> '*/';
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	}
	
	//terminal SL_COMMENT : '//' !('\n'|'\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	}
	
	//terminal WS         : (' '|'\t'|'\r'|'\n')+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	}
	
	//terminal ANY_OTHER: .;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	}
}
