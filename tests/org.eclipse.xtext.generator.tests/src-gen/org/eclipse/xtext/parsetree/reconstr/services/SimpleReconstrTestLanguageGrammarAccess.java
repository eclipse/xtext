/*
Generated with Xtext
*/

package org.eclipse.xtext.parsetree.reconstr.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class SimpleReconstrTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class OpElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private RuleCall c0ParserRuleCallTerm;
		private Group c1Group;
		private Action c10ActionOpvalues;
		private Assignment c11AssignmentValues;
		private RuleCall c110ParserRuleCallTerm;
		
		// Op returns Expression : Term ( { current = Op . values += current } values += Term ) * ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(1)); 
		}

		// Term ( { current = Op . values += current } values += Term ) *
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(1)); 
		}

		// Term
		public RuleCall ele0ParserRuleCallTerm() {
			return (c0ParserRuleCallTerm != null) ? c0ParserRuleCallTerm : (c0ParserRuleCallTerm = (RuleCall)eleGroup().eContents().get(0)); 
		}

		// ( { current = Op . values += current } values += Term ) *
		public Group ele1Group() {
			return (c1Group != null) ? c1Group : (c1Group = (Group)eleGroup().eContents().get(1)); 
		}

		// { current = Op . values += current }
		public Action ele10ActionOpvalues() {
			return (c10ActionOpvalues != null) ? c10ActionOpvalues : (c10ActionOpvalues = (Action)ele1Group().eContents().get(0)); 
		}

		// values += Term
		public Assignment ele11AssignmentValues() {
			return (c11AssignmentValues != null) ? c11AssignmentValues : (c11AssignmentValues = (Assignment)ele1Group().eContents().get(1)); 
		}

		// Term
		public RuleCall ele110ParserRuleCallTerm() {
			return (c110ParserRuleCallTerm != null) ? c110ParserRuleCallTerm : (c110ParserRuleCallTerm = (RuleCall)ele11AssignmentValues().eContents().get(0)); 
		}
	}

	public class TermElements implements IParserRuleAccess {
		private ParserRule rule;
		private Alternatives cAlternatives;
		private Alternatives c0Alternatives;
		private Alternatives c00Alternatives;
		private Alternatives c000Alternatives;
		private Alternatives c0000Alternatives;
		private Alternatives c00000Alternatives;
		private RuleCall c000000ParserRuleCallAtom;
		private RuleCall c000001ParserRuleCallTwoNumbers;
		private RuleCall c00001ParserRuleCallManyStrings;
		private RuleCall c0001ParserRuleCallParens;
		private RuleCall c001ParserRuleCallType;
		private RuleCall c01ParserRuleCallRef2;
		private RuleCall c1ParserRuleCallSpare;
		
		// Term returns Expression : Atom | TwoNumbers | ManyStrings | Parens | Type | Ref2 | Spare ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(2)); 
		}

		// Atom | TwoNumbers | ManyStrings | Parens | Type | Ref2 | Spare
		public Alternatives eleAlternatives() {
			return (cAlternatives != null) ? cAlternatives : (cAlternatives = (Alternatives)getRule().eContents().get(1)); 
		}

		// Atom | TwoNumbers | ManyStrings | Parens | Type | Ref2
		public Alternatives ele0Alternatives() {
			return (c0Alternatives != null) ? c0Alternatives : (c0Alternatives = (Alternatives)eleAlternatives().eContents().get(0)); 
		}

		// Atom | TwoNumbers | ManyStrings | Parens | Type
		public Alternatives ele00Alternatives() {
			return (c00Alternatives != null) ? c00Alternatives : (c00Alternatives = (Alternatives)ele0Alternatives().eContents().get(0)); 
		}

		// Atom | TwoNumbers | ManyStrings | Parens
		public Alternatives ele000Alternatives() {
			return (c000Alternatives != null) ? c000Alternatives : (c000Alternatives = (Alternatives)ele00Alternatives().eContents().get(0)); 
		}

		// Atom | TwoNumbers | ManyStrings
		public Alternatives ele0000Alternatives() {
			return (c0000Alternatives != null) ? c0000Alternatives : (c0000Alternatives = (Alternatives)ele000Alternatives().eContents().get(0)); 
		}

		// Atom | TwoNumbers
		public Alternatives ele00000Alternatives() {
			return (c00000Alternatives != null) ? c00000Alternatives : (c00000Alternatives = (Alternatives)ele0000Alternatives().eContents().get(0)); 
		}

		// Atom
		public RuleCall ele000000ParserRuleCallAtom() {
			return (c000000ParserRuleCallAtom != null) ? c000000ParserRuleCallAtom : (c000000ParserRuleCallAtom = (RuleCall)ele00000Alternatives().eContents().get(0)); 
		}

		// TwoNumbers
		public RuleCall ele000001ParserRuleCallTwoNumbers() {
			return (c000001ParserRuleCallTwoNumbers != null) ? c000001ParserRuleCallTwoNumbers : (c000001ParserRuleCallTwoNumbers = (RuleCall)ele00000Alternatives().eContents().get(1)); 
		}

		// ManyStrings
		public RuleCall ele00001ParserRuleCallManyStrings() {
			return (c00001ParserRuleCallManyStrings != null) ? c00001ParserRuleCallManyStrings : (c00001ParserRuleCallManyStrings = (RuleCall)ele0000Alternatives().eContents().get(1)); 
		}

		// Parens
		public RuleCall ele0001ParserRuleCallParens() {
			return (c0001ParserRuleCallParens != null) ? c0001ParserRuleCallParens : (c0001ParserRuleCallParens = (RuleCall)ele000Alternatives().eContents().get(1)); 
		}

		// Type
		public RuleCall ele001ParserRuleCallType() {
			return (c001ParserRuleCallType != null) ? c001ParserRuleCallType : (c001ParserRuleCallType = (RuleCall)ele00Alternatives().eContents().get(1)); 
		}

		// Ref2
		public RuleCall ele01ParserRuleCallRef2() {
			return (c01ParserRuleCallRef2 != null) ? c01ParserRuleCallRef2 : (c01ParserRuleCallRef2 = (RuleCall)ele0Alternatives().eContents().get(1)); 
		}

		// Spare
		public RuleCall ele1ParserRuleCallSpare() {
			return (c1ParserRuleCallSpare != null) ? c1ParserRuleCallSpare : (c1ParserRuleCallSpare = (RuleCall)eleAlternatives().eContents().get(1)); 
		}
	}

	public class AtomElements implements IParserRuleAccess {
		private ParserRule rule;
		private Assignment cAssignmentName;
		private RuleCall c0LexerRuleCallID;
		
		// Atom : name = ID ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(3)); 
		}

		// name = ID
		public Assignment eleAssignmentName() {
			return (cAssignmentName != null) ? cAssignmentName : (cAssignmentName = (Assignment)getRule().eContents().get(0)); 
		}

		// ID
		public RuleCall ele0LexerRuleCallID() {
			return (c0LexerRuleCallID != null) ? c0LexerRuleCallID : (c0LexerRuleCallID = (RuleCall)eleAssignmentName().eContents().get(0)); 
		}
	}

	public class ParensElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Keyword c000Keyword;
		private RuleCall c001ParserRuleCallOp;
		private Keyword c01Keyword;
		private Assignment c1AssignmentEm;
		private Keyword c10Keyword;
		
		// Parens returns Expression : '(' Op ')' ( em = '!' ) ? ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(4)); 
		}

		// '(' Op ')' ( em = '!' ) ?
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(1)); 
		}

		// '(' Op ')'
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// '(' Op
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// '('
		public Keyword ele000Keyword() {
			return (c000Keyword != null) ? c000Keyword : (c000Keyword = (Keyword)ele00Group().eContents().get(0)); 
		}

		// Op
		public RuleCall ele001ParserRuleCallOp() {
			return (c001ParserRuleCallOp != null) ? c001ParserRuleCallOp : (c001ParserRuleCallOp = (RuleCall)ele00Group().eContents().get(1)); 
		}

		// ')'
		public Keyword ele01Keyword() {
			return (c01Keyword != null) ? c01Keyword : (c01Keyword = (Keyword)ele0Group().eContents().get(1)); 
		}

		// ( em = '!' ) ?
		public Assignment ele1AssignmentEm() {
			return (c1AssignmentEm != null) ? c1AssignmentEm : (c1AssignmentEm = (Assignment)eleGroup().eContents().get(1)); 
		}

		// '!'
		public Keyword ele10Keyword() {
			return (c10Keyword != null) ? c10Keyword : (c10Keyword = (Keyword)ele1AssignmentEm().eContents().get(0)); 
		}
	}

	public class TwoNumbersElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Assignment c00AssignmentNum1;
		private RuleCall c000LexerRuleCallINT;
		private Assignment c01AssignmentNum2;
		private RuleCall c010LexerRuleCallINT;
		private Group c1Group;
		private Keyword c10Keyword;
		private Assignment c11AssignmentNum3;
		private RuleCall c110LexerRuleCallINT;
		
		// TwoNumbers : num1 = INT num2 = INT ( '#' num3 += INT ) * ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(5)); 
		}

		// num1 = INT num2 = INT ( '#' num3 += INT ) *
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// num1 = INT num2 = INT
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// num1 = INT
		public Assignment ele00AssignmentNum1() {
			return (c00AssignmentNum1 != null) ? c00AssignmentNum1 : (c00AssignmentNum1 = (Assignment)ele0Group().eContents().get(0)); 
		}

		// INT
		public RuleCall ele000LexerRuleCallINT() {
			return (c000LexerRuleCallINT != null) ? c000LexerRuleCallINT : (c000LexerRuleCallINT = (RuleCall)ele00AssignmentNum1().eContents().get(0)); 
		}

		// num2 = INT
		public Assignment ele01AssignmentNum2() {
			return (c01AssignmentNum2 != null) ? c01AssignmentNum2 : (c01AssignmentNum2 = (Assignment)ele0Group().eContents().get(1)); 
		}

		// INT
		public RuleCall ele010LexerRuleCallINT() {
			return (c010LexerRuleCallINT != null) ? c010LexerRuleCallINT : (c010LexerRuleCallINT = (RuleCall)ele01AssignmentNum2().eContents().get(0)); 
		}

		// ( '#' num3 += INT ) *
		public Group ele1Group() {
			return (c1Group != null) ? c1Group : (c1Group = (Group)eleGroup().eContents().get(1)); 
		}

		// '#'
		public Keyword ele10Keyword() {
			return (c10Keyword != null) ? c10Keyword : (c10Keyword = (Keyword)ele1Group().eContents().get(0)); 
		}

		// num3 += INT
		public Assignment ele11AssignmentNum3() {
			return (c11AssignmentNum3 != null) ? c11AssignmentNum3 : (c11AssignmentNum3 = (Assignment)ele1Group().eContents().get(1)); 
		}

		// INT
		public RuleCall ele110LexerRuleCallINT() {
			return (c110LexerRuleCallINT != null) ? c110LexerRuleCallINT : (c110LexerRuleCallINT = (RuleCall)ele11AssignmentNum3().eContents().get(0)); 
		}
	}

	public class ManyStringsElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Keyword c00Keyword;
		private Assignment c01AssignmentStr1;
		private RuleCall c010LexerRuleCallSTRING;
		private Assignment c1AssignmentStr2;
		private RuleCall c10LexerRuleCallSTRING;
		
		// ManyStrings : '=' ( str1 += STRING ) * str2 += STRING ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(6)); 
		}

		// '=' ( str1 += STRING ) * str2 += STRING
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// '=' ( str1 += STRING ) *
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// '='
		public Keyword ele00Keyword() {
			return (c00Keyword != null) ? c00Keyword : (c00Keyword = (Keyword)ele0Group().eContents().get(0)); 
		}

		// ( str1 += STRING ) *
		public Assignment ele01AssignmentStr1() {
			return (c01AssignmentStr1 != null) ? c01AssignmentStr1 : (c01AssignmentStr1 = (Assignment)ele0Group().eContents().get(1)); 
		}

		// STRING
		public RuleCall ele010LexerRuleCallSTRING() {
			return (c010LexerRuleCallSTRING != null) ? c010LexerRuleCallSTRING : (c010LexerRuleCallSTRING = (RuleCall)ele01AssignmentStr1().eContents().get(0)); 
		}

		// str2 += STRING
		public Assignment ele1AssignmentStr2() {
			return (c1AssignmentStr2 != null) ? c1AssignmentStr2 : (c1AssignmentStr2 = (Assignment)eleGroup().eContents().get(1)); 
		}

		// STRING
		public RuleCall ele10LexerRuleCallSTRING() {
			return (c10LexerRuleCallSTRING != null) ? c10LexerRuleCallSTRING : (c10LexerRuleCallSTRING = (RuleCall)ele1AssignmentStr2().eContents().get(0)); 
		}
	}

	public class TypeElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Keyword c000KeywordType;
		private Assignment c001AssignmentName;
		private RuleCall c0010LexerRuleCallID;
		private Keyword c01KeywordExtends;
		private Assignment c1AssignmentExtends;
		private CrossReference c10CrossReferenceType;
		
		// Type : 'type' name = ID 'extends' ^extends = [ Type ] ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(7)); 
		}

		// 'type' name = ID 'extends' ^extends = [ Type ]
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// 'type' name = ID 'extends'
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'type' name = ID
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// 'type'
		public Keyword ele000KeywordType() {
			return (c000KeywordType != null) ? c000KeywordType : (c000KeywordType = (Keyword)ele00Group().eContents().get(0)); 
		}

		// name = ID
		public Assignment ele001AssignmentName() {
			return (c001AssignmentName != null) ? c001AssignmentName : (c001AssignmentName = (Assignment)ele00Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele0010LexerRuleCallID() {
			return (c0010LexerRuleCallID != null) ? c0010LexerRuleCallID : (c0010LexerRuleCallID = (RuleCall)ele001AssignmentName().eContents().get(0)); 
		}

		// 'extends'
		public Keyword ele01KeywordExtends() {
			return (c01KeywordExtends != null) ? c01KeywordExtends : (c01KeywordExtends = (Keyword)ele0Group().eContents().get(1)); 
		}

		// ^extends = [ Type ]
		public Assignment ele1AssignmentExtends() {
			return (c1AssignmentExtends != null) ? c1AssignmentExtends : (c1AssignmentExtends = (Assignment)eleGroup().eContents().get(1)); 
		}

		// [ Type ]
		public CrossReference ele10CrossReferenceType() {
			return (c10CrossReferenceType != null) ? c10CrossReferenceType : (c10CrossReferenceType = (CrossReference)ele1AssignmentExtends().eContents().get(0)); 
		}
	}

	public class Ref2Elements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Keyword c0Keyword;
		private Assignment c1AssignmentRef2;
		private Alternatives c10Alternatives;
		private Alternatives c100Alternatives;
		private Keyword c1000KeywordMykeyword1;
		private RuleCall c1001LexerRuleCallSTRING;
		private Keyword c101KeywordMykeyword2;
		
		// Ref2 : '#2' ref2 = ( 'mykeyword1' | STRING | 'mykeyword2' ) ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(8)); 
		}

		// '#2' ref2 = ( 'mykeyword1' | STRING | 'mykeyword2' )
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// '#2'
		public Keyword ele0Keyword() {
			return (c0Keyword != null) ? c0Keyword : (c0Keyword = (Keyword)eleGroup().eContents().get(0)); 
		}

		// ref2 = ( 'mykeyword1' | STRING | 'mykeyword2' )
		public Assignment ele1AssignmentRef2() {
			return (c1AssignmentRef2 != null) ? c1AssignmentRef2 : (c1AssignmentRef2 = (Assignment)eleGroup().eContents().get(1)); 
		}

		// 'mykeyword1' | STRING | 'mykeyword2'
		public Alternatives ele10Alternatives() {
			return (c10Alternatives != null) ? c10Alternatives : (c10Alternatives = (Alternatives)ele1AssignmentRef2().eContents().get(0)); 
		}

		// 'mykeyword1' | STRING
		public Alternatives ele100Alternatives() {
			return (c100Alternatives != null) ? c100Alternatives : (c100Alternatives = (Alternatives)ele10Alternatives().eContents().get(0)); 
		}

		// 'mykeyword1'
		public Keyword ele1000KeywordMykeyword1() {
			return (c1000KeywordMykeyword1 != null) ? c1000KeywordMykeyword1 : (c1000KeywordMykeyword1 = (Keyword)ele100Alternatives().eContents().get(0)); 
		}

		// STRING
		public RuleCall ele1001LexerRuleCallSTRING() {
			return (c1001LexerRuleCallSTRING != null) ? c1001LexerRuleCallSTRING : (c1001LexerRuleCallSTRING = (RuleCall)ele100Alternatives().eContents().get(1)); 
		}

		// 'mykeyword2'
		public Keyword ele101KeywordMykeyword2() {
			return (c101KeywordMykeyword2 != null) ? c101KeywordMykeyword2 : (c101KeywordMykeyword2 = (Keyword)ele10Alternatives().eContents().get(1)); 
		}
	}

	public class SpareElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Keyword c00Keyword;
		private Assignment c01AssignmentId;
		private RuleCall c010LexerRuleCallID;
		private Group c1Group;
		private Keyword c10Keyword;
		private Assignment c11AssignmentId;
		private RuleCall c110LexerRuleCallID;
		
		// Spare : '#3' id += ID ( '.' id += ID ) * ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(9)); 
		}

		// '#3' id += ID ( '.' id += ID ) *
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// '#3' id += ID
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// '#3'
		public Keyword ele00Keyword() {
			return (c00Keyword != null) ? c00Keyword : (c00Keyword = (Keyword)ele0Group().eContents().get(0)); 
		}

		// id += ID
		public Assignment ele01AssignmentId() {
			return (c01AssignmentId != null) ? c01AssignmentId : (c01AssignmentId = (Assignment)ele0Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele010LexerRuleCallID() {
			return (c010LexerRuleCallID != null) ? c010LexerRuleCallID : (c010LexerRuleCallID = (RuleCall)ele01AssignmentId().eContents().get(0)); 
		}

		// ( '.' id += ID ) *
		public Group ele1Group() {
			return (c1Group != null) ? c1Group : (c1Group = (Group)eleGroup().eContents().get(1)); 
		}

		// '.'
		public Keyword ele10Keyword() {
			return (c10Keyword != null) ? c10Keyword : (c10Keyword = (Keyword)ele1Group().eContents().get(0)); 
		}

		// id += ID
		public Assignment ele11AssignmentId() {
			return (c11AssignmentId != null) ? c11AssignmentId : (c11AssignmentId = (Assignment)ele1Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele110LexerRuleCallID() {
			return (c110LexerRuleCallID != null) ? c110LexerRuleCallID : (c110LexerRuleCallID = (RuleCall)ele11AssignmentId().eContents().get(0)); 
		}
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

	// Term returns Expression : Atom | TwoNumbers | ManyStrings | Parens | Type | Ref2 | Spare ;
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
}
