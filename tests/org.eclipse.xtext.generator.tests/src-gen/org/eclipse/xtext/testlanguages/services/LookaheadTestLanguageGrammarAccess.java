/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class LookaheadTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class EntryElements implements IParserRuleAccess {
		private ParserRule rule;
		private Assignment cAssignmentContents;
		private RuleCall c0ParserRuleCallAlts;
		
		// Entry : ( contents += Alts ) * ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(1)); 
		}

		// ( contents += Alts ) *
		public Assignment eleAssignmentContents() {
			return (cAssignmentContents != null) ? cAssignmentContents : (cAssignmentContents = (Assignment)getRule().eContents().get(1)); 
		}

		// Alts
		public RuleCall ele0ParserRuleCallAlts() {
			return (c0ParserRuleCallAlts != null) ? c0ParserRuleCallAlts : (c0ParserRuleCallAlts = (RuleCall)eleAssignmentContents().eContents().get(0)); 
		}
	}

	public class AltsElements implements IParserRuleAccess {
		private ParserRule rule;
		private Alternatives cAlternatives;
		private Alternatives c0Alternatives;
		private RuleCall c00ParserRuleCallLookAhead0;
		private RuleCall c01ParserRuleCallLookAhead1;
		private RuleCall c1ParserRuleCallLookAhead3;
		
		// Alts : LookAhead0 | LookAhead1 | LookAhead3 ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(2)); 
		}

		// LookAhead0 | LookAhead1 | LookAhead3
		public Alternatives eleAlternatives() {
			return (cAlternatives != null) ? cAlternatives : (cAlternatives = (Alternatives)getRule().eContents().get(1)); 
		}

		// LookAhead0 | LookAhead1
		public Alternatives ele0Alternatives() {
			return (c0Alternatives != null) ? c0Alternatives : (c0Alternatives = (Alternatives)eleAlternatives().eContents().get(0)); 
		}

		// LookAhead0
		public RuleCall ele00ParserRuleCallLookAhead0() {
			return (c00ParserRuleCallLookAhead0 != null) ? c00ParserRuleCallLookAhead0 : (c00ParserRuleCallLookAhead0 = (RuleCall)ele0Alternatives().eContents().get(0)); 
		}

		// LookAhead1
		public RuleCall ele01ParserRuleCallLookAhead1() {
			return (c01ParserRuleCallLookAhead1 != null) ? c01ParserRuleCallLookAhead1 : (c01ParserRuleCallLookAhead1 = (RuleCall)ele0Alternatives().eContents().get(1)); 
		}

		// LookAhead3
		public RuleCall ele1ParserRuleCallLookAhead3() {
			return (c1ParserRuleCallLookAhead3 != null) ? c1ParserRuleCallLookAhead3 : (c1ParserRuleCallLookAhead3 = (RuleCall)eleAlternatives().eContents().get(1)); 
		}
	}

	public class LookAhead0Elements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Keyword c0KeywordBar;
		private Assignment c1AssignmentX;
		private Keyword c10KeywordA;
		
		// LookAhead0 : 'bar' x = 'a' ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(3)); 
		}

		// 'bar' x = 'a'
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(1)); 
		}

		// 'bar'
		public Keyword ele0KeywordBar() {
			return (c0KeywordBar != null) ? c0KeywordBar : (c0KeywordBar = (Keyword)eleGroup().eContents().get(0)); 
		}

		// x = 'a'
		public Assignment ele1AssignmentX() {
			return (c1AssignmentX != null) ? c1AssignmentX : (c1AssignmentX = (Assignment)eleGroup().eContents().get(1)); 
		}

		// 'a'
		public Keyword ele10KeywordA() {
			return (c10KeywordA != null) ? c10KeywordA : (c10KeywordA = (Keyword)ele1AssignmentX().eContents().get(0)); 
		}
	}

	public class LookAhead1Elements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Keyword c000KeywordFoo;
		private Assignment c001AssignmentY;
		private RuleCall c0010ParserRuleCallLookAhead2;
		private Assignment c01AssignmentX;
		private Keyword c010KeywordB;
		private Assignment c1AssignmentX;
		private Keyword c10KeywordD;
		
		// LookAhead1 : 'foo' y = LookAhead2 x = 'b' x = 'd' ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(4)); 
		}

		// 'foo' y = LookAhead2 x = 'b' x = 'd'
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(1)); 
		}

		// 'foo' y = LookAhead2 x = 'b'
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'foo' y = LookAhead2
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// 'foo'
		public Keyword ele000KeywordFoo() {
			return (c000KeywordFoo != null) ? c000KeywordFoo : (c000KeywordFoo = (Keyword)ele00Group().eContents().get(0)); 
		}

		// y = LookAhead2
		public Assignment ele001AssignmentY() {
			return (c001AssignmentY != null) ? c001AssignmentY : (c001AssignmentY = (Assignment)ele00Group().eContents().get(1)); 
		}

		// LookAhead2
		public RuleCall ele0010ParserRuleCallLookAhead2() {
			return (c0010ParserRuleCallLookAhead2 != null) ? c0010ParserRuleCallLookAhead2 : (c0010ParserRuleCallLookAhead2 = (RuleCall)ele001AssignmentY().eContents().get(0)); 
		}

		// x = 'b'
		public Assignment ele01AssignmentX() {
			return (c01AssignmentX != null) ? c01AssignmentX : (c01AssignmentX = (Assignment)ele0Group().eContents().get(1)); 
		}

		// 'b'
		public Keyword ele010KeywordB() {
			return (c010KeywordB != null) ? c010KeywordB : (c010KeywordB = (Keyword)ele01AssignmentX().eContents().get(0)); 
		}

		// x = 'd'
		public Assignment ele1AssignmentX() {
			return (c1AssignmentX != null) ? c1AssignmentX : (c1AssignmentX = (Assignment)eleGroup().eContents().get(1)); 
		}

		// 'd'
		public Keyword ele10KeywordD() {
			return (c10KeywordD != null) ? c10KeywordD : (c10KeywordD = (Keyword)ele1AssignmentX().eContents().get(0)); 
		}
	}

	public class LookAhead2Elements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Alternatives c0Alternatives;
		private Assignment c00AssignmentZ;
		private Keyword c000KeywordFoo;
		private Assignment c01AssignmentZ;
		private Keyword c010KeywordBar;
		private Keyword c1KeywordC;
		
		// LookAhead2 : ( z = 'foo' | z = 'bar' ) 'c' ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(5)); 
		}

		// ( z = 'foo' | z = 'bar' ) 'c'
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(1)); 
		}

		// z = 'foo' | z = 'bar'
		public Alternatives ele0Alternatives() {
			return (c0Alternatives != null) ? c0Alternatives : (c0Alternatives = (Alternatives)eleGroup().eContents().get(0)); 
		}

		// z = 'foo'
		public Assignment ele00AssignmentZ() {
			return (c00AssignmentZ != null) ? c00AssignmentZ : (c00AssignmentZ = (Assignment)ele0Alternatives().eContents().get(0)); 
		}

		// 'foo'
		public Keyword ele000KeywordFoo() {
			return (c000KeywordFoo != null) ? c000KeywordFoo : (c000KeywordFoo = (Keyword)ele00AssignmentZ().eContents().get(0)); 
		}

		// z = 'bar'
		public Assignment ele01AssignmentZ() {
			return (c01AssignmentZ != null) ? c01AssignmentZ : (c01AssignmentZ = (Assignment)ele0Alternatives().eContents().get(1)); 
		}

		// 'bar'
		public Keyword ele010KeywordBar() {
			return (c010KeywordBar != null) ? c010KeywordBar : (c010KeywordBar = (Keyword)ele01AssignmentZ().eContents().get(0)); 
		}

		// 'c'
		public Keyword ele1KeywordC() {
			return (c1KeywordC != null) ? c1KeywordC : (c1KeywordC = (Keyword)eleGroup().eContents().get(1)); 
		}
	}

	public class LookAhead3Elements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Keyword c000KeywordFoo;
		private Keyword c001KeywordBar;
		private Assignment c01AssignmentX;
		private Keyword c010KeywordB;
		private Assignment c1AssignmentZ;
		private RuleCall c10ParserRuleCallLookAhead4;
		
		// LookAhead3 : 'foo' 'bar' x = 'b' z = LookAhead4 ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(6)); 
		}

		// 'foo' 'bar' x = 'b' z = LookAhead4
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(1)); 
		}

		// 'foo' 'bar' x = 'b'
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'foo' 'bar'
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// 'foo'
		public Keyword ele000KeywordFoo() {
			return (c000KeywordFoo != null) ? c000KeywordFoo : (c000KeywordFoo = (Keyword)ele00Group().eContents().get(0)); 
		}

		// 'bar'
		public Keyword ele001KeywordBar() {
			return (c001KeywordBar != null) ? c001KeywordBar : (c001KeywordBar = (Keyword)ele00Group().eContents().get(1)); 
		}

		// x = 'b'
		public Assignment ele01AssignmentX() {
			return (c01AssignmentX != null) ? c01AssignmentX : (c01AssignmentX = (Assignment)ele0Group().eContents().get(1)); 
		}

		// 'b'
		public Keyword ele010KeywordB() {
			return (c010KeywordB != null) ? c010KeywordB : (c010KeywordB = (Keyword)ele01AssignmentX().eContents().get(0)); 
		}

		// z = LookAhead4
		public Assignment ele1AssignmentZ() {
			return (c1AssignmentZ != null) ? c1AssignmentZ : (c1AssignmentZ = (Assignment)eleGroup().eContents().get(1)); 
		}

		// LookAhead4
		public RuleCall ele10ParserRuleCallLookAhead4() {
			return (c10ParserRuleCallLookAhead4 != null) ? c10ParserRuleCallLookAhead4 : (c10ParserRuleCallLookAhead4 = (RuleCall)ele1AssignmentZ().eContents().get(0)); 
		}
	}

	public class LookAhead4Elements implements IParserRuleAccess {
		private ParserRule rule;
		private Alternatives cAlternatives;
		private Assignment c0AssignmentX;
		private Keyword c00KeywordC;
		private Assignment c1AssignmentX;
		private Keyword c10KeywordD;
		
		// LookAhead4 : x = 'c' | x = 'd' ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(7)); 
		}

		// x = 'c' | x = 'd'
		public Alternatives eleAlternatives() {
			return (cAlternatives != null) ? cAlternatives : (cAlternatives = (Alternatives)getRule().eContents().get(1)); 
		}

		// x = 'c'
		public Assignment ele0AssignmentX() {
			return (c0AssignmentX != null) ? c0AssignmentX : (c0AssignmentX = (Assignment)eleAlternatives().eContents().get(0)); 
		}

		// 'c'
		public Keyword ele00KeywordC() {
			return (c00KeywordC != null) ? c00KeywordC : (c00KeywordC = (Keyword)ele0AssignmentX().eContents().get(0)); 
		}

		// x = 'd'
		public Assignment ele1AssignmentX() {
			return (c1AssignmentX != null) ? c1AssignmentX : (c1AssignmentX = (Assignment)eleAlternatives().eContents().get(1)); 
		}

		// 'd'
		public Keyword ele10KeywordD() {
			return (c10KeywordD != null) ? c10KeywordD : (c10KeywordD = (Keyword)ele1AssignmentX().eContents().get(0)); 
		}
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

	// LookAhead0 : 'bar' x = 'a' ;
	public LookAhead0Elements prLookAhead0() {
		return (pLookAhead0 != null) ? pLookAhead0 : (pLookAhead0 = new LookAhead0Elements());
	} 

	// LookAhead1 : 'foo' y = LookAhead2 x = 'b' x = 'd' ;
	public LookAhead1Elements prLookAhead1() {
		return (pLookAhead1 != null) ? pLookAhead1 : (pLookAhead1 = new LookAhead1Elements());
	} 

	// LookAhead2 : ( z = 'foo' | z = 'bar' ) 'c' ;
	public LookAhead2Elements prLookAhead2() {
		return (pLookAhead2 != null) ? pLookAhead2 : (pLookAhead2 = new LookAhead2Elements());
	} 

	// LookAhead3 : 'foo' 'bar' x = 'b' z = LookAhead4 ;
	public LookAhead3Elements prLookAhead3() {
		return (pLookAhead3 != null) ? pLookAhead3 : (pLookAhead3 = new LookAhead3Elements());
	} 

	// LookAhead4 : x = 'c' | x = 'd' ;
	public LookAhead4Elements prLookAhead4() {
		return (pLookAhead4 != null) ? pLookAhead4 : (pLookAhead4 = new LookAhead4Elements());
	} 
}
