/*
Generated with Xtext
*/

package org.eclipse.xtext.parser.terminalrules.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;

import org.eclipse.xtext.service.GrammarProvider;


@Singleton
public class HiddenTerminalsTestLanguageGrammarAccess implements IGrammarAccess {
	
	
	public class ModelElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Model");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Alternatives c0Alternatives = (Alternatives)cAlternatives.eContents().get(0);
		private final Alternatives c00Alternatives = (Alternatives)c0Alternatives.eContents().get(0);
		private final Alternatives c000Alternatives = (Alternatives)c00Alternatives.eContents().get(0);
		private final RuleCall c0000ParserRuleCallWithoutHiddens = (RuleCall)c000Alternatives.eContents().get(0);
		private final RuleCall c0001ParserRuleCallWithHiddens = (RuleCall)c000Alternatives.eContents().get(1);
		private final RuleCall c001ParserRuleCallOverridingHiddens = (RuleCall)c00Alternatives.eContents().get(1);
		private final RuleCall c01ParserRuleCallInheritingHiddens = (RuleCall)c0Alternatives.eContents().get(1);
		private final RuleCall c1ParserRuleCallDatatypeHiddens = (RuleCall)cAlternatives.eContents().get(1);
		
		// Model:   WithoutHiddens|WithHiddens|OverridingHiddens|InheritingHiddens|DatatypeHiddens;
		public ParserRule getRule() { return rule; }

		// WithoutHiddens|WithHiddens|OverridingHiddens|InheritingHiddens|DatatypeHiddens
		public Alternatives eleAlternatives() { return cAlternatives; }

		// WithoutHiddens|WithHiddens|OverridingHiddens|InheritingHiddens
		public Alternatives ele0Alternatives() { return c0Alternatives; }

		// WithoutHiddens|WithHiddens|OverridingHiddens
		public Alternatives ele00Alternatives() { return c00Alternatives; }

		// WithoutHiddens|WithHiddens
		public Alternatives ele000Alternatives() { return c000Alternatives; }

		// WithoutHiddens
		public RuleCall ele0000ParserRuleCallWithoutHiddens() { return c0000ParserRuleCallWithoutHiddens; }

		// WithHiddens
		public RuleCall ele0001ParserRuleCallWithHiddens() { return c0001ParserRuleCallWithHiddens; }

		// OverridingHiddens
		public RuleCall ele001ParserRuleCallOverridingHiddens() { return c001ParserRuleCallOverridingHiddens; }

		// InheritingHiddens
		public RuleCall ele01ParserRuleCallInheritingHiddens() { return c01ParserRuleCallInheritingHiddens; }

