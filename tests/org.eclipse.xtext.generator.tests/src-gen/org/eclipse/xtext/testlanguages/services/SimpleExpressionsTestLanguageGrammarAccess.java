/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;

import org.eclipse.xtext.service.GrammarProvider;

import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

@Singleton
public class SimpleExpressionsTestLanguageGrammarAccess implements IGrammarAccess {
	
	
	public class SequenceElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Sequence");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallAddition = (RuleCall)cGroup.eContents().get(0);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Action c10ActionSequenceexpressions = (Action)c1Group.eContents().get(0);
		private final Assignment c11AssignmentExpressions = (Assignment)c1Group.eContents().get(1);
		private final RuleCall c110ParserRuleCallAddition = (RuleCall)c11AssignmentExpressions.eContents().get(0);
		
		// Sequence:   Addition ({current=Sequence.expressions+=current} expressions+=Addition)*;
		public ParserRule getRule() { return rule; }

		// Addition ({current=Sequence.expressions+=current} expressions+=Addition)*
		public Group eleGroup() { return cGroup; }

		// Addition
		public RuleCall ele0ParserRuleCallAddition() { return c0ParserRuleCallAddition; }

		// ({current=Sequence.expressions+=current} expressions+=Addition)*
		public Group ele1Group() { return c1Group; }

		// {current=Sequence.expressions+=current}
		public Action ele10ActionSequenceexpressions() { return c10ActionSequenceexpressions; }

		// expressions+=Addition
		public Assignment ele11AssignmentExpressions() { return c11AssignmentExpressions; }

