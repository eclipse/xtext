/*
Generated with Xtext
*/

package org.eclipse.xtext.reference.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;

import org.eclipse.xtext.service.GrammarProvider;

import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

@Singleton
public class ReferenceGrammarGrammarAccess implements IGrammarAccess {
	
	
	public class SpielplatzElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Spielplatz");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Keyword c00000KeywordSpielplatz = (Keyword)c0000Group.eContents().get(0);
		private final Assignment c00001AssignmentGroesse = (Assignment)c0000Group.eContents().get(1);
		private final RuleCall c000010LexerRuleCallINT = (RuleCall)c00001AssignmentGroesse.eContents().get(0);
		private final Assignment c0001AssignmentBeschreibung = (Assignment)c000Group.eContents().get(1);
		private final RuleCall c00010LexerRuleCallSTRING = (RuleCall)c0001AssignmentBeschreibung.eContents().get(0);
		private final Keyword c001KeywordLeftCurlyBracket = (Keyword)c00Group.eContents().get(1);
		private final Alternatives c01Alternatives = (Alternatives)c0Group.eContents().get(1);
		private final Alternatives c010Alternatives = (Alternatives)c01Alternatives.eContents().get(0);
		private final Alternatives c0100Alternatives = (Alternatives)c010Alternatives.eContents().get(0);
		private final Alternatives c01000Alternatives = (Alternatives)c0100Alternatives.eContents().get(0);
		private final Assignment c010000AssignmentKinder = (Assignment)c01000Alternatives.eContents().get(0);
		private final RuleCall c0100000ParserRuleCallKind = (RuleCall)c010000AssignmentKinder.eContents().get(0);
		private final Assignment c010001AssignmentErzieher = (Assignment)c01000Alternatives.eContents().get(1);
		private final RuleCall c0100010ParserRuleCallErwachsener = (RuleCall)c010001AssignmentErzieher.eContents().get(0);
		private final Assignment c01001AssignmentSpielzeuge = (Assignment)c0100Alternatives.eContents().get(1);
		private final RuleCall c010010ParserRuleCallSpielzeug = (RuleCall)c01001AssignmentSpielzeuge.eContents().get(0);
		private final Assignment c0101AssignmentFamilie = (Assignment)c010Alternatives.eContents().get(1);
		private final RuleCall c01010ParserRuleCallFamilie = (RuleCall)c0101AssignmentFamilie.eContents().get(0);
		private final Assignment c011AssignmentTypes = (Assignment)c01Alternatives.eContents().get(1);
		private final RuleCall c0110ParserRuleCallCustomTypeParserRule = (RuleCall)c011AssignmentTypes.eContents().get(0);
		private final Keyword c1KeywordRightCurlyBracket = (Keyword)cGroup.eContents().get(1);
		
		// Spielplatz:   ("spielplatz" groesse=INT (beschreibung=STRING)? "{" (kinder+=Kind|erzieher+=Erwachsener|spielzeuge+=Spielzeug|familie+=Familie|types+=CustomTypeParserRule)* "}")?;
		public ParserRule getRule() { return rule; }

		// ("spielplatz" groesse=INT (beschreibung=STRING)? "{" (kinder+=Kind|erzieher+=Erwachsener|spielzeuge+=Spielzeug|familie+=Familie|types+=CustomTypeParserRule)* "}")?
		public Group eleGroup() { return cGroup; }

		// "spielplatz" groesse=INT (beschreibung=STRING)? "{" (kinder+=Kind|erzieher+=Erwachsener|spielzeuge+=Spielzeug|familie+=Familie|types+=CustomTypeParserRule)*
		public Group ele0Group() { return c0Group; }

		// "spielplatz" groesse=INT (beschreibung=STRING)? "{"
		public Group ele00Group() { return c00Group; }

		// "spielplatz" groesse=INT (beschreibung=STRING)?
		public Group ele000Group() { return c000Group; }

		// "spielplatz" groesse=INT
		public Group ele0000Group() { return c0000Group; }

		// "spielplatz"
		public Keyword ele00000KeywordSpielplatz() { return c00000KeywordSpielplatz; }

