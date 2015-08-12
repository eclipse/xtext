package org.eclipse.xtext.linking.lazy.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.linking.lazy.idea.lang.psi.impl.LazyLinkingTestLanguageFileImpl;
import org.eclipse.xtext.linking.lazy.services.LazyLinkingTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class LazyLinkingTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<LazyLinkingTestLanguageFileImpl>>(LazyLinkingTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final LazyLinkingTestLanguageGrammarAccess GRAMMAR_ACCESS = LazyLinkingTestLanguageLanguage.INSTANCE.getInstance(LazyLinkingTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_TypesAssignmentElementType() {
			return new IGrammarAwareElementType("Model_TypesAssignment_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getTypesAssignment());
		}
		public static IGrammarAwareElementType createModel_TypesTypeParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Model_TypesTypeParserRuleCall_0_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getTypesTypeParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_TypesAssignment_ELEMENT_TYPE = associate(ModelFactory.createModel_TypesAssignmentElementType());

	public static final IGrammarAwareElementType Model_TypesTypeParserRuleCall_0_ELEMENT_TYPE = associate(ModelFactory.createModel_TypesTypeParserRuleCall_0ElementType());

	private static class TypeFactory {
		public static IGrammarAwareElementType createTypeElementType() {
			return new IGrammarAwareElementType("Type_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeRule());
		}
		public static IGrammarAwareElementType createType_GroupElementType() {
			return new IGrammarAwareElementType("Type_Group_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getGroup());
		}
		public static IGrammarAwareElementType createType_TypeKeyword_0ElementType() {
			return new IGrammarAwareElementType("Type_TypeKeyword_0_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getTypeKeyword_0());
		}
		public static IGrammarAwareElementType createType_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Type_NameAssignment_1_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createType_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Type_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createType_Group_2ElementType() {
			return new IGrammarAwareElementType("Type_Group_2_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createType_ExtendsKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Type_ExtendsKeyword_2_0_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getExtendsKeyword_2_0());
		}
		public static IGrammarAwareElementType createType_ExtendsAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("Type_ExtendsAssignment_2_1_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getExtendsAssignment_2_1());
		}
		public static IGrammarAwareElementType createType_ExtendsTypeCrossReference_2_1_0ElementType() {
			return new IGrammarAwareElementType("Type_ExtendsTypeCrossReference_2_1_0_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getExtendsTypeCrossReference_2_1_0());
		}
		public static IGrammarAwareElementType createType_ExtendsTypeIDTerminalRuleCall_2_1_0_1ElementType() {
			return new IGrammarAwareElementType("Type_ExtendsTypeIDTerminalRuleCall_2_1_0_1_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getExtendsTypeIDTerminalRuleCall_2_1_0_1());
		}
		public static IGrammarAwareElementType createType_FullStopKeyword_2_2ElementType() {
			return new IGrammarAwareElementType("Type_FullStopKeyword_2_2_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getFullStopKeyword_2_2());
		}
		public static IGrammarAwareElementType createType_ParentIdAssignment_2_3ElementType() {
			return new IGrammarAwareElementType("Type_ParentIdAssignment_2_3_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getParentIdAssignment_2_3());
		}
		public static IGrammarAwareElementType createType_ParentIdPropertyCrossReference_2_3_0ElementType() {
			return new IGrammarAwareElementType("Type_ParentIdPropertyCrossReference_2_3_0_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getParentIdPropertyCrossReference_2_3_0());
		}
		public static IGrammarAwareElementType createType_ParentIdPropertyIDTerminalRuleCall_2_3_0_1ElementType() {
			return new IGrammarAwareElementType("Type_ParentIdPropertyIDTerminalRuleCall_2_3_0_1_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getParentIdPropertyIDTerminalRuleCall_2_3_0_1());
		}
		public static IGrammarAwareElementType createType_Group_3ElementType() {
			return new IGrammarAwareElementType("Type_Group_3_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createType_ForKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("Type_ForKeyword_3_0_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getForKeyword_3_0());
		}
		public static IGrammarAwareElementType createType_ParentIdAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("Type_ParentIdAssignment_3_1_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getParentIdAssignment_3_1());
		}
		public static IGrammarAwareElementType createType_ParentIdPropertyCrossReference_3_1_0ElementType() {
			return new IGrammarAwareElementType("Type_ParentIdPropertyCrossReference_3_1_0_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getParentIdPropertyCrossReference_3_1_0());
		}
		public static IGrammarAwareElementType createType_ParentIdPropertyIDTerminalRuleCall_3_1_0_1ElementType() {
			return new IGrammarAwareElementType("Type_ParentIdPropertyIDTerminalRuleCall_3_1_0_1_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getParentIdPropertyIDTerminalRuleCall_3_1_0_1());
		}
		public static IGrammarAwareElementType createType_InKeyword_3_2ElementType() {
			return new IGrammarAwareElementType("Type_InKeyword_3_2_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getInKeyword_3_2());
		}
		public static IGrammarAwareElementType createType_ExtendsAssignment_3_3ElementType() {
			return new IGrammarAwareElementType("Type_ExtendsAssignment_3_3_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getExtendsAssignment_3_3());
		}
		public static IGrammarAwareElementType createType_ExtendsTypeCrossReference_3_3_0ElementType() {
			return new IGrammarAwareElementType("Type_ExtendsTypeCrossReference_3_3_0_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getExtendsTypeCrossReference_3_3_0());
		}
		public static IGrammarAwareElementType createType_ExtendsTypeIDTerminalRuleCall_3_3_0_1ElementType() {
			return new IGrammarAwareElementType("Type_ExtendsTypeIDTerminalRuleCall_3_3_0_1_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getExtendsTypeIDTerminalRuleCall_3_3_0_1());
		}
		public static IGrammarAwareElementType createType_LeftCurlyBracketKeyword_4ElementType() {
			return new IGrammarAwareElementType("Type_LeftCurlyBracketKeyword_4_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getLeftCurlyBracketKeyword_4());
		}
		public static IGrammarAwareElementType createType_PropertiesAssignment_5ElementType() {
			return new IGrammarAwareElementType("Type_PropertiesAssignment_5_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getPropertiesAssignment_5());
		}
		public static IGrammarAwareElementType createType_PropertiesPropertyParserRuleCall_5_0ElementType() {
			return new IGrammarAwareElementType("Type_PropertiesPropertyParserRuleCall_5_0_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getPropertiesPropertyParserRuleCall_5_0());
		}
		public static IGrammarAwareElementType createType_UnresolvedProxyPropertyAssignment_6ElementType() {
			return new IGrammarAwareElementType("Type_UnresolvedProxyPropertyAssignment_6_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getUnresolvedProxyPropertyAssignment_6());
		}
		public static IGrammarAwareElementType createType_UnresolvedProxyPropertyUnresolvedProxyPropertyParserRuleCall_6_0ElementType() {
			return new IGrammarAwareElementType("Type_UnresolvedProxyPropertyUnresolvedProxyPropertyParserRuleCall_6_0_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getUnresolvedProxyPropertyUnresolvedProxyPropertyParserRuleCall_6_0());
		}
		public static IGrammarAwareElementType createType_RightCurlyBracketKeyword_7ElementType() {
			return new IGrammarAwareElementType("Type_RightCurlyBracketKeyword_7_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getRightCurlyBracketKeyword_7());
		}
	}

	public static final IGrammarAwareElementType Type_ELEMENT_TYPE = associate(TypeFactory.createTypeElementType());

	public static final IGrammarAwareElementType Type_Group_ELEMENT_TYPE = associate(TypeFactory.createType_GroupElementType());

	public static final IGrammarAwareElementType Type_TypeKeyword_0_ELEMENT_TYPE = associate(TypeFactory.createType_TypeKeyword_0ElementType());

	public static final IGrammarAwareElementType Type_NameAssignment_1_ELEMENT_TYPE = associate(TypeFactory.createType_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Type_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(TypeFactory.createType_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Type_Group_2_ELEMENT_TYPE = associate(TypeFactory.createType_Group_2ElementType());

	public static final IGrammarAwareElementType Type_ExtendsKeyword_2_0_ELEMENT_TYPE = associate(TypeFactory.createType_ExtendsKeyword_2_0ElementType());

	public static final IGrammarAwareElementType Type_ExtendsAssignment_2_1_ELEMENT_TYPE = associate(TypeFactory.createType_ExtendsAssignment_2_1ElementType());

	public static final IGrammarAwareElementType Type_ExtendsTypeCrossReference_2_1_0_ELEMENT_TYPE = associate(TypeFactory.createType_ExtendsTypeCrossReference_2_1_0ElementType());

	public static final IGrammarAwareElementType Type_ExtendsTypeIDTerminalRuleCall_2_1_0_1_ELEMENT_TYPE = associate(TypeFactory.createType_ExtendsTypeIDTerminalRuleCall_2_1_0_1ElementType());

	public static final IGrammarAwareElementType Type_FullStopKeyword_2_2_ELEMENT_TYPE = associate(TypeFactory.createType_FullStopKeyword_2_2ElementType());

	public static final IGrammarAwareElementType Type_ParentIdAssignment_2_3_ELEMENT_TYPE = associate(TypeFactory.createType_ParentIdAssignment_2_3ElementType());

	public static final IGrammarAwareElementType Type_ParentIdPropertyCrossReference_2_3_0_ELEMENT_TYPE = associate(TypeFactory.createType_ParentIdPropertyCrossReference_2_3_0ElementType());

	public static final IGrammarAwareElementType Type_ParentIdPropertyIDTerminalRuleCall_2_3_0_1_ELEMENT_TYPE = associate(TypeFactory.createType_ParentIdPropertyIDTerminalRuleCall_2_3_0_1ElementType());

	public static final IGrammarAwareElementType Type_Group_3_ELEMENT_TYPE = associate(TypeFactory.createType_Group_3ElementType());

	public static final IGrammarAwareElementType Type_ForKeyword_3_0_ELEMENT_TYPE = associate(TypeFactory.createType_ForKeyword_3_0ElementType());

	public static final IGrammarAwareElementType Type_ParentIdAssignment_3_1_ELEMENT_TYPE = associate(TypeFactory.createType_ParentIdAssignment_3_1ElementType());

	public static final IGrammarAwareElementType Type_ParentIdPropertyCrossReference_3_1_0_ELEMENT_TYPE = associate(TypeFactory.createType_ParentIdPropertyCrossReference_3_1_0ElementType());

	public static final IGrammarAwareElementType Type_ParentIdPropertyIDTerminalRuleCall_3_1_0_1_ELEMENT_TYPE = associate(TypeFactory.createType_ParentIdPropertyIDTerminalRuleCall_3_1_0_1ElementType());

	public static final IGrammarAwareElementType Type_InKeyword_3_2_ELEMENT_TYPE = associate(TypeFactory.createType_InKeyword_3_2ElementType());

	public static final IGrammarAwareElementType Type_ExtendsAssignment_3_3_ELEMENT_TYPE = associate(TypeFactory.createType_ExtendsAssignment_3_3ElementType());

	public static final IGrammarAwareElementType Type_ExtendsTypeCrossReference_3_3_0_ELEMENT_TYPE = associate(TypeFactory.createType_ExtendsTypeCrossReference_3_3_0ElementType());

	public static final IGrammarAwareElementType Type_ExtendsTypeIDTerminalRuleCall_3_3_0_1_ELEMENT_TYPE = associate(TypeFactory.createType_ExtendsTypeIDTerminalRuleCall_3_3_0_1ElementType());

	public static final IGrammarAwareElementType Type_LeftCurlyBracketKeyword_4_ELEMENT_TYPE = associate(TypeFactory.createType_LeftCurlyBracketKeyword_4ElementType());

	public static final IGrammarAwareElementType Type_PropertiesAssignment_5_ELEMENT_TYPE = associate(TypeFactory.createType_PropertiesAssignment_5ElementType());

	public static final IGrammarAwareElementType Type_PropertiesPropertyParserRuleCall_5_0_ELEMENT_TYPE = associate(TypeFactory.createType_PropertiesPropertyParserRuleCall_5_0ElementType());

	public static final IGrammarAwareElementType Type_UnresolvedProxyPropertyAssignment_6_ELEMENT_TYPE = associate(TypeFactory.createType_UnresolvedProxyPropertyAssignment_6ElementType());

	public static final IGrammarAwareElementType Type_UnresolvedProxyPropertyUnresolvedProxyPropertyParserRuleCall_6_0_ELEMENT_TYPE = associate(TypeFactory.createType_UnresolvedProxyPropertyUnresolvedProxyPropertyParserRuleCall_6_0ElementType());

	public static final IGrammarAwareElementType Type_RightCurlyBracketKeyword_7_ELEMENT_TYPE = associate(TypeFactory.createType_RightCurlyBracketKeyword_7ElementType());

	private static class PropertyFactory {
		public static IGrammarAwareElementType createPropertyElementType() {
			return new IGrammarAwareElementType("Property_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPropertyRule());
		}
		public static IGrammarAwareElementType createProperty_GroupElementType() {
			return new IGrammarAwareElementType("Property_Group_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPropertyAccess().getGroup());
		}
		public static IGrammarAwareElementType createProperty_TypeAssignment_0ElementType() {
			return new IGrammarAwareElementType("Property_TypeAssignment_0_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPropertyAccess().getTypeAssignment_0());
		}
		public static IGrammarAwareElementType createProperty_TypeTypeCrossReference_0_0ElementType() {
			return new IGrammarAwareElementType("Property_TypeTypeCrossReference_0_0_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPropertyAccess().getTypeTypeCrossReference_0_0());
		}
		public static IGrammarAwareElementType createProperty_TypeTypeIDTerminalRuleCall_0_0_1ElementType() {
			return new IGrammarAwareElementType("Property_TypeTypeIDTerminalRuleCall_0_0_1_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPropertyAccess().getTypeTypeIDTerminalRuleCall_0_0_1());
		}
		public static IGrammarAwareElementType createProperty_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Property_NameAssignment_1_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPropertyAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createProperty_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Property_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPropertyAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createProperty_SemicolonKeyword_2ElementType() {
			return new IGrammarAwareElementType("Property_SemicolonKeyword_2_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPropertyAccess().getSemicolonKeyword_2());
		}
	}

	public static final IGrammarAwareElementType Property_ELEMENT_TYPE = associate(PropertyFactory.createPropertyElementType());

	public static final IGrammarAwareElementType Property_Group_ELEMENT_TYPE = associate(PropertyFactory.createProperty_GroupElementType());

	public static final IGrammarAwareElementType Property_TypeAssignment_0_ELEMENT_TYPE = associate(PropertyFactory.createProperty_TypeAssignment_0ElementType());

	public static final IGrammarAwareElementType Property_TypeTypeCrossReference_0_0_ELEMENT_TYPE = associate(PropertyFactory.createProperty_TypeTypeCrossReference_0_0ElementType());

	public static final IGrammarAwareElementType Property_TypeTypeIDTerminalRuleCall_0_0_1_ELEMENT_TYPE = associate(PropertyFactory.createProperty_TypeTypeIDTerminalRuleCall_0_0_1ElementType());

	public static final IGrammarAwareElementType Property_NameAssignment_1_ELEMENT_TYPE = associate(PropertyFactory.createProperty_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Property_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(PropertyFactory.createProperty_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Property_SemicolonKeyword_2_ELEMENT_TYPE = associate(PropertyFactory.createProperty_SemicolonKeyword_2ElementType());

	private static class UnresolvedProxyPropertyFactory {
		public static IGrammarAwareElementType createUnresolvedProxyPropertyElementType() {
			return new IGrammarAwareElementType("UnresolvedProxyProperty_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnresolvedProxyPropertyRule());
		}
		public static IGrammarAwareElementType createUnresolvedProxyProperty_GroupElementType() {
			return new IGrammarAwareElementType("UnresolvedProxyProperty_Group_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnresolvedProxyPropertyAccess().getGroup());
		}
		public static IGrammarAwareElementType createUnresolvedProxyProperty_UnresolvedKeyword_0ElementType() {
			return new IGrammarAwareElementType("UnresolvedProxyProperty_UnresolvedKeyword_0_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnresolvedProxyPropertyAccess().getUnresolvedKeyword_0());
		}
		public static IGrammarAwareElementType createUnresolvedProxyProperty_TypeAssignment_1ElementType() {
			return new IGrammarAwareElementType("UnresolvedProxyProperty_TypeAssignment_1_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnresolvedProxyPropertyAccess().getTypeAssignment_1());
		}
		public static IGrammarAwareElementType createUnresolvedProxyProperty_TypeTypeCrossReference_1_0ElementType() {
			return new IGrammarAwareElementType("UnresolvedProxyProperty_TypeTypeCrossReference_1_0_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnresolvedProxyPropertyAccess().getTypeTypeCrossReference_1_0());
		}
		public static IGrammarAwareElementType createUnresolvedProxyProperty_TypeTypeIDTerminalRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("UnresolvedProxyProperty_TypeTypeIDTerminalRuleCall_1_0_1_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnresolvedProxyPropertyAccess().getTypeTypeIDTerminalRuleCall_1_0_1());
		}
		public static IGrammarAwareElementType createUnresolvedProxyProperty_NameAssignment_2ElementType() {
			return new IGrammarAwareElementType("UnresolvedProxyProperty_NameAssignment_2_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnresolvedProxyPropertyAccess().getNameAssignment_2());
		}
		public static IGrammarAwareElementType createUnresolvedProxyProperty_NameIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("UnresolvedProxyProperty_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnresolvedProxyPropertyAccess().getNameIDTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createUnresolvedProxyProperty_SemicolonKeyword_3ElementType() {
			return new IGrammarAwareElementType("UnresolvedProxyProperty_SemicolonKeyword_3_ELEMENT_TYPE", LazyLinkingTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnresolvedProxyPropertyAccess().getSemicolonKeyword_3());
		}
	}

	public static final IGrammarAwareElementType UnresolvedProxyProperty_ELEMENT_TYPE = associate(UnresolvedProxyPropertyFactory.createUnresolvedProxyPropertyElementType());

	public static final IGrammarAwareElementType UnresolvedProxyProperty_Group_ELEMENT_TYPE = associate(UnresolvedProxyPropertyFactory.createUnresolvedProxyProperty_GroupElementType());

	public static final IGrammarAwareElementType UnresolvedProxyProperty_UnresolvedKeyword_0_ELEMENT_TYPE = associate(UnresolvedProxyPropertyFactory.createUnresolvedProxyProperty_UnresolvedKeyword_0ElementType());

	public static final IGrammarAwareElementType UnresolvedProxyProperty_TypeAssignment_1_ELEMENT_TYPE = associate(UnresolvedProxyPropertyFactory.createUnresolvedProxyProperty_TypeAssignment_1ElementType());

	public static final IGrammarAwareElementType UnresolvedProxyProperty_TypeTypeCrossReference_1_0_ELEMENT_TYPE = associate(UnresolvedProxyPropertyFactory.createUnresolvedProxyProperty_TypeTypeCrossReference_1_0ElementType());

	public static final IGrammarAwareElementType UnresolvedProxyProperty_TypeTypeIDTerminalRuleCall_1_0_1_ELEMENT_TYPE = associate(UnresolvedProxyPropertyFactory.createUnresolvedProxyProperty_TypeTypeIDTerminalRuleCall_1_0_1ElementType());

	public static final IGrammarAwareElementType UnresolvedProxyProperty_NameAssignment_2_ELEMENT_TYPE = associate(UnresolvedProxyPropertyFactory.createUnresolvedProxyProperty_NameAssignment_2ElementType());

	public static final IGrammarAwareElementType UnresolvedProxyProperty_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(UnresolvedProxyPropertyFactory.createUnresolvedProxyProperty_NameIDTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType UnresolvedProxyProperty_SemicolonKeyword_3_ELEMENT_TYPE = associate(UnresolvedProxyPropertyFactory.createUnresolvedProxyProperty_SemicolonKeyword_3ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getModelElementType() {
		return Model_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_TypesAssignmentElementType() {
		return Model_TypesAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_TypesTypeParserRuleCall_0ElementType() {
		return Model_TypesTypeParserRuleCall_0_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getType_Group_2ElementType() {
		return Type_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_ExtendsKeyword_2_0ElementType() {
		return Type_ExtendsKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_ExtendsAssignment_2_1ElementType() {
		return Type_ExtendsAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_ExtendsTypeCrossReference_2_1_0ElementType() {
		return Type_ExtendsTypeCrossReference_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_ExtendsTypeIDTerminalRuleCall_2_1_0_1ElementType() {
		return Type_ExtendsTypeIDTerminalRuleCall_2_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_FullStopKeyword_2_2ElementType() {
		return Type_FullStopKeyword_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_ParentIdAssignment_2_3ElementType() {
		return Type_ParentIdAssignment_2_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_ParentIdPropertyCrossReference_2_3_0ElementType() {
		return Type_ParentIdPropertyCrossReference_2_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_ParentIdPropertyIDTerminalRuleCall_2_3_0_1ElementType() {
		return Type_ParentIdPropertyIDTerminalRuleCall_2_3_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_Group_3ElementType() {
		return Type_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_ForKeyword_3_0ElementType() {
		return Type_ForKeyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_ParentIdAssignment_3_1ElementType() {
		return Type_ParentIdAssignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_ParentIdPropertyCrossReference_3_1_0ElementType() {
		return Type_ParentIdPropertyCrossReference_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_ParentIdPropertyIDTerminalRuleCall_3_1_0_1ElementType() {
		return Type_ParentIdPropertyIDTerminalRuleCall_3_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_InKeyword_3_2ElementType() {
		return Type_InKeyword_3_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_ExtendsAssignment_3_3ElementType() {
		return Type_ExtendsAssignment_3_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_ExtendsTypeCrossReference_3_3_0ElementType() {
		return Type_ExtendsTypeCrossReference_3_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_ExtendsTypeIDTerminalRuleCall_3_3_0_1ElementType() {
		return Type_ExtendsTypeIDTerminalRuleCall_3_3_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_LeftCurlyBracketKeyword_4ElementType() {
		return Type_LeftCurlyBracketKeyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_PropertiesAssignment_5ElementType() {
		return Type_PropertiesAssignment_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_PropertiesPropertyParserRuleCall_5_0ElementType() {
		return Type_PropertiesPropertyParserRuleCall_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_UnresolvedProxyPropertyAssignment_6ElementType() {
		return Type_UnresolvedProxyPropertyAssignment_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_UnresolvedProxyPropertyUnresolvedProxyPropertyParserRuleCall_6_0ElementType() {
		return Type_UnresolvedProxyPropertyUnresolvedProxyPropertyParserRuleCall_6_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_RightCurlyBracketKeyword_7ElementType() {
		return Type_RightCurlyBracketKeyword_7_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getProperty_TypeTypeIDTerminalRuleCall_0_0_1ElementType() {
		return Property_TypeTypeIDTerminalRuleCall_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getProperty_NameAssignment_1ElementType() {
		return Property_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getProperty_NameIDTerminalRuleCall_1_0ElementType() {
		return Property_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getProperty_SemicolonKeyword_2ElementType() {
		return Property_SemicolonKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnresolvedProxyPropertyElementType() {
		return UnresolvedProxyProperty_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnresolvedProxyProperty_GroupElementType() {
		return UnresolvedProxyProperty_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnresolvedProxyProperty_UnresolvedKeyword_0ElementType() {
		return UnresolvedProxyProperty_UnresolvedKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnresolvedProxyProperty_TypeAssignment_1ElementType() {
		return UnresolvedProxyProperty_TypeAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnresolvedProxyProperty_TypeTypeCrossReference_1_0ElementType() {
		return UnresolvedProxyProperty_TypeTypeCrossReference_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnresolvedProxyProperty_TypeTypeIDTerminalRuleCall_1_0_1ElementType() {
		return UnresolvedProxyProperty_TypeTypeIDTerminalRuleCall_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnresolvedProxyProperty_NameAssignment_2ElementType() {
		return UnresolvedProxyProperty_NameAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnresolvedProxyProperty_NameIDTerminalRuleCall_2_0ElementType() {
		return UnresolvedProxyProperty_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnresolvedProxyProperty_SemicolonKeyword_3ElementType() {
		return UnresolvedProxyProperty_SemicolonKeyword_3_ELEMENT_TYPE;
	}

}