		// Addition
		public RuleCall ele110ParserRuleCallAddition() { return c110ParserRuleCallAddition; }
	}

	public class AdditionElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Addition");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallMultiplication = (RuleCall)cGroup.eContents().get(0);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Group c10Group = (Group)c1Group.eContents().get(0);
		private final Action c100ActionOpvalues = (Action)c10Group.eContents().get(0);
		private final Assignment c101AssignmentOperator = (Assignment)c10Group.eContents().get(1);
		private final Alternatives c1010Alternatives = (Alternatives)c101AssignmentOperator.eContents().get(0);
		private final Keyword c10100KeywordPlusSign = (Keyword)c1010Alternatives.eContents().get(0);
		private final Keyword c10101KeywordHyphenMinus = (Keyword)c1010Alternatives.eContents().get(1);
		private final Assignment c11AssignmentValues = (Assignment)c1Group.eContents().get(1);
		private final RuleCall c110ParserRuleCallMultiplication = (RuleCall)c11AssignmentValues.eContents().get(0);
		
		// Addition returns Expression:   Multiplication ({current=Op.values+=current} operator=("+"|"-") values+=Multiplication)*;
		public ParserRule getRule() { return rule; }

		// Multiplication ({current=Op.values+=current} operator=("+"|"-") values+=Multiplication)*
		public Group eleGroup() { return cGroup; }

		// Multiplication
		public RuleCall ele0ParserRuleCallMultiplication() { return c0ParserRuleCallMultiplication; }

		// ({current=Op.values+=current} operator=("+"|"-") values+=Multiplication)*
		public Group ele1Group() { return c1Group; }

		// {current=Op.values+=current} operator=("+"|"-")
		public Group ele10Group() { return c10Group; }

		// {current=Op.values+=current}
		public Action ele100ActionOpvalues() { return c100ActionOpvalues; }

		// operator=("+"|"-")
		public Assignment ele101AssignmentOperator() { return c101AssignmentOperator; }

		// "+"|"-"
		public Alternatives ele1010Alternatives() { return c1010Alternatives; }

		// "+"
		public Keyword ele10100KeywordPlusSign() { return c10100KeywordPlusSign; }

		// "-"
		public Keyword ele10101KeywordHyphenMinus() { return c10101KeywordHyphenMinus; }

		// values+=Multiplication
		public Assignment ele11AssignmentValues() { return c11AssignmentValues; }

		// Multiplication
		public RuleCall ele110ParserRuleCallMultiplication() { return c110ParserRuleCallMultiplication; }
	}

	public class MultiplicationElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Multiplication");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallTerm = (RuleCall)cGroup.eContents().get(0);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Group c10Group = (Group)c1Group.eContents().get(0);
		private final Action c100ActionOpvalues = (Action)c10Group.eContents().get(0);
		private final Assignment c101AssignmentOperator = (Assignment)c10Group.eContents().get(1);
		private final Alternatives c1010Alternatives = (Alternatives)c101AssignmentOperator.eContents().get(0);
		private final Keyword c10100KeywordAsterisk = (Keyword)c1010Alternatives.eContents().get(0);
		private final Keyword c10101KeywordSolidus = (Keyword)c1010Alternatives.eContents().get(1);
		private final Assignment c11AssignmentValues = (Assignment)c1Group.eContents().get(1);
		private final RuleCall c110ParserRuleCallTerm = (RuleCall)c11AssignmentValues.eContents().get(0);
		
		// Multiplication returns Expression:   Term ({current=Op.values+=current} operator=("*"|"/") values+=Term)*;
		public ParserRule getRule() { return rule; }

		// Term ({current=Op.values+=current} operator=("*"|"/") values+=Term)*
		public Group eleGroup() { return cGroup; }

		// Term
		public RuleCall ele0ParserRuleCallTerm() { return c0ParserRuleCallTerm; }

		// ({current=Op.values+=current} operator=("*"|"/") values+=Term)*
		public Group ele1Group() { return c1Group; }

		// {current=Op.values+=current} operator=("*"|"/")
		public Group ele10Group() { return c10Group; }

		// {current=Op.values+=current}
		public Action ele100ActionOpvalues() { return c100ActionOpvalues; }

		// operator=("*"|"/")
		public Assignment ele101AssignmentOperator() { return c101AssignmentOperator; }

		// "*"|"/"
		public Alternatives ele1010Alternatives() { return c1010Alternatives; }

		// "*"
		public Keyword ele10100KeywordAsterisk() { return c10100KeywordAsterisk; }

		// "/"
		public Keyword ele10101KeywordSolidus() { return c10101KeywordSolidus; }

		// values+=Term
		public Assignment ele11AssignmentValues() { return c11AssignmentValues; }

		// Term
		public RuleCall ele110ParserRuleCallTerm() { return c110ParserRuleCallTerm; }
	}

	public class TermElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Term");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallAtom = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall c1ParserRuleCallParens = (RuleCall)cAlternatives.eContents().get(1);
		
		// Term returns Expression:   Atom|Parens;
		public ParserRule getRule() { return rule; }

		// Atom|Parens
		public Alternatives eleAlternatives() { return cAlternatives; }

		// Atom
		public RuleCall ele0ParserRuleCallAtom() { return c0ParserRuleCallAtom; }

		// Parens
		public RuleCall ele1ParserRuleCallParens() { return c1ParserRuleCallParens; }
	}

	public class AtomElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Atom");
		private final Assignment cAssignmentName = (Assignment)rule.eContents().get(1);
		private final RuleCall c0LexerRuleCallID = (RuleCall)cAssignmentName.eContents().get(0);
		
		// Atom:   name=ID;
		public ParserRule getRule() { return rule; }

		// name=ID
		public Assignment eleAssignmentName() { return cAssignmentName; }

		// ID
		public RuleCall ele0LexerRuleCallID() { return c0LexerRuleCallID; }
	}

	public class ParensElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Parens");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordLeftParenthesis = (Keyword)c0Group.eContents().get(0);
		private final RuleCall c01ParserRuleCallAddition = (RuleCall)c0Group.eContents().get(1);
		private final Keyword c1KeywordRightParenthesis = (Keyword)cGroup.eContents().get(1);
		
		// Parens returns Expression:   "(" Addition ")";
		public ParserRule getRule() { return rule; }

		// "(" Addition ")"
		public Group eleGroup() { return cGroup; }

		// "(" Addition
		public Group ele0Group() { return c0Group; }

		// "("
		public Keyword ele00KeywordLeftParenthesis() { return c00KeywordLeftParenthesis; }

		// Addition
		public RuleCall ele01ParserRuleCallAddition() { return c01ParserRuleCallAddition; }

		// ")"
		public Keyword ele1KeywordRightParenthesis() { return c1KeywordRightParenthesis; }
	}
	
	private SequenceElements pSequence;
	private AdditionElements pAddition;
	private MultiplicationElements pMultiplication;
	private TermElements pTerm;
	private AtomElements pAtom;
	private ParensElements pParens;
	
	private final GrammarProvider grammarProvider;

	private XtextBuiltinGrammarAccess superGrammarAccess;

	@Inject
	public SimpleExpressionsTestLanguageGrammarAccess(GrammarProvider grammarProvider, XtextBuiltinGrammarAccess superGrammarAccess) {
		this.grammarProvider = grammarProvider;
		this.superGrammarAccess = superGrammarAccess;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	public XtextBuiltinGrammarAccess getSuperGrammarAccess() {
		return superGrammarAccess;
	}

	
	// Sequence:   Addition ({current=Sequence.expressions+=current} expressions+=Addition)*;
	public SequenceElements prSequence() {
		return (pSequence != null) ? pSequence : (pSequence = new SequenceElements());
	} 

	// Addition returns Expression:   Multiplication ({current=Op.values+=current} operator=("+"|"-") values+=Multiplication)*;
	public AdditionElements prAddition() {
		return (pAddition != null) ? pAddition : (pAddition = new AdditionElements());
	} 

	// Multiplication returns Expression:   Term ({current=Op.values+=current} operator=("*"|"/") values+=Term)*;
	public MultiplicationElements prMultiplication() {
		return (pMultiplication != null) ? pMultiplication : (pMultiplication = new MultiplicationElements());
	} 

	// Term returns Expression:   Atom|Parens;
	public TermElements prTerm() {
		return (pTerm != null) ? pTerm : (pTerm = new TermElements());
	} 

	// Atom:   name=ID;
	public AtomElements prAtom() {
		return (pAtom != null) ? pAtom : (pAtom = new AtomElements());
	} 

	// Parens returns Expression:   "(" Addition ")";
	public ParensElements prParens() {
		return (pParens != null) ? pParens : (pParens = new ParensElements());
	} 

	// lexer ID:   "(\'^\')?(\'a\'..\'z\'|\'A\'..\'Z\'|\'_\') (\'a\'..\'z\'|\'A\'..\'Z\'|\'_\'|\'0\'..\'9\')*";
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
