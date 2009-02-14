/*
Generated with Xtext
*/

package org.eclipse.xtext.example.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;

import org.eclipse.xtext.service.GrammarProvider;

import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

@Singleton
public class DomainmodelGrammarAccess implements IGrammarAccess {
	
	
	public class FileElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "File");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment c0AssignmentImports = (Assignment)cGroup.eContents().get(0);
		private final RuleCall c00ParserRuleCallImport = (RuleCall)c0AssignmentImports.eContents().get(0);
		private final Assignment c1AssignmentNamedElements = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10ParserRuleCallNamedElement = (RuleCall)c1AssignmentNamedElements.eContents().get(0);
		
		// File:   (imports+=Import)* (namedElements+=NamedElement)*;
		public ParserRule getRule() { return rule; }

		// (imports+=Import)* (namedElements+=NamedElement)*
		public Group eleGroup() { return cGroup; }

		// (imports+=Import)*
		public Assignment ele0AssignmentImports() { return c0AssignmentImports; }

		// Import
		public RuleCall ele00ParserRuleCallImport() { return c00ParserRuleCallImport; }

		// (namedElements+=NamedElement)*
		public Assignment ele1AssignmentNamedElements() { return c1AssignmentNamedElements; }

		// NamedElement
		public RuleCall ele10ParserRuleCallNamedElement() { return c10ParserRuleCallNamedElement; }
	}

	public class ImportElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Import");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordImport = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentImportURI = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallSTRING = (RuleCall)c1AssignmentImportURI.eContents().get(0);
		
		// Import:   "import" importURI=STRING;
		public ParserRule getRule() { return rule; }

		// "import" importURI=STRING
		public Group eleGroup() { return cGroup; }

		// "import"
		public Keyword ele0KeywordImport() { return c0KeywordImport; }

		// importURI=STRING
		public Assignment ele1AssignmentImportURI() { return c1AssignmentImportURI; }

		// STRING
		public RuleCall ele10LexerRuleCallSTRING() { return c10LexerRuleCallSTRING; }
	}

	public class NamedElementElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "NamedElement");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallPackage = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall c1ParserRuleCallType = (RuleCall)cAlternatives.eContents().get(1);
		
		// NamedElement:   Package|Type;
		public ParserRule getRule() { return rule; }

		// Package|Type
		public Alternatives eleAlternatives() { return cAlternatives; }

		// Package
		public RuleCall ele0ParserRuleCallPackage() { return c0ParserRuleCallPackage; }

		// Type
		public RuleCall ele1ParserRuleCallType() { return c1ParserRuleCallType; }
	}

	public class PackageElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Package");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Keyword c0000KeywordPackage = (Keyword)c000Group.eContents().get(0);
		private final Assignment c0001AssignmentName = (Assignment)c000Group.eContents().get(1);
		private final RuleCall c00010ParserRuleCallQualifiedName = (RuleCall)c0001AssignmentName.eContents().get(0);
		private final Keyword c001KeywordLeftCurlyBracket = (Keyword)c00Group.eContents().get(1);
		private final Assignment c01AssignmentNamedElements = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010ParserRuleCallNamedElement = (RuleCall)c01AssignmentNamedElements.eContents().get(0);
		private final Keyword c1KeywordRightCurlyBracket = (Keyword)cGroup.eContents().get(1);
		
		// Package:   "package" name=QualifiedName "{" (namedElements+=NamedElement)* "}";
		public ParserRule getRule() { return rule; }

		// "package" name=QualifiedName "{" (namedElements+=NamedElement)* "}"
		public Group eleGroup() { return cGroup; }

		// "package" name=QualifiedName "{" (namedElements+=NamedElement)*
		public Group ele0Group() { return c0Group; }

		// "package" name=QualifiedName "{"
		public Group ele00Group() { return c00Group; }

		// "package" name=QualifiedName
		public Group ele000Group() { return c000Group; }

		// "package"
		public Keyword ele0000KeywordPackage() { return c0000KeywordPackage; }

		// name=QualifiedName
		public Assignment ele0001AssignmentName() { return c0001AssignmentName; }

		// QualifiedName
		public RuleCall ele00010ParserRuleCallQualifiedName() { return c00010ParserRuleCallQualifiedName; }

		// "{"
		public Keyword ele001KeywordLeftCurlyBracket() { return c001KeywordLeftCurlyBracket; }

		// (namedElements+=NamedElement)*
		public Assignment ele01AssignmentNamedElements() { return c01AssignmentNamedElements; }

		// NamedElement
		public RuleCall ele010ParserRuleCallNamedElement() { return c010ParserRuleCallNamedElement; }

		// "}"
		public Keyword ele1KeywordRightCurlyBracket() { return c1KeywordRightCurlyBracket; }
	}

	public class TypeElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Type");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallEntity = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall c1ParserRuleCallDataType = (RuleCall)cAlternatives.eContents().get(1);
		
		// Type:   Entity|DataType;
		public ParserRule getRule() { return rule; }

		// Entity|DataType
		public Alternatives eleAlternatives() { return cAlternatives; }

		// Entity
		public RuleCall ele0ParserRuleCallEntity() { return c0ParserRuleCallEntity; }

		// DataType
		public RuleCall ele1ParserRuleCallDataType() { return c1ParserRuleCallDataType; }
	}

	public class DataTypeElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "DataType");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordDatatype = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentName = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallID = (RuleCall)c1AssignmentName.eContents().get(0);
		
		// DataType:   "datatype" name=ID;
		public ParserRule getRule() { return rule; }

		// "datatype" name=ID
		public Group eleGroup() { return cGroup; }

		// "datatype"
		public Keyword ele0KeywordDatatype() { return c0KeywordDatatype; }

		// name=ID
		public Assignment ele1AssignmentName() { return c1AssignmentName; }

		// ID
		public RuleCall ele10LexerRuleCallID() { return c10LexerRuleCallID; }
	}

	public class EntityElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Entity");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Keyword c00000KeywordEntity = (Keyword)c0000Group.eContents().get(0);
		private final Assignment c00001AssignmentName = (Assignment)c0000Group.eContents().get(1);
		private final RuleCall c000010LexerRuleCallID = (RuleCall)c00001AssignmentName.eContents().get(0);
		private final Group c0001Group = (Group)c000Group.eContents().get(1);
		private final Keyword c00010KeywordExtends = (Keyword)c0001Group.eContents().get(0);
		private final Assignment c00011AssignmentSuperType = (Assignment)c0001Group.eContents().get(1);
		private final CrossReference c000110CrossReferenceEStringEntity = (CrossReference)c00011AssignmentSuperType.eContents().get(0);
		private final Keyword c001KeywordLeftCurlyBracket = (Keyword)c00Group.eContents().get(1);
		private final Assignment c01AssignmentFeatures = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010ParserRuleCallFeature = (RuleCall)c01AssignmentFeatures.eContents().get(0);
		private final Keyword c1KeywordRightCurlyBracket = (Keyword)cGroup.eContents().get(1);
		
		// Entity:   "entity" name=ID ("extends" superType=[Entity])? "{" (features+=Feature)* "}";
		public ParserRule getRule() { return rule; }

		// "entity" name=ID ("extends" superType=[Entity])? "{" (features+=Feature)* "}"
		public Group eleGroup() { return cGroup; }

		// "entity" name=ID ("extends" superType=[Entity])? "{" (features+=Feature)*
		public Group ele0Group() { return c0Group; }

		// "entity" name=ID ("extends" superType=[Entity])? "{"
		public Group ele00Group() { return c00Group; }

		// "entity" name=ID ("extends" superType=[Entity])?
		public Group ele000Group() { return c000Group; }

		// "entity" name=ID
		public Group ele0000Group() { return c0000Group; }

		// "entity"
		public Keyword ele00000KeywordEntity() { return c00000KeywordEntity; }

		// name=ID
		public Assignment ele00001AssignmentName() { return c00001AssignmentName; }

		// ID
		public RuleCall ele000010LexerRuleCallID() { return c000010LexerRuleCallID; }

		// ("extends" superType=[Entity])?
		public Group ele0001Group() { return c0001Group; }

		// "extends"
		public Keyword ele00010KeywordExtends() { return c00010KeywordExtends; }

		// superType=[Entity]
		public Assignment ele00011AssignmentSuperType() { return c00011AssignmentSuperType; }

		// [Entity]
		public CrossReference ele000110CrossReferenceEStringEntity() { return c000110CrossReferenceEStringEntity; }

		// "{"
		public Keyword ele001KeywordLeftCurlyBracket() { return c001KeywordLeftCurlyBracket; }

		// (features+=Feature)*
		public Assignment ele01AssignmentFeatures() { return c01AssignmentFeatures; }

		// Feature
		public RuleCall ele010ParserRuleCallFeature() { return c010ParserRuleCallFeature; }

		// "}"
		public Keyword ele1KeywordRightCurlyBracket() { return c1KeywordRightCurlyBracket; }
	}

	public class FeatureElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Feature");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallStructuralFeature = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall c1ParserRuleCallOperation = (RuleCall)cAlternatives.eContents().get(1);
		
		// Feature:   StructuralFeature|Operation;
		public ParserRule getRule() { return rule; }

		// StructuralFeature|Operation
		public Alternatives eleAlternatives() { return cAlternatives; }

		// StructuralFeature
		public RuleCall ele0ParserRuleCallStructuralFeature() { return c0ParserRuleCallStructuralFeature; }

		// Operation
		public RuleCall ele1ParserRuleCallOperation() { return c1ParserRuleCallOperation; }
	}

	public class StructuralFeatureElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "StructuralFeature");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallAttribute = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall c1ParserRuleCallReference = (RuleCall)cAlternatives.eContents().get(1);
		
		// StructuralFeature:   Attribute|Reference;
		public ParserRule getRule() { return rule; }

		// Attribute|Reference
		public Alternatives eleAlternatives() { return cAlternatives; }

		// Attribute
		public RuleCall ele0ParserRuleCallAttribute() { return c0ParserRuleCallAttribute; }

		// Reference
		public RuleCall ele1ParserRuleCallReference() { return c1ParserRuleCallReference; }
	}

	public class AttributeElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Attribute");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordAttr = (Keyword)c00Group.eContents().get(0);
		private final Assignment c001AssignmentName = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010LexerRuleCallID = (RuleCall)c001AssignmentName.eContents().get(0);
		private final Keyword c01KeywordColon = (Keyword)c0Group.eContents().get(1);
		private final Assignment c1AssignmentType = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10ParserRuleCallTypeRef = (RuleCall)c1AssignmentType.eContents().get(0);
		
		// Attribute:   "attr" name=ID ":" type=TypeRef;
		public ParserRule getRule() { return rule; }

		// "attr" name=ID ":" type=TypeRef
		public Group eleGroup() { return cGroup; }

		// "attr" name=ID ":"
		public Group ele0Group() { return c0Group; }

		// "attr" name=ID
		public Group ele00Group() { return c00Group; }

		// "attr"
		public Keyword ele000KeywordAttr() { return c000KeywordAttr; }

		// name=ID
		public Assignment ele001AssignmentName() { return c001AssignmentName; }

		// ID
		public RuleCall ele0010LexerRuleCallID() { return c0010LexerRuleCallID; }

		// ":"
		public Keyword ele01KeywordColon() { return c01KeywordColon; }

		// type=TypeRef
		public Assignment ele1AssignmentType() { return c1AssignmentType; }

		// TypeRef
		public RuleCall ele10ParserRuleCallTypeRef() { return c10ParserRuleCallTypeRef; }
	}

	public class ReferenceElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Reference");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Keyword c0000KeywordRef = (Keyword)c000Group.eContents().get(0);
		private final Assignment c0001AssignmentName = (Assignment)c000Group.eContents().get(1);
		private final RuleCall c00010LexerRuleCallID = (RuleCall)c0001AssignmentName.eContents().get(0);
		private final Keyword c001KeywordColon = (Keyword)c00Group.eContents().get(1);
		private final Assignment c01AssignmentType = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010ParserRuleCallTypeRef = (RuleCall)c01AssignmentType.eContents().get(0);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Keyword c10KeywordOpposite = (Keyword)c1Group.eContents().get(0);
		private final Assignment c11AssignmentOpposite = (Assignment)c1Group.eContents().get(1);
		private final CrossReference c110CrossReferenceEStringReference = (CrossReference)c11AssignmentOpposite.eContents().get(0);
		
		// Reference:   "ref" name=ID ":" type=TypeRef ("opposite" opposite=[Reference])?;
		public ParserRule getRule() { return rule; }

		// "ref" name=ID ":" type=TypeRef ("opposite" opposite=[Reference])?
		public Group eleGroup() { return cGroup; }

		// "ref" name=ID ":" type=TypeRef
		public Group ele0Group() { return c0Group; }

		// "ref" name=ID ":"
		public Group ele00Group() { return c00Group; }

		// "ref" name=ID
		public Group ele000Group() { return c000Group; }

		// "ref"
		public Keyword ele0000KeywordRef() { return c0000KeywordRef; }

		// name=ID
		public Assignment ele0001AssignmentName() { return c0001AssignmentName; }

		// ID
		public RuleCall ele00010LexerRuleCallID() { return c00010LexerRuleCallID; }

		// ":"
		public Keyword ele001KeywordColon() { return c001KeywordColon; }

		// type=TypeRef
		public Assignment ele01AssignmentType() { return c01AssignmentType; }

		// TypeRef
		public RuleCall ele010ParserRuleCallTypeRef() { return c010ParserRuleCallTypeRef; }

		// ("opposite" opposite=[Reference])?
		public Group ele1Group() { return c1Group; }

		// "opposite"
		public Keyword ele10KeywordOpposite() { return c10KeywordOpposite; }

		// opposite=[Reference]
		public Assignment ele11AssignmentOpposite() { return c11AssignmentOpposite; }

		// [Reference]
		public CrossReference ele110CrossReferenceEStringReference() { return c110CrossReferenceEStringReference; }
	}

	public class OperationElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Operation");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Group c00000Group = (Group)c0000Group.eContents().get(0);
		private final Keyword c000000KeywordOp = (Keyword)c00000Group.eContents().get(0);
		private final Assignment c000001AssignmentName = (Assignment)c00000Group.eContents().get(1);
		private final RuleCall c0000010LexerRuleCallID = (RuleCall)c000001AssignmentName.eContents().get(0);
		private final Keyword c00001KeywordLeftParenthesis = (Keyword)c0000Group.eContents().get(1);
		private final Group c0001Group = (Group)c000Group.eContents().get(1);
		private final Assignment c00010AssignmentParams = (Assignment)c0001Group.eContents().get(0);
		private final RuleCall c000100ParserRuleCallParameter = (RuleCall)c00010AssignmentParams.eContents().get(0);
		private final Group c00011Group = (Group)c0001Group.eContents().get(1);
		private final Keyword c000110KeywordComma = (Keyword)c00011Group.eContents().get(0);
		private final Assignment c000111AssignmentParams = (Assignment)c00011Group.eContents().get(1);
		private final RuleCall c0001110ParserRuleCallParameter = (RuleCall)c000111AssignmentParams.eContents().get(0);
		private final Keyword c001KeywordRightParenthesis = (Keyword)c00Group.eContents().get(1);
		private final Keyword c01KeywordColon = (Keyword)c0Group.eContents().get(1);
		private final Assignment c1AssignmentType = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10ParserRuleCallTypeRef = (RuleCall)c1AssignmentType.eContents().get(0);
		
		// Operation:   "op" name=ID "(" (params+=Parameter ("," params+=Parameter)*)? ")" ":" type=TypeRef;
		public ParserRule getRule() { return rule; }

		// "op" name=ID "(" (params+=Parameter ("," params+=Parameter)*)? ")" ":" type=TypeRef
		public Group eleGroup() { return cGroup; }

		// "op" name=ID "(" (params+=Parameter ("," params+=Parameter)*)? ")" ":"
		public Group ele0Group() { return c0Group; }

		// "op" name=ID "(" (params+=Parameter ("," params+=Parameter)*)? ")"
		public Group ele00Group() { return c00Group; }

		// "op" name=ID "(" (params+=Parameter ("," params+=Parameter)*)?
		public Group ele000Group() { return c000Group; }

		// "op" name=ID "("
		public Group ele0000Group() { return c0000Group; }

		// "op" name=ID
		public Group ele00000Group() { return c00000Group; }

		// "op"
		public Keyword ele000000KeywordOp() { return c000000KeywordOp; }

		// name=ID
		public Assignment ele000001AssignmentName() { return c000001AssignmentName; }

		// ID
		public RuleCall ele0000010LexerRuleCallID() { return c0000010LexerRuleCallID; }

		// "("
		public Keyword ele00001KeywordLeftParenthesis() { return c00001KeywordLeftParenthesis; }

		// (params+=Parameter ("," params+=Parameter)*)?
		public Group ele0001Group() { return c0001Group; }

		// params+=Parameter
		public Assignment ele00010AssignmentParams() { return c00010AssignmentParams; }

		// Parameter
		public RuleCall ele000100ParserRuleCallParameter() { return c000100ParserRuleCallParameter; }

		// ("," params+=Parameter)*
		public Group ele00011Group() { return c00011Group; }

		// ","
		public Keyword ele000110KeywordComma() { return c000110KeywordComma; }

		// params+=Parameter
		public Assignment ele000111AssignmentParams() { return c000111AssignmentParams; }

		// Parameter
		public RuleCall ele0001110ParserRuleCallParameter() { return c0001110ParserRuleCallParameter; }

		// ")"
		public Keyword ele001KeywordRightParenthesis() { return c001KeywordRightParenthesis; }

		// ":"
		public Keyword ele01KeywordColon() { return c01KeywordColon; }

		// type=TypeRef
		public Assignment ele1AssignmentType() { return c1AssignmentType; }

		// TypeRef
		public RuleCall ele10ParserRuleCallTypeRef() { return c10ParserRuleCallTypeRef; }
	}

	public class ParameterElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Parameter");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment c0AssignmentName = (Assignment)cGroup.eContents().get(0);
		private final RuleCall c00LexerRuleCallID = (RuleCall)c0AssignmentName.eContents().get(0);
		private final Assignment c1AssignmentType = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10ParserRuleCallTypeRef = (RuleCall)c1AssignmentType.eContents().get(0);
		
		// Parameter:   name=ID type=TypeRef;
		public ParserRule getRule() { return rule; }

		// name=ID type=TypeRef
		public Group eleGroup() { return cGroup; }

		// name=ID
		public Assignment ele0AssignmentName() { return c0AssignmentName; }

		// ID
		public RuleCall ele00LexerRuleCallID() { return c00LexerRuleCallID; }

		// type=TypeRef
		public Assignment ele1AssignmentType() { return c1AssignmentType; }

		// TypeRef
		public RuleCall ele10ParserRuleCallTypeRef() { return c10ParserRuleCallTypeRef; }
	}

	public class TypedElementElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TypedElement");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallFeature = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall c1ParserRuleCallParameter = (RuleCall)cAlternatives.eContents().get(1);
		
		// TypedElement:   Feature|Parameter;
		public ParserRule getRule() { return rule; }

		// Feature|Parameter
		public Alternatives eleAlternatives() { return cAlternatives; }

		// Feature
		public RuleCall ele0ParserRuleCallFeature() { return c0ParserRuleCallFeature; }

		// Parameter
		public RuleCall ele1ParserRuleCallParameter() { return c1ParserRuleCallParameter; }
	}

	public class TypeRefElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "TypeRef");
		private final Assignment cAssignmentReferenced = (Assignment)rule.eContents().get(1);
		private final CrossReference c0CrossReferenceEStringType = (CrossReference)cAssignmentReferenced.eContents().get(0);
		
		// TypeRef:   referenced=[Type];
		public ParserRule getRule() { return rule; }

		// referenced=[Type]
		public Assignment eleAssignmentReferenced() { return cAssignmentReferenced; }

		// [Type]
		public CrossReference ele0CrossReferenceEStringType() { return c0CrossReferenceEStringType; }
	}

	public class QualifiedNameElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "QualifiedName");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final RuleCall c0LexerRuleCallID = (RuleCall)cGroup.eContents().get(0);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Keyword c10KeywordFullStop = (Keyword)c1Group.eContents().get(0);
		private final RuleCall c11LexerRuleCallID = (RuleCall)c1Group.eContents().get(1);
		
		// QualifiedName returns EString:   ID ("." ID)*;
		public ParserRule getRule() { return rule; }

		// ID ("." ID)*
		public Group eleGroup() { return cGroup; }

		// ID
		public RuleCall ele0LexerRuleCallID() { return c0LexerRuleCallID; }

		// ("." ID)*
		public Group ele1Group() { return c1Group; }

		// "."
		public Keyword ele10KeywordFullStop() { return c10KeywordFullStop; }

		// ID
		public RuleCall ele11LexerRuleCallID() { return c11LexerRuleCallID; }
	}
	
	private FileElements pFile;
	private ImportElements pImport;
	private NamedElementElements pNamedElement;
	private PackageElements pPackage;
	private TypeElements pType;
	private DataTypeElements pDataType;
	private EntityElements pEntity;
	private FeatureElements pFeature;
	private StructuralFeatureElements pStructuralFeature;
	private AttributeElements pAttribute;
	private ReferenceElements pReference;
	private OperationElements pOperation;
	private ParameterElements pParameter;
	private TypedElementElements pTypedElement;
	private TypeRefElements pTypeRef;
	private QualifiedNameElements pQualifiedName;
	
	private final GrammarProvider grammarProvider;

	private XtextBuiltinGrammarAccess superGrammarAccess;

	@Inject
	public DomainmodelGrammarAccess(GrammarProvider grammarProvider, XtextBuiltinGrammarAccess superGrammarAccess) {
		this.grammarProvider = grammarProvider;
		this.superGrammarAccess = superGrammarAccess;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	public XtextBuiltinGrammarAccess getSuperGrammarAccess() {
		return superGrammarAccess;
	}

	
	// File:   (imports+=Import)* (namedElements+=NamedElement)*;
	public FileElements prFile() {
		return (pFile != null) ? pFile : (pFile = new FileElements());
	} 

	// Import:   "import" importURI=STRING;
	public ImportElements prImport() {
		return (pImport != null) ? pImport : (pImport = new ImportElements());
	} 

	// NamedElement:   Package|Type;
	public NamedElementElements prNamedElement() {
		return (pNamedElement != null) ? pNamedElement : (pNamedElement = new NamedElementElements());
	} 

	// Package:   "package" name=QualifiedName "{" (namedElements+=NamedElement)* "}";
	public PackageElements prPackage() {
		return (pPackage != null) ? pPackage : (pPackage = new PackageElements());
	} 

	// Type:   Entity|DataType;
	public TypeElements prType() {
		return (pType != null) ? pType : (pType = new TypeElements());
	} 

	// DataType:   "datatype" name=ID;
	public DataTypeElements prDataType() {
		return (pDataType != null) ? pDataType : (pDataType = new DataTypeElements());
	} 

	// Entity:   "entity" name=ID ("extends" superType=[Entity])? "{" (features+=Feature)* "}";
	public EntityElements prEntity() {
		return (pEntity != null) ? pEntity : (pEntity = new EntityElements());
	} 

	// Feature:   StructuralFeature|Operation;
	public FeatureElements prFeature() {
		return (pFeature != null) ? pFeature : (pFeature = new FeatureElements());
	} 

	// StructuralFeature:   Attribute|Reference;
	public StructuralFeatureElements prStructuralFeature() {
		return (pStructuralFeature != null) ? pStructuralFeature : (pStructuralFeature = new StructuralFeatureElements());
	} 

	// Attribute:   "attr" name=ID ":" type=TypeRef;
	public AttributeElements prAttribute() {
		return (pAttribute != null) ? pAttribute : (pAttribute = new AttributeElements());
	} 

	// Reference:   "ref" name=ID ":" type=TypeRef ("opposite" opposite=[Reference])?;
	public ReferenceElements prReference() {
		return (pReference != null) ? pReference : (pReference = new ReferenceElements());
	} 

	// Operation:   "op" name=ID "(" (params+=Parameter ("," params+=Parameter)*)? ")" ":" type=TypeRef;
	public OperationElements prOperation() {
		return (pOperation != null) ? pOperation : (pOperation = new OperationElements());
	} 

	// Parameter:   name=ID type=TypeRef;
	public ParameterElements prParameter() {
		return (pParameter != null) ? pParameter : (pParameter = new ParameterElements());
	} 

	// TypedElement:   Feature|Parameter;
	public TypedElementElements prTypedElement() {
		return (pTypedElement != null) ? pTypedElement : (pTypedElement = new TypedElementElements());
	} 

	// TypeRef:   referenced=[Type];
	public TypeRefElements prTypeRef() {
		return (pTypeRef != null) ? pTypeRef : (pTypeRef = new TypeRefElements());
	} 

	// QualifiedName returns EString:   ID ("." ID)*;
	public QualifiedNameElements prQualifiedName() {
		return (pQualifiedName != null) ? pQualifiedName : (pQualifiedName = new QualifiedNameElements());
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
