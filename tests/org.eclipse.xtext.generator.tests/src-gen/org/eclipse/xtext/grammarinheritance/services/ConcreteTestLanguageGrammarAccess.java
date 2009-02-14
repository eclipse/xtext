/*
Generated with Xtext
*/

package org.eclipse.xtext.grammarinheritance.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;

import org.eclipse.xtext.service.GrammarProvider;

import org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageGrammarAccess;

@Singleton
public class ConcreteTestLanguageGrammarAccess implements IGrammarAccess {
	
	
	public class RootRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "RootRule");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Alternatives c0Alternatives = (Alternatives)cAlternatives.eContents().get(0);
		private final Alternatives c00Alternatives = (Alternatives)c0Alternatives.eContents().get(0);
		private final RuleCall c000ParserRuleCallConcreteParserRule = (RuleCall)c00Alternatives.eContents().get(0);
		private final RuleCall c001ParserRuleCallCallOverridenParserRule = (RuleCall)c00Alternatives.eContents().get(1);
		private final RuleCall c01ParserRuleCallCallExtendedParserRule = (RuleCall)c0Alternatives.eContents().get(1);
		private final RuleCall c1ParserRuleCallOverridableParserRule2 = (RuleCall)cAlternatives.eContents().get(1);
		
		// RootRule:   ConcreteParserRule|CallOverridenParserRule|CallExtendedParserRule|OverridableParserRule2;
		public ParserRule getRule() { return rule; }

		// ConcreteParserRule|CallOverridenParserRule|CallExtendedParserRule|OverridableParserRule2
		public Alternatives eleAlternatives() { return cAlternatives; }

		// ConcreteParserRule|CallOverridenParserRule|CallExtendedParserRule
		public Alternatives ele0Alternatives() { return c0Alternatives; }

		// ConcreteParserRule|CallOverridenParserRule
		public Alternatives ele00Alternatives() { return c00Alternatives; }

		// ConcreteParserRule
		public RuleCall ele000ParserRuleCallConcreteParserRule() { return c000ParserRuleCallConcreteParserRule; }

		// CallOverridenParserRule
		public RuleCall ele001ParserRuleCallCallOverridenParserRule() { return c001ParserRuleCallCallOverridenParserRule; }

		// CallExtendedParserRule
		public RuleCall ele01ParserRuleCallCallExtendedParserRule() { return c01ParserRuleCallCallExtendedParserRule; }

		// OverridableParserRule2
		public RuleCall ele1ParserRuleCallOverridableParserRule2() { return c1ParserRuleCallOverridableParserRule2; }
	}

	public class ConcreteParserRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ConcreteParserRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordModel = (Keyword)c00Group.eContents().get(0);
		private final Assignment c001AssignmentMagicNumber = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010LexerRuleCallREAL = (RuleCall)c001AssignmentMagicNumber.eContents().get(0);
		private final Keyword c01KeywordColon = (Keyword)c0Group.eContents().get(1);
		private final Assignment c1AssignmentElements = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10ParserRuleCallInheritedParserRule = (RuleCall)c1AssignmentElements.eContents().get(0);
		
		// ConcreteParserRule:   "model" magicNumber=REAL ":" (elements+=InheritedParserRule)*;
		public ParserRule getRule() { return rule; }

		// "model" magicNumber=REAL ":" (elements+=InheritedParserRule)*
		public Group eleGroup() { return cGroup; }

		// "model" magicNumber=REAL ":"
		public Group ele0Group() { return c0Group; }

		// "model" magicNumber=REAL
		public Group ele00Group() { return c00Group; }

		// "model"
		public Keyword ele000KeywordModel() { return c000KeywordModel; }

		// magicNumber=REAL
		public Assignment ele001AssignmentMagicNumber() { return c001AssignmentMagicNumber; }

		// REAL
		public RuleCall ele0010LexerRuleCallREAL() { return c0010LexerRuleCallREAL; }

		// ":"
		public Keyword ele01KeywordColon() { return c01KeywordColon; }

		// (elements+=InheritedParserRule)*
		public Assignment ele1AssignmentElements() { return c1AssignmentElements; }

		// InheritedParserRule
		public RuleCall ele10ParserRuleCallInheritedParserRule() { return c10ParserRuleCallInheritedParserRule; }
	}

	public class OverridableParserRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "OverridableParserRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordOverriddenelement = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentName = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallID = (RuleCall)c1AssignmentName.eContents().get(0);
		
		// OverridableParserRule returns AType:   "overriddenelement" name=ID;
		public ParserRule getRule() { return rule; }

		// "overriddenelement" name=ID
		public Group eleGroup() { return cGroup; }

		// "overriddenelement"
		public Keyword ele0KeywordOverriddenelement() { return c0KeywordOverriddenelement; }

		// name=ID
		public Assignment ele1AssignmentName() { return c1AssignmentName; }

		// ID
		public RuleCall ele10LexerRuleCallID() { return c10LexerRuleCallID; }
	}

	public class CallOverridenParserRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "CallOverridenParserRule");
		private final Assignment cAssignmentCall = (Assignment)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallAbstractCallOverridenParserRule = (RuleCall)cAssignmentCall.eContents().get(0);
		
		// CallOverridenParserRule:   call=AbstractCallOverridenParserRule;
		public ParserRule getRule() { return rule; }

		// call=AbstractCallOverridenParserRule
		public Assignment eleAssignmentCall() { return cAssignmentCall; }

		// AbstractCallOverridenParserRule
		public RuleCall ele0ParserRuleCallAbstractCallOverridenParserRule() { return c0ParserRuleCallAbstractCallOverridenParserRule; }
	}

	public class OverridableParserRule2Elements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "OverridableParserRule2");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordOverriddenOtherElement = (Keyword)c00Group.eContents().get(0);
		private final Assignment c001AssignmentName = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010LexerRuleCallID = (RuleCall)c001AssignmentName.eContents().get(0);
		private final Keyword c01KeywordHyphenMinus = (Keyword)c0Group.eContents().get(1);
		private final Assignment c1AssignmentAge = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallINT = (RuleCall)c1AssignmentAge.eContents().get(0);
		
		// OverridableParserRule2 returns AType2:   "overridden other element" name=ID "-" age=INT;
		public ParserRule getRule() { return rule; }

		// "overridden other element" name=ID "-" age=INT
		public Group eleGroup() { return cGroup; }

		// "overridden other element" name=ID "-"
		public Group ele0Group() { return c0Group; }

		// "overridden other element" name=ID
		public Group ele00Group() { return c00Group; }

		// "overridden other element"
		public Keyword ele000KeywordOverriddenOtherElement() { return c000KeywordOverriddenOtherElement; }

		// name=ID
		public Assignment ele001AssignmentName() { return c001AssignmentName; }

		// ID
		public RuleCall ele0010LexerRuleCallID() { return c0010LexerRuleCallID; }

		// "-"
		public Keyword ele01KeywordHyphenMinus() { return c01KeywordHyphenMinus; }

		// age=INT
		public Assignment ele1AssignmentAge() { return c1AssignmentAge; }

		// INT
		public RuleCall ele10LexerRuleCallINT() { return c10LexerRuleCallINT; }
	}

	public class ExtendableParserRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ExtendableParserRule");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Alternatives c0Alternatives = (Alternatives)cAlternatives.eContents().get(0);
		private final RuleCall c00ParserRuleCallSubrule1 = (RuleCall)c0Alternatives.eContents().get(0);
		private final RuleCall c01ParserRuleCallSubrule2 = (RuleCall)c0Alternatives.eContents().get(1);
		private final RuleCall c1ParserRuleCallSubrule3 = (RuleCall)cAlternatives.eContents().get(1);
		
		// ExtendableParserRule returns AType:   Subrule1|Subrule2|Subrule3;
		public ParserRule getRule() { return rule; }

		// Subrule1|Subrule2|Subrule3
		public Alternatives eleAlternatives() { return cAlternatives; }

		// Subrule1|Subrule2
		public Alternatives ele0Alternatives() { return c0Alternatives; }

		// Subrule1
		public RuleCall ele00ParserRuleCallSubrule1() { return c00ParserRuleCallSubrule1; }

		// Subrule2
		public RuleCall ele01ParserRuleCallSubrule2() { return c01ParserRuleCallSubrule2; }

		// Subrule3
		public RuleCall ele1ParserRuleCallSubrule3() { return c1ParserRuleCallSubrule3; }
	}

	public class Subrule1Elements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Subrule1");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordSubrule1 = (Keyword)c0Group.eContents().get(0);
		private final Assignment c01AssignmentName = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010LexerRuleCallID = (RuleCall)c01AssignmentName.eContents().get(0);
		private final Assignment c1AssignmentSub1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallID = (RuleCall)c1AssignmentSub1.eContents().get(0);
		
		// Subrule1:   "subrule1" name=ID sub1=ID;
		public ParserRule getRule() { return rule; }

		// "subrule1" name=ID sub1=ID
		public Group eleGroup() { return cGroup; }

		// "subrule1" name=ID
		public Group ele0Group() { return c0Group; }

		// "subrule1"
		public Keyword ele00KeywordSubrule1() { return c00KeywordSubrule1; }

		// name=ID
		public Assignment ele01AssignmentName() { return c01AssignmentName; }

		// ID
		public RuleCall ele010LexerRuleCallID() { return c010LexerRuleCallID; }

		// sub1=ID
		public Assignment ele1AssignmentSub1() { return c1AssignmentSub1; }

		// ID
		public RuleCall ele10LexerRuleCallID() { return c10LexerRuleCallID; }
	}

	public class Subrule2Elements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Subrule2");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordSubrule3 = (Keyword)c0Group.eContents().get(0);
		private final Assignment c01AssignmentName = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010LexerRuleCallID = (RuleCall)c01AssignmentName.eContents().get(0);
		private final Assignment c1AssignmentSub2 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallSTRING = (RuleCall)c1AssignmentSub2.eContents().get(0);
		
		// Subrule2:   "subrule3" name=ID sub2=STRING;
		public ParserRule getRule() { return rule; }

		// "subrule3" name=ID sub2=STRING
		public Group eleGroup() { return cGroup; }

		// "subrule3" name=ID
		public Group ele0Group() { return c0Group; }

		// "subrule3"
		public Keyword ele00KeywordSubrule3() { return c00KeywordSubrule3; }

		// name=ID
		public Assignment ele01AssignmentName() { return c01AssignmentName; }

		// ID
		public RuleCall ele010LexerRuleCallID() { return c010LexerRuleCallID; }

		// sub2=STRING
		public Assignment ele1AssignmentSub2() { return c1AssignmentSub2; }

		// STRING
		public RuleCall ele10LexerRuleCallSTRING() { return c10LexerRuleCallSTRING; }
	}

	public class Subrule3Elements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Subrule3");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordSubrule3 = (Keyword)c0Group.eContents().get(0);
		private final Assignment c01AssignmentName = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010LexerRuleCallID = (RuleCall)c01AssignmentName.eContents().get(0);
		private final Assignment c1AssignmentSub1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallINT = (RuleCall)c1AssignmentSub1.eContents().get(0);
		
		// Subrule3:   "subrule3" name=ID sub1=INT;
		public ParserRule getRule() { return rule; }

		// "subrule3" name=ID sub1=INT
		public Group eleGroup() { return cGroup; }

		// "subrule3" name=ID
		public Group ele0Group() { return c0Group; }

		// "subrule3"
		public Keyword ele00KeywordSubrule3() { return c00KeywordSubrule3; }

		// name=ID
		public Assignment ele01AssignmentName() { return c01AssignmentName; }

		// ID
		public RuleCall ele010LexerRuleCallID() { return c010LexerRuleCallID; }

		// sub1=INT
		public Assignment ele1AssignmentSub1() { return c1AssignmentSub1; }

		// INT
		public RuleCall ele10LexerRuleCallINT() { return c10LexerRuleCallINT; }
	}

	public class CallExtendedParserRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "CallExtendedParserRule");
		private final Assignment cAssignmentCall = (Assignment)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallAbstractCallExtendedParserRule = (RuleCall)cAssignmentCall.eContents().get(0);
		
		// CallExtendedParserRule:   call=AbstractCallExtendedParserRule;
		public ParserRule getRule() { return rule; }

		// call=AbstractCallExtendedParserRule
		public Assignment eleAssignmentCall() { return cAssignmentCall; }

		// AbstractCallExtendedParserRule
		public RuleCall ele0ParserRuleCallAbstractCallExtendedParserRule() { return c0ParserRuleCallAbstractCallExtendedParserRule; }
	}
	
	private RootRuleElements pRootRule;
	private ConcreteParserRuleElements pConcreteParserRule;
	private OverridableParserRuleElements pOverridableParserRule;
	private CallOverridenParserRuleElements pCallOverridenParserRule;
	private OverridableParserRule2Elements pOverridableParserRule2;
	private ExtendableParserRuleElements pExtendableParserRule;
	private Subrule1Elements pSubrule1;
	private Subrule2Elements pSubrule2;
	private Subrule3Elements pSubrule3;
	private CallExtendedParserRuleElements pCallExtendedParserRule;
	
	private final GrammarProvider grammarProvider;

	private AbstractTestLanguageGrammarAccess superGrammarAccess;

	@Inject
	public ConcreteTestLanguageGrammarAccess(GrammarProvider grammarProvider, AbstractTestLanguageGrammarAccess superGrammarAccess) {
		this.grammarProvider = grammarProvider;
		this.superGrammarAccess = superGrammarAccess;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	public AbstractTestLanguageGrammarAccess getSuperGrammarAccess() {
		return superGrammarAccess;
	}

	
	// RootRule:   ConcreteParserRule|CallOverridenParserRule|CallExtendedParserRule|OverridableParserRule2;
	public RootRuleElements prRootRule() {
		return (pRootRule != null) ? pRootRule : (pRootRule = new RootRuleElements());
	} 

	// ConcreteParserRule:   "model" magicNumber=REAL ":" (elements+=InheritedParserRule)*;
	public ConcreteParserRuleElements prConcreteParserRule() {
		return (pConcreteParserRule != null) ? pConcreteParserRule : (pConcreteParserRule = new ConcreteParserRuleElements());
	} 

	// OverridableParserRule returns AType:   "overriddenelement" name=ID;
	public OverridableParserRuleElements prOverridableParserRule() {
		return (pOverridableParserRule != null) ? pOverridableParserRule : (pOverridableParserRule = new OverridableParserRuleElements());
	} 

	// CallOverridenParserRule:   call=AbstractCallOverridenParserRule;
	public CallOverridenParserRuleElements prCallOverridenParserRule() {
		return (pCallOverridenParserRule != null) ? pCallOverridenParserRule : (pCallOverridenParserRule = new CallOverridenParserRuleElements());
	} 

	// OverridableParserRule2 returns AType2:   "overridden other element" name=ID "-" age=INT;
	public OverridableParserRule2Elements prOverridableParserRule2() {
		return (pOverridableParserRule2 != null) ? pOverridableParserRule2 : (pOverridableParserRule2 = new OverridableParserRule2Elements());
	} 

	// ExtendableParserRule returns AType:   Subrule1|Subrule2|Subrule3;
	public ExtendableParserRuleElements prExtendableParserRule() {
		return (pExtendableParserRule != null) ? pExtendableParserRule : (pExtendableParserRule = new ExtendableParserRuleElements());
	} 

	// Subrule1:   "subrule1" name=ID sub1=ID;
	public Subrule1Elements prSubrule1() {
		return (pSubrule1 != null) ? pSubrule1 : (pSubrule1 = new Subrule1Elements());
	} 

	// Subrule2:   "subrule3" name=ID sub2=STRING;
	public Subrule2Elements prSubrule2() {
		return (pSubrule2 != null) ? pSubrule2 : (pSubrule2 = new Subrule2Elements());
	} 

	// Subrule3:   "subrule3" name=ID sub1=INT;
	public Subrule3Elements prSubrule3() {
		return (pSubrule3 != null) ? pSubrule3 : (pSubrule3 = new Subrule3Elements());
	} 

	// CallExtendedParserRule:   call=AbstractCallExtendedParserRule;
	public CallExtendedParserRuleElements prCallExtendedParserRule() {
		return (pCallExtendedParserRule != null) ? pCallExtendedParserRule : (pCallExtendedParserRule = new CallExtendedParserRuleElements());
	} 

	// InheritedParserRule returns AType:   "element" name=ID;
	public org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageGrammarAccess.InheritedParserRuleElements prInheritedParserRule() {
		return superGrammarAccess.prInheritedParserRule();
	} 

	// AbstractCallOverridenParserRule returns AModel:   "overridemodel" (elements+=OverridableParserRule)*;
	public org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageGrammarAccess.AbstractCallOverridenParserRuleElements prAbstractCallOverridenParserRule() {
		return superGrammarAccess.prAbstractCallOverridenParserRule();
	} 

	// AbstractCallExtendedParserRule returns AModel:   "extendedmodel" (elements+=ExtendableParserRule)*;
	public org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageGrammarAccess.AbstractCallExtendedParserRuleElements prAbstractCallExtendedParserRule() {
		return superGrammarAccess.prAbstractCallExtendedParserRule();
	} 

	// lexer REAL returns EDouble:   "RULE_INT \'.\' RULE_INT";
	public LexerRule lrREAL() {
		return superGrammarAccess.lrREAL();
	} 

	// lexer ID:   "(\'^\')?(\'a\'..\'z\'|\'A\'..\'Z\'|\'\u00F6\'|\'\u00E4\'|\'\u00FC\'|\'_\') (\'a\'..\'z\'|\'A\'..\'Z\'|\'_\'|\'0\'..\'9\')*";
	public LexerRule lrID() {
		return superGrammarAccess.lrID();
	} 

	// lexer INT returns EInt:   "(\'0\'..\'9\')+";
	public LexerRule lrINT() {
		return superGrammarAccess.lrINT();
	} 

	// lexer STRING:   "\n\t\t\t  \'\"\' ( \'\\\\\' (\'b\'|\'t\'|\'n\'|\'f\'|\'r\'|\'\\\"\'|\'\\\'\'|\'\\\\\') | ~(\'\\\\\'|\'\"\') )* \'\"\' | \n              \'\\\'\' ( \'\\\\\' (\'b\'|\'t\'|\'n\'|\'f\'|\'r\'|\'\\\"\'|\'\\\'\'|\'\\\\\') | ~(\'\\\\\'|\'\\\'\') )* \'\\\'\'\n              ";
	public LexerRule lrSTRING() {
		return superGrammarAccess.lrSTRING();
	} 

	// lexer ML_COMMENT:   "\'/*\' ( options {greedy=false;} : . )* \'*/\'";
	public LexerRule lrML_COMMENT() {
		return superGrammarAccess.lrML_COMMENT();
	} 

	// lexer SL_COMMENT:   "\'//\' ~(\'\\n\'|\'\\r\')* (\'\\r\'? \'\\n\')?";
	public LexerRule lrSL_COMMENT() {
		return superGrammarAccess.lrSL_COMMENT();
	} 

	// lexer WS:   "(\' \'|\'\\t\'|\'\\r\'|\'\\n\')+";
	public LexerRule lrWS() {
		return superGrammarAccess.lrWS();
	} 

	// lexer ANY_OTHER:   ".";
	public LexerRule lrANY_OTHER() {
		return superGrammarAccess.lrANY_OTHER();
	} 
}
