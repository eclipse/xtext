/*
Generated with Xtext
*/

package org.eclipse.xtext.parsetree.transientvalues.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class TransientValuesTestGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class RootElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Keyword c0KeywordTest;
		private Alternatives c1Alternatives;
		private Alternatives c10Alternatives;
		private RuleCall c100ParserRuleCallTestRequired;
		private RuleCall c101ParserRuleCallTestOptional;
		private RuleCall c11ParserRuleCallTestList;
		
		// Root : 'test' ( TestRequired | TestOptional | TestList ) ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(1)); 
		}

		// 'test' ( TestRequired | TestOptional | TestList )
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// 'test'
		public Keyword ele0KeywordTest() {
			return (c0KeywordTest != null) ? c0KeywordTest : (c0KeywordTest = (Keyword)eleGroup().eContents().get(0)); 
		}

		// TestRequired | TestOptional | TestList
		public Alternatives ele1Alternatives() {
			return (c1Alternatives != null) ? c1Alternatives : (c1Alternatives = (Alternatives)eleGroup().eContents().get(1)); 
		}

		// TestRequired | TestOptional
		public Alternatives ele10Alternatives() {
			return (c10Alternatives != null) ? c10Alternatives : (c10Alternatives = (Alternatives)ele1Alternatives().eContents().get(0)); 
		}

		// TestRequired
		public RuleCall ele100ParserRuleCallTestRequired() {
			return (c100ParserRuleCallTestRequired != null) ? c100ParserRuleCallTestRequired : (c100ParserRuleCallTestRequired = (RuleCall)ele10Alternatives().eContents().get(0)); 
		}

		// TestOptional
		public RuleCall ele101ParserRuleCallTestOptional() {
			return (c101ParserRuleCallTestOptional != null) ? c101ParserRuleCallTestOptional : (c101ParserRuleCallTestOptional = (RuleCall)ele10Alternatives().eContents().get(1)); 
		}

		// TestList
		public RuleCall ele11ParserRuleCallTestList() {
			return (c11ParserRuleCallTestList != null) ? c11ParserRuleCallTestList : (c11ParserRuleCallTestList = (RuleCall)ele1Alternatives().eContents().get(1)); 
		}
	}

	public class TestRequiredElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Keyword c00KeywordRequired;
		private Assignment c01AssignmentRequired1;
		private RuleCall c010LexerRuleCallINT;
		private Assignment c1AssignmentRequired2;
		private RuleCall c10LexerRuleCallINT;
		
		// TestRequired : 'required' required1 = INT required2 = INT ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(2)); 
		}

		// 'required' required1 = INT required2 = INT
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// 'required' required1 = INT
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'required'
		public Keyword ele00KeywordRequired() {
			return (c00KeywordRequired != null) ? c00KeywordRequired : (c00KeywordRequired = (Keyword)ele0Group().eContents().get(0)); 
		}

		// required1 = INT
		public Assignment ele01AssignmentRequired1() {
			return (c01AssignmentRequired1 != null) ? c01AssignmentRequired1 : (c01AssignmentRequired1 = (Assignment)ele0Group().eContents().get(1)); 
		}

		// INT
		public RuleCall ele010LexerRuleCallINT() {
			return (c010LexerRuleCallINT != null) ? c010LexerRuleCallINT : (c010LexerRuleCallINT = (RuleCall)ele01AssignmentRequired1().eContents().get(0)); 
		}

		// required2 = INT
		public Assignment ele1AssignmentRequired2() {
			return (c1AssignmentRequired2 != null) ? c1AssignmentRequired2 : (c1AssignmentRequired2 = (Assignment)eleGroup().eContents().get(1)); 
		}

		// INT
		public RuleCall ele10LexerRuleCallINT() {
			return (c10LexerRuleCallINT != null) ? c10LexerRuleCallINT : (c10LexerRuleCallINT = (RuleCall)ele1AssignmentRequired2().eContents().get(0)); 
		}
	}

	public class TestOptionalElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Keyword c00KeywordOptional;
		private Assignment c01AssignmentOpt1;
		private RuleCall c010LexerRuleCallINT;
		private Group c1Group;
		private Keyword c10Keyword;
		private Assignment c11AssignmentOpt2;
		private RuleCall c110LexerRuleCallINT;
		
		// TestOptional : 'optional' ( opt1 = INT ) ? ( ':' opt2 = INT ) ? ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(3)); 
		}

		// 'optional' ( opt1 = INT ) ? ( ':' opt2 = INT ) ?
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// 'optional' ( opt1 = INT ) ?
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'optional'
		public Keyword ele00KeywordOptional() {
			return (c00KeywordOptional != null) ? c00KeywordOptional : (c00KeywordOptional = (Keyword)ele0Group().eContents().get(0)); 
		}

		// ( opt1 = INT ) ?
		public Assignment ele01AssignmentOpt1() {
			return (c01AssignmentOpt1 != null) ? c01AssignmentOpt1 : (c01AssignmentOpt1 = (Assignment)ele0Group().eContents().get(1)); 
		}

		// INT
		public RuleCall ele010LexerRuleCallINT() {
			return (c010LexerRuleCallINT != null) ? c010LexerRuleCallINT : (c010LexerRuleCallINT = (RuleCall)ele01AssignmentOpt1().eContents().get(0)); 
		}

		// ( ':' opt2 = INT ) ?
		public Group ele1Group() {
			return (c1Group != null) ? c1Group : (c1Group = (Group)eleGroup().eContents().get(1)); 
		}

		// ':'
		public Keyword ele10Keyword() {
			return (c10Keyword != null) ? c10Keyword : (c10Keyword = (Keyword)ele1Group().eContents().get(0)); 
		}

		// opt2 = INT
		public Assignment ele11AssignmentOpt2() {
			return (c11AssignmentOpt2 != null) ? c11AssignmentOpt2 : (c11AssignmentOpt2 = (Assignment)ele1Group().eContents().get(1)); 
		}

		// INT
		public RuleCall ele110LexerRuleCallINT() {
			return (c110LexerRuleCallINT != null) ? c110LexerRuleCallINT : (c110LexerRuleCallINT = (RuleCall)ele11AssignmentOpt2().eContents().get(0)); 
		}
	}

	public class TestListElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Keyword c0KeywordList;
		private Assignment c1AssignmentItem;
		private RuleCall c10LexerRuleCallINT;
		
		// TestList : 'list' ( item += INT ) * ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(4)); 
		}

		// 'list' ( item += INT ) *
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// 'list'
		public Keyword ele0KeywordList() {
			return (c0KeywordList != null) ? c0KeywordList : (c0KeywordList = (Keyword)eleGroup().eContents().get(0)); 
		}

		// ( item += INT ) *
		public Assignment ele1AssignmentItem() {
			return (c1AssignmentItem != null) ? c1AssignmentItem : (c1AssignmentItem = (Assignment)eleGroup().eContents().get(1)); 
		}

		// INT
		public RuleCall ele10LexerRuleCallINT() {
			return (c10LexerRuleCallINT != null) ? c10LexerRuleCallINT : (c10LexerRuleCallINT = (RuleCall)ele1AssignmentItem().eContents().get(0)); 
		}
	}
	
	public final static TransientValuesTestGrammarAccess INSTANCE = new TransientValuesTestGrammarAccess();

	private static final String TRANSIENTVALUESTEST_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/parsetree/transientvalues/TransientValuesTest.xmi";
	private static Grammar GRAMMAR = null;
	private static RootElements pRoot;
	private static TestRequiredElements pTestRequired;
	private static TestOptionalElements pTestOptional;
	private static TestListElements pTestList;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(TransientValuesTestGrammarAccess.class.getClassLoader(),TRANSIENTVALUESTEST_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;		
	}

	
	// Root : 'test' ( TestRequired | TestOptional | TestList ) ;
	public RootElements prRoot() {
		return (pRoot != null) ? pRoot : (pRoot = new RootElements());
	} 

	// TestRequired : 'required' required1 = INT required2 = INT ;
	public TestRequiredElements prTestRequired() {
		return (pTestRequired != null) ? pTestRequired : (pTestRequired = new TestRequiredElements());
	} 

	// TestOptional : 'optional' ( opt1 = INT ) ? ( ':' opt2 = INT ) ? ;
	public TestOptionalElements prTestOptional() {
		return (pTestOptional != null) ? pTestOptional : (pTestOptional = new TestOptionalElements());
	} 

	// TestList : 'list' ( item += INT ) * ;
	public TestListElements prTestList() {
		return (pTestList != null) ? pTestList : (pTestList = new TestListElements());
	} 
}
