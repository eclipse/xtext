package org.eclipse.xtext.parser.antlr.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.antlr.idea.lang.psi.impl.Bug296889ExTestLanguageFileImpl;
import org.eclipse.xtext.parser.antlr.services.Bug296889ExTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class Bug296889ExTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<Bug296889ExTestLanguageFileImpl>>(Bug296889ExTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final Bug296889ExTestLanguageGrammarAccess GRAMMAR_ACCESS = Bug296889ExTestLanguageLanguage.INSTANCE.getInstance(Bug296889ExTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_AlternativesElementType() {
			return new IGrammarAwareElementType("Model_Alternatives_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createModel_Group_0ElementType() {
			return new IGrammarAwareElementType("Model_Group_0_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createModel_ModelKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("Model_ModelKeyword_0_0_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getModelKeyword_0_0());
		}
		public static IGrammarAwareElementType createModel_ExpressionsAssignment_0_1ElementType() {
			return new IGrammarAwareElementType("Model_ExpressionsAssignment_0_1_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getExpressionsAssignment_0_1());
		}
		public static IGrammarAwareElementType createModel_ExpressionsExpressionParserRuleCall_0_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ExpressionsExpressionParserRuleCall_0_1_0_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getExpressionsExpressionParserRuleCall_0_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_1ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createModel_DataTypeKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Model_DataTypeKeyword_1_0_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDataTypeKeyword_1_0());
		}
		public static IGrammarAwareElementType createModel_ValuesAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Model_ValuesAssignment_1_1_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValuesAssignment_1_1());
		}
		public static IGrammarAwareElementType createModel_ValuesDataTypeExpressionParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ValuesDataTypeExpressionParserRuleCall_1_1_0_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValuesDataTypeExpressionParserRuleCall_1_1_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Alternatives_ELEMENT_TYPE = associate(ModelFactory.createModel_AlternativesElementType());

	public static final IGrammarAwareElementType Model_Group_0_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_0ElementType());

	public static final IGrammarAwareElementType Model_ModelKeyword_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ModelKeyword_0_0ElementType());

	public static final IGrammarAwareElementType Model_ExpressionsAssignment_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ExpressionsAssignment_0_1ElementType());

	public static final IGrammarAwareElementType Model_ExpressionsExpressionParserRuleCall_0_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ExpressionsExpressionParserRuleCall_0_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1ElementType());

	public static final IGrammarAwareElementType Model_DataTypeKeyword_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DataTypeKeyword_1_0ElementType());

	public static final IGrammarAwareElementType Model_ValuesAssignment_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ValuesAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Model_ValuesDataTypeExpressionParserRuleCall_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ValuesDataTypeExpressionParserRuleCall_1_1_0ElementType());

	private static class ExpressionFactory {
		public static IGrammarAwareElementType createExpressionElementType() {
			return new IGrammarAwareElementType("Expression_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionRule());
		}
		public static IGrammarAwareElementType createExpression_AlternativesElementType() {
			return new IGrammarAwareElementType("Expression_Alternatives_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createExpression_PostopParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Expression_PostopParserRuleCall_0_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getPostopParserRuleCall_0());
		}
		public static IGrammarAwareElementType createExpression_PreopParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Expression_PreopParserRuleCall_1_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getPreopParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType Expression_ELEMENT_TYPE = associate(ExpressionFactory.createExpressionElementType());

	public static final IGrammarAwareElementType Expression_Alternatives_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_AlternativesElementType());

	public static final IGrammarAwareElementType Expression_PostopParserRuleCall_0_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_PostopParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Expression_PreopParserRuleCall_1_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_PreopParserRuleCall_1ElementType());

	private static class PreopFactory {
		public static IGrammarAwareElementType createPreopElementType() {
			return new IGrammarAwareElementType("Preop_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPreopRule());
		}
		public static IGrammarAwareElementType createPreop_GroupElementType() {
			return new IGrammarAwareElementType("Preop_Group_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPreopAccess().getGroup());
		}
		public static IGrammarAwareElementType createPreop_PreopAction_0ElementType() {
			return new IGrammarAwareElementType("Preop_PreopAction_0_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPreopAccess().getPreopAction_0());
		}
		public static IGrammarAwareElementType createPreop_FunctionNameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Preop_FunctionNameAssignment_1_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPreopAccess().getFunctionNameAssignment_1());
		}
		public static IGrammarAwareElementType createPreop_FunctionNameHyphenMinusHyphenMinusKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Preop_FunctionNameHyphenMinusHyphenMinusKeyword_1_0_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPreopAccess().getFunctionNameHyphenMinusHyphenMinusKeyword_1_0());
		}
		public static IGrammarAwareElementType createPreop_ExprAssignment_2ElementType() {
			return new IGrammarAwareElementType("Preop_ExprAssignment_2_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPreopAccess().getExprAssignment_2());
		}
		public static IGrammarAwareElementType createPreop_ExprVariableParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Preop_ExprVariableParserRuleCall_2_0_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPreopAccess().getExprVariableParserRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType Preop_ELEMENT_TYPE = associate(PreopFactory.createPreopElementType());

	public static final IGrammarAwareElementType Preop_Group_ELEMENT_TYPE = associate(PreopFactory.createPreop_GroupElementType());

	public static final IGrammarAwareElementType Preop_PreopAction_0_ELEMENT_TYPE = associate(PreopFactory.createPreop_PreopAction_0ElementType());

	public static final IGrammarAwareElementType Preop_FunctionNameAssignment_1_ELEMENT_TYPE = associate(PreopFactory.createPreop_FunctionNameAssignment_1ElementType());

	public static final IGrammarAwareElementType Preop_FunctionNameHyphenMinusHyphenMinusKeyword_1_0_ELEMENT_TYPE = associate(PreopFactory.createPreop_FunctionNameHyphenMinusHyphenMinusKeyword_1_0ElementType());

	public static final IGrammarAwareElementType Preop_ExprAssignment_2_ELEMENT_TYPE = associate(PreopFactory.createPreop_ExprAssignment_2ElementType());

	public static final IGrammarAwareElementType Preop_ExprVariableParserRuleCall_2_0_ELEMENT_TYPE = associate(PreopFactory.createPreop_ExprVariableParserRuleCall_2_0ElementType());

	private static class PostopFactory {
		public static IGrammarAwareElementType createPostopElementType() {
			return new IGrammarAwareElementType("Postop_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPostopRule());
		}
		public static IGrammarAwareElementType createPostop_GroupElementType() {
			return new IGrammarAwareElementType("Postop_Group_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPostopAccess().getGroup());
		}
		public static IGrammarAwareElementType createPostop_VariableParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Postop_VariableParserRuleCall_0_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPostopAccess().getVariableParserRuleCall_0());
		}
		public static IGrammarAwareElementType createPostop_Group_1ElementType() {
			return new IGrammarAwareElementType("Postop_Group_1_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPostopAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createPostop_PostopExprAction_1_0ElementType() {
			return new IGrammarAwareElementType("Postop_PostopExprAction_1_0_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPostopAccess().getPostopExprAction_1_0());
		}
		public static IGrammarAwareElementType createPostop_FunctionNameAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Postop_FunctionNameAssignment_1_1_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPostopAccess().getFunctionNameAssignment_1_1());
		}
		public static IGrammarAwareElementType createPostop_FunctionNameHyphenMinusHyphenMinusKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("Postop_FunctionNameHyphenMinusHyphenMinusKeyword_1_1_0_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPostopAccess().getFunctionNameHyphenMinusHyphenMinusKeyword_1_1_0());
		}
	}

	public static final IGrammarAwareElementType Postop_ELEMENT_TYPE = associate(PostopFactory.createPostopElementType());

	public static final IGrammarAwareElementType Postop_Group_ELEMENT_TYPE = associate(PostopFactory.createPostop_GroupElementType());

	public static final IGrammarAwareElementType Postop_VariableParserRuleCall_0_ELEMENT_TYPE = associate(PostopFactory.createPostop_VariableParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Postop_Group_1_ELEMENT_TYPE = associate(PostopFactory.createPostop_Group_1ElementType());

	public static final IGrammarAwareElementType Postop_PostopExprAction_1_0_ELEMENT_TYPE = associate(PostopFactory.createPostop_PostopExprAction_1_0ElementType());

	public static final IGrammarAwareElementType Postop_FunctionNameAssignment_1_1_ELEMENT_TYPE = associate(PostopFactory.createPostop_FunctionNameAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Postop_FunctionNameHyphenMinusHyphenMinusKeyword_1_1_0_ELEMENT_TYPE = associate(PostopFactory.createPostop_FunctionNameHyphenMinusHyphenMinusKeyword_1_1_0ElementType());

	private static class VariableFactory {
		public static IGrammarAwareElementType createVariableElementType() {
			return new IGrammarAwareElementType("Variable_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getVariableRule());
		}
		public static IGrammarAwareElementType createVariable_GroupElementType() {
			return new IGrammarAwareElementType("Variable_Group_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getVariableAccess().getGroup());
		}
		public static IGrammarAwareElementType createVariable_VariableAction_0ElementType() {
			return new IGrammarAwareElementType("Variable_VariableAction_0_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getVariableAccess().getVariableAction_0());
		}
		public static IGrammarAwareElementType createVariable_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Variable_NameAssignment_1_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getVariableAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createVariable_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Variable_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getVariableAccess().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Variable_ELEMENT_TYPE = associate(VariableFactory.createVariableElementType());

	public static final IGrammarAwareElementType Variable_Group_ELEMENT_TYPE = associate(VariableFactory.createVariable_GroupElementType());

	public static final IGrammarAwareElementType Variable_VariableAction_0_ELEMENT_TYPE = associate(VariableFactory.createVariable_VariableAction_0ElementType());

	public static final IGrammarAwareElementType Variable_NameAssignment_1_ELEMENT_TYPE = associate(VariableFactory.createVariable_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Variable_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(VariableFactory.createVariable_NameIDTerminalRuleCall_1_0ElementType());

	private static class DataTypeExpressionFactory {
		public static IGrammarAwareElementType createDataTypeExpressionElementType() {
			return new IGrammarAwareElementType("DataTypeExpression_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypeExpressionRule());
		}
		public static IGrammarAwareElementType createDataTypeExpression_AlternativesElementType() {
			return new IGrammarAwareElementType("DataTypeExpression_Alternatives_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypeExpressionAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createDataTypeExpression_DataTypePostopParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("DataTypeExpression_DataTypePostopParserRuleCall_0_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypeExpressionAccess().getDataTypePostopParserRuleCall_0());
		}
		public static IGrammarAwareElementType createDataTypeExpression_DataTypePreopParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("DataTypeExpression_DataTypePreopParserRuleCall_1_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypeExpressionAccess().getDataTypePreopParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType DataTypeExpression_ELEMENT_TYPE = associate(DataTypeExpressionFactory.createDataTypeExpressionElementType());

	public static final IGrammarAwareElementType DataTypeExpression_Alternatives_ELEMENT_TYPE = associate(DataTypeExpressionFactory.createDataTypeExpression_AlternativesElementType());

	public static final IGrammarAwareElementType DataTypeExpression_DataTypePostopParserRuleCall_0_ELEMENT_TYPE = associate(DataTypeExpressionFactory.createDataTypeExpression_DataTypePostopParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType DataTypeExpression_DataTypePreopParserRuleCall_1_ELEMENT_TYPE = associate(DataTypeExpressionFactory.createDataTypeExpression_DataTypePreopParserRuleCall_1ElementType());

	private static class DataTypePreopFactory {
		public static IGrammarAwareElementType createDataTypePreopElementType() {
			return new IGrammarAwareElementType("DataTypePreop_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypePreopRule());
		}
		public static IGrammarAwareElementType createDataTypePreop_GroupElementType() {
			return new IGrammarAwareElementType("DataTypePreop_Group_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypePreopAccess().getGroup());
		}
		public static IGrammarAwareElementType createDataTypePreop_HyphenMinusHyphenMinusKeyword_0ElementType() {
			return new IGrammarAwareElementType("DataTypePreop_HyphenMinusHyphenMinusKeyword_0_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypePreopAccess().getHyphenMinusHyphenMinusKeyword_0());
		}
		public static IGrammarAwareElementType createDataTypePreop_DataTypeVariableParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("DataTypePreop_DataTypeVariableParserRuleCall_1_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypePreopAccess().getDataTypeVariableParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType DataTypePreop_ELEMENT_TYPE = associate(DataTypePreopFactory.createDataTypePreopElementType());

	public static final IGrammarAwareElementType DataTypePreop_Group_ELEMENT_TYPE = associate(DataTypePreopFactory.createDataTypePreop_GroupElementType());

	public static final IGrammarAwareElementType DataTypePreop_HyphenMinusHyphenMinusKeyword_0_ELEMENT_TYPE = associate(DataTypePreopFactory.createDataTypePreop_HyphenMinusHyphenMinusKeyword_0ElementType());

	public static final IGrammarAwareElementType DataTypePreop_DataTypeVariableParserRuleCall_1_ELEMENT_TYPE = associate(DataTypePreopFactory.createDataTypePreop_DataTypeVariableParserRuleCall_1ElementType());

	private static class DataTypePostopFactory {
		public static IGrammarAwareElementType createDataTypePostopElementType() {
			return new IGrammarAwareElementType("DataTypePostop_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypePostopRule());
		}
		public static IGrammarAwareElementType createDataTypePostop_GroupElementType() {
			return new IGrammarAwareElementType("DataTypePostop_Group_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypePostopAccess().getGroup());
		}
		public static IGrammarAwareElementType createDataTypePostop_DataTypeVariableParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("DataTypePostop_DataTypeVariableParserRuleCall_0_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypePostopAccess().getDataTypeVariableParserRuleCall_0());
		}
		public static IGrammarAwareElementType createDataTypePostop_HyphenMinusHyphenMinusKeyword_1ElementType() {
			return new IGrammarAwareElementType("DataTypePostop_HyphenMinusHyphenMinusKeyword_1_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypePostopAccess().getHyphenMinusHyphenMinusKeyword_1());
		}
	}

	public static final IGrammarAwareElementType DataTypePostop_ELEMENT_TYPE = associate(DataTypePostopFactory.createDataTypePostopElementType());

	public static final IGrammarAwareElementType DataTypePostop_Group_ELEMENT_TYPE = associate(DataTypePostopFactory.createDataTypePostop_GroupElementType());

	public static final IGrammarAwareElementType DataTypePostop_DataTypeVariableParserRuleCall_0_ELEMENT_TYPE = associate(DataTypePostopFactory.createDataTypePostop_DataTypeVariableParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType DataTypePostop_HyphenMinusHyphenMinusKeyword_1_ELEMENT_TYPE = associate(DataTypePostopFactory.createDataTypePostop_HyphenMinusHyphenMinusKeyword_1ElementType());

	private static class DataTypeVariableFactory {
		public static IGrammarAwareElementType createDataTypeVariableElementType() {
			return new IGrammarAwareElementType("DataTypeVariable_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypeVariableRule());
		}
		public static IGrammarAwareElementType createDataTypeVariable_IDTerminalRuleCallElementType() {
			return new IGrammarAwareElementType("DataTypeVariable_IDTerminalRuleCall_ELEMENT_TYPE", Bug296889ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDataTypeVariableAccess().getIDTerminalRuleCall());
		}
	}

	public static final IGrammarAwareElementType DataTypeVariable_ELEMENT_TYPE = associate(DataTypeVariableFactory.createDataTypeVariableElementType());

	public static final IGrammarAwareElementType DataTypeVariable_IDTerminalRuleCall_ELEMENT_TYPE = associate(DataTypeVariableFactory.createDataTypeVariable_IDTerminalRuleCallElementType());

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

	public IGrammarAwareElementType getModel_AlternativesElementType() {
		return Model_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_0ElementType() {
		return Model_Group_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ModelKeyword_0_0ElementType() {
		return Model_ModelKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ExpressionsAssignment_0_1ElementType() {
		return Model_ExpressionsAssignment_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ExpressionsExpressionParserRuleCall_0_1_0ElementType() {
		return Model_ExpressionsExpressionParserRuleCall_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1ElementType() {
		return Model_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DataTypeKeyword_1_0ElementType() {
		return Model_DataTypeKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValuesAssignment_1_1ElementType() {
		return Model_ValuesAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValuesDataTypeExpressionParserRuleCall_1_1_0ElementType() {
		return Model_ValuesDataTypeExpressionParserRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpressionElementType() {
		return Expression_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_AlternativesElementType() {
		return Expression_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_PostopParserRuleCall_0ElementType() {
		return Expression_PostopParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_PreopParserRuleCall_1ElementType() {
		return Expression_PreopParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPreopElementType() {
		return Preop_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPreop_GroupElementType() {
		return Preop_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPreop_PreopAction_0ElementType() {
		return Preop_PreopAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPreop_FunctionNameAssignment_1ElementType() {
		return Preop_FunctionNameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPreop_FunctionNameHyphenMinusHyphenMinusKeyword_1_0ElementType() {
		return Preop_FunctionNameHyphenMinusHyphenMinusKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPreop_ExprAssignment_2ElementType() {
		return Preop_ExprAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPreop_ExprVariableParserRuleCall_2_0ElementType() {
		return Preop_ExprVariableParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPostopElementType() {
		return Postop_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPostop_GroupElementType() {
		return Postop_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPostop_VariableParserRuleCall_0ElementType() {
		return Postop_VariableParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPostop_Group_1ElementType() {
		return Postop_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPostop_PostopExprAction_1_0ElementType() {
		return Postop_PostopExprAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPostop_FunctionNameAssignment_1_1ElementType() {
		return Postop_FunctionNameAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPostop_FunctionNameHyphenMinusHyphenMinusKeyword_1_1_0ElementType() {
		return Postop_FunctionNameHyphenMinusHyphenMinusKeyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getVariableElementType() {
		return Variable_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getVariable_GroupElementType() {
		return Variable_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getVariable_VariableAction_0ElementType() {
		return Variable_VariableAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getVariable_NameAssignment_1ElementType() {
		return Variable_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getVariable_NameIDTerminalRuleCall_1_0ElementType() {
		return Variable_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataTypeExpressionElementType() {
		return DataTypeExpression_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataTypeExpression_AlternativesElementType() {
		return DataTypeExpression_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataTypeExpression_DataTypePostopParserRuleCall_0ElementType() {
		return DataTypeExpression_DataTypePostopParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataTypeExpression_DataTypePreopParserRuleCall_1ElementType() {
		return DataTypeExpression_DataTypePreopParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataTypePreopElementType() {
		return DataTypePreop_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataTypePreop_GroupElementType() {
		return DataTypePreop_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataTypePreop_HyphenMinusHyphenMinusKeyword_0ElementType() {
		return DataTypePreop_HyphenMinusHyphenMinusKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataTypePreop_DataTypeVariableParserRuleCall_1ElementType() {
		return DataTypePreop_DataTypeVariableParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataTypePostopElementType() {
		return DataTypePostop_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataTypePostop_GroupElementType() {
		return DataTypePostop_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataTypePostop_DataTypeVariableParserRuleCall_0ElementType() {
		return DataTypePostop_DataTypeVariableParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataTypePostop_HyphenMinusHyphenMinusKeyword_1ElementType() {
		return DataTypePostop_HyphenMinusHyphenMinusKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataTypeVariableElementType() {
		return DataTypeVariable_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDataTypeVariable_IDTerminalRuleCallElementType() {
		return DataTypeVariable_IDTerminalRuleCall_ELEMENT_TYPE;
	}

}
