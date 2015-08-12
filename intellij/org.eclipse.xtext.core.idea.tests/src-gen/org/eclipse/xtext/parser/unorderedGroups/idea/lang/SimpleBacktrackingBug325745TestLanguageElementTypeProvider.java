package org.eclipse.xtext.parser.unorderedGroups.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.psi.impl.SimpleBacktrackingBug325745TestLanguageFileImpl;
import org.eclipse.xtext.parser.unorderedGroups.services.SimpleBacktrackingBug325745TestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class SimpleBacktrackingBug325745TestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<SimpleBacktrackingBug325745TestLanguageFileImpl>>(SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final SimpleBacktrackingBug325745TestLanguageGrammarAccess GRAMMAR_ACCESS = SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE.getInstance(SimpleBacktrackingBug325745TestLanguageGrammarAccess.class);

	private static class DelegateModelFactory {
		public static IGrammarAwareElementType createDelegateModelElementType() {
			return new IGrammarAwareElementType("DelegateModel_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDelegateModelRule());
		}
		public static IGrammarAwareElementType createDelegateModel_ModelParserRuleCallElementType() {
			return new IGrammarAwareElementType("DelegateModel_ModelParserRuleCall_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDelegateModelAccess().getModelParserRuleCall());
		}
	}

	public static final IGrammarAwareElementType DelegateModel_ELEMENT_TYPE = associate(DelegateModelFactory.createDelegateModelElementType());

	public static final IGrammarAwareElementType DelegateModel_ModelParserRuleCall_ELEMENT_TYPE = associate(DelegateModelFactory.createDelegateModel_ModelParserRuleCallElementType());

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_GroupElementType() {
			return new IGrammarAwareElementType("Model_Group_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup());
		}
		public static IGrammarAwareElementType createModel_ModelAction_0ElementType() {
			return new IGrammarAwareElementType("Model_ModelAction_0_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getModelAction_0());
		}
		public static IGrammarAwareElementType createModel_FieldsAssignment_1ElementType() {
			return new IGrammarAwareElementType("Model_FieldsAssignment_1_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFieldsAssignment_1());
		}
		public static IGrammarAwareElementType createModel_FieldsElementParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Model_FieldsElementParserRuleCall_1_0_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFieldsElementParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Group_ELEMENT_TYPE = associate(ModelFactory.createModel_GroupElementType());

	public static final IGrammarAwareElementType Model_ModelAction_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ModelAction_0ElementType());

	public static final IGrammarAwareElementType Model_FieldsAssignment_1_ELEMENT_TYPE = associate(ModelFactory.createModel_FieldsAssignment_1ElementType());

	public static final IGrammarAwareElementType Model_FieldsElementParserRuleCall_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FieldsElementParserRuleCall_1_0ElementType());

	private static class ElementFactory {
		public static IGrammarAwareElementType createElementElementType() {
			return new IGrammarAwareElementType("Element_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementRule());
		}
		public static IGrammarAwareElementType createElement_GroupElementType() {
			return new IGrammarAwareElementType("Element_Group_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getGroup());
		}
		public static IGrammarAwareElementType createElement_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("Element_NameAssignment_0_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createElement_NameIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Element_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getNameIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createElement_DataTypeAssignment_1ElementType() {
			return new IGrammarAwareElementType("Element_DataTypeAssignment_1_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getDataTypeAssignment_1());
		}
		public static IGrammarAwareElementType createElement_DataTypeDataTypeParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Element_DataTypeDataTypeParserRuleCall_1_0_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getDataTypeDataTypeParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createElement_ExpressionAssignment_2ElementType() {
			return new IGrammarAwareElementType("Element_ExpressionAssignment_2_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getExpressionAssignment_2());
		}
		public static IGrammarAwareElementType createElement_ExpressionExpressionParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Element_ExpressionExpressionParserRuleCall_2_0_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getExpressionExpressionParserRuleCall_2_0());
		}
		public static IGrammarAwareElementType createElement_FullStopKeyword_3ElementType() {
			return new IGrammarAwareElementType("Element_FullStopKeyword_3_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getFullStopKeyword_3());
		}
	}

	public static final IGrammarAwareElementType Element_ELEMENT_TYPE = associate(ElementFactory.createElementElementType());

	public static final IGrammarAwareElementType Element_Group_ELEMENT_TYPE = associate(ElementFactory.createElement_GroupElementType());

	public static final IGrammarAwareElementType Element_NameAssignment_0_ELEMENT_TYPE = associate(ElementFactory.createElement_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType Element_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(ElementFactory.createElement_NameIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Element_DataTypeAssignment_1_ELEMENT_TYPE = associate(ElementFactory.createElement_DataTypeAssignment_1ElementType());

	public static final IGrammarAwareElementType Element_DataTypeDataTypeParserRuleCall_1_0_ELEMENT_TYPE = associate(ElementFactory.createElement_DataTypeDataTypeParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Element_ExpressionAssignment_2_ELEMENT_TYPE = associate(ElementFactory.createElement_ExpressionAssignment_2ElementType());

	public static final IGrammarAwareElementType Element_ExpressionExpressionParserRuleCall_2_0_ELEMENT_TYPE = associate(ElementFactory.createElement_ExpressionExpressionParserRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType Element_FullStopKeyword_3_ELEMENT_TYPE = associate(ElementFactory.createElement_FullStopKeyword_3ElementType());

	private static class DataTypeFactory {
		public static IGrammarAwareElementType createDataTypeElementType() {
			return new IGrammarAwareElementType("DataType_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypeRule());
		}
		public static IGrammarAwareElementType createDataType_GroupElementType() {
			return new IGrammarAwareElementType("DataType_Group_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypeAccess().getGroup());
		}
		public static IGrammarAwareElementType createDataType_BaseTypeAssignment_0ElementType() {
			return new IGrammarAwareElementType("DataType_BaseTypeAssignment_0_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypeAccess().getBaseTypeAssignment_0());
		}
		public static IGrammarAwareElementType createDataType_BaseTypeIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("DataType_BaseTypeIDTerminalRuleCall_0_0_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypeAccess().getBaseTypeIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createDataType_Group_1ElementType() {
			return new IGrammarAwareElementType("DataType_Group_1_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypeAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createDataType_ColonEqualsSignKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("DataType_ColonEqualsSignKeyword_1_0_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypeAccess().getColonEqualsSignKeyword_1_0());
		}
		public static IGrammarAwareElementType createDataType_DefaultValueAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("DataType_DefaultValueAssignment_1_1_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypeAccess().getDefaultValueAssignment_1_1());
		}
		public static IGrammarAwareElementType createDataType_DefaultValueSTRINGTerminalRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("DataType_DefaultValueSTRINGTerminalRuleCall_1_1_0_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypeAccess().getDefaultValueSTRINGTerminalRuleCall_1_1_0());
		}
	}

	public static final IGrammarAwareElementType DataType_ELEMENT_TYPE = associate(DataTypeFactory.createDataTypeElementType());

	public static final IGrammarAwareElementType DataType_Group_ELEMENT_TYPE = associate(DataTypeFactory.createDataType_GroupElementType());

	public static final IGrammarAwareElementType DataType_BaseTypeAssignment_0_ELEMENT_TYPE = associate(DataTypeFactory.createDataType_BaseTypeAssignment_0ElementType());

	public static final IGrammarAwareElementType DataType_BaseTypeIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(DataTypeFactory.createDataType_BaseTypeIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType DataType_Group_1_ELEMENT_TYPE = associate(DataTypeFactory.createDataType_Group_1ElementType());

	public static final IGrammarAwareElementType DataType_ColonEqualsSignKeyword_1_0_ELEMENT_TYPE = associate(DataTypeFactory.createDataType_ColonEqualsSignKeyword_1_0ElementType());

	public static final IGrammarAwareElementType DataType_DefaultValueAssignment_1_1_ELEMENT_TYPE = associate(DataTypeFactory.createDataType_DefaultValueAssignment_1_1ElementType());

	public static final IGrammarAwareElementType DataType_DefaultValueSTRINGTerminalRuleCall_1_1_0_ELEMENT_TYPE = associate(DataTypeFactory.createDataType_DefaultValueSTRINGTerminalRuleCall_1_1_0ElementType());

	private static class ExpressionFactory {
		public static IGrammarAwareElementType createExpressionElementType() {
			return new IGrammarAwareElementType("Expression_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionRule());
		}
		public static IGrammarAwareElementType createExpression_GroupElementType() {
			return new IGrammarAwareElementType("Expression_Group_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getGroup());
		}
		public static IGrammarAwareElementType createExpression_ExpressionAction_0ElementType() {
			return new IGrammarAwareElementType("Expression_ExpressionAction_0_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getExpressionAction_0());
		}
		public static IGrammarAwareElementType createExpression_UnorderedGroup_1ElementType() {
			return new IGrammarAwareElementType("Expression_UnorderedGroup_1_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getUnorderedGroup_1());
		}
		public static IGrammarAwareElementType createExpression_LeftSquareBracketKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Expression_LeftSquareBracketKeyword_1_0_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getLeftSquareBracketKeyword_1_0());
		}
		public static IGrammarAwareElementType createExpression_PrefixAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Expression_PrefixAssignment_1_1_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getPrefixAssignment_1_1());
		}
		public static IGrammarAwareElementType createExpression_PrefixSTRINGTerminalRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("Expression_PrefixSTRINGTerminalRuleCall_1_1_0_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getPrefixSTRINGTerminalRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createExpression_Group_2ElementType() {
			return new IGrammarAwareElementType("Expression_Group_2_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createExpression_LeftSquareBracketKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Expression_LeftSquareBracketKeyword_2_0_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getLeftSquareBracketKeyword_2_0());
		}
		public static IGrammarAwareElementType createExpression_TermsAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("Expression_TermsAssignment_2_1_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getTermsAssignment_2_1());
		}
		public static IGrammarAwareElementType createExpression_TermsSimpleTermParserRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("Expression_TermsSimpleTermParserRuleCall_2_1_0_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getTermsSimpleTermParserRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createExpression_RightSquareBracketKeyword_2_2ElementType() {
			return new IGrammarAwareElementType("Expression_RightSquareBracketKeyword_2_2_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getRightSquareBracketKeyword_2_2());
		}
		public static IGrammarAwareElementType createExpression_UnorderedGroup_3ElementType() {
			return new IGrammarAwareElementType("Expression_UnorderedGroup_3_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getUnorderedGroup_3());
		}
		public static IGrammarAwareElementType createExpression_RightSquareBracketKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("Expression_RightSquareBracketKeyword_3_0_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getRightSquareBracketKeyword_3_0());
		}
		public static IGrammarAwareElementType createExpression_PostfixAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("Expression_PostfixAssignment_3_1_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getPostfixAssignment_3_1());
		}
		public static IGrammarAwareElementType createExpression_PostfixSTRINGTerminalRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("Expression_PostfixSTRINGTerminalRuleCall_3_1_0_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getPostfixSTRINGTerminalRuleCall_3_1_0());
		}
	}

	public static final IGrammarAwareElementType Expression_ELEMENT_TYPE = associate(ExpressionFactory.createExpressionElementType());

	public static final IGrammarAwareElementType Expression_Group_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_GroupElementType());

	public static final IGrammarAwareElementType Expression_ExpressionAction_0_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_ExpressionAction_0ElementType());

	public static final IGrammarAwareElementType Expression_UnorderedGroup_1_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_UnorderedGroup_1ElementType());

	public static final IGrammarAwareElementType Expression_LeftSquareBracketKeyword_1_0_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_LeftSquareBracketKeyword_1_0ElementType());

	public static final IGrammarAwareElementType Expression_PrefixAssignment_1_1_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_PrefixAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Expression_PrefixSTRINGTerminalRuleCall_1_1_0_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_PrefixSTRINGTerminalRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType Expression_Group_2_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_Group_2ElementType());

	public static final IGrammarAwareElementType Expression_LeftSquareBracketKeyword_2_0_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_LeftSquareBracketKeyword_2_0ElementType());

	public static final IGrammarAwareElementType Expression_TermsAssignment_2_1_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_TermsAssignment_2_1ElementType());

	public static final IGrammarAwareElementType Expression_TermsSimpleTermParserRuleCall_2_1_0_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_TermsSimpleTermParserRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType Expression_RightSquareBracketKeyword_2_2_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_RightSquareBracketKeyword_2_2ElementType());

	public static final IGrammarAwareElementType Expression_UnorderedGroup_3_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_UnorderedGroup_3ElementType());

	public static final IGrammarAwareElementType Expression_RightSquareBracketKeyword_3_0_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_RightSquareBracketKeyword_3_0ElementType());

	public static final IGrammarAwareElementType Expression_PostfixAssignment_3_1_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_PostfixAssignment_3_1ElementType());

	public static final IGrammarAwareElementType Expression_PostfixSTRINGTerminalRuleCall_3_1_0_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_PostfixSTRINGTerminalRuleCall_3_1_0ElementType());

	private static class SimpleTermFactory {
		public static IGrammarAwareElementType createSimpleTermElementType() {
			return new IGrammarAwareElementType("SimpleTerm_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleTermRule());
		}
		public static IGrammarAwareElementType createSimpleTerm_AlternativesElementType() {
			return new IGrammarAwareElementType("SimpleTerm_Alternatives_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleTermAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createSimpleTerm_Group_0ElementType() {
			return new IGrammarAwareElementType("SimpleTerm_Group_0_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleTermAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createSimpleTerm_LineCountAssignment_0_0ElementType() {
			return new IGrammarAwareElementType("SimpleTerm_LineCountAssignment_0_0_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleTermAccess().getLineCountAssignment_0_0());
		}
		public static IGrammarAwareElementType createSimpleTerm_LineCountINTTerminalRuleCall_0_0_0ElementType() {
			return new IGrammarAwareElementType("SimpleTerm_LineCountINTTerminalRuleCall_0_0_0_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleTermAccess().getLineCountINTTerminalRuleCall_0_0_0());
		}
		public static IGrammarAwareElementType createSimpleTerm_AsteriskKeyword_0_1ElementType() {
			return new IGrammarAwareElementType("SimpleTerm_AsteriskKeyword_0_1_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleTermAccess().getAsteriskKeyword_0_1());
		}
		public static IGrammarAwareElementType createSimpleTerm_CharCountAssignment_0_2ElementType() {
			return new IGrammarAwareElementType("SimpleTerm_CharCountAssignment_0_2_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleTermAccess().getCharCountAssignment_0_2());
		}
		public static IGrammarAwareElementType createSimpleTerm_CharCountINTTerminalRuleCall_0_2_0ElementType() {
			return new IGrammarAwareElementType("SimpleTerm_CharCountINTTerminalRuleCall_0_2_0_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleTermAccess().getCharCountINTTerminalRuleCall_0_2_0());
		}
		public static IGrammarAwareElementType createSimpleTerm_ExclamationMarkKeyword_0_3ElementType() {
			return new IGrammarAwareElementType("SimpleTerm_ExclamationMarkKeyword_0_3_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleTermAccess().getExclamationMarkKeyword_0_3());
		}
		public static IGrammarAwareElementType createSimpleTerm_CharSetAssignment_0_4ElementType() {
			return new IGrammarAwareElementType("SimpleTerm_CharSetAssignment_0_4_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleTermAccess().getCharSetAssignment_0_4());
		}
		public static IGrammarAwareElementType createSimpleTerm_CharSetIDTerminalRuleCall_0_4_0ElementType() {
			return new IGrammarAwareElementType("SimpleTerm_CharSetIDTerminalRuleCall_0_4_0_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleTermAccess().getCharSetIDTerminalRuleCall_0_4_0());
		}
		public static IGrammarAwareElementType createSimpleTerm_RefCharAssignment_1ElementType() {
			return new IGrammarAwareElementType("SimpleTerm_RefCharAssignment_1_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleTermAccess().getRefCharAssignment_1());
		}
		public static IGrammarAwareElementType createSimpleTerm_RefCharIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("SimpleTerm_RefCharIDTerminalRuleCall_1_0_ELEMENT_TYPE", SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleTermAccess().getRefCharIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType SimpleTerm_ELEMENT_TYPE = associate(SimpleTermFactory.createSimpleTermElementType());

	public static final IGrammarAwareElementType SimpleTerm_Alternatives_ELEMENT_TYPE = associate(SimpleTermFactory.createSimpleTerm_AlternativesElementType());

	public static final IGrammarAwareElementType SimpleTerm_Group_0_ELEMENT_TYPE = associate(SimpleTermFactory.createSimpleTerm_Group_0ElementType());

	public static final IGrammarAwareElementType SimpleTerm_LineCountAssignment_0_0_ELEMENT_TYPE = associate(SimpleTermFactory.createSimpleTerm_LineCountAssignment_0_0ElementType());

	public static final IGrammarAwareElementType SimpleTerm_LineCountINTTerminalRuleCall_0_0_0_ELEMENT_TYPE = associate(SimpleTermFactory.createSimpleTerm_LineCountINTTerminalRuleCall_0_0_0ElementType());

	public static final IGrammarAwareElementType SimpleTerm_AsteriskKeyword_0_1_ELEMENT_TYPE = associate(SimpleTermFactory.createSimpleTerm_AsteriskKeyword_0_1ElementType());

	public static final IGrammarAwareElementType SimpleTerm_CharCountAssignment_0_2_ELEMENT_TYPE = associate(SimpleTermFactory.createSimpleTerm_CharCountAssignment_0_2ElementType());

	public static final IGrammarAwareElementType SimpleTerm_CharCountINTTerminalRuleCall_0_2_0_ELEMENT_TYPE = associate(SimpleTermFactory.createSimpleTerm_CharCountINTTerminalRuleCall_0_2_0ElementType());

	public static final IGrammarAwareElementType SimpleTerm_ExclamationMarkKeyword_0_3_ELEMENT_TYPE = associate(SimpleTermFactory.createSimpleTerm_ExclamationMarkKeyword_0_3ElementType());

	public static final IGrammarAwareElementType SimpleTerm_CharSetAssignment_0_4_ELEMENT_TYPE = associate(SimpleTermFactory.createSimpleTerm_CharSetAssignment_0_4ElementType());

	public static final IGrammarAwareElementType SimpleTerm_CharSetIDTerminalRuleCall_0_4_0_ELEMENT_TYPE = associate(SimpleTermFactory.createSimpleTerm_CharSetIDTerminalRuleCall_0_4_0ElementType());

	public static final IGrammarAwareElementType SimpleTerm_RefCharAssignment_1_ELEMENT_TYPE = associate(SimpleTermFactory.createSimpleTerm_RefCharAssignment_1ElementType());

	public static final IGrammarAwareElementType SimpleTerm_RefCharIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(SimpleTermFactory.createSimpleTerm_RefCharIDTerminalRuleCall_1_0ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getDelegateModelElementType() {
		return DelegateModel_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDelegateModel_ModelParserRuleCallElementType() {
		return DelegateModel_ModelParserRuleCall_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModelElementType() {
		return Model_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_GroupElementType() {
		return Model_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ModelAction_0ElementType() {
		return Model_ModelAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FieldsAssignment_1ElementType() {
		return Model_FieldsAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FieldsElementParserRuleCall_1_0ElementType() {
		return Model_FieldsElementParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElementElementType() {
		return Element_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_GroupElementType() {
		return Element_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_NameAssignment_0ElementType() {
		return Element_NameAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_NameIDTerminalRuleCall_0_0ElementType() {
		return Element_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_DataTypeAssignment_1ElementType() {
		return Element_DataTypeAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_DataTypeDataTypeParserRuleCall_1_0ElementType() {
		return Element_DataTypeDataTypeParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ExpressionAssignment_2ElementType() {
		return Element_ExpressionAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_ExpressionExpressionParserRuleCall_2_0ElementType() {
		return Element_ExpressionExpressionParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_FullStopKeyword_3ElementType() {
		return Element_FullStopKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataTypeElementType() {
		return DataType_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataType_GroupElementType() {
		return DataType_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataType_BaseTypeAssignment_0ElementType() {
		return DataType_BaseTypeAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataType_BaseTypeIDTerminalRuleCall_0_0ElementType() {
		return DataType_BaseTypeIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataType_Group_1ElementType() {
		return DataType_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataType_ColonEqualsSignKeyword_1_0ElementType() {
		return DataType_ColonEqualsSignKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataType_DefaultValueAssignment_1_1ElementType() {
		return DataType_DefaultValueAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataType_DefaultValueSTRINGTerminalRuleCall_1_1_0ElementType() {
		return DataType_DefaultValueSTRINGTerminalRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpressionElementType() {
		return Expression_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_GroupElementType() {
		return Expression_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_ExpressionAction_0ElementType() {
		return Expression_ExpressionAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_UnorderedGroup_1ElementType() {
		return Expression_UnorderedGroup_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_LeftSquareBracketKeyword_1_0ElementType() {
		return Expression_LeftSquareBracketKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_PrefixAssignment_1_1ElementType() {
		return Expression_PrefixAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_PrefixSTRINGTerminalRuleCall_1_1_0ElementType() {
		return Expression_PrefixSTRINGTerminalRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_Group_2ElementType() {
		return Expression_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_LeftSquareBracketKeyword_2_0ElementType() {
		return Expression_LeftSquareBracketKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_TermsAssignment_2_1ElementType() {
		return Expression_TermsAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_TermsSimpleTermParserRuleCall_2_1_0ElementType() {
		return Expression_TermsSimpleTermParserRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_RightSquareBracketKeyword_2_2ElementType() {
		return Expression_RightSquareBracketKeyword_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_UnorderedGroup_3ElementType() {
		return Expression_UnorderedGroup_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_RightSquareBracketKeyword_3_0ElementType() {
		return Expression_RightSquareBracketKeyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_PostfixAssignment_3_1ElementType() {
		return Expression_PostfixAssignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_PostfixSTRINGTerminalRuleCall_3_1_0ElementType() {
		return Expression_PostfixSTRINGTerminalRuleCall_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleTermElementType() {
		return SimpleTerm_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleTerm_AlternativesElementType() {
		return SimpleTerm_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleTerm_Group_0ElementType() {
		return SimpleTerm_Group_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleTerm_LineCountAssignment_0_0ElementType() {
		return SimpleTerm_LineCountAssignment_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleTerm_LineCountINTTerminalRuleCall_0_0_0ElementType() {
		return SimpleTerm_LineCountINTTerminalRuleCall_0_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleTerm_AsteriskKeyword_0_1ElementType() {
		return SimpleTerm_AsteriskKeyword_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleTerm_CharCountAssignment_0_2ElementType() {
		return SimpleTerm_CharCountAssignment_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleTerm_CharCountINTTerminalRuleCall_0_2_0ElementType() {
		return SimpleTerm_CharCountINTTerminalRuleCall_0_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleTerm_ExclamationMarkKeyword_0_3ElementType() {
		return SimpleTerm_ExclamationMarkKeyword_0_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleTerm_CharSetAssignment_0_4ElementType() {
		return SimpleTerm_CharSetAssignment_0_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleTerm_CharSetIDTerminalRuleCall_0_4_0ElementType() {
		return SimpleTerm_CharSetIDTerminalRuleCall_0_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleTerm_RefCharAssignment_1ElementType() {
		return SimpleTerm_RefCharAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleTerm_RefCharIDTerminalRuleCall_1_0ElementType() {
		return SimpleTerm_RefCharIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

}
