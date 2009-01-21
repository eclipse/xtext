/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class LookaheadTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class EntryElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(1);
		private final Assignment cAssignmentContents = (Assignment)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallAlts = (RuleCall)cAssignmentContents.eContents().get(0);
		
		// Entry : ( contents += Alts ) * ;
		public ParserRule getRule() { return rule; }

		// ( contents += Alts ) *
		public Assignment eleAssignmentContents() { return cAssignmentContents; }

		// Alts
		public RuleCall ele0ParserRuleCallAlts() { return c0ParserRuleCallAlts; }
	}

	public class AltsElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(2);
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Alternatives c0Alternatives = (Alternatives)cAlternatives.eContents().get(0);
		private final RuleCall c00ParserRuleCallLookAhead0 = (RuleCall)c0Alternatives.eContents().get(0);
		private final RuleCall c01ParserRuleCallLookAhead1 = (RuleCall)c0Alternatives.eContents().get(1);
		private final RuleCall c1ParserRuleCallLookAhead3 = (RuleCall)cAlternatives.eContents().get(1);
		
		// Alts : LookAhead0 | LookAhead1 | LookAhead3 ;
		public ParserRule getRule() { return rule; }

		// LookAhead0 | LookAhead1 | LookAhead3
		public Alternatives eleAlternatives() { return cAlternatives; }

		// LookAhead0 | LookAhead1
		public Alternatives ele0Alternatives() { return c0Alternatives; }

		// LookAhead0
		public RuleCall ele00ParserRuleCallLookAhead0() { return c00ParserRuleCallLookAhead0; }

		// LookAhead1
		public RuleCall ele01ParserRuleCallLookAhead1() { return c01ParserRuleCallLookAhead1; }

		// LookAhead3
		public RuleCall ele1ParserRuleCallLookAhead3() { return c1ParserRuleCallLookAhead3; }
	}

	public class LookAhead0Elements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(3);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordBar = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentX = (Assignment)cGroup.eContents().get(1);
		private final Keyword c10KeywordA = (Keyword)c1AssignmentX.eContents().get(0);
		
		// LookAhead0 : "bar" x = "a" ;
		public ParserRule getRule() { return rule; }

		// "bar" x = "a"
		public Group eleGroup() { return cGroup; }

		// "bar"
		public Keyword ele0KeywordBar() { return c0KeywordBar; }

		// x = "a"
		public Assignment ele1AssignmentX() { return c1AssignmentX; }

		// "a"
		public Keyword ele10KeywordA() { return c10KeywordA; }
	}

	public class LookAhead1Elements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(4);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordFoo = (Keyword)c00Group.eContents().get(0);
		private final Assignment c001AssignmentY = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010ParserRuleCallLookAhead2 = (RuleCall)c001AssignmentY.eContents().get(0);
		private final Assignment c01AssignmentX = (Assignment)c0Group.eContents().get(1);
		private final Keyword c010KeywordB = (Keyword)c01AssignmentX.eContents().get(0);
		private final Assignment c1AssignmentX = (Assignment)cGroup.eContents().get(1);
		private final Keyword c10KeywordD = (Keyword)c1AssignmentX.eContents().get(0);
		
		// LookAhead1 : "foo" y = LookAhead2 x = "b" x = "d" ;
		public ParserRule getRule() { return rule; }

		// "foo" y = LookAhead2 x = "b" x = "d"
		public Group eleGroup() { return cGroup; }

		// "foo" y = LookAhead2 x = "b"
		public Group ele0Group() { return c0Group; }

		// "foo" y = LookAhead2
		public Group ele00Group() { return c00Group; }

		// "foo"
		public Keyword ele000KeywordFoo() { return c000KeywordFoo; }

		// y = LookAhead2
		public Assignment ele001AssignmentY() { return c001AssignmentY; }

		// LookAhead2
		public RuleCall ele0010ParserRuleCallLookAhead2() { return c0010ParserRuleCallLookAhead2; }

		// x = "b"
		public Assignment ele01AssignmentX() { return c01AssignmentX; }

		// "b"
		public Keyword ele010KeywordB() { return c010KeywordB; }

		// x = "d"
		public Assignment ele1AssignmentX() { return c1AssignmentX; }

		// "d"
		public Keyword ele10KeywordD() { return c10KeywordD; }
	}

	public class LookAhead2Elements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(5);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives c0Alternatives = (Alternatives)cGroup.eContents().get(0);
		private final Assignment c00AssignmentZ = (Assignment)c0Alternatives.eContents().get(0);
		private final Keyword c000KeywordFoo = (Keyword)c00AssignmentZ.eContents().get(0);
		private final Assignment c01AssignmentZ = (Assignment)c0Alternatives.eContents().get(1);
		private final Keyword c010KeywordBar = (Keyword)c01AssignmentZ.eContents().get(0);
		private final Keyword c1KeywordC = (Keyword)cGroup.eContents().get(1);
		
		// LookAhead2 : ( z = "foo" | z = "bar" ) "c" ;
		public ParserRule getRule() { return rule; }

		// ( z = "foo" | z = "bar" ) "c"
		public Group eleGroup() { return cGroup; }

		// z = "foo" | z = "bar"
		public Alternatives ele0Alternatives() { return c0Alternatives; }

		// z = "foo"
		public Assignment ele00AssignmentZ() { return c00AssignmentZ; }

		// "foo"
		public Keyword ele000KeywordFoo() { return c000KeywordFoo; }

		// z = "bar"
		public Assignment ele01AssignmentZ() { return c01AssignmentZ; }

		// "bar"
		public Keyword ele010KeywordBar() { return c010KeywordBar; }

		// "c"
		public Keyword ele1KeywordC() { return c1KeywordC; }
	}

	public class LookAhead3Elements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(6);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordFoo = (Keyword)c00Group.eContents().get(0);
		private final Keyword c001KeywordBar = (Keyword)c00Group.eContents().get(1);
		private final Assignment c01AssignmentX = (Assignment)c0Group.eContents().get(1);
		private final Keyword c010KeywordB = (Keyword)c01AssignmentX.eContents().get(0);
		private final Assignment c1AssignmentZ = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10ParserRuleCallLookAhead4 = (RuleCall)c1AssignmentZ.eContents().get(0);
		
		// LookAhead3 : "foo" "bar" x = "b" z = LookAhead4 ;
		public ParserRule getRule() { return rule; }

		// "foo" "bar" x = "b" z = LookAhead4
		public Group eleGroup() { return cGroup; }

		// "foo" "bar" x = "b"
		public Group ele0Group() { return c0Group; }

		// "foo" "bar"
		public Group ele00Group() { return c00Group; }

		// "foo"
		public Keyword ele000KeywordFoo() { return c000KeywordFoo; }

		// "bar"
		public Keyword ele001KeywordBar() { return c001KeywordBar; }

		// x = "b"
		public Assignment ele01AssignmentX() { return c01AssignmentX; }

		// "b"
		public Keyword ele010KeywordB() { return c010KeywordB; }

		// z = LookAhead4
		public Assignment ele1AssignmentZ() { return c1AssignmentZ; }

		// LookAhead4
		public RuleCall ele10ParserRuleCallLookAhead4() { return c10ParserRuleCallLookAhead4; }
	}

	public class LookAhead4Elements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(7);
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment c0AssignmentX = (Assignment)cAlternatives.eContents().get(0);
		private final Keyword c00KeywordC = (Keyword)c0AssignmentX.eContents().get(0);
		private final Assignment c1AssignmentX = (Assignment)cAlternatives.eContents().get(1);
		private final Keyword c10KeywordD = (Keyword)c1AssignmentX.eContents().get(0);
		
		// LookAhead4 : x = "c" | x = "d" ;
		public ParserRule getRule() { return rule; }

		// x = "c" | x = "d"
		public Alternatives eleAlternatives() { return cAlternatives; }

		// x = "c"
		public Assignment ele0AssignmentX() { return c0AssignmentX; }

		// "c"
		public Keyword ele00KeywordC() { return c00KeywordC; }

		// x = "d"
		public Assignment ele1AssignmentX() { return c1AssignmentX; }

		// "d"
		public Keyword ele10KeywordD() { return c10KeywordD; }
	}
	
	public final static LookaheadTestLanguageGrammarAccess INSTANCE = new LookaheadTestLanguageGrammarAccess();

	private static final String LOOKAHEADTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/testlanguages/LookaheadTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static EntryElements pEntry;
	private static AltsElements pAlts;
	private static LookAhead0Elements pLookAhead0;
	private static LookAhead1Elements pLookAhead1;
	private static LookAhead2Elements pLookAhead2;
	private static LookAhead3Elements pLookAhead3;
	private static LookAhead4Elements pLookAhead4;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(LookaheadTestLanguageGrammarAccess.class.getClassLoader(),LOOKAHEADTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;
	}

	
	// Entry : ( contents += Alts ) * ;
	public EntryElements prEntry() {
		return (pEntry != null) ? pEntry : (pEntry = new EntryElements());
	} 

	// Alts : LookAhead0 | LookAhead1 | LookAhead3 ;
	public AltsElements prAlts() {
		return (pAlts != null) ? pAlts : (pAlts = new AltsElements());
	} 

	// LookAhead0 : "bar" x = "a" ;
	public LookAhead0Elements prLookAhead0() {
		return (pLookAhead0 != null) ? pLookAhead0 : (pLookAhead0 = new LookAhead0Elements());
	} 

	// LookAhead1 : "foo" y = LookAhead2 x = "b" x = "d" ;
	public LookAhead1Elements prLookAhead1() {
		return (pLookAhead1 != null) ? pLookAhead1 : (pLookAhead1 = new LookAhead1Elements());
	} 

	// LookAhead2 : ( z = "foo" | z = "bar" ) "c" ;
	public LookAhead2Elements prLookAhead2() {
		return (pLookAhead2 != null) ? pLookAhead2 : (pLookAhead2 = new LookAhead2Elements());
	} 

	// LookAhead3 : "foo" "bar" x = "b" z = LookAhead4 ;
	public LookAhead3Elements prLookAhead3() {
		return (pLookAhead3 != null) ? pLookAhead3 : (pLookAhead3 = new LookAhead3Elements());
	} 

	// LookAhead4 : x = "c" | x = "d" ;
	public LookAhead4Elements prLookAhead4() {
		return (pLookAhead4 != null) ? pLookAhead4 : (pLookAhead4 = new LookAhead4Elements());
	} 
}
