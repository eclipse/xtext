/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class ContentAssistTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class StartElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(1);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordAbstractRules = (Keyword)c0Group.eContents().get(0);
		private final Assignment c01AssignmentRules = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010ParserRuleCallAbstractRule = (RuleCall)c01AssignmentRules.eContents().get(0);
		private final Keyword c1KeywordEnd = (Keyword)cGroup.eContents().get(1);
		
		// Start : 'abstract rules' ( rules += AbstractRule ) + 'end' ;
		public ParserRule getRule() { return rule; }

		// 'abstract rules' ( rules += AbstractRule ) + 'end'
		public Group eleGroup() { return cGroup; }

		// 'abstract rules' ( rules += AbstractRule ) +
		public Group ele0Group() { return c0Group; }

		// 'abstract rules'
		public Keyword ele00KeywordAbstractRules() { return c00KeywordAbstractRules; }

		// ( rules += AbstractRule ) +
		public Assignment ele01AssignmentRules() { return c01AssignmentRules; }

		// AbstractRule
		public RuleCall ele010ParserRuleCallAbstractRule() { return c010ParserRuleCallAbstractRule; }

		// 'end'
		public Keyword ele1KeywordEnd() { return c1KeywordEnd; }
	}

	public class AbstractRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(2);
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallFirstAbstractRuleChild = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall c1ParserRuleCallSecondAbstractRuleChild = (RuleCall)cAlternatives.eContents().get(1);
		
		// AbstractRule : FirstAbstractRuleChild | SecondAbstractRuleChild ;
		public ParserRule getRule() { return rule; }

		// FirstAbstractRuleChild | SecondAbstractRuleChild
		public Alternatives eleAlternatives() { return cAlternatives; }

		// FirstAbstractRuleChild
		public RuleCall ele0ParserRuleCallFirstAbstractRuleChild() { return c0ParserRuleCallFirstAbstractRuleChild; }

		// SecondAbstractRuleChild
		public RuleCall ele1ParserRuleCallSecondAbstractRuleChild() { return c1ParserRuleCallSecondAbstractRuleChild; }
	}

	public class FirstAbstractRuleChildElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(3);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Assignment c0000AssignmentName = (Assignment)c000Group.eContents().get(0);
		private final RuleCall c00000LexerRuleCallID = (RuleCall)c0000AssignmentName.eContents().get(0);
		private final Keyword c0001KeywordLeftParenthesis = (Keyword)c000Group.eContents().get(1);
		private final Assignment c001AssignmentElements = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010ParserRuleCallAbstractRule = (RuleCall)c001AssignmentElements.eContents().get(0);
		private final Keyword c01KeywordRightParenthesis = (Keyword)c0Group.eContents().get(1);
		private final Keyword c1KeywordSemicolon = (Keyword)cGroup.eContents().get(1);
		
		// FirstAbstractRuleChild : name = ID '(' ( elements += AbstractRule ) + ')' ';' ;
		public ParserRule getRule() { return rule; }

		// name = ID '(' ( elements += AbstractRule ) + ')' ';'
		public Group eleGroup() { return cGroup; }

		// name = ID '(' ( elements += AbstractRule ) + ')'
		public Group ele0Group() { return c0Group; }

		// name = ID '(' ( elements += AbstractRule ) +
		public Group ele00Group() { return c00Group; }

		// name = ID '('
		public Group ele000Group() { return c000Group; }

		// name = ID
		public Assignment ele0000AssignmentName() { return c0000AssignmentName; }

		// ID
		public RuleCall ele00000LexerRuleCallID() { return c00000LexerRuleCallID; }

		// '('
		public Keyword ele0001KeywordLeftParenthesis() { return c0001KeywordLeftParenthesis; }

		// ( elements += AbstractRule ) +
		public Assignment ele001AssignmentElements() { return c001AssignmentElements; }

		// AbstractRule
		public RuleCall ele0010ParserRuleCallAbstractRule() { return c0010ParserRuleCallAbstractRule; }

		// ')'
		public Keyword ele01KeywordRightParenthesis() { return c01KeywordRightParenthesis; }

		// ';'
		public Keyword ele1KeywordSemicolon() { return c1KeywordSemicolon; }
	}

	public class SecondAbstractRuleChildElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(4);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Assignment c0000AssignmentName = (Assignment)c000Group.eContents().get(0);
		private final RuleCall c00000LexerRuleCallID = (RuleCall)c0000AssignmentName.eContents().get(0);
		private final Keyword c0001KeywordRule = (Keyword)c000Group.eContents().get(1);
		private final Keyword c001KeywordColon = (Keyword)c00Group.eContents().get(1);
		private final Assignment c01AssignmentRule = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010ParserRuleCallAbstractRuleCall = (RuleCall)c01AssignmentRule.eContents().get(0);
		private final Keyword c1KeywordSemicolon = (Keyword)cGroup.eContents().get(1);
		
		// SecondAbstractRuleChild : name = ID 'rule' ':' rule = AbstractRuleCall ';' ;
		public ParserRule getRule() { return rule; }

		// name = ID 'rule' ':' rule = AbstractRuleCall ';'
		public Group eleGroup() { return cGroup; }

		// name = ID 'rule' ':' rule = AbstractRuleCall
		public Group ele0Group() { return c0Group; }

		// name = ID 'rule' ':'
		public Group ele00Group() { return c00Group; }

		// name = ID 'rule'
		public Group ele000Group() { return c000Group; }

		// name = ID
		public Assignment ele0000AssignmentName() { return c0000AssignmentName; }

		// ID
		public RuleCall ele00000LexerRuleCallID() { return c00000LexerRuleCallID; }

		// 'rule'
		public Keyword ele0001KeywordRule() { return c0001KeywordRule; }

		// ':'
		public Keyword ele001KeywordColon() { return c001KeywordColon; }

		// rule = AbstractRuleCall
		public Assignment ele01AssignmentRule() { return c01AssignmentRule; }

		// AbstractRuleCall
		public RuleCall ele010ParserRuleCallAbstractRuleCall() { return c010ParserRuleCallAbstractRuleCall; }

		// ';'
		public Keyword ele1KeywordSemicolon() { return c1KeywordSemicolon; }
	}

	public class AbstractRuleCallElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(5);
		private final Assignment cAssignmentRule = (Assignment)rule.eContents().get(1);
		private final CrossReference c0CrossReferenceEStringAbstractRule = (CrossReference)cAssignmentRule.eContents().get(0);
		
		// AbstractRuleCall : rule = [ AbstractRule ] ;
		public ParserRule getRule() { return rule; }

		// rule = [ AbstractRule ]
		public Assignment eleAssignmentRule() { return cAssignmentRule; }

		// [ AbstractRule ]
		public CrossReference ele0CrossReferenceEStringAbstractRule() { return c0CrossReferenceEStringAbstractRule; }
	}
	
	public final static ContentAssistTestLanguageGrammarAccess INSTANCE = new ContentAssistTestLanguageGrammarAccess();

	private static final String CONTENTASSISTTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/testlanguages/ContentAssistTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static StartElements pStart;
	private static AbstractRuleElements pAbstractRule;
	private static FirstAbstractRuleChildElements pFirstAbstractRuleChild;
	private static SecondAbstractRuleChildElements pSecondAbstractRuleChild;
	private static AbstractRuleCallElements pAbstractRuleCall;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(ContentAssistTestLanguageGrammarAccess.class.getClassLoader(),CONTENTASSISTTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;		
	}

	
	// Start : 'abstract rules' ( rules += AbstractRule ) + 'end' ;
	public StartElements prStart() {
		return (pStart != null) ? pStart : (pStart = new StartElements());
	} 

	// AbstractRule : FirstAbstractRuleChild | SecondAbstractRuleChild ;
	public AbstractRuleElements prAbstractRule() {
		return (pAbstractRule != null) ? pAbstractRule : (pAbstractRule = new AbstractRuleElements());
	} 

	// FirstAbstractRuleChild : name = ID '(' ( elements += AbstractRule ) + ')' ';' ;
	public FirstAbstractRuleChildElements prFirstAbstractRuleChild() {
		return (pFirstAbstractRuleChild != null) ? pFirstAbstractRuleChild : (pFirstAbstractRuleChild = new FirstAbstractRuleChildElements());
	} 

	// SecondAbstractRuleChild : name = ID 'rule' ':' rule = AbstractRuleCall ';' ;
	public SecondAbstractRuleChildElements prSecondAbstractRuleChild() {
		return (pSecondAbstractRuleChild != null) ? pSecondAbstractRuleChild : (pSecondAbstractRuleChild = new SecondAbstractRuleChildElements());
	} 

	// AbstractRuleCall : rule = [ AbstractRule ] ;
	public AbstractRuleCallElements prAbstractRuleCall() {
		return (pAbstractRuleCall != null) ? pAbstractRuleCall : (pAbstractRuleCall = new AbstractRuleCallElements());
	} 
}
