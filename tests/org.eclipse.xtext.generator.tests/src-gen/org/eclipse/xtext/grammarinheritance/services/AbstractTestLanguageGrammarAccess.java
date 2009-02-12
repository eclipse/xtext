/*
Generated with Xtext
*/

package org.eclipse.xtext.grammarinheritance.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class AbstractTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class InheritedParserRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(2);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordElement = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentName = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallID = (RuleCall)c1AssignmentName.eContents().get(0);
		
		// InheritedParserRule returns AType:   "element" name=ID;
		public ParserRule getRule() { return rule; }

		// "element" name=ID
		public Group eleGroup() { return cGroup; }

		// "element"
		public Keyword ele0KeywordElement() { return c0KeywordElement; }

		// name=ID
		public Assignment ele1AssignmentName() { return c1AssignmentName; }

		// ID
		public RuleCall ele10LexerRuleCallID() { return c10LexerRuleCallID; }
	}

	public class AbstractCallOverridenParserRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(3);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordOverridemodel = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentElements = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10ParserRuleCallOverridableParserRule = (RuleCall)c1AssignmentElements.eContents().get(0);
		
		// AbstractCallOverridenParserRule returns AModel:   "overridemodel" (elements+=OverridableParserRule)*;
		public ParserRule getRule() { return rule; }

		// "overridemodel" (elements+=OverridableParserRule)*
		public Group eleGroup() { return cGroup; }

		// "overridemodel"
		public Keyword ele0KeywordOverridemodel() { return c0KeywordOverridemodel; }

		// (elements+=OverridableParserRule)*
		public Assignment ele1AssignmentElements() { return c1AssignmentElements; }

		// OverridableParserRule
		public RuleCall ele10ParserRuleCallOverridableParserRule() { return c10ParserRuleCallOverridableParserRule; }
	}

	public class OverridableParserRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(4);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordElement = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentName = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallID = (RuleCall)c1AssignmentName.eContents().get(0);
		
		// OverridableParserRule returns AType:   "element" name=ID;
		public ParserRule getRule() { return rule; }

		// "element" name=ID
		public Group eleGroup() { return cGroup; }

		// "element"
		public Keyword ele0KeywordElement() { return c0KeywordElement; }

		// name=ID
		public Assignment ele1AssignmentName() { return c1AssignmentName; }

		// ID
		public RuleCall ele10LexerRuleCallID() { return c10LexerRuleCallID; }
	}

	public class OverridableParserRule2Elements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(5);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordOtherElement = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentName = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallSTRING = (RuleCall)c1AssignmentName.eContents().get(0);
		
		// OverridableParserRule2 returns AType:   "other element" name=STRING;
		public ParserRule getRule() { return rule; }

		// "other element" name=STRING
		public Group eleGroup() { return cGroup; }

		// "other element"
		public Keyword ele0KeywordOtherElement() { return c0KeywordOtherElement; }

		// name=STRING
		public Assignment ele1AssignmentName() { return c1AssignmentName; }

		// STRING
		public RuleCall ele10LexerRuleCallSTRING() { return c10LexerRuleCallSTRING; }
	}

	public class AbstractCallExtendedParserRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(6);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordExtendedmodel = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentElements = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10ParserRuleCallExtendableParserRule = (RuleCall)c1AssignmentElements.eContents().get(0);
		
		// AbstractCallExtendedParserRule returns AModel:   "extendedmodel" (elements+=ExtendableParserRule)*;
		public ParserRule getRule() { return rule; }

		// "extendedmodel" (elements+=ExtendableParserRule)*
		public Group eleGroup() { return cGroup; }

		// "extendedmodel"
		public Keyword ele0KeywordExtendedmodel() { return c0KeywordExtendedmodel; }

		// (elements+=ExtendableParserRule)*
		public Assignment ele1AssignmentElements() { return c1AssignmentElements; }

		// ExtendableParserRule
		public RuleCall ele10ParserRuleCallExtendableParserRule() { return c10ParserRuleCallExtendableParserRule; }
	}

	public class ExtendableParserRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(7);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordElement = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentName = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallID = (RuleCall)c1AssignmentName.eContents().get(0);
		
		// ExtendableParserRule returns AType:   "element" name=ID;
		public ParserRule getRule() { return rule; }

		// "element" name=ID
		public Group eleGroup() { return cGroup; }

		// "element"
		public Keyword ele0KeywordElement() { return c0KeywordElement; }

		// name=ID
		public Assignment ele1AssignmentName() { return c1AssignmentName; }

		// ID
		public RuleCall ele10LexerRuleCallID() { return c10LexerRuleCallID; }
	}
	
	public final static AbstractTestLanguageGrammarAccess INSTANCE = new AbstractTestLanguageGrammarAccess();

	private static final String ABSTRACTTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/grammarinheritance/AbstractTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static InheritedParserRuleElements pInheritedParserRule;
	private static AbstractCallOverridenParserRuleElements pAbstractCallOverridenParserRule;
	private static OverridableParserRuleElements pOverridableParserRule;
	private static OverridableParserRule2Elements pOverridableParserRule2;
	private static AbstractCallExtendedParserRuleElements pAbstractCallExtendedParserRule;
	private static ExtendableParserRuleElements pExtendableParserRule;
	private static LexerRule lREAL;
	private static LexerRule lID;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(AbstractTestLanguageGrammarAccess.class.getClassLoader(),ABSTRACTTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;
	}

	
	// InheritedParserRule returns AType:   "element" name=ID;
	public InheritedParserRuleElements prInheritedParserRule() {
		return (pInheritedParserRule != null) ? pInheritedParserRule : (pInheritedParserRule = new InheritedParserRuleElements());
	} 

	// AbstractCallOverridenParserRule returns AModel:   "overridemodel" (elements+=OverridableParserRule)*;
	public AbstractCallOverridenParserRuleElements prAbstractCallOverridenParserRule() {
		return (pAbstractCallOverridenParserRule != null) ? pAbstractCallOverridenParserRule : (pAbstractCallOverridenParserRule = new AbstractCallOverridenParserRuleElements());
	} 

	// OverridableParserRule returns AType:   "element" name=ID;
	public OverridableParserRuleElements prOverridableParserRule() {
		return (pOverridableParserRule != null) ? pOverridableParserRule : (pOverridableParserRule = new OverridableParserRuleElements());
	} 

	// OverridableParserRule2 returns AType:   "other element" name=STRING;
	public OverridableParserRule2Elements prOverridableParserRule2() {
		return (pOverridableParserRule2 != null) ? pOverridableParserRule2 : (pOverridableParserRule2 = new OverridableParserRule2Elements());
	} 

	// AbstractCallExtendedParserRule returns AModel:   "extendedmodel" (elements+=ExtendableParserRule)*;
	public AbstractCallExtendedParserRuleElements prAbstractCallExtendedParserRule() {
		return (pAbstractCallExtendedParserRule != null) ? pAbstractCallExtendedParserRule : (pAbstractCallExtendedParserRule = new AbstractCallExtendedParserRuleElements());
	} 

	// ExtendableParserRule returns AType:   "element" name=ID;
	public ExtendableParserRuleElements prExtendableParserRule() {
		return (pExtendableParserRule != null) ? pExtendableParserRule : (pExtendableParserRule = new ExtendableParserRuleElements());
	} 

	// lexer REAL returns EDouble:   "RULE_INT \'.\' RULE_INT";
	public LexerRule lrREAL() {
		return (lREAL != null) ? lREAL : (lREAL = (LexerRule) getGrammar().eContents().get(8));
	} 

	// lexer ID:   "(\'^\')?(\'a\'..\'z\'|\'A\'..\'Z\'|\'\u00F6\'|\'\u00E4\'|\'\u00FC\'|\'_\') (\'a\'..\'z\'|\'A\'..\'Z\'|\'_\'|\'0\'..\'9\')*";
	public LexerRule lrID() {
		return (lID != null) ? lID : (lID = (LexerRule) getGrammar().eContents().get(9));
	} 
}
