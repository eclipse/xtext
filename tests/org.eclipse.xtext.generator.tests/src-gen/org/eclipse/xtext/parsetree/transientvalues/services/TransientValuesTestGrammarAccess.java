/*
Generated with Xtext
*/

package org.eclipse.xtext.parsetree.transientvalues.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class TransientValuesTestGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class RootElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(1);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordTest = (Keyword)cGroup.eContents().get(0);
		private final Alternatives c1Alternatives = (Alternatives)cGroup.eContents().get(1);
		private final Alternatives c10Alternatives = (Alternatives)c1Alternatives.eContents().get(0);
		private final RuleCall c100ParserRuleCallTestRequired = (RuleCall)c10Alternatives.eContents().get(0);
		private final RuleCall c101ParserRuleCallTestOptional = (RuleCall)c10Alternatives.eContents().get(1);
		private final RuleCall c11ParserRuleCallTestList = (RuleCall)c1Alternatives.eContents().get(1);
		
		// Root : 'test' ( TestRequired | TestOptional | TestList ) ;
		public ParserRule getRule() { return rule; }

		// 'test' ( TestRequired | TestOptional | TestList )
		public Group eleGroup() { return cGroup; }

		// 'test'
		public Keyword ele0KeywordTest() { return c0KeywordTest; }

		// TestRequired | TestOptional | TestList
		public Alternatives ele1Alternatives() { return c1Alternatives; }

		// TestRequired | TestOptional
		public Alternatives ele10Alternatives() { return c10Alternatives; }

		// TestRequired
		public RuleCall ele100ParserRuleCallTestRequired() { return c100ParserRuleCallTestRequired; }

		// TestOptional
		public RuleCall ele101ParserRuleCallTestOptional() { return c101ParserRuleCallTestOptional; }

		// TestList
		public RuleCall ele11ParserRuleCallTestList() { return c11ParserRuleCallTestList; }
	}

	public class TestRequiredElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(2);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordRequired = (Keyword)c0Group.eContents().get(0);
		private final Assignment c01AssignmentRequired1 = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010LexerRuleCallINT = (RuleCall)c01AssignmentRequired1.eContents().get(0);
		private final Assignment c1AssignmentRequired2 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallINT = (RuleCall)c1AssignmentRequired2.eContents().get(0);
		
		// TestRequired : 'required' required1 = INT required2 = INT ;
		public ParserRule getRule() { return rule; }

		// 'required' required1 = INT required2 = INT
		public Group eleGroup() { return cGroup; }

		// 'required' required1 = INT
		public Group ele0Group() { return c0Group; }

		// 'required'
		public Keyword ele00KeywordRequired() { return c00KeywordRequired; }

		// required1 = INT
		public Assignment ele01AssignmentRequired1() { return c01AssignmentRequired1; }

		// INT
		public RuleCall ele010LexerRuleCallINT() { return c010LexerRuleCallINT; }

		// required2 = INT
		public Assignment ele1AssignmentRequired2() { return c1AssignmentRequired2; }

		// INT
		public RuleCall ele10LexerRuleCallINT() { return c10LexerRuleCallINT; }
	}

	public class TestOptionalElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(3);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordOptional = (Keyword)c0Group.eContents().get(0);
		private final Assignment c01AssignmentOpt1 = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010LexerRuleCallINT = (RuleCall)c01AssignmentOpt1.eContents().get(0);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Keyword c10KeywordColon = (Keyword)c1Group.eContents().get(0);
		private final Assignment c11AssignmentOpt2 = (Assignment)c1Group.eContents().get(1);
		private final RuleCall c110LexerRuleCallINT = (RuleCall)c11AssignmentOpt2.eContents().get(0);
		
		// TestOptional : 'optional' ( opt1 = INT ) ? ( ':' opt2 = INT ) ? ;
		public ParserRule getRule() { return rule; }

		// 'optional' ( opt1 = INT ) ? ( ':' opt2 = INT ) ?
		public Group eleGroup() { return cGroup; }

		// 'optional' ( opt1 = INT ) ?
		public Group ele0Group() { return c0Group; }

		// 'optional'
		public Keyword ele00KeywordOptional() { return c00KeywordOptional; }

		// ( opt1 = INT ) ?
		public Assignment ele01AssignmentOpt1() { return c01AssignmentOpt1; }

		// INT
		public RuleCall ele010LexerRuleCallINT() { return c010LexerRuleCallINT; }

		// ( ':' opt2 = INT ) ?
		public Group ele1Group() { return c1Group; }

		// ':'
		public Keyword ele10KeywordColon() { return c10KeywordColon; }

		// opt2 = INT
		public Assignment ele11AssignmentOpt2() { return c11AssignmentOpt2; }

		// INT
		public RuleCall ele110LexerRuleCallINT() { return c110LexerRuleCallINT; }
	}

	public class TestListElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(4);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordList = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentItem = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallINT = (RuleCall)c1AssignmentItem.eContents().get(0);
		
		// TestList : 'list' ( item += INT ) * ;
		public ParserRule getRule() { return rule; }

		// 'list' ( item += INT ) *
		public Group eleGroup() { return cGroup; }

		// 'list'
		public Keyword ele0KeywordList() { return c0KeywordList; }

		// ( item += INT ) *
		public Assignment ele1AssignmentItem() { return c1AssignmentItem; }

		// INT
		public RuleCall ele10LexerRuleCallINT() { return c10LexerRuleCallINT; }
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
