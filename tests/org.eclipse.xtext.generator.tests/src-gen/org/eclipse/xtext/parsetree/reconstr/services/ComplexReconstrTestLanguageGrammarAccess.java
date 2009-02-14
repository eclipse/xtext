/*
Generated with Xtext
*/

package org.eclipse.xtext.parsetree.reconstr.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;

import org.eclipse.xtext.service.GrammarProvider;

import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

@Singleton
public class ComplexReconstrTestLanguageGrammarAccess implements IGrammarAccess {
	
	
	public class RootElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Root");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallOp = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall c1ParserRuleCallTrickyG = (RuleCall)cAlternatives.eContents().get(1);
		
		// Root:   Op|TrickyG;
		public ParserRule getRule() { return rule; }

		// Op|TrickyG
		public Alternatives eleAlternatives() { return cAlternatives; }

		// Op
		public RuleCall ele0ParserRuleCallOp() { return c0ParserRuleCallOp; }

		// TrickyG
		public RuleCall ele1ParserRuleCallTrickyG() { return c1ParserRuleCallTrickyG; }
	}

	public class OpElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Op");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallTerm = (RuleCall)cGroup.eContents().get(0);
		private final Alternatives c1Alternatives = (Alternatives)cGroup.eContents().get(1);
		private final Group c10Group = (Group)c1Alternatives.eContents().get(0);
		private final Group c100Group = (Group)c10Group.eContents().get(0);
		private final Action c1000ActionAddaddOperands = (Action)c100Group.eContents().get(0);
		private final Keyword c1001KeywordPlusSign = (Keyword)c100Group.eContents().get(1);
		private final Assignment c101AssignmentAddOperands = (Assignment)c10Group.eContents().get(1);
		private final RuleCall c1010ParserRuleCallTerm = (RuleCall)c101AssignmentAddOperands.eContents().get(0);
		private final Group c11Group = (Group)c1Alternatives.eContents().get(1);
		private final Group c110Group = (Group)c11Group.eContents().get(0);
		private final Action c1100ActionMinusminusOperands = (Action)c110Group.eContents().get(0);
		private final Keyword c1101KeywordHyphenMinus = (Keyword)c110Group.eContents().get(1);
		private final Assignment c111AssignmentMinusOperands = (Assignment)c11Group.eContents().get(1);
		private final RuleCall c1110ParserRuleCallTerm = (RuleCall)c111AssignmentMinusOperands.eContents().get(0);
		
		// Op returns Expression:   Term ({current=Add.addOperands+=current} "+" addOperands+=Term|{current=Minus.minusOperands+=current} "-" minusOperands+=Term)*;
		public ParserRule getRule() { return rule; }

		// Term ({current=Add.addOperands+=current} "+" addOperands+=Term|{current=Minus.minusOperands+=current} "-" minusOperands+=Term)*
		public Group eleGroup() { return cGroup; }

		// Term
		public RuleCall ele0ParserRuleCallTerm() { return c0ParserRuleCallTerm; }

		// ({current=Add.addOperands+=current} "+" addOperands+=Term|{current=Minus.minusOperands+=current} "-" minusOperands+=Term)*
		public Alternatives ele1Alternatives() { return c1Alternatives; }

		// {current=Add.addOperands+=current} "+" addOperands+=Term
		public Group ele10Group() { return c10Group; }

		// {current=Add.addOperands+=current} "+"
		public Group ele100Group() { return c100Group; }

		// {current=Add.addOperands+=current}
		public Action ele1000ActionAddaddOperands() { return c1000ActionAddaddOperands; }

		// "+"
		public Keyword ele1001KeywordPlusSign() { return c1001KeywordPlusSign; }

		// addOperands+=Term
		public Assignment ele101AssignmentAddOperands() { return c101AssignmentAddOperands; }

		// Term
		public RuleCall ele1010ParserRuleCallTerm() { return c1010ParserRuleCallTerm; }

		// {current=Minus.minusOperands+=current} "-" minusOperands+=Term
		public Group ele11Group() { return c11Group; }

		// {current=Minus.minusOperands+=current} "-"
		public Group ele110Group() { return c110Group; }

		// {current=Minus.minusOperands+=current}
		public Action ele1100ActionMinusminusOperands() { return c1100ActionMinusminusOperands; }

		// "-"
		public Keyword ele1101KeywordHyphenMinus() { return c1101KeywordHyphenMinus; }

		// minusOperands+=Term
		public Assignment ele111AssignmentMinusOperands() { return c111AssignmentMinusOperands; }

		// Term
		public RuleCall ele1110ParserRuleCallTerm() { return c1110ParserRuleCallTerm; }
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
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordLeftParenthesis = (Keyword)c00Group.eContents().get(0);
		private final RuleCall c001ParserRuleCallOp = (RuleCall)c00Group.eContents().get(1);
		private final Keyword c01KeywordRightParenthesis = (Keyword)c0Group.eContents().get(1);
		private final Assignment c1AssignmentEm = (Assignment)cGroup.eContents().get(1);
		private final Keyword c10KeywordExclamationMark = (Keyword)c1AssignmentEm.eContents().get(0);
		
		// Parens returns Expression:   "(" Op ")" (em="!")?;
		public ParserRule getRule() { return rule; }

		// "(" Op ")" (em="!")?
		public Group eleGroup() { return cGroup; }

		// "(" Op ")"
		public Group ele0Group() { return c0Group; }

		// "(" Op
		public Group ele00Group() { return c00Group; }

		// "("
		public Keyword ele000KeywordLeftParenthesis() { return c000KeywordLeftParenthesis; }

		// Op
		public RuleCall ele001ParserRuleCallOp() { return c001ParserRuleCallOp; }

		// ")"
		public Keyword ele01KeywordRightParenthesis() { return c01KeywordRightParenthesis; }

		// (em="!")?
		public Assignment ele1AssignmentEm() { return c1AssignmentEm; }

		// "!"
		public Keyword ele10KeywordExclamationMark() { return c10KeywordExclamationMark; }
	}

	public class TrickyAElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TrickyA");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Keyword c0000KeywordTA = (Keyword)c000Group.eContents().get(0);
		private final RuleCall c0001ParserRuleCallTrickyA1 = (RuleCall)c000Group.eContents().get(1);
		private final Assignment c001AssignmentName = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010LexerRuleCallID = (RuleCall)c001AssignmentName.eContents().get(0);
		private final Alternatives c01Alternatives = (Alternatives)c0Group.eContents().get(1);
		private final Group c010Group = (Group)c01Alternatives.eContents().get(0);
		private final Action c0100ActionTypeBx = (Action)c010Group.eContents().get(0);
		private final Keyword c0101KeywordX = (Keyword)c010Group.eContents().get(1);
		private final Group c011Group = (Group)c01Alternatives.eContents().get(1);
		private final Action c0110ActionTypeCx = (Action)c011Group.eContents().get(0);
		private final Keyword c0111KeywordY = (Keyword)c011Group.eContents().get(1);
		private final Assignment c1AssignmentName = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallSTRING = (RuleCall)c1AssignmentName.eContents().get(0);
		
		// TrickyA returns TypeA1:   "TA" TrickyA1 (name+=ID)* ({current=TypeB.x=current} "x"|{current=TypeC.x=current} "y")? name+=STRING;
		public ParserRule getRule() { return rule; }

		// "TA" TrickyA1 (name+=ID)* ({current=TypeB.x=current} "x"|{current=TypeC.x=current} "y")? name+=STRING
		public Group eleGroup() { return cGroup; }

		// "TA" TrickyA1 (name+=ID)* ({current=TypeB.x=current} "x"|{current=TypeC.x=current} "y")?
		public Group ele0Group() { return c0Group; }

		// "TA" TrickyA1 (name+=ID)*
		public Group ele00Group() { return c00Group; }

		// "TA" TrickyA1
		public Group ele000Group() { return c000Group; }

		// "TA"
		public Keyword ele0000KeywordTA() { return c0000KeywordTA; }

		// TrickyA1
		public RuleCall ele0001ParserRuleCallTrickyA1() { return c0001ParserRuleCallTrickyA1; }

		// (name+=ID)*
		public Assignment ele001AssignmentName() { return c001AssignmentName; }

		// ID
		public RuleCall ele0010LexerRuleCallID() { return c0010LexerRuleCallID; }

		// ({current=TypeB.x=current} "x"|{current=TypeC.x=current} "y")?
		public Alternatives ele01Alternatives() { return c01Alternatives; }

		// {current=TypeB.x=current} "x"
		public Group ele010Group() { return c010Group; }

		// {current=TypeB.x=current}
		public Action ele0100ActionTypeBx() { return c0100ActionTypeBx; }

		// "x"
		public Keyword ele0101KeywordX() { return c0101KeywordX; }

		// {current=TypeC.x=current} "y"
		public Group ele011Group() { return c011Group; }

		// {current=TypeC.x=current}
		public Action ele0110ActionTypeCx() { return c0110ActionTypeCx; }

		// "y"
		public Keyword ele0111KeywordY() { return c0111KeywordY; }

		// name+=STRING
		public Assignment ele1AssignmentName() { return c1AssignmentName; }

		// STRING
		public RuleCall ele10LexerRuleCallSTRING() { return c10LexerRuleCallSTRING; }
	}

	public class TrickyA1Elements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TrickyA1");
		private final Assignment cAssignmentName = (Assignment)rule.eContents().get(1);
		private final RuleCall c0LexerRuleCallID = (RuleCall)cAssignmentName.eContents().get(0);
		
		// TrickyA1 returns TypeD:   name+=ID;
		public ParserRule getRule() { return rule; }

		// name+=ID
		public Assignment eleAssignmentName() { return cAssignmentName; }

		// ID
		public RuleCall ele0LexerRuleCallID() { return c0LexerRuleCallID; }
	}

	public class TrickyBElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TrickyB");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordTB = (Keyword)c0Group.eContents().get(0);
		private final Group c01Group = (Group)c0Group.eContents().get(1);
		private final Assignment c010AssignmentName = (Assignment)c01Group.eContents().get(0);
		private final RuleCall c0100LexerRuleCallID = (RuleCall)c010AssignmentName.eContents().get(0);
		private final Assignment c011AssignmentType = (Assignment)c01Group.eContents().get(1);
		private final RuleCall c0110LexerRuleCallINT = (RuleCall)c011AssignmentType.eContents().get(0);
		private final Assignment c1AssignmentType = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallINT = (RuleCall)c1AssignmentType.eContents().get(0);
		
		// TrickyB:   "TB" (name=ID type+=INT)? (type+=INT)*;
		public ParserRule getRule() { return rule; }

		// "TB" (name=ID type+=INT)? (type+=INT)*
		public Group eleGroup() { return cGroup; }

		// "TB" (name=ID type+=INT)?
		public Group ele0Group() { return c0Group; }

		// "TB"
		public Keyword ele00KeywordTB() { return c00KeywordTB; }

		// (name=ID type+=INT)?
		public Group ele01Group() { return c01Group; }

		// name=ID
		public Assignment ele010AssignmentName() { return c010AssignmentName; }

		// ID
		public RuleCall ele0100LexerRuleCallID() { return c0100LexerRuleCallID; }

		// type+=INT
		public Assignment ele011AssignmentType() { return c011AssignmentType; }

		// INT
		public RuleCall ele0110LexerRuleCallINT() { return c0110LexerRuleCallINT; }

		// (type+=INT)*
		public Assignment ele1AssignmentType() { return c1AssignmentType; }

		// INT
		public RuleCall ele10LexerRuleCallINT() { return c10LexerRuleCallINT; }
	}

	public class TrickyCElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TrickyC");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Keyword c0000KeywordTC = (Keyword)c000Group.eContents().get(0);
		private final Assignment c0001AssignmentName = (Assignment)c000Group.eContents().get(1);
		private final RuleCall c00010LexerRuleCallID = (RuleCall)c0001AssignmentName.eContents().get(0);
		private final Group c001Group = (Group)c00Group.eContents().get(1);
		private final Action c0010ActionC1x = (Action)c001Group.eContents().get(0);
		private final Keyword c0011KeywordX = (Keyword)c001Group.eContents().get(1);
		private final Group c01Group = (Group)c0Group.eContents().get(1);
		private final Action c010ActionC2y = (Action)c01Group.eContents().get(0);
		private final Keyword c011KeywordY = (Keyword)c01Group.eContents().get(1);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Action c10ActionC3z = (Action)c1Group.eContents().get(0);
		private final Keyword c11KeywordZ = (Keyword)c1Group.eContents().get(1);
		
		// TrickyC:   "TC" name=ID ({current=C1.x=current} "x")? ({current=C2.y=current} "y")? ({current=C3.z=current} "z")?;
		public ParserRule getRule() { return rule; }

		// "TC" name=ID ({current=C1.x=current} "x")? ({current=C2.y=current} "y")? ({current=C3.z=current} "z")?
		public Group eleGroup() { return cGroup; }

		// "TC" name=ID ({current=C1.x=current} "x")? ({current=C2.y=current} "y")?
		public Group ele0Group() { return c0Group; }

		// "TC" name=ID ({current=C1.x=current} "x")?
		public Group ele00Group() { return c00Group; }

		// "TC" name=ID
		public Group ele000Group() { return c000Group; }

		// "TC"
		public Keyword ele0000KeywordTC() { return c0000KeywordTC; }

		// name=ID
		public Assignment ele0001AssignmentName() { return c0001AssignmentName; }

		// ID
		public RuleCall ele00010LexerRuleCallID() { return c00010LexerRuleCallID; }

		// ({current=C1.x=current} "x")?
		public Group ele001Group() { return c001Group; }

		// {current=C1.x=current}
		public Action ele0010ActionC1x() { return c0010ActionC1x; }

		// "x"
		public Keyword ele0011KeywordX() { return c0011KeywordX; }

		// ({current=C2.y=current} "y")?
		public Group ele01Group() { return c01Group; }

		// {current=C2.y=current}
		public Action ele010ActionC2y() { return c010ActionC2y; }

		// "y"
		public Keyword ele011KeywordY() { return c011KeywordY; }

		// ({current=C3.z=current} "z")?
		public Group ele1Group() { return c1Group; }

		// {current=C3.z=current}
		public Action ele10ActionC3z() { return c10ActionC3z; }

		// "z"
		public Keyword ele11KeywordZ() { return c11KeywordZ; }
	}

	public class TrickyDElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TrickyD");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordTD = (Keyword)c00Group.eContents().get(0);
		private final Group c001Group = (Group)c00Group.eContents().get(1);
		private final Group c0010Group = (Group)c001Group.eContents().get(0);
		private final Assignment c00100AssignmentName = (Assignment)c0010Group.eContents().get(0);
		private final RuleCall c001000LexerRuleCallINT = (RuleCall)c00100AssignmentName.eContents().get(0);
		private final Assignment c00101AssignmentFoo = (Assignment)c0010Group.eContents().get(1);
		private final RuleCall c001010LexerRuleCallSTRING = (RuleCall)c00101AssignmentFoo.eContents().get(0);
		private final Assignment c0011AssignmentType = (Assignment)c001Group.eContents().get(1);
		private final RuleCall c00110LexerRuleCallID = (RuleCall)c0011AssignmentType.eContents().get(0);
		private final Group c01Group = (Group)c0Group.eContents().get(1);
		private final Assignment c010AssignmentName = (Assignment)c01Group.eContents().get(0);
		private final RuleCall c0100LexerRuleCallINT = (RuleCall)c010AssignmentName.eContents().get(0);
		private final Assignment c011AssignmentType = (Assignment)c01Group.eContents().get(1);
		private final RuleCall c0110LexerRuleCallID = (RuleCall)c011AssignmentType.eContents().get(0);
		private final Assignment c1AssignmentType = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallID = (RuleCall)c1AssignmentType.eContents().get(0);
		
		// TrickyD:   "TD" (name+=INT foo=STRING type+=ID)? (name+=INT type+=ID)? (type+=ID)*;
		public ParserRule getRule() { return rule; }

		// "TD" (name+=INT foo=STRING type+=ID)? (name+=INT type+=ID)? (type+=ID)*
		public Group eleGroup() { return cGroup; }

		// "TD" (name+=INT foo=STRING type+=ID)? (name+=INT type+=ID)?
		public Group ele0Group() { return c0Group; }

		// "TD" (name+=INT foo=STRING type+=ID)?
		public Group ele00Group() { return c00Group; }

		// "TD"
		public Keyword ele000KeywordTD() { return c000KeywordTD; }

		// (name+=INT foo=STRING type+=ID)?
		public Group ele001Group() { return c001Group; }

		// name+=INT foo=STRING
		public Group ele0010Group() { return c0010Group; }

		// name+=INT
		public Assignment ele00100AssignmentName() { return c00100AssignmentName; }

		// INT
		public RuleCall ele001000LexerRuleCallINT() { return c001000LexerRuleCallINT; }

		// foo=STRING
		public Assignment ele00101AssignmentFoo() { return c00101AssignmentFoo; }

		// STRING
		public RuleCall ele001010LexerRuleCallSTRING() { return c001010LexerRuleCallSTRING; }

		// type+=ID
		public Assignment ele0011AssignmentType() { return c0011AssignmentType; }

		// ID
		public RuleCall ele00110LexerRuleCallID() { return c00110LexerRuleCallID; }

		// (name+=INT type+=ID)?
		public Group ele01Group() { return c01Group; }

		// name+=INT
		public Assignment ele010AssignmentName() { return c010AssignmentName; }

		// INT
		public RuleCall ele0100LexerRuleCallINT() { return c0100LexerRuleCallINT; }

		// type+=ID
		public Assignment ele011AssignmentType() { return c011AssignmentType; }

		// ID
		public RuleCall ele0110LexerRuleCallID() { return c0110LexerRuleCallID; }

		// (type+=ID)*
		public Assignment ele1AssignmentType() { return c1AssignmentType; }

		// ID
		public RuleCall ele10LexerRuleCallID() { return c10LexerRuleCallID; }
	}

	public class TrickyEElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TrickyE");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordTE = (Keyword)c00Group.eContents().get(0);
		private final Group c001Group = (Group)c00Group.eContents().get(1);
		private final Group c0010Group = (Group)c001Group.eContents().get(0);
		private final Assignment c00100AssignmentName = (Assignment)c0010Group.eContents().get(0);
		private final RuleCall c001000LexerRuleCallINT = (RuleCall)c00100AssignmentName.eContents().get(0);
		private final Assignment c00101AssignmentFoo = (Assignment)c0010Group.eContents().get(1);
		private final RuleCall c001010LexerRuleCallSTRING = (RuleCall)c00101AssignmentFoo.eContents().get(0);
		private final Assignment c0011AssignmentType = (Assignment)c001Group.eContents().get(1);
		private final RuleCall c00110LexerRuleCallID = (RuleCall)c0011AssignmentType.eContents().get(0);
		private final Keyword c01KeywordX = (Keyword)c0Group.eContents().get(1);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Assignment c10AssignmentName = (Assignment)c1Group.eContents().get(0);
		private final RuleCall c100LexerRuleCallINT = (RuleCall)c10AssignmentName.eContents().get(0);
		private final Assignment c11AssignmentType = (Assignment)c1Group.eContents().get(1);
		private final RuleCall c110LexerRuleCallID = (RuleCall)c11AssignmentType.eContents().get(0);
		
		// TrickyE:   "TE" (name+=INT foo+=STRING type+=ID)* "x" (name+=INT type+=ID)*;
		public ParserRule getRule() { return rule; }

		// "TE" (name+=INT foo+=STRING type+=ID)* "x" (name+=INT type+=ID)*
		public Group eleGroup() { return cGroup; }

		// "TE" (name+=INT foo+=STRING type+=ID)* "x"
		public Group ele0Group() { return c0Group; }

		// "TE" (name+=INT foo+=STRING type+=ID)*
		public Group ele00Group() { return c00Group; }

		// "TE"
		public Keyword ele000KeywordTE() { return c000KeywordTE; }

		// (name+=INT foo+=STRING type+=ID)*
		public Group ele001Group() { return c001Group; }

		// name+=INT foo+=STRING
		public Group ele0010Group() { return c0010Group; }

		// name+=INT
		public Assignment ele00100AssignmentName() { return c00100AssignmentName; }

		// INT
		public RuleCall ele001000LexerRuleCallINT() { return c001000LexerRuleCallINT; }

		// foo+=STRING
		public Assignment ele00101AssignmentFoo() { return c00101AssignmentFoo; }

		// STRING
		public RuleCall ele001010LexerRuleCallSTRING() { return c001010LexerRuleCallSTRING; }

		// type+=ID
		public Assignment ele0011AssignmentType() { return c0011AssignmentType; }

		// ID
		public RuleCall ele00110LexerRuleCallID() { return c00110LexerRuleCallID; }

		// "x"
		public Keyword ele01KeywordX() { return c01KeywordX; }

		// (name+=INT type+=ID)*
		public Group ele1Group() { return c1Group; }

		// name+=INT
		public Assignment ele10AssignmentName() { return c10AssignmentName; }

		// INT
		public RuleCall ele100LexerRuleCallINT() { return c100LexerRuleCallINT; }

		// type+=ID
		public Assignment ele11AssignmentType() { return c11AssignmentType; }

		// ID
		public RuleCall ele110LexerRuleCallID() { return c110LexerRuleCallID; }
	}

	public class TrickyFElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TrickyF");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordTF = (Keyword)c0Group.eContents().get(0);
		private final Group c01Group = (Group)c0Group.eContents().get(1);
		private final Assignment c010AssignmentName = (Assignment)c01Group.eContents().get(0);
		private final RuleCall c0100LexerRuleCallID = (RuleCall)c010AssignmentName.eContents().get(0);
		private final Assignment c011AssignmentType = (Assignment)c01Group.eContents().get(1);
		private final RuleCall c0110LexerRuleCallINT = (RuleCall)c011AssignmentType.eContents().get(0);
		private final Alternatives c1Alternatives = (Alternatives)cGroup.eContents().get(1);
		private final Assignment c10AssignmentName = (Assignment)c1Alternatives.eContents().get(0);
		private final RuleCall c100LexerRuleCallID = (RuleCall)c10AssignmentName.eContents().get(0);
		private final Assignment c11AssignmentType = (Assignment)c1Alternatives.eContents().get(1);
		private final RuleCall c110LexerRuleCallINT = (RuleCall)c11AssignmentType.eContents().get(0);
		
		// TrickyF:   "TF" (name+=ID type+=INT)* (name+=ID|type+=INT);
		public ParserRule getRule() { return rule; }

		// "TF" (name+=ID type+=INT)* (name+=ID|type+=INT)
		public Group eleGroup() { return cGroup; }

		// "TF" (name+=ID type+=INT)*
		public Group ele0Group() { return c0Group; }

		// "TF"
		public Keyword ele00KeywordTF() { return c00KeywordTF; }

		// (name+=ID type+=INT)*
		public Group ele01Group() { return c01Group; }

		// name+=ID
		public Assignment ele010AssignmentName() { return c010AssignmentName; }

		// ID
		public RuleCall ele0100LexerRuleCallID() { return c0100LexerRuleCallID; }

		// type+=INT
		public Assignment ele011AssignmentType() { return c011AssignmentType; }

		// INT
		public RuleCall ele0110LexerRuleCallINT() { return c0110LexerRuleCallINT; }

		// name+=ID|type+=INT
		public Alternatives ele1Alternatives() { return c1Alternatives; }

		// name+=ID
		public Assignment ele10AssignmentName() { return c10AssignmentName; }

		// ID
		public RuleCall ele100LexerRuleCallID() { return c100LexerRuleCallID; }

		// type+=INT
		public Assignment ele11AssignmentType() { return c11AssignmentType; }

		// INT
		public RuleCall ele110LexerRuleCallINT() { return c110LexerRuleCallINT; }
	}

	public class TrickyGElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TrickyG");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordTG = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentTree = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10ParserRuleCallTrickyG1 = (RuleCall)c1AssignmentTree.eContents().get(0);
		
		// TrickyG:   "TG" tree=TrickyG1;
		public ParserRule getRule() { return rule; }

		// "TG" tree=TrickyG1
		public Group eleGroup() { return cGroup; }

		// "TG"
		public Keyword ele0KeywordTG() { return c0KeywordTG; }

		// tree=TrickyG1
		public Assignment ele1AssignmentTree() { return c1AssignmentTree; }

		// TrickyG1
		public RuleCall ele10ParserRuleCallTrickyG1() { return c10ParserRuleCallTrickyG1; }
	}

	public class TrickyG1Elements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TrickyG1");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordLeftSquareBracket = (Keyword)c0Group.eContents().get(0);
		private final Group c01Group = (Group)c0Group.eContents().get(1);
		private final Assignment c010AssignmentVals = (Assignment)c01Group.eContents().get(0);
		private final RuleCall c0100ParserRuleCallTrickyG2 = (RuleCall)c010AssignmentVals.eContents().get(0);
		private final Group c011Group = (Group)c01Group.eContents().get(1);
		private final Keyword c0110KeywordComma = (Keyword)c011Group.eContents().get(0);
		private final Assignment c0111AssignmentVals = (Assignment)c011Group.eContents().get(1);
		private final RuleCall c01110ParserRuleCallTrickyG2 = (RuleCall)c0111AssignmentVals.eContents().get(0);
		private final Keyword c1KeywordRightSquareBracket = (Keyword)cGroup.eContents().get(1);
		
		// TrickyG1:   "[" (vals+=TrickyG2 ("," vals+=TrickyG2)*)? "]";
		public ParserRule getRule() { return rule; }

		// "[" (vals+=TrickyG2 ("," vals+=TrickyG2)*)? "]"
		public Group eleGroup() { return cGroup; }

		// "[" (vals+=TrickyG2 ("," vals+=TrickyG2)*)?
		public Group ele0Group() { return c0Group; }

		// "["
		public Keyword ele00KeywordLeftSquareBracket() { return c00KeywordLeftSquareBracket; }

		// (vals+=TrickyG2 ("," vals+=TrickyG2)*)?
		public Group ele01Group() { return c01Group; }

		// vals+=TrickyG2
		public Assignment ele010AssignmentVals() { return c010AssignmentVals; }

		// TrickyG2
		public RuleCall ele0100ParserRuleCallTrickyG2() { return c0100ParserRuleCallTrickyG2; }

		// ("," vals+=TrickyG2)*
		public Group ele011Group() { return c011Group; }

		// ","
		public Keyword ele0110KeywordComma() { return c0110KeywordComma; }

		// vals+=TrickyG2
		public Assignment ele0111AssignmentVals() { return c0111AssignmentVals; }

		// TrickyG2
		public RuleCall ele01110ParserRuleCallTrickyG2() { return c01110ParserRuleCallTrickyG2; }

		// "]"
		public Keyword ele1KeywordRightSquareBracket() { return c1KeywordRightSquareBracket; }
	}

	public class TrickyG2Elements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TrickyG2");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallTrickyG1 = (RuleCall)cAlternatives.eContents().get(0);
		private final Assignment c1AssignmentVal = (Assignment)cAlternatives.eContents().get(1);
		private final RuleCall c10LexerRuleCallINT = (RuleCall)c1AssignmentVal.eContents().get(0);
		
		// TrickyG2:   TrickyG1|val=INT;
		public ParserRule getRule() { return rule; }

		// TrickyG1|val=INT
		public Alternatives eleAlternatives() { return cAlternatives; }

		// TrickyG1
		public RuleCall ele0ParserRuleCallTrickyG1() { return c0ParserRuleCallTrickyG1; }

		// val=INT
		public Assignment ele1AssignmentVal() { return c1AssignmentVal; }

		// INT
		public RuleCall ele10LexerRuleCallINT() { return c10LexerRuleCallINT; }
	}
	
	private RootElements pRoot;
	private OpElements pOp;
	private TermElements pTerm;
	private AtomElements pAtom;
	private ParensElements pParens;
	private TrickyAElements pTrickyA;
	private TrickyA1Elements pTrickyA1;
	private TrickyBElements pTrickyB;
	private TrickyCElements pTrickyC;
	private TrickyDElements pTrickyD;
	private TrickyEElements pTrickyE;
	private TrickyFElements pTrickyF;
	private TrickyGElements pTrickyG;
	private TrickyG1Elements pTrickyG1;
	private TrickyG2Elements pTrickyG2;
	
	private final GrammarProvider grammarProvider;

	private XtextBuiltinGrammarAccess superGrammarAccess;

	@Inject
	public ComplexReconstrTestLanguageGrammarAccess(GrammarProvider grammarProvider, XtextBuiltinGrammarAccess superGrammarAccess) {
		this.grammarProvider = grammarProvider;
		this.superGrammarAccess = superGrammarAccess;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	public XtextBuiltinGrammarAccess getSuperGrammarAccess() {
		return superGrammarAccess;
	}

	
	// Root:   Op|TrickyG;
	public RootElements prRoot() {
		return (pRoot != null) ? pRoot : (pRoot = new RootElements());
	} 

	// Op returns Expression:   Term ({current=Add.addOperands+=current} "+" addOperands+=Term|{current=Minus.minusOperands+=current} "-" minusOperands+=Term)*;
	public OpElements prOp() {
		return (pOp != null) ? pOp : (pOp = new OpElements());
	} 

	// Term returns Expression:   Atom|Parens;
	public TermElements prTerm() {
		return (pTerm != null) ? pTerm : (pTerm = new TermElements());
	} 

	// Atom:   name=ID;
	public AtomElements prAtom() {
		return (pAtom != null) ? pAtom : (pAtom = new AtomElements());
	} 

	// Parens returns Expression:   "(" Op ")" (em="!")?;
	public ParensElements prParens() {
		return (pParens != null) ? pParens : (pParens = new ParensElements());
	} 

	// TrickyA returns TypeA1:   "TA" TrickyA1 (name+=ID)* ({current=TypeB.x=current} "x"|{current=TypeC.x=current} "y")? name+=STRING;
	public TrickyAElements prTrickyA() {
		return (pTrickyA != null) ? pTrickyA : (pTrickyA = new TrickyAElements());
	} 

	// TrickyA1 returns TypeD:   name+=ID;
	public TrickyA1Elements prTrickyA1() {
		return (pTrickyA1 != null) ? pTrickyA1 : (pTrickyA1 = new TrickyA1Elements());
	} 

	// TrickyB:   "TB" (name=ID type+=INT)? (type+=INT)*;
	public TrickyBElements prTrickyB() {
		return (pTrickyB != null) ? pTrickyB : (pTrickyB = new TrickyBElements());
	} 

	// TrickyC:   "TC" name=ID ({current=C1.x=current} "x")? ({current=C2.y=current} "y")? ({current=C3.z=current} "z")?;
	public TrickyCElements prTrickyC() {
		return (pTrickyC != null) ? pTrickyC : (pTrickyC = new TrickyCElements());
	} 

	// TrickyD:   "TD" (name+=INT foo=STRING type+=ID)? (name+=INT type+=ID)? (type+=ID)*;
	public TrickyDElements prTrickyD() {
		return (pTrickyD != null) ? pTrickyD : (pTrickyD = new TrickyDElements());
	} 

	// TrickyE:   "TE" (name+=INT foo+=STRING type+=ID)* "x" (name+=INT type+=ID)*;
	public TrickyEElements prTrickyE() {
		return (pTrickyE != null) ? pTrickyE : (pTrickyE = new TrickyEElements());
	} 

	// TrickyF:   "TF" (name+=ID type+=INT)* (name+=ID|type+=INT);
	public TrickyFElements prTrickyF() {
		return (pTrickyF != null) ? pTrickyF : (pTrickyF = new TrickyFElements());
	} 

	// TrickyG:   "TG" tree=TrickyG1;
	public TrickyGElements prTrickyG() {
		return (pTrickyG != null) ? pTrickyG : (pTrickyG = new TrickyGElements());
	} 

	// TrickyG1:   "[" (vals+=TrickyG2 ("," vals+=TrickyG2)*)? "]";
	public TrickyG1Elements prTrickyG1() {
		return (pTrickyG1 != null) ? pTrickyG1 : (pTrickyG1 = new TrickyG1Elements());
	} 

	// TrickyG2:   TrickyG1|val=INT;
	public TrickyG2Elements prTrickyG2() {
		return (pTrickyG2 != null) ? pTrickyG2 : (pTrickyG2 = new TrickyG2Elements());
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