		// groesse=INT
		public Assignment ele00001AssignmentGroesse() { return c00001AssignmentGroesse; }

		// INT
		public RuleCall ele000010LexerRuleCallINT() { return c000010LexerRuleCallINT; }

		// (beschreibung=STRING)?
		public Assignment ele0001AssignmentBeschreibung() { return c0001AssignmentBeschreibung; }

		// STRING
		public RuleCall ele00010LexerRuleCallSTRING() { return c00010LexerRuleCallSTRING; }

		// "{"
		public Keyword ele001KeywordLeftCurlyBracket() { return c001KeywordLeftCurlyBracket; }

		// (kinder+=Kind|erzieher+=Erwachsener|spielzeuge+=Spielzeug|familie+=Familie|types+=CustomTypeParserRule)*
		public Alternatives ele01Alternatives() { return c01Alternatives; }

		// kinder+=Kind|erzieher+=Erwachsener|spielzeuge+=Spielzeug|familie+=Familie
		public Alternatives ele010Alternatives() { return c010Alternatives; }

		// kinder+=Kind|erzieher+=Erwachsener|spielzeuge+=Spielzeug
		public Alternatives ele0100Alternatives() { return c0100Alternatives; }

		// kinder+=Kind|erzieher+=Erwachsener
		public Alternatives ele01000Alternatives() { return c01000Alternatives; }

		// kinder+=Kind
		public Assignment ele010000AssignmentKinder() { return c010000AssignmentKinder; }

		// Kind
		public RuleCall ele0100000ParserRuleCallKind() { return c0100000ParserRuleCallKind; }

		// erzieher+=Erwachsener
		public Assignment ele010001AssignmentErzieher() { return c010001AssignmentErzieher; }

		// Erwachsener
		public RuleCall ele0100010ParserRuleCallErwachsener() { return c0100010ParserRuleCallErwachsener; }

		// spielzeuge+=Spielzeug
		public Assignment ele01001AssignmentSpielzeuge() { return c01001AssignmentSpielzeuge; }

		// Spielzeug
		public RuleCall ele010010ParserRuleCallSpielzeug() { return c010010ParserRuleCallSpielzeug; }

		// familie+=Familie
		public Assignment ele0101AssignmentFamilie() { return c0101AssignmentFamilie; }

		// Familie
		public RuleCall ele01010ParserRuleCallFamilie() { return c01010ParserRuleCallFamilie; }

		// types+=CustomTypeParserRule
		public Assignment ele011AssignmentTypes() { return c011AssignmentTypes; }

		// CustomTypeParserRule
		public RuleCall ele0110ParserRuleCallCustomTypeParserRule() { return c0110ParserRuleCallCustomTypeParserRule; }

