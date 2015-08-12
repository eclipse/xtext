package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.psi.impl.SerializationErrorTestLanguageFileImpl;
import org.eclipse.xtext.parsetree.reconstr.services.SerializationErrorTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class SerializationErrorTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<SerializationErrorTestLanguageFileImpl>>(SerializationErrorTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final SerializationErrorTestLanguageGrammarAccess GRAMMAR_ACCESS = SerializationErrorTestLanguageLanguage.INSTANCE.getInstance(SerializationErrorTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_AlternativesElementType() {
			return new IGrammarAwareElementType("Model_Alternatives_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createModel_TestAssignment_0ElementType() {
			return new IGrammarAwareElementType("Model_TestAssignment_0_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getTestAssignment_0());
		}
		public static IGrammarAwareElementType createModel_TestTestParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Model_TestTestParserRuleCall_0_0_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getTestTestParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createModel_TestAssignment_1ElementType() {
			return new IGrammarAwareElementType("Model_TestAssignment_1_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getTestAssignment_1());
		}
		public static IGrammarAwareElementType createModel_TestParenthesisParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Model_TestParenthesisParserRuleCall_1_0_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getTestParenthesisParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Alternatives_ELEMENT_TYPE = associate(ModelFactory.createModel_AlternativesElementType());

	public static final IGrammarAwareElementType Model_TestAssignment_0_ELEMENT_TYPE = associate(ModelFactory.createModel_TestAssignment_0ElementType());

	public static final IGrammarAwareElementType Model_TestTestParserRuleCall_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_TestTestParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Model_TestAssignment_1_ELEMENT_TYPE = associate(ModelFactory.createModel_TestAssignment_1ElementType());

	public static final IGrammarAwareElementType Model_TestParenthesisParserRuleCall_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_TestParenthesisParserRuleCall_1_0ElementType());

	private static class ParenthesisFactory {
		public static IGrammarAwareElementType createParenthesisElementType() {
			return new IGrammarAwareElementType("Parenthesis_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesisRule());
		}
		public static IGrammarAwareElementType createParenthesis_GroupElementType() {
			return new IGrammarAwareElementType("Parenthesis_Group_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesisAccess().getGroup());
		}
		public static IGrammarAwareElementType createParenthesis_LeftParenthesisKeyword_0ElementType() {
			return new IGrammarAwareElementType("Parenthesis_LeftParenthesisKeyword_0_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesisAccess().getLeftParenthesisKeyword_0());
		}
		public static IGrammarAwareElementType createParenthesis_TestParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Parenthesis_TestParserRuleCall_1_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesisAccess().getTestParserRuleCall_1());
		}
		public static IGrammarAwareElementType createParenthesis_RightParenthesisKeyword_2ElementType() {
			return new IGrammarAwareElementType("Parenthesis_RightParenthesisKeyword_2_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesisAccess().getRightParenthesisKeyword_2());
		}
	}

	public static final IGrammarAwareElementType Parenthesis_ELEMENT_TYPE = associate(ParenthesisFactory.createParenthesisElementType());

	public static final IGrammarAwareElementType Parenthesis_Group_ELEMENT_TYPE = associate(ParenthesisFactory.createParenthesis_GroupElementType());

	public static final IGrammarAwareElementType Parenthesis_LeftParenthesisKeyword_0_ELEMENT_TYPE = associate(ParenthesisFactory.createParenthesis_LeftParenthesisKeyword_0ElementType());

	public static final IGrammarAwareElementType Parenthesis_TestParserRuleCall_1_ELEMENT_TYPE = associate(ParenthesisFactory.createParenthesis_TestParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType Parenthesis_RightParenthesisKeyword_2_ELEMENT_TYPE = associate(ParenthesisFactory.createParenthesis_RightParenthesisKeyword_2ElementType());

	private static class TestFactory {
		public static IGrammarAwareElementType createTestElementType() {
			return new IGrammarAwareElementType("Test_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestRule());
		}
		public static IGrammarAwareElementType createTest_AlternativesElementType() {
			return new IGrammarAwareElementType("Test_Alternatives_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createTest_TwoRequiredParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Test_TwoRequiredParserRuleCall_0_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestAccess().getTwoRequiredParserRuleCall_0());
		}
		public static IGrammarAwareElementType createTest_TwoOptionsParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Test_TwoOptionsParserRuleCall_1_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestAccess().getTwoOptionsParserRuleCall_1());
		}
		public static IGrammarAwareElementType createTest_IndentParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("Test_IndentParserRuleCall_2_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTestAccess().getIndentParserRuleCall_2());
		}
	}

	public static final IGrammarAwareElementType Test_ELEMENT_TYPE = associate(TestFactory.createTestElementType());

	public static final IGrammarAwareElementType Test_Alternatives_ELEMENT_TYPE = associate(TestFactory.createTest_AlternativesElementType());

	public static final IGrammarAwareElementType Test_TwoRequiredParserRuleCall_0_ELEMENT_TYPE = associate(TestFactory.createTest_TwoRequiredParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Test_TwoOptionsParserRuleCall_1_ELEMENT_TYPE = associate(TestFactory.createTest_TwoOptionsParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType Test_IndentParserRuleCall_2_ELEMENT_TYPE = associate(TestFactory.createTest_IndentParserRuleCall_2ElementType());

	private static class TwoRequiredFactory {
		public static IGrammarAwareElementType createTwoRequiredElementType() {
			return new IGrammarAwareElementType("TwoRequired_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoRequiredRule());
		}
		public static IGrammarAwareElementType createTwoRequired_GroupElementType() {
			return new IGrammarAwareElementType("TwoRequired_Group_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoRequiredAccess().getGroup());
		}
		public static IGrammarAwareElementType createTwoRequired_TworequiredKeyword_0ElementType() {
			return new IGrammarAwareElementType("TwoRequired_TworequiredKeyword_0_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoRequiredAccess().getTworequiredKeyword_0());
		}
		public static IGrammarAwareElementType createTwoRequired_OneAssignment_1ElementType() {
			return new IGrammarAwareElementType("TwoRequired_OneAssignment_1_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoRequiredAccess().getOneAssignment_1());
		}
		public static IGrammarAwareElementType createTwoRequired_OneIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("TwoRequired_OneIDTerminalRuleCall_1_0_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoRequiredAccess().getOneIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createTwoRequired_TwoAssignment_2ElementType() {
			return new IGrammarAwareElementType("TwoRequired_TwoAssignment_2_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoRequiredAccess().getTwoAssignment_2());
		}
		public static IGrammarAwareElementType createTwoRequired_TwoIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("TwoRequired_TwoIDTerminalRuleCall_2_0_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoRequiredAccess().getTwoIDTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType TwoRequired_ELEMENT_TYPE = associate(TwoRequiredFactory.createTwoRequiredElementType());

	public static final IGrammarAwareElementType TwoRequired_Group_ELEMENT_TYPE = associate(TwoRequiredFactory.createTwoRequired_GroupElementType());

	public static final IGrammarAwareElementType TwoRequired_TworequiredKeyword_0_ELEMENT_TYPE = associate(TwoRequiredFactory.createTwoRequired_TworequiredKeyword_0ElementType());

	public static final IGrammarAwareElementType TwoRequired_OneAssignment_1_ELEMENT_TYPE = associate(TwoRequiredFactory.createTwoRequired_OneAssignment_1ElementType());

	public static final IGrammarAwareElementType TwoRequired_OneIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(TwoRequiredFactory.createTwoRequired_OneIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType TwoRequired_TwoAssignment_2_ELEMENT_TYPE = associate(TwoRequiredFactory.createTwoRequired_TwoAssignment_2ElementType());

	public static final IGrammarAwareElementType TwoRequired_TwoIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(TwoRequiredFactory.createTwoRequired_TwoIDTerminalRuleCall_2_0ElementType());

	private static class TwoOptionsFactory {
		public static IGrammarAwareElementType createTwoOptionsElementType() {
			return new IGrammarAwareElementType("TwoOptions_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoOptionsRule());
		}
		public static IGrammarAwareElementType createTwoOptions_GroupElementType() {
			return new IGrammarAwareElementType("TwoOptions_Group_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoOptionsAccess().getGroup());
		}
		public static IGrammarAwareElementType createTwoOptions_TwooptionsKeyword_0ElementType() {
			return new IGrammarAwareElementType("TwoOptions_TwooptionsKeyword_0_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoOptionsAccess().getTwooptionsKeyword_0());
		}
		public static IGrammarAwareElementType createTwoOptions_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("TwoOptions_Alternatives_1_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoOptionsAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createTwoOptions_Group_1_0ElementType() {
			return new IGrammarAwareElementType("TwoOptions_Group_1_0_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoOptionsAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createTwoOptions_OneKeyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("TwoOptions_OneKeyword_1_0_0_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoOptionsAccess().getOneKeyword_1_0_0());
		}
		public static IGrammarAwareElementType createTwoOptions_OneAssignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("TwoOptions_OneAssignment_1_0_1_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoOptionsAccess().getOneAssignment_1_0_1());
		}
		public static IGrammarAwareElementType createTwoOptions_OneIDTerminalRuleCall_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("TwoOptions_OneIDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoOptionsAccess().getOneIDTerminalRuleCall_1_0_1_0());
		}
		public static IGrammarAwareElementType createTwoOptions_Group_1_1ElementType() {
			return new IGrammarAwareElementType("TwoOptions_Group_1_1_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoOptionsAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createTwoOptions_TwoKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("TwoOptions_TwoKeyword_1_1_0_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoOptionsAccess().getTwoKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createTwoOptions_TwoAssignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("TwoOptions_TwoAssignment_1_1_1_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoOptionsAccess().getTwoAssignment_1_1_1());
		}
		public static IGrammarAwareElementType createTwoOptions_TwoIDTerminalRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("TwoOptions_TwoIDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoOptionsAccess().getTwoIDTerminalRuleCall_1_1_1_0());
		}
	}

	public static final IGrammarAwareElementType TwoOptions_ELEMENT_TYPE = associate(TwoOptionsFactory.createTwoOptionsElementType());

	public static final IGrammarAwareElementType TwoOptions_Group_ELEMENT_TYPE = associate(TwoOptionsFactory.createTwoOptions_GroupElementType());

	public static final IGrammarAwareElementType TwoOptions_TwooptionsKeyword_0_ELEMENT_TYPE = associate(TwoOptionsFactory.createTwoOptions_TwooptionsKeyword_0ElementType());

	public static final IGrammarAwareElementType TwoOptions_Alternatives_1_ELEMENT_TYPE = associate(TwoOptionsFactory.createTwoOptions_Alternatives_1ElementType());

	public static final IGrammarAwareElementType TwoOptions_Group_1_0_ELEMENT_TYPE = associate(TwoOptionsFactory.createTwoOptions_Group_1_0ElementType());

	public static final IGrammarAwareElementType TwoOptions_OneKeyword_1_0_0_ELEMENT_TYPE = associate(TwoOptionsFactory.createTwoOptions_OneKeyword_1_0_0ElementType());

	public static final IGrammarAwareElementType TwoOptions_OneAssignment_1_0_1_ELEMENT_TYPE = associate(TwoOptionsFactory.createTwoOptions_OneAssignment_1_0_1ElementType());

	public static final IGrammarAwareElementType TwoOptions_OneIDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE = associate(TwoOptionsFactory.createTwoOptions_OneIDTerminalRuleCall_1_0_1_0ElementType());

	public static final IGrammarAwareElementType TwoOptions_Group_1_1_ELEMENT_TYPE = associate(TwoOptionsFactory.createTwoOptions_Group_1_1ElementType());

	public static final IGrammarAwareElementType TwoOptions_TwoKeyword_1_1_0_ELEMENT_TYPE = associate(TwoOptionsFactory.createTwoOptions_TwoKeyword_1_1_0ElementType());

	public static final IGrammarAwareElementType TwoOptions_TwoAssignment_1_1_1_ELEMENT_TYPE = associate(TwoOptionsFactory.createTwoOptions_TwoAssignment_1_1_1ElementType());

	public static final IGrammarAwareElementType TwoOptions_TwoIDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE = associate(TwoOptionsFactory.createTwoOptions_TwoIDTerminalRuleCall_1_1_1_0ElementType());

	private static class IndentFactory {
		public static IGrammarAwareElementType createIndentElementType() {
			return new IGrammarAwareElementType("Indent_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getIndentRule());
		}
		public static IGrammarAwareElementType createIndent_GroupElementType() {
			return new IGrammarAwareElementType("Indent_Group_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getIndentAccess().getGroup());
		}
		public static IGrammarAwareElementType createIndent_LeftCurlyBracketKeyword_0ElementType() {
			return new IGrammarAwareElementType("Indent_LeftCurlyBracketKeyword_0_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getIndentAccess().getLeftCurlyBracketKeyword_0());
		}
		public static IGrammarAwareElementType createIndent_ReqAssignment_1ElementType() {
			return new IGrammarAwareElementType("Indent_ReqAssignment_1_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getIndentAccess().getReqAssignment_1());
		}
		public static IGrammarAwareElementType createIndent_ReqTwoRequiredParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Indent_ReqTwoRequiredParserRuleCall_1_0_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getIndentAccess().getReqTwoRequiredParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createIndent_OptAssignment_2ElementType() {
			return new IGrammarAwareElementType("Indent_OptAssignment_2_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getIndentAccess().getOptAssignment_2());
		}
		public static IGrammarAwareElementType createIndent_OptTwoOptionsParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Indent_OptTwoOptionsParserRuleCall_2_0_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getIndentAccess().getOptTwoOptionsParserRuleCall_2_0());
		}
		public static IGrammarAwareElementType createIndent_IndentAssignment_3ElementType() {
			return new IGrammarAwareElementType("Indent_IndentAssignment_3_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getIndentAccess().getIndentAssignment_3());
		}
		public static IGrammarAwareElementType createIndent_IndentIndentParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("Indent_IndentIndentParserRuleCall_3_0_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getIndentAccess().getIndentIndentParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createIndent_RightCurlyBracketKeyword_4ElementType() {
			return new IGrammarAwareElementType("Indent_RightCurlyBracketKeyword_4_ELEMENT_TYPE", SerializationErrorTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getIndentAccess().getRightCurlyBracketKeyword_4());
		}
	}

	public static final IGrammarAwareElementType Indent_ELEMENT_TYPE = associate(IndentFactory.createIndentElementType());

	public static final IGrammarAwareElementType Indent_Group_ELEMENT_TYPE = associate(IndentFactory.createIndent_GroupElementType());

	public static final IGrammarAwareElementType Indent_LeftCurlyBracketKeyword_0_ELEMENT_TYPE = associate(IndentFactory.createIndent_LeftCurlyBracketKeyword_0ElementType());

	public static final IGrammarAwareElementType Indent_ReqAssignment_1_ELEMENT_TYPE = associate(IndentFactory.createIndent_ReqAssignment_1ElementType());

	public static final IGrammarAwareElementType Indent_ReqTwoRequiredParserRuleCall_1_0_ELEMENT_TYPE = associate(IndentFactory.createIndent_ReqTwoRequiredParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Indent_OptAssignment_2_ELEMENT_TYPE = associate(IndentFactory.createIndent_OptAssignment_2ElementType());

	public static final IGrammarAwareElementType Indent_OptTwoOptionsParserRuleCall_2_0_ELEMENT_TYPE = associate(IndentFactory.createIndent_OptTwoOptionsParserRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType Indent_IndentAssignment_3_ELEMENT_TYPE = associate(IndentFactory.createIndent_IndentAssignment_3ElementType());

	public static final IGrammarAwareElementType Indent_IndentIndentParserRuleCall_3_0_ELEMENT_TYPE = associate(IndentFactory.createIndent_IndentIndentParserRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType Indent_RightCurlyBracketKeyword_4_ELEMENT_TYPE = associate(IndentFactory.createIndent_RightCurlyBracketKeyword_4ElementType());

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

	public IGrammarAwareElementType getModel_TestAssignment_0ElementType() {
		return Model_TestAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_TestTestParserRuleCall_0_0ElementType() {
		return Model_TestTestParserRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_TestAssignment_1ElementType() {
		return Model_TestAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_TestParenthesisParserRuleCall_1_0ElementType() {
		return Model_TestParenthesisParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParenthesisElementType() {
		return Parenthesis_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParenthesis_GroupElementType() {
		return Parenthesis_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParenthesis_LeftParenthesisKeyword_0ElementType() {
		return Parenthesis_LeftParenthesisKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParenthesis_TestParserRuleCall_1ElementType() {
		return Parenthesis_TestParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParenthesis_RightParenthesisKeyword_2ElementType() {
		return Parenthesis_RightParenthesisKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestElementType() {
		return Test_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTest_AlternativesElementType() {
		return Test_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTest_TwoRequiredParserRuleCall_0ElementType() {
		return Test_TwoRequiredParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTest_TwoOptionsParserRuleCall_1ElementType() {
		return Test_TwoOptionsParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTest_IndentParserRuleCall_2ElementType() {
		return Test_IndentParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoRequiredElementType() {
		return TwoRequired_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoRequired_GroupElementType() {
		return TwoRequired_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoRequired_TworequiredKeyword_0ElementType() {
		return TwoRequired_TworequiredKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoRequired_OneAssignment_1ElementType() {
		return TwoRequired_OneAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoRequired_OneIDTerminalRuleCall_1_0ElementType() {
		return TwoRequired_OneIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoRequired_TwoAssignment_2ElementType() {
		return TwoRequired_TwoAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoRequired_TwoIDTerminalRuleCall_2_0ElementType() {
		return TwoRequired_TwoIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoOptionsElementType() {
		return TwoOptions_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoOptions_GroupElementType() {
		return TwoOptions_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoOptions_TwooptionsKeyword_0ElementType() {
		return TwoOptions_TwooptionsKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoOptions_Alternatives_1ElementType() {
		return TwoOptions_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoOptions_Group_1_0ElementType() {
		return TwoOptions_Group_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoOptions_OneKeyword_1_0_0ElementType() {
		return TwoOptions_OneKeyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoOptions_OneAssignment_1_0_1ElementType() {
		return TwoOptions_OneAssignment_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoOptions_OneIDTerminalRuleCall_1_0_1_0ElementType() {
		return TwoOptions_OneIDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoOptions_Group_1_1ElementType() {
		return TwoOptions_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoOptions_TwoKeyword_1_1_0ElementType() {
		return TwoOptions_TwoKeyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoOptions_TwoAssignment_1_1_1ElementType() {
		return TwoOptions_TwoAssignment_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoOptions_TwoIDTerminalRuleCall_1_1_1_0ElementType() {
		return TwoOptions_TwoIDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getIndentElementType() {
		return Indent_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getIndent_GroupElementType() {
		return Indent_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getIndent_LeftCurlyBracketKeyword_0ElementType() {
		return Indent_LeftCurlyBracketKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getIndent_ReqAssignment_1ElementType() {
		return Indent_ReqAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getIndent_ReqTwoRequiredParserRuleCall_1_0ElementType() {
		return Indent_ReqTwoRequiredParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getIndent_OptAssignment_2ElementType() {
		return Indent_OptAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getIndent_OptTwoOptionsParserRuleCall_2_0ElementType() {
		return Indent_OptTwoOptionsParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getIndent_IndentAssignment_3ElementType() {
		return Indent_IndentAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getIndent_IndentIndentParserRuleCall_3_0ElementType() {
		return Indent_IndentIndentParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getIndent_RightCurlyBracketKeyword_4ElementType() {
		return Indent_RightCurlyBracketKeyword_4_ELEMENT_TYPE;
	}

}
