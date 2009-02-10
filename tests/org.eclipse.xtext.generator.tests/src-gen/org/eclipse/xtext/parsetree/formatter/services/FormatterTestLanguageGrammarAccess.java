/*
Generated with Xtext
*/

package org.eclipse.xtext.parsetree.formatter.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class FormatterTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class RootElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(1);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordTest = (Keyword)cGroup.eContents().get(0);
		private final Alternatives c1Alternatives = (Alternatives)cGroup.eContents().get(1);
		private final RuleCall c10ParserRuleCallTestLinewrap = (RuleCall)c1Alternatives.eContents().get(0);
		private final RuleCall c11ParserRuleCallTestIndentation = (RuleCall)c1Alternatives.eContents().get(1);
		
		// Root:   "test" (TestLinewrap|TestIndentation);
		public ParserRule getRule() { return rule; }

		// "test" (TestLinewrap|TestIndentation)
		public Group eleGroup() { return cGroup; }

		// "test"
		public Keyword ele0KeywordTest() { return c0KeywordTest; }

		// TestLinewrap|TestIndentation
		public Alternatives ele1Alternatives() { return c1Alternatives; }

		// TestLinewrap
		public RuleCall ele10ParserRuleCallTestLinewrap() { return c10ParserRuleCallTestLinewrap; }

		// TestIndentation
		public RuleCall ele11ParserRuleCallTestIndentation() { return c11ParserRuleCallTestIndentation; }
	}

	public class LineElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(2);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Assignment c00AssignmentType = (Assignment)c0Group.eContents().get(0);
		private final RuleCall c000LexerRuleCallID = (RuleCall)c00AssignmentType.eContents().get(0);
		private final Assignment c01AssignmentName = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010LexerRuleCallID = (RuleCall)c01AssignmentName.eContents().get(0);
		private final Keyword c1KeywordSemicolon = (Keyword)cGroup.eContents().get(1);
		
		// Line:   type+=ID name+=ID ";";
		public ParserRule getRule() { return rule; }

		// type+=ID name+=ID ";"
		public Group eleGroup() { return cGroup; }

		// type+=ID name+=ID
		public Group ele0Group() { return c0Group; }

		// type+=ID
		public Assignment ele00AssignmentType() { return c00AssignmentType; }

		// ID
		public RuleCall ele000LexerRuleCallID() { return c000LexerRuleCallID; }

		// name+=ID
		public Assignment ele01AssignmentName() { return c01AssignmentName; }

		// ID
		public RuleCall ele010LexerRuleCallID() { return c010LexerRuleCallID; }

		// ";"
		public Keyword ele1KeywordSemicolon() { return c1KeywordSemicolon; }
	}

	public class TestLinewrapElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(3);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordLinewrap = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentItems = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10ParserRuleCallLine = (RuleCall)c1AssignmentItems.eContents().get(0);
		
		// TestLinewrap:   "linewrap" (items+=Line)*;
		public ParserRule getRule() { return rule; }

		// "linewrap" (items+=Line)*
		public Group eleGroup() { return cGroup; }

		// "linewrap"
		public Keyword ele0KeywordLinewrap() { return c0KeywordLinewrap; }

		// (items+=Line)*
		public Assignment ele1AssignmentItems() { return c1AssignmentItems; }

		// Line
		public RuleCall ele10ParserRuleCallLine() { return c10ParserRuleCallLine; }
	}

	public class TestIndentationElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(4);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordIndentation = (Keyword)c00Group.eContents().get(0);
		private final Keyword c001KeywordLeftCurlyBracket = (Keyword)c00Group.eContents().get(1);
		private final Alternatives c01Alternatives = (Alternatives)c0Group.eContents().get(1);
		private final Assignment c010AssignmentSub = (Assignment)c01Alternatives.eContents().get(0);
		private final RuleCall c0100ParserRuleCallTestIndentation = (RuleCall)c010AssignmentSub.eContents().get(0);
		private final Assignment c011AssignmentItems = (Assignment)c01Alternatives.eContents().get(1);
		private final RuleCall c0110ParserRuleCallLine = (RuleCall)c011AssignmentItems.eContents().get(0);
		private final Keyword c1KeywordRightCurlyBracket = (Keyword)cGroup.eContents().get(1);
		
		// TestIndentation:   "indentation" "{" (sub+=TestIndentation|items+=Line)* "}";
		public ParserRule getRule() { return rule; }

		// "indentation" "{" (sub+=TestIndentation|items+=Line)* "}"
		public Group eleGroup() { return cGroup; }

		// "indentation" "{" (sub+=TestIndentation|items+=Line)*
		public Group ele0Group() { return c0Group; }

		// "indentation" "{"
		public Group ele00Group() { return c00Group; }

		// "indentation"
		public Keyword ele000KeywordIndentation() { return c000KeywordIndentation; }

		// "{"
		public Keyword ele001KeywordLeftCurlyBracket() { return c001KeywordLeftCurlyBracket; }

		// (sub+=TestIndentation|items+=Line)*
		public Alternatives ele01Alternatives() { return c01Alternatives; }

		// sub+=TestIndentation
		public Assignment ele010AssignmentSub() { return c010AssignmentSub; }

		// TestIndentation
		public RuleCall ele0100ParserRuleCallTestIndentation() { return c0100ParserRuleCallTestIndentation; }

		// items+=Line
		public Assignment ele011AssignmentItems() { return c011AssignmentItems; }

		// Line
		public RuleCall ele0110ParserRuleCallLine() { return c0110ParserRuleCallLine; }

		// "}"
		public Keyword ele1KeywordRightCurlyBracket() { return c1KeywordRightCurlyBracket; }
	}
	
	public final static FormatterTestLanguageGrammarAccess INSTANCE = new FormatterTestLanguageGrammarAccess();

	private static final String FORMATTERTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/parsetree/formatter/FormatterTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static RootElements pRoot;
	private static LineElements pLine;
	private static TestLinewrapElements pTestLinewrap;
	private static TestIndentationElements pTestIndentation;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(FormatterTestLanguageGrammarAccess.class.getClassLoader(),FORMATTERTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;
	}

	
	// Root:   "test" (TestLinewrap|TestIndentation);
	public RootElements prRoot() {
		return (pRoot != null) ? pRoot : (pRoot = new RootElements());
	} 

	// Line:   type+=ID name+=ID ";";
	public LineElements prLine() {
		return (pLine != null) ? pLine : (pLine = new LineElements());
	} 

	// TestLinewrap:   "linewrap" (items+=Line)*;
	public TestLinewrapElements prTestLinewrap() {
		return (pTestLinewrap != null) ? pTestLinewrap : (pTestLinewrap = new TestLinewrapElements());
	} 

	// TestIndentation:   "indentation" "{" (sub+=TestIndentation|items+=Line)* "}";
	public TestIndentationElements prTestIndentation() {
		return (pTestIndentation != null) ? pTestIndentation : (pTestIndentation = new TestIndentationElements());
	} 
}
