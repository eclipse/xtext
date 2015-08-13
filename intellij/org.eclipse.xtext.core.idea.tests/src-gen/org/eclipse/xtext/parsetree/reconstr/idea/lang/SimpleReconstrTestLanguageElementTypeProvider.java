package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.psi.impl.SimpleReconstrTestLanguageFileImpl;
import org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class SimpleReconstrTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<SimpleReconstrTestLanguageFileImpl>>(SimpleReconstrTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final SimpleReconstrTestLanguageGrammarAccess GRAMMAR_ACCESS = SimpleReconstrTestLanguageLanguage.INSTANCE.getInstance(SimpleReconstrTestLanguageGrammarAccess.class);

	private static class OpFactory {
		public static IGrammarAwareElementType createOpElementType() {
			return new IGrammarAwareElementType("Op_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOpRule());
		}
		public static IGrammarAwareElementType createOp_GroupElementType() {
			return new IGrammarAwareElementType("Op_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOpAccess().getGroup());
		}
		public static IGrammarAwareElementType createOp_TermParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Op_TermParserRuleCall_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOpAccess().getTermParserRuleCall_0());
		}
		public static IGrammarAwareElementType createOp_Group_1ElementType() {
			return new IGrammarAwareElementType("Op_Group_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOpAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createOp_OpValuesAction_1_0ElementType() {
			return new IGrammarAwareElementType("Op_OpValuesAction_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOpAccess().getOpValuesAction_1_0());
		}
		public static IGrammarAwareElementType createOp_ValuesAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Op_ValuesAssignment_1_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOpAccess().getValuesAssignment_1_1());
		}
		public static IGrammarAwareElementType createOp_ValuesTermParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("Op_ValuesTermParserRuleCall_1_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOpAccess().getValuesTermParserRuleCall_1_1_0());
		}
	}

	public static final IGrammarAwareElementType Op_ELEMENT_TYPE = associate(OpFactory.createOpElementType());

	public static final IGrammarAwareElementType Op_Group_ELEMENT_TYPE = associate(OpFactory.createOp_GroupElementType());

	public static final IGrammarAwareElementType Op_TermParserRuleCall_0_ELEMENT_TYPE = associate(OpFactory.createOp_TermParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Op_Group_1_ELEMENT_TYPE = associate(OpFactory.createOp_Group_1ElementType());

	public static final IGrammarAwareElementType Op_OpValuesAction_1_0_ELEMENT_TYPE = associate(OpFactory.createOp_OpValuesAction_1_0ElementType());

	public static final IGrammarAwareElementType Op_ValuesAssignment_1_1_ELEMENT_TYPE = associate(OpFactory.createOp_ValuesAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Op_ValuesTermParserRuleCall_1_1_0_ELEMENT_TYPE = associate(OpFactory.createOp_ValuesTermParserRuleCall_1_1_0ElementType());

	private static class TermFactory {
		public static IGrammarAwareElementType createTermElementType() {
			return new IGrammarAwareElementType("Term_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermRule());
		}
		public static IGrammarAwareElementType createTerm_AlternativesElementType() {
			return new IGrammarAwareElementType("Term_Alternatives_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createTerm_AtomParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Term_AtomParserRuleCall_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getAtomParserRuleCall_0());
		}
		public static IGrammarAwareElementType createTerm_TwoNumbersParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Term_TwoNumbersParserRuleCall_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getTwoNumbersParserRuleCall_1());
		}
		public static IGrammarAwareElementType createTerm_ManyStringsParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("Term_ManyStringsParserRuleCall_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getManyStringsParserRuleCall_2());
		}
		public static IGrammarAwareElementType createTerm_TypeParserRuleCall_3ElementType() {
			return new IGrammarAwareElementType("Term_TypeParserRuleCall_3_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getTypeParserRuleCall_3());
		}
		public static IGrammarAwareElementType createTerm_Ref2ParserRuleCall_4ElementType() {
			return new IGrammarAwareElementType("Term_Ref2ParserRuleCall_4_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getRef2ParserRuleCall_4());
		}
		public static IGrammarAwareElementType createTerm_SpareParserRuleCall_5ElementType() {
			return new IGrammarAwareElementType("Term_SpareParserRuleCall_5_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getSpareParserRuleCall_5());
		}
		public static IGrammarAwareElementType createTerm_BooleanParserRuleCall_6ElementType() {
			return new IGrammarAwareElementType("Term_BooleanParserRuleCall_6_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getBooleanParserRuleCall_6());
		}
		public static IGrammarAwareElementType createTerm_Transient1ParserRuleCall_7ElementType() {
			return new IGrammarAwareElementType("Term_Transient1ParserRuleCall_7_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getTransient1ParserRuleCall_7());
		}
		public static IGrammarAwareElementType createTerm_Consumed1ParserRuleCall_8ElementType() {
			return new IGrammarAwareElementType("Term_Consumed1ParserRuleCall_8_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getConsumed1ParserRuleCall_8());
		}
		public static IGrammarAwareElementType createTerm_Consumed2ParserRuleCall_9ElementType() {
			return new IGrammarAwareElementType("Term_Consumed2ParserRuleCall_9_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getConsumed2ParserRuleCall_9());
		}
		public static IGrammarAwareElementType createTerm_Loop1ParserRuleCall_10ElementType() {
			return new IGrammarAwareElementType("Term_Loop1ParserRuleCall_10_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getLoop1ParserRuleCall_10());
		}
		public static IGrammarAwareElementType createTerm_Loop2ParserRuleCall_11ElementType() {
			return new IGrammarAwareElementType("Term_Loop2ParserRuleCall_11_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getLoop2ParserRuleCall_11());
		}
		public static IGrammarAwareElementType createTerm_Loop3ParserRuleCall_12ElementType() {
			return new IGrammarAwareElementType("Term_Loop3ParserRuleCall_12_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getLoop3ParserRuleCall_12());
		}
		public static IGrammarAwareElementType createTerm_Loop4ParserRuleCall_13ElementType() {
			return new IGrammarAwareElementType("Term_Loop4ParserRuleCall_13_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getLoop4ParserRuleCall_13());
		}
		public static IGrammarAwareElementType createTerm_LoopBug285452ParserRuleCall_14ElementType() {
			return new IGrammarAwareElementType("Term_LoopBug285452ParserRuleCall_14_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getLoopBug285452ParserRuleCall_14());
		}
		public static IGrammarAwareElementType createTerm_DuplicateBug284491ParserRuleCall_15ElementType() {
			return new IGrammarAwareElementType("Term_DuplicateBug284491ParserRuleCall_15_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getDuplicateBug284491ParserRuleCall_15());
		}
		public static IGrammarAwareElementType createTerm_EmptyObjectBug284850ParserRuleCall_16ElementType() {
			return new IGrammarAwareElementType("Term_EmptyObjectBug284850ParserRuleCall_16_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getEmptyObjectBug284850ParserRuleCall_16());
		}
		public static IGrammarAwareElementType createTerm_MultiInheritanceBug280439ParserRuleCall_17ElementType() {
			return new IGrammarAwareElementType("Term_MultiInheritanceBug280439ParserRuleCall_17_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getMultiInheritanceBug280439ParserRuleCall_17());
		}
		public static IGrammarAwareElementType createTerm_EObjectRefParserRuleCall_18ElementType() {
			return new IGrammarAwareElementType("Term_EObjectRefParserRuleCall_18_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getEObjectRefParserRuleCall_18());
		}
		public static IGrammarAwareElementType createTerm_TypeBug305577_1ParserRuleCall_19ElementType() {
			return new IGrammarAwareElementType("Term_TypeBug305577_1ParserRuleCall_19_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getTypeBug305577_1ParserRuleCall_19());
		}
		public static IGrammarAwareElementType createTerm_TypeBug305577_2ParserRuleCall_20ElementType() {
			return new IGrammarAwareElementType("Term_TypeBug305577_2ParserRuleCall_20_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getTypeBug305577_2ParserRuleCall_20());
		}
		public static IGrammarAwareElementType createTerm_ParensParserRuleCall_21ElementType() {
			return new IGrammarAwareElementType("Term_ParensParserRuleCall_21_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getParensParserRuleCall_21());
		}
		public static IGrammarAwareElementType createTerm_Bug305171ParserRuleCall_22ElementType() {
			return new IGrammarAwareElementType("Term_Bug305171ParserRuleCall_22_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getBug305171ParserRuleCall_22());
		}
		public static IGrammarAwareElementType createTerm_Bug310435ValParserRuleCall_23ElementType() {
			return new IGrammarAwareElementType("Term_Bug310435ValParserRuleCall_23_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getBug310435ValParserRuleCall_23());
		}
		public static IGrammarAwareElementType createTerm_Bug310435EnumParserRuleCall_24ElementType() {
			return new IGrammarAwareElementType("Term_Bug310435EnumParserRuleCall_24_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getBug310435EnumParserRuleCall_24());
		}
		public static IGrammarAwareElementType createTerm_CrossRefNameTestParserRuleCall_25ElementType() {
			return new IGrammarAwareElementType("Term_CrossRefNameTestParserRuleCall_25_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getCrossRefNameTestParserRuleCall_25());
		}
	}

	public static final IGrammarAwareElementType Term_ELEMENT_TYPE = associate(TermFactory.createTermElementType());

	public static final IGrammarAwareElementType Term_Alternatives_ELEMENT_TYPE = associate(TermFactory.createTerm_AlternativesElementType());

	public static final IGrammarAwareElementType Term_AtomParserRuleCall_0_ELEMENT_TYPE = associate(TermFactory.createTerm_AtomParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Term_TwoNumbersParserRuleCall_1_ELEMENT_TYPE = associate(TermFactory.createTerm_TwoNumbersParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType Term_ManyStringsParserRuleCall_2_ELEMENT_TYPE = associate(TermFactory.createTerm_ManyStringsParserRuleCall_2ElementType());

	public static final IGrammarAwareElementType Term_TypeParserRuleCall_3_ELEMENT_TYPE = associate(TermFactory.createTerm_TypeParserRuleCall_3ElementType());

	public static final IGrammarAwareElementType Term_Ref2ParserRuleCall_4_ELEMENT_TYPE = associate(TermFactory.createTerm_Ref2ParserRuleCall_4ElementType());

	public static final IGrammarAwareElementType Term_SpareParserRuleCall_5_ELEMENT_TYPE = associate(TermFactory.createTerm_SpareParserRuleCall_5ElementType());

	public static final IGrammarAwareElementType Term_BooleanParserRuleCall_6_ELEMENT_TYPE = associate(TermFactory.createTerm_BooleanParserRuleCall_6ElementType());

	public static final IGrammarAwareElementType Term_Transient1ParserRuleCall_7_ELEMENT_TYPE = associate(TermFactory.createTerm_Transient1ParserRuleCall_7ElementType());

	public static final IGrammarAwareElementType Term_Consumed1ParserRuleCall_8_ELEMENT_TYPE = associate(TermFactory.createTerm_Consumed1ParserRuleCall_8ElementType());

	public static final IGrammarAwareElementType Term_Consumed2ParserRuleCall_9_ELEMENT_TYPE = associate(TermFactory.createTerm_Consumed2ParserRuleCall_9ElementType());

	public static final IGrammarAwareElementType Term_Loop1ParserRuleCall_10_ELEMENT_TYPE = associate(TermFactory.createTerm_Loop1ParserRuleCall_10ElementType());

	public static final IGrammarAwareElementType Term_Loop2ParserRuleCall_11_ELEMENT_TYPE = associate(TermFactory.createTerm_Loop2ParserRuleCall_11ElementType());

	public static final IGrammarAwareElementType Term_Loop3ParserRuleCall_12_ELEMENT_TYPE = associate(TermFactory.createTerm_Loop3ParserRuleCall_12ElementType());

	public static final IGrammarAwareElementType Term_Loop4ParserRuleCall_13_ELEMENT_TYPE = associate(TermFactory.createTerm_Loop4ParserRuleCall_13ElementType());

	public static final IGrammarAwareElementType Term_LoopBug285452ParserRuleCall_14_ELEMENT_TYPE = associate(TermFactory.createTerm_LoopBug285452ParserRuleCall_14ElementType());

	public static final IGrammarAwareElementType Term_DuplicateBug284491ParserRuleCall_15_ELEMENT_TYPE = associate(TermFactory.createTerm_DuplicateBug284491ParserRuleCall_15ElementType());

	public static final IGrammarAwareElementType Term_EmptyObjectBug284850ParserRuleCall_16_ELEMENT_TYPE = associate(TermFactory.createTerm_EmptyObjectBug284850ParserRuleCall_16ElementType());

	public static final IGrammarAwareElementType Term_MultiInheritanceBug280439ParserRuleCall_17_ELEMENT_TYPE = associate(TermFactory.createTerm_MultiInheritanceBug280439ParserRuleCall_17ElementType());

	public static final IGrammarAwareElementType Term_EObjectRefParserRuleCall_18_ELEMENT_TYPE = associate(TermFactory.createTerm_EObjectRefParserRuleCall_18ElementType());

	public static final IGrammarAwareElementType Term_TypeBug305577_1ParserRuleCall_19_ELEMENT_TYPE = associate(TermFactory.createTerm_TypeBug305577_1ParserRuleCall_19ElementType());

	public static final IGrammarAwareElementType Term_TypeBug305577_2ParserRuleCall_20_ELEMENT_TYPE = associate(TermFactory.createTerm_TypeBug305577_2ParserRuleCall_20ElementType());

	public static final IGrammarAwareElementType Term_ParensParserRuleCall_21_ELEMENT_TYPE = associate(TermFactory.createTerm_ParensParserRuleCall_21ElementType());

	public static final IGrammarAwareElementType Term_Bug305171ParserRuleCall_22_ELEMENT_TYPE = associate(TermFactory.createTerm_Bug305171ParserRuleCall_22ElementType());

	public static final IGrammarAwareElementType Term_Bug310435ValParserRuleCall_23_ELEMENT_TYPE = associate(TermFactory.createTerm_Bug310435ValParserRuleCall_23ElementType());

	public static final IGrammarAwareElementType Term_Bug310435EnumParserRuleCall_24_ELEMENT_TYPE = associate(TermFactory.createTerm_Bug310435EnumParserRuleCall_24ElementType());

	public static final IGrammarAwareElementType Term_CrossRefNameTestParserRuleCall_25_ELEMENT_TYPE = associate(TermFactory.createTerm_CrossRefNameTestParserRuleCall_25ElementType());

	private static class AtomFactory {
		public static IGrammarAwareElementType createAtomElementType() {
			return new IGrammarAwareElementType("Atom_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAtomRule());
		}
		public static IGrammarAwareElementType createAtom_NameAssignmentElementType() {
			return new IGrammarAwareElementType("Atom_NameAssignment_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAtomAccess().getNameAssignment());
		}
		public static IGrammarAwareElementType createAtom_NameIDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Atom_NameIDTerminalRuleCall_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAtomAccess().getNameIDTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Atom_ELEMENT_TYPE = associate(AtomFactory.createAtomElementType());

	public static final IGrammarAwareElementType Atom_NameAssignment_ELEMENT_TYPE = associate(AtomFactory.createAtom_NameAssignmentElementType());

	public static final IGrammarAwareElementType Atom_NameIDTerminalRuleCall_0_ELEMENT_TYPE = associate(AtomFactory.createAtom_NameIDTerminalRuleCall_0ElementType());

	private static class ParensFactory {
		public static IGrammarAwareElementType createParensElementType() {
			return new IGrammarAwareElementType("Parens_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParensRule());
		}
		public static IGrammarAwareElementType createParens_GroupElementType() {
			return new IGrammarAwareElementType("Parens_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParensAccess().getGroup());
		}
		public static IGrammarAwareElementType createParens_LeftParenthesisKeyword_0ElementType() {
			return new IGrammarAwareElementType("Parens_LeftParenthesisKeyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParensAccess().getLeftParenthesisKeyword_0());
		}
		public static IGrammarAwareElementType createParens_OpParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Parens_OpParserRuleCall_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParensAccess().getOpParserRuleCall_1());
		}
		public static IGrammarAwareElementType createParens_RightParenthesisKeyword_2ElementType() {
			return new IGrammarAwareElementType("Parens_RightParenthesisKeyword_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParensAccess().getRightParenthesisKeyword_2());
		}
		public static IGrammarAwareElementType createParens_EmAssignment_3ElementType() {
			return new IGrammarAwareElementType("Parens_EmAssignment_3_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParensAccess().getEmAssignment_3());
		}
		public static IGrammarAwareElementType createParens_EmExclamationMarkKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("Parens_EmExclamationMarkKeyword_3_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParensAccess().getEmExclamationMarkKeyword_3_0());
		}
	}

	public static final IGrammarAwareElementType Parens_ELEMENT_TYPE = associate(ParensFactory.createParensElementType());

	public static final IGrammarAwareElementType Parens_Group_ELEMENT_TYPE = associate(ParensFactory.createParens_GroupElementType());

	public static final IGrammarAwareElementType Parens_LeftParenthesisKeyword_0_ELEMENT_TYPE = associate(ParensFactory.createParens_LeftParenthesisKeyword_0ElementType());

	public static final IGrammarAwareElementType Parens_OpParserRuleCall_1_ELEMENT_TYPE = associate(ParensFactory.createParens_OpParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType Parens_RightParenthesisKeyword_2_ELEMENT_TYPE = associate(ParensFactory.createParens_RightParenthesisKeyword_2ElementType());

	public static final IGrammarAwareElementType Parens_EmAssignment_3_ELEMENT_TYPE = associate(ParensFactory.createParens_EmAssignment_3ElementType());

	public static final IGrammarAwareElementType Parens_EmExclamationMarkKeyword_3_0_ELEMENT_TYPE = associate(ParensFactory.createParens_EmExclamationMarkKeyword_3_0ElementType());

	private static class TwoNumbersFactory {
		public static IGrammarAwareElementType createTwoNumbersElementType() {
			return new IGrammarAwareElementType("TwoNumbers_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoNumbersRule());
		}
		public static IGrammarAwareElementType createTwoNumbers_GroupElementType() {
			return new IGrammarAwareElementType("TwoNumbers_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoNumbersAccess().getGroup());
		}
		public static IGrammarAwareElementType createTwoNumbers_Num1Assignment_0ElementType() {
			return new IGrammarAwareElementType("TwoNumbers_Num1Assignment_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoNumbersAccess().getNum1Assignment_0());
		}
		public static IGrammarAwareElementType createTwoNumbers_Num1INTTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("TwoNumbers_Num1INTTerminalRuleCall_0_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoNumbersAccess().getNum1INTTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createTwoNumbers_Num2Assignment_1ElementType() {
			return new IGrammarAwareElementType("TwoNumbers_Num2Assignment_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoNumbersAccess().getNum2Assignment_1());
		}
		public static IGrammarAwareElementType createTwoNumbers_Num2INTTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("TwoNumbers_Num2INTTerminalRuleCall_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoNumbersAccess().getNum2INTTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createTwoNumbers_Group_2ElementType() {
			return new IGrammarAwareElementType("TwoNumbers_Group_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoNumbersAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createTwoNumbers_NumberSignKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("TwoNumbers_NumberSignKeyword_2_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoNumbersAccess().getNumberSignKeyword_2_0());
		}
		public static IGrammarAwareElementType createTwoNumbers_Num3Assignment_2_1ElementType() {
			return new IGrammarAwareElementType("TwoNumbers_Num3Assignment_2_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoNumbersAccess().getNum3Assignment_2_1());
		}
		public static IGrammarAwareElementType createTwoNumbers_Num3INTTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("TwoNumbers_Num3INTTerminalRuleCall_2_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTwoNumbersAccess().getNum3INTTerminalRuleCall_2_1_0());
		}
	}

	public static final IGrammarAwareElementType TwoNumbers_ELEMENT_TYPE = associate(TwoNumbersFactory.createTwoNumbersElementType());

	public static final IGrammarAwareElementType TwoNumbers_Group_ELEMENT_TYPE = associate(TwoNumbersFactory.createTwoNumbers_GroupElementType());

	public static final IGrammarAwareElementType TwoNumbers_Num1Assignment_0_ELEMENT_TYPE = associate(TwoNumbersFactory.createTwoNumbers_Num1Assignment_0ElementType());

	public static final IGrammarAwareElementType TwoNumbers_Num1INTTerminalRuleCall_0_0_ELEMENT_TYPE = associate(TwoNumbersFactory.createTwoNumbers_Num1INTTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType TwoNumbers_Num2Assignment_1_ELEMENT_TYPE = associate(TwoNumbersFactory.createTwoNumbers_Num2Assignment_1ElementType());

	public static final IGrammarAwareElementType TwoNumbers_Num2INTTerminalRuleCall_1_0_ELEMENT_TYPE = associate(TwoNumbersFactory.createTwoNumbers_Num2INTTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType TwoNumbers_Group_2_ELEMENT_TYPE = associate(TwoNumbersFactory.createTwoNumbers_Group_2ElementType());

	public static final IGrammarAwareElementType TwoNumbers_NumberSignKeyword_2_0_ELEMENT_TYPE = associate(TwoNumbersFactory.createTwoNumbers_NumberSignKeyword_2_0ElementType());

	public static final IGrammarAwareElementType TwoNumbers_Num3Assignment_2_1_ELEMENT_TYPE = associate(TwoNumbersFactory.createTwoNumbers_Num3Assignment_2_1ElementType());

	public static final IGrammarAwareElementType TwoNumbers_Num3INTTerminalRuleCall_2_1_0_ELEMENT_TYPE = associate(TwoNumbersFactory.createTwoNumbers_Num3INTTerminalRuleCall_2_1_0ElementType());

	private static class ManyStringsFactory {
		public static IGrammarAwareElementType createManyStringsElementType() {
			return new IGrammarAwareElementType("ManyStrings_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getManyStringsRule());
		}
		public static IGrammarAwareElementType createManyStrings_GroupElementType() {
			return new IGrammarAwareElementType("ManyStrings_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getManyStringsAccess().getGroup());
		}
		public static IGrammarAwareElementType createManyStrings_EqualsSignKeyword_0ElementType() {
			return new IGrammarAwareElementType("ManyStrings_EqualsSignKeyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getManyStringsAccess().getEqualsSignKeyword_0());
		}
		public static IGrammarAwareElementType createManyStrings_Str1Assignment_1ElementType() {
			return new IGrammarAwareElementType("ManyStrings_Str1Assignment_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getManyStringsAccess().getStr1Assignment_1());
		}
		public static IGrammarAwareElementType createManyStrings_Str1STRINGTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("ManyStrings_Str1STRINGTerminalRuleCall_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getManyStringsAccess().getStr1STRINGTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createManyStrings_Str2Assignment_2ElementType() {
			return new IGrammarAwareElementType("ManyStrings_Str2Assignment_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getManyStringsAccess().getStr2Assignment_2());
		}
		public static IGrammarAwareElementType createManyStrings_Str2STRINGTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("ManyStrings_Str2STRINGTerminalRuleCall_2_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getManyStringsAccess().getStr2STRINGTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType ManyStrings_ELEMENT_TYPE = associate(ManyStringsFactory.createManyStringsElementType());

	public static final IGrammarAwareElementType ManyStrings_Group_ELEMENT_TYPE = associate(ManyStringsFactory.createManyStrings_GroupElementType());

	public static final IGrammarAwareElementType ManyStrings_EqualsSignKeyword_0_ELEMENT_TYPE = associate(ManyStringsFactory.createManyStrings_EqualsSignKeyword_0ElementType());

	public static final IGrammarAwareElementType ManyStrings_Str1Assignment_1_ELEMENT_TYPE = associate(ManyStringsFactory.createManyStrings_Str1Assignment_1ElementType());

	public static final IGrammarAwareElementType ManyStrings_Str1STRINGTerminalRuleCall_1_0_ELEMENT_TYPE = associate(ManyStringsFactory.createManyStrings_Str1STRINGTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType ManyStrings_Str2Assignment_2_ELEMENT_TYPE = associate(ManyStringsFactory.createManyStrings_Str2Assignment_2ElementType());

	public static final IGrammarAwareElementType ManyStrings_Str2STRINGTerminalRuleCall_2_0_ELEMENT_TYPE = associate(ManyStringsFactory.createManyStrings_Str2STRINGTerminalRuleCall_2_0ElementType());

	private static class TypeFactory {
		public static IGrammarAwareElementType createTypeElementType() {
			return new IGrammarAwareElementType("Type_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeRule());
		}
		public static IGrammarAwareElementType createType_GroupElementType() {
			return new IGrammarAwareElementType("Type_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getGroup());
		}
		public static IGrammarAwareElementType createType_TypeKeyword_0ElementType() {
			return new IGrammarAwareElementType("Type_TypeKeyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getTypeKeyword_0());
		}
		public static IGrammarAwareElementType createType_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Type_NameAssignment_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createType_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Type_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createType_ExtendsKeyword_2ElementType() {
			return new IGrammarAwareElementType("Type_ExtendsKeyword_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getExtendsKeyword_2());
		}
		public static IGrammarAwareElementType createType_ExtendsAssignment_3ElementType() {
			return new IGrammarAwareElementType("Type_ExtendsAssignment_3_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getExtendsAssignment_3());
		}
		public static IGrammarAwareElementType createType_ExtendsTypeCrossReference_3_0ElementType() {
			return new IGrammarAwareElementType("Type_ExtendsTypeCrossReference_3_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getExtendsTypeCrossReference_3_0());
		}
		public static IGrammarAwareElementType createType_ExtendsTypeIDTerminalRuleCall_3_0_1ElementType() {
			return new IGrammarAwareElementType("Type_ExtendsTypeIDTerminalRuleCall_3_0_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getExtendsTypeIDTerminalRuleCall_3_0_1());
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

	private static class Ref2Factory {
		public static IGrammarAwareElementType createRef2ElementType() {
			return new IGrammarAwareElementType("Ref2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRef2Rule());
		}
		public static IGrammarAwareElementType createRef2_GroupElementType() {
			return new IGrammarAwareElementType("Ref2_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRef2Access().getGroup());
		}
		public static IGrammarAwareElementType createRef2_NumberSignDigitTwoKeyword_0ElementType() {
			return new IGrammarAwareElementType("Ref2_NumberSignDigitTwoKeyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRef2Access().getNumberSignDigitTwoKeyword_0());
		}
		public static IGrammarAwareElementType createRef2_Ref2Assignment_1ElementType() {
			return new IGrammarAwareElementType("Ref2_Ref2Assignment_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRef2Access().getRef2Assignment_1());
		}
		public static IGrammarAwareElementType createRef2_Ref2Alternatives_1_0ElementType() {
			return new IGrammarAwareElementType("Ref2_Ref2Alternatives_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRef2Access().getRef2Alternatives_1_0());
		}
		public static IGrammarAwareElementType createRef2_Ref2Mykeyword1Keyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("Ref2_Ref2Mykeyword1Keyword_1_0_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRef2Access().getRef2Mykeyword1Keyword_1_0_0());
		}
		public static IGrammarAwareElementType createRef2_Ref2STRINGTerminalRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("Ref2_Ref2STRINGTerminalRuleCall_1_0_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRef2Access().getRef2STRINGTerminalRuleCall_1_0_1());
		}
		public static IGrammarAwareElementType createRef2_Ref2Mykeyword2Keyword_1_0_2ElementType() {
			return new IGrammarAwareElementType("Ref2_Ref2Mykeyword2Keyword_1_0_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRef2Access().getRef2Mykeyword2Keyword_1_0_2());
		}
	}

	public static final IGrammarAwareElementType Ref2_ELEMENT_TYPE = associate(Ref2Factory.createRef2ElementType());

	public static final IGrammarAwareElementType Ref2_Group_ELEMENT_TYPE = associate(Ref2Factory.createRef2_GroupElementType());

	public static final IGrammarAwareElementType Ref2_NumberSignDigitTwoKeyword_0_ELEMENT_TYPE = associate(Ref2Factory.createRef2_NumberSignDigitTwoKeyword_0ElementType());

	public static final IGrammarAwareElementType Ref2_Ref2Assignment_1_ELEMENT_TYPE = associate(Ref2Factory.createRef2_Ref2Assignment_1ElementType());

	public static final IGrammarAwareElementType Ref2_Ref2Alternatives_1_0_ELEMENT_TYPE = associate(Ref2Factory.createRef2_Ref2Alternatives_1_0ElementType());

	public static final IGrammarAwareElementType Ref2_Ref2Mykeyword1Keyword_1_0_0_ELEMENT_TYPE = associate(Ref2Factory.createRef2_Ref2Mykeyword1Keyword_1_0_0ElementType());

	public static final IGrammarAwareElementType Ref2_Ref2STRINGTerminalRuleCall_1_0_1_ELEMENT_TYPE = associate(Ref2Factory.createRef2_Ref2STRINGTerminalRuleCall_1_0_1ElementType());

	public static final IGrammarAwareElementType Ref2_Ref2Mykeyword2Keyword_1_0_2_ELEMENT_TYPE = associate(Ref2Factory.createRef2_Ref2Mykeyword2Keyword_1_0_2ElementType());

	private static class SpareFactory {
		public static IGrammarAwareElementType createSpareElementType() {
			return new IGrammarAwareElementType("Spare_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpareRule());
		}
		public static IGrammarAwareElementType createSpare_GroupElementType() {
			return new IGrammarAwareElementType("Spare_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpareAccess().getGroup());
		}
		public static IGrammarAwareElementType createSpare_NumberSignDigitThreeKeyword_0ElementType() {
			return new IGrammarAwareElementType("Spare_NumberSignDigitThreeKeyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpareAccess().getNumberSignDigitThreeKeyword_0());
		}
		public static IGrammarAwareElementType createSpare_IdAssignment_1ElementType() {
			return new IGrammarAwareElementType("Spare_IdAssignment_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpareAccess().getIdAssignment_1());
		}
		public static IGrammarAwareElementType createSpare_IdIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Spare_IdIDTerminalRuleCall_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpareAccess().getIdIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createSpare_Group_2ElementType() {
			return new IGrammarAwareElementType("Spare_Group_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpareAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createSpare_FullStopKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Spare_FullStopKeyword_2_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpareAccess().getFullStopKeyword_2_0());
		}
		public static IGrammarAwareElementType createSpare_IdAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("Spare_IdAssignment_2_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpareAccess().getIdAssignment_2_1());
		}
		public static IGrammarAwareElementType createSpare_IdIDTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("Spare_IdIDTerminalRuleCall_2_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpareAccess().getIdIDTerminalRuleCall_2_1_0());
		}
	}

	public static final IGrammarAwareElementType Spare_ELEMENT_TYPE = associate(SpareFactory.createSpareElementType());

	public static final IGrammarAwareElementType Spare_Group_ELEMENT_TYPE = associate(SpareFactory.createSpare_GroupElementType());

	public static final IGrammarAwareElementType Spare_NumberSignDigitThreeKeyword_0_ELEMENT_TYPE = associate(SpareFactory.createSpare_NumberSignDigitThreeKeyword_0ElementType());

	public static final IGrammarAwareElementType Spare_IdAssignment_1_ELEMENT_TYPE = associate(SpareFactory.createSpare_IdAssignment_1ElementType());

	public static final IGrammarAwareElementType Spare_IdIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(SpareFactory.createSpare_IdIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Spare_Group_2_ELEMENT_TYPE = associate(SpareFactory.createSpare_Group_2ElementType());

	public static final IGrammarAwareElementType Spare_FullStopKeyword_2_0_ELEMENT_TYPE = associate(SpareFactory.createSpare_FullStopKeyword_2_0ElementType());

	public static final IGrammarAwareElementType Spare_IdAssignment_2_1_ELEMENT_TYPE = associate(SpareFactory.createSpare_IdAssignment_2_1ElementType());

	public static final IGrammarAwareElementType Spare_IdIDTerminalRuleCall_2_1_0_ELEMENT_TYPE = associate(SpareFactory.createSpare_IdIDTerminalRuleCall_2_1_0ElementType());

	private static class BooleanFactory {
		public static IGrammarAwareElementType createBooleanElementType() {
			return new IGrammarAwareElementType("Boolean_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanRule());
		}
		public static IGrammarAwareElementType createBoolean_GroupElementType() {
			return new IGrammarAwareElementType("Boolean_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanAccess().getGroup());
		}
		public static IGrammarAwareElementType createBoolean_NumberSignDigitFourKeyword_0ElementType() {
			return new IGrammarAwareElementType("Boolean_NumberSignDigitFourKeyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanAccess().getNumberSignDigitFourKeyword_0());
		}
		public static IGrammarAwareElementType createBoolean_BoolAssignment_1ElementType() {
			return new IGrammarAwareElementType("Boolean_BoolAssignment_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanAccess().getBoolAssignment_1());
		}
		public static IGrammarAwareElementType createBoolean_BoolMyoptionKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Boolean_BoolMyoptionKeyword_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanAccess().getBoolMyoptionKeyword_1_0());
		}
		public static IGrammarAwareElementType createBoolean_KwKeyword_2ElementType() {
			return new IGrammarAwareElementType("Boolean_KwKeyword_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanAccess().getKwKeyword_2());
		}
		public static IGrammarAwareElementType createBoolean_ValueAssignment_3ElementType() {
			return new IGrammarAwareElementType("Boolean_ValueAssignment_3_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanAccess().getValueAssignment_3());
		}
		public static IGrammarAwareElementType createBoolean_ValueIDTerminalRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("Boolean_ValueIDTerminalRuleCall_3_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBooleanAccess().getValueIDTerminalRuleCall_3_0());
		}
	}

	public static final IGrammarAwareElementType Boolean_ELEMENT_TYPE = associate(BooleanFactory.createBooleanElementType());

	public static final IGrammarAwareElementType Boolean_Group_ELEMENT_TYPE = associate(BooleanFactory.createBoolean_GroupElementType());

	public static final IGrammarAwareElementType Boolean_NumberSignDigitFourKeyword_0_ELEMENT_TYPE = associate(BooleanFactory.createBoolean_NumberSignDigitFourKeyword_0ElementType());

	public static final IGrammarAwareElementType Boolean_BoolAssignment_1_ELEMENT_TYPE = associate(BooleanFactory.createBoolean_BoolAssignment_1ElementType());

	public static final IGrammarAwareElementType Boolean_BoolMyoptionKeyword_1_0_ELEMENT_TYPE = associate(BooleanFactory.createBoolean_BoolMyoptionKeyword_1_0ElementType());

	public static final IGrammarAwareElementType Boolean_KwKeyword_2_ELEMENT_TYPE = associate(BooleanFactory.createBoolean_KwKeyword_2ElementType());

	public static final IGrammarAwareElementType Boolean_ValueAssignment_3_ELEMENT_TYPE = associate(BooleanFactory.createBoolean_ValueAssignment_3ElementType());

	public static final IGrammarAwareElementType Boolean_ValueIDTerminalRuleCall_3_0_ELEMENT_TYPE = associate(BooleanFactory.createBoolean_ValueIDTerminalRuleCall_3_0ElementType());

	private static class Transient1Factory {
		public static IGrammarAwareElementType createTransient1ElementType() {
			return new IGrammarAwareElementType("Transient1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransient1Rule());
		}
		public static IGrammarAwareElementType createTransient1_GroupElementType() {
			return new IGrammarAwareElementType("Transient1_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransient1Access().getGroup());
		}
		public static IGrammarAwareElementType createTransient1_NumberSignDigitFiveKeyword_0ElementType() {
			return new IGrammarAwareElementType("Transient1_NumberSignDigitFiveKeyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransient1Access().getNumberSignDigitFiveKeyword_0());
		}
		public static IGrammarAwareElementType createTransient1_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("Transient1_Alternatives_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransient1Access().getAlternatives_1());
		}
		public static IGrammarAwareElementType createTransient1_PrecStarAssignment_1_0ElementType() {
			return new IGrammarAwareElementType("Transient1_PrecStarAssignment_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransient1Access().getPrecStarAssignment_1_0());
		}
		public static IGrammarAwareElementType createTransient1_PrecStarAsteriskKeyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("Transient1_PrecStarAsteriskKeyword_1_0_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransient1Access().getPrecStarAsteriskKeyword_1_0_0());
		}
		public static IGrammarAwareElementType createTransient1_PrecAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Transient1_PrecAssignment_1_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransient1Access().getPrecAssignment_1_1());
		}
		public static IGrammarAwareElementType createTransient1_PrecINTTerminalRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("Transient1_PrecINTTerminalRuleCall_1_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransient1Access().getPrecINTTerminalRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createTransient1_Group_2ElementType() {
			return new IGrammarAwareElementType("Transient1_Group_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransient1Access().getGroup_2());
		}
		public static IGrammarAwareElementType createTransient1_CommaKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Transient1_CommaKeyword_2_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransient1Access().getCommaKeyword_2_0());
		}
		public static IGrammarAwareElementType createTransient1_Alternatives_2_1ElementType() {
			return new IGrammarAwareElementType("Transient1_Alternatives_2_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransient1Access().getAlternatives_2_1());
		}
		public static IGrammarAwareElementType createTransient1_ScaleStarAssignment_2_1_0ElementType() {
			return new IGrammarAwareElementType("Transient1_ScaleStarAssignment_2_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransient1Access().getScaleStarAssignment_2_1_0());
		}
		public static IGrammarAwareElementType createTransient1_ScaleStarAsteriskKeyword_2_1_0_0ElementType() {
			return new IGrammarAwareElementType("Transient1_ScaleStarAsteriskKeyword_2_1_0_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransient1Access().getScaleStarAsteriskKeyword_2_1_0_0());
		}
		public static IGrammarAwareElementType createTransient1_ScaleAssignment_2_1_1ElementType() {
			return new IGrammarAwareElementType("Transient1_ScaleAssignment_2_1_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransient1Access().getScaleAssignment_2_1_1());
		}
		public static IGrammarAwareElementType createTransient1_ScaleINTTerminalRuleCall_2_1_1_0ElementType() {
			return new IGrammarAwareElementType("Transient1_ScaleINTTerminalRuleCall_2_1_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTransient1Access().getScaleINTTerminalRuleCall_2_1_1_0());
		}
	}

	public static final IGrammarAwareElementType Transient1_ELEMENT_TYPE = associate(Transient1Factory.createTransient1ElementType());

	public static final IGrammarAwareElementType Transient1_Group_ELEMENT_TYPE = associate(Transient1Factory.createTransient1_GroupElementType());

	public static final IGrammarAwareElementType Transient1_NumberSignDigitFiveKeyword_0_ELEMENT_TYPE = associate(Transient1Factory.createTransient1_NumberSignDigitFiveKeyword_0ElementType());

	public static final IGrammarAwareElementType Transient1_Alternatives_1_ELEMENT_TYPE = associate(Transient1Factory.createTransient1_Alternatives_1ElementType());

	public static final IGrammarAwareElementType Transient1_PrecStarAssignment_1_0_ELEMENT_TYPE = associate(Transient1Factory.createTransient1_PrecStarAssignment_1_0ElementType());

	public static final IGrammarAwareElementType Transient1_PrecStarAsteriskKeyword_1_0_0_ELEMENT_TYPE = associate(Transient1Factory.createTransient1_PrecStarAsteriskKeyword_1_0_0ElementType());

	public static final IGrammarAwareElementType Transient1_PrecAssignment_1_1_ELEMENT_TYPE = associate(Transient1Factory.createTransient1_PrecAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Transient1_PrecINTTerminalRuleCall_1_1_0_ELEMENT_TYPE = associate(Transient1Factory.createTransient1_PrecINTTerminalRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType Transient1_Group_2_ELEMENT_TYPE = associate(Transient1Factory.createTransient1_Group_2ElementType());

	public static final IGrammarAwareElementType Transient1_CommaKeyword_2_0_ELEMENT_TYPE = associate(Transient1Factory.createTransient1_CommaKeyword_2_0ElementType());

	public static final IGrammarAwareElementType Transient1_Alternatives_2_1_ELEMENT_TYPE = associate(Transient1Factory.createTransient1_Alternatives_2_1ElementType());

	public static final IGrammarAwareElementType Transient1_ScaleStarAssignment_2_1_0_ELEMENT_TYPE = associate(Transient1Factory.createTransient1_ScaleStarAssignment_2_1_0ElementType());

	public static final IGrammarAwareElementType Transient1_ScaleStarAsteriskKeyword_2_1_0_0_ELEMENT_TYPE = associate(Transient1Factory.createTransient1_ScaleStarAsteriskKeyword_2_1_0_0ElementType());

	public static final IGrammarAwareElementType Transient1_ScaleAssignment_2_1_1_ELEMENT_TYPE = associate(Transient1Factory.createTransient1_ScaleAssignment_2_1_1ElementType());

	public static final IGrammarAwareElementType Transient1_ScaleINTTerminalRuleCall_2_1_1_0_ELEMENT_TYPE = associate(Transient1Factory.createTransient1_ScaleINTTerminalRuleCall_2_1_1_0ElementType());

	private static class Consumed1Factory {
		public static IGrammarAwareElementType createConsumed1ElementType() {
			return new IGrammarAwareElementType("Consumed1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConsumed1Rule());
		}
		public static IGrammarAwareElementType createConsumed1_GroupElementType() {
			return new IGrammarAwareElementType("Consumed1_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConsumed1Access().getGroup());
		}
		public static IGrammarAwareElementType createConsumed1_NumberSignDigitSixKeyword_0ElementType() {
			return new IGrammarAwareElementType("Consumed1_NumberSignDigitSixKeyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConsumed1Access().getNumberSignDigitSixKeyword_0());
		}
		public static IGrammarAwareElementType createConsumed1_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("Consumed1_Alternatives_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConsumed1Access().getAlternatives_1());
		}
		public static IGrammarAwareElementType createConsumed1_Group_1_0ElementType() {
			return new IGrammarAwareElementType("Consumed1_Group_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConsumed1Access().getGroup_1_0());
		}
		public static IGrammarAwareElementType createConsumed1_V1Keyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("Consumed1_V1Keyword_1_0_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConsumed1Access().getV1Keyword_1_0_0());
		}
		public static IGrammarAwareElementType createConsumed1_V1Assignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("Consumed1_V1Assignment_1_0_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConsumed1Access().getV1Assignment_1_0_1());
		}
		public static IGrammarAwareElementType createConsumed1_V1INTTerminalRuleCall_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("Consumed1_V1INTTerminalRuleCall_1_0_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConsumed1Access().getV1INTTerminalRuleCall_1_0_1_0());
		}
		public static IGrammarAwareElementType createConsumed1_V2Assignment_1_0_2ElementType() {
			return new IGrammarAwareElementType("Consumed1_V2Assignment_1_0_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConsumed1Access().getV2Assignment_1_0_2());
		}
		public static IGrammarAwareElementType createConsumed1_V2IDTerminalRuleCall_1_0_2_0ElementType() {
			return new IGrammarAwareElementType("Consumed1_V2IDTerminalRuleCall_1_0_2_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConsumed1Access().getV2IDTerminalRuleCall_1_0_2_0());
		}
		public static IGrammarAwareElementType createConsumed1_Group_1_1ElementType() {
			return new IGrammarAwareElementType("Consumed1_Group_1_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConsumed1Access().getGroup_1_1());
		}
		public static IGrammarAwareElementType createConsumed1_V2Keyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("Consumed1_V2Keyword_1_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConsumed1Access().getV2Keyword_1_1_0());
		}
		public static IGrammarAwareElementType createConsumed1_V2Assignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("Consumed1_V2Assignment_1_1_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConsumed1Access().getV2Assignment_1_1_1());
		}
		public static IGrammarAwareElementType createConsumed1_V2IDTerminalRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("Consumed1_V2IDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConsumed1Access().getV2IDTerminalRuleCall_1_1_1_0());
		}
		public static IGrammarAwareElementType createConsumed1_V1Assignment_1_1_2ElementType() {
			return new IGrammarAwareElementType("Consumed1_V1Assignment_1_1_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConsumed1Access().getV1Assignment_1_1_2());
		}
		public static IGrammarAwareElementType createConsumed1_V1INTTerminalRuleCall_1_1_2_0ElementType() {
			return new IGrammarAwareElementType("Consumed1_V1INTTerminalRuleCall_1_1_2_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConsumed1Access().getV1INTTerminalRuleCall_1_1_2_0());
		}
	}

	public static final IGrammarAwareElementType Consumed1_ELEMENT_TYPE = associate(Consumed1Factory.createConsumed1ElementType());

	public static final IGrammarAwareElementType Consumed1_Group_ELEMENT_TYPE = associate(Consumed1Factory.createConsumed1_GroupElementType());

	public static final IGrammarAwareElementType Consumed1_NumberSignDigitSixKeyword_0_ELEMENT_TYPE = associate(Consumed1Factory.createConsumed1_NumberSignDigitSixKeyword_0ElementType());

	public static final IGrammarAwareElementType Consumed1_Alternatives_1_ELEMENT_TYPE = associate(Consumed1Factory.createConsumed1_Alternatives_1ElementType());

	public static final IGrammarAwareElementType Consumed1_Group_1_0_ELEMENT_TYPE = associate(Consumed1Factory.createConsumed1_Group_1_0ElementType());

	public static final IGrammarAwareElementType Consumed1_V1Keyword_1_0_0_ELEMENT_TYPE = associate(Consumed1Factory.createConsumed1_V1Keyword_1_0_0ElementType());

	public static final IGrammarAwareElementType Consumed1_V1Assignment_1_0_1_ELEMENT_TYPE = associate(Consumed1Factory.createConsumed1_V1Assignment_1_0_1ElementType());

	public static final IGrammarAwareElementType Consumed1_V1INTTerminalRuleCall_1_0_1_0_ELEMENT_TYPE = associate(Consumed1Factory.createConsumed1_V1INTTerminalRuleCall_1_0_1_0ElementType());

	public static final IGrammarAwareElementType Consumed1_V2Assignment_1_0_2_ELEMENT_TYPE = associate(Consumed1Factory.createConsumed1_V2Assignment_1_0_2ElementType());

	public static final IGrammarAwareElementType Consumed1_V2IDTerminalRuleCall_1_0_2_0_ELEMENT_TYPE = associate(Consumed1Factory.createConsumed1_V2IDTerminalRuleCall_1_0_2_0ElementType());

	public static final IGrammarAwareElementType Consumed1_Group_1_1_ELEMENT_TYPE = associate(Consumed1Factory.createConsumed1_Group_1_1ElementType());

	public static final IGrammarAwareElementType Consumed1_V2Keyword_1_1_0_ELEMENT_TYPE = associate(Consumed1Factory.createConsumed1_V2Keyword_1_1_0ElementType());

	public static final IGrammarAwareElementType Consumed1_V2Assignment_1_1_1_ELEMENT_TYPE = associate(Consumed1Factory.createConsumed1_V2Assignment_1_1_1ElementType());

	public static final IGrammarAwareElementType Consumed1_V2IDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE = associate(Consumed1Factory.createConsumed1_V2IDTerminalRuleCall_1_1_1_0ElementType());

	public static final IGrammarAwareElementType Consumed1_V1Assignment_1_1_2_ELEMENT_TYPE = associate(Consumed1Factory.createConsumed1_V1Assignment_1_1_2ElementType());

	public static final IGrammarAwareElementType Consumed1_V1INTTerminalRuleCall_1_1_2_0_ELEMENT_TYPE = associate(Consumed1Factory.createConsumed1_V1INTTerminalRuleCall_1_1_2_0ElementType());

	private static class Consumed2Factory {
		public static IGrammarAwareElementType createConsumed2ElementType() {
			return new IGrammarAwareElementType("Consumed2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConsumed2Rule());
		}
		public static IGrammarAwareElementType createConsumed2_GroupElementType() {
			return new IGrammarAwareElementType("Consumed2_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConsumed2Access().getGroup());
		}
		public static IGrammarAwareElementType createConsumed2_NumberSignDigitSevenKeyword_0ElementType() {
			return new IGrammarAwareElementType("Consumed2_NumberSignDigitSevenKeyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConsumed2Access().getNumberSignDigitSevenKeyword_0());
		}
		public static IGrammarAwareElementType createConsumed2_ChildAssignment_1ElementType() {
			return new IGrammarAwareElementType("Consumed2_ChildAssignment_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConsumed2Access().getChildAssignment_1());
		}
		public static IGrammarAwareElementType createConsumed2_ChildConsumed1ParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Consumed2_ChildConsumed1ParserRuleCall_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConsumed2Access().getChildConsumed1ParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Consumed2_ELEMENT_TYPE = associate(Consumed2Factory.createConsumed2ElementType());

	public static final IGrammarAwareElementType Consumed2_Group_ELEMENT_TYPE = associate(Consumed2Factory.createConsumed2_GroupElementType());

	public static final IGrammarAwareElementType Consumed2_NumberSignDigitSevenKeyword_0_ELEMENT_TYPE = associate(Consumed2Factory.createConsumed2_NumberSignDigitSevenKeyword_0ElementType());

	public static final IGrammarAwareElementType Consumed2_ChildAssignment_1_ELEMENT_TYPE = associate(Consumed2Factory.createConsumed2_ChildAssignment_1ElementType());

	public static final IGrammarAwareElementType Consumed2_ChildConsumed1ParserRuleCall_1_0_ELEMENT_TYPE = associate(Consumed2Factory.createConsumed2_ChildConsumed1ParserRuleCall_1_0ElementType());

	private static class Loop1Factory {
		public static IGrammarAwareElementType createLoop1ElementType() {
			return new IGrammarAwareElementType("Loop1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop1Rule());
		}
		public static IGrammarAwareElementType createLoop1_GroupElementType() {
			return new IGrammarAwareElementType("Loop1_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop1Access().getGroup());
		}
		public static IGrammarAwareElementType createLoop1_Kw0Keyword_0ElementType() {
			return new IGrammarAwareElementType("Loop1_Kw0Keyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop1Access().getKw0Keyword_0());
		}
		public static IGrammarAwareElementType createLoop1_NumberSignDigitEightKeyword_1ElementType() {
			return new IGrammarAwareElementType("Loop1_NumberSignDigitEightKeyword_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop1Access().getNumberSignDigitEightKeyword_1());
		}
		public static IGrammarAwareElementType createLoop1_IdAssignment_2ElementType() {
			return new IGrammarAwareElementType("Loop1_IdAssignment_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop1Access().getIdAssignment_2());
		}
		public static IGrammarAwareElementType createLoop1_IdIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Loop1_IdIDTerminalRuleCall_2_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop1Access().getIdIDTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createLoop1_Kw1Keyword_3ElementType() {
			return new IGrammarAwareElementType("Loop1_Kw1Keyword_3_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop1Access().getKw1Keyword_3());
		}
		public static IGrammarAwareElementType createLoop1_IdAssignment_4ElementType() {
			return new IGrammarAwareElementType("Loop1_IdAssignment_4_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop1Access().getIdAssignment_4());
		}
		public static IGrammarAwareElementType createLoop1_IdIDTerminalRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("Loop1_IdIDTerminalRuleCall_4_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop1Access().getIdIDTerminalRuleCall_4_0());
		}
		public static IGrammarAwareElementType createLoop1_Group_5ElementType() {
			return new IGrammarAwareElementType("Loop1_Group_5_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop1Access().getGroup_5());
		}
		public static IGrammarAwareElementType createLoop1_Kw2Keyword_5_0ElementType() {
			return new IGrammarAwareElementType("Loop1_Kw2Keyword_5_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop1Access().getKw2Keyword_5_0());
		}
		public static IGrammarAwareElementType createLoop1_Kw30Keyword_5_1ElementType() {
			return new IGrammarAwareElementType("Loop1_Kw30Keyword_5_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop1Access().getKw30Keyword_5_1());
		}
	}

	public static final IGrammarAwareElementType Loop1_ELEMENT_TYPE = associate(Loop1Factory.createLoop1ElementType());

	public static final IGrammarAwareElementType Loop1_Group_ELEMENT_TYPE = associate(Loop1Factory.createLoop1_GroupElementType());

	public static final IGrammarAwareElementType Loop1_Kw0Keyword_0_ELEMENT_TYPE = associate(Loop1Factory.createLoop1_Kw0Keyword_0ElementType());

	public static final IGrammarAwareElementType Loop1_NumberSignDigitEightKeyword_1_ELEMENT_TYPE = associate(Loop1Factory.createLoop1_NumberSignDigitEightKeyword_1ElementType());

	public static final IGrammarAwareElementType Loop1_IdAssignment_2_ELEMENT_TYPE = associate(Loop1Factory.createLoop1_IdAssignment_2ElementType());

	public static final IGrammarAwareElementType Loop1_IdIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(Loop1Factory.createLoop1_IdIDTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType Loop1_Kw1Keyword_3_ELEMENT_TYPE = associate(Loop1Factory.createLoop1_Kw1Keyword_3ElementType());

	public static final IGrammarAwareElementType Loop1_IdAssignment_4_ELEMENT_TYPE = associate(Loop1Factory.createLoop1_IdAssignment_4ElementType());

	public static final IGrammarAwareElementType Loop1_IdIDTerminalRuleCall_4_0_ELEMENT_TYPE = associate(Loop1Factory.createLoop1_IdIDTerminalRuleCall_4_0ElementType());

	public static final IGrammarAwareElementType Loop1_Group_5_ELEMENT_TYPE = associate(Loop1Factory.createLoop1_Group_5ElementType());

	public static final IGrammarAwareElementType Loop1_Kw2Keyword_5_0_ELEMENT_TYPE = associate(Loop1Factory.createLoop1_Kw2Keyword_5_0ElementType());

	public static final IGrammarAwareElementType Loop1_Kw30Keyword_5_1_ELEMENT_TYPE = associate(Loop1Factory.createLoop1_Kw30Keyword_5_1ElementType());

	private static class Loop2Factory {
		public static IGrammarAwareElementType createLoop2ElementType() {
			return new IGrammarAwareElementType("Loop2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop2Rule());
		}
		public static IGrammarAwareElementType createLoop2_GroupElementType() {
			return new IGrammarAwareElementType("Loop2_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop2Access().getGroup());
		}
		public static IGrammarAwareElementType createLoop2_NumberSignDigitNineKeyword_0ElementType() {
			return new IGrammarAwareElementType("Loop2_NumberSignDigitNineKeyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop2Access().getNumberSignDigitNineKeyword_0());
		}
		public static IGrammarAwareElementType createLoop2_IdAssignment_1ElementType() {
			return new IGrammarAwareElementType("Loop2_IdAssignment_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop2Access().getIdAssignment_1());
		}
		public static IGrammarAwareElementType createLoop2_IdIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Loop2_IdIDTerminalRuleCall_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop2Access().getIdIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createLoop2_Alternatives_2ElementType() {
			return new IGrammarAwareElementType("Loop2_Alternatives_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop2Access().getAlternatives_2());
		}
		public static IGrammarAwareElementType createLoop2_Kw1Keyword_2_0ElementType() {
			return new IGrammarAwareElementType("Loop2_Kw1Keyword_2_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop2Access().getKw1Keyword_2_0());
		}
		public static IGrammarAwareElementType createLoop2_Group_2_1ElementType() {
			return new IGrammarAwareElementType("Loop2_Group_2_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop2Access().getGroup_2_1());
		}
		public static IGrammarAwareElementType createLoop2_IdAssignment_2_1_0ElementType() {
			return new IGrammarAwareElementType("Loop2_IdAssignment_2_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop2Access().getIdAssignment_2_1_0());
		}
		public static IGrammarAwareElementType createLoop2_IdIDTerminalRuleCall_2_1_0_0ElementType() {
			return new IGrammarAwareElementType("Loop2_IdIDTerminalRuleCall_2_1_0_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop2Access().getIdIDTerminalRuleCall_2_1_0_0());
		}
		public static IGrammarAwareElementType createLoop2_Kw2Keyword_2_1_1ElementType() {
			return new IGrammarAwareElementType("Loop2_Kw2Keyword_2_1_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop2Access().getKw2Keyword_2_1_1());
		}
		public static IGrammarAwareElementType createLoop2_Alternatives_3ElementType() {
			return new IGrammarAwareElementType("Loop2_Alternatives_3_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop2Access().getAlternatives_3());
		}
		public static IGrammarAwareElementType createLoop2_Kw3Keyword_3_0ElementType() {
			return new IGrammarAwareElementType("Loop2_Kw3Keyword_3_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop2Access().getKw3Keyword_3_0());
		}
		public static IGrammarAwareElementType createLoop2_Group_3_1ElementType() {
			return new IGrammarAwareElementType("Loop2_Group_3_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop2Access().getGroup_3_1());
		}
		public static IGrammarAwareElementType createLoop2_IdAssignment_3_1_0ElementType() {
			return new IGrammarAwareElementType("Loop2_IdAssignment_3_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop2Access().getIdAssignment_3_1_0());
		}
		public static IGrammarAwareElementType createLoop2_IdIDTerminalRuleCall_3_1_0_0ElementType() {
			return new IGrammarAwareElementType("Loop2_IdIDTerminalRuleCall_3_1_0_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop2Access().getIdIDTerminalRuleCall_3_1_0_0());
		}
		public static IGrammarAwareElementType createLoop2_Kw4Keyword_3_1_1ElementType() {
			return new IGrammarAwareElementType("Loop2_Kw4Keyword_3_1_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop2Access().getKw4Keyword_3_1_1());
		}
		public static IGrammarAwareElementType createLoop2_Alternatives_4ElementType() {
			return new IGrammarAwareElementType("Loop2_Alternatives_4_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop2Access().getAlternatives_4());
		}
		public static IGrammarAwareElementType createLoop2_Kw5Keyword_4_0ElementType() {
			return new IGrammarAwareElementType("Loop2_Kw5Keyword_4_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop2Access().getKw5Keyword_4_0());
		}
		public static IGrammarAwareElementType createLoop2_Kw6Keyword_4_1ElementType() {
			return new IGrammarAwareElementType("Loop2_Kw6Keyword_4_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop2Access().getKw6Keyword_4_1());
		}
	}

	public static final IGrammarAwareElementType Loop2_ELEMENT_TYPE = associate(Loop2Factory.createLoop2ElementType());

	public static final IGrammarAwareElementType Loop2_Group_ELEMENT_TYPE = associate(Loop2Factory.createLoop2_GroupElementType());

	public static final IGrammarAwareElementType Loop2_NumberSignDigitNineKeyword_0_ELEMENT_TYPE = associate(Loop2Factory.createLoop2_NumberSignDigitNineKeyword_0ElementType());

	public static final IGrammarAwareElementType Loop2_IdAssignment_1_ELEMENT_TYPE = associate(Loop2Factory.createLoop2_IdAssignment_1ElementType());

	public static final IGrammarAwareElementType Loop2_IdIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(Loop2Factory.createLoop2_IdIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Loop2_Alternatives_2_ELEMENT_TYPE = associate(Loop2Factory.createLoop2_Alternatives_2ElementType());

	public static final IGrammarAwareElementType Loop2_Kw1Keyword_2_0_ELEMENT_TYPE = associate(Loop2Factory.createLoop2_Kw1Keyword_2_0ElementType());

	public static final IGrammarAwareElementType Loop2_Group_2_1_ELEMENT_TYPE = associate(Loop2Factory.createLoop2_Group_2_1ElementType());

	public static final IGrammarAwareElementType Loop2_IdAssignment_2_1_0_ELEMENT_TYPE = associate(Loop2Factory.createLoop2_IdAssignment_2_1_0ElementType());

	public static final IGrammarAwareElementType Loop2_IdIDTerminalRuleCall_2_1_0_0_ELEMENT_TYPE = associate(Loop2Factory.createLoop2_IdIDTerminalRuleCall_2_1_0_0ElementType());

	public static final IGrammarAwareElementType Loop2_Kw2Keyword_2_1_1_ELEMENT_TYPE = associate(Loop2Factory.createLoop2_Kw2Keyword_2_1_1ElementType());

	public static final IGrammarAwareElementType Loop2_Alternatives_3_ELEMENT_TYPE = associate(Loop2Factory.createLoop2_Alternatives_3ElementType());

	public static final IGrammarAwareElementType Loop2_Kw3Keyword_3_0_ELEMENT_TYPE = associate(Loop2Factory.createLoop2_Kw3Keyword_3_0ElementType());

	public static final IGrammarAwareElementType Loop2_Group_3_1_ELEMENT_TYPE = associate(Loop2Factory.createLoop2_Group_3_1ElementType());

	public static final IGrammarAwareElementType Loop2_IdAssignment_3_1_0_ELEMENT_TYPE = associate(Loop2Factory.createLoop2_IdAssignment_3_1_0ElementType());

	public static final IGrammarAwareElementType Loop2_IdIDTerminalRuleCall_3_1_0_0_ELEMENT_TYPE = associate(Loop2Factory.createLoop2_IdIDTerminalRuleCall_3_1_0_0ElementType());

	public static final IGrammarAwareElementType Loop2_Kw4Keyword_3_1_1_ELEMENT_TYPE = associate(Loop2Factory.createLoop2_Kw4Keyword_3_1_1ElementType());

	public static final IGrammarAwareElementType Loop2_Alternatives_4_ELEMENT_TYPE = associate(Loop2Factory.createLoop2_Alternatives_4ElementType());

	public static final IGrammarAwareElementType Loop2_Kw5Keyword_4_0_ELEMENT_TYPE = associate(Loop2Factory.createLoop2_Kw5Keyword_4_0ElementType());

	public static final IGrammarAwareElementType Loop2_Kw6Keyword_4_1_ELEMENT_TYPE = associate(Loop2Factory.createLoop2_Kw6Keyword_4_1ElementType());

	private static class Loop3Factory {
		public static IGrammarAwareElementType createLoop3ElementType() {
			return new IGrammarAwareElementType("Loop3_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop3Rule());
		}
		public static IGrammarAwareElementType createLoop3_GroupElementType() {
			return new IGrammarAwareElementType("Loop3_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop3Access().getGroup());
		}
		public static IGrammarAwareElementType createLoop3_Alternatives_0ElementType() {
			return new IGrammarAwareElementType("Loop3_Alternatives_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop3Access().getAlternatives_0());
		}
		public static IGrammarAwareElementType createLoop3_Kw1Keyword_0_0ElementType() {
			return new IGrammarAwareElementType("Loop3_Kw1Keyword_0_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop3Access().getKw1Keyword_0_0());
		}
		public static IGrammarAwareElementType createLoop3_Kw2Keyword_0_1ElementType() {
			return new IGrammarAwareElementType("Loop3_Kw2Keyword_0_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop3Access().getKw2Keyword_0_1());
		}
		public static IGrammarAwareElementType createLoop3_Kw3Keyword_0_2ElementType() {
			return new IGrammarAwareElementType("Loop3_Kw3Keyword_0_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop3Access().getKw3Keyword_0_2());
		}
		public static IGrammarAwareElementType createLoop3_NumberSignDigitOneDigitZeroKeyword_1ElementType() {
			return new IGrammarAwareElementType("Loop3_NumberSignDigitOneDigitZeroKeyword_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop3Access().getNumberSignDigitOneDigitZeroKeyword_1());
		}
		public static IGrammarAwareElementType createLoop3_IdAssignment_2ElementType() {
			return new IGrammarAwareElementType("Loop3_IdAssignment_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop3Access().getIdAssignment_2());
		}
		public static IGrammarAwareElementType createLoop3_IdIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Loop3_IdIDTerminalRuleCall_2_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop3Access().getIdIDTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createLoop3_Group_3ElementType() {
			return new IGrammarAwareElementType("Loop3_Group_3_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop3Access().getGroup_3());
		}
		public static IGrammarAwareElementType createLoop3_Kw4Keyword_3_0ElementType() {
			return new IGrammarAwareElementType("Loop3_Kw4Keyword_3_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop3Access().getKw4Keyword_3_0());
		}
		public static IGrammarAwareElementType createLoop3_IdAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("Loop3_IdAssignment_3_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop3Access().getIdAssignment_3_1());
		}
		public static IGrammarAwareElementType createLoop3_IdIDTerminalRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("Loop3_IdIDTerminalRuleCall_3_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop3Access().getIdIDTerminalRuleCall_3_1_0());
		}
		public static IGrammarAwareElementType createLoop3_Kw5Keyword_3_2ElementType() {
			return new IGrammarAwareElementType("Loop3_Kw5Keyword_3_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop3Access().getKw5Keyword_3_2());
		}
	}

	public static final IGrammarAwareElementType Loop3_ELEMENT_TYPE = associate(Loop3Factory.createLoop3ElementType());

	public static final IGrammarAwareElementType Loop3_Group_ELEMENT_TYPE = associate(Loop3Factory.createLoop3_GroupElementType());

	public static final IGrammarAwareElementType Loop3_Alternatives_0_ELEMENT_TYPE = associate(Loop3Factory.createLoop3_Alternatives_0ElementType());

	public static final IGrammarAwareElementType Loop3_Kw1Keyword_0_0_ELEMENT_TYPE = associate(Loop3Factory.createLoop3_Kw1Keyword_0_0ElementType());

	public static final IGrammarAwareElementType Loop3_Kw2Keyword_0_1_ELEMENT_TYPE = associate(Loop3Factory.createLoop3_Kw2Keyword_0_1ElementType());

	public static final IGrammarAwareElementType Loop3_Kw3Keyword_0_2_ELEMENT_TYPE = associate(Loop3Factory.createLoop3_Kw3Keyword_0_2ElementType());

	public static final IGrammarAwareElementType Loop3_NumberSignDigitOneDigitZeroKeyword_1_ELEMENT_TYPE = associate(Loop3Factory.createLoop3_NumberSignDigitOneDigitZeroKeyword_1ElementType());

	public static final IGrammarAwareElementType Loop3_IdAssignment_2_ELEMENT_TYPE = associate(Loop3Factory.createLoop3_IdAssignment_2ElementType());

	public static final IGrammarAwareElementType Loop3_IdIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(Loop3Factory.createLoop3_IdIDTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType Loop3_Group_3_ELEMENT_TYPE = associate(Loop3Factory.createLoop3_Group_3ElementType());

	public static final IGrammarAwareElementType Loop3_Kw4Keyword_3_0_ELEMENT_TYPE = associate(Loop3Factory.createLoop3_Kw4Keyword_3_0ElementType());

	public static final IGrammarAwareElementType Loop3_IdAssignment_3_1_ELEMENT_TYPE = associate(Loop3Factory.createLoop3_IdAssignment_3_1ElementType());

	public static final IGrammarAwareElementType Loop3_IdIDTerminalRuleCall_3_1_0_ELEMENT_TYPE = associate(Loop3Factory.createLoop3_IdIDTerminalRuleCall_3_1_0ElementType());

	public static final IGrammarAwareElementType Loop3_Kw5Keyword_3_2_ELEMENT_TYPE = associate(Loop3Factory.createLoop3_Kw5Keyword_3_2ElementType());

	private static class Loop4Factory {
		public static IGrammarAwareElementType createLoop4ElementType() {
			return new IGrammarAwareElementType("Loop4_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop4Rule());
		}
		public static IGrammarAwareElementType createLoop4_GroupElementType() {
			return new IGrammarAwareElementType("Loop4_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop4Access().getGroup());
		}
		public static IGrammarAwareElementType createLoop4_NumberSignDigitOneDigitOneKeyword_0ElementType() {
			return new IGrammarAwareElementType("Loop4_NumberSignDigitOneDigitOneKeyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop4Access().getNumberSignDigitOneDigitOneKeyword_0());
		}
		public static IGrammarAwareElementType createLoop4_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("Loop4_Alternatives_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop4Access().getAlternatives_1());
		}
		public static IGrammarAwareElementType createLoop4_Kw1Keyword_1_0ElementType() {
			return new IGrammarAwareElementType("Loop4_Kw1Keyword_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop4Access().getKw1Keyword_1_0());
		}
		public static IGrammarAwareElementType createLoop4_Kw2Keyword_1_1ElementType() {
			return new IGrammarAwareElementType("Loop4_Kw2Keyword_1_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop4Access().getKw2Keyword_1_1());
		}
		public static IGrammarAwareElementType createLoop4_Group_1_2ElementType() {
			return new IGrammarAwareElementType("Loop4_Group_1_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop4Access().getGroup_1_2());
		}
		public static IGrammarAwareElementType createLoop4_Kw3Keyword_1_2_0ElementType() {
			return new IGrammarAwareElementType("Loop4_Kw3Keyword_1_2_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop4Access().getKw3Keyword_1_2_0());
		}
		public static IGrammarAwareElementType createLoop4_Kw4Keyword_1_2_1ElementType() {
			return new IGrammarAwareElementType("Loop4_Kw4Keyword_1_2_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop4Access().getKw4Keyword_1_2_1());
		}
		public static IGrammarAwareElementType createLoop4_IdAssignment_2ElementType() {
			return new IGrammarAwareElementType("Loop4_IdAssignment_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop4Access().getIdAssignment_2());
		}
		public static IGrammarAwareElementType createLoop4_IdIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Loop4_IdIDTerminalRuleCall_2_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop4Access().getIdIDTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createLoop4_Group_3ElementType() {
			return new IGrammarAwareElementType("Loop4_Group_3_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop4Access().getGroup_3());
		}
		public static IGrammarAwareElementType createLoop4_Kw5Keyword_3_0ElementType() {
			return new IGrammarAwareElementType("Loop4_Kw5Keyword_3_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop4Access().getKw5Keyword_3_0());
		}
		public static IGrammarAwareElementType createLoop4_Group_3_1ElementType() {
			return new IGrammarAwareElementType("Loop4_Group_3_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop4Access().getGroup_3_1());
		}
		public static IGrammarAwareElementType createLoop4_Kw6Keyword_3_1_0ElementType() {
			return new IGrammarAwareElementType("Loop4_Kw6Keyword_3_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop4Access().getKw6Keyword_3_1_0());
		}
		public static IGrammarAwareElementType createLoop4_Kw7Keyword_3_1_1ElementType() {
			return new IGrammarAwareElementType("Loop4_Kw7Keyword_3_1_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoop4Access().getKw7Keyword_3_1_1());
		}
	}

	public static final IGrammarAwareElementType Loop4_ELEMENT_TYPE = associate(Loop4Factory.createLoop4ElementType());

	public static final IGrammarAwareElementType Loop4_Group_ELEMENT_TYPE = associate(Loop4Factory.createLoop4_GroupElementType());

	public static final IGrammarAwareElementType Loop4_NumberSignDigitOneDigitOneKeyword_0_ELEMENT_TYPE = associate(Loop4Factory.createLoop4_NumberSignDigitOneDigitOneKeyword_0ElementType());

	public static final IGrammarAwareElementType Loop4_Alternatives_1_ELEMENT_TYPE = associate(Loop4Factory.createLoop4_Alternatives_1ElementType());

	public static final IGrammarAwareElementType Loop4_Kw1Keyword_1_0_ELEMENT_TYPE = associate(Loop4Factory.createLoop4_Kw1Keyword_1_0ElementType());

	public static final IGrammarAwareElementType Loop4_Kw2Keyword_1_1_ELEMENT_TYPE = associate(Loop4Factory.createLoop4_Kw2Keyword_1_1ElementType());

	public static final IGrammarAwareElementType Loop4_Group_1_2_ELEMENT_TYPE = associate(Loop4Factory.createLoop4_Group_1_2ElementType());

	public static final IGrammarAwareElementType Loop4_Kw3Keyword_1_2_0_ELEMENT_TYPE = associate(Loop4Factory.createLoop4_Kw3Keyword_1_2_0ElementType());

	public static final IGrammarAwareElementType Loop4_Kw4Keyword_1_2_1_ELEMENT_TYPE = associate(Loop4Factory.createLoop4_Kw4Keyword_1_2_1ElementType());

	public static final IGrammarAwareElementType Loop4_IdAssignment_2_ELEMENT_TYPE = associate(Loop4Factory.createLoop4_IdAssignment_2ElementType());

	public static final IGrammarAwareElementType Loop4_IdIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(Loop4Factory.createLoop4_IdIDTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType Loop4_Group_3_ELEMENT_TYPE = associate(Loop4Factory.createLoop4_Group_3ElementType());

	public static final IGrammarAwareElementType Loop4_Kw5Keyword_3_0_ELEMENT_TYPE = associate(Loop4Factory.createLoop4_Kw5Keyword_3_0ElementType());

	public static final IGrammarAwareElementType Loop4_Group_3_1_ELEMENT_TYPE = associate(Loop4Factory.createLoop4_Group_3_1ElementType());

	public static final IGrammarAwareElementType Loop4_Kw6Keyword_3_1_0_ELEMENT_TYPE = associate(Loop4Factory.createLoop4_Kw6Keyword_3_1_0ElementType());

	public static final IGrammarAwareElementType Loop4_Kw7Keyword_3_1_1_ELEMENT_TYPE = associate(Loop4Factory.createLoop4_Kw7Keyword_3_1_1ElementType());

	private static class LoopBug285452Factory {
		public static IGrammarAwareElementType createLoopBug285452ElementType() {
			return new IGrammarAwareElementType("LoopBug285452_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoopBug285452Rule());
		}
		public static IGrammarAwareElementType createLoopBug285452_GroupElementType() {
			return new IGrammarAwareElementType("LoopBug285452_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoopBug285452Access().getGroup());
		}
		public static IGrammarAwareElementType createLoopBug285452_NumberSignDigitOneDigitTwoKeyword_0ElementType() {
			return new IGrammarAwareElementType("LoopBug285452_NumberSignDigitOneDigitTwoKeyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoopBug285452Access().getNumberSignDigitOneDigitTwoKeyword_0());
		}
		public static IGrammarAwareElementType createLoopBug285452_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("LoopBug285452_Alternatives_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoopBug285452Access().getAlternatives_1());
		}
		public static IGrammarAwareElementType createLoopBug285452_InterfaceAssignment_1_0ElementType() {
			return new IGrammarAwareElementType("LoopBug285452_InterfaceAssignment_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoopBug285452Access().getInterfaceAssignment_1_0());
		}
		public static IGrammarAwareElementType createLoopBug285452_InterfaceInterfaceKeyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("LoopBug285452_InterfaceInterfaceKeyword_1_0_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoopBug285452Access().getInterfaceInterfaceKeyword_1_0_0());
		}
		public static IGrammarAwareElementType createLoopBug285452_ClassKeyword_1_1ElementType() {
			return new IGrammarAwareElementType("LoopBug285452_ClassKeyword_1_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoopBug285452Access().getClassKeyword_1_1());
		}
		public static IGrammarAwareElementType createLoopBug285452_NameAssignment_2ElementType() {
			return new IGrammarAwareElementType("LoopBug285452_NameAssignment_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoopBug285452Access().getNameAssignment_2());
		}
		public static IGrammarAwareElementType createLoopBug285452_NameIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("LoopBug285452_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getLoopBug285452Access().getNameIDTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType LoopBug285452_ELEMENT_TYPE = associate(LoopBug285452Factory.createLoopBug285452ElementType());

	public static final IGrammarAwareElementType LoopBug285452_Group_ELEMENT_TYPE = associate(LoopBug285452Factory.createLoopBug285452_GroupElementType());

	public static final IGrammarAwareElementType LoopBug285452_NumberSignDigitOneDigitTwoKeyword_0_ELEMENT_TYPE = associate(LoopBug285452Factory.createLoopBug285452_NumberSignDigitOneDigitTwoKeyword_0ElementType());

	public static final IGrammarAwareElementType LoopBug285452_Alternatives_1_ELEMENT_TYPE = associate(LoopBug285452Factory.createLoopBug285452_Alternatives_1ElementType());

	public static final IGrammarAwareElementType LoopBug285452_InterfaceAssignment_1_0_ELEMENT_TYPE = associate(LoopBug285452Factory.createLoopBug285452_InterfaceAssignment_1_0ElementType());

	public static final IGrammarAwareElementType LoopBug285452_InterfaceInterfaceKeyword_1_0_0_ELEMENT_TYPE = associate(LoopBug285452Factory.createLoopBug285452_InterfaceInterfaceKeyword_1_0_0ElementType());

	public static final IGrammarAwareElementType LoopBug285452_ClassKeyword_1_1_ELEMENT_TYPE = associate(LoopBug285452Factory.createLoopBug285452_ClassKeyword_1_1ElementType());

	public static final IGrammarAwareElementType LoopBug285452_NameAssignment_2_ELEMENT_TYPE = associate(LoopBug285452Factory.createLoopBug285452_NameAssignment_2ElementType());

	public static final IGrammarAwareElementType LoopBug285452_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(LoopBug285452Factory.createLoopBug285452_NameIDTerminalRuleCall_2_0ElementType());

	private static class DuplicateBug284491Factory {
		public static IGrammarAwareElementType createDuplicateBug284491ElementType() {
			return new IGrammarAwareElementType("DuplicateBug284491_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDuplicateBug284491Rule());
		}
		public static IGrammarAwareElementType createDuplicateBug284491_GroupElementType() {
			return new IGrammarAwareElementType("DuplicateBug284491_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDuplicateBug284491Access().getGroup());
		}
		public static IGrammarAwareElementType createDuplicateBug284491_NumberSignDigitOneDigitThreeKeyword_0ElementType() {
			return new IGrammarAwareElementType("DuplicateBug284491_NumberSignDigitOneDigitThreeKeyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDuplicateBug284491Access().getNumberSignDigitOneDigitThreeKeyword_0());
		}
		public static IGrammarAwareElementType createDuplicateBug284491_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("DuplicateBug284491_Alternatives_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDuplicateBug284491Access().getAlternatives_1());
		}
		public static IGrammarAwareElementType createDuplicateBug284491_StaticAssignment_1_0ElementType() {
			return new IGrammarAwareElementType("DuplicateBug284491_StaticAssignment_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDuplicateBug284491Access().getStaticAssignment_1_0());
		}
		public static IGrammarAwareElementType createDuplicateBug284491_StaticStaticKeyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("DuplicateBug284491_StaticStaticKeyword_1_0_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDuplicateBug284491Access().getStaticStaticKeyword_1_0_0());
		}
		public static IGrammarAwareElementType createDuplicateBug284491_FinalAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("DuplicateBug284491_FinalAssignment_1_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDuplicateBug284491Access().getFinalAssignment_1_1());
		}
		public static IGrammarAwareElementType createDuplicateBug284491_FinalFinalKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("DuplicateBug284491_FinalFinalKeyword_1_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDuplicateBug284491Access().getFinalFinalKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createDuplicateBug284491_TransientAssignment_1_2ElementType() {
			return new IGrammarAwareElementType("DuplicateBug284491_TransientAssignment_1_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDuplicateBug284491Access().getTransientAssignment_1_2());
		}
		public static IGrammarAwareElementType createDuplicateBug284491_TransientTransientKeyword_1_2_0ElementType() {
			return new IGrammarAwareElementType("DuplicateBug284491_TransientTransientKeyword_1_2_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDuplicateBug284491Access().getTransientTransientKeyword_1_2_0());
		}
	}

	public static final IGrammarAwareElementType DuplicateBug284491_ELEMENT_TYPE = associate(DuplicateBug284491Factory.createDuplicateBug284491ElementType());

	public static final IGrammarAwareElementType DuplicateBug284491_Group_ELEMENT_TYPE = associate(DuplicateBug284491Factory.createDuplicateBug284491_GroupElementType());

	public static final IGrammarAwareElementType DuplicateBug284491_NumberSignDigitOneDigitThreeKeyword_0_ELEMENT_TYPE = associate(DuplicateBug284491Factory.createDuplicateBug284491_NumberSignDigitOneDigitThreeKeyword_0ElementType());

	public static final IGrammarAwareElementType DuplicateBug284491_Alternatives_1_ELEMENT_TYPE = associate(DuplicateBug284491Factory.createDuplicateBug284491_Alternatives_1ElementType());

	public static final IGrammarAwareElementType DuplicateBug284491_StaticAssignment_1_0_ELEMENT_TYPE = associate(DuplicateBug284491Factory.createDuplicateBug284491_StaticAssignment_1_0ElementType());

	public static final IGrammarAwareElementType DuplicateBug284491_StaticStaticKeyword_1_0_0_ELEMENT_TYPE = associate(DuplicateBug284491Factory.createDuplicateBug284491_StaticStaticKeyword_1_0_0ElementType());

	public static final IGrammarAwareElementType DuplicateBug284491_FinalAssignment_1_1_ELEMENT_TYPE = associate(DuplicateBug284491Factory.createDuplicateBug284491_FinalAssignment_1_1ElementType());

	public static final IGrammarAwareElementType DuplicateBug284491_FinalFinalKeyword_1_1_0_ELEMENT_TYPE = associate(DuplicateBug284491Factory.createDuplicateBug284491_FinalFinalKeyword_1_1_0ElementType());

	public static final IGrammarAwareElementType DuplicateBug284491_TransientAssignment_1_2_ELEMENT_TYPE = associate(DuplicateBug284491Factory.createDuplicateBug284491_TransientAssignment_1_2ElementType());

	public static final IGrammarAwareElementType DuplicateBug284491_TransientTransientKeyword_1_2_0_ELEMENT_TYPE = associate(DuplicateBug284491Factory.createDuplicateBug284491_TransientTransientKeyword_1_2_0ElementType());

	private static class EmptyObjectBug284850Factory {
		public static IGrammarAwareElementType createEmptyObjectBug284850ElementType() {
			return new IGrammarAwareElementType("EmptyObjectBug284850_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEmptyObjectBug284850Rule());
		}
		public static IGrammarAwareElementType createEmptyObjectBug284850_GroupElementType() {
			return new IGrammarAwareElementType("EmptyObjectBug284850_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEmptyObjectBug284850Access().getGroup());
		}
		public static IGrammarAwareElementType createEmptyObjectBug284850_NumberSignDigitOneDigitFourKeyword_0ElementType() {
			return new IGrammarAwareElementType("EmptyObjectBug284850_NumberSignDigitOneDigitFourKeyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEmptyObjectBug284850Access().getNumberSignDigitOneDigitFourKeyword_0());
		}
		public static IGrammarAwareElementType createEmptyObjectBug284850_ItemsAssignment_1ElementType() {
			return new IGrammarAwareElementType("EmptyObjectBug284850_ItemsAssignment_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEmptyObjectBug284850Access().getItemsAssignment_1());
		}
		public static IGrammarAwareElementType createEmptyObjectBug284850_ItemsEmptyObjectItemsParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("EmptyObjectBug284850_ItemsEmptyObjectItemsParserRuleCall_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEmptyObjectBug284850Access().getItemsEmptyObjectItemsParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType EmptyObjectBug284850_ELEMENT_TYPE = associate(EmptyObjectBug284850Factory.createEmptyObjectBug284850ElementType());

	public static final IGrammarAwareElementType EmptyObjectBug284850_Group_ELEMENT_TYPE = associate(EmptyObjectBug284850Factory.createEmptyObjectBug284850_GroupElementType());

	public static final IGrammarAwareElementType EmptyObjectBug284850_NumberSignDigitOneDigitFourKeyword_0_ELEMENT_TYPE = associate(EmptyObjectBug284850Factory.createEmptyObjectBug284850_NumberSignDigitOneDigitFourKeyword_0ElementType());

	public static final IGrammarAwareElementType EmptyObjectBug284850_ItemsAssignment_1_ELEMENT_TYPE = associate(EmptyObjectBug284850Factory.createEmptyObjectBug284850_ItemsAssignment_1ElementType());

	public static final IGrammarAwareElementType EmptyObjectBug284850_ItemsEmptyObjectItemsParserRuleCall_1_0_ELEMENT_TYPE = associate(EmptyObjectBug284850Factory.createEmptyObjectBug284850_ItemsEmptyObjectItemsParserRuleCall_1_0ElementType());

	private static class EmptyObjectItemsFactory {
		public static IGrammarAwareElementType createEmptyObjectItemsElementType() {
			return new IGrammarAwareElementType("EmptyObjectItems_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEmptyObjectItemsRule());
		}
		public static IGrammarAwareElementType createEmptyObjectItems_ListAssignmentElementType() {
			return new IGrammarAwareElementType("EmptyObjectItems_ListAssignment_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEmptyObjectItemsAccess().getListAssignment());
		}
		public static IGrammarAwareElementType createEmptyObjectItems_ListEmptyObjectItemParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("EmptyObjectItems_ListEmptyObjectItemParserRuleCall_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEmptyObjectItemsAccess().getListEmptyObjectItemParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType EmptyObjectItems_ELEMENT_TYPE = associate(EmptyObjectItemsFactory.createEmptyObjectItemsElementType());

	public static final IGrammarAwareElementType EmptyObjectItems_ListAssignment_ELEMENT_TYPE = associate(EmptyObjectItemsFactory.createEmptyObjectItems_ListAssignmentElementType());

	public static final IGrammarAwareElementType EmptyObjectItems_ListEmptyObjectItemParserRuleCall_0_ELEMENT_TYPE = associate(EmptyObjectItemsFactory.createEmptyObjectItems_ListEmptyObjectItemParserRuleCall_0ElementType());

	private static class EmptyObjectItemFactory {
		public static IGrammarAwareElementType createEmptyObjectItemElementType() {
			return new IGrammarAwareElementType("EmptyObjectItem_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEmptyObjectItemRule());
		}
		public static IGrammarAwareElementType createEmptyObjectItem_GroupElementType() {
			return new IGrammarAwareElementType("EmptyObjectItem_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEmptyObjectItemAccess().getGroup());
		}
		public static IGrammarAwareElementType createEmptyObjectItem_ItemKeyword_0ElementType() {
			return new IGrammarAwareElementType("EmptyObjectItem_ItemKeyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEmptyObjectItemAccess().getItemKeyword_0());
		}
		public static IGrammarAwareElementType createEmptyObjectItem_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("EmptyObjectItem_NameAssignment_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEmptyObjectItemAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createEmptyObjectItem_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("EmptyObjectItem_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEmptyObjectItemAccess().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType EmptyObjectItem_ELEMENT_TYPE = associate(EmptyObjectItemFactory.createEmptyObjectItemElementType());

	public static final IGrammarAwareElementType EmptyObjectItem_Group_ELEMENT_TYPE = associate(EmptyObjectItemFactory.createEmptyObjectItem_GroupElementType());

	public static final IGrammarAwareElementType EmptyObjectItem_ItemKeyword_0_ELEMENT_TYPE = associate(EmptyObjectItemFactory.createEmptyObjectItem_ItemKeyword_0ElementType());

	public static final IGrammarAwareElementType EmptyObjectItem_NameAssignment_1_ELEMENT_TYPE = associate(EmptyObjectItemFactory.createEmptyObjectItem_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType EmptyObjectItem_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(EmptyObjectItemFactory.createEmptyObjectItem_NameIDTerminalRuleCall_1_0ElementType());

	private static class MultiInheritanceBug280439Factory {
		public static IGrammarAwareElementType createMultiInheritanceBug280439ElementType() {
			return new IGrammarAwareElementType("MultiInheritanceBug280439_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiInheritanceBug280439Rule());
		}
		public static IGrammarAwareElementType createMultiInheritanceBug280439_GroupElementType() {
			return new IGrammarAwareElementType("MultiInheritanceBug280439_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiInheritanceBug280439Access().getGroup());
		}
		public static IGrammarAwareElementType createMultiInheritanceBug280439_NumberSignDigitOneDigitFiveKeyword_0ElementType() {
			return new IGrammarAwareElementType("MultiInheritanceBug280439_NumberSignDigitOneDigitFiveKeyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiInheritanceBug280439Access().getNumberSignDigitOneDigitFiveKeyword_0());
		}
		public static IGrammarAwareElementType createMultiInheritanceBug280439_ValAssignment_1ElementType() {
			return new IGrammarAwareElementType("MultiInheritanceBug280439_ValAssignment_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiInheritanceBug280439Access().getValAssignment_1());
		}
		public static IGrammarAwareElementType createMultiInheritanceBug280439_ValConcreteMultiParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("MultiInheritanceBug280439_ValConcreteMultiParserRuleCall_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMultiInheritanceBug280439Access().getValConcreteMultiParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType MultiInheritanceBug280439_ELEMENT_TYPE = associate(MultiInheritanceBug280439Factory.createMultiInheritanceBug280439ElementType());

	public static final IGrammarAwareElementType MultiInheritanceBug280439_Group_ELEMENT_TYPE = associate(MultiInheritanceBug280439Factory.createMultiInheritanceBug280439_GroupElementType());

	public static final IGrammarAwareElementType MultiInheritanceBug280439_NumberSignDigitOneDigitFiveKeyword_0_ELEMENT_TYPE = associate(MultiInheritanceBug280439Factory.createMultiInheritanceBug280439_NumberSignDigitOneDigitFiveKeyword_0ElementType());

	public static final IGrammarAwareElementType MultiInheritanceBug280439_ValAssignment_1_ELEMENT_TYPE = associate(MultiInheritanceBug280439Factory.createMultiInheritanceBug280439_ValAssignment_1ElementType());

	public static final IGrammarAwareElementType MultiInheritanceBug280439_ValConcreteMultiParserRuleCall_1_0_ELEMENT_TYPE = associate(MultiInheritanceBug280439Factory.createMultiInheritanceBug280439_ValConcreteMultiParserRuleCall_1_0ElementType());

	private static class AbstractMulti1Factory {
		public static IGrammarAwareElementType createAbstractMulti1ElementType() {
			return new IGrammarAwareElementType("AbstractMulti1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractMulti1Rule());
		}
		public static IGrammarAwareElementType createAbstractMulti1_AlternativesElementType() {
			return new IGrammarAwareElementType("AbstractMulti1_Alternatives_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractMulti1Access().getAlternatives());
		}
		public static IGrammarAwareElementType createAbstractMulti1_ConcreteMultiParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("AbstractMulti1_ConcreteMultiParserRuleCall_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractMulti1Access().getConcreteMultiParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAbstractMulti1_M1Assignment_1ElementType() {
			return new IGrammarAwareElementType("AbstractMulti1_M1Assignment_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractMulti1Access().getM1Assignment_1());
		}
		public static IGrammarAwareElementType createAbstractMulti1_M1IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("AbstractMulti1_M1IDTerminalRuleCall_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractMulti1Access().getM1IDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType AbstractMulti1_ELEMENT_TYPE = associate(AbstractMulti1Factory.createAbstractMulti1ElementType());

	public static final IGrammarAwareElementType AbstractMulti1_Alternatives_ELEMENT_TYPE = associate(AbstractMulti1Factory.createAbstractMulti1_AlternativesElementType());

	public static final IGrammarAwareElementType AbstractMulti1_ConcreteMultiParserRuleCall_0_ELEMENT_TYPE = associate(AbstractMulti1Factory.createAbstractMulti1_ConcreteMultiParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType AbstractMulti1_M1Assignment_1_ELEMENT_TYPE = associate(AbstractMulti1Factory.createAbstractMulti1_M1Assignment_1ElementType());

	public static final IGrammarAwareElementType AbstractMulti1_M1IDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(AbstractMulti1Factory.createAbstractMulti1_M1IDTerminalRuleCall_1_0ElementType());

	private static class AbstractMulti2Factory {
		public static IGrammarAwareElementType createAbstractMulti2ElementType() {
			return new IGrammarAwareElementType("AbstractMulti2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractMulti2Rule());
		}
		public static IGrammarAwareElementType createAbstractMulti2_AlternativesElementType() {
			return new IGrammarAwareElementType("AbstractMulti2_Alternatives_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractMulti2Access().getAlternatives());
		}
		public static IGrammarAwareElementType createAbstractMulti2_ConcreteMultiParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("AbstractMulti2_ConcreteMultiParserRuleCall_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractMulti2Access().getConcreteMultiParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAbstractMulti2_M2Assignment_1ElementType() {
			return new IGrammarAwareElementType("AbstractMulti2_M2Assignment_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractMulti2Access().getM2Assignment_1());
		}
		public static IGrammarAwareElementType createAbstractMulti2_M2IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("AbstractMulti2_M2IDTerminalRuleCall_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractMulti2Access().getM2IDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType AbstractMulti2_ELEMENT_TYPE = associate(AbstractMulti2Factory.createAbstractMulti2ElementType());

	public static final IGrammarAwareElementType AbstractMulti2_Alternatives_ELEMENT_TYPE = associate(AbstractMulti2Factory.createAbstractMulti2_AlternativesElementType());

	public static final IGrammarAwareElementType AbstractMulti2_ConcreteMultiParserRuleCall_0_ELEMENT_TYPE = associate(AbstractMulti2Factory.createAbstractMulti2_ConcreteMultiParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType AbstractMulti2_M2Assignment_1_ELEMENT_TYPE = associate(AbstractMulti2Factory.createAbstractMulti2_M2Assignment_1ElementType());

	public static final IGrammarAwareElementType AbstractMulti2_M2IDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(AbstractMulti2Factory.createAbstractMulti2_M2IDTerminalRuleCall_1_0ElementType());

	private static class ConcreteMultiFactory {
		public static IGrammarAwareElementType createConcreteMultiElementType() {
			return new IGrammarAwareElementType("ConcreteMulti_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConcreteMultiRule());
		}
		public static IGrammarAwareElementType createConcreteMulti_GroupElementType() {
			return new IGrammarAwareElementType("ConcreteMulti_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConcreteMultiAccess().getGroup());
		}
		public static IGrammarAwareElementType createConcreteMulti_M1Assignment_0ElementType() {
			return new IGrammarAwareElementType("ConcreteMulti_M1Assignment_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConcreteMultiAccess().getM1Assignment_0());
		}
		public static IGrammarAwareElementType createConcreteMulti_M1IDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("ConcreteMulti_M1IDTerminalRuleCall_0_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConcreteMultiAccess().getM1IDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createConcreteMulti_M2Assignment_1ElementType() {
			return new IGrammarAwareElementType("ConcreteMulti_M2Assignment_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConcreteMultiAccess().getM2Assignment_1());
		}
		public static IGrammarAwareElementType createConcreteMulti_M2IDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("ConcreteMulti_M2IDTerminalRuleCall_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getConcreteMultiAccess().getM2IDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType ConcreteMulti_ELEMENT_TYPE = associate(ConcreteMultiFactory.createConcreteMultiElementType());

	public static final IGrammarAwareElementType ConcreteMulti_Group_ELEMENT_TYPE = associate(ConcreteMultiFactory.createConcreteMulti_GroupElementType());

	public static final IGrammarAwareElementType ConcreteMulti_M1Assignment_0_ELEMENT_TYPE = associate(ConcreteMultiFactory.createConcreteMulti_M1Assignment_0ElementType());

	public static final IGrammarAwareElementType ConcreteMulti_M1IDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(ConcreteMultiFactory.createConcreteMulti_M1IDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType ConcreteMulti_M2Assignment_1_ELEMENT_TYPE = associate(ConcreteMultiFactory.createConcreteMulti_M2Assignment_1ElementType());

	public static final IGrammarAwareElementType ConcreteMulti_M2IDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(ConcreteMultiFactory.createConcreteMulti_M2IDTerminalRuleCall_1_0ElementType());

	private static class EObjectRefFactory {
		public static IGrammarAwareElementType createEObjectRefElementType() {
			return new IGrammarAwareElementType("EObjectRef_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEObjectRefRule());
		}
		public static IGrammarAwareElementType createEObjectRef_GroupElementType() {
			return new IGrammarAwareElementType("EObjectRef_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEObjectRefAccess().getGroup());
		}
		public static IGrammarAwareElementType createEObjectRef_NumberSignDigitOneDigitSixKeyword_0ElementType() {
			return new IGrammarAwareElementType("EObjectRef_NumberSignDigitOneDigitSixKeyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEObjectRefAccess().getNumberSignDigitOneDigitSixKeyword_0());
		}
		public static IGrammarAwareElementType createEObjectRef_ObjAssignment_1ElementType() {
			return new IGrammarAwareElementType("EObjectRef_ObjAssignment_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEObjectRefAccess().getObjAssignment_1());
		}
		public static IGrammarAwareElementType createEObjectRef_ObjEObjectElementParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("EObjectRef_ObjEObjectElementParserRuleCall_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEObjectRefAccess().getObjEObjectElementParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createEObjectRef_RefsKeyword_2ElementType() {
			return new IGrammarAwareElementType("EObjectRef_RefsKeyword_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEObjectRefAccess().getRefsKeyword_2());
		}
		public static IGrammarAwareElementType createEObjectRef_RefAssignment_3ElementType() {
			return new IGrammarAwareElementType("EObjectRef_RefAssignment_3_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEObjectRefAccess().getRefAssignment_3());
		}
		public static IGrammarAwareElementType createEObjectRef_RefEObjectCrossReference_3_0ElementType() {
			return new IGrammarAwareElementType("EObjectRef_RefEObjectCrossReference_3_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEObjectRefAccess().getRefEObjectCrossReference_3_0());
		}
		public static IGrammarAwareElementType createEObjectRef_RefEObjectIDTerminalRuleCall_3_0_1ElementType() {
			return new IGrammarAwareElementType("EObjectRef_RefEObjectIDTerminalRuleCall_3_0_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEObjectRefAccess().getRefEObjectIDTerminalRuleCall_3_0_1());
		}
	}

	public static final IGrammarAwareElementType EObjectRef_ELEMENT_TYPE = associate(EObjectRefFactory.createEObjectRefElementType());

	public static final IGrammarAwareElementType EObjectRef_Group_ELEMENT_TYPE = associate(EObjectRefFactory.createEObjectRef_GroupElementType());

	public static final IGrammarAwareElementType EObjectRef_NumberSignDigitOneDigitSixKeyword_0_ELEMENT_TYPE = associate(EObjectRefFactory.createEObjectRef_NumberSignDigitOneDigitSixKeyword_0ElementType());

	public static final IGrammarAwareElementType EObjectRef_ObjAssignment_1_ELEMENT_TYPE = associate(EObjectRefFactory.createEObjectRef_ObjAssignment_1ElementType());

	public static final IGrammarAwareElementType EObjectRef_ObjEObjectElementParserRuleCall_1_0_ELEMENT_TYPE = associate(EObjectRefFactory.createEObjectRef_ObjEObjectElementParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType EObjectRef_RefsKeyword_2_ELEMENT_TYPE = associate(EObjectRefFactory.createEObjectRef_RefsKeyword_2ElementType());

	public static final IGrammarAwareElementType EObjectRef_RefAssignment_3_ELEMENT_TYPE = associate(EObjectRefFactory.createEObjectRef_RefAssignment_3ElementType());

	public static final IGrammarAwareElementType EObjectRef_RefEObjectCrossReference_3_0_ELEMENT_TYPE = associate(EObjectRefFactory.createEObjectRef_RefEObjectCrossReference_3_0ElementType());

	public static final IGrammarAwareElementType EObjectRef_RefEObjectIDTerminalRuleCall_3_0_1_ELEMENT_TYPE = associate(EObjectRefFactory.createEObjectRef_RefEObjectIDTerminalRuleCall_3_0_1ElementType());

	private static class EObjectElementFactory {
		public static IGrammarAwareElementType createEObjectElementElementType() {
			return new IGrammarAwareElementType("EObjectElement_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEObjectElementRule());
		}
		public static IGrammarAwareElementType createEObjectElement_NameAssignmentElementType() {
			return new IGrammarAwareElementType("EObjectElement_NameAssignment_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEObjectElementAccess().getNameAssignment());
		}
		public static IGrammarAwareElementType createEObjectElement_NameIDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("EObjectElement_NameIDTerminalRuleCall_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEObjectElementAccess().getNameIDTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType EObjectElement_ELEMENT_TYPE = associate(EObjectElementFactory.createEObjectElementElementType());

	public static final IGrammarAwareElementType EObjectElement_NameAssignment_ELEMENT_TYPE = associate(EObjectElementFactory.createEObjectElement_NameAssignmentElementType());

	public static final IGrammarAwareElementType EObjectElement_NameIDTerminalRuleCall_0_ELEMENT_TYPE = associate(EObjectElementFactory.createEObjectElement_NameIDTerminalRuleCall_0ElementType());

	private static class TypeBug305577_1Factory {
		public static IGrammarAwareElementType createTypeBug305577_1ElementType() {
			return new IGrammarAwareElementType("TypeBug305577_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug305577_1Rule());
		}
		public static IGrammarAwareElementType createTypeBug305577_1_GroupElementType() {
			return new IGrammarAwareElementType("TypeBug305577_1_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug305577_1Access().getGroup());
		}
		public static IGrammarAwareElementType createTypeBug305577_1_NumberSignDigitOneDigitSevenKeyword_0ElementType() {
			return new IGrammarAwareElementType("TypeBug305577_1_NumberSignDigitOneDigitSevenKeyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug305577_1Access().getNumberSignDigitOneDigitSevenKeyword_0());
		}
		public static IGrammarAwareElementType createTypeBug305577_1_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("TypeBug305577_1_Alternatives_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug305577_1Access().getAlternatives_1());
		}
		public static IGrammarAwareElementType createTypeBug305577_1_TypeBug1AParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("TypeBug305577_1_TypeBug1AParserRuleCall_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug305577_1Access().getTypeBug1AParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createTypeBug305577_1_TypeBug1BParserRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("TypeBug305577_1_TypeBug1BParserRuleCall_1_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug305577_1Access().getTypeBug1BParserRuleCall_1_1());
		}
	}

	public static final IGrammarAwareElementType TypeBug305577_1_ELEMENT_TYPE = associate(TypeBug305577_1Factory.createTypeBug305577_1ElementType());

	public static final IGrammarAwareElementType TypeBug305577_1_Group_ELEMENT_TYPE = associate(TypeBug305577_1Factory.createTypeBug305577_1_GroupElementType());

	public static final IGrammarAwareElementType TypeBug305577_1_NumberSignDigitOneDigitSevenKeyword_0_ELEMENT_TYPE = associate(TypeBug305577_1Factory.createTypeBug305577_1_NumberSignDigitOneDigitSevenKeyword_0ElementType());

	public static final IGrammarAwareElementType TypeBug305577_1_Alternatives_1_ELEMENT_TYPE = associate(TypeBug305577_1Factory.createTypeBug305577_1_Alternatives_1ElementType());

	public static final IGrammarAwareElementType TypeBug305577_1_TypeBug1AParserRuleCall_1_0_ELEMENT_TYPE = associate(TypeBug305577_1Factory.createTypeBug305577_1_TypeBug1AParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType TypeBug305577_1_TypeBug1BParserRuleCall_1_1_ELEMENT_TYPE = associate(TypeBug305577_1Factory.createTypeBug305577_1_TypeBug1BParserRuleCall_1_1ElementType());

	private static class TypeBug305577_2Factory {
		public static IGrammarAwareElementType createTypeBug305577_2ElementType() {
			return new IGrammarAwareElementType("TypeBug305577_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug305577_2Rule());
		}
		public static IGrammarAwareElementType createTypeBug305577_2_GroupElementType() {
			return new IGrammarAwareElementType("TypeBug305577_2_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug305577_2Access().getGroup());
		}
		public static IGrammarAwareElementType createTypeBug305577_2_NumberSignDigitOneDigitEightKeyword_0ElementType() {
			return new IGrammarAwareElementType("TypeBug305577_2_NumberSignDigitOneDigitEightKeyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug305577_2Access().getNumberSignDigitOneDigitEightKeyword_0());
		}
		public static IGrammarAwareElementType createTypeBug305577_2_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("TypeBug305577_2_Alternatives_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug305577_2Access().getAlternatives_1());
		}
		public static IGrammarAwareElementType createTypeBug305577_2_TypeBug2BParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("TypeBug305577_2_TypeBug2BParserRuleCall_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug305577_2Access().getTypeBug2BParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createTypeBug305577_2_TypeBug2AParserRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("TypeBug305577_2_TypeBug2AParserRuleCall_1_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug305577_2Access().getTypeBug2AParserRuleCall_1_1());
		}
	}

	public static final IGrammarAwareElementType TypeBug305577_2_ELEMENT_TYPE = associate(TypeBug305577_2Factory.createTypeBug305577_2ElementType());

	public static final IGrammarAwareElementType TypeBug305577_2_Group_ELEMENT_TYPE = associate(TypeBug305577_2Factory.createTypeBug305577_2_GroupElementType());

	public static final IGrammarAwareElementType TypeBug305577_2_NumberSignDigitOneDigitEightKeyword_0_ELEMENT_TYPE = associate(TypeBug305577_2Factory.createTypeBug305577_2_NumberSignDigitOneDigitEightKeyword_0ElementType());

	public static final IGrammarAwareElementType TypeBug305577_2_Alternatives_1_ELEMENT_TYPE = associate(TypeBug305577_2Factory.createTypeBug305577_2_Alternatives_1ElementType());

	public static final IGrammarAwareElementType TypeBug305577_2_TypeBug2BParserRuleCall_1_0_ELEMENT_TYPE = associate(TypeBug305577_2Factory.createTypeBug305577_2_TypeBug2BParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType TypeBug305577_2_TypeBug2AParserRuleCall_1_1_ELEMENT_TYPE = associate(TypeBug305577_2Factory.createTypeBug305577_2_TypeBug2AParserRuleCall_1_1ElementType());

	private static class TypeBug1AInhFactory {
		public static IGrammarAwareElementType createTypeBug1AInhElementType() {
			return new IGrammarAwareElementType("TypeBug1AInh_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug1AInhRule());
		}
		public static IGrammarAwareElementType createTypeBug1AInh_TypeBug1BParserRuleCallElementType() {
			return new IGrammarAwareElementType("TypeBug1AInh_TypeBug1BParserRuleCall_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug1AInhAccess().getTypeBug1BParserRuleCall());
		}
	}

	public static final IGrammarAwareElementType TypeBug1AInh_ELEMENT_TYPE = associate(TypeBug1AInhFactory.createTypeBug1AInhElementType());

	public static final IGrammarAwareElementType TypeBug1AInh_TypeBug1BParserRuleCall_ELEMENT_TYPE = associate(TypeBug1AInhFactory.createTypeBug1AInh_TypeBug1BParserRuleCallElementType());

	private static class TypeBug1AFactory {
		public static IGrammarAwareElementType createTypeBug1AElementType() {
			return new IGrammarAwareElementType("TypeBug1A_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug1ARule());
		}
		public static IGrammarAwareElementType createTypeBug1A_GroupElementType() {
			return new IGrammarAwareElementType("TypeBug1A_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug1AAccess().getGroup());
		}
		public static IGrammarAwareElementType createTypeBug1A_TypeBug1AAction_0ElementType() {
			return new IGrammarAwareElementType("TypeBug1A_TypeBug1AAction_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug1AAccess().getTypeBug1AAction_0());
		}
		public static IGrammarAwareElementType createTypeBug1A_KaKeyword_1ElementType() {
			return new IGrammarAwareElementType("TypeBug1A_KaKeyword_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug1AAccess().getKaKeyword_1());
		}
		public static IGrammarAwareElementType createTypeBug1A_NameAssignment_2ElementType() {
			return new IGrammarAwareElementType("TypeBug1A_NameAssignment_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug1AAccess().getNameAssignment_2());
		}
		public static IGrammarAwareElementType createTypeBug1A_NameIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("TypeBug1A_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug1AAccess().getNameIDTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType TypeBug1A_ELEMENT_TYPE = associate(TypeBug1AFactory.createTypeBug1AElementType());

	public static final IGrammarAwareElementType TypeBug1A_Group_ELEMENT_TYPE = associate(TypeBug1AFactory.createTypeBug1A_GroupElementType());

	public static final IGrammarAwareElementType TypeBug1A_TypeBug1AAction_0_ELEMENT_TYPE = associate(TypeBug1AFactory.createTypeBug1A_TypeBug1AAction_0ElementType());

	public static final IGrammarAwareElementType TypeBug1A_KaKeyword_1_ELEMENT_TYPE = associate(TypeBug1AFactory.createTypeBug1A_KaKeyword_1ElementType());

	public static final IGrammarAwareElementType TypeBug1A_NameAssignment_2_ELEMENT_TYPE = associate(TypeBug1AFactory.createTypeBug1A_NameAssignment_2ElementType());

	public static final IGrammarAwareElementType TypeBug1A_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(TypeBug1AFactory.createTypeBug1A_NameIDTerminalRuleCall_2_0ElementType());

	private static class TypeBug1BFactory {
		public static IGrammarAwareElementType createTypeBug1BElementType() {
			return new IGrammarAwareElementType("TypeBug1B_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug1BRule());
		}
		public static IGrammarAwareElementType createTypeBug1B_GroupElementType() {
			return new IGrammarAwareElementType("TypeBug1B_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug1BAccess().getGroup());
		}
		public static IGrammarAwareElementType createTypeBug1B_TypeBug1BAction_0ElementType() {
			return new IGrammarAwareElementType("TypeBug1B_TypeBug1BAction_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug1BAccess().getTypeBug1BAction_0());
		}
		public static IGrammarAwareElementType createTypeBug1B_KbKeyword_1ElementType() {
			return new IGrammarAwareElementType("TypeBug1B_KbKeyword_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug1BAccess().getKbKeyword_1());
		}
		public static IGrammarAwareElementType createTypeBug1B_NameAssignment_2ElementType() {
			return new IGrammarAwareElementType("TypeBug1B_NameAssignment_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug1BAccess().getNameAssignment_2());
		}
		public static IGrammarAwareElementType createTypeBug1B_NameIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("TypeBug1B_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug1BAccess().getNameIDTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType TypeBug1B_ELEMENT_TYPE = associate(TypeBug1BFactory.createTypeBug1BElementType());

	public static final IGrammarAwareElementType TypeBug1B_Group_ELEMENT_TYPE = associate(TypeBug1BFactory.createTypeBug1B_GroupElementType());

	public static final IGrammarAwareElementType TypeBug1B_TypeBug1BAction_0_ELEMENT_TYPE = associate(TypeBug1BFactory.createTypeBug1B_TypeBug1BAction_0ElementType());

	public static final IGrammarAwareElementType TypeBug1B_KbKeyword_1_ELEMENT_TYPE = associate(TypeBug1BFactory.createTypeBug1B_KbKeyword_1ElementType());

	public static final IGrammarAwareElementType TypeBug1B_NameAssignment_2_ELEMENT_TYPE = associate(TypeBug1BFactory.createTypeBug1B_NameAssignment_2ElementType());

	public static final IGrammarAwareElementType TypeBug1B_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(TypeBug1BFactory.createTypeBug1B_NameIDTerminalRuleCall_2_0ElementType());

	private static class TypeBug2AInhFactory {
		public static IGrammarAwareElementType createTypeBug2AInhElementType() {
			return new IGrammarAwareElementType("TypeBug2AInh_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug2AInhRule());
		}
		public static IGrammarAwareElementType createTypeBug2AInh_TypeBug2BParserRuleCallElementType() {
			return new IGrammarAwareElementType("TypeBug2AInh_TypeBug2BParserRuleCall_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug2AInhAccess().getTypeBug2BParserRuleCall());
		}
	}

	public static final IGrammarAwareElementType TypeBug2AInh_ELEMENT_TYPE = associate(TypeBug2AInhFactory.createTypeBug2AInhElementType());

	public static final IGrammarAwareElementType TypeBug2AInh_TypeBug2BParserRuleCall_ELEMENT_TYPE = associate(TypeBug2AInhFactory.createTypeBug2AInh_TypeBug2BParserRuleCallElementType());

	private static class TypeBug2AFactory {
		public static IGrammarAwareElementType createTypeBug2AElementType() {
			return new IGrammarAwareElementType("TypeBug2A_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug2ARule());
		}
		public static IGrammarAwareElementType createTypeBug2A_GroupElementType() {
			return new IGrammarAwareElementType("TypeBug2A_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug2AAccess().getGroup());
		}
		public static IGrammarAwareElementType createTypeBug2A_TypeBug2AAction_0ElementType() {
			return new IGrammarAwareElementType("TypeBug2A_TypeBug2AAction_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug2AAccess().getTypeBug2AAction_0());
		}
		public static IGrammarAwareElementType createTypeBug2A_KaKeyword_1ElementType() {
			return new IGrammarAwareElementType("TypeBug2A_KaKeyword_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug2AAccess().getKaKeyword_1());
		}
		public static IGrammarAwareElementType createTypeBug2A_NameAssignment_2ElementType() {
			return new IGrammarAwareElementType("TypeBug2A_NameAssignment_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug2AAccess().getNameAssignment_2());
		}
		public static IGrammarAwareElementType createTypeBug2A_NameIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("TypeBug2A_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug2AAccess().getNameIDTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType TypeBug2A_ELEMENT_TYPE = associate(TypeBug2AFactory.createTypeBug2AElementType());

	public static final IGrammarAwareElementType TypeBug2A_Group_ELEMENT_TYPE = associate(TypeBug2AFactory.createTypeBug2A_GroupElementType());

	public static final IGrammarAwareElementType TypeBug2A_TypeBug2AAction_0_ELEMENT_TYPE = associate(TypeBug2AFactory.createTypeBug2A_TypeBug2AAction_0ElementType());

	public static final IGrammarAwareElementType TypeBug2A_KaKeyword_1_ELEMENT_TYPE = associate(TypeBug2AFactory.createTypeBug2A_KaKeyword_1ElementType());

	public static final IGrammarAwareElementType TypeBug2A_NameAssignment_2_ELEMENT_TYPE = associate(TypeBug2AFactory.createTypeBug2A_NameAssignment_2ElementType());

	public static final IGrammarAwareElementType TypeBug2A_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(TypeBug2AFactory.createTypeBug2A_NameIDTerminalRuleCall_2_0ElementType());

	private static class TypeBug2BFactory {
		public static IGrammarAwareElementType createTypeBug2BElementType() {
			return new IGrammarAwareElementType("TypeBug2B_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug2BRule());
		}
		public static IGrammarAwareElementType createTypeBug2B_GroupElementType() {
			return new IGrammarAwareElementType("TypeBug2B_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug2BAccess().getGroup());
		}
		public static IGrammarAwareElementType createTypeBug2B_TypeBug2BAction_0ElementType() {
			return new IGrammarAwareElementType("TypeBug2B_TypeBug2BAction_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug2BAccess().getTypeBug2BAction_0());
		}
		public static IGrammarAwareElementType createTypeBug2B_KbKeyword_1ElementType() {
			return new IGrammarAwareElementType("TypeBug2B_KbKeyword_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug2BAccess().getKbKeyword_1());
		}
		public static IGrammarAwareElementType createTypeBug2B_NameAssignment_2ElementType() {
			return new IGrammarAwareElementType("TypeBug2B_NameAssignment_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug2BAccess().getNameAssignment_2());
		}
		public static IGrammarAwareElementType createTypeBug2B_NameIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("TypeBug2B_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeBug2BAccess().getNameIDTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType TypeBug2B_ELEMENT_TYPE = associate(TypeBug2BFactory.createTypeBug2BElementType());

	public static final IGrammarAwareElementType TypeBug2B_Group_ELEMENT_TYPE = associate(TypeBug2BFactory.createTypeBug2B_GroupElementType());

	public static final IGrammarAwareElementType TypeBug2B_TypeBug2BAction_0_ELEMENT_TYPE = associate(TypeBug2BFactory.createTypeBug2B_TypeBug2BAction_0ElementType());

	public static final IGrammarAwareElementType TypeBug2B_KbKeyword_1_ELEMENT_TYPE = associate(TypeBug2BFactory.createTypeBug2B_KbKeyword_1ElementType());

	public static final IGrammarAwareElementType TypeBug2B_NameAssignment_2_ELEMENT_TYPE = associate(TypeBug2BFactory.createTypeBug2B_NameAssignment_2ElementType());

	public static final IGrammarAwareElementType TypeBug2B_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(TypeBug2BFactory.createTypeBug2B_NameIDTerminalRuleCall_2_0ElementType());

	private static class Bug305171Factory {
		public static IGrammarAwareElementType createBug305171ElementType() {
			return new IGrammarAwareElementType("Bug305171_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Rule());
		}
		public static IGrammarAwareElementType createBug305171_GroupElementType() {
			return new IGrammarAwareElementType("Bug305171_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getGroup());
		}
		public static IGrammarAwareElementType createBug305171_NumberSignDigitOneDigitNineKeyword_0ElementType() {
			return new IGrammarAwareElementType("Bug305171_NumberSignDigitOneDigitNineKeyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getNumberSignDigitOneDigitNineKeyword_0());
		}
		public static IGrammarAwareElementType createBug305171_Group_1ElementType() {
			return new IGrammarAwareElementType("Bug305171_Group_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getGroup_1());
		}
		public static IGrammarAwareElementType createBug305171_Group_1_0ElementType() {
			return new IGrammarAwareElementType("Bug305171_Group_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getGroup_1_0());
		}
		public static IGrammarAwareElementType createBug305171_KxKeyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("Bug305171_KxKeyword_1_0_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getKxKeyword_1_0_0());
		}
		public static IGrammarAwareElementType createBug305171_XAssignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("Bug305171_XAssignment_1_0_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getXAssignment_1_0_1());
		}
		public static IGrammarAwareElementType createBug305171_XIDTerminalRuleCall_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("Bug305171_XIDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getXIDTerminalRuleCall_1_0_1_0());
		}
		public static IGrammarAwareElementType createBug305171_Group_1_0_2ElementType() {
			return new IGrammarAwareElementType("Bug305171_Group_1_0_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getGroup_1_0_2());
		}
		public static IGrammarAwareElementType createBug305171_CommaKeyword_1_0_2_0ElementType() {
			return new IGrammarAwareElementType("Bug305171_CommaKeyword_1_0_2_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getCommaKeyword_1_0_2_0());
		}
		public static IGrammarAwareElementType createBug305171_XAssignment_1_0_2_1ElementType() {
			return new IGrammarAwareElementType("Bug305171_XAssignment_1_0_2_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getXAssignment_1_0_2_1());
		}
		public static IGrammarAwareElementType createBug305171_XIDTerminalRuleCall_1_0_2_1_0ElementType() {
			return new IGrammarAwareElementType("Bug305171_XIDTerminalRuleCall_1_0_2_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getXIDTerminalRuleCall_1_0_2_1_0());
		}
		public static IGrammarAwareElementType createBug305171_Group_1_1ElementType() {
			return new IGrammarAwareElementType("Bug305171_Group_1_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getGroup_1_1());
		}
		public static IGrammarAwareElementType createBug305171_Group_1_1_0ElementType() {
			return new IGrammarAwareElementType("Bug305171_Group_1_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getGroup_1_1_0());
		}
		public static IGrammarAwareElementType createBug305171_KyKeyword_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("Bug305171_KyKeyword_1_1_0_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getKyKeyword_1_1_0_0());
		}
		public static IGrammarAwareElementType createBug305171_YAssignment_1_1_0_1ElementType() {
			return new IGrammarAwareElementType("Bug305171_YAssignment_1_1_0_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getYAssignment_1_1_0_1());
		}
		public static IGrammarAwareElementType createBug305171_YIDTerminalRuleCall_1_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("Bug305171_YIDTerminalRuleCall_1_1_0_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getYIDTerminalRuleCall_1_1_0_1_0());
		}
		public static IGrammarAwareElementType createBug305171_Group_1_1_0_2ElementType() {
			return new IGrammarAwareElementType("Bug305171_Group_1_1_0_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getGroup_1_1_0_2());
		}
		public static IGrammarAwareElementType createBug305171_CommaKeyword_1_1_0_2_0ElementType() {
			return new IGrammarAwareElementType("Bug305171_CommaKeyword_1_1_0_2_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getCommaKeyword_1_1_0_2_0());
		}
		public static IGrammarAwareElementType createBug305171_YAssignment_1_1_0_2_1ElementType() {
			return new IGrammarAwareElementType("Bug305171_YAssignment_1_1_0_2_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getYAssignment_1_1_0_2_1());
		}
		public static IGrammarAwareElementType createBug305171_YIDTerminalRuleCall_1_1_0_2_1_0ElementType() {
			return new IGrammarAwareElementType("Bug305171_YIDTerminalRuleCall_1_1_0_2_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getYIDTerminalRuleCall_1_1_0_2_1_0());
		}
		public static IGrammarAwareElementType createBug305171_Group_1_1_1ElementType() {
			return new IGrammarAwareElementType("Bug305171_Group_1_1_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getGroup_1_1_1());
		}
		public static IGrammarAwareElementType createBug305171_KzKeyword_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("Bug305171_KzKeyword_1_1_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getKzKeyword_1_1_1_0());
		}
		public static IGrammarAwareElementType createBug305171_ZAssignment_1_1_1_1ElementType() {
			return new IGrammarAwareElementType("Bug305171_ZAssignment_1_1_1_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getZAssignment_1_1_1_1());
		}
		public static IGrammarAwareElementType createBug305171_ZIDTerminalRuleCall_1_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("Bug305171_ZIDTerminalRuleCall_1_1_1_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getZIDTerminalRuleCall_1_1_1_1_0());
		}
		public static IGrammarAwareElementType createBug305171_Group_1_1_1_2ElementType() {
			return new IGrammarAwareElementType("Bug305171_Group_1_1_1_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getGroup_1_1_1_2());
		}
		public static IGrammarAwareElementType createBug305171_CommaKeyword_1_1_1_2_0ElementType() {
			return new IGrammarAwareElementType("Bug305171_CommaKeyword_1_1_1_2_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getCommaKeyword_1_1_1_2_0());
		}
		public static IGrammarAwareElementType createBug305171_ZAssignment_1_1_1_2_1ElementType() {
			return new IGrammarAwareElementType("Bug305171_ZAssignment_1_1_1_2_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getZAssignment_1_1_1_2_1());
		}
		public static IGrammarAwareElementType createBug305171_ZIDTerminalRuleCall_1_1_1_2_1_0ElementType() {
			return new IGrammarAwareElementType("Bug305171_ZIDTerminalRuleCall_1_1_1_2_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getZIDTerminalRuleCall_1_1_1_2_1_0());
		}
		public static IGrammarAwareElementType createBug305171_NameAssignment_2ElementType() {
			return new IGrammarAwareElementType("Bug305171_NameAssignment_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getNameAssignment_2());
		}
		public static IGrammarAwareElementType createBug305171_NameIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Bug305171_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug305171Access().getNameIDTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType Bug305171_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171ElementType());

	public static final IGrammarAwareElementType Bug305171_Group_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_GroupElementType());

	public static final IGrammarAwareElementType Bug305171_NumberSignDigitOneDigitNineKeyword_0_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_NumberSignDigitOneDigitNineKeyword_0ElementType());

	public static final IGrammarAwareElementType Bug305171_Group_1_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_Group_1ElementType());

	public static final IGrammarAwareElementType Bug305171_Group_1_0_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_Group_1_0ElementType());

	public static final IGrammarAwareElementType Bug305171_KxKeyword_1_0_0_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_KxKeyword_1_0_0ElementType());

	public static final IGrammarAwareElementType Bug305171_XAssignment_1_0_1_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_XAssignment_1_0_1ElementType());

	public static final IGrammarAwareElementType Bug305171_XIDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_XIDTerminalRuleCall_1_0_1_0ElementType());

	public static final IGrammarAwareElementType Bug305171_Group_1_0_2_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_Group_1_0_2ElementType());

	public static final IGrammarAwareElementType Bug305171_CommaKeyword_1_0_2_0_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_CommaKeyword_1_0_2_0ElementType());

	public static final IGrammarAwareElementType Bug305171_XAssignment_1_0_2_1_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_XAssignment_1_0_2_1ElementType());

	public static final IGrammarAwareElementType Bug305171_XIDTerminalRuleCall_1_0_2_1_0_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_XIDTerminalRuleCall_1_0_2_1_0ElementType());

	public static final IGrammarAwareElementType Bug305171_Group_1_1_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_Group_1_1ElementType());

	public static final IGrammarAwareElementType Bug305171_Group_1_1_0_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_Group_1_1_0ElementType());

	public static final IGrammarAwareElementType Bug305171_KyKeyword_1_1_0_0_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_KyKeyword_1_1_0_0ElementType());

	public static final IGrammarAwareElementType Bug305171_YAssignment_1_1_0_1_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_YAssignment_1_1_0_1ElementType());

	public static final IGrammarAwareElementType Bug305171_YIDTerminalRuleCall_1_1_0_1_0_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_YIDTerminalRuleCall_1_1_0_1_0ElementType());

	public static final IGrammarAwareElementType Bug305171_Group_1_1_0_2_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_Group_1_1_0_2ElementType());

	public static final IGrammarAwareElementType Bug305171_CommaKeyword_1_1_0_2_0_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_CommaKeyword_1_1_0_2_0ElementType());

	public static final IGrammarAwareElementType Bug305171_YAssignment_1_1_0_2_1_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_YAssignment_1_1_0_2_1ElementType());

	public static final IGrammarAwareElementType Bug305171_YIDTerminalRuleCall_1_1_0_2_1_0_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_YIDTerminalRuleCall_1_1_0_2_1_0ElementType());

	public static final IGrammarAwareElementType Bug305171_Group_1_1_1_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_Group_1_1_1ElementType());

	public static final IGrammarAwareElementType Bug305171_KzKeyword_1_1_1_0_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_KzKeyword_1_1_1_0ElementType());

	public static final IGrammarAwareElementType Bug305171_ZAssignment_1_1_1_1_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_ZAssignment_1_1_1_1ElementType());

	public static final IGrammarAwareElementType Bug305171_ZIDTerminalRuleCall_1_1_1_1_0_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_ZIDTerminalRuleCall_1_1_1_1_0ElementType());

	public static final IGrammarAwareElementType Bug305171_Group_1_1_1_2_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_Group_1_1_1_2ElementType());

	public static final IGrammarAwareElementType Bug305171_CommaKeyword_1_1_1_2_0_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_CommaKeyword_1_1_1_2_0ElementType());

	public static final IGrammarAwareElementType Bug305171_ZAssignment_1_1_1_2_1_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_ZAssignment_1_1_1_2_1ElementType());

	public static final IGrammarAwareElementType Bug305171_ZIDTerminalRuleCall_1_1_1_2_1_0_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_ZIDTerminalRuleCall_1_1_1_2_1_0ElementType());

	public static final IGrammarAwareElementType Bug305171_NameAssignment_2_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_NameAssignment_2ElementType());

	public static final IGrammarAwareElementType Bug305171_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(Bug305171Factory.createBug305171_NameIDTerminalRuleCall_2_0ElementType());

	private static class Bug310435EnumFactory {
		public static IGrammarAwareElementType createBug310435EnumElementType() {
			return new IGrammarAwareElementType("Bug310435Enum_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug310435EnumRule());
		}
		public static IGrammarAwareElementType createBug310435Enum_GroupElementType() {
			return new IGrammarAwareElementType("Bug310435Enum_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug310435EnumAccess().getGroup());
		}
		public static IGrammarAwareElementType createBug310435Enum_NumberSignDigitTwoDigitZeroKeyword_0ElementType() {
			return new IGrammarAwareElementType("Bug310435Enum_NumberSignDigitTwoDigitZeroKeyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug310435EnumAccess().getNumberSignDigitTwoDigitZeroKeyword_0());
		}
		public static IGrammarAwareElementType createBug310435Enum_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("Bug310435Enum_Alternatives_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug310435EnumAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createBug310435Enum_Group_1_0ElementType() {
			return new IGrammarAwareElementType("Bug310435Enum_Group_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug310435EnumAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createBug310435Enum_Kw1Keyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("Bug310435Enum_Kw1Keyword_1_0_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug310435EnumAccess().getKw1Keyword_1_0_0());
		}
		public static IGrammarAwareElementType createBug310435Enum_LitsAssignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("Bug310435Enum_LitsAssignment_1_0_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug310435EnumAccess().getLitsAssignment_1_0_1());
		}
		public static IGrammarAwareElementType createBug310435Enum_LitsEnumBug310435Lit1EnumRuleCall_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("Bug310435Enum_LitsEnumBug310435Lit1EnumRuleCall_1_0_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug310435EnumAccess().getLitsEnumBug310435Lit1EnumRuleCall_1_0_1_0());
		}
		public static IGrammarAwareElementType createBug310435Enum_Group_1_1ElementType() {
			return new IGrammarAwareElementType("Bug310435Enum_Group_1_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug310435EnumAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createBug310435Enum_Kw2Keyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("Bug310435Enum_Kw2Keyword_1_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug310435EnumAccess().getKw2Keyword_1_1_0());
		}
		public static IGrammarAwareElementType createBug310435Enum_LitsAssignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("Bug310435Enum_LitsAssignment_1_1_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug310435EnumAccess().getLitsAssignment_1_1_1());
		}
		public static IGrammarAwareElementType createBug310435Enum_LitsEnumBug310435Lit2EnumRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("Bug310435Enum_LitsEnumBug310435Lit2EnumRuleCall_1_1_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug310435EnumAccess().getLitsEnumBug310435Lit2EnumRuleCall_1_1_1_0());
		}
	}

	public static final IGrammarAwareElementType Bug310435Enum_ELEMENT_TYPE = associate(Bug310435EnumFactory.createBug310435EnumElementType());

	public static final IGrammarAwareElementType Bug310435Enum_Group_ELEMENT_TYPE = associate(Bug310435EnumFactory.createBug310435Enum_GroupElementType());

	public static final IGrammarAwareElementType Bug310435Enum_NumberSignDigitTwoDigitZeroKeyword_0_ELEMENT_TYPE = associate(Bug310435EnumFactory.createBug310435Enum_NumberSignDigitTwoDigitZeroKeyword_0ElementType());

	public static final IGrammarAwareElementType Bug310435Enum_Alternatives_1_ELEMENT_TYPE = associate(Bug310435EnumFactory.createBug310435Enum_Alternatives_1ElementType());

	public static final IGrammarAwareElementType Bug310435Enum_Group_1_0_ELEMENT_TYPE = associate(Bug310435EnumFactory.createBug310435Enum_Group_1_0ElementType());

	public static final IGrammarAwareElementType Bug310435Enum_Kw1Keyword_1_0_0_ELEMENT_TYPE = associate(Bug310435EnumFactory.createBug310435Enum_Kw1Keyword_1_0_0ElementType());

	public static final IGrammarAwareElementType Bug310435Enum_LitsAssignment_1_0_1_ELEMENT_TYPE = associate(Bug310435EnumFactory.createBug310435Enum_LitsAssignment_1_0_1ElementType());

	public static final IGrammarAwareElementType Bug310435Enum_LitsEnumBug310435Lit1EnumRuleCall_1_0_1_0_ELEMENT_TYPE = associate(Bug310435EnumFactory.createBug310435Enum_LitsEnumBug310435Lit1EnumRuleCall_1_0_1_0ElementType());

	public static final IGrammarAwareElementType Bug310435Enum_Group_1_1_ELEMENT_TYPE = associate(Bug310435EnumFactory.createBug310435Enum_Group_1_1ElementType());

	public static final IGrammarAwareElementType Bug310435Enum_Kw2Keyword_1_1_0_ELEMENT_TYPE = associate(Bug310435EnumFactory.createBug310435Enum_Kw2Keyword_1_1_0ElementType());

	public static final IGrammarAwareElementType Bug310435Enum_LitsAssignment_1_1_1_ELEMENT_TYPE = associate(Bug310435EnumFactory.createBug310435Enum_LitsAssignment_1_1_1ElementType());

	public static final IGrammarAwareElementType Bug310435Enum_LitsEnumBug310435Lit2EnumRuleCall_1_1_1_0_ELEMENT_TYPE = associate(Bug310435EnumFactory.createBug310435Enum_LitsEnumBug310435Lit2EnumRuleCall_1_1_1_0ElementType());

	private static class Bug310435ValFactory {
		public static IGrammarAwareElementType createBug310435ValElementType() {
			return new IGrammarAwareElementType("Bug310435Val_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug310435ValRule());
		}
		public static IGrammarAwareElementType createBug310435Val_GroupElementType() {
			return new IGrammarAwareElementType("Bug310435Val_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug310435ValAccess().getGroup());
		}
		public static IGrammarAwareElementType createBug310435Val_NumberSignDigitTwoDigitOneKeyword_0ElementType() {
			return new IGrammarAwareElementType("Bug310435Val_NumberSignDigitTwoDigitOneKeyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug310435ValAccess().getNumberSignDigitTwoDigitOneKeyword_0());
		}
		public static IGrammarAwareElementType createBug310435Val_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("Bug310435Val_Alternatives_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug310435ValAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createBug310435Val_Group_1_0ElementType() {
			return new IGrammarAwareElementType("Bug310435Val_Group_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug310435ValAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createBug310435Val_Kw1Keyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("Bug310435Val_Kw1Keyword_1_0_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug310435ValAccess().getKw1Keyword_1_0_0());
		}
		public static IGrammarAwareElementType createBug310435Val_LitsAssignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("Bug310435Val_LitsAssignment_1_0_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug310435ValAccess().getLitsAssignment_1_0_1());
		}
		public static IGrammarAwareElementType createBug310435Val_LitsIDTerminalRuleCall_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("Bug310435Val_LitsIDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug310435ValAccess().getLitsIDTerminalRuleCall_1_0_1_0());
		}
		public static IGrammarAwareElementType createBug310435Val_Group_1_1ElementType() {
			return new IGrammarAwareElementType("Bug310435Val_Group_1_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug310435ValAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createBug310435Val_Kw2Keyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("Bug310435Val_Kw2Keyword_1_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug310435ValAccess().getKw2Keyword_1_1_0());
		}
		public static IGrammarAwareElementType createBug310435Val_LitsAssignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("Bug310435Val_LitsAssignment_1_1_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug310435ValAccess().getLitsAssignment_1_1_1());
		}
		public static IGrammarAwareElementType createBug310435Val_LitsSTRINGTerminalRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("Bug310435Val_LitsSTRINGTerminalRuleCall_1_1_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBug310435ValAccess().getLitsSTRINGTerminalRuleCall_1_1_1_0());
		}
	}

	public static final IGrammarAwareElementType Bug310435Val_ELEMENT_TYPE = associate(Bug310435ValFactory.createBug310435ValElementType());

	public static final IGrammarAwareElementType Bug310435Val_Group_ELEMENT_TYPE = associate(Bug310435ValFactory.createBug310435Val_GroupElementType());

	public static final IGrammarAwareElementType Bug310435Val_NumberSignDigitTwoDigitOneKeyword_0_ELEMENT_TYPE = associate(Bug310435ValFactory.createBug310435Val_NumberSignDigitTwoDigitOneKeyword_0ElementType());

	public static final IGrammarAwareElementType Bug310435Val_Alternatives_1_ELEMENT_TYPE = associate(Bug310435ValFactory.createBug310435Val_Alternatives_1ElementType());

	public static final IGrammarAwareElementType Bug310435Val_Group_1_0_ELEMENT_TYPE = associate(Bug310435ValFactory.createBug310435Val_Group_1_0ElementType());

	public static final IGrammarAwareElementType Bug310435Val_Kw1Keyword_1_0_0_ELEMENT_TYPE = associate(Bug310435ValFactory.createBug310435Val_Kw1Keyword_1_0_0ElementType());

	public static final IGrammarAwareElementType Bug310435Val_LitsAssignment_1_0_1_ELEMENT_TYPE = associate(Bug310435ValFactory.createBug310435Val_LitsAssignment_1_0_1ElementType());

	public static final IGrammarAwareElementType Bug310435Val_LitsIDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE = associate(Bug310435ValFactory.createBug310435Val_LitsIDTerminalRuleCall_1_0_1_0ElementType());

	public static final IGrammarAwareElementType Bug310435Val_Group_1_1_ELEMENT_TYPE = associate(Bug310435ValFactory.createBug310435Val_Group_1_1ElementType());

	public static final IGrammarAwareElementType Bug310435Val_Kw2Keyword_1_1_0_ELEMENT_TYPE = associate(Bug310435ValFactory.createBug310435Val_Kw2Keyword_1_1_0ElementType());

	public static final IGrammarAwareElementType Bug310435Val_LitsAssignment_1_1_1_ELEMENT_TYPE = associate(Bug310435ValFactory.createBug310435Val_LitsAssignment_1_1_1ElementType());

	public static final IGrammarAwareElementType Bug310435Val_LitsSTRINGTerminalRuleCall_1_1_1_0_ELEMENT_TYPE = associate(Bug310435ValFactory.createBug310435Val_LitsSTRINGTerminalRuleCall_1_1_1_0ElementType());

	private static class EnumBug310435Lit1Factory {
		public static IGrammarAwareElementType createEnumBug310435Lit1ElementType() {
			return new IGrammarAwareElementType("EnumBug310435Lit1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBug310435Lit1Rule());
		}
		public static IGrammarAwareElementType createEnumBug310435Lit1_Lit1EnumLiteralDeclarationElementType() {
			return new IGrammarAwareElementType("EnumBug310435Lit1_Lit1EnumLiteralDeclaration_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBug310435Lit1Access().getLit1EnumLiteralDeclaration());
		}
		public static IGrammarAwareElementType createEnumBug310435Lit1_Lit1Lit1Keyword_0ElementType() {
			return new IGrammarAwareElementType("EnumBug310435Lit1_Lit1Lit1Keyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBug310435Lit1Access().getLit1Lit1Keyword_0());
		}
	}

	public static final IGrammarAwareElementType EnumBug310435Lit1_ELEMENT_TYPE = associate(EnumBug310435Lit1Factory.createEnumBug310435Lit1ElementType());

	public static final IGrammarAwareElementType EnumBug310435Lit1_Lit1EnumLiteralDeclaration_ELEMENT_TYPE = associate(EnumBug310435Lit1Factory.createEnumBug310435Lit1_Lit1EnumLiteralDeclarationElementType());

	public static final IGrammarAwareElementType EnumBug310435Lit1_Lit1Lit1Keyword_0_ELEMENT_TYPE = associate(EnumBug310435Lit1Factory.createEnumBug310435Lit1_Lit1Lit1Keyword_0ElementType());

	private static class EnumBug310435Lit2Factory {
		public static IGrammarAwareElementType createEnumBug310435Lit2ElementType() {
			return new IGrammarAwareElementType("EnumBug310435Lit2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBug310435Lit2Rule());
		}
		public static IGrammarAwareElementType createEnumBug310435Lit2_Lit2EnumLiteralDeclarationElementType() {
			return new IGrammarAwareElementType("EnumBug310435Lit2_Lit2EnumLiteralDeclaration_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBug310435Lit2Access().getLit2EnumLiteralDeclaration());
		}
		public static IGrammarAwareElementType createEnumBug310435Lit2_Lit2Lit2Keyword_0ElementType() {
			return new IGrammarAwareElementType("EnumBug310435Lit2_Lit2Lit2Keyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumBug310435Lit2Access().getLit2Lit2Keyword_0());
		}
	}

	public static final IGrammarAwareElementType EnumBug310435Lit2_ELEMENT_TYPE = associate(EnumBug310435Lit2Factory.createEnumBug310435Lit2ElementType());

	public static final IGrammarAwareElementType EnumBug310435Lit2_Lit2EnumLiteralDeclaration_ELEMENT_TYPE = associate(EnumBug310435Lit2Factory.createEnumBug310435Lit2_Lit2EnumLiteralDeclarationElementType());

	public static final IGrammarAwareElementType EnumBug310435Lit2_Lit2Lit2Keyword_0_ELEMENT_TYPE = associate(EnumBug310435Lit2Factory.createEnumBug310435Lit2_Lit2Lit2Keyword_0ElementType());

	private static class CrossRefNameTestFactory {
		public static IGrammarAwareElementType createCrossRefNameTestElementType() {
			return new IGrammarAwareElementType("CrossRefNameTest_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefNameTestRule());
		}
		public static IGrammarAwareElementType createCrossRefNameTest_GroupElementType() {
			return new IGrammarAwareElementType("CrossRefNameTest_Group_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefNameTestAccess().getGroup());
		}
		public static IGrammarAwareElementType createCrossRefNameTest_NumberSignDigitTwoDigitTwoKeyword_0ElementType() {
			return new IGrammarAwareElementType("CrossRefNameTest_NumberSignDigitTwoDigitTwoKeyword_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefNameTestAccess().getNumberSignDigitTwoDigitTwoKeyword_0());
		}
		public static IGrammarAwareElementType createCrossRefNameTest_NamedAssignment_1ElementType() {
			return new IGrammarAwareElementType("CrossRefNameTest_NamedAssignment_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefNameTestAccess().getNamedAssignment_1());
		}
		public static IGrammarAwareElementType createCrossRefNameTest_NamedCrossRefNamedParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("CrossRefNameTest_NamedCrossRefNamedParserRuleCall_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefNameTestAccess().getNamedCrossRefNamedParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createCrossRefNameTest_Kw1Keyword_2ElementType() {
			return new IGrammarAwareElementType("CrossRefNameTest_Kw1Keyword_2_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefNameTestAccess().getKw1Keyword_2());
		}
		public static IGrammarAwareElementType createCrossRefNameTest_Alternatives_3ElementType() {
			return new IGrammarAwareElementType("CrossRefNameTest_Alternatives_3_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefNameTestAccess().getAlternatives_3());
		}
		public static IGrammarAwareElementType createCrossRefNameTest_Group_3_0ElementType() {
			return new IGrammarAwareElementType("CrossRefNameTest_Group_3_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefNameTestAccess().getGroup_3_0());
		}
		public static IGrammarAwareElementType createCrossRefNameTest_Kw2Keyword_3_0_0ElementType() {
			return new IGrammarAwareElementType("CrossRefNameTest_Kw2Keyword_3_0_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefNameTestAccess().getKw2Keyword_3_0_0());
		}
		public static IGrammarAwareElementType createCrossRefNameTest_RefAssignment_3_0_1ElementType() {
			return new IGrammarAwareElementType("CrossRefNameTest_RefAssignment_3_0_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefNameTestAccess().getRefAssignment_3_0_1());
		}
		public static IGrammarAwareElementType createCrossRefNameTest_RefCrossRefNamedCrossReference_3_0_1_0ElementType() {
			return new IGrammarAwareElementType("CrossRefNameTest_RefCrossRefNamedCrossReference_3_0_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefNameTestAccess().getRefCrossRefNamedCrossReference_3_0_1_0());
		}
		public static IGrammarAwareElementType createCrossRefNameTest_RefCrossRefNamedID1TerminalRuleCall_3_0_1_0_1ElementType() {
			return new IGrammarAwareElementType("CrossRefNameTest_RefCrossRefNamedID1TerminalRuleCall_3_0_1_0_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefNameTestAccess().getRefCrossRefNamedID1TerminalRuleCall_3_0_1_0_1());
		}
		public static IGrammarAwareElementType createCrossRefNameTest_Group_3_1ElementType() {
			return new IGrammarAwareElementType("CrossRefNameTest_Group_3_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefNameTestAccess().getGroup_3_1());
		}
		public static IGrammarAwareElementType createCrossRefNameTest_Kw3Keyword_3_1_0ElementType() {
			return new IGrammarAwareElementType("CrossRefNameTest_Kw3Keyword_3_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefNameTestAccess().getKw3Keyword_3_1_0());
		}
		public static IGrammarAwareElementType createCrossRefNameTest_RefAssignment_3_1_1ElementType() {
			return new IGrammarAwareElementType("CrossRefNameTest_RefAssignment_3_1_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefNameTestAccess().getRefAssignment_3_1_1());
		}
		public static IGrammarAwareElementType createCrossRefNameTest_RefCrossRefNamedCrossReference_3_1_1_0ElementType() {
			return new IGrammarAwareElementType("CrossRefNameTest_RefCrossRefNamedCrossReference_3_1_1_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefNameTestAccess().getRefCrossRefNamedCrossReference_3_1_1_0());
		}
		public static IGrammarAwareElementType createCrossRefNameTest_RefCrossRefNamedID2TerminalRuleCall_3_1_1_0_1ElementType() {
			return new IGrammarAwareElementType("CrossRefNameTest_RefCrossRefNamedID2TerminalRuleCall_3_1_1_0_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefNameTestAccess().getRefCrossRefNamedID2TerminalRuleCall_3_1_1_0_1());
		}
	}

	public static final IGrammarAwareElementType CrossRefNameTest_ELEMENT_TYPE = associate(CrossRefNameTestFactory.createCrossRefNameTestElementType());

	public static final IGrammarAwareElementType CrossRefNameTest_Group_ELEMENT_TYPE = associate(CrossRefNameTestFactory.createCrossRefNameTest_GroupElementType());

	public static final IGrammarAwareElementType CrossRefNameTest_NumberSignDigitTwoDigitTwoKeyword_0_ELEMENT_TYPE = associate(CrossRefNameTestFactory.createCrossRefNameTest_NumberSignDigitTwoDigitTwoKeyword_0ElementType());

	public static final IGrammarAwareElementType CrossRefNameTest_NamedAssignment_1_ELEMENT_TYPE = associate(CrossRefNameTestFactory.createCrossRefNameTest_NamedAssignment_1ElementType());

	public static final IGrammarAwareElementType CrossRefNameTest_NamedCrossRefNamedParserRuleCall_1_0_ELEMENT_TYPE = associate(CrossRefNameTestFactory.createCrossRefNameTest_NamedCrossRefNamedParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType CrossRefNameTest_Kw1Keyword_2_ELEMENT_TYPE = associate(CrossRefNameTestFactory.createCrossRefNameTest_Kw1Keyword_2ElementType());

	public static final IGrammarAwareElementType CrossRefNameTest_Alternatives_3_ELEMENT_TYPE = associate(CrossRefNameTestFactory.createCrossRefNameTest_Alternatives_3ElementType());

	public static final IGrammarAwareElementType CrossRefNameTest_Group_3_0_ELEMENT_TYPE = associate(CrossRefNameTestFactory.createCrossRefNameTest_Group_3_0ElementType());

	public static final IGrammarAwareElementType CrossRefNameTest_Kw2Keyword_3_0_0_ELEMENT_TYPE = associate(CrossRefNameTestFactory.createCrossRefNameTest_Kw2Keyword_3_0_0ElementType());

	public static final IGrammarAwareElementType CrossRefNameTest_RefAssignment_3_0_1_ELEMENT_TYPE = associate(CrossRefNameTestFactory.createCrossRefNameTest_RefAssignment_3_0_1ElementType());

	public static final IGrammarAwareElementType CrossRefNameTest_RefCrossRefNamedCrossReference_3_0_1_0_ELEMENT_TYPE = associate(CrossRefNameTestFactory.createCrossRefNameTest_RefCrossRefNamedCrossReference_3_0_1_0ElementType());

	public static final IGrammarAwareElementType CrossRefNameTest_RefCrossRefNamedID1TerminalRuleCall_3_0_1_0_1_ELEMENT_TYPE = associate(CrossRefNameTestFactory.createCrossRefNameTest_RefCrossRefNamedID1TerminalRuleCall_3_0_1_0_1ElementType());

	public static final IGrammarAwareElementType CrossRefNameTest_Group_3_1_ELEMENT_TYPE = associate(CrossRefNameTestFactory.createCrossRefNameTest_Group_3_1ElementType());

	public static final IGrammarAwareElementType CrossRefNameTest_Kw3Keyword_3_1_0_ELEMENT_TYPE = associate(CrossRefNameTestFactory.createCrossRefNameTest_Kw3Keyword_3_1_0ElementType());

	public static final IGrammarAwareElementType CrossRefNameTest_RefAssignment_3_1_1_ELEMENT_TYPE = associate(CrossRefNameTestFactory.createCrossRefNameTest_RefAssignment_3_1_1ElementType());

	public static final IGrammarAwareElementType CrossRefNameTest_RefCrossRefNamedCrossReference_3_1_1_0_ELEMENT_TYPE = associate(CrossRefNameTestFactory.createCrossRefNameTest_RefCrossRefNamedCrossReference_3_1_1_0ElementType());

	public static final IGrammarAwareElementType CrossRefNameTest_RefCrossRefNamedID2TerminalRuleCall_3_1_1_0_1_ELEMENT_TYPE = associate(CrossRefNameTestFactory.createCrossRefNameTest_RefCrossRefNamedID2TerminalRuleCall_3_1_1_0_1ElementType());

	private static class CrossRefNamedFactory {
		public static IGrammarAwareElementType createCrossRefNamedElementType() {
			return new IGrammarAwareElementType("CrossRefNamed_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefNamedRule());
		}
		public static IGrammarAwareElementType createCrossRefNamed_NameAssignmentElementType() {
			return new IGrammarAwareElementType("CrossRefNamed_NameAssignment_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefNamedAccess().getNameAssignment());
		}
		public static IGrammarAwareElementType createCrossRefNamed_NameAlternatives_0ElementType() {
			return new IGrammarAwareElementType("CrossRefNamed_NameAlternatives_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefNamedAccess().getNameAlternatives_0());
		}
		public static IGrammarAwareElementType createCrossRefNamed_NameID1TerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("CrossRefNamed_NameID1TerminalRuleCall_0_0_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefNamedAccess().getNameID1TerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createCrossRefNamed_NameID2TerminalRuleCall_0_1ElementType() {
			return new IGrammarAwareElementType("CrossRefNamed_NameID2TerminalRuleCall_0_1_ELEMENT_TYPE", SimpleReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getCrossRefNamedAccess().getNameID2TerminalRuleCall_0_1());
		}
	}

	public static final IGrammarAwareElementType CrossRefNamed_ELEMENT_TYPE = associate(CrossRefNamedFactory.createCrossRefNamedElementType());

	public static final IGrammarAwareElementType CrossRefNamed_NameAssignment_ELEMENT_TYPE = associate(CrossRefNamedFactory.createCrossRefNamed_NameAssignmentElementType());

	public static final IGrammarAwareElementType CrossRefNamed_NameAlternatives_0_ELEMENT_TYPE = associate(CrossRefNamedFactory.createCrossRefNamed_NameAlternatives_0ElementType());

	public static final IGrammarAwareElementType CrossRefNamed_NameID1TerminalRuleCall_0_0_ELEMENT_TYPE = associate(CrossRefNamedFactory.createCrossRefNamed_NameID1TerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType CrossRefNamed_NameID2TerminalRuleCall_0_1_ELEMENT_TYPE = associate(CrossRefNamedFactory.createCrossRefNamed_NameID2TerminalRuleCall_0_1ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getOpElementType() {
		return Op_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOp_GroupElementType() {
		return Op_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOp_TermParserRuleCall_0ElementType() {
		return Op_TermParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOp_Group_1ElementType() {
		return Op_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOp_OpValuesAction_1_0ElementType() {
		return Op_OpValuesAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOp_ValuesAssignment_1_1ElementType() {
		return Op_ValuesAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOp_ValuesTermParserRuleCall_1_1_0ElementType() {
		return Op_ValuesTermParserRuleCall_1_1_0_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getTerm_TwoNumbersParserRuleCall_1ElementType() {
		return Term_TwoNumbersParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_ManyStringsParserRuleCall_2ElementType() {
		return Term_ManyStringsParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_TypeParserRuleCall_3ElementType() {
		return Term_TypeParserRuleCall_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_Ref2ParserRuleCall_4ElementType() {
		return Term_Ref2ParserRuleCall_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_SpareParserRuleCall_5ElementType() {
		return Term_SpareParserRuleCall_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_BooleanParserRuleCall_6ElementType() {
		return Term_BooleanParserRuleCall_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_Transient1ParserRuleCall_7ElementType() {
		return Term_Transient1ParserRuleCall_7_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_Consumed1ParserRuleCall_8ElementType() {
		return Term_Consumed1ParserRuleCall_8_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_Consumed2ParserRuleCall_9ElementType() {
		return Term_Consumed2ParserRuleCall_9_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_Loop1ParserRuleCall_10ElementType() {
		return Term_Loop1ParserRuleCall_10_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_Loop2ParserRuleCall_11ElementType() {
		return Term_Loop2ParserRuleCall_11_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_Loop3ParserRuleCall_12ElementType() {
		return Term_Loop3ParserRuleCall_12_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_Loop4ParserRuleCall_13ElementType() {
		return Term_Loop4ParserRuleCall_13_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_LoopBug285452ParserRuleCall_14ElementType() {
		return Term_LoopBug285452ParserRuleCall_14_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_DuplicateBug284491ParserRuleCall_15ElementType() {
		return Term_DuplicateBug284491ParserRuleCall_15_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_EmptyObjectBug284850ParserRuleCall_16ElementType() {
		return Term_EmptyObjectBug284850ParserRuleCall_16_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_MultiInheritanceBug280439ParserRuleCall_17ElementType() {
		return Term_MultiInheritanceBug280439ParserRuleCall_17_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_EObjectRefParserRuleCall_18ElementType() {
		return Term_EObjectRefParserRuleCall_18_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_TypeBug305577_1ParserRuleCall_19ElementType() {
		return Term_TypeBug305577_1ParserRuleCall_19_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_TypeBug305577_2ParserRuleCall_20ElementType() {
		return Term_TypeBug305577_2ParserRuleCall_20_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_ParensParserRuleCall_21ElementType() {
		return Term_ParensParserRuleCall_21_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_Bug305171ParserRuleCall_22ElementType() {
		return Term_Bug305171ParserRuleCall_22_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_Bug310435ValParserRuleCall_23ElementType() {
		return Term_Bug310435ValParserRuleCall_23_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_Bug310435EnumParserRuleCall_24ElementType() {
		return Term_Bug310435EnumParserRuleCall_24_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTerm_CrossRefNameTestParserRuleCall_25ElementType() {
		return Term_CrossRefNameTestParserRuleCall_25_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getParens_OpParserRuleCall_1ElementType() {
		return Parens_OpParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParens_RightParenthesisKeyword_2ElementType() {
		return Parens_RightParenthesisKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParens_EmAssignment_3ElementType() {
		return Parens_EmAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParens_EmExclamationMarkKeyword_3_0ElementType() {
		return Parens_EmExclamationMarkKeyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoNumbersElementType() {
		return TwoNumbers_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoNumbers_GroupElementType() {
		return TwoNumbers_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoNumbers_Num1Assignment_0ElementType() {
		return TwoNumbers_Num1Assignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoNumbers_Num1INTTerminalRuleCall_0_0ElementType() {
		return TwoNumbers_Num1INTTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoNumbers_Num2Assignment_1ElementType() {
		return TwoNumbers_Num2Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoNumbers_Num2INTTerminalRuleCall_1_0ElementType() {
		return TwoNumbers_Num2INTTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoNumbers_Group_2ElementType() {
		return TwoNumbers_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoNumbers_NumberSignKeyword_2_0ElementType() {
		return TwoNumbers_NumberSignKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoNumbers_Num3Assignment_2_1ElementType() {
		return TwoNumbers_Num3Assignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTwoNumbers_Num3INTTerminalRuleCall_2_1_0ElementType() {
		return TwoNumbers_Num3INTTerminalRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getManyStringsElementType() {
		return ManyStrings_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getManyStrings_GroupElementType() {
		return ManyStrings_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getManyStrings_EqualsSignKeyword_0ElementType() {
		return ManyStrings_EqualsSignKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getManyStrings_Str1Assignment_1ElementType() {
		return ManyStrings_Str1Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getManyStrings_Str1STRINGTerminalRuleCall_1_0ElementType() {
		return ManyStrings_Str1STRINGTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getManyStrings_Str2Assignment_2ElementType() {
		return ManyStrings_Str2Assignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getManyStrings_Str2STRINGTerminalRuleCall_2_0ElementType() {
		return ManyStrings_Str2STRINGTerminalRuleCall_2_0_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getRef2ElementType() {
		return Ref2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRef2_GroupElementType() {
		return Ref2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRef2_NumberSignDigitTwoKeyword_0ElementType() {
		return Ref2_NumberSignDigitTwoKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRef2_Ref2Assignment_1ElementType() {
		return Ref2_Ref2Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRef2_Ref2Alternatives_1_0ElementType() {
		return Ref2_Ref2Alternatives_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRef2_Ref2Mykeyword1Keyword_1_0_0ElementType() {
		return Ref2_Ref2Mykeyword1Keyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRef2_Ref2STRINGTerminalRuleCall_1_0_1ElementType() {
		return Ref2_Ref2STRINGTerminalRuleCall_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRef2_Ref2Mykeyword2Keyword_1_0_2ElementType() {
		return Ref2_Ref2Mykeyword2Keyword_1_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpareElementType() {
		return Spare_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpare_GroupElementType() {
		return Spare_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpare_NumberSignDigitThreeKeyword_0ElementType() {
		return Spare_NumberSignDigitThreeKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpare_IdAssignment_1ElementType() {
		return Spare_IdAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpare_IdIDTerminalRuleCall_1_0ElementType() {
		return Spare_IdIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpare_Group_2ElementType() {
		return Spare_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpare_FullStopKeyword_2_0ElementType() {
		return Spare_FullStopKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpare_IdAssignment_2_1ElementType() {
		return Spare_IdAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpare_IdIDTerminalRuleCall_2_1_0ElementType() {
		return Spare_IdIDTerminalRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBooleanElementType() {
		return Boolean_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBoolean_GroupElementType() {
		return Boolean_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBoolean_NumberSignDigitFourKeyword_0ElementType() {
		return Boolean_NumberSignDigitFourKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBoolean_BoolAssignment_1ElementType() {
		return Boolean_BoolAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBoolean_BoolMyoptionKeyword_1_0ElementType() {
		return Boolean_BoolMyoptionKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBoolean_KwKeyword_2ElementType() {
		return Boolean_KwKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBoolean_ValueAssignment_3ElementType() {
		return Boolean_ValueAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBoolean_ValueIDTerminalRuleCall_3_0ElementType() {
		return Boolean_ValueIDTerminalRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransient1ElementType() {
		return Transient1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransient1_GroupElementType() {
		return Transient1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransient1_NumberSignDigitFiveKeyword_0ElementType() {
		return Transient1_NumberSignDigitFiveKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransient1_Alternatives_1ElementType() {
		return Transient1_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransient1_PrecStarAssignment_1_0ElementType() {
		return Transient1_PrecStarAssignment_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransient1_PrecStarAsteriskKeyword_1_0_0ElementType() {
		return Transient1_PrecStarAsteriskKeyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransient1_PrecAssignment_1_1ElementType() {
		return Transient1_PrecAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransient1_PrecINTTerminalRuleCall_1_1_0ElementType() {
		return Transient1_PrecINTTerminalRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransient1_Group_2ElementType() {
		return Transient1_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransient1_CommaKeyword_2_0ElementType() {
		return Transient1_CommaKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransient1_Alternatives_2_1ElementType() {
		return Transient1_Alternatives_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransient1_ScaleStarAssignment_2_1_0ElementType() {
		return Transient1_ScaleStarAssignment_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransient1_ScaleStarAsteriskKeyword_2_1_0_0ElementType() {
		return Transient1_ScaleStarAsteriskKeyword_2_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransient1_ScaleAssignment_2_1_1ElementType() {
		return Transient1_ScaleAssignment_2_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTransient1_ScaleINTTerminalRuleCall_2_1_1_0ElementType() {
		return Transient1_ScaleINTTerminalRuleCall_2_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConsumed1ElementType() {
		return Consumed1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConsumed1_GroupElementType() {
		return Consumed1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConsumed1_NumberSignDigitSixKeyword_0ElementType() {
		return Consumed1_NumberSignDigitSixKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConsumed1_Alternatives_1ElementType() {
		return Consumed1_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConsumed1_Group_1_0ElementType() {
		return Consumed1_Group_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConsumed1_V1Keyword_1_0_0ElementType() {
		return Consumed1_V1Keyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConsumed1_V1Assignment_1_0_1ElementType() {
		return Consumed1_V1Assignment_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConsumed1_V1INTTerminalRuleCall_1_0_1_0ElementType() {
		return Consumed1_V1INTTerminalRuleCall_1_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConsumed1_V2Assignment_1_0_2ElementType() {
		return Consumed1_V2Assignment_1_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConsumed1_V2IDTerminalRuleCall_1_0_2_0ElementType() {
		return Consumed1_V2IDTerminalRuleCall_1_0_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConsumed1_Group_1_1ElementType() {
		return Consumed1_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConsumed1_V2Keyword_1_1_0ElementType() {
		return Consumed1_V2Keyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConsumed1_V2Assignment_1_1_1ElementType() {
		return Consumed1_V2Assignment_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConsumed1_V2IDTerminalRuleCall_1_1_1_0ElementType() {
		return Consumed1_V2IDTerminalRuleCall_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConsumed1_V1Assignment_1_1_2ElementType() {
		return Consumed1_V1Assignment_1_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConsumed1_V1INTTerminalRuleCall_1_1_2_0ElementType() {
		return Consumed1_V1INTTerminalRuleCall_1_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConsumed2ElementType() {
		return Consumed2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConsumed2_GroupElementType() {
		return Consumed2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConsumed2_NumberSignDigitSevenKeyword_0ElementType() {
		return Consumed2_NumberSignDigitSevenKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConsumed2_ChildAssignment_1ElementType() {
		return Consumed2_ChildAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConsumed2_ChildConsumed1ParserRuleCall_1_0ElementType() {
		return Consumed2_ChildConsumed1ParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop1ElementType() {
		return Loop1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop1_GroupElementType() {
		return Loop1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop1_Kw0Keyword_0ElementType() {
		return Loop1_Kw0Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop1_NumberSignDigitEightKeyword_1ElementType() {
		return Loop1_NumberSignDigitEightKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop1_IdAssignment_2ElementType() {
		return Loop1_IdAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop1_IdIDTerminalRuleCall_2_0ElementType() {
		return Loop1_IdIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop1_Kw1Keyword_3ElementType() {
		return Loop1_Kw1Keyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop1_IdAssignment_4ElementType() {
		return Loop1_IdAssignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop1_IdIDTerminalRuleCall_4_0ElementType() {
		return Loop1_IdIDTerminalRuleCall_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop1_Group_5ElementType() {
		return Loop1_Group_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop1_Kw2Keyword_5_0ElementType() {
		return Loop1_Kw2Keyword_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop1_Kw30Keyword_5_1ElementType() {
		return Loop1_Kw30Keyword_5_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop2ElementType() {
		return Loop2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop2_GroupElementType() {
		return Loop2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop2_NumberSignDigitNineKeyword_0ElementType() {
		return Loop2_NumberSignDigitNineKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop2_IdAssignment_1ElementType() {
		return Loop2_IdAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop2_IdIDTerminalRuleCall_1_0ElementType() {
		return Loop2_IdIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop2_Alternatives_2ElementType() {
		return Loop2_Alternatives_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop2_Kw1Keyword_2_0ElementType() {
		return Loop2_Kw1Keyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop2_Group_2_1ElementType() {
		return Loop2_Group_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop2_IdAssignment_2_1_0ElementType() {
		return Loop2_IdAssignment_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop2_IdIDTerminalRuleCall_2_1_0_0ElementType() {
		return Loop2_IdIDTerminalRuleCall_2_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop2_Kw2Keyword_2_1_1ElementType() {
		return Loop2_Kw2Keyword_2_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop2_Alternatives_3ElementType() {
		return Loop2_Alternatives_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop2_Kw3Keyword_3_0ElementType() {
		return Loop2_Kw3Keyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop2_Group_3_1ElementType() {
		return Loop2_Group_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop2_IdAssignment_3_1_0ElementType() {
		return Loop2_IdAssignment_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop2_IdIDTerminalRuleCall_3_1_0_0ElementType() {
		return Loop2_IdIDTerminalRuleCall_3_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop2_Kw4Keyword_3_1_1ElementType() {
		return Loop2_Kw4Keyword_3_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop2_Alternatives_4ElementType() {
		return Loop2_Alternatives_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop2_Kw5Keyword_4_0ElementType() {
		return Loop2_Kw5Keyword_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop2_Kw6Keyword_4_1ElementType() {
		return Loop2_Kw6Keyword_4_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop3ElementType() {
		return Loop3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop3_GroupElementType() {
		return Loop3_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop3_Alternatives_0ElementType() {
		return Loop3_Alternatives_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop3_Kw1Keyword_0_0ElementType() {
		return Loop3_Kw1Keyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop3_Kw2Keyword_0_1ElementType() {
		return Loop3_Kw2Keyword_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop3_Kw3Keyword_0_2ElementType() {
		return Loop3_Kw3Keyword_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop3_NumberSignDigitOneDigitZeroKeyword_1ElementType() {
		return Loop3_NumberSignDigitOneDigitZeroKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop3_IdAssignment_2ElementType() {
		return Loop3_IdAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop3_IdIDTerminalRuleCall_2_0ElementType() {
		return Loop3_IdIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop3_Group_3ElementType() {
		return Loop3_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop3_Kw4Keyword_3_0ElementType() {
		return Loop3_Kw4Keyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop3_IdAssignment_3_1ElementType() {
		return Loop3_IdAssignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop3_IdIDTerminalRuleCall_3_1_0ElementType() {
		return Loop3_IdIDTerminalRuleCall_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop3_Kw5Keyword_3_2ElementType() {
		return Loop3_Kw5Keyword_3_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop4ElementType() {
		return Loop4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop4_GroupElementType() {
		return Loop4_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop4_NumberSignDigitOneDigitOneKeyword_0ElementType() {
		return Loop4_NumberSignDigitOneDigitOneKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop4_Alternatives_1ElementType() {
		return Loop4_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop4_Kw1Keyword_1_0ElementType() {
		return Loop4_Kw1Keyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop4_Kw2Keyword_1_1ElementType() {
		return Loop4_Kw2Keyword_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop4_Group_1_2ElementType() {
		return Loop4_Group_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop4_Kw3Keyword_1_2_0ElementType() {
		return Loop4_Kw3Keyword_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop4_Kw4Keyword_1_2_1ElementType() {
		return Loop4_Kw4Keyword_1_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop4_IdAssignment_2ElementType() {
		return Loop4_IdAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop4_IdIDTerminalRuleCall_2_0ElementType() {
		return Loop4_IdIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop4_Group_3ElementType() {
		return Loop4_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop4_Kw5Keyword_3_0ElementType() {
		return Loop4_Kw5Keyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop4_Group_3_1ElementType() {
		return Loop4_Group_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop4_Kw6Keyword_3_1_0ElementType() {
		return Loop4_Kw6Keyword_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoop4_Kw7Keyword_3_1_1ElementType() {
		return Loop4_Kw7Keyword_3_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoopBug285452ElementType() {
		return LoopBug285452_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoopBug285452_GroupElementType() {
		return LoopBug285452_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoopBug285452_NumberSignDigitOneDigitTwoKeyword_0ElementType() {
		return LoopBug285452_NumberSignDigitOneDigitTwoKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoopBug285452_Alternatives_1ElementType() {
		return LoopBug285452_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoopBug285452_InterfaceAssignment_1_0ElementType() {
		return LoopBug285452_InterfaceAssignment_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoopBug285452_InterfaceInterfaceKeyword_1_0_0ElementType() {
		return LoopBug285452_InterfaceInterfaceKeyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoopBug285452_ClassKeyword_1_1ElementType() {
		return LoopBug285452_ClassKeyword_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoopBug285452_NameAssignment_2ElementType() {
		return LoopBug285452_NameAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getLoopBug285452_NameIDTerminalRuleCall_2_0ElementType() {
		return LoopBug285452_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDuplicateBug284491ElementType() {
		return DuplicateBug284491_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDuplicateBug284491_GroupElementType() {
		return DuplicateBug284491_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDuplicateBug284491_NumberSignDigitOneDigitThreeKeyword_0ElementType() {
		return DuplicateBug284491_NumberSignDigitOneDigitThreeKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDuplicateBug284491_Alternatives_1ElementType() {
		return DuplicateBug284491_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDuplicateBug284491_StaticAssignment_1_0ElementType() {
		return DuplicateBug284491_StaticAssignment_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDuplicateBug284491_StaticStaticKeyword_1_0_0ElementType() {
		return DuplicateBug284491_StaticStaticKeyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDuplicateBug284491_FinalAssignment_1_1ElementType() {
		return DuplicateBug284491_FinalAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDuplicateBug284491_FinalFinalKeyword_1_1_0ElementType() {
		return DuplicateBug284491_FinalFinalKeyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDuplicateBug284491_TransientAssignment_1_2ElementType() {
		return DuplicateBug284491_TransientAssignment_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDuplicateBug284491_TransientTransientKeyword_1_2_0ElementType() {
		return DuplicateBug284491_TransientTransientKeyword_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEmptyObjectBug284850ElementType() {
		return EmptyObjectBug284850_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEmptyObjectBug284850_GroupElementType() {
		return EmptyObjectBug284850_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEmptyObjectBug284850_NumberSignDigitOneDigitFourKeyword_0ElementType() {
		return EmptyObjectBug284850_NumberSignDigitOneDigitFourKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEmptyObjectBug284850_ItemsAssignment_1ElementType() {
		return EmptyObjectBug284850_ItemsAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEmptyObjectBug284850_ItemsEmptyObjectItemsParserRuleCall_1_0ElementType() {
		return EmptyObjectBug284850_ItemsEmptyObjectItemsParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEmptyObjectItemsElementType() {
		return EmptyObjectItems_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEmptyObjectItems_ListAssignmentElementType() {
		return EmptyObjectItems_ListAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEmptyObjectItems_ListEmptyObjectItemParserRuleCall_0ElementType() {
		return EmptyObjectItems_ListEmptyObjectItemParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEmptyObjectItemElementType() {
		return EmptyObjectItem_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEmptyObjectItem_GroupElementType() {
		return EmptyObjectItem_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEmptyObjectItem_ItemKeyword_0ElementType() {
		return EmptyObjectItem_ItemKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEmptyObjectItem_NameAssignment_1ElementType() {
		return EmptyObjectItem_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEmptyObjectItem_NameIDTerminalRuleCall_1_0ElementType() {
		return EmptyObjectItem_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiInheritanceBug280439ElementType() {
		return MultiInheritanceBug280439_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiInheritanceBug280439_GroupElementType() {
		return MultiInheritanceBug280439_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiInheritanceBug280439_NumberSignDigitOneDigitFiveKeyword_0ElementType() {
		return MultiInheritanceBug280439_NumberSignDigitOneDigitFiveKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiInheritanceBug280439_ValAssignment_1ElementType() {
		return MultiInheritanceBug280439_ValAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMultiInheritanceBug280439_ValConcreteMultiParserRuleCall_1_0ElementType() {
		return MultiInheritanceBug280439_ValConcreteMultiParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractMulti1ElementType() {
		return AbstractMulti1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractMulti1_AlternativesElementType() {
		return AbstractMulti1_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractMulti1_ConcreteMultiParserRuleCall_0ElementType() {
		return AbstractMulti1_ConcreteMultiParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractMulti1_M1Assignment_1ElementType() {
		return AbstractMulti1_M1Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractMulti1_M1IDTerminalRuleCall_1_0ElementType() {
		return AbstractMulti1_M1IDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractMulti2ElementType() {
		return AbstractMulti2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractMulti2_AlternativesElementType() {
		return AbstractMulti2_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractMulti2_ConcreteMultiParserRuleCall_0ElementType() {
		return AbstractMulti2_ConcreteMultiParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractMulti2_M2Assignment_1ElementType() {
		return AbstractMulti2_M2Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractMulti2_M2IDTerminalRuleCall_1_0ElementType() {
		return AbstractMulti2_M2IDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConcreteMultiElementType() {
		return ConcreteMulti_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConcreteMulti_GroupElementType() {
		return ConcreteMulti_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConcreteMulti_M1Assignment_0ElementType() {
		return ConcreteMulti_M1Assignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConcreteMulti_M1IDTerminalRuleCall_0_0ElementType() {
		return ConcreteMulti_M1IDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConcreteMulti_M2Assignment_1ElementType() {
		return ConcreteMulti_M2Assignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getConcreteMulti_M2IDTerminalRuleCall_1_0ElementType() {
		return ConcreteMulti_M2IDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEObjectRefElementType() {
		return EObjectRef_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEObjectRef_GroupElementType() {
		return EObjectRef_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEObjectRef_NumberSignDigitOneDigitSixKeyword_0ElementType() {
		return EObjectRef_NumberSignDigitOneDigitSixKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEObjectRef_ObjAssignment_1ElementType() {
		return EObjectRef_ObjAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEObjectRef_ObjEObjectElementParserRuleCall_1_0ElementType() {
		return EObjectRef_ObjEObjectElementParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEObjectRef_RefsKeyword_2ElementType() {
		return EObjectRef_RefsKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEObjectRef_RefAssignment_3ElementType() {
		return EObjectRef_RefAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEObjectRef_RefEObjectCrossReference_3_0ElementType() {
		return EObjectRef_RefEObjectCrossReference_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEObjectRef_RefEObjectIDTerminalRuleCall_3_0_1ElementType() {
		return EObjectRef_RefEObjectIDTerminalRuleCall_3_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEObjectElementElementType() {
		return EObjectElement_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEObjectElement_NameAssignmentElementType() {
		return EObjectElement_NameAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEObjectElement_NameIDTerminalRuleCall_0ElementType() {
		return EObjectElement_NameIDTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug305577_1ElementType() {
		return TypeBug305577_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug305577_1_GroupElementType() {
		return TypeBug305577_1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug305577_1_NumberSignDigitOneDigitSevenKeyword_0ElementType() {
		return TypeBug305577_1_NumberSignDigitOneDigitSevenKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug305577_1_Alternatives_1ElementType() {
		return TypeBug305577_1_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug305577_1_TypeBug1AParserRuleCall_1_0ElementType() {
		return TypeBug305577_1_TypeBug1AParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug305577_1_TypeBug1BParserRuleCall_1_1ElementType() {
		return TypeBug305577_1_TypeBug1BParserRuleCall_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug305577_2ElementType() {
		return TypeBug305577_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug305577_2_GroupElementType() {
		return TypeBug305577_2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug305577_2_NumberSignDigitOneDigitEightKeyword_0ElementType() {
		return TypeBug305577_2_NumberSignDigitOneDigitEightKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug305577_2_Alternatives_1ElementType() {
		return TypeBug305577_2_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug305577_2_TypeBug2BParserRuleCall_1_0ElementType() {
		return TypeBug305577_2_TypeBug2BParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug305577_2_TypeBug2AParserRuleCall_1_1ElementType() {
		return TypeBug305577_2_TypeBug2AParserRuleCall_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug1AInhElementType() {
		return TypeBug1AInh_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug1AInh_TypeBug1BParserRuleCallElementType() {
		return TypeBug1AInh_TypeBug1BParserRuleCall_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug1AElementType() {
		return TypeBug1A_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug1A_GroupElementType() {
		return TypeBug1A_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug1A_TypeBug1AAction_0ElementType() {
		return TypeBug1A_TypeBug1AAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug1A_KaKeyword_1ElementType() {
		return TypeBug1A_KaKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug1A_NameAssignment_2ElementType() {
		return TypeBug1A_NameAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug1A_NameIDTerminalRuleCall_2_0ElementType() {
		return TypeBug1A_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug1BElementType() {
		return TypeBug1B_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug1B_GroupElementType() {
		return TypeBug1B_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug1B_TypeBug1BAction_0ElementType() {
		return TypeBug1B_TypeBug1BAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug1B_KbKeyword_1ElementType() {
		return TypeBug1B_KbKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug1B_NameAssignment_2ElementType() {
		return TypeBug1B_NameAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug1B_NameIDTerminalRuleCall_2_0ElementType() {
		return TypeBug1B_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug2AInhElementType() {
		return TypeBug2AInh_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug2AInh_TypeBug2BParserRuleCallElementType() {
		return TypeBug2AInh_TypeBug2BParserRuleCall_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug2AElementType() {
		return TypeBug2A_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug2A_GroupElementType() {
		return TypeBug2A_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug2A_TypeBug2AAction_0ElementType() {
		return TypeBug2A_TypeBug2AAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug2A_KaKeyword_1ElementType() {
		return TypeBug2A_KaKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug2A_NameAssignment_2ElementType() {
		return TypeBug2A_NameAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug2A_NameIDTerminalRuleCall_2_0ElementType() {
		return TypeBug2A_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug2BElementType() {
		return TypeBug2B_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug2B_GroupElementType() {
		return TypeBug2B_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug2B_TypeBug2BAction_0ElementType() {
		return TypeBug2B_TypeBug2BAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug2B_KbKeyword_1ElementType() {
		return TypeBug2B_KbKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug2B_NameAssignment_2ElementType() {
		return TypeBug2B_NameAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeBug2B_NameIDTerminalRuleCall_2_0ElementType() {
		return TypeBug2B_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171ElementType() {
		return Bug305171_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_GroupElementType() {
		return Bug305171_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_NumberSignDigitOneDigitNineKeyword_0ElementType() {
		return Bug305171_NumberSignDigitOneDigitNineKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_Group_1ElementType() {
		return Bug305171_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_Group_1_0ElementType() {
		return Bug305171_Group_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_KxKeyword_1_0_0ElementType() {
		return Bug305171_KxKeyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_XAssignment_1_0_1ElementType() {
		return Bug305171_XAssignment_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_XIDTerminalRuleCall_1_0_1_0ElementType() {
		return Bug305171_XIDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_Group_1_0_2ElementType() {
		return Bug305171_Group_1_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_CommaKeyword_1_0_2_0ElementType() {
		return Bug305171_CommaKeyword_1_0_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_XAssignment_1_0_2_1ElementType() {
		return Bug305171_XAssignment_1_0_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_XIDTerminalRuleCall_1_0_2_1_0ElementType() {
		return Bug305171_XIDTerminalRuleCall_1_0_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_Group_1_1ElementType() {
		return Bug305171_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_Group_1_1_0ElementType() {
		return Bug305171_Group_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_KyKeyword_1_1_0_0ElementType() {
		return Bug305171_KyKeyword_1_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_YAssignment_1_1_0_1ElementType() {
		return Bug305171_YAssignment_1_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_YIDTerminalRuleCall_1_1_0_1_0ElementType() {
		return Bug305171_YIDTerminalRuleCall_1_1_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_Group_1_1_0_2ElementType() {
		return Bug305171_Group_1_1_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_CommaKeyword_1_1_0_2_0ElementType() {
		return Bug305171_CommaKeyword_1_1_0_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_YAssignment_1_1_0_2_1ElementType() {
		return Bug305171_YAssignment_1_1_0_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_YIDTerminalRuleCall_1_1_0_2_1_0ElementType() {
		return Bug305171_YIDTerminalRuleCall_1_1_0_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_Group_1_1_1ElementType() {
		return Bug305171_Group_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_KzKeyword_1_1_1_0ElementType() {
		return Bug305171_KzKeyword_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_ZAssignment_1_1_1_1ElementType() {
		return Bug305171_ZAssignment_1_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_ZIDTerminalRuleCall_1_1_1_1_0ElementType() {
		return Bug305171_ZIDTerminalRuleCall_1_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_Group_1_1_1_2ElementType() {
		return Bug305171_Group_1_1_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_CommaKeyword_1_1_1_2_0ElementType() {
		return Bug305171_CommaKeyword_1_1_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_ZAssignment_1_1_1_2_1ElementType() {
		return Bug305171_ZAssignment_1_1_1_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_ZIDTerminalRuleCall_1_1_1_2_1_0ElementType() {
		return Bug305171_ZIDTerminalRuleCall_1_1_1_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_NameAssignment_2ElementType() {
		return Bug305171_NameAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug305171_NameIDTerminalRuleCall_2_0ElementType() {
		return Bug305171_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug310435EnumElementType() {
		return Bug310435Enum_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug310435Enum_GroupElementType() {
		return Bug310435Enum_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug310435Enum_NumberSignDigitTwoDigitZeroKeyword_0ElementType() {
		return Bug310435Enum_NumberSignDigitTwoDigitZeroKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug310435Enum_Alternatives_1ElementType() {
		return Bug310435Enum_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug310435Enum_Group_1_0ElementType() {
		return Bug310435Enum_Group_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug310435Enum_Kw1Keyword_1_0_0ElementType() {
		return Bug310435Enum_Kw1Keyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug310435Enum_LitsAssignment_1_0_1ElementType() {
		return Bug310435Enum_LitsAssignment_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug310435Enum_LitsEnumBug310435Lit1EnumRuleCall_1_0_1_0ElementType() {
		return Bug310435Enum_LitsEnumBug310435Lit1EnumRuleCall_1_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug310435Enum_Group_1_1ElementType() {
		return Bug310435Enum_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug310435Enum_Kw2Keyword_1_1_0ElementType() {
		return Bug310435Enum_Kw2Keyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug310435Enum_LitsAssignment_1_1_1ElementType() {
		return Bug310435Enum_LitsAssignment_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug310435Enum_LitsEnumBug310435Lit2EnumRuleCall_1_1_1_0ElementType() {
		return Bug310435Enum_LitsEnumBug310435Lit2EnumRuleCall_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug310435ValElementType() {
		return Bug310435Val_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug310435Val_GroupElementType() {
		return Bug310435Val_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug310435Val_NumberSignDigitTwoDigitOneKeyword_0ElementType() {
		return Bug310435Val_NumberSignDigitTwoDigitOneKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug310435Val_Alternatives_1ElementType() {
		return Bug310435Val_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug310435Val_Group_1_0ElementType() {
		return Bug310435Val_Group_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug310435Val_Kw1Keyword_1_0_0ElementType() {
		return Bug310435Val_Kw1Keyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug310435Val_LitsAssignment_1_0_1ElementType() {
		return Bug310435Val_LitsAssignment_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug310435Val_LitsIDTerminalRuleCall_1_0_1_0ElementType() {
		return Bug310435Val_LitsIDTerminalRuleCall_1_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug310435Val_Group_1_1ElementType() {
		return Bug310435Val_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug310435Val_Kw2Keyword_1_1_0ElementType() {
		return Bug310435Val_Kw2Keyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug310435Val_LitsAssignment_1_1_1ElementType() {
		return Bug310435Val_LitsAssignment_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBug310435Val_LitsSTRINGTerminalRuleCall_1_1_1_0ElementType() {
		return Bug310435Val_LitsSTRINGTerminalRuleCall_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBug310435Lit1ElementType() {
		return EnumBug310435Lit1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBug310435Lit1_Lit1EnumLiteralDeclarationElementType() {
		return EnumBug310435Lit1_Lit1EnumLiteralDeclaration_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBug310435Lit1_Lit1Lit1Keyword_0ElementType() {
		return EnumBug310435Lit1_Lit1Lit1Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBug310435Lit2ElementType() {
		return EnumBug310435Lit2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBug310435Lit2_Lit2EnumLiteralDeclarationElementType() {
		return EnumBug310435Lit2_Lit2EnumLiteralDeclaration_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumBug310435Lit2_Lit2Lit2Keyword_0ElementType() {
		return EnumBug310435Lit2_Lit2Lit2Keyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRefNameTestElementType() {
		return CrossRefNameTest_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRefNameTest_GroupElementType() {
		return CrossRefNameTest_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRefNameTest_NumberSignDigitTwoDigitTwoKeyword_0ElementType() {
		return CrossRefNameTest_NumberSignDigitTwoDigitTwoKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRefNameTest_NamedAssignment_1ElementType() {
		return CrossRefNameTest_NamedAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRefNameTest_NamedCrossRefNamedParserRuleCall_1_0ElementType() {
		return CrossRefNameTest_NamedCrossRefNamedParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRefNameTest_Kw1Keyword_2ElementType() {
		return CrossRefNameTest_Kw1Keyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRefNameTest_Alternatives_3ElementType() {
		return CrossRefNameTest_Alternatives_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRefNameTest_Group_3_0ElementType() {
		return CrossRefNameTest_Group_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRefNameTest_Kw2Keyword_3_0_0ElementType() {
		return CrossRefNameTest_Kw2Keyword_3_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRefNameTest_RefAssignment_3_0_1ElementType() {
		return CrossRefNameTest_RefAssignment_3_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRefNameTest_RefCrossRefNamedCrossReference_3_0_1_0ElementType() {
		return CrossRefNameTest_RefCrossRefNamedCrossReference_3_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRefNameTest_RefCrossRefNamedID1TerminalRuleCall_3_0_1_0_1ElementType() {
		return CrossRefNameTest_RefCrossRefNamedID1TerminalRuleCall_3_0_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRefNameTest_Group_3_1ElementType() {
		return CrossRefNameTest_Group_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRefNameTest_Kw3Keyword_3_1_0ElementType() {
		return CrossRefNameTest_Kw3Keyword_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRefNameTest_RefAssignment_3_1_1ElementType() {
		return CrossRefNameTest_RefAssignment_3_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRefNameTest_RefCrossRefNamedCrossReference_3_1_1_0ElementType() {
		return CrossRefNameTest_RefCrossRefNamedCrossReference_3_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRefNameTest_RefCrossRefNamedID2TerminalRuleCall_3_1_1_0_1ElementType() {
		return CrossRefNameTest_RefCrossRefNamedID2TerminalRuleCall_3_1_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRefNamedElementType() {
		return CrossRefNamed_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRefNamed_NameAssignmentElementType() {
		return CrossRefNamed_NameAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRefNamed_NameAlternatives_0ElementType() {
		return CrossRefNamed_NameAlternatives_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRefNamed_NameID1TerminalRuleCall_0_0ElementType() {
		return CrossRefNamed_NameID1TerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getCrossRefNamed_NameID2TerminalRuleCall_0_1ElementType() {
		return CrossRefNamed_NameID2TerminalRuleCall_0_1_ELEMENT_TYPE;
	}

}
