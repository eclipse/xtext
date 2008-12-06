/*
Generated with Xtext
*/

package org.eclipse.xtext.reference.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class ReferenceGrammarGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class SpielplatzElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Group c000Group;
		private Group c0000Group;
		private Keyword c00000KeywordSpielplatz;
		private Assignment c00001AssignmentGroesse;
		private RuleCall c000010LexerRuleCallINT;
		private Assignment c0001AssignmentBeschreibung;
		private RuleCall c00010LexerRuleCallSTRING;
		private Keyword c001Keyword;
		private Alternatives c01Alternatives;
		private Alternatives c010Alternatives;
		private Alternatives c0100Alternatives;
		private Alternatives c01000Alternatives;
		private Assignment c010000AssignmentKinder;
		private RuleCall c0100000ParserRuleCallKind;
		private Assignment c010001AssignmentErzieher;
		private RuleCall c0100010ParserRuleCallErwachsener;
		private Assignment c01001AssignmentSpielzeuge;
		private RuleCall c010010ParserRuleCallSpielzeug;
		private Assignment c0101AssignmentFamilie;
		private RuleCall c01010ParserRuleCallFamilie;
		private Assignment c011AssignmentTypes;
		private RuleCall c0110ParserRuleCallCustomTypeParserRule;
		private Keyword c1Keyword;
		
		// Spielplatz : ( 'spielplatz' groesse = INT ( beschreibung = STRING ) ? '{' ( kinder += Kind | erzieher += Erwachsener | spielzeuge += Spielzeug | familie += Familie | types += CustomTypeParserRule ) * '}' ) ? ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(2)); 
		}

		// ( 'spielplatz' groesse = INT ( beschreibung = STRING ) ? '{' ( kinder += Kind | erzieher += Erwachsener | spielzeuge += Spielzeug | familie += Familie | types += CustomTypeParserRule ) * '}' ) ?
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// 'spielplatz' groesse = INT ( beschreibung = STRING ) ? '{' ( kinder += Kind | erzieher += Erwachsener | spielzeuge += Spielzeug | familie += Familie | types += CustomTypeParserRule ) *
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'spielplatz' groesse = INT ( beschreibung = STRING ) ? '{'
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// 'spielplatz' groesse = INT ( beschreibung = STRING ) ?
		public Group ele000Group() {
			return (c000Group != null) ? c000Group : (c000Group = (Group)ele00Group().eContents().get(0)); 
		}

		// 'spielplatz' groesse = INT
		public Group ele0000Group() {
			return (c0000Group != null) ? c0000Group : (c0000Group = (Group)ele000Group().eContents().get(0)); 
		}

		// 'spielplatz'
		public Keyword ele00000KeywordSpielplatz() {
			return (c00000KeywordSpielplatz != null) ? c00000KeywordSpielplatz : (c00000KeywordSpielplatz = (Keyword)ele0000Group().eContents().get(0)); 
		}

		// groesse = INT
		public Assignment ele00001AssignmentGroesse() {
			return (c00001AssignmentGroesse != null) ? c00001AssignmentGroesse : (c00001AssignmentGroesse = (Assignment)ele0000Group().eContents().get(1)); 
		}

		// INT
		public RuleCall ele000010LexerRuleCallINT() {
			return (c000010LexerRuleCallINT != null) ? c000010LexerRuleCallINT : (c000010LexerRuleCallINT = (RuleCall)ele00001AssignmentGroesse().eContents().get(0)); 
		}

		// ( beschreibung = STRING ) ?
		public Assignment ele0001AssignmentBeschreibung() {
			return (c0001AssignmentBeschreibung != null) ? c0001AssignmentBeschreibung : (c0001AssignmentBeschreibung = (Assignment)ele000Group().eContents().get(1)); 
		}

		// STRING
		public RuleCall ele00010LexerRuleCallSTRING() {
			return (c00010LexerRuleCallSTRING != null) ? c00010LexerRuleCallSTRING : (c00010LexerRuleCallSTRING = (RuleCall)ele0001AssignmentBeschreibung().eContents().get(0)); 
		}

		// '{'
		public Keyword ele001Keyword() {
			return (c001Keyword != null) ? c001Keyword : (c001Keyword = (Keyword)ele00Group().eContents().get(1)); 
		}

		// ( kinder += Kind | erzieher += Erwachsener | spielzeuge += Spielzeug | familie += Familie | types += CustomTypeParserRule ) *
		public Alternatives ele01Alternatives() {
			return (c01Alternatives != null) ? c01Alternatives : (c01Alternatives = (Alternatives)ele0Group().eContents().get(1)); 
		}

		// kinder += Kind | erzieher += Erwachsener | spielzeuge += Spielzeug | familie += Familie
		public Alternatives ele010Alternatives() {
			return (c010Alternatives != null) ? c010Alternatives : (c010Alternatives = (Alternatives)ele01Alternatives().eContents().get(0)); 
		}

		// kinder += Kind | erzieher += Erwachsener | spielzeuge += Spielzeug
		public Alternatives ele0100Alternatives() {
			return (c0100Alternatives != null) ? c0100Alternatives : (c0100Alternatives = (Alternatives)ele010Alternatives().eContents().get(0)); 
		}

		// kinder += Kind | erzieher += Erwachsener
		public Alternatives ele01000Alternatives() {
			return (c01000Alternatives != null) ? c01000Alternatives : (c01000Alternatives = (Alternatives)ele0100Alternatives().eContents().get(0)); 
		}

		// kinder += Kind
		public Assignment ele010000AssignmentKinder() {
			return (c010000AssignmentKinder != null) ? c010000AssignmentKinder : (c010000AssignmentKinder = (Assignment)ele01000Alternatives().eContents().get(0)); 
		}

		// Kind
		public RuleCall ele0100000ParserRuleCallKind() {
			return (c0100000ParserRuleCallKind != null) ? c0100000ParserRuleCallKind : (c0100000ParserRuleCallKind = (RuleCall)ele010000AssignmentKinder().eContents().get(0)); 
		}

		// erzieher += Erwachsener
		public Assignment ele010001AssignmentErzieher() {
			return (c010001AssignmentErzieher != null) ? c010001AssignmentErzieher : (c010001AssignmentErzieher = (Assignment)ele01000Alternatives().eContents().get(1)); 
		}

		// Erwachsener
		public RuleCall ele0100010ParserRuleCallErwachsener() {
			return (c0100010ParserRuleCallErwachsener != null) ? c0100010ParserRuleCallErwachsener : (c0100010ParserRuleCallErwachsener = (RuleCall)ele010001AssignmentErzieher().eContents().get(0)); 
		}

		// spielzeuge += Spielzeug
		public Assignment ele01001AssignmentSpielzeuge() {
			return (c01001AssignmentSpielzeuge != null) ? c01001AssignmentSpielzeuge : (c01001AssignmentSpielzeuge = (Assignment)ele0100Alternatives().eContents().get(1)); 
		}

		// Spielzeug
		public RuleCall ele010010ParserRuleCallSpielzeug() {
			return (c010010ParserRuleCallSpielzeug != null) ? c010010ParserRuleCallSpielzeug : (c010010ParserRuleCallSpielzeug = (RuleCall)ele01001AssignmentSpielzeuge().eContents().get(0)); 
		}

		// familie += Familie
		public Assignment ele0101AssignmentFamilie() {
			return (c0101AssignmentFamilie != null) ? c0101AssignmentFamilie : (c0101AssignmentFamilie = (Assignment)ele010Alternatives().eContents().get(1)); 
		}

		// Familie
		public RuleCall ele01010ParserRuleCallFamilie() {
			return (c01010ParserRuleCallFamilie != null) ? c01010ParserRuleCallFamilie : (c01010ParserRuleCallFamilie = (RuleCall)ele0101AssignmentFamilie().eContents().get(0)); 
		}

		// types += CustomTypeParserRule
		public Assignment ele011AssignmentTypes() {
			return (c011AssignmentTypes != null) ? c011AssignmentTypes : (c011AssignmentTypes = (Assignment)ele01Alternatives().eContents().get(1)); 
		}

		// CustomTypeParserRule
		public RuleCall ele0110ParserRuleCallCustomTypeParserRule() {
			return (c0110ParserRuleCallCustomTypeParserRule != null) ? c0110ParserRuleCallCustomTypeParserRule : (c0110ParserRuleCallCustomTypeParserRule = (RuleCall)ele011AssignmentTypes().eContents().get(0)); 
		}

		// '}'
		public Keyword ele1Keyword() {
			return (c1Keyword != null) ? c1Keyword : (c1Keyword = (Keyword)eleGroup().eContents().get(1)); 
		}
	}

	public class PersonElements implements IParserRuleAccess {
		private ParserRule rule;
		private Alternatives cAlternatives;
		private RuleCall c0ParserRuleCallKind;
		private RuleCall c1ParserRuleCallErwachsener;
		
		// Person : Kind | Erwachsener ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(3)); 
		}

		// Kind | Erwachsener
		public Alternatives eleAlternatives() {
			return (cAlternatives != null) ? cAlternatives : (cAlternatives = (Alternatives)getRule().eContents().get(0)); 
		}

		// Kind
		public RuleCall ele0ParserRuleCallKind() {
			return (c0ParserRuleCallKind != null) ? c0ParserRuleCallKind : (c0ParserRuleCallKind = (RuleCall)eleAlternatives().eContents().get(0)); 
		}

		// Erwachsener
		public RuleCall ele1ParserRuleCallErwachsener() {
			return (c1ParserRuleCallErwachsener != null) ? c1ParserRuleCallErwachsener : (c1ParserRuleCallErwachsener = (RuleCall)eleAlternatives().eContents().get(1)); 
		}
	}

	public class KindElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Group c000Group;
		private Keyword c0000KeywordKind;
		private Keyword c0001Keyword;
		private Assignment c001AssignmentName;
		private RuleCall c0010LexerRuleCallID;
		private Assignment c01AssignmentAge;
		private RuleCall c010LexerRuleCallINT;
		private Keyword c1Keyword;
		
		// Kind : 'kind' '(' name = ID age = INT ')' ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(4)); 
		}

		// 'kind' '(' name = ID age = INT ')'
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// 'kind' '(' name = ID age = INT
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'kind' '(' name = ID
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// 'kind' '('
		public Group ele000Group() {
			return (c000Group != null) ? c000Group : (c000Group = (Group)ele00Group().eContents().get(0)); 
		}

		// 'kind'
		public Keyword ele0000KeywordKind() {
			return (c0000KeywordKind != null) ? c0000KeywordKind : (c0000KeywordKind = (Keyword)ele000Group().eContents().get(0)); 
		}

		// '('
		public Keyword ele0001Keyword() {
			return (c0001Keyword != null) ? c0001Keyword : (c0001Keyword = (Keyword)ele000Group().eContents().get(1)); 
		}

		// name = ID
		public Assignment ele001AssignmentName() {
			return (c001AssignmentName != null) ? c001AssignmentName : (c001AssignmentName = (Assignment)ele00Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele0010LexerRuleCallID() {
			return (c0010LexerRuleCallID != null) ? c0010LexerRuleCallID : (c0010LexerRuleCallID = (RuleCall)ele001AssignmentName().eContents().get(0)); 
		}

		// age = INT
		public Assignment ele01AssignmentAge() {
			return (c01AssignmentAge != null) ? c01AssignmentAge : (c01AssignmentAge = (Assignment)ele0Group().eContents().get(1)); 
		}

		// INT
		public RuleCall ele010LexerRuleCallINT() {
			return (c010LexerRuleCallINT != null) ? c010LexerRuleCallINT : (c010LexerRuleCallINT = (RuleCall)ele01AssignmentAge().eContents().get(0)); 
		}

		// ')'
		public Keyword ele1Keyword() {
			return (c1Keyword != null) ? c1Keyword : (c1Keyword = (Keyword)eleGroup().eContents().get(1)); 
		}
	}

	public class ErwachsenerElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Group c000Group;
		private Keyword c0000KeywordErwachsener;
		private Keyword c0001Keyword;
		private Assignment c001AssignmentName;
		private RuleCall c0010LexerRuleCallID;
		private Assignment c01AssignmentAge;
		private RuleCall c010LexerRuleCallINT;
		private Keyword c1Keyword;
		
		// Erwachsener : 'erwachsener' '(' name = ID age = INT ')' ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(5)); 
		}

		// 'erwachsener' '(' name = ID age = INT ')'
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// 'erwachsener' '(' name = ID age = INT
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'erwachsener' '(' name = ID
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// 'erwachsener' '('
		public Group ele000Group() {
			return (c000Group != null) ? c000Group : (c000Group = (Group)ele00Group().eContents().get(0)); 
		}

		// 'erwachsener'
		public Keyword ele0000KeywordErwachsener() {
			return (c0000KeywordErwachsener != null) ? c0000KeywordErwachsener : (c0000KeywordErwachsener = (Keyword)ele000Group().eContents().get(0)); 
		}

		// '('
		public Keyword ele0001Keyword() {
			return (c0001Keyword != null) ? c0001Keyword : (c0001Keyword = (Keyword)ele000Group().eContents().get(1)); 
		}

		// name = ID
		public Assignment ele001AssignmentName() {
			return (c001AssignmentName != null) ? c001AssignmentName : (c001AssignmentName = (Assignment)ele00Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele0010LexerRuleCallID() {
			return (c0010LexerRuleCallID != null) ? c0010LexerRuleCallID : (c0010LexerRuleCallID = (RuleCall)ele001AssignmentName().eContents().get(0)); 
		}

		// age = INT
		public Assignment ele01AssignmentAge() {
			return (c01AssignmentAge != null) ? c01AssignmentAge : (c01AssignmentAge = (Assignment)ele0Group().eContents().get(1)); 
		}

		// INT
		public RuleCall ele010LexerRuleCallINT() {
			return (c010LexerRuleCallINT != null) ? c010LexerRuleCallINT : (c010LexerRuleCallINT = (RuleCall)ele01AssignmentAge().eContents().get(0)); 
		}

		// ')'
		public Keyword ele1Keyword() {
			return (c1Keyword != null) ? c1Keyword : (c1Keyword = (Keyword)eleGroup().eContents().get(1)); 
		}
	}

	public class SpielzeugElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Group c000Group;
		private Keyword c0000KeywordSpielzeug;
		private Keyword c0001Keyword;
		private Assignment c001AssignmentName;
		private RuleCall c0010LexerRuleCallID;
		private Assignment c01AssignmentFarbe;
		private RuleCall c010ParserRuleCallFarbe;
		private Keyword c1Keyword;
		
		// Spielzeug : 'spielzeug' '(' name = ID farbe = Farbe ')' ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(6)); 
		}

		// 'spielzeug' '(' name = ID farbe = Farbe ')'
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// 'spielzeug' '(' name = ID farbe = Farbe
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'spielzeug' '(' name = ID
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// 'spielzeug' '('
		public Group ele000Group() {
			return (c000Group != null) ? c000Group : (c000Group = (Group)ele00Group().eContents().get(0)); 
		}

		// 'spielzeug'
		public Keyword ele0000KeywordSpielzeug() {
			return (c0000KeywordSpielzeug != null) ? c0000KeywordSpielzeug : (c0000KeywordSpielzeug = (Keyword)ele000Group().eContents().get(0)); 
		}

		// '('
		public Keyword ele0001Keyword() {
			return (c0001Keyword != null) ? c0001Keyword : (c0001Keyword = (Keyword)ele000Group().eContents().get(1)); 
		}

		// name = ID
		public Assignment ele001AssignmentName() {
			return (c001AssignmentName != null) ? c001AssignmentName : (c001AssignmentName = (Assignment)ele00Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele0010LexerRuleCallID() {
			return (c0010LexerRuleCallID != null) ? c0010LexerRuleCallID : (c0010LexerRuleCallID = (RuleCall)ele001AssignmentName().eContents().get(0)); 
		}

		// farbe = Farbe
		public Assignment ele01AssignmentFarbe() {
			return (c01AssignmentFarbe != null) ? c01AssignmentFarbe : (c01AssignmentFarbe = (Assignment)ele0Group().eContents().get(1)); 
		}

		// Farbe
		public RuleCall ele010ParserRuleCallFarbe() {
			return (c010ParserRuleCallFarbe != null) ? c010ParserRuleCallFarbe : (c010ParserRuleCallFarbe = (RuleCall)ele01AssignmentFarbe().eContents().get(0)); 
		}

		// ')'
		public Keyword ele1Keyword() {
			return (c1Keyword != null) ? c1Keyword : (c1Keyword = (Keyword)eleGroup().eContents().get(1)); 
		}
	}

	public class FamilieElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Group c000Group;
		private Group c0000Group;
		private Group c00000Group;
		private Group c000000Group;
		private Keyword c0000000KeywordFamilie;
		private Keyword c0000001Keyword;
		private Assignment c000001AssignmentName;
		private Alternatives c0000010Alternatives;
		private Alternatives c00000100Alternatives;
		private Keyword c000001000KeywordKeyword;
		private RuleCall c000001001LexerRuleCallSTRING;
		private RuleCall c00000101LexerRuleCallID;
		private Assignment c00001AssignmentMutter;
		private CrossReference c000010CrossReferenceErwachsener;
		private Assignment c0001AssignmentVater;
		private CrossReference c00010CrossReferenceErwachsener;
		private Assignment c001AssignmentKinder;
		private CrossReference c0010CrossReferenceKind;
		private Group c01Group;
		private Keyword c010Keyword;
		private Assignment c011AssignmentKinder;
		private CrossReference c0110CrossReferenceKind;
		private Keyword c1Keyword;
		
		// (error)
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(7)); 
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

		// (error)
		public Group ele000Group() {
			return (c000Group != null) ? c000Group : (c000Group = (Group)ele00Group().eContents().get(0)); 
		}

		// (error)
		public Group ele0000Group() {
			return (c0000Group != null) ? c0000Group : (c0000Group = (Group)ele000Group().eContents().get(0)); 
		}

		// 'familie' '(' name = ( 'keyword' | STRING | ID )
		public Group ele00000Group() {
			return (c00000Group != null) ? c00000Group : (c00000Group = (Group)ele0000Group().eContents().get(0)); 
		}

		// 'familie' '('
		public Group ele000000Group() {
			return (c000000Group != null) ? c000000Group : (c000000Group = (Group)ele00000Group().eContents().get(0)); 
		}

		// 'familie'
		public Keyword ele0000000KeywordFamilie() {
			return (c0000000KeywordFamilie != null) ? c0000000KeywordFamilie : (c0000000KeywordFamilie = (Keyword)ele000000Group().eContents().get(0)); 
		}

		// '('
		public Keyword ele0000001Keyword() {
			return (c0000001Keyword != null) ? c0000001Keyword : (c0000001Keyword = (Keyword)ele000000Group().eContents().get(1)); 
		}

		// name = ( 'keyword' | STRING | ID )
		public Assignment ele000001AssignmentName() {
			return (c000001AssignmentName != null) ? c000001AssignmentName : (c000001AssignmentName = (Assignment)ele00000Group().eContents().get(1)); 
		}

		// 'keyword' | STRING | ID
		public Alternatives ele0000010Alternatives() {
			return (c0000010Alternatives != null) ? c0000010Alternatives : (c0000010Alternatives = (Alternatives)ele000001AssignmentName().eContents().get(0)); 
		}

		// 'keyword' | STRING
		public Alternatives ele00000100Alternatives() {
			return (c00000100Alternatives != null) ? c00000100Alternatives : (c00000100Alternatives = (Alternatives)ele0000010Alternatives().eContents().get(0)); 
		}

		// 'keyword'
		public Keyword ele000001000KeywordKeyword() {
			return (c000001000KeywordKeyword != null) ? c000001000KeywordKeyword : (c000001000KeywordKeyword = (Keyword)ele00000100Alternatives().eContents().get(0)); 
		}

		// STRING
		public RuleCall ele000001001LexerRuleCallSTRING() {
			return (c000001001LexerRuleCallSTRING != null) ? c000001001LexerRuleCallSTRING : (c000001001LexerRuleCallSTRING = (RuleCall)ele00000100Alternatives().eContents().get(1)); 
		}

		// ID
		public RuleCall ele00000101LexerRuleCallID() {
			return (c00000101LexerRuleCallID != null) ? c00000101LexerRuleCallID : (c00000101LexerRuleCallID = (RuleCall)ele0000010Alternatives().eContents().get(1)); 
		}

		// (error)
		public Assignment ele00001AssignmentMutter() {
			return (c00001AssignmentMutter != null) ? c00001AssignmentMutter : (c00001AssignmentMutter = (Assignment)ele0000Group().eContents().get(1)); 
		}

		// (error)
		public CrossReference ele000010CrossReferenceErwachsener() {
			return (c000010CrossReferenceErwachsener != null) ? c000010CrossReferenceErwachsener : (c000010CrossReferenceErwachsener = (CrossReference)ele00001AssignmentMutter().eContents().get(0)); 
		}

		// (error)
		public Assignment ele0001AssignmentVater() {
			return (c0001AssignmentVater != null) ? c0001AssignmentVater : (c0001AssignmentVater = (Assignment)ele000Group().eContents().get(1)); 
		}

		// (error)
		public CrossReference ele00010CrossReferenceErwachsener() {
			return (c00010CrossReferenceErwachsener != null) ? c00010CrossReferenceErwachsener : (c00010CrossReferenceErwachsener = (CrossReference)ele0001AssignmentVater().eContents().get(0)); 
		}

		// (error)
		public Assignment ele001AssignmentKinder() {
			return (c001AssignmentKinder != null) ? c001AssignmentKinder : (c001AssignmentKinder = (Assignment)ele00Group().eContents().get(1)); 
		}

		// (error)
		public CrossReference ele0010CrossReferenceKind() {
			return (c0010CrossReferenceKind != null) ? c0010CrossReferenceKind : (c0010CrossReferenceKind = (CrossReference)ele001AssignmentKinder().eContents().get(0)); 
		}

		// (error)
		public Group ele01Group() {
			return (c01Group != null) ? c01Group : (c01Group = (Group)ele0Group().eContents().get(1)); 
		}

		// ','
		public Keyword ele010Keyword() {
			return (c010Keyword != null) ? c010Keyword : (c010Keyword = (Keyword)ele01Group().eContents().get(0)); 
		}

		// (error)
		public Assignment ele011AssignmentKinder() {
			return (c011AssignmentKinder != null) ? c011AssignmentKinder : (c011AssignmentKinder = (Assignment)ele01Group().eContents().get(1)); 
		}

		// (error)
		public CrossReference ele0110CrossReferenceKind() {
			return (c0110CrossReferenceKind != null) ? c0110CrossReferenceKind : (c0110CrossReferenceKind = (CrossReference)ele011AssignmentKinder().eContents().get(0)); 
		}

		// ')'
		public Keyword ele1Keyword() {
			return (c1Keyword != null) ? c1Keyword : (c1Keyword = (Keyword)eleGroup().eContents().get(1)); 
		}
	}

	public class FarbeElements implements IParserRuleAccess {
		private ParserRule rule;
		private Assignment cAssignmentWert;
		private Alternatives c0Alternatives;
		private Alternatives c00Alternatives;
		private Alternatives c000Alternatives;
		private Keyword c0000KeywordROT;
		private Keyword c0001KeywordBLAU;
		private Keyword c001KeywordGELB;
		private Keyword c01KeywordGRÜN;
		
		// Farbe : wert = ( 'ROT' | 'BLAU' | 'GELB' | 'GRÜN' ) ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(8)); 
		}

		// wert = ( 'ROT' | 'BLAU' | 'GELB' | 'GRÜN' )
		public Assignment eleAssignmentWert() {
			return (cAssignmentWert != null) ? cAssignmentWert : (cAssignmentWert = (Assignment)getRule().eContents().get(0)); 
		}

		// 'ROT' | 'BLAU' | 'GELB' | 'GRÜN'
		public Alternatives ele0Alternatives() {
			return (c0Alternatives != null) ? c0Alternatives : (c0Alternatives = (Alternatives)eleAssignmentWert().eContents().get(0)); 
		}

		// 'ROT' | 'BLAU' | 'GELB'
		public Alternatives ele00Alternatives() {
			return (c00Alternatives != null) ? c00Alternatives : (c00Alternatives = (Alternatives)ele0Alternatives().eContents().get(0)); 
		}

		// 'ROT' | 'BLAU'
		public Alternatives ele000Alternatives() {
			return (c000Alternatives != null) ? c000Alternatives : (c000Alternatives = (Alternatives)ele00Alternatives().eContents().get(0)); 
		}

		// 'ROT'
		public Keyword ele0000KeywordROT() {
			return (c0000KeywordROT != null) ? c0000KeywordROT : (c0000KeywordROT = (Keyword)ele000Alternatives().eContents().get(0)); 
		}

		// 'BLAU'
		public Keyword ele0001KeywordBLAU() {
			return (c0001KeywordBLAU != null) ? c0001KeywordBLAU : (c0001KeywordBLAU = (Keyword)ele000Alternatives().eContents().get(1)); 
		}

		// 'GELB'
		public Keyword ele001KeywordGELB() {
			return (c001KeywordGELB != null) ? c001KeywordGELB : (c001KeywordGELB = (Keyword)ele00Alternatives().eContents().get(1)); 
		}

		// 'GRÜN'
		public Keyword ele01KeywordGRÜN() {
			return (c01KeywordGRÜN != null) ? c01KeywordGRÜN : (c01KeywordGRÜN = (Keyword)ele0Alternatives().eContents().get(1)); 
		}
	}

	public class CustomTypeParserRuleElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Keyword c0KeywordType;
		private Assignment c1AssignmentName;
		private RuleCall c10LexerRuleCallID;
		
		// CustomTypeParserRule returns ReferenceModel :: CustomType : 'type' name = ID ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(9)); 
		}

		// 'type' name = ID
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(1)); 
		}

		// 'type'
		public Keyword ele0KeywordType() {
			return (c0KeywordType != null) ? c0KeywordType : (c0KeywordType = (Keyword)eleGroup().eContents().get(0)); 
		}

		// name = ID
		public Assignment ele1AssignmentName() {
			return (c1AssignmentName != null) ? c1AssignmentName : (c1AssignmentName = (Assignment)eleGroup().eContents().get(1)); 
		}

		// ID
		public RuleCall ele10LexerRuleCallID() {
			return (c10LexerRuleCallID != null) ? c10LexerRuleCallID : (c10LexerRuleCallID = (RuleCall)ele1AssignmentName().eContents().get(0)); 
		}
	}
	
	public final static ReferenceGrammarGrammarAccess INSTANCE = new ReferenceGrammarGrammarAccess();

	private static final String REFERENCEGRAMMAR_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/reference/ReferenceGrammar.xmi";
	private static Grammar GRAMMAR = null;
	private static SpielplatzElements pSpielplatz;
	private static PersonElements pPerson;
	private static KindElements pKind;
	private static ErwachsenerElements pErwachsener;
	private static SpielzeugElements pSpielzeug;
	private static FamilieElements pFamilie;
	private static FarbeElements pFarbe;
	private static CustomTypeParserRuleElements pCustomTypeParserRule;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(ReferenceGrammarGrammarAccess.class.getClassLoader(),REFERENCEGRAMMAR_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;		
	}

	
	// Spielplatz : ( 'spielplatz' groesse = INT ( beschreibung = STRING ) ? '{' ( kinder += Kind | erzieher += Erwachsener | spielzeuge += Spielzeug | familie += Familie | types += CustomTypeParserRule ) * '}' ) ? ;
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

	// (error)
	public FamilieElements prFamilie() {
		return (pFamilie != null) ? pFamilie : (pFamilie = new FamilieElements());
	} 

	// Farbe : wert = ( 'ROT' | 'BLAU' | 'GELB' | 'GRÜN' ) ;
	public FarbeElements prFarbe() {
		return (pFarbe != null) ? pFarbe : (pFarbe = new FarbeElements());
	} 

	// CustomTypeParserRule returns ReferenceModel :: CustomType : 'type' name = ID ;
	public CustomTypeParserRuleElements prCustomTypeParserRule() {
		return (pCustomTypeParserRule != null) ? pCustomTypeParserRule : (pCustomTypeParserRule = new CustomTypeParserRuleElements());
	} 
}
