/*
Generated with Xtext
*/

package org.eclipse.xtext.parser.terminalrules.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class TerminalRulesTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class ModelElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(2);
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Alternatives c0Alternatives = (Alternatives)cAlternatives.eContents().get(0);
		private final Alternatives c00Alternatives = (Alternatives)c0Alternatives.eContents().get(0);
		private final Alternatives c000Alternatives = (Alternatives)c00Alternatives.eContents().get(0);
		private final Alternatives c0000Alternatives = (Alternatives)c000Alternatives.eContents().get(0);
		private final Alternatives c00000Alternatives = (Alternatives)c0000Alternatives.eContents().get(0);
		private final Assignment c000000AssignmentIdValue = (Assignment)c00000Alternatives.eContents().get(0);
		private final RuleCall c0000000ParserRuleCallID = (RuleCall)c000000AssignmentIdValue.eContents().get(0);
		private final Assignment c000001AssignmentIntValue = (Assignment)c00000Alternatives.eContents().get(1);
		private final RuleCall c0000010ParserRuleCallINT = (RuleCall)c000001AssignmentIntValue.eContents().get(0);
		private final Assignment c00001AssignmentStringValue = (Assignment)c0000Alternatives.eContents().get(1);
		private final RuleCall c000010ParserRuleCallSTRING = (RuleCall)c00001AssignmentStringValue.eContents().get(0);
		private final Assignment c0001AssignmentMlCommentValue = (Assignment)c000Alternatives.eContents().get(1);
		private final RuleCall c00010ParserRuleCallML_COMMENT = (RuleCall)c0001AssignmentMlCommentValue.eContents().get(0);
		private final Assignment c001AssignmentSlCommentValue = (Assignment)c00Alternatives.eContents().get(1);
		private final RuleCall c0010ParserRuleCallSL_COMMENT = (RuleCall)c001AssignmentSlCommentValue.eContents().get(0);
		private final Assignment c01AssignmentWsValue = (Assignment)c0Alternatives.eContents().get(1);
		private final RuleCall c010ParserRuleCallWS = (RuleCall)c01AssignmentWsValue.eContents().get(0);
		private final Assignment c1AssignmentAnyValue = (Assignment)cAlternatives.eContents().get(1);
		private final RuleCall c10ParserRuleCallANY_OTHER = (RuleCall)c1AssignmentAnyValue.eContents().get(0);
		
		// Model : idValue = ID | intValue = INT | stringValue = STRING | mlCommentValue = ML_COMMENT | slCommentValue = SL_COMMENT | wsValue = WS | anyValue = ANY_OTHER ;
		public ParserRule getRule() { return rule; }

		// idValue = ID | intValue = INT | stringValue = STRING | mlCommentValue = ML_COMMENT | slCommentValue = SL_COMMENT | wsValue = WS | anyValue = ANY_OTHER
		public Alternatives eleAlternatives() { return cAlternatives; }

		// idValue = ID | intValue = INT | stringValue = STRING | mlCommentValue = ML_COMMENT | slCommentValue = SL_COMMENT | wsValue = WS
		public Alternatives ele0Alternatives() { return c0Alternatives; }

		// idValue = ID | intValue = INT | stringValue = STRING | mlCommentValue = ML_COMMENT | slCommentValue = SL_COMMENT
		public Alternatives ele00Alternatives() { return c00Alternatives; }

		// idValue = ID | intValue = INT | stringValue = STRING | mlCommentValue = ML_COMMENT
		public Alternatives ele000Alternatives() { return c000Alternatives; }

		// idValue = ID | intValue = INT | stringValue = STRING
		public Alternatives ele0000Alternatives() { return c0000Alternatives; }

		// idValue = ID | intValue = INT
		public Alternatives ele00000Alternatives() { return c00000Alternatives; }

		// idValue = ID
		public Assignment ele000000AssignmentIdValue() { return c000000AssignmentIdValue; }

		// ID
		public RuleCall ele0000000ParserRuleCallID() { return c0000000ParserRuleCallID; }

		// intValue = INT
		public Assignment ele000001AssignmentIntValue() { return c000001AssignmentIntValue; }

		// INT
		public RuleCall ele0000010ParserRuleCallINT() { return c0000010ParserRuleCallINT; }

		// stringValue = STRING
		public Assignment ele00001AssignmentStringValue() { return c00001AssignmentStringValue; }

		// STRING
		public RuleCall ele000010ParserRuleCallSTRING() { return c000010ParserRuleCallSTRING; }

		// mlCommentValue = ML_COMMENT
		public Assignment ele0001AssignmentMlCommentValue() { return c0001AssignmentMlCommentValue; }

		// ML_COMMENT
		public RuleCall ele00010ParserRuleCallML_COMMENT() { return c00010ParserRuleCallML_COMMENT; }

		// slCommentValue = SL_COMMENT
		public Assignment ele001AssignmentSlCommentValue() { return c001AssignmentSlCommentValue; }

		// SL_COMMENT
		public RuleCall ele0010ParserRuleCallSL_COMMENT() { return c0010ParserRuleCallSL_COMMENT; }

		// wsValue = WS
		public Assignment ele01AssignmentWsValue() { return c01AssignmentWsValue; }

		// WS
		public RuleCall ele010ParserRuleCallWS() { return c010ParserRuleCallWS; }

		// anyValue = ANY_OTHER
		public Assignment ele1AssignmentAnyValue() { return c1AssignmentAnyValue; }

		// ANY_OTHER
		public RuleCall ele10ParserRuleCallANY_OTHER() { return c10ParserRuleCallANY_OTHER; }
	}

	public class IDElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(3);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordCircumflexAccent = (Keyword)c0Group.eContents().get(0);
		private final Alternatives c01Alternatives = (Alternatives)c0Group.eContents().get(1);
		private final Alternatives c010Alternatives = (Alternatives)c01Alternatives.eContents().get(0);
		private final CharacterRange c0100CharacterRange = (CharacterRange)c010Alternatives.eContents().get(0);
		private final Keyword c01000KeywordA = (Keyword)c0100CharacterRange.eContents().get(0);
		private final Keyword c01001KeywordZ = (Keyword)c0100CharacterRange.eContents().get(1);
		private final CharacterRange c0101CharacterRange = (CharacterRange)c010Alternatives.eContents().get(1);
		private final Keyword c01010KeywordA = (Keyword)c0101CharacterRange.eContents().get(0);
		private final Keyword c01011KeywordZ = (Keyword)c0101CharacterRange.eContents().get(1);
		private final Keyword c011Keyword_ = (Keyword)c01Alternatives.eContents().get(1);
		private final Alternatives c1Alternatives = (Alternatives)cGroup.eContents().get(1);
		private final Alternatives c10Alternatives = (Alternatives)c1Alternatives.eContents().get(0);
		private final Alternatives c100Alternatives = (Alternatives)c10Alternatives.eContents().get(0);
		private final CharacterRange c1000CharacterRange = (CharacterRange)c100Alternatives.eContents().get(0);
		private final Keyword c10000KeywordA = (Keyword)c1000CharacterRange.eContents().get(0);
		private final Keyword c10001KeywordZ = (Keyword)c1000CharacterRange.eContents().get(1);
		private final CharacterRange c1001CharacterRange = (CharacterRange)c100Alternatives.eContents().get(1);
		private final Keyword c10010KeywordA = (Keyword)c1001CharacterRange.eContents().get(0);
		private final Keyword c10011KeywordZ = (Keyword)c1001CharacterRange.eContents().get(1);
		private final Keyword c101Keyword_ = (Keyword)c10Alternatives.eContents().get(1);
		private final CharacterRange c11CharacterRange = (CharacterRange)c1Alternatives.eContents().get(1);
		private final Keyword c110KeywordDigitZero = (Keyword)c11CharacterRange.eContents().get(0);
		private final Keyword c111KeywordDigitNine = (Keyword)c11CharacterRange.eContents().get(1);
		
		// terminal ID returns EString : '^' ? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' ) * ;
		public ParserRule getRule() { return rule; }

		// '^' ? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' ) *
		public Group eleGroup() { return cGroup; }

		// '^' ? ( 'a' .. 'z' | 'A' .. 'Z' | '_' )
		public Group ele0Group() { return c0Group; }

		// '^' ?
		public Keyword ele00KeywordCircumflexAccent() { return c00KeywordCircumflexAccent; }

		// 'a' .. 'z' | 'A' .. 'Z' | '_'
		public Alternatives ele01Alternatives() { return c01Alternatives; }

		// 'a' .. 'z' | 'A' .. 'Z'
		public Alternatives ele010Alternatives() { return c010Alternatives; }

		// 'a' .. 'z'
		public CharacterRange ele0100CharacterRange() { return c0100CharacterRange; }

		// 'a'
		public Keyword ele01000KeywordA() { return c01000KeywordA; }

		// 'z'
		public Keyword ele01001KeywordZ() { return c01001KeywordZ; }

		// 'A' .. 'Z'
		public CharacterRange ele0101CharacterRange() { return c0101CharacterRange; }

		// 'A'
		public Keyword ele01010KeywordA() { return c01010KeywordA; }

		// 'Z'
		public Keyword ele01011KeywordZ() { return c01011KeywordZ; }

		// '_'
		public Keyword ele011Keyword_() { return c011Keyword_; }

		// ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' ) *
		public Alternatives ele1Alternatives() { return c1Alternatives; }

		// 'a' .. 'z' | 'A' .. 'Z' | '_'
		public Alternatives ele10Alternatives() { return c10Alternatives; }

		// 'a' .. 'z' | 'A' .. 'Z'
		public Alternatives ele100Alternatives() { return c100Alternatives; }

		// 'a' .. 'z'
		public CharacterRange ele1000CharacterRange() { return c1000CharacterRange; }

		// 'a'
		public Keyword ele10000KeywordA() { return c10000KeywordA; }

		// 'z'
		public Keyword ele10001KeywordZ() { return c10001KeywordZ; }

		// 'A' .. 'Z'
		public CharacterRange ele1001CharacterRange() { return c1001CharacterRange; }

		// 'A'
		public Keyword ele10010KeywordA() { return c10010KeywordA; }

		// 'Z'
		public Keyword ele10011KeywordZ() { return c10011KeywordZ; }

		// '_'
		public Keyword ele101Keyword_() { return c101Keyword_; }

		// '0' .. '9'
		public CharacterRange ele11CharacterRange() { return c11CharacterRange; }

		// '0'
		public Keyword ele110KeywordDigitZero() { return c110KeywordDigitZero; }

		// '9'
		public Keyword ele111KeywordDigitNine() { return c111KeywordDigitNine; }
	}

	public class INTElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(4);
		private final CharacterRange cCharacterRange = (CharacterRange)rule.eContents().get(1);
		private final Keyword c0KeywordDigitZero = (Keyword)cCharacterRange.eContents().get(0);
		private final Keyword c1KeywordDigitNine = (Keyword)cCharacterRange.eContents().get(1);
		
		// terminal INT returns EString : '0' .. '9' + ;
		public ParserRule getRule() { return rule; }

		// '0' .. '9' +
		public CharacterRange eleCharacterRange() { return cCharacterRange; }

		// '0'
		public Keyword ele0KeywordDigitZero() { return c0KeywordDigitZero; }

		// '9'
		public Keyword ele1KeywordDigitNine() { return c1KeywordDigitNine; }
	}

	public class STRINGElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(5);
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group c0Group = (Group)cAlternatives.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordQuotationMark = (Keyword)c00Group.eContents().get(0);
		private final Alternatives c001Alternatives = (Alternatives)c00Group.eContents().get(1);
		private final Group c0010Group = (Group)c001Alternatives.eContents().get(0);
		private final Keyword c00100KeywordReverseSolidusReverseSolidus = (Keyword)c0010Group.eContents().get(0);
		private final Alternatives c00101Alternatives = (Alternatives)c0010Group.eContents().get(1);
		private final Alternatives c001010Alternatives = (Alternatives)c00101Alternatives.eContents().get(0);
		private final Alternatives c0010100Alternatives = (Alternatives)c001010Alternatives.eContents().get(0);
		private final Alternatives c00101000Alternatives = (Alternatives)c0010100Alternatives.eContents().get(0);
		private final Alternatives c001010000Alternatives = (Alternatives)c00101000Alternatives.eContents().get(0);
		private final Alternatives c0010100000Alternatives = (Alternatives)c001010000Alternatives.eContents().get(0);
		private final Alternatives c00101000000Alternatives = (Alternatives)c0010100000Alternatives.eContents().get(0);
		private final Keyword c001010000000KeywordB = (Keyword)c00101000000Alternatives.eContents().get(0);
		private final Keyword c001010000001KeywordT = (Keyword)c00101000000Alternatives.eContents().get(1);
		private final Keyword c00101000001KeywordN = (Keyword)c0010100000Alternatives.eContents().get(1);
		private final Keyword c0010100001KeywordF = (Keyword)c001010000Alternatives.eContents().get(1);
		private final Keyword c001010001KeywordR = (Keyword)c00101000Alternatives.eContents().get(1);
		private final Keyword c00101001KeywordQuotationMark = (Keyword)c0010100Alternatives.eContents().get(1);
		private final Keyword c0010101KeywordApostrophe = (Keyword)c001010Alternatives.eContents().get(1);
		private final Keyword c001011KeywordReverseSolidusReverseSolidus = (Keyword)c00101Alternatives.eContents().get(1);
		private final NegatedToken c0011NegatedToken = (NegatedToken)c001Alternatives.eContents().get(1);
		private final Alternatives c00110Alternatives = (Alternatives)c0011NegatedToken.eContents().get(0);
		private final Keyword c001100KeywordReverseSolidusReverseSolidus = (Keyword)c00110Alternatives.eContents().get(0);
		private final Keyword c001101KeywordQuotationMark = (Keyword)c00110Alternatives.eContents().get(1);
		private final Keyword c01KeywordQuotationMark = (Keyword)c0Group.eContents().get(1);
		private final Group c1Group = (Group)cAlternatives.eContents().get(1);
		private final Group c10Group = (Group)c1Group.eContents().get(0);
		private final Keyword c100KeywordApostrophe = (Keyword)c10Group.eContents().get(0);
		private final Alternatives c101Alternatives = (Alternatives)c10Group.eContents().get(1);
		private final Group c1010Group = (Group)c101Alternatives.eContents().get(0);
		private final Keyword c10100KeywordReverseSolidusReverseSolidus = (Keyword)c1010Group.eContents().get(0);
		private final Alternatives c10101Alternatives = (Alternatives)c1010Group.eContents().get(1);
		private final Alternatives c101010Alternatives = (Alternatives)c10101Alternatives.eContents().get(0);
		private final Alternatives c1010100Alternatives = (Alternatives)c101010Alternatives.eContents().get(0);
		private final Alternatives c10101000Alternatives = (Alternatives)c1010100Alternatives.eContents().get(0);
		private final Alternatives c101010000Alternatives = (Alternatives)c10101000Alternatives.eContents().get(0);
		private final Alternatives c1010100000Alternatives = (Alternatives)c101010000Alternatives.eContents().get(0);
		private final Alternatives c10101000000Alternatives = (Alternatives)c1010100000Alternatives.eContents().get(0);
		private final Keyword c101010000000KeywordB = (Keyword)c10101000000Alternatives.eContents().get(0);
		private final Keyword c101010000001KeywordT = (Keyword)c10101000000Alternatives.eContents().get(1);
		private final Keyword c10101000001KeywordN = (Keyword)c1010100000Alternatives.eContents().get(1);
		private final Keyword c1010100001KeywordF = (Keyword)c101010000Alternatives.eContents().get(1);
		private final Keyword c101010001KeywordR = (Keyword)c10101000Alternatives.eContents().get(1);
		private final Keyword c10101001KeywordQuotationMark = (Keyword)c1010100Alternatives.eContents().get(1);
		private final Keyword c1010101KeywordApostrophe = (Keyword)c101010Alternatives.eContents().get(1);
		private final Keyword c101011KeywordReverseSolidusReverseSolidus = (Keyword)c10101Alternatives.eContents().get(1);
		private final NegatedToken c1011NegatedToken = (NegatedToken)c101Alternatives.eContents().get(1);
		private final Alternatives c10110Alternatives = (Alternatives)c1011NegatedToken.eContents().get(0);
		private final Keyword c101100KeywordReverseSolidusReverseSolidus = (Keyword)c10110Alternatives.eContents().get(0);
		private final Keyword c101101KeywordApostrophe = (Keyword)c10110Alternatives.eContents().get(1);
		private final Keyword c11KeywordApostrophe = (Keyword)c1Group.eContents().get(1);
		
		// terminal STRING returns EString : '"' ( '\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '"' | "'" | '\\' ) | ! ( '\\' | '"' ) ) * '"' | "'" ( '\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '"' | "'" | '\\' ) | ! ( '\\' | "'" ) ) * "'" ;
		public ParserRule getRule() { return rule; }

		// '"' ( '\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '"' | "'" | '\\' ) | ! ( '\\' | '"' ) ) * '"' | "'" ( '\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '"' | "'" | '\\' ) | ! ( '\\' | "'" ) ) * "'"
		public Alternatives eleAlternatives() { return cAlternatives; }

		// '"' ( '\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '"' | "'" | '\\' ) | ! ( '\\' | '"' ) ) * '"'
		public Group ele0Group() { return c0Group; }

		// '"' ( '\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '"' | "'" | '\\' ) | ! ( '\\' | '"' ) ) *
		public Group ele00Group() { return c00Group; }

		// '"'
		public Keyword ele000KeywordQuotationMark() { return c000KeywordQuotationMark; }

		// ( '\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '"' | "'" | '\\' ) | ! ( '\\' | '"' ) ) *
		public Alternatives ele001Alternatives() { return c001Alternatives; }

		// '\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '"' | "'" | '\\' )
		public Group ele0010Group() { return c0010Group; }

		// '\\'
		public Keyword ele00100KeywordReverseSolidusReverseSolidus() { return c00100KeywordReverseSolidusReverseSolidus; }

		// 'b' | 't' | 'n' | 'f' | 'r' | '"' | "'" | '\\'
		public Alternatives ele00101Alternatives() { return c00101Alternatives; }

		// 'b' | 't' | 'n' | 'f' | 'r' | '"' | "'"
		public Alternatives ele001010Alternatives() { return c001010Alternatives; }

		// 'b' | 't' | 'n' | 'f' | 'r' | '"'
		public Alternatives ele0010100Alternatives() { return c0010100Alternatives; }

		// 'b' | 't' | 'n' | 'f' | 'r'
		public Alternatives ele00101000Alternatives() { return c00101000Alternatives; }

		// 'b' | 't' | 'n' | 'f'
		public Alternatives ele001010000Alternatives() { return c001010000Alternatives; }

		// 'b' | 't' | 'n'
		public Alternatives ele0010100000Alternatives() { return c0010100000Alternatives; }

		// 'b' | 't'
		public Alternatives ele00101000000Alternatives() { return c00101000000Alternatives; }

		// 'b'
		public Keyword ele001010000000KeywordB() { return c001010000000KeywordB; }

		// 't'
		public Keyword ele001010000001KeywordT() { return c001010000001KeywordT; }

		// 'n'
		public Keyword ele00101000001KeywordN() { return c00101000001KeywordN; }

		// 'f'
		public Keyword ele0010100001KeywordF() { return c0010100001KeywordF; }

		// 'r'
		public Keyword ele001010001KeywordR() { return c001010001KeywordR; }

		// '"'
		public Keyword ele00101001KeywordQuotationMark() { return c00101001KeywordQuotationMark; }

		// "'"
		public Keyword ele0010101KeywordApostrophe() { return c0010101KeywordApostrophe; }

		// '\\'
		public Keyword ele001011KeywordReverseSolidusReverseSolidus() { return c001011KeywordReverseSolidusReverseSolidus; }

		// ! ( '\\' | '"' )
		public NegatedToken ele0011NegatedToken() { return c0011NegatedToken; }

		// '\\' | '"'
		public Alternatives ele00110Alternatives() { return c00110Alternatives; }

		// '\\'
		public Keyword ele001100KeywordReverseSolidusReverseSolidus() { return c001100KeywordReverseSolidusReverseSolidus; }

		// '"'
		public Keyword ele001101KeywordQuotationMark() { return c001101KeywordQuotationMark; }

		// '"'
		public Keyword ele01KeywordQuotationMark() { return c01KeywordQuotationMark; }

		// "'" ( '\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '"' | "'" | '\\' ) | ! ( '\\' | "'" ) ) * "'"
		public Group ele1Group() { return c1Group; }

		// "'" ( '\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '"' | "'" | '\\' ) | ! ( '\\' | "'" ) ) *
		public Group ele10Group() { return c10Group; }

		// "'"
		public Keyword ele100KeywordApostrophe() { return c100KeywordApostrophe; }

		// ( '\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '"' | "'" | '\\' ) | ! ( '\\' | "'" ) ) *
		public Alternatives ele101Alternatives() { return c101Alternatives; }

		// '\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '"' | "'" | '\\' )
		public Group ele1010Group() { return c1010Group; }

		// '\\'
		public Keyword ele10100KeywordReverseSolidusReverseSolidus() { return c10100KeywordReverseSolidusReverseSolidus; }

		// 'b' | 't' | 'n' | 'f' | 'r' | '"' | "'" | '\\'
		public Alternatives ele10101Alternatives() { return c10101Alternatives; }

		// 'b' | 't' | 'n' | 'f' | 'r' | '"' | "'"
		public Alternatives ele101010Alternatives() { return c101010Alternatives; }

		// 'b' | 't' | 'n' | 'f' | 'r' | '"'
		public Alternatives ele1010100Alternatives() { return c1010100Alternatives; }

		// 'b' | 't' | 'n' | 'f' | 'r'
		public Alternatives ele10101000Alternatives() { return c10101000Alternatives; }

		// 'b' | 't' | 'n' | 'f'
		public Alternatives ele101010000Alternatives() { return c101010000Alternatives; }

		// 'b' | 't' | 'n'
		public Alternatives ele1010100000Alternatives() { return c1010100000Alternatives; }

		// 'b' | 't'
		public Alternatives ele10101000000Alternatives() { return c10101000000Alternatives; }

		// 'b'
		public Keyword ele101010000000KeywordB() { return c101010000000KeywordB; }

		// 't'
		public Keyword ele101010000001KeywordT() { return c101010000001KeywordT; }

		// 'n'
		public Keyword ele10101000001KeywordN() { return c10101000001KeywordN; }

		// 'f'
		public Keyword ele1010100001KeywordF() { return c1010100001KeywordF; }

		// 'r'
		public Keyword ele101010001KeywordR() { return c101010001KeywordR; }

		// '"'
		public Keyword ele10101001KeywordQuotationMark() { return c10101001KeywordQuotationMark; }

		// "'"
		public Keyword ele1010101KeywordApostrophe() { return c1010101KeywordApostrophe; }

		// '\\'
		public Keyword ele101011KeywordReverseSolidusReverseSolidus() { return c101011KeywordReverseSolidusReverseSolidus; }

		// ! ( '\\' | "'" )
		public NegatedToken ele1011NegatedToken() { return c1011NegatedToken; }

		// '\\' | "'"
		public Alternatives ele10110Alternatives() { return c10110Alternatives; }

		// '\\'
		public Keyword ele101100KeywordReverseSolidusReverseSolidus() { return c101100KeywordReverseSolidusReverseSolidus; }

		// "'"
		public Keyword ele101101KeywordApostrophe() { return c101101KeywordApostrophe; }

		// "'"
		public Keyword ele11KeywordApostrophe() { return c11KeywordApostrophe; }
	}

	public class ML_COMMENTElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(6);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordSolidusAsterisk = (Keyword)cGroup.eContents().get(0);
		private final UpToToken c1UpToToken = (UpToToken)cGroup.eContents().get(1);
		private final Keyword c10KeywordAsteriskSolidus = (Keyword)c1UpToToken.eContents().get(0);
		
		// terminal ML_COMMENT returns EString : '/*' -> '*/' ;
		public ParserRule getRule() { return rule; }

		// '/*' -> '*/'
		public Group eleGroup() { return cGroup; }

		// '/*'
		public Keyword ele0KeywordSolidusAsterisk() { return c0KeywordSolidusAsterisk; }

		// -> '*/'
		public UpToToken ele1UpToToken() { return c1UpToToken; }

		// '*/'
		public Keyword ele10KeywordAsteriskSolidus() { return c10KeywordAsteriskSolidus; }
	}

	public class SL_COMMENTElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(7);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordSolidusSolidus = (Keyword)c0Group.eContents().get(0);
		private final NegatedToken c01NegatedToken = (NegatedToken)c0Group.eContents().get(1);
		private final Alternatives c010Alternatives = (Alternatives)c01NegatedToken.eContents().get(0);
		private final Keyword c0100KeywordN = (Keyword)c010Alternatives.eContents().get(0);
		private final Keyword c0101KeywordR = (Keyword)c010Alternatives.eContents().get(1);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Keyword c10KeywordR = (Keyword)c1Group.eContents().get(0);
		private final Keyword c11KeywordN = (Keyword)c1Group.eContents().get(1);
		
		// terminal SL_COMMENT returns EString : '//' ! ( '\n' | '\r' ) * ( '\r' ? '\n' ) ? ;
		public ParserRule getRule() { return rule; }

		// '//' ! ( '\n' | '\r' ) * ( '\r' ? '\n' ) ?
		public Group eleGroup() { return cGroup; }

		// '//' ! ( '\n' | '\r' ) *
		public Group ele0Group() { return c0Group; }

		// '//'
		public Keyword ele00KeywordSolidusSolidus() { return c00KeywordSolidusSolidus; }

		// ! ( '\n' | '\r' ) *
		public NegatedToken ele01NegatedToken() { return c01NegatedToken; }

		// '\n' | '\r'
		public Alternatives ele010Alternatives() { return c010Alternatives; }

		// '\n'
		public Keyword ele0100KeywordN() { return c0100KeywordN; }

		// '\r'
		public Keyword ele0101KeywordR() { return c0101KeywordR; }

		// ( '\r' ? '\n' ) ?
		public Group ele1Group() { return c1Group; }

		// '\r' ?
		public Keyword ele10KeywordR() { return c10KeywordR; }

		// '\n'
		public Keyword ele11KeywordN() { return c11KeywordN; }
	}

	public class WSElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(8);
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Alternatives c0Alternatives = (Alternatives)cAlternatives.eContents().get(0);
		private final Alternatives c00Alternatives = (Alternatives)c0Alternatives.eContents().get(0);
		private final Keyword c000KeywordSpace = (Keyword)c00Alternatives.eContents().get(0);
		private final Keyword c001KeywordT = (Keyword)c00Alternatives.eContents().get(1);
		private final Keyword c01KeywordR = (Keyword)c0Alternatives.eContents().get(1);
		private final Keyword c1KeywordN = (Keyword)cAlternatives.eContents().get(1);
		
		// terminal WS returns EString : ( ' ' | '\t' | '\r' | '\n' ) + ;
		public ParserRule getRule() { return rule; }

		// ( ' ' | '\t' | '\r' | '\n' ) +
		public Alternatives eleAlternatives() { return cAlternatives; }

		// ' ' | '\t' | '\r'
		public Alternatives ele0Alternatives() { return c0Alternatives; }

		// ' ' | '\t'
		public Alternatives ele00Alternatives() { return c00Alternatives; }

		// ' '
		public Keyword ele000KeywordSpace() { return c000KeywordSpace; }

		// '\t'
		public Keyword ele001KeywordT() { return c001KeywordT; }

		// '\r'
		public Keyword ele01KeywordR() { return c01KeywordR; }

		// '\n'
		public Keyword ele1KeywordN() { return c1KeywordN; }
	}

	public class ANY_OTHERElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(9);
		private final Wildcard cWildcard = (Wildcard)rule.eContents().get(1);
		
		// terminal ANY_OTHER returns EString : . ;
		public ParserRule getRule() { return rule; }

		// .
		public Wildcard eleWildcard() { return cWildcard; }
	}
	
	public final static TerminalRulesTestLanguageGrammarAccess INSTANCE = new TerminalRulesTestLanguageGrammarAccess();

	private static final String TERMINALRULESTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/parser/terminalrules/TerminalRulesTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static ModelElements pModel;
	private static IDElements pID;
	private static INTElements pINT;
	private static STRINGElements pSTRING;
	private static ML_COMMENTElements pML_COMMENT;
	private static SL_COMMENTElements pSL_COMMENT;
	private static WSElements pWS;
	private static ANY_OTHERElements pANY_OTHER;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(TerminalRulesTestLanguageGrammarAccess.class.getClassLoader(),TERMINALRULESTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public IGrammarAccess getSuperGrammar() {
		return null;		
	}

	
	// Model : idValue = ID | intValue = INT | stringValue = STRING | mlCommentValue = ML_COMMENT | slCommentValue = SL_COMMENT | wsValue = WS | anyValue = ANY_OTHER ;
	public ModelElements prModel() {
		return (pModel != null) ? pModel : (pModel = new ModelElements());
	} 

	// terminal ID returns EString : '^' ? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' ) * ;
	public IDElements prID() {
		return (pID != null) ? pID : (pID = new IDElements());
	} 

	// terminal INT returns EString : '0' .. '9' + ;
	public INTElements prINT() {
		return (pINT != null) ? pINT : (pINT = new INTElements());
	} 

	// terminal STRING returns EString : '"' ( '\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '"' | "'" | '\\' ) | ! ( '\\' | '"' ) ) * '"' | "'" ( '\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '"' | "'" | '\\' ) | ! ( '\\' | "'" ) ) * "'" ;
	public STRINGElements prSTRING() {
		return (pSTRING != null) ? pSTRING : (pSTRING = new STRINGElements());
	} 

	// terminal ML_COMMENT returns EString : '/*' -> '*/' ;
	public ML_COMMENTElements prML_COMMENT() {
		return (pML_COMMENT != null) ? pML_COMMENT : (pML_COMMENT = new ML_COMMENTElements());
	} 

	// terminal SL_COMMENT returns EString : '//' ! ( '\n' | '\r' ) * ( '\r' ? '\n' ) ? ;
	public SL_COMMENTElements prSL_COMMENT() {
		return (pSL_COMMENT != null) ? pSL_COMMENT : (pSL_COMMENT = new SL_COMMENTElements());
	} 

	// terminal WS returns EString : ( ' ' | '\t' | '\r' | '\n' ) + ;
	public WSElements prWS() {
		return (pWS != null) ? pWS : (pWS = new WSElements());
	} 

	// terminal ANY_OTHER returns EString : . ;
	public ANY_OTHERElements prANY_OTHER() {
		return (pANY_OTHER != null) ? pANY_OTHER : (pANY_OTHER = new ANY_OTHERElements());
	} 
}
