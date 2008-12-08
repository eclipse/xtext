/*
Generated with Xtext
*/

package org.eclipse.xtext.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class XtextGrammarTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class GrammarElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Group c000Group;
		private Group c0000Group;
		private Alternatives c00000Alternatives;
		private Assignment c000000AssignmentAbstract;
		private Keyword c0000000KeywordAbstractLanguage;
		private Keyword c000001KeywordLanguage;
		private Assignment c00001AssignmentIdElements;
		private RuleCall c000010LexerRuleCallID;
		private Group c0001Group;
		private Keyword c00010Keyword;
		private Assignment c00011AssignmentIdElements;
		private RuleCall c000110LexerRuleCallID;
		private Group c001Group;
		private Group c0010Group;
		private Keyword c00100KeywordExtends;
		private Assignment c00101AssignmentSuperGrammarIdElements;
		private RuleCall c001010LexerRuleCallID;
		private Group c0011Group;
		private Keyword c00110Keyword;
		private Assignment c00111AssignmentSuperGrammarIdElements;
		private RuleCall c001110LexerRuleCallID;
		private Assignment c01AssignmentMetamodelDeclarations;
		private RuleCall c010ParserRuleCallAbstractMetamodelDeclaration;
		private Assignment c1AssignmentRules;
		private RuleCall c10ParserRuleCallAbstractRule;
		
		// Grammar : ( abstract ?= 'abstract language' | 'language' ) idElements += ID ( '.' idElements += ID ) * ( 'extends' superGrammarIdElements += ID ( '.' superGrammarIdElements += ID ) * ) ? ( metamodelDeclarations += AbstractMetamodelDeclaration ) * ( rules += AbstractRule ) + ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(1)); 
		}

		// ( abstract ?= 'abstract language' | 'language' ) idElements += ID ( '.' idElements += ID ) * ( 'extends' superGrammarIdElements += ID ( '.' superGrammarIdElements += ID ) * ) ? ( metamodelDeclarations += AbstractMetamodelDeclaration ) * ( rules += AbstractRule ) +
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// ( abstract ?= 'abstract language' | 'language' ) idElements += ID ( '.' idElements += ID ) * ( 'extends' superGrammarIdElements += ID ( '.' superGrammarIdElements += ID ) * ) ? ( metamodelDeclarations += AbstractMetamodelDeclaration ) *
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// ( abstract ?= 'abstract language' | 'language' ) idElements += ID ( '.' idElements += ID ) * ( 'extends' superGrammarIdElements += ID ( '.' superGrammarIdElements += ID ) * ) ?
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// ( abstract ?= 'abstract language' | 'language' ) idElements += ID ( '.' idElements += ID ) *
		public Group ele000Group() {
			return (c000Group != null) ? c000Group : (c000Group = (Group)ele00Group().eContents().get(0)); 
		}

		// ( abstract ?= 'abstract language' | 'language' ) idElements += ID
		public Group ele0000Group() {
			return (c0000Group != null) ? c0000Group : (c0000Group = (Group)ele000Group().eContents().get(0)); 
		}

		// abstract ?= 'abstract language' | 'language'
		public Alternatives ele00000Alternatives() {
			return (c00000Alternatives != null) ? c00000Alternatives : (c00000Alternatives = (Alternatives)ele0000Group().eContents().get(0)); 
		}

		// abstract ?= 'abstract language'
		public Assignment ele000000AssignmentAbstract() {
			return (c000000AssignmentAbstract != null) ? c000000AssignmentAbstract : (c000000AssignmentAbstract = (Assignment)ele00000Alternatives().eContents().get(0)); 
		}

		// 'abstract language'
		public Keyword ele0000000KeywordAbstractLanguage() {
			return (c0000000KeywordAbstractLanguage != null) ? c0000000KeywordAbstractLanguage : (c0000000KeywordAbstractLanguage = (Keyword)ele000000AssignmentAbstract().eContents().get(0)); 
		}

		// 'language'
		public Keyword ele000001KeywordLanguage() {
			return (c000001KeywordLanguage != null) ? c000001KeywordLanguage : (c000001KeywordLanguage = (Keyword)ele00000Alternatives().eContents().get(1)); 
		}

		// idElements += ID
		public Assignment ele00001AssignmentIdElements() {
			return (c00001AssignmentIdElements != null) ? c00001AssignmentIdElements : (c00001AssignmentIdElements = (Assignment)ele0000Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele000010LexerRuleCallID() {
			return (c000010LexerRuleCallID != null) ? c000010LexerRuleCallID : (c000010LexerRuleCallID = (RuleCall)ele00001AssignmentIdElements().eContents().get(0)); 
		}

		// ( '.' idElements += ID ) *
		public Group ele0001Group() {
			return (c0001Group != null) ? c0001Group : (c0001Group = (Group)ele000Group().eContents().get(1)); 
		}

		// '.'
		public Keyword ele00010Keyword() {
			return (c00010Keyword != null) ? c00010Keyword : (c00010Keyword = (Keyword)ele0001Group().eContents().get(0)); 
		}

		// idElements += ID
		public Assignment ele00011AssignmentIdElements() {
			return (c00011AssignmentIdElements != null) ? c00011AssignmentIdElements : (c00011AssignmentIdElements = (Assignment)ele0001Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele000110LexerRuleCallID() {
			return (c000110LexerRuleCallID != null) ? c000110LexerRuleCallID : (c000110LexerRuleCallID = (RuleCall)ele00011AssignmentIdElements().eContents().get(0)); 
		}

		// ( 'extends' superGrammarIdElements += ID ( '.' superGrammarIdElements += ID ) * ) ?
		public Group ele001Group() {
			return (c001Group != null) ? c001Group : (c001Group = (Group)ele00Group().eContents().get(1)); 
		}

		// 'extends' superGrammarIdElements += ID
		public Group ele0010Group() {
			return (c0010Group != null) ? c0010Group : (c0010Group = (Group)ele001Group().eContents().get(0)); 
		}

		// 'extends'
		public Keyword ele00100KeywordExtends() {
			return (c00100KeywordExtends != null) ? c00100KeywordExtends : (c00100KeywordExtends = (Keyword)ele0010Group().eContents().get(0)); 
		}

		// superGrammarIdElements += ID
		public Assignment ele00101AssignmentSuperGrammarIdElements() {
			return (c00101AssignmentSuperGrammarIdElements != null) ? c00101AssignmentSuperGrammarIdElements : (c00101AssignmentSuperGrammarIdElements = (Assignment)ele0010Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele001010LexerRuleCallID() {
			return (c001010LexerRuleCallID != null) ? c001010LexerRuleCallID : (c001010LexerRuleCallID = (RuleCall)ele00101AssignmentSuperGrammarIdElements().eContents().get(0)); 
		}

		// ( '.' superGrammarIdElements += ID ) *
		public Group ele0011Group() {
			return (c0011Group != null) ? c0011Group : (c0011Group = (Group)ele001Group().eContents().get(1)); 
		}

		// '.'
		public Keyword ele00110Keyword() {
			return (c00110Keyword != null) ? c00110Keyword : (c00110Keyword = (Keyword)ele0011Group().eContents().get(0)); 
		}

		// superGrammarIdElements += ID
		public Assignment ele00111AssignmentSuperGrammarIdElements() {
			return (c00111AssignmentSuperGrammarIdElements != null) ? c00111AssignmentSuperGrammarIdElements : (c00111AssignmentSuperGrammarIdElements = (Assignment)ele0011Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele001110LexerRuleCallID() {
			return (c001110LexerRuleCallID != null) ? c001110LexerRuleCallID : (c001110LexerRuleCallID = (RuleCall)ele00111AssignmentSuperGrammarIdElements().eContents().get(0)); 
		}

		// ( metamodelDeclarations += AbstractMetamodelDeclaration ) *
		public Assignment ele01AssignmentMetamodelDeclarations() {
			return (c01AssignmentMetamodelDeclarations != null) ? c01AssignmentMetamodelDeclarations : (c01AssignmentMetamodelDeclarations = (Assignment)ele0Group().eContents().get(1)); 
		}

		// AbstractMetamodelDeclaration
		public RuleCall ele010ParserRuleCallAbstractMetamodelDeclaration() {
			return (c010ParserRuleCallAbstractMetamodelDeclaration != null) ? c010ParserRuleCallAbstractMetamodelDeclaration : (c010ParserRuleCallAbstractMetamodelDeclaration = (RuleCall)ele01AssignmentMetamodelDeclarations().eContents().get(0)); 
		}

		// ( rules += AbstractRule ) +
		public Assignment ele1AssignmentRules() {
			return (c1AssignmentRules != null) ? c1AssignmentRules : (c1AssignmentRules = (Assignment)eleGroup().eContents().get(1)); 
		}

		// AbstractRule
		public RuleCall ele10ParserRuleCallAbstractRule() {
			return (c10ParserRuleCallAbstractRule != null) ? c10ParserRuleCallAbstractRule : (c10ParserRuleCallAbstractRule = (RuleCall)ele1AssignmentRules().eContents().get(0)); 
		}
	}

	public class AbstractRuleElements implements IParserRuleAccess {
		private ParserRule rule;
		private Alternatives cAlternatives;
		private RuleCall c0ParserRuleCallLexerRule;
		private RuleCall c1ParserRuleCallParserRule;
		
		// AbstractRule : LexerRule | ParserRule ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(2)); 
		}

		// LexerRule | ParserRule
		public Alternatives eleAlternatives() {
			return (cAlternatives != null) ? cAlternatives : (cAlternatives = (Alternatives)getRule().eContents().get(0)); 
		}

		// LexerRule
		public RuleCall ele0ParserRuleCallLexerRule() {
			return (c0ParserRuleCallLexerRule != null) ? c0ParserRuleCallLexerRule : (c0ParserRuleCallLexerRule = (RuleCall)eleAlternatives().eContents().get(0)); 
		}

		// ParserRule
		public RuleCall ele1ParserRuleCallParserRule() {
			return (c1ParserRuleCallParserRule != null) ? c1ParserRuleCallParserRule : (c1ParserRuleCallParserRule = (RuleCall)eleAlternatives().eContents().get(1)); 
		}
	}

	public class AbstractMetamodelDeclarationElements implements IParserRuleAccess {
		private ParserRule rule;
		private Alternatives cAlternatives;
		private RuleCall c0ParserRuleCallGeneratedMetamodel;
		private RuleCall c1ParserRuleCallReferencedMetamodel;
		
		// AbstractMetamodelDeclaration : GeneratedMetamodel | ReferencedMetamodel ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(3)); 
		}

		// GeneratedMetamodel | ReferencedMetamodel
		public Alternatives eleAlternatives() {
			return (cAlternatives != null) ? cAlternatives : (cAlternatives = (Alternatives)getRule().eContents().get(0)); 
		}

		// GeneratedMetamodel
		public RuleCall ele0ParserRuleCallGeneratedMetamodel() {
			return (c0ParserRuleCallGeneratedMetamodel != null) ? c0ParserRuleCallGeneratedMetamodel : (c0ParserRuleCallGeneratedMetamodel = (RuleCall)eleAlternatives().eContents().get(0)); 
		}

		// ReferencedMetamodel
		public RuleCall ele1ParserRuleCallReferencedMetamodel() {
			return (c1ParserRuleCallReferencedMetamodel != null) ? c1ParserRuleCallReferencedMetamodel : (c1ParserRuleCallReferencedMetamodel = (RuleCall)eleAlternatives().eContents().get(1)); 
		}
	}

	public class GeneratedMetamodelElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Keyword c000KeywordGenerate;
		private Assignment c001AssignmentName;
		private RuleCall c0010LexerRuleCallID;
		private Assignment c01AssignmentNsURI;
		private RuleCall c010LexerRuleCallSTRING;
		private Group c1Group;
		private Keyword c10KeywordAs;
		private Assignment c11AssignmentAlias;
		private RuleCall c110LexerRuleCallID;
		
		// GeneratedMetamodel : 'generate' name = ID nsURI = STRING ( 'as' alias = ID ) ? ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(4)); 
		}

		// 'generate' name = ID nsURI = STRING ( 'as' alias = ID ) ?
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// 'generate' name = ID nsURI = STRING
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'generate' name = ID
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// 'generate'
		public Keyword ele000KeywordGenerate() {
			return (c000KeywordGenerate != null) ? c000KeywordGenerate : (c000KeywordGenerate = (Keyword)ele00Group().eContents().get(0)); 
		}

		// name = ID
		public Assignment ele001AssignmentName() {
			return (c001AssignmentName != null) ? c001AssignmentName : (c001AssignmentName = (Assignment)ele00Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele0010LexerRuleCallID() {
			return (c0010LexerRuleCallID != null) ? c0010LexerRuleCallID : (c0010LexerRuleCallID = (RuleCall)ele001AssignmentName().eContents().get(0)); 
		}

		// nsURI = STRING
		public Assignment ele01AssignmentNsURI() {
			return (c01AssignmentNsURI != null) ? c01AssignmentNsURI : (c01AssignmentNsURI = (Assignment)ele0Group().eContents().get(1)); 
		}

		// STRING
		public RuleCall ele010LexerRuleCallSTRING() {
			return (c010LexerRuleCallSTRING != null) ? c010LexerRuleCallSTRING : (c010LexerRuleCallSTRING = (RuleCall)ele01AssignmentNsURI().eContents().get(0)); 
		}

		// ( 'as' alias = ID ) ?
		public Group ele1Group() {
			return (c1Group != null) ? c1Group : (c1Group = (Group)eleGroup().eContents().get(1)); 
		}

		// 'as'
		public Keyword ele10KeywordAs() {
			return (c10KeywordAs != null) ? c10KeywordAs : (c10KeywordAs = (Keyword)ele1Group().eContents().get(0)); 
		}

		// alias = ID
		public Assignment ele11AssignmentAlias() {
			return (c11AssignmentAlias != null) ? c11AssignmentAlias : (c11AssignmentAlias = (Assignment)ele1Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele110LexerRuleCallID() {
			return (c110LexerRuleCallID != null) ? c110LexerRuleCallID : (c110LexerRuleCallID = (RuleCall)ele11AssignmentAlias().eContents().get(0)); 
		}
	}

	public class ReferencedMetamodelElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Keyword c00KeywordImport;
		private Assignment c01AssignmentUri;
		private RuleCall c010LexerRuleCallSTRING;
		private Group c1Group;
		private Keyword c10KeywordAs;
		private Assignment c11AssignmentAlias;
		private RuleCall c110LexerRuleCallID;
		
		// ReferencedMetamodel : 'import' uri = STRING ( 'as' alias = ID ) ? ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(5)); 
		}

		// 'import' uri = STRING ( 'as' alias = ID ) ?
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// 'import' uri = STRING
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'import'
		public Keyword ele00KeywordImport() {
			return (c00KeywordImport != null) ? c00KeywordImport : (c00KeywordImport = (Keyword)ele0Group().eContents().get(0)); 
		}

		// uri = STRING
		public Assignment ele01AssignmentUri() {
			return (c01AssignmentUri != null) ? c01AssignmentUri : (c01AssignmentUri = (Assignment)ele0Group().eContents().get(1)); 
		}

		// STRING
		public RuleCall ele010LexerRuleCallSTRING() {
			return (c010LexerRuleCallSTRING != null) ? c010LexerRuleCallSTRING : (c010LexerRuleCallSTRING = (RuleCall)ele01AssignmentUri().eContents().get(0)); 
		}

		// ( 'as' alias = ID ) ?
		public Group ele1Group() {
			return (c1Group != null) ? c1Group : (c1Group = (Group)eleGroup().eContents().get(1)); 
		}

		// 'as'
		public Keyword ele10KeywordAs() {
			return (c10KeywordAs != null) ? c10KeywordAs : (c10KeywordAs = (Keyword)ele1Group().eContents().get(0)); 
		}

		// alias = ID
		public Assignment ele11AssignmentAlias() {
			return (c11AssignmentAlias != null) ? c11AssignmentAlias : (c11AssignmentAlias = (Assignment)ele1Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele110LexerRuleCallID() {
			return (c110LexerRuleCallID != null) ? c110LexerRuleCallID : (c110LexerRuleCallID = (RuleCall)ele11AssignmentAlias().eContents().get(0)); 
		}
	}

	public class LexerRuleElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Group c000Group;
		private Group c0000Group;
		private Alternatives c00000Alternatives;
		private Keyword c000000KeywordNative;
		private Keyword c000001KeywordLexer;
		private Assignment c00001AssignmentName;
		private RuleCall c000010LexerRuleCallID;
		private Group c0001Group;
		private Keyword c00010KeywordReturns;
		private Assignment c00011AssignmentType;
		private RuleCall c000110ParserRuleCallTypeRef;
		private Keyword c001Keyword;
		private Assignment c01AssignmentBody;
		private RuleCall c010LexerRuleCallSTRING;
		private Keyword c1Keyword;
		
		// LexerRule : ( 'native' | 'lexer' ) name = ID ( 'returns' type = TypeRef ) ? ':' body = STRING ';' ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(6)); 
		}

		// ( 'native' | 'lexer' ) name = ID ( 'returns' type = TypeRef ) ? ':' body = STRING ';'
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// ( 'native' | 'lexer' ) name = ID ( 'returns' type = TypeRef ) ? ':' body = STRING
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// ( 'native' | 'lexer' ) name = ID ( 'returns' type = TypeRef ) ? ':'
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// ( 'native' | 'lexer' ) name = ID ( 'returns' type = TypeRef ) ?
		public Group ele000Group() {
			return (c000Group != null) ? c000Group : (c000Group = (Group)ele00Group().eContents().get(0)); 
		}

		// ( 'native' | 'lexer' ) name = ID
		public Group ele0000Group() {
			return (c0000Group != null) ? c0000Group : (c0000Group = (Group)ele000Group().eContents().get(0)); 
		}

		// 'native' | 'lexer'
		public Alternatives ele00000Alternatives() {
			return (c00000Alternatives != null) ? c00000Alternatives : (c00000Alternatives = (Alternatives)ele0000Group().eContents().get(0)); 
		}

		// 'native'
		public Keyword ele000000KeywordNative() {
			return (c000000KeywordNative != null) ? c000000KeywordNative : (c000000KeywordNative = (Keyword)ele00000Alternatives().eContents().get(0)); 
		}

		// 'lexer'
		public Keyword ele000001KeywordLexer() {
			return (c000001KeywordLexer != null) ? c000001KeywordLexer : (c000001KeywordLexer = (Keyword)ele00000Alternatives().eContents().get(1)); 
		}

		// name = ID
		public Assignment ele00001AssignmentName() {
			return (c00001AssignmentName != null) ? c00001AssignmentName : (c00001AssignmentName = (Assignment)ele0000Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele000010LexerRuleCallID() {
			return (c000010LexerRuleCallID != null) ? c000010LexerRuleCallID : (c000010LexerRuleCallID = (RuleCall)ele00001AssignmentName().eContents().get(0)); 
		}

		// ( 'returns' type = TypeRef ) ?
		public Group ele0001Group() {
			return (c0001Group != null) ? c0001Group : (c0001Group = (Group)ele000Group().eContents().get(1)); 
		}

		// 'returns'
		public Keyword ele00010KeywordReturns() {
			return (c00010KeywordReturns != null) ? c00010KeywordReturns : (c00010KeywordReturns = (Keyword)ele0001Group().eContents().get(0)); 
		}

		// type = TypeRef
		public Assignment ele00011AssignmentType() {
			return (c00011AssignmentType != null) ? c00011AssignmentType : (c00011AssignmentType = (Assignment)ele0001Group().eContents().get(1)); 
		}

		// TypeRef
		public RuleCall ele000110ParserRuleCallTypeRef() {
			return (c000110ParserRuleCallTypeRef != null) ? c000110ParserRuleCallTypeRef : (c000110ParserRuleCallTypeRef = (RuleCall)ele00011AssignmentType().eContents().get(0)); 
		}

		// ':'
		public Keyword ele001Keyword() {
			return (c001Keyword != null) ? c001Keyword : (c001Keyword = (Keyword)ele00Group().eContents().get(1)); 
		}

		// body = STRING
		public Assignment ele01AssignmentBody() {
			return (c01AssignmentBody != null) ? c01AssignmentBody : (c01AssignmentBody = (Assignment)ele0Group().eContents().get(1)); 
		}

		// STRING
		public RuleCall ele010LexerRuleCallSTRING() {
			return (c010LexerRuleCallSTRING != null) ? c010LexerRuleCallSTRING : (c010LexerRuleCallSTRING = (RuleCall)ele01AssignmentBody().eContents().get(0)); 
		}

		// ';'
		public Keyword ele1Keyword() {
			return (c1Keyword != null) ? c1Keyword : (c1Keyword = (Keyword)eleGroup().eContents().get(1)); 
		}
	}

	public class ParserRuleElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Group c000Group;
		private Assignment c0000AssignmentName;
		private RuleCall c00000LexerRuleCallID;
		private Group c0001Group;
		private Keyword c00010KeywordReturns;
		private Assignment c00011AssignmentType;
		private RuleCall c000110ParserRuleCallTypeRef;
		private Keyword c001Keyword;
		private Assignment c01AssignmentAlternatives;
		private RuleCall c010ParserRuleCallAlternatives;
		private Keyword c1Keyword;
		
		// ParserRule : name = ID ( 'returns' type = TypeRef ) ? ':' alternatives = Alternatives ';' ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(7)); 
		}

		// name = ID ( 'returns' type = TypeRef ) ? ':' alternatives = Alternatives ';'
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// name = ID ( 'returns' type = TypeRef ) ? ':' alternatives = Alternatives
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// name = ID ( 'returns' type = TypeRef ) ? ':'
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// name = ID ( 'returns' type = TypeRef ) ?
		public Group ele000Group() {
			return (c000Group != null) ? c000Group : (c000Group = (Group)ele00Group().eContents().get(0)); 
		}

		// name = ID
		public Assignment ele0000AssignmentName() {
			return (c0000AssignmentName != null) ? c0000AssignmentName : (c0000AssignmentName = (Assignment)ele000Group().eContents().get(0)); 
		}

		// ID
		public RuleCall ele00000LexerRuleCallID() {
			return (c00000LexerRuleCallID != null) ? c00000LexerRuleCallID : (c00000LexerRuleCallID = (RuleCall)ele0000AssignmentName().eContents().get(0)); 
		}

		// ( 'returns' type = TypeRef ) ?
		public Group ele0001Group() {
			return (c0001Group != null) ? c0001Group : (c0001Group = (Group)ele000Group().eContents().get(1)); 
		}

		// 'returns'
		public Keyword ele00010KeywordReturns() {
			return (c00010KeywordReturns != null) ? c00010KeywordReturns : (c00010KeywordReturns = (Keyword)ele0001Group().eContents().get(0)); 
		}

		// type = TypeRef
		public Assignment ele00011AssignmentType() {
			return (c00011AssignmentType != null) ? c00011AssignmentType : (c00011AssignmentType = (Assignment)ele0001Group().eContents().get(1)); 
		}

		// TypeRef
		public RuleCall ele000110ParserRuleCallTypeRef() {
			return (c000110ParserRuleCallTypeRef != null) ? c000110ParserRuleCallTypeRef : (c000110ParserRuleCallTypeRef = (RuleCall)ele00011AssignmentType().eContents().get(0)); 
		}

		// ':'
		public Keyword ele001Keyword() {
			return (c001Keyword != null) ? c001Keyword : (c001Keyword = (Keyword)ele00Group().eContents().get(1)); 
		}

		// alternatives = Alternatives
		public Assignment ele01AssignmentAlternatives() {
			return (c01AssignmentAlternatives != null) ? c01AssignmentAlternatives : (c01AssignmentAlternatives = (Assignment)ele0Group().eContents().get(1)); 
		}

		// Alternatives
		public RuleCall ele010ParserRuleCallAlternatives() {
			return (c010ParserRuleCallAlternatives != null) ? c010ParserRuleCallAlternatives : (c010ParserRuleCallAlternatives = (RuleCall)ele01AssignmentAlternatives().eContents().get(0)); 
		}

		// ';'
		public Keyword ele1Keyword() {
			return (c1Keyword != null) ? c1Keyword : (c1Keyword = (Keyword)eleGroup().eContents().get(1)); 
		}
	}

	public class TypeRefElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Assignment c00AssignmentAlias;
		private RuleCall c000LexerRuleCallID;
		private Keyword c01Keyword;
		private Assignment c1AssignmentName;
		private RuleCall c10LexerRuleCallID;
		
		// TypeRef : ( alias = ID '::' ) ? name = ID ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(8)); 
		}

		// ( alias = ID '::' ) ? name = ID
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// ( alias = ID '::' ) ?
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// alias = ID
		public Assignment ele00AssignmentAlias() {
			return (c00AssignmentAlias != null) ? c00AssignmentAlias : (c00AssignmentAlias = (Assignment)ele0Group().eContents().get(0)); 
		}

		// ID
		public RuleCall ele000LexerRuleCallID() {
			return (c000LexerRuleCallID != null) ? c000LexerRuleCallID : (c000LexerRuleCallID = (RuleCall)ele00AssignmentAlias().eContents().get(0)); 
		}

		// '::'
		public Keyword ele01Keyword() {
			return (c01Keyword != null) ? c01Keyword : (c01Keyword = (Keyword)ele0Group().eContents().get(1)); 
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

	public class AlternativesElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private RuleCall c0ParserRuleCallGroup;
		private Group c1Group;
		private Group c10Group;
		private Action c100ActionAlternativesgroups;
		private Keyword c101Keyword;
		private Assignment c11AssignmentGroups;
		private RuleCall c110ParserRuleCallGroup;
		
		// Alternatives returns AbstractElement : Group ( { current = Alternatives . groups += current } '|' groups += Group ) * ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(9)); 
		}

		// Group ( { current = Alternatives . groups += current } '|' groups += Group ) *
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(1)); 
		}

		// Group
		public RuleCall ele0ParserRuleCallGroup() {
			return (c0ParserRuleCallGroup != null) ? c0ParserRuleCallGroup : (c0ParserRuleCallGroup = (RuleCall)eleGroup().eContents().get(0)); 
		}

		// ( { current = Alternatives . groups += current } '|' groups += Group ) *
		public Group ele1Group() {
			return (c1Group != null) ? c1Group : (c1Group = (Group)eleGroup().eContents().get(1)); 
		}

		// { current = Alternatives . groups += current } '|'
		public Group ele10Group() {
			return (c10Group != null) ? c10Group : (c10Group = (Group)ele1Group().eContents().get(0)); 
		}

		// { current = Alternatives . groups += current }
		public Action ele100ActionAlternativesgroups() {
			return (c100ActionAlternativesgroups != null) ? c100ActionAlternativesgroups : (c100ActionAlternativesgroups = (Action)ele10Group().eContents().get(0)); 
		}

		// '|'
		public Keyword ele101Keyword() {
			return (c101Keyword != null) ? c101Keyword : (c101Keyword = (Keyword)ele10Group().eContents().get(1)); 
		}

		// groups += Group
		public Assignment ele11AssignmentGroups() {
			return (c11AssignmentGroups != null) ? c11AssignmentGroups : (c11AssignmentGroups = (Assignment)ele1Group().eContents().get(1)); 
		}

		// Group
		public RuleCall ele110ParserRuleCallGroup() {
			return (c110ParserRuleCallGroup != null) ? c110ParserRuleCallGroup : (c110ParserRuleCallGroup = (RuleCall)ele11AssignmentGroups().eContents().get(0)); 
		}
	}

	public class GroupElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private RuleCall c0ParserRuleCallAbstractToken;
		private Group c1Group;
		private Action c10ActionGroupabstractTokens;
		private Assignment c11AssignmentAbstractTokens;
		private RuleCall c110ParserRuleCallAbstractToken;
		
		// Group returns AbstractElement : AbstractToken ( { current = Group . abstractTokens += current } abstractTokens += AbstractToken ) * ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(10)); 
		}

		// AbstractToken ( { current = Group . abstractTokens += current } abstractTokens += AbstractToken ) *
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(1)); 
		}

		// AbstractToken
		public RuleCall ele0ParserRuleCallAbstractToken() {
			return (c0ParserRuleCallAbstractToken != null) ? c0ParserRuleCallAbstractToken : (c0ParserRuleCallAbstractToken = (RuleCall)eleGroup().eContents().get(0)); 
		}

		// ( { current = Group . abstractTokens += current } abstractTokens += AbstractToken ) *
		public Group ele1Group() {
			return (c1Group != null) ? c1Group : (c1Group = (Group)eleGroup().eContents().get(1)); 
		}

		// { current = Group . abstractTokens += current }
		public Action ele10ActionGroupabstractTokens() {
			return (c10ActionGroupabstractTokens != null) ? c10ActionGroupabstractTokens : (c10ActionGroupabstractTokens = (Action)ele1Group().eContents().get(0)); 
		}

		// abstractTokens += AbstractToken
		public Assignment ele11AssignmentAbstractTokens() {
			return (c11AssignmentAbstractTokens != null) ? c11AssignmentAbstractTokens : (c11AssignmentAbstractTokens = (Assignment)ele1Group().eContents().get(1)); 
		}

		// AbstractToken
		public RuleCall ele110ParserRuleCallAbstractToken() {
			return (c110ParserRuleCallAbstractToken != null) ? c110ParserRuleCallAbstractToken : (c110ParserRuleCallAbstractToken = (RuleCall)ele11AssignmentAbstractTokens().eContents().get(0)); 
		}
	}

	public class AbstractTokenElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Alternatives c0Alternatives;
		private Alternatives c00Alternatives;
		private RuleCall c000ParserRuleCallAssignment;
		private RuleCall c001ParserRuleCallAction;
		private RuleCall c01ParserRuleCallAbstractTerminal;
		private Assignment c1AssignmentCardinality;
		private Alternatives c10Alternatives;
		private Alternatives c100Alternatives;
		private Keyword c1000Keyword;
		private Keyword c1001Keyword;
		private Keyword c101Keyword;
		
		// AbstractToken returns AbstractElement : ( Assignment | Action | AbstractTerminal ) ( cardinality = ( '?' | '*' | '+' ) ) ? ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(11)); 
		}

		// ( Assignment | Action | AbstractTerminal ) ( cardinality = ( '?' | '*' | '+' ) ) ?
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(1)); 
		}

		// Assignment | Action | AbstractTerminal
		public Alternatives ele0Alternatives() {
			return (c0Alternatives != null) ? c0Alternatives : (c0Alternatives = (Alternatives)eleGroup().eContents().get(0)); 
		}

		// Assignment | Action
		public Alternatives ele00Alternatives() {
			return (c00Alternatives != null) ? c00Alternatives : (c00Alternatives = (Alternatives)ele0Alternatives().eContents().get(0)); 
		}

		// Assignment
		public RuleCall ele000ParserRuleCallAssignment() {
			return (c000ParserRuleCallAssignment != null) ? c000ParserRuleCallAssignment : (c000ParserRuleCallAssignment = (RuleCall)ele00Alternatives().eContents().get(0)); 
		}

		// Action
		public RuleCall ele001ParserRuleCallAction() {
			return (c001ParserRuleCallAction != null) ? c001ParserRuleCallAction : (c001ParserRuleCallAction = (RuleCall)ele00Alternatives().eContents().get(1)); 
		}

		// AbstractTerminal
		public RuleCall ele01ParserRuleCallAbstractTerminal() {
			return (c01ParserRuleCallAbstractTerminal != null) ? c01ParserRuleCallAbstractTerminal : (c01ParserRuleCallAbstractTerminal = (RuleCall)ele0Alternatives().eContents().get(1)); 
		}

		// ( cardinality = ( '?' | '*' | '+' ) ) ?
		public Assignment ele1AssignmentCardinality() {
			return (c1AssignmentCardinality != null) ? c1AssignmentCardinality : (c1AssignmentCardinality = (Assignment)eleGroup().eContents().get(1)); 
		}

		// '?' | '*' | '+'
		public Alternatives ele10Alternatives() {
			return (c10Alternatives != null) ? c10Alternatives : (c10Alternatives = (Alternatives)ele1AssignmentCardinality().eContents().get(0)); 
		}

		// '?' | '*'
		public Alternatives ele100Alternatives() {
			return (c100Alternatives != null) ? c100Alternatives : (c100Alternatives = (Alternatives)ele10Alternatives().eContents().get(0)); 
		}

		// '?'
		public Keyword ele1000Keyword() {
			return (c1000Keyword != null) ? c1000Keyword : (c1000Keyword = (Keyword)ele100Alternatives().eContents().get(0)); 
		}

		// '*'
		public Keyword ele1001Keyword() {
			return (c1001Keyword != null) ? c1001Keyword : (c1001Keyword = (Keyword)ele100Alternatives().eContents().get(1)); 
		}

		// '+'
		public Keyword ele101Keyword() {
			return (c101Keyword != null) ? c101Keyword : (c101Keyword = (Keyword)ele10Alternatives().eContents().get(1)); 
		}
	}

	public class AssignmentElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Assignment c00AssignmentFeature;
		private RuleCall c000LexerRuleCallID;
		private Assignment c01AssignmentOperator;
		private Alternatives c010Alternatives;
		private Alternatives c0100Alternatives;
		private Keyword c01000Keyword;
		private Keyword c01001Keyword;
		private Keyword c0101Keyword;
		private Assignment c1AssignmentTerminal;
		private RuleCall c10ParserRuleCallAbstractTerminal;
		
		// Assignment returns Assignment : feature = ID operator = ( '+=' | '=' | '?=' ) terminal = AbstractTerminal ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(12)); 
		}

		// feature = ID operator = ( '+=' | '=' | '?=' ) terminal = AbstractTerminal
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(1)); 
		}

		// feature = ID operator = ( '+=' | '=' | '?=' )
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// feature = ID
		public Assignment ele00AssignmentFeature() {
			return (c00AssignmentFeature != null) ? c00AssignmentFeature : (c00AssignmentFeature = (Assignment)ele0Group().eContents().get(0)); 
		}

		// ID
		public RuleCall ele000LexerRuleCallID() {
			return (c000LexerRuleCallID != null) ? c000LexerRuleCallID : (c000LexerRuleCallID = (RuleCall)ele00AssignmentFeature().eContents().get(0)); 
		}

		// operator = ( '+=' | '=' | '?=' )
		public Assignment ele01AssignmentOperator() {
			return (c01AssignmentOperator != null) ? c01AssignmentOperator : (c01AssignmentOperator = (Assignment)ele0Group().eContents().get(1)); 
		}

		// '+=' | '=' | '?='
		public Alternatives ele010Alternatives() {
			return (c010Alternatives != null) ? c010Alternatives : (c010Alternatives = (Alternatives)ele01AssignmentOperator().eContents().get(0)); 
		}

		// '+=' | '='
		public Alternatives ele0100Alternatives() {
			return (c0100Alternatives != null) ? c0100Alternatives : (c0100Alternatives = (Alternatives)ele010Alternatives().eContents().get(0)); 
		}

		// '+='
		public Keyword ele01000Keyword() {
			return (c01000Keyword != null) ? c01000Keyword : (c01000Keyword = (Keyword)ele0100Alternatives().eContents().get(0)); 
		}

		// '='
		public Keyword ele01001Keyword() {
			return (c01001Keyword != null) ? c01001Keyword : (c01001Keyword = (Keyword)ele0100Alternatives().eContents().get(1)); 
		}

		// '?='
		public Keyword ele0101Keyword() {
			return (c0101Keyword != null) ? c0101Keyword : (c0101Keyword = (Keyword)ele010Alternatives().eContents().get(1)); 
		}

		// terminal = AbstractTerminal
		public Assignment ele1AssignmentTerminal() {
			return (c1AssignmentTerminal != null) ? c1AssignmentTerminal : (c1AssignmentTerminal = (Assignment)eleGroup().eContents().get(1)); 
		}

		// AbstractTerminal
		public RuleCall ele10ParserRuleCallAbstractTerminal() {
			return (c10ParserRuleCallAbstractTerminal != null) ? c10ParserRuleCallAbstractTerminal : (c10ParserRuleCallAbstractTerminal = (RuleCall)ele1AssignmentTerminal().eContents().get(0)); 
		}
	}

	public class ActionElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Group c000Group;
		private Group c0000Group;
		private Group c00000Group;
		private Group c000000Group;
		private Keyword c0000000Keyword;
		private Group c0000001Group;
		private Keyword c00000010KeywordCurrent;
		private Keyword c00000011Keyword;
		private Assignment c000001AssignmentTypeName;
		private RuleCall c0000010ParserRuleCallTypeRef;
		private Keyword c00001Keyword;
		private Assignment c0001AssignmentFeature;
		private RuleCall c00010LexerRuleCallID;
		private Assignment c001AssignmentOperator;
		private Alternatives c0010Alternatives;
		private Keyword c00100Keyword;
		private Keyword c00101Keyword;
		private Keyword c01KeywordCurrent;
		private Keyword c1Keyword;
		
		// Action returns Action : '{' ( 'current' '=' ) ? typeName = TypeRef '.' feature = ID operator = ( '=' | '+=' ) 'current' '}' ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(13)); 
		}

		// '{' ( 'current' '=' ) ? typeName = TypeRef '.' feature = ID operator = ( '=' | '+=' ) 'current' '}'
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(1)); 
		}

		// '{' ( 'current' '=' ) ? typeName = TypeRef '.' feature = ID operator = ( '=' | '+=' ) 'current'
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// '{' ( 'current' '=' ) ? typeName = TypeRef '.' feature = ID operator = ( '=' | '+=' )
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// '{' ( 'current' '=' ) ? typeName = TypeRef '.' feature = ID
		public Group ele000Group() {
			return (c000Group != null) ? c000Group : (c000Group = (Group)ele00Group().eContents().get(0)); 
		}

		// '{' ( 'current' '=' ) ? typeName = TypeRef '.'
		public Group ele0000Group() {
			return (c0000Group != null) ? c0000Group : (c0000Group = (Group)ele000Group().eContents().get(0)); 
		}

		// '{' ( 'current' '=' ) ? typeName = TypeRef
		public Group ele00000Group() {
			return (c00000Group != null) ? c00000Group : (c00000Group = (Group)ele0000Group().eContents().get(0)); 
		}

		// '{' ( 'current' '=' ) ?
		public Group ele000000Group() {
			return (c000000Group != null) ? c000000Group : (c000000Group = (Group)ele00000Group().eContents().get(0)); 
		}

		// '{'
		public Keyword ele0000000Keyword() {
			return (c0000000Keyword != null) ? c0000000Keyword : (c0000000Keyword = (Keyword)ele000000Group().eContents().get(0)); 
		}

		// ( 'current' '=' ) ?
		public Group ele0000001Group() {
			return (c0000001Group != null) ? c0000001Group : (c0000001Group = (Group)ele000000Group().eContents().get(1)); 
		}

		// 'current'
		public Keyword ele00000010KeywordCurrent() {
			return (c00000010KeywordCurrent != null) ? c00000010KeywordCurrent : (c00000010KeywordCurrent = (Keyword)ele0000001Group().eContents().get(0)); 
		}

		// '='
		public Keyword ele00000011Keyword() {
			return (c00000011Keyword != null) ? c00000011Keyword : (c00000011Keyword = (Keyword)ele0000001Group().eContents().get(1)); 
		}

		// typeName = TypeRef
		public Assignment ele000001AssignmentTypeName() {
			return (c000001AssignmentTypeName != null) ? c000001AssignmentTypeName : (c000001AssignmentTypeName = (Assignment)ele00000Group().eContents().get(1)); 
		}

		// TypeRef
		public RuleCall ele0000010ParserRuleCallTypeRef() {
			return (c0000010ParserRuleCallTypeRef != null) ? c0000010ParserRuleCallTypeRef : (c0000010ParserRuleCallTypeRef = (RuleCall)ele000001AssignmentTypeName().eContents().get(0)); 
		}

		// '.'
		public Keyword ele00001Keyword() {
			return (c00001Keyword != null) ? c00001Keyword : (c00001Keyword = (Keyword)ele0000Group().eContents().get(1)); 
		}

		// feature = ID
		public Assignment ele0001AssignmentFeature() {
			return (c0001AssignmentFeature != null) ? c0001AssignmentFeature : (c0001AssignmentFeature = (Assignment)ele000Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele00010LexerRuleCallID() {
			return (c00010LexerRuleCallID != null) ? c00010LexerRuleCallID : (c00010LexerRuleCallID = (RuleCall)ele0001AssignmentFeature().eContents().get(0)); 
		}

		// operator = ( '=' | '+=' )
		public Assignment ele001AssignmentOperator() {
			return (c001AssignmentOperator != null) ? c001AssignmentOperator : (c001AssignmentOperator = (Assignment)ele00Group().eContents().get(1)); 
		}

		// '=' | '+='
		public Alternatives ele0010Alternatives() {
			return (c0010Alternatives != null) ? c0010Alternatives : (c0010Alternatives = (Alternatives)ele001AssignmentOperator().eContents().get(0)); 
		}

		// '='
		public Keyword ele00100Keyword() {
			return (c00100Keyword != null) ? c00100Keyword : (c00100Keyword = (Keyword)ele0010Alternatives().eContents().get(0)); 
		}

		// '+='
		public Keyword ele00101Keyword() {
			return (c00101Keyword != null) ? c00101Keyword : (c00101Keyword = (Keyword)ele0010Alternatives().eContents().get(1)); 
		}

		// 'current'
		public Keyword ele01KeywordCurrent() {
			return (c01KeywordCurrent != null) ? c01KeywordCurrent : (c01KeywordCurrent = (Keyword)ele0Group().eContents().get(1)); 
		}

		// '}'
		public Keyword ele1Keyword() {
			return (c1Keyword != null) ? c1Keyword : (c1Keyword = (Keyword)eleGroup().eContents().get(1)); 
		}
	}

	public class AbstractTerminalElements implements IParserRuleAccess {
		private ParserRule rule;
		private Alternatives cAlternatives;
		private Alternatives c0Alternatives;
		private Alternatives c00Alternatives;
		private RuleCall c000ParserRuleCallKeyword;
		private RuleCall c001ParserRuleCallRuleCall;
		private RuleCall c01ParserRuleCallParenthesizedElement;
		private RuleCall c1ParserRuleCallCrossReference;
		
		// AbstractTerminal returns AbstractElement : Keyword | RuleCall | ParenthesizedElement | CrossReference ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(14)); 
		}

		// Keyword | RuleCall | ParenthesizedElement | CrossReference
		public Alternatives eleAlternatives() {
			return (cAlternatives != null) ? cAlternatives : (cAlternatives = (Alternatives)getRule().eContents().get(1)); 
		}

		// Keyword | RuleCall | ParenthesizedElement
		public Alternatives ele0Alternatives() {
			return (c0Alternatives != null) ? c0Alternatives : (c0Alternatives = (Alternatives)eleAlternatives().eContents().get(0)); 
		}

		// Keyword | RuleCall
		public Alternatives ele00Alternatives() {
			return (c00Alternatives != null) ? c00Alternatives : (c00Alternatives = (Alternatives)ele0Alternatives().eContents().get(0)); 
		}

		// Keyword
		public RuleCall ele000ParserRuleCallKeyword() {
			return (c000ParserRuleCallKeyword != null) ? c000ParserRuleCallKeyword : (c000ParserRuleCallKeyword = (RuleCall)ele00Alternatives().eContents().get(0)); 
		}

		// RuleCall
		public RuleCall ele001ParserRuleCallRuleCall() {
			return (c001ParserRuleCallRuleCall != null) ? c001ParserRuleCallRuleCall : (c001ParserRuleCallRuleCall = (RuleCall)ele00Alternatives().eContents().get(1)); 
		}

		// ParenthesizedElement
		public RuleCall ele01ParserRuleCallParenthesizedElement() {
			return (c01ParserRuleCallParenthesizedElement != null) ? c01ParserRuleCallParenthesizedElement : (c01ParserRuleCallParenthesizedElement = (RuleCall)ele0Alternatives().eContents().get(1)); 
		}

		// CrossReference
		public RuleCall ele1ParserRuleCallCrossReference() {
			return (c1ParserRuleCallCrossReference != null) ? c1ParserRuleCallCrossReference : (c1ParserRuleCallCrossReference = (RuleCall)eleAlternatives().eContents().get(1)); 
		}
	}

	public class CrossReferenceElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Keyword c000Keyword;
		private Assignment c001AssignmentType;
		private RuleCall c0010ParserRuleCallTypeRef;
		private Group c01Group;
		private Keyword c010Keyword;
		private Assignment c011AssignmentRule;
		private CrossReference c0110CrossReferenceLexerRule;
		private Keyword c1Keyword;
		
		// CrossReference : '[' type = TypeRef ( '|' rule = [ LexerRule ] ) ? ']' ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(15)); 
		}

		// '[' type = TypeRef ( '|' rule = [ LexerRule ] ) ? ']'
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// '[' type = TypeRef ( '|' rule = [ LexerRule ] ) ?
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// '[' type = TypeRef
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// '['
		public Keyword ele000Keyword() {
			return (c000Keyword != null) ? c000Keyword : (c000Keyword = (Keyword)ele00Group().eContents().get(0)); 
		}

		// type = TypeRef
		public Assignment ele001AssignmentType() {
			return (c001AssignmentType != null) ? c001AssignmentType : (c001AssignmentType = (Assignment)ele00Group().eContents().get(1)); 
		}

		// TypeRef
		public RuleCall ele0010ParserRuleCallTypeRef() {
			return (c0010ParserRuleCallTypeRef != null) ? c0010ParserRuleCallTypeRef : (c0010ParserRuleCallTypeRef = (RuleCall)ele001AssignmentType().eContents().get(0)); 
		}

		// ( '|' rule = [ LexerRule ] ) ?
		public Group ele01Group() {
			return (c01Group != null) ? c01Group : (c01Group = (Group)ele0Group().eContents().get(1)); 
		}

		// '|'
		public Keyword ele010Keyword() {
			return (c010Keyword != null) ? c010Keyword : (c010Keyword = (Keyword)ele01Group().eContents().get(0)); 
		}

		// rule = [ LexerRule ]
		public Assignment ele011AssignmentRule() {
			return (c011AssignmentRule != null) ? c011AssignmentRule : (c011AssignmentRule = (Assignment)ele01Group().eContents().get(1)); 
		}

		// [ LexerRule ]
		public CrossReference ele0110CrossReferenceLexerRule() {
			return (c0110CrossReferenceLexerRule != null) ? c0110CrossReferenceLexerRule : (c0110CrossReferenceLexerRule = (CrossReference)ele011AssignmentRule().eContents().get(0)); 
		}

		// ']'
		public Keyword ele1Keyword() {
			return (c1Keyword != null) ? c1Keyword : (c1Keyword = (Keyword)eleGroup().eContents().get(1)); 
		}
	}

	public class ParenthesizedElementElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Keyword c00Keyword;
		private RuleCall c01ParserRuleCallAlternatives;
		private Keyword c1Keyword;
		
		// ParenthesizedElement returns AbstractElement : '(' Alternatives ')' ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(16)); 
		}

		// '(' Alternatives ')'
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(1)); 
		}

		// '(' Alternatives
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// '('
		public Keyword ele00Keyword() {
			return (c00Keyword != null) ? c00Keyword : (c00Keyword = (Keyword)ele0Group().eContents().get(0)); 
		}

		// Alternatives
		public RuleCall ele01ParserRuleCallAlternatives() {
			return (c01ParserRuleCallAlternatives != null) ? c01ParserRuleCallAlternatives : (c01ParserRuleCallAlternatives = (RuleCall)ele0Group().eContents().get(1)); 
		}

		// ')'
		public Keyword ele1Keyword() {
			return (c1Keyword != null) ? c1Keyword : (c1Keyword = (Keyword)eleGroup().eContents().get(1)); 
		}
	}

	public class KeywordElements implements IParserRuleAccess {
		private ParserRule rule;
		private Assignment cAssignmentValue;
		private RuleCall c0LexerRuleCallSTRING;
		
		// Keyword : value = STRING ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(17)); 
		}

		// value = STRING
		public Assignment eleAssignmentValue() {
			return (cAssignmentValue != null) ? cAssignmentValue : (cAssignmentValue = (Assignment)getRule().eContents().get(0)); 
		}

		// STRING
		public RuleCall ele0LexerRuleCallSTRING() {
			return (c0LexerRuleCallSTRING != null) ? c0LexerRuleCallSTRING : (c0LexerRuleCallSTRING = (RuleCall)eleAssignmentValue().eContents().get(0)); 
		}
	}

	public class RuleCallElements implements IParserRuleAccess {
		private ParserRule rule;
		private Assignment cAssignmentRule;
		private CrossReference c0CrossReferenceAbstractRule;
		
		// RuleCall : rule = [ AbstractRule ] ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(18)); 
		}

		// rule = [ AbstractRule ]
		public Assignment eleAssignmentRule() {
			return (cAssignmentRule != null) ? cAssignmentRule : (cAssignmentRule = (Assignment)getRule().eContents().get(0)); 
		}

		// [ AbstractRule ]
		public CrossReference ele0CrossReferenceAbstractRule() {
			return (c0CrossReferenceAbstractRule != null) ? c0CrossReferenceAbstractRule : (c0CrossReferenceAbstractRule = (CrossReference)eleAssignmentRule().eContents().get(0)); 
		}
	}
	
	public final static XtextGrammarTestLanguageGrammarAccess INSTANCE = new XtextGrammarTestLanguageGrammarAccess();

	private static final String XTEXTGRAMMARTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static GrammarElements pGrammar;
	private static AbstractRuleElements pAbstractRule;
	private static AbstractMetamodelDeclarationElements pAbstractMetamodelDeclaration;
	private static GeneratedMetamodelElements pGeneratedMetamodel;
	private static ReferencedMetamodelElements pReferencedMetamodel;
	private static LexerRuleElements pLexerRule;
	private static ParserRuleElements pParserRule;
	private static TypeRefElements pTypeRef;
	private static AlternativesElements pAlternatives;
	private static GroupElements pGroup;
	private static AbstractTokenElements pAbstractToken;
	private static AssignmentElements pAssignment;
	private static ActionElements pAction;
	private static AbstractTerminalElements pAbstractTerminal;
	private static CrossReferenceElements pCrossReference;
	private static ParenthesizedElementElements pParenthesizedElement;
	private static KeywordElements pKeyword;
	private static RuleCallElements pRuleCall;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(XtextGrammarTestLanguageGrammarAccess.class.getClassLoader(),XTEXTGRAMMARTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;		
	}

	
	// Grammar : ( abstract ?= 'abstract language' | 'language' ) idElements += ID ( '.' idElements += ID ) * ( 'extends' superGrammarIdElements += ID ( '.' superGrammarIdElements += ID ) * ) ? ( metamodelDeclarations += AbstractMetamodelDeclaration ) * ( rules += AbstractRule ) + ;
	public GrammarElements prGrammar() {
		return (pGrammar != null) ? pGrammar : (pGrammar = new GrammarElements());
	} 

	// AbstractRule : LexerRule | ParserRule ;
	public AbstractRuleElements prAbstractRule() {
		return (pAbstractRule != null) ? pAbstractRule : (pAbstractRule = new AbstractRuleElements());
	} 

	// AbstractMetamodelDeclaration : GeneratedMetamodel | ReferencedMetamodel ;
	public AbstractMetamodelDeclarationElements prAbstractMetamodelDeclaration() {
		return (pAbstractMetamodelDeclaration != null) ? pAbstractMetamodelDeclaration : (pAbstractMetamodelDeclaration = new AbstractMetamodelDeclarationElements());
	} 

	// GeneratedMetamodel : 'generate' name = ID nsURI = STRING ( 'as' alias = ID ) ? ;
	public GeneratedMetamodelElements prGeneratedMetamodel() {
		return (pGeneratedMetamodel != null) ? pGeneratedMetamodel : (pGeneratedMetamodel = new GeneratedMetamodelElements());
	} 

	// ReferencedMetamodel : 'import' uri = STRING ( 'as' alias = ID ) ? ;
	public ReferencedMetamodelElements prReferencedMetamodel() {
		return (pReferencedMetamodel != null) ? pReferencedMetamodel : (pReferencedMetamodel = new ReferencedMetamodelElements());
	} 

	// LexerRule : ( 'native' | 'lexer' ) name = ID ( 'returns' type = TypeRef ) ? ':' body = STRING ';' ;
	public LexerRuleElements prLexerRule() {
		return (pLexerRule != null) ? pLexerRule : (pLexerRule = new LexerRuleElements());
	} 

	// ParserRule : name = ID ( 'returns' type = TypeRef ) ? ':' alternatives = Alternatives ';' ;
	public ParserRuleElements prParserRule() {
		return (pParserRule != null) ? pParserRule : (pParserRule = new ParserRuleElements());
	} 

	// TypeRef : ( alias = ID '::' ) ? name = ID ;
	public TypeRefElements prTypeRef() {
		return (pTypeRef != null) ? pTypeRef : (pTypeRef = new TypeRefElements());
	} 

	// Alternatives returns AbstractElement : Group ( { current = Alternatives . groups += current } '|' groups += Group ) * ;
	public AlternativesElements prAlternatives() {
		return (pAlternatives != null) ? pAlternatives : (pAlternatives = new AlternativesElements());
	} 

	// Group returns AbstractElement : AbstractToken ( { current = Group . abstractTokens += current } abstractTokens += AbstractToken ) * ;
	public GroupElements prGroup() {
		return (pGroup != null) ? pGroup : (pGroup = new GroupElements());
	} 

	// AbstractToken returns AbstractElement : ( Assignment | Action | AbstractTerminal ) ( cardinality = ( '?' | '*' | '+' ) ) ? ;
	public AbstractTokenElements prAbstractToken() {
		return (pAbstractToken != null) ? pAbstractToken : (pAbstractToken = new AbstractTokenElements());
	} 

	// Assignment returns Assignment : feature = ID operator = ( '+=' | '=' | '?=' ) terminal = AbstractTerminal ;
	public AssignmentElements prAssignment() {
		return (pAssignment != null) ? pAssignment : (pAssignment = new AssignmentElements());
	} 

	// Action returns Action : '{' ( 'current' '=' ) ? typeName = TypeRef '.' feature = ID operator = ( '=' | '+=' ) 'current' '}' ;
	public ActionElements prAction() {
		return (pAction != null) ? pAction : (pAction = new ActionElements());
	} 

	// AbstractTerminal returns AbstractElement : Keyword | RuleCall | ParenthesizedElement | CrossReference ;
	public AbstractTerminalElements prAbstractTerminal() {
		return (pAbstractTerminal != null) ? pAbstractTerminal : (pAbstractTerminal = new AbstractTerminalElements());
	} 

	// CrossReference : '[' type = TypeRef ( '|' rule = [ LexerRule ] ) ? ']' ;
	public CrossReferenceElements prCrossReference() {
		return (pCrossReference != null) ? pCrossReference : (pCrossReference = new CrossReferenceElements());
	} 

	// ParenthesizedElement returns AbstractElement : '(' Alternatives ')' ;
	public ParenthesizedElementElements prParenthesizedElement() {
		return (pParenthesizedElement != null) ? pParenthesizedElement : (pParenthesizedElement = new ParenthesizedElementElements());
	} 

	// Keyword : value = STRING ;
	public KeywordElements prKeyword() {
		return (pKeyword != null) ? pKeyword : (pKeyword = new KeywordElements());
	} 

	// RuleCall : rule = [ AbstractRule ] ;
	public RuleCallElements prRuleCall() {
		return (pRuleCall != null) ? pRuleCall : (pRuleCall = new RuleCallElements());
	} 
}
