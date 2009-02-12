/*
Generated with Xtext
*/

package org.eclipse.xtext.metamodelreferencing.tests.services;

import com.google.inject.Singleton;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;

@Singleton
public class MetamodelRefTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class FooElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Foo");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment c0AssignmentName = (Assignment)cGroup.eContents().get(0);
		private final RuleCall c00LexerRuleCallID = (RuleCall)c0AssignmentName.eContents().get(0);
		private final Assignment c1AssignmentNameRefs = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10ParserRuleCallNameRef = (RuleCall)c1AssignmentNameRefs.eContents().get(0);
		
		// Foo:   name=ID (nameRefs+=NameRef)*;
		public ParserRule getRule() { return rule; }

		// name=ID (nameRefs+=NameRef)*
		public Group eleGroup() { return cGroup; }

		// name=ID
		public Assignment ele0AssignmentName() { return c0AssignmentName; }

		// ID
		public RuleCall ele00LexerRuleCallID() { return c00LexerRuleCallID; }

		// (nameRefs+=NameRef)*
		public Assignment ele1AssignmentNameRefs() { return c1AssignmentNameRefs; }

		// NameRef
		public RuleCall ele10ParserRuleCallNameRef() { return c10ParserRuleCallNameRef; }
	}

	public class NameRefElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "NameRef");
		private final Assignment cAssignmentRule = (Assignment)rule.eContents().get(1);
		private final CrossReference c0CrossReferenceEStringParserRule = (CrossReference)cAssignmentRule.eContents().get(0);
		
		// NameRef returns RuleCall:   rule=[ParserRule];
		public ParserRule getRule() { return rule; }

		// rule=[ParserRule]
		public Assignment eleAssignmentRule() { return cAssignmentRule; }

		// [ParserRule]
		public CrossReference ele0CrossReferenceEStringParserRule() { return c0CrossReferenceEStringParserRule; }
	}

	public class MyRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MyRule");
		private final Assignment cAssignmentName = (Assignment)rule.eContents().get(1);
		private final RuleCall c0LexerRuleCallID = (RuleCall)cAssignmentName.eContents().get(0);
		
		// MyRule returns ParserRule:   name=ID;
		public ParserRule getRule() { return rule; }

		// name=ID
		public Assignment eleAssignmentName() { return cAssignmentName; }

		// ID
		public RuleCall ele0LexerRuleCallID() { return c0LexerRuleCallID; }
	}
	
	public final static MetamodelRefTestLanguageGrammarAccess INSTANCE = new MetamodelRefTestLanguageGrammarAccess();

	private static final String METAMODELREFTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static FooElements pFoo;
	private static NameRefElements pNameRef;
	private static MyRuleElements pMyRule;
	private static LexerRule lID;
	private static LexerRule lINT;
	private static LexerRule lSTRING;
	private static LexerRule lML_COMMENT;
	private static LexerRule lSL_COMMENT;
	private static LexerRule lWS;
	private static LexerRule lANY_OTHER;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(MetamodelRefTestLanguageGrammarAccess.class.getClassLoader(),METAMODELREFTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}

	
	// Foo:   name=ID (nameRefs+=NameRef)*;
	public FooElements prFoo() {
		return (pFoo != null) ? pFoo : (pFoo = new FooElements());
	} 

	// NameRef returns RuleCall:   rule=[ParserRule];
	public NameRefElements prNameRef() {
		return (pNameRef != null) ? pNameRef : (pNameRef = new NameRefElements());
	} 

	// MyRule returns ParserRule:   name=ID;
	public MyRuleElements prMyRule() {
		return (pMyRule != null) ? pMyRule : (pMyRule = new MyRuleElements());
	} 

	// lexer ID:   "(\'^\')?(\'a\'..\'z\'|\'A\'..\'Z\'|\'_\') (\'a\'..\'z\'|\'A\'..\'Z\'|\'_\'|\'0\'..\'9\')*";
	public LexerRule lrID() {
		return (lID != null) ? lID : (lID = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "ID"));
	} 

	// lexer INT returns EInt:   "(\'0\'..\'9\')+";
	public LexerRule lrINT() {
		return (lINT != null) ? lINT : (lINT = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "INT"));
	} 

	// lexer STRING:   "\n\t\t\t  \'\"\' ( \'\\\\\' (\'b\'|\'t\'|\'n\'|\'f\'|\'r\'|\'\\\"\'|\'\\\'\'|\'\\\\\') | ~(\'\\\\\'|\'\"\') )* \'\"\' | \n              \'\\\'\' ( \'\\\\\' (\'b\'|\'t\'|\'n\'|\'f\'|\'r\'|\'\\\"\'|\'\\\'\'|\'\\\\\') | ~(\'\\\\\'|\'\\\'\') )* \'\\\'\'\n              ";
	public LexerRule lrSTRING() {
		return (lSTRING != null) ? lSTRING : (lSTRING = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "STRING"));
	} 

	// lexer ML_COMMENT:   "\'/*\' ( options {greedy=false;} : . )* \'*/\'";
	public LexerRule lrML_COMMENT() {
		return (lML_COMMENT != null) ? lML_COMMENT : (lML_COMMENT = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "ML_COMMENT"));
	} 

	// lexer SL_COMMENT:   "\'//\' ~(\'\\n\'|\'\\r\')* (\'\\r\'? \'\\n\')?";
	public LexerRule lrSL_COMMENT() {
		return (lSL_COMMENT != null) ? lSL_COMMENT : (lSL_COMMENT = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "SL_COMMENT"));
	} 

	// lexer WS:   "(\' \'|\'\\t\'|\'\\r\'|\'\\n\')+";
	public LexerRule lrWS() {
		return (lWS != null) ? lWS : (lWS = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "WS"));
	} 

	// lexer ANY_OTHER:   ".";
	public LexerRule lrANY_OTHER() {
		return (lANY_OTHER != null) ? lANY_OTHER : (lANY_OTHER = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "ANY_OTHER"));
	} 
}
