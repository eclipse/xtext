/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class TestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class EntryRuleElements implements IParserRuleAccess {
		private ParserRule rule;
		private Assignment cAssignmentMultiFeature;
		private RuleCall c0ParserRuleCallAbstractRule;
		
		// (error)
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(1)); 
		}

		// ( multiFeature += AbstractRule ) *
		public Assignment eleAssignmentMultiFeature() {
			return (cAssignmentMultiFeature != null) ? cAssignmentMultiFeature : (cAssignmentMultiFeature = (Assignment)getRule().eContents().get(1)); 
		}

		// AbstractRule
		public RuleCall ele0ParserRuleCallAbstractRule() {
			return (c0ParserRuleCallAbstractRule != null) ? c0ParserRuleCallAbstractRule : (c0ParserRuleCallAbstractRule = (RuleCall)eleAssignmentMultiFeature().eContents().get(0)); 
		}
	}

	public class AbstractRuleElements implements IParserRuleAccess {
		private ParserRule rule;
		private Alternatives cAlternatives;
		private RuleCall c0ParserRuleCallChoiceRule;
		private RuleCall c1ParserRuleCallReducibleRule;
		
		// (error)
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(2)); 
		}

		// ChoiceRule | ReducibleRule
		public Alternatives eleAlternatives() {
			return (cAlternatives != null) ? cAlternatives : (cAlternatives = (Alternatives)getRule().eContents().get(1)); 
		}

		// ChoiceRule
		public RuleCall ele0ParserRuleCallChoiceRule() {
			return (c0ParserRuleCallChoiceRule != null) ? c0ParserRuleCallChoiceRule : (c0ParserRuleCallChoiceRule = (RuleCall)eleAlternatives().eContents().get(0)); 
		}

		// ReducibleRule
		public RuleCall ele1ParserRuleCallReducibleRule() {
			return (c1ParserRuleCallReducibleRule != null) ? c1ParserRuleCallReducibleRule : (c1ParserRuleCallReducibleRule = (RuleCall)eleAlternatives().eContents().get(1)); 
		}
	}

	public class ChoiceRuleElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Keyword c00KeywordChoice;
		private Assignment c01AssignmentOptionalKeyword;
		private Keyword c010KeywordOptional;
		private Assignment c1AssignmentName;
		private RuleCall c10LexerRuleCallID;
		
		// (error)
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(3)); 
		}

		// 'choice' ( optionalKeyword ?= 'optional' ) ? name = ID
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(1)); 
		}

		// 'choice' ( optionalKeyword ?= 'optional' ) ?
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'choice'
		public Keyword ele00KeywordChoice() {
			return (c00KeywordChoice != null) ? c00KeywordChoice : (c00KeywordChoice = (Keyword)ele0Group().eContents().get(0)); 
		}

		// ( optionalKeyword ?= 'optional' ) ?
		public Assignment ele01AssignmentOptionalKeyword() {
			return (c01AssignmentOptionalKeyword != null) ? c01AssignmentOptionalKeyword : (c01AssignmentOptionalKeyword = (Assignment)ele0Group().eContents().get(1)); 
		}

		// 'optional'
		public Keyword ele010KeywordOptional() {
			return (c010KeywordOptional != null) ? c010KeywordOptional : (c010KeywordOptional = (Keyword)ele01AssignmentOptionalKeyword().eContents().get(0)); 
		}

		// name = ID
		public Assignment ele1AssignmentName() {
			return (c1AssignmentName != null) ? c1AssignmentName : (c1AssignmentName = (Assignment)eleGroup().eContents().get(1)); 
		}

		// ID
		public RuleCall ele10LexerRuleCallID() {
			return (c10LexerRuleCallID != null) ? c10LexerRuleCallID : (c10LexerRuleCallID = (RuleCall)ele1AssignmentName().eContents().get(0)); 
		}
	}

	public class ReducibleRuleElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Keyword c00KeywordReducible;
		private RuleCall c01ParserRuleCallTerminalRule;
		private Group c1Group;
		private Action c10ActionReducibleCompositeactionFeature;
		private Assignment c11AssignmentActionFeature;
		private RuleCall c110ParserRuleCallTerminalRule;
		
		// (error)
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(4)); 
		}

		// (error)
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(1)); 
		}

		// 'reducible' TerminalRule
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'reducible'
		public Keyword ele00KeywordReducible() {
			return (c00KeywordReducible != null) ? c00KeywordReducible : (c00KeywordReducible = (Keyword)ele0Group().eContents().get(0)); 
		}

		// TerminalRule
		public RuleCall ele01ParserRuleCallTerminalRule() {
			return (c01ParserRuleCallTerminalRule != null) ? c01ParserRuleCallTerminalRule : (c01ParserRuleCallTerminalRule = (RuleCall)ele0Group().eContents().get(1)); 
		}

		// (error)
		public Group ele1Group() {
			return (c1Group != null) ? c1Group : (c1Group = (Group)eleGroup().eContents().get(1)); 
		}

		// (error)
		public Action ele10ActionReducibleCompositeactionFeature() {
			return (c10ActionReducibleCompositeactionFeature != null) ? c10ActionReducibleCompositeactionFeature : (c10ActionReducibleCompositeactionFeature = (Action)ele1Group().eContents().get(0)); 
		}

		// actionFeature += TerminalRule
		public Assignment ele11AssignmentActionFeature() {
			return (c11AssignmentActionFeature != null) ? c11AssignmentActionFeature : (c11AssignmentActionFeature = (Assignment)ele1Group().eContents().get(1)); 
		}

		// TerminalRule
		public RuleCall ele110ParserRuleCallTerminalRule() {
			return (c110ParserRuleCallTerminalRule != null) ? c110ParserRuleCallTerminalRule : (c110ParserRuleCallTerminalRule = (RuleCall)ele11AssignmentActionFeature().eContents().get(0)); 
		}
	}

	public class TerminalRuleElements implements IParserRuleAccess {
		private ParserRule rule;
		private Assignment cAssignmentStringFeature;
		private RuleCall c0LexerRuleCallSTRING;
		
		// (error)
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(5)); 
		}

		// stringFeature = STRING
		public Assignment eleAssignmentStringFeature() {
			return (cAssignmentStringFeature != null) ? cAssignmentStringFeature : (cAssignmentStringFeature = (Assignment)getRule().eContents().get(1)); 
		}

		// STRING
		public RuleCall ele0LexerRuleCallSTRING() {
			return (c0LexerRuleCallSTRING != null) ? c0LexerRuleCallSTRING : (c0LexerRuleCallSTRING = (RuleCall)eleAssignmentStringFeature().eContents().get(0)); 
		}
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

	
	// (error)
	public EntryRuleElements prEntryRule() {
		return (pEntryRule != null) ? pEntryRule : (pEntryRule = new EntryRuleElements());
	} 

	// (error)
	public AbstractRuleElements prAbstractRule() {
		return (pAbstractRule != null) ? pAbstractRule : (pAbstractRule = new AbstractRuleElements());
	} 

	// (error)
	public ChoiceRuleElements prChoiceRule() {
		return (pChoiceRule != null) ? pChoiceRule : (pChoiceRule = new ChoiceRuleElements());
	} 

	// (error)
	public ReducibleRuleElements prReducibleRule() {
		return (pReducibleRule != null) ? pReducibleRule : (pReducibleRule = new ReducibleRuleElements());
	} 

	// (error)
	public TerminalRuleElements prTerminalRule() {
		return (pTerminalRule != null) ? pTerminalRule : (pTerminalRule = new TerminalRuleElements());
	} 
}
