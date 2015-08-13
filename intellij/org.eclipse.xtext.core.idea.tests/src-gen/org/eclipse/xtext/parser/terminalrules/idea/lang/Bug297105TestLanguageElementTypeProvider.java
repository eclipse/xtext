package org.eclipse.xtext.parser.terminalrules.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.terminalrules.idea.lang.psi.impl.Bug297105TestLanguageFileImpl;
import org.eclipse.xtext.parser.terminalrules.services.Bug297105TestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class Bug297105TestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<Bug297105TestLanguageFileImpl>>(Bug297105TestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final Bug297105TestLanguageGrammarAccess GRAMMAR_ACCESS = Bug297105TestLanguageLanguage.INSTANCE.getInstance(Bug297105TestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_ExpressionsAssignmentElementType() {
			return new IGrammarAwareElementType("Model_ExpressionsAssignment_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getExpressionsAssignment());
		}
		public static IGrammarAwareElementType createModel_ExpressionsExpressionParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Model_ExpressionsExpressionParserRuleCall_0_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getExpressionsExpressionParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_ExpressionsAssignment_ELEMENT_TYPE = associate(ModelFactory.createModel_ExpressionsAssignmentElementType());

	public static final IGrammarAwareElementType Model_ExpressionsExpressionParserRuleCall_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ExpressionsExpressionParserRuleCall_0ElementType());

	private static class ExpressionFactory {
		public static IGrammarAwareElementType createExpressionElementType() {
			return new IGrammarAwareElementType("Expression_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionRule());
		}
		public static IGrammarAwareElementType createExpression_GroupElementType() {
			return new IGrammarAwareElementType("Expression_Group_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getGroup());
		}
		public static IGrammarAwareElementType createExpression_LeftAssignment_0ElementType() {
			return new IGrammarAwareElementType("Expression_LeftAssignment_0_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getLeftAssignment_0());
		}
		public static IGrammarAwareElementType createExpression_LeftLiteralParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Expression_LeftLiteralParserRuleCall_0_0_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getLeftLiteralParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createExpression_PlusSignKeyword_1ElementType() {
			return new IGrammarAwareElementType("Expression_PlusSignKeyword_1_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getPlusSignKeyword_1());
		}
		public static IGrammarAwareElementType createExpression_RightAssignment_2ElementType() {
			return new IGrammarAwareElementType("Expression_RightAssignment_2_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getRightAssignment_2());
		}
		public static IGrammarAwareElementType createExpression_RightLiteralParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Expression_RightLiteralParserRuleCall_2_0_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getRightLiteralParserRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType Expression_ELEMENT_TYPE = associate(ExpressionFactory.createExpressionElementType());

	public static final IGrammarAwareElementType Expression_Group_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_GroupElementType());

	public static final IGrammarAwareElementType Expression_LeftAssignment_0_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_LeftAssignment_0ElementType());

	public static final IGrammarAwareElementType Expression_LeftLiteralParserRuleCall_0_0_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_LeftLiteralParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Expression_PlusSignKeyword_1_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_PlusSignKeyword_1ElementType());

	public static final IGrammarAwareElementType Expression_RightAssignment_2_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_RightAssignment_2ElementType());

	public static final IGrammarAwareElementType Expression_RightLiteralParserRuleCall_2_0_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_RightLiteralParserRuleCall_2_0ElementType());

	private static class LiteralFactory {
		public static IGrammarAwareElementType createLiteralElementType() {
			return new IGrammarAwareElementType("Literal_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLiteralRule());
		}
		public static IGrammarAwareElementType createLiteral_AlternativesElementType() {
			return new IGrammarAwareElementType("Literal_Alternatives_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLiteralAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createLiteral_RealLiteralParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Literal_RealLiteralParserRuleCall_0_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLiteralAccess().getRealLiteralParserRuleCall_0());
		}
		public static IGrammarAwareElementType createLiteral_IntLiteralParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Literal_IntLiteralParserRuleCall_1_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLiteralAccess().getIntLiteralParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType Literal_ELEMENT_TYPE = associate(LiteralFactory.createLiteralElementType());

	public static final IGrammarAwareElementType Literal_Alternatives_ELEMENT_TYPE = associate(LiteralFactory.createLiteral_AlternativesElementType());

	public static final IGrammarAwareElementType Literal_RealLiteralParserRuleCall_0_ELEMENT_TYPE = associate(LiteralFactory.createLiteral_RealLiteralParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Literal_IntLiteralParserRuleCall_1_ELEMENT_TYPE = associate(LiteralFactory.createLiteral_IntLiteralParserRuleCall_1ElementType());

	private static class IntLiteralFactory {
		public static IGrammarAwareElementType createIntLiteralElementType() {
			return new IGrammarAwareElementType("IntLiteral_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getIntLiteralRule());
		}
		public static IGrammarAwareElementType createIntLiteral_ValueAssignmentElementType() {
			return new IGrammarAwareElementType("IntLiteral_ValueAssignment_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getIntLiteralAccess().getValueAssignment());
		}
		public static IGrammarAwareElementType createIntLiteral_ValueIntValueParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("IntLiteral_ValueIntValueParserRuleCall_0_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getIntLiteralAccess().getValueIntValueParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType IntLiteral_ELEMENT_TYPE = associate(IntLiteralFactory.createIntLiteralElementType());

	public static final IGrammarAwareElementType IntLiteral_ValueAssignment_ELEMENT_TYPE = associate(IntLiteralFactory.createIntLiteral_ValueAssignmentElementType());

	public static final IGrammarAwareElementType IntLiteral_ValueIntValueParserRuleCall_0_ELEMENT_TYPE = associate(IntLiteralFactory.createIntLiteral_ValueIntValueParserRuleCall_0ElementType());

	private static class RealLiteralFactory {
		public static IGrammarAwareElementType createRealLiteralElementType() {
			return new IGrammarAwareElementType("RealLiteral_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRealLiteralRule());
		}
		public static IGrammarAwareElementType createRealLiteral_ValueAssignmentElementType() {
			return new IGrammarAwareElementType("RealLiteral_ValueAssignment_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRealLiteralAccess().getValueAssignment());
		}
		public static IGrammarAwareElementType createRealLiteral_ValueRealValueParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("RealLiteral_ValueRealValueParserRuleCall_0_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRealLiteralAccess().getValueRealValueParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType RealLiteral_ELEMENT_TYPE = associate(RealLiteralFactory.createRealLiteralElementType());

	public static final IGrammarAwareElementType RealLiteral_ValueAssignment_ELEMENT_TYPE = associate(RealLiteralFactory.createRealLiteral_ValueAssignmentElementType());

	public static final IGrammarAwareElementType RealLiteral_ValueRealValueParserRuleCall_0_ELEMENT_TYPE = associate(RealLiteralFactory.createRealLiteral_ValueRealValueParserRuleCall_0ElementType());

	private static class IntValueFactory {
		public static IGrammarAwareElementType createIntValueElementType() {
			return new IGrammarAwareElementType("IntValue_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getIntValueRule());
		}
		public static IGrammarAwareElementType createIntValue_INTTerminalRuleCallElementType() {
			return new IGrammarAwareElementType("IntValue_INTTerminalRuleCall_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getIntValueAccess().getINTTerminalRuleCall());
		}
	}

	public static final IGrammarAwareElementType IntValue_ELEMENT_TYPE = associate(IntValueFactory.createIntValueElementType());

	public static final IGrammarAwareElementType IntValue_INTTerminalRuleCall_ELEMENT_TYPE = associate(IntValueFactory.createIntValue_INTTerminalRuleCallElementType());

	private static class RealValueFactory {
		public static IGrammarAwareElementType createRealValueElementType() {
			return new IGrammarAwareElementType("RealValue_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRealValueRule());
		}
		public static IGrammarAwareElementType createRealValue_RealParserRuleCallElementType() {
			return new IGrammarAwareElementType("RealValue_RealParserRuleCall_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRealValueAccess().getRealParserRuleCall());
		}
	}

	public static final IGrammarAwareElementType RealValue_ELEMENT_TYPE = associate(RealValueFactory.createRealValueElementType());

	public static final IGrammarAwareElementType RealValue_RealParserRuleCall_ELEMENT_TYPE = associate(RealValueFactory.createRealValue_RealParserRuleCallElementType());

	private static class RealFactory {
		public static IGrammarAwareElementType createRealElementType() {
			return new IGrammarAwareElementType("Real_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRealRule());
		}
		public static IGrammarAwareElementType createReal_GroupElementType() {
			return new IGrammarAwareElementType("Real_Group_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRealAccess().getGroup());
		}
		public static IGrammarAwareElementType createReal_INTTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Real_INTTerminalRuleCall_0_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRealAccess().getINTTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createReal_FullStopKeyword_1ElementType() {
			return new IGrammarAwareElementType("Real_FullStopKeyword_1_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRealAccess().getFullStopKeyword_1());
		}
		public static IGrammarAwareElementType createReal_Alternatives_2ElementType() {
			return new IGrammarAwareElementType("Real_Alternatives_2_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRealAccess().getAlternatives_2());
		}
		public static IGrammarAwareElementType createReal_EXT_INTTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Real_EXT_INTTerminalRuleCall_2_0_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRealAccess().getEXT_INTTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createReal_INTTerminalRuleCall_2_1ElementType() {
			return new IGrammarAwareElementType("Real_INTTerminalRuleCall_2_1_ELEMENT_TYPE", Bug297105TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRealAccess().getINTTerminalRuleCall_2_1());
		}
	}

	public static final IGrammarAwareElementType Real_ELEMENT_TYPE = associate(RealFactory.createRealElementType());

	public static final IGrammarAwareElementType Real_Group_ELEMENT_TYPE = associate(RealFactory.createReal_GroupElementType());

	public static final IGrammarAwareElementType Real_INTTerminalRuleCall_0_ELEMENT_TYPE = associate(RealFactory.createReal_INTTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType Real_FullStopKeyword_1_ELEMENT_TYPE = associate(RealFactory.createReal_FullStopKeyword_1ElementType());

	public static final IGrammarAwareElementType Real_Alternatives_2_ELEMENT_TYPE = associate(RealFactory.createReal_Alternatives_2ElementType());

	public static final IGrammarAwareElementType Real_EXT_INTTerminalRuleCall_2_0_ELEMENT_TYPE = associate(RealFactory.createReal_EXT_INTTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType Real_INTTerminalRuleCall_2_1_ELEMENT_TYPE = associate(RealFactory.createReal_INTTerminalRuleCall_2_1ElementType());

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

	public IGrammarAwareElementType getModel_ExpressionsAssignmentElementType() {
		return Model_ExpressionsAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ExpressionsExpressionParserRuleCall_0ElementType() {
		return Model_ExpressionsExpressionParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpressionElementType() {
		return Expression_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_GroupElementType() {
		return Expression_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_LeftAssignment_0ElementType() {
		return Expression_LeftAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_LeftLiteralParserRuleCall_0_0ElementType() {
		return Expression_LeftLiteralParserRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_PlusSignKeyword_1ElementType() {
		return Expression_PlusSignKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_RightAssignment_2ElementType() {
		return Expression_RightAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_RightLiteralParserRuleCall_2_0ElementType() {
		return Expression_RightLiteralParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLiteralElementType() {
		return Literal_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLiteral_AlternativesElementType() {
		return Literal_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLiteral_RealLiteralParserRuleCall_0ElementType() {
		return Literal_RealLiteralParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLiteral_IntLiteralParserRuleCall_1ElementType() {
		return Literal_IntLiteralParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getIntLiteralElementType() {
		return IntLiteral_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getIntLiteral_ValueAssignmentElementType() {
		return IntLiteral_ValueAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getIntLiteral_ValueIntValueParserRuleCall_0ElementType() {
		return IntLiteral_ValueIntValueParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRealLiteralElementType() {
		return RealLiteral_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRealLiteral_ValueAssignmentElementType() {
		return RealLiteral_ValueAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRealLiteral_ValueRealValueParserRuleCall_0ElementType() {
		return RealLiteral_ValueRealValueParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getIntValueElementType() {
		return IntValue_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getIntValue_INTTerminalRuleCallElementType() {
		return IntValue_INTTerminalRuleCall_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRealValueElementType() {
		return RealValue_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRealValue_RealParserRuleCallElementType() {
		return RealValue_RealParserRuleCall_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRealElementType() {
		return Real_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReal_GroupElementType() {
		return Real_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReal_INTTerminalRuleCall_0ElementType() {
		return Real_INTTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReal_FullStopKeyword_1ElementType() {
		return Real_FullStopKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReal_Alternatives_2ElementType() {
		return Real_Alternatives_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReal_EXT_INTTerminalRuleCall_2_0ElementType() {
		return Real_EXT_INTTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getReal_INTTerminalRuleCall_2_1ElementType() {
		return Real_INTTerminalRuleCall_2_1_ELEMENT_TYPE;
	}

}
