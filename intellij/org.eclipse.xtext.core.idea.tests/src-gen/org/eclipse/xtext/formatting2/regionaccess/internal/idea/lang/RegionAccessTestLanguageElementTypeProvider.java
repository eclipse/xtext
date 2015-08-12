package org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.psi.impl.RegionAccessTestLanguageFileImpl;
import org.eclipse.xtext.formatting2.regionaccess.internal.services.RegionAccessTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class RegionAccessTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<RegionAccessTestLanguageFileImpl>>(RegionAccessTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final RegionAccessTestLanguageGrammarAccess GRAMMAR_ACCESS = RegionAccessTestLanguageLanguage.INSTANCE.getInstance(RegionAccessTestLanguageGrammarAccess.class);

	private static class RootFactory {
		public static IGrammarAwareElementType createRootElementType() {
			return new IGrammarAwareElementType("Root_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootRule());
		}
		public static IGrammarAwareElementType createRoot_AlternativesElementType() {
			return new IGrammarAwareElementType("Root_Alternatives_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createRoot_SimpleParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Root_SimpleParserRuleCall_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getSimpleParserRuleCall_0());
		}
		public static IGrammarAwareElementType createRoot_DelegationParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Root_DelegationParserRuleCall_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getDelegationParserRuleCall_1());
		}
		public static IGrammarAwareElementType createRoot_UnassignedParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("Root_UnassignedParserRuleCall_2_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getUnassignedParserRuleCall_2());
		}
		public static IGrammarAwareElementType createRoot_PrefixedUnassignedParserRuleCall_3ElementType() {
			return new IGrammarAwareElementType("Root_PrefixedUnassignedParserRuleCall_3_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getPrefixedUnassignedParserRuleCall_3());
		}
		public static IGrammarAwareElementType createRoot_Group_4ElementType() {
			return new IGrammarAwareElementType("Root_Group_4_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getGroup_4());
		}
		public static IGrammarAwareElementType createRoot_DigitFiveKeyword_4_0ElementType() {
			return new IGrammarAwareElementType("Root_DigitFiveKeyword_4_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getDigitFiveKeyword_4_0());
		}
		public static IGrammarAwareElementType createRoot_ExpressionParserRuleCall_4_1ElementType() {
			return new IGrammarAwareElementType("Root_ExpressionParserRuleCall_4_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getExpressionParserRuleCall_4_1());
		}
		public static IGrammarAwareElementType createRoot_Group_5ElementType() {
			return new IGrammarAwareElementType("Root_Group_5_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getGroup_5());
		}
		public static IGrammarAwareElementType createRoot_DigitSixKeyword_5_0ElementType() {
			return new IGrammarAwareElementType("Root_DigitSixKeyword_5_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getDigitSixKeyword_5_0());
		}
		public static IGrammarAwareElementType createRoot_MixedParserRuleCall_5_1ElementType() {
			return new IGrammarAwareElementType("Root_MixedParserRuleCall_5_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getMixedParserRuleCall_5_1());
		}
		public static IGrammarAwareElementType createRoot_Group_6ElementType() {
			return new IGrammarAwareElementType("Root_Group_6_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getGroup_6());
		}
		public static IGrammarAwareElementType createRoot_DigitSevenKeyword_6_0ElementType() {
			return new IGrammarAwareElementType("Root_DigitSevenKeyword_6_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getDigitSevenKeyword_6_0());
		}
		public static IGrammarAwareElementType createRoot_MixedAssignment_6_1ElementType() {
			return new IGrammarAwareElementType("Root_MixedAssignment_6_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getMixedAssignment_6_1());
		}
		public static IGrammarAwareElementType createRoot_MixedMixedParserRuleCall_6_1_0ElementType() {
			return new IGrammarAwareElementType("Root_MixedMixedParserRuleCall_6_1_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getMixedMixedParserRuleCall_6_1_0());
		}
	}

	public static final IGrammarAwareElementType Root_ELEMENT_TYPE = associate(RootFactory.createRootElementType());

	public static final IGrammarAwareElementType Root_Alternatives_ELEMENT_TYPE = associate(RootFactory.createRoot_AlternativesElementType());

	public static final IGrammarAwareElementType Root_SimpleParserRuleCall_0_ELEMENT_TYPE = associate(RootFactory.createRoot_SimpleParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Root_DelegationParserRuleCall_1_ELEMENT_TYPE = associate(RootFactory.createRoot_DelegationParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType Root_UnassignedParserRuleCall_2_ELEMENT_TYPE = associate(RootFactory.createRoot_UnassignedParserRuleCall_2ElementType());

	public static final IGrammarAwareElementType Root_PrefixedUnassignedParserRuleCall_3_ELEMENT_TYPE = associate(RootFactory.createRoot_PrefixedUnassignedParserRuleCall_3ElementType());

	public static final IGrammarAwareElementType Root_Group_4_ELEMENT_TYPE = associate(RootFactory.createRoot_Group_4ElementType());

	public static final IGrammarAwareElementType Root_DigitFiveKeyword_4_0_ELEMENT_TYPE = associate(RootFactory.createRoot_DigitFiveKeyword_4_0ElementType());

	public static final IGrammarAwareElementType Root_ExpressionParserRuleCall_4_1_ELEMENT_TYPE = associate(RootFactory.createRoot_ExpressionParserRuleCall_4_1ElementType());

	public static final IGrammarAwareElementType Root_Group_5_ELEMENT_TYPE = associate(RootFactory.createRoot_Group_5ElementType());

	public static final IGrammarAwareElementType Root_DigitSixKeyword_5_0_ELEMENT_TYPE = associate(RootFactory.createRoot_DigitSixKeyword_5_0ElementType());

	public static final IGrammarAwareElementType Root_MixedParserRuleCall_5_1_ELEMENT_TYPE = associate(RootFactory.createRoot_MixedParserRuleCall_5_1ElementType());

	public static final IGrammarAwareElementType Root_Group_6_ELEMENT_TYPE = associate(RootFactory.createRoot_Group_6ElementType());

	public static final IGrammarAwareElementType Root_DigitSevenKeyword_6_0_ELEMENT_TYPE = associate(RootFactory.createRoot_DigitSevenKeyword_6_0ElementType());

	public static final IGrammarAwareElementType Root_MixedAssignment_6_1_ELEMENT_TYPE = associate(RootFactory.createRoot_MixedAssignment_6_1ElementType());

	public static final IGrammarAwareElementType Root_MixedMixedParserRuleCall_6_1_0_ELEMENT_TYPE = associate(RootFactory.createRoot_MixedMixedParserRuleCall_6_1_0ElementType());

	private static class SimpleFactory {
		public static IGrammarAwareElementType createSimpleElementType() {
			return new IGrammarAwareElementType("Simple_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleRule());
		}
		public static IGrammarAwareElementType createSimple_GroupElementType() {
			return new IGrammarAwareElementType("Simple_Group_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAccess().getGroup());
		}
		public static IGrammarAwareElementType createSimple_DigitOneKeyword_0ElementType() {
			return new IGrammarAwareElementType("Simple_DigitOneKeyword_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAccess().getDigitOneKeyword_0());
		}
		public static IGrammarAwareElementType createSimple_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Simple_NameAssignment_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createSimple_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Simple_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSimpleAccess().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Simple_ELEMENT_TYPE = associate(SimpleFactory.createSimpleElementType());

	public static final IGrammarAwareElementType Simple_Group_ELEMENT_TYPE = associate(SimpleFactory.createSimple_GroupElementType());

	public static final IGrammarAwareElementType Simple_DigitOneKeyword_0_ELEMENT_TYPE = associate(SimpleFactory.createSimple_DigitOneKeyword_0ElementType());

	public static final IGrammarAwareElementType Simple_NameAssignment_1_ELEMENT_TYPE = associate(SimpleFactory.createSimple_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Simple_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(SimpleFactory.createSimple_NameIDTerminalRuleCall_1_0ElementType());

	private static class DelegationFactory {
		public static IGrammarAwareElementType createDelegationElementType() {
			return new IGrammarAwareElementType("Delegation_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDelegationRule());
		}
		public static IGrammarAwareElementType createDelegation_GroupElementType() {
			return new IGrammarAwareElementType("Delegation_Group_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDelegationAccess().getGroup());
		}
		public static IGrammarAwareElementType createDelegation_DigitTwoKeyword_0ElementType() {
			return new IGrammarAwareElementType("Delegation_DigitTwoKeyword_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDelegationAccess().getDigitTwoKeyword_0());
		}
		public static IGrammarAwareElementType createDelegation_DelegateAssignment_1ElementType() {
			return new IGrammarAwareElementType("Delegation_DelegateAssignment_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDelegationAccess().getDelegateAssignment_1());
		}
		public static IGrammarAwareElementType createDelegation_DelegateDelegateParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Delegation_DelegateDelegateParserRuleCall_1_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDelegationAccess().getDelegateDelegateParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Delegation_ELEMENT_TYPE = associate(DelegationFactory.createDelegationElementType());

	public static final IGrammarAwareElementType Delegation_Group_ELEMENT_TYPE = associate(DelegationFactory.createDelegation_GroupElementType());

	public static final IGrammarAwareElementType Delegation_DigitTwoKeyword_0_ELEMENT_TYPE = associate(DelegationFactory.createDelegation_DigitTwoKeyword_0ElementType());

	public static final IGrammarAwareElementType Delegation_DelegateAssignment_1_ELEMENT_TYPE = associate(DelegationFactory.createDelegation_DelegateAssignment_1ElementType());

	public static final IGrammarAwareElementType Delegation_DelegateDelegateParserRuleCall_1_0_ELEMENT_TYPE = associate(DelegationFactory.createDelegation_DelegateDelegateParserRuleCall_1_0ElementType());

	private static class UnassignedFactory {
		public static IGrammarAwareElementType createUnassignedElementType() {
			return new IGrammarAwareElementType("Unassigned_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedRule());
		}
		public static IGrammarAwareElementType createUnassigned_GroupElementType() {
			return new IGrammarAwareElementType("Unassigned_Group_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAccess().getGroup());
		}
		public static IGrammarAwareElementType createUnassigned_DigitThreeKeyword_0ElementType() {
			return new IGrammarAwareElementType("Unassigned_DigitThreeKeyword_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAccess().getDigitThreeKeyword_0());
		}
		public static IGrammarAwareElementType createUnassigned_DelegateParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Unassigned_DelegateParserRuleCall_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnassignedAccess().getDelegateParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType Unassigned_ELEMENT_TYPE = associate(UnassignedFactory.createUnassignedElementType());

	public static final IGrammarAwareElementType Unassigned_Group_ELEMENT_TYPE = associate(UnassignedFactory.createUnassigned_GroupElementType());

	public static final IGrammarAwareElementType Unassigned_DigitThreeKeyword_0_ELEMENT_TYPE = associate(UnassignedFactory.createUnassigned_DigitThreeKeyword_0ElementType());

	public static final IGrammarAwareElementType Unassigned_DelegateParserRuleCall_1_ELEMENT_TYPE = associate(UnassignedFactory.createUnassigned_DelegateParserRuleCall_1ElementType());

	private static class PrefixedUnassignedFactory {
		public static IGrammarAwareElementType createPrefixedUnassignedElementType() {
			return new IGrammarAwareElementType("PrefixedUnassigned_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrefixedUnassignedRule());
		}
		public static IGrammarAwareElementType createPrefixedUnassigned_GroupElementType() {
			return new IGrammarAwareElementType("PrefixedUnassigned_Group_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrefixedUnassignedAccess().getGroup());
		}
		public static IGrammarAwareElementType createPrefixedUnassigned_DigitFourKeyword_0ElementType() {
			return new IGrammarAwareElementType("PrefixedUnassigned_DigitFourKeyword_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrefixedUnassignedAccess().getDigitFourKeyword_0());
		}
		public static IGrammarAwareElementType createPrefixedUnassigned_DelegateAssignment_1ElementType() {
			return new IGrammarAwareElementType("PrefixedUnassigned_DelegateAssignment_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrefixedUnassignedAccess().getDelegateAssignment_1());
		}
		public static IGrammarAwareElementType createPrefixedUnassigned_DelegatePrefixedDelegateParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("PrefixedUnassigned_DelegatePrefixedDelegateParserRuleCall_1_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrefixedUnassignedAccess().getDelegatePrefixedDelegateParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType PrefixedUnassigned_ELEMENT_TYPE = associate(PrefixedUnassignedFactory.createPrefixedUnassignedElementType());

	public static final IGrammarAwareElementType PrefixedUnassigned_Group_ELEMENT_TYPE = associate(PrefixedUnassignedFactory.createPrefixedUnassigned_GroupElementType());

	public static final IGrammarAwareElementType PrefixedUnassigned_DigitFourKeyword_0_ELEMENT_TYPE = associate(PrefixedUnassignedFactory.createPrefixedUnassigned_DigitFourKeyword_0ElementType());

	public static final IGrammarAwareElementType PrefixedUnassigned_DelegateAssignment_1_ELEMENT_TYPE = associate(PrefixedUnassignedFactory.createPrefixedUnassigned_DelegateAssignment_1ElementType());

	public static final IGrammarAwareElementType PrefixedUnassigned_DelegatePrefixedDelegateParserRuleCall_1_0_ELEMENT_TYPE = associate(PrefixedUnassignedFactory.createPrefixedUnassigned_DelegatePrefixedDelegateParserRuleCall_1_0ElementType());

	private static class PrefixedDelegateFactory {
		public static IGrammarAwareElementType createPrefixedDelegateElementType() {
			return new IGrammarAwareElementType("PrefixedDelegate_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrefixedDelegateRule());
		}
		public static IGrammarAwareElementType createPrefixedDelegate_GroupElementType() {
			return new IGrammarAwareElementType("PrefixedDelegate_Group_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrefixedDelegateAccess().getGroup());
		}
		public static IGrammarAwareElementType createPrefixedDelegate_PrefixKeyword_0ElementType() {
			return new IGrammarAwareElementType("PrefixedDelegate_PrefixKeyword_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrefixedDelegateAccess().getPrefixKeyword_0());
		}
		public static IGrammarAwareElementType createPrefixedDelegate_DelegateParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("PrefixedDelegate_DelegateParserRuleCall_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrefixedDelegateAccess().getDelegateParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType PrefixedDelegate_ELEMENT_TYPE = associate(PrefixedDelegateFactory.createPrefixedDelegateElementType());

	public static final IGrammarAwareElementType PrefixedDelegate_Group_ELEMENT_TYPE = associate(PrefixedDelegateFactory.createPrefixedDelegate_GroupElementType());

	public static final IGrammarAwareElementType PrefixedDelegate_PrefixKeyword_0_ELEMENT_TYPE = associate(PrefixedDelegateFactory.createPrefixedDelegate_PrefixKeyword_0ElementType());

	public static final IGrammarAwareElementType PrefixedDelegate_DelegateParserRuleCall_1_ELEMENT_TYPE = associate(PrefixedDelegateFactory.createPrefixedDelegate_DelegateParserRuleCall_1ElementType());

	private static class DelegateFactory {
		public static IGrammarAwareElementType createDelegateElementType() {
			return new IGrammarAwareElementType("Delegate_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDelegateRule());
		}
		public static IGrammarAwareElementType createDelegate_NameAssignmentElementType() {
			return new IGrammarAwareElementType("Delegate_NameAssignment_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDelegateAccess().getNameAssignment());
		}
		public static IGrammarAwareElementType createDelegate_NameIDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Delegate_NameIDTerminalRuleCall_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDelegateAccess().getNameIDTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Delegate_ELEMENT_TYPE = associate(DelegateFactory.createDelegateElementType());

	public static final IGrammarAwareElementType Delegate_NameAssignment_ELEMENT_TYPE = associate(DelegateFactory.createDelegate_NameAssignmentElementType());

	public static final IGrammarAwareElementType Delegate_NameIDTerminalRuleCall_0_ELEMENT_TYPE = associate(DelegateFactory.createDelegate_NameIDTerminalRuleCall_0ElementType());

	private static class ExpressionFactory {
		public static IGrammarAwareElementType createExpressionElementType() {
			return new IGrammarAwareElementType("Expression_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionRule());
		}
		public static IGrammarAwareElementType createExpression_GroupElementType() {
			return new IGrammarAwareElementType("Expression_Group_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getGroup());
		}
		public static IGrammarAwareElementType createExpression_PrimaryParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Expression_PrimaryParserRuleCall_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getPrimaryParserRuleCall_0());
		}
		public static IGrammarAwareElementType createExpression_Group_1ElementType() {
			return new IGrammarAwareElementType("Expression_Group_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createExpression_AddLeftAction_1_0ElementType() {
			return new IGrammarAwareElementType("Expression_AddLeftAction_1_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getAddLeftAction_1_0());
		}
		public static IGrammarAwareElementType createExpression_PlusSignKeyword_1_1ElementType() {
			return new IGrammarAwareElementType("Expression_PlusSignKeyword_1_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getPlusSignKeyword_1_1());
		}
		public static IGrammarAwareElementType createExpression_RightAssignment_1_2ElementType() {
			return new IGrammarAwareElementType("Expression_RightAssignment_1_2_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getRightAssignment_1_2());
		}
		public static IGrammarAwareElementType createExpression_RightPrimaryParserRuleCall_1_2_0ElementType() {
			return new IGrammarAwareElementType("Expression_RightPrimaryParserRuleCall_1_2_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExpressionAccess().getRightPrimaryParserRuleCall_1_2_0());
		}
	}

	public static final IGrammarAwareElementType Expression_ELEMENT_TYPE = associate(ExpressionFactory.createExpressionElementType());

	public static final IGrammarAwareElementType Expression_Group_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_GroupElementType());

	public static final IGrammarAwareElementType Expression_PrimaryParserRuleCall_0_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_PrimaryParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Expression_Group_1_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_Group_1ElementType());

	public static final IGrammarAwareElementType Expression_AddLeftAction_1_0_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_AddLeftAction_1_0ElementType());

	public static final IGrammarAwareElementType Expression_PlusSignKeyword_1_1_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_PlusSignKeyword_1_1ElementType());

	public static final IGrammarAwareElementType Expression_RightAssignment_1_2_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_RightAssignment_1_2ElementType());

	public static final IGrammarAwareElementType Expression_RightPrimaryParserRuleCall_1_2_0_ELEMENT_TYPE = associate(ExpressionFactory.createExpression_RightPrimaryParserRuleCall_1_2_0ElementType());

	private static class PrimaryFactory {
		public static IGrammarAwareElementType createPrimaryElementType() {
			return new IGrammarAwareElementType("Primary_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimaryRule());
		}
		public static IGrammarAwareElementType createPrimary_AlternativesElementType() {
			return new IGrammarAwareElementType("Primary_Alternatives_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimaryAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createPrimary_Group_0ElementType() {
			return new IGrammarAwareElementType("Primary_Group_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimaryAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createPrimary_NamedAction_0_0ElementType() {
			return new IGrammarAwareElementType("Primary_NamedAction_0_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimaryAccess().getNamedAction_0_0());
		}
		public static IGrammarAwareElementType createPrimary_NameAssignment_0_1ElementType() {
			return new IGrammarAwareElementType("Primary_NameAssignment_0_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimaryAccess().getNameAssignment_0_1());
		}
		public static IGrammarAwareElementType createPrimary_NameIDTerminalRuleCall_0_1_0ElementType() {
			return new IGrammarAwareElementType("Primary_NameIDTerminalRuleCall_0_1_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimaryAccess().getNameIDTerminalRuleCall_0_1_0());
		}
		public static IGrammarAwareElementType createPrimary_ParenthesizedParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Primary_ParenthesizedParserRuleCall_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPrimaryAccess().getParenthesizedParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType Primary_ELEMENT_TYPE = associate(PrimaryFactory.createPrimaryElementType());

	public static final IGrammarAwareElementType Primary_Alternatives_ELEMENT_TYPE = associate(PrimaryFactory.createPrimary_AlternativesElementType());

	public static final IGrammarAwareElementType Primary_Group_0_ELEMENT_TYPE = associate(PrimaryFactory.createPrimary_Group_0ElementType());

	public static final IGrammarAwareElementType Primary_NamedAction_0_0_ELEMENT_TYPE = associate(PrimaryFactory.createPrimary_NamedAction_0_0ElementType());

	public static final IGrammarAwareElementType Primary_NameAssignment_0_1_ELEMENT_TYPE = associate(PrimaryFactory.createPrimary_NameAssignment_0_1ElementType());

	public static final IGrammarAwareElementType Primary_NameIDTerminalRuleCall_0_1_0_ELEMENT_TYPE = associate(PrimaryFactory.createPrimary_NameIDTerminalRuleCall_0_1_0ElementType());

	public static final IGrammarAwareElementType Primary_ParenthesizedParserRuleCall_1_ELEMENT_TYPE = associate(PrimaryFactory.createPrimary_ParenthesizedParserRuleCall_1ElementType());

	private static class ParenthesizedFactory {
		public static IGrammarAwareElementType createParenthesizedElementType() {
			return new IGrammarAwareElementType("Parenthesized_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedRule());
		}
		public static IGrammarAwareElementType createParenthesized_GroupElementType() {
			return new IGrammarAwareElementType("Parenthesized_Group_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedAccess().getGroup());
		}
		public static IGrammarAwareElementType createParenthesized_LeftParenthesisKeyword_0ElementType() {
			return new IGrammarAwareElementType("Parenthesized_LeftParenthesisKeyword_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedAccess().getLeftParenthesisKeyword_0());
		}
		public static IGrammarAwareElementType createParenthesized_ExpressionParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Parenthesized_ExpressionParserRuleCall_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedAccess().getExpressionParserRuleCall_1());
		}
		public static IGrammarAwareElementType createParenthesized_RightParenthesisKeyword_2ElementType() {
			return new IGrammarAwareElementType("Parenthesized_RightParenthesisKeyword_2_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParenthesizedAccess().getRightParenthesisKeyword_2());
		}
	}

	public static final IGrammarAwareElementType Parenthesized_ELEMENT_TYPE = associate(ParenthesizedFactory.createParenthesizedElementType());

	public static final IGrammarAwareElementType Parenthesized_Group_ELEMENT_TYPE = associate(ParenthesizedFactory.createParenthesized_GroupElementType());

	public static final IGrammarAwareElementType Parenthesized_LeftParenthesisKeyword_0_ELEMENT_TYPE = associate(ParenthesizedFactory.createParenthesized_LeftParenthesisKeyword_0ElementType());

	public static final IGrammarAwareElementType Parenthesized_ExpressionParserRuleCall_1_ELEMENT_TYPE = associate(ParenthesizedFactory.createParenthesized_ExpressionParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType Parenthesized_RightParenthesisKeyword_2_ELEMENT_TYPE = associate(ParenthesizedFactory.createParenthesized_RightParenthesisKeyword_2ElementType());

	private static class MixedFactory {
		public static IGrammarAwareElementType createMixedElementType() {
			return new IGrammarAwareElementType("Mixed_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedRule());
		}
		public static IGrammarAwareElementType createMixed_GroupElementType() {
			return new IGrammarAwareElementType("Mixed_Group_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getGroup());
		}
		public static IGrammarAwareElementType createMixed_LeftParenthesisKeyword_0ElementType() {
			return new IGrammarAwareElementType("Mixed_LeftParenthesisKeyword_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getLeftParenthesisKeyword_0());
		}
		public static IGrammarAwareElementType createMixed_Group_1ElementType() {
			return new IGrammarAwareElementType("Mixed_Group_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createMixed_UnassignedKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Mixed_UnassignedKeyword_1_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getUnassignedKeyword_1_0());
		}
		public static IGrammarAwareElementType createMixed_Alternatives_1_1ElementType() {
			return new IGrammarAwareElementType("Mixed_Alternatives_1_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getAlternatives_1_1());
		}
		public static IGrammarAwareElementType createMixed_IDTerminalRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("Mixed_IDTerminalRuleCall_1_1_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getIDTerminalRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createMixed_DatatypeParserRuleCall_1_1_1ElementType() {
			return new IGrammarAwareElementType("Mixed_DatatypeParserRuleCall_1_1_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getDatatypeParserRuleCall_1_1_1());
		}
		public static IGrammarAwareElementType createMixed_Alternatives_2ElementType() {
			return new IGrammarAwareElementType("Mixed_Alternatives_2_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getAlternatives_2());
		}
		public static IGrammarAwareElementType createMixed_ActionAction_2_0ElementType() {
			return new IGrammarAwareElementType("Mixed_ActionAction_2_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getActionAction_2_0());
		}
		public static IGrammarAwareElementType createMixed_MixedParserRuleCall_2_1ElementType() {
			return new IGrammarAwareElementType("Mixed_MixedParserRuleCall_2_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getMixedParserRuleCall_2_1());
		}
		public static IGrammarAwareElementType createMixed_Alternatives_2_2ElementType() {
			return new IGrammarAwareElementType("Mixed_Alternatives_2_2_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getAlternatives_2_2());
		}
		public static IGrammarAwareElementType createMixed_NameAssignment_2_2_0ElementType() {
			return new IGrammarAwareElementType("Mixed_NameAssignment_2_2_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getNameAssignment_2_2_0());
		}
		public static IGrammarAwareElementType createMixed_NameIDTerminalRuleCall_2_2_0_0ElementType() {
			return new IGrammarAwareElementType("Mixed_NameIDTerminalRuleCall_2_2_0_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getNameIDTerminalRuleCall_2_2_0_0());
		}
		public static IGrammarAwareElementType createMixed_Group_2_2_1ElementType() {
			return new IGrammarAwareElementType("Mixed_Group_2_2_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getGroup_2_2_1());
		}
		public static IGrammarAwareElementType createMixed_ChildKeyword_2_2_1_0ElementType() {
			return new IGrammarAwareElementType("Mixed_ChildKeyword_2_2_1_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getChildKeyword_2_2_1_0());
		}
		public static IGrammarAwareElementType createMixed_EobjAssignment_2_2_1_1ElementType() {
			return new IGrammarAwareElementType("Mixed_EobjAssignment_2_2_1_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getEobjAssignment_2_2_1_1());
		}
		public static IGrammarAwareElementType createMixed_EobjMixedParserRuleCall_2_2_1_1_0ElementType() {
			return new IGrammarAwareElementType("Mixed_EobjMixedParserRuleCall_2_2_1_1_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getEobjMixedParserRuleCall_2_2_1_1_0());
		}
		public static IGrammarAwareElementType createMixed_DatatypeAssignment_2_2_2ElementType() {
			return new IGrammarAwareElementType("Mixed_DatatypeAssignment_2_2_2_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getDatatypeAssignment_2_2_2());
		}
		public static IGrammarAwareElementType createMixed_DatatypeDatatypeParserRuleCall_2_2_2_0ElementType() {
			return new IGrammarAwareElementType("Mixed_DatatypeDatatypeParserRuleCall_2_2_2_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getDatatypeDatatypeParserRuleCall_2_2_2_0());
		}
		public static IGrammarAwareElementType createMixed_Group_2_2_3ElementType() {
			return new IGrammarAwareElementType("Mixed_Group_2_2_3_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getGroup_2_2_3());
		}
		public static IGrammarAwareElementType createMixed_RefKeyword_2_2_3_0ElementType() {
			return new IGrammarAwareElementType("Mixed_RefKeyword_2_2_3_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getRefKeyword_2_2_3_0());
		}
		public static IGrammarAwareElementType createMixed_RefAssignment_2_2_3_1ElementType() {
			return new IGrammarAwareElementType("Mixed_RefAssignment_2_2_3_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getRefAssignment_2_2_3_1());
		}
		public static IGrammarAwareElementType createMixed_RefMixedCrossReference_2_2_3_1_0ElementType() {
			return new IGrammarAwareElementType("Mixed_RefMixedCrossReference_2_2_3_1_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getRefMixedCrossReference_2_2_3_1_0());
		}
		public static IGrammarAwareElementType createMixed_RefMixedIDTerminalRuleCall_2_2_3_1_0_1ElementType() {
			return new IGrammarAwareElementType("Mixed_RefMixedIDTerminalRuleCall_2_2_3_1_0_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getRefMixedIDTerminalRuleCall_2_2_3_1_0_1());
		}
		public static IGrammarAwareElementType createMixed_LitAssignment_2_2_4ElementType() {
			return new IGrammarAwareElementType("Mixed_LitAssignment_2_2_4_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getLitAssignment_2_2_4());
		}
		public static IGrammarAwareElementType createMixed_LitEnumEnumRuleCall_2_2_4_0ElementType() {
			return new IGrammarAwareElementType("Mixed_LitEnumEnumRuleCall_2_2_4_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getLitEnumEnumRuleCall_2_2_4_0());
		}
		public static IGrammarAwareElementType createMixed_RightParenthesisKeyword_3ElementType() {
			return new IGrammarAwareElementType("Mixed_RightParenthesisKeyword_3_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getRightParenthesisKeyword_3());
		}
		public static IGrammarAwareElementType createMixed_Group_4ElementType() {
			return new IGrammarAwareElementType("Mixed_Group_4_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getGroup_4());
		}
		public static IGrammarAwareElementType createMixed_AssignedActionChildAction_4_0ElementType() {
			return new IGrammarAwareElementType("Mixed_AssignedActionChildAction_4_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getAssignedActionChildAction_4_0());
		}
		public static IGrammarAwareElementType createMixed_ActionKeyword_4_1ElementType() {
			return new IGrammarAwareElementType("Mixed_ActionKeyword_4_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getActionKeyword_4_1());
		}
		public static IGrammarAwareElementType createMixed_Group_4_2ElementType() {
			return new IGrammarAwareElementType("Mixed_Group_4_2_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getGroup_4_2());
		}
		public static IGrammarAwareElementType createMixed_BodyAssignment_4_2_0ElementType() {
			return new IGrammarAwareElementType("Mixed_BodyAssignment_4_2_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getBodyAssignment_4_2_0());
		}
		public static IGrammarAwareElementType createMixed_BodyMixedParserRuleCall_4_2_0_0ElementType() {
			return new IGrammarAwareElementType("Mixed_BodyMixedParserRuleCall_4_2_0_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getBodyMixedParserRuleCall_4_2_0_0());
		}
		public static IGrammarAwareElementType createMixed_EndKeyword_4_2_1ElementType() {
			return new IGrammarAwareElementType("Mixed_EndKeyword_4_2_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMixedAccess().getEndKeyword_4_2_1());
		}
	}

	public static final IGrammarAwareElementType Mixed_ELEMENT_TYPE = associate(MixedFactory.createMixedElementType());

	public static final IGrammarAwareElementType Mixed_Group_ELEMENT_TYPE = associate(MixedFactory.createMixed_GroupElementType());

	public static final IGrammarAwareElementType Mixed_LeftParenthesisKeyword_0_ELEMENT_TYPE = associate(MixedFactory.createMixed_LeftParenthesisKeyword_0ElementType());

	public static final IGrammarAwareElementType Mixed_Group_1_ELEMENT_TYPE = associate(MixedFactory.createMixed_Group_1ElementType());

	public static final IGrammarAwareElementType Mixed_UnassignedKeyword_1_0_ELEMENT_TYPE = associate(MixedFactory.createMixed_UnassignedKeyword_1_0ElementType());

	public static final IGrammarAwareElementType Mixed_Alternatives_1_1_ELEMENT_TYPE = associate(MixedFactory.createMixed_Alternatives_1_1ElementType());

	public static final IGrammarAwareElementType Mixed_IDTerminalRuleCall_1_1_0_ELEMENT_TYPE = associate(MixedFactory.createMixed_IDTerminalRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType Mixed_DatatypeParserRuleCall_1_1_1_ELEMENT_TYPE = associate(MixedFactory.createMixed_DatatypeParserRuleCall_1_1_1ElementType());

	public static final IGrammarAwareElementType Mixed_Alternatives_2_ELEMENT_TYPE = associate(MixedFactory.createMixed_Alternatives_2ElementType());

	public static final IGrammarAwareElementType Mixed_ActionAction_2_0_ELEMENT_TYPE = associate(MixedFactory.createMixed_ActionAction_2_0ElementType());

	public static final IGrammarAwareElementType Mixed_MixedParserRuleCall_2_1_ELEMENT_TYPE = associate(MixedFactory.createMixed_MixedParserRuleCall_2_1ElementType());

	public static final IGrammarAwareElementType Mixed_Alternatives_2_2_ELEMENT_TYPE = associate(MixedFactory.createMixed_Alternatives_2_2ElementType());

	public static final IGrammarAwareElementType Mixed_NameAssignment_2_2_0_ELEMENT_TYPE = associate(MixedFactory.createMixed_NameAssignment_2_2_0ElementType());

	public static final IGrammarAwareElementType Mixed_NameIDTerminalRuleCall_2_2_0_0_ELEMENT_TYPE = associate(MixedFactory.createMixed_NameIDTerminalRuleCall_2_2_0_0ElementType());

	public static final IGrammarAwareElementType Mixed_Group_2_2_1_ELEMENT_TYPE = associate(MixedFactory.createMixed_Group_2_2_1ElementType());

	public static final IGrammarAwareElementType Mixed_ChildKeyword_2_2_1_0_ELEMENT_TYPE = associate(MixedFactory.createMixed_ChildKeyword_2_2_1_0ElementType());

	public static final IGrammarAwareElementType Mixed_EobjAssignment_2_2_1_1_ELEMENT_TYPE = associate(MixedFactory.createMixed_EobjAssignment_2_2_1_1ElementType());

	public static final IGrammarAwareElementType Mixed_EobjMixedParserRuleCall_2_2_1_1_0_ELEMENT_TYPE = associate(MixedFactory.createMixed_EobjMixedParserRuleCall_2_2_1_1_0ElementType());

	public static final IGrammarAwareElementType Mixed_DatatypeAssignment_2_2_2_ELEMENT_TYPE = associate(MixedFactory.createMixed_DatatypeAssignment_2_2_2ElementType());

	public static final IGrammarAwareElementType Mixed_DatatypeDatatypeParserRuleCall_2_2_2_0_ELEMENT_TYPE = associate(MixedFactory.createMixed_DatatypeDatatypeParserRuleCall_2_2_2_0ElementType());

	public static final IGrammarAwareElementType Mixed_Group_2_2_3_ELEMENT_TYPE = associate(MixedFactory.createMixed_Group_2_2_3ElementType());

	public static final IGrammarAwareElementType Mixed_RefKeyword_2_2_3_0_ELEMENT_TYPE = associate(MixedFactory.createMixed_RefKeyword_2_2_3_0ElementType());

	public static final IGrammarAwareElementType Mixed_RefAssignment_2_2_3_1_ELEMENT_TYPE = associate(MixedFactory.createMixed_RefAssignment_2_2_3_1ElementType());

	public static final IGrammarAwareElementType Mixed_RefMixedCrossReference_2_2_3_1_0_ELEMENT_TYPE = associate(MixedFactory.createMixed_RefMixedCrossReference_2_2_3_1_0ElementType());

	public static final IGrammarAwareElementType Mixed_RefMixedIDTerminalRuleCall_2_2_3_1_0_1_ELEMENT_TYPE = associate(MixedFactory.createMixed_RefMixedIDTerminalRuleCall_2_2_3_1_0_1ElementType());

	public static final IGrammarAwareElementType Mixed_LitAssignment_2_2_4_ELEMENT_TYPE = associate(MixedFactory.createMixed_LitAssignment_2_2_4ElementType());

	public static final IGrammarAwareElementType Mixed_LitEnumEnumRuleCall_2_2_4_0_ELEMENT_TYPE = associate(MixedFactory.createMixed_LitEnumEnumRuleCall_2_2_4_0ElementType());

	public static final IGrammarAwareElementType Mixed_RightParenthesisKeyword_3_ELEMENT_TYPE = associate(MixedFactory.createMixed_RightParenthesisKeyword_3ElementType());

	public static final IGrammarAwareElementType Mixed_Group_4_ELEMENT_TYPE = associate(MixedFactory.createMixed_Group_4ElementType());

	public static final IGrammarAwareElementType Mixed_AssignedActionChildAction_4_0_ELEMENT_TYPE = associate(MixedFactory.createMixed_AssignedActionChildAction_4_0ElementType());

	public static final IGrammarAwareElementType Mixed_ActionKeyword_4_1_ELEMENT_TYPE = associate(MixedFactory.createMixed_ActionKeyword_4_1ElementType());

	public static final IGrammarAwareElementType Mixed_Group_4_2_ELEMENT_TYPE = associate(MixedFactory.createMixed_Group_4_2ElementType());

	public static final IGrammarAwareElementType Mixed_BodyAssignment_4_2_0_ELEMENT_TYPE = associate(MixedFactory.createMixed_BodyAssignment_4_2_0ElementType());

	public static final IGrammarAwareElementType Mixed_BodyMixedParserRuleCall_4_2_0_0_ELEMENT_TYPE = associate(MixedFactory.createMixed_BodyMixedParserRuleCall_4_2_0_0ElementType());

	public static final IGrammarAwareElementType Mixed_EndKeyword_4_2_1_ELEMENT_TYPE = associate(MixedFactory.createMixed_EndKeyword_4_2_1ElementType());

	private static class DatatypeFactory {
		public static IGrammarAwareElementType createDatatypeElementType() {
			return new IGrammarAwareElementType("Datatype_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeRule());
		}
		public static IGrammarAwareElementType createDatatype_GroupElementType() {
			return new IGrammarAwareElementType("Datatype_Group_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeAccess().getGroup());
		}
		public static IGrammarAwareElementType createDatatype_DatatypeKeyword_0ElementType() {
			return new IGrammarAwareElementType("Datatype_DatatypeKeyword_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeAccess().getDatatypeKeyword_0());
		}
		public static IGrammarAwareElementType createDatatype_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("Datatype_Alternatives_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createDatatype_DatatypeParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Datatype_DatatypeParserRuleCall_1_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeAccess().getDatatypeParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createDatatype_IDTerminalRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("Datatype_IDTerminalRuleCall_1_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDatatypeAccess().getIDTerminalRuleCall_1_1());
		}
	}

	public static final IGrammarAwareElementType Datatype_ELEMENT_TYPE = associate(DatatypeFactory.createDatatypeElementType());

	public static final IGrammarAwareElementType Datatype_Group_ELEMENT_TYPE = associate(DatatypeFactory.createDatatype_GroupElementType());

	public static final IGrammarAwareElementType Datatype_DatatypeKeyword_0_ELEMENT_TYPE = associate(DatatypeFactory.createDatatype_DatatypeKeyword_0ElementType());

	public static final IGrammarAwareElementType Datatype_Alternatives_1_ELEMENT_TYPE = associate(DatatypeFactory.createDatatype_Alternatives_1ElementType());

	public static final IGrammarAwareElementType Datatype_DatatypeParserRuleCall_1_0_ELEMENT_TYPE = associate(DatatypeFactory.createDatatype_DatatypeParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Datatype_IDTerminalRuleCall_1_1_ELEMENT_TYPE = associate(DatatypeFactory.createDatatype_IDTerminalRuleCall_1_1ElementType());

	private static class EnumFactory {
		public static IGrammarAwareElementType createEnumElementType() {
			return new IGrammarAwareElementType("Enum_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumRule());
		}
		public static IGrammarAwareElementType createEnum_AlternativesElementType() {
			return new IGrammarAwareElementType("Enum_Alternatives_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createEnum_Lit1EnumLiteralDeclaration_0ElementType() {
			return new IGrammarAwareElementType("Enum_Lit1EnumLiteralDeclaration_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumAccess().getLit1EnumLiteralDeclaration_0());
		}
		public static IGrammarAwareElementType createEnum_Lit1Lit1Keyword_0_0ElementType() {
			return new IGrammarAwareElementType("Enum_Lit1Lit1Keyword_0_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumAccess().getLit1Lit1Keyword_0_0());
		}
		public static IGrammarAwareElementType createEnum_Lit2EnumLiteralDeclaration_1ElementType() {
			return new IGrammarAwareElementType("Enum_Lit2EnumLiteralDeclaration_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumAccess().getLit2EnumLiteralDeclaration_1());
		}
		public static IGrammarAwareElementType createEnum_Lit2Lit2Keyword_1_0ElementType() {
			return new IGrammarAwareElementType("Enum_Lit2Lit2Keyword_1_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getEnumAccess().getLit2Lit2Keyword_1_0());
		}
	}

	public static final IGrammarAwareElementType Enum_ELEMENT_TYPE = associate(EnumFactory.createEnumElementType());

	public static final IGrammarAwareElementType Enum_Alternatives_ELEMENT_TYPE = associate(EnumFactory.createEnum_AlternativesElementType());

	public static final IGrammarAwareElementType Enum_Lit1EnumLiteralDeclaration_0_ELEMENT_TYPE = associate(EnumFactory.createEnum_Lit1EnumLiteralDeclaration_0ElementType());

	public static final IGrammarAwareElementType Enum_Lit1Lit1Keyword_0_0_ELEMENT_TYPE = associate(EnumFactory.createEnum_Lit1Lit1Keyword_0_0ElementType());

	public static final IGrammarAwareElementType Enum_Lit2EnumLiteralDeclaration_1_ELEMENT_TYPE = associate(EnumFactory.createEnum_Lit2EnumLiteralDeclaration_1ElementType());

	public static final IGrammarAwareElementType Enum_Lit2Lit2Keyword_1_0_ELEMENT_TYPE = associate(EnumFactory.createEnum_Lit2Lit2Keyword_1_0ElementType());

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

	public IGrammarAwareElementType getRoot_SimpleParserRuleCall_0ElementType() {
		return Root_SimpleParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_DelegationParserRuleCall_1ElementType() {
		return Root_DelegationParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_UnassignedParserRuleCall_2ElementType() {
		return Root_UnassignedParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_PrefixedUnassignedParserRuleCall_3ElementType() {
		return Root_PrefixedUnassignedParserRuleCall_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_Group_4ElementType() {
		return Root_Group_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_DigitFiveKeyword_4_0ElementType() {
		return Root_DigitFiveKeyword_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_ExpressionParserRuleCall_4_1ElementType() {
		return Root_ExpressionParserRuleCall_4_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_Group_5ElementType() {
		return Root_Group_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_DigitSixKeyword_5_0ElementType() {
		return Root_DigitSixKeyword_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_MixedParserRuleCall_5_1ElementType() {
		return Root_MixedParserRuleCall_5_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_Group_6ElementType() {
		return Root_Group_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_DigitSevenKeyword_6_0ElementType() {
		return Root_DigitSevenKeyword_6_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_MixedAssignment_6_1ElementType() {
		return Root_MixedAssignment_6_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_MixedMixedParserRuleCall_6_1_0ElementType() {
		return Root_MixedMixedParserRuleCall_6_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimpleElementType() {
		return Simple_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimple_GroupElementType() {
		return Simple_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimple_DigitOneKeyword_0ElementType() {
		return Simple_DigitOneKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimple_NameAssignment_1ElementType() {
		return Simple_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSimple_NameIDTerminalRuleCall_1_0ElementType() {
		return Simple_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDelegationElementType() {
		return Delegation_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDelegation_GroupElementType() {
		return Delegation_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDelegation_DigitTwoKeyword_0ElementType() {
		return Delegation_DigitTwoKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDelegation_DelegateAssignment_1ElementType() {
		return Delegation_DelegateAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDelegation_DelegateDelegateParserRuleCall_1_0ElementType() {
		return Delegation_DelegateDelegateParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassignedElementType() {
		return Unassigned_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassigned_GroupElementType() {
		return Unassigned_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassigned_DigitThreeKeyword_0ElementType() {
		return Unassigned_DigitThreeKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnassigned_DelegateParserRuleCall_1ElementType() {
		return Unassigned_DelegateParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrefixedUnassignedElementType() {
		return PrefixedUnassigned_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrefixedUnassigned_GroupElementType() {
		return PrefixedUnassigned_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrefixedUnassigned_DigitFourKeyword_0ElementType() {
		return PrefixedUnassigned_DigitFourKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrefixedUnassigned_DelegateAssignment_1ElementType() {
		return PrefixedUnassigned_DelegateAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrefixedUnassigned_DelegatePrefixedDelegateParserRuleCall_1_0ElementType() {
		return PrefixedUnassigned_DelegatePrefixedDelegateParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrefixedDelegateElementType() {
		return PrefixedDelegate_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrefixedDelegate_GroupElementType() {
		return PrefixedDelegate_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrefixedDelegate_PrefixKeyword_0ElementType() {
		return PrefixedDelegate_PrefixKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrefixedDelegate_DelegateParserRuleCall_1ElementType() {
		return PrefixedDelegate_DelegateParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDelegateElementType() {
		return Delegate_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDelegate_NameAssignmentElementType() {
		return Delegate_NameAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDelegate_NameIDTerminalRuleCall_0ElementType() {
		return Delegate_NameIDTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpressionElementType() {
		return Expression_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_GroupElementType() {
		return Expression_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_PrimaryParserRuleCall_0ElementType() {
		return Expression_PrimaryParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_Group_1ElementType() {
		return Expression_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_AddLeftAction_1_0ElementType() {
		return Expression_AddLeftAction_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_PlusSignKeyword_1_1ElementType() {
		return Expression_PlusSignKeyword_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_RightAssignment_1_2ElementType() {
		return Expression_RightAssignment_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExpression_RightPrimaryParserRuleCall_1_2_0ElementType() {
		return Expression_RightPrimaryParserRuleCall_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrimaryElementType() {
		return Primary_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrimary_AlternativesElementType() {
		return Primary_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrimary_Group_0ElementType() {
		return Primary_Group_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrimary_NamedAction_0_0ElementType() {
		return Primary_NamedAction_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrimary_NameAssignment_0_1ElementType() {
		return Primary_NameAssignment_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrimary_NameIDTerminalRuleCall_0_1_0ElementType() {
		return Primary_NameIDTerminalRuleCall_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPrimary_ParenthesizedParserRuleCall_1ElementType() {
		return Primary_ParenthesizedParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParenthesizedElementType() {
		return Parenthesized_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParenthesized_GroupElementType() {
		return Parenthesized_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParenthesized_LeftParenthesisKeyword_0ElementType() {
		return Parenthesized_LeftParenthesisKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParenthesized_ExpressionParserRuleCall_1ElementType() {
		return Parenthesized_ExpressionParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParenthesized_RightParenthesisKeyword_2ElementType() {
		return Parenthesized_RightParenthesisKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixedElementType() {
		return Mixed_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_GroupElementType() {
		return Mixed_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_LeftParenthesisKeyword_0ElementType() {
		return Mixed_LeftParenthesisKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_Group_1ElementType() {
		return Mixed_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_UnassignedKeyword_1_0ElementType() {
		return Mixed_UnassignedKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_Alternatives_1_1ElementType() {
		return Mixed_Alternatives_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_IDTerminalRuleCall_1_1_0ElementType() {
		return Mixed_IDTerminalRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_DatatypeParserRuleCall_1_1_1ElementType() {
		return Mixed_DatatypeParserRuleCall_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_Alternatives_2ElementType() {
		return Mixed_Alternatives_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_ActionAction_2_0ElementType() {
		return Mixed_ActionAction_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_MixedParserRuleCall_2_1ElementType() {
		return Mixed_MixedParserRuleCall_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_Alternatives_2_2ElementType() {
		return Mixed_Alternatives_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_NameAssignment_2_2_0ElementType() {
		return Mixed_NameAssignment_2_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_NameIDTerminalRuleCall_2_2_0_0ElementType() {
		return Mixed_NameIDTerminalRuleCall_2_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_Group_2_2_1ElementType() {
		return Mixed_Group_2_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_ChildKeyword_2_2_1_0ElementType() {
		return Mixed_ChildKeyword_2_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_EobjAssignment_2_2_1_1ElementType() {
		return Mixed_EobjAssignment_2_2_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_EobjMixedParserRuleCall_2_2_1_1_0ElementType() {
		return Mixed_EobjMixedParserRuleCall_2_2_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_DatatypeAssignment_2_2_2ElementType() {
		return Mixed_DatatypeAssignment_2_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_DatatypeDatatypeParserRuleCall_2_2_2_0ElementType() {
		return Mixed_DatatypeDatatypeParserRuleCall_2_2_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_Group_2_2_3ElementType() {
		return Mixed_Group_2_2_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_RefKeyword_2_2_3_0ElementType() {
		return Mixed_RefKeyword_2_2_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_RefAssignment_2_2_3_1ElementType() {
		return Mixed_RefAssignment_2_2_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_RefMixedCrossReference_2_2_3_1_0ElementType() {
		return Mixed_RefMixedCrossReference_2_2_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_RefMixedIDTerminalRuleCall_2_2_3_1_0_1ElementType() {
		return Mixed_RefMixedIDTerminalRuleCall_2_2_3_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_LitAssignment_2_2_4ElementType() {
		return Mixed_LitAssignment_2_2_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_LitEnumEnumRuleCall_2_2_4_0ElementType() {
		return Mixed_LitEnumEnumRuleCall_2_2_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_RightParenthesisKeyword_3ElementType() {
		return Mixed_RightParenthesisKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_Group_4ElementType() {
		return Mixed_Group_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_AssignedActionChildAction_4_0ElementType() {
		return Mixed_AssignedActionChildAction_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_ActionKeyword_4_1ElementType() {
		return Mixed_ActionKeyword_4_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_Group_4_2ElementType() {
		return Mixed_Group_4_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_BodyAssignment_4_2_0ElementType() {
		return Mixed_BodyAssignment_4_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_BodyMixedParserRuleCall_4_2_0_0ElementType() {
		return Mixed_BodyMixedParserRuleCall_4_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMixed_EndKeyword_4_2_1ElementType() {
		return Mixed_EndKeyword_4_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatypeElementType() {
		return Datatype_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatype_GroupElementType() {
		return Datatype_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatype_DatatypeKeyword_0ElementType() {
		return Datatype_DatatypeKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatype_Alternatives_1ElementType() {
		return Datatype_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatype_DatatypeParserRuleCall_1_0ElementType() {
		return Datatype_DatatypeParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getDatatype_IDTerminalRuleCall_1_1ElementType() {
		return Datatype_IDTerminalRuleCall_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnumElementType() {
		return Enum_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnum_AlternativesElementType() {
		return Enum_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnum_Lit1EnumLiteralDeclaration_0ElementType() {
		return Enum_Lit1EnumLiteralDeclaration_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnum_Lit1Lit1Keyword_0_0ElementType() {
		return Enum_Lit1Lit1Keyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnum_Lit2EnumLiteralDeclaration_1ElementType() {
		return Enum_Lit2EnumLiteralDeclaration_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getEnum_Lit2Lit2Keyword_1_0ElementType() {
		return Enum_Lit2Lit2Keyword_1_0_ELEMENT_TYPE;
	}

}
