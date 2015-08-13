package org.eclipse.xtext.parser.epatch.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.epatch.idea.lang.psi.impl.EpatchTestLanguageFileImpl;
import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class EpatchTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<EpatchTestLanguageFileImpl>>(EpatchTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final EpatchTestLanguageGrammarAccess GRAMMAR_ACCESS = EpatchTestLanguageLanguage.INSTANCE.getInstance(EpatchTestLanguageGrammarAccess.class);

	private static class EPatchFactory {
		public static IGrammarAwareElementType createEPatchElementType() {
			return new IGrammarAwareElementType("EPatch_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEPatchRule());
		}
		public static IGrammarAwareElementType createEPatch_GroupElementType() {
			return new IGrammarAwareElementType("EPatch_Group_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEPatchAccess().getGroup());
		}
		public static IGrammarAwareElementType createEPatch_EpatchKeyword_0ElementType() {
			return new IGrammarAwareElementType("EPatch_EpatchKeyword_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEPatchAccess().getEpatchKeyword_0());
		}
		public static IGrammarAwareElementType createEPatch_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("EPatch_NameAssignment_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEPatchAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createEPatch_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("EPatch_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEPatchAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createEPatch_LeftCurlyBracketKeyword_2ElementType() {
			return new IGrammarAwareElementType("EPatch_LeftCurlyBracketKeyword_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEPatchAccess().getLeftCurlyBracketKeyword_2());
		}
		public static IGrammarAwareElementType createEPatch_ImportsAssignment_3ElementType() {
			return new IGrammarAwareElementType("EPatch_ImportsAssignment_3_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEPatchAccess().getImportsAssignment_3());
		}
		public static IGrammarAwareElementType createEPatch_ImportsImportParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("EPatch_ImportsImportParserRuleCall_3_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEPatchAccess().getImportsImportParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createEPatch_ResourcesAssignment_4ElementType() {
			return new IGrammarAwareElementType("EPatch_ResourcesAssignment_4_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEPatchAccess().getResourcesAssignment_4());
		}
		public static IGrammarAwareElementType createEPatch_ResourcesNamedResourceParserRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("EPatch_ResourcesNamedResourceParserRuleCall_4_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEPatchAccess().getResourcesNamedResourceParserRuleCall_4_0());
		}
		public static IGrammarAwareElementType createEPatch_ObjectsAssignment_5ElementType() {
			return new IGrammarAwareElementType("EPatch_ObjectsAssignment_5_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEPatchAccess().getObjectsAssignment_5());
		}
		public static IGrammarAwareElementType createEPatch_ObjectsObjectRefParserRuleCall_5_0ElementType() {
			return new IGrammarAwareElementType("EPatch_ObjectsObjectRefParserRuleCall_5_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEPatchAccess().getObjectsObjectRefParserRuleCall_5_0());
		}
		public static IGrammarAwareElementType createEPatch_RightCurlyBracketKeyword_6ElementType() {
			return new IGrammarAwareElementType("EPatch_RightCurlyBracketKeyword_6_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEPatchAccess().getRightCurlyBracketKeyword_6());
		}
	}

	public static final IGrammarAwareElementType EPatch_ELEMENT_TYPE = associate(EPatchFactory.createEPatchElementType());

	public static final IGrammarAwareElementType EPatch_Group_ELEMENT_TYPE = associate(EPatchFactory.createEPatch_GroupElementType());

	public static final IGrammarAwareElementType EPatch_EpatchKeyword_0_ELEMENT_TYPE = associate(EPatchFactory.createEPatch_EpatchKeyword_0ElementType());

	public static final IGrammarAwareElementType EPatch_NameAssignment_1_ELEMENT_TYPE = associate(EPatchFactory.createEPatch_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType EPatch_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(EPatchFactory.createEPatch_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType EPatch_LeftCurlyBracketKeyword_2_ELEMENT_TYPE = associate(EPatchFactory.createEPatch_LeftCurlyBracketKeyword_2ElementType());

	public static final IGrammarAwareElementType EPatch_ImportsAssignment_3_ELEMENT_TYPE = associate(EPatchFactory.createEPatch_ImportsAssignment_3ElementType());

	public static final IGrammarAwareElementType EPatch_ImportsImportParserRuleCall_3_0_ELEMENT_TYPE = associate(EPatchFactory.createEPatch_ImportsImportParserRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType EPatch_ResourcesAssignment_4_ELEMENT_TYPE = associate(EPatchFactory.createEPatch_ResourcesAssignment_4ElementType());

	public static final IGrammarAwareElementType EPatch_ResourcesNamedResourceParserRuleCall_4_0_ELEMENT_TYPE = associate(EPatchFactory.createEPatch_ResourcesNamedResourceParserRuleCall_4_0ElementType());

	public static final IGrammarAwareElementType EPatch_ObjectsAssignment_5_ELEMENT_TYPE = associate(EPatchFactory.createEPatch_ObjectsAssignment_5ElementType());

	public static final IGrammarAwareElementType EPatch_ObjectsObjectRefParserRuleCall_5_0_ELEMENT_TYPE = associate(EPatchFactory.createEPatch_ObjectsObjectRefParserRuleCall_5_0ElementType());

	public static final IGrammarAwareElementType EPatch_RightCurlyBracketKeyword_6_ELEMENT_TYPE = associate(EPatchFactory.createEPatch_RightCurlyBracketKeyword_6ElementType());

	private static class ImportFactory {
		public static IGrammarAwareElementType createImportElementType() {
			return new IGrammarAwareElementType("Import_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getImportRule());
		}
		public static IGrammarAwareElementType createImport_AlternativesElementType() {
			return new IGrammarAwareElementType("Import_Alternatives_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getImportAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createImport_ModelImportParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Import_ModelImportParserRuleCall_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getImportAccess().getModelImportParserRuleCall_0());
		}
		public static IGrammarAwareElementType createImport_JavaImportParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Import_JavaImportParserRuleCall_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getImportAccess().getJavaImportParserRuleCall_1());
		}
		public static IGrammarAwareElementType createImport_ExtensionImportParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("Import_ExtensionImportParserRuleCall_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getImportAccess().getExtensionImportParserRuleCall_2());
		}
	}

	public static final IGrammarAwareElementType Import_ELEMENT_TYPE = associate(ImportFactory.createImportElementType());

	public static final IGrammarAwareElementType Import_Alternatives_ELEMENT_TYPE = associate(ImportFactory.createImport_AlternativesElementType());

	public static final IGrammarAwareElementType Import_ModelImportParserRuleCall_0_ELEMENT_TYPE = associate(ImportFactory.createImport_ModelImportParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Import_JavaImportParserRuleCall_1_ELEMENT_TYPE = associate(ImportFactory.createImport_JavaImportParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType Import_ExtensionImportParserRuleCall_2_ELEMENT_TYPE = associate(ImportFactory.createImport_ExtensionImportParserRuleCall_2ElementType());

	private static class ModelImportFactory {
		public static IGrammarAwareElementType createModelImportElementType() {
			return new IGrammarAwareElementType("ModelImport_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelImportRule());
		}
		public static IGrammarAwareElementType createModelImport_AlternativesElementType() {
			return new IGrammarAwareElementType("ModelImport_Alternatives_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelImportAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createModelImport_ResourceImportParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("ModelImport_ResourceImportParserRuleCall_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelImportAccess().getResourceImportParserRuleCall_0());
		}
		public static IGrammarAwareElementType createModelImport_EPackageImportParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("ModelImport_EPackageImportParserRuleCall_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelImportAccess().getEPackageImportParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType ModelImport_ELEMENT_TYPE = associate(ModelImportFactory.createModelImportElementType());

	public static final IGrammarAwareElementType ModelImport_Alternatives_ELEMENT_TYPE = associate(ModelImportFactory.createModelImport_AlternativesElementType());

	public static final IGrammarAwareElementType ModelImport_ResourceImportParserRuleCall_0_ELEMENT_TYPE = associate(ModelImportFactory.createModelImport_ResourceImportParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType ModelImport_EPackageImportParserRuleCall_1_ELEMENT_TYPE = associate(ModelImportFactory.createModelImport_EPackageImportParserRuleCall_1ElementType());

	private static class ResourceImportFactory {
		public static IGrammarAwareElementType createResourceImportElementType() {
			return new IGrammarAwareElementType("ResourceImport_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getResourceImportRule());
		}
		public static IGrammarAwareElementType createResourceImport_GroupElementType() {
			return new IGrammarAwareElementType("ResourceImport_Group_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getResourceImportAccess().getGroup());
		}
		public static IGrammarAwareElementType createResourceImport_ImportKeyword_0ElementType() {
			return new IGrammarAwareElementType("ResourceImport_ImportKeyword_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getResourceImportAccess().getImportKeyword_0());
		}
		public static IGrammarAwareElementType createResourceImport_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("ResourceImport_NameAssignment_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getResourceImportAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createResourceImport_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("ResourceImport_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getResourceImportAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createResourceImport_UriKeyword_2ElementType() {
			return new IGrammarAwareElementType("ResourceImport_UriKeyword_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getResourceImportAccess().getUriKeyword_2());
		}
		public static IGrammarAwareElementType createResourceImport_UriAssignment_3ElementType() {
			return new IGrammarAwareElementType("ResourceImport_UriAssignment_3_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getResourceImportAccess().getUriAssignment_3());
		}
		public static IGrammarAwareElementType createResourceImport_UriSTRINGTerminalRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("ResourceImport_UriSTRINGTerminalRuleCall_3_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getResourceImportAccess().getUriSTRINGTerminalRuleCall_3_0());
		}
	}

	public static final IGrammarAwareElementType ResourceImport_ELEMENT_TYPE = associate(ResourceImportFactory.createResourceImportElementType());

	public static final IGrammarAwareElementType ResourceImport_Group_ELEMENT_TYPE = associate(ResourceImportFactory.createResourceImport_GroupElementType());

	public static final IGrammarAwareElementType ResourceImport_ImportKeyword_0_ELEMENT_TYPE = associate(ResourceImportFactory.createResourceImport_ImportKeyword_0ElementType());

	public static final IGrammarAwareElementType ResourceImport_NameAssignment_1_ELEMENT_TYPE = associate(ResourceImportFactory.createResourceImport_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType ResourceImport_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(ResourceImportFactory.createResourceImport_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType ResourceImport_UriKeyword_2_ELEMENT_TYPE = associate(ResourceImportFactory.createResourceImport_UriKeyword_2ElementType());

	public static final IGrammarAwareElementType ResourceImport_UriAssignment_3_ELEMENT_TYPE = associate(ResourceImportFactory.createResourceImport_UriAssignment_3ElementType());

	public static final IGrammarAwareElementType ResourceImport_UriSTRINGTerminalRuleCall_3_0_ELEMENT_TYPE = associate(ResourceImportFactory.createResourceImport_UriSTRINGTerminalRuleCall_3_0ElementType());

	private static class EPackageImportFactory {
		public static IGrammarAwareElementType createEPackageImportElementType() {
			return new IGrammarAwareElementType("EPackageImport_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEPackageImportRule());
		}
		public static IGrammarAwareElementType createEPackageImport_GroupElementType() {
			return new IGrammarAwareElementType("EPackageImport_Group_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEPackageImportAccess().getGroup());
		}
		public static IGrammarAwareElementType createEPackageImport_ImportKeyword_0ElementType() {
			return new IGrammarAwareElementType("EPackageImport_ImportKeyword_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEPackageImportAccess().getImportKeyword_0());
		}
		public static IGrammarAwareElementType createEPackageImport_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("EPackageImport_NameAssignment_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEPackageImportAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createEPackageImport_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("EPackageImport_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEPackageImportAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createEPackageImport_NsKeyword_2ElementType() {
			return new IGrammarAwareElementType("EPackageImport_NsKeyword_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEPackageImportAccess().getNsKeyword_2());
		}
		public static IGrammarAwareElementType createEPackageImport_NsURIAssignment_3ElementType() {
			return new IGrammarAwareElementType("EPackageImport_NsURIAssignment_3_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEPackageImportAccess().getNsURIAssignment_3());
		}
		public static IGrammarAwareElementType createEPackageImport_NsURISTRINGTerminalRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("EPackageImport_NsURISTRINGTerminalRuleCall_3_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEPackageImportAccess().getNsURISTRINGTerminalRuleCall_3_0());
		}
	}

	public static final IGrammarAwareElementType EPackageImport_ELEMENT_TYPE = associate(EPackageImportFactory.createEPackageImportElementType());

	public static final IGrammarAwareElementType EPackageImport_Group_ELEMENT_TYPE = associate(EPackageImportFactory.createEPackageImport_GroupElementType());

	public static final IGrammarAwareElementType EPackageImport_ImportKeyword_0_ELEMENT_TYPE = associate(EPackageImportFactory.createEPackageImport_ImportKeyword_0ElementType());

	public static final IGrammarAwareElementType EPackageImport_NameAssignment_1_ELEMENT_TYPE = associate(EPackageImportFactory.createEPackageImport_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType EPackageImport_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(EPackageImportFactory.createEPackageImport_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType EPackageImport_NsKeyword_2_ELEMENT_TYPE = associate(EPackageImportFactory.createEPackageImport_NsKeyword_2ElementType());

	public static final IGrammarAwareElementType EPackageImport_NsURIAssignment_3_ELEMENT_TYPE = associate(EPackageImportFactory.createEPackageImport_NsURIAssignment_3ElementType());

	public static final IGrammarAwareElementType EPackageImport_NsURISTRINGTerminalRuleCall_3_0_ELEMENT_TYPE = associate(EPackageImportFactory.createEPackageImport_NsURISTRINGTerminalRuleCall_3_0ElementType());

	private static class JavaImportFactory {
		public static IGrammarAwareElementType createJavaImportElementType() {
			return new IGrammarAwareElementType("JavaImport_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getJavaImportRule());
		}
		public static IGrammarAwareElementType createJavaImport_GroupElementType() {
			return new IGrammarAwareElementType("JavaImport_Group_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getJavaImportAccess().getGroup());
		}
		public static IGrammarAwareElementType createJavaImport_ImportKeyword_0ElementType() {
			return new IGrammarAwareElementType("JavaImport_ImportKeyword_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getJavaImportAccess().getImportKeyword_0());
		}
		public static IGrammarAwareElementType createJavaImport_JavaKeyword_1ElementType() {
			return new IGrammarAwareElementType("JavaImport_JavaKeyword_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getJavaImportAccess().getJavaKeyword_1());
		}
		public static IGrammarAwareElementType createJavaImport_PathAssignment_2ElementType() {
			return new IGrammarAwareElementType("JavaImport_PathAssignment_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getJavaImportAccess().getPathAssignment_2());
		}
		public static IGrammarAwareElementType createJavaImport_PathIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("JavaImport_PathIDTerminalRuleCall_2_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getJavaImportAccess().getPathIDTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createJavaImport_Group_3ElementType() {
			return new IGrammarAwareElementType("JavaImport_Group_3_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getJavaImportAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createJavaImport_FullStopKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("JavaImport_FullStopKeyword_3_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getJavaImportAccess().getFullStopKeyword_3_0());
		}
		public static IGrammarAwareElementType createJavaImport_PathAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("JavaImport_PathAssignment_3_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getJavaImportAccess().getPathAssignment_3_1());
		}
		public static IGrammarAwareElementType createJavaImport_PathIDTerminalRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("JavaImport_PathIDTerminalRuleCall_3_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getJavaImportAccess().getPathIDTerminalRuleCall_3_1_0());
		}
	}

	public static final IGrammarAwareElementType JavaImport_ELEMENT_TYPE = associate(JavaImportFactory.createJavaImportElementType());

	public static final IGrammarAwareElementType JavaImport_Group_ELEMENT_TYPE = associate(JavaImportFactory.createJavaImport_GroupElementType());

	public static final IGrammarAwareElementType JavaImport_ImportKeyword_0_ELEMENT_TYPE = associate(JavaImportFactory.createJavaImport_ImportKeyword_0ElementType());

	public static final IGrammarAwareElementType JavaImport_JavaKeyword_1_ELEMENT_TYPE = associate(JavaImportFactory.createJavaImport_JavaKeyword_1ElementType());

	public static final IGrammarAwareElementType JavaImport_PathAssignment_2_ELEMENT_TYPE = associate(JavaImportFactory.createJavaImport_PathAssignment_2ElementType());

	public static final IGrammarAwareElementType JavaImport_PathIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(JavaImportFactory.createJavaImport_PathIDTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType JavaImport_Group_3_ELEMENT_TYPE = associate(JavaImportFactory.createJavaImport_Group_3ElementType());

	public static final IGrammarAwareElementType JavaImport_FullStopKeyword_3_0_ELEMENT_TYPE = associate(JavaImportFactory.createJavaImport_FullStopKeyword_3_0ElementType());

	public static final IGrammarAwareElementType JavaImport_PathAssignment_3_1_ELEMENT_TYPE = associate(JavaImportFactory.createJavaImport_PathAssignment_3_1ElementType());

	public static final IGrammarAwareElementType JavaImport_PathIDTerminalRuleCall_3_1_0_ELEMENT_TYPE = associate(JavaImportFactory.createJavaImport_PathIDTerminalRuleCall_3_1_0ElementType());

	private static class ExtensionImportFactory {
		public static IGrammarAwareElementType createExtensionImportElementType() {
			return new IGrammarAwareElementType("ExtensionImport_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExtensionImportRule());
		}
		public static IGrammarAwareElementType createExtensionImport_GroupElementType() {
			return new IGrammarAwareElementType("ExtensionImport_Group_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExtensionImportAccess().getGroup());
		}
		public static IGrammarAwareElementType createExtensionImport_ImportKeyword_0ElementType() {
			return new IGrammarAwareElementType("ExtensionImport_ImportKeyword_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExtensionImportAccess().getImportKeyword_0());
		}
		public static IGrammarAwareElementType createExtensionImport_ExtensionKeyword_1ElementType() {
			return new IGrammarAwareElementType("ExtensionImport_ExtensionKeyword_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExtensionImportAccess().getExtensionKeyword_1());
		}
		public static IGrammarAwareElementType createExtensionImport_PathAssignment_2ElementType() {
			return new IGrammarAwareElementType("ExtensionImport_PathAssignment_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExtensionImportAccess().getPathAssignment_2());
		}
		public static IGrammarAwareElementType createExtensionImport_PathIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("ExtensionImport_PathIDTerminalRuleCall_2_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExtensionImportAccess().getPathIDTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createExtensionImport_Group_3ElementType() {
			return new IGrammarAwareElementType("ExtensionImport_Group_3_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExtensionImportAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createExtensionImport_ColonColonKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("ExtensionImport_ColonColonKeyword_3_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExtensionImportAccess().getColonColonKeyword_3_0());
		}
		public static IGrammarAwareElementType createExtensionImport_PathAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("ExtensionImport_PathAssignment_3_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExtensionImportAccess().getPathAssignment_3_1());
		}
		public static IGrammarAwareElementType createExtensionImport_PathIDTerminalRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("ExtensionImport_PathIDTerminalRuleCall_3_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExtensionImportAccess().getPathIDTerminalRuleCall_3_1_0());
		}
	}

	public static final IGrammarAwareElementType ExtensionImport_ELEMENT_TYPE = associate(ExtensionImportFactory.createExtensionImportElementType());

	public static final IGrammarAwareElementType ExtensionImport_Group_ELEMENT_TYPE = associate(ExtensionImportFactory.createExtensionImport_GroupElementType());

	public static final IGrammarAwareElementType ExtensionImport_ImportKeyword_0_ELEMENT_TYPE = associate(ExtensionImportFactory.createExtensionImport_ImportKeyword_0ElementType());

	public static final IGrammarAwareElementType ExtensionImport_ExtensionKeyword_1_ELEMENT_TYPE = associate(ExtensionImportFactory.createExtensionImport_ExtensionKeyword_1ElementType());

	public static final IGrammarAwareElementType ExtensionImport_PathAssignment_2_ELEMENT_TYPE = associate(ExtensionImportFactory.createExtensionImport_PathAssignment_2ElementType());

	public static final IGrammarAwareElementType ExtensionImport_PathIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(ExtensionImportFactory.createExtensionImport_PathIDTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType ExtensionImport_Group_3_ELEMENT_TYPE = associate(ExtensionImportFactory.createExtensionImport_Group_3ElementType());

	public static final IGrammarAwareElementType ExtensionImport_ColonColonKeyword_3_0_ELEMENT_TYPE = associate(ExtensionImportFactory.createExtensionImport_ColonColonKeyword_3_0ElementType());

	public static final IGrammarAwareElementType ExtensionImport_PathAssignment_3_1_ELEMENT_TYPE = associate(ExtensionImportFactory.createExtensionImport_PathAssignment_3_1ElementType());

	public static final IGrammarAwareElementType ExtensionImport_PathIDTerminalRuleCall_3_1_0_ELEMENT_TYPE = associate(ExtensionImportFactory.createExtensionImport_PathIDTerminalRuleCall_3_1_0ElementType());

	private static class NamedResourceFactory {
		public static IGrammarAwareElementType createNamedResourceElementType() {
			return new IGrammarAwareElementType("NamedResource_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedResourceRule());
		}
		public static IGrammarAwareElementType createNamedResource_GroupElementType() {
			return new IGrammarAwareElementType("NamedResource_Group_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedResourceAccess().getGroup());
		}
		public static IGrammarAwareElementType createNamedResource_ResourceKeyword_0ElementType() {
			return new IGrammarAwareElementType("NamedResource_ResourceKeyword_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedResourceAccess().getResourceKeyword_0());
		}
		public static IGrammarAwareElementType createNamedResource_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("NamedResource_NameAssignment_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedResourceAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createNamedResource_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("NamedResource_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedResourceAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createNamedResource_LeftCurlyBracketKeyword_2ElementType() {
			return new IGrammarAwareElementType("NamedResource_LeftCurlyBracketKeyword_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedResourceAccess().getLeftCurlyBracketKeyword_2());
		}
		public static IGrammarAwareElementType createNamedResource_LeftKeyword_3ElementType() {
			return new IGrammarAwareElementType("NamedResource_LeftKeyword_3_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedResourceAccess().getLeftKeyword_3());
		}
		public static IGrammarAwareElementType createNamedResource_Alternatives_4ElementType() {
			return new IGrammarAwareElementType("NamedResource_Alternatives_4_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedResourceAccess().getAlternatives_4());
		}
		public static IGrammarAwareElementType createNamedResource_Group_4_0ElementType() {
			return new IGrammarAwareElementType("NamedResource_Group_4_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedResourceAccess().getGroup_4_0());
		}
		public static IGrammarAwareElementType createNamedResource_UriKeyword_4_0_0ElementType() {
			return new IGrammarAwareElementType("NamedResource_UriKeyword_4_0_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedResourceAccess().getUriKeyword_4_0_0());
		}
		public static IGrammarAwareElementType createNamedResource_LeftUriAssignment_4_0_1ElementType() {
			return new IGrammarAwareElementType("NamedResource_LeftUriAssignment_4_0_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedResourceAccess().getLeftUriAssignment_4_0_1());
		}
		public static IGrammarAwareElementType createNamedResource_LeftUriSTRINGTerminalRuleCall_4_0_1_0ElementType() {
			return new IGrammarAwareElementType("NamedResource_LeftUriSTRINGTerminalRuleCall_4_0_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedResourceAccess().getLeftUriSTRINGTerminalRuleCall_4_0_1_0());
		}
		public static IGrammarAwareElementType createNamedResource_LeftRootAssignment_4_1ElementType() {
			return new IGrammarAwareElementType("NamedResource_LeftRootAssignment_4_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedResourceAccess().getLeftRootAssignment_4_1());
		}
		public static IGrammarAwareElementType createNamedResource_LeftRootCreatedObjectParserRuleCall_4_1_0ElementType() {
			return new IGrammarAwareElementType("NamedResource_LeftRootCreatedObjectParserRuleCall_4_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedResourceAccess().getLeftRootCreatedObjectParserRuleCall_4_1_0());
		}
		public static IGrammarAwareElementType createNamedResource_SemicolonKeyword_5ElementType() {
			return new IGrammarAwareElementType("NamedResource_SemicolonKeyword_5_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedResourceAccess().getSemicolonKeyword_5());
		}
		public static IGrammarAwareElementType createNamedResource_RightKeyword_6ElementType() {
			return new IGrammarAwareElementType("NamedResource_RightKeyword_6_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedResourceAccess().getRightKeyword_6());
		}
		public static IGrammarAwareElementType createNamedResource_Alternatives_7ElementType() {
			return new IGrammarAwareElementType("NamedResource_Alternatives_7_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedResourceAccess().getAlternatives_7());
		}
		public static IGrammarAwareElementType createNamedResource_Group_7_0ElementType() {
			return new IGrammarAwareElementType("NamedResource_Group_7_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedResourceAccess().getGroup_7_0());
		}
		public static IGrammarAwareElementType createNamedResource_UriKeyword_7_0_0ElementType() {
			return new IGrammarAwareElementType("NamedResource_UriKeyword_7_0_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedResourceAccess().getUriKeyword_7_0_0());
		}
		public static IGrammarAwareElementType createNamedResource_RightUriAssignment_7_0_1ElementType() {
			return new IGrammarAwareElementType("NamedResource_RightUriAssignment_7_0_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedResourceAccess().getRightUriAssignment_7_0_1());
		}
		public static IGrammarAwareElementType createNamedResource_RightUriSTRINGTerminalRuleCall_7_0_1_0ElementType() {
			return new IGrammarAwareElementType("NamedResource_RightUriSTRINGTerminalRuleCall_7_0_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedResourceAccess().getRightUriSTRINGTerminalRuleCall_7_0_1_0());
		}
		public static IGrammarAwareElementType createNamedResource_RightRootAssignment_7_1ElementType() {
			return new IGrammarAwareElementType("NamedResource_RightRootAssignment_7_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedResourceAccess().getRightRootAssignment_7_1());
		}
		public static IGrammarAwareElementType createNamedResource_RightRootCreatedObjectParserRuleCall_7_1_0ElementType() {
			return new IGrammarAwareElementType("NamedResource_RightRootCreatedObjectParserRuleCall_7_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedResourceAccess().getRightRootCreatedObjectParserRuleCall_7_1_0());
		}
		public static IGrammarAwareElementType createNamedResource_SemicolonKeyword_8ElementType() {
			return new IGrammarAwareElementType("NamedResource_SemicolonKeyword_8_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedResourceAccess().getSemicolonKeyword_8());
		}
		public static IGrammarAwareElementType createNamedResource_RightCurlyBracketKeyword_9ElementType() {
			return new IGrammarAwareElementType("NamedResource_RightCurlyBracketKeyword_9_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedResourceAccess().getRightCurlyBracketKeyword_9());
		}
	}

	public static final IGrammarAwareElementType NamedResource_ELEMENT_TYPE = associate(NamedResourceFactory.createNamedResourceElementType());

	public static final IGrammarAwareElementType NamedResource_Group_ELEMENT_TYPE = associate(NamedResourceFactory.createNamedResource_GroupElementType());

	public static final IGrammarAwareElementType NamedResource_ResourceKeyword_0_ELEMENT_TYPE = associate(NamedResourceFactory.createNamedResource_ResourceKeyword_0ElementType());

	public static final IGrammarAwareElementType NamedResource_NameAssignment_1_ELEMENT_TYPE = associate(NamedResourceFactory.createNamedResource_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType NamedResource_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(NamedResourceFactory.createNamedResource_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType NamedResource_LeftCurlyBracketKeyword_2_ELEMENT_TYPE = associate(NamedResourceFactory.createNamedResource_LeftCurlyBracketKeyword_2ElementType());

	public static final IGrammarAwareElementType NamedResource_LeftKeyword_3_ELEMENT_TYPE = associate(NamedResourceFactory.createNamedResource_LeftKeyword_3ElementType());

	public static final IGrammarAwareElementType NamedResource_Alternatives_4_ELEMENT_TYPE = associate(NamedResourceFactory.createNamedResource_Alternatives_4ElementType());

	public static final IGrammarAwareElementType NamedResource_Group_4_0_ELEMENT_TYPE = associate(NamedResourceFactory.createNamedResource_Group_4_0ElementType());

	public static final IGrammarAwareElementType NamedResource_UriKeyword_4_0_0_ELEMENT_TYPE = associate(NamedResourceFactory.createNamedResource_UriKeyword_4_0_0ElementType());

	public static final IGrammarAwareElementType NamedResource_LeftUriAssignment_4_0_1_ELEMENT_TYPE = associate(NamedResourceFactory.createNamedResource_LeftUriAssignment_4_0_1ElementType());

	public static final IGrammarAwareElementType NamedResource_LeftUriSTRINGTerminalRuleCall_4_0_1_0_ELEMENT_TYPE = associate(NamedResourceFactory.createNamedResource_LeftUriSTRINGTerminalRuleCall_4_0_1_0ElementType());

	public static final IGrammarAwareElementType NamedResource_LeftRootAssignment_4_1_ELEMENT_TYPE = associate(NamedResourceFactory.createNamedResource_LeftRootAssignment_4_1ElementType());

	public static final IGrammarAwareElementType NamedResource_LeftRootCreatedObjectParserRuleCall_4_1_0_ELEMENT_TYPE = associate(NamedResourceFactory.createNamedResource_LeftRootCreatedObjectParserRuleCall_4_1_0ElementType());

	public static final IGrammarAwareElementType NamedResource_SemicolonKeyword_5_ELEMENT_TYPE = associate(NamedResourceFactory.createNamedResource_SemicolonKeyword_5ElementType());

	public static final IGrammarAwareElementType NamedResource_RightKeyword_6_ELEMENT_TYPE = associate(NamedResourceFactory.createNamedResource_RightKeyword_6ElementType());

	public static final IGrammarAwareElementType NamedResource_Alternatives_7_ELEMENT_TYPE = associate(NamedResourceFactory.createNamedResource_Alternatives_7ElementType());

	public static final IGrammarAwareElementType NamedResource_Group_7_0_ELEMENT_TYPE = associate(NamedResourceFactory.createNamedResource_Group_7_0ElementType());

	public static final IGrammarAwareElementType NamedResource_UriKeyword_7_0_0_ELEMENT_TYPE = associate(NamedResourceFactory.createNamedResource_UriKeyword_7_0_0ElementType());

	public static final IGrammarAwareElementType NamedResource_RightUriAssignment_7_0_1_ELEMENT_TYPE = associate(NamedResourceFactory.createNamedResource_RightUriAssignment_7_0_1ElementType());

	public static final IGrammarAwareElementType NamedResource_RightUriSTRINGTerminalRuleCall_7_0_1_0_ELEMENT_TYPE = associate(NamedResourceFactory.createNamedResource_RightUriSTRINGTerminalRuleCall_7_0_1_0ElementType());

	public static final IGrammarAwareElementType NamedResource_RightRootAssignment_7_1_ELEMENT_TYPE = associate(NamedResourceFactory.createNamedResource_RightRootAssignment_7_1ElementType());

	public static final IGrammarAwareElementType NamedResource_RightRootCreatedObjectParserRuleCall_7_1_0_ELEMENT_TYPE = associate(NamedResourceFactory.createNamedResource_RightRootCreatedObjectParserRuleCall_7_1_0ElementType());

	public static final IGrammarAwareElementType NamedResource_SemicolonKeyword_8_ELEMENT_TYPE = associate(NamedResourceFactory.createNamedResource_SemicolonKeyword_8ElementType());

	public static final IGrammarAwareElementType NamedResource_RightCurlyBracketKeyword_9_ELEMENT_TYPE = associate(NamedResourceFactory.createNamedResource_RightCurlyBracketKeyword_9ElementType());

	private static class NamedObjectFactory {
		public static IGrammarAwareElementType createNamedObjectElementType() {
			return new IGrammarAwareElementType("NamedObject_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedObjectRule());
		}
		public static IGrammarAwareElementType createNamedObject_AlternativesElementType() {
			return new IGrammarAwareElementType("NamedObject_Alternatives_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedObjectAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createNamedObject_ObjectRefParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("NamedObject_ObjectRefParserRuleCall_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedObjectAccess().getObjectRefParserRuleCall_0());
		}
		public static IGrammarAwareElementType createNamedObject_CreatedObjectParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("NamedObject_CreatedObjectParserRuleCall_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedObjectAccess().getCreatedObjectParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType NamedObject_ELEMENT_TYPE = associate(NamedObjectFactory.createNamedObjectElementType());

	public static final IGrammarAwareElementType NamedObject_Alternatives_ELEMENT_TYPE = associate(NamedObjectFactory.createNamedObject_AlternativesElementType());

	public static final IGrammarAwareElementType NamedObject_ObjectRefParserRuleCall_0_ELEMENT_TYPE = associate(NamedObjectFactory.createNamedObject_ObjectRefParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType NamedObject_CreatedObjectParserRuleCall_1_ELEMENT_TYPE = associate(NamedObjectFactory.createNamedObject_CreatedObjectParserRuleCall_1ElementType());

	private static class ObjectRefFactory {
		public static IGrammarAwareElementType createObjectRefElementType() {
			return new IGrammarAwareElementType("ObjectRef_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefRule());
		}
		public static IGrammarAwareElementType createObjectRef_GroupElementType() {
			return new IGrammarAwareElementType("ObjectRef_Group_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getGroup());
		}
		public static IGrammarAwareElementType createObjectRef_ObjectKeyword_0ElementType() {
			return new IGrammarAwareElementType("ObjectRef_ObjectKeyword_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getObjectKeyword_0());
		}
		public static IGrammarAwareElementType createObjectRef_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("ObjectRef_NameAssignment_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createObjectRef_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("ObjectRef_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createObjectRef_Alternatives_2ElementType() {
			return new IGrammarAwareElementType("ObjectRef_Alternatives_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getAlternatives_2());
		}
		public static IGrammarAwareElementType createObjectRef_Group_2_0ElementType() {
			return new IGrammarAwareElementType("ObjectRef_Group_2_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getGroup_2_0());
		}
		public static IGrammarAwareElementType createObjectRef_LeftResAssignment_2_0_0ElementType() {
			return new IGrammarAwareElementType("ObjectRef_LeftResAssignment_2_0_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getLeftResAssignment_2_0_0());
		}
		public static IGrammarAwareElementType createObjectRef_LeftResNamedResourceCrossReference_2_0_0_0ElementType() {
			return new IGrammarAwareElementType("ObjectRef_LeftResNamedResourceCrossReference_2_0_0_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getLeftResNamedResourceCrossReference_2_0_0_0());
		}
		public static IGrammarAwareElementType createObjectRef_LeftResNamedResourceIDTerminalRuleCall_2_0_0_0_1ElementType() {
			return new IGrammarAwareElementType("ObjectRef_LeftResNamedResourceIDTerminalRuleCall_2_0_0_0_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getLeftResNamedResourceIDTerminalRuleCall_2_0_0_0_1());
		}
		public static IGrammarAwareElementType createObjectRef_LeftFragAssignment_2_0_1ElementType() {
			return new IGrammarAwareElementType("ObjectRef_LeftFragAssignment_2_0_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getLeftFragAssignment_2_0_1());
		}
		public static IGrammarAwareElementType createObjectRef_LeftFragFRAGMENTTerminalRuleCall_2_0_1_0ElementType() {
			return new IGrammarAwareElementType("ObjectRef_LeftFragFRAGMENTTerminalRuleCall_2_0_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getLeftFragFRAGMENTTerminalRuleCall_2_0_1_0());
		}
		public static IGrammarAwareElementType createObjectRef_Group_2_1ElementType() {
			return new IGrammarAwareElementType("ObjectRef_Group_2_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getGroup_2_1());
		}
		public static IGrammarAwareElementType createObjectRef_LeftKeyword_2_1_0ElementType() {
			return new IGrammarAwareElementType("ObjectRef_LeftKeyword_2_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getLeftKeyword_2_1_0());
		}
		public static IGrammarAwareElementType createObjectRef_LeftResAssignment_2_1_1ElementType() {
			return new IGrammarAwareElementType("ObjectRef_LeftResAssignment_2_1_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getLeftResAssignment_2_1_1());
		}
		public static IGrammarAwareElementType createObjectRef_LeftResNamedResourceCrossReference_2_1_1_0ElementType() {
			return new IGrammarAwareElementType("ObjectRef_LeftResNamedResourceCrossReference_2_1_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getLeftResNamedResourceCrossReference_2_1_1_0());
		}
		public static IGrammarAwareElementType createObjectRef_LeftResNamedResourceIDTerminalRuleCall_2_1_1_0_1ElementType() {
			return new IGrammarAwareElementType("ObjectRef_LeftResNamedResourceIDTerminalRuleCall_2_1_1_0_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getLeftResNamedResourceIDTerminalRuleCall_2_1_1_0_1());
		}
		public static IGrammarAwareElementType createObjectRef_LeftFragAssignment_2_1_2ElementType() {
			return new IGrammarAwareElementType("ObjectRef_LeftFragAssignment_2_1_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getLeftFragAssignment_2_1_2());
		}
		public static IGrammarAwareElementType createObjectRef_LeftFragFRAGMENTTerminalRuleCall_2_1_2_0ElementType() {
			return new IGrammarAwareElementType("ObjectRef_LeftFragFRAGMENTTerminalRuleCall_2_1_2_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getLeftFragFRAGMENTTerminalRuleCall_2_1_2_0());
		}
		public static IGrammarAwareElementType createObjectRef_RightKeyword_2_1_3ElementType() {
			return new IGrammarAwareElementType("ObjectRef_RightKeyword_2_1_3_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getRightKeyword_2_1_3());
		}
		public static IGrammarAwareElementType createObjectRef_RightResAssignment_2_1_4ElementType() {
			return new IGrammarAwareElementType("ObjectRef_RightResAssignment_2_1_4_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getRightResAssignment_2_1_4());
		}
		public static IGrammarAwareElementType createObjectRef_RightResNamedResourceCrossReference_2_1_4_0ElementType() {
			return new IGrammarAwareElementType("ObjectRef_RightResNamedResourceCrossReference_2_1_4_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getRightResNamedResourceCrossReference_2_1_4_0());
		}
		public static IGrammarAwareElementType createObjectRef_RightResNamedResourceIDTerminalRuleCall_2_1_4_0_1ElementType() {
			return new IGrammarAwareElementType("ObjectRef_RightResNamedResourceIDTerminalRuleCall_2_1_4_0_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getRightResNamedResourceIDTerminalRuleCall_2_1_4_0_1());
		}
		public static IGrammarAwareElementType createObjectRef_RightFragAssignment_2_1_5ElementType() {
			return new IGrammarAwareElementType("ObjectRef_RightFragAssignment_2_1_5_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getRightFragAssignment_2_1_5());
		}
		public static IGrammarAwareElementType createObjectRef_RightFragFRAGMENTTerminalRuleCall_2_1_5_0ElementType() {
			return new IGrammarAwareElementType("ObjectRef_RightFragFRAGMENTTerminalRuleCall_2_1_5_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getRightFragFRAGMENTTerminalRuleCall_2_1_5_0());
		}
		public static IGrammarAwareElementType createObjectRef_Group_3ElementType() {
			return new IGrammarAwareElementType("ObjectRef_Group_3_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createObjectRef_LeftCurlyBracketKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("ObjectRef_LeftCurlyBracketKeyword_3_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getLeftCurlyBracketKeyword_3_0());
		}
		public static IGrammarAwareElementType createObjectRef_Alternatives_3_1ElementType() {
			return new IGrammarAwareElementType("ObjectRef_Alternatives_3_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getAlternatives_3_1());
		}
		public static IGrammarAwareElementType createObjectRef_AssignmentsAssignment_3_1_0ElementType() {
			return new IGrammarAwareElementType("ObjectRef_AssignmentsAssignment_3_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getAssignmentsAssignment_3_1_0());
		}
		public static IGrammarAwareElementType createObjectRef_AssignmentsBiSingleAssignmentParserRuleCall_3_1_0_0ElementType() {
			return new IGrammarAwareElementType("ObjectRef_AssignmentsBiSingleAssignmentParserRuleCall_3_1_0_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getAssignmentsBiSingleAssignmentParserRuleCall_3_1_0_0());
		}
		public static IGrammarAwareElementType createObjectRef_AssignmentsAssignment_3_1_1ElementType() {
			return new IGrammarAwareElementType("ObjectRef_AssignmentsAssignment_3_1_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getAssignmentsAssignment_3_1_1());
		}
		public static IGrammarAwareElementType createObjectRef_AssignmentsBiListAssignmentParserRuleCall_3_1_1_0ElementType() {
			return new IGrammarAwareElementType("ObjectRef_AssignmentsBiListAssignmentParserRuleCall_3_1_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getAssignmentsBiListAssignmentParserRuleCall_3_1_1_0());
		}
		public static IGrammarAwareElementType createObjectRef_Group_3_2ElementType() {
			return new IGrammarAwareElementType("ObjectRef_Group_3_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getGroup_3_2());
		}
		public static IGrammarAwareElementType createObjectRef_LeftKeyword_3_2_0ElementType() {
			return new IGrammarAwareElementType("ObjectRef_LeftKeyword_3_2_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getLeftKeyword_3_2_0());
		}
		public static IGrammarAwareElementType createObjectRef_LeftMigAssignment_3_2_1ElementType() {
			return new IGrammarAwareElementType("ObjectRef_LeftMigAssignment_3_2_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getLeftMigAssignment_3_2_1());
		}
		public static IGrammarAwareElementType createObjectRef_LeftMigMigrationParserRuleCall_3_2_1_0ElementType() {
			return new IGrammarAwareElementType("ObjectRef_LeftMigMigrationParserRuleCall_3_2_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getLeftMigMigrationParserRuleCall_3_2_1_0());
		}
		public static IGrammarAwareElementType createObjectRef_Group_3_3ElementType() {
			return new IGrammarAwareElementType("ObjectRef_Group_3_3_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getGroup_3_3());
		}
		public static IGrammarAwareElementType createObjectRef_RightKeyword_3_3_0ElementType() {
			return new IGrammarAwareElementType("ObjectRef_RightKeyword_3_3_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getRightKeyword_3_3_0());
		}
		public static IGrammarAwareElementType createObjectRef_RightMigAssignment_3_3_1ElementType() {
			return new IGrammarAwareElementType("ObjectRef_RightMigAssignment_3_3_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getRightMigAssignment_3_3_1());
		}
		public static IGrammarAwareElementType createObjectRef_RightMigMigrationParserRuleCall_3_3_1_0ElementType() {
			return new IGrammarAwareElementType("ObjectRef_RightMigMigrationParserRuleCall_3_3_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getRightMigMigrationParserRuleCall_3_3_1_0());
		}
		public static IGrammarAwareElementType createObjectRef_RightCurlyBracketKeyword_3_4ElementType() {
			return new IGrammarAwareElementType("ObjectRef_RightCurlyBracketKeyword_3_4_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectRefAccess().getRightCurlyBracketKeyword_3_4());
		}
	}

	public static final IGrammarAwareElementType ObjectRef_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRefElementType());

	public static final IGrammarAwareElementType ObjectRef_Group_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_GroupElementType());

	public static final IGrammarAwareElementType ObjectRef_ObjectKeyword_0_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_ObjectKeyword_0ElementType());

	public static final IGrammarAwareElementType ObjectRef_NameAssignment_1_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType ObjectRef_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType ObjectRef_Alternatives_2_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_Alternatives_2ElementType());

	public static final IGrammarAwareElementType ObjectRef_Group_2_0_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_Group_2_0ElementType());

	public static final IGrammarAwareElementType ObjectRef_LeftResAssignment_2_0_0_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_LeftResAssignment_2_0_0ElementType());

	public static final IGrammarAwareElementType ObjectRef_LeftResNamedResourceCrossReference_2_0_0_0_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_LeftResNamedResourceCrossReference_2_0_0_0ElementType());

	public static final IGrammarAwareElementType ObjectRef_LeftResNamedResourceIDTerminalRuleCall_2_0_0_0_1_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_LeftResNamedResourceIDTerminalRuleCall_2_0_0_0_1ElementType());

	public static final IGrammarAwareElementType ObjectRef_LeftFragAssignment_2_0_1_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_LeftFragAssignment_2_0_1ElementType());

	public static final IGrammarAwareElementType ObjectRef_LeftFragFRAGMENTTerminalRuleCall_2_0_1_0_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_LeftFragFRAGMENTTerminalRuleCall_2_0_1_0ElementType());

	public static final IGrammarAwareElementType ObjectRef_Group_2_1_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_Group_2_1ElementType());

	public static final IGrammarAwareElementType ObjectRef_LeftKeyword_2_1_0_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_LeftKeyword_2_1_0ElementType());

	public static final IGrammarAwareElementType ObjectRef_LeftResAssignment_2_1_1_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_LeftResAssignment_2_1_1ElementType());

	public static final IGrammarAwareElementType ObjectRef_LeftResNamedResourceCrossReference_2_1_1_0_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_LeftResNamedResourceCrossReference_2_1_1_0ElementType());

	public static final IGrammarAwareElementType ObjectRef_LeftResNamedResourceIDTerminalRuleCall_2_1_1_0_1_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_LeftResNamedResourceIDTerminalRuleCall_2_1_1_0_1ElementType());

	public static final IGrammarAwareElementType ObjectRef_LeftFragAssignment_2_1_2_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_LeftFragAssignment_2_1_2ElementType());

	public static final IGrammarAwareElementType ObjectRef_LeftFragFRAGMENTTerminalRuleCall_2_1_2_0_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_LeftFragFRAGMENTTerminalRuleCall_2_1_2_0ElementType());

	public static final IGrammarAwareElementType ObjectRef_RightKeyword_2_1_3_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_RightKeyword_2_1_3ElementType());

	public static final IGrammarAwareElementType ObjectRef_RightResAssignment_2_1_4_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_RightResAssignment_2_1_4ElementType());

	public static final IGrammarAwareElementType ObjectRef_RightResNamedResourceCrossReference_2_1_4_0_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_RightResNamedResourceCrossReference_2_1_4_0ElementType());

	public static final IGrammarAwareElementType ObjectRef_RightResNamedResourceIDTerminalRuleCall_2_1_4_0_1_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_RightResNamedResourceIDTerminalRuleCall_2_1_4_0_1ElementType());

	public static final IGrammarAwareElementType ObjectRef_RightFragAssignment_2_1_5_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_RightFragAssignment_2_1_5ElementType());

	public static final IGrammarAwareElementType ObjectRef_RightFragFRAGMENTTerminalRuleCall_2_1_5_0_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_RightFragFRAGMENTTerminalRuleCall_2_1_5_0ElementType());

	public static final IGrammarAwareElementType ObjectRef_Group_3_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_Group_3ElementType());

	public static final IGrammarAwareElementType ObjectRef_LeftCurlyBracketKeyword_3_0_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_LeftCurlyBracketKeyword_3_0ElementType());

	public static final IGrammarAwareElementType ObjectRef_Alternatives_3_1_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_Alternatives_3_1ElementType());

	public static final IGrammarAwareElementType ObjectRef_AssignmentsAssignment_3_1_0_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_AssignmentsAssignment_3_1_0ElementType());

	public static final IGrammarAwareElementType ObjectRef_AssignmentsBiSingleAssignmentParserRuleCall_3_1_0_0_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_AssignmentsBiSingleAssignmentParserRuleCall_3_1_0_0ElementType());

	public static final IGrammarAwareElementType ObjectRef_AssignmentsAssignment_3_1_1_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_AssignmentsAssignment_3_1_1ElementType());

	public static final IGrammarAwareElementType ObjectRef_AssignmentsBiListAssignmentParserRuleCall_3_1_1_0_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_AssignmentsBiListAssignmentParserRuleCall_3_1_1_0ElementType());

	public static final IGrammarAwareElementType ObjectRef_Group_3_2_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_Group_3_2ElementType());

	public static final IGrammarAwareElementType ObjectRef_LeftKeyword_3_2_0_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_LeftKeyword_3_2_0ElementType());

	public static final IGrammarAwareElementType ObjectRef_LeftMigAssignment_3_2_1_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_LeftMigAssignment_3_2_1ElementType());

	public static final IGrammarAwareElementType ObjectRef_LeftMigMigrationParserRuleCall_3_2_1_0_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_LeftMigMigrationParserRuleCall_3_2_1_0ElementType());

	public static final IGrammarAwareElementType ObjectRef_Group_3_3_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_Group_3_3ElementType());

	public static final IGrammarAwareElementType ObjectRef_RightKeyword_3_3_0_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_RightKeyword_3_3_0ElementType());

	public static final IGrammarAwareElementType ObjectRef_RightMigAssignment_3_3_1_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_RightMigAssignment_3_3_1ElementType());

	public static final IGrammarAwareElementType ObjectRef_RightMigMigrationParserRuleCall_3_3_1_0_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_RightMigMigrationParserRuleCall_3_3_1_0ElementType());

	public static final IGrammarAwareElementType ObjectRef_RightCurlyBracketKeyword_3_4_ELEMENT_TYPE = associate(ObjectRefFactory.createObjectRef_RightCurlyBracketKeyword_3_4ElementType());

	private static class AssignmentFactory {
		public static IGrammarAwareElementType createAssignmentElementType() {
			return new IGrammarAwareElementType("Assignment_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentRule());
		}
		public static IGrammarAwareElementType createAssignment_AlternativesElementType() {
			return new IGrammarAwareElementType("Assignment_Alternatives_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createAssignment_BiSingleAssignmentParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Assignment_BiSingleAssignmentParserRuleCall_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getBiSingleAssignmentParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAssignment_BiListAssignmentParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Assignment_BiListAssignmentParserRuleCall_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getBiListAssignmentParserRuleCall_1());
		}
		public static IGrammarAwareElementType createAssignment_MonoSingleAssignmentParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("Assignment_MonoSingleAssignmentParserRuleCall_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getMonoSingleAssignmentParserRuleCall_2());
		}
		public static IGrammarAwareElementType createAssignment_MonoListAssignmentParserRuleCall_3ElementType() {
			return new IGrammarAwareElementType("Assignment_MonoListAssignmentParserRuleCall_3_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentAccess().getMonoListAssignmentParserRuleCall_3());
		}
	}

	public static final IGrammarAwareElementType Assignment_ELEMENT_TYPE = associate(AssignmentFactory.createAssignmentElementType());

	public static final IGrammarAwareElementType Assignment_Alternatives_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_AlternativesElementType());

	public static final IGrammarAwareElementType Assignment_BiSingleAssignmentParserRuleCall_0_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_BiSingleAssignmentParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Assignment_BiListAssignmentParserRuleCall_1_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_BiListAssignmentParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType Assignment_MonoSingleAssignmentParserRuleCall_2_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_MonoSingleAssignmentParserRuleCall_2ElementType());

	public static final IGrammarAwareElementType Assignment_MonoListAssignmentParserRuleCall_3_ELEMENT_TYPE = associate(AssignmentFactory.createAssignment_MonoListAssignmentParserRuleCall_3ElementType());

	private static class BiSingleAssignmentFactory {
		public static IGrammarAwareElementType createBiSingleAssignmentElementType() {
			return new IGrammarAwareElementType("BiSingleAssignment_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiSingleAssignmentRule());
		}
		public static IGrammarAwareElementType createBiSingleAssignment_GroupElementType() {
			return new IGrammarAwareElementType("BiSingleAssignment_Group_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiSingleAssignmentAccess().getGroup());
		}
		public static IGrammarAwareElementType createBiSingleAssignment_FeatureAssignment_0ElementType() {
			return new IGrammarAwareElementType("BiSingleAssignment_FeatureAssignment_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiSingleAssignmentAccess().getFeatureAssignment_0());
		}
		public static IGrammarAwareElementType createBiSingleAssignment_FeatureIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("BiSingleAssignment_FeatureIDTerminalRuleCall_0_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiSingleAssignmentAccess().getFeatureIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createBiSingleAssignment_EqualsSignKeyword_1ElementType() {
			return new IGrammarAwareElementType("BiSingleAssignment_EqualsSignKeyword_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiSingleAssignmentAccess().getEqualsSignKeyword_1());
		}
		public static IGrammarAwareElementType createBiSingleAssignment_LeftValueAssignment_2ElementType() {
			return new IGrammarAwareElementType("BiSingleAssignment_LeftValueAssignment_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiSingleAssignmentAccess().getLeftValueAssignment_2());
		}
		public static IGrammarAwareElementType createBiSingleAssignment_LeftValueSingleAssignmentValueParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("BiSingleAssignment_LeftValueSingleAssignmentValueParserRuleCall_2_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiSingleAssignmentAccess().getLeftValueSingleAssignmentValueParserRuleCall_2_0());
		}
		public static IGrammarAwareElementType createBiSingleAssignment_VerticalLineKeyword_3ElementType() {
			return new IGrammarAwareElementType("BiSingleAssignment_VerticalLineKeyword_3_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiSingleAssignmentAccess().getVerticalLineKeyword_3());
		}
		public static IGrammarAwareElementType createBiSingleAssignment_RightValueAssignment_4ElementType() {
			return new IGrammarAwareElementType("BiSingleAssignment_RightValueAssignment_4_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiSingleAssignmentAccess().getRightValueAssignment_4());
		}
		public static IGrammarAwareElementType createBiSingleAssignment_RightValueSingleAssignmentValueParserRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("BiSingleAssignment_RightValueSingleAssignmentValueParserRuleCall_4_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiSingleAssignmentAccess().getRightValueSingleAssignmentValueParserRuleCall_4_0());
		}
		public static IGrammarAwareElementType createBiSingleAssignment_SemicolonKeyword_5ElementType() {
			return new IGrammarAwareElementType("BiSingleAssignment_SemicolonKeyword_5_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiSingleAssignmentAccess().getSemicolonKeyword_5());
		}
	}

	public static final IGrammarAwareElementType BiSingleAssignment_ELEMENT_TYPE = associate(BiSingleAssignmentFactory.createBiSingleAssignmentElementType());

	public static final IGrammarAwareElementType BiSingleAssignment_Group_ELEMENT_TYPE = associate(BiSingleAssignmentFactory.createBiSingleAssignment_GroupElementType());

	public static final IGrammarAwareElementType BiSingleAssignment_FeatureAssignment_0_ELEMENT_TYPE = associate(BiSingleAssignmentFactory.createBiSingleAssignment_FeatureAssignment_0ElementType());

	public static final IGrammarAwareElementType BiSingleAssignment_FeatureIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(BiSingleAssignmentFactory.createBiSingleAssignment_FeatureIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType BiSingleAssignment_EqualsSignKeyword_1_ELEMENT_TYPE = associate(BiSingleAssignmentFactory.createBiSingleAssignment_EqualsSignKeyword_1ElementType());

	public static final IGrammarAwareElementType BiSingleAssignment_LeftValueAssignment_2_ELEMENT_TYPE = associate(BiSingleAssignmentFactory.createBiSingleAssignment_LeftValueAssignment_2ElementType());

	public static final IGrammarAwareElementType BiSingleAssignment_LeftValueSingleAssignmentValueParserRuleCall_2_0_ELEMENT_TYPE = associate(BiSingleAssignmentFactory.createBiSingleAssignment_LeftValueSingleAssignmentValueParserRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType BiSingleAssignment_VerticalLineKeyword_3_ELEMENT_TYPE = associate(BiSingleAssignmentFactory.createBiSingleAssignment_VerticalLineKeyword_3ElementType());

	public static final IGrammarAwareElementType BiSingleAssignment_RightValueAssignment_4_ELEMENT_TYPE = associate(BiSingleAssignmentFactory.createBiSingleAssignment_RightValueAssignment_4ElementType());

	public static final IGrammarAwareElementType BiSingleAssignment_RightValueSingleAssignmentValueParserRuleCall_4_0_ELEMENT_TYPE = associate(BiSingleAssignmentFactory.createBiSingleAssignment_RightValueSingleAssignmentValueParserRuleCall_4_0ElementType());

	public static final IGrammarAwareElementType BiSingleAssignment_SemicolonKeyword_5_ELEMENT_TYPE = associate(BiSingleAssignmentFactory.createBiSingleAssignment_SemicolonKeyword_5ElementType());

	private static class BiListAssignmentFactory {
		public static IGrammarAwareElementType createBiListAssignmentElementType() {
			return new IGrammarAwareElementType("BiListAssignment_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiListAssignmentRule());
		}
		public static IGrammarAwareElementType createBiListAssignment_GroupElementType() {
			return new IGrammarAwareElementType("BiListAssignment_Group_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiListAssignmentAccess().getGroup());
		}
		public static IGrammarAwareElementType createBiListAssignment_FeatureAssignment_0ElementType() {
			return new IGrammarAwareElementType("BiListAssignment_FeatureAssignment_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiListAssignmentAccess().getFeatureAssignment_0());
		}
		public static IGrammarAwareElementType createBiListAssignment_FeatureIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("BiListAssignment_FeatureIDTerminalRuleCall_0_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiListAssignmentAccess().getFeatureIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createBiListAssignment_EqualsSignKeyword_1ElementType() {
			return new IGrammarAwareElementType("BiListAssignment_EqualsSignKeyword_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiListAssignmentAccess().getEqualsSignKeyword_1());
		}
		public static IGrammarAwareElementType createBiListAssignment_LeftSquareBracketKeyword_2ElementType() {
			return new IGrammarAwareElementType("BiListAssignment_LeftSquareBracketKeyword_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiListAssignmentAccess().getLeftSquareBracketKeyword_2());
		}
		public static IGrammarAwareElementType createBiListAssignment_Group_3ElementType() {
			return new IGrammarAwareElementType("BiListAssignment_Group_3_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiListAssignmentAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createBiListAssignment_LeftValuesAssignment_3_0ElementType() {
			return new IGrammarAwareElementType("BiListAssignment_LeftValuesAssignment_3_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiListAssignmentAccess().getLeftValuesAssignment_3_0());
		}
		public static IGrammarAwareElementType createBiListAssignment_LeftValuesListAssignmentValueParserRuleCall_3_0_0ElementType() {
			return new IGrammarAwareElementType("BiListAssignment_LeftValuesListAssignmentValueParserRuleCall_3_0_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiListAssignmentAccess().getLeftValuesListAssignmentValueParserRuleCall_3_0_0());
		}
		public static IGrammarAwareElementType createBiListAssignment_Group_3_1ElementType() {
			return new IGrammarAwareElementType("BiListAssignment_Group_3_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiListAssignmentAccess().getGroup_3_1());
		}
		public static IGrammarAwareElementType createBiListAssignment_CommaKeyword_3_1_0ElementType() {
			return new IGrammarAwareElementType("BiListAssignment_CommaKeyword_3_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiListAssignmentAccess().getCommaKeyword_3_1_0());
		}
		public static IGrammarAwareElementType createBiListAssignment_LeftValuesAssignment_3_1_1ElementType() {
			return new IGrammarAwareElementType("BiListAssignment_LeftValuesAssignment_3_1_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiListAssignmentAccess().getLeftValuesAssignment_3_1_1());
		}
		public static IGrammarAwareElementType createBiListAssignment_LeftValuesListAssignmentValueParserRuleCall_3_1_1_0ElementType() {
			return new IGrammarAwareElementType("BiListAssignment_LeftValuesListAssignmentValueParserRuleCall_3_1_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiListAssignmentAccess().getLeftValuesListAssignmentValueParserRuleCall_3_1_1_0());
		}
		public static IGrammarAwareElementType createBiListAssignment_VerticalLineKeyword_4ElementType() {
			return new IGrammarAwareElementType("BiListAssignment_VerticalLineKeyword_4_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiListAssignmentAccess().getVerticalLineKeyword_4());
		}
		public static IGrammarAwareElementType createBiListAssignment_Group_5ElementType() {
			return new IGrammarAwareElementType("BiListAssignment_Group_5_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiListAssignmentAccess().getGroup_5());
		}
		public static IGrammarAwareElementType createBiListAssignment_RightValuesAssignment_5_0ElementType() {
			return new IGrammarAwareElementType("BiListAssignment_RightValuesAssignment_5_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiListAssignmentAccess().getRightValuesAssignment_5_0());
		}
		public static IGrammarAwareElementType createBiListAssignment_RightValuesListAssignmentValueParserRuleCall_5_0_0ElementType() {
			return new IGrammarAwareElementType("BiListAssignment_RightValuesListAssignmentValueParserRuleCall_5_0_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiListAssignmentAccess().getRightValuesListAssignmentValueParserRuleCall_5_0_0());
		}
		public static IGrammarAwareElementType createBiListAssignment_Group_5_1ElementType() {
			return new IGrammarAwareElementType("BiListAssignment_Group_5_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiListAssignmentAccess().getGroup_5_1());
		}
		public static IGrammarAwareElementType createBiListAssignment_CommaKeyword_5_1_0ElementType() {
			return new IGrammarAwareElementType("BiListAssignment_CommaKeyword_5_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiListAssignmentAccess().getCommaKeyword_5_1_0());
		}
		public static IGrammarAwareElementType createBiListAssignment_RightValuesAssignment_5_1_1ElementType() {
			return new IGrammarAwareElementType("BiListAssignment_RightValuesAssignment_5_1_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiListAssignmentAccess().getRightValuesAssignment_5_1_1());
		}
		public static IGrammarAwareElementType createBiListAssignment_RightValuesListAssignmentValueParserRuleCall_5_1_1_0ElementType() {
			return new IGrammarAwareElementType("BiListAssignment_RightValuesListAssignmentValueParserRuleCall_5_1_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiListAssignmentAccess().getRightValuesListAssignmentValueParserRuleCall_5_1_1_0());
		}
		public static IGrammarAwareElementType createBiListAssignment_RightSquareBracketKeyword_6ElementType() {
			return new IGrammarAwareElementType("BiListAssignment_RightSquareBracketKeyword_6_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiListAssignmentAccess().getRightSquareBracketKeyword_6());
		}
		public static IGrammarAwareElementType createBiListAssignment_SemicolonKeyword_7ElementType() {
			return new IGrammarAwareElementType("BiListAssignment_SemicolonKeyword_7_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBiListAssignmentAccess().getSemicolonKeyword_7());
		}
	}

	public static final IGrammarAwareElementType BiListAssignment_ELEMENT_TYPE = associate(BiListAssignmentFactory.createBiListAssignmentElementType());

	public static final IGrammarAwareElementType BiListAssignment_Group_ELEMENT_TYPE = associate(BiListAssignmentFactory.createBiListAssignment_GroupElementType());

	public static final IGrammarAwareElementType BiListAssignment_FeatureAssignment_0_ELEMENT_TYPE = associate(BiListAssignmentFactory.createBiListAssignment_FeatureAssignment_0ElementType());

	public static final IGrammarAwareElementType BiListAssignment_FeatureIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(BiListAssignmentFactory.createBiListAssignment_FeatureIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType BiListAssignment_EqualsSignKeyword_1_ELEMENT_TYPE = associate(BiListAssignmentFactory.createBiListAssignment_EqualsSignKeyword_1ElementType());

	public static final IGrammarAwareElementType BiListAssignment_LeftSquareBracketKeyword_2_ELEMENT_TYPE = associate(BiListAssignmentFactory.createBiListAssignment_LeftSquareBracketKeyword_2ElementType());

	public static final IGrammarAwareElementType BiListAssignment_Group_3_ELEMENT_TYPE = associate(BiListAssignmentFactory.createBiListAssignment_Group_3ElementType());

	public static final IGrammarAwareElementType BiListAssignment_LeftValuesAssignment_3_0_ELEMENT_TYPE = associate(BiListAssignmentFactory.createBiListAssignment_LeftValuesAssignment_3_0ElementType());

	public static final IGrammarAwareElementType BiListAssignment_LeftValuesListAssignmentValueParserRuleCall_3_0_0_ELEMENT_TYPE = associate(BiListAssignmentFactory.createBiListAssignment_LeftValuesListAssignmentValueParserRuleCall_3_0_0ElementType());

	public static final IGrammarAwareElementType BiListAssignment_Group_3_1_ELEMENT_TYPE = associate(BiListAssignmentFactory.createBiListAssignment_Group_3_1ElementType());

	public static final IGrammarAwareElementType BiListAssignment_CommaKeyword_3_1_0_ELEMENT_TYPE = associate(BiListAssignmentFactory.createBiListAssignment_CommaKeyword_3_1_0ElementType());

	public static final IGrammarAwareElementType BiListAssignment_LeftValuesAssignment_3_1_1_ELEMENT_TYPE = associate(BiListAssignmentFactory.createBiListAssignment_LeftValuesAssignment_3_1_1ElementType());

	public static final IGrammarAwareElementType BiListAssignment_LeftValuesListAssignmentValueParserRuleCall_3_1_1_0_ELEMENT_TYPE = associate(BiListAssignmentFactory.createBiListAssignment_LeftValuesListAssignmentValueParserRuleCall_3_1_1_0ElementType());

	public static final IGrammarAwareElementType BiListAssignment_VerticalLineKeyword_4_ELEMENT_TYPE = associate(BiListAssignmentFactory.createBiListAssignment_VerticalLineKeyword_4ElementType());

	public static final IGrammarAwareElementType BiListAssignment_Group_5_ELEMENT_TYPE = associate(BiListAssignmentFactory.createBiListAssignment_Group_5ElementType());

	public static final IGrammarAwareElementType BiListAssignment_RightValuesAssignment_5_0_ELEMENT_TYPE = associate(BiListAssignmentFactory.createBiListAssignment_RightValuesAssignment_5_0ElementType());

	public static final IGrammarAwareElementType BiListAssignment_RightValuesListAssignmentValueParserRuleCall_5_0_0_ELEMENT_TYPE = associate(BiListAssignmentFactory.createBiListAssignment_RightValuesListAssignmentValueParserRuleCall_5_0_0ElementType());

	public static final IGrammarAwareElementType BiListAssignment_Group_5_1_ELEMENT_TYPE = associate(BiListAssignmentFactory.createBiListAssignment_Group_5_1ElementType());

	public static final IGrammarAwareElementType BiListAssignment_CommaKeyword_5_1_0_ELEMENT_TYPE = associate(BiListAssignmentFactory.createBiListAssignment_CommaKeyword_5_1_0ElementType());

	public static final IGrammarAwareElementType BiListAssignment_RightValuesAssignment_5_1_1_ELEMENT_TYPE = associate(BiListAssignmentFactory.createBiListAssignment_RightValuesAssignment_5_1_1ElementType());

	public static final IGrammarAwareElementType BiListAssignment_RightValuesListAssignmentValueParserRuleCall_5_1_1_0_ELEMENT_TYPE = associate(BiListAssignmentFactory.createBiListAssignment_RightValuesListAssignmentValueParserRuleCall_5_1_1_0ElementType());

	public static final IGrammarAwareElementType BiListAssignment_RightSquareBracketKeyword_6_ELEMENT_TYPE = associate(BiListAssignmentFactory.createBiListAssignment_RightSquareBracketKeyword_6ElementType());

	public static final IGrammarAwareElementType BiListAssignment_SemicolonKeyword_7_ELEMENT_TYPE = associate(BiListAssignmentFactory.createBiListAssignment_SemicolonKeyword_7ElementType());

	private static class MonoSingleAssignmentFactory {
		public static IGrammarAwareElementType createMonoSingleAssignmentElementType() {
			return new IGrammarAwareElementType("MonoSingleAssignment_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMonoSingleAssignmentRule());
		}
		public static IGrammarAwareElementType createMonoSingleAssignment_GroupElementType() {
			return new IGrammarAwareElementType("MonoSingleAssignment_Group_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMonoSingleAssignmentAccess().getGroup());
		}
		public static IGrammarAwareElementType createMonoSingleAssignment_FeatureAssignment_0ElementType() {
			return new IGrammarAwareElementType("MonoSingleAssignment_FeatureAssignment_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMonoSingleAssignmentAccess().getFeatureAssignment_0());
		}
		public static IGrammarAwareElementType createMonoSingleAssignment_FeatureIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("MonoSingleAssignment_FeatureIDTerminalRuleCall_0_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMonoSingleAssignmentAccess().getFeatureIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createMonoSingleAssignment_EqualsSignKeyword_1ElementType() {
			return new IGrammarAwareElementType("MonoSingleAssignment_EqualsSignKeyword_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMonoSingleAssignmentAccess().getEqualsSignKeyword_1());
		}
		public static IGrammarAwareElementType createMonoSingleAssignment_LeftValueAssignment_2ElementType() {
			return new IGrammarAwareElementType("MonoSingleAssignment_LeftValueAssignment_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMonoSingleAssignmentAccess().getLeftValueAssignment_2());
		}
		public static IGrammarAwareElementType createMonoSingleAssignment_LeftValueSingleAssignmentValueParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("MonoSingleAssignment_LeftValueSingleAssignmentValueParserRuleCall_2_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMonoSingleAssignmentAccess().getLeftValueSingleAssignmentValueParserRuleCall_2_0());
		}
		public static IGrammarAwareElementType createMonoSingleAssignment_SemicolonKeyword_3ElementType() {
			return new IGrammarAwareElementType("MonoSingleAssignment_SemicolonKeyword_3_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMonoSingleAssignmentAccess().getSemicolonKeyword_3());
		}
	}

	public static final IGrammarAwareElementType MonoSingleAssignment_ELEMENT_TYPE = associate(MonoSingleAssignmentFactory.createMonoSingleAssignmentElementType());

	public static final IGrammarAwareElementType MonoSingleAssignment_Group_ELEMENT_TYPE = associate(MonoSingleAssignmentFactory.createMonoSingleAssignment_GroupElementType());

	public static final IGrammarAwareElementType MonoSingleAssignment_FeatureAssignment_0_ELEMENT_TYPE = associate(MonoSingleAssignmentFactory.createMonoSingleAssignment_FeatureAssignment_0ElementType());

	public static final IGrammarAwareElementType MonoSingleAssignment_FeatureIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(MonoSingleAssignmentFactory.createMonoSingleAssignment_FeatureIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType MonoSingleAssignment_EqualsSignKeyword_1_ELEMENT_TYPE = associate(MonoSingleAssignmentFactory.createMonoSingleAssignment_EqualsSignKeyword_1ElementType());

	public static final IGrammarAwareElementType MonoSingleAssignment_LeftValueAssignment_2_ELEMENT_TYPE = associate(MonoSingleAssignmentFactory.createMonoSingleAssignment_LeftValueAssignment_2ElementType());

	public static final IGrammarAwareElementType MonoSingleAssignment_LeftValueSingleAssignmentValueParserRuleCall_2_0_ELEMENT_TYPE = associate(MonoSingleAssignmentFactory.createMonoSingleAssignment_LeftValueSingleAssignmentValueParserRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType MonoSingleAssignment_SemicolonKeyword_3_ELEMENT_TYPE = associate(MonoSingleAssignmentFactory.createMonoSingleAssignment_SemicolonKeyword_3ElementType());

	private static class MonoListAssignmentFactory {
		public static IGrammarAwareElementType createMonoListAssignmentElementType() {
			return new IGrammarAwareElementType("MonoListAssignment_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMonoListAssignmentRule());
		}
		public static IGrammarAwareElementType createMonoListAssignment_GroupElementType() {
			return new IGrammarAwareElementType("MonoListAssignment_Group_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMonoListAssignmentAccess().getGroup());
		}
		public static IGrammarAwareElementType createMonoListAssignment_FeatureAssignment_0ElementType() {
			return new IGrammarAwareElementType("MonoListAssignment_FeatureAssignment_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMonoListAssignmentAccess().getFeatureAssignment_0());
		}
		public static IGrammarAwareElementType createMonoListAssignment_FeatureIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("MonoListAssignment_FeatureIDTerminalRuleCall_0_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMonoListAssignmentAccess().getFeatureIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createMonoListAssignment_EqualsSignKeyword_1ElementType() {
			return new IGrammarAwareElementType("MonoListAssignment_EqualsSignKeyword_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMonoListAssignmentAccess().getEqualsSignKeyword_1());
		}
		public static IGrammarAwareElementType createMonoListAssignment_LeftSquareBracketKeyword_2ElementType() {
			return new IGrammarAwareElementType("MonoListAssignment_LeftSquareBracketKeyword_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMonoListAssignmentAccess().getLeftSquareBracketKeyword_2());
		}
		public static IGrammarAwareElementType createMonoListAssignment_Group_3ElementType() {
			return new IGrammarAwareElementType("MonoListAssignment_Group_3_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMonoListAssignmentAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createMonoListAssignment_LeftValuesAssignment_3_0ElementType() {
			return new IGrammarAwareElementType("MonoListAssignment_LeftValuesAssignment_3_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMonoListAssignmentAccess().getLeftValuesAssignment_3_0());
		}
		public static IGrammarAwareElementType createMonoListAssignment_LeftValuesAssignmentValueParserRuleCall_3_0_0ElementType() {
			return new IGrammarAwareElementType("MonoListAssignment_LeftValuesAssignmentValueParserRuleCall_3_0_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMonoListAssignmentAccess().getLeftValuesAssignmentValueParserRuleCall_3_0_0());
		}
		public static IGrammarAwareElementType createMonoListAssignment_Group_3_1ElementType() {
			return new IGrammarAwareElementType("MonoListAssignment_Group_3_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMonoListAssignmentAccess().getGroup_3_1());
		}
		public static IGrammarAwareElementType createMonoListAssignment_CommaKeyword_3_1_0ElementType() {
			return new IGrammarAwareElementType("MonoListAssignment_CommaKeyword_3_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMonoListAssignmentAccess().getCommaKeyword_3_1_0());
		}
		public static IGrammarAwareElementType createMonoListAssignment_LeftValuesAssignment_3_1_1ElementType() {
			return new IGrammarAwareElementType("MonoListAssignment_LeftValuesAssignment_3_1_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMonoListAssignmentAccess().getLeftValuesAssignment_3_1_1());
		}
		public static IGrammarAwareElementType createMonoListAssignment_LeftValuesAssignmentValueParserRuleCall_3_1_1_0ElementType() {
			return new IGrammarAwareElementType("MonoListAssignment_LeftValuesAssignmentValueParserRuleCall_3_1_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMonoListAssignmentAccess().getLeftValuesAssignmentValueParserRuleCall_3_1_1_0());
		}
		public static IGrammarAwareElementType createMonoListAssignment_RightSquareBracketKeyword_4ElementType() {
			return new IGrammarAwareElementType("MonoListAssignment_RightSquareBracketKeyword_4_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMonoListAssignmentAccess().getRightSquareBracketKeyword_4());
		}
		public static IGrammarAwareElementType createMonoListAssignment_SemicolonKeyword_5ElementType() {
			return new IGrammarAwareElementType("MonoListAssignment_SemicolonKeyword_5_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMonoListAssignmentAccess().getSemicolonKeyword_5());
		}
	}

	public static final IGrammarAwareElementType MonoListAssignment_ELEMENT_TYPE = associate(MonoListAssignmentFactory.createMonoListAssignmentElementType());

	public static final IGrammarAwareElementType MonoListAssignment_Group_ELEMENT_TYPE = associate(MonoListAssignmentFactory.createMonoListAssignment_GroupElementType());

	public static final IGrammarAwareElementType MonoListAssignment_FeatureAssignment_0_ELEMENT_TYPE = associate(MonoListAssignmentFactory.createMonoListAssignment_FeatureAssignment_0ElementType());

	public static final IGrammarAwareElementType MonoListAssignment_FeatureIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(MonoListAssignmentFactory.createMonoListAssignment_FeatureIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType MonoListAssignment_EqualsSignKeyword_1_ELEMENT_TYPE = associate(MonoListAssignmentFactory.createMonoListAssignment_EqualsSignKeyword_1ElementType());

	public static final IGrammarAwareElementType MonoListAssignment_LeftSquareBracketKeyword_2_ELEMENT_TYPE = associate(MonoListAssignmentFactory.createMonoListAssignment_LeftSquareBracketKeyword_2ElementType());

	public static final IGrammarAwareElementType MonoListAssignment_Group_3_ELEMENT_TYPE = associate(MonoListAssignmentFactory.createMonoListAssignment_Group_3ElementType());

	public static final IGrammarAwareElementType MonoListAssignment_LeftValuesAssignment_3_0_ELEMENT_TYPE = associate(MonoListAssignmentFactory.createMonoListAssignment_LeftValuesAssignment_3_0ElementType());

	public static final IGrammarAwareElementType MonoListAssignment_LeftValuesAssignmentValueParserRuleCall_3_0_0_ELEMENT_TYPE = associate(MonoListAssignmentFactory.createMonoListAssignment_LeftValuesAssignmentValueParserRuleCall_3_0_0ElementType());

	public static final IGrammarAwareElementType MonoListAssignment_Group_3_1_ELEMENT_TYPE = associate(MonoListAssignmentFactory.createMonoListAssignment_Group_3_1ElementType());

	public static final IGrammarAwareElementType MonoListAssignment_CommaKeyword_3_1_0_ELEMENT_TYPE = associate(MonoListAssignmentFactory.createMonoListAssignment_CommaKeyword_3_1_0ElementType());

	public static final IGrammarAwareElementType MonoListAssignment_LeftValuesAssignment_3_1_1_ELEMENT_TYPE = associate(MonoListAssignmentFactory.createMonoListAssignment_LeftValuesAssignment_3_1_1ElementType());

	public static final IGrammarAwareElementType MonoListAssignment_LeftValuesAssignmentValueParserRuleCall_3_1_1_0_ELEMENT_TYPE = associate(MonoListAssignmentFactory.createMonoListAssignment_LeftValuesAssignmentValueParserRuleCall_3_1_1_0ElementType());

	public static final IGrammarAwareElementType MonoListAssignment_RightSquareBracketKeyword_4_ELEMENT_TYPE = associate(MonoListAssignmentFactory.createMonoListAssignment_RightSquareBracketKeyword_4ElementType());

	public static final IGrammarAwareElementType MonoListAssignment_SemicolonKeyword_5_ELEMENT_TYPE = associate(MonoListAssignmentFactory.createMonoListAssignment_SemicolonKeyword_5ElementType());

	private static class AssignmentValueFactory {
		public static IGrammarAwareElementType createAssignmentValueElementType() {
			return new IGrammarAwareElementType("AssignmentValue_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentValueRule());
		}
		public static IGrammarAwareElementType createAssignmentValue_AlternativesElementType() {
			return new IGrammarAwareElementType("AssignmentValue_Alternatives_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentValueAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createAssignmentValue_ValueAssignment_0ElementType() {
			return new IGrammarAwareElementType("AssignmentValue_ValueAssignment_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentValueAccess().getValueAssignment_0());
		}
		public static IGrammarAwareElementType createAssignmentValue_ValueSTRINGTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("AssignmentValue_ValueSTRINGTerminalRuleCall_0_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentValueAccess().getValueSTRINGTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createAssignmentValue_Group_1ElementType() {
			return new IGrammarAwareElementType("AssignmentValue_Group_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentValueAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createAssignmentValue_RefObjectAssignment_1_0ElementType() {
			return new IGrammarAwareElementType("AssignmentValue_RefObjectAssignment_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentValueAccess().getRefObjectAssignment_1_0());
		}
		public static IGrammarAwareElementType createAssignmentValue_RefObjectNamedObjectCrossReference_1_0_0ElementType() {
			return new IGrammarAwareElementType("AssignmentValue_RefObjectNamedObjectCrossReference_1_0_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentValueAccess().getRefObjectNamedObjectCrossReference_1_0_0());
		}
		public static IGrammarAwareElementType createAssignmentValue_RefObjectNamedObjectIDTerminalRuleCall_1_0_0_1ElementType() {
			return new IGrammarAwareElementType("AssignmentValue_RefObjectNamedObjectIDTerminalRuleCall_1_0_0_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentValueAccess().getRefObjectNamedObjectIDTerminalRuleCall_1_0_0_1());
		}
		public static IGrammarAwareElementType createAssignmentValue_Group_1_1ElementType() {
			return new IGrammarAwareElementType("AssignmentValue_Group_1_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentValueAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createAssignmentValue_FullStopKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("AssignmentValue_FullStopKeyword_1_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentValueAccess().getFullStopKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createAssignmentValue_RefFeatureAssignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("AssignmentValue_RefFeatureAssignment_1_1_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentValueAccess().getRefFeatureAssignment_1_1_1());
		}
		public static IGrammarAwareElementType createAssignmentValue_RefFeatureIDTerminalRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("AssignmentValue_RefFeatureIDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentValueAccess().getRefFeatureIDTerminalRuleCall_1_1_1_0());
		}
		public static IGrammarAwareElementType createAssignmentValue_Group_1_1_2ElementType() {
			return new IGrammarAwareElementType("AssignmentValue_Group_1_1_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentValueAccess().getGroup_1_1_2());
		}
		public static IGrammarAwareElementType createAssignmentValue_LeftSquareBracketKeyword_1_1_2_0ElementType() {
			return new IGrammarAwareElementType("AssignmentValue_LeftSquareBracketKeyword_1_1_2_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentValueAccess().getLeftSquareBracketKeyword_1_1_2_0());
		}
		public static IGrammarAwareElementType createAssignmentValue_RefIndexAssignment_1_1_2_1ElementType() {
			return new IGrammarAwareElementType("AssignmentValue_RefIndexAssignment_1_1_2_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentValueAccess().getRefIndexAssignment_1_1_2_1());
		}
		public static IGrammarAwareElementType createAssignmentValue_RefIndexINTTerminalRuleCall_1_1_2_1_0ElementType() {
			return new IGrammarAwareElementType("AssignmentValue_RefIndexINTTerminalRuleCall_1_1_2_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentValueAccess().getRefIndexINTTerminalRuleCall_1_1_2_1_0());
		}
		public static IGrammarAwareElementType createAssignmentValue_RightSquareBracketKeyword_1_1_2_2ElementType() {
			return new IGrammarAwareElementType("AssignmentValue_RightSquareBracketKeyword_1_1_2_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentValueAccess().getRightSquareBracketKeyword_1_1_2_2());
		}
		public static IGrammarAwareElementType createAssignmentValue_NewObjectAssignment_2ElementType() {
			return new IGrammarAwareElementType("AssignmentValue_NewObjectAssignment_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentValueAccess().getNewObjectAssignment_2());
		}
		public static IGrammarAwareElementType createAssignmentValue_NewObjectCreatedObjectParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("AssignmentValue_NewObjectCreatedObjectParserRuleCall_2_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentValueAccess().getNewObjectCreatedObjectParserRuleCall_2_0());
		}
		public static IGrammarAwareElementType createAssignmentValue_Group_3ElementType() {
			return new IGrammarAwareElementType("AssignmentValue_Group_3_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentValueAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createAssignmentValue_ImportAssignment_3_0ElementType() {
			return new IGrammarAwareElementType("AssignmentValue_ImportAssignment_3_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentValueAccess().getImportAssignment_3_0());
		}
		public static IGrammarAwareElementType createAssignmentValue_ImportImportCrossReference_3_0_0ElementType() {
			return new IGrammarAwareElementType("AssignmentValue_ImportImportCrossReference_3_0_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentValueAccess().getImportImportCrossReference_3_0_0());
		}
		public static IGrammarAwareElementType createAssignmentValue_ImportImportIDTerminalRuleCall_3_0_0_1ElementType() {
			return new IGrammarAwareElementType("AssignmentValue_ImportImportIDTerminalRuleCall_3_0_0_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentValueAccess().getImportImportIDTerminalRuleCall_3_0_0_1());
		}
		public static IGrammarAwareElementType createAssignmentValue_ImpFragAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("AssignmentValue_ImpFragAssignment_3_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentValueAccess().getImpFragAssignment_3_1());
		}
		public static IGrammarAwareElementType createAssignmentValue_ImpFragFRAGMENTTerminalRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("AssignmentValue_ImpFragFRAGMENTTerminalRuleCall_3_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAssignmentValueAccess().getImpFragFRAGMENTTerminalRuleCall_3_1_0());
		}
	}

	public static final IGrammarAwareElementType AssignmentValue_ELEMENT_TYPE = associate(AssignmentValueFactory.createAssignmentValueElementType());

	public static final IGrammarAwareElementType AssignmentValue_Alternatives_ELEMENT_TYPE = associate(AssignmentValueFactory.createAssignmentValue_AlternativesElementType());

	public static final IGrammarAwareElementType AssignmentValue_ValueAssignment_0_ELEMENT_TYPE = associate(AssignmentValueFactory.createAssignmentValue_ValueAssignment_0ElementType());

	public static final IGrammarAwareElementType AssignmentValue_ValueSTRINGTerminalRuleCall_0_0_ELEMENT_TYPE = associate(AssignmentValueFactory.createAssignmentValue_ValueSTRINGTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType AssignmentValue_Group_1_ELEMENT_TYPE = associate(AssignmentValueFactory.createAssignmentValue_Group_1ElementType());

	public static final IGrammarAwareElementType AssignmentValue_RefObjectAssignment_1_0_ELEMENT_TYPE = associate(AssignmentValueFactory.createAssignmentValue_RefObjectAssignment_1_0ElementType());

	public static final IGrammarAwareElementType AssignmentValue_RefObjectNamedObjectCrossReference_1_0_0_ELEMENT_TYPE = associate(AssignmentValueFactory.createAssignmentValue_RefObjectNamedObjectCrossReference_1_0_0ElementType());

	public static final IGrammarAwareElementType AssignmentValue_RefObjectNamedObjectIDTerminalRuleCall_1_0_0_1_ELEMENT_TYPE = associate(AssignmentValueFactory.createAssignmentValue_RefObjectNamedObjectIDTerminalRuleCall_1_0_0_1ElementType());

	public static final IGrammarAwareElementType AssignmentValue_Group_1_1_ELEMENT_TYPE = associate(AssignmentValueFactory.createAssignmentValue_Group_1_1ElementType());

	public static final IGrammarAwareElementType AssignmentValue_FullStopKeyword_1_1_0_ELEMENT_TYPE = associate(AssignmentValueFactory.createAssignmentValue_FullStopKeyword_1_1_0ElementType());

	public static final IGrammarAwareElementType AssignmentValue_RefFeatureAssignment_1_1_1_ELEMENT_TYPE = associate(AssignmentValueFactory.createAssignmentValue_RefFeatureAssignment_1_1_1ElementType());

	public static final IGrammarAwareElementType AssignmentValue_RefFeatureIDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE = associate(AssignmentValueFactory.createAssignmentValue_RefFeatureIDTerminalRuleCall_1_1_1_0ElementType());

	public static final IGrammarAwareElementType AssignmentValue_Group_1_1_2_ELEMENT_TYPE = associate(AssignmentValueFactory.createAssignmentValue_Group_1_1_2ElementType());

	public static final IGrammarAwareElementType AssignmentValue_LeftSquareBracketKeyword_1_1_2_0_ELEMENT_TYPE = associate(AssignmentValueFactory.createAssignmentValue_LeftSquareBracketKeyword_1_1_2_0ElementType());

	public static final IGrammarAwareElementType AssignmentValue_RefIndexAssignment_1_1_2_1_ELEMENT_TYPE = associate(AssignmentValueFactory.createAssignmentValue_RefIndexAssignment_1_1_2_1ElementType());

	public static final IGrammarAwareElementType AssignmentValue_RefIndexINTTerminalRuleCall_1_1_2_1_0_ELEMENT_TYPE = associate(AssignmentValueFactory.createAssignmentValue_RefIndexINTTerminalRuleCall_1_1_2_1_0ElementType());

	public static final IGrammarAwareElementType AssignmentValue_RightSquareBracketKeyword_1_1_2_2_ELEMENT_TYPE = associate(AssignmentValueFactory.createAssignmentValue_RightSquareBracketKeyword_1_1_2_2ElementType());

	public static final IGrammarAwareElementType AssignmentValue_NewObjectAssignment_2_ELEMENT_TYPE = associate(AssignmentValueFactory.createAssignmentValue_NewObjectAssignment_2ElementType());

	public static final IGrammarAwareElementType AssignmentValue_NewObjectCreatedObjectParserRuleCall_2_0_ELEMENT_TYPE = associate(AssignmentValueFactory.createAssignmentValue_NewObjectCreatedObjectParserRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType AssignmentValue_Group_3_ELEMENT_TYPE = associate(AssignmentValueFactory.createAssignmentValue_Group_3ElementType());

	public static final IGrammarAwareElementType AssignmentValue_ImportAssignment_3_0_ELEMENT_TYPE = associate(AssignmentValueFactory.createAssignmentValue_ImportAssignment_3_0ElementType());

	public static final IGrammarAwareElementType AssignmentValue_ImportImportCrossReference_3_0_0_ELEMENT_TYPE = associate(AssignmentValueFactory.createAssignmentValue_ImportImportCrossReference_3_0_0ElementType());

	public static final IGrammarAwareElementType AssignmentValue_ImportImportIDTerminalRuleCall_3_0_0_1_ELEMENT_TYPE = associate(AssignmentValueFactory.createAssignmentValue_ImportImportIDTerminalRuleCall_3_0_0_1ElementType());

	public static final IGrammarAwareElementType AssignmentValue_ImpFragAssignment_3_1_ELEMENT_TYPE = associate(AssignmentValueFactory.createAssignmentValue_ImpFragAssignment_3_1ElementType());

	public static final IGrammarAwareElementType AssignmentValue_ImpFragFRAGMENTTerminalRuleCall_3_1_0_ELEMENT_TYPE = associate(AssignmentValueFactory.createAssignmentValue_ImpFragFRAGMENTTerminalRuleCall_3_1_0ElementType());

	private static class ListAssignmentValueFactory {
		public static IGrammarAwareElementType createListAssignmentValueElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueRule());
		}
		public static IGrammarAwareElementType createListAssignmentValue_GroupElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_Group_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getGroup());
		}
		public static IGrammarAwareElementType createListAssignmentValue_IndexAssignment_0ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_IndexAssignment_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getIndexAssignment_0());
		}
		public static IGrammarAwareElementType createListAssignmentValue_IndexINTTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_IndexINTTerminalRuleCall_0_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getIndexINTTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createListAssignmentValue_ColonKeyword_1ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_ColonKeyword_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getColonKeyword_1());
		}
		public static IGrammarAwareElementType createListAssignmentValue_Alternatives_2ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_Alternatives_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getAlternatives_2());
		}
		public static IGrammarAwareElementType createListAssignmentValue_Group_2_0ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_Group_2_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getGroup_2_0());
		}
		public static IGrammarAwareElementType createListAssignmentValue_LeftSquareBracketKeyword_2_0_0ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_LeftSquareBracketKeyword_2_0_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getLeftSquareBracketKeyword_2_0_0());
		}
		public static IGrammarAwareElementType createListAssignmentValue_RefIndexAssignment_2_0_1ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_RefIndexAssignment_2_0_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getRefIndexAssignment_2_0_1());
		}
		public static IGrammarAwareElementType createListAssignmentValue_RefIndexINTTerminalRuleCall_2_0_1_0ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_RefIndexINTTerminalRuleCall_2_0_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getRefIndexINTTerminalRuleCall_2_0_1_0());
		}
		public static IGrammarAwareElementType createListAssignmentValue_RightSquareBracketKeyword_2_0_2ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_RightSquareBracketKeyword_2_0_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getRightSquareBracketKeyword_2_0_2());
		}
		public static IGrammarAwareElementType createListAssignmentValue_ValueAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_ValueAssignment_2_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getValueAssignment_2_1());
		}
		public static IGrammarAwareElementType createListAssignmentValue_ValueSTRINGTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_ValueSTRINGTerminalRuleCall_2_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getValueSTRINGTerminalRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createListAssignmentValue_Group_2_2ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_Group_2_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getGroup_2_2());
		}
		public static IGrammarAwareElementType createListAssignmentValue_RefObjectAssignment_2_2_0ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_RefObjectAssignment_2_2_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getRefObjectAssignment_2_2_0());
		}
		public static IGrammarAwareElementType createListAssignmentValue_RefObjectNamedObjectCrossReference_2_2_0_0ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_RefObjectNamedObjectCrossReference_2_2_0_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getRefObjectNamedObjectCrossReference_2_2_0_0());
		}
		public static IGrammarAwareElementType createListAssignmentValue_RefObjectNamedObjectIDTerminalRuleCall_2_2_0_0_1ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_RefObjectNamedObjectIDTerminalRuleCall_2_2_0_0_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getRefObjectNamedObjectIDTerminalRuleCall_2_2_0_0_1());
		}
		public static IGrammarAwareElementType createListAssignmentValue_Group_2_2_1ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_Group_2_2_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getGroup_2_2_1());
		}
		public static IGrammarAwareElementType createListAssignmentValue_FullStopKeyword_2_2_1_0ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_FullStopKeyword_2_2_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getFullStopKeyword_2_2_1_0());
		}
		public static IGrammarAwareElementType createListAssignmentValue_RefFeatureAssignment_2_2_1_1ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_RefFeatureAssignment_2_2_1_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getRefFeatureAssignment_2_2_1_1());
		}
		public static IGrammarAwareElementType createListAssignmentValue_RefFeatureIDTerminalRuleCall_2_2_1_1_0ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_RefFeatureIDTerminalRuleCall_2_2_1_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getRefFeatureIDTerminalRuleCall_2_2_1_1_0());
		}
		public static IGrammarAwareElementType createListAssignmentValue_Group_2_2_1_2ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_Group_2_2_1_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getGroup_2_2_1_2());
		}
		public static IGrammarAwareElementType createListAssignmentValue_LeftSquareBracketKeyword_2_2_1_2_0ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_LeftSquareBracketKeyword_2_2_1_2_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getLeftSquareBracketKeyword_2_2_1_2_0());
		}
		public static IGrammarAwareElementType createListAssignmentValue_RefIndexAssignment_2_2_1_2_1ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_RefIndexAssignment_2_2_1_2_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getRefIndexAssignment_2_2_1_2_1());
		}
		public static IGrammarAwareElementType createListAssignmentValue_RefIndexINTTerminalRuleCall_2_2_1_2_1_0ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_RefIndexINTTerminalRuleCall_2_2_1_2_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getRefIndexINTTerminalRuleCall_2_2_1_2_1_0());
		}
		public static IGrammarAwareElementType createListAssignmentValue_RightSquareBracketKeyword_2_2_1_2_2ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_RightSquareBracketKeyword_2_2_1_2_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getRightSquareBracketKeyword_2_2_1_2_2());
		}
		public static IGrammarAwareElementType createListAssignmentValue_NewObjectAssignment_2_3ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_NewObjectAssignment_2_3_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getNewObjectAssignment_2_3());
		}
		public static IGrammarAwareElementType createListAssignmentValue_NewObjectCreatedObjectParserRuleCall_2_3_0ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_NewObjectCreatedObjectParserRuleCall_2_3_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getNewObjectCreatedObjectParserRuleCall_2_3_0());
		}
		public static IGrammarAwareElementType createListAssignmentValue_Group_2_4ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_Group_2_4_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getGroup_2_4());
		}
		public static IGrammarAwareElementType createListAssignmentValue_ImportAssignment_2_4_0ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_ImportAssignment_2_4_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getImportAssignment_2_4_0());
		}
		public static IGrammarAwareElementType createListAssignmentValue_ImportImportCrossReference_2_4_0_0ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_ImportImportCrossReference_2_4_0_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getImportImportCrossReference_2_4_0_0());
		}
		public static IGrammarAwareElementType createListAssignmentValue_ImportImportIDTerminalRuleCall_2_4_0_0_1ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_ImportImportIDTerminalRuleCall_2_4_0_0_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getImportImportIDTerminalRuleCall_2_4_0_0_1());
		}
		public static IGrammarAwareElementType createListAssignmentValue_ImpFragAssignment_2_4_1ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_ImpFragAssignment_2_4_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getImpFragAssignment_2_4_1());
		}
		public static IGrammarAwareElementType createListAssignmentValue_ImpFragFRAGMENTTerminalRuleCall_2_4_1_0ElementType() {
			return new IGrammarAwareElementType("ListAssignmentValue_ImpFragFRAGMENTTerminalRuleCall_2_4_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getListAssignmentValueAccess().getImpFragFRAGMENTTerminalRuleCall_2_4_1_0());
		}
	}

	public static final IGrammarAwareElementType ListAssignmentValue_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValueElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_Group_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_GroupElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_IndexAssignment_0_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_IndexAssignment_0ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_IndexINTTerminalRuleCall_0_0_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_IndexINTTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_ColonKeyword_1_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_ColonKeyword_1ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_Alternatives_2_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_Alternatives_2ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_Group_2_0_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_Group_2_0ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_LeftSquareBracketKeyword_2_0_0_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_LeftSquareBracketKeyword_2_0_0ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_RefIndexAssignment_2_0_1_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_RefIndexAssignment_2_0_1ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_RefIndexINTTerminalRuleCall_2_0_1_0_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_RefIndexINTTerminalRuleCall_2_0_1_0ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_RightSquareBracketKeyword_2_0_2_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_RightSquareBracketKeyword_2_0_2ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_ValueAssignment_2_1_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_ValueAssignment_2_1ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_ValueSTRINGTerminalRuleCall_2_1_0_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_ValueSTRINGTerminalRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_Group_2_2_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_Group_2_2ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_RefObjectAssignment_2_2_0_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_RefObjectAssignment_2_2_0ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_RefObjectNamedObjectCrossReference_2_2_0_0_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_RefObjectNamedObjectCrossReference_2_2_0_0ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_RefObjectNamedObjectIDTerminalRuleCall_2_2_0_0_1_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_RefObjectNamedObjectIDTerminalRuleCall_2_2_0_0_1ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_Group_2_2_1_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_Group_2_2_1ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_FullStopKeyword_2_2_1_0_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_FullStopKeyword_2_2_1_0ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_RefFeatureAssignment_2_2_1_1_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_RefFeatureAssignment_2_2_1_1ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_RefFeatureIDTerminalRuleCall_2_2_1_1_0_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_RefFeatureIDTerminalRuleCall_2_2_1_1_0ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_Group_2_2_1_2_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_Group_2_2_1_2ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_LeftSquareBracketKeyword_2_2_1_2_0_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_LeftSquareBracketKeyword_2_2_1_2_0ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_RefIndexAssignment_2_2_1_2_1_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_RefIndexAssignment_2_2_1_2_1ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_RefIndexINTTerminalRuleCall_2_2_1_2_1_0_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_RefIndexINTTerminalRuleCall_2_2_1_2_1_0ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_RightSquareBracketKeyword_2_2_1_2_2_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_RightSquareBracketKeyword_2_2_1_2_2ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_NewObjectAssignment_2_3_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_NewObjectAssignment_2_3ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_NewObjectCreatedObjectParserRuleCall_2_3_0_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_NewObjectCreatedObjectParserRuleCall_2_3_0ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_Group_2_4_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_Group_2_4ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_ImportAssignment_2_4_0_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_ImportAssignment_2_4_0ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_ImportImportCrossReference_2_4_0_0_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_ImportImportCrossReference_2_4_0_0ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_ImportImportIDTerminalRuleCall_2_4_0_0_1_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_ImportImportIDTerminalRuleCall_2_4_0_0_1ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_ImpFragAssignment_2_4_1_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_ImpFragAssignment_2_4_1ElementType());

	public static final IGrammarAwareElementType ListAssignmentValue_ImpFragFRAGMENTTerminalRuleCall_2_4_1_0_ELEMENT_TYPE = associate(ListAssignmentValueFactory.createListAssignmentValue_ImpFragFRAGMENTTerminalRuleCall_2_4_1_0ElementType());

	private static class SingleAssignmentValueFactory {
		public static IGrammarAwareElementType createSingleAssignmentValueElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueRule());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_AlternativesElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_Alternatives_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_KeywordAssignment_0ElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_KeywordAssignment_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getKeywordAssignment_0());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_KeywordNullKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_KeywordNullKeyword_0_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getKeywordNullKeyword_0_0());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_ValueAssignment_1ElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_ValueAssignment_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getValueAssignment_1());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_ValueSTRINGTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_ValueSTRINGTerminalRuleCall_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getValueSTRINGTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_Group_2ElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_Group_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_RefObjectAssignment_2_0ElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_RefObjectAssignment_2_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getRefObjectAssignment_2_0());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_RefObjectNamedObjectCrossReference_2_0_0ElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_RefObjectNamedObjectCrossReference_2_0_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getRefObjectNamedObjectCrossReference_2_0_0());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_RefObjectNamedObjectIDTerminalRuleCall_2_0_0_1ElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_RefObjectNamedObjectIDTerminalRuleCall_2_0_0_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getRefObjectNamedObjectIDTerminalRuleCall_2_0_0_1());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_Group_2_1ElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_Group_2_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getGroup_2_1());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_FullStopKeyword_2_1_0ElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_FullStopKeyword_2_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getFullStopKeyword_2_1_0());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_RefFeatureAssignment_2_1_1ElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_RefFeatureAssignment_2_1_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getRefFeatureAssignment_2_1_1());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_RefFeatureIDTerminalRuleCall_2_1_1_0ElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_RefFeatureIDTerminalRuleCall_2_1_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getRefFeatureIDTerminalRuleCall_2_1_1_0());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_Group_2_1_2ElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_Group_2_1_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getGroup_2_1_2());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_LeftSquareBracketKeyword_2_1_2_0ElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_LeftSquareBracketKeyword_2_1_2_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getLeftSquareBracketKeyword_2_1_2_0());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_RefIndexAssignment_2_1_2_1ElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_RefIndexAssignment_2_1_2_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getRefIndexAssignment_2_1_2_1());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_RefIndexINTTerminalRuleCall_2_1_2_1_0ElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_RefIndexINTTerminalRuleCall_2_1_2_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getRefIndexINTTerminalRuleCall_2_1_2_1_0());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_RightSquareBracketKeyword_2_1_2_2ElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_RightSquareBracketKeyword_2_1_2_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getRightSquareBracketKeyword_2_1_2_2());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_NewObjectAssignment_3ElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_NewObjectAssignment_3_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getNewObjectAssignment_3());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_NewObjectCreatedObjectParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_NewObjectCreatedObjectParserRuleCall_3_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getNewObjectCreatedObjectParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_Group_4ElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_Group_4_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getGroup_4());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_ImportAssignment_4_0ElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_ImportAssignment_4_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getImportAssignment_4_0());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_ImportImportCrossReference_4_0_0ElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_ImportImportCrossReference_4_0_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getImportImportCrossReference_4_0_0());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_ImportImportIDTerminalRuleCall_4_0_0_1ElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_ImportImportIDTerminalRuleCall_4_0_0_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getImportImportIDTerminalRuleCall_4_0_0_1());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_ImpFragAssignment_4_1ElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_ImpFragAssignment_4_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getImpFragAssignment_4_1());
		}
		public static IGrammarAwareElementType createSingleAssignmentValue_ImpFragFRAGMENTTerminalRuleCall_4_1_0ElementType() {
			return new IGrammarAwareElementType("SingleAssignmentValue_ImpFragFRAGMENTTerminalRuleCall_4_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSingleAssignmentValueAccess().getImpFragFRAGMENTTerminalRuleCall_4_1_0());
		}
	}

	public static final IGrammarAwareElementType SingleAssignmentValue_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValueElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_Alternatives_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_AlternativesElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_KeywordAssignment_0_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_KeywordAssignment_0ElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_KeywordNullKeyword_0_0_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_KeywordNullKeyword_0_0ElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_ValueAssignment_1_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_ValueAssignment_1ElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_ValueSTRINGTerminalRuleCall_1_0_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_ValueSTRINGTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_Group_2_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_Group_2ElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_RefObjectAssignment_2_0_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_RefObjectAssignment_2_0ElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_RefObjectNamedObjectCrossReference_2_0_0_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_RefObjectNamedObjectCrossReference_2_0_0ElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_RefObjectNamedObjectIDTerminalRuleCall_2_0_0_1_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_RefObjectNamedObjectIDTerminalRuleCall_2_0_0_1ElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_Group_2_1_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_Group_2_1ElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_FullStopKeyword_2_1_0_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_FullStopKeyword_2_1_0ElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_RefFeatureAssignment_2_1_1_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_RefFeatureAssignment_2_1_1ElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_RefFeatureIDTerminalRuleCall_2_1_1_0_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_RefFeatureIDTerminalRuleCall_2_1_1_0ElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_Group_2_1_2_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_Group_2_1_2ElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_LeftSquareBracketKeyword_2_1_2_0_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_LeftSquareBracketKeyword_2_1_2_0ElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_RefIndexAssignment_2_1_2_1_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_RefIndexAssignment_2_1_2_1ElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_RefIndexINTTerminalRuleCall_2_1_2_1_0_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_RefIndexINTTerminalRuleCall_2_1_2_1_0ElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_RightSquareBracketKeyword_2_1_2_2_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_RightSquareBracketKeyword_2_1_2_2ElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_NewObjectAssignment_3_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_NewObjectAssignment_3ElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_NewObjectCreatedObjectParserRuleCall_3_0_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_NewObjectCreatedObjectParserRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_Group_4_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_Group_4ElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_ImportAssignment_4_0_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_ImportAssignment_4_0ElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_ImportImportCrossReference_4_0_0_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_ImportImportCrossReference_4_0_0ElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_ImportImportIDTerminalRuleCall_4_0_0_1_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_ImportImportIDTerminalRuleCall_4_0_0_1ElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_ImpFragAssignment_4_1_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_ImpFragAssignment_4_1ElementType());

	public static final IGrammarAwareElementType SingleAssignmentValue_ImpFragFRAGMENTTerminalRuleCall_4_1_0_ELEMENT_TYPE = associate(SingleAssignmentValueFactory.createSingleAssignmentValue_ImpFragFRAGMENTTerminalRuleCall_4_1_0ElementType());

	private static class CreatedObjectFactory {
		public static IGrammarAwareElementType createCreatedObjectElementType() {
			return new IGrammarAwareElementType("CreatedObject_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCreatedObjectRule());
		}
		public static IGrammarAwareElementType createCreatedObject_GroupElementType() {
			return new IGrammarAwareElementType("CreatedObject_Group_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCreatedObjectAccess().getGroup());
		}
		public static IGrammarAwareElementType createCreatedObject_Alternatives_0ElementType() {
			return new IGrammarAwareElementType("CreatedObject_Alternatives_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCreatedObjectAccess().getAlternatives_0());
		}
		public static IGrammarAwareElementType createCreatedObject_ObjectNewParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("CreatedObject_ObjectNewParserRuleCall_0_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCreatedObjectAccess().getObjectNewParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createCreatedObject_ObjectCopyParserRuleCall_0_1ElementType() {
			return new IGrammarAwareElementType("CreatedObject_ObjectCopyParserRuleCall_0_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCreatedObjectAccess().getObjectCopyParserRuleCall_0_1());
		}
		public static IGrammarAwareElementType createCreatedObject_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("CreatedObject_NameAssignment_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCreatedObjectAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createCreatedObject_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("CreatedObject_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCreatedObjectAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createCreatedObject_Group_2ElementType() {
			return new IGrammarAwareElementType("CreatedObject_Group_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCreatedObjectAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createCreatedObject_LeftCurlyBracketKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("CreatedObject_LeftCurlyBracketKeyword_2_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCreatedObjectAccess().getLeftCurlyBracketKeyword_2_0());
		}
		public static IGrammarAwareElementType createCreatedObject_Alternatives_2_1ElementType() {
			return new IGrammarAwareElementType("CreatedObject_Alternatives_2_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCreatedObjectAccess().getAlternatives_2_1());
		}
		public static IGrammarAwareElementType createCreatedObject_AssignmentsAssignment_2_1_0ElementType() {
			return new IGrammarAwareElementType("CreatedObject_AssignmentsAssignment_2_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCreatedObjectAccess().getAssignmentsAssignment_2_1_0());
		}
		public static IGrammarAwareElementType createCreatedObject_AssignmentsMonoSingleAssignmentParserRuleCall_2_1_0_0ElementType() {
			return new IGrammarAwareElementType("CreatedObject_AssignmentsMonoSingleAssignmentParserRuleCall_2_1_0_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCreatedObjectAccess().getAssignmentsMonoSingleAssignmentParserRuleCall_2_1_0_0());
		}
		public static IGrammarAwareElementType createCreatedObject_AssignmentsAssignment_2_1_1ElementType() {
			return new IGrammarAwareElementType("CreatedObject_AssignmentsAssignment_2_1_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCreatedObjectAccess().getAssignmentsAssignment_2_1_1());
		}
		public static IGrammarAwareElementType createCreatedObject_AssignmentsMonoListAssignmentParserRuleCall_2_1_1_0ElementType() {
			return new IGrammarAwareElementType("CreatedObject_AssignmentsMonoListAssignmentParserRuleCall_2_1_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCreatedObjectAccess().getAssignmentsMonoListAssignmentParserRuleCall_2_1_1_0());
		}
		public static IGrammarAwareElementType createCreatedObject_LeftMigAssignment_2_2ElementType() {
			return new IGrammarAwareElementType("CreatedObject_LeftMigAssignment_2_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCreatedObjectAccess().getLeftMigAssignment_2_2());
		}
		public static IGrammarAwareElementType createCreatedObject_LeftMigMigrationParserRuleCall_2_2_0ElementType() {
			return new IGrammarAwareElementType("CreatedObject_LeftMigMigrationParserRuleCall_2_2_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCreatedObjectAccess().getLeftMigMigrationParserRuleCall_2_2_0());
		}
		public static IGrammarAwareElementType createCreatedObject_RightCurlyBracketKeyword_2_3ElementType() {
			return new IGrammarAwareElementType("CreatedObject_RightCurlyBracketKeyword_2_3_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCreatedObjectAccess().getRightCurlyBracketKeyword_2_3());
		}
	}

	public static final IGrammarAwareElementType CreatedObject_ELEMENT_TYPE = associate(CreatedObjectFactory.createCreatedObjectElementType());

	public static final IGrammarAwareElementType CreatedObject_Group_ELEMENT_TYPE = associate(CreatedObjectFactory.createCreatedObject_GroupElementType());

	public static final IGrammarAwareElementType CreatedObject_Alternatives_0_ELEMENT_TYPE = associate(CreatedObjectFactory.createCreatedObject_Alternatives_0ElementType());

	public static final IGrammarAwareElementType CreatedObject_ObjectNewParserRuleCall_0_0_ELEMENT_TYPE = associate(CreatedObjectFactory.createCreatedObject_ObjectNewParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType CreatedObject_ObjectCopyParserRuleCall_0_1_ELEMENT_TYPE = associate(CreatedObjectFactory.createCreatedObject_ObjectCopyParserRuleCall_0_1ElementType());

	public static final IGrammarAwareElementType CreatedObject_NameAssignment_1_ELEMENT_TYPE = associate(CreatedObjectFactory.createCreatedObject_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType CreatedObject_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(CreatedObjectFactory.createCreatedObject_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType CreatedObject_Group_2_ELEMENT_TYPE = associate(CreatedObjectFactory.createCreatedObject_Group_2ElementType());

	public static final IGrammarAwareElementType CreatedObject_LeftCurlyBracketKeyword_2_0_ELEMENT_TYPE = associate(CreatedObjectFactory.createCreatedObject_LeftCurlyBracketKeyword_2_0ElementType());

	public static final IGrammarAwareElementType CreatedObject_Alternatives_2_1_ELEMENT_TYPE = associate(CreatedObjectFactory.createCreatedObject_Alternatives_2_1ElementType());

	public static final IGrammarAwareElementType CreatedObject_AssignmentsAssignment_2_1_0_ELEMENT_TYPE = associate(CreatedObjectFactory.createCreatedObject_AssignmentsAssignment_2_1_0ElementType());

	public static final IGrammarAwareElementType CreatedObject_AssignmentsMonoSingleAssignmentParserRuleCall_2_1_0_0_ELEMENT_TYPE = associate(CreatedObjectFactory.createCreatedObject_AssignmentsMonoSingleAssignmentParserRuleCall_2_1_0_0ElementType());

	public static final IGrammarAwareElementType CreatedObject_AssignmentsAssignment_2_1_1_ELEMENT_TYPE = associate(CreatedObjectFactory.createCreatedObject_AssignmentsAssignment_2_1_1ElementType());

	public static final IGrammarAwareElementType CreatedObject_AssignmentsMonoListAssignmentParserRuleCall_2_1_1_0_ELEMENT_TYPE = associate(CreatedObjectFactory.createCreatedObject_AssignmentsMonoListAssignmentParserRuleCall_2_1_1_0ElementType());

	public static final IGrammarAwareElementType CreatedObject_LeftMigAssignment_2_2_ELEMENT_TYPE = associate(CreatedObjectFactory.createCreatedObject_LeftMigAssignment_2_2ElementType());

	public static final IGrammarAwareElementType CreatedObject_LeftMigMigrationParserRuleCall_2_2_0_ELEMENT_TYPE = associate(CreatedObjectFactory.createCreatedObject_LeftMigMigrationParserRuleCall_2_2_0ElementType());

	public static final IGrammarAwareElementType CreatedObject_RightCurlyBracketKeyword_2_3_ELEMENT_TYPE = associate(CreatedObjectFactory.createCreatedObject_RightCurlyBracketKeyword_2_3ElementType());

	private static class ObjectNewFactory {
		public static IGrammarAwareElementType createObjectNewElementType() {
			return new IGrammarAwareElementType("ObjectNew_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectNewRule());
		}
		public static IGrammarAwareElementType createObjectNew_GroupElementType() {
			return new IGrammarAwareElementType("ObjectNew_Group_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectNewAccess().getGroup());
		}
		public static IGrammarAwareElementType createObjectNew_NewKeyword_0ElementType() {
			return new IGrammarAwareElementType("ObjectNew_NewKeyword_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectNewAccess().getNewKeyword_0());
		}
		public static IGrammarAwareElementType createObjectNew_ImportAssignment_1ElementType() {
			return new IGrammarAwareElementType("ObjectNew_ImportAssignment_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectNewAccess().getImportAssignment_1());
		}
		public static IGrammarAwareElementType createObjectNew_ImportImportCrossReference_1_0ElementType() {
			return new IGrammarAwareElementType("ObjectNew_ImportImportCrossReference_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectNewAccess().getImportImportCrossReference_1_0());
		}
		public static IGrammarAwareElementType createObjectNew_ImportImportIDTerminalRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("ObjectNew_ImportImportIDTerminalRuleCall_1_0_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectNewAccess().getImportImportIDTerminalRuleCall_1_0_1());
		}
		public static IGrammarAwareElementType createObjectNew_ImpFragAssignment_2ElementType() {
			return new IGrammarAwareElementType("ObjectNew_ImpFragAssignment_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectNewAccess().getImpFragAssignment_2());
		}
		public static IGrammarAwareElementType createObjectNew_ImpFragFRAGMENTTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("ObjectNew_ImpFragFRAGMENTTerminalRuleCall_2_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectNewAccess().getImpFragFRAGMENTTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType ObjectNew_ELEMENT_TYPE = associate(ObjectNewFactory.createObjectNewElementType());

	public static final IGrammarAwareElementType ObjectNew_Group_ELEMENT_TYPE = associate(ObjectNewFactory.createObjectNew_GroupElementType());

	public static final IGrammarAwareElementType ObjectNew_NewKeyword_0_ELEMENT_TYPE = associate(ObjectNewFactory.createObjectNew_NewKeyword_0ElementType());

	public static final IGrammarAwareElementType ObjectNew_ImportAssignment_1_ELEMENT_TYPE = associate(ObjectNewFactory.createObjectNew_ImportAssignment_1ElementType());

	public static final IGrammarAwareElementType ObjectNew_ImportImportCrossReference_1_0_ELEMENT_TYPE = associate(ObjectNewFactory.createObjectNew_ImportImportCrossReference_1_0ElementType());

	public static final IGrammarAwareElementType ObjectNew_ImportImportIDTerminalRuleCall_1_0_1_ELEMENT_TYPE = associate(ObjectNewFactory.createObjectNew_ImportImportIDTerminalRuleCall_1_0_1ElementType());

	public static final IGrammarAwareElementType ObjectNew_ImpFragAssignment_2_ELEMENT_TYPE = associate(ObjectNewFactory.createObjectNew_ImpFragAssignment_2ElementType());

	public static final IGrammarAwareElementType ObjectNew_ImpFragFRAGMENTTerminalRuleCall_2_0_ELEMENT_TYPE = associate(ObjectNewFactory.createObjectNew_ImpFragFRAGMENTTerminalRuleCall_2_0ElementType());

	private static class ObjectCopyFactory {
		public static IGrammarAwareElementType createObjectCopyElementType() {
			return new IGrammarAwareElementType("ObjectCopy_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectCopyRule());
		}
		public static IGrammarAwareElementType createObjectCopy_GroupElementType() {
			return new IGrammarAwareElementType("ObjectCopy_Group_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectCopyAccess().getGroup());
		}
		public static IGrammarAwareElementType createObjectCopy_CopyKeyword_0ElementType() {
			return new IGrammarAwareElementType("ObjectCopy_CopyKeyword_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectCopyAccess().getCopyKeyword_0());
		}
		public static IGrammarAwareElementType createObjectCopy_ResourceAssignment_1ElementType() {
			return new IGrammarAwareElementType("ObjectCopy_ResourceAssignment_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectCopyAccess().getResourceAssignment_1());
		}
		public static IGrammarAwareElementType createObjectCopy_ResourceNamedResourceCrossReference_1_0ElementType() {
			return new IGrammarAwareElementType("ObjectCopy_ResourceNamedResourceCrossReference_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectCopyAccess().getResourceNamedResourceCrossReference_1_0());
		}
		public static IGrammarAwareElementType createObjectCopy_ResourceNamedResourceIDTerminalRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("ObjectCopy_ResourceNamedResourceIDTerminalRuleCall_1_0_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectCopyAccess().getResourceNamedResourceIDTerminalRuleCall_1_0_1());
		}
		public static IGrammarAwareElementType createObjectCopy_FragmentAssignment_2ElementType() {
			return new IGrammarAwareElementType("ObjectCopy_FragmentAssignment_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectCopyAccess().getFragmentAssignment_2());
		}
		public static IGrammarAwareElementType createObjectCopy_FragmentFRAGMENTTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("ObjectCopy_FragmentFRAGMENTTerminalRuleCall_2_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getObjectCopyAccess().getFragmentFRAGMENTTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType ObjectCopy_ELEMENT_TYPE = associate(ObjectCopyFactory.createObjectCopyElementType());

	public static final IGrammarAwareElementType ObjectCopy_Group_ELEMENT_TYPE = associate(ObjectCopyFactory.createObjectCopy_GroupElementType());

	public static final IGrammarAwareElementType ObjectCopy_CopyKeyword_0_ELEMENT_TYPE = associate(ObjectCopyFactory.createObjectCopy_CopyKeyword_0ElementType());

	public static final IGrammarAwareElementType ObjectCopy_ResourceAssignment_1_ELEMENT_TYPE = associate(ObjectCopyFactory.createObjectCopy_ResourceAssignment_1ElementType());

	public static final IGrammarAwareElementType ObjectCopy_ResourceNamedResourceCrossReference_1_0_ELEMENT_TYPE = associate(ObjectCopyFactory.createObjectCopy_ResourceNamedResourceCrossReference_1_0ElementType());

	public static final IGrammarAwareElementType ObjectCopy_ResourceNamedResourceIDTerminalRuleCall_1_0_1_ELEMENT_TYPE = associate(ObjectCopyFactory.createObjectCopy_ResourceNamedResourceIDTerminalRuleCall_1_0_1ElementType());

	public static final IGrammarAwareElementType ObjectCopy_FragmentAssignment_2_ELEMENT_TYPE = associate(ObjectCopyFactory.createObjectCopy_FragmentAssignment_2ElementType());

	public static final IGrammarAwareElementType ObjectCopy_FragmentFRAGMENTTerminalRuleCall_2_0_ELEMENT_TYPE = associate(ObjectCopyFactory.createObjectCopy_FragmentFRAGMENTTerminalRuleCall_2_0ElementType());

	private static class MigrationFactory {
		public static IGrammarAwareElementType createMigrationElementType() {
			return new IGrammarAwareElementType("Migration_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMigrationRule());
		}
		public static IGrammarAwareElementType createMigration_GroupElementType() {
			return new IGrammarAwareElementType("Migration_Group_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMigrationAccess().getGroup());
		}
		public static IGrammarAwareElementType createMigration_MigrationAction_0ElementType() {
			return new IGrammarAwareElementType("Migration_MigrationAction_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMigrationAccess().getMigrationAction_0());
		}
		public static IGrammarAwareElementType createMigration_MigrateKeyword_1ElementType() {
			return new IGrammarAwareElementType("Migration_MigrateKeyword_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMigrationAccess().getMigrateKeyword_1());
		}
		public static IGrammarAwareElementType createMigration_FirstAssignment_2ElementType() {
			return new IGrammarAwareElementType("Migration_FirstAssignment_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMigrationAccess().getFirstAssignment_2());
		}
		public static IGrammarAwareElementType createMigration_FirstExecutableParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Migration_FirstExecutableParserRuleCall_2_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMigrationAccess().getFirstExecutableParserRuleCall_2_0());
		}
		public static IGrammarAwareElementType createMigration_Alternatives_3ElementType() {
			return new IGrammarAwareElementType("Migration_Alternatives_3_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMigrationAccess().getAlternatives_3());
		}
		public static IGrammarAwareElementType createMigration_Group_3_0ElementType() {
			return new IGrammarAwareElementType("Migration_Group_3_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMigrationAccess().getGroup_3_0());
		}
		public static IGrammarAwareElementType createMigration_AsKeyword_3_0_0ElementType() {
			return new IGrammarAwareElementType("Migration_AsKeyword_3_0_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMigrationAccess().getAsKeyword_3_0_0());
		}
		public static IGrammarAwareElementType createMigration_AsOpAssignment_3_0_1ElementType() {
			return new IGrammarAwareElementType("Migration_AsOpAssignment_3_0_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMigrationAccess().getAsOpAssignment_3_0_1());
		}
		public static IGrammarAwareElementType createMigration_AsOpExecutableParserRuleCall_3_0_1_0ElementType() {
			return new IGrammarAwareElementType("Migration_AsOpExecutableParserRuleCall_3_0_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMigrationAccess().getAsOpExecutableParserRuleCall_3_0_1_0());
		}
		public static IGrammarAwareElementType createMigration_Group_3_1ElementType() {
			return new IGrammarAwareElementType("Migration_Group_3_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMigrationAccess().getGroup_3_1());
		}
		public static IGrammarAwareElementType createMigration_EachKeyword_3_1_0ElementType() {
			return new IGrammarAwareElementType("Migration_EachKeyword_3_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMigrationAccess().getEachKeyword_3_1_0());
		}
		public static IGrammarAwareElementType createMigration_EachOpAssignment_3_1_1ElementType() {
			return new IGrammarAwareElementType("Migration_EachOpAssignment_3_1_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMigrationAccess().getEachOpAssignment_3_1_1());
		}
		public static IGrammarAwareElementType createMigration_EachOpExecutableParserRuleCall_3_1_1_0ElementType() {
			return new IGrammarAwareElementType("Migration_EachOpExecutableParserRuleCall_3_1_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMigrationAccess().getEachOpExecutableParserRuleCall_3_1_1_0());
		}
		public static IGrammarAwareElementType createMigration_SemicolonKeyword_4ElementType() {
			return new IGrammarAwareElementType("Migration_SemicolonKeyword_4_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMigrationAccess().getSemicolonKeyword_4());
		}
	}

	public static final IGrammarAwareElementType Migration_ELEMENT_TYPE = associate(MigrationFactory.createMigrationElementType());

	public static final IGrammarAwareElementType Migration_Group_ELEMENT_TYPE = associate(MigrationFactory.createMigration_GroupElementType());

	public static final IGrammarAwareElementType Migration_MigrationAction_0_ELEMENT_TYPE = associate(MigrationFactory.createMigration_MigrationAction_0ElementType());

	public static final IGrammarAwareElementType Migration_MigrateKeyword_1_ELEMENT_TYPE = associate(MigrationFactory.createMigration_MigrateKeyword_1ElementType());

	public static final IGrammarAwareElementType Migration_FirstAssignment_2_ELEMENT_TYPE = associate(MigrationFactory.createMigration_FirstAssignment_2ElementType());

	public static final IGrammarAwareElementType Migration_FirstExecutableParserRuleCall_2_0_ELEMENT_TYPE = associate(MigrationFactory.createMigration_FirstExecutableParserRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType Migration_Alternatives_3_ELEMENT_TYPE = associate(MigrationFactory.createMigration_Alternatives_3ElementType());

	public static final IGrammarAwareElementType Migration_Group_3_0_ELEMENT_TYPE = associate(MigrationFactory.createMigration_Group_3_0ElementType());

	public static final IGrammarAwareElementType Migration_AsKeyword_3_0_0_ELEMENT_TYPE = associate(MigrationFactory.createMigration_AsKeyword_3_0_0ElementType());

	public static final IGrammarAwareElementType Migration_AsOpAssignment_3_0_1_ELEMENT_TYPE = associate(MigrationFactory.createMigration_AsOpAssignment_3_0_1ElementType());

	public static final IGrammarAwareElementType Migration_AsOpExecutableParserRuleCall_3_0_1_0_ELEMENT_TYPE = associate(MigrationFactory.createMigration_AsOpExecutableParserRuleCall_3_0_1_0ElementType());

	public static final IGrammarAwareElementType Migration_Group_3_1_ELEMENT_TYPE = associate(MigrationFactory.createMigration_Group_3_1ElementType());

	public static final IGrammarAwareElementType Migration_EachKeyword_3_1_0_ELEMENT_TYPE = associate(MigrationFactory.createMigration_EachKeyword_3_1_0ElementType());

	public static final IGrammarAwareElementType Migration_EachOpAssignment_3_1_1_ELEMENT_TYPE = associate(MigrationFactory.createMigration_EachOpAssignment_3_1_1ElementType());

	public static final IGrammarAwareElementType Migration_EachOpExecutableParserRuleCall_3_1_1_0_ELEMENT_TYPE = associate(MigrationFactory.createMigration_EachOpExecutableParserRuleCall_3_1_1_0ElementType());

	public static final IGrammarAwareElementType Migration_SemicolonKeyword_4_ELEMENT_TYPE = associate(MigrationFactory.createMigration_SemicolonKeyword_4ElementType());

	private static class ExecutableFactory {
		public static IGrammarAwareElementType createExecutableElementType() {
			return new IGrammarAwareElementType("Executable_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExecutableRule());
		}
		public static IGrammarAwareElementType createExecutable_AlternativesElementType() {
			return new IGrammarAwareElementType("Executable_Alternatives_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExecutableAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createExecutable_JavaExecutableParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Executable_JavaExecutableParserRuleCall_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExecutableAccess().getJavaExecutableParserRuleCall_0());
		}
		public static IGrammarAwareElementType createExecutable_ExpressionExecutableParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Executable_ExpressionExecutableParserRuleCall_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExecutableAccess().getExpressionExecutableParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType Executable_ELEMENT_TYPE = associate(ExecutableFactory.createExecutableElementType());

	public static final IGrammarAwareElementType Executable_Alternatives_ELEMENT_TYPE = associate(ExecutableFactory.createExecutable_AlternativesElementType());

	public static final IGrammarAwareElementType Executable_JavaExecutableParserRuleCall_0_ELEMENT_TYPE = associate(ExecutableFactory.createExecutable_JavaExecutableParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Executable_ExpressionExecutableParserRuleCall_1_ELEMENT_TYPE = associate(ExecutableFactory.createExecutable_ExpressionExecutableParserRuleCall_1ElementType());

	private static class JavaExecutableFactory {
		public static IGrammarAwareElementType createJavaExecutableElementType() {
			return new IGrammarAwareElementType("JavaExecutable_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getJavaExecutableRule());
		}
		public static IGrammarAwareElementType createJavaExecutable_GroupElementType() {
			return new IGrammarAwareElementType("JavaExecutable_Group_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getJavaExecutableAccess().getGroup());
		}
		public static IGrammarAwareElementType createJavaExecutable_JavaKeyword_0ElementType() {
			return new IGrammarAwareElementType("JavaExecutable_JavaKeyword_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getJavaExecutableAccess().getJavaKeyword_0());
		}
		public static IGrammarAwareElementType createJavaExecutable_MethodAssignment_1ElementType() {
			return new IGrammarAwareElementType("JavaExecutable_MethodAssignment_1_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getJavaExecutableAccess().getMethodAssignment_1());
		}
		public static IGrammarAwareElementType createJavaExecutable_MethodIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("JavaExecutable_MethodIDTerminalRuleCall_1_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getJavaExecutableAccess().getMethodIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createJavaExecutable_LeftParenthesisKeyword_2ElementType() {
			return new IGrammarAwareElementType("JavaExecutable_LeftParenthesisKeyword_2_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getJavaExecutableAccess().getLeftParenthesisKeyword_2());
		}
		public static IGrammarAwareElementType createJavaExecutable_RightParenthesisKeyword_3ElementType() {
			return new IGrammarAwareElementType("JavaExecutable_RightParenthesisKeyword_3_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getJavaExecutableAccess().getRightParenthesisKeyword_3());
		}
	}

	public static final IGrammarAwareElementType JavaExecutable_ELEMENT_TYPE = associate(JavaExecutableFactory.createJavaExecutableElementType());

	public static final IGrammarAwareElementType JavaExecutable_Group_ELEMENT_TYPE = associate(JavaExecutableFactory.createJavaExecutable_GroupElementType());

	public static final IGrammarAwareElementType JavaExecutable_JavaKeyword_0_ELEMENT_TYPE = associate(JavaExecutableFactory.createJavaExecutable_JavaKeyword_0ElementType());

	public static final IGrammarAwareElementType JavaExecutable_MethodAssignment_1_ELEMENT_TYPE = associate(JavaExecutableFactory.createJavaExecutable_MethodAssignment_1ElementType());

	public static final IGrammarAwareElementType JavaExecutable_MethodIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(JavaExecutableFactory.createJavaExecutable_MethodIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType JavaExecutable_LeftParenthesisKeyword_2_ELEMENT_TYPE = associate(JavaExecutableFactory.createJavaExecutable_LeftParenthesisKeyword_2ElementType());

	public static final IGrammarAwareElementType JavaExecutable_RightParenthesisKeyword_3_ELEMENT_TYPE = associate(JavaExecutableFactory.createJavaExecutable_RightParenthesisKeyword_3ElementType());

	private static class ExpressionExecutableFactory {
		public static IGrammarAwareElementType createExpressionExecutableElementType() {
			return new IGrammarAwareElementType("ExpressionExecutable_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionExecutableRule());
		}
		public static IGrammarAwareElementType createExpressionExecutable_ExprstrAssignmentElementType() {
			return new IGrammarAwareElementType("ExpressionExecutable_ExprstrAssignment_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionExecutableAccess().getExprstrAssignment());
		}
		public static IGrammarAwareElementType createExpressionExecutable_ExprstrSTRINGTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("ExpressionExecutable_ExprstrSTRINGTerminalRuleCall_0_ELEMENT_TYPE", EpatchTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionExecutableAccess().getExprstrSTRINGTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType ExpressionExecutable_ELEMENT_TYPE = associate(ExpressionExecutableFactory.createExpressionExecutableElementType());

	public static final IGrammarAwareElementType ExpressionExecutable_ExprstrAssignment_ELEMENT_TYPE = associate(ExpressionExecutableFactory.createExpressionExecutable_ExprstrAssignmentElementType());

	public static final IGrammarAwareElementType ExpressionExecutable_ExprstrSTRINGTerminalRuleCall_0_ELEMENT_TYPE = associate(ExpressionExecutableFactory.createExpressionExecutable_ExprstrSTRINGTerminalRuleCall_0ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getEPatchElementType() {
		return EPatch_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEPatch_GroupElementType() {
		return EPatch_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEPatch_EpatchKeyword_0ElementType() {
		return EPatch_EpatchKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEPatch_NameAssignment_1ElementType() {
		return EPatch_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEPatch_NameIDTerminalRuleCall_1_0ElementType() {
		return EPatch_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEPatch_LeftCurlyBracketKeyword_2ElementType() {
		return EPatch_LeftCurlyBracketKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEPatch_ImportsAssignment_3ElementType() {
		return EPatch_ImportsAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEPatch_ImportsImportParserRuleCall_3_0ElementType() {
		return EPatch_ImportsImportParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEPatch_ResourcesAssignment_4ElementType() {
		return EPatch_ResourcesAssignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEPatch_ResourcesNamedResourceParserRuleCall_4_0ElementType() {
		return EPatch_ResourcesNamedResourceParserRuleCall_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEPatch_ObjectsAssignment_5ElementType() {
		return EPatch_ObjectsAssignment_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEPatch_ObjectsObjectRefParserRuleCall_5_0ElementType() {
		return EPatch_ObjectsObjectRefParserRuleCall_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEPatch_RightCurlyBracketKeyword_6ElementType() {
		return EPatch_RightCurlyBracketKeyword_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getImportElementType() {
		return Import_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getImport_AlternativesElementType() {
		return Import_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getImport_ModelImportParserRuleCall_0ElementType() {
		return Import_ModelImportParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getImport_JavaImportParserRuleCall_1ElementType() {
		return Import_JavaImportParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getImport_ExtensionImportParserRuleCall_2ElementType() {
		return Import_ExtensionImportParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelImportElementType() {
		return ModelImport_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelImport_AlternativesElementType() {
		return ModelImport_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelImport_ResourceImportParserRuleCall_0ElementType() {
		return ModelImport_ResourceImportParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelImport_EPackageImportParserRuleCall_1ElementType() {
		return ModelImport_EPackageImportParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getResourceImportElementType() {
		return ResourceImport_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getResourceImport_GroupElementType() {
		return ResourceImport_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getResourceImport_ImportKeyword_0ElementType() {
		return ResourceImport_ImportKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getResourceImport_NameAssignment_1ElementType() {
		return ResourceImport_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getResourceImport_NameIDTerminalRuleCall_1_0ElementType() {
		return ResourceImport_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getResourceImport_UriKeyword_2ElementType() {
		return ResourceImport_UriKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getResourceImport_UriAssignment_3ElementType() {
		return ResourceImport_UriAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getResourceImport_UriSTRINGTerminalRuleCall_3_0ElementType() {
		return ResourceImport_UriSTRINGTerminalRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEPackageImportElementType() {
		return EPackageImport_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEPackageImport_GroupElementType() {
		return EPackageImport_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEPackageImport_ImportKeyword_0ElementType() {
		return EPackageImport_ImportKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEPackageImport_NameAssignment_1ElementType() {
		return EPackageImport_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEPackageImport_NameIDTerminalRuleCall_1_0ElementType() {
		return EPackageImport_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEPackageImport_NsKeyword_2ElementType() {
		return EPackageImport_NsKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEPackageImport_NsURIAssignment_3ElementType() {
		return EPackageImport_NsURIAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEPackageImport_NsURISTRINGTerminalRuleCall_3_0ElementType() {
		return EPackageImport_NsURISTRINGTerminalRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getJavaImportElementType() {
		return JavaImport_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getJavaImport_GroupElementType() {
		return JavaImport_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getJavaImport_ImportKeyword_0ElementType() {
		return JavaImport_ImportKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getJavaImport_JavaKeyword_1ElementType() {
		return JavaImport_JavaKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getJavaImport_PathAssignment_2ElementType() {
		return JavaImport_PathAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getJavaImport_PathIDTerminalRuleCall_2_0ElementType() {
		return JavaImport_PathIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getJavaImport_Group_3ElementType() {
		return JavaImport_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getJavaImport_FullStopKeyword_3_0ElementType() {
		return JavaImport_FullStopKeyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getJavaImport_PathAssignment_3_1ElementType() {
		return JavaImport_PathAssignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getJavaImport_PathIDTerminalRuleCall_3_1_0ElementType() {
		return JavaImport_PathIDTerminalRuleCall_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExtensionImportElementType() {
		return ExtensionImport_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExtensionImport_GroupElementType() {
		return ExtensionImport_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExtensionImport_ImportKeyword_0ElementType() {
		return ExtensionImport_ImportKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExtensionImport_ExtensionKeyword_1ElementType() {
		return ExtensionImport_ExtensionKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExtensionImport_PathAssignment_2ElementType() {
		return ExtensionImport_PathAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExtensionImport_PathIDTerminalRuleCall_2_0ElementType() {
		return ExtensionImport_PathIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExtensionImport_Group_3ElementType() {
		return ExtensionImport_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExtensionImport_ColonColonKeyword_3_0ElementType() {
		return ExtensionImport_ColonColonKeyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExtensionImport_PathAssignment_3_1ElementType() {
		return ExtensionImport_PathAssignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExtensionImport_PathIDTerminalRuleCall_3_1_0ElementType() {
		return ExtensionImport_PathIDTerminalRuleCall_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedResourceElementType() {
		return NamedResource_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedResource_GroupElementType() {
		return NamedResource_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedResource_ResourceKeyword_0ElementType() {
		return NamedResource_ResourceKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedResource_NameAssignment_1ElementType() {
		return NamedResource_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedResource_NameIDTerminalRuleCall_1_0ElementType() {
		return NamedResource_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedResource_LeftCurlyBracketKeyword_2ElementType() {
		return NamedResource_LeftCurlyBracketKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedResource_LeftKeyword_3ElementType() {
		return NamedResource_LeftKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedResource_Alternatives_4ElementType() {
		return NamedResource_Alternatives_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedResource_Group_4_0ElementType() {
		return NamedResource_Group_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedResource_UriKeyword_4_0_0ElementType() {
		return NamedResource_UriKeyword_4_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedResource_LeftUriAssignment_4_0_1ElementType() {
		return NamedResource_LeftUriAssignment_4_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedResource_LeftUriSTRINGTerminalRuleCall_4_0_1_0ElementType() {
		return NamedResource_LeftUriSTRINGTerminalRuleCall_4_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedResource_LeftRootAssignment_4_1ElementType() {
		return NamedResource_LeftRootAssignment_4_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedResource_LeftRootCreatedObjectParserRuleCall_4_1_0ElementType() {
		return NamedResource_LeftRootCreatedObjectParserRuleCall_4_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedResource_SemicolonKeyword_5ElementType() {
		return NamedResource_SemicolonKeyword_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedResource_RightKeyword_6ElementType() {
		return NamedResource_RightKeyword_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedResource_Alternatives_7ElementType() {
		return NamedResource_Alternatives_7_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedResource_Group_7_0ElementType() {
		return NamedResource_Group_7_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedResource_UriKeyword_7_0_0ElementType() {
		return NamedResource_UriKeyword_7_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedResource_RightUriAssignment_7_0_1ElementType() {
		return NamedResource_RightUriAssignment_7_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedResource_RightUriSTRINGTerminalRuleCall_7_0_1_0ElementType() {
		return NamedResource_RightUriSTRINGTerminalRuleCall_7_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedResource_RightRootAssignment_7_1ElementType() {
		return NamedResource_RightRootAssignment_7_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedResource_RightRootCreatedObjectParserRuleCall_7_1_0ElementType() {
		return NamedResource_RightRootCreatedObjectParserRuleCall_7_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedResource_SemicolonKeyword_8ElementType() {
		return NamedResource_SemicolonKeyword_8_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedResource_RightCurlyBracketKeyword_9ElementType() {
		return NamedResource_RightCurlyBracketKeyword_9_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedObjectElementType() {
		return NamedObject_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedObject_AlternativesElementType() {
		return NamedObject_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedObject_ObjectRefParserRuleCall_0ElementType() {
		return NamedObject_ObjectRefParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedObject_CreatedObjectParserRuleCall_1ElementType() {
		return NamedObject_CreatedObjectParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRefElementType() {
		return ObjectRef_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_GroupElementType() {
		return ObjectRef_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_ObjectKeyword_0ElementType() {
		return ObjectRef_ObjectKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_NameAssignment_1ElementType() {
		return ObjectRef_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_NameIDTerminalRuleCall_1_0ElementType() {
		return ObjectRef_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_Alternatives_2ElementType() {
		return ObjectRef_Alternatives_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_Group_2_0ElementType() {
		return ObjectRef_Group_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_LeftResAssignment_2_0_0ElementType() {
		return ObjectRef_LeftResAssignment_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_LeftResNamedResourceCrossReference_2_0_0_0ElementType() {
		return ObjectRef_LeftResNamedResourceCrossReference_2_0_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_LeftResNamedResourceIDTerminalRuleCall_2_0_0_0_1ElementType() {
		return ObjectRef_LeftResNamedResourceIDTerminalRuleCall_2_0_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_LeftFragAssignment_2_0_1ElementType() {
		return ObjectRef_LeftFragAssignment_2_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_LeftFragFRAGMENTTerminalRuleCall_2_0_1_0ElementType() {
		return ObjectRef_LeftFragFRAGMENTTerminalRuleCall_2_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_Group_2_1ElementType() {
		return ObjectRef_Group_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_LeftKeyword_2_1_0ElementType() {
		return ObjectRef_LeftKeyword_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_LeftResAssignment_2_1_1ElementType() {
		return ObjectRef_LeftResAssignment_2_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_LeftResNamedResourceCrossReference_2_1_1_0ElementType() {
		return ObjectRef_LeftResNamedResourceCrossReference_2_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_LeftResNamedResourceIDTerminalRuleCall_2_1_1_0_1ElementType() {
		return ObjectRef_LeftResNamedResourceIDTerminalRuleCall_2_1_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_LeftFragAssignment_2_1_2ElementType() {
		return ObjectRef_LeftFragAssignment_2_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_LeftFragFRAGMENTTerminalRuleCall_2_1_2_0ElementType() {
		return ObjectRef_LeftFragFRAGMENTTerminalRuleCall_2_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_RightKeyword_2_1_3ElementType() {
		return ObjectRef_RightKeyword_2_1_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_RightResAssignment_2_1_4ElementType() {
		return ObjectRef_RightResAssignment_2_1_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_RightResNamedResourceCrossReference_2_1_4_0ElementType() {
		return ObjectRef_RightResNamedResourceCrossReference_2_1_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_RightResNamedResourceIDTerminalRuleCall_2_1_4_0_1ElementType() {
		return ObjectRef_RightResNamedResourceIDTerminalRuleCall_2_1_4_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_RightFragAssignment_2_1_5ElementType() {
		return ObjectRef_RightFragAssignment_2_1_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_RightFragFRAGMENTTerminalRuleCall_2_1_5_0ElementType() {
		return ObjectRef_RightFragFRAGMENTTerminalRuleCall_2_1_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_Group_3ElementType() {
		return ObjectRef_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_LeftCurlyBracketKeyword_3_0ElementType() {
		return ObjectRef_LeftCurlyBracketKeyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_Alternatives_3_1ElementType() {
		return ObjectRef_Alternatives_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_AssignmentsAssignment_3_1_0ElementType() {
		return ObjectRef_AssignmentsAssignment_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_AssignmentsBiSingleAssignmentParserRuleCall_3_1_0_0ElementType() {
		return ObjectRef_AssignmentsBiSingleAssignmentParserRuleCall_3_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_AssignmentsAssignment_3_1_1ElementType() {
		return ObjectRef_AssignmentsAssignment_3_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_AssignmentsBiListAssignmentParserRuleCall_3_1_1_0ElementType() {
		return ObjectRef_AssignmentsBiListAssignmentParserRuleCall_3_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_Group_3_2ElementType() {
		return ObjectRef_Group_3_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_LeftKeyword_3_2_0ElementType() {
		return ObjectRef_LeftKeyword_3_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_LeftMigAssignment_3_2_1ElementType() {
		return ObjectRef_LeftMigAssignment_3_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_LeftMigMigrationParserRuleCall_3_2_1_0ElementType() {
		return ObjectRef_LeftMigMigrationParserRuleCall_3_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_Group_3_3ElementType() {
		return ObjectRef_Group_3_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_RightKeyword_3_3_0ElementType() {
		return ObjectRef_RightKeyword_3_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_RightMigAssignment_3_3_1ElementType() {
		return ObjectRef_RightMigAssignment_3_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_RightMigMigrationParserRuleCall_3_3_1_0ElementType() {
		return ObjectRef_RightMigMigrationParserRuleCall_3_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectRef_RightCurlyBracketKeyword_3_4ElementType() {
		return ObjectRef_RightCurlyBracketKeyword_3_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentElementType() {
		return Assignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_AlternativesElementType() {
		return Assignment_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_BiSingleAssignmentParserRuleCall_0ElementType() {
		return Assignment_BiSingleAssignmentParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_BiListAssignmentParserRuleCall_1ElementType() {
		return Assignment_BiListAssignmentParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_MonoSingleAssignmentParserRuleCall_2ElementType() {
		return Assignment_MonoSingleAssignmentParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignment_MonoListAssignmentParserRuleCall_3ElementType() {
		return Assignment_MonoListAssignmentParserRuleCall_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiSingleAssignmentElementType() {
		return BiSingleAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiSingleAssignment_GroupElementType() {
		return BiSingleAssignment_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiSingleAssignment_FeatureAssignment_0ElementType() {
		return BiSingleAssignment_FeatureAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiSingleAssignment_FeatureIDTerminalRuleCall_0_0ElementType() {
		return BiSingleAssignment_FeatureIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiSingleAssignment_EqualsSignKeyword_1ElementType() {
		return BiSingleAssignment_EqualsSignKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiSingleAssignment_LeftValueAssignment_2ElementType() {
		return BiSingleAssignment_LeftValueAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiSingleAssignment_LeftValueSingleAssignmentValueParserRuleCall_2_0ElementType() {
		return BiSingleAssignment_LeftValueSingleAssignmentValueParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiSingleAssignment_VerticalLineKeyword_3ElementType() {
		return BiSingleAssignment_VerticalLineKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiSingleAssignment_RightValueAssignment_4ElementType() {
		return BiSingleAssignment_RightValueAssignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiSingleAssignment_RightValueSingleAssignmentValueParserRuleCall_4_0ElementType() {
		return BiSingleAssignment_RightValueSingleAssignmentValueParserRuleCall_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiSingleAssignment_SemicolonKeyword_5ElementType() {
		return BiSingleAssignment_SemicolonKeyword_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiListAssignmentElementType() {
		return BiListAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiListAssignment_GroupElementType() {
		return BiListAssignment_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiListAssignment_FeatureAssignment_0ElementType() {
		return BiListAssignment_FeatureAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiListAssignment_FeatureIDTerminalRuleCall_0_0ElementType() {
		return BiListAssignment_FeatureIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiListAssignment_EqualsSignKeyword_1ElementType() {
		return BiListAssignment_EqualsSignKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiListAssignment_LeftSquareBracketKeyword_2ElementType() {
		return BiListAssignment_LeftSquareBracketKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiListAssignment_Group_3ElementType() {
		return BiListAssignment_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiListAssignment_LeftValuesAssignment_3_0ElementType() {
		return BiListAssignment_LeftValuesAssignment_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiListAssignment_LeftValuesListAssignmentValueParserRuleCall_3_0_0ElementType() {
		return BiListAssignment_LeftValuesListAssignmentValueParserRuleCall_3_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiListAssignment_Group_3_1ElementType() {
		return BiListAssignment_Group_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiListAssignment_CommaKeyword_3_1_0ElementType() {
		return BiListAssignment_CommaKeyword_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiListAssignment_LeftValuesAssignment_3_1_1ElementType() {
		return BiListAssignment_LeftValuesAssignment_3_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiListAssignment_LeftValuesListAssignmentValueParserRuleCall_3_1_1_0ElementType() {
		return BiListAssignment_LeftValuesListAssignmentValueParserRuleCall_3_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiListAssignment_VerticalLineKeyword_4ElementType() {
		return BiListAssignment_VerticalLineKeyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiListAssignment_Group_5ElementType() {
		return BiListAssignment_Group_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiListAssignment_RightValuesAssignment_5_0ElementType() {
		return BiListAssignment_RightValuesAssignment_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiListAssignment_RightValuesListAssignmentValueParserRuleCall_5_0_0ElementType() {
		return BiListAssignment_RightValuesListAssignmentValueParserRuleCall_5_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiListAssignment_Group_5_1ElementType() {
		return BiListAssignment_Group_5_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiListAssignment_CommaKeyword_5_1_0ElementType() {
		return BiListAssignment_CommaKeyword_5_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiListAssignment_RightValuesAssignment_5_1_1ElementType() {
		return BiListAssignment_RightValuesAssignment_5_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiListAssignment_RightValuesListAssignmentValueParserRuleCall_5_1_1_0ElementType() {
		return BiListAssignment_RightValuesListAssignmentValueParserRuleCall_5_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiListAssignment_RightSquareBracketKeyword_6ElementType() {
		return BiListAssignment_RightSquareBracketKeyword_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBiListAssignment_SemicolonKeyword_7ElementType() {
		return BiListAssignment_SemicolonKeyword_7_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMonoSingleAssignmentElementType() {
		return MonoSingleAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMonoSingleAssignment_GroupElementType() {
		return MonoSingleAssignment_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMonoSingleAssignment_FeatureAssignment_0ElementType() {
		return MonoSingleAssignment_FeatureAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMonoSingleAssignment_FeatureIDTerminalRuleCall_0_0ElementType() {
		return MonoSingleAssignment_FeatureIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMonoSingleAssignment_EqualsSignKeyword_1ElementType() {
		return MonoSingleAssignment_EqualsSignKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMonoSingleAssignment_LeftValueAssignment_2ElementType() {
		return MonoSingleAssignment_LeftValueAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMonoSingleAssignment_LeftValueSingleAssignmentValueParserRuleCall_2_0ElementType() {
		return MonoSingleAssignment_LeftValueSingleAssignmentValueParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMonoSingleAssignment_SemicolonKeyword_3ElementType() {
		return MonoSingleAssignment_SemicolonKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMonoListAssignmentElementType() {
		return MonoListAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMonoListAssignment_GroupElementType() {
		return MonoListAssignment_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMonoListAssignment_FeatureAssignment_0ElementType() {
		return MonoListAssignment_FeatureAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMonoListAssignment_FeatureIDTerminalRuleCall_0_0ElementType() {
		return MonoListAssignment_FeatureIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMonoListAssignment_EqualsSignKeyword_1ElementType() {
		return MonoListAssignment_EqualsSignKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMonoListAssignment_LeftSquareBracketKeyword_2ElementType() {
		return MonoListAssignment_LeftSquareBracketKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMonoListAssignment_Group_3ElementType() {
		return MonoListAssignment_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMonoListAssignment_LeftValuesAssignment_3_0ElementType() {
		return MonoListAssignment_LeftValuesAssignment_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMonoListAssignment_LeftValuesAssignmentValueParserRuleCall_3_0_0ElementType() {
		return MonoListAssignment_LeftValuesAssignmentValueParserRuleCall_3_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMonoListAssignment_Group_3_1ElementType() {
		return MonoListAssignment_Group_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMonoListAssignment_CommaKeyword_3_1_0ElementType() {
		return MonoListAssignment_CommaKeyword_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMonoListAssignment_LeftValuesAssignment_3_1_1ElementType() {
		return MonoListAssignment_LeftValuesAssignment_3_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMonoListAssignment_LeftValuesAssignmentValueParserRuleCall_3_1_1_0ElementType() {
		return MonoListAssignment_LeftValuesAssignmentValueParserRuleCall_3_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMonoListAssignment_RightSquareBracketKeyword_4ElementType() {
		return MonoListAssignment_RightSquareBracketKeyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMonoListAssignment_SemicolonKeyword_5ElementType() {
		return MonoListAssignment_SemicolonKeyword_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentValueElementType() {
		return AssignmentValue_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentValue_AlternativesElementType() {
		return AssignmentValue_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentValue_ValueAssignment_0ElementType() {
		return AssignmentValue_ValueAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentValue_ValueSTRINGTerminalRuleCall_0_0ElementType() {
		return AssignmentValue_ValueSTRINGTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentValue_Group_1ElementType() {
		return AssignmentValue_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentValue_RefObjectAssignment_1_0ElementType() {
		return AssignmentValue_RefObjectAssignment_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentValue_RefObjectNamedObjectCrossReference_1_0_0ElementType() {
		return AssignmentValue_RefObjectNamedObjectCrossReference_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentValue_RefObjectNamedObjectIDTerminalRuleCall_1_0_0_1ElementType() {
		return AssignmentValue_RefObjectNamedObjectIDTerminalRuleCall_1_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentValue_Group_1_1ElementType() {
		return AssignmentValue_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentValue_FullStopKeyword_1_1_0ElementType() {
		return AssignmentValue_FullStopKeyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentValue_RefFeatureAssignment_1_1_1ElementType() {
		return AssignmentValue_RefFeatureAssignment_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentValue_RefFeatureIDTerminalRuleCall_1_1_1_0ElementType() {
		return AssignmentValue_RefFeatureIDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentValue_Group_1_1_2ElementType() {
		return AssignmentValue_Group_1_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentValue_LeftSquareBracketKeyword_1_1_2_0ElementType() {
		return AssignmentValue_LeftSquareBracketKeyword_1_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentValue_RefIndexAssignment_1_1_2_1ElementType() {
		return AssignmentValue_RefIndexAssignment_1_1_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentValue_RefIndexINTTerminalRuleCall_1_1_2_1_0ElementType() {
		return AssignmentValue_RefIndexINTTerminalRuleCall_1_1_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentValue_RightSquareBracketKeyword_1_1_2_2ElementType() {
		return AssignmentValue_RightSquareBracketKeyword_1_1_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentValue_NewObjectAssignment_2ElementType() {
		return AssignmentValue_NewObjectAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentValue_NewObjectCreatedObjectParserRuleCall_2_0ElementType() {
		return AssignmentValue_NewObjectCreatedObjectParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentValue_Group_3ElementType() {
		return AssignmentValue_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentValue_ImportAssignment_3_0ElementType() {
		return AssignmentValue_ImportAssignment_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentValue_ImportImportCrossReference_3_0_0ElementType() {
		return AssignmentValue_ImportImportCrossReference_3_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentValue_ImportImportIDTerminalRuleCall_3_0_0_1ElementType() {
		return AssignmentValue_ImportImportIDTerminalRuleCall_3_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentValue_ImpFragAssignment_3_1ElementType() {
		return AssignmentValue_ImpFragAssignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAssignmentValue_ImpFragFRAGMENTTerminalRuleCall_3_1_0ElementType() {
		return AssignmentValue_ImpFragFRAGMENTTerminalRuleCall_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValueElementType() {
		return ListAssignmentValue_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_GroupElementType() {
		return ListAssignmentValue_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_IndexAssignment_0ElementType() {
		return ListAssignmentValue_IndexAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_IndexINTTerminalRuleCall_0_0ElementType() {
		return ListAssignmentValue_IndexINTTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_ColonKeyword_1ElementType() {
		return ListAssignmentValue_ColonKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_Alternatives_2ElementType() {
		return ListAssignmentValue_Alternatives_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_Group_2_0ElementType() {
		return ListAssignmentValue_Group_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_LeftSquareBracketKeyword_2_0_0ElementType() {
		return ListAssignmentValue_LeftSquareBracketKeyword_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_RefIndexAssignment_2_0_1ElementType() {
		return ListAssignmentValue_RefIndexAssignment_2_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_RefIndexINTTerminalRuleCall_2_0_1_0ElementType() {
		return ListAssignmentValue_RefIndexINTTerminalRuleCall_2_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_RightSquareBracketKeyword_2_0_2ElementType() {
		return ListAssignmentValue_RightSquareBracketKeyword_2_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_ValueAssignment_2_1ElementType() {
		return ListAssignmentValue_ValueAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_ValueSTRINGTerminalRuleCall_2_1_0ElementType() {
		return ListAssignmentValue_ValueSTRINGTerminalRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_Group_2_2ElementType() {
		return ListAssignmentValue_Group_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_RefObjectAssignment_2_2_0ElementType() {
		return ListAssignmentValue_RefObjectAssignment_2_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_RefObjectNamedObjectCrossReference_2_2_0_0ElementType() {
		return ListAssignmentValue_RefObjectNamedObjectCrossReference_2_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_RefObjectNamedObjectIDTerminalRuleCall_2_2_0_0_1ElementType() {
		return ListAssignmentValue_RefObjectNamedObjectIDTerminalRuleCall_2_2_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_Group_2_2_1ElementType() {
		return ListAssignmentValue_Group_2_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_FullStopKeyword_2_2_1_0ElementType() {
		return ListAssignmentValue_FullStopKeyword_2_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_RefFeatureAssignment_2_2_1_1ElementType() {
		return ListAssignmentValue_RefFeatureAssignment_2_2_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_RefFeatureIDTerminalRuleCall_2_2_1_1_0ElementType() {
		return ListAssignmentValue_RefFeatureIDTerminalRuleCall_2_2_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_Group_2_2_1_2ElementType() {
		return ListAssignmentValue_Group_2_2_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_LeftSquareBracketKeyword_2_2_1_2_0ElementType() {
		return ListAssignmentValue_LeftSquareBracketKeyword_2_2_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_RefIndexAssignment_2_2_1_2_1ElementType() {
		return ListAssignmentValue_RefIndexAssignment_2_2_1_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_RefIndexINTTerminalRuleCall_2_2_1_2_1_0ElementType() {
		return ListAssignmentValue_RefIndexINTTerminalRuleCall_2_2_1_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_RightSquareBracketKeyword_2_2_1_2_2ElementType() {
		return ListAssignmentValue_RightSquareBracketKeyword_2_2_1_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_NewObjectAssignment_2_3ElementType() {
		return ListAssignmentValue_NewObjectAssignment_2_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_NewObjectCreatedObjectParserRuleCall_2_3_0ElementType() {
		return ListAssignmentValue_NewObjectCreatedObjectParserRuleCall_2_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_Group_2_4ElementType() {
		return ListAssignmentValue_Group_2_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_ImportAssignment_2_4_0ElementType() {
		return ListAssignmentValue_ImportAssignment_2_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_ImportImportCrossReference_2_4_0_0ElementType() {
		return ListAssignmentValue_ImportImportCrossReference_2_4_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_ImportImportIDTerminalRuleCall_2_4_0_0_1ElementType() {
		return ListAssignmentValue_ImportImportIDTerminalRuleCall_2_4_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_ImpFragAssignment_2_4_1ElementType() {
		return ListAssignmentValue_ImpFragAssignment_2_4_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getListAssignmentValue_ImpFragFRAGMENTTerminalRuleCall_2_4_1_0ElementType() {
		return ListAssignmentValue_ImpFragFRAGMENTTerminalRuleCall_2_4_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValueElementType() {
		return SingleAssignmentValue_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_AlternativesElementType() {
		return SingleAssignmentValue_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_KeywordAssignment_0ElementType() {
		return SingleAssignmentValue_KeywordAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_KeywordNullKeyword_0_0ElementType() {
		return SingleAssignmentValue_KeywordNullKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_ValueAssignment_1ElementType() {
		return SingleAssignmentValue_ValueAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_ValueSTRINGTerminalRuleCall_1_0ElementType() {
		return SingleAssignmentValue_ValueSTRINGTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_Group_2ElementType() {
		return SingleAssignmentValue_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_RefObjectAssignment_2_0ElementType() {
		return SingleAssignmentValue_RefObjectAssignment_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_RefObjectNamedObjectCrossReference_2_0_0ElementType() {
		return SingleAssignmentValue_RefObjectNamedObjectCrossReference_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_RefObjectNamedObjectIDTerminalRuleCall_2_0_0_1ElementType() {
		return SingleAssignmentValue_RefObjectNamedObjectIDTerminalRuleCall_2_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_Group_2_1ElementType() {
		return SingleAssignmentValue_Group_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_FullStopKeyword_2_1_0ElementType() {
		return SingleAssignmentValue_FullStopKeyword_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_RefFeatureAssignment_2_1_1ElementType() {
		return SingleAssignmentValue_RefFeatureAssignment_2_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_RefFeatureIDTerminalRuleCall_2_1_1_0ElementType() {
		return SingleAssignmentValue_RefFeatureIDTerminalRuleCall_2_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_Group_2_1_2ElementType() {
		return SingleAssignmentValue_Group_2_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_LeftSquareBracketKeyword_2_1_2_0ElementType() {
		return SingleAssignmentValue_LeftSquareBracketKeyword_2_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_RefIndexAssignment_2_1_2_1ElementType() {
		return SingleAssignmentValue_RefIndexAssignment_2_1_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_RefIndexINTTerminalRuleCall_2_1_2_1_0ElementType() {
		return SingleAssignmentValue_RefIndexINTTerminalRuleCall_2_1_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_RightSquareBracketKeyword_2_1_2_2ElementType() {
		return SingleAssignmentValue_RightSquareBracketKeyword_2_1_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_NewObjectAssignment_3ElementType() {
		return SingleAssignmentValue_NewObjectAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_NewObjectCreatedObjectParserRuleCall_3_0ElementType() {
		return SingleAssignmentValue_NewObjectCreatedObjectParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_Group_4ElementType() {
		return SingleAssignmentValue_Group_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_ImportAssignment_4_0ElementType() {
		return SingleAssignmentValue_ImportAssignment_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_ImportImportCrossReference_4_0_0ElementType() {
		return SingleAssignmentValue_ImportImportCrossReference_4_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_ImportImportIDTerminalRuleCall_4_0_0_1ElementType() {
		return SingleAssignmentValue_ImportImportIDTerminalRuleCall_4_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_ImpFragAssignment_4_1ElementType() {
		return SingleAssignmentValue_ImpFragAssignment_4_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSingleAssignmentValue_ImpFragFRAGMENTTerminalRuleCall_4_1_0ElementType() {
		return SingleAssignmentValue_ImpFragFRAGMENTTerminalRuleCall_4_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCreatedObjectElementType() {
		return CreatedObject_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCreatedObject_GroupElementType() {
		return CreatedObject_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCreatedObject_Alternatives_0ElementType() {
		return CreatedObject_Alternatives_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCreatedObject_ObjectNewParserRuleCall_0_0ElementType() {
		return CreatedObject_ObjectNewParserRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCreatedObject_ObjectCopyParserRuleCall_0_1ElementType() {
		return CreatedObject_ObjectCopyParserRuleCall_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCreatedObject_NameAssignment_1ElementType() {
		return CreatedObject_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCreatedObject_NameIDTerminalRuleCall_1_0ElementType() {
		return CreatedObject_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCreatedObject_Group_2ElementType() {
		return CreatedObject_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCreatedObject_LeftCurlyBracketKeyword_2_0ElementType() {
		return CreatedObject_LeftCurlyBracketKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCreatedObject_Alternatives_2_1ElementType() {
		return CreatedObject_Alternatives_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCreatedObject_AssignmentsAssignment_2_1_0ElementType() {
		return CreatedObject_AssignmentsAssignment_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCreatedObject_AssignmentsMonoSingleAssignmentParserRuleCall_2_1_0_0ElementType() {
		return CreatedObject_AssignmentsMonoSingleAssignmentParserRuleCall_2_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCreatedObject_AssignmentsAssignment_2_1_1ElementType() {
		return CreatedObject_AssignmentsAssignment_2_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCreatedObject_AssignmentsMonoListAssignmentParserRuleCall_2_1_1_0ElementType() {
		return CreatedObject_AssignmentsMonoListAssignmentParserRuleCall_2_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCreatedObject_LeftMigAssignment_2_2ElementType() {
		return CreatedObject_LeftMigAssignment_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCreatedObject_LeftMigMigrationParserRuleCall_2_2_0ElementType() {
		return CreatedObject_LeftMigMigrationParserRuleCall_2_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCreatedObject_RightCurlyBracketKeyword_2_3ElementType() {
		return CreatedObject_RightCurlyBracketKeyword_2_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectNewElementType() {
		return ObjectNew_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectNew_GroupElementType() {
		return ObjectNew_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectNew_NewKeyword_0ElementType() {
		return ObjectNew_NewKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectNew_ImportAssignment_1ElementType() {
		return ObjectNew_ImportAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectNew_ImportImportCrossReference_1_0ElementType() {
		return ObjectNew_ImportImportCrossReference_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectNew_ImportImportIDTerminalRuleCall_1_0_1ElementType() {
		return ObjectNew_ImportImportIDTerminalRuleCall_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectNew_ImpFragAssignment_2ElementType() {
		return ObjectNew_ImpFragAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectNew_ImpFragFRAGMENTTerminalRuleCall_2_0ElementType() {
		return ObjectNew_ImpFragFRAGMENTTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectCopyElementType() {
		return ObjectCopy_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectCopy_GroupElementType() {
		return ObjectCopy_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectCopy_CopyKeyword_0ElementType() {
		return ObjectCopy_CopyKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectCopy_ResourceAssignment_1ElementType() {
		return ObjectCopy_ResourceAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectCopy_ResourceNamedResourceCrossReference_1_0ElementType() {
		return ObjectCopy_ResourceNamedResourceCrossReference_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectCopy_ResourceNamedResourceIDTerminalRuleCall_1_0_1ElementType() {
		return ObjectCopy_ResourceNamedResourceIDTerminalRuleCall_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectCopy_FragmentAssignment_2ElementType() {
		return ObjectCopy_FragmentAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getObjectCopy_FragmentFRAGMENTTerminalRuleCall_2_0ElementType() {
		return ObjectCopy_FragmentFRAGMENTTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMigrationElementType() {
		return Migration_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMigration_GroupElementType() {
		return Migration_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMigration_MigrationAction_0ElementType() {
		return Migration_MigrationAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMigration_MigrateKeyword_1ElementType() {
		return Migration_MigrateKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMigration_FirstAssignment_2ElementType() {
		return Migration_FirstAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMigration_FirstExecutableParserRuleCall_2_0ElementType() {
		return Migration_FirstExecutableParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMigration_Alternatives_3ElementType() {
		return Migration_Alternatives_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMigration_Group_3_0ElementType() {
		return Migration_Group_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMigration_AsKeyword_3_0_0ElementType() {
		return Migration_AsKeyword_3_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMigration_AsOpAssignment_3_0_1ElementType() {
		return Migration_AsOpAssignment_3_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMigration_AsOpExecutableParserRuleCall_3_0_1_0ElementType() {
		return Migration_AsOpExecutableParserRuleCall_3_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMigration_Group_3_1ElementType() {
		return Migration_Group_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMigration_EachKeyword_3_1_0ElementType() {
		return Migration_EachKeyword_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMigration_EachOpAssignment_3_1_1ElementType() {
		return Migration_EachOpAssignment_3_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMigration_EachOpExecutableParserRuleCall_3_1_1_0ElementType() {
		return Migration_EachOpExecutableParserRuleCall_3_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMigration_SemicolonKeyword_4ElementType() {
		return Migration_SemicolonKeyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExecutableElementType() {
		return Executable_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExecutable_AlternativesElementType() {
		return Executable_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExecutable_JavaExecutableParserRuleCall_0ElementType() {
		return Executable_JavaExecutableParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExecutable_ExpressionExecutableParserRuleCall_1ElementType() {
		return Executable_ExpressionExecutableParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getJavaExecutableElementType() {
		return JavaExecutable_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getJavaExecutable_GroupElementType() {
		return JavaExecutable_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getJavaExecutable_JavaKeyword_0ElementType() {
		return JavaExecutable_JavaKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getJavaExecutable_MethodAssignment_1ElementType() {
		return JavaExecutable_MethodAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getJavaExecutable_MethodIDTerminalRuleCall_1_0ElementType() {
		return JavaExecutable_MethodIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getJavaExecutable_LeftParenthesisKeyword_2ElementType() {
		return JavaExecutable_LeftParenthesisKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getJavaExecutable_RightParenthesisKeyword_3ElementType() {
		return JavaExecutable_RightParenthesisKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpressionExecutableElementType() {
		return ExpressionExecutable_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpressionExecutable_ExprstrAssignmentElementType() {
		return ExpressionExecutable_ExprstrAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpressionExecutable_ExprstrSTRINGTerminalRuleCall_0ElementType() {
		return ExpressionExecutable_ExprstrSTRINGTerminalRuleCall_0_ELEMENT_TYPE;
	}

}