		// "}"
		public Keyword ele1KeywordRightCurlyBracket() { return c1KeywordRightCurlyBracket; }
	}

	public class PersonElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Person");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallKind = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall c1ParserRuleCallErwachsener = (RuleCall)cAlternatives.eContents().get(1);
		
		// Person:   Kind|Erwachsener;
		public ParserRule getRule() { return rule; }

		// Kind|Erwachsener
		public Alternatives eleAlternatives() { return cAlternatives; }

		// Kind
		public RuleCall ele0ParserRuleCallKind() { return c0ParserRuleCallKind; }

		// Erwachsener
		public RuleCall ele1ParserRuleCallErwachsener() { return c1ParserRuleCallErwachsener; }
	}

	public class KindElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Kind");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Keyword c0000KeywordKind = (Keyword)c000Group.eContents().get(0);
		private final Keyword c0001KeywordLeftParenthesis = (Keyword)c000Group.eContents().get(1);
		private final Assignment c001AssignmentName = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010LexerRuleCallID = (RuleCall)c001AssignmentName.eContents().get(0);
		private final Assignment c01AssignmentAge = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010LexerRuleCallINT = (RuleCall)c01AssignmentAge.eContents().get(0);
		private final Keyword c1KeywordRightParenthesis = (Keyword)cGroup.eContents().get(1);
		
		// Kind:   "kind" "(" name=ID age=INT ")";
		public ParserRule getRule() { return rule; }

		// "kind" "(" name=ID age=INT ")"
		public Group eleGroup() { return cGroup; }

		// "kind" "(" name=ID age=INT
		public Group ele0Group() { return c0Group; }

		// "kind" "(" name=ID
		public Group ele00Group() { return c00Group; }

		// "kind" "("
		public Group ele000Group() { return c000Group; }

		// "kind"
		public Keyword ele0000KeywordKind() { return c0000KeywordKind; }

		// "("
		public Keyword ele0001KeywordLeftParenthesis() { return c0001KeywordLeftParenthesis; }

		// name=ID
		public Assignment ele001AssignmentName() { return c001AssignmentName; }

		// ID
		public RuleCall ele0010LexerRuleCallID() { return c0010LexerRuleCallID; }

		// age=INT
		public Assignment ele01AssignmentAge() { return c01AssignmentAge; }

		// INT
		public RuleCall ele010LexerRuleCallINT() { return c010LexerRuleCallINT; }

		// ")"
		public Keyword ele1KeywordRightParenthesis() { return c1KeywordRightParenthesis; }
	}

	public class ErwachsenerElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Erwachsener");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Keyword c0000KeywordErwachsener = (Keyword)c000Group.eContents().get(0);
		private final Keyword c0001KeywordLeftParenthesis = (Keyword)c000Group.eContents().get(1);
		private final Assignment c001AssignmentName = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010LexerRuleCallID = (RuleCall)c001AssignmentName.eContents().get(0);
		private final Assignment c01AssignmentAge = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010LexerRuleCallINT = (RuleCall)c01AssignmentAge.eContents().get(0);
		private final Keyword c1KeywordRightParenthesis = (Keyword)cGroup.eContents().get(1);
		
		// Erwachsener:   "erwachsener" "(" name=ID age=INT ")";
		public ParserRule getRule() { return rule; }

		// "erwachsener" "(" name=ID age=INT ")"
		public Group eleGroup() { return cGroup; }

		// "erwachsener" "(" name=ID age=INT
		public Group ele0Group() { return c0Group; }

		// "erwachsener" "(" name=ID
		public Group ele00Group() { return c00Group; }

		// "erwachsener" "("
		public Group ele000Group() { return c000Group; }

		// "erwachsener"
		public Keyword ele0000KeywordErwachsener() { return c0000KeywordErwachsener; }

		// "("
		public Keyword ele0001KeywordLeftParenthesis() { return c0001KeywordLeftParenthesis; }

		// name=ID
		public Assignment ele001AssignmentName() { return c001AssignmentName; }

		// ID
		public RuleCall ele0010LexerRuleCallID() { return c0010LexerRuleCallID; }

		// age=INT
		public Assignment ele01AssignmentAge() { return c01AssignmentAge; }

		// INT
		public RuleCall ele010LexerRuleCallINT() { return c010LexerRuleCallINT; }

		// ")"
		public Keyword ele1KeywordRightParenthesis() { return c1KeywordRightParenthesis; }
	}

	public class SpielzeugElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Spielzeug");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Keyword c0000KeywordSpielzeug = (Keyword)c000Group.eContents().get(0);
		private final Keyword c0001KeywordLeftParenthesis = (Keyword)c000Group.eContents().get(1);
		private final Assignment c001AssignmentName = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010LexerRuleCallID = (RuleCall)c001AssignmentName.eContents().get(0);
		private final Assignment c01AssignmentFarbe = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010ParserRuleCallFarbe = (RuleCall)c01AssignmentFarbe.eContents().get(0);
		private final Keyword c1KeywordRightParenthesis = (Keyword)cGroup.eContents().get(1);
		
		// Spielzeug:   "spielzeug" "(" name=ID farbe=Farbe ")";
		public ParserRule getRule() { return rule; }

		// "spielzeug" "(" name=ID farbe=Farbe ")"
		public Group eleGroup() { return cGroup; }

		// "spielzeug" "(" name=ID farbe=Farbe
		public Group ele0Group() { return c0Group; }

		// "spielzeug" "(" name=ID
		public Group ele00Group() { return c00Group; }

		// "spielzeug" "("
		public Group ele000Group() { return c000Group; }

		// "spielzeug"
		public Keyword ele0000KeywordSpielzeug() { return c0000KeywordSpielzeug; }

		// "("
		public Keyword ele0001KeywordLeftParenthesis() { return c0001KeywordLeftParenthesis; }

		// name=ID
		public Assignment ele001AssignmentName() { return c001AssignmentName; }

		// ID
		public RuleCall ele0010LexerRuleCallID() { return c0010LexerRuleCallID; }

		// farbe=Farbe
		public Assignment ele01AssignmentFarbe() { return c01AssignmentFarbe; }

		// Farbe
		public RuleCall ele010ParserRuleCallFarbe() { return c010ParserRuleCallFarbe; }

		// ")"
		public Keyword ele1KeywordRightParenthesis() { return c1KeywordRightParenthesis; }
	}

	public class FamilieElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Familie");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Group c00000Group = (Group)c0000Group.eContents().get(0);
		private final Group c000000Group = (Group)c00000Group.eContents().get(0);
		private final Keyword c0000000KeywordFamilie = (Keyword)c000000Group.eContents().get(0);
		private final Keyword c0000001KeywordLeftParenthesis = (Keyword)c000000Group.eContents().get(1);
		private final Assignment c000001AssignmentName = (Assignment)c00000Group.eContents().get(1);
		private final Alternatives c0000010Alternatives = (Alternatives)c000001AssignmentName.eContents().get(0);
		private final Alternatives c00000100Alternatives = (Alternatives)c0000010Alternatives.eContents().get(0);
		private final Keyword c000001000KeywordKeyword = (Keyword)c00000100Alternatives.eContents().get(0);
		private final RuleCall c000001001LexerRuleCallSTRING = (RuleCall)c00000100Alternatives.eContents().get(1);
		private final RuleCall c00000101LexerRuleCallID = (RuleCall)c0000010Alternatives.eContents().get(1);
		private final Assignment c00001AssignmentMutter = (Assignment)c0000Group.eContents().get(1);
		private final CrossReference c000010CrossReferenceEStringErwachsener = (CrossReference)c00001AssignmentMutter.eContents().get(0);
		private final Assignment c0001AssignmentVater = (Assignment)c000Group.eContents().get(1);
		private final CrossReference c00010CrossReferenceEStringErwachsener = (CrossReference)c0001AssignmentVater.eContents().get(0);
		private final Assignment c001AssignmentKinder = (Assignment)c00Group.eContents().get(1);
		private final CrossReference c0010CrossReferenceEStringKind = (CrossReference)c001AssignmentKinder.eContents().get(0);
		private final Group c01Group = (Group)c0Group.eContents().get(1);
		private final Keyword c010KeywordComma = (Keyword)c01Group.eContents().get(0);
		private final Assignment c011AssignmentKinder = (Assignment)c01Group.eContents().get(1);
		private final CrossReference c0110CrossReferenceEStringKind = (CrossReference)c011AssignmentKinder.eContents().get(0);
		private final Keyword c1KeywordRightParenthesis = (Keyword)cGroup.eContents().get(1);
		
		// Familie:   "familie" "(" name=("keyword"|STRING|ID) mutter=[Erwachsener] vater=[Erwachsener] kinder+=[Kind] ("," kinder+=[Kind])* ")";
		public ParserRule getRule() { return rule; }

		// "familie" "(" name=("keyword"|STRING|ID) mutter=[Erwachsener] vater=[Erwachsener] kinder+=[Kind] ("," kinder+=[Kind])* ")"
		public Group eleGroup() { return cGroup; }

		// "familie" "(" name=("keyword"|STRING|ID) mutter=[Erwachsener] vater=[Erwachsener] kinder+=[Kind] ("," kinder+=[Kind])*
		public Group ele0Group() { return c0Group; }

		// "familie" "(" name=("keyword"|STRING|ID) mutter=[Erwachsener] vater=[Erwachsener] kinder+=[Kind]
		public Group ele00Group() { return c00Group; }

		// "familie" "(" name=("keyword"|STRING|ID) mutter=[Erwachsener] vater=[Erwachsener]
		public Group ele000Group() { return c000Group; }

		// "familie" "(" name=("keyword"|STRING|ID) mutter=[Erwachsener]
		public Group ele0000Group() { return c0000Group; }

		// "familie" "(" name=("keyword"|STRING|ID)
		public Group ele00000Group() { return c00000Group; }

		// "familie" "("
		public Group ele000000Group() { return c000000Group; }

		// "familie"
		public Keyword ele0000000KeywordFamilie() { return c0000000KeywordFamilie; }

		// "("
		public Keyword ele0000001KeywordLeftParenthesis() { return c0000001KeywordLeftParenthesis; }

		// name=("keyword"|STRING|ID)
		public Assignment ele000001AssignmentName() { return c000001AssignmentName; }

		// "keyword"|STRING|ID
		public Alternatives ele0000010Alternatives() { return c0000010Alternatives; }

		// "keyword"|STRING
		public Alternatives ele00000100Alternatives() { return c00000100Alternatives; }

		// "keyword"
		public Keyword ele000001000KeywordKeyword() { return c000001000KeywordKeyword; }

		// STRING
		public RuleCall ele000001001LexerRuleCallSTRING() { return c000001001LexerRuleCallSTRING; }

		// ID
		public RuleCall ele00000101LexerRuleCallID() { return c00000101LexerRuleCallID; }

		// mutter=[Erwachsener]
		public Assignment ele00001AssignmentMutter() { return c00001AssignmentMutter; }

		// [Erwachsener]
		public CrossReference ele000010CrossReferenceEStringErwachsener() { return c000010CrossReferenceEStringErwachsener; }

		// vater=[Erwachsener]
		public Assignment ele0001AssignmentVater() { return c0001AssignmentVater; }

		// [Erwachsener]
		public CrossReference ele00010CrossReferenceEStringErwachsener() { return c00010CrossReferenceEStringErwachsener; }

		// kinder+=[Kind]
		public Assignment ele001AssignmentKinder() { return c001AssignmentKinder; }

		// [Kind]
		public CrossReference ele0010CrossReferenceEStringKind() { return c0010CrossReferenceEStringKind; }

		// ("," kinder+=[Kind])*
		public Group ele01Group() { return c01Group; }

		// ","
		public Keyword ele010KeywordComma() { return c010KeywordComma; }

		// kinder+=[Kind]
		public Assignment ele011AssignmentKinder() { return c011AssignmentKinder; }

		// [Kind]
		public CrossReference ele0110CrossReferenceEStringKind() { return c0110CrossReferenceEStringKind; }

		// ")"
		public Keyword ele1KeywordRightParenthesis() { return c1KeywordRightParenthesis; }
	}

	public class FarbeElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Farbe");
		private final Assignment cAssignmentWert = (Assignment)rule.eContents().get(1);
		private final Alternatives c0Alternatives = (Alternatives)cAssignmentWert.eContents().get(0);
		private final Alternatives c00Alternatives = (Alternatives)c0Alternatives.eContents().get(0);
		private final Alternatives c000Alternatives = (Alternatives)c00Alternatives.eContents().get(0);
		private final Keyword c0000KeywordROT = (Keyword)c000Alternatives.eContents().get(0);
		private final Keyword c0001KeywordBLAU = (Keyword)c000Alternatives.eContents().get(1);
		private final Keyword c001KeywordGELB = (Keyword)c00Alternatives.eContents().get(1);
		private final Keyword c01KeywordGRÜN = (Keyword)c0Alternatives.eContents().get(1);
		
		// Farbe:   wert=("ROT"|"BLAU"|"GELB"|"GR\u00DCN");
		public ParserRule getRule() { return rule; }

		// wert=("ROT"|"BLAU"|"GELB"|"GR\u00DCN")
		public Assignment eleAssignmentWert() { return cAssignmentWert; }

		// "ROT"|"BLAU"|"GELB"|"GR\u00DCN"
		public Alternatives ele0Alternatives() { return c0Alternatives; }

		// "ROT"|"BLAU"|"GELB"
		public Alternatives ele00Alternatives() { return c00Alternatives; }

		// "ROT"|"BLAU"
		public Alternatives ele000Alternatives() { return c000Alternatives; }

		// "ROT"
		public Keyword ele0000KeywordROT() { return c0000KeywordROT; }

		// "BLAU"
		public Keyword ele0001KeywordBLAU() { return c0001KeywordBLAU; }

		// "GELB"
		public Keyword ele001KeywordGELB() { return c001KeywordGELB; }

		// "GR\u00DCN"
		public Keyword ele01KeywordGRÜN() { return c01KeywordGRÜN; }
	}

	public class CustomTypeParserRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "CustomTypeParserRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordType = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentName = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallID = (RuleCall)c1AssignmentName.eContents().get(0);
		
		// CustomTypeParserRule returns CustomType:   "type" name=ID;
		public ParserRule getRule() { return rule; }

		// "type" name=ID
		public Group eleGroup() { return cGroup; }

		// "type"
		public Keyword ele0KeywordType() { return c0KeywordType; }

		// name=ID
		public Assignment ele1AssignmentName() { return c1AssignmentName; }

		// ID
		public RuleCall ele10LexerRuleCallID() { return c10LexerRuleCallID; }
	}
	
	private SpielplatzElements pSpielplatz;
	private PersonElements pPerson;
	private KindElements pKind;
	private ErwachsenerElements pErwachsener;
	private SpielzeugElements pSpielzeug;
	private FamilieElements pFamilie;
	private FarbeElements pFarbe;
	private CustomTypeParserRuleElements pCustomTypeParserRule;
	
	private final GrammarProvider grammarProvider;

	private XtextBuiltinGrammarAccess superGrammarAccess;

	@Inject
	public ReferenceGrammarGrammarAccess(GrammarProvider grammarProvider, XtextBuiltinGrammarAccess superGrammarAccess) {
		this.grammarProvider = grammarProvider;
		this.superGrammarAccess = superGrammarAccess;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	public XtextBuiltinGrammarAccess getSuperGrammarAccess() {
		return superGrammarAccess;
	}

	
	// Spielplatz:   ("spielplatz" groesse=INT (beschreibung=STRING)? "{" (kinder+=Kind|erzieher+=Erwachsener|spielzeuge+=Spielzeug|familie+=Familie|types+=CustomTypeParserRule)* "}")?;
	public SpielplatzElements prSpielplatz() {
		return (pSpielplatz != null) ? pSpielplatz : (pSpielplatz = new SpielplatzElements());
	} 

	// Person:   Kind|Erwachsener;
	public PersonElements prPerson() {
		return (pPerson != null) ? pPerson : (pPerson = new PersonElements());
	} 

	// Kind:   "kind" "(" name=ID age=INT ")";
	public KindElements prKind() {
		return (pKind != null) ? pKind : (pKind = new KindElements());
	} 

	// Erwachsener:   "erwachsener" "(" name=ID age=INT ")";
	public ErwachsenerElements prErwachsener() {
		return (pErwachsener != null) ? pErwachsener : (pErwachsener = new ErwachsenerElements());
	} 

	// Spielzeug:   "spielzeug" "(" name=ID farbe=Farbe ")";
	public SpielzeugElements prSpielzeug() {
		return (pSpielzeug != null) ? pSpielzeug : (pSpielzeug = new SpielzeugElements());
	} 

	// Familie:   "familie" "(" name=("keyword"|STRING|ID) mutter=[Erwachsener] vater=[Erwachsener] kinder+=[Kind] ("," kinder+=[Kind])* ")";
	public FamilieElements prFamilie() {
		return (pFamilie != null) ? pFamilie : (pFamilie = new FamilieElements());
	} 

	// Farbe:   wert=("ROT"|"BLAU"|"GELB"|"GR\u00DCN");
	public FarbeElements prFarbe() {
		return (pFarbe != null) ? pFarbe : (pFarbe = new FarbeElements());
	} 

	// CustomTypeParserRule returns CustomType:   "type" name=ID;
	public CustomTypeParserRuleElements prCustomTypeParserRule() {
		return (pCustomTypeParserRule != null) ? pCustomTypeParserRule : (pCustomTypeParserRule = new CustomTypeParserRuleElements());
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
