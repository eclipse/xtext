/*
Generated with Xtext
*/

package org.eclipse.xtext.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class XtextGrammarTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class GrammarElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(2);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Group c00000Group = (Group)c0000Group.eContents().get(0);
		private final Alternatives c000000Alternatives = (Alternatives)c00000Group.eContents().get(0);
		private final Assignment c0000000AssignmentAbstract = (Assignment)c000000Alternatives.eContents().get(0);
		private final Keyword c00000000KeywordAbstractLanguage = (Keyword)c0000000AssignmentAbstract.eContents().get(0);
		private final Keyword c0000001KeywordLanguage = (Keyword)c000000Alternatives.eContents().get(1);
		private final Assignment c000001AssignmentIdElements = (Assignment)c00000Group.eContents().get(1);
		private final RuleCall c0000010LexerRuleCallID = (RuleCall)c000001AssignmentIdElements.eContents().get(0);
		private final Group c00001Group = (Group)c0000Group.eContents().get(1);
		private final Keyword c000010KeywordFullStop = (Keyword)c00001Group.eContents().get(0);
		private final Assignment c000011AssignmentIdElements = (Assignment)c00001Group.eContents().get(1);
		private final RuleCall c0000110LexerRuleCallID = (RuleCall)c000011AssignmentIdElements.eContents().get(0);
		private final Group c0001Group = (Group)c000Group.eContents().get(1);
		private final Group c00010Group = (Group)c0001Group.eContents().get(0);
		private final Keyword c000100KeywordExtends = (Keyword)c00010Group.eContents().get(0);
		private final Assignment c000101AssignmentSuperGrammarIdElements = (Assignment)c00010Group.eContents().get(1);
		private final RuleCall c0001010LexerRuleCallID = (RuleCall)c000101AssignmentSuperGrammarIdElements.eContents().get(0);
		private final Group c00011Group = (Group)c0001Group.eContents().get(1);
		private final Keyword c000110KeywordFullStop = (Keyword)c00011Group.eContents().get(0);
		private final Assignment c000111AssignmentSuperGrammarIdElements = (Assignment)c00011Group.eContents().get(1);
		private final RuleCall c0001110LexerRuleCallID = (RuleCall)c000111AssignmentSuperGrammarIdElements.eContents().get(0);
		private final Group c001Group = (Group)c00Group.eContents().get(1);
		private final Group c0010Group = (Group)c001Group.eContents().get(0);
		private final Group c00100Group = (Group)c0010Group.eContents().get(0);
		private final Assignment c001000AssignmentDefinesHiddenTokens = (Assignment)c00100Group.eContents().get(0);
		private final Keyword c0010000KeywordHidden = (Keyword)c001000AssignmentDefinesHiddenTokens.eContents().get(0);
		private final Keyword c001001KeywordLeftParenthesis = (Keyword)c00100Group.eContents().get(1);
		private final Group c00101Group = (Group)c0010Group.eContents().get(1);
		private final Assignment c001010AssignmentHiddenTokens = (Assignment)c00101Group.eContents().get(0);
		private final CrossReference c0010100CrossReferenceEStringAbstractRule = (CrossReference)c001010AssignmentHiddenTokens.eContents().get(0);
		private final Group c001011Group = (Group)c00101Group.eContents().get(1);
		private final Keyword c0010110KeywordComma = (Keyword)c001011Group.eContents().get(0);
		private final Assignment c0010111AssignmentHiddenTokens = (Assignment)c001011Group.eContents().get(1);
		private final CrossReference c00101110CrossReferenceEStringAbstractRule = (CrossReference)c0010111AssignmentHiddenTokens.eContents().get(0);
		private final Keyword c0011KeywordRightParenthesis = (Keyword)c001Group.eContents().get(1);
		private final Assignment c01AssignmentMetamodelDeclarations = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010ParserRuleCallAbstractMetamodelDeclaration = (RuleCall)c01AssignmentMetamodelDeclarations.eContents().get(0);
		private final Assignment c1AssignmentRules = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10ParserRuleCallAbstractRule = (RuleCall)c1AssignmentRules.eContents().get(0);
		
		// Grammar:   (abstract?="abstract language"|"language") idElements+=ID ("." idElements+=ID)* ("extends" superGrammarIdElements+=ID ("." superGrammarIdElements+=ID)*)? (definesHiddenTokens?="hidden" "(" (hiddenTokens+=[AbstractRule] ("," hiddenTokens+=[AbstractRule])*)? ")")? (metamodelDeclarations+=AbstractMetamodelDeclaration)* (rules+=AbstractRule)+;
		public ParserRule getRule() { return rule; }

		// (abstract?="abstract language"|"language") idElements+=ID ("." idElements+=ID)* ("extends" superGrammarIdElements+=ID ("." superGrammarIdElements+=ID)*)? (definesHiddenTokens?="hidden" "(" (hiddenTokens+=[AbstractRule] ("," hiddenTokens+=[AbstractRule])*)? ")")? (metamodelDeclarations+=AbstractMetamodelDeclaration)* (rules+=AbstractRule)+
		public Group eleGroup() { return cGroup; }

		// (abstract?="abstract language"|"language") idElements+=ID ("." idElements+=ID)* ("extends" superGrammarIdElements+=ID ("." superGrammarIdElements+=ID)*)? (definesHiddenTokens?="hidden" "(" (hiddenTokens+=[AbstractRule] ("," hiddenTokens+=[AbstractRule])*)? ")")? (metamodelDeclarations+=AbstractMetamodelDeclaration)*
		public Group ele0Group() { return c0Group; }

		// (abstract?="abstract language"|"language") idElements+=ID ("." idElements+=ID)* ("extends" superGrammarIdElements+=ID ("." superGrammarIdElements+=ID)*)? (definesHiddenTokens?="hidden" "(" (hiddenTokens+=[AbstractRule] ("," hiddenTokens+=[AbstractRule])*)? ")")?
		public Group ele00Group() { return c00Group; }

		// (abstract?="abstract language"|"language") idElements+=ID ("." idElements+=ID)* ("extends" superGrammarIdElements+=ID ("." superGrammarIdElements+=ID)*)?
		public Group ele000Group() { return c000Group; }

		// (abstract?="abstract language"|"language") idElements+=ID ("." idElements+=ID)*
		public Group ele0000Group() { return c0000Group; }

		// (abstract?="abstract language"|"language") idElements+=ID
		public Group ele00000Group() { return c00000Group; }

		// abstract?="abstract language"|"language"
		public Alternatives ele000000Alternatives() { return c000000Alternatives; }

		// abstract?="abstract language"
		public Assignment ele0000000AssignmentAbstract() { return c0000000AssignmentAbstract; }

		// "abstract language"
		public Keyword ele00000000KeywordAbstractLanguage() { return c00000000KeywordAbstractLanguage; }

		// "language"
		public Keyword ele0000001KeywordLanguage() { return c0000001KeywordLanguage; }

		// idElements+=ID
		public Assignment ele000001AssignmentIdElements() { return c000001AssignmentIdElements; }

		// ID
		public RuleCall ele0000010LexerRuleCallID() { return c0000010LexerRuleCallID; }

		// ("." idElements+=ID)*
		public Group ele00001Group() { return c00001Group; }

		// "."
		public Keyword ele000010KeywordFullStop() { return c000010KeywordFullStop; }

		// idElements+=ID
		public Assignment ele000011AssignmentIdElements() { return c000011AssignmentIdElements; }

		// ID
		public RuleCall ele0000110LexerRuleCallID() { return c0000110LexerRuleCallID; }

		// ("extends" superGrammarIdElements+=ID ("." superGrammarIdElements+=ID)*)?
		public Group ele0001Group() { return c0001Group; }

		// "extends" superGrammarIdElements+=ID
		public Group ele00010Group() { return c00010Group; }

		// "extends"
		public Keyword ele000100KeywordExtends() { return c000100KeywordExtends; }

		// superGrammarIdElements+=ID
		public Assignment ele000101AssignmentSuperGrammarIdElements() { return c000101AssignmentSuperGrammarIdElements; }

		// ID
		public RuleCall ele0001010LexerRuleCallID() { return c0001010LexerRuleCallID; }

		// ("." superGrammarIdElements+=ID)*
		public Group ele00011Group() { return c00011Group; }

		// "."
		public Keyword ele000110KeywordFullStop() { return c000110KeywordFullStop; }

		// superGrammarIdElements+=ID
		public Assignment ele000111AssignmentSuperGrammarIdElements() { return c000111AssignmentSuperGrammarIdElements; }

		// ID
		public RuleCall ele0001110LexerRuleCallID() { return c0001110LexerRuleCallID; }

		// (definesHiddenTokens?="hidden" "(" (hiddenTokens+=[AbstractRule] ("," hiddenTokens+=[AbstractRule])*)? ")")?
		public Group ele001Group() { return c001Group; }

		// definesHiddenTokens?="hidden" "(" (hiddenTokens+=[AbstractRule] ("," hiddenTokens+=[AbstractRule])*)?
		public Group ele0010Group() { return c0010Group; }

		// definesHiddenTokens?="hidden" "("
		public Group ele00100Group() { return c00100Group; }

		// definesHiddenTokens?="hidden"
		public Assignment ele001000AssignmentDefinesHiddenTokens() { return c001000AssignmentDefinesHiddenTokens; }

		// "hidden"
		public Keyword ele0010000KeywordHidden() { return c0010000KeywordHidden; }

		// "("
		public Keyword ele001001KeywordLeftParenthesis() { return c001001KeywordLeftParenthesis; }

		// (hiddenTokens+=[AbstractRule] ("," hiddenTokens+=[AbstractRule])*)?
		public Group ele00101Group() { return c00101Group; }

		// hiddenTokens+=[AbstractRule]
		public Assignment ele001010AssignmentHiddenTokens() { return c001010AssignmentHiddenTokens; }

		// [AbstractRule]
		public CrossReference ele0010100CrossReferenceEStringAbstractRule() { return c0010100CrossReferenceEStringAbstractRule; }

		// ("," hiddenTokens+=[AbstractRule])*
		public Group ele001011Group() { return c001011Group; }

		// ","
		public Keyword ele0010110KeywordComma() { return c0010110KeywordComma; }

		// hiddenTokens+=[AbstractRule]
		public Assignment ele0010111AssignmentHiddenTokens() { return c0010111AssignmentHiddenTokens; }

		// [AbstractRule]
		public CrossReference ele00101110CrossReferenceEStringAbstractRule() { return c00101110CrossReferenceEStringAbstractRule; }

		// ")"
		public Keyword ele0011KeywordRightParenthesis() { return c0011KeywordRightParenthesis; }

		// (metamodelDeclarations+=AbstractMetamodelDeclaration)*
		public Assignment ele01AssignmentMetamodelDeclarations() { return c01AssignmentMetamodelDeclarations; }

		// AbstractMetamodelDeclaration
		public RuleCall ele010ParserRuleCallAbstractMetamodelDeclaration() { return c010ParserRuleCallAbstractMetamodelDeclaration; }

		// (rules+=AbstractRule)+
		public Assignment ele1AssignmentRules() { return c1AssignmentRules; }

		// AbstractRule
		public RuleCall ele10ParserRuleCallAbstractRule() { return c10ParserRuleCallAbstractRule; }
	}

	public class AbstractRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(3);
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Alternatives c0Alternatives = (Alternatives)cAlternatives.eContents().get(0);
		private final RuleCall c00ParserRuleCallLexerRule = (RuleCall)c0Alternatives.eContents().get(0);
		private final RuleCall c01ParserRuleCallParserRule = (RuleCall)c0Alternatives.eContents().get(1);
		private final RuleCall c1ParserRuleCallTerminalRule = (RuleCall)cAlternatives.eContents().get(1);
		
		// AbstractRule:   LexerRule|ParserRule|TerminalRule;
		public ParserRule getRule() { return rule; }

		// LexerRule|ParserRule|TerminalRule
		public Alternatives eleAlternatives() { return cAlternatives; }

		// LexerRule|ParserRule
		public Alternatives ele0Alternatives() { return c0Alternatives; }

		// LexerRule
		public RuleCall ele00ParserRuleCallLexerRule() { return c00ParserRuleCallLexerRule; }

		// ParserRule
		public RuleCall ele01ParserRuleCallParserRule() { return c01ParserRuleCallParserRule; }

		// TerminalRule
		public RuleCall ele1ParserRuleCallTerminalRule() { return c1ParserRuleCallTerminalRule; }
	}

	public class AbstractMetamodelDeclarationElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(4);
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallGeneratedMetamodel = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall c1ParserRuleCallReferencedMetamodel = (RuleCall)cAlternatives.eContents().get(1);
		
		// AbstractMetamodelDeclaration:   GeneratedMetamodel|ReferencedMetamodel;
		public ParserRule getRule() { return rule; }

		// GeneratedMetamodel|ReferencedMetamodel
		public Alternatives eleAlternatives() { return cAlternatives; }

		// GeneratedMetamodel
		public RuleCall ele0ParserRuleCallGeneratedMetamodel() { return c0ParserRuleCallGeneratedMetamodel; }

		// ReferencedMetamodel
		public RuleCall ele1ParserRuleCallReferencedMetamodel() { return c1ParserRuleCallReferencedMetamodel; }
	}

	public class GeneratedMetamodelElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(5);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordGenerate = (Keyword)c00Group.eContents().get(0);
		private final Assignment c001AssignmentName = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010LexerRuleCallID = (RuleCall)c001AssignmentName.eContents().get(0);
		private final Assignment c01AssignmentEPackage = (Assignment)c0Group.eContents().get(1);
		private final CrossReference c010CrossReferenceEStringEPackage = (CrossReference)c01AssignmentEPackage.eContents().get(0);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Keyword c10KeywordAs = (Keyword)c1Group.eContents().get(0);
		private final Assignment c11AssignmentAlias = (Assignment)c1Group.eContents().get(1);
		private final RuleCall c110LexerRuleCallID = (RuleCall)c11AssignmentAlias.eContents().get(0);
		
		// GeneratedMetamodel:   "generate" name=ID ePackage=[EPackage|STRING] ("as" alias=ID)?;
		public ParserRule getRule() { return rule; }

		// "generate" name=ID ePackage=[EPackage|STRING] ("as" alias=ID)?
		public Group eleGroup() { return cGroup; }

		// "generate" name=ID ePackage=[EPackage|STRING]
		public Group ele0Group() { return c0Group; }

		// "generate" name=ID
		public Group ele00Group() { return c00Group; }

		// "generate"
		public Keyword ele000KeywordGenerate() { return c000KeywordGenerate; }

		// name=ID
		public Assignment ele001AssignmentName() { return c001AssignmentName; }

		// ID
		public RuleCall ele0010LexerRuleCallID() { return c0010LexerRuleCallID; }

		// ePackage=[EPackage|STRING]
		public Assignment ele01AssignmentEPackage() { return c01AssignmentEPackage; }

		// [EPackage|STRING]
		public CrossReference ele010CrossReferenceEStringEPackage() { return c010CrossReferenceEStringEPackage; }

		// ("as" alias=ID)?
		public Group ele1Group() { return c1Group; }

		// "as"
		public Keyword ele10KeywordAs() { return c10KeywordAs; }

		// alias=ID
		public Assignment ele11AssignmentAlias() { return c11AssignmentAlias; }

		// ID
		public RuleCall ele110LexerRuleCallID() { return c110LexerRuleCallID; }
	}

	public class ReferencedMetamodelElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(6);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordImport = (Keyword)c0Group.eContents().get(0);
		private final Assignment c01AssignmentEPackage = (Assignment)c0Group.eContents().get(1);
		private final CrossReference c010CrossReferenceEStringEPackage = (CrossReference)c01AssignmentEPackage.eContents().get(0);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Keyword c10KeywordAs = (Keyword)c1Group.eContents().get(0);
		private final Assignment c11AssignmentAlias = (Assignment)c1Group.eContents().get(1);
		private final RuleCall c110LexerRuleCallID = (RuleCall)c11AssignmentAlias.eContents().get(0);
		
		// ReferencedMetamodel:   "import" ePackage=[EPackage|STRING] ("as" alias=ID)?;
		public ParserRule getRule() { return rule; }

		// "import" ePackage=[EPackage|STRING] ("as" alias=ID)?
		public Group eleGroup() { return cGroup; }

		// "import" ePackage=[EPackage|STRING]
		public Group ele0Group() { return c0Group; }

		// "import"
		public Keyword ele00KeywordImport() { return c00KeywordImport; }

		// ePackage=[EPackage|STRING]
		public Assignment ele01AssignmentEPackage() { return c01AssignmentEPackage; }

		// [EPackage|STRING]
		public CrossReference ele010CrossReferenceEStringEPackage() { return c010CrossReferenceEStringEPackage; }

		// ("as" alias=ID)?
		public Group ele1Group() { return c1Group; }

		// "as"
		public Keyword ele10KeywordAs() { return c10KeywordAs; }

		// alias=ID
		public Assignment ele11AssignmentAlias() { return c11AssignmentAlias; }

		// ID
		public RuleCall ele110LexerRuleCallID() { return c110LexerRuleCallID; }
	}

	public class LexerRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(7);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Alternatives c00000Alternatives = (Alternatives)c0000Group.eContents().get(0);
		private final Keyword c000000KeywordNative = (Keyword)c00000Alternatives.eContents().get(0);
		private final Keyword c000001KeywordLexer = (Keyword)c00000Alternatives.eContents().get(1);
		private final Assignment c00001AssignmentName = (Assignment)c0000Group.eContents().get(1);
		private final RuleCall c000010LexerRuleCallID = (RuleCall)c00001AssignmentName.eContents().get(0);
		private final Group c0001Group = (Group)c000Group.eContents().get(1);
		private final Keyword c00010KeywordReturns = (Keyword)c0001Group.eContents().get(0);
		private final Assignment c00011AssignmentType = (Assignment)c0001Group.eContents().get(1);
		private final RuleCall c000110ParserRuleCallTypeRef = (RuleCall)c00011AssignmentType.eContents().get(0);
		private final Keyword c001KeywordColon = (Keyword)c00Group.eContents().get(1);
		private final Assignment c01AssignmentBody = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010LexerRuleCallSTRING = (RuleCall)c01AssignmentBody.eContents().get(0);
		private final Keyword c1KeywordSemicolon = (Keyword)cGroup.eContents().get(1);
		
		// LexerRule:   ("native"|"lexer") name=ID ("returns" type=TypeRef)? ":" body=STRING ";";
		public ParserRule getRule() { return rule; }

		// ("native"|"lexer") name=ID ("returns" type=TypeRef)? ":" body=STRING ";"
		public Group eleGroup() { return cGroup; }

		// ("native"|"lexer") name=ID ("returns" type=TypeRef)? ":" body=STRING
		public Group ele0Group() { return c0Group; }

		// ("native"|"lexer") name=ID ("returns" type=TypeRef)? ":"
		public Group ele00Group() { return c00Group; }

		// ("native"|"lexer") name=ID ("returns" type=TypeRef)?
		public Group ele000Group() { return c000Group; }

		// ("native"|"lexer") name=ID
		public Group ele0000Group() { return c0000Group; }

		// "native"|"lexer"
		public Alternatives ele00000Alternatives() { return c00000Alternatives; }

		// "native"
		public Keyword ele000000KeywordNative() { return c000000KeywordNative; }

		// "lexer"
		public Keyword ele000001KeywordLexer() { return c000001KeywordLexer; }

		// name=ID
		public Assignment ele00001AssignmentName() { return c00001AssignmentName; }

		// ID
		public RuleCall ele000010LexerRuleCallID() { return c000010LexerRuleCallID; }

		// ("returns" type=TypeRef)?
		public Group ele0001Group() { return c0001Group; }

		// "returns"
		public Keyword ele00010KeywordReturns() { return c00010KeywordReturns; }

		// type=TypeRef
		public Assignment ele00011AssignmentType() { return c00011AssignmentType; }

		// TypeRef
		public RuleCall ele000110ParserRuleCallTypeRef() { return c000110ParserRuleCallTypeRef; }

		// ":"
		public Keyword ele001KeywordColon() { return c001KeywordColon; }

		// body=STRING
		public Assignment ele01AssignmentBody() { return c01AssignmentBody; }

		// STRING
		public RuleCall ele010LexerRuleCallSTRING() { return c010LexerRuleCallSTRING; }

		// ";"
		public Keyword ele1KeywordSemicolon() { return c1KeywordSemicolon; }
	}

	public class ParserRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(8);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Assignment c00000AssignmentName = (Assignment)c0000Group.eContents().get(0);
		private final RuleCall c000000LexerRuleCallID = (RuleCall)c00000AssignmentName.eContents().get(0);
		private final Group c00001Group = (Group)c0000Group.eContents().get(1);
		private final Keyword c000010KeywordReturns = (Keyword)c00001Group.eContents().get(0);
		private final Assignment c000011AssignmentType = (Assignment)c00001Group.eContents().get(1);
		private final RuleCall c0000110ParserRuleCallTypeRef = (RuleCall)c000011AssignmentType.eContents().get(0);
		private final Group c0001Group = (Group)c000Group.eContents().get(1);
		private final Group c00010Group = (Group)c0001Group.eContents().get(0);
		private final Group c000100Group = (Group)c00010Group.eContents().get(0);
		private final Assignment c0001000AssignmentDefinesHiddenTokens = (Assignment)c000100Group.eContents().get(0);
		private final Keyword c00010000KeywordHidden = (Keyword)c0001000AssignmentDefinesHiddenTokens.eContents().get(0);
		private final Keyword c0001001KeywordLeftParenthesis = (Keyword)c000100Group.eContents().get(1);
		private final Group c000101Group = (Group)c00010Group.eContents().get(1);
		private final Assignment c0001010AssignmentHiddenTokens = (Assignment)c000101Group.eContents().get(0);
		private final CrossReference c00010100CrossReferenceEStringAbstractRule = (CrossReference)c0001010AssignmentHiddenTokens.eContents().get(0);
		private final Group c0001011Group = (Group)c000101Group.eContents().get(1);
		private final Keyword c00010110KeywordComma = (Keyword)c0001011Group.eContents().get(0);
		private final Assignment c00010111AssignmentHiddenTokens = (Assignment)c0001011Group.eContents().get(1);
		private final CrossReference c000101110CrossReferenceEStringAbstractRule = (CrossReference)c00010111AssignmentHiddenTokens.eContents().get(0);
		private final Keyword c00011KeywordRightParenthesis = (Keyword)c0001Group.eContents().get(1);
		private final Keyword c001KeywordColon = (Keyword)c00Group.eContents().get(1);
		private final Assignment c01AssignmentAlternatives = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010ParserRuleCallAlternatives = (RuleCall)c01AssignmentAlternatives.eContents().get(0);
		private final Keyword c1KeywordSemicolon = (Keyword)cGroup.eContents().get(1);
		
		// ParserRule:   name=ID ("returns" type=TypeRef)? (definesHiddenTokens?="hidden" "(" (hiddenTokens+=[AbstractRule] ("," hiddenTokens+=[AbstractRule])*)? ")")? ":" alternatives=Alternatives ";";
		public ParserRule getRule() { return rule; }

		// name=ID ("returns" type=TypeRef)? (definesHiddenTokens?="hidden" "(" (hiddenTokens+=[AbstractRule] ("," hiddenTokens+=[AbstractRule])*)? ")")? ":" alternatives=Alternatives ";"
		public Group eleGroup() { return cGroup; }

		// name=ID ("returns" type=TypeRef)? (definesHiddenTokens?="hidden" "(" (hiddenTokens+=[AbstractRule] ("," hiddenTokens+=[AbstractRule])*)? ")")? ":" alternatives=Alternatives
		public Group ele0Group() { return c0Group; }

		// name=ID ("returns" type=TypeRef)? (definesHiddenTokens?="hidden" "(" (hiddenTokens+=[AbstractRule] ("," hiddenTokens+=[AbstractRule])*)? ")")? ":"
		public Group ele00Group() { return c00Group; }

		// name=ID ("returns" type=TypeRef)? (definesHiddenTokens?="hidden" "(" (hiddenTokens+=[AbstractRule] ("," hiddenTokens+=[AbstractRule])*)? ")")?
		public Group ele000Group() { return c000Group; }

		// name=ID ("returns" type=TypeRef)?
		public Group ele0000Group() { return c0000Group; }

		// name=ID
		public Assignment ele00000AssignmentName() { return c00000AssignmentName; }

		// ID
		public RuleCall ele000000LexerRuleCallID() { return c000000LexerRuleCallID; }

		// ("returns" type=TypeRef)?
		public Group ele00001Group() { return c00001Group; }

		// "returns"
		public Keyword ele000010KeywordReturns() { return c000010KeywordReturns; }

		// type=TypeRef
		public Assignment ele000011AssignmentType() { return c000011AssignmentType; }

		// TypeRef
		public RuleCall ele0000110ParserRuleCallTypeRef() { return c0000110ParserRuleCallTypeRef; }

		// (definesHiddenTokens?="hidden" "(" (hiddenTokens+=[AbstractRule] ("," hiddenTokens+=[AbstractRule])*)? ")")?
		public Group ele0001Group() { return c0001Group; }

		// definesHiddenTokens?="hidden" "(" (hiddenTokens+=[AbstractRule] ("," hiddenTokens+=[AbstractRule])*)?
		public Group ele00010Group() { return c00010Group; }

		// definesHiddenTokens?="hidden" "("
		public Group ele000100Group() { return c000100Group; }

		// definesHiddenTokens?="hidden"
		public Assignment ele0001000AssignmentDefinesHiddenTokens() { return c0001000AssignmentDefinesHiddenTokens; }

		// "hidden"
		public Keyword ele00010000KeywordHidden() { return c00010000KeywordHidden; }

		// "("
		public Keyword ele0001001KeywordLeftParenthesis() { return c0001001KeywordLeftParenthesis; }

		// (hiddenTokens+=[AbstractRule] ("," hiddenTokens+=[AbstractRule])*)?
		public Group ele000101Group() { return c000101Group; }

		// hiddenTokens+=[AbstractRule]
		public Assignment ele0001010AssignmentHiddenTokens() { return c0001010AssignmentHiddenTokens; }

		// [AbstractRule]
		public CrossReference ele00010100CrossReferenceEStringAbstractRule() { return c00010100CrossReferenceEStringAbstractRule; }

		// ("," hiddenTokens+=[AbstractRule])*
		public Group ele0001011Group() { return c0001011Group; }

		// ","
		public Keyword ele00010110KeywordComma() { return c00010110KeywordComma; }

		// hiddenTokens+=[AbstractRule]
		public Assignment ele00010111AssignmentHiddenTokens() { return c00010111AssignmentHiddenTokens; }

		// [AbstractRule]
		public CrossReference ele000101110CrossReferenceEStringAbstractRule() { return c000101110CrossReferenceEStringAbstractRule; }

		// ")"
		public Keyword ele00011KeywordRightParenthesis() { return c00011KeywordRightParenthesis; }

		// ":"
		public Keyword ele001KeywordColon() { return c001KeywordColon; }

		// alternatives=Alternatives
		public Assignment ele01AssignmentAlternatives() { return c01AssignmentAlternatives; }

		// Alternatives
		public RuleCall ele010ParserRuleCallAlternatives() { return c010ParserRuleCallAlternatives; }

		// ";"
		public Keyword ele1KeywordSemicolon() { return c1KeywordSemicolon; }
	}

	public class TerminalRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(9);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Assignment c00000AssignmentTerminal = (Assignment)c0000Group.eContents().get(0);
		private final Keyword c000000KeywordTerminal = (Keyword)c00000AssignmentTerminal.eContents().get(0);
		private final Assignment c00001AssignmentName = (Assignment)c0000Group.eContents().get(1);
		private final RuleCall c000010LexerRuleCallID = (RuleCall)c00001AssignmentName.eContents().get(0);
		private final Group c0001Group = (Group)c000Group.eContents().get(1);
		private final Keyword c00010KeywordReturns = (Keyword)c0001Group.eContents().get(0);
		private final Assignment c00011AssignmentType = (Assignment)c0001Group.eContents().get(1);
		private final RuleCall c000110ParserRuleCallTypeRef = (RuleCall)c00011AssignmentType.eContents().get(0);
		private final Keyword c001KeywordColon = (Keyword)c00Group.eContents().get(1);
		private final Assignment c01AssignmentAlternatives = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010ParserRuleCallTerminalAlternatives = (RuleCall)c01AssignmentAlternatives.eContents().get(0);
		private final Keyword c1KeywordSemicolon = (Keyword)cGroup.eContents().get(1);
		
		// TerminalRule returns ParserRule:   ^terminal?="terminal" name=ID ("returns" type=TypeRef)? ":" alternatives=TerminalAlternatives ";";
		public ParserRule getRule() { return rule; }

		// ^terminal?="terminal" name=ID ("returns" type=TypeRef)? ":" alternatives=TerminalAlternatives ";"
		public Group eleGroup() { return cGroup; }

		// ^terminal?="terminal" name=ID ("returns" type=TypeRef)? ":" alternatives=TerminalAlternatives
		public Group ele0Group() { return c0Group; }

		// ^terminal?="terminal" name=ID ("returns" type=TypeRef)? ":"
		public Group ele00Group() { return c00Group; }

		// ^terminal?="terminal" name=ID ("returns" type=TypeRef)?
		public Group ele000Group() { return c000Group; }

		// ^terminal?="terminal" name=ID
		public Group ele0000Group() { return c0000Group; }

		// ^terminal?="terminal"
		public Assignment ele00000AssignmentTerminal() { return c00000AssignmentTerminal; }

		// "terminal"
		public Keyword ele000000KeywordTerminal() { return c000000KeywordTerminal; }

		// name=ID
		public Assignment ele00001AssignmentName() { return c00001AssignmentName; }

		// ID
		public RuleCall ele000010LexerRuleCallID() { return c000010LexerRuleCallID; }

		// ("returns" type=TypeRef)?
		public Group ele0001Group() { return c0001Group; }

		// "returns"
		public Keyword ele00010KeywordReturns() { return c00010KeywordReturns; }

		// type=TypeRef
		public Assignment ele00011AssignmentType() { return c00011AssignmentType; }

		// TypeRef
		public RuleCall ele000110ParserRuleCallTypeRef() { return c000110ParserRuleCallTypeRef; }

		// ":"
		public Keyword ele001KeywordColon() { return c001KeywordColon; }

		// alternatives=TerminalAlternatives
		public Assignment ele01AssignmentAlternatives() { return c01AssignmentAlternatives; }

		// TerminalAlternatives
		public RuleCall ele010ParserRuleCallTerminalAlternatives() { return c010ParserRuleCallTerminalAlternatives; }

		// ";"
		public Keyword ele1KeywordSemicolon() { return c1KeywordSemicolon; }
	}

	public class TypeRefElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(10);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Assignment c00AssignmentMetamodel = (Assignment)c0Group.eContents().get(0);
		private final CrossReference c000CrossReferenceEStringAbstractMetamodelDeclaration = (CrossReference)c00AssignmentMetamodel.eContents().get(0);
		private final Keyword c01KeywordColonColon = (Keyword)c0Group.eContents().get(1);
		private final Assignment c1AssignmentType = (Assignment)cGroup.eContents().get(1);
		private final CrossReference c10CrossReferenceEStringEClassifier = (CrossReference)c1AssignmentType.eContents().get(0);
		
		// TypeRef:   (metamodel=[AbstractMetamodelDeclaration] "::")? type=[EClassifier];
		public ParserRule getRule() { return rule; }

		// (metamodel=[AbstractMetamodelDeclaration] "::")? type=[EClassifier]
		public Group eleGroup() { return cGroup; }

		// (metamodel=[AbstractMetamodelDeclaration] "::")?
		public Group ele0Group() { return c0Group; }

		// metamodel=[AbstractMetamodelDeclaration]
		public Assignment ele00AssignmentMetamodel() { return c00AssignmentMetamodel; }

		// [AbstractMetamodelDeclaration]
		public CrossReference ele000CrossReferenceEStringAbstractMetamodelDeclaration() { return c000CrossReferenceEStringAbstractMetamodelDeclaration; }

		// "::"
		public Keyword ele01KeywordColonColon() { return c01KeywordColonColon; }

		// type=[EClassifier]
		public Assignment ele1AssignmentType() { return c1AssignmentType; }

		// [EClassifier]
		public CrossReference ele10CrossReferenceEStringEClassifier() { return c10CrossReferenceEStringEClassifier; }
	}

	public class AlternativesElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(11);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallGroup = (RuleCall)cGroup.eContents().get(0);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Group c10Group = (Group)c1Group.eContents().get(0);
		private final Action c100ActionAlternativesgroups = (Action)c10Group.eContents().get(0);
		private final Keyword c101KeywordVerticalLine = (Keyword)c10Group.eContents().get(1);
		private final Assignment c11AssignmentGroups = (Assignment)c1Group.eContents().get(1);
		private final RuleCall c110ParserRuleCallGroup = (RuleCall)c11AssignmentGroups.eContents().get(0);
		
		// Alternatives returns AbstractElement:   Group ({current=Alternatives.groups+=current} "|" groups+=Group)*;
		public ParserRule getRule() { return rule; }

		// Group ({current=Alternatives.groups+=current} "|" groups+=Group)*
		public Group eleGroup() { return cGroup; }

		// Group
		public RuleCall ele0ParserRuleCallGroup() { return c0ParserRuleCallGroup; }

		// ({current=Alternatives.groups+=current} "|" groups+=Group)*
		public Group ele1Group() { return c1Group; }

		// {current=Alternatives.groups+=current} "|"
		public Group ele10Group() { return c10Group; }

		// {current=Alternatives.groups+=current}
		public Action ele100ActionAlternativesgroups() { return c100ActionAlternativesgroups; }

		// "|"
		public Keyword ele101KeywordVerticalLine() { return c101KeywordVerticalLine; }

		// groups+=Group
		public Assignment ele11AssignmentGroups() { return c11AssignmentGroups; }

		// Group
		public RuleCall ele110ParserRuleCallGroup() { return c110ParserRuleCallGroup; }
	}

	public class TerminalAlternativesElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(12);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallTerminalGroup = (RuleCall)cGroup.eContents().get(0);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Group c10Group = (Group)c1Group.eContents().get(0);
		private final Action c100ActionAlternativesgroups = (Action)c10Group.eContents().get(0);
		private final Keyword c101KeywordVerticalLine = (Keyword)c10Group.eContents().get(1);
		private final Assignment c11AssignmentGroups = (Assignment)c1Group.eContents().get(1);
		private final RuleCall c110ParserRuleCallTerminalGroup = (RuleCall)c11AssignmentGroups.eContents().get(0);
		
		// TerminalAlternatives returns AbstractElement:   TerminalGroup ({current=Alternatives.groups+=current} "|" groups+=TerminalGroup)*;
		public ParserRule getRule() { return rule; }

		// TerminalGroup ({current=Alternatives.groups+=current} "|" groups+=TerminalGroup)*
		public Group eleGroup() { return cGroup; }

		// TerminalGroup
		public RuleCall ele0ParserRuleCallTerminalGroup() { return c0ParserRuleCallTerminalGroup; }

		// ({current=Alternatives.groups+=current} "|" groups+=TerminalGroup)*
		public Group ele1Group() { return c1Group; }

		// {current=Alternatives.groups+=current} "|"
		public Group ele10Group() { return c10Group; }

		// {current=Alternatives.groups+=current}
		public Action ele100ActionAlternativesgroups() { return c100ActionAlternativesgroups; }

		// "|"
		public Keyword ele101KeywordVerticalLine() { return c101KeywordVerticalLine; }

		// groups+=TerminalGroup
		public Assignment ele11AssignmentGroups() { return c11AssignmentGroups; }

		// TerminalGroup
		public RuleCall ele110ParserRuleCallTerminalGroup() { return c110ParserRuleCallTerminalGroup; }
	}

	public class GroupElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(13);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallAbstractToken = (RuleCall)cGroup.eContents().get(0);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Action c10ActionGroupabstractTokens = (Action)c1Group.eContents().get(0);
		private final Assignment c11AssignmentAbstractTokens = (Assignment)c1Group.eContents().get(1);
		private final RuleCall c110ParserRuleCallAbstractToken = (RuleCall)c11AssignmentAbstractTokens.eContents().get(0);
		
		// Group returns AbstractElement:   AbstractToken ({current=Group.abstractTokens+=current} abstractTokens+=AbstractToken)*;
		public ParserRule getRule() { return rule; }

		// AbstractToken ({current=Group.abstractTokens+=current} abstractTokens+=AbstractToken)*
		public Group eleGroup() { return cGroup; }

		// AbstractToken
		public RuleCall ele0ParserRuleCallAbstractToken() { return c0ParserRuleCallAbstractToken; }

		// ({current=Group.abstractTokens+=current} abstractTokens+=AbstractToken)*
		public Group ele1Group() { return c1Group; }

		// {current=Group.abstractTokens+=current}
		public Action ele10ActionGroupabstractTokens() { return c10ActionGroupabstractTokens; }

		// abstractTokens+=AbstractToken
		public Assignment ele11AssignmentAbstractTokens() { return c11AssignmentAbstractTokens; }

		// AbstractToken
		public RuleCall ele110ParserRuleCallAbstractToken() { return c110ParserRuleCallAbstractToken; }
	}

	public class TerminalGroupElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(14);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallTerminalToken = (RuleCall)cGroup.eContents().get(0);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Action c10ActionGroupabstractTokens = (Action)c1Group.eContents().get(0);
		private final Assignment c11AssignmentAbstractTokens = (Assignment)c1Group.eContents().get(1);
		private final RuleCall c110ParserRuleCallTerminalToken = (RuleCall)c11AssignmentAbstractTokens.eContents().get(0);
		
		// TerminalGroup returns AbstractElement:   TerminalToken ({current=Group.abstractTokens+=current} abstractTokens+=TerminalToken)*;
		public ParserRule getRule() { return rule; }

		// TerminalToken ({current=Group.abstractTokens+=current} abstractTokens+=TerminalToken)*
		public Group eleGroup() { return cGroup; }

		// TerminalToken
		public RuleCall ele0ParserRuleCallTerminalToken() { return c0ParserRuleCallTerminalToken; }

		// ({current=Group.abstractTokens+=current} abstractTokens+=TerminalToken)*
		public Group ele1Group() { return c1Group; }

		// {current=Group.abstractTokens+=current}
		public Action ele10ActionGroupabstractTokens() { return c10ActionGroupabstractTokens; }

		// abstractTokens+=TerminalToken
		public Assignment ele11AssignmentAbstractTokens() { return c11AssignmentAbstractTokens; }

		// TerminalToken
		public RuleCall ele110ParserRuleCallTerminalToken() { return c110ParserRuleCallTerminalToken; }
	}

	public class AbstractTokenElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(15);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Alternatives c0Alternatives = (Alternatives)cGroup.eContents().get(0);
		private final Alternatives c00Alternatives = (Alternatives)c0Alternatives.eContents().get(0);
		private final RuleCall c000ParserRuleCallAssignment = (RuleCall)c00Alternatives.eContents().get(0);
		private final RuleCall c001ParserRuleCallAction = (RuleCall)c00Alternatives.eContents().get(1);
		private final RuleCall c01ParserRuleCallAbstractTerminal = (RuleCall)c0Alternatives.eContents().get(1);
		private final Assignment c1AssignmentCardinality = (Assignment)cGroup.eContents().get(1);
		private final Alternatives c10Alternatives = (Alternatives)c1AssignmentCardinality.eContents().get(0);
		private final Alternatives c100Alternatives = (Alternatives)c10Alternatives.eContents().get(0);
		private final Keyword c1000KeywordQuestionMark = (Keyword)c100Alternatives.eContents().get(0);
		private final Keyword c1001KeywordAsterisk = (Keyword)c100Alternatives.eContents().get(1);
		private final Keyword c101KeywordPlusSign = (Keyword)c10Alternatives.eContents().get(1);
		
		// AbstractToken returns AbstractElement:   (Assignment|Action|AbstractTerminal) (cardinality=("?"|"*"|"+"))?;
		public ParserRule getRule() { return rule; }

		// (Assignment|Action|AbstractTerminal) (cardinality=("?"|"*"|"+"))?
		public Group eleGroup() { return cGroup; }

		// Assignment|Action|AbstractTerminal
		public Alternatives ele0Alternatives() { return c0Alternatives; }

		// Assignment|Action
		public Alternatives ele00Alternatives() { return c00Alternatives; }

		// Assignment
		public RuleCall ele000ParserRuleCallAssignment() { return c000ParserRuleCallAssignment; }

		// Action
		public RuleCall ele001ParserRuleCallAction() { return c001ParserRuleCallAction; }

		// AbstractTerminal
		public RuleCall ele01ParserRuleCallAbstractTerminal() { return c01ParserRuleCallAbstractTerminal; }

		// (cardinality=("?"|"*"|"+"))?
		public Assignment ele1AssignmentCardinality() { return c1AssignmentCardinality; }

		// "?"|"*"|"+"
		public Alternatives ele10Alternatives() { return c10Alternatives; }

		// "?"|"*"
		public Alternatives ele100Alternatives() { return c100Alternatives; }

		// "?"
		public Keyword ele1000KeywordQuestionMark() { return c1000KeywordQuestionMark; }

		// "*"
		public Keyword ele1001KeywordAsterisk() { return c1001KeywordAsterisk; }

		// "+"
		public Keyword ele101KeywordPlusSign() { return c101KeywordPlusSign; }
	}

	public class TerminalTokenElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(16);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallTerminalTokenElement = (RuleCall)cGroup.eContents().get(0);
		private final Assignment c1AssignmentCardinality = (Assignment)cGroup.eContents().get(1);
		private final Alternatives c10Alternatives = (Alternatives)c1AssignmentCardinality.eContents().get(0);
		private final Alternatives c100Alternatives = (Alternatives)c10Alternatives.eContents().get(0);
		private final Keyword c1000KeywordQuestionMark = (Keyword)c100Alternatives.eContents().get(0);
		private final Keyword c1001KeywordAsterisk = (Keyword)c100Alternatives.eContents().get(1);
		private final Keyword c101KeywordPlusSign = (Keyword)c10Alternatives.eContents().get(1);
		
		// TerminalToken returns AbstractElement:   TerminalTokenElement (cardinality=("?"|"*"|"+"))?;
		public ParserRule getRule() { return rule; }

		// TerminalTokenElement (cardinality=("?"|"*"|"+"))?
		public Group eleGroup() { return cGroup; }

		// TerminalTokenElement
		public RuleCall ele0ParserRuleCallTerminalTokenElement() { return c0ParserRuleCallTerminalTokenElement; }

		// (cardinality=("?"|"*"|"+"))?
		public Assignment ele1AssignmentCardinality() { return c1AssignmentCardinality; }

		// "?"|"*"|"+"
		public Alternatives ele10Alternatives() { return c10Alternatives; }

		// "?"|"*"
		public Alternatives ele100Alternatives() { return c100Alternatives; }

		// "?"
		public Keyword ele1000KeywordQuestionMark() { return c1000KeywordQuestionMark; }

		// "*"
		public Keyword ele1001KeywordAsterisk() { return c1001KeywordAsterisk; }

		// "+"
		public Keyword ele101KeywordPlusSign() { return c101KeywordPlusSign; }
	}

	public class AssignmentElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(17);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Assignment c00AssignmentFeature = (Assignment)c0Group.eContents().get(0);
		private final RuleCall c000LexerRuleCallID = (RuleCall)c00AssignmentFeature.eContents().get(0);
		private final Assignment c01AssignmentOperator = (Assignment)c0Group.eContents().get(1);
		private final Alternatives c010Alternatives = (Alternatives)c01AssignmentOperator.eContents().get(0);
		private final Alternatives c0100Alternatives = (Alternatives)c010Alternatives.eContents().get(0);
		private final Keyword c01000KeywordPlusSignEqualsSign = (Keyword)c0100Alternatives.eContents().get(0);
		private final Keyword c01001KeywordEqualsSign = (Keyword)c0100Alternatives.eContents().get(1);
		private final Keyword c0101KeywordQuestionMarkEqualsSign = (Keyword)c010Alternatives.eContents().get(1);
		private final Assignment c1AssignmentTerminal = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10ParserRuleCallAbstractTerminal = (RuleCall)c1AssignmentTerminal.eContents().get(0);
		
		// Assignment:   feature=ID operator=("+="|"="|"?=") ^terminal=AbstractTerminal;
		public ParserRule getRule() { return rule; }

		// feature=ID operator=("+="|"="|"?=") ^terminal=AbstractTerminal
		public Group eleGroup() { return cGroup; }

		// feature=ID operator=("+="|"="|"?=")
		public Group ele0Group() { return c0Group; }

		// feature=ID
		public Assignment ele00AssignmentFeature() { return c00AssignmentFeature; }

		// ID
		public RuleCall ele000LexerRuleCallID() { return c000LexerRuleCallID; }

		// operator=("+="|"="|"?=")
		public Assignment ele01AssignmentOperator() { return c01AssignmentOperator; }

		// "+="|"="|"?="
		public Alternatives ele010Alternatives() { return c010Alternatives; }

		// "+="|"="
		public Alternatives ele0100Alternatives() { return c0100Alternatives; }

		// "+="
		public Keyword ele01000KeywordPlusSignEqualsSign() { return c01000KeywordPlusSignEqualsSign; }

		// "="
		public Keyword ele01001KeywordEqualsSign() { return c01001KeywordEqualsSign; }

		// "?="
		public Keyword ele0101KeywordQuestionMarkEqualsSign() { return c0101KeywordQuestionMarkEqualsSign; }

		// ^terminal=AbstractTerminal
		public Assignment ele1AssignmentTerminal() { return c1AssignmentTerminal; }

		// AbstractTerminal
		public RuleCall ele10ParserRuleCallAbstractTerminal() { return c10ParserRuleCallAbstractTerminal; }
	}

	public class ActionElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(18);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Group c00000Group = (Group)c0000Group.eContents().get(0);
		private final Group c000000Group = (Group)c00000Group.eContents().get(0);
		private final Keyword c0000000KeywordLeftCurlyBracket = (Keyword)c000000Group.eContents().get(0);
		private final Group c0000001Group = (Group)c000000Group.eContents().get(1);
		private final Keyword c00000010KeywordCurrent = (Keyword)c0000001Group.eContents().get(0);
		private final Keyword c00000011KeywordEqualsSign = (Keyword)c0000001Group.eContents().get(1);
		private final Assignment c000001AssignmentTypeName = (Assignment)c00000Group.eContents().get(1);
		private final RuleCall c0000010ParserRuleCallTypeRef = (RuleCall)c000001AssignmentTypeName.eContents().get(0);
		private final Keyword c00001KeywordFullStop = (Keyword)c0000Group.eContents().get(1);
		private final Assignment c0001AssignmentFeature = (Assignment)c000Group.eContents().get(1);
		private final RuleCall c00010LexerRuleCallID = (RuleCall)c0001AssignmentFeature.eContents().get(0);
		private final Assignment c001AssignmentOperator = (Assignment)c00Group.eContents().get(1);
		private final Alternatives c0010Alternatives = (Alternatives)c001AssignmentOperator.eContents().get(0);
		private final Keyword c00100KeywordEqualsSign = (Keyword)c0010Alternatives.eContents().get(0);
		private final Keyword c00101KeywordPlusSignEqualsSign = (Keyword)c0010Alternatives.eContents().get(1);
		private final Keyword c01KeywordCurrent = (Keyword)c0Group.eContents().get(1);
		private final Keyword c1KeywordRightCurlyBracket = (Keyword)cGroup.eContents().get(1);
		
		// Action:   "{" ("current" "=")? typeName=TypeRef "." feature=ID operator=("="|"+=") "current" "}";
		public ParserRule getRule() { return rule; }

		// "{" ("current" "=")? typeName=TypeRef "." feature=ID operator=("="|"+=") "current" "}"
		public Group eleGroup() { return cGroup; }

		// "{" ("current" "=")? typeName=TypeRef "." feature=ID operator=("="|"+=") "current"
		public Group ele0Group() { return c0Group; }

		// "{" ("current" "=")? typeName=TypeRef "." feature=ID operator=("="|"+=")
		public Group ele00Group() { return c00Group; }

		// "{" ("current" "=")? typeName=TypeRef "." feature=ID
		public Group ele000Group() { return c000Group; }

		// "{" ("current" "=")? typeName=TypeRef "."
		public Group ele0000Group() { return c0000Group; }

		// "{" ("current" "=")? typeName=TypeRef
		public Group ele00000Group() { return c00000Group; }

		// "{" ("current" "=")?
		public Group ele000000Group() { return c000000Group; }

		// "{"
		public Keyword ele0000000KeywordLeftCurlyBracket() { return c0000000KeywordLeftCurlyBracket; }

		// ("current" "=")?
		public Group ele0000001Group() { return c0000001Group; }

		// "current"
		public Keyword ele00000010KeywordCurrent() { return c00000010KeywordCurrent; }

		// "="
		public Keyword ele00000011KeywordEqualsSign() { return c00000011KeywordEqualsSign; }

		// typeName=TypeRef
		public Assignment ele000001AssignmentTypeName() { return c000001AssignmentTypeName; }

		// TypeRef
		public RuleCall ele0000010ParserRuleCallTypeRef() { return c0000010ParserRuleCallTypeRef; }

		// "."
		public Keyword ele00001KeywordFullStop() { return c00001KeywordFullStop; }

		// feature=ID
		public Assignment ele0001AssignmentFeature() { return c0001AssignmentFeature; }

		// ID
		public RuleCall ele00010LexerRuleCallID() { return c00010LexerRuleCallID; }

		// operator=("="|"+=")
		public Assignment ele001AssignmentOperator() { return c001AssignmentOperator; }

		// "="|"+="
		public Alternatives ele0010Alternatives() { return c0010Alternatives; }

		// "="
		public Keyword ele00100KeywordEqualsSign() { return c00100KeywordEqualsSign; }

		// "+="
		public Keyword ele00101KeywordPlusSignEqualsSign() { return c00101KeywordPlusSignEqualsSign; }

		// "current"
		public Keyword ele01KeywordCurrent() { return c01KeywordCurrent; }

		// "}"
		public Keyword ele1KeywordRightCurlyBracket() { return c1KeywordRightCurlyBracket; }
	}

	public class AbstractTerminalElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(19);
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Alternatives c0Alternatives = (Alternatives)cAlternatives.eContents().get(0);
		private final Alternatives c00Alternatives = (Alternatives)c0Alternatives.eContents().get(0);
		private final RuleCall c000ParserRuleCallKeyword = (RuleCall)c00Alternatives.eContents().get(0);
		private final RuleCall c001ParserRuleCallRuleCall = (RuleCall)c00Alternatives.eContents().get(1);
		private final RuleCall c01ParserRuleCallParenthesizedElement = (RuleCall)c0Alternatives.eContents().get(1);
		private final RuleCall c1ParserRuleCallCrossReference = (RuleCall)cAlternatives.eContents().get(1);
		
		// AbstractTerminal returns AbstractElement:   Keyword|RuleCall|ParenthesizedElement|CrossReference;
		public ParserRule getRule() { return rule; }

		// Keyword|RuleCall|ParenthesizedElement|CrossReference
		public Alternatives eleAlternatives() { return cAlternatives; }

		// Keyword|RuleCall|ParenthesizedElement
		public Alternatives ele0Alternatives() { return c0Alternatives; }

		// Keyword|RuleCall
		public Alternatives ele00Alternatives() { return c00Alternatives; }

		// Keyword
		public RuleCall ele000ParserRuleCallKeyword() { return c000ParserRuleCallKeyword; }

		// RuleCall
		public RuleCall ele001ParserRuleCallRuleCall() { return c001ParserRuleCallRuleCall; }

		// ParenthesizedElement
		public RuleCall ele01ParserRuleCallParenthesizedElement() { return c01ParserRuleCallParenthesizedElement; }

		// CrossReference
		public RuleCall ele1ParserRuleCallCrossReference() { return c1ParserRuleCallCrossReference; }
	}

	public class TerminalTokenElementElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(20);
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Alternatives c0Alternatives = (Alternatives)cAlternatives.eContents().get(0);
		private final Alternatives c00Alternatives = (Alternatives)c0Alternatives.eContents().get(0);
		private final Alternatives c000Alternatives = (Alternatives)c00Alternatives.eContents().get(0);
		private final RuleCall c0000ParserRuleCallCharacterRange = (RuleCall)c000Alternatives.eContents().get(0);
		private final RuleCall c0001ParserRuleCallRuleCall = (RuleCall)c000Alternatives.eContents().get(1);
		private final RuleCall c001ParserRuleCallParenthesizedTerminalElement = (RuleCall)c00Alternatives.eContents().get(1);
		private final RuleCall c01ParserRuleCallAbstractNegatedToken = (RuleCall)c0Alternatives.eContents().get(1);
		private final RuleCall c1ParserRuleCallWildcard = (RuleCall)cAlternatives.eContents().get(1);
		
		// TerminalTokenElement returns AbstractElement:   CharacterRange|RuleCall|ParenthesizedTerminalElement|AbstractNegatedToken|Wildcard;
		public ParserRule getRule() { return rule; }

		// CharacterRange|RuleCall|ParenthesizedTerminalElement|AbstractNegatedToken|Wildcard
		public Alternatives eleAlternatives() { return cAlternatives; }

		// CharacterRange|RuleCall|ParenthesizedTerminalElement|AbstractNegatedToken
		public Alternatives ele0Alternatives() { return c0Alternatives; }

		// CharacterRange|RuleCall|ParenthesizedTerminalElement
		public Alternatives ele00Alternatives() { return c00Alternatives; }

		// CharacterRange|RuleCall
		public Alternatives ele000Alternatives() { return c000Alternatives; }

		// CharacterRange
		public RuleCall ele0000ParserRuleCallCharacterRange() { return c0000ParserRuleCallCharacterRange; }

		// RuleCall
		public RuleCall ele0001ParserRuleCallRuleCall() { return c0001ParserRuleCallRuleCall; }

		// ParenthesizedTerminalElement
		public RuleCall ele001ParserRuleCallParenthesizedTerminalElement() { return c001ParserRuleCallParenthesizedTerminalElement; }

		// AbstractNegatedToken
		public RuleCall ele01ParserRuleCallAbstractNegatedToken() { return c01ParserRuleCallAbstractNegatedToken; }

		// Wildcard
		public RuleCall ele1ParserRuleCallWildcard() { return c1ParserRuleCallWildcard; }
	}

	public class AbstractNegatedTokenElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(21);
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallNegatedToken = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall c1ParserRuleCallUpToToken = (RuleCall)cAlternatives.eContents().get(1);
		
		// AbstractNegatedToken:   NegatedToken|UpToToken;
		public ParserRule getRule() { return rule; }

		// NegatedToken|UpToToken
		public Alternatives eleAlternatives() { return cAlternatives; }

		// NegatedToken
		public RuleCall ele0ParserRuleCallNegatedToken() { return c0ParserRuleCallNegatedToken; }

		// UpToToken
		public RuleCall ele1ParserRuleCallUpToToken() { return c1ParserRuleCallUpToToken; }
	}

	public class NegatedTokenElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(22);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordExclamationMark = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentTerminal = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10ParserRuleCallTerminalTokenElement = (RuleCall)c1AssignmentTerminal.eContents().get(0);
		
		// NegatedToken:   "!" ^terminal=TerminalTokenElement;
		public ParserRule getRule() { return rule; }

		// "!" ^terminal=TerminalTokenElement
		public Group eleGroup() { return cGroup; }

		// "!"
		public Keyword ele0KeywordExclamationMark() { return c0KeywordExclamationMark; }

		// ^terminal=TerminalTokenElement
		public Assignment ele1AssignmentTerminal() { return c1AssignmentTerminal; }

		// TerminalTokenElement
		public RuleCall ele10ParserRuleCallTerminalTokenElement() { return c10ParserRuleCallTerminalTokenElement; }
	}

	public class UpToTokenElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(23);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordHyphenMinusGreaterThanSign = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentTerminal = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10ParserRuleCallTerminalTokenElement = (RuleCall)c1AssignmentTerminal.eContents().get(0);
		
		// UpToToken:   "->" ^terminal=TerminalTokenElement;
		public ParserRule getRule() { return rule; }

		// "->" ^terminal=TerminalTokenElement
		public Group eleGroup() { return cGroup; }

		// "->"
		public Keyword ele0KeywordHyphenMinusGreaterThanSign() { return c0KeywordHyphenMinusGreaterThanSign; }

		// ^terminal=TerminalTokenElement
		public Assignment ele1AssignmentTerminal() { return c1AssignmentTerminal; }

		// TerminalTokenElement
		public RuleCall ele10ParserRuleCallTerminalTokenElement() { return c10ParserRuleCallTerminalTokenElement; }
	}

	public class WildcardElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(24);
		private final Assignment cAssignmentIsWildcard = (Assignment)rule.eContents().get(1);
		private final Keyword c0KeywordFullStop = (Keyword)cAssignmentIsWildcard.eContents().get(0);
		
		// Wildcard:   isWildcard?=".";
		public ParserRule getRule() { return rule; }

		// isWildcard?="."
		public Assignment eleAssignmentIsWildcard() { return cAssignmentIsWildcard; }

		// "."
		public Keyword ele0KeywordFullStop() { return c0KeywordFullStop; }
	}

	public class CharacterRangeElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(25);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallKeyword = (RuleCall)cGroup.eContents().get(0);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Group c10Group = (Group)c1Group.eContents().get(0);
		private final Action c100ActionCharacterRangeleft = (Action)c10Group.eContents().get(0);
		private final Keyword c101KeywordFullStopFullStop = (Keyword)c10Group.eContents().get(1);
		private final Assignment c11AssignmentRight = (Assignment)c1Group.eContents().get(1);
		private final RuleCall c110ParserRuleCallKeyword = (RuleCall)c11AssignmentRight.eContents().get(0);
		
		// CharacterRange returns AbstractElement:   Keyword ({current=CharacterRange.left=current} ".." right=Keyword)?;
		public ParserRule getRule() { return rule; }

		// Keyword ({current=CharacterRange.left=current} ".." right=Keyword)?
		public Group eleGroup() { return cGroup; }

		// Keyword
		public RuleCall ele0ParserRuleCallKeyword() { return c0ParserRuleCallKeyword; }

		// ({current=CharacterRange.left=current} ".." right=Keyword)?
		public Group ele1Group() { return c1Group; }

		// {current=CharacterRange.left=current} ".."
		public Group ele10Group() { return c10Group; }

		// {current=CharacterRange.left=current}
		public Action ele100ActionCharacterRangeleft() { return c100ActionCharacterRangeleft; }

		// ".."
		public Keyword ele101KeywordFullStopFullStop() { return c101KeywordFullStopFullStop; }

		// right=Keyword
		public Assignment ele11AssignmentRight() { return c11AssignmentRight; }

		// Keyword
		public RuleCall ele110ParserRuleCallKeyword() { return c110ParserRuleCallKeyword; }
	}

	public class CrossReferenceElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(26);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordLeftSquareBracket = (Keyword)c00Group.eContents().get(0);
		private final Assignment c001AssignmentType = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010ParserRuleCallTypeRef = (RuleCall)c001AssignmentType.eContents().get(0);
		private final Group c01Group = (Group)c0Group.eContents().get(1);
		private final Keyword c010KeywordVerticalLine = (Keyword)c01Group.eContents().get(0);
		private final Assignment c011AssignmentRule = (Assignment)c01Group.eContents().get(1);
		private final CrossReference c0110CrossReferenceEStringAbstractRule = (CrossReference)c011AssignmentRule.eContents().get(0);
		private final Keyword c1KeywordRightSquareBracket = (Keyword)cGroup.eContents().get(1);
		
		// CrossReference:   "[" type=TypeRef ("|" rule=[AbstractRule])? "]";
		public ParserRule getRule() { return rule; }

		// "[" type=TypeRef ("|" rule=[AbstractRule])? "]"
		public Group eleGroup() { return cGroup; }

		// "[" type=TypeRef ("|" rule=[AbstractRule])?
		public Group ele0Group() { return c0Group; }

		// "[" type=TypeRef
		public Group ele00Group() { return c00Group; }

		// "["
		public Keyword ele000KeywordLeftSquareBracket() { return c000KeywordLeftSquareBracket; }

		// type=TypeRef
		public Assignment ele001AssignmentType() { return c001AssignmentType; }

		// TypeRef
		public RuleCall ele0010ParserRuleCallTypeRef() { return c0010ParserRuleCallTypeRef; }

		// ("|" rule=[AbstractRule])?
		public Group ele01Group() { return c01Group; }

		// "|"
		public Keyword ele010KeywordVerticalLine() { return c010KeywordVerticalLine; }

		// rule=[AbstractRule]
		public Assignment ele011AssignmentRule() { return c011AssignmentRule; }

		// [AbstractRule]
		public CrossReference ele0110CrossReferenceEStringAbstractRule() { return c0110CrossReferenceEStringAbstractRule; }

		// "]"
		public Keyword ele1KeywordRightSquareBracket() { return c1KeywordRightSquareBracket; }
	}

	public class ParenthesizedElementElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(27);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordLeftParenthesis = (Keyword)c0Group.eContents().get(0);
		private final RuleCall c01ParserRuleCallAlternatives = (RuleCall)c0Group.eContents().get(1);
		private final Keyword c1KeywordRightParenthesis = (Keyword)cGroup.eContents().get(1);
		
		// ParenthesizedElement returns AbstractElement:   "(" Alternatives ")";
		public ParserRule getRule() { return rule; }

		// "(" Alternatives ")"
		public Group eleGroup() { return cGroup; }

		// "(" Alternatives
		public Group ele0Group() { return c0Group; }

		// "("
		public Keyword ele00KeywordLeftParenthesis() { return c00KeywordLeftParenthesis; }

		// Alternatives
		public RuleCall ele01ParserRuleCallAlternatives() { return c01ParserRuleCallAlternatives; }

		// ")"
		public Keyword ele1KeywordRightParenthesis() { return c1KeywordRightParenthesis; }
	}

	public class ParenthesizedTerminalElementElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(28);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordLeftParenthesis = (Keyword)c0Group.eContents().get(0);
		private final RuleCall c01ParserRuleCallTerminalAlternatives = (RuleCall)c0Group.eContents().get(1);
		private final Keyword c1KeywordRightParenthesis = (Keyword)cGroup.eContents().get(1);
		
		// ParenthesizedTerminalElement returns AbstractElement:   "(" TerminalAlternatives ")";
		public ParserRule getRule() { return rule; }

		// "(" TerminalAlternatives ")"
		public Group eleGroup() { return cGroup; }

		// "(" TerminalAlternatives
		public Group ele0Group() { return c0Group; }

		// "("
		public Keyword ele00KeywordLeftParenthesis() { return c00KeywordLeftParenthesis; }

		// TerminalAlternatives
		public RuleCall ele01ParserRuleCallTerminalAlternatives() { return c01ParserRuleCallTerminalAlternatives; }

		// ")"
		public Keyword ele1KeywordRightParenthesis() { return c1KeywordRightParenthesis; }
	}

	public class KeywordElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(29);
		private final Assignment cAssignmentValue = (Assignment)rule.eContents().get(1);
		private final RuleCall c0LexerRuleCallSTRING = (RuleCall)cAssignmentValue.eContents().get(0);
		
		// Keyword:   value=STRING;
		public ParserRule getRule() { return rule; }

		// value=STRING
		public Assignment eleAssignmentValue() { return cAssignmentValue; }

		// STRING
		public RuleCall ele0LexerRuleCallSTRING() { return c0LexerRuleCallSTRING; }
	}

	public class RuleCallElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(30);
		private final Assignment cAssignmentRule = (Assignment)rule.eContents().get(1);
		private final CrossReference c0CrossReferenceEStringAbstractRule = (CrossReference)cAssignmentRule.eContents().get(0);
		
		// RuleCall:   rule=[AbstractRule];
		public ParserRule getRule() { return rule; }

		// rule=[AbstractRule]
		public Assignment eleAssignmentRule() { return cAssignmentRule; }

		// [AbstractRule]
		public CrossReference ele0CrossReferenceEStringAbstractRule() { return c0CrossReferenceEStringAbstractRule; }
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
	private static TerminalRuleElements pTerminalRule;
	private static TypeRefElements pTypeRef;
	private static AlternativesElements pAlternatives;
	private static TerminalAlternativesElements pTerminalAlternatives;
	private static GroupElements pGroup;
	private static TerminalGroupElements pTerminalGroup;
	private static AbstractTokenElements pAbstractToken;
	private static TerminalTokenElements pTerminalToken;
	private static AssignmentElements pAssignment;
	private static ActionElements pAction;
	private static AbstractTerminalElements pAbstractTerminal;
	private static TerminalTokenElementElements pTerminalTokenElement;
	private static AbstractNegatedTokenElements pAbstractNegatedToken;
	private static NegatedTokenElements pNegatedToken;
	private static UpToTokenElements pUpToToken;
	private static WildcardElements pWildcard;
	private static CharacterRangeElements pCharacterRange;
	private static CrossReferenceElements pCrossReference;
	private static ParenthesizedElementElements pParenthesizedElement;
	private static ParenthesizedTerminalElementElements pParenthesizedTerminalElement;
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

	
	// Grammar:   (abstract?="abstract language"|"language") idElements+=ID ("." idElements+=ID)* ("extends" superGrammarIdElements+=ID ("." superGrammarIdElements+=ID)*)? (definesHiddenTokens?="hidden" "(" (hiddenTokens+=[AbstractRule] ("," hiddenTokens+=[AbstractRule])*)? ")")? (metamodelDeclarations+=AbstractMetamodelDeclaration)* (rules+=AbstractRule)+;
	public GrammarElements prGrammar() {
		return (pGrammar != null) ? pGrammar : (pGrammar = new GrammarElements());
	} 

	// AbstractRule:   LexerRule|ParserRule|TerminalRule;
	public AbstractRuleElements prAbstractRule() {
		return (pAbstractRule != null) ? pAbstractRule : (pAbstractRule = new AbstractRuleElements());
	} 

	// AbstractMetamodelDeclaration:   GeneratedMetamodel|ReferencedMetamodel;
	public AbstractMetamodelDeclarationElements prAbstractMetamodelDeclaration() {
		return (pAbstractMetamodelDeclaration != null) ? pAbstractMetamodelDeclaration : (pAbstractMetamodelDeclaration = new AbstractMetamodelDeclarationElements());
	} 

	// GeneratedMetamodel:   "generate" name=ID ePackage=[EPackage|STRING] ("as" alias=ID)?;
	public GeneratedMetamodelElements prGeneratedMetamodel() {
		return (pGeneratedMetamodel != null) ? pGeneratedMetamodel : (pGeneratedMetamodel = new GeneratedMetamodelElements());
	} 

	// ReferencedMetamodel:   "import" ePackage=[EPackage|STRING] ("as" alias=ID)?;
	public ReferencedMetamodelElements prReferencedMetamodel() {
		return (pReferencedMetamodel != null) ? pReferencedMetamodel : (pReferencedMetamodel = new ReferencedMetamodelElements());
	} 

	// LexerRule:   ("native"|"lexer") name=ID ("returns" type=TypeRef)? ":" body=STRING ";";
	public LexerRuleElements prLexerRule() {
		return (pLexerRule != null) ? pLexerRule : (pLexerRule = new LexerRuleElements());
	} 

	// ParserRule:   name=ID ("returns" type=TypeRef)? (definesHiddenTokens?="hidden" "(" (hiddenTokens+=[AbstractRule] ("," hiddenTokens+=[AbstractRule])*)? ")")? ":" alternatives=Alternatives ";";
	public ParserRuleElements prParserRule() {
		return (pParserRule != null) ? pParserRule : (pParserRule = new ParserRuleElements());
	} 

	// TerminalRule returns ParserRule:   ^terminal?="terminal" name=ID ("returns" type=TypeRef)? ":" alternatives=TerminalAlternatives ";";
	public TerminalRuleElements prTerminalRule() {
		return (pTerminalRule != null) ? pTerminalRule : (pTerminalRule = new TerminalRuleElements());
	} 

	// TypeRef:   (metamodel=[AbstractMetamodelDeclaration] "::")? type=[EClassifier];
	public TypeRefElements prTypeRef() {
		return (pTypeRef != null) ? pTypeRef : (pTypeRef = new TypeRefElements());
	} 

	// Alternatives returns AbstractElement:   Group ({current=Alternatives.groups+=current} "|" groups+=Group)*;
	public AlternativesElements prAlternatives() {
		return (pAlternatives != null) ? pAlternatives : (pAlternatives = new AlternativesElements());
	} 

	// TerminalAlternatives returns AbstractElement:   TerminalGroup ({current=Alternatives.groups+=current} "|" groups+=TerminalGroup)*;
	public TerminalAlternativesElements prTerminalAlternatives() {
		return (pTerminalAlternatives != null) ? pTerminalAlternatives : (pTerminalAlternatives = new TerminalAlternativesElements());
	} 

	// Group returns AbstractElement:   AbstractToken ({current=Group.abstractTokens+=current} abstractTokens+=AbstractToken)*;
	public GroupElements prGroup() {
		return (pGroup != null) ? pGroup : (pGroup = new GroupElements());
	} 

	// TerminalGroup returns AbstractElement:   TerminalToken ({current=Group.abstractTokens+=current} abstractTokens+=TerminalToken)*;
	public TerminalGroupElements prTerminalGroup() {
		return (pTerminalGroup != null) ? pTerminalGroup : (pTerminalGroup = new TerminalGroupElements());
	} 

	// AbstractToken returns AbstractElement:   (Assignment|Action|AbstractTerminal) (cardinality=("?"|"*"|"+"))?;
	public AbstractTokenElements prAbstractToken() {
		return (pAbstractToken != null) ? pAbstractToken : (pAbstractToken = new AbstractTokenElements());
	} 

	// TerminalToken returns AbstractElement:   TerminalTokenElement (cardinality=("?"|"*"|"+"))?;
	public TerminalTokenElements prTerminalToken() {
		return (pTerminalToken != null) ? pTerminalToken : (pTerminalToken = new TerminalTokenElements());
	} 

	// Assignment:   feature=ID operator=("+="|"="|"?=") ^terminal=AbstractTerminal;
	public AssignmentElements prAssignment() {
		return (pAssignment != null) ? pAssignment : (pAssignment = new AssignmentElements());
	} 

	// Action:   "{" ("current" "=")? typeName=TypeRef "." feature=ID operator=("="|"+=") "current" "}";
	public ActionElements prAction() {
		return (pAction != null) ? pAction : (pAction = new ActionElements());
	} 

	// AbstractTerminal returns AbstractElement:   Keyword|RuleCall|ParenthesizedElement|CrossReference;
	public AbstractTerminalElements prAbstractTerminal() {
		return (pAbstractTerminal != null) ? pAbstractTerminal : (pAbstractTerminal = new AbstractTerminalElements());
	} 

	// TerminalTokenElement returns AbstractElement:   CharacterRange|RuleCall|ParenthesizedTerminalElement|AbstractNegatedToken|Wildcard;
	public TerminalTokenElementElements prTerminalTokenElement() {
		return (pTerminalTokenElement != null) ? pTerminalTokenElement : (pTerminalTokenElement = new TerminalTokenElementElements());
	} 

	// AbstractNegatedToken:   NegatedToken|UpToToken;
	public AbstractNegatedTokenElements prAbstractNegatedToken() {
		return (pAbstractNegatedToken != null) ? pAbstractNegatedToken : (pAbstractNegatedToken = new AbstractNegatedTokenElements());
	} 

	// NegatedToken:   "!" ^terminal=TerminalTokenElement;
	public NegatedTokenElements prNegatedToken() {
		return (pNegatedToken != null) ? pNegatedToken : (pNegatedToken = new NegatedTokenElements());
	} 

	// UpToToken:   "->" ^terminal=TerminalTokenElement;
	public UpToTokenElements prUpToToken() {
		return (pUpToToken != null) ? pUpToToken : (pUpToToken = new UpToTokenElements());
	} 

	// Wildcard:   isWildcard?=".";
	public WildcardElements prWildcard() {
		return (pWildcard != null) ? pWildcard : (pWildcard = new WildcardElements());
	} 

	// CharacterRange returns AbstractElement:   Keyword ({current=CharacterRange.left=current} ".." right=Keyword)?;
	public CharacterRangeElements prCharacterRange() {
		return (pCharacterRange != null) ? pCharacterRange : (pCharacterRange = new CharacterRangeElements());
	} 

	// CrossReference:   "[" type=TypeRef ("|" rule=[AbstractRule])? "]";
	public CrossReferenceElements prCrossReference() {
		return (pCrossReference != null) ? pCrossReference : (pCrossReference = new CrossReferenceElements());
	} 

	// ParenthesizedElement returns AbstractElement:   "(" Alternatives ")";
	public ParenthesizedElementElements prParenthesizedElement() {
		return (pParenthesizedElement != null) ? pParenthesizedElement : (pParenthesizedElement = new ParenthesizedElementElements());
	} 

	// ParenthesizedTerminalElement returns AbstractElement:   "(" TerminalAlternatives ")";
	public ParenthesizedTerminalElementElements prParenthesizedTerminalElement() {
		return (pParenthesizedTerminalElement != null) ? pParenthesizedTerminalElement : (pParenthesizedTerminalElement = new ParenthesizedTerminalElementElements());
	} 

	// Keyword:   value=STRING;
	public KeywordElements prKeyword() {
		return (pKeyword != null) ? pKeyword : (pKeyword = new KeywordElements());
	} 

	// RuleCall:   rule=[AbstractRule];
	public RuleCallElements prRuleCall() {
		return (pRuleCall != null) ? pRuleCall : (pRuleCall = new RuleCallElements());
	} 
}
