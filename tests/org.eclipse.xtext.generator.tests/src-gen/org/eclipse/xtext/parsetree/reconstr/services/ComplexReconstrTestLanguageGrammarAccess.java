/*
Generated with Xtext
*/

package org.eclipse.xtext.parsetree.reconstr.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class ComplexReconstrTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class OpElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private RuleCall c0ParserRuleCallTerm;
		private Alternatives c1Alternatives;
		private Group c10Group;
		private Group c100Group;
		private Action c1000ActionAddaddOperands;
		private Keyword c1001Keyword;
		private Assignment c101AssignmentAddOperands;
		private RuleCall c1010ParserRuleCallTerm;
		private Group c11Group;
		private Group c110Group;
		private Action c1100ActionMinusminusOperands;
		private Keyword c1101Keyword;
		private Assignment c111AssignmentMinusOperands;
		private RuleCall c1110ParserRuleCallTerm;
		
		// (error)
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(1)); 
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
		public Alternatives ele1Alternatives() {
			return (c1Alternatives != null) ? c1Alternatives : (c1Alternatives = (Alternatives)eleGroup().eContents().get(1)); 
		}

		// (error)
		public Group ele10Group() {
			return (c10Group != null) ? c10Group : (c10Group = (Group)ele1Alternatives().eContents().get(0)); 
		}

		// (error)
		public Group ele100Group() {
			return (c100Group != null) ? c100Group : (c100Group = (Group)ele10Group().eContents().get(0)); 
		}

		// (error)
		public Action ele1000ActionAddaddOperands() {
			return (c1000ActionAddaddOperands != null) ? c1000ActionAddaddOperands : (c1000ActionAddaddOperands = (Action)ele100Group().eContents().get(0)); 
		}

		// '+'
		public Keyword ele1001Keyword() {
			return (c1001Keyword != null) ? c1001Keyword : (c1001Keyword = (Keyword)ele100Group().eContents().get(1)); 
		}

		// addOperands += Term
		public Assignment ele101AssignmentAddOperands() {
			return (c101AssignmentAddOperands != null) ? c101AssignmentAddOperands : (c101AssignmentAddOperands = (Assignment)ele10Group().eContents().get(1)); 
		}

		// Term
		public RuleCall ele1010ParserRuleCallTerm() {
			return (c1010ParserRuleCallTerm != null) ? c1010ParserRuleCallTerm : (c1010ParserRuleCallTerm = (RuleCall)ele101AssignmentAddOperands().eContents().get(0)); 
		}

		// (error)
		public Group ele11Group() {
			return (c11Group != null) ? c11Group : (c11Group = (Group)ele1Alternatives().eContents().get(1)); 
		}

		// (error)
		public Group ele110Group() {
			return (c110Group != null) ? c110Group : (c110Group = (Group)ele11Group().eContents().get(0)); 
		}

		// (error)
		public Action ele1100ActionMinusminusOperands() {
			return (c1100ActionMinusminusOperands != null) ? c1100ActionMinusminusOperands : (c1100ActionMinusminusOperands = (Action)ele110Group().eContents().get(0)); 
		}

		// '-'
		public Keyword ele1101Keyword() {
			return (c1101Keyword != null) ? c1101Keyword : (c1101Keyword = (Keyword)ele110Group().eContents().get(1)); 
		}

		// minusOperands += Term
		public Assignment ele111AssignmentMinusOperands() {
			return (c111AssignmentMinusOperands != null) ? c111AssignmentMinusOperands : (c111AssignmentMinusOperands = (Assignment)ele11Group().eContents().get(1)); 
		}

		// Term
		public RuleCall ele1110ParserRuleCallTerm() {
			return (c1110ParserRuleCallTerm != null) ? c1110ParserRuleCallTerm : (c1110ParserRuleCallTerm = (RuleCall)ele111AssignmentMinusOperands().eContents().get(0)); 
		}
	}

	public class TermElements implements IParserRuleAccess {
		private ParserRule rule;
		private Alternatives cAlternatives;
		private RuleCall c0ParserRuleCallAtom;
		private RuleCall c1ParserRuleCallParens;
		
		// (error)
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(2)); 
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
		
		// (error)
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

	public class TrickyAElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Group c000Group;
		private Keyword c0000KeywordTA;
		private RuleCall c0001ParserRuleCallTrickyA1;
		private Assignment c001AssignmentName;
		private RuleCall c0010LexerRuleCallID;
		private Alternatives c01Alternatives;
		private Group c010Group;
		private Action c0100ActionTypeBx;
		private Keyword c0101KeywordX;
		private Group c011Group;
		private Action c0110ActionTypeCx;
		private Keyword c0111KeywordY;
		private Assignment c1AssignmentName;
		private RuleCall c10LexerRuleCallSTRING;
		
		// (error)
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(5)); 
		}

		// (error)
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(1)); 
		}

		// (error)
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'TA' TrickyA1 ( name += ID ) *
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// 'TA' TrickyA1
		public Group ele000Group() {
			return (c000Group != null) ? c000Group : (c000Group = (Group)ele00Group().eContents().get(0)); 
		}

		// 'TA'
		public Keyword ele0000KeywordTA() {
			return (c0000KeywordTA != null) ? c0000KeywordTA : (c0000KeywordTA = (Keyword)ele000Group().eContents().get(0)); 
		}

		// TrickyA1
		public RuleCall ele0001ParserRuleCallTrickyA1() {
			return (c0001ParserRuleCallTrickyA1 != null) ? c0001ParserRuleCallTrickyA1 : (c0001ParserRuleCallTrickyA1 = (RuleCall)ele000Group().eContents().get(1)); 
		}

		// ( name += ID ) *
		public Assignment ele001AssignmentName() {
			return (c001AssignmentName != null) ? c001AssignmentName : (c001AssignmentName = (Assignment)ele00Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele0010LexerRuleCallID() {
			return (c0010LexerRuleCallID != null) ? c0010LexerRuleCallID : (c0010LexerRuleCallID = (RuleCall)ele001AssignmentName().eContents().get(0)); 
		}

		// (error)
		public Alternatives ele01Alternatives() {
			return (c01Alternatives != null) ? c01Alternatives : (c01Alternatives = (Alternatives)ele0Group().eContents().get(1)); 
		}

		// (error)
		public Group ele010Group() {
			return (c010Group != null) ? c010Group : (c010Group = (Group)ele01Alternatives().eContents().get(0)); 
		}

		// (error)
		public Action ele0100ActionTypeBx() {
			return (c0100ActionTypeBx != null) ? c0100ActionTypeBx : (c0100ActionTypeBx = (Action)ele010Group().eContents().get(0)); 
		}

		// 'x'
		public Keyword ele0101KeywordX() {
			return (c0101KeywordX != null) ? c0101KeywordX : (c0101KeywordX = (Keyword)ele010Group().eContents().get(1)); 
		}

		// (error)
		public Group ele011Group() {
			return (c011Group != null) ? c011Group : (c011Group = (Group)ele01Alternatives().eContents().get(1)); 
		}

		// (error)
		public Action ele0110ActionTypeCx() {
			return (c0110ActionTypeCx != null) ? c0110ActionTypeCx : (c0110ActionTypeCx = (Action)ele011Group().eContents().get(0)); 
		}

		// 'y'
		public Keyword ele0111KeywordY() {
			return (c0111KeywordY != null) ? c0111KeywordY : (c0111KeywordY = (Keyword)ele011Group().eContents().get(1)); 
		}

		// name += STRING
		public Assignment ele1AssignmentName() {
			return (c1AssignmentName != null) ? c1AssignmentName : (c1AssignmentName = (Assignment)eleGroup().eContents().get(1)); 
		}

		// STRING
		public RuleCall ele10LexerRuleCallSTRING() {
			return (c10LexerRuleCallSTRING != null) ? c10LexerRuleCallSTRING : (c10LexerRuleCallSTRING = (RuleCall)ele1AssignmentName().eContents().get(0)); 
		}
	}

	public class TrickyA1Elements implements IParserRuleAccess {
		private ParserRule rule;
		private Assignment cAssignmentName;
		private RuleCall c0LexerRuleCallID;
		
		// (error)
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(6)); 
		}

		// name += ID
		public Assignment eleAssignmentName() {
			return (cAssignmentName != null) ? cAssignmentName : (cAssignmentName = (Assignment)getRule().eContents().get(1)); 
		}

		// ID
		public RuleCall ele0LexerRuleCallID() {
			return (c0LexerRuleCallID != null) ? c0LexerRuleCallID : (c0LexerRuleCallID = (RuleCall)eleAssignmentName().eContents().get(0)); 
		}
	}

	public class TrickyBElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Keyword c00KeywordTB;
		private Group c01Group;
		private Assignment c010AssignmentName;
		private RuleCall c0100LexerRuleCallID;
		private Assignment c011AssignmentType;
		private RuleCall c0110LexerRuleCallINT;
		private Assignment c1AssignmentType;
		private RuleCall c10LexerRuleCallID;
		
		// TrickyB : 'TB' ( name = ID type += INT ) ? ( type += ID ) * ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(7)); 
		}

		// 'TB' ( name = ID type += INT ) ? ( type += ID ) *
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// 'TB' ( name = ID type += INT ) ?
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'TB'
		public Keyword ele00KeywordTB() {
			return (c00KeywordTB != null) ? c00KeywordTB : (c00KeywordTB = (Keyword)ele0Group().eContents().get(0)); 
		}

		// ( name = ID type += INT ) ?
		public Group ele01Group() {
			return (c01Group != null) ? c01Group : (c01Group = (Group)ele0Group().eContents().get(1)); 
		}

		// name = ID
		public Assignment ele010AssignmentName() {
			return (c010AssignmentName != null) ? c010AssignmentName : (c010AssignmentName = (Assignment)ele01Group().eContents().get(0)); 
		}

		// ID
		public RuleCall ele0100LexerRuleCallID() {
			return (c0100LexerRuleCallID != null) ? c0100LexerRuleCallID : (c0100LexerRuleCallID = (RuleCall)ele010AssignmentName().eContents().get(0)); 
		}

		// type += INT
		public Assignment ele011AssignmentType() {
			return (c011AssignmentType != null) ? c011AssignmentType : (c011AssignmentType = (Assignment)ele01Group().eContents().get(1)); 
		}

		// INT
		public RuleCall ele0110LexerRuleCallINT() {
			return (c0110LexerRuleCallINT != null) ? c0110LexerRuleCallINT : (c0110LexerRuleCallINT = (RuleCall)ele011AssignmentType().eContents().get(0)); 
		}

		// ( type += ID ) *
		public Assignment ele1AssignmentType() {
			return (c1AssignmentType != null) ? c1AssignmentType : (c1AssignmentType = (Assignment)eleGroup().eContents().get(1)); 
		}

		// ID
		public RuleCall ele10LexerRuleCallID() {
			return (c10LexerRuleCallID != null) ? c10LexerRuleCallID : (c10LexerRuleCallID = (RuleCall)ele1AssignmentType().eContents().get(0)); 
		}
	}

	public class TrickyCElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Group c000Group;
		private Keyword c0000KeywordTC;
		private Assignment c0001AssignmentName;
		private RuleCall c00010LexerRuleCallID;
		private Group c001Group;
		private Action c0010ActionC1x;
		private Keyword c0011KeywordX;
		private Group c01Group;
		private Action c010ActionC2y;
		private Keyword c011KeywordY;
		private Group c1Group;
		private Action c10ActionC3z;
		private Keyword c11KeywordZ;
		
		// (error)
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(8)); 
		}

		// (error)
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// (error)
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// (error)
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// 'TC' name = ID
		public Group ele000Group() {
			return (c000Group != null) ? c000Group : (c000Group = (Group)ele00Group().eContents().get(0)); 
		}

		// 'TC'
		public Keyword ele0000KeywordTC() {
			return (c0000KeywordTC != null) ? c0000KeywordTC : (c0000KeywordTC = (Keyword)ele000Group().eContents().get(0)); 
		}

		// name = ID
		public Assignment ele0001AssignmentName() {
			return (c0001AssignmentName != null) ? c0001AssignmentName : (c0001AssignmentName = (Assignment)ele000Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele00010LexerRuleCallID() {
			return (c00010LexerRuleCallID != null) ? c00010LexerRuleCallID : (c00010LexerRuleCallID = (RuleCall)ele0001AssignmentName().eContents().get(0)); 
		}

		// (error)
		public Group ele001Group() {
			return (c001Group != null) ? c001Group : (c001Group = (Group)ele00Group().eContents().get(1)); 
		}

		// (error)
		public Action ele0010ActionC1x() {
			return (c0010ActionC1x != null) ? c0010ActionC1x : (c0010ActionC1x = (Action)ele001Group().eContents().get(0)); 
		}

		// 'x'
		public Keyword ele0011KeywordX() {
			return (c0011KeywordX != null) ? c0011KeywordX : (c0011KeywordX = (Keyword)ele001Group().eContents().get(1)); 
		}

		// (error)
		public Group ele01Group() {
			return (c01Group != null) ? c01Group : (c01Group = (Group)ele0Group().eContents().get(1)); 
		}

		// (error)
		public Action ele010ActionC2y() {
			return (c010ActionC2y != null) ? c010ActionC2y : (c010ActionC2y = (Action)ele01Group().eContents().get(0)); 
		}

		// 'y'
		public Keyword ele011KeywordY() {
			return (c011KeywordY != null) ? c011KeywordY : (c011KeywordY = (Keyword)ele01Group().eContents().get(1)); 
		}

		// (error)
		public Group ele1Group() {
			return (c1Group != null) ? c1Group : (c1Group = (Group)eleGroup().eContents().get(1)); 
		}

		// (error)
		public Action ele10ActionC3z() {
			return (c10ActionC3z != null) ? c10ActionC3z : (c10ActionC3z = (Action)ele1Group().eContents().get(0)); 
		}

		// 'z'
		public Keyword ele11KeywordZ() {
			return (c11KeywordZ != null) ? c11KeywordZ : (c11KeywordZ = (Keyword)ele1Group().eContents().get(1)); 
		}
	}

	public class TrickyDElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Keyword c000KeywordTD;
		private Group c001Group;
		private Group c0010Group;
		private Assignment c00100AssignmentName;
		private RuleCall c001000LexerRuleCallINT;
		private Assignment c00101AssignmentFoo;
		private RuleCall c001010LexerRuleCallSTRING;
		private Assignment c0011AssignmentType;
		private RuleCall c00110LexerRuleCallID;
		private Group c01Group;
		private Assignment c010AssignmentName;
		private RuleCall c0100LexerRuleCallINT;
		private Assignment c011AssignmentType;
		private RuleCall c0110LexerRuleCallID;
		private Assignment c1AssignmentType;
		private RuleCall c10LexerRuleCallID;
		
		// TrickyD : 'TD' ( name += INT foo = STRING type += ID ) ? ( name += INT type += ID ) ? ( type += ID ) * ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(9)); 
		}

		// 'TD' ( name += INT foo = STRING type += ID ) ? ( name += INT type += ID ) ? ( type += ID ) *
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// 'TD' ( name += INT foo = STRING type += ID ) ? ( name += INT type += ID ) ?
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'TD' ( name += INT foo = STRING type += ID ) ?
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// 'TD'
		public Keyword ele000KeywordTD() {
			return (c000KeywordTD != null) ? c000KeywordTD : (c000KeywordTD = (Keyword)ele00Group().eContents().get(0)); 
		}

		// ( name += INT foo = STRING type += ID ) ?
		public Group ele001Group() {
			return (c001Group != null) ? c001Group : (c001Group = (Group)ele00Group().eContents().get(1)); 
		}

		// name += INT foo = STRING
		public Group ele0010Group() {
			return (c0010Group != null) ? c0010Group : (c0010Group = (Group)ele001Group().eContents().get(0)); 
		}

		// name += INT
		public Assignment ele00100AssignmentName() {
			return (c00100AssignmentName != null) ? c00100AssignmentName : (c00100AssignmentName = (Assignment)ele0010Group().eContents().get(0)); 
		}

		// INT
		public RuleCall ele001000LexerRuleCallINT() {
			return (c001000LexerRuleCallINT != null) ? c001000LexerRuleCallINT : (c001000LexerRuleCallINT = (RuleCall)ele00100AssignmentName().eContents().get(0)); 
		}

		// foo = STRING
		public Assignment ele00101AssignmentFoo() {
			return (c00101AssignmentFoo != null) ? c00101AssignmentFoo : (c00101AssignmentFoo = (Assignment)ele0010Group().eContents().get(1)); 
		}

		// STRING
		public RuleCall ele001010LexerRuleCallSTRING() {
			return (c001010LexerRuleCallSTRING != null) ? c001010LexerRuleCallSTRING : (c001010LexerRuleCallSTRING = (RuleCall)ele00101AssignmentFoo().eContents().get(0)); 
		}

		// type += ID
		public Assignment ele0011AssignmentType() {
			return (c0011AssignmentType != null) ? c0011AssignmentType : (c0011AssignmentType = (Assignment)ele001Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele00110LexerRuleCallID() {
			return (c00110LexerRuleCallID != null) ? c00110LexerRuleCallID : (c00110LexerRuleCallID = (RuleCall)ele0011AssignmentType().eContents().get(0)); 
		}

		// ( name += INT type += ID ) ?
		public Group ele01Group() {
			return (c01Group != null) ? c01Group : (c01Group = (Group)ele0Group().eContents().get(1)); 
		}

		// name += INT
		public Assignment ele010AssignmentName() {
			return (c010AssignmentName != null) ? c010AssignmentName : (c010AssignmentName = (Assignment)ele01Group().eContents().get(0)); 
		}

		// INT
		public RuleCall ele0100LexerRuleCallINT() {
			return (c0100LexerRuleCallINT != null) ? c0100LexerRuleCallINT : (c0100LexerRuleCallINT = (RuleCall)ele010AssignmentName().eContents().get(0)); 
		}

		// type += ID
		public Assignment ele011AssignmentType() {
			return (c011AssignmentType != null) ? c011AssignmentType : (c011AssignmentType = (Assignment)ele01Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele0110LexerRuleCallID() {
			return (c0110LexerRuleCallID != null) ? c0110LexerRuleCallID : (c0110LexerRuleCallID = (RuleCall)ele011AssignmentType().eContents().get(0)); 
		}

		// ( type += ID ) *
		public Assignment ele1AssignmentType() {
			return (c1AssignmentType != null) ? c1AssignmentType : (c1AssignmentType = (Assignment)eleGroup().eContents().get(1)); 
		}

		// ID
		public RuleCall ele10LexerRuleCallID() {
			return (c10LexerRuleCallID != null) ? c10LexerRuleCallID : (c10LexerRuleCallID = (RuleCall)ele1AssignmentType().eContents().get(0)); 
		}
	}

	public class TrickyEElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Keyword c000KeywordTE;
		private Group c001Group;
		private Group c0010Group;
		private Assignment c00100AssignmentName;
		private RuleCall c001000LexerRuleCallINT;
		private Assignment c00101AssignmentFoo;
		private RuleCall c001010LexerRuleCallSTRING;
		private Assignment c0011AssignmentType;
		private RuleCall c00110LexerRuleCallID;
		private Keyword c01KeywordX;
		private Group c1Group;
		private Assignment c10AssignmentName;
		private RuleCall c100LexerRuleCallINT;
		private Assignment c11AssignmentType;
		private RuleCall c110LexerRuleCallID;
		
		// TrickyE : 'TE' ( name += INT foo += STRING type += ID ) * 'x' ( name += INT type += ID ) * ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(10)); 
		}

		// 'TE' ( name += INT foo += STRING type += ID ) * 'x' ( name += INT type += ID ) *
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// 'TE' ( name += INT foo += STRING type += ID ) * 'x'
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'TE' ( name += INT foo += STRING type += ID ) *
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// 'TE'
		public Keyword ele000KeywordTE() {
			return (c000KeywordTE != null) ? c000KeywordTE : (c000KeywordTE = (Keyword)ele00Group().eContents().get(0)); 
		}

		// ( name += INT foo += STRING type += ID ) *
		public Group ele001Group() {
			return (c001Group != null) ? c001Group : (c001Group = (Group)ele00Group().eContents().get(1)); 
		}

		// name += INT foo += STRING
		public Group ele0010Group() {
			return (c0010Group != null) ? c0010Group : (c0010Group = (Group)ele001Group().eContents().get(0)); 
		}

		// name += INT
		public Assignment ele00100AssignmentName() {
			return (c00100AssignmentName != null) ? c00100AssignmentName : (c00100AssignmentName = (Assignment)ele0010Group().eContents().get(0)); 
		}

		// INT
		public RuleCall ele001000LexerRuleCallINT() {
			return (c001000LexerRuleCallINT != null) ? c001000LexerRuleCallINT : (c001000LexerRuleCallINT = (RuleCall)ele00100AssignmentName().eContents().get(0)); 
		}

		// foo += STRING
		public Assignment ele00101AssignmentFoo() {
			return (c00101AssignmentFoo != null) ? c00101AssignmentFoo : (c00101AssignmentFoo = (Assignment)ele0010Group().eContents().get(1)); 
		}

		// STRING
		public RuleCall ele001010LexerRuleCallSTRING() {
			return (c001010LexerRuleCallSTRING != null) ? c001010LexerRuleCallSTRING : (c001010LexerRuleCallSTRING = (RuleCall)ele00101AssignmentFoo().eContents().get(0)); 
		}

		// type += ID
		public Assignment ele0011AssignmentType() {
			return (c0011AssignmentType != null) ? c0011AssignmentType : (c0011AssignmentType = (Assignment)ele001Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele00110LexerRuleCallID() {
			return (c00110LexerRuleCallID != null) ? c00110LexerRuleCallID : (c00110LexerRuleCallID = (RuleCall)ele0011AssignmentType().eContents().get(0)); 
		}

		// 'x'
		public Keyword ele01KeywordX() {
			return (c01KeywordX != null) ? c01KeywordX : (c01KeywordX = (Keyword)ele0Group().eContents().get(1)); 
		}

		// ( name += INT type += ID ) *
		public Group ele1Group() {
			return (c1Group != null) ? c1Group : (c1Group = (Group)eleGroup().eContents().get(1)); 
		}

		// name += INT
		public Assignment ele10AssignmentName() {
			return (c10AssignmentName != null) ? c10AssignmentName : (c10AssignmentName = (Assignment)ele1Group().eContents().get(0)); 
		}

		// INT
		public RuleCall ele100LexerRuleCallINT() {
			return (c100LexerRuleCallINT != null) ? c100LexerRuleCallINT : (c100LexerRuleCallINT = (RuleCall)ele10AssignmentName().eContents().get(0)); 
		}

		// type += ID
		public Assignment ele11AssignmentType() {
			return (c11AssignmentType != null) ? c11AssignmentType : (c11AssignmentType = (Assignment)ele1Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele110LexerRuleCallID() {
			return (c110LexerRuleCallID != null) ? c110LexerRuleCallID : (c110LexerRuleCallID = (RuleCall)ele11AssignmentType().eContents().get(0)); 
		}
	}

	public class TrickyFElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Keyword c00KeywordTF;
		private Group c01Group;
		private Assignment c010AssignmentName;
		private RuleCall c0100LexerRuleCallID;
		private Assignment c011AssignmentType;
		private RuleCall c0110LexerRuleCallINT;
		private Alternatives c1Alternatives;
		private Assignment c10AssignmentName;
		private RuleCall c100LexerRuleCallID;
		private Assignment c11AssignmentType;
		private RuleCall c110LexerRuleCallINT;
		
		// TrickyF : 'TF' ( name += ID type += INT ) * ( name += ID | type += INT ) ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(11)); 
		}

		// 'TF' ( name += ID type += INT ) * ( name += ID | type += INT )
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// 'TF' ( name += ID type += INT ) *
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'TF'
		public Keyword ele00KeywordTF() {
			return (c00KeywordTF != null) ? c00KeywordTF : (c00KeywordTF = (Keyword)ele0Group().eContents().get(0)); 
		}

		// ( name += ID type += INT ) *
		public Group ele01Group() {
			return (c01Group != null) ? c01Group : (c01Group = (Group)ele0Group().eContents().get(1)); 
		}

		// name += ID
		public Assignment ele010AssignmentName() {
			return (c010AssignmentName != null) ? c010AssignmentName : (c010AssignmentName = (Assignment)ele01Group().eContents().get(0)); 
		}

		// ID
		public RuleCall ele0100LexerRuleCallID() {
			return (c0100LexerRuleCallID != null) ? c0100LexerRuleCallID : (c0100LexerRuleCallID = (RuleCall)ele010AssignmentName().eContents().get(0)); 
		}

		// type += INT
		public Assignment ele011AssignmentType() {
			return (c011AssignmentType != null) ? c011AssignmentType : (c011AssignmentType = (Assignment)ele01Group().eContents().get(1)); 
		}

		// INT
		public RuleCall ele0110LexerRuleCallINT() {
			return (c0110LexerRuleCallINT != null) ? c0110LexerRuleCallINT : (c0110LexerRuleCallINT = (RuleCall)ele011AssignmentType().eContents().get(0)); 
		}

		// name += ID | type += INT
		public Alternatives ele1Alternatives() {
			return (c1Alternatives != null) ? c1Alternatives : (c1Alternatives = (Alternatives)eleGroup().eContents().get(1)); 
		}

		// name += ID
		public Assignment ele10AssignmentName() {
			return (c10AssignmentName != null) ? c10AssignmentName : (c10AssignmentName = (Assignment)ele1Alternatives().eContents().get(0)); 
		}

		// ID
		public RuleCall ele100LexerRuleCallID() {
			return (c100LexerRuleCallID != null) ? c100LexerRuleCallID : (c100LexerRuleCallID = (RuleCall)ele10AssignmentName().eContents().get(0)); 
		}

		// type += INT
		public Assignment ele11AssignmentType() {
			return (c11AssignmentType != null) ? c11AssignmentType : (c11AssignmentType = (Assignment)ele1Alternatives().eContents().get(1)); 
		}

		// INT
		public RuleCall ele110LexerRuleCallINT() {
			return (c110LexerRuleCallINT != null) ? c110LexerRuleCallINT : (c110LexerRuleCallINT = (RuleCall)ele11AssignmentType().eContents().get(0)); 
		}
	}
	
	public final static ComplexReconstrTestLanguageGrammarAccess INSTANCE = new ComplexReconstrTestLanguageGrammarAccess();

	private static final String COMPLEXRECONSTRTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static OpElements pOp;
	private static TermElements pTerm;
	private static AtomElements pAtom;
	private static ParensElements pParens;
	private static TrickyAElements pTrickyA;
	private static TrickyA1Elements pTrickyA1;
	private static TrickyBElements pTrickyB;
	private static TrickyCElements pTrickyC;
	private static TrickyDElements pTrickyD;
	private static TrickyEElements pTrickyE;
	private static TrickyFElements pTrickyF;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(ComplexReconstrTestLanguageGrammarAccess.class.getClassLoader(),COMPLEXRECONSTRTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;		
	}

	
	// (error)
	public OpElements prOp() {
		return (pOp != null) ? pOp : (pOp = new OpElements());
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

	// (error)
	public TrickyAElements prTrickyA() {
		return (pTrickyA != null) ? pTrickyA : (pTrickyA = new TrickyAElements());
	} 

	// (error)
	public TrickyA1Elements prTrickyA1() {
		return (pTrickyA1 != null) ? pTrickyA1 : (pTrickyA1 = new TrickyA1Elements());
	} 

	// TrickyB : 'TB' ( name = ID type += INT ) ? ( type += ID ) * ;
	public TrickyBElements prTrickyB() {
		return (pTrickyB != null) ? pTrickyB : (pTrickyB = new TrickyBElements());
	} 

	// (error)
	public TrickyCElements prTrickyC() {
		return (pTrickyC != null) ? pTrickyC : (pTrickyC = new TrickyCElements());
	} 

	// TrickyD : 'TD' ( name += INT foo = STRING type += ID ) ? ( name += INT type += ID ) ? ( type += ID ) * ;
	public TrickyDElements prTrickyD() {
		return (pTrickyD != null) ? pTrickyD : (pTrickyD = new TrickyDElements());
	} 

	// TrickyE : 'TE' ( name += INT foo += STRING type += ID ) * 'x' ( name += INT type += ID ) * ;
	public TrickyEElements prTrickyE() {
		return (pTrickyE != null) ? pTrickyE : (pTrickyE = new TrickyEElements());
	} 

	// TrickyF : 'TF' ( name += ID type += INT ) * ( name += ID | type += INT ) ;
	public TrickyFElements prTrickyF() {
		return (pTrickyF != null) ? pTrickyF : (pTrickyF = new TrickyFElements());
	} 
}
