package org.eclipse.xtext.index.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.index.idea.lang.psi.impl.IndexTestLanguageFileImpl;
import org.eclipse.xtext.index.services.IndexTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class IndexTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<IndexTestLanguageFileImpl>>(IndexTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final IndexTestLanguageGrammarAccess GRAMMAR_ACCESS = IndexTestLanguageLanguage.INSTANCE.getInstance(IndexTestLanguageGrammarAccess.class);

	private static class FileFactory {
		public static IGrammarAwareElementType createFileElementType() {
			return new IGrammarAwareElementType("File_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFileRule());
		}
		public static IGrammarAwareElementType createFile_ElementsAssignmentElementType() {
			return new IGrammarAwareElementType("File_ElementsAssignment_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFileAccess().getElementsAssignment());
		}
		public static IGrammarAwareElementType createFile_ElementsElementParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("File_ElementsElementParserRuleCall_0_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFileAccess().getElementsElementParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType File_ELEMENT_TYPE = associate(FileFactory.createFileElementType());

	public static final IGrammarAwareElementType File_ElementsAssignment_ELEMENT_TYPE = associate(FileFactory.createFile_ElementsAssignmentElementType());

	public static final IGrammarAwareElementType File_ElementsElementParserRuleCall_0_ELEMENT_TYPE = associate(FileFactory.createFile_ElementsElementParserRuleCall_0ElementType());

	private static class ImportFactory {
		public static IGrammarAwareElementType createImportElementType() {
			return new IGrammarAwareElementType("Import_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getImportRule());
		}
		public static IGrammarAwareElementType createImport_GroupElementType() {
			return new IGrammarAwareElementType("Import_Group_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getImportAccess().getGroup());
		}
		public static IGrammarAwareElementType createImport_ImportKeyword_0ElementType() {
			return new IGrammarAwareElementType("Import_ImportKeyword_0_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getImportAccess().getImportKeyword_0());
		}
		public static IGrammarAwareElementType createImport_ImportedNamespaceAssignment_1ElementType() {
			return new IGrammarAwareElementType("Import_ImportedNamespaceAssignment_1_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getImportAccess().getImportedNamespaceAssignment_1());
		}
		public static IGrammarAwareElementType createImport_ImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Import_ImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Import_ELEMENT_TYPE = associate(ImportFactory.createImportElementType());

	public static final IGrammarAwareElementType Import_Group_ELEMENT_TYPE = associate(ImportFactory.createImport_GroupElementType());

	public static final IGrammarAwareElementType Import_ImportKeyword_0_ELEMENT_TYPE = associate(ImportFactory.createImport_ImportKeyword_0ElementType());

	public static final IGrammarAwareElementType Import_ImportedNamespaceAssignment_1_ELEMENT_TYPE = associate(ImportFactory.createImport_ImportedNamespaceAssignment_1ElementType());

	public static final IGrammarAwareElementType Import_ImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0_ELEMENT_TYPE = associate(ImportFactory.createImport_ImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0ElementType());

	private static class QualifiedNameWithWildCardFactory {
		public static IGrammarAwareElementType createQualifiedNameWithWildCardElementType() {
			return new IGrammarAwareElementType("QualifiedNameWithWildCard_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameWithWildCardRule());
		}
		public static IGrammarAwareElementType createQualifiedNameWithWildCard_GroupElementType() {
			return new IGrammarAwareElementType("QualifiedNameWithWildCard_Group_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameWithWildCardAccess().getGroup());
		}
		public static IGrammarAwareElementType createQualifiedNameWithWildCard_QualifiedNameParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("QualifiedNameWithWildCard_QualifiedNameParserRuleCall_0_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0());
		}
		public static IGrammarAwareElementType createQualifiedNameWithWildCard_FullStopAsteriskKeyword_1ElementType() {
			return new IGrammarAwareElementType("QualifiedNameWithWildCard_FullStopAsteriskKeyword_1_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameWithWildCardAccess().getFullStopAsteriskKeyword_1());
		}
	}

	public static final IGrammarAwareElementType QualifiedNameWithWildCard_ELEMENT_TYPE = associate(QualifiedNameWithWildCardFactory.createQualifiedNameWithWildCardElementType());

	public static final IGrammarAwareElementType QualifiedNameWithWildCard_Group_ELEMENT_TYPE = associate(QualifiedNameWithWildCardFactory.createQualifiedNameWithWildCard_GroupElementType());

	public static final IGrammarAwareElementType QualifiedNameWithWildCard_QualifiedNameParserRuleCall_0_ELEMENT_TYPE = associate(QualifiedNameWithWildCardFactory.createQualifiedNameWithWildCard_QualifiedNameParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType QualifiedNameWithWildCard_FullStopAsteriskKeyword_1_ELEMENT_TYPE = associate(QualifiedNameWithWildCardFactory.createQualifiedNameWithWildCard_FullStopAsteriskKeyword_1ElementType());

	private static class QualifiedNameFactory {
		public static IGrammarAwareElementType createQualifiedNameElementType() {
			return new IGrammarAwareElementType("QualifiedName_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameRule());
		}
		public static IGrammarAwareElementType createQualifiedName_GroupElementType() {
			return new IGrammarAwareElementType("QualifiedName_Group_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameAccess().getGroup());
		}
		public static IGrammarAwareElementType createQualifiedName_IDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("QualifiedName_IDTerminalRuleCall_0_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameAccess().getIDTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createQualifiedName_Group_1ElementType() {
			return new IGrammarAwareElementType("QualifiedName_Group_1_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createQualifiedName_FullStopKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("QualifiedName_FullStopKeyword_1_0_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameAccess().getFullStopKeyword_1_0());
		}
		public static IGrammarAwareElementType createQualifiedName_IDTerminalRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("QualifiedName_IDTerminalRuleCall_1_1_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
		}
	}

	public static final IGrammarAwareElementType QualifiedName_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedNameElementType());

	public static final IGrammarAwareElementType QualifiedName_Group_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedName_GroupElementType());

	public static final IGrammarAwareElementType QualifiedName_IDTerminalRuleCall_0_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedName_IDTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType QualifiedName_Group_1_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedName_Group_1ElementType());

	public static final IGrammarAwareElementType QualifiedName_FullStopKeyword_1_0_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedName_FullStopKeyword_1_0ElementType());

	public static final IGrammarAwareElementType QualifiedName_IDTerminalRuleCall_1_1_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedName_IDTerminalRuleCall_1_1ElementType());

	private static class NamespaceFactory {
		public static IGrammarAwareElementType createNamespaceElementType() {
			return new IGrammarAwareElementType("Namespace_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamespaceRule());
		}
		public static IGrammarAwareElementType createNamespace_GroupElementType() {
			return new IGrammarAwareElementType("Namespace_Group_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamespaceAccess().getGroup());
		}
		public static IGrammarAwareElementType createNamespace_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("Namespace_NameAssignment_0_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamespaceAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createNamespace_NameQualifiedNameParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Namespace_NameQualifiedNameParserRuleCall_0_0_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamespaceAccess().getNameQualifiedNameParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createNamespace_LeftCurlyBracketKeyword_1ElementType() {
			return new IGrammarAwareElementType("Namespace_LeftCurlyBracketKeyword_1_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamespaceAccess().getLeftCurlyBracketKeyword_1());
		}
		public static IGrammarAwareElementType createNamespace_ElementsAssignment_2ElementType() {
			return new IGrammarAwareElementType("Namespace_ElementsAssignment_2_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamespaceAccess().getElementsAssignment_2());
		}
		public static IGrammarAwareElementType createNamespace_ElementsElementParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Namespace_ElementsElementParserRuleCall_2_0_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamespaceAccess().getElementsElementParserRuleCall_2_0());
		}
		public static IGrammarAwareElementType createNamespace_RightCurlyBracketKeyword_3ElementType() {
			return new IGrammarAwareElementType("Namespace_RightCurlyBracketKeyword_3_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamespaceAccess().getRightCurlyBracketKeyword_3());
		}
	}

	public static final IGrammarAwareElementType Namespace_ELEMENT_TYPE = associate(NamespaceFactory.createNamespaceElementType());

	public static final IGrammarAwareElementType Namespace_Group_ELEMENT_TYPE = associate(NamespaceFactory.createNamespace_GroupElementType());

	public static final IGrammarAwareElementType Namespace_NameAssignment_0_ELEMENT_TYPE = associate(NamespaceFactory.createNamespace_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType Namespace_NameQualifiedNameParserRuleCall_0_0_ELEMENT_TYPE = associate(NamespaceFactory.createNamespace_NameQualifiedNameParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Namespace_LeftCurlyBracketKeyword_1_ELEMENT_TYPE = associate(NamespaceFactory.createNamespace_LeftCurlyBracketKeyword_1ElementType());

	public static final IGrammarAwareElementType Namespace_ElementsAssignment_2_ELEMENT_TYPE = associate(NamespaceFactory.createNamespace_ElementsAssignment_2ElementType());

	public static final IGrammarAwareElementType Namespace_ElementsElementParserRuleCall_2_0_ELEMENT_TYPE = associate(NamespaceFactory.createNamespace_ElementsElementParserRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType Namespace_RightCurlyBracketKeyword_3_ELEMENT_TYPE = associate(NamespaceFactory.createNamespace_RightCurlyBracketKeyword_3ElementType());

	private static class ElementFactory {
		public static IGrammarAwareElementType createElementElementType() {
			return new IGrammarAwareElementType("Element_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementRule());
		}
		public static IGrammarAwareElementType createElement_AlternativesElementType() {
			return new IGrammarAwareElementType("Element_Alternatives_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createElement_NamespaceParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Element_NamespaceParserRuleCall_0_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getNamespaceParserRuleCall_0());
		}
		public static IGrammarAwareElementType createElement_TypeParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Element_TypeParserRuleCall_1_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getTypeParserRuleCall_1());
		}
		public static IGrammarAwareElementType createElement_ImportParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("Element_ImportParserRuleCall_2_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getImportParserRuleCall_2());
		}
	}

	public static final IGrammarAwareElementType Element_ELEMENT_TYPE = associate(ElementFactory.createElementElementType());

	public static final IGrammarAwareElementType Element_Alternatives_ELEMENT_TYPE = associate(ElementFactory.createElement_AlternativesElementType());

	public static final IGrammarAwareElementType Element_NamespaceParserRuleCall_0_ELEMENT_TYPE = associate(ElementFactory.createElement_NamespaceParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Element_TypeParserRuleCall_1_ELEMENT_TYPE = associate(ElementFactory.createElement_TypeParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType Element_ImportParserRuleCall_2_ELEMENT_TYPE = associate(ElementFactory.createElement_ImportParserRuleCall_2ElementType());

	private static class TypeFactory {
		public static IGrammarAwareElementType createTypeElementType() {
			return new IGrammarAwareElementType("Type_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeRule());
		}
		public static IGrammarAwareElementType createType_AlternativesElementType() {
			return new IGrammarAwareElementType("Type_Alternatives_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createType_EntityParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Type_EntityParserRuleCall_0_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getEntityParserRuleCall_0());
		}
		public static IGrammarAwareElementType createType_DatatypeParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Type_DatatypeParserRuleCall_1_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getDatatypeParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType Type_ELEMENT_TYPE = associate(TypeFactory.createTypeElementType());

	public static final IGrammarAwareElementType Type_Alternatives_ELEMENT_TYPE = associate(TypeFactory.createType_AlternativesElementType());

	public static final IGrammarAwareElementType Type_EntityParserRuleCall_0_ELEMENT_TYPE = associate(TypeFactory.createType_EntityParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Type_DatatypeParserRuleCall_1_ELEMENT_TYPE = associate(TypeFactory.createType_DatatypeParserRuleCall_1ElementType());

	private static class EntityFactory {
		public static IGrammarAwareElementType createEntityElementType() {
			return new IGrammarAwareElementType("Entity_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityRule());
		}
		public static IGrammarAwareElementType createEntity_GroupElementType() {
			return new IGrammarAwareElementType("Entity_Group_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityAccess().getGroup());
		}
		public static IGrammarAwareElementType createEntity_EntityKeyword_0ElementType() {
			return new IGrammarAwareElementType("Entity_EntityKeyword_0_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityAccess().getEntityKeyword_0());
		}
		public static IGrammarAwareElementType createEntity_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Entity_NameAssignment_1_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createEntity_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Entity_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createEntity_LeftCurlyBracketKeyword_2ElementType() {
			return new IGrammarAwareElementType("Entity_LeftCurlyBracketKeyword_2_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityAccess().getLeftCurlyBracketKeyword_2());
		}
		public static IGrammarAwareElementType createEntity_PropertiesAssignment_3ElementType() {
			return new IGrammarAwareElementType("Entity_PropertiesAssignment_3_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityAccess().getPropertiesAssignment_3());
		}
		public static IGrammarAwareElementType createEntity_PropertiesPropertyParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("Entity_PropertiesPropertyParserRuleCall_3_0_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityAccess().getPropertiesPropertyParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createEntity_RightCurlyBracketKeyword_4ElementType() {
			return new IGrammarAwareElementType("Entity_RightCurlyBracketKeyword_4_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEntityAccess().getRightCurlyBracketKeyword_4());
		}
	}

	public static final IGrammarAwareElementType Entity_ELEMENT_TYPE = associate(EntityFactory.createEntityElementType());

	public static final IGrammarAwareElementType Entity_Group_ELEMENT_TYPE = associate(EntityFactory.createEntity_GroupElementType());

	public static final IGrammarAwareElementType Entity_EntityKeyword_0_ELEMENT_TYPE = associate(EntityFactory.createEntity_EntityKeyword_0ElementType());

	public static final IGrammarAwareElementType Entity_NameAssignment_1_ELEMENT_TYPE = associate(EntityFactory.createEntity_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Entity_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(EntityFactory.createEntity_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Entity_LeftCurlyBracketKeyword_2_ELEMENT_TYPE = associate(EntityFactory.createEntity_LeftCurlyBracketKeyword_2ElementType());

	public static final IGrammarAwareElementType Entity_PropertiesAssignment_3_ELEMENT_TYPE = associate(EntityFactory.createEntity_PropertiesAssignment_3ElementType());

	public static final IGrammarAwareElementType Entity_PropertiesPropertyParserRuleCall_3_0_ELEMENT_TYPE = associate(EntityFactory.createEntity_PropertiesPropertyParserRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType Entity_RightCurlyBracketKeyword_4_ELEMENT_TYPE = associate(EntityFactory.createEntity_RightCurlyBracketKeyword_4ElementType());

	private static class DatatypeFactory {
		public static IGrammarAwareElementType createDatatypeElementType() {
			return new IGrammarAwareElementType("Datatype_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeRule());
		}
		public static IGrammarAwareElementType createDatatype_GroupElementType() {
			return new IGrammarAwareElementType("Datatype_Group_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeAccess().getGroup());
		}
		public static IGrammarAwareElementType createDatatype_DatatypeKeyword_0ElementType() {
			return new IGrammarAwareElementType("Datatype_DatatypeKeyword_0_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeAccess().getDatatypeKeyword_0());
		}
		public static IGrammarAwareElementType createDatatype_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Datatype_NameAssignment_1_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createDatatype_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Datatype_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeAccess().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Datatype_ELEMENT_TYPE = associate(DatatypeFactory.createDatatypeElementType());

	public static final IGrammarAwareElementType Datatype_Group_ELEMENT_TYPE = associate(DatatypeFactory.createDatatype_GroupElementType());

	public static final IGrammarAwareElementType Datatype_DatatypeKeyword_0_ELEMENT_TYPE = associate(DatatypeFactory.createDatatype_DatatypeKeyword_0ElementType());

	public static final IGrammarAwareElementType Datatype_NameAssignment_1_ELEMENT_TYPE = associate(DatatypeFactory.createDatatype_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Datatype_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(DatatypeFactory.createDatatype_NameIDTerminalRuleCall_1_0ElementType());

	private static class PropertyFactory {
		public static IGrammarAwareElementType createPropertyElementType() {
			return new IGrammarAwareElementType("Property_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPropertyRule());
		}
		public static IGrammarAwareElementType createProperty_GroupElementType() {
			return new IGrammarAwareElementType("Property_Group_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPropertyAccess().getGroup());
		}
		public static IGrammarAwareElementType createProperty_TypeAssignment_0ElementType() {
			return new IGrammarAwareElementType("Property_TypeAssignment_0_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPropertyAccess().getTypeAssignment_0());
		}
		public static IGrammarAwareElementType createProperty_TypeTypeCrossReference_0_0ElementType() {
			return new IGrammarAwareElementType("Property_TypeTypeCrossReference_0_0_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPropertyAccess().getTypeTypeCrossReference_0_0());
		}
		public static IGrammarAwareElementType createProperty_TypeTypeQualifiedNameParserRuleCall_0_0_1ElementType() {
			return new IGrammarAwareElementType("Property_TypeTypeQualifiedNameParserRuleCall_0_0_1_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPropertyAccess().getTypeTypeQualifiedNameParserRuleCall_0_0_1());
		}
		public static IGrammarAwareElementType createProperty_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Property_NameAssignment_1_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPropertyAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createProperty_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Property_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", IndexTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPropertyAccess().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Property_ELEMENT_TYPE = associate(PropertyFactory.createPropertyElementType());

	public static final IGrammarAwareElementType Property_Group_ELEMENT_TYPE = associate(PropertyFactory.createProperty_GroupElementType());

	public static final IGrammarAwareElementType Property_TypeAssignment_0_ELEMENT_TYPE = associate(PropertyFactory.createProperty_TypeAssignment_0ElementType());

	public static final IGrammarAwareElementType Property_TypeTypeCrossReference_0_0_ELEMENT_TYPE = associate(PropertyFactory.createProperty_TypeTypeCrossReference_0_0ElementType());

	public static final IGrammarAwareElementType Property_TypeTypeQualifiedNameParserRuleCall_0_0_1_ELEMENT_TYPE = associate(PropertyFactory.createProperty_TypeTypeQualifiedNameParserRuleCall_0_0_1ElementType());

	public static final IGrammarAwareElementType Property_NameAssignment_1_ELEMENT_TYPE = associate(PropertyFactory.createProperty_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Property_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(PropertyFactory.createProperty_NameIDTerminalRuleCall_1_0ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getFileElementType() {
		return File_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFile_ElementsAssignmentElementType() {
		return File_ElementsAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFile_ElementsElementParserRuleCall_0ElementType() {
		return File_ElementsElementParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getImportElementType() {
		return Import_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getImport_GroupElementType() {
		return Import_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getImport_ImportKeyword_0ElementType() {
		return Import_ImportKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getImport_ImportedNamespaceAssignment_1ElementType() {
		return Import_ImportedNamespaceAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getImport_ImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0ElementType() {
		return Import_ImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQualifiedNameWithWildCardElementType() {
		return QualifiedNameWithWildCard_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQualifiedNameWithWildCard_GroupElementType() {
		return QualifiedNameWithWildCard_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQualifiedNameWithWildCard_QualifiedNameParserRuleCall_0ElementType() {
		return QualifiedNameWithWildCard_QualifiedNameParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQualifiedNameWithWildCard_FullStopAsteriskKeyword_1ElementType() {
		return QualifiedNameWithWildCard_FullStopAsteriskKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQualifiedNameElementType() {
		return QualifiedName_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQualifiedName_GroupElementType() {
		return QualifiedName_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQualifiedName_IDTerminalRuleCall_0ElementType() {
		return QualifiedName_IDTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQualifiedName_Group_1ElementType() {
		return QualifiedName_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQualifiedName_FullStopKeyword_1_0ElementType() {
		return QualifiedName_FullStopKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQualifiedName_IDTerminalRuleCall_1_1ElementType() {
		return QualifiedName_IDTerminalRuleCall_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamespaceElementType() {
		return Namespace_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamespace_GroupElementType() {
		return Namespace_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamespace_NameAssignment_0ElementType() {
		return Namespace_NameAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamespace_NameQualifiedNameParserRuleCall_0_0ElementType() {
		return Namespace_NameQualifiedNameParserRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamespace_LeftCurlyBracketKeyword_1ElementType() {
		return Namespace_LeftCurlyBracketKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamespace_ElementsAssignment_2ElementType() {
		return Namespace_ElementsAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamespace_ElementsElementParserRuleCall_2_0ElementType() {
		return Namespace_ElementsElementParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamespace_RightCurlyBracketKeyword_3ElementType() {
		return Namespace_RightCurlyBracketKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElementElementType() {
		return Element_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_AlternativesElementType() {
		return Element_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_NamespaceParserRuleCall_0ElementType() {
		return Element_NamespaceParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_TypeParserRuleCall_1ElementType() {
		return Element_TypeParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ImportParserRuleCall_2ElementType() {
		return Element_ImportParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeElementType() {
		return Type_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_AlternativesElementType() {
		return Type_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_EntityParserRuleCall_0ElementType() {
		return Type_EntityParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_DatatypeParserRuleCall_1ElementType() {
		return Type_DatatypeParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEntityElementType() {
		return Entity_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEntity_GroupElementType() {
		return Entity_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEntity_EntityKeyword_0ElementType() {
		return Entity_EntityKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEntity_NameAssignment_1ElementType() {
		return Entity_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEntity_NameIDTerminalRuleCall_1_0ElementType() {
		return Entity_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEntity_LeftCurlyBracketKeyword_2ElementType() {
		return Entity_LeftCurlyBracketKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEntity_PropertiesAssignment_3ElementType() {
		return Entity_PropertiesAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEntity_PropertiesPropertyParserRuleCall_3_0ElementType() {
		return Entity_PropertiesPropertyParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEntity_RightCurlyBracketKeyword_4ElementType() {
		return Entity_RightCurlyBracketKeyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeElementType() {
		return Datatype_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatype_GroupElementType() {
		return Datatype_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatype_DatatypeKeyword_0ElementType() {
		return Datatype_DatatypeKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatype_NameAssignment_1ElementType() {
		return Datatype_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatype_NameIDTerminalRuleCall_1_0ElementType() {
		return Datatype_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPropertyElementType() {
		return Property_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getProperty_GroupElementType() {
		return Property_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getProperty_TypeAssignment_0ElementType() {
		return Property_TypeAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getProperty_TypeTypeCrossReference_0_0ElementType() {
		return Property_TypeTypeCrossReference_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getProperty_TypeTypeQualifiedNameParserRuleCall_0_0_1ElementType() {
		return Property_TypeTypeQualifiedNameParserRuleCall_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getProperty_NameAssignment_1ElementType() {
		return Property_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getProperty_NameIDTerminalRuleCall_1_0ElementType() {
		return Property_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

}
