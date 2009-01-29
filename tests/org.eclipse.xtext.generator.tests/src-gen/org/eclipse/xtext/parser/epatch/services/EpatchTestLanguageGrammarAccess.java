/*
Generated with Xtext
*/

package org.eclipse.xtext.parser.epatch.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class EpatchTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class EPatchElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(1);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Group c00000Group = (Group)c0000Group.eContents().get(0);
		private final Keyword c000000KeywordEpatch = (Keyword)c00000Group.eContents().get(0);
		private final Assignment c000001AssignmentName = (Assignment)c00000Group.eContents().get(1);
		private final RuleCall c0000010LexerRuleCallID = (RuleCall)c000001AssignmentName.eContents().get(0);
		private final Keyword c00001KeywordLeftCurlyBracket = (Keyword)c0000Group.eContents().get(1);
		private final Assignment c0001AssignmentImports = (Assignment)c000Group.eContents().get(1);
		private final RuleCall c00010ParserRuleCallImport = (RuleCall)c0001AssignmentImports.eContents().get(0);
		private final Assignment c001AssignmentResources = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010ParserRuleCallNamedResource = (RuleCall)c001AssignmentResources.eContents().get(0);
		private final Assignment c01AssignmentObjects = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010ParserRuleCallObjectRef = (RuleCall)c01AssignmentObjects.eContents().get(0);
		private final Keyword c1KeywordRightCurlyBracket = (Keyword)cGroup.eContents().get(1);
		
		// EPatch hidden ( WS , ML_COMMENT , SL_COMMENT ) : "epatch" name = ID "{" ( imports += Import ) * ( resources += NamedResource ) * ( objects += ObjectRef ) * "}" ;
		public ParserRule getRule() { return rule; }

		// "epatch" name = ID "{" ( imports += Import ) * ( resources += NamedResource ) * ( objects += ObjectRef ) * "}"
		public Group eleGroup() { return cGroup; }

		// "epatch" name = ID "{" ( imports += Import ) * ( resources += NamedResource ) * ( objects += ObjectRef ) *
		public Group ele0Group() { return c0Group; }

		// "epatch" name = ID "{" ( imports += Import ) * ( resources += NamedResource ) *
		public Group ele00Group() { return c00Group; }

		// "epatch" name = ID "{" ( imports += Import ) *
		public Group ele000Group() { return c000Group; }

		// "epatch" name = ID "{"
		public Group ele0000Group() { return c0000Group; }

		// "epatch" name = ID
		public Group ele00000Group() { return c00000Group; }

		// "epatch"
		public Keyword ele000000KeywordEpatch() { return c000000KeywordEpatch; }

		// name = ID
		public Assignment ele000001AssignmentName() { return c000001AssignmentName; }

		// ID
		public RuleCall ele0000010LexerRuleCallID() { return c0000010LexerRuleCallID; }

		// "{"
		public Keyword ele00001KeywordLeftCurlyBracket() { return c00001KeywordLeftCurlyBracket; }

		// ( imports += Import ) *
		public Assignment ele0001AssignmentImports() { return c0001AssignmentImports; }

		// Import
		public RuleCall ele00010ParserRuleCallImport() { return c00010ParserRuleCallImport; }

		// ( resources += NamedResource ) *
		public Assignment ele001AssignmentResources() { return c001AssignmentResources; }

		// NamedResource
		public RuleCall ele0010ParserRuleCallNamedResource() { return c0010ParserRuleCallNamedResource; }

		// ( objects += ObjectRef ) *
		public Assignment ele01AssignmentObjects() { return c01AssignmentObjects; }

		// ObjectRef
		public RuleCall ele010ParserRuleCallObjectRef() { return c010ParserRuleCallObjectRef; }

		// "}"
		public Keyword ele1KeywordRightCurlyBracket() { return c1KeywordRightCurlyBracket; }
	}

	public class ImportElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(2);
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Alternatives c0Alternatives = (Alternatives)cAlternatives.eContents().get(0);
		private final RuleCall c00ParserRuleCallModelImport = (RuleCall)c0Alternatives.eContents().get(0);
		private final RuleCall c01ParserRuleCallJavaImport = (RuleCall)c0Alternatives.eContents().get(1);
		private final RuleCall c1ParserRuleCallExtensionImport = (RuleCall)cAlternatives.eContents().get(1);
		
		// Import : ModelImport | JavaImport | ExtensionImport ;
		public ParserRule getRule() { return rule; }

		// ModelImport | JavaImport | ExtensionImport
		public Alternatives eleAlternatives() { return cAlternatives; }

		// ModelImport | JavaImport
		public Alternatives ele0Alternatives() { return c0Alternatives; }

		// ModelImport
		public RuleCall ele00ParserRuleCallModelImport() { return c00ParserRuleCallModelImport; }

		// JavaImport
		public RuleCall ele01ParserRuleCallJavaImport() { return c01ParserRuleCallJavaImport; }

		// ExtensionImport
		public RuleCall ele1ParserRuleCallExtensionImport() { return c1ParserRuleCallExtensionImport; }
	}

	public class ModelImportElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(3);
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallResourceImport = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall c1ParserRuleCallEPackageImport = (RuleCall)cAlternatives.eContents().get(1);
		
		// ModelImport : ResourceImport | EPackageImport ;
		public ParserRule getRule() { return rule; }

		// ResourceImport | EPackageImport
		public Alternatives eleAlternatives() { return cAlternatives; }

		// ResourceImport
		public RuleCall ele0ParserRuleCallResourceImport() { return c0ParserRuleCallResourceImport; }

		// EPackageImport
		public RuleCall ele1ParserRuleCallEPackageImport() { return c1ParserRuleCallEPackageImport; }
	}

	public class ResourceImportElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(4);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordImport = (Keyword)c00Group.eContents().get(0);
		private final Assignment c001AssignmentName = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010LexerRuleCallID = (RuleCall)c001AssignmentName.eContents().get(0);
		private final Keyword c01KeywordUri = (Keyword)c0Group.eContents().get(1);
		private final Assignment c1AssignmentUri = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallSTRING = (RuleCall)c1AssignmentUri.eContents().get(0);
		
		// ResourceImport : "import" name = ID "uri" uri = STRING ;
		public ParserRule getRule() { return rule; }

		// "import" name = ID "uri" uri = STRING
		public Group eleGroup() { return cGroup; }

		// "import" name = ID "uri"
		public Group ele0Group() { return c0Group; }

		// "import" name = ID
		public Group ele00Group() { return c00Group; }

		// "import"
		public Keyword ele000KeywordImport() { return c000KeywordImport; }

		// name = ID
		public Assignment ele001AssignmentName() { return c001AssignmentName; }

		// ID
		public RuleCall ele0010LexerRuleCallID() { return c0010LexerRuleCallID; }

		// "uri"
		public Keyword ele01KeywordUri() { return c01KeywordUri; }

		// uri = STRING
		public Assignment ele1AssignmentUri() { return c1AssignmentUri; }

		// STRING
		public RuleCall ele10LexerRuleCallSTRING() { return c10LexerRuleCallSTRING; }
	}

	public class EPackageImportElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(5);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordImport = (Keyword)c00Group.eContents().get(0);
		private final Assignment c001AssignmentName = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010LexerRuleCallID = (RuleCall)c001AssignmentName.eContents().get(0);
		private final Keyword c01KeywordNs = (Keyword)c0Group.eContents().get(1);
		private final Assignment c1AssignmentNsURI = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallSTRING = (RuleCall)c1AssignmentNsURI.eContents().get(0);
		
		// EPackageImport : "import" name = ID "ns" nsURI = STRING ;
		public ParserRule getRule() { return rule; }

		// "import" name = ID "ns" nsURI = STRING
		public Group eleGroup() { return cGroup; }

		// "import" name = ID "ns"
		public Group ele0Group() { return c0Group; }

		// "import" name = ID
		public Group ele00Group() { return c00Group; }

		// "import"
		public Keyword ele000KeywordImport() { return c000KeywordImport; }

		// name = ID
		public Assignment ele001AssignmentName() { return c001AssignmentName; }

		// ID
		public RuleCall ele0010LexerRuleCallID() { return c0010LexerRuleCallID; }

		// "ns"
		public Keyword ele01KeywordNs() { return c01KeywordNs; }

		// nsURI = STRING
		public Assignment ele1AssignmentNsURI() { return c1AssignmentNsURI; }

		// STRING
		public RuleCall ele10LexerRuleCallSTRING() { return c10LexerRuleCallSTRING; }
	}

	public class JavaImportElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(6);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordImport = (Keyword)c00Group.eContents().get(0);
		private final Keyword c001KeywordJava = (Keyword)c00Group.eContents().get(1);
		private final Assignment c01AssignmentPath = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010LexerRuleCallID = (RuleCall)c01AssignmentPath.eContents().get(0);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Keyword c10KeywordFullStop = (Keyword)c1Group.eContents().get(0);
		private final Assignment c11AssignmentPath = (Assignment)c1Group.eContents().get(1);
		private final RuleCall c110LexerRuleCallID = (RuleCall)c11AssignmentPath.eContents().get(0);
		
		// JavaImport : "import" "java" path += ID ( "." path += ID ) * ;
		public ParserRule getRule() { return rule; }

		// "import" "java" path += ID ( "." path += ID ) *
		public Group eleGroup() { return cGroup; }

		// "import" "java" path += ID
		public Group ele0Group() { return c0Group; }

		// "import" "java"
		public Group ele00Group() { return c00Group; }

		// "import"
		public Keyword ele000KeywordImport() { return c000KeywordImport; }

		// "java"
		public Keyword ele001KeywordJava() { return c001KeywordJava; }

		// path += ID
		public Assignment ele01AssignmentPath() { return c01AssignmentPath; }

		// ID
		public RuleCall ele010LexerRuleCallID() { return c010LexerRuleCallID; }

		// ( "." path += ID ) *
		public Group ele1Group() { return c1Group; }

		// "."
		public Keyword ele10KeywordFullStop() { return c10KeywordFullStop; }

		// path += ID
		public Assignment ele11AssignmentPath() { return c11AssignmentPath; }

		// ID
		public RuleCall ele110LexerRuleCallID() { return c110LexerRuleCallID; }
	}

	public class ExtensionImportElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(7);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordImport = (Keyword)c00Group.eContents().get(0);
		private final Keyword c001KeywordExtension = (Keyword)c00Group.eContents().get(1);
		private final Assignment c01AssignmentPath = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010LexerRuleCallID = (RuleCall)c01AssignmentPath.eContents().get(0);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Keyword c10KeywordColonColon = (Keyword)c1Group.eContents().get(0);
		private final Assignment c11AssignmentPath = (Assignment)c1Group.eContents().get(1);
		private final RuleCall c110LexerRuleCallID = (RuleCall)c11AssignmentPath.eContents().get(0);
		
		// ExtensionImport : "import" "extension" path += ID ( "::" path += ID ) * ;
		public ParserRule getRule() { return rule; }

		// "import" "extension" path += ID ( "::" path += ID ) *
		public Group eleGroup() { return cGroup; }

		// "import" "extension" path += ID
		public Group ele0Group() { return c0Group; }

		// "import" "extension"
		public Group ele00Group() { return c00Group; }

		// "import"
		public Keyword ele000KeywordImport() { return c000KeywordImport; }

		// "extension"
		public Keyword ele001KeywordExtension() { return c001KeywordExtension; }

		// path += ID
		public Assignment ele01AssignmentPath() { return c01AssignmentPath; }

		// ID
		public RuleCall ele010LexerRuleCallID() { return c010LexerRuleCallID; }

		// ( "::" path += ID ) *
		public Group ele1Group() { return c1Group; }

		// "::"
		public Keyword ele10KeywordColonColon() { return c10KeywordColonColon; }

		// path += ID
		public Assignment ele11AssignmentPath() { return c11AssignmentPath; }

		// ID
		public RuleCall ele110LexerRuleCallID() { return c110LexerRuleCallID; }
	}

	public class NamedResourceElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(8);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Group c00000Group = (Group)c0000Group.eContents().get(0);
		private final Group c000000Group = (Group)c00000Group.eContents().get(0);
		private final Group c0000000Group = (Group)c000000Group.eContents().get(0);
		private final Group c00000000Group = (Group)c0000000Group.eContents().get(0);
		private final Keyword c000000000KeywordResource = (Keyword)c00000000Group.eContents().get(0);
		private final Assignment c000000001AssignmentName = (Assignment)c00000000Group.eContents().get(1);
		private final RuleCall c0000000010LexerRuleCallID = (RuleCall)c000000001AssignmentName.eContents().get(0);
		private final Keyword c00000001KeywordLeftCurlyBracket = (Keyword)c0000000Group.eContents().get(1);
		private final Keyword c0000001KeywordLeft = (Keyword)c000000Group.eContents().get(1);
		private final Alternatives c000001Alternatives = (Alternatives)c00000Group.eContents().get(1);
		private final Group c0000010Group = (Group)c000001Alternatives.eContents().get(0);
		private final Keyword c00000100KeywordUri = (Keyword)c0000010Group.eContents().get(0);
		private final Assignment c00000101AssignmentLeftUri = (Assignment)c0000010Group.eContents().get(1);
		private final RuleCall c000001010LexerRuleCallSTRING = (RuleCall)c00000101AssignmentLeftUri.eContents().get(0);
		private final Assignment c0000011AssignmentLeftRoot = (Assignment)c000001Alternatives.eContents().get(1);
		private final RuleCall c00000110ParserRuleCallCreatedObject = (RuleCall)c0000011AssignmentLeftRoot.eContents().get(0);
		private final Keyword c00001KeywordSemicolon = (Keyword)c0000Group.eContents().get(1);
		private final Keyword c0001KeywordRight = (Keyword)c000Group.eContents().get(1);
		private final Alternatives c001Alternatives = (Alternatives)c00Group.eContents().get(1);
		private final Group c0010Group = (Group)c001Alternatives.eContents().get(0);
		private final Keyword c00100KeywordUri = (Keyword)c0010Group.eContents().get(0);
		private final Assignment c00101AssignmentRightUri = (Assignment)c0010Group.eContents().get(1);
		private final RuleCall c001010LexerRuleCallSTRING = (RuleCall)c00101AssignmentRightUri.eContents().get(0);
		private final Assignment c0011AssignmentRightRoot = (Assignment)c001Alternatives.eContents().get(1);
		private final RuleCall c00110ParserRuleCallCreatedObject = (RuleCall)c0011AssignmentRightRoot.eContents().get(0);
		private final Keyword c01KeywordSemicolon = (Keyword)c0Group.eContents().get(1);
		private final Keyword c1KeywordRightCurlyBracket = (Keyword)cGroup.eContents().get(1);
		
		// NamedResource : "resource" name = ID "{" "left" ( "uri" leftUri = STRING | leftRoot = CreatedObject ) ";" "right" ( "uri" rightUri = STRING | rightRoot = CreatedObject ) ";" "}" ;
		public ParserRule getRule() { return rule; }

		// "resource" name = ID "{" "left" ( "uri" leftUri = STRING | leftRoot = CreatedObject ) ";" "right" ( "uri" rightUri = STRING | rightRoot = CreatedObject ) ";" "}"
		public Group eleGroup() { return cGroup; }

		// "resource" name = ID "{" "left" ( "uri" leftUri = STRING | leftRoot = CreatedObject ) ";" "right" ( "uri" rightUri = STRING | rightRoot = CreatedObject ) ";"
		public Group ele0Group() { return c0Group; }

		// "resource" name = ID "{" "left" ( "uri" leftUri = STRING | leftRoot = CreatedObject ) ";" "right" ( "uri" rightUri = STRING | rightRoot = CreatedObject )
		public Group ele00Group() { return c00Group; }

		// "resource" name = ID "{" "left" ( "uri" leftUri = STRING | leftRoot = CreatedObject ) ";" "right"
		public Group ele000Group() { return c000Group; }

		// "resource" name = ID "{" "left" ( "uri" leftUri = STRING | leftRoot = CreatedObject ) ";"
		public Group ele0000Group() { return c0000Group; }

		// "resource" name = ID "{" "left" ( "uri" leftUri = STRING | leftRoot = CreatedObject )
		public Group ele00000Group() { return c00000Group; }

		// "resource" name = ID "{" "left"
		public Group ele000000Group() { return c000000Group; }

		// "resource" name = ID "{"
		public Group ele0000000Group() { return c0000000Group; }

		// "resource" name = ID
		public Group ele00000000Group() { return c00000000Group; }

		// "resource"
		public Keyword ele000000000KeywordResource() { return c000000000KeywordResource; }

		// name = ID
		public Assignment ele000000001AssignmentName() { return c000000001AssignmentName; }

		// ID
		public RuleCall ele0000000010LexerRuleCallID() { return c0000000010LexerRuleCallID; }

		// "{"
		public Keyword ele00000001KeywordLeftCurlyBracket() { return c00000001KeywordLeftCurlyBracket; }

		// "left"
		public Keyword ele0000001KeywordLeft() { return c0000001KeywordLeft; }

		// "uri" leftUri = STRING | leftRoot = CreatedObject
		public Alternatives ele000001Alternatives() { return c000001Alternatives; }

		// "uri" leftUri = STRING
		public Group ele0000010Group() { return c0000010Group; }

		// "uri"
		public Keyword ele00000100KeywordUri() { return c00000100KeywordUri; }

		// leftUri = STRING
		public Assignment ele00000101AssignmentLeftUri() { return c00000101AssignmentLeftUri; }

		// STRING
		public RuleCall ele000001010LexerRuleCallSTRING() { return c000001010LexerRuleCallSTRING; }

		// leftRoot = CreatedObject
		public Assignment ele0000011AssignmentLeftRoot() { return c0000011AssignmentLeftRoot; }

		// CreatedObject
		public RuleCall ele00000110ParserRuleCallCreatedObject() { return c00000110ParserRuleCallCreatedObject; }

		// ";"
		public Keyword ele00001KeywordSemicolon() { return c00001KeywordSemicolon; }

		// "right"
		public Keyword ele0001KeywordRight() { return c0001KeywordRight; }

		// "uri" rightUri = STRING | rightRoot = CreatedObject
		public Alternatives ele001Alternatives() { return c001Alternatives; }

		// "uri" rightUri = STRING
		public Group ele0010Group() { return c0010Group; }

		// "uri"
		public Keyword ele00100KeywordUri() { return c00100KeywordUri; }

		// rightUri = STRING
		public Assignment ele00101AssignmentRightUri() { return c00101AssignmentRightUri; }

		// STRING
		public RuleCall ele001010LexerRuleCallSTRING() { return c001010LexerRuleCallSTRING; }

		// rightRoot = CreatedObject
		public Assignment ele0011AssignmentRightRoot() { return c0011AssignmentRightRoot; }

		// CreatedObject
		public RuleCall ele00110ParserRuleCallCreatedObject() { return c00110ParserRuleCallCreatedObject; }

		// ";"
		public Keyword ele01KeywordSemicolon() { return c01KeywordSemicolon; }

		// "}"
		public Keyword ele1KeywordRightCurlyBracket() { return c1KeywordRightCurlyBracket; }
	}

	public class NamedObjectElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(9);
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallObjectRef = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall c1ParserRuleCallCreatedObject = (RuleCall)cAlternatives.eContents().get(1);
		
		// NamedObject : ObjectRef | CreatedObject ;
		public ParserRule getRule() { return rule; }

		// ObjectRef | CreatedObject
		public Alternatives eleAlternatives() { return cAlternatives; }

		// ObjectRef
		public RuleCall ele0ParserRuleCallObjectRef() { return c0ParserRuleCallObjectRef; }

		// CreatedObject
		public RuleCall ele1ParserRuleCallCreatedObject() { return c1ParserRuleCallCreatedObject; }
	}

	public class ObjectRefElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(10);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordObject = (Keyword)c00Group.eContents().get(0);
		private final Assignment c001AssignmentName = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010LexerRuleCallID = (RuleCall)c001AssignmentName.eContents().get(0);
		private final Alternatives c01Alternatives = (Alternatives)c0Group.eContents().get(1);
		private final Group c010Group = (Group)c01Alternatives.eContents().get(0);
		private final Assignment c0100AssignmentLeftRes = (Assignment)c010Group.eContents().get(0);
		private final CrossReference c01000CrossReferenceEStringNamedResource = (CrossReference)c0100AssignmentLeftRes.eContents().get(0);
		private final Assignment c0101AssignmentLeftFrag = (Assignment)c010Group.eContents().get(1);
		private final RuleCall c01010LexerRuleCallFRAGMENT = (RuleCall)c0101AssignmentLeftFrag.eContents().get(0);
		private final Group c011Group = (Group)c01Alternatives.eContents().get(1);
		private final Group c0110Group = (Group)c011Group.eContents().get(0);
		private final Group c01100Group = (Group)c0110Group.eContents().get(0);
		private final Group c011000Group = (Group)c01100Group.eContents().get(0);
		private final Group c0110000Group = (Group)c011000Group.eContents().get(0);
		private final Keyword c01100000KeywordLeft = (Keyword)c0110000Group.eContents().get(0);
		private final Assignment c01100001AssignmentLeftRes = (Assignment)c0110000Group.eContents().get(1);
		private final CrossReference c011000010CrossReferenceEStringNamedResource = (CrossReference)c01100001AssignmentLeftRes.eContents().get(0);
		private final Assignment c0110001AssignmentLeftFrag = (Assignment)c011000Group.eContents().get(1);
		private final RuleCall c01100010LexerRuleCallFRAGMENT = (RuleCall)c0110001AssignmentLeftFrag.eContents().get(0);
		private final Keyword c011001KeywordRight = (Keyword)c01100Group.eContents().get(1);
		private final Assignment c01101AssignmentRightRes = (Assignment)c0110Group.eContents().get(1);
		private final CrossReference c011010CrossReferenceEStringNamedResource = (CrossReference)c01101AssignmentRightRes.eContents().get(0);
		private final Assignment c0111AssignmentRightFrag = (Assignment)c011Group.eContents().get(1);
		private final RuleCall c01110LexerRuleCallFRAGMENT = (RuleCall)c0111AssignmentRightFrag.eContents().get(0);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Group c10Group = (Group)c1Group.eContents().get(0);
		private final Group c100Group = (Group)c10Group.eContents().get(0);
		private final Group c1000Group = (Group)c100Group.eContents().get(0);
		private final Keyword c10000KeywordLeftCurlyBracket = (Keyword)c1000Group.eContents().get(0);
		private final Alternatives c10001Alternatives = (Alternatives)c1000Group.eContents().get(1);
		private final Assignment c100010AssignmentAssignments = (Assignment)c10001Alternatives.eContents().get(0);
		private final RuleCall c1000100ParserRuleCallBiSingleAssignment = (RuleCall)c100010AssignmentAssignments.eContents().get(0);
		private final Assignment c100011AssignmentAssignments = (Assignment)c10001Alternatives.eContents().get(1);
		private final RuleCall c1000110ParserRuleCallBiListAssignment = (RuleCall)c100011AssignmentAssignments.eContents().get(0);
		private final Group c1001Group = (Group)c100Group.eContents().get(1);
		private final Keyword c10010KeywordLeft = (Keyword)c1001Group.eContents().get(0);
		private final Assignment c10011AssignmentLeftMig = (Assignment)c1001Group.eContents().get(1);
		private final RuleCall c100110ParserRuleCallMigration = (RuleCall)c10011AssignmentLeftMig.eContents().get(0);
		private final Group c101Group = (Group)c10Group.eContents().get(1);
		private final Keyword c1010KeywordRight = (Keyword)c101Group.eContents().get(0);
		private final Assignment c1011AssignmentRightMig = (Assignment)c101Group.eContents().get(1);
		private final RuleCall c10110ParserRuleCallMigration = (RuleCall)c1011AssignmentRightMig.eContents().get(0);
		private final Keyword c11KeywordRightCurlyBracket = (Keyword)c1Group.eContents().get(1);
		
		// ObjectRef : "object" ( name = ID ) ? ( leftRes = [ NamedResource ] leftFrag = FRAGMENT | "left" leftRes = [ NamedResource ] leftFrag = FRAGMENT "right" rightRes = [ NamedResource ] rightFrag = FRAGMENT ) ( "{" ( assignments += BiSingleAssignment | assignments += BiListAssignment ) + ( "left" leftMig = Migration ) ? ( "right" rightMig = Migration ) ? "}" ) ? ;
		public ParserRule getRule() { return rule; }

		// "object" ( name = ID ) ? ( leftRes = [ NamedResource ] leftFrag = FRAGMENT | "left" leftRes = [ NamedResource ] leftFrag = FRAGMENT "right" rightRes = [ NamedResource ] rightFrag = FRAGMENT ) ( "{" ( assignments += BiSingleAssignment | assignments += BiListAssignment ) + ( "left" leftMig = Migration ) ? ( "right" rightMig = Migration ) ? "}" ) ?
		public Group eleGroup() { return cGroup; }

		// "object" ( name = ID ) ? ( leftRes = [ NamedResource ] leftFrag = FRAGMENT | "left" leftRes = [ NamedResource ] leftFrag = FRAGMENT "right" rightRes = [ NamedResource ] rightFrag = FRAGMENT )
		public Group ele0Group() { return c0Group; }

		// "object" ( name = ID ) ?
		public Group ele00Group() { return c00Group; }

		// "object"
		public Keyword ele000KeywordObject() { return c000KeywordObject; }

		// ( name = ID ) ?
		public Assignment ele001AssignmentName() { return c001AssignmentName; }

		// ID
		public RuleCall ele0010LexerRuleCallID() { return c0010LexerRuleCallID; }

		// leftRes = [ NamedResource ] leftFrag = FRAGMENT | "left" leftRes = [ NamedResource ] leftFrag = FRAGMENT "right" rightRes = [ NamedResource ] rightFrag = FRAGMENT
		public Alternatives ele01Alternatives() { return c01Alternatives; }

		// leftRes = [ NamedResource ] leftFrag = FRAGMENT
		public Group ele010Group() { return c010Group; }

		// leftRes = [ NamedResource ]
		public Assignment ele0100AssignmentLeftRes() { return c0100AssignmentLeftRes; }

		// [ NamedResource ]
		public CrossReference ele01000CrossReferenceEStringNamedResource() { return c01000CrossReferenceEStringNamedResource; }

		// leftFrag = FRAGMENT
		public Assignment ele0101AssignmentLeftFrag() { return c0101AssignmentLeftFrag; }

		// FRAGMENT
		public RuleCall ele01010LexerRuleCallFRAGMENT() { return c01010LexerRuleCallFRAGMENT; }

		// "left" leftRes = [ NamedResource ] leftFrag = FRAGMENT "right" rightRes = [ NamedResource ] rightFrag = FRAGMENT
		public Group ele011Group() { return c011Group; }

		// "left" leftRes = [ NamedResource ] leftFrag = FRAGMENT "right" rightRes = [ NamedResource ]
		public Group ele0110Group() { return c0110Group; }

		// "left" leftRes = [ NamedResource ] leftFrag = FRAGMENT "right"
		public Group ele01100Group() { return c01100Group; }

		// "left" leftRes = [ NamedResource ] leftFrag = FRAGMENT
		public Group ele011000Group() { return c011000Group; }

		// "left" leftRes = [ NamedResource ]
		public Group ele0110000Group() { return c0110000Group; }

		// "left"
		public Keyword ele01100000KeywordLeft() { return c01100000KeywordLeft; }

		// leftRes = [ NamedResource ]
		public Assignment ele01100001AssignmentLeftRes() { return c01100001AssignmentLeftRes; }

		// [ NamedResource ]
		public CrossReference ele011000010CrossReferenceEStringNamedResource() { return c011000010CrossReferenceEStringNamedResource; }

		// leftFrag = FRAGMENT
		public Assignment ele0110001AssignmentLeftFrag() { return c0110001AssignmentLeftFrag; }

		// FRAGMENT
		public RuleCall ele01100010LexerRuleCallFRAGMENT() { return c01100010LexerRuleCallFRAGMENT; }

		// "right"
		public Keyword ele011001KeywordRight() { return c011001KeywordRight; }

		// rightRes = [ NamedResource ]
		public Assignment ele01101AssignmentRightRes() { return c01101AssignmentRightRes; }

		// [ NamedResource ]
		public CrossReference ele011010CrossReferenceEStringNamedResource() { return c011010CrossReferenceEStringNamedResource; }

		// rightFrag = FRAGMENT
		public Assignment ele0111AssignmentRightFrag() { return c0111AssignmentRightFrag; }

		// FRAGMENT
		public RuleCall ele01110LexerRuleCallFRAGMENT() { return c01110LexerRuleCallFRAGMENT; }

		// ( "{" ( assignments += BiSingleAssignment | assignments += BiListAssignment ) + ( "left" leftMig = Migration ) ? ( "right" rightMig = Migration ) ? "}" ) ?
		public Group ele1Group() { return c1Group; }

		// "{" ( assignments += BiSingleAssignment | assignments += BiListAssignment ) + ( "left" leftMig = Migration ) ? ( "right" rightMig = Migration ) ?
		public Group ele10Group() { return c10Group; }

		// "{" ( assignments += BiSingleAssignment | assignments += BiListAssignment ) + ( "left" leftMig = Migration ) ?
		public Group ele100Group() { return c100Group; }

		// "{" ( assignments += BiSingleAssignment | assignments += BiListAssignment ) +
		public Group ele1000Group() { return c1000Group; }

		// "{"
		public Keyword ele10000KeywordLeftCurlyBracket() { return c10000KeywordLeftCurlyBracket; }

		// ( assignments += BiSingleAssignment | assignments += BiListAssignment ) +
		public Alternatives ele10001Alternatives() { return c10001Alternatives; }

		// assignments += BiSingleAssignment
		public Assignment ele100010AssignmentAssignments() { return c100010AssignmentAssignments; }

		// BiSingleAssignment
		public RuleCall ele1000100ParserRuleCallBiSingleAssignment() { return c1000100ParserRuleCallBiSingleAssignment; }

		// assignments += BiListAssignment
		public Assignment ele100011AssignmentAssignments() { return c100011AssignmentAssignments; }

		// BiListAssignment
		public RuleCall ele1000110ParserRuleCallBiListAssignment() { return c1000110ParserRuleCallBiListAssignment; }

		// ( "left" leftMig = Migration ) ?
		public Group ele1001Group() { return c1001Group; }

		// "left"
		public Keyword ele10010KeywordLeft() { return c10010KeywordLeft; }

		// leftMig = Migration
		public Assignment ele10011AssignmentLeftMig() { return c10011AssignmentLeftMig; }

		// Migration
		public RuleCall ele100110ParserRuleCallMigration() { return c100110ParserRuleCallMigration; }

		// ( "right" rightMig = Migration ) ?
		public Group ele101Group() { return c101Group; }

		// "right"
		public Keyword ele1010KeywordRight() { return c1010KeywordRight; }

		// rightMig = Migration
		public Assignment ele1011AssignmentRightMig() { return c1011AssignmentRightMig; }

		// Migration
		public RuleCall ele10110ParserRuleCallMigration() { return c10110ParserRuleCallMigration; }

		// "}"
		public Keyword ele11KeywordRightCurlyBracket() { return c11KeywordRightCurlyBracket; }
	}

	public class AssignmentElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(11);
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Alternatives c0Alternatives = (Alternatives)cAlternatives.eContents().get(0);
		private final Alternatives c00Alternatives = (Alternatives)c0Alternatives.eContents().get(0);
		private final RuleCall c000ParserRuleCallBiSingleAssignment = (RuleCall)c00Alternatives.eContents().get(0);
		private final RuleCall c001ParserRuleCallBiListAssignment = (RuleCall)c00Alternatives.eContents().get(1);
		private final RuleCall c01ParserRuleCallMonoSingleAssignment = (RuleCall)c0Alternatives.eContents().get(1);
		private final RuleCall c1ParserRuleCallMonoListAssignment = (RuleCall)cAlternatives.eContents().get(1);
		
		// Assignment : BiSingleAssignment | BiListAssignment | MonoSingleAssignment | MonoListAssignment ;
		public ParserRule getRule() { return rule; }

		// BiSingleAssignment | BiListAssignment | MonoSingleAssignment | MonoListAssignment
		public Alternatives eleAlternatives() { return cAlternatives; }

		// BiSingleAssignment | BiListAssignment | MonoSingleAssignment
		public Alternatives ele0Alternatives() { return c0Alternatives; }

		// BiSingleAssignment | BiListAssignment
		public Alternatives ele00Alternatives() { return c00Alternatives; }

		// BiSingleAssignment
		public RuleCall ele000ParserRuleCallBiSingleAssignment() { return c000ParserRuleCallBiSingleAssignment; }

		// BiListAssignment
		public RuleCall ele001ParserRuleCallBiListAssignment() { return c001ParserRuleCallBiListAssignment; }

		// MonoSingleAssignment
		public RuleCall ele01ParserRuleCallMonoSingleAssignment() { return c01ParserRuleCallMonoSingleAssignment; }

		// MonoListAssignment
		public RuleCall ele1ParserRuleCallMonoListAssignment() { return c1ParserRuleCallMonoListAssignment; }
	}

	public class BiSingleAssignmentElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(12);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Assignment c00000AssignmentFeature = (Assignment)c0000Group.eContents().get(0);
		private final RuleCall c000000LexerRuleCallID = (RuleCall)c00000AssignmentFeature.eContents().get(0);
		private final Keyword c00001KeywordEqualsSign = (Keyword)c0000Group.eContents().get(1);
		private final Assignment c0001AssignmentLeftValue = (Assignment)c000Group.eContents().get(1);
		private final RuleCall c00010ParserRuleCallSingleAssignmentValue = (RuleCall)c0001AssignmentLeftValue.eContents().get(0);
		private final Keyword c001KeywordVerticalLine = (Keyword)c00Group.eContents().get(1);
		private final Assignment c01AssignmentRightValue = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010ParserRuleCallSingleAssignmentValue = (RuleCall)c01AssignmentRightValue.eContents().get(0);
		private final Keyword c1KeywordSemicolon = (Keyword)cGroup.eContents().get(1);
		
		// BiSingleAssignment returns SingleAssignment : feature = ID "=" leftValue = SingleAssignmentValue "|" rightValue = SingleAssignmentValue ";" ;
		public ParserRule getRule() { return rule; }

		// feature = ID "=" leftValue = SingleAssignmentValue "|" rightValue = SingleAssignmentValue ";"
		public Group eleGroup() { return cGroup; }

		// feature = ID "=" leftValue = SingleAssignmentValue "|" rightValue = SingleAssignmentValue
		public Group ele0Group() { return c0Group; }

		// feature = ID "=" leftValue = SingleAssignmentValue "|"
		public Group ele00Group() { return c00Group; }

		// feature = ID "=" leftValue = SingleAssignmentValue
		public Group ele000Group() { return c000Group; }

		// feature = ID "="
		public Group ele0000Group() { return c0000Group; }

		// feature = ID
		public Assignment ele00000AssignmentFeature() { return c00000AssignmentFeature; }

		// ID
		public RuleCall ele000000LexerRuleCallID() { return c000000LexerRuleCallID; }

		// "="
		public Keyword ele00001KeywordEqualsSign() { return c00001KeywordEqualsSign; }

		// leftValue = SingleAssignmentValue
		public Assignment ele0001AssignmentLeftValue() { return c0001AssignmentLeftValue; }

		// SingleAssignmentValue
		public RuleCall ele00010ParserRuleCallSingleAssignmentValue() { return c00010ParserRuleCallSingleAssignmentValue; }

		// "|"
		public Keyword ele001KeywordVerticalLine() { return c001KeywordVerticalLine; }

		// rightValue = SingleAssignmentValue
		public Assignment ele01AssignmentRightValue() { return c01AssignmentRightValue; }

		// SingleAssignmentValue
		public RuleCall ele010ParserRuleCallSingleAssignmentValue() { return c010ParserRuleCallSingleAssignmentValue; }

		// ";"
		public Keyword ele1KeywordSemicolon() { return c1KeywordSemicolon; }
	}

	public class BiListAssignmentElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(13);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Group c00000Group = (Group)c0000Group.eContents().get(0);
		private final Group c000000Group = (Group)c00000Group.eContents().get(0);
		private final Assignment c0000000AssignmentFeature = (Assignment)c000000Group.eContents().get(0);
		private final RuleCall c00000000LexerRuleCallID = (RuleCall)c0000000AssignmentFeature.eContents().get(0);
		private final Keyword c0000001KeywordEqualsSign = (Keyword)c000000Group.eContents().get(1);
		private final Keyword c000001KeywordLeftSquareBracket = (Keyword)c00000Group.eContents().get(1);
		private final Group c00001Group = (Group)c0000Group.eContents().get(1);
		private final Assignment c000010AssignmentLeftValues = (Assignment)c00001Group.eContents().get(0);
		private final RuleCall c0000100ParserRuleCallListAssignmentValue = (RuleCall)c000010AssignmentLeftValues.eContents().get(0);
		private final Group c000011Group = (Group)c00001Group.eContents().get(1);
		private final Keyword c0000110KeywordComma = (Keyword)c000011Group.eContents().get(0);
		private final Assignment c0000111AssignmentLeftValues = (Assignment)c000011Group.eContents().get(1);
		private final RuleCall c00001110ParserRuleCallListAssignmentValue = (RuleCall)c0000111AssignmentLeftValues.eContents().get(0);
		private final Keyword c0001KeywordVerticalLine = (Keyword)c000Group.eContents().get(1);
		private final Group c001Group = (Group)c00Group.eContents().get(1);
		private final Assignment c0010AssignmentRightValues = (Assignment)c001Group.eContents().get(0);
		private final RuleCall c00100ParserRuleCallListAssignmentValue = (RuleCall)c0010AssignmentRightValues.eContents().get(0);
		private final Group c0011Group = (Group)c001Group.eContents().get(1);
		private final Keyword c00110KeywordComma = (Keyword)c0011Group.eContents().get(0);
		private final Assignment c00111AssignmentRightValues = (Assignment)c0011Group.eContents().get(1);
		private final RuleCall c001110ParserRuleCallListAssignmentValue = (RuleCall)c00111AssignmentRightValues.eContents().get(0);
		private final Keyword c01KeywordRightSquareBracket = (Keyword)c0Group.eContents().get(1);
		private final Keyword c1KeywordSemicolon = (Keyword)cGroup.eContents().get(1);
		
		// BiListAssignment returns ListAssignment : feature = ID "=" "[" ( leftValues += ListAssignmentValue ( "," leftValues += ListAssignmentValue ) * ) ? "|" ( rightValues += ListAssignmentValue ( "," rightValues += ListAssignmentValue ) * ) ? "]" ";" ;
		public ParserRule getRule() { return rule; }

		// feature = ID "=" "[" ( leftValues += ListAssignmentValue ( "," leftValues += ListAssignmentValue ) * ) ? "|" ( rightValues += ListAssignmentValue ( "," rightValues += ListAssignmentValue ) * ) ? "]" ";"
		public Group eleGroup() { return cGroup; }

		// feature = ID "=" "[" ( leftValues += ListAssignmentValue ( "," leftValues += ListAssignmentValue ) * ) ? "|" ( rightValues += ListAssignmentValue ( "," rightValues += ListAssignmentValue ) * ) ? "]"
		public Group ele0Group() { return c0Group; }

		// feature = ID "=" "[" ( leftValues += ListAssignmentValue ( "," leftValues += ListAssignmentValue ) * ) ? "|" ( rightValues += ListAssignmentValue ( "," rightValues += ListAssignmentValue ) * ) ?
		public Group ele00Group() { return c00Group; }

		// feature = ID "=" "[" ( leftValues += ListAssignmentValue ( "," leftValues += ListAssignmentValue ) * ) ? "|"
		public Group ele000Group() { return c000Group; }

		// feature = ID "=" "[" ( leftValues += ListAssignmentValue ( "," leftValues += ListAssignmentValue ) * ) ?
		public Group ele0000Group() { return c0000Group; }

		// feature = ID "=" "["
		public Group ele00000Group() { return c00000Group; }

		// feature = ID "="
		public Group ele000000Group() { return c000000Group; }

		// feature = ID
		public Assignment ele0000000AssignmentFeature() { return c0000000AssignmentFeature; }

		// ID
		public RuleCall ele00000000LexerRuleCallID() { return c00000000LexerRuleCallID; }

		// "="
		public Keyword ele0000001KeywordEqualsSign() { return c0000001KeywordEqualsSign; }

		// "["
		public Keyword ele000001KeywordLeftSquareBracket() { return c000001KeywordLeftSquareBracket; }

		// ( leftValues += ListAssignmentValue ( "," leftValues += ListAssignmentValue ) * ) ?
		public Group ele00001Group() { return c00001Group; }

		// leftValues += ListAssignmentValue
		public Assignment ele000010AssignmentLeftValues() { return c000010AssignmentLeftValues; }

		// ListAssignmentValue
		public RuleCall ele0000100ParserRuleCallListAssignmentValue() { return c0000100ParserRuleCallListAssignmentValue; }

		// ( "," leftValues += ListAssignmentValue ) *
		public Group ele000011Group() { return c000011Group; }

		// ","
		public Keyword ele0000110KeywordComma() { return c0000110KeywordComma; }

		// leftValues += ListAssignmentValue
		public Assignment ele0000111AssignmentLeftValues() { return c0000111AssignmentLeftValues; }

		// ListAssignmentValue
		public RuleCall ele00001110ParserRuleCallListAssignmentValue() { return c00001110ParserRuleCallListAssignmentValue; }

		// "|"
		public Keyword ele0001KeywordVerticalLine() { return c0001KeywordVerticalLine; }

		// ( rightValues += ListAssignmentValue ( "," rightValues += ListAssignmentValue ) * ) ?
		public Group ele001Group() { return c001Group; }

		// rightValues += ListAssignmentValue
		public Assignment ele0010AssignmentRightValues() { return c0010AssignmentRightValues; }

		// ListAssignmentValue
		public RuleCall ele00100ParserRuleCallListAssignmentValue() { return c00100ParserRuleCallListAssignmentValue; }

		// ( "," rightValues += ListAssignmentValue ) *
		public Group ele0011Group() { return c0011Group; }

		// ","
		public Keyword ele00110KeywordComma() { return c00110KeywordComma; }

		// rightValues += ListAssignmentValue
		public Assignment ele00111AssignmentRightValues() { return c00111AssignmentRightValues; }

		// ListAssignmentValue
		public RuleCall ele001110ParserRuleCallListAssignmentValue() { return c001110ParserRuleCallListAssignmentValue; }

		// "]"
		public Keyword ele01KeywordRightSquareBracket() { return c01KeywordRightSquareBracket; }

		// ";"
		public Keyword ele1KeywordSemicolon() { return c1KeywordSemicolon; }
	}

	public class MonoSingleAssignmentElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(14);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Assignment c000AssignmentFeature = (Assignment)c00Group.eContents().get(0);
		private final RuleCall c0000LexerRuleCallID = (RuleCall)c000AssignmentFeature.eContents().get(0);
		private final Keyword c001KeywordEqualsSign = (Keyword)c00Group.eContents().get(1);
		private final Assignment c01AssignmentLeftValue = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010ParserRuleCallSingleAssignmentValue = (RuleCall)c01AssignmentLeftValue.eContents().get(0);
		private final Keyword c1KeywordSemicolon = (Keyword)cGroup.eContents().get(1);
		
		// MonoSingleAssignment returns SingleAssignment : feature = ID "=" leftValue = SingleAssignmentValue ";" ;
		public ParserRule getRule() { return rule; }

		// feature = ID "=" leftValue = SingleAssignmentValue ";"
		public Group eleGroup() { return cGroup; }

		// feature = ID "=" leftValue = SingleAssignmentValue
		public Group ele0Group() { return c0Group; }

		// feature = ID "="
		public Group ele00Group() { return c00Group; }

		// feature = ID
		public Assignment ele000AssignmentFeature() { return c000AssignmentFeature; }

		// ID
		public RuleCall ele0000LexerRuleCallID() { return c0000LexerRuleCallID; }

		// "="
		public Keyword ele001KeywordEqualsSign() { return c001KeywordEqualsSign; }

		// leftValue = SingleAssignmentValue
		public Assignment ele01AssignmentLeftValue() { return c01AssignmentLeftValue; }

		// SingleAssignmentValue
		public RuleCall ele010ParserRuleCallSingleAssignmentValue() { return c010ParserRuleCallSingleAssignmentValue; }

		// ";"
		public Keyword ele1KeywordSemicolon() { return c1KeywordSemicolon; }
	}

	public class MonoListAssignmentElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(15);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Assignment c00000AssignmentFeature = (Assignment)c0000Group.eContents().get(0);
		private final RuleCall c000000LexerRuleCallID = (RuleCall)c00000AssignmentFeature.eContents().get(0);
		private final Keyword c00001KeywordEqualsSign = (Keyword)c0000Group.eContents().get(1);
		private final Keyword c0001KeywordLeftSquareBracket = (Keyword)c000Group.eContents().get(1);
		private final Group c001Group = (Group)c00Group.eContents().get(1);
		private final Assignment c0010AssignmentLeftValues = (Assignment)c001Group.eContents().get(0);
		private final RuleCall c00100ParserRuleCallAssignmentValue = (RuleCall)c0010AssignmentLeftValues.eContents().get(0);
		private final Group c0011Group = (Group)c001Group.eContents().get(1);
		private final Keyword c00110KeywordComma = (Keyword)c0011Group.eContents().get(0);
		private final Assignment c00111AssignmentLeftValues = (Assignment)c0011Group.eContents().get(1);
		private final RuleCall c001110ParserRuleCallAssignmentValue = (RuleCall)c00111AssignmentLeftValues.eContents().get(0);
		private final Keyword c01KeywordRightSquareBracket = (Keyword)c0Group.eContents().get(1);
		private final Keyword c1KeywordSemicolon = (Keyword)cGroup.eContents().get(1);
		
		// MonoListAssignment returns ListAssignment : feature = ID "=" "[" ( leftValues += AssignmentValue ( "," leftValues += AssignmentValue ) * ) ? "]" ";" ;
		public ParserRule getRule() { return rule; }

		// feature = ID "=" "[" ( leftValues += AssignmentValue ( "," leftValues += AssignmentValue ) * ) ? "]" ";"
		public Group eleGroup() { return cGroup; }

		// feature = ID "=" "[" ( leftValues += AssignmentValue ( "," leftValues += AssignmentValue ) * ) ? "]"
		public Group ele0Group() { return c0Group; }

		// feature = ID "=" "[" ( leftValues += AssignmentValue ( "," leftValues += AssignmentValue ) * ) ?
		public Group ele00Group() { return c00Group; }

		// feature = ID "=" "["
		public Group ele000Group() { return c000Group; }

		// feature = ID "="
		public Group ele0000Group() { return c0000Group; }

		// feature = ID
		public Assignment ele00000AssignmentFeature() { return c00000AssignmentFeature; }

		// ID
		public RuleCall ele000000LexerRuleCallID() { return c000000LexerRuleCallID; }

		// "="
		public Keyword ele00001KeywordEqualsSign() { return c00001KeywordEqualsSign; }

		// "["
		public Keyword ele0001KeywordLeftSquareBracket() { return c0001KeywordLeftSquareBracket; }

		// ( leftValues += AssignmentValue ( "," leftValues += AssignmentValue ) * ) ?
		public Group ele001Group() { return c001Group; }

		// leftValues += AssignmentValue
		public Assignment ele0010AssignmentLeftValues() { return c0010AssignmentLeftValues; }

		// AssignmentValue
		public RuleCall ele00100ParserRuleCallAssignmentValue() { return c00100ParserRuleCallAssignmentValue; }

		// ( "," leftValues += AssignmentValue ) *
		public Group ele0011Group() { return c0011Group; }

		// ","
		public Keyword ele00110KeywordComma() { return c00110KeywordComma; }

		// leftValues += AssignmentValue
		public Assignment ele00111AssignmentLeftValues() { return c00111AssignmentLeftValues; }

		// AssignmentValue
		public RuleCall ele001110ParserRuleCallAssignmentValue() { return c001110ParserRuleCallAssignmentValue; }

		// "]"
		public Keyword ele01KeywordRightSquareBracket() { return c01KeywordRightSquareBracket; }

		// ";"
		public Keyword ele1KeywordSemicolon() { return c1KeywordSemicolon; }
	}

	public class AssignmentValueElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(16);
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Alternatives c0Alternatives = (Alternatives)cAlternatives.eContents().get(0);
		private final Alternatives c00Alternatives = (Alternatives)c0Alternatives.eContents().get(0);
		private final Assignment c000AssignmentValue = (Assignment)c00Alternatives.eContents().get(0);
		private final RuleCall c0000LexerRuleCallSTRING = (RuleCall)c000AssignmentValue.eContents().get(0);
		private final Group c001Group = (Group)c00Alternatives.eContents().get(1);
		private final Assignment c0010AssignmentRefObject = (Assignment)c001Group.eContents().get(0);
		private final CrossReference c00100CrossReferenceEStringNamedObject = (CrossReference)c0010AssignmentRefObject.eContents().get(0);
		private final Group c0011Group = (Group)c001Group.eContents().get(1);
		private final Group c00110Group = (Group)c0011Group.eContents().get(0);
		private final Keyword c001100KeywordFullStop = (Keyword)c00110Group.eContents().get(0);
		private final Assignment c001101AssignmentRefFeature = (Assignment)c00110Group.eContents().get(1);
		private final RuleCall c0011010LexerRuleCallID = (RuleCall)c001101AssignmentRefFeature.eContents().get(0);
		private final Group c00111Group = (Group)c0011Group.eContents().get(1);
		private final Group c001110Group = (Group)c00111Group.eContents().get(0);
		private final Keyword c0011100KeywordLeftSquareBracket = (Keyword)c001110Group.eContents().get(0);
		private final Assignment c0011101AssignmentRefIndex = (Assignment)c001110Group.eContents().get(1);
		private final RuleCall c00111010LexerRuleCallINT = (RuleCall)c0011101AssignmentRefIndex.eContents().get(0);
		private final Keyword c001111KeywordRightSquareBracket = (Keyword)c00111Group.eContents().get(1);
		private final Assignment c01AssignmentNewObject = (Assignment)c0Alternatives.eContents().get(1);
		private final RuleCall c010ParserRuleCallCreatedObject = (RuleCall)c01AssignmentNewObject.eContents().get(0);
		private final Group c1Group = (Group)cAlternatives.eContents().get(1);
		private final Assignment c10AssignmentImport = (Assignment)c1Group.eContents().get(0);
		private final CrossReference c100CrossReferenceEStringImport = (CrossReference)c10AssignmentImport.eContents().get(0);
		private final Assignment c11AssignmentImpFrag = (Assignment)c1Group.eContents().get(1);
		private final RuleCall c110LexerRuleCallFRAGMENT = (RuleCall)c11AssignmentImpFrag.eContents().get(0);
		
		// AssignmentValue : value = STRING | refObject = [ NamedObject ] ( "." refFeature = ID ( "[" refIndex = INT "]" ) ? ) ? | newObject = CreatedObject | ^import = [ Import ] impFrag = FRAGMENT ;
		public ParserRule getRule() { return rule; }

		// value = STRING | refObject = [ NamedObject ] ( "." refFeature = ID ( "[" refIndex = INT "]" ) ? ) ? | newObject = CreatedObject | ^import = [ Import ] impFrag = FRAGMENT
		public Alternatives eleAlternatives() { return cAlternatives; }

		// value = STRING | refObject = [ NamedObject ] ( "." refFeature = ID ( "[" refIndex = INT "]" ) ? ) ? | newObject = CreatedObject
		public Alternatives ele0Alternatives() { return c0Alternatives; }

		// value = STRING | refObject = [ NamedObject ] ( "." refFeature = ID ( "[" refIndex = INT "]" ) ? ) ?
		public Alternatives ele00Alternatives() { return c00Alternatives; }

		// value = STRING
		public Assignment ele000AssignmentValue() { return c000AssignmentValue; }

		// STRING
		public RuleCall ele0000LexerRuleCallSTRING() { return c0000LexerRuleCallSTRING; }

		// refObject = [ NamedObject ] ( "." refFeature = ID ( "[" refIndex = INT "]" ) ? ) ?
		public Group ele001Group() { return c001Group; }

		// refObject = [ NamedObject ]
		public Assignment ele0010AssignmentRefObject() { return c0010AssignmentRefObject; }

		// [ NamedObject ]
		public CrossReference ele00100CrossReferenceEStringNamedObject() { return c00100CrossReferenceEStringNamedObject; }

		// ( "." refFeature = ID ( "[" refIndex = INT "]" ) ? ) ?
		public Group ele0011Group() { return c0011Group; }

		// "." refFeature = ID
		public Group ele00110Group() { return c00110Group; }

		// "."
		public Keyword ele001100KeywordFullStop() { return c001100KeywordFullStop; }

		// refFeature = ID
		public Assignment ele001101AssignmentRefFeature() { return c001101AssignmentRefFeature; }

		// ID
		public RuleCall ele0011010LexerRuleCallID() { return c0011010LexerRuleCallID; }

		// ( "[" refIndex = INT "]" ) ?
		public Group ele00111Group() { return c00111Group; }

		// "[" refIndex = INT
		public Group ele001110Group() { return c001110Group; }

		// "["
		public Keyword ele0011100KeywordLeftSquareBracket() { return c0011100KeywordLeftSquareBracket; }

		// refIndex = INT
		public Assignment ele0011101AssignmentRefIndex() { return c0011101AssignmentRefIndex; }

		// INT
		public RuleCall ele00111010LexerRuleCallINT() { return c00111010LexerRuleCallINT; }

		// "]"
		public Keyword ele001111KeywordRightSquareBracket() { return c001111KeywordRightSquareBracket; }

		// newObject = CreatedObject
		public Assignment ele01AssignmentNewObject() { return c01AssignmentNewObject; }

		// CreatedObject
		public RuleCall ele010ParserRuleCallCreatedObject() { return c010ParserRuleCallCreatedObject; }

		// ^import = [ Import ] impFrag = FRAGMENT
		public Group ele1Group() { return c1Group; }

		// ^import = [ Import ]
		public Assignment ele10AssignmentImport() { return c10AssignmentImport; }

		// [ Import ]
		public CrossReference ele100CrossReferenceEStringImport() { return c100CrossReferenceEStringImport; }

		// impFrag = FRAGMENT
		public Assignment ele11AssignmentImpFrag() { return c11AssignmentImpFrag; }

		// FRAGMENT
		public RuleCall ele110LexerRuleCallFRAGMENT() { return c110LexerRuleCallFRAGMENT; }
	}

	public class ListAssignmentValueElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(17);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Assignment c00AssignmentIndex = (Assignment)c0Group.eContents().get(0);
		private final RuleCall c000LexerRuleCallINT = (RuleCall)c00AssignmentIndex.eContents().get(0);
		private final Keyword c01KeywordColon = (Keyword)c0Group.eContents().get(1);
		private final Alternatives c1Alternatives = (Alternatives)cGroup.eContents().get(1);
		private final Alternatives c10Alternatives = (Alternatives)c1Alternatives.eContents().get(0);
		private final Alternatives c100Alternatives = (Alternatives)c10Alternatives.eContents().get(0);
		private final Alternatives c1000Alternatives = (Alternatives)c100Alternatives.eContents().get(0);
		private final Group c10000Group = (Group)c1000Alternatives.eContents().get(0);
		private final Group c100000Group = (Group)c10000Group.eContents().get(0);
		private final Keyword c1000000KeywordLeftSquareBracket = (Keyword)c100000Group.eContents().get(0);
		private final Assignment c1000001AssignmentRefIndex = (Assignment)c100000Group.eContents().get(1);
		private final RuleCall c10000010LexerRuleCallINT = (RuleCall)c1000001AssignmentRefIndex.eContents().get(0);
		private final Keyword c100001KeywordRightSquareBracket = (Keyword)c10000Group.eContents().get(1);
		private final Assignment c10001AssignmentValue = (Assignment)c1000Alternatives.eContents().get(1);
		private final RuleCall c100010LexerRuleCallSTRING = (RuleCall)c10001AssignmentValue.eContents().get(0);
		private final Group c1001Group = (Group)c100Alternatives.eContents().get(1);
		private final Assignment c10010AssignmentRefObject = (Assignment)c1001Group.eContents().get(0);
		private final CrossReference c100100CrossReferenceEStringNamedObject = (CrossReference)c10010AssignmentRefObject.eContents().get(0);
		private final Group c10011Group = (Group)c1001Group.eContents().get(1);
		private final Group c100110Group = (Group)c10011Group.eContents().get(0);
		private final Keyword c1001100KeywordFullStop = (Keyword)c100110Group.eContents().get(0);
		private final Assignment c1001101AssignmentRefFeature = (Assignment)c100110Group.eContents().get(1);
		private final RuleCall c10011010LexerRuleCallID = (RuleCall)c1001101AssignmentRefFeature.eContents().get(0);
		private final Group c100111Group = (Group)c10011Group.eContents().get(1);
		private final Group c1001110Group = (Group)c100111Group.eContents().get(0);
		private final Keyword c10011100KeywordLeftSquareBracket = (Keyword)c1001110Group.eContents().get(0);
		private final Assignment c10011101AssignmentRefIndex = (Assignment)c1001110Group.eContents().get(1);
		private final RuleCall c100111010LexerRuleCallINT = (RuleCall)c10011101AssignmentRefIndex.eContents().get(0);
		private final Keyword c1001111KeywordRightSquareBracket = (Keyword)c100111Group.eContents().get(1);
		private final Assignment c101AssignmentNewObject = (Assignment)c10Alternatives.eContents().get(1);
		private final RuleCall c1010ParserRuleCallCreatedObject = (RuleCall)c101AssignmentNewObject.eContents().get(0);
		private final Group c11Group = (Group)c1Alternatives.eContents().get(1);
		private final Assignment c110AssignmentImport = (Assignment)c11Group.eContents().get(0);
		private final CrossReference c1100CrossReferenceEStringImport = (CrossReference)c110AssignmentImport.eContents().get(0);
		private final Assignment c111AssignmentImpFrag = (Assignment)c11Group.eContents().get(1);
		private final RuleCall c1110LexerRuleCallFRAGMENT = (RuleCall)c111AssignmentImpFrag.eContents().get(0);
		
		// ListAssignmentValue returns AssignmentValue : index = INT ":" ( "[" refIndex = INT "]" | value = STRING | refObject = [ NamedObject ] ( "." refFeature = ID ( "[" refIndex = INT "]" ) ? ) ? | newObject = CreatedObject | ^import = [ Import ] impFrag = FRAGMENT ) ;
		public ParserRule getRule() { return rule; }

		// index = INT ":" ( "[" refIndex = INT "]" | value = STRING | refObject = [ NamedObject ] ( "." refFeature = ID ( "[" refIndex = INT "]" ) ? ) ? | newObject = CreatedObject | ^import = [ Import ] impFrag = FRAGMENT )
		public Group eleGroup() { return cGroup; }

		// index = INT ":"
		public Group ele0Group() { return c0Group; }

		// index = INT
		public Assignment ele00AssignmentIndex() { return c00AssignmentIndex; }

		// INT
		public RuleCall ele000LexerRuleCallINT() { return c000LexerRuleCallINT; }

		// ":"
		public Keyword ele01KeywordColon() { return c01KeywordColon; }

		// "[" refIndex = INT "]" | value = STRING | refObject = [ NamedObject ] ( "." refFeature = ID ( "[" refIndex = INT "]" ) ? ) ? | newObject = CreatedObject | ^import = [ Import ] impFrag = FRAGMENT
		public Alternatives ele1Alternatives() { return c1Alternatives; }

		// "[" refIndex = INT "]" | value = STRING | refObject = [ NamedObject ] ( "." refFeature = ID ( "[" refIndex = INT "]" ) ? ) ? | newObject = CreatedObject
		public Alternatives ele10Alternatives() { return c10Alternatives; }

		// "[" refIndex = INT "]" | value = STRING | refObject = [ NamedObject ] ( "." refFeature = ID ( "[" refIndex = INT "]" ) ? ) ?
		public Alternatives ele100Alternatives() { return c100Alternatives; }

		// "[" refIndex = INT "]" | value = STRING
		public Alternatives ele1000Alternatives() { return c1000Alternatives; }

		// "[" refIndex = INT "]"
		public Group ele10000Group() { return c10000Group; }

		// "[" refIndex = INT
		public Group ele100000Group() { return c100000Group; }

		// "["
		public Keyword ele1000000KeywordLeftSquareBracket() { return c1000000KeywordLeftSquareBracket; }

		// refIndex = INT
		public Assignment ele1000001AssignmentRefIndex() { return c1000001AssignmentRefIndex; }

		// INT
		public RuleCall ele10000010LexerRuleCallINT() { return c10000010LexerRuleCallINT; }

		// "]"
		public Keyword ele100001KeywordRightSquareBracket() { return c100001KeywordRightSquareBracket; }

		// value = STRING
		public Assignment ele10001AssignmentValue() { return c10001AssignmentValue; }

		// STRING
		public RuleCall ele100010LexerRuleCallSTRING() { return c100010LexerRuleCallSTRING; }

		// refObject = [ NamedObject ] ( "." refFeature = ID ( "[" refIndex = INT "]" ) ? ) ?
		public Group ele1001Group() { return c1001Group; }

		// refObject = [ NamedObject ]
		public Assignment ele10010AssignmentRefObject() { return c10010AssignmentRefObject; }

		// [ NamedObject ]
		public CrossReference ele100100CrossReferenceEStringNamedObject() { return c100100CrossReferenceEStringNamedObject; }

		// ( "." refFeature = ID ( "[" refIndex = INT "]" ) ? ) ?
		public Group ele10011Group() { return c10011Group; }

		// "." refFeature = ID
		public Group ele100110Group() { return c100110Group; }

		// "."
		public Keyword ele1001100KeywordFullStop() { return c1001100KeywordFullStop; }

		// refFeature = ID
		public Assignment ele1001101AssignmentRefFeature() { return c1001101AssignmentRefFeature; }

		// ID
		public RuleCall ele10011010LexerRuleCallID() { return c10011010LexerRuleCallID; }

		// ( "[" refIndex = INT "]" ) ?
		public Group ele100111Group() { return c100111Group; }

		// "[" refIndex = INT
		public Group ele1001110Group() { return c1001110Group; }

		// "["
		public Keyword ele10011100KeywordLeftSquareBracket() { return c10011100KeywordLeftSquareBracket; }

		// refIndex = INT
		public Assignment ele10011101AssignmentRefIndex() { return c10011101AssignmentRefIndex; }

		// INT
		public RuleCall ele100111010LexerRuleCallINT() { return c100111010LexerRuleCallINT; }

		// "]"
		public Keyword ele1001111KeywordRightSquareBracket() { return c1001111KeywordRightSquareBracket; }

		// newObject = CreatedObject
		public Assignment ele101AssignmentNewObject() { return c101AssignmentNewObject; }

		// CreatedObject
		public RuleCall ele1010ParserRuleCallCreatedObject() { return c1010ParserRuleCallCreatedObject; }

		// ^import = [ Import ] impFrag = FRAGMENT
		public Group ele11Group() { return c11Group; }

		// ^import = [ Import ]
		public Assignment ele110AssignmentImport() { return c110AssignmentImport; }

		// [ Import ]
		public CrossReference ele1100CrossReferenceEStringImport() { return c1100CrossReferenceEStringImport; }

		// impFrag = FRAGMENT
		public Assignment ele111AssignmentImpFrag() { return c111AssignmentImpFrag; }

		// FRAGMENT
		public RuleCall ele1110LexerRuleCallFRAGMENT() { return c1110LexerRuleCallFRAGMENT; }
	}

	public class SingleAssignmentValueElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(18);
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Alternatives c0Alternatives = (Alternatives)cAlternatives.eContents().get(0);
		private final Alternatives c00Alternatives = (Alternatives)c0Alternatives.eContents().get(0);
		private final Alternatives c000Alternatives = (Alternatives)c00Alternatives.eContents().get(0);
		private final Assignment c0000AssignmentKeyword = (Assignment)c000Alternatives.eContents().get(0);
		private final Keyword c00000KeywordNull = (Keyword)c0000AssignmentKeyword.eContents().get(0);
		private final Assignment c0001AssignmentValue = (Assignment)c000Alternatives.eContents().get(1);
		private final RuleCall c00010LexerRuleCallSTRING = (RuleCall)c0001AssignmentValue.eContents().get(0);
		private final Group c001Group = (Group)c00Alternatives.eContents().get(1);
		private final Assignment c0010AssignmentRefObject = (Assignment)c001Group.eContents().get(0);
		private final CrossReference c00100CrossReferenceEStringNamedObject = (CrossReference)c0010AssignmentRefObject.eContents().get(0);
		private final Group c0011Group = (Group)c001Group.eContents().get(1);
		private final Group c00110Group = (Group)c0011Group.eContents().get(0);
		private final Keyword c001100KeywordFullStop = (Keyword)c00110Group.eContents().get(0);
		private final Assignment c001101AssignmentRefFeature = (Assignment)c00110Group.eContents().get(1);
		private final RuleCall c0011010LexerRuleCallID = (RuleCall)c001101AssignmentRefFeature.eContents().get(0);
		private final Group c00111Group = (Group)c0011Group.eContents().get(1);
		private final Group c001110Group = (Group)c00111Group.eContents().get(0);
		private final Keyword c0011100KeywordLeftSquareBracket = (Keyword)c001110Group.eContents().get(0);
		private final Assignment c0011101AssignmentRefIndex = (Assignment)c001110Group.eContents().get(1);
		private final RuleCall c00111010LexerRuleCallINT = (RuleCall)c0011101AssignmentRefIndex.eContents().get(0);
		private final Keyword c001111KeywordRightSquareBracket = (Keyword)c00111Group.eContents().get(1);
		private final Assignment c01AssignmentNewObject = (Assignment)c0Alternatives.eContents().get(1);
		private final RuleCall c010ParserRuleCallCreatedObject = (RuleCall)c01AssignmentNewObject.eContents().get(0);
		private final Group c1Group = (Group)cAlternatives.eContents().get(1);
		private final Assignment c10AssignmentImport = (Assignment)c1Group.eContents().get(0);
		private final CrossReference c100CrossReferenceEStringImport = (CrossReference)c10AssignmentImport.eContents().get(0);
		private final Assignment c11AssignmentImpFrag = (Assignment)c1Group.eContents().get(1);
		private final RuleCall c110LexerRuleCallFRAGMENT = (RuleCall)c11AssignmentImpFrag.eContents().get(0);
		
		// SingleAssignmentValue returns AssignmentValue : keyword = "null" | value = STRING | refObject = [ NamedObject ] ( "." refFeature = ID ( "[" refIndex = INT "]" ) ? ) ? | newObject = CreatedObject | ^import = [ Import ] impFrag = FRAGMENT ;
		public ParserRule getRule() { return rule; }

		// keyword = "null" | value = STRING | refObject = [ NamedObject ] ( "." refFeature = ID ( "[" refIndex = INT "]" ) ? ) ? | newObject = CreatedObject | ^import = [ Import ] impFrag = FRAGMENT
		public Alternatives eleAlternatives() { return cAlternatives; }

		// keyword = "null" | value = STRING | refObject = [ NamedObject ] ( "." refFeature = ID ( "[" refIndex = INT "]" ) ? ) ? | newObject = CreatedObject
		public Alternatives ele0Alternatives() { return c0Alternatives; }

		// keyword = "null" | value = STRING | refObject = [ NamedObject ] ( "." refFeature = ID ( "[" refIndex = INT "]" ) ? ) ?
		public Alternatives ele00Alternatives() { return c00Alternatives; }

		// keyword = "null" | value = STRING
		public Alternatives ele000Alternatives() { return c000Alternatives; }

		// keyword = "null"
		public Assignment ele0000AssignmentKeyword() { return c0000AssignmentKeyword; }

		// "null"
		public Keyword ele00000KeywordNull() { return c00000KeywordNull; }

		// value = STRING
		public Assignment ele0001AssignmentValue() { return c0001AssignmentValue; }

		// STRING
		public RuleCall ele00010LexerRuleCallSTRING() { return c00010LexerRuleCallSTRING; }

		// refObject = [ NamedObject ] ( "." refFeature = ID ( "[" refIndex = INT "]" ) ? ) ?
		public Group ele001Group() { return c001Group; }

		// refObject = [ NamedObject ]
		public Assignment ele0010AssignmentRefObject() { return c0010AssignmentRefObject; }

		// [ NamedObject ]
		public CrossReference ele00100CrossReferenceEStringNamedObject() { return c00100CrossReferenceEStringNamedObject; }

		// ( "." refFeature = ID ( "[" refIndex = INT "]" ) ? ) ?
		public Group ele0011Group() { return c0011Group; }

		// "." refFeature = ID
		public Group ele00110Group() { return c00110Group; }

		// "."
		public Keyword ele001100KeywordFullStop() { return c001100KeywordFullStop; }

		// refFeature = ID
		public Assignment ele001101AssignmentRefFeature() { return c001101AssignmentRefFeature; }

		// ID
		public RuleCall ele0011010LexerRuleCallID() { return c0011010LexerRuleCallID; }

		// ( "[" refIndex = INT "]" ) ?
		public Group ele00111Group() { return c00111Group; }

		// "[" refIndex = INT
		public Group ele001110Group() { return c001110Group; }

		// "["
		public Keyword ele0011100KeywordLeftSquareBracket() { return c0011100KeywordLeftSquareBracket; }

		// refIndex = INT
		public Assignment ele0011101AssignmentRefIndex() { return c0011101AssignmentRefIndex; }

		// INT
		public RuleCall ele00111010LexerRuleCallINT() { return c00111010LexerRuleCallINT; }

		// "]"
		public Keyword ele001111KeywordRightSquareBracket() { return c001111KeywordRightSquareBracket; }

		// newObject = CreatedObject
		public Assignment ele01AssignmentNewObject() { return c01AssignmentNewObject; }

		// CreatedObject
		public RuleCall ele010ParserRuleCallCreatedObject() { return c010ParserRuleCallCreatedObject; }

		// ^import = [ Import ] impFrag = FRAGMENT
		public Group ele1Group() { return c1Group; }

		// ^import = [ Import ]
		public Assignment ele10AssignmentImport() { return c10AssignmentImport; }

		// [ Import ]
		public CrossReference ele100CrossReferenceEStringImport() { return c100CrossReferenceEStringImport; }

		// impFrag = FRAGMENT
		public Assignment ele11AssignmentImpFrag() { return c11AssignmentImpFrag; }

		// FRAGMENT
		public RuleCall ele110LexerRuleCallFRAGMENT() { return c110LexerRuleCallFRAGMENT; }
	}

	public class CreatedObjectElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(19);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Alternatives c00Alternatives = (Alternatives)c0Group.eContents().get(0);
		private final RuleCall c000ParserRuleCallObjectNew = (RuleCall)c00Alternatives.eContents().get(0);
		private final RuleCall c001ParserRuleCallObjectCopy = (RuleCall)c00Alternatives.eContents().get(1);
		private final Assignment c01AssignmentName = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010LexerRuleCallID = (RuleCall)c01AssignmentName.eContents().get(0);
		private final Group c1Group = (Group)cGroup.eContents().get(1);
		private final Group c10Group = (Group)c1Group.eContents().get(0);
		private final Group c100Group = (Group)c10Group.eContents().get(0);
		private final Keyword c1000KeywordLeftCurlyBracket = (Keyword)c100Group.eContents().get(0);
		private final Alternatives c1001Alternatives = (Alternatives)c100Group.eContents().get(1);
		private final Assignment c10010AssignmentAssignments = (Assignment)c1001Alternatives.eContents().get(0);
		private final RuleCall c100100ParserRuleCallMonoSingleAssignment = (RuleCall)c10010AssignmentAssignments.eContents().get(0);
		private final Assignment c10011AssignmentAssignments = (Assignment)c1001Alternatives.eContents().get(1);
		private final RuleCall c100110ParserRuleCallMonoListAssignment = (RuleCall)c10011AssignmentAssignments.eContents().get(0);
		private final Assignment c101AssignmentLeftMig = (Assignment)c10Group.eContents().get(1);
		private final RuleCall c1010ParserRuleCallMigration = (RuleCall)c101AssignmentLeftMig.eContents().get(0);
		private final Keyword c11KeywordRightCurlyBracket = (Keyword)c1Group.eContents().get(1);
		
		// CreatedObject : ( ObjectNew | ObjectCopy ) ( name = ID ) ? ( "{" ( assignments += MonoSingleAssignment | assignments += MonoListAssignment ) + ( leftMig = Migration ) ? "}" ) ? ;
		public ParserRule getRule() { return rule; }

		// ( ObjectNew | ObjectCopy ) ( name = ID ) ? ( "{" ( assignments += MonoSingleAssignment | assignments += MonoListAssignment ) + ( leftMig = Migration ) ? "}" ) ?
		public Group eleGroup() { return cGroup; }

		// ( ObjectNew | ObjectCopy ) ( name = ID ) ?
		public Group ele0Group() { return c0Group; }

		// ObjectNew | ObjectCopy
		public Alternatives ele00Alternatives() { return c00Alternatives; }

		// ObjectNew
		public RuleCall ele000ParserRuleCallObjectNew() { return c000ParserRuleCallObjectNew; }

		// ObjectCopy
		public RuleCall ele001ParserRuleCallObjectCopy() { return c001ParserRuleCallObjectCopy; }

		// ( name = ID ) ?
		public Assignment ele01AssignmentName() { return c01AssignmentName; }

		// ID
		public RuleCall ele010LexerRuleCallID() { return c010LexerRuleCallID; }

		// ( "{" ( assignments += MonoSingleAssignment | assignments += MonoListAssignment ) + ( leftMig = Migration ) ? "}" ) ?
		public Group ele1Group() { return c1Group; }

		// "{" ( assignments += MonoSingleAssignment | assignments += MonoListAssignment ) + ( leftMig = Migration ) ?
		public Group ele10Group() { return c10Group; }

		// "{" ( assignments += MonoSingleAssignment | assignments += MonoListAssignment ) +
		public Group ele100Group() { return c100Group; }

		// "{"
		public Keyword ele1000KeywordLeftCurlyBracket() { return c1000KeywordLeftCurlyBracket; }

		// ( assignments += MonoSingleAssignment | assignments += MonoListAssignment ) +
		public Alternatives ele1001Alternatives() { return c1001Alternatives; }

		// assignments += MonoSingleAssignment
		public Assignment ele10010AssignmentAssignments() { return c10010AssignmentAssignments; }

		// MonoSingleAssignment
		public RuleCall ele100100ParserRuleCallMonoSingleAssignment() { return c100100ParserRuleCallMonoSingleAssignment; }

		// assignments += MonoListAssignment
		public Assignment ele10011AssignmentAssignments() { return c10011AssignmentAssignments; }

		// MonoListAssignment
		public RuleCall ele100110ParserRuleCallMonoListAssignment() { return c100110ParserRuleCallMonoListAssignment; }

		// ( leftMig = Migration ) ?
		public Assignment ele101AssignmentLeftMig() { return c101AssignmentLeftMig; }

		// Migration
		public RuleCall ele1010ParserRuleCallMigration() { return c1010ParserRuleCallMigration; }

		// "}"
		public Keyword ele11KeywordRightCurlyBracket() { return c11KeywordRightCurlyBracket; }
	}

	public class ObjectNewElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(20);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordNew = (Keyword)c0Group.eContents().get(0);
		private final Assignment c01AssignmentImport = (Assignment)c0Group.eContents().get(1);
		private final CrossReference c010CrossReferenceEStringImport = (CrossReference)c01AssignmentImport.eContents().get(0);
		private final Assignment c1AssignmentImpFrag = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallFRAGMENT = (RuleCall)c1AssignmentImpFrag.eContents().get(0);
		
		// ObjectNew : "new" ^import = [ Import ] impFrag = FRAGMENT ;
		public ParserRule getRule() { return rule; }

		// "new" ^import = [ Import ] impFrag = FRAGMENT
		public Group eleGroup() { return cGroup; }

		// "new" ^import = [ Import ]
		public Group ele0Group() { return c0Group; }

		// "new"
		public Keyword ele00KeywordNew() { return c00KeywordNew; }

		// ^import = [ Import ]
		public Assignment ele01AssignmentImport() { return c01AssignmentImport; }

		// [ Import ]
		public CrossReference ele010CrossReferenceEStringImport() { return c010CrossReferenceEStringImport; }

		// impFrag = FRAGMENT
		public Assignment ele1AssignmentImpFrag() { return c1AssignmentImpFrag; }

		// FRAGMENT
		public RuleCall ele10LexerRuleCallFRAGMENT() { return c10LexerRuleCallFRAGMENT; }
	}

	public class ObjectCopyElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(21);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Keyword c00KeywordCopy = (Keyword)c0Group.eContents().get(0);
		private final Assignment c01AssignmentResource = (Assignment)c0Group.eContents().get(1);
		private final CrossReference c010CrossReferenceEStringNamedResource = (CrossReference)c01AssignmentResource.eContents().get(0);
		private final Assignment c1AssignmentFragment = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallFRAGMENT = (RuleCall)c1AssignmentFragment.eContents().get(0);
		
		// ObjectCopy : "copy" resource = [ NamedResource ] fragment = FRAGMENT ;
		public ParserRule getRule() { return rule; }

		// "copy" resource = [ NamedResource ] fragment = FRAGMENT
		public Group eleGroup() { return cGroup; }

		// "copy" resource = [ NamedResource ]
		public Group ele0Group() { return c0Group; }

		// "copy"
		public Keyword ele00KeywordCopy() { return c00KeywordCopy; }

		// resource = [ NamedResource ]
		public Assignment ele01AssignmentResource() { return c01AssignmentResource; }

		// [ NamedResource ]
		public CrossReference ele010CrossReferenceEStringNamedResource() { return c010CrossReferenceEStringNamedResource; }

		// fragment = FRAGMENT
		public Assignment ele1AssignmentFragment() { return c1AssignmentFragment; }

		// FRAGMENT
		public RuleCall ele10LexerRuleCallFRAGMENT() { return c10LexerRuleCallFRAGMENT; }
	}

	public class MigrationElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(23);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordMigrate = (Keyword)c00Group.eContents().get(0);
		private final Assignment c001AssignmentFirst = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010ParserRuleCallExecutable = (RuleCall)c001AssignmentFirst.eContents().get(0);
		private final Alternatives c01Alternatives = (Alternatives)c0Group.eContents().get(1);
		private final Group c010Group = (Group)c01Alternatives.eContents().get(0);
		private final Keyword c0100KeywordAs = (Keyword)c010Group.eContents().get(0);
		private final Assignment c0101AssignmentAsOp = (Assignment)c010Group.eContents().get(1);
		private final RuleCall c01010ParserRuleCallExecutable = (RuleCall)c0101AssignmentAsOp.eContents().get(0);
		private final Group c011Group = (Group)c01Alternatives.eContents().get(1);
		private final Keyword c0110KeywordEach = (Keyword)c011Group.eContents().get(0);
		private final Assignment c0111AssignmentEachOp = (Assignment)c011Group.eContents().get(1);
		private final RuleCall c01110ParserRuleCallExecutable = (RuleCall)c0111AssignmentEachOp.eContents().get(0);
		private final Keyword c1KeywordSemicolon = (Keyword)cGroup.eContents().get(1);
		
		// Migration : "migrate" ( first = Executable ) ? ( "as" asOp = Executable | "each" eachOp = Executable ) ? ";" ;
		public ParserRule getRule() { return rule; }

		// "migrate" ( first = Executable ) ? ( "as" asOp = Executable | "each" eachOp = Executable ) ? ";"
		public Group eleGroup() { return cGroup; }

		// "migrate" ( first = Executable ) ? ( "as" asOp = Executable | "each" eachOp = Executable ) ?
		public Group ele0Group() { return c0Group; }

		// "migrate" ( first = Executable ) ?
		public Group ele00Group() { return c00Group; }

		// "migrate"
		public Keyword ele000KeywordMigrate() { return c000KeywordMigrate; }

		// ( first = Executable ) ?
		public Assignment ele001AssignmentFirst() { return c001AssignmentFirst; }

		// Executable
		public RuleCall ele0010ParserRuleCallExecutable() { return c0010ParserRuleCallExecutable; }

		// ( "as" asOp = Executable | "each" eachOp = Executable ) ?
		public Alternatives ele01Alternatives() { return c01Alternatives; }

		// "as" asOp = Executable
		public Group ele010Group() { return c010Group; }

		// "as"
		public Keyword ele0100KeywordAs() { return c0100KeywordAs; }

		// asOp = Executable
		public Assignment ele0101AssignmentAsOp() { return c0101AssignmentAsOp; }

		// Executable
		public RuleCall ele01010ParserRuleCallExecutable() { return c01010ParserRuleCallExecutable; }

		// "each" eachOp = Executable
		public Group ele011Group() { return c011Group; }

		// "each"
		public Keyword ele0110KeywordEach() { return c0110KeywordEach; }

		// eachOp = Executable
		public Assignment ele0111AssignmentEachOp() { return c0111AssignmentEachOp; }

		// Executable
		public RuleCall ele01110ParserRuleCallExecutable() { return c01110ParserRuleCallExecutable; }

		// ";"
		public Keyword ele1KeywordSemicolon() { return c1KeywordSemicolon; }
	}

	public class ExecutableElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(24);
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallJavaExecutable = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall c1ParserRuleCallExpressionExecutable = (RuleCall)cAlternatives.eContents().get(1);
		
		// Executable : JavaExecutable | ExpressionExecutable ;
		public ParserRule getRule() { return rule; }

		// JavaExecutable | ExpressionExecutable
		public Alternatives eleAlternatives() { return cAlternatives; }

		// JavaExecutable
		public RuleCall ele0ParserRuleCallJavaExecutable() { return c0ParserRuleCallJavaExecutable; }

		// ExpressionExecutable
		public RuleCall ele1ParserRuleCallExpressionExecutable() { return c1ParserRuleCallExpressionExecutable; }
	}

	public class JavaExecutableElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(25);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordJava = (Keyword)c00Group.eContents().get(0);
		private final Assignment c001AssignmentMethod = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010LexerRuleCallID = (RuleCall)c001AssignmentMethod.eContents().get(0);
		private final Keyword c01KeywordLeftParenthesis = (Keyword)c0Group.eContents().get(1);
		private final Keyword c1KeywordRightParenthesis = (Keyword)cGroup.eContents().get(1);
		
		// JavaExecutable : "java" method = ID "(" ")" ;
		public ParserRule getRule() { return rule; }

		// "java" method = ID "(" ")"
		public Group eleGroup() { return cGroup; }

		// "java" method = ID "("
		public Group ele0Group() { return c0Group; }

		// "java" method = ID
		public Group ele00Group() { return c00Group; }

		// "java"
		public Keyword ele000KeywordJava() { return c000KeywordJava; }

		// method = ID
		public Assignment ele001AssignmentMethod() { return c001AssignmentMethod; }

		// ID
		public RuleCall ele0010LexerRuleCallID() { return c0010LexerRuleCallID; }

		// "("
		public Keyword ele01KeywordLeftParenthesis() { return c01KeywordLeftParenthesis; }

		// ")"
		public Keyword ele1KeywordRightParenthesis() { return c1KeywordRightParenthesis; }
	}

	public class ExpressionExecutableElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(26);
		private final Assignment cAssignmentExprstr = (Assignment)rule.eContents().get(1);
		private final RuleCall c0LexerRuleCallSTRING = (RuleCall)cAssignmentExprstr.eContents().get(0);
		
		// ExpressionExecutable : exprstr = STRING ;
		public ParserRule getRule() { return rule; }

		// exprstr = STRING
		public Assignment eleAssignmentExprstr() { return cAssignmentExprstr; }

		// STRING
		public RuleCall ele0LexerRuleCallSTRING() { return c0LexerRuleCallSTRING; }
	}
	
	public final static EpatchTestLanguageGrammarAccess INSTANCE = new EpatchTestLanguageGrammarAccess();

	private static final String EPATCHTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static EPatchElements pEPatch;
	private static ImportElements pImport;
	private static ModelImportElements pModelImport;
	private static ResourceImportElements pResourceImport;
	private static EPackageImportElements pEPackageImport;
	private static JavaImportElements pJavaImport;
	private static ExtensionImportElements pExtensionImport;
	private static NamedResourceElements pNamedResource;
	private static NamedObjectElements pNamedObject;
	private static ObjectRefElements pObjectRef;
	private static AssignmentElements pAssignment;
	private static BiSingleAssignmentElements pBiSingleAssignment;
	private static BiListAssignmentElements pBiListAssignment;
	private static MonoSingleAssignmentElements pMonoSingleAssignment;
	private static MonoListAssignmentElements pMonoListAssignment;
	private static AssignmentValueElements pAssignmentValue;
	private static ListAssignmentValueElements pListAssignmentValue;
	private static SingleAssignmentValueElements pSingleAssignmentValue;
	private static CreatedObjectElements pCreatedObject;
	private static ObjectNewElements pObjectNew;
	private static ObjectCopyElements pObjectCopy;
	private static LexerRule lFRAGMENT;
	private static MigrationElements pMigration;
	private static ExecutableElements pExecutable;
	private static JavaExecutableElements pJavaExecutable;
	private static ExpressionExecutableElements pExpressionExecutable;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(EpatchTestLanguageGrammarAccess.class.getClassLoader(),EPATCHTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;
	}

	
	// EPatch hidden ( WS , ML_COMMENT , SL_COMMENT ) : "epatch" name = ID "{" ( imports += Import ) * ( resources += NamedResource ) * ( objects += ObjectRef ) * "}" ;
	public EPatchElements prEPatch() {
		return (pEPatch != null) ? pEPatch : (pEPatch = new EPatchElements());
	} 

	// Import : ModelImport | JavaImport | ExtensionImport ;
	public ImportElements prImport() {
		return (pImport != null) ? pImport : (pImport = new ImportElements());
	} 

	// ModelImport : ResourceImport | EPackageImport ;
	public ModelImportElements prModelImport() {
		return (pModelImport != null) ? pModelImport : (pModelImport = new ModelImportElements());
	} 

	// ResourceImport : "import" name = ID "uri" uri = STRING ;
	public ResourceImportElements prResourceImport() {
		return (pResourceImport != null) ? pResourceImport : (pResourceImport = new ResourceImportElements());
	} 

	// EPackageImport : "import" name = ID "ns" nsURI = STRING ;
	public EPackageImportElements prEPackageImport() {
		return (pEPackageImport != null) ? pEPackageImport : (pEPackageImport = new EPackageImportElements());
	} 

	// JavaImport : "import" "java" path += ID ( "." path += ID ) * ;
	public JavaImportElements prJavaImport() {
		return (pJavaImport != null) ? pJavaImport : (pJavaImport = new JavaImportElements());
	} 

	// ExtensionImport : "import" "extension" path += ID ( "::" path += ID ) * ;
	public ExtensionImportElements prExtensionImport() {
		return (pExtensionImport != null) ? pExtensionImport : (pExtensionImport = new ExtensionImportElements());
	} 

	// NamedResource : "resource" name = ID "{" "left" ( "uri" leftUri = STRING | leftRoot = CreatedObject ) ";" "right" ( "uri" rightUri = STRING | rightRoot = CreatedObject ) ";" "}" ;
	public NamedResourceElements prNamedResource() {
		return (pNamedResource != null) ? pNamedResource : (pNamedResource = new NamedResourceElements());
	} 

	// NamedObject : ObjectRef | CreatedObject ;
	public NamedObjectElements prNamedObject() {
		return (pNamedObject != null) ? pNamedObject : (pNamedObject = new NamedObjectElements());
	} 

	// ObjectRef : "object" ( name = ID ) ? ( leftRes = [ NamedResource ] leftFrag = FRAGMENT | "left" leftRes = [ NamedResource ] leftFrag = FRAGMENT "right" rightRes = [ NamedResource ] rightFrag = FRAGMENT ) ( "{" ( assignments += BiSingleAssignment | assignments += BiListAssignment ) + ( "left" leftMig = Migration ) ? ( "right" rightMig = Migration ) ? "}" ) ? ;
	public ObjectRefElements prObjectRef() {
		return (pObjectRef != null) ? pObjectRef : (pObjectRef = new ObjectRefElements());
	} 

	// Assignment : BiSingleAssignment | BiListAssignment | MonoSingleAssignment | MonoListAssignment ;
	public AssignmentElements prAssignment() {
		return (pAssignment != null) ? pAssignment : (pAssignment = new AssignmentElements());
	} 

	// BiSingleAssignment returns SingleAssignment : feature = ID "=" leftValue = SingleAssignmentValue "|" rightValue = SingleAssignmentValue ";" ;
	public BiSingleAssignmentElements prBiSingleAssignment() {
		return (pBiSingleAssignment != null) ? pBiSingleAssignment : (pBiSingleAssignment = new BiSingleAssignmentElements());
	} 

	// BiListAssignment returns ListAssignment : feature = ID "=" "[" ( leftValues += ListAssignmentValue ( "," leftValues += ListAssignmentValue ) * ) ? "|" ( rightValues += ListAssignmentValue ( "," rightValues += ListAssignmentValue ) * ) ? "]" ";" ;
	public BiListAssignmentElements prBiListAssignment() {
		return (pBiListAssignment != null) ? pBiListAssignment : (pBiListAssignment = new BiListAssignmentElements());
	} 

	// MonoSingleAssignment returns SingleAssignment : feature = ID "=" leftValue = SingleAssignmentValue ";" ;
	public MonoSingleAssignmentElements prMonoSingleAssignment() {
		return (pMonoSingleAssignment != null) ? pMonoSingleAssignment : (pMonoSingleAssignment = new MonoSingleAssignmentElements());
	} 

	// MonoListAssignment returns ListAssignment : feature = ID "=" "[" ( leftValues += AssignmentValue ( "," leftValues += AssignmentValue ) * ) ? "]" ";" ;
	public MonoListAssignmentElements prMonoListAssignment() {
		return (pMonoListAssignment != null) ? pMonoListAssignment : (pMonoListAssignment = new MonoListAssignmentElements());
	} 

	// AssignmentValue : value = STRING | refObject = [ NamedObject ] ( "." refFeature = ID ( "[" refIndex = INT "]" ) ? ) ? | newObject = CreatedObject | ^import = [ Import ] impFrag = FRAGMENT ;
	public AssignmentValueElements prAssignmentValue() {
		return (pAssignmentValue != null) ? pAssignmentValue : (pAssignmentValue = new AssignmentValueElements());
	} 

	// ListAssignmentValue returns AssignmentValue : index = INT ":" ( "[" refIndex = INT "]" | value = STRING | refObject = [ NamedObject ] ( "." refFeature = ID ( "[" refIndex = INT "]" ) ? ) ? | newObject = CreatedObject | ^import = [ Import ] impFrag = FRAGMENT ) ;
	public ListAssignmentValueElements prListAssignmentValue() {
		return (pListAssignmentValue != null) ? pListAssignmentValue : (pListAssignmentValue = new ListAssignmentValueElements());
	} 

	// SingleAssignmentValue returns AssignmentValue : keyword = "null" | value = STRING | refObject = [ NamedObject ] ( "." refFeature = ID ( "[" refIndex = INT "]" ) ? ) ? | newObject = CreatedObject | ^import = [ Import ] impFrag = FRAGMENT ;
	public SingleAssignmentValueElements prSingleAssignmentValue() {
		return (pSingleAssignmentValue != null) ? pSingleAssignmentValue : (pSingleAssignmentValue = new SingleAssignmentValueElements());
	} 

	// CreatedObject : ( ObjectNew | ObjectCopy ) ( name = ID ) ? ( "{" ( assignments += MonoSingleAssignment | assignments += MonoListAssignment ) + ( leftMig = Migration ) ? "}" ) ? ;
	public CreatedObjectElements prCreatedObject() {
		return (pCreatedObject != null) ? pCreatedObject : (pCreatedObject = new CreatedObjectElements());
	} 

	// ObjectNew : "new" ^import = [ Import ] impFrag = FRAGMENT ;
	public ObjectNewElements prObjectNew() {
		return (pObjectNew != null) ? pObjectNew : (pObjectNew = new ObjectNewElements());
	} 

	// ObjectCopy : "copy" resource = [ NamedResource ] fragment = FRAGMENT ;
	public ObjectCopyElements prObjectCopy() {
		return (pObjectCopy != null) ? pObjectCopy : (pObjectCopy = new ObjectCopyElements());
	} 

	// lexer FRAGMENT : "\'#\' (\'a\'..\'z\'|\'A\'..\'Z\'|\'0\'..\'9\'|\'_\'|\'/\'|\'[\'|\']\'|\'{\'|\'}\'|\'.\'|\'@\')+" ;
	public LexerRule lrFRAGMENT() {
		return (lFRAGMENT != null) ? lFRAGMENT : (lFRAGMENT = (LexerRule) getGrammar().eContents().get(22));
	} 

	// Migration : "migrate" ( first = Executable ) ? ( "as" asOp = Executable | "each" eachOp = Executable ) ? ";" ;
	public MigrationElements prMigration() {
		return (pMigration != null) ? pMigration : (pMigration = new MigrationElements());
	} 

	// Executable : JavaExecutable | ExpressionExecutable ;
	public ExecutableElements prExecutable() {
		return (pExecutable != null) ? pExecutable : (pExecutable = new ExecutableElements());
	} 

	// JavaExecutable : "java" method = ID "(" ")" ;
	public JavaExecutableElements prJavaExecutable() {
		return (pJavaExecutable != null) ? pJavaExecutable : (pJavaExecutable = new JavaExecutableElements());
	} 

	// ExpressionExecutable : exprstr = STRING ;
	public ExpressionExecutableElements prExpressionExecutable() {
		return (pExpressionExecutable != null) ? pExpressionExecutable : (pExpressionExecutable = new ExpressionExecutableElements());
	} 
}
