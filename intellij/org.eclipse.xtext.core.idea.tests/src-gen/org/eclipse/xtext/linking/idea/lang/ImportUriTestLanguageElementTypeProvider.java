package org.eclipse.xtext.linking.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.linking.idea.lang.psi.impl.ImportUriTestLanguageFileImpl;
import org.eclipse.xtext.linking.services.ImportUriTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class ImportUriTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<ImportUriTestLanguageFileImpl>>(ImportUriTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final ImportUriTestLanguageGrammarAccess GRAMMAR_ACCESS = ImportUriTestLanguageLanguage.INSTANCE.getInstance(ImportUriTestLanguageGrammarAccess.class);

	private static class MainFactory {
		public static IGrammarAwareElementType createMainElementType() {
			return new IGrammarAwareElementType("Main_ELEMENT_TYPE", ImportUriTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMainRule());
		}
		public static IGrammarAwareElementType createMain_GroupElementType() {
			return new IGrammarAwareElementType("Main_Group_ELEMENT_TYPE", ImportUriTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMainAccess().getGroup());
		}
		public static IGrammarAwareElementType createMain_ImportsAssignment_0ElementType() {
			return new IGrammarAwareElementType("Main_ImportsAssignment_0_ELEMENT_TYPE", ImportUriTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMainAccess().getImportsAssignment_0());
		}
		public static IGrammarAwareElementType createMain_ImportsImportParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Main_ImportsImportParserRuleCall_0_0_ELEMENT_TYPE", ImportUriTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMainAccess().getImportsImportParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createMain_TypesAssignment_1ElementType() {
			return new IGrammarAwareElementType("Main_TypesAssignment_1_ELEMENT_TYPE", ImportUriTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMainAccess().getTypesAssignment_1());
		}
		public static IGrammarAwareElementType createMain_TypesTypeParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Main_TypesTypeParserRuleCall_1_0_ELEMENT_TYPE", ImportUriTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMainAccess().getTypesTypeParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Main_ELEMENT_TYPE = associate(MainFactory.createMainElementType());

	public static final IGrammarAwareElementType Main_Group_ELEMENT_TYPE = associate(MainFactory.createMain_GroupElementType());

	public static final IGrammarAwareElementType Main_ImportsAssignment_0_ELEMENT_TYPE = associate(MainFactory.createMain_ImportsAssignment_0ElementType());

	public static final IGrammarAwareElementType Main_ImportsImportParserRuleCall_0_0_ELEMENT_TYPE = associate(MainFactory.createMain_ImportsImportParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Main_TypesAssignment_1_ELEMENT_TYPE = associate(MainFactory.createMain_TypesAssignment_1ElementType());

	public static final IGrammarAwareElementType Main_TypesTypeParserRuleCall_1_0_ELEMENT_TYPE = associate(MainFactory.createMain_TypesTypeParserRuleCall_1_0ElementType());

	private static class ImportFactory {
		public static IGrammarAwareElementType createImportElementType() {
			return new IGrammarAwareElementType("Import_ELEMENT_TYPE", ImportUriTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getImportRule());
		}
		public static IGrammarAwareElementType createImport_GroupElementType() {
			return new IGrammarAwareElementType("Import_Group_ELEMENT_TYPE", ImportUriTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getImportAccess().getGroup());
		}
		public static IGrammarAwareElementType createImport_ImportKeyword_0ElementType() {
			return new IGrammarAwareElementType("Import_ImportKeyword_0_ELEMENT_TYPE", ImportUriTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getImportAccess().getImportKeyword_0());
		}
		public static IGrammarAwareElementType createImport_ImportURIAssignment_1ElementType() {
			return new IGrammarAwareElementType("Import_ImportURIAssignment_1_ELEMENT_TYPE", ImportUriTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getImportAccess().getImportURIAssignment_1());
		}
		public static IGrammarAwareElementType createImport_ImportURISTRINGTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Import_ImportURISTRINGTerminalRuleCall_1_0_ELEMENT_TYPE", ImportUriTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Import_ELEMENT_TYPE = associate(ImportFactory.createImportElementType());

	public static final IGrammarAwareElementType Import_Group_ELEMENT_TYPE = associate(ImportFactory.createImport_GroupElementType());

	public static final IGrammarAwareElementType Import_ImportKeyword_0_ELEMENT_TYPE = associate(ImportFactory.createImport_ImportKeyword_0ElementType());

	public static final IGrammarAwareElementType Import_ImportURIAssignment_1_ELEMENT_TYPE = associate(ImportFactory.createImport_ImportURIAssignment_1ElementType());

	public static final IGrammarAwareElementType Import_ImportURISTRINGTerminalRuleCall_1_0_ELEMENT_TYPE = associate(ImportFactory.createImport_ImportURISTRINGTerminalRuleCall_1_0ElementType());

	private static class TypeFactory {
		public static IGrammarAwareElementType createTypeElementType() {
			return new IGrammarAwareElementType("Type_ELEMENT_TYPE", ImportUriTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeRule());
		}
		public static IGrammarAwareElementType createType_GroupElementType() {
			return new IGrammarAwareElementType("Type_Group_ELEMENT_TYPE", ImportUriTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getGroup());
		}
		public static IGrammarAwareElementType createType_TypeKeyword_0ElementType() {
			return new IGrammarAwareElementType("Type_TypeKeyword_0_ELEMENT_TYPE", ImportUriTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getTypeKeyword_0());
		}
		public static IGrammarAwareElementType createType_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Type_NameAssignment_1_ELEMENT_TYPE", ImportUriTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createType_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Type_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", ImportUriTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createType_ExtendsKeyword_2ElementType() {
			return new IGrammarAwareElementType("Type_ExtendsKeyword_2_ELEMENT_TYPE", ImportUriTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getExtendsKeyword_2());
		}
		public static IGrammarAwareElementType createType_ExtendsAssignment_3ElementType() {
			return new IGrammarAwareElementType("Type_ExtendsAssignment_3_ELEMENT_TYPE", ImportUriTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getExtendsAssignment_3());
		}
		public static IGrammarAwareElementType createType_ExtendsTypeCrossReference_3_0ElementType() {
			return new IGrammarAwareElementType("Type_ExtendsTypeCrossReference_3_0_ELEMENT_TYPE", ImportUriTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getExtendsTypeCrossReference_3_0());
		}
		public static IGrammarAwareElementType createType_ExtendsTypeIDTerminalRuleCall_3_0_1ElementType() {
			return new IGrammarAwareElementType("Type_ExtendsTypeIDTerminalRuleCall_3_0_1_ELEMENT_TYPE", ImportUriTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getExtendsTypeIDTerminalRuleCall_3_0_1());
		}
	}

	public static final IGrammarAwareElementType Type_ELEMENT_TYPE = associate(TypeFactory.createTypeElementType());

	public static final IGrammarAwareElementType Type_Group_ELEMENT_TYPE = associate(TypeFactory.createType_GroupElementType());

	public static final IGrammarAwareElementType Type_TypeKeyword_0_ELEMENT_TYPE = associate(TypeFactory.createType_TypeKeyword_0ElementType());

	public static final IGrammarAwareElementType Type_NameAssignment_1_ELEMENT_TYPE = associate(TypeFactory.createType_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Type_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(TypeFactory.createType_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Type_ExtendsKeyword_2_ELEMENT_TYPE = associate(TypeFactory.createType_ExtendsKeyword_2ElementType());

	public static final IGrammarAwareElementType Type_ExtendsAssignment_3_ELEMENT_TYPE = associate(TypeFactory.createType_ExtendsAssignment_3ElementType());

	public static final IGrammarAwareElementType Type_ExtendsTypeCrossReference_3_0_ELEMENT_TYPE = associate(TypeFactory.createType_ExtendsTypeCrossReference_3_0ElementType());

	public static final IGrammarAwareElementType Type_ExtendsTypeIDTerminalRuleCall_3_0_1_ELEMENT_TYPE = associate(TypeFactory.createType_ExtendsTypeIDTerminalRuleCall_3_0_1ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getMainElementType() {
		return Main_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMain_GroupElementType() {
		return Main_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMain_ImportsAssignment_0ElementType() {
		return Main_ImportsAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMain_ImportsImportParserRuleCall_0_0ElementType() {
		return Main_ImportsImportParserRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMain_TypesAssignment_1ElementType() {
		return Main_TypesAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMain_TypesTypeParserRuleCall_1_0ElementType() {
		return Main_TypesTypeParserRuleCall_1_0_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getImport_ImportURIAssignment_1ElementType() {
		return Import_ImportURIAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getImport_ImportURISTRINGTerminalRuleCall_1_0ElementType() {
		return Import_ImportURISTRINGTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeElementType() {
		return Type_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_GroupElementType() {
		return Type_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_TypeKeyword_0ElementType() {
		return Type_TypeKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_NameAssignment_1ElementType() {
		return Type_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_NameIDTerminalRuleCall_1_0ElementType() {
		return Type_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_ExtendsKeyword_2ElementType() {
		return Type_ExtendsKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_ExtendsAssignment_3ElementType() {
		return Type_ExtendsAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_ExtendsTypeCrossReference_3_0ElementType() {
		return Type_ExtendsTypeCrossReference_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_ExtendsTypeIDTerminalRuleCall_3_0_1ElementType() {
		return Type_ExtendsTypeIDTerminalRuleCall_3_0_1_ELEMENT_TYPE;
	}

}
