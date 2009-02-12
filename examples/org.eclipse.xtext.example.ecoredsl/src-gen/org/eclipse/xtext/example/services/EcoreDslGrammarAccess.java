/*
Generated with Xtext
*/

package org.eclipse.xtext.example.services;

import com.google.inject.Singleton;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;

@Singleton
public class EcoreDslGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class EcoreDslElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EcoreDsl");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment c0AssignmentImports = (Assignment)cGroup.eContents().get(0);
		private final RuleCall c00ParserRuleCallImportStatementDecl = (RuleCall)c0AssignmentImports.eContents().get(0);
		private final Assignment c1AssignmentPackage = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10ParserRuleCallEPackageDecl = (RuleCall)c1AssignmentPackage.eContents().get(0);
		
		// EcoreDsl:   (imports+=ImportStatementDecl)* package=EPackageDecl;
		public ParserRule getRule() { return rule; }

		// (imports+=ImportStatementDecl)* package=EPackageDecl
		public Group eleGroup() { return cGroup; }

		// (imports+=ImportStatementDecl)*
		public Assignment ele0AssignmentImports() { return c0AssignmentImports; }

		// ImportStatementDecl
		public RuleCall ele00ParserRuleCallImportStatementDecl() { return c00ParserRuleCallImportStatementDecl; }

		// package=EPackageDecl
		public Assignment ele1AssignmentPackage() { return c1AssignmentPackage; }

		// EPackageDecl
		public RuleCall ele10ParserRuleCallEPackageDecl() { return c10ParserRuleCallEPackageDecl; }
	}

	public class ImportStatementDeclElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ImportStatementDecl");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordImport = (Keyword)c00Group.eContents().get(0);
		private final Group c001Group = (Group)c00Group.eContents().get(1);
		private final Assignment c0010AssignmentAlias = (Assignment)c001Group.eContents().get(0);
		private final RuleCall c00100LexerRuleCallID = (RuleCall)c0010AssignmentAlias.eContents().get(0);
		private final Keyword c0011KeywordEqualsSign = (Keyword)c001Group.eContents().get(1);
		private final Assignment c01AssignmentImportURI = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010LexerRuleCallSTRING = (RuleCall)c01AssignmentImportURI.eContents().get(0);
		private final Keyword c1KeywordSemicolon = (Keyword)cGroup.eContents().get(1);
		
		// ImportStatementDecl:   "import" (alias=ID "=")? importURI=STRING ";";
		public ParserRule getRule() { return rule; }

		// "import" (alias=ID "=")? importURI=STRING ";"
		public Group eleGroup() { return cGroup; }

		// "import" (alias=ID "=")? importURI=STRING
		public Group ele0Group() { return c0Group; }

		// "import" (alias=ID "=")?
		public Group ele00Group() { return c00Group; }

		// "import"
		public Keyword ele000KeywordImport() { return c000KeywordImport; }

		// (alias=ID "=")?
		public Group ele001Group() { return c001Group; }

		// alias=ID
		public Assignment ele0010AssignmentAlias() { return c0010AssignmentAlias; }

		// ID
		public RuleCall ele00100LexerRuleCallID() { return c00100LexerRuleCallID; }

		// "="
		public Keyword ele0011KeywordEqualsSign() { return c0011KeywordEqualsSign; }

		// importURI=STRING
		public Assignment ele01AssignmentImportURI() { return c01AssignmentImportURI; }

		// STRING
		public RuleCall ele010LexerRuleCallSTRING() { return c010LexerRuleCallSTRING; }

		// ";"
		public Keyword ele1KeywordSemicolon() { return c1KeywordSemicolon; }
	}

	public class EPackageDeclElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EPackageDecl");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Group c00000Group = (Group)c0000Group.eContents().get(0);
		private final Group c000000Group = (Group)c00000Group.eContents().get(0);
		private final Group c0000000Group = (Group)c000000Group.eContents().get(0);
		private final Group c00000000Group = (Group)c0000000Group.eContents().get(0);
		private final Group c000000000Group = (Group)c00000000Group.eContents().get(0);
		private final Group c0000000000Group = (Group)c000000000Group.eContents().get(0);
		private final Assignment c00000000000AssignmentEAnnotations = (Assignment)c0000000000Group.eContents().get(0);
		private final RuleCall c000000000000ParserRuleCallEAnnotationDecl = (RuleCall)c00000000000AssignmentEAnnotations.eContents().get(0);
		private final Keyword c00000000001KeywordPackage = (Keyword)c0000000000Group.eContents().get(1);
		private final Assignment c0000000001AssignmentName = (Assignment)c000000000Group.eContents().get(1);
		private final RuleCall c00000000010ParserRuleCallQID = (RuleCall)c0000000001AssignmentName.eContents().get(0);
		private final Keyword c000000001KeywordNsURI = (Keyword)c00000000Group.eContents().get(1);
		private final Keyword c00000001KeywordEqualsSign = (Keyword)c0000000Group.eContents().get(1);
		private final Assignment c0000001AssignmentNsURI = (Assignment)c000000Group.eContents().get(1);
		private final RuleCall c00000010LexerRuleCallSTRING = (RuleCall)c0000001AssignmentNsURI.eContents().get(0);
		private final Keyword c000001KeywordNsPrefix = (Keyword)c00000Group.eContents().get(1);
		private final Keyword c00001KeywordEqualsSign = (Keyword)c0000Group.eContents().get(1);
		private final Assignment c0001AssignmentNsPrefix = (Assignment)c000Group.eContents().get(1);
		private final RuleCall c00010ParserRuleCallQID = (RuleCall)c0001AssignmentNsPrefix.eContents().get(0);
		private final Keyword c001KeywordLeftCurlyBracket = (Keyword)c00Group.eContents().get(1);
		private final Alternatives c01Alternatives = (Alternatives)c0Group.eContents().get(1);
		private final Assignment c010AssignmentESubpackages = (Assignment)c01Alternatives.eContents().get(0);
		private final RuleCall c0100ParserRuleCallSubEPackageDecl = (RuleCall)c010AssignmentESubpackages.eContents().get(0);
		private final Assignment c011AssignmentEClassifiers = (Assignment)c01Alternatives.eContents().get(1);
		private final RuleCall c0110ParserRuleCallEClassifierDecl = (RuleCall)c011AssignmentEClassifiers.eContents().get(0);
		private final Keyword c1KeywordRightCurlyBracket = (Keyword)cGroup.eContents().get(1);
		
		// EPackageDecl returns EPackage:   (eAnnotations+=EAnnotationDecl)* "package" name=QID "nsURI" "=" nsURI=STRING "nsPrefix" "=" nsPrefix=QID "{" (eSubpackages+=SubEPackageDecl|eClassifiers+=EClassifierDecl)* "}";
		public ParserRule getRule() { return rule; }

		// (eAnnotations+=EAnnotationDecl)* "package" name=QID "nsURI" "=" nsURI=STRING "nsPrefix" "=" nsPrefix=QID "{" (eSubpackages+=SubEPackageDecl|eClassifiers+=EClassifierDecl)* "}"
		public Group eleGroup() { return cGroup; }

		// (eAnnotations+=EAnnotationDecl)* "package" name=QID "nsURI" "=" nsURI=STRING "nsPrefix" "=" nsPrefix=QID "{" (eSubpackages+=SubEPackageDecl|eClassifiers+=EClassifierDecl)*
		public Group ele0Group() { return c0Group; }

		// (eAnnotations+=EAnnotationDecl)* "package" name=QID "nsURI" "=" nsURI=STRING "nsPrefix" "=" nsPrefix=QID "{"
		public Group ele00Group() { return c00Group; }

		// (eAnnotations+=EAnnotationDecl)* "package" name=QID "nsURI" "=" nsURI=STRING "nsPrefix" "=" nsPrefix=QID
		public Group ele000Group() { return c000Group; }

		// (eAnnotations+=EAnnotationDecl)* "package" name=QID "nsURI" "=" nsURI=STRING "nsPrefix" "="
		public Group ele0000Group() { return c0000Group; }

		// (eAnnotations+=EAnnotationDecl)* "package" name=QID "nsURI" "=" nsURI=STRING "nsPrefix"
		public Group ele00000Group() { return c00000Group; }

		// (eAnnotations+=EAnnotationDecl)* "package" name=QID "nsURI" "=" nsURI=STRING
		public Group ele000000Group() { return c000000Group; }

		// (eAnnotations+=EAnnotationDecl)* "package" name=QID "nsURI" "="
		public Group ele0000000Group() { return c0000000Group; }

		// (eAnnotations+=EAnnotationDecl)* "package" name=QID "nsURI"
		public Group ele00000000Group() { return c00000000Group; }

		// (eAnnotations+=EAnnotationDecl)* "package" name=QID
		public Group ele000000000Group() { return c000000000Group; }

		// (eAnnotations+=EAnnotationDecl)* "package"
		public Group ele0000000000Group() { return c0000000000Group; }

		// (eAnnotations+=EAnnotationDecl)*
		public Assignment ele00000000000AssignmentEAnnotations() { return c00000000000AssignmentEAnnotations; }

		// EAnnotationDecl
		public RuleCall ele000000000000ParserRuleCallEAnnotationDecl() { return c000000000000ParserRuleCallEAnnotationDecl; }

		// "package"
		public Keyword ele00000000001KeywordPackage() { return c00000000001KeywordPackage; }

		// name=QID
		public Assignment ele0000000001AssignmentName() { return c0000000001AssignmentName; }

		// QID
		public RuleCall ele00000000010ParserRuleCallQID() { return c00000000010ParserRuleCallQID; }

		// "nsURI"
		public Keyword ele000000001KeywordNsURI() { return c000000001KeywordNsURI; }

		// "="
		public Keyword ele00000001KeywordEqualsSign() { return c00000001KeywordEqualsSign; }

		// nsURI=STRING
		public Assignment ele0000001AssignmentNsURI() { return c0000001AssignmentNsURI; }

		// STRING
		public RuleCall ele00000010LexerRuleCallSTRING() { return c00000010LexerRuleCallSTRING; }

		// "nsPrefix"
		public Keyword ele000001KeywordNsPrefix() { return c000001KeywordNsPrefix; }

		// "="
		public Keyword ele00001KeywordEqualsSign() { return c00001KeywordEqualsSign; }

		// nsPrefix=QID
		public Assignment ele0001AssignmentNsPrefix() { return c0001AssignmentNsPrefix; }

		// QID
		public RuleCall ele00010ParserRuleCallQID() { return c00010ParserRuleCallQID; }

		// "{"
		public Keyword ele001KeywordLeftCurlyBracket() { return c001KeywordLeftCurlyBracket; }

		// (eSubpackages+=SubEPackageDecl|eClassifiers+=EClassifierDecl)*
		public Alternatives ele01Alternatives() { return c01Alternatives; }

		// eSubpackages+=SubEPackageDecl
		public Assignment ele010AssignmentESubpackages() { return c010AssignmentESubpackages; }

		// SubEPackageDecl
		public RuleCall ele0100ParserRuleCallSubEPackageDecl() { return c0100ParserRuleCallSubEPackageDecl; }

		// eClassifiers+=EClassifierDecl
		public Assignment ele011AssignmentEClassifiers() { return c011AssignmentEClassifiers; }

		// EClassifierDecl
		public RuleCall ele0110ParserRuleCallEClassifierDecl() { return c0110ParserRuleCallEClassifierDecl; }

		// "}"
		public Keyword ele1KeywordRightCurlyBracket() { return c1KeywordRightCurlyBracket; }
	}

	public class SubEPackageDeclElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SubEPackageDecl");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Assignment c00000AssignmentEAnnotations = (Assignment)c0000Group.eContents().get(0);
		private final RuleCall c000000ParserRuleCallEAnnotationDecl = (RuleCall)c00000AssignmentEAnnotations.eContents().get(0);
		private final Keyword c00001KeywordPackage = (Keyword)c0000Group.eContents().get(1);
		private final Assignment c0001AssignmentName = (Assignment)c000Group.eContents().get(1);
		private final RuleCall c00010LexerRuleCallID = (RuleCall)c0001AssignmentName.eContents().get(0);
		private final Keyword c001KeywordLeftCurlyBracket = (Keyword)c00Group.eContents().get(1);
		private final Alternatives c01Alternatives = (Alternatives)c0Group.eContents().get(1);
		private final Assignment c010AssignmentESubpackages = (Assignment)c01Alternatives.eContents().get(0);
		private final RuleCall c0100ParserRuleCallSubEPackageDecl = (RuleCall)c010AssignmentESubpackages.eContents().get(0);
		private final Assignment c011AssignmentEClassifiers = (Assignment)c01Alternatives.eContents().get(1);
		private final RuleCall c0110ParserRuleCallEClassifierDecl = (RuleCall)c011AssignmentEClassifiers.eContents().get(0);
		private final Keyword c1KeywordRightCurlyBracket = (Keyword)cGroup.eContents().get(1);
		
		// SubEPackageDecl returns EPackage:   (eAnnotations+=EAnnotationDecl)* "package" name=ID "{" (eSubpackages+=SubEPackageDecl|eClassifiers+=EClassifierDecl)* "}";
		public ParserRule getRule() { return rule; }

		// (eAnnotations+=EAnnotationDecl)* "package" name=ID "{" (eSubpackages+=SubEPackageDecl|eClassifiers+=EClassifierDecl)* "}"
		public Group eleGroup() { return cGroup; }

		// (eAnnotations+=EAnnotationDecl)* "package" name=ID "{" (eSubpackages+=SubEPackageDecl|eClassifiers+=EClassifierDecl)*
		public Group ele0Group() { return c0Group; }

		// (eAnnotations+=EAnnotationDecl)* "package" name=ID "{"
		public Group ele00Group() { return c00Group; }

		// (eAnnotations+=EAnnotationDecl)* "package" name=ID
		public Group ele000Group() { return c000Group; }

		// (eAnnotations+=EAnnotationDecl)* "package"
		public Group ele0000Group() { return c0000Group; }

		// (eAnnotations+=EAnnotationDecl)*
		public Assignment ele00000AssignmentEAnnotations() { return c00000AssignmentEAnnotations; }

		// EAnnotationDecl
		public RuleCall ele000000ParserRuleCallEAnnotationDecl() { return c000000ParserRuleCallEAnnotationDecl; }

		// "package"
		public Keyword ele00001KeywordPackage() { return c00001KeywordPackage; }

		// name=ID
		public Assignment ele0001AssignmentName() { return c0001AssignmentName; }

		// ID
		public RuleCall ele00010LexerRuleCallID() { return c00010LexerRuleCallID; }

		// "{"
		public Keyword ele001KeywordLeftCurlyBracket() { return c001KeywordLeftCurlyBracket; }

		// (eSubpackages+=SubEPackageDecl|eClassifiers+=EClassifierDecl)*
		public Alternatives ele01Alternatives() { return c01Alternatives; }

		// eSubpackages+=SubEPackageDecl
		public Assignment ele010AssignmentESubpackages() { return c010AssignmentESubpackages; }

		// SubEPackageDecl
		public RuleCall ele0100ParserRuleCallSubEPackageDecl() { return c0100ParserRuleCallSubEPackageDecl; }

		// eClassifiers+=EClassifierDecl
		public Assignment ele011AssignmentEClassifiers() { return c011AssignmentEClassifiers; }

		// EClassifierDecl
		public RuleCall ele0110ParserRuleCallEClassifierDecl() { return c0110ParserRuleCallEClassifierDecl; }

		// "}"
		public Keyword ele1KeywordRightCurlyBracket() { return c1KeywordRightCurlyBracket; }
	}

	public class EClassifierDeclElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EClassifierDecl");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallEClassDecl = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall c1ParserRuleCallEDataTypeDecl = (RuleCall)cAlternatives.eContents().get(1);
		
		// EClassifierDecl returns EClassifier:   EClassDecl|EDataTypeDecl;
		public ParserRule getRule() { return rule; }

		// EClassDecl|EDataTypeDecl
		public Alternatives eleAlternatives() { return cAlternatives; }

		// EClassDecl
		public RuleCall ele0ParserRuleCallEClassDecl() { return c0ParserRuleCallEClassDecl; }

		// EDataTypeDecl
		public RuleCall ele1ParserRuleCallEDataTypeDecl() { return c1ParserRuleCallEDataTypeDecl; }
	}

	public class EDataTypeDeclElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EDataTypeDecl");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group c0Group = (Group)cAlternatives.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Assignment c000AssignmentEAnnotations = (Assignment)c00Group.eContents().get(0);
		private final RuleCall c0000ParserRuleCallEAnnotationDecl = (RuleCall)c000AssignmentEAnnotations.eContents().get(0);
		private final Assignment c001AssignmentSerializable = (Assignment)c00Group.eContents().get(1);
		private final Keyword c0010KeywordSerializable = (Keyword)c001AssignmentSerializable.eContents().get(0);
		private final Group c01Group = (Group)c0Group.eContents().get(1);
		private final Group c010Group = (Group)c01Group.eContents().get(0);
		private final Group c0100Group = (Group)c010Group.eContents().get(0);
		private final Group c01000Group = (Group)c0100Group.eContents().get(0);
		private final Keyword c010000KeywordDatatype = (Keyword)c01000Group.eContents().get(0);
		private final Assignment c010001AssignmentName = (Assignment)c01000Group.eContents().get(1);
		private final RuleCall c0100010LexerRuleCallID = (RuleCall)c010001AssignmentName.eContents().get(0);
		private final Keyword c01001KeywordColon = (Keyword)c0100Group.eContents().get(1);
		private final Assignment c0101AssignmentInstanceClassName = (Assignment)c010Group.eContents().get(1);
		private final RuleCall c01010ParserRuleCallSTRING_OR_QID = (RuleCall)c0101AssignmentInstanceClassName.eContents().get(0);
		private final Keyword c011KeywordSemicolon = (Keyword)c01Group.eContents().get(1);
		private final RuleCall c1ParserRuleCallEEnumDecl = (RuleCall)cAlternatives.eContents().get(1);
		
		// EDataTypeDecl returns EDataType:   (eAnnotations+=EAnnotationDecl)* (serializable?="!serializable")? ("datatype" name=ID ":" instanceClassName=STRING_OR_QID ";")|EEnumDecl;
		public ParserRule getRule() { return rule; }

		// (eAnnotations+=EAnnotationDecl)* (serializable?="!serializable")? ("datatype" name=ID ":" instanceClassName=STRING_OR_QID ";")|EEnumDecl
		public Alternatives eleAlternatives() { return cAlternatives; }

		// (eAnnotations+=EAnnotationDecl)* (serializable?="!serializable")? ("datatype" name=ID ":" instanceClassName=STRING_OR_QID ";")
		public Group ele0Group() { return c0Group; }

		// (eAnnotations+=EAnnotationDecl)* (serializable?="!serializable")?
		public Group ele00Group() { return c00Group; }

		// (eAnnotations+=EAnnotationDecl)*
		public Assignment ele000AssignmentEAnnotations() { return c000AssignmentEAnnotations; }

		// EAnnotationDecl
		public RuleCall ele0000ParserRuleCallEAnnotationDecl() { return c0000ParserRuleCallEAnnotationDecl; }

		// (serializable?="!serializable")?
		public Assignment ele001AssignmentSerializable() { return c001AssignmentSerializable; }

		// "!serializable"
		public Keyword ele0010KeywordSerializable() { return c0010KeywordSerializable; }

		// "datatype" name=ID ":" instanceClassName=STRING_OR_QID ";"
		public Group ele01Group() { return c01Group; }

		// "datatype" name=ID ":" instanceClassName=STRING_OR_QID
		public Group ele010Group() { return c010Group; }

		// "datatype" name=ID ":"
		public Group ele0100Group() { return c0100Group; }

		// "datatype" name=ID
		public Group ele01000Group() { return c01000Group; }

		// "datatype"
		public Keyword ele010000KeywordDatatype() { return c010000KeywordDatatype; }

		// name=ID
		public Assignment ele010001AssignmentName() { return c010001AssignmentName; }

		// ID
		public RuleCall ele0100010LexerRuleCallID() { return c0100010LexerRuleCallID; }

		// ":"
		public Keyword ele01001KeywordColon() { return c01001KeywordColon; }

		// instanceClassName=STRING_OR_QID
		public Assignment ele0101AssignmentInstanceClassName() { return c0101AssignmentInstanceClassName; }

		// STRING_OR_QID
		public RuleCall ele01010ParserRuleCallSTRING_OR_QID() { return c01010ParserRuleCallSTRING_OR_QID; }

		// ";"
		public Keyword ele011KeywordSemicolon() { return c011KeywordSemicolon; }

		// EEnumDecl
		public RuleCall ele1ParserRuleCallEEnumDecl() { return c1ParserRuleCallEEnumDecl; }
	}

	public class EAnnotationDeclElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EAnnotationDecl");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Group c00000Group = (Group)c0000Group.eContents().get(0);
		private final Keyword c000000KeywordCommercialAt = (Keyword)c00000Group.eContents().get(0);
		private final Assignment c000001AssignmentSource = (Assignment)c00000Group.eContents().get(1);
		private final RuleCall c0000010LexerRuleCallSTRING = (RuleCall)c000001AssignmentSource.eContents().get(0);
		private final Assignment c00001AssignmentEModelElement = (Assignment)c0000Group.eContents().get(1);
		private final CrossReference c000010CrossReferenceEStringEModelElement = (CrossReference)c00001AssignmentEModelElement.eContents().get(0);
		private final Keyword c0001KeywordLeftParenthesis = (Keyword)c000Group.eContents().get(1);
		private final Assignment c001AssignmentContents = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010ParserRuleCallMapEntrySuper = (RuleCall)c001AssignmentContents.eContents().get(0);
		private final Group c01Group = (Group)c0Group.eContents().get(1);
		private final Keyword c010KeywordComma = (Keyword)c01Group.eContents().get(0);
		private final Assignment c011AssignmentContents = (Assignment)c01Group.eContents().get(1);
		private final RuleCall c0110ParserRuleCallMapEntrySuper = (RuleCall)c011AssignmentContents.eContents().get(0);
		private final Keyword c1KeywordRightParenthesis = (Keyword)cGroup.eContents().get(1);
		
		// EAnnotationDecl returns EAnnotation:   "@" source=STRING (eModelElement=[EModelElement])? "(" contents+=MapEntrySuper ("," contents+=MapEntrySuper)* ")";
		public ParserRule getRule() { return rule; }

		// "@" source=STRING (eModelElement=[EModelElement])? "(" contents+=MapEntrySuper ("," contents+=MapEntrySuper)* ")"
		public Group eleGroup() { return cGroup; }

		// "@" source=STRING (eModelElement=[EModelElement])? "(" contents+=MapEntrySuper ("," contents+=MapEntrySuper)*
		public Group ele0Group() { return c0Group; }

		// "@" source=STRING (eModelElement=[EModelElement])? "(" contents+=MapEntrySuper
		public Group ele00Group() { return c00Group; }

		// "@" source=STRING (eModelElement=[EModelElement])? "("
		public Group ele000Group() { return c000Group; }

		// "@" source=STRING (eModelElement=[EModelElement])?
		public Group ele0000Group() { return c0000Group; }

		// "@" source=STRING
		public Group ele00000Group() { return c00000Group; }

		// "@"
		public Keyword ele000000KeywordCommercialAt() { return c000000KeywordCommercialAt; }

		// source=STRING
		public Assignment ele000001AssignmentSource() { return c000001AssignmentSource; }

		// STRING
		public RuleCall ele0000010LexerRuleCallSTRING() { return c0000010LexerRuleCallSTRING; }

		// (eModelElement=[EModelElement])?
		public Assignment ele00001AssignmentEModelElement() { return c00001AssignmentEModelElement; }

		// [EModelElement]
		public CrossReference ele000010CrossReferenceEStringEModelElement() { return c000010CrossReferenceEStringEModelElement; }

		// "("
		public Keyword ele0001KeywordLeftParenthesis() { return c0001KeywordLeftParenthesis; }

		// contents+=MapEntrySuper
		public Assignment ele001AssignmentContents() { return c001AssignmentContents; }

		// MapEntrySuper
		public RuleCall ele0010ParserRuleCallMapEntrySuper() { return c0010ParserRuleCallMapEntrySuper; }

		// ("," contents+=MapEntrySuper)*
		public Group ele01Group() { return c01Group; }

		// ","
		public Keyword ele010KeywordComma() { return c010KeywordComma; }

		// contents+=MapEntrySuper
		public Assignment ele011AssignmentContents() { return c011AssignmentContents; }

		// MapEntrySuper
		public RuleCall ele0110ParserRuleCallMapEntrySuper() { return c0110ParserRuleCallMapEntrySuper; }

		// ")"
		public Keyword ele1KeywordRightParenthesis() { return c1KeywordRightParenthesis; }
	}

	public class EClassDeclElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EClassDecl");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Group c00000Group = (Group)c0000Group.eContents().get(0);
		private final Group c000000Group = (Group)c00000Group.eContents().get(0);
		private final Group c0000000Group = (Group)c000000Group.eContents().get(0);
		private final Group c00000000Group = (Group)c0000000Group.eContents().get(0);
		private final Assignment c000000000AssignmentEAnnotations = (Assignment)c00000000Group.eContents().get(0);
		private final RuleCall c0000000000ParserRuleCallEAnnotationDecl = (RuleCall)c000000000AssignmentEAnnotations.eContents().get(0);
		private final Assignment c000000001AssignmentAbstract = (Assignment)c00000000Group.eContents().get(1);
		private final Keyword c0000000010KeywordAbstract = (Keyword)c000000001AssignmentAbstract.eContents().get(0);
		private final Alternatives c00000001Alternatives = (Alternatives)c0000000Group.eContents().get(1);
		private final Assignment c000000010AssignmentInterface = (Assignment)c00000001Alternatives.eContents().get(0);
		private final Keyword c0000000100KeywordInterface = (Keyword)c000000010AssignmentInterface.eContents().get(0);
		private final Keyword c000000011KeywordClass = (Keyword)c00000001Alternatives.eContents().get(1);
		private final Assignment c0000001AssignmentName = (Assignment)c000000Group.eContents().get(1);
		private final RuleCall c00000010LexerRuleCallID = (RuleCall)c0000001AssignmentName.eContents().get(0);
		private final Group c000001Group = (Group)c00000Group.eContents().get(1);
		private final Group c0000010Group = (Group)c000001Group.eContents().get(0);
		private final Group c00000100Group = (Group)c0000010Group.eContents().get(0);
		private final Keyword c000001000KeywordLessThanSign = (Keyword)c00000100Group.eContents().get(0);
		private final Assignment c000001001AssignmentETypeParameters = (Assignment)c00000100Group.eContents().get(1);
		private final RuleCall c0000010010ParserRuleCallETypeParameterDecl = (RuleCall)c000001001AssignmentETypeParameters.eContents().get(0);
		private final Group c00000101Group = (Group)c0000010Group.eContents().get(1);
		private final Keyword c000001010KeywordComma = (Keyword)c00000101Group.eContents().get(0);
		private final Assignment c000001011AssignmentETypeParameters = (Assignment)c00000101Group.eContents().get(1);
		private final RuleCall c0000010110ParserRuleCallETypeParameterDecl = (RuleCall)c000001011AssignmentETypeParameters.eContents().get(0);
		private final Keyword c0000011KeywordGreaterThanSign = (Keyword)c000001Group.eContents().get(1);
		private final Group c00001Group = (Group)c0000Group.eContents().get(1);
		private final Group c000010Group = (Group)c00001Group.eContents().get(0);
		private final Keyword c0000100KeywordExtends = (Keyword)c000010Group.eContents().get(0);
		private final Assignment c0000101AssignmentEGenericSuperTypes = (Assignment)c000010Group.eContents().get(1);
		private final RuleCall c00001010ParserRuleCallEGenericTypeReferenceDecl = (RuleCall)c0000101AssignmentEGenericSuperTypes.eContents().get(0);
		private final Group c000011Group = (Group)c00001Group.eContents().get(1);
		private final Keyword c0000110KeywordComma = (Keyword)c000011Group.eContents().get(0);
		private final Assignment c0000111AssignmentEGenericSuperTypes = (Assignment)c000011Group.eContents().get(1);
		private final RuleCall c00001110ParserRuleCallEGenericTypeReferenceDecl = (RuleCall)c0000111AssignmentEGenericSuperTypes.eContents().get(0);
		private final Group c0001Group = (Group)c000Group.eContents().get(1);
		private final Keyword c00010KeywordColon = (Keyword)c0001Group.eContents().get(0);
		private final Assignment c00011AssignmentInstanceClassName = (Assignment)c0001Group.eContents().get(1);
		private final RuleCall c000110ParserRuleCallSTRING_OR_QID = (RuleCall)c00011AssignmentInstanceClassName.eContents().get(0);
		private final Keyword c001KeywordLeftCurlyBracket = (Keyword)c00Group.eContents().get(1);
		private final Alternatives c01Alternatives = (Alternatives)c0Group.eContents().get(1);
		private final Assignment c010AssignmentEStructuralFeatures = (Assignment)c01Alternatives.eContents().get(0);
		private final RuleCall c0100ParserRuleCallEStructuralFeatureDecl = (RuleCall)c010AssignmentEStructuralFeatures.eContents().get(0);
		private final Assignment c011AssignmentEOperations = (Assignment)c01Alternatives.eContents().get(1);
		private final RuleCall c0110ParserRuleCallEOperationDecl = (RuleCall)c011AssignmentEOperations.eContents().get(0);
		private final Keyword c1KeywordRightCurlyBracket = (Keyword)cGroup.eContents().get(1);
		
		// EClassDecl returns EClass:   (eAnnotations+=EAnnotationDecl)* (abstract?="abstract")? (interface?="interface"|"class") name=ID ("<" eTypeParameters+=ETypeParameterDecl ("," eTypeParameters+=ETypeParameterDecl)* ">")? ("extends" eGenericSuperTypes+=EGenericTypeReferenceDecl ("," eGenericSuperTypes+=EGenericTypeReferenceDecl)*)? (":" instanceClassName=STRING_OR_QID)? "{" (eStructuralFeatures+=EStructuralFeatureDecl|eOperations+=EOperationDecl)* "}";
		public ParserRule getRule() { return rule; }

		// (eAnnotations+=EAnnotationDecl)* (abstract?="abstract")? (interface?="interface"|"class") name=ID ("<" eTypeParameters+=ETypeParameterDecl ("," eTypeParameters+=ETypeParameterDecl)* ">")? ("extends" eGenericSuperTypes+=EGenericTypeReferenceDecl ("," eGenericSuperTypes+=EGenericTypeReferenceDecl)*)? (":" instanceClassName=STRING_OR_QID)? "{" (eStructuralFeatures+=EStructuralFeatureDecl|eOperations+=EOperationDecl)* "}"
		public Group eleGroup() { return cGroup; }

		// (eAnnotations+=EAnnotationDecl)* (abstract?="abstract")? (interface?="interface"|"class") name=ID ("<" eTypeParameters+=ETypeParameterDecl ("," eTypeParameters+=ETypeParameterDecl)* ">")? ("extends" eGenericSuperTypes+=EGenericTypeReferenceDecl ("," eGenericSuperTypes+=EGenericTypeReferenceDecl)*)? (":" instanceClassName=STRING_OR_QID)? "{" (eStructuralFeatures+=EStructuralFeatureDecl|eOperations+=EOperationDecl)*
		public Group ele0Group() { return c0Group; }

		// (eAnnotations+=EAnnotationDecl)* (abstract?="abstract")? (interface?="interface"|"class") name=ID ("<" eTypeParameters+=ETypeParameterDecl ("," eTypeParameters+=ETypeParameterDecl)* ">")? ("extends" eGenericSuperTypes+=EGenericTypeReferenceDecl ("," eGenericSuperTypes+=EGenericTypeReferenceDecl)*)? (":" instanceClassName=STRING_OR_QID)? "{"
		public Group ele00Group() { return c00Group; }

		// (eAnnotations+=EAnnotationDecl)* (abstract?="abstract")? (interface?="interface"|"class") name=ID ("<" eTypeParameters+=ETypeParameterDecl ("," eTypeParameters+=ETypeParameterDecl)* ">")? ("extends" eGenericSuperTypes+=EGenericTypeReferenceDecl ("," eGenericSuperTypes+=EGenericTypeReferenceDecl)*)? (":" instanceClassName=STRING_OR_QID)?
		public Group ele000Group() { return c000Group; }

		// (eAnnotations+=EAnnotationDecl)* (abstract?="abstract")? (interface?="interface"|"class") name=ID ("<" eTypeParameters+=ETypeParameterDecl ("," eTypeParameters+=ETypeParameterDecl)* ">")? ("extends" eGenericSuperTypes+=EGenericTypeReferenceDecl ("," eGenericSuperTypes+=EGenericTypeReferenceDecl)*)?
		public Group ele0000Group() { return c0000Group; }

		// (eAnnotations+=EAnnotationDecl)* (abstract?="abstract")? (interface?="interface"|"class") name=ID ("<" eTypeParameters+=ETypeParameterDecl ("," eTypeParameters+=ETypeParameterDecl)* ">")?
		public Group ele00000Group() { return c00000Group; }

		// (eAnnotations+=EAnnotationDecl)* (abstract?="abstract")? (interface?="interface"|"class") name=ID
		public Group ele000000Group() { return c000000Group; }

		// (eAnnotations+=EAnnotationDecl)* (abstract?="abstract")? (interface?="interface"|"class")
		public Group ele0000000Group() { return c0000000Group; }

		// (eAnnotations+=EAnnotationDecl)* (abstract?="abstract")?
		public Group ele00000000Group() { return c00000000Group; }

		// (eAnnotations+=EAnnotationDecl)*
		public Assignment ele000000000AssignmentEAnnotations() { return c000000000AssignmentEAnnotations; }

		// EAnnotationDecl
		public RuleCall ele0000000000ParserRuleCallEAnnotationDecl() { return c0000000000ParserRuleCallEAnnotationDecl; }

		// (abstract?="abstract")?
		public Assignment ele000000001AssignmentAbstract() { return c000000001AssignmentAbstract; }

		// "abstract"
		public Keyword ele0000000010KeywordAbstract() { return c0000000010KeywordAbstract; }

		// interface?="interface"|"class"
		public Alternatives ele00000001Alternatives() { return c00000001Alternatives; }

		// interface?="interface"
		public Assignment ele000000010AssignmentInterface() { return c000000010AssignmentInterface; }

		// "interface"
		public Keyword ele0000000100KeywordInterface() { return c0000000100KeywordInterface; }

		// "class"
		public Keyword ele000000011KeywordClass() { return c000000011KeywordClass; }

		// name=ID
		public Assignment ele0000001AssignmentName() { return c0000001AssignmentName; }

		// ID
		public RuleCall ele00000010LexerRuleCallID() { return c00000010LexerRuleCallID; }

		// ("<" eTypeParameters+=ETypeParameterDecl ("," eTypeParameters+=ETypeParameterDecl)* ">")?
		public Group ele000001Group() { return c000001Group; }

		// "<" eTypeParameters+=ETypeParameterDecl ("," eTypeParameters+=ETypeParameterDecl)*
		public Group ele0000010Group() { return c0000010Group; }

		// "<" eTypeParameters+=ETypeParameterDecl
		public Group ele00000100Group() { return c00000100Group; }

		// "<"
		public Keyword ele000001000KeywordLessThanSign() { return c000001000KeywordLessThanSign; }

		// eTypeParameters+=ETypeParameterDecl
		public Assignment ele000001001AssignmentETypeParameters() { return c000001001AssignmentETypeParameters; }

		// ETypeParameterDecl
		public RuleCall ele0000010010ParserRuleCallETypeParameterDecl() { return c0000010010ParserRuleCallETypeParameterDecl; }

		// ("," eTypeParameters+=ETypeParameterDecl)*
		public Group ele00000101Group() { return c00000101Group; }

		// ","
		public Keyword ele000001010KeywordComma() { return c000001010KeywordComma; }

		// eTypeParameters+=ETypeParameterDecl
		public Assignment ele000001011AssignmentETypeParameters() { return c000001011AssignmentETypeParameters; }

		// ETypeParameterDecl
		public RuleCall ele0000010110ParserRuleCallETypeParameterDecl() { return c0000010110ParserRuleCallETypeParameterDecl; }

		// ">"
		public Keyword ele0000011KeywordGreaterThanSign() { return c0000011KeywordGreaterThanSign; }

		// ("extends" eGenericSuperTypes+=EGenericTypeReferenceDecl ("," eGenericSuperTypes+=EGenericTypeReferenceDecl)*)?
		public Group ele00001Group() { return c00001Group; }

		// "extends" eGenericSuperTypes+=EGenericTypeReferenceDecl
		public Group ele000010Group() { return c000010Group; }

		// "extends"
		public Keyword ele0000100KeywordExtends() { return c0000100KeywordExtends; }

		// eGenericSuperTypes+=EGenericTypeReferenceDecl
		public Assignment ele0000101AssignmentEGenericSuperTypes() { return c0000101AssignmentEGenericSuperTypes; }

		// EGenericTypeReferenceDecl
		public RuleCall ele00001010ParserRuleCallEGenericTypeReferenceDecl() { return c00001010ParserRuleCallEGenericTypeReferenceDecl; }

		// ("," eGenericSuperTypes+=EGenericTypeReferenceDecl)*
		public Group ele000011Group() { return c000011Group; }

		// ","
		public Keyword ele0000110KeywordComma() { return c0000110KeywordComma; }

		// eGenericSuperTypes+=EGenericTypeReferenceDecl
		public Assignment ele0000111AssignmentEGenericSuperTypes() { return c0000111AssignmentEGenericSuperTypes; }

		// EGenericTypeReferenceDecl
		public RuleCall ele00001110ParserRuleCallEGenericTypeReferenceDecl() { return c00001110ParserRuleCallEGenericTypeReferenceDecl; }

		// (":" instanceClassName=STRING_OR_QID)?
		public Group ele0001Group() { return c0001Group; }

		// ":"
		public Keyword ele00010KeywordColon() { return c00010KeywordColon; }

		// instanceClassName=STRING_OR_QID
		public Assignment ele00011AssignmentInstanceClassName() { return c00011AssignmentInstanceClassName; }

		// STRING_OR_QID
		public RuleCall ele000110ParserRuleCallSTRING_OR_QID() { return c000110ParserRuleCallSTRING_OR_QID; }

		// "{"
		public Keyword ele001KeywordLeftCurlyBracket() { return c001KeywordLeftCurlyBracket; }

		// (eStructuralFeatures+=EStructuralFeatureDecl|eOperations+=EOperationDecl)*
		public Alternatives ele01Alternatives() { return c01Alternatives; }

		// eStructuralFeatures+=EStructuralFeatureDecl
		public Assignment ele010AssignmentEStructuralFeatures() { return c010AssignmentEStructuralFeatures; }

		// EStructuralFeatureDecl
		public RuleCall ele0100ParserRuleCallEStructuralFeatureDecl() { return c0100ParserRuleCallEStructuralFeatureDecl; }

		// eOperations+=EOperationDecl
		public Assignment ele011AssignmentEOperations() { return c011AssignmentEOperations; }

		// EOperationDecl
		public RuleCall ele0110ParserRuleCallEOperationDecl() { return c0110ParserRuleCallEOperationDecl; }

		// "}"
		public Keyword ele1KeywordRightCurlyBracket() { return c1KeywordRightCurlyBracket; }
	}

	public class EStructuralFeatureDeclElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EStructuralFeatureDecl");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallEAttributeDecl = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall c1ParserRuleCallEReferenceDecl = (RuleCall)cAlternatives.eContents().get(1);
		
		// EStructuralFeatureDecl returns EStructuralFeature:   EAttributeDecl|EReferenceDecl;
		public ParserRule getRule() { return rule; }

		// EAttributeDecl|EReferenceDecl
		public Alternatives eleAlternatives() { return cAlternatives; }

		// EAttributeDecl
		public RuleCall ele0ParserRuleCallEAttributeDecl() { return c0ParserRuleCallEAttributeDecl; }

		// EReferenceDecl
		public RuleCall ele1ParserRuleCallEReferenceDecl() { return c1ParserRuleCallEReferenceDecl; }
	}

	public class EAttributeDeclElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EAttributeDecl");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Group c00000Group = (Group)c0000Group.eContents().get(0);
		private final Group c000000Group = (Group)c00000Group.eContents().get(0);
		private final Assignment c0000000AssignmentEAnnotations = (Assignment)c000000Group.eContents().get(0);
		private final RuleCall c00000000ParserRuleCallEAnnotationDecl = (RuleCall)c0000000AssignmentEAnnotations.eContents().get(0);
		private final Alternatives c0000001Alternatives = (Alternatives)c000000Group.eContents().get(1);
		private final Alternatives c00000010Alternatives = (Alternatives)c0000001Alternatives.eContents().get(0);
		private final Alternatives c000000100Alternatives = (Alternatives)c00000010Alternatives.eContents().get(0);
		private final Alternatives c0000001000Alternatives = (Alternatives)c000000100Alternatives.eContents().get(0);
		private final Alternatives c00000010000Alternatives = (Alternatives)c0000001000Alternatives.eContents().get(0);
		private final Alternatives c000000100000Alternatives = (Alternatives)c00000010000Alternatives.eContents().get(0);
		private final Alternatives c0000001000000Alternatives = (Alternatives)c000000100000Alternatives.eContents().get(0);
		private final Assignment c00000010000000AssignmentID = (Assignment)c0000001000000Alternatives.eContents().get(0);
		private final Keyword c000000100000000KeywordID = (Keyword)c00000010000000AssignmentID.eContents().get(0);
		private final Assignment c00000010000001AssignmentUnique = (Assignment)c0000001000000Alternatives.eContents().get(1);
		private final Keyword c000000100000010KeywordBag = (Keyword)c00000010000001AssignmentUnique.eContents().get(0);
		private final Assignment c0000001000001AssignmentOrdered = (Assignment)c000000100000Alternatives.eContents().get(1);
		private final Keyword c00000010000010KeywordRandom = (Keyword)c0000001000001AssignmentOrdered.eContents().get(0);
		private final Assignment c000000100001AssignmentChangeable = (Assignment)c00000010000Alternatives.eContents().get(1);
		private final Keyword c0000001000010KeywordReadonly = (Keyword)c000000100001AssignmentChangeable.eContents().get(0);
		private final Assignment c00000010001AssignmentVolatile = (Assignment)c0000001000Alternatives.eContents().get(1);
		private final Keyword c000000100010KeywordVolatile = (Keyword)c00000010001AssignmentVolatile.eContents().get(0);
		private final Assignment c0000001001AssignmentTransient = (Assignment)c000000100Alternatives.eContents().get(1);
		private final Keyword c00000010010KeywordTransient = (Keyword)c0000001001AssignmentTransient.eContents().get(0);
		private final Assignment c000000101AssignmentUnsettable = (Assignment)c00000010Alternatives.eContents().get(1);
		private final Keyword c0000001010KeywordUnsettable = (Keyword)c000000101AssignmentUnsettable.eContents().get(0);
		private final Assignment c00000011AssignmentDerived = (Assignment)c0000001Alternatives.eContents().get(1);
		private final Keyword c000000110KeywordDerived = (Keyword)c00000011AssignmentDerived.eContents().get(0);
		private final Keyword c000001KeywordAttr = (Keyword)c00000Group.eContents().get(1);
		private final Assignment c00001AssignmentEGenericType = (Assignment)c0000Group.eContents().get(1);
		private final RuleCall c000010ParserRuleCallEGenericTypeReferenceDecl = (RuleCall)c00001AssignmentEGenericType.eContents().get(0);
		private final Group c0001Group = (Group)c000Group.eContents().get(1);
		private final Group c00010Group = (Group)c0001Group.eContents().get(0);
		private final Group c000100Group = (Group)c00010Group.eContents().get(0);
		private final Keyword c0001000KeywordLeftSquareBracket = (Keyword)c000100Group.eContents().get(0);
		private final Assignment c0001001AssignmentLowerBound = (Assignment)c000100Group.eContents().get(1);
		private final RuleCall c00010010LexerRuleCallINT = (RuleCall)c0001001AssignmentLowerBound.eContents().get(0);
		private final Group c000101Group = (Group)c00010Group.eContents().get(1);
		private final Keyword c0001010KeywordFullStopFullStop = (Keyword)c000101Group.eContents().get(0);
		private final Assignment c0001011AssignmentUpperBound = (Assignment)c000101Group.eContents().get(1);
		private final RuleCall c00010110ParserRuleCallSINT = (RuleCall)c0001011AssignmentUpperBound.eContents().get(0);
		private final Keyword c00011KeywordRightSquareBracket = (Keyword)c0001Group.eContents().get(1);
		private final Assignment c001AssignmentName = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010LexerRuleCallID = (RuleCall)c001AssignmentName.eContents().get(0);
		private final Group c01Group = (Group)c0Group.eContents().get(1);
		private final Keyword c010KeywordEqualsSign = (Keyword)c01Group.eContents().get(0);
		private final Assignment c011AssignmentDefaultValueLiteral = (Assignment)c01Group.eContents().get(1);
		private final RuleCall c0110LexerRuleCallSTRING = (RuleCall)c011AssignmentDefaultValueLiteral.eContents().get(0);
		private final Keyword c1KeywordSemicolon = (Keyword)cGroup.eContents().get(1);
		
		// EAttributeDecl returns EAttribute:   (eAnnotations+=EAnnotationDecl)* (iD?="ID"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"|transient?="transient"|unsettable?="unsettable"|derived?="derived")* "attr" eGenericType=EGenericTypeReferenceDecl ("[" lowerBound=INT (".." upperBound=SINT)? "]")? name=ID ("=" defaultValueLiteral=STRING)? ";";
		public ParserRule getRule() { return rule; }

		// (eAnnotations+=EAnnotationDecl)* (iD?="ID"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"|transient?="transient"|unsettable?="unsettable"|derived?="derived")* "attr" eGenericType=EGenericTypeReferenceDecl ("[" lowerBound=INT (".." upperBound=SINT)? "]")? name=ID ("=" defaultValueLiteral=STRING)? ";"
		public Group eleGroup() { return cGroup; }

		// (eAnnotations+=EAnnotationDecl)* (iD?="ID"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"|transient?="transient"|unsettable?="unsettable"|derived?="derived")* "attr" eGenericType=EGenericTypeReferenceDecl ("[" lowerBound=INT (".." upperBound=SINT)? "]")? name=ID ("=" defaultValueLiteral=STRING)?
		public Group ele0Group() { return c0Group; }

		// (eAnnotations+=EAnnotationDecl)* (iD?="ID"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"|transient?="transient"|unsettable?="unsettable"|derived?="derived")* "attr" eGenericType=EGenericTypeReferenceDecl ("[" lowerBound=INT (".." upperBound=SINT)? "]")? name=ID
		public Group ele00Group() { return c00Group; }

		// (eAnnotations+=EAnnotationDecl)* (iD?="ID"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"|transient?="transient"|unsettable?="unsettable"|derived?="derived")* "attr" eGenericType=EGenericTypeReferenceDecl ("[" lowerBound=INT (".." upperBound=SINT)? "]")?
		public Group ele000Group() { return c000Group; }

		// (eAnnotations+=EAnnotationDecl)* (iD?="ID"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"|transient?="transient"|unsettable?="unsettable"|derived?="derived")* "attr" eGenericType=EGenericTypeReferenceDecl
		public Group ele0000Group() { return c0000Group; }

		// (eAnnotations+=EAnnotationDecl)* (iD?="ID"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"|transient?="transient"|unsettable?="unsettable"|derived?="derived")* "attr"
		public Group ele00000Group() { return c00000Group; }

		// (eAnnotations+=EAnnotationDecl)* (iD?="ID"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"|transient?="transient"|unsettable?="unsettable"|derived?="derived")*
		public Group ele000000Group() { return c000000Group; }

		// (eAnnotations+=EAnnotationDecl)*
		public Assignment ele0000000AssignmentEAnnotations() { return c0000000AssignmentEAnnotations; }

		// EAnnotationDecl
		public RuleCall ele00000000ParserRuleCallEAnnotationDecl() { return c00000000ParserRuleCallEAnnotationDecl; }

		// (iD?="ID"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"|transient?="transient"|unsettable?="unsettable"|derived?="derived")*
		public Alternatives ele0000001Alternatives() { return c0000001Alternatives; }

		// iD?="ID"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"|transient?="transient"|unsettable?="unsettable"
		public Alternatives ele00000010Alternatives() { return c00000010Alternatives; }

		// iD?="ID"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"|transient?="transient"
		public Alternatives ele000000100Alternatives() { return c000000100Alternatives; }

		// iD?="ID"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"
		public Alternatives ele0000001000Alternatives() { return c0000001000Alternatives; }

		// iD?="ID"|unique?="bag"|ordered?="random"|changeable?="readonly"
		public Alternatives ele00000010000Alternatives() { return c00000010000Alternatives; }

		// iD?="ID"|unique?="bag"|ordered?="random"
		public Alternatives ele000000100000Alternatives() { return c000000100000Alternatives; }

		// iD?="ID"|unique?="bag"
		public Alternatives ele0000001000000Alternatives() { return c0000001000000Alternatives; }

		// iD?="ID"
		public Assignment ele00000010000000AssignmentID() { return c00000010000000AssignmentID; }

		// "ID"
		public Keyword ele000000100000000KeywordID() { return c000000100000000KeywordID; }

		// unique?="bag"
		public Assignment ele00000010000001AssignmentUnique() { return c00000010000001AssignmentUnique; }

		// "bag"
		public Keyword ele000000100000010KeywordBag() { return c000000100000010KeywordBag; }

		// ordered?="random"
		public Assignment ele0000001000001AssignmentOrdered() { return c0000001000001AssignmentOrdered; }

		// "random"
		public Keyword ele00000010000010KeywordRandom() { return c00000010000010KeywordRandom; }

		// changeable?="readonly"
		public Assignment ele000000100001AssignmentChangeable() { return c000000100001AssignmentChangeable; }

		// "readonly"
		public Keyword ele0000001000010KeywordReadonly() { return c0000001000010KeywordReadonly; }

		// volatile?="volatile"
		public Assignment ele00000010001AssignmentVolatile() { return c00000010001AssignmentVolatile; }

		// "volatile"
		public Keyword ele000000100010KeywordVolatile() { return c000000100010KeywordVolatile; }

		// transient?="transient"
		public Assignment ele0000001001AssignmentTransient() { return c0000001001AssignmentTransient; }

		// "transient"
		public Keyword ele00000010010KeywordTransient() { return c00000010010KeywordTransient; }

		// unsettable?="unsettable"
		public Assignment ele000000101AssignmentUnsettable() { return c000000101AssignmentUnsettable; }

		// "unsettable"
		public Keyword ele0000001010KeywordUnsettable() { return c0000001010KeywordUnsettable; }

		// derived?="derived"
		public Assignment ele00000011AssignmentDerived() { return c00000011AssignmentDerived; }

		// "derived"
		public Keyword ele000000110KeywordDerived() { return c000000110KeywordDerived; }

		// "attr"
		public Keyword ele000001KeywordAttr() { return c000001KeywordAttr; }

		// eGenericType=EGenericTypeReferenceDecl
		public Assignment ele00001AssignmentEGenericType() { return c00001AssignmentEGenericType; }

		// EGenericTypeReferenceDecl
		public RuleCall ele000010ParserRuleCallEGenericTypeReferenceDecl() { return c000010ParserRuleCallEGenericTypeReferenceDecl; }

		// ("[" lowerBound=INT (".." upperBound=SINT)? "]")?
		public Group ele0001Group() { return c0001Group; }

		// "[" lowerBound=INT (".." upperBound=SINT)?
		public Group ele00010Group() { return c00010Group; }

		// "[" lowerBound=INT
		public Group ele000100Group() { return c000100Group; }

		// "["
		public Keyword ele0001000KeywordLeftSquareBracket() { return c0001000KeywordLeftSquareBracket; }

		// lowerBound=INT
		public Assignment ele0001001AssignmentLowerBound() { return c0001001AssignmentLowerBound; }

		// INT
		public RuleCall ele00010010LexerRuleCallINT() { return c00010010LexerRuleCallINT; }

		// (".." upperBound=SINT)?
		public Group ele000101Group() { return c000101Group; }

		// ".."
		public Keyword ele0001010KeywordFullStopFullStop() { return c0001010KeywordFullStopFullStop; }

		// upperBound=SINT
		public Assignment ele0001011AssignmentUpperBound() { return c0001011AssignmentUpperBound; }

		// SINT
		public RuleCall ele00010110ParserRuleCallSINT() { return c00010110ParserRuleCallSINT; }

		// "]"
		public Keyword ele00011KeywordRightSquareBracket() { return c00011KeywordRightSquareBracket; }

		// name=ID
		public Assignment ele001AssignmentName() { return c001AssignmentName; }

		// ID
		public RuleCall ele0010LexerRuleCallID() { return c0010LexerRuleCallID; }

		// ("=" defaultValueLiteral=STRING)?
		public Group ele01Group() { return c01Group; }

		// "="
		public Keyword ele010KeywordEqualsSign() { return c010KeywordEqualsSign; }

		// defaultValueLiteral=STRING
		public Assignment ele011AssignmentDefaultValueLiteral() { return c011AssignmentDefaultValueLiteral; }

		// STRING
		public RuleCall ele0110LexerRuleCallSTRING() { return c0110LexerRuleCallSTRING; }

		// ";"
		public Keyword ele1KeywordSemicolon() { return c1KeywordSemicolon; }
	}

	public class EReferenceDeclElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EReferenceDecl");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Group c00000Group = (Group)c0000Group.eContents().get(0);
		private final Group c000000Group = (Group)c00000Group.eContents().get(0);
		private final Assignment c0000000AssignmentEAnnotations = (Assignment)c000000Group.eContents().get(0);
		private final RuleCall c00000000ParserRuleCallEAnnotationDecl = (RuleCall)c0000000AssignmentEAnnotations.eContents().get(0);
		private final Alternatives c0000001Alternatives = (Alternatives)c000000Group.eContents().get(1);
		private final Alternatives c00000010Alternatives = (Alternatives)c0000001Alternatives.eContents().get(0);
		private final Alternatives c000000100Alternatives = (Alternatives)c00000010Alternatives.eContents().get(0);
		private final Alternatives c0000001000Alternatives = (Alternatives)c000000100Alternatives.eContents().get(0);
		private final Alternatives c00000010000Alternatives = (Alternatives)c0000001000Alternatives.eContents().get(0);
		private final Alternatives c000000100000Alternatives = (Alternatives)c00000010000Alternatives.eContents().get(0);
		private final Alternatives c0000001000000Alternatives = (Alternatives)c000000100000Alternatives.eContents().get(0);
		private final Assignment c00000010000000AssignmentResolveProxies = (Assignment)c0000001000000Alternatives.eContents().get(0);
		private final Keyword c000000100000000KeywordLocal = (Keyword)c00000010000000AssignmentResolveProxies.eContents().get(0);
		private final Assignment c00000010000001AssignmentUnique = (Assignment)c0000001000000Alternatives.eContents().get(1);
		private final Keyword c000000100000010KeywordBag = (Keyword)c00000010000001AssignmentUnique.eContents().get(0);
		private final Assignment c0000001000001AssignmentOrdered = (Assignment)c000000100000Alternatives.eContents().get(1);
		private final Keyword c00000010000010KeywordRandom = (Keyword)c0000001000001AssignmentOrdered.eContents().get(0);
		private final Assignment c000000100001AssignmentChangeable = (Assignment)c00000010000Alternatives.eContents().get(1);
		private final Keyword c0000001000010KeywordReadonly = (Keyword)c000000100001AssignmentChangeable.eContents().get(0);
		private final Assignment c00000010001AssignmentVolatile = (Assignment)c0000001000Alternatives.eContents().get(1);
		private final Keyword c000000100010KeywordVolatile = (Keyword)c00000010001AssignmentVolatile.eContents().get(0);
		private final Assignment c0000001001AssignmentTransient = (Assignment)c000000100Alternatives.eContents().get(1);
		private final Keyword c00000010010KeywordTransient = (Keyword)c0000001001AssignmentTransient.eContents().get(0);
		private final Assignment c000000101AssignmentUnsettable = (Assignment)c00000010Alternatives.eContents().get(1);
		private final Keyword c0000001010KeywordUnsettable = (Keyword)c000000101AssignmentUnsettable.eContents().get(0);
		private final Assignment c00000011AssignmentDerived = (Assignment)c0000001Alternatives.eContents().get(1);
		private final Keyword c000000110KeywordDerived = (Keyword)c00000011AssignmentDerived.eContents().get(0);
		private final Alternatives c000001Alternatives = (Alternatives)c00000Group.eContents().get(1);
		private final Assignment c0000010AssignmentContainment = (Assignment)c000001Alternatives.eContents().get(0);
		private final Keyword c00000100KeywordVal = (Keyword)c0000010AssignmentContainment.eContents().get(0);
		private final Keyword c0000011KeywordRef = (Keyword)c000001Alternatives.eContents().get(1);
		private final Assignment c00001AssignmentEGenericType = (Assignment)c0000Group.eContents().get(1);
		private final RuleCall c000010ParserRuleCallEGenericTypeReferenceDecl = (RuleCall)c00001AssignmentEGenericType.eContents().get(0);
		private final Group c0001Group = (Group)c000Group.eContents().get(1);
		private final Group c00010Group = (Group)c0001Group.eContents().get(0);
		private final Group c000100Group = (Group)c00010Group.eContents().get(0);
		private final Keyword c0001000KeywordLeftSquareBracket = (Keyword)c000100Group.eContents().get(0);
		private final Assignment c0001001AssignmentLowerBound = (Assignment)c000100Group.eContents().get(1);
		private final RuleCall c00010010LexerRuleCallINT = (RuleCall)c0001001AssignmentLowerBound.eContents().get(0);
		private final Group c000101Group = (Group)c00010Group.eContents().get(1);
		private final Keyword c0001010KeywordFullStopFullStop = (Keyword)c000101Group.eContents().get(0);
		private final Assignment c0001011AssignmentUpperBound = (Assignment)c000101Group.eContents().get(1);
		private final RuleCall c00010110ParserRuleCallSINT = (RuleCall)c0001011AssignmentUpperBound.eContents().get(0);
		private final Keyword c00011KeywordRightSquareBracket = (Keyword)c0001Group.eContents().get(1);
		private final Group c001Group = (Group)c00Group.eContents().get(1);
		private final Keyword c0010KeywordNumberSign = (Keyword)c001Group.eContents().get(0);
		private final Assignment c0011AssignmentEOpposite = (Assignment)c001Group.eContents().get(1);
		private final CrossReference c00110CrossReferenceEStringEReference = (CrossReference)c0011AssignmentEOpposite.eContents().get(0);
		private final Assignment c01AssignmentName = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010LexerRuleCallID = (RuleCall)c01AssignmentName.eContents().get(0);
		private final Keyword c1KeywordSemicolon = (Keyword)cGroup.eContents().get(1);
		
		// EReferenceDecl returns EReference:   (eAnnotations+=EAnnotationDecl)* (resolveProxies?="local"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"|transient?="transient"|unsettable?="unsettable"|derived?="derived")* (containment?="val"|"ref") eGenericType=EGenericTypeReferenceDecl ("[" lowerBound=INT (".." upperBound=SINT)? "]")? ("#" eOpposite=[EReference])? name=ID ";";
		public ParserRule getRule() { return rule; }

		// (eAnnotations+=EAnnotationDecl)* (resolveProxies?="local"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"|transient?="transient"|unsettable?="unsettable"|derived?="derived")* (containment?="val"|"ref") eGenericType=EGenericTypeReferenceDecl ("[" lowerBound=INT (".." upperBound=SINT)? "]")? ("#" eOpposite=[EReference])? name=ID ";"
		public Group eleGroup() { return cGroup; }

		// (eAnnotations+=EAnnotationDecl)* (resolveProxies?="local"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"|transient?="transient"|unsettable?="unsettable"|derived?="derived")* (containment?="val"|"ref") eGenericType=EGenericTypeReferenceDecl ("[" lowerBound=INT (".." upperBound=SINT)? "]")? ("#" eOpposite=[EReference])? name=ID
		public Group ele0Group() { return c0Group; }

		// (eAnnotations+=EAnnotationDecl)* (resolveProxies?="local"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"|transient?="transient"|unsettable?="unsettable"|derived?="derived")* (containment?="val"|"ref") eGenericType=EGenericTypeReferenceDecl ("[" lowerBound=INT (".." upperBound=SINT)? "]")? ("#" eOpposite=[EReference])?
		public Group ele00Group() { return c00Group; }

		// (eAnnotations+=EAnnotationDecl)* (resolveProxies?="local"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"|transient?="transient"|unsettable?="unsettable"|derived?="derived")* (containment?="val"|"ref") eGenericType=EGenericTypeReferenceDecl ("[" lowerBound=INT (".." upperBound=SINT)? "]")?
		public Group ele000Group() { return c000Group; }

		// (eAnnotations+=EAnnotationDecl)* (resolveProxies?="local"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"|transient?="transient"|unsettable?="unsettable"|derived?="derived")* (containment?="val"|"ref") eGenericType=EGenericTypeReferenceDecl
		public Group ele0000Group() { return c0000Group; }

		// (eAnnotations+=EAnnotationDecl)* (resolveProxies?="local"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"|transient?="transient"|unsettable?="unsettable"|derived?="derived")* (containment?="val"|"ref")
		public Group ele00000Group() { return c00000Group; }

		// (eAnnotations+=EAnnotationDecl)* (resolveProxies?="local"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"|transient?="transient"|unsettable?="unsettable"|derived?="derived")*
		public Group ele000000Group() { return c000000Group; }

		// (eAnnotations+=EAnnotationDecl)*
		public Assignment ele0000000AssignmentEAnnotations() { return c0000000AssignmentEAnnotations; }

		// EAnnotationDecl
		public RuleCall ele00000000ParserRuleCallEAnnotationDecl() { return c00000000ParserRuleCallEAnnotationDecl; }

		// (resolveProxies?="local"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"|transient?="transient"|unsettable?="unsettable"|derived?="derived")*
		public Alternatives ele0000001Alternatives() { return c0000001Alternatives; }

		// resolveProxies?="local"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"|transient?="transient"|unsettable?="unsettable"
		public Alternatives ele00000010Alternatives() { return c00000010Alternatives; }

		// resolveProxies?="local"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"|transient?="transient"
		public Alternatives ele000000100Alternatives() { return c000000100Alternatives; }

		// resolveProxies?="local"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"
		public Alternatives ele0000001000Alternatives() { return c0000001000Alternatives; }

		// resolveProxies?="local"|unique?="bag"|ordered?="random"|changeable?="readonly"
		public Alternatives ele00000010000Alternatives() { return c00000010000Alternatives; }

		// resolveProxies?="local"|unique?="bag"|ordered?="random"
		public Alternatives ele000000100000Alternatives() { return c000000100000Alternatives; }

		// resolveProxies?="local"|unique?="bag"
		public Alternatives ele0000001000000Alternatives() { return c0000001000000Alternatives; }

		// resolveProxies?="local"
		public Assignment ele00000010000000AssignmentResolveProxies() { return c00000010000000AssignmentResolveProxies; }

		// "local"
		public Keyword ele000000100000000KeywordLocal() { return c000000100000000KeywordLocal; }

		// unique?="bag"
		public Assignment ele00000010000001AssignmentUnique() { return c00000010000001AssignmentUnique; }

		// "bag"
		public Keyword ele000000100000010KeywordBag() { return c000000100000010KeywordBag; }

		// ordered?="random"
		public Assignment ele0000001000001AssignmentOrdered() { return c0000001000001AssignmentOrdered; }

		// "random"
		public Keyword ele00000010000010KeywordRandom() { return c00000010000010KeywordRandom; }

		// changeable?="readonly"
		public Assignment ele000000100001AssignmentChangeable() { return c000000100001AssignmentChangeable; }

		// "readonly"
		public Keyword ele0000001000010KeywordReadonly() { return c0000001000010KeywordReadonly; }

		// volatile?="volatile"
		public Assignment ele00000010001AssignmentVolatile() { return c00000010001AssignmentVolatile; }

		// "volatile"
		public Keyword ele000000100010KeywordVolatile() { return c000000100010KeywordVolatile; }

		// transient?="transient"
		public Assignment ele0000001001AssignmentTransient() { return c0000001001AssignmentTransient; }

		// "transient"
		public Keyword ele00000010010KeywordTransient() { return c00000010010KeywordTransient; }

		// unsettable?="unsettable"
		public Assignment ele000000101AssignmentUnsettable() { return c000000101AssignmentUnsettable; }

		// "unsettable"
		public Keyword ele0000001010KeywordUnsettable() { return c0000001010KeywordUnsettable; }

		// derived?="derived"
		public Assignment ele00000011AssignmentDerived() { return c00000011AssignmentDerived; }

		// "derived"
		public Keyword ele000000110KeywordDerived() { return c000000110KeywordDerived; }

		// containment?="val"|"ref"
		public Alternatives ele000001Alternatives() { return c000001Alternatives; }

		// containment?="val"
		public Assignment ele0000010AssignmentContainment() { return c0000010AssignmentContainment; }

		// "val"
		public Keyword ele00000100KeywordVal() { return c00000100KeywordVal; }

		// "ref"
		public Keyword ele0000011KeywordRef() { return c0000011KeywordRef; }

		// eGenericType=EGenericTypeReferenceDecl
		public Assignment ele00001AssignmentEGenericType() { return c00001AssignmentEGenericType; }

		// EGenericTypeReferenceDecl
		public RuleCall ele000010ParserRuleCallEGenericTypeReferenceDecl() { return c000010ParserRuleCallEGenericTypeReferenceDecl; }

		// ("[" lowerBound=INT (".." upperBound=SINT)? "]")?
		public Group ele0001Group() { return c0001Group; }

		// "[" lowerBound=INT (".." upperBound=SINT)?
		public Group ele00010Group() { return c00010Group; }

		// "[" lowerBound=INT
		public Group ele000100Group() { return c000100Group; }

		// "["
		public Keyword ele0001000KeywordLeftSquareBracket() { return c0001000KeywordLeftSquareBracket; }

		// lowerBound=INT
		public Assignment ele0001001AssignmentLowerBound() { return c0001001AssignmentLowerBound; }

		// INT
		public RuleCall ele00010010LexerRuleCallINT() { return c00010010LexerRuleCallINT; }

		// (".." upperBound=SINT)?
		public Group ele000101Group() { return c000101Group; }

		// ".."
		public Keyword ele0001010KeywordFullStopFullStop() { return c0001010KeywordFullStopFullStop; }

		// upperBound=SINT
		public Assignment ele0001011AssignmentUpperBound() { return c0001011AssignmentUpperBound; }

		// SINT
		public RuleCall ele00010110ParserRuleCallSINT() { return c00010110ParserRuleCallSINT; }

		// "]"
		public Keyword ele00011KeywordRightSquareBracket() { return c00011KeywordRightSquareBracket; }

		// ("#" eOpposite=[EReference])?
		public Group ele001Group() { return c001Group; }

		// "#"
		public Keyword ele0010KeywordNumberSign() { return c0010KeywordNumberSign; }

		// eOpposite=[EReference]
		public Assignment ele0011AssignmentEOpposite() { return c0011AssignmentEOpposite; }

		// [EReference]
		public CrossReference ele00110CrossReferenceEStringEReference() { return c00110CrossReferenceEStringEReference; }

		// name=ID
		public Assignment ele01AssignmentName() { return c01AssignmentName; }

		// ID
		public RuleCall ele010LexerRuleCallID() { return c010LexerRuleCallID; }

		// ";"
		public Keyword ele1KeywordSemicolon() { return c1KeywordSemicolon; }
	}

	public class EEnumDeclElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EEnumDecl");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Assignment c00000AssignmentEAnnotations = (Assignment)c0000Group.eContents().get(0);
		private final RuleCall c000000ParserRuleCallEAnnotationDecl = (RuleCall)c00000AssignmentEAnnotations.eContents().get(0);
		private final Keyword c00001KeywordEnum = (Keyword)c0000Group.eContents().get(1);
		private final Assignment c0001AssignmentName = (Assignment)c000Group.eContents().get(1);
		private final RuleCall c00010LexerRuleCallID = (RuleCall)c0001AssignmentName.eContents().get(0);
		private final Keyword c001KeywordLeftCurlyBracket = (Keyword)c00Group.eContents().get(1);
		private final Assignment c01AssignmentELiterals = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010ParserRuleCallEEnumLiteralDecl = (RuleCall)c01AssignmentELiterals.eContents().get(0);
		private final Keyword c1KeywordRightCurlyBracket = (Keyword)cGroup.eContents().get(1);
		
		// EEnumDecl returns EEnum:   (eAnnotations+=EAnnotationDecl)* "enum" name=ID "{" (eLiterals+=EEnumLiteralDecl)+ "}";
		public ParserRule getRule() { return rule; }

		// (eAnnotations+=EAnnotationDecl)* "enum" name=ID "{" (eLiterals+=EEnumLiteralDecl)+ "}"
		public Group eleGroup() { return cGroup; }

		// (eAnnotations+=EAnnotationDecl)* "enum" name=ID "{" (eLiterals+=EEnumLiteralDecl)+
		public Group ele0Group() { return c0Group; }

		// (eAnnotations+=EAnnotationDecl)* "enum" name=ID "{"
		public Group ele00Group() { return c00Group; }

		// (eAnnotations+=EAnnotationDecl)* "enum" name=ID
		public Group ele000Group() { return c000Group; }

		// (eAnnotations+=EAnnotationDecl)* "enum"
		public Group ele0000Group() { return c0000Group; }

		// (eAnnotations+=EAnnotationDecl)*
		public Assignment ele00000AssignmentEAnnotations() { return c00000AssignmentEAnnotations; }

		// EAnnotationDecl
		public RuleCall ele000000ParserRuleCallEAnnotationDecl() { return c000000ParserRuleCallEAnnotationDecl; }

		// "enum"
		public Keyword ele00001KeywordEnum() { return c00001KeywordEnum; }

		// name=ID
		public Assignment ele0001AssignmentName() { return c0001AssignmentName; }

		// ID
		public RuleCall ele00010LexerRuleCallID() { return c00010LexerRuleCallID; }

		// "{"
		public Keyword ele001KeywordLeftCurlyBracket() { return c001KeywordLeftCurlyBracket; }

		// (eLiterals+=EEnumLiteralDecl)+
		public Assignment ele01AssignmentELiterals() { return c01AssignmentELiterals; }

		// EEnumLiteralDecl
		public RuleCall ele010ParserRuleCallEEnumLiteralDecl() { return c010ParserRuleCallEEnumLiteralDecl; }

		// "}"
		public Keyword ele1KeywordRightCurlyBracket() { return c1KeywordRightCurlyBracket; }
	}

	public class EEnumLiteralDeclElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EEnumLiteralDecl");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Assignment c0000AssignmentEAnnotations = (Assignment)c000Group.eContents().get(0);
		private final RuleCall c00000ParserRuleCallEAnnotationDecl = (RuleCall)c0000AssignmentEAnnotations.eContents().get(0);
		private final Assignment c0001AssignmentName = (Assignment)c000Group.eContents().get(1);
		private final RuleCall c00010LexerRuleCallID = (RuleCall)c0001AssignmentName.eContents().get(0);
		private final Group c001Group = (Group)c00Group.eContents().get(1);
		private final Keyword c0010KeywordEqualsSign = (Keyword)c001Group.eContents().get(0);
		private final Assignment c0011AssignmentValue = (Assignment)c001Group.eContents().get(1);
		private final RuleCall c00110LexerRuleCallINT = (RuleCall)c0011AssignmentValue.eContents().get(0);
		private final Assignment c01AssignmentLiteral = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010LexerRuleCallSTRING = (RuleCall)c01AssignmentLiteral.eContents().get(0);
		private final Keyword c1KeywordSemicolon = (Keyword)cGroup.eContents().get(1);
		
		// EEnumLiteralDecl returns EEnumLiteral:   (eAnnotations+=EAnnotationDecl)* name=ID ("=" value=INT)? (literal=STRING)? ";";
		public ParserRule getRule() { return rule; }

		// (eAnnotations+=EAnnotationDecl)* name=ID ("=" value=INT)? (literal=STRING)? ";"
		public Group eleGroup() { return cGroup; }

		// (eAnnotations+=EAnnotationDecl)* name=ID ("=" value=INT)? (literal=STRING)?
		public Group ele0Group() { return c0Group; }

		// (eAnnotations+=EAnnotationDecl)* name=ID ("=" value=INT)?
		public Group ele00Group() { return c00Group; }

		// (eAnnotations+=EAnnotationDecl)* name=ID
		public Group ele000Group() { return c000Group; }

		// (eAnnotations+=EAnnotationDecl)*
		public Assignment ele0000AssignmentEAnnotations() { return c0000AssignmentEAnnotations; }

		// EAnnotationDecl
		public RuleCall ele00000ParserRuleCallEAnnotationDecl() { return c00000ParserRuleCallEAnnotationDecl; }

		// name=ID
		public Assignment ele0001AssignmentName() { return c0001AssignmentName; }

		// ID
		public RuleCall ele00010LexerRuleCallID() { return c00010LexerRuleCallID; }

		// ("=" value=INT)?
		public Group ele001Group() { return c001Group; }

		// "="
		public Keyword ele0010KeywordEqualsSign() { return c0010KeywordEqualsSign; }

		// value=INT
		public Assignment ele0011AssignmentValue() { return c0011AssignmentValue; }

		// INT
		public RuleCall ele00110LexerRuleCallINT() { return c00110LexerRuleCallINT; }

		// (literal=STRING)?
		public Assignment ele01AssignmentLiteral() { return c01AssignmentLiteral; }

		// STRING
		public RuleCall ele010LexerRuleCallSTRING() { return c010LexerRuleCallSTRING; }

		// ";"
		public Keyword ele1KeywordSemicolon() { return c1KeywordSemicolon; }
	}

	public class ETypeParameterDeclElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ETypeParameterDecl");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment c0AssignmentName = (Assignment)cGroup.eContents().get(0);
		private final RuleCall c00LexerRuleCallID = (RuleCall)c0AssignmentName.eContents().get(0);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Keyword c10KeywordExtends = (Keyword)c1Group.eContents().get(0);
		private final Assignment c11AssignmentEBounds = (Assignment)c1Group.eContents().get(1);
		private final RuleCall c110ParserRuleCallEGenericTypeDecl = (RuleCall)c11AssignmentEBounds.eContents().get(0);
		
		// ETypeParameterDecl returns ETypeParameter:   name=ID ("extends" eBounds+=EGenericTypeDecl)?;
		public ParserRule getRule() { return rule; }

		// name=ID ("extends" eBounds+=EGenericTypeDecl)?
		public Group eleGroup() { return cGroup; }

		// name=ID
		public Assignment ele0AssignmentName() { return c0AssignmentName; }

		// ID
		public RuleCall ele00LexerRuleCallID() { return c00LexerRuleCallID; }

		// ("extends" eBounds+=EGenericTypeDecl)?
		public Group ele1Group() { return c1Group; }

		// "extends"
		public Keyword ele10KeywordExtends() { return c10KeywordExtends; }

		// eBounds+=EGenericTypeDecl
		public Assignment ele11AssignmentEBounds() { return c11AssignmentEBounds; }

		// EGenericTypeDecl
		public RuleCall ele110ParserRuleCallEGenericTypeDecl() { return c110ParserRuleCallEGenericTypeDecl; }
	}

	public class EGenericTypeReferenceDeclElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EGenericTypeReferenceDecl");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Group c0Group = (Group)cAlternatives.eContents().get(0);
		private final Assignment c00AssignmentEClassifier = (Assignment)c0Group.eContents().get(0);
		private final CrossReference c000CrossReferenceEStringEClassifier = (CrossReference)c00AssignmentEClassifier.eContents().get(0);
		private final Group c01Group = (Group)c0Group.eContents().get(1);
		private final Group c010Group = (Group)c01Group.eContents().get(0);
		private final Group c0100Group = (Group)c010Group.eContents().get(0);
		private final Keyword c01000KeywordLessThanSign = (Keyword)c0100Group.eContents().get(0);
		private final Assignment c01001AssignmentETypeArguments = (Assignment)c0100Group.eContents().get(1);
		private final RuleCall c010010ParserRuleCallEGenericTypeDecl = (RuleCall)c01001AssignmentETypeArguments.eContents().get(0);
		private final Group c0101Group = (Group)c010Group.eContents().get(1);
		private final Keyword c01010KeywordComma = (Keyword)c0101Group.eContents().get(0);
		private final Assignment c01011AssignmentETypeArguments = (Assignment)c0101Group.eContents().get(1);
		private final RuleCall c010110ParserRuleCallEGenericTypeDecl = (RuleCall)c01011AssignmentETypeArguments.eContents().get(0);
		private final Keyword c011KeywordGreaterThanSign = (Keyword)c01Group.eContents().get(1);
		private final Group c1Group = (Group)cAlternatives.eContents().get(1);
		private final Keyword c10KeywordNumberSign = (Keyword)c1Group.eContents().get(0);
		private final Assignment c11AssignmentETypeParameter = (Assignment)c1Group.eContents().get(1);
		private final CrossReference c110CrossReferenceEStringETypeParameter = (CrossReference)c11AssignmentETypeParameter.eContents().get(0);
		
		// EGenericTypeReferenceDecl returns EGenericType:   eClassifier=[EClassifier] ("<" eTypeArguments+=EGenericTypeDecl ("," eTypeArguments+=EGenericTypeDecl)* ">")?|"#" eTypeParameter=[ETypeParameter];
		public ParserRule getRule() { return rule; }

		// eClassifier=[EClassifier] ("<" eTypeArguments+=EGenericTypeDecl ("," eTypeArguments+=EGenericTypeDecl)* ">")?|"#" eTypeParameter=[ETypeParameter]
		public Alternatives eleAlternatives() { return cAlternatives; }

		// eClassifier=[EClassifier] ("<" eTypeArguments+=EGenericTypeDecl ("," eTypeArguments+=EGenericTypeDecl)* ">")?
		public Group ele0Group() { return c0Group; }

		// eClassifier=[EClassifier]
		public Assignment ele00AssignmentEClassifier() { return c00AssignmentEClassifier; }

		// [EClassifier]
		public CrossReference ele000CrossReferenceEStringEClassifier() { return c000CrossReferenceEStringEClassifier; }

		// ("<" eTypeArguments+=EGenericTypeDecl ("," eTypeArguments+=EGenericTypeDecl)* ">")?
		public Group ele01Group() { return c01Group; }

		// "<" eTypeArguments+=EGenericTypeDecl ("," eTypeArguments+=EGenericTypeDecl)*
		public Group ele010Group() { return c010Group; }

		// "<" eTypeArguments+=EGenericTypeDecl
		public Group ele0100Group() { return c0100Group; }

		// "<"
		public Keyword ele01000KeywordLessThanSign() { return c01000KeywordLessThanSign; }

		// eTypeArguments+=EGenericTypeDecl
		public Assignment ele01001AssignmentETypeArguments() { return c01001AssignmentETypeArguments; }

		// EGenericTypeDecl
		public RuleCall ele010010ParserRuleCallEGenericTypeDecl() { return c010010ParserRuleCallEGenericTypeDecl; }

		// ("," eTypeArguments+=EGenericTypeDecl)*
		public Group ele0101Group() { return c0101Group; }

		// ","
		public Keyword ele01010KeywordComma() { return c01010KeywordComma; }

		// eTypeArguments+=EGenericTypeDecl
		public Assignment ele01011AssignmentETypeArguments() { return c01011AssignmentETypeArguments; }

		// EGenericTypeDecl
		public RuleCall ele010110ParserRuleCallEGenericTypeDecl() { return c010110ParserRuleCallEGenericTypeDecl; }

		// ">"
		public Keyword ele011KeywordGreaterThanSign() { return c011KeywordGreaterThanSign; }

		// "#" eTypeParameter=[ETypeParameter]
		public Group ele1Group() { return c1Group; }

		// "#"
		public Keyword ele10KeywordNumberSign() { return c10KeywordNumberSign; }

		// eTypeParameter=[ETypeParameter]
		public Assignment ele11AssignmentETypeParameter() { return c11AssignmentETypeParameter; }

		// [ETypeParameter]
		public CrossReference ele110CrossReferenceEStringETypeParameter() { return c110CrossReferenceEStringETypeParameter; }
	}

	public class EGenericTypeDeclElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EGenericTypeDecl");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Alternatives c0Alternatives = (Alternatives)cAlternatives.eContents().get(0);
		private final Group c00Group = (Group)c0Alternatives.eContents().get(0);
		private final Assignment c000AssignmentEClassifier = (Assignment)c00Group.eContents().get(0);
		private final CrossReference c0000CrossReferenceEStringEClassifier = (CrossReference)c000AssignmentEClassifier.eContents().get(0);
		private final Group c001Group = (Group)c00Group.eContents().get(1);
		private final Group c0010Group = (Group)c001Group.eContents().get(0);
		private final Group c00100Group = (Group)c0010Group.eContents().get(0);
		private final Keyword c001000KeywordLessThanSign = (Keyword)c00100Group.eContents().get(0);
		private final Assignment c001001AssignmentETypeArguments = (Assignment)c00100Group.eContents().get(1);
		private final RuleCall c0010010ParserRuleCallEGenericTypeDecl = (RuleCall)c001001AssignmentETypeArguments.eContents().get(0);
		private final Group c00101Group = (Group)c0010Group.eContents().get(1);
		private final Keyword c001010KeywordComma = (Keyword)c00101Group.eContents().get(0);
		private final Assignment c001011AssignmentETypeArguments = (Assignment)c00101Group.eContents().get(1);
		private final RuleCall c0010110ParserRuleCallEGenericTypeDecl = (RuleCall)c001011AssignmentETypeArguments.eContents().get(0);
		private final Keyword c0011KeywordGreaterThanSign = (Keyword)c001Group.eContents().get(1);
		private final Group c01Group = (Group)c0Alternatives.eContents().get(1);
		private final Keyword c010KeywordNumberSign = (Keyword)c01Group.eContents().get(0);
		private final Assignment c011AssignmentETypeParameter = (Assignment)c01Group.eContents().get(1);
		private final CrossReference c0110CrossReferenceEStringETypeParameter = (CrossReference)c011AssignmentETypeParameter.eContents().get(0);
		private final Group c1Group = (Group)cAlternatives.eContents().get(1);
		private final Keyword c10KeywordQuestionMark = (Keyword)c1Group.eContents().get(0);
		private final Alternatives c11Alternatives = (Alternatives)c1Group.eContents().get(1);
		private final Group c110Group = (Group)c11Alternatives.eContents().get(0);
		private final Keyword c1100KeywordExtends = (Keyword)c110Group.eContents().get(0);
		private final Assignment c1101AssignmentEUpperBound = (Assignment)c110Group.eContents().get(1);
		private final RuleCall c11010ParserRuleCallEGenericTypeDecl = (RuleCall)c1101AssignmentEUpperBound.eContents().get(0);
		private final Group c111Group = (Group)c11Alternatives.eContents().get(1);
		private final Keyword c1110KeywordSuper = (Keyword)c111Group.eContents().get(0);
		private final Assignment c1111AssignmentELowerBound = (Assignment)c111Group.eContents().get(1);
		private final RuleCall c11110ParserRuleCallEGenericTypeDecl = (RuleCall)c1111AssignmentELowerBound.eContents().get(0);
		
		// EGenericTypeDecl returns EGenericType:   eClassifier=[EClassifier] ("<" eTypeArguments+=EGenericTypeDecl ("," eTypeArguments+=EGenericTypeDecl)* ">")?|"#" eTypeParameter=[ETypeParameter]|"?" ("extends" eUpperBound=EGenericTypeDecl|"super" eLowerBound=EGenericTypeDecl);
		public ParserRule getRule() { return rule; }

		// eClassifier=[EClassifier] ("<" eTypeArguments+=EGenericTypeDecl ("," eTypeArguments+=EGenericTypeDecl)* ">")?|"#" eTypeParameter=[ETypeParameter]|"?" ("extends" eUpperBound=EGenericTypeDecl|"super" eLowerBound=EGenericTypeDecl)
		public Alternatives eleAlternatives() { return cAlternatives; }

		// eClassifier=[EClassifier] ("<" eTypeArguments+=EGenericTypeDecl ("," eTypeArguments+=EGenericTypeDecl)* ">")?|"#" eTypeParameter=[ETypeParameter]
		public Alternatives ele0Alternatives() { return c0Alternatives; }

		// eClassifier=[EClassifier] ("<" eTypeArguments+=EGenericTypeDecl ("," eTypeArguments+=EGenericTypeDecl)* ">")?
		public Group ele00Group() { return c00Group; }

		// eClassifier=[EClassifier]
		public Assignment ele000AssignmentEClassifier() { return c000AssignmentEClassifier; }

		// [EClassifier]
		public CrossReference ele0000CrossReferenceEStringEClassifier() { return c0000CrossReferenceEStringEClassifier; }

		// ("<" eTypeArguments+=EGenericTypeDecl ("," eTypeArguments+=EGenericTypeDecl)* ">")?
		public Group ele001Group() { return c001Group; }

		// "<" eTypeArguments+=EGenericTypeDecl ("," eTypeArguments+=EGenericTypeDecl)*
		public Group ele0010Group() { return c0010Group; }

		// "<" eTypeArguments+=EGenericTypeDecl
		public Group ele00100Group() { return c00100Group; }

		// "<"
		public Keyword ele001000KeywordLessThanSign() { return c001000KeywordLessThanSign; }

		// eTypeArguments+=EGenericTypeDecl
		public Assignment ele001001AssignmentETypeArguments() { return c001001AssignmentETypeArguments; }

		// EGenericTypeDecl
		public RuleCall ele0010010ParserRuleCallEGenericTypeDecl() { return c0010010ParserRuleCallEGenericTypeDecl; }

		// ("," eTypeArguments+=EGenericTypeDecl)*
		public Group ele00101Group() { return c00101Group; }

		// ","
		public Keyword ele001010KeywordComma() { return c001010KeywordComma; }

		// eTypeArguments+=EGenericTypeDecl
		public Assignment ele001011AssignmentETypeArguments() { return c001011AssignmentETypeArguments; }

		// EGenericTypeDecl
		public RuleCall ele0010110ParserRuleCallEGenericTypeDecl() { return c0010110ParserRuleCallEGenericTypeDecl; }

		// ">"
		public Keyword ele0011KeywordGreaterThanSign() { return c0011KeywordGreaterThanSign; }

		// "#" eTypeParameter=[ETypeParameter]
		public Group ele01Group() { return c01Group; }

		// "#"
		public Keyword ele010KeywordNumberSign() { return c010KeywordNumberSign; }

		// eTypeParameter=[ETypeParameter]
		public Assignment ele011AssignmentETypeParameter() { return c011AssignmentETypeParameter; }

		// [ETypeParameter]
		public CrossReference ele0110CrossReferenceEStringETypeParameter() { return c0110CrossReferenceEStringETypeParameter; }

		// "?" ("extends" eUpperBound=EGenericTypeDecl|"super" eLowerBound=EGenericTypeDecl)
		public Group ele1Group() { return c1Group; }

		// "?"
		public Keyword ele10KeywordQuestionMark() { return c10KeywordQuestionMark; }

		// "extends" eUpperBound=EGenericTypeDecl|"super" eLowerBound=EGenericTypeDecl
		public Alternatives ele11Alternatives() { return c11Alternatives; }

		// "extends" eUpperBound=EGenericTypeDecl
		public Group ele110Group() { return c110Group; }

		// "extends"
		public Keyword ele1100KeywordExtends() { return c1100KeywordExtends; }

		// eUpperBound=EGenericTypeDecl
		public Assignment ele1101AssignmentEUpperBound() { return c1101AssignmentEUpperBound; }

		// EGenericTypeDecl
		public RuleCall ele11010ParserRuleCallEGenericTypeDecl() { return c11010ParserRuleCallEGenericTypeDecl; }

		// "super" eLowerBound=EGenericTypeDecl
		public Group ele111Group() { return c111Group; }

		// "super"
		public Keyword ele1110KeywordSuper() { return c1110KeywordSuper; }

		// eLowerBound=EGenericTypeDecl
		public Assignment ele1111AssignmentELowerBound() { return c1111AssignmentELowerBound; }

		// EGenericTypeDecl
		public RuleCall ele11110ParserRuleCallEGenericTypeDecl() { return c11110ParserRuleCallEGenericTypeDecl; }
	}

	public class EOperationDeclElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EOperationDecl");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Group c00000Group = (Group)c0000Group.eContents().get(0);
		private final Group c000000Group = (Group)c00000Group.eContents().get(0);
		private final Group c0000000Group = (Group)c000000Group.eContents().get(0);
		private final Group c00000000Group = (Group)c0000000Group.eContents().get(0);
		private final Group c000000000Group = (Group)c00000000Group.eContents().get(0);
		private final Assignment c0000000000AssignmentEAnnotations = (Assignment)c000000000Group.eContents().get(0);
		private final RuleCall c00000000000ParserRuleCallEAnnotationDecl = (RuleCall)c0000000000AssignmentEAnnotations.eContents().get(0);
		private final Alternatives c0000000001Alternatives = (Alternatives)c000000000Group.eContents().get(1);
		private final Assignment c00000000010AssignmentUnique = (Assignment)c0000000001Alternatives.eContents().get(0);
		private final Keyword c000000000100KeywordBag = (Keyword)c00000000010AssignmentUnique.eContents().get(0);
		private final Assignment c00000000011AssignmentOrdered = (Assignment)c0000000001Alternatives.eContents().get(1);
		private final Keyword c000000000110KeywordRandom = (Keyword)c00000000011AssignmentOrdered.eContents().get(0);
		private final Keyword c000000001KeywordOp = (Keyword)c00000000Group.eContents().get(1);
		private final Alternatives c00000001Alternatives = (Alternatives)c0000000Group.eContents().get(1);
		private final Assignment c000000010AssignmentEGenericType = (Assignment)c00000001Alternatives.eContents().get(0);
		private final RuleCall c0000000100ParserRuleCallEGenericTypeReferenceDecl = (RuleCall)c000000010AssignmentEGenericType.eContents().get(0);
		private final Keyword c000000011KeywordVoid = (Keyword)c00000001Alternatives.eContents().get(1);
		private final Assignment c0000001AssignmentName = (Assignment)c000000Group.eContents().get(1);
		private final RuleCall c00000010LexerRuleCallID = (RuleCall)c0000001AssignmentName.eContents().get(0);
		private final Group c000001Group = (Group)c00000Group.eContents().get(1);
		private final Group c0000010Group = (Group)c000001Group.eContents().get(0);
		private final Group c00000100Group = (Group)c0000010Group.eContents().get(0);
		private final Keyword c000001000KeywordLessThanSign = (Keyword)c00000100Group.eContents().get(0);
		private final Assignment c000001001AssignmentETypeParameters = (Assignment)c00000100Group.eContents().get(1);
		private final RuleCall c0000010010ParserRuleCallETypeParameterDecl = (RuleCall)c000001001AssignmentETypeParameters.eContents().get(0);
		private final Group c00000101Group = (Group)c0000010Group.eContents().get(1);
		private final Keyword c000001010KeywordComma = (Keyword)c00000101Group.eContents().get(0);
		private final Assignment c000001011AssignmentETypeParameters = (Assignment)c00000101Group.eContents().get(1);
		private final RuleCall c0000010110ParserRuleCallETypeParameterDecl = (RuleCall)c000001011AssignmentETypeParameters.eContents().get(0);
		private final Keyword c0000011KeywordGreaterThanSign = (Keyword)c000001Group.eContents().get(1);
		private final Keyword c00001KeywordLeftParenthesis = (Keyword)c0000Group.eContents().get(1);
		private final Group c0001Group = (Group)c000Group.eContents().get(1);
		private final Assignment c00010AssignmentEParameters = (Assignment)c0001Group.eContents().get(0);
		private final RuleCall c000100ParserRuleCallEParameterDecl = (RuleCall)c00010AssignmentEParameters.eContents().get(0);
		private final Group c00011Group = (Group)c0001Group.eContents().get(1);
		private final Keyword c000110KeywordComma = (Keyword)c00011Group.eContents().get(0);
		private final Assignment c000111AssignmentEParameters = (Assignment)c00011Group.eContents().get(1);
		private final RuleCall c0001110ParserRuleCallEParameterDecl = (RuleCall)c000111AssignmentEParameters.eContents().get(0);
		private final Keyword c001KeywordRightParenthesis = (Keyword)c00Group.eContents().get(1);
		private final Group c01Group = (Group)c0Group.eContents().get(1);
		private final Group c010Group = (Group)c01Group.eContents().get(0);
		private final Keyword c0100KeywordThrows = (Keyword)c010Group.eContents().get(0);
		private final Assignment c0101AssignmentEGenericExceptions = (Assignment)c010Group.eContents().get(1);
		private final RuleCall c01010ParserRuleCallEGenericTypeReferenceDecl = (RuleCall)c0101AssignmentEGenericExceptions.eContents().get(0);
		private final Group c011Group = (Group)c01Group.eContents().get(1);
		private final Keyword c0110KeywordComma = (Keyword)c011Group.eContents().get(0);
		private final Assignment c0111AssignmentEGenericExceptions = (Assignment)c011Group.eContents().get(1);
		private final RuleCall c01110ParserRuleCallEGenericTypeReferenceDecl = (RuleCall)c0111AssignmentEGenericExceptions.eContents().get(0);
		private final Keyword c1KeywordSemicolon = (Keyword)cGroup.eContents().get(1);
		
		// EOperationDecl returns EOperation:   (eAnnotations+=EAnnotationDecl)* (unique?="bag"|ordered?="random")* "op" (eGenericType=EGenericTypeReferenceDecl|"void") name=ID ("<" eTypeParameters+=ETypeParameterDecl ("," eTypeParameters+=ETypeParameterDecl)* ">")? "(" (eParameters+=EParameterDecl ("," eParameters+=EParameterDecl)*)? ")" ("throws" eGenericExceptions+=EGenericTypeReferenceDecl ("," eGenericExceptions+=EGenericTypeReferenceDecl)*)? ";";
		public ParserRule getRule() { return rule; }

		// (eAnnotations+=EAnnotationDecl)* (unique?="bag"|ordered?="random")* "op" (eGenericType=EGenericTypeReferenceDecl|"void") name=ID ("<" eTypeParameters+=ETypeParameterDecl ("," eTypeParameters+=ETypeParameterDecl)* ">")? "(" (eParameters+=EParameterDecl ("," eParameters+=EParameterDecl)*)? ")" ("throws" eGenericExceptions+=EGenericTypeReferenceDecl ("," eGenericExceptions+=EGenericTypeReferenceDecl)*)? ";"
		public Group eleGroup() { return cGroup; }

		// (eAnnotations+=EAnnotationDecl)* (unique?="bag"|ordered?="random")* "op" (eGenericType=EGenericTypeReferenceDecl|"void") name=ID ("<" eTypeParameters+=ETypeParameterDecl ("," eTypeParameters+=ETypeParameterDecl)* ">")? "(" (eParameters+=EParameterDecl ("," eParameters+=EParameterDecl)*)? ")" ("throws" eGenericExceptions+=EGenericTypeReferenceDecl ("," eGenericExceptions+=EGenericTypeReferenceDecl)*)?
		public Group ele0Group() { return c0Group; }

		// (eAnnotations+=EAnnotationDecl)* (unique?="bag"|ordered?="random")* "op" (eGenericType=EGenericTypeReferenceDecl|"void") name=ID ("<" eTypeParameters+=ETypeParameterDecl ("," eTypeParameters+=ETypeParameterDecl)* ">")? "(" (eParameters+=EParameterDecl ("," eParameters+=EParameterDecl)*)? ")"
		public Group ele00Group() { return c00Group; }

		// (eAnnotations+=EAnnotationDecl)* (unique?="bag"|ordered?="random")* "op" (eGenericType=EGenericTypeReferenceDecl|"void") name=ID ("<" eTypeParameters+=ETypeParameterDecl ("," eTypeParameters+=ETypeParameterDecl)* ">")? "(" (eParameters+=EParameterDecl ("," eParameters+=EParameterDecl)*)?
		public Group ele000Group() { return c000Group; }

		// (eAnnotations+=EAnnotationDecl)* (unique?="bag"|ordered?="random")* "op" (eGenericType=EGenericTypeReferenceDecl|"void") name=ID ("<" eTypeParameters+=ETypeParameterDecl ("," eTypeParameters+=ETypeParameterDecl)* ">")? "("
		public Group ele0000Group() { return c0000Group; }

		// (eAnnotations+=EAnnotationDecl)* (unique?="bag"|ordered?="random")* "op" (eGenericType=EGenericTypeReferenceDecl|"void") name=ID ("<" eTypeParameters+=ETypeParameterDecl ("," eTypeParameters+=ETypeParameterDecl)* ">")?
		public Group ele00000Group() { return c00000Group; }

		// (eAnnotations+=EAnnotationDecl)* (unique?="bag"|ordered?="random")* "op" (eGenericType=EGenericTypeReferenceDecl|"void") name=ID
		public Group ele000000Group() { return c000000Group; }

		// (eAnnotations+=EAnnotationDecl)* (unique?="bag"|ordered?="random")* "op" (eGenericType=EGenericTypeReferenceDecl|"void")
		public Group ele0000000Group() { return c0000000Group; }

		// (eAnnotations+=EAnnotationDecl)* (unique?="bag"|ordered?="random")* "op"
		public Group ele00000000Group() { return c00000000Group; }

		// (eAnnotations+=EAnnotationDecl)* (unique?="bag"|ordered?="random")*
		public Group ele000000000Group() { return c000000000Group; }

		// (eAnnotations+=EAnnotationDecl)*
		public Assignment ele0000000000AssignmentEAnnotations() { return c0000000000AssignmentEAnnotations; }

		// EAnnotationDecl
		public RuleCall ele00000000000ParserRuleCallEAnnotationDecl() { return c00000000000ParserRuleCallEAnnotationDecl; }

		// (unique?="bag"|ordered?="random")*
		public Alternatives ele0000000001Alternatives() { return c0000000001Alternatives; }

		// unique?="bag"
		public Assignment ele00000000010AssignmentUnique() { return c00000000010AssignmentUnique; }

		// "bag"
		public Keyword ele000000000100KeywordBag() { return c000000000100KeywordBag; }

		// ordered?="random"
		public Assignment ele00000000011AssignmentOrdered() { return c00000000011AssignmentOrdered; }

		// "random"
		public Keyword ele000000000110KeywordRandom() { return c000000000110KeywordRandom; }

		// "op"
		public Keyword ele000000001KeywordOp() { return c000000001KeywordOp; }

		// eGenericType=EGenericTypeReferenceDecl|"void"
		public Alternatives ele00000001Alternatives() { return c00000001Alternatives; }

		// eGenericType=EGenericTypeReferenceDecl
		public Assignment ele000000010AssignmentEGenericType() { return c000000010AssignmentEGenericType; }

		// EGenericTypeReferenceDecl
		public RuleCall ele0000000100ParserRuleCallEGenericTypeReferenceDecl() { return c0000000100ParserRuleCallEGenericTypeReferenceDecl; }

		// "void"
		public Keyword ele000000011KeywordVoid() { return c000000011KeywordVoid; }

		// name=ID
		public Assignment ele0000001AssignmentName() { return c0000001AssignmentName; }

		// ID
		public RuleCall ele00000010LexerRuleCallID() { return c00000010LexerRuleCallID; }

		// ("<" eTypeParameters+=ETypeParameterDecl ("," eTypeParameters+=ETypeParameterDecl)* ">")?
		public Group ele000001Group() { return c000001Group; }

		// "<" eTypeParameters+=ETypeParameterDecl ("," eTypeParameters+=ETypeParameterDecl)*
		public Group ele0000010Group() { return c0000010Group; }

		// "<" eTypeParameters+=ETypeParameterDecl
		public Group ele00000100Group() { return c00000100Group; }

		// "<"
		public Keyword ele000001000KeywordLessThanSign() { return c000001000KeywordLessThanSign; }

		// eTypeParameters+=ETypeParameterDecl
		public Assignment ele000001001AssignmentETypeParameters() { return c000001001AssignmentETypeParameters; }

		// ETypeParameterDecl
		public RuleCall ele0000010010ParserRuleCallETypeParameterDecl() { return c0000010010ParserRuleCallETypeParameterDecl; }

		// ("," eTypeParameters+=ETypeParameterDecl)*
		public Group ele00000101Group() { return c00000101Group; }

		// ","
		public Keyword ele000001010KeywordComma() { return c000001010KeywordComma; }

		// eTypeParameters+=ETypeParameterDecl
		public Assignment ele000001011AssignmentETypeParameters() { return c000001011AssignmentETypeParameters; }

		// ETypeParameterDecl
		public RuleCall ele0000010110ParserRuleCallETypeParameterDecl() { return c0000010110ParserRuleCallETypeParameterDecl; }

		// ">"
		public Keyword ele0000011KeywordGreaterThanSign() { return c0000011KeywordGreaterThanSign; }

		// "("
		public Keyword ele00001KeywordLeftParenthesis() { return c00001KeywordLeftParenthesis; }

		// (eParameters+=EParameterDecl ("," eParameters+=EParameterDecl)*)?
		public Group ele0001Group() { return c0001Group; }

		// eParameters+=EParameterDecl
		public Assignment ele00010AssignmentEParameters() { return c00010AssignmentEParameters; }

		// EParameterDecl
		public RuleCall ele000100ParserRuleCallEParameterDecl() { return c000100ParserRuleCallEParameterDecl; }

		// ("," eParameters+=EParameterDecl)*
		public Group ele00011Group() { return c00011Group; }

		// ","
		public Keyword ele000110KeywordComma() { return c000110KeywordComma; }

		// eParameters+=EParameterDecl
		public Assignment ele000111AssignmentEParameters() { return c000111AssignmentEParameters; }

		// EParameterDecl
		public RuleCall ele0001110ParserRuleCallEParameterDecl() { return c0001110ParserRuleCallEParameterDecl; }

		// ")"
		public Keyword ele001KeywordRightParenthesis() { return c001KeywordRightParenthesis; }

		// ("throws" eGenericExceptions+=EGenericTypeReferenceDecl ("," eGenericExceptions+=EGenericTypeReferenceDecl)*)?
		public Group ele01Group() { return c01Group; }

		// "throws" eGenericExceptions+=EGenericTypeReferenceDecl
		public Group ele010Group() { return c010Group; }

		// "throws"
		public Keyword ele0100KeywordThrows() { return c0100KeywordThrows; }

		// eGenericExceptions+=EGenericTypeReferenceDecl
		public Assignment ele0101AssignmentEGenericExceptions() { return c0101AssignmentEGenericExceptions; }

		// EGenericTypeReferenceDecl
		public RuleCall ele01010ParserRuleCallEGenericTypeReferenceDecl() { return c01010ParserRuleCallEGenericTypeReferenceDecl; }

		// ("," eGenericExceptions+=EGenericTypeReferenceDecl)*
		public Group ele011Group() { return c011Group; }

		// ","
		public Keyword ele0110KeywordComma() { return c0110KeywordComma; }

		// eGenericExceptions+=EGenericTypeReferenceDecl
		public Assignment ele0111AssignmentEGenericExceptions() { return c0111AssignmentEGenericExceptions; }

		// EGenericTypeReferenceDecl
		public RuleCall ele01110ParserRuleCallEGenericTypeReferenceDecl() { return c01110ParserRuleCallEGenericTypeReferenceDecl; }

		// ";"
		public Keyword ele1KeywordSemicolon() { return c1KeywordSemicolon; }
	}

	public class EParameterDeclElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EParameterDecl");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Assignment c00AssignmentEAnnotations = (Assignment)c0Group.eContents().get(0);
		private final RuleCall c000ParserRuleCallEAnnotationDecl = (RuleCall)c00AssignmentEAnnotations.eContents().get(0);
		private final Assignment c01AssignmentEGenericType = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010ParserRuleCallEGenericTypeReferenceDecl = (RuleCall)c01AssignmentEGenericType.eContents().get(0);
		private final Assignment c1AssignmentName = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallID = (RuleCall)c1AssignmentName.eContents().get(0);
		
		// EParameterDecl returns EParameter:   (eAnnotations+=EAnnotationDecl)* eGenericType=EGenericTypeReferenceDecl name=ID;
		public ParserRule getRule() { return rule; }

		// (eAnnotations+=EAnnotationDecl)* eGenericType=EGenericTypeReferenceDecl name=ID
		public Group eleGroup() { return cGroup; }

		// (eAnnotations+=EAnnotationDecl)* eGenericType=EGenericTypeReferenceDecl
		public Group ele0Group() { return c0Group; }

		// (eAnnotations+=EAnnotationDecl)*
		public Assignment ele00AssignmentEAnnotations() { return c00AssignmentEAnnotations; }

		// EAnnotationDecl
		public RuleCall ele000ParserRuleCallEAnnotationDecl() { return c000ParserRuleCallEAnnotationDecl; }

		// eGenericType=EGenericTypeReferenceDecl
		public Assignment ele01AssignmentEGenericType() { return c01AssignmentEGenericType; }

		// EGenericTypeReferenceDecl
		public RuleCall ele010ParserRuleCallEGenericTypeReferenceDecl() { return c010ParserRuleCallEGenericTypeReferenceDecl; }

		// name=ID
		public Assignment ele1AssignmentName() { return c1AssignmentName; }

		// ID
		public RuleCall ele10LexerRuleCallID() { return c10LexerRuleCallID; }
	}

	public class MapEntrySuperElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MapEntrySuper");
		private final RuleCall cParserRuleCallMapEntry = (RuleCall)rule.eContents().get(1);
		
		// MapEntrySuper returns EObject:   MapEntry;
		public ParserRule getRule() { return rule; }

		// MapEntry
		public RuleCall eleParserRuleCallMapEntry() { return cParserRuleCallMapEntry; }
	}

	public class MapEntryElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MapEntry");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Assignment c00AssignmentDetailKey = (Assignment)c0Group.eContents().get(0);
		private final RuleCall c000LexerRuleCallID = (RuleCall)c00AssignmentDetailKey.eContents().get(0);
		private final Keyword c01KeywordEqualsSign = (Keyword)c0Group.eContents().get(1);
		private final Assignment c1AssignmentDetailValue = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallSTRING = (RuleCall)c1AssignmentDetailValue.eContents().get(0);
		
		// MapEntry:   detailKey=ID "=" detailValue=STRING;
		public ParserRule getRule() { return rule; }

		// detailKey=ID "=" detailValue=STRING
		public Group eleGroup() { return cGroup; }

		// detailKey=ID "="
		public Group ele0Group() { return c0Group; }

		// detailKey=ID
		public Assignment ele00AssignmentDetailKey() { return c00AssignmentDetailKey; }

		// ID
		public RuleCall ele000LexerRuleCallID() { return c000LexerRuleCallID; }

		// "="
		public Keyword ele01KeywordEqualsSign() { return c01KeywordEqualsSign; }

		// detailValue=STRING
		public Assignment ele1AssignmentDetailValue() { return c1AssignmentDetailValue; }

		// STRING
		public RuleCall ele10LexerRuleCallSTRING() { return c10LexerRuleCallSTRING; }
	}

	public class MultiplicityExprElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "MultiplicityExpr");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Alternatives c0Alternatives = (Alternatives)cAlternatives.eContents().get(0);
		private final Keyword c00KeywordPlusSign = (Keyword)c0Alternatives.eContents().get(0);
		private final Keyword c01KeywordQuestionMark = (Keyword)c0Alternatives.eContents().get(1);
		private final Keyword c1KeywordAsterisk = (Keyword)cAlternatives.eContents().get(1);
		
		// MultiplicityExpr:   "+"|"?"|"*";
		public ParserRule getRule() { return rule; }

		// "+"|"?"|"*"
		public Alternatives eleAlternatives() { return cAlternatives; }

		// "+"|"?"
		public Alternatives ele0Alternatives() { return c0Alternatives; }

		// "+"
		public Keyword ele00KeywordPlusSign() { return c00KeywordPlusSign; }

		// "?"
		public Keyword ele01KeywordQuestionMark() { return c01KeywordQuestionMark; }

		// "*"
		public Keyword ele1KeywordAsterisk() { return c1KeywordAsterisk; }
	}

	public class QIDElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "QID");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall c0LexerRuleCallID = (RuleCall)cGroup.eContents().get(0);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Alternatives c10Alternatives = (Alternatives)c1Group.eContents().get(0);
		private final Keyword c100KeywordFullStop = (Keyword)c10Alternatives.eContents().get(0);
		private final Keyword c101Keyword$ = (Keyword)c10Alternatives.eContents().get(1);
		private final RuleCall c11LexerRuleCallID = (RuleCall)c1Group.eContents().get(1);
		
		// QID returns EString:   ID (("."|"$") ID)*;
		public ParserRule getRule() { return rule; }

		// ID (("."|"$") ID)*
		public Group eleGroup() { return cGroup; }

		// ID
		public RuleCall ele0LexerRuleCallID() { return c0LexerRuleCallID; }

		// (("."|"$") ID)*
		public Group ele1Group() { return c1Group; }

		// "."|"$"
		public Alternatives ele10Alternatives() { return c10Alternatives; }

		// "."
		public Keyword ele100KeywordFullStop() { return c100KeywordFullStop; }

		// "$"
		public Keyword ele101Keyword$() { return c101Keyword$; }

		// ID
		public RuleCall ele11LexerRuleCallID() { return c11LexerRuleCallID; }
	}

	public class STRING_OR_QIDElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "STRING_OR_QID");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c0LexerRuleCallSTRING = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall c1ParserRuleCallQID = (RuleCall)cAlternatives.eContents().get(1);
		
		// STRING_OR_QID returns EString:   STRING|QID;
		public ParserRule getRule() { return rule; }

		// STRING|QID
		public Alternatives eleAlternatives() { return cAlternatives; }

		// STRING
		public RuleCall ele0LexerRuleCallSTRING() { return c0LexerRuleCallSTRING; }

		// QID
		public RuleCall ele1ParserRuleCallQID() { return c1ParserRuleCallQID; }
	}

	public class SINTElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SINT");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordHyphenMinus = (Keyword)cGroup.eContents().get(0);
		private final RuleCall c1LexerRuleCallINT = (RuleCall)cGroup.eContents().get(1);
		
		// SINT returns EInt:   "-"? INT;
		public ParserRule getRule() { return rule; }

		// "-"? INT
		public Group eleGroup() { return cGroup; }

		// "-"?
		public Keyword ele0KeywordHyphenMinus() { return c0KeywordHyphenMinus; }

		// INT
		public RuleCall ele1LexerRuleCallINT() { return c1LexerRuleCallINT; }
	}
	
	public final static EcoreDslGrammarAccess INSTANCE = new EcoreDslGrammarAccess();

	private static final String ECOREDSL_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/example/EcoreDsl.xmi";
	private static Grammar GRAMMAR = null;
	private static EcoreDslElements pEcoreDsl;
	private static ImportStatementDeclElements pImportStatementDecl;
	private static EPackageDeclElements pEPackageDecl;
	private static SubEPackageDeclElements pSubEPackageDecl;
	private static EClassifierDeclElements pEClassifierDecl;
	private static EDataTypeDeclElements pEDataTypeDecl;
	private static EAnnotationDeclElements pEAnnotationDecl;
	private static EClassDeclElements pEClassDecl;
	private static EStructuralFeatureDeclElements pEStructuralFeatureDecl;
	private static EAttributeDeclElements pEAttributeDecl;
	private static EReferenceDeclElements pEReferenceDecl;
	private static EEnumDeclElements pEEnumDecl;
	private static EEnumLiteralDeclElements pEEnumLiteralDecl;
	private static ETypeParameterDeclElements pETypeParameterDecl;
	private static EGenericTypeReferenceDeclElements pEGenericTypeReferenceDecl;
	private static EGenericTypeDeclElements pEGenericTypeDecl;
	private static EOperationDeclElements pEOperationDecl;
	private static EParameterDeclElements pEParameterDecl;
	private static MapEntrySuperElements pMapEntrySuper;
	private static MapEntryElements pMapEntry;
	private static MultiplicityExprElements pMultiplicityExpr;
	private static QIDElements pQID;
	private static STRING_OR_QIDElements pSTRING_OR_QID;
	private static SINTElements pSINT;
	private static LexerRule lID;
	private static LexerRule lINT;
	private static LexerRule lSTRING;
	private static LexerRule lML_COMMENT;
	private static LexerRule lSL_COMMENT;
	private static LexerRule lWS;
	private static LexerRule lANY_OTHER;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(EcoreDslGrammarAccess.class.getClassLoader(),ECOREDSL_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}

	
	// EcoreDsl:   (imports+=ImportStatementDecl)* package=EPackageDecl;
	public EcoreDslElements prEcoreDsl() {
		return (pEcoreDsl != null) ? pEcoreDsl : (pEcoreDsl = new EcoreDslElements());
	} 

	// ImportStatementDecl:   "import" (alias=ID "=")? importURI=STRING ";";
	public ImportStatementDeclElements prImportStatementDecl() {
		return (pImportStatementDecl != null) ? pImportStatementDecl : (pImportStatementDecl = new ImportStatementDeclElements());
	} 

	// EPackageDecl returns EPackage:   (eAnnotations+=EAnnotationDecl)* "package" name=QID "nsURI" "=" nsURI=STRING "nsPrefix" "=" nsPrefix=QID "{" (eSubpackages+=SubEPackageDecl|eClassifiers+=EClassifierDecl)* "}";
	public EPackageDeclElements prEPackageDecl() {
		return (pEPackageDecl != null) ? pEPackageDecl : (pEPackageDecl = new EPackageDeclElements());
	} 

	// SubEPackageDecl returns EPackage:   (eAnnotations+=EAnnotationDecl)* "package" name=ID "{" (eSubpackages+=SubEPackageDecl|eClassifiers+=EClassifierDecl)* "}";
	public SubEPackageDeclElements prSubEPackageDecl() {
		return (pSubEPackageDecl != null) ? pSubEPackageDecl : (pSubEPackageDecl = new SubEPackageDeclElements());
	} 

	// EClassifierDecl returns EClassifier:   EClassDecl|EDataTypeDecl;
	public EClassifierDeclElements prEClassifierDecl() {
		return (pEClassifierDecl != null) ? pEClassifierDecl : (pEClassifierDecl = new EClassifierDeclElements());
	} 

	// EDataTypeDecl returns EDataType:   (eAnnotations+=EAnnotationDecl)* (serializable?="!serializable")? ("datatype" name=ID ":" instanceClassName=STRING_OR_QID ";")|EEnumDecl;
	public EDataTypeDeclElements prEDataTypeDecl() {
		return (pEDataTypeDecl != null) ? pEDataTypeDecl : (pEDataTypeDecl = new EDataTypeDeclElements());
	} 

	// EAnnotationDecl returns EAnnotation:   "@" source=STRING (eModelElement=[EModelElement])? "(" contents+=MapEntrySuper ("," contents+=MapEntrySuper)* ")";
	public EAnnotationDeclElements prEAnnotationDecl() {
		return (pEAnnotationDecl != null) ? pEAnnotationDecl : (pEAnnotationDecl = new EAnnotationDeclElements());
	} 

	// EClassDecl returns EClass:   (eAnnotations+=EAnnotationDecl)* (abstract?="abstract")? (interface?="interface"|"class") name=ID ("<" eTypeParameters+=ETypeParameterDecl ("," eTypeParameters+=ETypeParameterDecl)* ">")? ("extends" eGenericSuperTypes+=EGenericTypeReferenceDecl ("," eGenericSuperTypes+=EGenericTypeReferenceDecl)*)? (":" instanceClassName=STRING_OR_QID)? "{" (eStructuralFeatures+=EStructuralFeatureDecl|eOperations+=EOperationDecl)* "}";
	public EClassDeclElements prEClassDecl() {
		return (pEClassDecl != null) ? pEClassDecl : (pEClassDecl = new EClassDeclElements());
	} 

	// EStructuralFeatureDecl returns EStructuralFeature:   EAttributeDecl|EReferenceDecl;
	public EStructuralFeatureDeclElements prEStructuralFeatureDecl() {
		return (pEStructuralFeatureDecl != null) ? pEStructuralFeatureDecl : (pEStructuralFeatureDecl = new EStructuralFeatureDeclElements());
	} 

	// EAttributeDecl returns EAttribute:   (eAnnotations+=EAnnotationDecl)* (iD?="ID"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"|transient?="transient"|unsettable?="unsettable"|derived?="derived")* "attr" eGenericType=EGenericTypeReferenceDecl ("[" lowerBound=INT (".." upperBound=SINT)? "]")? name=ID ("=" defaultValueLiteral=STRING)? ";";
	public EAttributeDeclElements prEAttributeDecl() {
		return (pEAttributeDecl != null) ? pEAttributeDecl : (pEAttributeDecl = new EAttributeDeclElements());
	} 

	// EReferenceDecl returns EReference:   (eAnnotations+=EAnnotationDecl)* (resolveProxies?="local"|unique?="bag"|ordered?="random"|changeable?="readonly"|volatile?="volatile"|transient?="transient"|unsettable?="unsettable"|derived?="derived")* (containment?="val"|"ref") eGenericType=EGenericTypeReferenceDecl ("[" lowerBound=INT (".." upperBound=SINT)? "]")? ("#" eOpposite=[EReference])? name=ID ";";
	public EReferenceDeclElements prEReferenceDecl() {
		return (pEReferenceDecl != null) ? pEReferenceDecl : (pEReferenceDecl = new EReferenceDeclElements());
	} 

	// EEnumDecl returns EEnum:   (eAnnotations+=EAnnotationDecl)* "enum" name=ID "{" (eLiterals+=EEnumLiteralDecl)+ "}";
	public EEnumDeclElements prEEnumDecl() {
		return (pEEnumDecl != null) ? pEEnumDecl : (pEEnumDecl = new EEnumDeclElements());
	} 

	// EEnumLiteralDecl returns EEnumLiteral:   (eAnnotations+=EAnnotationDecl)* name=ID ("=" value=INT)? (literal=STRING)? ";";
	public EEnumLiteralDeclElements prEEnumLiteralDecl() {
		return (pEEnumLiteralDecl != null) ? pEEnumLiteralDecl : (pEEnumLiteralDecl = new EEnumLiteralDeclElements());
	} 

	// ETypeParameterDecl returns ETypeParameter:   name=ID ("extends" eBounds+=EGenericTypeDecl)?;
	public ETypeParameterDeclElements prETypeParameterDecl() {
		return (pETypeParameterDecl != null) ? pETypeParameterDecl : (pETypeParameterDecl = new ETypeParameterDeclElements());
	} 

	// EGenericTypeReferenceDecl returns EGenericType:   eClassifier=[EClassifier] ("<" eTypeArguments+=EGenericTypeDecl ("," eTypeArguments+=EGenericTypeDecl)* ">")?|"#" eTypeParameter=[ETypeParameter];
	public EGenericTypeReferenceDeclElements prEGenericTypeReferenceDecl() {
		return (pEGenericTypeReferenceDecl != null) ? pEGenericTypeReferenceDecl : (pEGenericTypeReferenceDecl = new EGenericTypeReferenceDeclElements());
	} 

	// EGenericTypeDecl returns EGenericType:   eClassifier=[EClassifier] ("<" eTypeArguments+=EGenericTypeDecl ("," eTypeArguments+=EGenericTypeDecl)* ">")?|"#" eTypeParameter=[ETypeParameter]|"?" ("extends" eUpperBound=EGenericTypeDecl|"super" eLowerBound=EGenericTypeDecl);
	public EGenericTypeDeclElements prEGenericTypeDecl() {
		return (pEGenericTypeDecl != null) ? pEGenericTypeDecl : (pEGenericTypeDecl = new EGenericTypeDeclElements());
	} 

	// EOperationDecl returns EOperation:   (eAnnotations+=EAnnotationDecl)* (unique?="bag"|ordered?="random")* "op" (eGenericType=EGenericTypeReferenceDecl|"void") name=ID ("<" eTypeParameters+=ETypeParameterDecl ("," eTypeParameters+=ETypeParameterDecl)* ">")? "(" (eParameters+=EParameterDecl ("," eParameters+=EParameterDecl)*)? ")" ("throws" eGenericExceptions+=EGenericTypeReferenceDecl ("," eGenericExceptions+=EGenericTypeReferenceDecl)*)? ";";
	public EOperationDeclElements prEOperationDecl() {
		return (pEOperationDecl != null) ? pEOperationDecl : (pEOperationDecl = new EOperationDeclElements());
	} 

	// EParameterDecl returns EParameter:   (eAnnotations+=EAnnotationDecl)* eGenericType=EGenericTypeReferenceDecl name=ID;
	public EParameterDeclElements prEParameterDecl() {
		return (pEParameterDecl != null) ? pEParameterDecl : (pEParameterDecl = new EParameterDeclElements());
	} 

	// MapEntrySuper returns EObject:   MapEntry;
	public MapEntrySuperElements prMapEntrySuper() {
		return (pMapEntrySuper != null) ? pMapEntrySuper : (pMapEntrySuper = new MapEntrySuperElements());
	} 

	// MapEntry:   detailKey=ID "=" detailValue=STRING;
	public MapEntryElements prMapEntry() {
		return (pMapEntry != null) ? pMapEntry : (pMapEntry = new MapEntryElements());
	} 

	// MultiplicityExpr:   "+"|"?"|"*";
	public MultiplicityExprElements prMultiplicityExpr() {
		return (pMultiplicityExpr != null) ? pMultiplicityExpr : (pMultiplicityExpr = new MultiplicityExprElements());
	} 

	// QID returns EString:   ID (("."|"$") ID)*;
	public QIDElements prQID() {
		return (pQID != null) ? pQID : (pQID = new QIDElements());
	} 

	// STRING_OR_QID returns EString:   STRING|QID;
	public STRING_OR_QIDElements prSTRING_OR_QID() {
		return (pSTRING_OR_QID != null) ? pSTRING_OR_QID : (pSTRING_OR_QID = new STRING_OR_QIDElements());
	} 

	// SINT returns EInt:   "-"? INT;
	public SINTElements prSINT() {
		return (pSINT != null) ? pSINT : (pSINT = new SINTElements());
	} 

	// lexer ID:   "(\'^\')?(\'a\'..\'z\'|\'A\'..\'Z\'|\'_\') (\'a\'..\'z\'|\'A\'..\'Z\'|\'_\'|\'0\'..\'9\')*";
	public LexerRule lrID() {
		return (lID != null) ? lID : (lID = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "ID"));
	} 

	// lexer INT returns EInt:   "(\'0\'..\'9\')+";
	public LexerRule lrINT() {
		return (lINT != null) ? lINT : (lINT = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "INT"));
	} 

	// lexer STRING:   "\n\t\t\t  \'\"\' ( \'\\\\\' (\'b\'|\'t\'|\'n\'|\'f\'|\'r\'|\'\\\"\'|\'\\\'\'|\'\\\\\') | ~(\'\\\\\'|\'\"\') )* \'\"\' | \n              \'\\\'\' ( \'\\\\\' (\'b\'|\'t\'|\'n\'|\'f\'|\'r\'|\'\\\"\'|\'\\\'\'|\'\\\\\') | ~(\'\\\\\'|\'\\\'\') )* \'\\\'\'\n              ";
	public LexerRule lrSTRING() {
		return (lSTRING != null) ? lSTRING : (lSTRING = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "STRING"));
	} 

	// lexer ML_COMMENT:   "\'/*\' ( options {greedy=false;} : . )* \'*/\'";
	public LexerRule lrML_COMMENT() {
		return (lML_COMMENT != null) ? lML_COMMENT : (lML_COMMENT = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "ML_COMMENT"));
	} 

	// lexer SL_COMMENT:   "\'//\' ~(\'\\n\'|\'\\r\')* (\'\\r\'? \'\\n\')?";
	public LexerRule lrSL_COMMENT() {
		return (lSL_COMMENT != null) ? lSL_COMMENT : (lSL_COMMENT = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "SL_COMMENT"));
	} 

	// lexer WS:   "(\' \'|\'\\t\'|\'\\r\'|\'\\n\')+";
	public LexerRule lrWS() {
		return (lWS != null) ? lWS : (lWS = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "WS"));
	} 

	// lexer ANY_OTHER:   ".";
	public LexerRule lrANY_OTHER() {
		return (lANY_OTHER != null) ? lANY_OTHER : (lANY_OTHER = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "ANY_OTHER"));
	} 
}
