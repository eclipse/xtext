/*
Generated with Xtext
*/

package org.eclipse.xtext.parsetree.reconstr.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class SimpleReconstrTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class OpElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(1);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallTerm = (RuleCall)cGroup.eContents().get(0);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Action c10ActionOpvalues = (Action)c1Group.eContents().get(0);
		private final Assignment c11AssignmentValues = (Assignment)c1Group.eContents().get(1);
		private final RuleCall c110ParserRuleCallTerm = (RuleCall)c11AssignmentValues.eContents().get(0);
		
		// Op returns Expression : Term ( { current = Op . values += current } values += Term ) * ;
		public ParserRule getRule() { return rule; }

		// Term ( { current = Op . values += current } values += Term ) *
		public Group eleGroup() { return cGroup; }

		// Term
		public RuleCall ele0ParserRuleCallTerm() { return c0ParserRuleCallTerm; }

		// ( { current = Op . values += current } values += Term ) *
		public Group ele1Group() { return c1Group; }

		// { current = Op . values += current }
		public Action ele10ActionOpvalues() { return c10ActionOpvalues; }

		// values += Term
		public Assignment ele11AssignmentValues() { return c11AssignmentValues; }

		// Term
		public RuleCall ele110ParserRuleCallTerm() { return c110ParserRuleCallTerm; }
	}

	public class TermElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(2);
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Alternatives c0Alternatives = (Alternatives)cAlternatives.eContents().get(0);
		private final Alternatives c00Alternatives = (Alternatives)c0Alternatives.eContents().get(0);
		private final Alternatives c000Alternatives = (Alternatives)c00Alternatives.eContents().get(0);
		private final Alternatives c0000Alternatives = (Alternatives)c000Alternatives.eContents().get(0);
		private final Alternatives c00000Alternatives = (Alternatives)c0000Alternatives.eContents().get(0);
		private final Alternatives c000000Alternatives = (Alternatives)c00000Alternatives.eContents().get(0);
		private final RuleCall c0000000ParserRuleCallAtom = (RuleCall)c000000Alternatives.eContents().get(0);
		private final RuleCall c0000001ParserRuleCallTwoNumbers = (RuleCall)c000000Alternatives.eContents().get(1);
		private final RuleCall c000001ParserRuleCallManyStrings = (RuleCall)c00000Alternatives.eContents().get(1);
		private final RuleCall c00001ParserRuleCallParens = (RuleCall)c0000Alternatives.eContents().get(1);
		private final RuleCall c0001ParserRuleCallType = (RuleCall)c000Alternatives.eContents().get(1);
		private final RuleCall c001ParserRuleCallRef2 = (RuleCall)c00Alternatives.eContents().get(1);
		private final RuleCall c01ParserRuleCallSpare = (RuleCall)c0Alternatives.eContents().get(1);
		private final RuleCall c1ParserRuleCallBoolean = (RuleCall)cAlternatives.eContents().get(1);
		
		// Term returns Expression : Atom | TwoNumbers | ManyStrings | Parens | Type | Ref2 | Spare | Boolean ;
		public ParserRule getRule() { return rule; }

		// Atom | TwoNumbers | ManyStrings | Parens | Type | Ref2 | Spare | Boolean
		public Alternatives eleAlternatives() { return cAlternatives; }

		// Atom | TwoNumbers | ManyStrings | Parens | Type | Ref2 | Spare
		public Alternatives ele0Alternatives() { return c0Alternatives; }

		// Atom | TwoNumbers | ManyStrings | Parens | Type | Ref2
		public Alternatives ele00Alternatives() { return c00Alternatives; }

		// Atom | TwoNumbers | ManyStrings | Parens | Type
		public Alternatives ele000Alternatives() { return c000Alternatives; }

		// Atom | TwoNumbers | ManyStrings | Parens
		public Alternatives ele0000Alternatives() { return c0000Alternatives; }

		// Atom | TwoNumbers | ManyStrings
		public Alternatives ele00000Alternatives() { return c00000Alternatives; }

		// Atom | TwoNumbers
		public Alternatives ele000000Alternatives() { return c000000Alternatives; }

		// Atom
		public RuleCall ele0000000ParserRuleCallAtom() { return c0000000ParserRuleCallAtom; }

		// TwoNumbers
		public RuleCall ele0000001ParserRuleCallTwoNumbers() { return c0000001ParserRuleCallTwoNumbers; }

		// ManyStrings
		public RuleCall ele000001ParserRuleCallManyStrings() { return c000001ParserRuleCallManyStrings; }

		// Parens
		public RuleCall ele00001ParserRuleCallParens() { return c00001ParserRuleCallParens; }

		// Type
		public RuleCall ele0001ParserRuleCallType() { return c0001ParserRuleCallType; }

		// Ref2
		public RuleCall ele001ParserRuleCallRef2() { return c001ParserRuleCallRef2; }

		// Spare
		public RuleCall ele01ParserRuleCallSpare() { return c01ParserRuleCallSpare; }

		// Boolean
		public RuleCall ele1ParserRuleCallBoolean() { return c1ParserRuleCallBoolean; }
	}

	public class AtomElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(3);
		private final Assignment cAssignmentName = (Assignment)rule.eContents().get(1);
		private final RuleCall c0LexerRuleCallID = (RuleCall)cAssignmentName.eContents().get(0);
		
		// Atom : name = ID ;
		public ParserRule getRule() { return rule; }

		// name = ID
		public Assignment eleAssignmentName() { return cAssignmentName; }

		// ID
		public RuleCall ele0LexerRuleCallID() { return c0LexerRuleCallID; }
	}

	public class ParensElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(4);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordLeftParenthesis = (Keyword)c00Group.eContents().get(0);
		private final RuleCall c001ParserRuleCallOp = (RuleCall)c00Group.eContents().get(1);
		private final Keyword c01KeywordRightParenthesis = (Keyword)c0Group.eContents().get(1);
		private final Assignment c1AssignmentEm = (Assignment)cGroup.eContents().get(1);
		private final Keyword c10KeywordExclamationMark = (Keyword)c1AssignmentEm.eContents().get(0);
		
		// Parens returns Expression : '(' Op ')' ( em = '!' ) ? ;
		public ParserRule getRule() { return rule; }

		// '(' Op ')' ( em = '!' ) ?
		public Group eleGroup() { return cGroup; }

		// '(' Op ')'
		public Group ele0Group() { return c0Group; }

		// '(' Op
		public Group ele00Group() { return c00Group; }

		// '('
		public Keyword ele000KeywordLeftParenthesis() { return c000KeywordLeftParenthesis; }

		// Op
		public RuleCall ele001ParserRuleCallOp() { return c001ParserRuleCallOp; }

		// ')'
		public Keyword ele01KeywordRightParenthesis() { return c01KeywordRightParenthesis; }

		// ( em = '!' ) ?
		public Assignment ele1AssignmentEm() { return c1AssignmentEm; }

		// '!'
		public Keyword ele10KeywordExclamationMark() { return c10KeywordExclamationMark; }
	}

	public class TwoNumbersElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(5);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Assignment c00AssignmentNum1 = (Assignment)c0Group.eContents().get(0);
		private final RuleCall c000LexerRuleCallINT = (RuleCall)c00AssignmentNum1.eContents().get(0);
		private final Assignment c01AssignmentNum2 = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010LexerRuleCallINT = (RuleCall)c01AssignmentNum2.eContents().get(0);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Keyword c10KeywordNumberSign = (Keyword)c1Group.eContents().get(0);
		private final Assignment c11AssignmentNum3 = (Assignment)c1Group.eContents().get(1);
		private final RuleCall c110LexerRuleCallINT = (RuleCall)c11AssignmentNum3.eContents().get(0);
		
		// TwoNumbers : num1 = INT num2 = INT ( '#' num3 += INT ) * ;
		public ParserRule getRule() { return rule; }

		// num1 = INT num2 = INT ( '#' num3 += INT ) *
		public Group eleGroup() { return cGroup; }

		// num1 = INT num2 = INT
		public Group ele0Group() { return c0Group; }

		// num1 = INT
		public Assignment ele00AssignmentNum1() { return c00AssignmentNum1; }

		// INT
		public RuleCall ele000LexerRuleCallINT() { return c000LexerRuleCallINT; }

		// num2 = INT
		public Assignment ele01AssignmentNum2() { return c01AssignmentNum2; }

		// INT
		public RuleCall ele010LexerRuleCallINT() { return c010LexerRuleCallINT; }

		// ( '#' num3 += INT ) *
		public Group ele1Group() { return c1Group; }

		// '#'
		public Keyword ele10KeywordNumberSign() { return c10KeywordNumberSign; }

		// num3 += INT
		public Assignment ele11AssignmentNum3() { return c11AssignmentNum3; }

		// INT
		public RuleCall ele110LexerRuleCallINT() { return c110LexerRuleCallINT; }
	}

	public class ManyStringsElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(6);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordEqualsSign = (Keyword)c0Group.eContents().get(0);
		private final Assignment c01AssignmentStr1 = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010LexerRuleCallSTRING = (RuleCall)c01AssignmentStr1.eContents().get(0);
		private final Assignment c1AssignmentStr2 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallSTRING = (RuleCall)c1AssignmentStr2.eContents().get(0);
		
		// ManyStrings : '=' ( str1 += STRING ) * str2 += STRING ;
		public ParserRule getRule() { return rule; }

		// '=' ( str1 += STRING ) * str2 += STRING
		public Group eleGroup() { return cGroup; }

		// '=' ( str1 += STRING ) *
		public Group ele0Group() { return c0Group; }

		// '='
		public Keyword ele00KeywordEqualsSign() { return c00KeywordEqualsSign; }

		// ( str1 += STRING ) *
		public Assignment ele01AssignmentStr1() { return c01AssignmentStr1; }

		// STRING
		public RuleCall ele010LexerRuleCallSTRING() { return c010LexerRuleCallSTRING; }

		// str2 += STRING
		public Assignment ele1AssignmentStr2() { return c1AssignmentStr2; }

		// STRING
		public RuleCall ele10LexerRuleCallSTRING() { return c10LexerRuleCallSTRING; }
	}

	public class TypeElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(7);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordType = (Keyword)c00Group.eContents().get(0);
		private final Assignment c001AssignmentName = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010LexerRuleCallID = (RuleCall)c001AssignmentName.eContents().get(0);
		private final Keyword c01KeywordExtends = (Keyword)c0Group.eContents().get(1);
		private final Assignment c1AssignmentExtends = (Assignment)cGroup.eContents().get(1);
		private final CrossReference c10CrossReferenceEStringType = (CrossReference)c1AssignmentExtends.eContents().get(0);
		
		// Type : 'type' name = ID 'extends' ^extends = [ Type ] ;
		public ParserRule getRule() { return rule; }

		// 'type' name = ID 'extends' ^extends = [ Type ]
		public Group eleGroup() { return cGroup; }

		// 'type' name = ID 'extends'
		public Group ele0Group() { return c0Group; }

		// 'type' name = ID
		public Group ele00Group() { return c00Group; }

		// 'type'
		public Keyword ele000KeywordType() { return c000KeywordType; }

		// name = ID
		public Assignment ele001AssignmentName() { return c001AssignmentName; }

		// ID
		public RuleCall ele0010LexerRuleCallID() { return c0010LexerRuleCallID; }

		// 'extends'
		public Keyword ele01KeywordExtends() { return c01KeywordExtends; }

		// ^extends = [ Type ]
		public Assignment ele1AssignmentExtends() { return c1AssignmentExtends; }

		// [ Type ]
		public CrossReference ele10CrossReferenceEStringType() { return c10CrossReferenceEStringType; }
	}

	public class Ref2Elements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(8);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordNumberSignDigitTwo = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentRef2 = (Assignment)cGroup.eContents().get(1);
		private final Alternatives c10Alternatives = (Alternatives)c1AssignmentRef2.eContents().get(0);
		private final Alternatives c100Alternatives = (Alternatives)c10Alternatives.eContents().get(0);
		private final Keyword c1000KeywordMykeyword1 = (Keyword)c100Alternatives.eContents().get(0);
		private final RuleCall c1001LexerRuleCallSTRING = (RuleCall)c100Alternatives.eContents().get(1);
		private final Keyword c101KeywordMykeyword2 = (Keyword)c10Alternatives.eContents().get(1);
		
		// Ref2 : '#2' ref2 = ( 'mykeyword1' | STRING | 'mykeyword2' ) ;
		public ParserRule getRule() { return rule; }

		// '#2' ref2 = ( 'mykeyword1' | STRING | 'mykeyword2' )
		public Group eleGroup() { return cGroup; }

		// '#2'
		public Keyword ele0KeywordNumberSignDigitTwo() { return c0KeywordNumberSignDigitTwo; }

		// ref2 = ( 'mykeyword1' | STRING | 'mykeyword2' )
		public Assignment ele1AssignmentRef2() { return c1AssignmentRef2; }

		// 'mykeyword1' | STRING | 'mykeyword2'
		public Alternatives ele10Alternatives() { return c10Alternatives; }

		// 'mykeyword1' | STRING
		public Alternatives ele100Alternatives() { return c100Alternatives; }

		// 'mykeyword1'
		public Keyword ele1000KeywordMykeyword1() { return c1000KeywordMykeyword1; }

		// STRING
		public RuleCall ele1001LexerRuleCallSTRING() { return c1001LexerRuleCallSTRING; }

		// 'mykeyword2'
		public Keyword ele101KeywordMykeyword2() { return c101KeywordMykeyword2; }
	}

	public class SpareElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(9);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordNumberSignDigitThree = (Keyword)c0Group.eContents().get(0);
		private final Assignment c01AssignmentId = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010LexerRuleCallID = (RuleCall)c01AssignmentId.eContents().get(0);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Keyword c10KeywordFullStop = (Keyword)c1Group.eContents().get(0);
		private final Assignment c11AssignmentId = (Assignment)c1Group.eContents().get(1);
		private final RuleCall c110LexerRuleCallID = (RuleCall)c11AssignmentId.eContents().get(0);
		
		// Spare : '#3' id += ID ( '.' id += ID ) * ;
		public ParserRule getRule() { return rule; }

		// '#3' id += ID ( '.' id += ID ) *
		public Group eleGroup() { return cGroup; }

		// '#3' id += ID
		public Group ele0Group() { return c0Group; }

		// '#3'
		public Keyword ele00KeywordNumberSignDigitThree() { return c00KeywordNumberSignDigitThree; }

		// id += ID
		public Assignment ele01AssignmentId() { return c01AssignmentId; }

		// ID
		public RuleCall ele010LexerRuleCallID() { return c010LexerRuleCallID; }

		// ( '.' id += ID ) *
		public Group ele1Group() { return c1Group; }

		// '.'
		public Keyword ele10KeywordFullStop() { return c10KeywordFullStop; }

		// id += ID
		public Assignment ele11AssignmentId() { return c11AssignmentId; }

		// ID
		public RuleCall ele110LexerRuleCallID() { return c110LexerRuleCallID; }
	}

	public class BooleanElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(10);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordNumberSignDigitFour = (Keyword)c00Group.eContents().get(0);
		private final Assignment c001AssignmentBool = (Assignment)c00Group.eContents().get(1);
		private final Keyword c0010KeywordMyoption = (Keyword)c001AssignmentBool.eContents().get(0);
		private final Keyword c01KeywordKw = (Keyword)c0Group.eContents().get(1);
		private final Assignment c1AssignmentValue = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallID = (RuleCall)c1AssignmentValue.eContents().get(0);
		
		// Boolean : '#4' ( bool ?= 'myoption' ) ? 'kw' value = ID ;
		public ParserRule getRule() { return rule; }

		// '#4' ( bool ?= 'myoption' ) ? 'kw' value = ID
		public Group eleGroup() { return cGroup; }

		// '#4' ( bool ?= 'myoption' ) ? 'kw'
		public Group ele0Group() { return c0Group; }

		// '#4' ( bool ?= 'myoption' ) ?
		public Group ele00Group() { return c00Group; }

		// '#4'
		public Keyword ele000KeywordNumberSignDigitFour() { return c000KeywordNumberSignDigitFour; }

		// ( bool ?= 'myoption' ) ?
		public Assignment ele001AssignmentBool() { return c001AssignmentBool; }

		// 'myoption'
		public Keyword ele0010KeywordMyoption() { return c0010KeywordMyoption; }

		// 'kw'
		public Keyword ele01KeywordKw() { return c01KeywordKw; }

		// value = ID
		public Assignment ele1AssignmentValue() { return c1AssignmentValue; }

		// ID
		public RuleCall ele10LexerRuleCallID() { return c10LexerRuleCallID; }
	}
	
	public final static SimpleReconstrTestLanguageGrammarAccess INSTANCE = new SimpleReconstrTestLanguageGrammarAccess();

	private static final String SIMPLERECONSTRTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static OpElements pOp;
	private static TermElements pTerm;
	private static AtomElements pAtom;
	private static ParensElements pParens;
	private static TwoNumbersElements pTwoNumbers;
	private static ManyStringsElements pManyStrings;
	private static TypeElements pType;
	private static Ref2Elements pRef2;
	private static SpareElements pSpare;
	private static BooleanElements pBoolean;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(SimpleReconstrTestLanguageGrammarAccess.class.getClassLoader(),SIMPLERECONSTRTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;		
	}

	
	// Op returns Expression : Term ( { current = Op . values += current } values += Term ) * ;
	public OpElements prOp() {
		return (pOp != null) ? pOp : (pOp = new OpElements());
	} 

	// Term returns Expression : Atom | TwoNumbers | ManyStrings | Parens | Type | Ref2 | Spare | Boolean ;
	public TermElements prTerm() {
		return (pTerm != null) ? pTerm : (pTerm = new TermElements());
	} 

	// Atom : name = ID ;
	public AtomElements prAtom() {
		return (pAtom != null) ? pAtom : (pAtom = new AtomElements());
	} 

	// Parens returns Expression : '(' Op ')' ( em = '!' ) ? ;
	public ParensElements prParens() {
		return (pParens != null) ? pParens : (pParens = new ParensElements());
	} 

	// TwoNumbers : num1 = INT num2 = INT ( '#' num3 += INT ) * ;
	public TwoNumbersElements prTwoNumbers() {
		return (pTwoNumbers != null) ? pTwoNumbers : (pTwoNumbers = new TwoNumbersElements());
	} 

	// ManyStrings : '=' ( str1 += STRING ) * str2 += STRING ;
	public ManyStringsElements prManyStrings() {
		return (pManyStrings != null) ? pManyStrings : (pManyStrings = new ManyStringsElements());
	} 

	// Type : 'type' name = ID 'extends' ^extends = [ Type ] ;
	public TypeElements prType() {
		return (pType != null) ? pType : (pType = new TypeElements());
	} 

	// Ref2 : '#2' ref2 = ( 'mykeyword1' | STRING | 'mykeyword2' ) ;
	public Ref2Elements prRef2() {
		return (pRef2 != null) ? pRef2 : (pRef2 = new Ref2Elements());
	} 

	// Spare : '#3' id += ID ( '.' id += ID ) * ;
	public SpareElements prSpare() {
		return (pSpare != null) ? pSpare : (pSpare = new SpareElements());
	} 

	// Boolean : '#4' ( bool ?= 'myoption' ) ? 'kw' value = ID ;
	public BooleanElements prBoolean() {
		return (pBoolean != null) ? pBoolean : (pBoolean = new BooleanElements());
	} 
}