		// DatatypeHiddens
		public RuleCall ele1ParserRuleCallDatatypeHiddens() { return c1ParserRuleCallDatatypeHiddens; }
	}

	public class WithoutHiddensElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "WithoutHiddens");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Keyword c0000KeywordWithout = (Keyword)c000Group.eContents().get(0);
		private final Assignment c0001AssignmentSpaces = (Assignment)c000Group.eContents().get(1);
		private final RuleCall c00010ParserRuleCallWS = (RuleCall)c0001AssignmentSpaces.eContents().get(0);
		private final Keyword c001KeywordHiddens = (Keyword)c00Group.eContents().get(1);
		private final Assignment c01AssignmentSpaces = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010ParserRuleCallWS = (RuleCall)c01AssignmentSpaces.eContents().get(0);
		private final Assignment c1AssignmentValid = (Assignment)cGroup.eContents().get(1);
		private final Keyword c10KeywordSemicolon = (Keyword)c1AssignmentValid.eContents().get(0);
		
		// WithoutHiddens:   "without" spaces+=WS "hiddens" (spaces+=WS)? valid?=";";
		public ParserRule getRule() { return rule; }

		// "without" spaces+=WS "hiddens" (spaces+=WS)? valid?=";"
		public Group eleGroup() { return cGroup; }

		// "without" spaces+=WS "hiddens" (spaces+=WS)?
		public Group ele0Group() { return c0Group; }

		// "without" spaces+=WS "hiddens"
		public Group ele00Group() { return c00Group; }

		// "without" spaces+=WS
		public Group ele000Group() { return c000Group; }

		// "without"
		public Keyword ele0000KeywordWithout() { return c0000KeywordWithout; }

		// spaces+=WS
		public Assignment ele0001AssignmentSpaces() { return c0001AssignmentSpaces; }

		// WS
		public RuleCall ele00010ParserRuleCallWS() { return c00010ParserRuleCallWS; }

		// "hiddens"
		public Keyword ele001KeywordHiddens() { return c001KeywordHiddens; }

		// (spaces+=WS)?
		public Assignment ele01AssignmentSpaces() { return c01AssignmentSpaces; }

		// WS
		public RuleCall ele010ParserRuleCallWS() { return c010ParserRuleCallWS; }

		// valid?=";"
		public Assignment ele1AssignmentValid() { return c1AssignmentValid; }

		// ";"
		public Keyword ele10KeywordSemicolon() { return c10KeywordSemicolon; }
	}

	public class WithHiddensElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "WithHiddens");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordWith = (Keyword)c0Group.eContents().get(0);
		private final Keyword c01KeywordHiddens = (Keyword)c0Group.eContents().get(1);
		private final Assignment c1AssignmentValid = (Assignment)cGroup.eContents().get(1);
		private final Keyword c10KeywordSemicolon = (Keyword)c1AssignmentValid.eContents().get(0);
		
		// WithHiddens hidden ( WS , ML_COMMENT , SL_COMMENT ):   "with" "hiddens" valid?=";";
		public ParserRule getRule() { return rule; }

		// "with" "hiddens" valid?=";"
		public Group eleGroup() { return cGroup; }

		// "with" "hiddens"
		public Group ele0Group() { return c0Group; }

		// "with"
		public Keyword ele00KeywordWith() { return c00KeywordWith; }

		// "hiddens"
		public Keyword ele01KeywordHiddens() { return c01KeywordHiddens; }

		// valid?=";"
		public Assignment ele1AssignmentValid() { return c1AssignmentValid; }

		// ";"
		public Keyword ele10KeywordSemicolon() { return c10KeywordSemicolon; }
	}

	public class OverridingHiddensElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "OverridingHiddens");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Keyword c00000KeywordOverriding = (Keyword)c0000Group.eContents().get(0);
		private final Keyword c00001KeywordHiddens = (Keyword)c0000Group.eContents().get(1);
		private final Keyword c0001KeywordLeftParenthesis = (Keyword)c000Group.eContents().get(1);
		private final Assignment c001AssignmentCalled = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010ParserRuleCallOverridingHiddensCall = (RuleCall)c001AssignmentCalled.eContents().get(0);
		private final Keyword c01KeywordRightParenthesis = (Keyword)c0Group.eContents().get(1);
		private final Assignment c1AssignmentValid = (Assignment)cGroup.eContents().get(1);
		private final Keyword c10KeywordSemicolon = (Keyword)c1AssignmentValid.eContents().get(0);
		
		// OverridingHiddens hidden ( WS , ML_COMMENT , SL_COMMENT ):   "overriding" "hiddens" "(" called=OverridingHiddensCall ")" valid?=";";
		public ParserRule getRule() { return rule; }

		// "overriding" "hiddens" "(" called=OverridingHiddensCall ")" valid?=";"
		public Group eleGroup() { return cGroup; }

		// "overriding" "hiddens" "(" called=OverridingHiddensCall ")"
		public Group ele0Group() { return c0Group; }

		// "overriding" "hiddens" "(" called=OverridingHiddensCall
		public Group ele00Group() { return c00Group; }

		// "overriding" "hiddens" "("
		public Group ele000Group() { return c000Group; }

		// "overriding" "hiddens"
		public Group ele0000Group() { return c0000Group; }

		// "overriding"
		public Keyword ele00000KeywordOverriding() { return c00000KeywordOverriding; }

		// "hiddens"
		public Keyword ele00001KeywordHiddens() { return c00001KeywordHiddens; }

		// "("
		public Keyword ele0001KeywordLeftParenthesis() { return c0001KeywordLeftParenthesis; }

		// called=OverridingHiddensCall
		public Assignment ele001AssignmentCalled() { return c001AssignmentCalled; }

		// OverridingHiddensCall
		public RuleCall ele0010ParserRuleCallOverridingHiddensCall() { return c0010ParserRuleCallOverridingHiddensCall; }

		// ")"
		public Keyword ele01KeywordRightParenthesis() { return c01KeywordRightParenthesis; }

		// valid?=";"
		public Assignment ele1AssignmentValid() { return c1AssignmentValid; }

		// ";"
		public Keyword ele10KeywordSemicolon() { return c10KeywordSemicolon; }
	}

	public class OverridingHiddensCallElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "OverridingHiddensCall");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordCall = (Keyword)c0Group.eContents().get(0);
		private final Assignment c01AssignmentSpaces = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010ParserRuleCallWS = (RuleCall)c01AssignmentSpaces.eContents().get(0);
		private final Assignment c1AssignmentValid = (Assignment)cGroup.eContents().get(1);
		private final Keyword c10KeywordSemicolon = (Keyword)c1AssignmentValid.eContents().get(0);
		
		// OverridingHiddensCall hidden ( ):   "call" (spaces+=WS)? valid?=";";
		public ParserRule getRule() { return rule; }

		// "call" (spaces+=WS)? valid?=";"
		public Group eleGroup() { return cGroup; }

		// "call" (spaces+=WS)?
		public Group ele0Group() { return c0Group; }

		// "call"
		public Keyword ele00KeywordCall() { return c00KeywordCall; }

		// (spaces+=WS)?
		public Assignment ele01AssignmentSpaces() { return c01AssignmentSpaces; }

		// WS
		public RuleCall ele010ParserRuleCallWS() { return c010ParserRuleCallWS; }

		// valid?=";"
		public Assignment ele1AssignmentValid() { return c1AssignmentValid; }

		// ";"
		public Keyword ele10KeywordSemicolon() { return c10KeywordSemicolon; }
	}

	public class InheritingHiddensElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "InheritingHiddens");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Keyword c00000KeywordInheriting = (Keyword)c0000Group.eContents().get(0);
		private final Keyword c00001KeywordHiddens = (Keyword)c0000Group.eContents().get(1);
		private final Keyword c0001KeywordLeftParenthesis = (Keyword)c000Group.eContents().get(1);
		private final Alternatives c001Alternatives = (Alternatives)c00Group.eContents().get(1);
		private final Assignment c0010AssignmentCalled = (Assignment)c001Alternatives.eContents().get(0);
		private final RuleCall c00100ParserRuleCallInheritingHiddensCall = (RuleCall)c0010AssignmentCalled.eContents().get(0);
		private final Assignment c0011AssignmentHidingCalled = (Assignment)c001Alternatives.eContents().get(1);
		private final RuleCall c00110ParserRuleCallHidingHiddens = (RuleCall)c0011AssignmentHidingCalled.eContents().get(0);
		private final Keyword c01KeywordRightParenthesis = (Keyword)c0Group.eContents().get(1);
		private final Assignment c1AssignmentValid = (Assignment)cGroup.eContents().get(1);
		private final Keyword c10KeywordSemicolon = (Keyword)c1AssignmentValid.eContents().get(0);
		
		// InheritingHiddens hidden ( WS , ML_COMMENT , SL_COMMENT ):   "inheriting" "hiddens" "(" (called=InheritingHiddensCall|hidingCalled=HidingHiddens) ")" valid?=";";
		public ParserRule getRule() { return rule; }

		// "inheriting" "hiddens" "(" (called=InheritingHiddensCall|hidingCalled=HidingHiddens) ")" valid?=";"
		public Group eleGroup() { return cGroup; }

		// "inheriting" "hiddens" "(" (called=InheritingHiddensCall|hidingCalled=HidingHiddens) ")"
		public Group ele0Group() { return c0Group; }

		// "inheriting" "hiddens" "(" (called=InheritingHiddensCall|hidingCalled=HidingHiddens)
		public Group ele00Group() { return c00Group; }

		// "inheriting" "hiddens" "("
		public Group ele000Group() { return c000Group; }

		// "inheriting" "hiddens"
		public Group ele0000Group() { return c0000Group; }

		// "inheriting"
		public Keyword ele00000KeywordInheriting() { return c00000KeywordInheriting; }

		// "hiddens"
		public Keyword ele00001KeywordHiddens() { return c00001KeywordHiddens; }

		// "("
		public Keyword ele0001KeywordLeftParenthesis() { return c0001KeywordLeftParenthesis; }

		// called=InheritingHiddensCall|hidingCalled=HidingHiddens
		public Alternatives ele001Alternatives() { return c001Alternatives; }

		// called=InheritingHiddensCall
		public Assignment ele0010AssignmentCalled() { return c0010AssignmentCalled; }

		// InheritingHiddensCall
		public RuleCall ele00100ParserRuleCallInheritingHiddensCall() { return c00100ParserRuleCallInheritingHiddensCall; }

		// hidingCalled=HidingHiddens
		public Assignment ele0011AssignmentHidingCalled() { return c0011AssignmentHidingCalled; }

		// HidingHiddens
		public RuleCall ele00110ParserRuleCallHidingHiddens() { return c00110ParserRuleCallHidingHiddens; }

		// ")"
		public Keyword ele01KeywordRightParenthesis() { return c01KeywordRightParenthesis; }

		// valid?=";"
		public Assignment ele1AssignmentValid() { return c1AssignmentValid; }

		// ";"
		public Keyword ele10KeywordSemicolon() { return c10KeywordSemicolon; }
	}

	public class DatatypeHiddensElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "DatatypeHiddens");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordDatatype = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentValid = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10ParserRuleCallDatatypeRule = (RuleCall)c1AssignmentValid.eContents().get(0);
		
		// DatatypeHiddens:   "datatype" valid?=DatatypeRule;
		public ParserRule getRule() { return rule; }

		// "datatype" valid?=DatatypeRule
		public Group eleGroup() { return cGroup; }

		// "datatype"
		public Keyword ele0KeywordDatatype() { return c0KeywordDatatype; }

		// valid?=DatatypeRule
		public Assignment ele1AssignmentValid() { return c1AssignmentValid; }

		// DatatypeRule
		public RuleCall ele10ParserRuleCallDatatypeRule() { return c10ParserRuleCallDatatypeRule; }
	}

	public class DatatypeRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "DatatypeRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordRule = (Keyword)cGroup.eContents().get(0);
		private final Keyword c1KeywordSemicolon = (Keyword)cGroup.eContents().get(1);
		
		// DatatypeRule returns EString hidden ( WS ):   "rule" ";";
		public ParserRule getRule() { return rule; }

		// "rule" ";"
		public Group eleGroup() { return cGroup; }

		// "rule"
		public Keyword ele0KeywordRule() { return c0KeywordRule; }

		// ";"
		public Keyword ele1KeywordSemicolon() { return c1KeywordSemicolon; }
	}

	public class HidingHiddensElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "HidingHiddens");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordHiding = (Keyword)c0Group.eContents().get(0);
		private final Assignment c01AssignmentSpace = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010ParserRuleCallWS = (RuleCall)c01AssignmentSpace.eContents().get(0);
		private final Assignment c1AssignmentCalled = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10ParserRuleCallInheritingHiddensCall = (RuleCall)c1AssignmentCalled.eContents().get(0);
		
		// HidingHiddens hidden ( ):   "hiding" space=WS called=InheritingHiddensCall;
		public ParserRule getRule() { return rule; }

		// "hiding" space=WS called=InheritingHiddensCall
		public Group eleGroup() { return cGroup; }

		// "hiding" space=WS
		public Group ele0Group() { return c0Group; }

		// "hiding"
		public Keyword ele00KeywordHiding() { return c00KeywordHiding; }

		// space=WS
		public Assignment ele01AssignmentSpace() { return c01AssignmentSpace; }

		// WS
		public RuleCall ele010ParserRuleCallWS() { return c010ParserRuleCallWS; }

		// called=InheritingHiddensCall
		public Assignment ele1AssignmentCalled() { return c1AssignmentCalled; }

		// InheritingHiddensCall
		public RuleCall ele10ParserRuleCallInheritingHiddensCall() { return c10ParserRuleCallInheritingHiddensCall; }
	}

	public class InheritingHiddensCallElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "InheritingHiddensCall");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordCall = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentValid = (Assignment)cGroup.eContents().get(1);
		private final Keyword c10KeywordSemicolon = (Keyword)c1AssignmentValid.eContents().get(0);
		
		// InheritingHiddensCall:   "call" valid?=";";
		public ParserRule getRule() { return rule; }

		// "call" valid?=";"
		public Group eleGroup() { return cGroup; }

		// "call"
		public Keyword ele0KeywordCall() { return c0KeywordCall; }

		// valid?=";"
		public Assignment ele1AssignmentValid() { return c1AssignmentValid; }

		// ";"
		public Keyword ele10KeywordSemicolon() { return c10KeywordSemicolon; }
	}

	public class ML_COMMENTElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ML_COMMENT");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordSolidusAsterisk = (Keyword)cGroup.eContents().get(0);
		private final UpToToken c1UpToToken = (UpToToken)cGroup.eContents().get(1);
		private final Keyword c10KeywordAsteriskSolidus = (Keyword)c1UpToToken.eContents().get(0);
		
		// terminal ML_COMMENT returns EString : "/*" -> "*/" ;
		public ParserRule getRule() { return rule; }

		// "/*" -> "*/"
		public Group eleGroup() { return cGroup; }

		// "/*"
		public Keyword ele0KeywordSolidusAsterisk() { return c0KeywordSolidusAsterisk; }

		// -> "*/"
		public UpToToken ele1UpToToken() { return c1UpToToken; }

		// "*/"
		public Keyword ele10KeywordAsteriskSolidus() { return c10KeywordAsteriskSolidus; }
	}

	public class SL_COMMENTElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SL_COMMENT");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordSolidusSolidus = (Keyword)c0Group.eContents().get(0);
		private final NegatedToken c01NegatedToken = (NegatedToken)c0Group.eContents().get(1);
		private final Alternatives c010Alternatives = (Alternatives)c01NegatedToken.eContents().get(0);
		private final Keyword c0100Keyword = (Keyword)c010Alternatives.eContents().get(0);
		private final Keyword c0101Keyword = (Keyword)c010Alternatives.eContents().get(1);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Keyword c10Keyword = (Keyword)c1Group.eContents().get(0);
		private final Keyword c11Keyword = (Keyword)c1Group.eContents().get(1);
		
		// terminal SL_COMMENT returns EString : "//" ! ( "\n" | "\r" ) * ( "\r" ? "\n" ) ? ;
		public ParserRule getRule() { return rule; }

		// "//" ! ( "\n" | "\r" ) * ( "\r" ? "\n" ) ?
		public Group eleGroup() { return cGroup; }

		// "//" ! ( "\n" | "\r" ) *
		public Group ele0Group() { return c0Group; }

		// "//"
		public Keyword ele00KeywordSolidusSolidus() { return c00KeywordSolidusSolidus; }

		// ! ( "\n" | "\r" ) *
		public NegatedToken ele01NegatedToken() { return c01NegatedToken; }

		// "\n"|"\r"
		public Alternatives ele010Alternatives() { return c010Alternatives; }

		// "\n"
		public Keyword ele0100Keyword() { return c0100Keyword; }

		// "\r"
		public Keyword ele0101Keyword() { return c0101Keyword; }

		// ("\r"? "\n")?
		public Group ele1Group() { return c1Group; }

		// "\r"?
		public Keyword ele10Keyword() { return c10Keyword; }

		// "\n"
		public Keyword ele11Keyword() { return c11Keyword; }
	}

	public class WSElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "WS");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Alternatives c0Alternatives = (Alternatives)cAlternatives.eContents().get(0);
		private final Alternatives c00Alternatives = (Alternatives)c0Alternatives.eContents().get(0);
		private final Keyword c000KeywordSpace = (Keyword)c00Alternatives.eContents().get(0);
		private final Keyword c001Keyword = (Keyword)c00Alternatives.eContents().get(1);
		private final Keyword c01Keyword = (Keyword)c0Alternatives.eContents().get(1);
		private final Keyword c1Keyword = (Keyword)cAlternatives.eContents().get(1);
		
		// terminal WS returns EString : ( " " | "\t" | "\r" | "\n" ) + ;
		public ParserRule getRule() { return rule; }

		// (" "|"\t"|"\r"|"\n")+
		public Alternatives eleAlternatives() { return cAlternatives; }

		// " "|"\t"|"\r"
		public Alternatives ele0Alternatives() { return c0Alternatives; }

		// " "|"\t"
		public Alternatives ele00Alternatives() { return c00Alternatives; }

		// " "
		public Keyword ele000KeywordSpace() { return c000KeywordSpace; }

		// "\t"
		public Keyword ele001Keyword() { return c001Keyword; }

		// "\r"
		public Keyword ele01Keyword() { return c01Keyword; }

		// "\n"
		public Keyword ele1Keyword() { return c1Keyword; }
	}

	public class ANY_OTHERElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ANY_OTHER");
		private final Wildcard cWildcard = (Wildcard)rule.eContents().get(1);
		
		// terminal ANY_OTHER returns EString : . ;
		public ParserRule getRule() { return rule; }

		// .
		public Wildcard eleWildcard() { return cWildcard; }
	}
	
	private ModelElements pModel;
	private WithoutHiddensElements pWithoutHiddens;
	private WithHiddensElements pWithHiddens;
	private OverridingHiddensElements pOverridingHiddens;
	private OverridingHiddensCallElements pOverridingHiddensCall;
	private InheritingHiddensElements pInheritingHiddens;
	private DatatypeHiddensElements pDatatypeHiddens;
	private DatatypeRuleElements pDatatypeRule;
	private HidingHiddensElements pHidingHiddens;
	private InheritingHiddensCallElements pInheritingHiddensCall;
	private ML_COMMENTElements pML_COMMENT;
	private SL_COMMENTElements pSL_COMMENT;
	private WSElements pWS;
	private ANY_OTHERElements pANY_OTHER;
	
	private final GrammarProvider grammarProvider;

	@Inject
	public HiddenTerminalsTestLanguageGrammarAccess(GrammarProvider grammarProvider) {
		this.grammarProvider = grammarProvider;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	
	// Model:   WithoutHiddens|WithHiddens|OverridingHiddens|InheritingHiddens|DatatypeHiddens;
	public ModelElements prModel() {
		return (pModel != null) ? pModel : (pModel = new ModelElements());
	} 

	// WithoutHiddens:   "without" spaces+=WS "hiddens" (spaces+=WS)? valid?=";";
	public WithoutHiddensElements prWithoutHiddens() {
		return (pWithoutHiddens != null) ? pWithoutHiddens : (pWithoutHiddens = new WithoutHiddensElements());
	} 

	// WithHiddens hidden ( WS , ML_COMMENT , SL_COMMENT ):   "with" "hiddens" valid?=";";
	public WithHiddensElements prWithHiddens() {
		return (pWithHiddens != null) ? pWithHiddens : (pWithHiddens = new WithHiddensElements());
	} 

	// OverridingHiddens hidden ( WS , ML_COMMENT , SL_COMMENT ):   "overriding" "hiddens" "(" called=OverridingHiddensCall ")" valid?=";";
	public OverridingHiddensElements prOverridingHiddens() {
		return (pOverridingHiddens != null) ? pOverridingHiddens : (pOverridingHiddens = new OverridingHiddensElements());
	} 

	// OverridingHiddensCall hidden ( ):   "call" (spaces+=WS)? valid?=";";
	public OverridingHiddensCallElements prOverridingHiddensCall() {
		return (pOverridingHiddensCall != null) ? pOverridingHiddensCall : (pOverridingHiddensCall = new OverridingHiddensCallElements());
	} 

	// InheritingHiddens hidden ( WS , ML_COMMENT , SL_COMMENT ):   "inheriting" "hiddens" "(" (called=InheritingHiddensCall|hidingCalled=HidingHiddens) ")" valid?=";";
	public InheritingHiddensElements prInheritingHiddens() {
		return (pInheritingHiddens != null) ? pInheritingHiddens : (pInheritingHiddens = new InheritingHiddensElements());
	} 

	// DatatypeHiddens:   "datatype" valid?=DatatypeRule;
	public DatatypeHiddensElements prDatatypeHiddens() {
		return (pDatatypeHiddens != null) ? pDatatypeHiddens : (pDatatypeHiddens = new DatatypeHiddensElements());
	} 

	// DatatypeRule returns EString hidden ( WS ):   "rule" ";";
	public DatatypeRuleElements prDatatypeRule() {
		return (pDatatypeRule != null) ? pDatatypeRule : (pDatatypeRule = new DatatypeRuleElements());
	} 

	// HidingHiddens hidden ( ):   "hiding" space=WS called=InheritingHiddensCall;
	public HidingHiddensElements prHidingHiddens() {
		return (pHidingHiddens != null) ? pHidingHiddens : (pHidingHiddens = new HidingHiddensElements());
	} 

	// InheritingHiddensCall:   "call" valid?=";";
	public InheritingHiddensCallElements prInheritingHiddensCall() {
		return (pInheritingHiddensCall != null) ? pInheritingHiddensCall : (pInheritingHiddensCall = new InheritingHiddensCallElements());
	} 

	// terminal ML_COMMENT returns EString : "/*" -> "*/" ;
	public ML_COMMENTElements prML_COMMENT() {
		return (pML_COMMENT != null) ? pML_COMMENT : (pML_COMMENT = new ML_COMMENTElements());
	} 

	// terminal SL_COMMENT returns EString : "//" ! ( "\n" | "\r" ) * ( "\r" ? "\n" ) ? ;
	public SL_COMMENTElements prSL_COMMENT() {
		return (pSL_COMMENT != null) ? pSL_COMMENT : (pSL_COMMENT = new SL_COMMENTElements());
	} 

	// terminal WS returns EString : ( " " | "\t" | "\r" | "\n" ) + ;
	public WSElements prWS() {
		return (pWS != null) ? pWS : (pWS = new WSElements());
	} 

	// terminal ANY_OTHER returns EString : . ;
	public ANY_OTHERElements prANY_OTHER() {
		return (pANY_OTHER != null) ? pANY_OTHER : (pANY_OTHER = new ANY_OTHERElements());
	} 
}
