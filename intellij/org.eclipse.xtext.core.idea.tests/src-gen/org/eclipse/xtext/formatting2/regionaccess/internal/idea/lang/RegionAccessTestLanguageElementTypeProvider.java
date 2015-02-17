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
		public static IGrammarAwareElementType createRoot_GroupElementType() {
			return new IGrammarAwareElementType("Root_Group_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getGroup());
		}
		public static IGrammarAwareElementType createRoot_TestKeyword_0ElementType() {
			return new IGrammarAwareElementType("Root_TestKeyword_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getTestKeyword_0());
		}
		public static IGrammarAwareElementType createRoot_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("Root_Alternatives_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createRoot_SimpleParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Root_SimpleParserRuleCall_1_0_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getSimpleParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createRoot_DelegationParserRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("Root_DelegationParserRuleCall_1_1_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getDelegationParserRuleCall_1_1());
		}
		public static IGrammarAwareElementType createRoot_UnassignedParserRuleCall_1_2ElementType() {
			return new IGrammarAwareElementType("Root_UnassignedParserRuleCall_1_2_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getUnassignedParserRuleCall_1_2());
		}
		public static IGrammarAwareElementType createRoot_PrefixedUnassignedParserRuleCall_1_3ElementType() {
			return new IGrammarAwareElementType("Root_PrefixedUnassignedParserRuleCall_1_3_ELEMENT_TYPE", RegionAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getPrefixedUnassignedParserRuleCall_1_3());
		}
	}

	public static final IGrammarAwareElementType Root_ELEMENT_TYPE = associate(RootFactory.createRootElementType());

	public static final IGrammarAwareElementType Root_Group_ELEMENT_TYPE = associate(RootFactory.createRoot_GroupElementType());

	public static final IGrammarAwareElementType Root_TestKeyword_0_ELEMENT_TYPE = associate(RootFactory.createRoot_TestKeyword_0ElementType());

	public static final IGrammarAwareElementType Root_Alternatives_1_ELEMENT_TYPE = associate(RootFactory.createRoot_Alternatives_1ElementType());

	public static final IGrammarAwareElementType Root_SimpleParserRuleCall_1_0_ELEMENT_TYPE = associate(RootFactory.createRoot_SimpleParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Root_DelegationParserRuleCall_1_1_ELEMENT_TYPE = associate(RootFactory.createRoot_DelegationParserRuleCall_1_1ElementType());

	public static final IGrammarAwareElementType Root_UnassignedParserRuleCall_1_2_ELEMENT_TYPE = associate(RootFactory.createRoot_UnassignedParserRuleCall_1_2ElementType());

	public static final IGrammarAwareElementType Root_PrefixedUnassignedParserRuleCall_1_3_ELEMENT_TYPE = associate(RootFactory.createRoot_PrefixedUnassignedParserRuleCall_1_3ElementType());

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

	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}
	
	public IGrammarAwareElementType getRootElementType() {
		return Root_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getRoot_GroupElementType() {
		return Root_Group_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getRoot_TestKeyword_0ElementType() {
		return Root_TestKeyword_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getRoot_Alternatives_1ElementType() {
		return Root_Alternatives_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getRoot_SimpleParserRuleCall_1_0ElementType() {
		return Root_SimpleParserRuleCall_1_0_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getRoot_DelegationParserRuleCall_1_1ElementType() {
		return Root_DelegationParserRuleCall_1_1_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getRoot_UnassignedParserRuleCall_1_2ElementType() {
		return Root_UnassignedParserRuleCall_1_2_ELEMENT_TYPE;
	}
	
	public IGrammarAwareElementType getRoot_PrefixedUnassignedParserRuleCall_1_3ElementType() {
		return Root_PrefixedUnassignedParserRuleCall_1_3_ELEMENT_TYPE;
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

}
