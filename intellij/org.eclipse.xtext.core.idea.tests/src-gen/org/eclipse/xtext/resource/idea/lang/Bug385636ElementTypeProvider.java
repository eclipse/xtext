package org.eclipse.xtext.resource.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.resource.idea.lang.psi.impl.Bug385636FileImpl;
import org.eclipse.xtext.resource.services.Bug385636GrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class Bug385636ElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<Bug385636FileImpl>>(Bug385636Language.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final Bug385636GrammarAccess GRAMMAR_ACCESS = Bug385636Language.INSTANCE.getInstance(Bug385636GrammarAccess.class);

	private static class ProgramFactory {
		public static IGrammarAwareElementType createProgramElementType() {
			return new IGrammarAwareElementType("Program_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getProgramRule());
		}
		public static IGrammarAwareElementType createProgram_GroupElementType() {
			return new IGrammarAwareElementType("Program_Group_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getProgramAccess().getGroup());
		}
		public static IGrammarAwareElementType createProgram_DefineAssignment_0ElementType() {
			return new IGrammarAwareElementType("Program_DefineAssignment_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getProgramAccess().getDefineAssignment_0());
		}
		public static IGrammarAwareElementType createProgram_DefineDefineVariablesParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Program_DefineDefineVariablesParserRuleCall_0_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getProgramAccess().getDefineDefineVariablesParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createProgram_StatementsAssignment_1ElementType() {
			return new IGrammarAwareElementType("Program_StatementsAssignment_1_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getProgramAccess().getStatementsAssignment_1());
		}
		public static IGrammarAwareElementType createProgram_StatementsStatementParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Program_StatementsStatementParserRuleCall_1_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getProgramAccess().getStatementsStatementParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createProgram_ENDKeyword_2ElementType() {
			return new IGrammarAwareElementType("Program_ENDKeyword_2_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getProgramAccess().getENDKeyword_2());
		}
	}

	public static final IGrammarAwareElementType Program_ELEMENT_TYPE = associate(ProgramFactory.createProgramElementType());

	public static final IGrammarAwareElementType Program_Group_ELEMENT_TYPE = associate(ProgramFactory.createProgram_GroupElementType());

	public static final IGrammarAwareElementType Program_DefineAssignment_0_ELEMENT_TYPE = associate(ProgramFactory.createProgram_DefineAssignment_0ElementType());

	public static final IGrammarAwareElementType Program_DefineDefineVariablesParserRuleCall_0_0_ELEMENT_TYPE = associate(ProgramFactory.createProgram_DefineDefineVariablesParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Program_StatementsAssignment_1_ELEMENT_TYPE = associate(ProgramFactory.createProgram_StatementsAssignment_1ElementType());

	public static final IGrammarAwareElementType Program_StatementsStatementParserRuleCall_1_0_ELEMENT_TYPE = associate(ProgramFactory.createProgram_StatementsStatementParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Program_ENDKeyword_2_ELEMENT_TYPE = associate(ProgramFactory.createProgram_ENDKeyword_2ElementType());

	private static class DefineVariablesFactory {
		public static IGrammarAwareElementType createDefineVariablesElementType() {
			return new IGrammarAwareElementType("DefineVariables_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getDefineVariablesRule());
		}
		public static IGrammarAwareElementType createDefineVariables_GroupElementType() {
			return new IGrammarAwareElementType("DefineVariables_Group_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getDefineVariablesAccess().getGroup());
		}
		public static IGrammarAwareElementType createDefineVariables_VARIABLESKeyword_0ElementType() {
			return new IGrammarAwareElementType("DefineVariables_VARIABLESKeyword_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getDefineVariablesAccess().getVARIABLESKeyword_0());
		}
		public static IGrammarAwareElementType createDefineVariables_VariablesAssignment_1ElementType() {
			return new IGrammarAwareElementType("DefineVariables_VariablesAssignment_1_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getDefineVariablesAccess().getVariablesAssignment_1());
		}
		public static IGrammarAwareElementType createDefineVariables_VariablesDefineVariableParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("DefineVariables_VariablesDefineVariableParserRuleCall_1_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getDefineVariablesAccess().getVariablesDefineVariableParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createDefineVariables_ENDVARIABLESKeyword_2ElementType() {
			return new IGrammarAwareElementType("DefineVariables_ENDVARIABLESKeyword_2_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getDefineVariablesAccess().getENDVARIABLESKeyword_2());
		}
	}

	public static final IGrammarAwareElementType DefineVariables_ELEMENT_TYPE = associate(DefineVariablesFactory.createDefineVariablesElementType());

	public static final IGrammarAwareElementType DefineVariables_Group_ELEMENT_TYPE = associate(DefineVariablesFactory.createDefineVariables_GroupElementType());

	public static final IGrammarAwareElementType DefineVariables_VARIABLESKeyword_0_ELEMENT_TYPE = associate(DefineVariablesFactory.createDefineVariables_VARIABLESKeyword_0ElementType());

	public static final IGrammarAwareElementType DefineVariables_VariablesAssignment_1_ELEMENT_TYPE = associate(DefineVariablesFactory.createDefineVariables_VariablesAssignment_1ElementType());

	public static final IGrammarAwareElementType DefineVariables_VariablesDefineVariableParserRuleCall_1_0_ELEMENT_TYPE = associate(DefineVariablesFactory.createDefineVariables_VariablesDefineVariableParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType DefineVariables_ENDVARIABLESKeyword_2_ELEMENT_TYPE = associate(DefineVariablesFactory.createDefineVariables_ENDVARIABLESKeyword_2ElementType());

	private static class DefineVariableFactory {
		public static IGrammarAwareElementType createDefineVariableElementType() {
			return new IGrammarAwareElementType("DefineVariable_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getDefineVariableRule());
		}
		public static IGrammarAwareElementType createDefineVariable_GroupElementType() {
			return new IGrammarAwareElementType("DefineVariable_Group_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getDefineVariableAccess().getGroup());
		}
		public static IGrammarAwareElementType createDefineVariable_NAMEKeyword_0ElementType() {
			return new IGrammarAwareElementType("DefineVariable_NAMEKeyword_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getDefineVariableAccess().getNAMEKeyword_0());
		}
		public static IGrammarAwareElementType createDefineVariable_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("DefineVariable_NameAssignment_1_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getDefineVariableAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createDefineVariable_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("DefineVariable_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getDefineVariableAccess().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType DefineVariable_ELEMENT_TYPE = associate(DefineVariableFactory.createDefineVariableElementType());

	public static final IGrammarAwareElementType DefineVariable_Group_ELEMENT_TYPE = associate(DefineVariableFactory.createDefineVariable_GroupElementType());

	public static final IGrammarAwareElementType DefineVariable_NAMEKeyword_0_ELEMENT_TYPE = associate(DefineVariableFactory.createDefineVariable_NAMEKeyword_0ElementType());

	public static final IGrammarAwareElementType DefineVariable_NameAssignment_1_ELEMENT_TYPE = associate(DefineVariableFactory.createDefineVariable_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType DefineVariable_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(DefineVariableFactory.createDefineVariable_NameIDTerminalRuleCall_1_0ElementType());

	private static class NVariableAccessFactory {
		public static IGrammarAwareElementType createNVariableAccessElementType() {
			return new IGrammarAwareElementType("NVariableAccess_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getNVariableAccessRule());
		}
		public static IGrammarAwareElementType createNVariableAccess_VariableAssignmentElementType() {
			return new IGrammarAwareElementType("NVariableAccess_VariableAssignment_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getNVariableAccessAccess().getVariableAssignment());
		}
		public static IGrammarAwareElementType createNVariableAccess_VariableDefineVariableCrossReference_0ElementType() {
			return new IGrammarAwareElementType("NVariableAccess_VariableDefineVariableCrossReference_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getNVariableAccessAccess().getVariableDefineVariableCrossReference_0());
		}
		public static IGrammarAwareElementType createNVariableAccess_VariableDefineVariableIDTerminalRuleCall_0_1ElementType() {
			return new IGrammarAwareElementType("NVariableAccess_VariableDefineVariableIDTerminalRuleCall_0_1_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getNVariableAccessAccess().getVariableDefineVariableIDTerminalRuleCall_0_1());
		}
	}

	public static final IGrammarAwareElementType NVariableAccess_ELEMENT_TYPE = associate(NVariableAccessFactory.createNVariableAccessElementType());

	public static final IGrammarAwareElementType NVariableAccess_VariableAssignment_ELEMENT_TYPE = associate(NVariableAccessFactory.createNVariableAccess_VariableAssignmentElementType());

	public static final IGrammarAwareElementType NVariableAccess_VariableDefineVariableCrossReference_0_ELEMENT_TYPE = associate(NVariableAccessFactory.createNVariableAccess_VariableDefineVariableCrossReference_0ElementType());

	public static final IGrammarAwareElementType NVariableAccess_VariableDefineVariableIDTerminalRuleCall_0_1_ELEMENT_TYPE = associate(NVariableAccessFactory.createNVariableAccess_VariableDefineVariableIDTerminalRuleCall_0_1ElementType());

	private static class StatementFactory {
		public static IGrammarAwareElementType createStatementElementType() {
			return new IGrammarAwareElementType("Statement_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementRule());
		}
		public static IGrammarAwareElementType createStatement_GroupElementType() {
			return new IGrammarAwareElementType("Statement_Group_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getGroup());
		}
		public static IGrammarAwareElementType createStatement_Expression_VariableNameParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Statement_Expression_VariableNameParserRuleCall_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getExpression_VariableNameParserRuleCall_0());
		}
		public static IGrammarAwareElementType createStatement_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("Statement_Alternatives_1_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createStatement_Group_1_0ElementType() {
			return new IGrammarAwareElementType("Statement_Group_1_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createStatement_C1Keyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("Statement_C1Keyword_1_0_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getC1Keyword_1_0_0());
		}
		public static IGrammarAwareElementType createStatement_Expression_Larger_EqualLeftAction_1_0_1ElementType() {
			return new IGrammarAwareElementType("Statement_Expression_Larger_EqualLeftAction_1_0_1_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getExpression_Larger_EqualLeftAction_1_0_1());
		}
		public static IGrammarAwareElementType createStatement_RightAssignment_1_0_2ElementType() {
			return new IGrammarAwareElementType("Statement_RightAssignment_1_0_2_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getRightAssignment_1_0_2());
		}
		public static IGrammarAwareElementType createStatement_RightExpression_VariableNameParserRuleCall_1_0_2_0ElementType() {
			return new IGrammarAwareElementType("Statement_RightExpression_VariableNameParserRuleCall_1_0_2_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getRightExpression_VariableNameParserRuleCall_1_0_2_0());
		}
		public static IGrammarAwareElementType createStatement_Group_1_1ElementType() {
			return new IGrammarAwareElementType("Statement_Group_1_1_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createStatement_C2Keyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("Statement_C2Keyword_1_1_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getC2Keyword_1_1_0());
		}
		public static IGrammarAwareElementType createStatement_Expression_SmallerLeftAction_1_1_1ElementType() {
			return new IGrammarAwareElementType("Statement_Expression_SmallerLeftAction_1_1_1_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getExpression_SmallerLeftAction_1_1_1());
		}
		public static IGrammarAwareElementType createStatement_RightAssignment_1_1_2ElementType() {
			return new IGrammarAwareElementType("Statement_RightAssignment_1_1_2_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getRightAssignment_1_1_2());
		}
		public static IGrammarAwareElementType createStatement_RightExpression_VariableNameParserRuleCall_1_1_2_0ElementType() {
			return new IGrammarAwareElementType("Statement_RightExpression_VariableNameParserRuleCall_1_1_2_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getRightExpression_VariableNameParserRuleCall_1_1_2_0());
		}
		public static IGrammarAwareElementType createStatement_Group_1_2ElementType() {
			return new IGrammarAwareElementType("Statement_Group_1_2_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getGroup_1_2());
		}
		public static IGrammarAwareElementType createStatement_C3Keyword_1_2_0ElementType() {
			return new IGrammarAwareElementType("Statement_C3Keyword_1_2_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getC3Keyword_1_2_0());
		}
		public static IGrammarAwareElementType createStatement_Expression_Smaller_EqualLeftAction_1_2_1ElementType() {
			return new IGrammarAwareElementType("Statement_Expression_Smaller_EqualLeftAction_1_2_1_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getExpression_Smaller_EqualLeftAction_1_2_1());
		}
		public static IGrammarAwareElementType createStatement_RightAssignment_1_2_2ElementType() {
			return new IGrammarAwareElementType("Statement_RightAssignment_1_2_2_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getRightAssignment_1_2_2());
		}
		public static IGrammarAwareElementType createStatement_RightExpression_VariableNameParserRuleCall_1_2_2_0ElementType() {
			return new IGrammarAwareElementType("Statement_RightExpression_VariableNameParserRuleCall_1_2_2_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getRightExpression_VariableNameParserRuleCall_1_2_2_0());
		}
		public static IGrammarAwareElementType createStatement_Group_1_3ElementType() {
			return new IGrammarAwareElementType("Statement_Group_1_3_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getGroup_1_3());
		}
		public static IGrammarAwareElementType createStatement_C4Keyword_1_3_0ElementType() {
			return new IGrammarAwareElementType("Statement_C4Keyword_1_3_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getC4Keyword_1_3_0());
		}
		public static IGrammarAwareElementType createStatement_Expression_EqualLeftAction_1_3_1ElementType() {
			return new IGrammarAwareElementType("Statement_Expression_EqualLeftAction_1_3_1_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getExpression_EqualLeftAction_1_3_1());
		}
		public static IGrammarAwareElementType createStatement_RightAssignment_1_3_2ElementType() {
			return new IGrammarAwareElementType("Statement_RightAssignment_1_3_2_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getRightAssignment_1_3_2());
		}
		public static IGrammarAwareElementType createStatement_RightExpression_VariableNameParserRuleCall_1_3_2_0ElementType() {
			return new IGrammarAwareElementType("Statement_RightExpression_VariableNameParserRuleCall_1_3_2_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getRightExpression_VariableNameParserRuleCall_1_3_2_0());
		}
		public static IGrammarAwareElementType createStatement_Group_1_4ElementType() {
			return new IGrammarAwareElementType("Statement_Group_1_4_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getGroup_1_4());
		}
		public static IGrammarAwareElementType createStatement_C5Keyword_1_4_0ElementType() {
			return new IGrammarAwareElementType("Statement_C5Keyword_1_4_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getC5Keyword_1_4_0());
		}
		public static IGrammarAwareElementType createStatement_Expression_Not_EqualLeftAction_1_4_1ElementType() {
			return new IGrammarAwareElementType("Statement_Expression_Not_EqualLeftAction_1_4_1_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getExpression_Not_EqualLeftAction_1_4_1());
		}
		public static IGrammarAwareElementType createStatement_RightAssignment_1_4_2ElementType() {
			return new IGrammarAwareElementType("Statement_RightAssignment_1_4_2_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getRightAssignment_1_4_2());
		}
		public static IGrammarAwareElementType createStatement_RightExpression_VariableNameParserRuleCall_1_4_2_0ElementType() {
			return new IGrammarAwareElementType("Statement_RightExpression_VariableNameParserRuleCall_1_4_2_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getRightExpression_VariableNameParserRuleCall_1_4_2_0());
		}
		public static IGrammarAwareElementType createStatement_Group_1_5ElementType() {
			return new IGrammarAwareElementType("Statement_Group_1_5_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getGroup_1_5());
		}
		public static IGrammarAwareElementType createStatement_Group_1_5_0ElementType() {
			return new IGrammarAwareElementType("Statement_Group_1_5_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getGroup_1_5_0());
		}
		public static IGrammarAwareElementType createStatement_C6Keyword_1_5_0_0ElementType() {
			return new IGrammarAwareElementType("Statement_C6Keyword_1_5_0_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getC6Keyword_1_5_0_0());
		}
		public static IGrammarAwareElementType createStatement_C7Keyword_1_5_0_1ElementType() {
			return new IGrammarAwareElementType("Statement_C7Keyword_1_5_0_1_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getC7Keyword_1_5_0_1());
		}
		public static IGrammarAwareElementType createStatement_Expression_Not_LessLeftAction_1_5_1ElementType() {
			return new IGrammarAwareElementType("Statement_Expression_Not_LessLeftAction_1_5_1_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getExpression_Not_LessLeftAction_1_5_1());
		}
		public static IGrammarAwareElementType createStatement_RightAssignment_1_5_2ElementType() {
			return new IGrammarAwareElementType("Statement_RightAssignment_1_5_2_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getRightAssignment_1_5_2());
		}
		public static IGrammarAwareElementType createStatement_RightExpression_VariableNameParserRuleCall_1_5_2_0ElementType() {
			return new IGrammarAwareElementType("Statement_RightExpression_VariableNameParserRuleCall_1_5_2_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getRightExpression_VariableNameParserRuleCall_1_5_2_0());
		}
		public static IGrammarAwareElementType createStatement_Group_1_6ElementType() {
			return new IGrammarAwareElementType("Statement_Group_1_6_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getGroup_1_6());
		}
		public static IGrammarAwareElementType createStatement_Group_1_6_0ElementType() {
			return new IGrammarAwareElementType("Statement_Group_1_6_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getGroup_1_6_0());
		}
		public static IGrammarAwareElementType createStatement_C6Keyword_1_6_0_0ElementType() {
			return new IGrammarAwareElementType("Statement_C6Keyword_1_6_0_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getC6Keyword_1_6_0_0());
		}
		public static IGrammarAwareElementType createStatement_C8Keyword_1_6_0_1ElementType() {
			return new IGrammarAwareElementType("Statement_C8Keyword_1_6_0_1_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getC8Keyword_1_6_0_1());
		}
		public static IGrammarAwareElementType createStatement_Expression_Not_GreaterLeftAction_1_6_1ElementType() {
			return new IGrammarAwareElementType("Statement_Expression_Not_GreaterLeftAction_1_6_1_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getExpression_Not_GreaterLeftAction_1_6_1());
		}
		public static IGrammarAwareElementType createStatement_RightAssignment_1_6_2ElementType() {
			return new IGrammarAwareElementType("Statement_RightAssignment_1_6_2_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getRightAssignment_1_6_2());
		}
		public static IGrammarAwareElementType createStatement_RightExpression_VariableNameParserRuleCall_1_6_2_0ElementType() {
			return new IGrammarAwareElementType("Statement_RightExpression_VariableNameParserRuleCall_1_6_2_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getStatementAccess().getRightExpression_VariableNameParserRuleCall_1_6_2_0());
		}
	}

	public static final IGrammarAwareElementType Statement_ELEMENT_TYPE = associate(StatementFactory.createStatementElementType());

	public static final IGrammarAwareElementType Statement_Group_ELEMENT_TYPE = associate(StatementFactory.createStatement_GroupElementType());

	public static final IGrammarAwareElementType Statement_Expression_VariableNameParserRuleCall_0_ELEMENT_TYPE = associate(StatementFactory.createStatement_Expression_VariableNameParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Statement_Alternatives_1_ELEMENT_TYPE = associate(StatementFactory.createStatement_Alternatives_1ElementType());

	public static final IGrammarAwareElementType Statement_Group_1_0_ELEMENT_TYPE = associate(StatementFactory.createStatement_Group_1_0ElementType());

	public static final IGrammarAwareElementType Statement_C1Keyword_1_0_0_ELEMENT_TYPE = associate(StatementFactory.createStatement_C1Keyword_1_0_0ElementType());

	public static final IGrammarAwareElementType Statement_Expression_Larger_EqualLeftAction_1_0_1_ELEMENT_TYPE = associate(StatementFactory.createStatement_Expression_Larger_EqualLeftAction_1_0_1ElementType());

	public static final IGrammarAwareElementType Statement_RightAssignment_1_0_2_ELEMENT_TYPE = associate(StatementFactory.createStatement_RightAssignment_1_0_2ElementType());

	public static final IGrammarAwareElementType Statement_RightExpression_VariableNameParserRuleCall_1_0_2_0_ELEMENT_TYPE = associate(StatementFactory.createStatement_RightExpression_VariableNameParserRuleCall_1_0_2_0ElementType());

	public static final IGrammarAwareElementType Statement_Group_1_1_ELEMENT_TYPE = associate(StatementFactory.createStatement_Group_1_1ElementType());

	public static final IGrammarAwareElementType Statement_C2Keyword_1_1_0_ELEMENT_TYPE = associate(StatementFactory.createStatement_C2Keyword_1_1_0ElementType());

	public static final IGrammarAwareElementType Statement_Expression_SmallerLeftAction_1_1_1_ELEMENT_TYPE = associate(StatementFactory.createStatement_Expression_SmallerLeftAction_1_1_1ElementType());

	public static final IGrammarAwareElementType Statement_RightAssignment_1_1_2_ELEMENT_TYPE = associate(StatementFactory.createStatement_RightAssignment_1_1_2ElementType());

	public static final IGrammarAwareElementType Statement_RightExpression_VariableNameParserRuleCall_1_1_2_0_ELEMENT_TYPE = associate(StatementFactory.createStatement_RightExpression_VariableNameParserRuleCall_1_1_2_0ElementType());

	public static final IGrammarAwareElementType Statement_Group_1_2_ELEMENT_TYPE = associate(StatementFactory.createStatement_Group_1_2ElementType());

	public static final IGrammarAwareElementType Statement_C3Keyword_1_2_0_ELEMENT_TYPE = associate(StatementFactory.createStatement_C3Keyword_1_2_0ElementType());

	public static final IGrammarAwareElementType Statement_Expression_Smaller_EqualLeftAction_1_2_1_ELEMENT_TYPE = associate(StatementFactory.createStatement_Expression_Smaller_EqualLeftAction_1_2_1ElementType());

	public static final IGrammarAwareElementType Statement_RightAssignment_1_2_2_ELEMENT_TYPE = associate(StatementFactory.createStatement_RightAssignment_1_2_2ElementType());

	public static final IGrammarAwareElementType Statement_RightExpression_VariableNameParserRuleCall_1_2_2_0_ELEMENT_TYPE = associate(StatementFactory.createStatement_RightExpression_VariableNameParserRuleCall_1_2_2_0ElementType());

	public static final IGrammarAwareElementType Statement_Group_1_3_ELEMENT_TYPE = associate(StatementFactory.createStatement_Group_1_3ElementType());

	public static final IGrammarAwareElementType Statement_C4Keyword_1_3_0_ELEMENT_TYPE = associate(StatementFactory.createStatement_C4Keyword_1_3_0ElementType());

	public static final IGrammarAwareElementType Statement_Expression_EqualLeftAction_1_3_1_ELEMENT_TYPE = associate(StatementFactory.createStatement_Expression_EqualLeftAction_1_3_1ElementType());

	public static final IGrammarAwareElementType Statement_RightAssignment_1_3_2_ELEMENT_TYPE = associate(StatementFactory.createStatement_RightAssignment_1_3_2ElementType());

	public static final IGrammarAwareElementType Statement_RightExpression_VariableNameParserRuleCall_1_3_2_0_ELEMENT_TYPE = associate(StatementFactory.createStatement_RightExpression_VariableNameParserRuleCall_1_3_2_0ElementType());

	public static final IGrammarAwareElementType Statement_Group_1_4_ELEMENT_TYPE = associate(StatementFactory.createStatement_Group_1_4ElementType());

	public static final IGrammarAwareElementType Statement_C5Keyword_1_4_0_ELEMENT_TYPE = associate(StatementFactory.createStatement_C5Keyword_1_4_0ElementType());

	public static final IGrammarAwareElementType Statement_Expression_Not_EqualLeftAction_1_4_1_ELEMENT_TYPE = associate(StatementFactory.createStatement_Expression_Not_EqualLeftAction_1_4_1ElementType());

	public static final IGrammarAwareElementType Statement_RightAssignment_1_4_2_ELEMENT_TYPE = associate(StatementFactory.createStatement_RightAssignment_1_4_2ElementType());

	public static final IGrammarAwareElementType Statement_RightExpression_VariableNameParserRuleCall_1_4_2_0_ELEMENT_TYPE = associate(StatementFactory.createStatement_RightExpression_VariableNameParserRuleCall_1_4_2_0ElementType());

	public static final IGrammarAwareElementType Statement_Group_1_5_ELEMENT_TYPE = associate(StatementFactory.createStatement_Group_1_5ElementType());

	public static final IGrammarAwareElementType Statement_Group_1_5_0_ELEMENT_TYPE = associate(StatementFactory.createStatement_Group_1_5_0ElementType());

	public static final IGrammarAwareElementType Statement_C6Keyword_1_5_0_0_ELEMENT_TYPE = associate(StatementFactory.createStatement_C6Keyword_1_5_0_0ElementType());

	public static final IGrammarAwareElementType Statement_C7Keyword_1_5_0_1_ELEMENT_TYPE = associate(StatementFactory.createStatement_C7Keyword_1_5_0_1ElementType());

	public static final IGrammarAwareElementType Statement_Expression_Not_LessLeftAction_1_5_1_ELEMENT_TYPE = associate(StatementFactory.createStatement_Expression_Not_LessLeftAction_1_5_1ElementType());

	public static final IGrammarAwareElementType Statement_RightAssignment_1_5_2_ELEMENT_TYPE = associate(StatementFactory.createStatement_RightAssignment_1_5_2ElementType());

	public static final IGrammarAwareElementType Statement_RightExpression_VariableNameParserRuleCall_1_5_2_0_ELEMENT_TYPE = associate(StatementFactory.createStatement_RightExpression_VariableNameParserRuleCall_1_5_2_0ElementType());

	public static final IGrammarAwareElementType Statement_Group_1_6_ELEMENT_TYPE = associate(StatementFactory.createStatement_Group_1_6ElementType());

	public static final IGrammarAwareElementType Statement_Group_1_6_0_ELEMENT_TYPE = associate(StatementFactory.createStatement_Group_1_6_0ElementType());

	public static final IGrammarAwareElementType Statement_C6Keyword_1_6_0_0_ELEMENT_TYPE = associate(StatementFactory.createStatement_C6Keyword_1_6_0_0ElementType());

	public static final IGrammarAwareElementType Statement_C8Keyword_1_6_0_1_ELEMENT_TYPE = associate(StatementFactory.createStatement_C8Keyword_1_6_0_1ElementType());

	public static final IGrammarAwareElementType Statement_Expression_Not_GreaterLeftAction_1_6_1_ELEMENT_TYPE = associate(StatementFactory.createStatement_Expression_Not_GreaterLeftAction_1_6_1ElementType());

	public static final IGrammarAwareElementType Statement_RightAssignment_1_6_2_ELEMENT_TYPE = associate(StatementFactory.createStatement_RightAssignment_1_6_2ElementType());

	public static final IGrammarAwareElementType Statement_RightExpression_VariableNameParserRuleCall_1_6_2_0_ELEMENT_TYPE = associate(StatementFactory.createStatement_RightExpression_VariableNameParserRuleCall_1_6_2_0ElementType());

	private static class Expression_VariableNameFactory {
		public static IGrammarAwareElementType createExpression_VariableNameElementType() {
			return new IGrammarAwareElementType("Expression_VariableName_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getExpression_VariableNameRule());
		}
		public static IGrammarAwareElementType createExpression_VariableName_VariableAssignmentElementType() {
			return new IGrammarAwareElementType("Expression_VariableName_VariableAssignment_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getExpression_VariableNameAccess().getVariableAssignment());
		}
		public static IGrammarAwareElementType createExpression_VariableName_VariableNVariableAccessParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Expression_VariableName_VariableNVariableAccessParserRuleCall_0_ELEMENT_TYPE", Bug385636Language.INSTANCE, GRAMMAR_ACCESS.getExpression_VariableNameAccess().getVariableNVariableAccessParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Expression_VariableName_ELEMENT_TYPE = associate(Expression_VariableNameFactory.createExpression_VariableNameElementType());

	public static final IGrammarAwareElementType Expression_VariableName_VariableAssignment_ELEMENT_TYPE = associate(Expression_VariableNameFactory.createExpression_VariableName_VariableAssignmentElementType());

	public static final IGrammarAwareElementType Expression_VariableName_VariableNVariableAccessParserRuleCall_0_ELEMENT_TYPE = associate(Expression_VariableNameFactory.createExpression_VariableName_VariableNVariableAccessParserRuleCall_0ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getProgramElementType() {
		return Program_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getProgram_GroupElementType() {
		return Program_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getProgram_DefineAssignment_0ElementType() {
		return Program_DefineAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getProgram_DefineDefineVariablesParserRuleCall_0_0ElementType() {
		return Program_DefineDefineVariablesParserRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getProgram_StatementsAssignment_1ElementType() {
		return Program_StatementsAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getProgram_StatementsStatementParserRuleCall_1_0ElementType() {
		return Program_StatementsStatementParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getProgram_ENDKeyword_2ElementType() {
		return Program_ENDKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefineVariablesElementType() {
		return DefineVariables_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefineVariables_GroupElementType() {
		return DefineVariables_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefineVariables_VARIABLESKeyword_0ElementType() {
		return DefineVariables_VARIABLESKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefineVariables_VariablesAssignment_1ElementType() {
		return DefineVariables_VariablesAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefineVariables_VariablesDefineVariableParserRuleCall_1_0ElementType() {
		return DefineVariables_VariablesDefineVariableParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefineVariables_ENDVARIABLESKeyword_2ElementType() {
		return DefineVariables_ENDVARIABLESKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefineVariableElementType() {
		return DefineVariable_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefineVariable_GroupElementType() {
		return DefineVariable_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefineVariable_NAMEKeyword_0ElementType() {
		return DefineVariable_NAMEKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefineVariable_NameAssignment_1ElementType() {
		return DefineVariable_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDefineVariable_NameIDTerminalRuleCall_1_0ElementType() {
		return DefineVariable_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNVariableAccessElementType() {
		return NVariableAccess_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNVariableAccess_VariableAssignmentElementType() {
		return NVariableAccess_VariableAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNVariableAccess_VariableDefineVariableCrossReference_0ElementType() {
		return NVariableAccess_VariableDefineVariableCrossReference_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNVariableAccess_VariableDefineVariableIDTerminalRuleCall_0_1ElementType() {
		return NVariableAccess_VariableDefineVariableIDTerminalRuleCall_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatementElementType() {
		return Statement_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_GroupElementType() {
		return Statement_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_Expression_VariableNameParserRuleCall_0ElementType() {
		return Statement_Expression_VariableNameParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_Alternatives_1ElementType() {
		return Statement_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_Group_1_0ElementType() {
		return Statement_Group_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_C1Keyword_1_0_0ElementType() {
		return Statement_C1Keyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_Expression_Larger_EqualLeftAction_1_0_1ElementType() {
		return Statement_Expression_Larger_EqualLeftAction_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_RightAssignment_1_0_2ElementType() {
		return Statement_RightAssignment_1_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_RightExpression_VariableNameParserRuleCall_1_0_2_0ElementType() {
		return Statement_RightExpression_VariableNameParserRuleCall_1_0_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_Group_1_1ElementType() {
		return Statement_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_C2Keyword_1_1_0ElementType() {
		return Statement_C2Keyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_Expression_SmallerLeftAction_1_1_1ElementType() {
		return Statement_Expression_SmallerLeftAction_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_RightAssignment_1_1_2ElementType() {
		return Statement_RightAssignment_1_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_RightExpression_VariableNameParserRuleCall_1_1_2_0ElementType() {
		return Statement_RightExpression_VariableNameParserRuleCall_1_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_Group_1_2ElementType() {
		return Statement_Group_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_C3Keyword_1_2_0ElementType() {
		return Statement_C3Keyword_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_Expression_Smaller_EqualLeftAction_1_2_1ElementType() {
		return Statement_Expression_Smaller_EqualLeftAction_1_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_RightAssignment_1_2_2ElementType() {
		return Statement_RightAssignment_1_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_RightExpression_VariableNameParserRuleCall_1_2_2_0ElementType() {
		return Statement_RightExpression_VariableNameParserRuleCall_1_2_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_Group_1_3ElementType() {
		return Statement_Group_1_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_C4Keyword_1_3_0ElementType() {
		return Statement_C4Keyword_1_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_Expression_EqualLeftAction_1_3_1ElementType() {
		return Statement_Expression_EqualLeftAction_1_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_RightAssignment_1_3_2ElementType() {
		return Statement_RightAssignment_1_3_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_RightExpression_VariableNameParserRuleCall_1_3_2_0ElementType() {
		return Statement_RightExpression_VariableNameParserRuleCall_1_3_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_Group_1_4ElementType() {
		return Statement_Group_1_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_C5Keyword_1_4_0ElementType() {
		return Statement_C5Keyword_1_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_Expression_Not_EqualLeftAction_1_4_1ElementType() {
		return Statement_Expression_Not_EqualLeftAction_1_4_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_RightAssignment_1_4_2ElementType() {
		return Statement_RightAssignment_1_4_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_RightExpression_VariableNameParserRuleCall_1_4_2_0ElementType() {
		return Statement_RightExpression_VariableNameParserRuleCall_1_4_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_Group_1_5ElementType() {
		return Statement_Group_1_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_Group_1_5_0ElementType() {
		return Statement_Group_1_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_C6Keyword_1_5_0_0ElementType() {
		return Statement_C6Keyword_1_5_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_C7Keyword_1_5_0_1ElementType() {
		return Statement_C7Keyword_1_5_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_Expression_Not_LessLeftAction_1_5_1ElementType() {
		return Statement_Expression_Not_LessLeftAction_1_5_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_RightAssignment_1_5_2ElementType() {
		return Statement_RightAssignment_1_5_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_RightExpression_VariableNameParserRuleCall_1_5_2_0ElementType() {
		return Statement_RightExpression_VariableNameParserRuleCall_1_5_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_Group_1_6ElementType() {
		return Statement_Group_1_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_Group_1_6_0ElementType() {
		return Statement_Group_1_6_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_C6Keyword_1_6_0_0ElementType() {
		return Statement_C6Keyword_1_6_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_C8Keyword_1_6_0_1ElementType() {
		return Statement_C8Keyword_1_6_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_Expression_Not_GreaterLeftAction_1_6_1ElementType() {
		return Statement_Expression_Not_GreaterLeftAction_1_6_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_RightAssignment_1_6_2ElementType() {
		return Statement_RightAssignment_1_6_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getStatement_RightExpression_VariableNameParserRuleCall_1_6_2_0ElementType() {
		return Statement_RightExpression_VariableNameParserRuleCall_1_6_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_VariableNameElementType() {
		return Expression_VariableName_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_VariableName_VariableAssignmentElementType() {
		return Expression_VariableName_VariableAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_VariableName_VariableNVariableAccessParserRuleCall_0ElementType() {
		return Expression_VariableName_VariableNVariableAccessParserRuleCall_0_ELEMENT_TYPE;
	}

}
