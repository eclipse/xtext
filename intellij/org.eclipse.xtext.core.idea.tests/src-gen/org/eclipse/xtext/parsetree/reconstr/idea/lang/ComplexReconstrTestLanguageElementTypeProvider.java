package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.psi.impl.ComplexReconstrTestLanguageFileImpl;
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class ComplexReconstrTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<ComplexReconstrTestLanguageFileImpl>>(ComplexReconstrTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final ComplexReconstrTestLanguageGrammarAccess GRAMMAR_ACCESS = ComplexReconstrTestLanguageLanguage.INSTANCE.getInstance(ComplexReconstrTestLanguageGrammarAccess.class);

	private static class RootFactory {
		public static IGrammarAwareElementType createRootElementType() {
			return new IGrammarAwareElementType("Root_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootRule());
		}
		public static IGrammarAwareElementType createRoot_AlternativesElementType() {
			return new IGrammarAwareElementType("Root_Alternatives_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createRoot_OpParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Root_OpParserRuleCall_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getOpParserRuleCall_0());
		}
		public static IGrammarAwareElementType createRoot_TrickyGParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Root_TrickyGParserRuleCall_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getTrickyGParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType Root_ELEMENT_TYPE = associate(RootFactory.createRootElementType());

	public static final IGrammarAwareElementType Root_Alternatives_ELEMENT_TYPE = associate(RootFactory.createRoot_AlternativesElementType());

	public static final IGrammarAwareElementType Root_OpParserRuleCall_0_ELEMENT_TYPE = associate(RootFactory.createRoot_OpParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Root_TrickyGParserRuleCall_1_ELEMENT_TYPE = associate(RootFactory.createRoot_TrickyGParserRuleCall_1ElementType());

	private static class OpFactory {
		public static IGrammarAwareElementType createOpElementType() {
			return new IGrammarAwareElementType("Op_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOpRule());
		}
		public static IGrammarAwareElementType createOp_GroupElementType() {
			return new IGrammarAwareElementType("Op_Group_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOpAccess().getGroup());
		}
		public static IGrammarAwareElementType createOp_TermParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Op_TermParserRuleCall_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOpAccess().getTermParserRuleCall_0());
		}
		public static IGrammarAwareElementType createOp_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("Op_Alternatives_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOpAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createOp_Group_1_0ElementType() {
			return new IGrammarAwareElementType("Op_Group_1_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOpAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createOp_AddAddOperandsAction_1_0_0ElementType() {
			return new IGrammarAwareElementType("Op_AddAddOperandsAction_1_0_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOpAccess().getAddAddOperandsAction_1_0_0());
		}
		public static IGrammarAwareElementType createOp_PlusSignKeyword_1_0_1ElementType() {
			return new IGrammarAwareElementType("Op_PlusSignKeyword_1_0_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOpAccess().getPlusSignKeyword_1_0_1());
		}
		public static IGrammarAwareElementType createOp_AddOperandsAssignment_1_0_2ElementType() {
			return new IGrammarAwareElementType("Op_AddOperandsAssignment_1_0_2_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOpAccess().getAddOperandsAssignment_1_0_2());
		}
		public static IGrammarAwareElementType createOp_AddOperandsTermParserRuleCall_1_0_2_0ElementType() {
			return new IGrammarAwareElementType("Op_AddOperandsTermParserRuleCall_1_0_2_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOpAccess().getAddOperandsTermParserRuleCall_1_0_2_0());
		}
		public static IGrammarAwareElementType createOp_Group_1_1ElementType() {
			return new IGrammarAwareElementType("Op_Group_1_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOpAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createOp_MinusMinusOperandsAction_1_1_0ElementType() {
			return new IGrammarAwareElementType("Op_MinusMinusOperandsAction_1_1_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOpAccess().getMinusMinusOperandsAction_1_1_0());
		}
		public static IGrammarAwareElementType createOp_HyphenMinusKeyword_1_1_1ElementType() {
			return new IGrammarAwareElementType("Op_HyphenMinusKeyword_1_1_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOpAccess().getHyphenMinusKeyword_1_1_1());
		}
		public static IGrammarAwareElementType createOp_MinusOperandsAssignment_1_1_2ElementType() {
			return new IGrammarAwareElementType("Op_MinusOperandsAssignment_1_1_2_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOpAccess().getMinusOperandsAssignment_1_1_2());
		}
		public static IGrammarAwareElementType createOp_MinusOperandsTermParserRuleCall_1_1_2_0ElementType() {
			return new IGrammarAwareElementType("Op_MinusOperandsTermParserRuleCall_1_1_2_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOpAccess().getMinusOperandsTermParserRuleCall_1_1_2_0());
		}
	}

	public static final IGrammarAwareElementType Op_ELEMENT_TYPE = associate(OpFactory.createOpElementType());

	public static final IGrammarAwareElementType Op_Group_ELEMENT_TYPE = associate(OpFactory.createOp_GroupElementType());

	public static final IGrammarAwareElementType Op_TermParserRuleCall_0_ELEMENT_TYPE = associate(OpFactory.createOp_TermParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Op_Alternatives_1_ELEMENT_TYPE = associate(OpFactory.createOp_Alternatives_1ElementType());

	public static final IGrammarAwareElementType Op_Group_1_0_ELEMENT_TYPE = associate(OpFactory.createOp_Group_1_0ElementType());

	public static final IGrammarAwareElementType Op_AddAddOperandsAction_1_0_0_ELEMENT_TYPE = associate(OpFactory.createOp_AddAddOperandsAction_1_0_0ElementType());

	public static final IGrammarAwareElementType Op_PlusSignKeyword_1_0_1_ELEMENT_TYPE = associate(OpFactory.createOp_PlusSignKeyword_1_0_1ElementType());

	public static final IGrammarAwareElementType Op_AddOperandsAssignment_1_0_2_ELEMENT_TYPE = associate(OpFactory.createOp_AddOperandsAssignment_1_0_2ElementType());

	public static final IGrammarAwareElementType Op_AddOperandsTermParserRuleCall_1_0_2_0_ELEMENT_TYPE = associate(OpFactory.createOp_AddOperandsTermParserRuleCall_1_0_2_0ElementType());

	public static final IGrammarAwareElementType Op_Group_1_1_ELEMENT_TYPE = associate(OpFactory.createOp_Group_1_1ElementType());

	public static final IGrammarAwareElementType Op_MinusMinusOperandsAction_1_1_0_ELEMENT_TYPE = associate(OpFactory.createOp_MinusMinusOperandsAction_1_1_0ElementType());

	public static final IGrammarAwareElementType Op_HyphenMinusKeyword_1_1_1_ELEMENT_TYPE = associate(OpFactory.createOp_HyphenMinusKeyword_1_1_1ElementType());

	public static final IGrammarAwareElementType Op_MinusOperandsAssignment_1_1_2_ELEMENT_TYPE = associate(OpFactory.createOp_MinusOperandsAssignment_1_1_2ElementType());

	public static final IGrammarAwareElementType Op_MinusOperandsTermParserRuleCall_1_1_2_0_ELEMENT_TYPE = associate(OpFactory.createOp_MinusOperandsTermParserRuleCall_1_1_2_0ElementType());

	private static class TermFactory {
		public static IGrammarAwareElementType createTermElementType() {
			return new IGrammarAwareElementType("Term_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermRule());
		}
		public static IGrammarAwareElementType createTerm_AlternativesElementType() {
			return new IGrammarAwareElementType("Term_Alternatives_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createTerm_AtomParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Term_AtomParserRuleCall_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getAtomParserRuleCall_0());
		}
		public static IGrammarAwareElementType createTerm_ParensParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Term_ParensParserRuleCall_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTermAccess().getParensParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType Term_ELEMENT_TYPE = associate(TermFactory.createTermElementType());

	public static final IGrammarAwareElementType Term_Alternatives_ELEMENT_TYPE = associate(TermFactory.createTerm_AlternativesElementType());

	public static final IGrammarAwareElementType Term_AtomParserRuleCall_0_ELEMENT_TYPE = associate(TermFactory.createTerm_AtomParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Term_ParensParserRuleCall_1_ELEMENT_TYPE = associate(TermFactory.createTerm_ParensParserRuleCall_1ElementType());

	private static class AtomFactory {
		public static IGrammarAwareElementType createAtomElementType() {
			return new IGrammarAwareElementType("Atom_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAtomRule());
		}
		public static IGrammarAwareElementType createAtom_NameAssignmentElementType() {
			return new IGrammarAwareElementType("Atom_NameAssignment_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAtomAccess().getNameAssignment());
		}
		public static IGrammarAwareElementType createAtom_NameIDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Atom_NameIDTerminalRuleCall_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAtomAccess().getNameIDTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Atom_ELEMENT_TYPE = associate(AtomFactory.createAtomElementType());

	public static final IGrammarAwareElementType Atom_NameAssignment_ELEMENT_TYPE = associate(AtomFactory.createAtom_NameAssignmentElementType());

	public static final IGrammarAwareElementType Atom_NameIDTerminalRuleCall_0_ELEMENT_TYPE = associate(AtomFactory.createAtom_NameIDTerminalRuleCall_0ElementType());

	private static class ParensFactory {
		public static IGrammarAwareElementType createParensElementType() {
			return new IGrammarAwareElementType("Parens_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParensRule());
		}
		public static IGrammarAwareElementType createParens_GroupElementType() {
			return new IGrammarAwareElementType("Parens_Group_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParensAccess().getGroup());
		}
		public static IGrammarAwareElementType createParens_LeftParenthesisKeyword_0ElementType() {
			return new IGrammarAwareElementType("Parens_LeftParenthesisKeyword_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParensAccess().getLeftParenthesisKeyword_0());
		}
		public static IGrammarAwareElementType createParens_OpParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Parens_OpParserRuleCall_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParensAccess().getOpParserRuleCall_1());
		}
		public static IGrammarAwareElementType createParens_RightParenthesisKeyword_2ElementType() {
			return new IGrammarAwareElementType("Parens_RightParenthesisKeyword_2_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParensAccess().getRightParenthesisKeyword_2());
		}
		public static IGrammarAwareElementType createParens_EmAssignment_3ElementType() {
			return new IGrammarAwareElementType("Parens_EmAssignment_3_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParensAccess().getEmAssignment_3());
		}
		public static IGrammarAwareElementType createParens_EmExclamationMarkKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("Parens_EmExclamationMarkKeyword_3_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParensAccess().getEmExclamationMarkKeyword_3_0());
		}
	}

	public static final IGrammarAwareElementType Parens_ELEMENT_TYPE = associate(ParensFactory.createParensElementType());

	public static final IGrammarAwareElementType Parens_Group_ELEMENT_TYPE = associate(ParensFactory.createParens_GroupElementType());

	public static final IGrammarAwareElementType Parens_LeftParenthesisKeyword_0_ELEMENT_TYPE = associate(ParensFactory.createParens_LeftParenthesisKeyword_0ElementType());

	public static final IGrammarAwareElementType Parens_OpParserRuleCall_1_ELEMENT_TYPE = associate(ParensFactory.createParens_OpParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType Parens_RightParenthesisKeyword_2_ELEMENT_TYPE = associate(ParensFactory.createParens_RightParenthesisKeyword_2ElementType());

	public static final IGrammarAwareElementType Parens_EmAssignment_3_ELEMENT_TYPE = associate(ParensFactory.createParens_EmAssignment_3ElementType());

	public static final IGrammarAwareElementType Parens_EmExclamationMarkKeyword_3_0_ELEMENT_TYPE = associate(ParensFactory.createParens_EmExclamationMarkKeyword_3_0ElementType());

	private static class TrickyBFactory {
		public static IGrammarAwareElementType createTrickyBElementType() {
			return new IGrammarAwareElementType("TrickyB_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyBRule());
		}
		public static IGrammarAwareElementType createTrickyB_GroupElementType() {
			return new IGrammarAwareElementType("TrickyB_Group_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyBAccess().getGroup());
		}
		public static IGrammarAwareElementType createTrickyB_TBKeyword_0ElementType() {
			return new IGrammarAwareElementType("TrickyB_TBKeyword_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyBAccess().getTBKeyword_0());
		}
		public static IGrammarAwareElementType createTrickyB_Group_1ElementType() {
			return new IGrammarAwareElementType("TrickyB_Group_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyBAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createTrickyB_NameAssignment_1_0ElementType() {
			return new IGrammarAwareElementType("TrickyB_NameAssignment_1_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyBAccess().getNameAssignment_1_0());
		}
		public static IGrammarAwareElementType createTrickyB_NameIDTerminalRuleCall_1_0_0ElementType() {
			return new IGrammarAwareElementType("TrickyB_NameIDTerminalRuleCall_1_0_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyBAccess().getNameIDTerminalRuleCall_1_0_0());
		}
		public static IGrammarAwareElementType createTrickyB_TypeAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("TrickyB_TypeAssignment_1_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyBAccess().getTypeAssignment_1_1());
		}
		public static IGrammarAwareElementType createTrickyB_TypeINTTerminalRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("TrickyB_TypeINTTerminalRuleCall_1_1_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyBAccess().getTypeINTTerminalRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createTrickyB_TypeAssignment_2ElementType() {
			return new IGrammarAwareElementType("TrickyB_TypeAssignment_2_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyBAccess().getTypeAssignment_2());
		}
		public static IGrammarAwareElementType createTrickyB_TypeINTTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("TrickyB_TypeINTTerminalRuleCall_2_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyBAccess().getTypeINTTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType TrickyB_ELEMENT_TYPE = associate(TrickyBFactory.createTrickyBElementType());

	public static final IGrammarAwareElementType TrickyB_Group_ELEMENT_TYPE = associate(TrickyBFactory.createTrickyB_GroupElementType());

	public static final IGrammarAwareElementType TrickyB_TBKeyword_0_ELEMENT_TYPE = associate(TrickyBFactory.createTrickyB_TBKeyword_0ElementType());

	public static final IGrammarAwareElementType TrickyB_Group_1_ELEMENT_TYPE = associate(TrickyBFactory.createTrickyB_Group_1ElementType());

	public static final IGrammarAwareElementType TrickyB_NameAssignment_1_0_ELEMENT_TYPE = associate(TrickyBFactory.createTrickyB_NameAssignment_1_0ElementType());

	public static final IGrammarAwareElementType TrickyB_NameIDTerminalRuleCall_1_0_0_ELEMENT_TYPE = associate(TrickyBFactory.createTrickyB_NameIDTerminalRuleCall_1_0_0ElementType());

	public static final IGrammarAwareElementType TrickyB_TypeAssignment_1_1_ELEMENT_TYPE = associate(TrickyBFactory.createTrickyB_TypeAssignment_1_1ElementType());

	public static final IGrammarAwareElementType TrickyB_TypeINTTerminalRuleCall_1_1_0_ELEMENT_TYPE = associate(TrickyBFactory.createTrickyB_TypeINTTerminalRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType TrickyB_TypeAssignment_2_ELEMENT_TYPE = associate(TrickyBFactory.createTrickyB_TypeAssignment_2ElementType());

	public static final IGrammarAwareElementType TrickyB_TypeINTTerminalRuleCall_2_0_ELEMENT_TYPE = associate(TrickyBFactory.createTrickyB_TypeINTTerminalRuleCall_2_0ElementType());

	private static class TrickyCFactory {
		public static IGrammarAwareElementType createTrickyCElementType() {
			return new IGrammarAwareElementType("TrickyC_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyCRule());
		}
		public static IGrammarAwareElementType createTrickyC_GroupElementType() {
			return new IGrammarAwareElementType("TrickyC_Group_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyCAccess().getGroup());
		}
		public static IGrammarAwareElementType createTrickyC_TCKeyword_0ElementType() {
			return new IGrammarAwareElementType("TrickyC_TCKeyword_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyCAccess().getTCKeyword_0());
		}
		public static IGrammarAwareElementType createTrickyC_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("TrickyC_NameAssignment_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyCAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createTrickyC_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("TrickyC_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyCAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createTrickyC_Group_2ElementType() {
			return new IGrammarAwareElementType("TrickyC_Group_2_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyCAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createTrickyC_C1XAction_2_0ElementType() {
			return new IGrammarAwareElementType("TrickyC_C1XAction_2_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyCAccess().getC1XAction_2_0());
		}
		public static IGrammarAwareElementType createTrickyC_XKeyword_2_1ElementType() {
			return new IGrammarAwareElementType("TrickyC_XKeyword_2_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyCAccess().getXKeyword_2_1());
		}
		public static IGrammarAwareElementType createTrickyC_Group_3ElementType() {
			return new IGrammarAwareElementType("TrickyC_Group_3_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyCAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createTrickyC_C2YAction_3_0ElementType() {
			return new IGrammarAwareElementType("TrickyC_C2YAction_3_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyCAccess().getC2YAction_3_0());
		}
		public static IGrammarAwareElementType createTrickyC_YKeyword_3_1ElementType() {
			return new IGrammarAwareElementType("TrickyC_YKeyword_3_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyCAccess().getYKeyword_3_1());
		}
		public static IGrammarAwareElementType createTrickyC_Group_4ElementType() {
			return new IGrammarAwareElementType("TrickyC_Group_4_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyCAccess().getGroup_4());
		}
		public static IGrammarAwareElementType createTrickyC_C3ZAction_4_0ElementType() {
			return new IGrammarAwareElementType("TrickyC_C3ZAction_4_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyCAccess().getC3ZAction_4_0());
		}
		public static IGrammarAwareElementType createTrickyC_ZKeyword_4_1ElementType() {
			return new IGrammarAwareElementType("TrickyC_ZKeyword_4_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyCAccess().getZKeyword_4_1());
		}
	}

	public static final IGrammarAwareElementType TrickyC_ELEMENT_TYPE = associate(TrickyCFactory.createTrickyCElementType());

	public static final IGrammarAwareElementType TrickyC_Group_ELEMENT_TYPE = associate(TrickyCFactory.createTrickyC_GroupElementType());

	public static final IGrammarAwareElementType TrickyC_TCKeyword_0_ELEMENT_TYPE = associate(TrickyCFactory.createTrickyC_TCKeyword_0ElementType());

	public static final IGrammarAwareElementType TrickyC_NameAssignment_1_ELEMENT_TYPE = associate(TrickyCFactory.createTrickyC_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType TrickyC_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(TrickyCFactory.createTrickyC_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType TrickyC_Group_2_ELEMENT_TYPE = associate(TrickyCFactory.createTrickyC_Group_2ElementType());

	public static final IGrammarAwareElementType TrickyC_C1XAction_2_0_ELEMENT_TYPE = associate(TrickyCFactory.createTrickyC_C1XAction_2_0ElementType());

	public static final IGrammarAwareElementType TrickyC_XKeyword_2_1_ELEMENT_TYPE = associate(TrickyCFactory.createTrickyC_XKeyword_2_1ElementType());

	public static final IGrammarAwareElementType TrickyC_Group_3_ELEMENT_TYPE = associate(TrickyCFactory.createTrickyC_Group_3ElementType());

	public static final IGrammarAwareElementType TrickyC_C2YAction_3_0_ELEMENT_TYPE = associate(TrickyCFactory.createTrickyC_C2YAction_3_0ElementType());

	public static final IGrammarAwareElementType TrickyC_YKeyword_3_1_ELEMENT_TYPE = associate(TrickyCFactory.createTrickyC_YKeyword_3_1ElementType());

	public static final IGrammarAwareElementType TrickyC_Group_4_ELEMENT_TYPE = associate(TrickyCFactory.createTrickyC_Group_4ElementType());

	public static final IGrammarAwareElementType TrickyC_C3ZAction_4_0_ELEMENT_TYPE = associate(TrickyCFactory.createTrickyC_C3ZAction_4_0ElementType());

	public static final IGrammarAwareElementType TrickyC_ZKeyword_4_1_ELEMENT_TYPE = associate(TrickyCFactory.createTrickyC_ZKeyword_4_1ElementType());

	private static class TrickyDFactory {
		public static IGrammarAwareElementType createTrickyDElementType() {
			return new IGrammarAwareElementType("TrickyD_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyDRule());
		}
		public static IGrammarAwareElementType createTrickyD_GroupElementType() {
			return new IGrammarAwareElementType("TrickyD_Group_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyDAccess().getGroup());
		}
		public static IGrammarAwareElementType createTrickyD_TDKeyword_0ElementType() {
			return new IGrammarAwareElementType("TrickyD_TDKeyword_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyDAccess().getTDKeyword_0());
		}
		public static IGrammarAwareElementType createTrickyD_Group_1ElementType() {
			return new IGrammarAwareElementType("TrickyD_Group_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyDAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createTrickyD_NameAssignment_1_0ElementType() {
			return new IGrammarAwareElementType("TrickyD_NameAssignment_1_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyDAccess().getNameAssignment_1_0());
		}
		public static IGrammarAwareElementType createTrickyD_NameINTTerminalRuleCall_1_0_0ElementType() {
			return new IGrammarAwareElementType("TrickyD_NameINTTerminalRuleCall_1_0_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyDAccess().getNameINTTerminalRuleCall_1_0_0());
		}
		public static IGrammarAwareElementType createTrickyD_FooAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("TrickyD_FooAssignment_1_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyDAccess().getFooAssignment_1_1());
		}
		public static IGrammarAwareElementType createTrickyD_FooSTRINGTerminalRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("TrickyD_FooSTRINGTerminalRuleCall_1_1_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyDAccess().getFooSTRINGTerminalRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createTrickyD_TypeAssignment_1_2ElementType() {
			return new IGrammarAwareElementType("TrickyD_TypeAssignment_1_2_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyDAccess().getTypeAssignment_1_2());
		}
		public static IGrammarAwareElementType createTrickyD_TypeIDTerminalRuleCall_1_2_0ElementType() {
			return new IGrammarAwareElementType("TrickyD_TypeIDTerminalRuleCall_1_2_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyDAccess().getTypeIDTerminalRuleCall_1_2_0());
		}
		public static IGrammarAwareElementType createTrickyD_Group_2ElementType() {
			return new IGrammarAwareElementType("TrickyD_Group_2_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyDAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createTrickyD_NameAssignment_2_0ElementType() {
			return new IGrammarAwareElementType("TrickyD_NameAssignment_2_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyDAccess().getNameAssignment_2_0());
		}
		public static IGrammarAwareElementType createTrickyD_NameINTTerminalRuleCall_2_0_0ElementType() {
			return new IGrammarAwareElementType("TrickyD_NameINTTerminalRuleCall_2_0_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyDAccess().getNameINTTerminalRuleCall_2_0_0());
		}
		public static IGrammarAwareElementType createTrickyD_TypeAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("TrickyD_TypeAssignment_2_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyDAccess().getTypeAssignment_2_1());
		}
		public static IGrammarAwareElementType createTrickyD_TypeIDTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("TrickyD_TypeIDTerminalRuleCall_2_1_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyDAccess().getTypeIDTerminalRuleCall_2_1_0());
		}
		public static IGrammarAwareElementType createTrickyD_TypeAssignment_3ElementType() {
			return new IGrammarAwareElementType("TrickyD_TypeAssignment_3_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyDAccess().getTypeAssignment_3());
		}
		public static IGrammarAwareElementType createTrickyD_TypeIDTerminalRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("TrickyD_TypeIDTerminalRuleCall_3_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyDAccess().getTypeIDTerminalRuleCall_3_0());
		}
	}

	public static final IGrammarAwareElementType TrickyD_ELEMENT_TYPE = associate(TrickyDFactory.createTrickyDElementType());

	public static final IGrammarAwareElementType TrickyD_Group_ELEMENT_TYPE = associate(TrickyDFactory.createTrickyD_GroupElementType());

	public static final IGrammarAwareElementType TrickyD_TDKeyword_0_ELEMENT_TYPE = associate(TrickyDFactory.createTrickyD_TDKeyword_0ElementType());

	public static final IGrammarAwareElementType TrickyD_Group_1_ELEMENT_TYPE = associate(TrickyDFactory.createTrickyD_Group_1ElementType());

	public static final IGrammarAwareElementType TrickyD_NameAssignment_1_0_ELEMENT_TYPE = associate(TrickyDFactory.createTrickyD_NameAssignment_1_0ElementType());

	public static final IGrammarAwareElementType TrickyD_NameINTTerminalRuleCall_1_0_0_ELEMENT_TYPE = associate(TrickyDFactory.createTrickyD_NameINTTerminalRuleCall_1_0_0ElementType());

	public static final IGrammarAwareElementType TrickyD_FooAssignment_1_1_ELEMENT_TYPE = associate(TrickyDFactory.createTrickyD_FooAssignment_1_1ElementType());

	public static final IGrammarAwareElementType TrickyD_FooSTRINGTerminalRuleCall_1_1_0_ELEMENT_TYPE = associate(TrickyDFactory.createTrickyD_FooSTRINGTerminalRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType TrickyD_TypeAssignment_1_2_ELEMENT_TYPE = associate(TrickyDFactory.createTrickyD_TypeAssignment_1_2ElementType());

	public static final IGrammarAwareElementType TrickyD_TypeIDTerminalRuleCall_1_2_0_ELEMENT_TYPE = associate(TrickyDFactory.createTrickyD_TypeIDTerminalRuleCall_1_2_0ElementType());

	public static final IGrammarAwareElementType TrickyD_Group_2_ELEMENT_TYPE = associate(TrickyDFactory.createTrickyD_Group_2ElementType());

	public static final IGrammarAwareElementType TrickyD_NameAssignment_2_0_ELEMENT_TYPE = associate(TrickyDFactory.createTrickyD_NameAssignment_2_0ElementType());

	public static final IGrammarAwareElementType TrickyD_NameINTTerminalRuleCall_2_0_0_ELEMENT_TYPE = associate(TrickyDFactory.createTrickyD_NameINTTerminalRuleCall_2_0_0ElementType());

	public static final IGrammarAwareElementType TrickyD_TypeAssignment_2_1_ELEMENT_TYPE = associate(TrickyDFactory.createTrickyD_TypeAssignment_2_1ElementType());

	public static final IGrammarAwareElementType TrickyD_TypeIDTerminalRuleCall_2_1_0_ELEMENT_TYPE = associate(TrickyDFactory.createTrickyD_TypeIDTerminalRuleCall_2_1_0ElementType());

	public static final IGrammarAwareElementType TrickyD_TypeAssignment_3_ELEMENT_TYPE = associate(TrickyDFactory.createTrickyD_TypeAssignment_3ElementType());

	public static final IGrammarAwareElementType TrickyD_TypeIDTerminalRuleCall_3_0_ELEMENT_TYPE = associate(TrickyDFactory.createTrickyD_TypeIDTerminalRuleCall_3_0ElementType());

	private static class TrickyEFactory {
		public static IGrammarAwareElementType createTrickyEElementType() {
			return new IGrammarAwareElementType("TrickyE_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyERule());
		}
		public static IGrammarAwareElementType createTrickyE_GroupElementType() {
			return new IGrammarAwareElementType("TrickyE_Group_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyEAccess().getGroup());
		}
		public static IGrammarAwareElementType createTrickyE_TEKeyword_0ElementType() {
			return new IGrammarAwareElementType("TrickyE_TEKeyword_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyEAccess().getTEKeyword_0());
		}
		public static IGrammarAwareElementType createTrickyE_Group_1ElementType() {
			return new IGrammarAwareElementType("TrickyE_Group_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyEAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createTrickyE_NameAssignment_1_0ElementType() {
			return new IGrammarAwareElementType("TrickyE_NameAssignment_1_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyEAccess().getNameAssignment_1_0());
		}
		public static IGrammarAwareElementType createTrickyE_NameINTTerminalRuleCall_1_0_0ElementType() {
			return new IGrammarAwareElementType("TrickyE_NameINTTerminalRuleCall_1_0_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyEAccess().getNameINTTerminalRuleCall_1_0_0());
		}
		public static IGrammarAwareElementType createTrickyE_FooAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("TrickyE_FooAssignment_1_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyEAccess().getFooAssignment_1_1());
		}
		public static IGrammarAwareElementType createTrickyE_FooSTRINGTerminalRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("TrickyE_FooSTRINGTerminalRuleCall_1_1_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyEAccess().getFooSTRINGTerminalRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createTrickyE_TypeAssignment_1_2ElementType() {
			return new IGrammarAwareElementType("TrickyE_TypeAssignment_1_2_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyEAccess().getTypeAssignment_1_2());
		}
		public static IGrammarAwareElementType createTrickyE_TypeIDTerminalRuleCall_1_2_0ElementType() {
			return new IGrammarAwareElementType("TrickyE_TypeIDTerminalRuleCall_1_2_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyEAccess().getTypeIDTerminalRuleCall_1_2_0());
		}
		public static IGrammarAwareElementType createTrickyE_XKeyword_2ElementType() {
			return new IGrammarAwareElementType("TrickyE_XKeyword_2_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyEAccess().getXKeyword_2());
		}
		public static IGrammarAwareElementType createTrickyE_Group_3ElementType() {
			return new IGrammarAwareElementType("TrickyE_Group_3_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyEAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createTrickyE_NameAssignment_3_0ElementType() {
			return new IGrammarAwareElementType("TrickyE_NameAssignment_3_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyEAccess().getNameAssignment_3_0());
		}
		public static IGrammarAwareElementType createTrickyE_NameINTTerminalRuleCall_3_0_0ElementType() {
			return new IGrammarAwareElementType("TrickyE_NameINTTerminalRuleCall_3_0_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyEAccess().getNameINTTerminalRuleCall_3_0_0());
		}
		public static IGrammarAwareElementType createTrickyE_TypeAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("TrickyE_TypeAssignment_3_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyEAccess().getTypeAssignment_3_1());
		}
		public static IGrammarAwareElementType createTrickyE_TypeIDTerminalRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("TrickyE_TypeIDTerminalRuleCall_3_1_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyEAccess().getTypeIDTerminalRuleCall_3_1_0());
		}
	}

	public static final IGrammarAwareElementType TrickyE_ELEMENT_TYPE = associate(TrickyEFactory.createTrickyEElementType());

	public static final IGrammarAwareElementType TrickyE_Group_ELEMENT_TYPE = associate(TrickyEFactory.createTrickyE_GroupElementType());

	public static final IGrammarAwareElementType TrickyE_TEKeyword_0_ELEMENT_TYPE = associate(TrickyEFactory.createTrickyE_TEKeyword_0ElementType());

	public static final IGrammarAwareElementType TrickyE_Group_1_ELEMENT_TYPE = associate(TrickyEFactory.createTrickyE_Group_1ElementType());

	public static final IGrammarAwareElementType TrickyE_NameAssignment_1_0_ELEMENT_TYPE = associate(TrickyEFactory.createTrickyE_NameAssignment_1_0ElementType());

	public static final IGrammarAwareElementType TrickyE_NameINTTerminalRuleCall_1_0_0_ELEMENT_TYPE = associate(TrickyEFactory.createTrickyE_NameINTTerminalRuleCall_1_0_0ElementType());

	public static final IGrammarAwareElementType TrickyE_FooAssignment_1_1_ELEMENT_TYPE = associate(TrickyEFactory.createTrickyE_FooAssignment_1_1ElementType());

	public static final IGrammarAwareElementType TrickyE_FooSTRINGTerminalRuleCall_1_1_0_ELEMENT_TYPE = associate(TrickyEFactory.createTrickyE_FooSTRINGTerminalRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType TrickyE_TypeAssignment_1_2_ELEMENT_TYPE = associate(TrickyEFactory.createTrickyE_TypeAssignment_1_2ElementType());

	public static final IGrammarAwareElementType TrickyE_TypeIDTerminalRuleCall_1_2_0_ELEMENT_TYPE = associate(TrickyEFactory.createTrickyE_TypeIDTerminalRuleCall_1_2_0ElementType());

	public static final IGrammarAwareElementType TrickyE_XKeyword_2_ELEMENT_TYPE = associate(TrickyEFactory.createTrickyE_XKeyword_2ElementType());

	public static final IGrammarAwareElementType TrickyE_Group_3_ELEMENT_TYPE = associate(TrickyEFactory.createTrickyE_Group_3ElementType());

	public static final IGrammarAwareElementType TrickyE_NameAssignment_3_0_ELEMENT_TYPE = associate(TrickyEFactory.createTrickyE_NameAssignment_3_0ElementType());

	public static final IGrammarAwareElementType TrickyE_NameINTTerminalRuleCall_3_0_0_ELEMENT_TYPE = associate(TrickyEFactory.createTrickyE_NameINTTerminalRuleCall_3_0_0ElementType());

	public static final IGrammarAwareElementType TrickyE_TypeAssignment_3_1_ELEMENT_TYPE = associate(TrickyEFactory.createTrickyE_TypeAssignment_3_1ElementType());

	public static final IGrammarAwareElementType TrickyE_TypeIDTerminalRuleCall_3_1_0_ELEMENT_TYPE = associate(TrickyEFactory.createTrickyE_TypeIDTerminalRuleCall_3_1_0ElementType());

	private static class TrickyFFactory {
		public static IGrammarAwareElementType createTrickyFElementType() {
			return new IGrammarAwareElementType("TrickyF_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyFRule());
		}
		public static IGrammarAwareElementType createTrickyF_GroupElementType() {
			return new IGrammarAwareElementType("TrickyF_Group_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyFAccess().getGroup());
		}
		public static IGrammarAwareElementType createTrickyF_TFKeyword_0ElementType() {
			return new IGrammarAwareElementType("TrickyF_TFKeyword_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyFAccess().getTFKeyword_0());
		}
		public static IGrammarAwareElementType createTrickyF_Group_1ElementType() {
			return new IGrammarAwareElementType("TrickyF_Group_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyFAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createTrickyF_NameAssignment_1_0ElementType() {
			return new IGrammarAwareElementType("TrickyF_NameAssignment_1_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyFAccess().getNameAssignment_1_0());
		}
		public static IGrammarAwareElementType createTrickyF_NameIDTerminalRuleCall_1_0_0ElementType() {
			return new IGrammarAwareElementType("TrickyF_NameIDTerminalRuleCall_1_0_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyFAccess().getNameIDTerminalRuleCall_1_0_0());
		}
		public static IGrammarAwareElementType createTrickyF_TypeAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("TrickyF_TypeAssignment_1_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyFAccess().getTypeAssignment_1_1());
		}
		public static IGrammarAwareElementType createTrickyF_TypeINTTerminalRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("TrickyF_TypeINTTerminalRuleCall_1_1_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyFAccess().getTypeINTTerminalRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createTrickyF_Alternatives_2ElementType() {
			return new IGrammarAwareElementType("TrickyF_Alternatives_2_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyFAccess().getAlternatives_2());
		}
		public static IGrammarAwareElementType createTrickyF_NameAssignment_2_0ElementType() {
			return new IGrammarAwareElementType("TrickyF_NameAssignment_2_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyFAccess().getNameAssignment_2_0());
		}
		public static IGrammarAwareElementType createTrickyF_NameIDTerminalRuleCall_2_0_0ElementType() {
			return new IGrammarAwareElementType("TrickyF_NameIDTerminalRuleCall_2_0_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyFAccess().getNameIDTerminalRuleCall_2_0_0());
		}
		public static IGrammarAwareElementType createTrickyF_TypeAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("TrickyF_TypeAssignment_2_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyFAccess().getTypeAssignment_2_1());
		}
		public static IGrammarAwareElementType createTrickyF_TypeINTTerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("TrickyF_TypeINTTerminalRuleCall_2_1_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyFAccess().getTypeINTTerminalRuleCall_2_1_0());
		}
	}

	public static final IGrammarAwareElementType TrickyF_ELEMENT_TYPE = associate(TrickyFFactory.createTrickyFElementType());

	public static final IGrammarAwareElementType TrickyF_Group_ELEMENT_TYPE = associate(TrickyFFactory.createTrickyF_GroupElementType());

	public static final IGrammarAwareElementType TrickyF_TFKeyword_0_ELEMENT_TYPE = associate(TrickyFFactory.createTrickyF_TFKeyword_0ElementType());

	public static final IGrammarAwareElementType TrickyF_Group_1_ELEMENT_TYPE = associate(TrickyFFactory.createTrickyF_Group_1ElementType());

	public static final IGrammarAwareElementType TrickyF_NameAssignment_1_0_ELEMENT_TYPE = associate(TrickyFFactory.createTrickyF_NameAssignment_1_0ElementType());

	public static final IGrammarAwareElementType TrickyF_NameIDTerminalRuleCall_1_0_0_ELEMENT_TYPE = associate(TrickyFFactory.createTrickyF_NameIDTerminalRuleCall_1_0_0ElementType());

	public static final IGrammarAwareElementType TrickyF_TypeAssignment_1_1_ELEMENT_TYPE = associate(TrickyFFactory.createTrickyF_TypeAssignment_1_1ElementType());

	public static final IGrammarAwareElementType TrickyF_TypeINTTerminalRuleCall_1_1_0_ELEMENT_TYPE = associate(TrickyFFactory.createTrickyF_TypeINTTerminalRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType TrickyF_Alternatives_2_ELEMENT_TYPE = associate(TrickyFFactory.createTrickyF_Alternatives_2ElementType());

	public static final IGrammarAwareElementType TrickyF_NameAssignment_2_0_ELEMENT_TYPE = associate(TrickyFFactory.createTrickyF_NameAssignment_2_0ElementType());

	public static final IGrammarAwareElementType TrickyF_NameIDTerminalRuleCall_2_0_0_ELEMENT_TYPE = associate(TrickyFFactory.createTrickyF_NameIDTerminalRuleCall_2_0_0ElementType());

	public static final IGrammarAwareElementType TrickyF_TypeAssignment_2_1_ELEMENT_TYPE = associate(TrickyFFactory.createTrickyF_TypeAssignment_2_1ElementType());

	public static final IGrammarAwareElementType TrickyF_TypeINTTerminalRuleCall_2_1_0_ELEMENT_TYPE = associate(TrickyFFactory.createTrickyF_TypeINTTerminalRuleCall_2_1_0ElementType());

	private static class TrickyGFactory {
		public static IGrammarAwareElementType createTrickyGElementType() {
			return new IGrammarAwareElementType("TrickyG_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyGRule());
		}
		public static IGrammarAwareElementType createTrickyG_GroupElementType() {
			return new IGrammarAwareElementType("TrickyG_Group_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyGAccess().getGroup());
		}
		public static IGrammarAwareElementType createTrickyG_TGKeyword_0ElementType() {
			return new IGrammarAwareElementType("TrickyG_TGKeyword_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyGAccess().getTGKeyword_0());
		}
		public static IGrammarAwareElementType createTrickyG_TreeAssignment_1ElementType() {
			return new IGrammarAwareElementType("TrickyG_TreeAssignment_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyGAccess().getTreeAssignment_1());
		}
		public static IGrammarAwareElementType createTrickyG_TreeTrickyG1ParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("TrickyG_TreeTrickyG1ParserRuleCall_1_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyGAccess().getTreeTrickyG1ParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType TrickyG_ELEMENT_TYPE = associate(TrickyGFactory.createTrickyGElementType());

	public static final IGrammarAwareElementType TrickyG_Group_ELEMENT_TYPE = associate(TrickyGFactory.createTrickyG_GroupElementType());

	public static final IGrammarAwareElementType TrickyG_TGKeyword_0_ELEMENT_TYPE = associate(TrickyGFactory.createTrickyG_TGKeyword_0ElementType());

	public static final IGrammarAwareElementType TrickyG_TreeAssignment_1_ELEMENT_TYPE = associate(TrickyGFactory.createTrickyG_TreeAssignment_1ElementType());

	public static final IGrammarAwareElementType TrickyG_TreeTrickyG1ParserRuleCall_1_0_ELEMENT_TYPE = associate(TrickyGFactory.createTrickyG_TreeTrickyG1ParserRuleCall_1_0ElementType());

	private static class TrickyG1Factory {
		public static IGrammarAwareElementType createTrickyG1ElementType() {
			return new IGrammarAwareElementType("TrickyG1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyG1Rule());
		}
		public static IGrammarAwareElementType createTrickyG1_GroupElementType() {
			return new IGrammarAwareElementType("TrickyG1_Group_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyG1Access().getGroup());
		}
		public static IGrammarAwareElementType createTrickyG1_LeftSquareBracketKeyword_0ElementType() {
			return new IGrammarAwareElementType("TrickyG1_LeftSquareBracketKeyword_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyG1Access().getLeftSquareBracketKeyword_0());
		}
		public static IGrammarAwareElementType createTrickyG1_Group_1ElementType() {
			return new IGrammarAwareElementType("TrickyG1_Group_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyG1Access().getGroup_1());
		}
		public static IGrammarAwareElementType createTrickyG1_ValsAssignment_1_0ElementType() {
			return new IGrammarAwareElementType("TrickyG1_ValsAssignment_1_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyG1Access().getValsAssignment_1_0());
		}
		public static IGrammarAwareElementType createTrickyG1_ValsTrickyG2ParserRuleCall_1_0_0ElementType() {
			return new IGrammarAwareElementType("TrickyG1_ValsTrickyG2ParserRuleCall_1_0_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyG1Access().getValsTrickyG2ParserRuleCall_1_0_0());
		}
		public static IGrammarAwareElementType createTrickyG1_Group_1_1ElementType() {
			return new IGrammarAwareElementType("TrickyG1_Group_1_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyG1Access().getGroup_1_1());
		}
		public static IGrammarAwareElementType createTrickyG1_CommaKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("TrickyG1_CommaKeyword_1_1_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyG1Access().getCommaKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createTrickyG1_ValsAssignment_1_1_1ElementType() {
			return new IGrammarAwareElementType("TrickyG1_ValsAssignment_1_1_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyG1Access().getValsAssignment_1_1_1());
		}
		public static IGrammarAwareElementType createTrickyG1_ValsTrickyG2ParserRuleCall_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("TrickyG1_ValsTrickyG2ParserRuleCall_1_1_1_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyG1Access().getValsTrickyG2ParserRuleCall_1_1_1_0());
		}
		public static IGrammarAwareElementType createTrickyG1_RightSquareBracketKeyword_2ElementType() {
			return new IGrammarAwareElementType("TrickyG1_RightSquareBracketKeyword_2_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyG1Access().getRightSquareBracketKeyword_2());
		}
	}

	public static final IGrammarAwareElementType TrickyG1_ELEMENT_TYPE = associate(TrickyG1Factory.createTrickyG1ElementType());

	public static final IGrammarAwareElementType TrickyG1_Group_ELEMENT_TYPE = associate(TrickyG1Factory.createTrickyG1_GroupElementType());

	public static final IGrammarAwareElementType TrickyG1_LeftSquareBracketKeyword_0_ELEMENT_TYPE = associate(TrickyG1Factory.createTrickyG1_LeftSquareBracketKeyword_0ElementType());

	public static final IGrammarAwareElementType TrickyG1_Group_1_ELEMENT_TYPE = associate(TrickyG1Factory.createTrickyG1_Group_1ElementType());

	public static final IGrammarAwareElementType TrickyG1_ValsAssignment_1_0_ELEMENT_TYPE = associate(TrickyG1Factory.createTrickyG1_ValsAssignment_1_0ElementType());

	public static final IGrammarAwareElementType TrickyG1_ValsTrickyG2ParserRuleCall_1_0_0_ELEMENT_TYPE = associate(TrickyG1Factory.createTrickyG1_ValsTrickyG2ParserRuleCall_1_0_0ElementType());

	public static final IGrammarAwareElementType TrickyG1_Group_1_1_ELEMENT_TYPE = associate(TrickyG1Factory.createTrickyG1_Group_1_1ElementType());

	public static final IGrammarAwareElementType TrickyG1_CommaKeyword_1_1_0_ELEMENT_TYPE = associate(TrickyG1Factory.createTrickyG1_CommaKeyword_1_1_0ElementType());

	public static final IGrammarAwareElementType TrickyG1_ValsAssignment_1_1_1_ELEMENT_TYPE = associate(TrickyG1Factory.createTrickyG1_ValsAssignment_1_1_1ElementType());

	public static final IGrammarAwareElementType TrickyG1_ValsTrickyG2ParserRuleCall_1_1_1_0_ELEMENT_TYPE = associate(TrickyG1Factory.createTrickyG1_ValsTrickyG2ParserRuleCall_1_1_1_0ElementType());

	public static final IGrammarAwareElementType TrickyG1_RightSquareBracketKeyword_2_ELEMENT_TYPE = associate(TrickyG1Factory.createTrickyG1_RightSquareBracketKeyword_2ElementType());

	private static class TrickyG2Factory {
		public static IGrammarAwareElementType createTrickyG2ElementType() {
			return new IGrammarAwareElementType("TrickyG2_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyG2Rule());
		}
		public static IGrammarAwareElementType createTrickyG2_AlternativesElementType() {
			return new IGrammarAwareElementType("TrickyG2_Alternatives_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyG2Access().getAlternatives());
		}
		public static IGrammarAwareElementType createTrickyG2_TrickyG1ParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("TrickyG2_TrickyG1ParserRuleCall_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyG2Access().getTrickyG1ParserRuleCall_0());
		}
		public static IGrammarAwareElementType createTrickyG2_ValAssignment_1ElementType() {
			return new IGrammarAwareElementType("TrickyG2_ValAssignment_1_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyG2Access().getValAssignment_1());
		}
		public static IGrammarAwareElementType createTrickyG2_ValINTTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("TrickyG2_ValINTTerminalRuleCall_1_0_ELEMENT_TYPE", ComplexReconstrTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTrickyG2Access().getValINTTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType TrickyG2_ELEMENT_TYPE = associate(TrickyG2Factory.createTrickyG2ElementType());

	public static final IGrammarAwareElementType TrickyG2_Alternatives_ELEMENT_TYPE = associate(TrickyG2Factory.createTrickyG2_AlternativesElementType());

	public static final IGrammarAwareElementType TrickyG2_TrickyG1ParserRuleCall_0_ELEMENT_TYPE = associate(TrickyG2Factory.createTrickyG2_TrickyG1ParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType TrickyG2_ValAssignment_1_ELEMENT_TYPE = associate(TrickyG2Factory.createTrickyG2_ValAssignment_1ElementType());

	public static final IGrammarAwareElementType TrickyG2_ValINTTerminalRuleCall_1_0_ELEMENT_TYPE = associate(TrickyG2Factory.createTrickyG2_ValINTTerminalRuleCall_1_0ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getRootElementType() {
		return Root_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_AlternativesElementType() {
		return Root_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_OpParserRuleCall_0ElementType() {
		return Root_OpParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_TrickyGParserRuleCall_1ElementType() {
		return Root_TrickyGParserRuleCall_1_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getOp_Alternatives_1ElementType() {
		return Op_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOp_Group_1_0ElementType() {
		return Op_Group_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOp_AddAddOperandsAction_1_0_0ElementType() {
		return Op_AddAddOperandsAction_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOp_PlusSignKeyword_1_0_1ElementType() {
		return Op_PlusSignKeyword_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOp_AddOperandsAssignment_1_0_2ElementType() {
		return Op_AddOperandsAssignment_1_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOp_AddOperandsTermParserRuleCall_1_0_2_0ElementType() {
		return Op_AddOperandsTermParserRuleCall_1_0_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOp_Group_1_1ElementType() {
		return Op_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOp_MinusMinusOperandsAction_1_1_0ElementType() {
		return Op_MinusMinusOperandsAction_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOp_HyphenMinusKeyword_1_1_1ElementType() {
		return Op_HyphenMinusKeyword_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOp_MinusOperandsAssignment_1_1_2ElementType() {
		return Op_MinusOperandsAssignment_1_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOp_MinusOperandsTermParserRuleCall_1_1_2_0ElementType() {
		return Op_MinusOperandsTermParserRuleCall_1_1_2_0_ELEMENT_TYPE;
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

	public IGrammarAwareElementType getTrickyBElementType() {
		return TrickyB_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyB_GroupElementType() {
		return TrickyB_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyB_TBKeyword_0ElementType() {
		return TrickyB_TBKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyB_Group_1ElementType() {
		return TrickyB_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyB_NameAssignment_1_0ElementType() {
		return TrickyB_NameAssignment_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyB_NameIDTerminalRuleCall_1_0_0ElementType() {
		return TrickyB_NameIDTerminalRuleCall_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyB_TypeAssignment_1_1ElementType() {
		return TrickyB_TypeAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyB_TypeINTTerminalRuleCall_1_1_0ElementType() {
		return TrickyB_TypeINTTerminalRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyB_TypeAssignment_2ElementType() {
		return TrickyB_TypeAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyB_TypeINTTerminalRuleCall_2_0ElementType() {
		return TrickyB_TypeINTTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyCElementType() {
		return TrickyC_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyC_GroupElementType() {
		return TrickyC_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyC_TCKeyword_0ElementType() {
		return TrickyC_TCKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyC_NameAssignment_1ElementType() {
		return TrickyC_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyC_NameIDTerminalRuleCall_1_0ElementType() {
		return TrickyC_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyC_Group_2ElementType() {
		return TrickyC_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyC_C1XAction_2_0ElementType() {
		return TrickyC_C1XAction_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyC_XKeyword_2_1ElementType() {
		return TrickyC_XKeyword_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyC_Group_3ElementType() {
		return TrickyC_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyC_C2YAction_3_0ElementType() {
		return TrickyC_C2YAction_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyC_YKeyword_3_1ElementType() {
		return TrickyC_YKeyword_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyC_Group_4ElementType() {
		return TrickyC_Group_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyC_C3ZAction_4_0ElementType() {
		return TrickyC_C3ZAction_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyC_ZKeyword_4_1ElementType() {
		return TrickyC_ZKeyword_4_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyDElementType() {
		return TrickyD_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyD_GroupElementType() {
		return TrickyD_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyD_TDKeyword_0ElementType() {
		return TrickyD_TDKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyD_Group_1ElementType() {
		return TrickyD_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyD_NameAssignment_1_0ElementType() {
		return TrickyD_NameAssignment_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyD_NameINTTerminalRuleCall_1_0_0ElementType() {
		return TrickyD_NameINTTerminalRuleCall_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyD_FooAssignment_1_1ElementType() {
		return TrickyD_FooAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyD_FooSTRINGTerminalRuleCall_1_1_0ElementType() {
		return TrickyD_FooSTRINGTerminalRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyD_TypeAssignment_1_2ElementType() {
		return TrickyD_TypeAssignment_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyD_TypeIDTerminalRuleCall_1_2_0ElementType() {
		return TrickyD_TypeIDTerminalRuleCall_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyD_Group_2ElementType() {
		return TrickyD_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyD_NameAssignment_2_0ElementType() {
		return TrickyD_NameAssignment_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyD_NameINTTerminalRuleCall_2_0_0ElementType() {
		return TrickyD_NameINTTerminalRuleCall_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyD_TypeAssignment_2_1ElementType() {
		return TrickyD_TypeAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyD_TypeIDTerminalRuleCall_2_1_0ElementType() {
		return TrickyD_TypeIDTerminalRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyD_TypeAssignment_3ElementType() {
		return TrickyD_TypeAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyD_TypeIDTerminalRuleCall_3_0ElementType() {
		return TrickyD_TypeIDTerminalRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyEElementType() {
		return TrickyE_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyE_GroupElementType() {
		return TrickyE_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyE_TEKeyword_0ElementType() {
		return TrickyE_TEKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyE_Group_1ElementType() {
		return TrickyE_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyE_NameAssignment_1_0ElementType() {
		return TrickyE_NameAssignment_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyE_NameINTTerminalRuleCall_1_0_0ElementType() {
		return TrickyE_NameINTTerminalRuleCall_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyE_FooAssignment_1_1ElementType() {
		return TrickyE_FooAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyE_FooSTRINGTerminalRuleCall_1_1_0ElementType() {
		return TrickyE_FooSTRINGTerminalRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyE_TypeAssignment_1_2ElementType() {
		return TrickyE_TypeAssignment_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyE_TypeIDTerminalRuleCall_1_2_0ElementType() {
		return TrickyE_TypeIDTerminalRuleCall_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyE_XKeyword_2ElementType() {
		return TrickyE_XKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyE_Group_3ElementType() {
		return TrickyE_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyE_NameAssignment_3_0ElementType() {
		return TrickyE_NameAssignment_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyE_NameINTTerminalRuleCall_3_0_0ElementType() {
		return TrickyE_NameINTTerminalRuleCall_3_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyE_TypeAssignment_3_1ElementType() {
		return TrickyE_TypeAssignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyE_TypeIDTerminalRuleCall_3_1_0ElementType() {
		return TrickyE_TypeIDTerminalRuleCall_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyFElementType() {
		return TrickyF_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyF_GroupElementType() {
		return TrickyF_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyF_TFKeyword_0ElementType() {
		return TrickyF_TFKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyF_Group_1ElementType() {
		return TrickyF_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyF_NameAssignment_1_0ElementType() {
		return TrickyF_NameAssignment_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyF_NameIDTerminalRuleCall_1_0_0ElementType() {
		return TrickyF_NameIDTerminalRuleCall_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyF_TypeAssignment_1_1ElementType() {
		return TrickyF_TypeAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyF_TypeINTTerminalRuleCall_1_1_0ElementType() {
		return TrickyF_TypeINTTerminalRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyF_Alternatives_2ElementType() {
		return TrickyF_Alternatives_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyF_NameAssignment_2_0ElementType() {
		return TrickyF_NameAssignment_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyF_NameIDTerminalRuleCall_2_0_0ElementType() {
		return TrickyF_NameIDTerminalRuleCall_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyF_TypeAssignment_2_1ElementType() {
		return TrickyF_TypeAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyF_TypeINTTerminalRuleCall_2_1_0ElementType() {
		return TrickyF_TypeINTTerminalRuleCall_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyGElementType() {
		return TrickyG_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyG_GroupElementType() {
		return TrickyG_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyG_TGKeyword_0ElementType() {
		return TrickyG_TGKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyG_TreeAssignment_1ElementType() {
		return TrickyG_TreeAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyG_TreeTrickyG1ParserRuleCall_1_0ElementType() {
		return TrickyG_TreeTrickyG1ParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyG1ElementType() {
		return TrickyG1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyG1_GroupElementType() {
		return TrickyG1_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyG1_LeftSquareBracketKeyword_0ElementType() {
		return TrickyG1_LeftSquareBracketKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyG1_Group_1ElementType() {
		return TrickyG1_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyG1_ValsAssignment_1_0ElementType() {
		return TrickyG1_ValsAssignment_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyG1_ValsTrickyG2ParserRuleCall_1_0_0ElementType() {
		return TrickyG1_ValsTrickyG2ParserRuleCall_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyG1_Group_1_1ElementType() {
		return TrickyG1_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyG1_CommaKeyword_1_1_0ElementType() {
		return TrickyG1_CommaKeyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyG1_ValsAssignment_1_1_1ElementType() {
		return TrickyG1_ValsAssignment_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyG1_ValsTrickyG2ParserRuleCall_1_1_1_0ElementType() {
		return TrickyG1_ValsTrickyG2ParserRuleCall_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyG1_RightSquareBracketKeyword_2ElementType() {
		return TrickyG1_RightSquareBracketKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyG2ElementType() {
		return TrickyG2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyG2_AlternativesElementType() {
		return TrickyG2_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyG2_TrickyG1ParserRuleCall_0ElementType() {
		return TrickyG2_TrickyG1ParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyG2_ValAssignment_1ElementType() {
		return TrickyG2_ValAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTrickyG2_ValINTTerminalRuleCall_1_0ElementType() {
		return TrickyG2_ValINTTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

}
