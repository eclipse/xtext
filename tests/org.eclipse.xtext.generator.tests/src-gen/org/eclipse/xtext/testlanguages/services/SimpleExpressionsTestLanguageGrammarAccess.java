/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class SimpleExpressionsTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class SequenceElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private RuleCall c0ParserRuleCallAddition;
		private Group c1Group;
		private Action c10ActionSequenceexpressions;
		private Assignment c11AssignmentExpressions;
		private RuleCall c110ParserRuleCallAddition;
		
		// (error)
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(1)); 
		}

		// (error)
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// Addition
		public RuleCall ele0ParserRuleCallAddition() {
			return (c0ParserRuleCallAddition != null) ? c0ParserRuleCallAddition : (c0ParserRuleCallAddition = (RuleCall)eleGroup().eContents().get(0)); 
		}

		// (error)
		public Group ele1Group() {
			return (c1Group != null) ? c1Group : (c1Group = (Group)eleGroup().eContents().get(1)); 
		}

		// (error)
		public Action ele10ActionSequenceexpressions() {
			return (c10ActionSequenceexpressions != null) ? c10ActionSequenceexpressions : (c10ActionSequenceexpressions = (Action)ele1Group().eContents().get(0)); 
		}

		// expressions += Addition
		public Assignment ele11AssignmentExpressions() {
			return (c11AssignmentExpressions != null) ? c11AssignmentExpressions : (c11AssignmentExpressions = (Assignment)ele1Group().eContents().get(1)); 
		}

		// Addition
		public RuleCall ele110ParserRuleCallAddition() {
			return (c110ParserRuleCallAddition != null) ? c110ParserRuleCallAddition : (c110ParserRuleCallAddition = (RuleCall)ele11AssignmentExpressions().eContents().get(0)); 
		}
	}

	public class AdditionElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private RuleCall c0ParserRuleCallMultiplication;
		private Group c1Group;
		private Group c10Group;
		private Action c100ActionOpvalues;
		private Assignment c101AssignmentOperator;
		private Alternatives c1010Alternatives;
		private Keyword c10100Keyword;
		private Keyword c10101Keyword;
		private Assignment c11AssignmentValues;
		private RuleCall c110ParserRuleCallMultiplication;
		
		// (error)
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(2)); 
		}

		// (error)
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(1)); 
		}

		// Multiplication
		public RuleCall ele0ParserRuleCallMultiplication() {
			return (c0ParserRuleCallMultiplication != null) ? c0ParserRuleCallMultiplication : (c0ParserRuleCallMultiplication = (RuleCall)eleGroup().eContents().get(0)); 
		}

		// (error)
		public Group ele1Group() {
			return (c1Group != null) ? c1Group : (c1Group = (Group)eleGroup().eContents().get(1)); 
		}

		// (error)
		public Group ele10Group() {
			return (c10Group != null) ? c10Group : (c10Group = (Group)ele1Group().eContents().get(0)); 
		}

		// (error)
		public Action ele100ActionOpvalues() {
			return (c100ActionOpvalues != null) ? c100ActionOpvalues : (c100ActionOpvalues = (Action)ele10Group().eContents().get(0)); 
		}

		// operator = ( '+' | '-' )
		public Assignment ele101AssignmentOperator() {
			return (c101AssignmentOperator != null) ? c101AssignmentOperator : (c101AssignmentOperator = (Assignment)ele10Group().eContents().get(1)); 
		}

		// '+' | '-'
		public Alternatives ele1010Alternatives() {
			return (c1010Alternatives != null) ? c1010Alternatives : (c1010Alternatives = (Alternatives)ele101AssignmentOperator().eContents().get(0)); 
		}

		// '+'
		public Keyword ele10100Keyword() {
			return (c10100Keyword != null) ? c10100Keyword : (c10100Keyword = (Keyword)ele1010Alternatives().eContents().get(0)); 
		}

		// '-'
		public Keyword ele10101Keyword() {
			return (c10101Keyword != null) ? c10101Keyword : (c10101Keyword = (Keyword)ele1010Alternatives().eContents().get(1)); 
		}

		// values += Multiplication
		public Assignment ele11AssignmentValues() {
			return (c11AssignmentValues != null) ? c11AssignmentValues : (c11AssignmentValues = (Assignment)ele1Group().eContents().get(1)); 
		}

		// Multiplication
		public RuleCall ele110ParserRuleCallMultiplication() {
			return (c110ParserRuleCallMultiplication != null) ? c110ParserRuleCallMultiplication : (c110ParserRuleCallMultiplication = (RuleCall)ele11AssignmentValues().eContents().get(0)); 
		}
	}

	public class MultiplicationElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private RuleCall c0ParserRuleCallTerm;
		private Group c1Group;
		private Group c10Group;
		private Action c100ActionOpvalues;
		private Assignment c101AssignmentOperator;
		private Alternatives c1010Alternatives;
		private Keyword c10100Keyword;
		private Keyword c10101Keyword;
		private Assignment c11AssignmentValues;
		private RuleCall c110ParserRuleCallTerm;
		
		// (error)
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(3)); 
		}

		// (error)
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(1)); 
		}

		// Term
		public RuleCall ele0ParserRuleCallTerm() {
			return (c0ParserRuleCallTerm != null) ? c0ParserRuleCallTerm : (c0ParserRuleCallTerm = (RuleCall)eleGroup().eContents().get(0)); 
		}

		// (error)
		public Group ele1Group() {
			return (c1Group != null) ? c1Group : (c1Group = (Group)eleGroup().eContents().get(1)); 
		}

		// (error)
		public Group ele10Group() {
			return (c10Group != null) ? c10Group : (c10Group = (Group)ele1Group().eContents().get(0)); 
		}

		// (error)
		public Action ele100ActionOpvalues() {
			return (c100ActionOpvalues != null) ? c100ActionOpvalues : (c100ActionOpvalues = (Action)ele10Group().eContents().get(0)); 
		}

		// operator = ( '*' | '/' )
		public Assignment ele101AssignmentOperator() {
			return (c101AssignmentOperator != null) ? c101AssignmentOperator : (c101AssignmentOperator = (Assignment)ele10Group().eContents().get(1)); 
		}

		// '*' | '/'
		public Alternatives ele1010Alternatives() {
			return (c1010Alternatives != null) ? c1010Alternatives : (c1010Alternatives = (Alternatives)ele101AssignmentOperator().eContents().get(0)); 
		}

		// '*'
		public Keyword ele10100Keyword() {
			return (c10100Keyword != null) ? c10100Keyword : (c10100Keyword = (Keyword)ele1010Alternatives().eContents().get(0)); 
		}

		// '/'
		public Keyword ele10101Keyword() {
			return (c10101Keyword != null) ? c10101Keyword : (c10101Keyword = (Keyword)ele1010Alternatives().eContents().get(1)); 
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
		private RuleCall c0ParserRuleCallAtom;
		private RuleCall c1ParserRuleCallParens;
		
		// (error)
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(4)); 
		}

		// Atom | Parens
		public Alternatives eleAlternatives() {
			return (cAlternatives != null) ? cAlternatives : (cAlternatives = (Alternatives)getRule().eContents().get(1)); 
		}

		// Atom
		public RuleCall ele0ParserRuleCallAtom() {
			return (c0ParserRuleCallAtom != null) ? c0ParserRuleCallAtom : (c0ParserRuleCallAtom = (RuleCall)eleAlternatives().eContents().get(0)); 
		}

		// Parens
		public RuleCall ele1ParserRuleCallParens() {
			return (c1ParserRuleCallParens != null) ? c1ParserRuleCallParens : (c1ParserRuleCallParens = (RuleCall)eleAlternatives().eContents().get(1)); 
		}
	}

	public class AtomElements implements IParserRuleAccess {
		private ParserRule rule;
		private Assignment cAssignmentName;
		private RuleCall c0LexerRuleCallID;
		
		// Atom : name = ID ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(5)); 
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
		private Keyword c00Keyword;
		private RuleCall c01ParserRuleCallAddition;
		private Keyword c1Keyword;
		
		// (error)
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(6)); 
		}

		// '(' Addition ')'
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(1)); 
		}

		// '(' Addition
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// '('
		public Keyword ele00Keyword() {
			return (c00Keyword != null) ? c00Keyword : (c00Keyword = (Keyword)ele0Group().eContents().get(0)); 
		}

		// Addition
		public RuleCall ele01ParserRuleCallAddition() {
			return (c01ParserRuleCallAddition != null) ? c01ParserRuleCallAddition : (c01ParserRuleCallAddition = (RuleCall)ele0Group().eContents().get(1)); 
		}

		// ')'
		public Keyword ele1Keyword() {
			return (c1Keyword != null) ? c1Keyword : (c1Keyword = (Keyword)eleGroup().eContents().get(1)); 
		}
	}
	
	public final static SimpleExpressionsTestLanguageGrammarAccess INSTANCE = new SimpleExpressionsTestLanguageGrammarAccess();

	private static final String SIMPLEEXPRESSIONSTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/testlanguages/SimpleExpressionsTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static SequenceElements pSequence;
	private static AdditionElements pAddition;
	private static MultiplicationElements pMultiplication;
	private static TermElements pTerm;
	private static AtomElements pAtom;
	private static ParensElements pParens;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(SimpleExpressionsTestLanguageGrammarAccess.class.getClassLoader(),SIMPLEEXPRESSIONSTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;		
	}

	
	// (error)
	public SequenceElements prSequence() {
		return (pSequence != null) ? pSequence : (pSequence = new SequenceElements());
	} 

	// (error)
	public AdditionElements prAddition() {
		return (pAddition != null) ? pAddition : (pAddition = new AdditionElements());
	} 

	// (error)
	public MultiplicationElements prMultiplication() {
		return (pMultiplication != null) ? pMultiplication : (pMultiplication = new MultiplicationElements());
	} 

	// (error)
	public TermElements prTerm() {
		return (pTerm != null) ? pTerm : (pTerm = new TermElements());
	} 

	// Atom : name = ID ;
	public AtomElements prAtom() {
		return (pAtom != null) ? pAtom : (pAtom = new AtomElements());
	} 

	// (error)
	public ParensElements prParens() {
		return (pParens != null) ? pParens : (pParens = new ParensElements());
	} 
}
