/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class TestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class EntryRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(1);
		private final Assignment cAssignmentMultiFeature = (Assignment)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallAbstractRule = (RuleCall)cAssignmentMultiFeature.eContents().get(0);
		
		// EntryRule returns Model : ( multiFeature += AbstractRule ) * ;
		public ParserRule getRule() { return rule; }

		// ( multiFeature += AbstractRule ) *
		public Assignment eleAssignmentMultiFeature() { return cAssignmentMultiFeature; }

		// AbstractRule
		public RuleCall ele0ParserRuleCallAbstractRule() { return c0ParserRuleCallAbstractRule; }
	}

	public class AbstractRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(2);
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallChoiceRule = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall c1ParserRuleCallReducibleRule = (RuleCall)cAlternatives.eContents().get(1);
		
		// AbstractRule returns AbstractElement : ChoiceRule | ReducibleRule ;
		public ParserRule getRule() { return rule; }

		// ChoiceRule | ReducibleRule
		public Alternatives eleAlternatives() { return cAlternatives; }

		// ChoiceRule
		public RuleCall ele0ParserRuleCallChoiceRule() { return c0ParserRuleCallChoiceRule; }

		// ReducibleRule
		public RuleCall ele1ParserRuleCallReducibleRule() { return c1ParserRuleCallReducibleRule; }
	}

	public class ChoiceRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(3);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordChoice = (Keyword)c0Group.eContents().get(0);
		private final Assignment c01AssignmentOptionalKeyword = (Assignment)c0Group.eContents().get(1);
		private final Keyword c010KeywordOptional = (Keyword)c01AssignmentOptionalKeyword.eContents().get(0);
		private final Assignment c1AssignmentName = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallID = (RuleCall)c1AssignmentName.eContents().get(0);
		
		// ChoiceRule returns ChoiceElement : 'choice' ( optionalKeyword ?= 'optional' ) ? name = ID ;
		public ParserRule getRule() { return rule; }

		// 'choice' ( optionalKeyword ?= 'optional' ) ? name = ID
		public Group eleGroup() { return cGroup; }

		// 'choice' ( optionalKeyword ?= 'optional' ) ?
		public Group ele0Group() { return c0Group; }

		// 'choice'
		public Keyword ele00KeywordChoice() { return c00KeywordChoice; }

		// ( optionalKeyword ?= 'optional' ) ?
		public Assignment ele01AssignmentOptionalKeyword() { return c01AssignmentOptionalKeyword; }

		// 'optional'
		public Keyword ele010KeywordOptional() { return c010KeywordOptional; }

		// name = ID
		public Assignment ele1AssignmentName() { return c1AssignmentName; }

		// ID
		public RuleCall ele10LexerRuleCallID() { return c10LexerRuleCallID; }
	}

	public class ReducibleRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(4);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordReducible = (Keyword)c0Group.eContents().get(0);
		private final RuleCall c01ParserRuleCallTerminalRule = (RuleCall)c0Group.eContents().get(1);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Action c10ActionReducibleCompositeactionFeature = (Action)c1Group.eContents().get(0);
		private final Assignment c11AssignmentActionFeature = (Assignment)c1Group.eContents().get(1);
		private final RuleCall c110ParserRuleCallTerminalRule = (RuleCall)c11AssignmentActionFeature.eContents().get(0);
		
		// ReducibleRule returns ReducibleElement : 'reducible' TerminalRule ( { current = ReducibleComposite . actionFeature += current } actionFeature += TerminalRule ) ? ;
		public ParserRule getRule() { return rule; }

		// 'reducible' TerminalRule ( { current = ReducibleComposite . actionFeature += current } actionFeature += TerminalRule ) ?
		public Group eleGroup() { return cGroup; }

		// 'reducible' TerminalRule
		public Group ele0Group() { return c0Group; }

		// 'reducible'
		public Keyword ele00KeywordReducible() { return c00KeywordReducible; }

		// TerminalRule
		public RuleCall ele01ParserRuleCallTerminalRule() { return c01ParserRuleCallTerminalRule; }

		// ( { current = ReducibleComposite . actionFeature += current } actionFeature += TerminalRule ) ?
		public Group ele1Group() { return c1Group; }

		// { current = ReducibleComposite . actionFeature += current }
		public Action ele10ActionReducibleCompositeactionFeature() { return c10ActionReducibleCompositeactionFeature; }

		// actionFeature += TerminalRule
		public Assignment ele11AssignmentActionFeature() { return c11AssignmentActionFeature; }

		// TerminalRule
		public RuleCall ele110ParserRuleCallTerminalRule() { return c110ParserRuleCallTerminalRule; }
	}

	public class TerminalRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(5);
		private final Assignment cAssignmentStringFeature = (Assignment)rule.eContents().get(1);
		private final RuleCall c0LexerRuleCallSTRING = (RuleCall)cAssignmentStringFeature.eContents().get(0);
		
		// TerminalRule returns TerminalElement : stringFeature = STRING ;
		public ParserRule getRule() { return rule; }

		// stringFeature = STRING
		public Assignment eleAssignmentStringFeature() { return cAssignmentStringFeature; }

		// STRING
		public RuleCall ele0LexerRuleCallSTRING() { return c0LexerRuleCallSTRING; }
	}
	
	public final static TestLanguageGrammarAccess INSTANCE = new TestLanguageGrammarAccess();

	private static final String TESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/testlanguages/TestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static EntryRuleElements pEntryRule;
	private static AbstractRuleElements pAbstractRule;
	private static ChoiceRuleElements pChoiceRule;
	private static ReducibleRuleElements pReducibleRule;
	private static TerminalRuleElements pTerminalRule;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(TestLanguageGrammarAccess.class.getClassLoader(),TESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;		
	}

	
	// EntryRule returns Model : ( multiFeature += AbstractRule ) * ;
	public EntryRuleElements prEntryRule() {
		return (pEntryRule != null) ? pEntryRule : (pEntryRule = new EntryRuleElements());
	} 

	// AbstractRule returns AbstractElement : ChoiceRule | ReducibleRule ;
	public AbstractRuleElements prAbstractRule() {
		return (pAbstractRule != null) ? pAbstractRule : (pAbstractRule = new AbstractRuleElements());
	} 

	// ChoiceRule returns ChoiceElement : 'choice' ( optionalKeyword ?= 'optional' ) ? name = ID ;
	public ChoiceRuleElements prChoiceRule() {
		return (pChoiceRule != null) ? pChoiceRule : (pChoiceRule = new ChoiceRuleElements());
	} 

	// ReducibleRule returns ReducibleElement : 'reducible' TerminalRule ( { current = ReducibleComposite . actionFeature += current } actionFeature += TerminalRule ) ? ;
	public ReducibleRuleElements prReducibleRule() {
		return (pReducibleRule != null) ? pReducibleRule : (pReducibleRule = new ReducibleRuleElements());
	} 

	// TerminalRule returns TerminalElement : stringFeature = STRING ;
	public TerminalRuleElements prTerminalRule() {
		return (pTerminalRule != null) ? pTerminalRule : (pTerminalRule = new TerminalRuleElements());
	} 
}
