/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class ReferenceGrammarTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class SpielplatzElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(1);
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
		private final Assignment c01000AssignmentKinder = (Assignment)c0100Alternatives.eContents().get(0);
		private final RuleCall c010000ParserRuleCallKind = (RuleCall)c01000AssignmentKinder.eContents().get(0);
		private final Assignment c01001AssignmentErzieher = (Assignment)c0100Alternatives.eContents().get(1);
		private final RuleCall c010010ParserRuleCallErwachsener = (RuleCall)c01001AssignmentErzieher.eContents().get(0);
		private final Assignment c0101AssignmentSpielzeuge = (Assignment)c010Alternatives.eContents().get(1);
		private final RuleCall c01010ParserRuleCallSpielzeug = (RuleCall)c0101AssignmentSpielzeuge.eContents().get(0);
		private final Assignment c011AssignmentFamilie = (Assignment)c01Alternatives.eContents().get(1);
		private final RuleCall c0110ParserRuleCallFamilie = (RuleCall)c011AssignmentFamilie.eContents().get(0);
		private final Keyword c1KeywordRightCurlyBracket = (Keyword)cGroup.eContents().get(1);
		
		// Spielplatz : ( 'spielplatz' groesse = INT ( beschreibung = STRING ) ? '{' ( kinder += Kind | erzieher += Erwachsener | spielzeuge += Spielzeug | familie += Familie ) * '}' ) ? ;
		public ParserRule getRule() { return rule; }

		// ( 'spielplatz' groesse = INT ( beschreibung = STRING ) ? '{' ( kinder += Kind | erzieher += Erwachsener | spielzeuge += Spielzeug | familie += Familie ) * '}' ) ?
		public Group eleGroup() { return cGroup; }

		// 'spielplatz' groesse = INT ( beschreibung = STRING ) ? '{' ( kinder += Kind | erzieher += Erwachsener | spielzeuge += Spielzeug | familie += Familie ) *
		public Group ele0Group() { return c0Group; }

		// 'spielplatz' groesse = INT ( beschreibung = STRING ) ? '{'
		public Group ele00Group() { return c00Group; }

		// 'spielplatz' groesse = INT ( beschreibung = STRING ) ?
		public Group ele000Group() { return c000Group; }

		// 'spielplatz' groesse = INT
		public Group ele0000Group() { return c0000Group; }

		// 'spielplatz'
		public Keyword ele00000KeywordSpielplatz() { return c00000KeywordSpielplatz; }

		// groesse = INT
		public Assignment ele00001AssignmentGroesse() { return c00001AssignmentGroesse; }

		// INT
		public RuleCall ele000010LexerRuleCallINT() { return c000010LexerRuleCallINT; }

		// ( beschreibung = STRING ) ?
		public Assignment ele0001AssignmentBeschreibung() { return c0001AssignmentBeschreibung; }

		// STRING
		public RuleCall ele00010LexerRuleCallSTRING() { return c00010LexerRuleCallSTRING; }

		// '{'
		public Keyword ele001KeywordLeftCurlyBracket() { return c001KeywordLeftCurlyBracket; }

		// ( kinder += Kind | erzieher += Erwachsener | spielzeuge += Spielzeug | familie += Familie ) *
		public Alternatives ele01Alternatives() { return c01Alternatives; }

		// kinder += Kind | erzieher += Erwachsener | spielzeuge += Spielzeug
		public Alternatives ele010Alternatives() { return c010Alternatives; }

		// kinder += Kind | erzieher += Erwachsener
		public Alternatives ele0100Alternatives() { return c0100Alternatives; }

		// kinder += Kind
		public Assignment ele01000AssignmentKinder() { return c01000AssignmentKinder; }

		// Kind
		public RuleCall ele010000ParserRuleCallKind() { return c010000ParserRuleCallKind; }

		// erzieher += Erwachsener
		public Assignment ele01001AssignmentErzieher() { return c01001AssignmentErzieher; }

		// Erwachsener
		public RuleCall ele010010ParserRuleCallErwachsener() { return c010010ParserRuleCallErwachsener; }

		// spielzeuge += Spielzeug
		public Assignment ele0101AssignmentSpielzeuge() { return c0101AssignmentSpielzeuge; }

		// Spielzeug
		public RuleCall ele01010ParserRuleCallSpielzeug() { return c01010ParserRuleCallSpielzeug; }

		// familie += Familie
		public Assignment ele011AssignmentFamilie() { return c011AssignmentFamilie; }

		// Familie
		public RuleCall ele0110ParserRuleCallFamilie() { return c0110ParserRuleCallFamilie; }

		// '}'
		public Keyword ele1KeywordRightCurlyBracket() { return c1KeywordRightCurlyBracket; }
	}

	public class PersonElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(2);
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallKind = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall c1ParserRuleCallErwachsener = (RuleCall)cAlternatives.eContents().get(1);
		
		// Person : Kind | Erwachsener ;
		public ParserRule getRule() { return rule; }

		// Kind | Erwachsener
		public Alternatives eleAlternatives() { return cAlternatives; }

		// Kind
		public RuleCall ele0ParserRuleCallKind() { return c0ParserRuleCallKind; }

		// Erwachsener
		public RuleCall ele1ParserRuleCallErwachsener() { return c1ParserRuleCallErwachsener; }
	}

	public class KindElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(3);
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
		
		// Kind : 'kind' '(' name = ID age = INT ')' ;
		public ParserRule getRule() { return rule; }

		// 'kind' '(' name = ID age = INT ')'
		public Group eleGroup() { return cGroup; }

		// 'kind' '(' name = ID age = INT
		public Group ele0Group() { return c0Group; }

		// 'kind' '(' name = ID
		public Group ele00Group() { return c00Group; }

		// 'kind' '('
		public Group ele000Group() { return c000Group; }

		// 'kind'
		public Keyword ele0000KeywordKind() { return c0000KeywordKind; }

		// '('
		public Keyword ele0001KeywordLeftParenthesis() { return c0001KeywordLeftParenthesis; }

		// name = ID
		public Assignment ele001AssignmentName() { return c001AssignmentName; }

		// ID
		public RuleCall ele0010LexerRuleCallID() { return c0010LexerRuleCallID; }

		// age = INT
		public Assignment ele01AssignmentAge() { return c01AssignmentAge; }

		// INT
		public RuleCall ele010LexerRuleCallINT() { return c010LexerRuleCallINT; }

		// ')'
		public Keyword ele1KeywordRightParenthesis() { return c1KeywordRightParenthesis; }
	}

	public class ErwachsenerElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(4);
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
		
		// Erwachsener : 'erwachsener' '(' name = ID age = INT ')' ;
		public ParserRule getRule() { return rule; }

		// 'erwachsener' '(' name = ID age = INT ')'
		public Group eleGroup() { return cGroup; }

		// 'erwachsener' '(' name = ID age = INT
		public Group ele0Group() { return c0Group; }

		// 'erwachsener' '(' name = ID
		public Group ele00Group() { return c00Group; }

		// 'erwachsener' '('
		public Group ele000Group() { return c000Group; }

		// 'erwachsener'
		public Keyword ele0000KeywordErwachsener() { return c0000KeywordErwachsener; }

		// '('
		public Keyword ele0001KeywordLeftParenthesis() { return c0001KeywordLeftParenthesis; }

		// name = ID
		public Assignment ele001AssignmentName() { return c001AssignmentName; }

		// ID
		public RuleCall ele0010LexerRuleCallID() { return c0010LexerRuleCallID; }

		// age = INT
		public Assignment ele01AssignmentAge() { return c01AssignmentAge; }

		// INT
		public RuleCall ele010LexerRuleCallINT() { return c010LexerRuleCallINT; }

		// ')'
		public Keyword ele1KeywordRightParenthesis() { return c1KeywordRightParenthesis; }
	}

	public class SpielzeugElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(5);
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
		
		// Spielzeug : 'spielzeug' '(' name = ID farbe = Farbe ')' ;
		public ParserRule getRule() { return rule; }

		// 'spielzeug' '(' name = ID farbe = Farbe ')'
		public Group eleGroup() { return cGroup; }

		// 'spielzeug' '(' name = ID farbe = Farbe
		public Group ele0Group() { return c0Group; }

		// 'spielzeug' '(' name = ID
		public Group ele00Group() { return c00Group; }

		// 'spielzeug' '('
		public Group ele000Group() { return c000Group; }

		// 'spielzeug'
		public Keyword ele0000KeywordSpielzeug() { return c0000KeywordSpielzeug; }

		// '('
		public Keyword ele0001KeywordLeftParenthesis() { return c0001KeywordLeftParenthesis; }

		// name = ID
		public Assignment ele001AssignmentName() { return c001AssignmentName; }

		// ID
		public RuleCall ele0010LexerRuleCallID() { return c0010LexerRuleCallID; }

		// farbe = Farbe
		public Assignment ele01AssignmentFarbe() { return c01AssignmentFarbe; }

		// Farbe
		public RuleCall ele010ParserRuleCallFarbe() { return c010ParserRuleCallFarbe; }

		// ')'
		public Keyword ele1KeywordRightParenthesis() { return c1KeywordRightParenthesis; }
	}

	public class FarbeElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(6);
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Alternatives c0Alternatives = (Alternatives)cAlternatives.eContents().get(0);
		private final Alternatives c00Alternatives = (Alternatives)c0Alternatives.eContents().get(0);
		private final Keyword c000KeywordROT = (Keyword)c00Alternatives.eContents().get(0);
		private final Keyword c001KeywordBLAU = (Keyword)c00Alternatives.eContents().get(1);
		private final Keyword c01KeywordGELB = (Keyword)c0Alternatives.eContents().get(1);
		private final Keyword c1KeywordGRÜN = (Keyword)cAlternatives.eContents().get(1);
		
		// Farbe : 'ROT' | 'BLAU' | 'GELB' | 'GRÜN' ;
		public ParserRule getRule() { return rule; }

		// 'ROT' | 'BLAU' | 'GELB' | 'GRÜN'
		public Alternatives eleAlternatives() { return cAlternatives; }

		// 'ROT' | 'BLAU' | 'GELB'
		public Alternatives ele0Alternatives() { return c0Alternatives; }

		// 'ROT' | 'BLAU'
		public Alternatives ele00Alternatives() { return c00Alternatives; }

		// 'ROT'
		public Keyword ele000KeywordROT() { return c000KeywordROT; }

		// 'BLAU'
		public Keyword ele001KeywordBLAU() { return c001KeywordBLAU; }

		// 'GELB'
		public Keyword ele01KeywordGELB() { return c01KeywordGELB; }

		// 'GRÜN'
		public Keyword ele1KeywordGRÜN() { return c1KeywordGRÜN; }
	}

	public class FamilieElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(7);
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
		private final CrossReference c000010CrossReferenceErwachsener = (CrossReference)c00001AssignmentMutter.eContents().get(0);
		private final Assignment c0001AssignmentVater = (Assignment)c000Group.eContents().get(1);
		private final CrossReference c00010CrossReferenceErwachsener = (CrossReference)c0001AssignmentVater.eContents().get(0);
		private final Assignment c001AssignmentKinder = (Assignment)c00Group.eContents().get(1);
		private final CrossReference c0010CrossReferenceKind = (CrossReference)c001AssignmentKinder.eContents().get(0);
		private final Group c01Group = (Group)c0Group.eContents().get(1);
		private final Keyword c010KeywordComma = (Keyword)c01Group.eContents().get(0);
		private final Assignment c011AssignmentKinder = (Assignment)c01Group.eContents().get(1);
		private final CrossReference c0110CrossReferenceKind = (CrossReference)c011AssignmentKinder.eContents().get(0);
		private final Keyword c1KeywordRightParenthesis = (Keyword)cGroup.eContents().get(1);
		
		// Familie : 'familie' '(' name = ( 'keyword' | STRING | ID ) mutter = [ Erwachsener ] vater = [ Erwachsener ] kinder += [ Kind ] ( ',' kinder += [ Kind ] ) * ')' ;
		public ParserRule getRule() { return rule; }

		// 'familie' '(' name = ( 'keyword' | STRING | ID ) mutter = [ Erwachsener ] vater = [ Erwachsener ] kinder += [ Kind ] ( ',' kinder += [ Kind ] ) * ')'
		public Group eleGroup() { return cGroup; }

		// 'familie' '(' name = ( 'keyword' | STRING | ID ) mutter = [ Erwachsener ] vater = [ Erwachsener ] kinder += [ Kind ] ( ',' kinder += [ Kind ] ) *
		public Group ele0Group() { return c0Group; }

		// 'familie' '(' name = ( 'keyword' | STRING | ID ) mutter = [ Erwachsener ] vater = [ Erwachsener ] kinder += [ Kind ]
		public Group ele00Group() { return c00Group; }

		// 'familie' '(' name = ( 'keyword' | STRING | ID ) mutter = [ Erwachsener ] vater = [ Erwachsener ]
		public Group ele000Group() { return c000Group; }

		// 'familie' '(' name = ( 'keyword' | STRING | ID ) mutter = [ Erwachsener ]
		public Group ele0000Group() { return c0000Group; }

		// 'familie' '(' name = ( 'keyword' | STRING | ID )
		public Group ele00000Group() { return c00000Group; }

		// 'familie' '('
		public Group ele000000Group() { return c000000Group; }

		// 'familie'
		public Keyword ele0000000KeywordFamilie() { return c0000000KeywordFamilie; }

		// '('
		public Keyword ele0000001KeywordLeftParenthesis() { return c0000001KeywordLeftParenthesis; }

		// name = ( 'keyword' | STRING | ID )
		public Assignment ele000001AssignmentName() { return c000001AssignmentName; }

		// 'keyword' | STRING | ID
		public Alternatives ele0000010Alternatives() { return c0000010Alternatives; }

		// 'keyword' | STRING
		public Alternatives ele00000100Alternatives() { return c00000100Alternatives; }

		// 'keyword'
		public Keyword ele000001000KeywordKeyword() { return c000001000KeywordKeyword; }

		// STRING
		public RuleCall ele000001001LexerRuleCallSTRING() { return c000001001LexerRuleCallSTRING; }

		// ID
		public RuleCall ele00000101LexerRuleCallID() { return c00000101LexerRuleCallID; }

		// mutter = [ Erwachsener ]
		public Assignment ele00001AssignmentMutter() { return c00001AssignmentMutter; }

		// [ Erwachsener ]
		public CrossReference ele000010CrossReferenceErwachsener() { return c000010CrossReferenceErwachsener; }

		// vater = [ Erwachsener ]
		public Assignment ele0001AssignmentVater() { return c0001AssignmentVater; }

		// [ Erwachsener ]
		public CrossReference ele00010CrossReferenceErwachsener() { return c00010CrossReferenceErwachsener; }

		// kinder += [ Kind ]
		public Assignment ele001AssignmentKinder() { return c001AssignmentKinder; }

		// [ Kind ]
		public CrossReference ele0010CrossReferenceKind() { return c0010CrossReferenceKind; }

		// ( ',' kinder += [ Kind ] ) *
		public Group ele01Group() { return c01Group; }

		// ','
		public Keyword ele010KeywordComma() { return c010KeywordComma; }

		// kinder += [ Kind ]
		public Assignment ele011AssignmentKinder() { return c011AssignmentKinder; }

		// [ Kind ]
		public CrossReference ele0110CrossReferenceKind() { return c0110CrossReferenceKind; }

		// ')'
		public Keyword ele1KeywordRightParenthesis() { return c1KeywordRightParenthesis; }
	}
	
	public final static ReferenceGrammarTestLanguageGrammarAccess INSTANCE = new ReferenceGrammarTestLanguageGrammarAccess();

	private static final String REFERENCEGRAMMARTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammarTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static SpielplatzElements pSpielplatz;
	private static PersonElements pPerson;
	private static KindElements pKind;
	private static ErwachsenerElements pErwachsener;
	private static SpielzeugElements pSpielzeug;
	private static FarbeElements pFarbe;
	private static FamilieElements pFamilie;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(ReferenceGrammarTestLanguageGrammarAccess.class.getClassLoader(),REFERENCEGRAMMARTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;		
	}

	
	// Spielplatz : ( 'spielplatz' groesse = INT ( beschreibung = STRING ) ? '{' ( kinder += Kind | erzieher += Erwachsener | spielzeuge += Spielzeug | familie += Familie ) * '}' ) ? ;
	public SpielplatzElements prSpielplatz() {
		return (pSpielplatz != null) ? pSpielplatz : (pSpielplatz = new SpielplatzElements());
	} 

	// Person : Kind | Erwachsener ;
	public PersonElements prPerson() {
		return (pPerson != null) ? pPerson : (pPerson = new PersonElements());
	} 

	// Kind : 'kind' '(' name = ID age = INT ')' ;
	public KindElements prKind() {
		return (pKind != null) ? pKind : (pKind = new KindElements());
	} 

	// Erwachsener : 'erwachsener' '(' name = ID age = INT ')' ;
	public ErwachsenerElements prErwachsener() {
		return (pErwachsener != null) ? pErwachsener : (pErwachsener = new ErwachsenerElements());
	} 

	// Spielzeug : 'spielzeug' '(' name = ID farbe = Farbe ')' ;
	public SpielzeugElements prSpielzeug() {
		return (pSpielzeug != null) ? pSpielzeug : (pSpielzeug = new SpielzeugElements());
	} 

	// Farbe : 'ROT' | 'BLAU' | 'GELB' | 'GRÜN' ;
	public FarbeElements prFarbe() {
		return (pFarbe != null) ? pFarbe : (pFarbe = new FarbeElements());
	} 

	// Familie : 'familie' '(' name = ( 'keyword' | STRING | ID ) mutter = [ Erwachsener ] vater = [ Erwachsener ] kinder += [ Kind ] ( ',' kinder += [ Kind ] ) * ')' ;
	public FamilieElements prFamilie() {
		return (pFamilie != null) ? pFamilie : (pFamilie = new FamilieElements());
	} 
}
