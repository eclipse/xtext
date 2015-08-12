package org.eclipse.xtext.testlanguages.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.testlanguages.idea.lang.psi.impl.SimpleExpressionsTestLanguageFileImpl;
import org.eclipse.xtext.testlanguages.services.SimpleExpressionsTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class SimpleExpressionsTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<SimpleExpressionsTestLanguageFileImpl>>(SimpleExpressionsTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final SimpleExpressionsTestLanguageGrammarAccess GRAMMAR_ACCESS = SimpleExpressionsTestLanguageLanguage.INSTANCE.getInstance(SimpleExpressionsTestLanguageGrammarAccess.class);

	private static class SequenceFactory {
		public static IGrammarAwareElementType createSequenceElementType() {
			return new IGrammarAwareElementType("Sequence_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSequenceRule());
		}
		public static IGrammarAwareElementType createSequence_GroupElementType() {
			return new IGrammarAwareElementType("Sequence_Group_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSequenceAccess().getGroup());
		}
		public static IGrammarAwareElementType createSequence_AdditionParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Sequence_AdditionParserRuleCall_0_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSequenceAccess().getAdditionParserRuleCall_0());
		}
		public static IGrammarAwareElementType createSequence_Group_1ElementType() {
			return new IGrammarAwareElementType("Sequence_Group_1_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSequenceAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createSequence_SequenceExpressionsAction_1_0ElementType() {
			return new IGrammarAwareElementType("Sequence_SequenceExpressionsAction_1_0_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSequenceAccess().getSequenceExpressionsAction_1_0());
		}
		public static IGrammarAwareElementType createSequence_ExpressionsAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Sequence_ExpressionsAssignment_1_1_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSequenceAccess().getExpressionsAssignment_1_1());
		}
		public static IGrammarAwareElementType createSequence_ExpressionsAdditionParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("Sequence_ExpressionsAdditionParserRuleCall_1_1_0_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSequenceAccess().getExpressionsAdditionParserRuleCall_1_1_0());
		}
	}

	public static final IGrammarAwareElementType Sequence_ELEMENT_TYPE = associate(SequenceFactory.createSequenceElementType());

	public static final IGrammarAwareElementType Sequence_Group_ELEMENT_TYPE = associate(SequenceFactory.createSequence_GroupElementType());

	public static final IGrammarAwareElementType Sequence_AdditionParserRuleCall_0_ELEMENT_TYPE = associate(SequenceFactory.createSequence_AdditionParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Sequence_Group_1_ELEMENT_TYPE = associate(SequenceFactory.createSequence_Group_1ElementType());

	public static final IGrammarAwareElementType Sequence_SequenceExpressionsAction_1_0_ELEMENT_TYPE = associate(SequenceFactory.createSequence_SequenceExpressionsAction_1_0ElementType());

	public static final IGrammarAwareElementType Sequence_ExpressionsAssignment_1_1_ELEMENT_TYPE = associate(SequenceFactory.createSequence_ExpressionsAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Sequence_ExpressionsAdditionParserRuleCall_1_1_0_ELEMENT_TYPE = associate(SequenceFactory.createSequence_ExpressionsAdditionParserRuleCall_1_1_0ElementType());

	private static class AdditionFactory {
		public static IGrammarAwareElementType createAdditionElementType() {
			return new IGrammarAwareElementType("Addition_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAdditionRule());
		}
		public static IGrammarAwareElementType createAddition_GroupElementType() {
			return new IGrammarAwareElementType("Addition_Group_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAdditionAccess().getGroup());
		}
		public static IGrammarAwareElementType createAddition_MultiplicationParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Addition_MultiplicationParserRuleCall_0_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAdditionAccess().getMultiplicationParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAddition_Group_1ElementType() {
			return new IGrammarAwareElementType("Addition_Group_1_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAdditionAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createAddition_OpValuesAction_1_0ElementType() {
			return new IGrammarAwareElementType("Addition_OpValuesAction_1_0_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAdditionAccess().getOpValuesAction_1_0());
		}
		public static IGrammarAwareElementType createAddition_OperatorAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Addition_OperatorAssignment_1_1_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAdditionAccess().getOperatorAssignment_1_1());
		}
		public static IGrammarAwareElementType createAddition_OperatorAlternatives_1_1_0ElementType() {
			return new IGrammarAwareElementType("Addition_OperatorAlternatives_1_1_0_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAdditionAccess().getOperatorAlternatives_1_1_0());
		}
		public static IGrammarAwareElementType createAddition_OperatorPlusSignKeyword_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("Addition_OperatorPlusSignKeyword_1_1_0_0_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAdditionAccess().getOperatorPlusSignKeyword_1_1_0_0());
		}
		public static IGrammarAwareElementType createAddition_OperatorHyphenMinusKeyword_1_1_0_1ElementType() {
			return new IGrammarAwareElementType("Addition_OperatorHyphenMinusKeyword_1_1_0_1_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAdditionAccess().getOperatorHyphenMinusKeyword_1_1_0_1());
		}
		public static IGrammarAwareElementType createAddition_ValuesAssignment_1_2ElementType() {
			return new IGrammarAwareElementType("Addition_ValuesAssignment_1_2_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAdditionAccess().getValuesAssignment_1_2());
		}
		public static IGrammarAwareElementType createAddition_ValuesMultiplicationParserRuleCall_1_2_0ElementType() {
			return new IGrammarAwareElementType("Addition_ValuesMultiplicationParserRuleCall_1_2_0_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAdditionAccess().getValuesMultiplicationParserRuleCall_1_2_0());
		}
	}

	public static final IGrammarAwareElementType Addition_ELEMENT_TYPE = associate(AdditionFactory.createAdditionElementType());

	public static final IGrammarAwareElementType Addition_Group_ELEMENT_TYPE = associate(AdditionFactory.createAddition_GroupElementType());

	public static final IGrammarAwareElementType Addition_MultiplicationParserRuleCall_0_ELEMENT_TYPE = associate(AdditionFactory.createAddition_MultiplicationParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Addition_Group_1_ELEMENT_TYPE = associate(AdditionFactory.createAddition_Group_1ElementType());

	public static final IGrammarAwareElementType Addition_OpValuesAction_1_0_ELEMENT_TYPE = associate(AdditionFactory.createAddition_OpValuesAction_1_0ElementType());

	public static final IGrammarAwareElementType Addition_OperatorAssignment_1_1_ELEMENT_TYPE = associate(AdditionFactory.createAddition_OperatorAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Addition_OperatorAlternatives_1_1_0_ELEMENT_TYPE = associate(AdditionFactory.createAddition_OperatorAlternatives_1_1_0ElementType());

	public static final IGrammarAwareElementType Addition_OperatorPlusSignKeyword_1_1_0_0_ELEMENT_TYPE = associate(AdditionFactory.createAddition_OperatorPlusSignKeyword_1_1_0_0ElementType());

	public static final IGrammarAwareElementType Addition_OperatorHyphenMinusKeyword_1_1_0_1_ELEMENT_TYPE = associate(AdditionFactory.createAddition_OperatorHyphenMinusKeyword_1_1_0_1ElementType());

	public static final IGrammarAwareElementType Addition_ValuesAssignment_1_2_ELEMENT_TYPE = associate(AdditionFactory.createAddition_ValuesAssignment_1_2ElementType());

	public static final IGrammarAwareElementType Addition_ValuesMultiplicationParserRuleCall_1_2_0_ELEMENT_TYPE = associate(AdditionFactory.createAddition_ValuesMultiplicationParserRuleCall_1_2_0ElementType());

	private static class MultiplicationFactory {
		public static IGrammarAwareElementType createMultiplicationElementType() {
			return new IGrammarAwareElementType("Multiplication_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiplicationRule());
		}
		public static IGrammarAwareElementType createMultiplication_GroupElementType() {
			return new IGrammarAwareElementType("Multiplication_Group_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiplicationAccess().getGroup());
		}
		public static IGrammarAwareElementType createMultiplication_TermParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Multiplication_TermParserRuleCall_0_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiplicationAccess().getTermParserRuleCall_0());
		}
		public static IGrammarAwareElementType createMultiplication_Group_1ElementType() {
			return new IGrammarAwareElementType("Multiplication_Group_1_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiplicationAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createMultiplication_OpValuesAction_1_0ElementType() {
			return new IGrammarAwareElementType("Multiplication_OpValuesAction_1_0_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiplicationAccess().getOpValuesAction_1_0());
		}
		public static IGrammarAwareElementType createMultiplication_OperatorAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Multiplication_OperatorAssignment_1_1_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiplicationAccess().getOperatorAssignment_1_1());
		}
		public static IGrammarAwareElementType createMultiplication_OperatorAlternatives_1_1_0ElementType() {
			return new IGrammarAwareElementType("Multiplication_OperatorAlternatives_1_1_0_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiplicationAccess().getOperatorAlternatives_1_1_0());
		}
		public static IGrammarAwareElementType createMultiplication_OperatorAsteriskKeyword_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("Multiplication_OperatorAsteriskKeyword_1_1_0_0_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiplicationAccess().getOperatorAsteriskKeyword_1_1_0_0());
		}
		public static IGrammarAwareElementType createMultiplication_OperatorSolidusKeyword_1_1_0_1ElementType() {
			return new IGrammarAwareElementType("Multiplication_OperatorSolidusKeyword_1_1_0_1_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiplicationAccess().getOperatorSolidusKeyword_1_1_0_1());
		}
		public static IGrammarAwareElementType createMultiplication_ValuesAssignment_1_2ElementType() {
			return new IGrammarAwareElementType("Multiplication_ValuesAssignment_1_2_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiplicationAccess().getValuesAssignment_1_2());
		}
		public static IGrammarAwareElementType createMultiplication_ValuesTermParserRuleCall_1_2_0ElementType() {
			return new IGrammarAwareElementType("Multiplication_ValuesTermParserRuleCall_1_2_0_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiplicationAccess().getValuesTermParserRuleCall_1_2_0());
		}
	}

	public static final IGrammarAwareElementType Multiplication_ELEMENT_TYPE = associate(MultiplicationFactory.createMultiplicationElementType());

	public static final IGrammarAwareElementType Multiplication_Group_ELEMENT_TYPE = associate(MultiplicationFactory.createMultiplication_GroupElementType());

	public static final IGrammarAwareElementType Multiplication_TermParserRuleCall_0_ELEMENT_TYPE = associate(MultiplicationFactory.createMultiplication_TermParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Multiplication_Group_1_ELEMENT_TYPE = associate(MultiplicationFactory.createMultiplication_Group_1ElementType());

	public static final IGrammarAwareElementType Multiplication_OpValuesAction_1_0_ELEMENT_TYPE = associate(MultiplicationFactory.createMultiplication_OpValuesAction_1_0ElementType());

	public static final IGrammarAwareElementType Multiplication_OperatorAssignment_1_1_ELEMENT_TYPE = associate(MultiplicationFactory.createMultiplication_OperatorAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Multiplication_OperatorAlternatives_1_1_0_ELEMENT_TYPE = associate(MultiplicationFactory.createMultiplication_OperatorAlternatives_1_1_0ElementType());

	public static final IGrammarAwareElementType Multiplication_OperatorAsteriskKeyword_1_1_0_0_ELEMENT_TYPE = associate(MultiplicationFactory.createMultiplication_OperatorAsteriskKeyword_1_1_0_0ElementType());

	public static final IGrammarAwareElementType Multiplication_OperatorSolidusKeyword_1_1_0_1_ELEMENT_TYPE = associate(MultiplicationFactory.createMultiplication_OperatorSolidusKeyword_1_1_0_1ElementType());

	public static final IGrammarAwareElementType Multiplication_ValuesAssignment_1_2_ELEMENT_TYPE = associate(MultiplicationFactory.createMultiplication_ValuesAssignment_1_2ElementType());

	public static final IGrammarAwareElementType Multiplication_ValuesTermParserRuleCall_1_2_0_ELEMENT_TYPE = associate(MultiplicationFactory.createMultiplication_ValuesTermParserRuleCall_1_2_0ElementType());

	private static class TermFactory {
		public static IGrammarAwareElementType createTermElementType() {
			return new IGrammarAwareElementType("Term_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermRule());
		}
		public static IGrammarAwareElementType createTerm_AlternativesElementType() {
			return new IGrammarAwareElementType("Term_Alternatives_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createTerm_AtomParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Term_AtomParserRuleCall_0_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getAtomParserRuleCall_0());
		}
		public static IGrammarAwareElementType createTerm_ParensParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Term_ParensParserRuleCall_1_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getParensParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType Term_ELEMENT_TYPE = associate(TermFactory.createTermElementType());

	public static final IGrammarAwareElementType Term_Alternatives_ELEMENT_TYPE = associate(TermFactory.createTerm_AlternativesElementType());

	public static final IGrammarAwareElementType Term_AtomParserRuleCall_0_ELEMENT_TYPE = associate(TermFactory.createTerm_AtomParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Term_ParensParserRuleCall_1_ELEMENT_TYPE = associate(TermFactory.createTerm_ParensParserRuleCall_1ElementType());

	private static class AtomFactory {
		public static IGrammarAwareElementType createAtomElementType() {
			return new IGrammarAwareElementType("Atom_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAtomRule());
		}
		public static IGrammarAwareElementType createAtom_NameAssignmentElementType() {
			return new IGrammarAwareElementType("Atom_NameAssignment_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAtomAccess().getNameAssignment());
		}
		public static IGrammarAwareElementType createAtom_NameIDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Atom_NameIDTerminalRuleCall_0_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAtomAccess().getNameIDTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Atom_ELEMENT_TYPE = associate(AtomFactory.createAtomElementType());

	public static final IGrammarAwareElementType Atom_NameAssignment_ELEMENT_TYPE = associate(AtomFactory.createAtom_NameAssignmentElementType());

	public static final IGrammarAwareElementType Atom_NameIDTerminalRuleCall_0_ELEMENT_TYPE = associate(AtomFactory.createAtom_NameIDTerminalRuleCall_0ElementType());

	private static class ParensFactory {
		public static IGrammarAwareElementType createParensElementType() {
			return new IGrammarAwareElementType("Parens_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParensRule());
		}
		public static IGrammarAwareElementType createParens_GroupElementType() {
			return new IGrammarAwareElementType("Parens_Group_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParensAccess().getGroup());
		}
		public static IGrammarAwareElementType createParens_LeftParenthesisKeyword_0ElementType() {
			return new IGrammarAwareElementType("Parens_LeftParenthesisKeyword_0_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParensAccess().getLeftParenthesisKeyword_0());
		}
		public static IGrammarAwareElementType createParens_AdditionParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Parens_AdditionParserRuleCall_1_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParensAccess().getAdditionParserRuleCall_1());
		}
		public static IGrammarAwareElementType createParens_RightParenthesisKeyword_2ElementType() {
			return new IGrammarAwareElementType("Parens_RightParenthesisKeyword_2_ELEMENT_TYPE", SimpleExpressionsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParensAccess().getRightParenthesisKeyword_2());
		}
	}

	public static final IGrammarAwareElementType Parens_ELEMENT_TYPE = associate(ParensFactory.createParensElementType());

	public static final IGrammarAwareElementType Parens_Group_ELEMENT_TYPE = associate(ParensFactory.createParens_GroupElementType());

	public static final IGrammarAwareElementType Parens_LeftParenthesisKeyword_0_ELEMENT_TYPE = associate(ParensFactory.createParens_LeftParenthesisKeyword_0ElementType());

	public static final IGrammarAwareElementType Parens_AdditionParserRuleCall_1_ELEMENT_TYPE = associate(ParensFactory.createParens_AdditionParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType Parens_RightParenthesisKeyword_2_ELEMENT_TYPE = associate(ParensFactory.createParens_RightParenthesisKeyword_2ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getSequenceElementType() {
		return Sequence_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSequence_GroupElementType() {
		return Sequence_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSequence_AdditionParserRuleCall_0ElementType() {
		return Sequence_AdditionParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSequence_Group_1ElementType() {
		return Sequence_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSequence_SequenceExpressionsAction_1_0ElementType() {
		return Sequence_SequenceExpressionsAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSequence_ExpressionsAssignment_1_1ElementType() {
		return Sequence_ExpressionsAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSequence_ExpressionsAdditionParserRuleCall_1_1_0ElementType() {
		return Sequence_ExpressionsAdditionParserRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAdditionElementType() {
		return Addition_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition_GroupElementType() {
		return Addition_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition_MultiplicationParserRuleCall_0ElementType() {
		return Addition_MultiplicationParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition_Group_1ElementType() {
		return Addition_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition_OpValuesAction_1_0ElementType() {
		return Addition_OpValuesAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition_OperatorAssignment_1_1ElementType() {
		return Addition_OperatorAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition_OperatorAlternatives_1_1_0ElementType() {
		return Addition_OperatorAlternatives_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition_OperatorPlusSignKeyword_1_1_0_0ElementType() {
		return Addition_OperatorPlusSignKeyword_1_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition_OperatorHyphenMinusKeyword_1_1_0_1ElementType() {
		return Addition_OperatorHyphenMinusKeyword_1_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition_ValuesAssignment_1_2ElementType() {
		return Addition_ValuesAssignment_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAddition_ValuesMultiplicationParserRuleCall_1_2_0ElementType() {
		return Addition_ValuesMultiplicationParserRuleCall_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiplicationElementType() {
		return Multiplication_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiplication_GroupElementType() {
		return Multiplication_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiplication_TermParserRuleCall_0ElementType() {
		return Multiplication_TermParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiplication_Group_1ElementType() {
		return Multiplication_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiplication_OpValuesAction_1_0ElementType() {
		return Multiplication_OpValuesAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiplication_OperatorAssignment_1_1ElementType() {
		return Multiplication_OperatorAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiplication_OperatorAlternatives_1_1_0ElementType() {
		return Multiplication_OperatorAlternatives_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiplication_OperatorAsteriskKeyword_1_1_0_0ElementType() {
		return Multiplication_OperatorAsteriskKeyword_1_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiplication_OperatorSolidusKeyword_1_1_0_1ElementType() {
		return Multiplication_OperatorSolidusKeyword_1_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiplication_ValuesAssignment_1_2ElementType() {
		return Multiplication_ValuesAssignment_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiplication_ValuesTermParserRuleCall_1_2_0ElementType() {
		return Multiplication_ValuesTermParserRuleCall_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTermElementType() {
		return Term_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_AlternativesElementType() {
		return Term_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_AtomParserRuleCall_0ElementType() {
		return Term_AtomParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_ParensParserRuleCall_1ElementType() {
		return Term_ParensParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAtomElementType() {
		return Atom_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAtom_NameAssignmentElementType() {
		return Atom_NameAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAtom_NameIDTerminalRuleCall_0ElementType() {
		return Atom_NameIDTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParensElementType() {
		return Parens_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParens_GroupElementType() {
		return Parens_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParens_LeftParenthesisKeyword_0ElementType() {
		return Parens_LeftParenthesisKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParens_AdditionParserRuleCall_1ElementType() {
		return Parens_AdditionParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParens_RightParenthesisKeyword_2ElementType() {
		return Parens_RightParenthesisKeyword_2_ELEMENT_TYPE;
	}

}
