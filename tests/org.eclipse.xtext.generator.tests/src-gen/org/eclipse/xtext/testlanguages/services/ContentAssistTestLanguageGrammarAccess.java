/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class ContentAssistTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class StartElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Keyword c00KeywordAbstractRules;
		private Assignment c01AssignmentRules;
		private RuleCall c010ParserRuleCallAbstractRule;
		private Keyword c1KeywordEnd;
		
		// Start : 'abstract rules' ( rules += AbstractRule ) + 'end' ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(1)); 
		}

		// 'abstract rules' ( rules += AbstractRule ) + 'end'
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// 'abstract rules' ( rules += AbstractRule ) +
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'abstract rules'
		public Keyword ele00KeywordAbstractRules() {
			return (c00KeywordAbstractRules != null) ? c00KeywordAbstractRules : (c00KeywordAbstractRules = (Keyword)ele0Group().eContents().get(0)); 
		}

		// ( rules += AbstractRule ) +
		public Assignment ele01AssignmentRules() {
			return (c01AssignmentRules != null) ? c01AssignmentRules : (c01AssignmentRules = (Assignment)ele0Group().eContents().get(1)); 
		}

		// AbstractRule
		public RuleCall ele010ParserRuleCallAbstractRule() {
			return (c010ParserRuleCallAbstractRule != null) ? c010ParserRuleCallAbstractRule : (c010ParserRuleCallAbstractRule = (RuleCall)ele01AssignmentRules().eContents().get(0)); 
		}

		// 'end'
		public Keyword ele1KeywordEnd() {
			return (c1KeywordEnd != null) ? c1KeywordEnd : (c1KeywordEnd = (Keyword)eleGroup().eContents().get(1)); 
		}
	}

	public class AbstractRuleElements implements IParserRuleAccess {
		private ParserRule rule;
		private Alternatives cAlternatives;
		private RuleCall c0ParserRuleCallFirstAbstractRuleChild;
		private RuleCall c1ParserRuleCallSecondAbstractRuleChild;
		
		// AbstractRule : FirstAbstractRuleChild | SecondAbstractRuleChild ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(2)); 
		}

		// FirstAbstractRuleChild | SecondAbstractRuleChild
		public Alternatives eleAlternatives() {
			return (cAlternatives != null) ? cAlternatives : (cAlternatives = (Alternatives)getRule().eContents().get(0)); 
		}

		// FirstAbstractRuleChild
		public RuleCall ele0ParserRuleCallFirstAbstractRuleChild() {
			return (c0ParserRuleCallFirstAbstractRuleChild != null) ? c0ParserRuleCallFirstAbstractRuleChild : (c0ParserRuleCallFirstAbstractRuleChild = (RuleCall)eleAlternatives().eContents().get(0)); 
		}

		// SecondAbstractRuleChild
		public RuleCall ele1ParserRuleCallSecondAbstractRuleChild() {
			return (c1ParserRuleCallSecondAbstractRuleChild != null) ? c1ParserRuleCallSecondAbstractRuleChild : (c1ParserRuleCallSecondAbstractRuleChild = (RuleCall)eleAlternatives().eContents().get(1)); 
		}
	}

	public class FirstAbstractRuleChildElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Group c000Group;
		private Assignment c0000AssignmentName;
		private RuleCall c00000LexerRuleCallID;
		private Keyword c0001Keyword;
		private Assignment c001AssignmentElements;
		private RuleCall c0010ParserRuleCallAbstractRule;
		private Keyword c01Keyword;
		private Keyword c1Keyword;
		
		// FirstAbstractRuleChild : name = ID '(' ( elements += AbstractRule ) + ')' ';' ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(3)); 
		}

		// name = ID '(' ( elements += AbstractRule ) + ')' ';'
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// name = ID '(' ( elements += AbstractRule ) + ')'
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// name = ID '(' ( elements += AbstractRule ) +
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// name = ID '('
		public Group ele000Group() {
			return (c000Group != null) ? c000Group : (c000Group = (Group)ele00Group().eContents().get(0)); 
		}

		// name = ID
		public Assignment ele0000AssignmentName() {
			return (c0000AssignmentName != null) ? c0000AssignmentName : (c0000AssignmentName = (Assignment)ele000Group().eContents().get(0)); 
		}

		// ID
		public RuleCall ele00000LexerRuleCallID() {
			return (c00000LexerRuleCallID != null) ? c00000LexerRuleCallID : (c00000LexerRuleCallID = (RuleCall)ele0000AssignmentName().eContents().get(0)); 
		}

		// '('
		public Keyword ele0001Keyword() {
			return (c0001Keyword != null) ? c0001Keyword : (c0001Keyword = (Keyword)ele000Group().eContents().get(1)); 
		}

		// ( elements += AbstractRule ) +
		public Assignment ele001AssignmentElements() {
			return (c001AssignmentElements != null) ? c001AssignmentElements : (c001AssignmentElements = (Assignment)ele00Group().eContents().get(1)); 
		}

		// AbstractRule
		public RuleCall ele0010ParserRuleCallAbstractRule() {
			return (c0010ParserRuleCallAbstractRule != null) ? c0010ParserRuleCallAbstractRule : (c0010ParserRuleCallAbstractRule = (RuleCall)ele001AssignmentElements().eContents().get(0)); 
		}

		// ')'
		public Keyword ele01Keyword() {
			return (c01Keyword != null) ? c01Keyword : (c01Keyword = (Keyword)ele0Group().eContents().get(1)); 
		}

		// ';'
		public Keyword ele1Keyword() {
			return (c1Keyword != null) ? c1Keyword : (c1Keyword = (Keyword)eleGroup().eContents().get(1)); 
		}
	}

	public class SecondAbstractRuleChildElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Group c000Group;
		private Assignment c0000AssignmentName;
		private RuleCall c00000LexerRuleCallID;
		private Keyword c0001KeywordRule;
		private Keyword c001Keyword;
		private Assignment c01AssignmentRule;
		private RuleCall c010ParserRuleCallAbstractRuleCall;
		private Keyword c1Keyword;
		
		// SecondAbstractRuleChild : name = ID 'rule' ':' rule = AbstractRuleCall ';' ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(4)); 
		}

		// name = ID 'rule' ':' rule = AbstractRuleCall ';'
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// name = ID 'rule' ':' rule = AbstractRuleCall
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// name = ID 'rule' ':'
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// name = ID 'rule'
		public Group ele000Group() {
			return (c000Group != null) ? c000Group : (c000Group = (Group)ele00Group().eContents().get(0)); 
		}

		// name = ID
		public Assignment ele0000AssignmentName() {
			return (c0000AssignmentName != null) ? c0000AssignmentName : (c0000AssignmentName = (Assignment)ele000Group().eContents().get(0)); 
		}

		// ID
		public RuleCall ele00000LexerRuleCallID() {
			return (c00000LexerRuleCallID != null) ? c00000LexerRuleCallID : (c00000LexerRuleCallID = (RuleCall)ele0000AssignmentName().eContents().get(0)); 
		}

		// 'rule'
		public Keyword ele0001KeywordRule() {
			return (c0001KeywordRule != null) ? c0001KeywordRule : (c0001KeywordRule = (Keyword)ele000Group().eContents().get(1)); 
		}

		// ':'
		public Keyword ele001Keyword() {
			return (c001Keyword != null) ? c001Keyword : (c001Keyword = (Keyword)ele00Group().eContents().get(1)); 
		}

		// rule = AbstractRuleCall
		public Assignment ele01AssignmentRule() {
			return (c01AssignmentRule != null) ? c01AssignmentRule : (c01AssignmentRule = (Assignment)ele0Group().eContents().get(1)); 
		}

		// AbstractRuleCall
		public RuleCall ele010ParserRuleCallAbstractRuleCall() {
			return (c010ParserRuleCallAbstractRuleCall != null) ? c010ParserRuleCallAbstractRuleCall : (c010ParserRuleCallAbstractRuleCall = (RuleCall)ele01AssignmentRule().eContents().get(0)); 
		}

		// ';'
		public Keyword ele1Keyword() {
			return (c1Keyword != null) ? c1Keyword : (c1Keyword = (Keyword)eleGroup().eContents().get(1)); 
		}
	}

	public class AbstractRuleCallElements implements IParserRuleAccess {
		private ParserRule rule;
		private Assignment cAssignmentRule;
		private CrossReference c0CrossReferenceAbstractRule;
		
		// AbstractRuleCall : rule = [ AbstractRule ] ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(5)); 
		}

		// rule = [ AbstractRule ]
		public Assignment eleAssignmentRule() {
			return (cAssignmentRule != null) ? cAssignmentRule : (cAssignmentRule = (Assignment)getRule().eContents().get(0)); 
		}

		// [ AbstractRule ]
		public CrossReference ele0CrossReferenceAbstractRule() {
			return (c0CrossReferenceAbstractRule != null) ? c0CrossReferenceAbstractRule : (c0CrossReferenceAbstractRule = (CrossReference)eleAssignmentRule().eContents().get(0)); 
		}
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
