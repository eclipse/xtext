package org.eclipse.xtext.parser.unorderedGroups.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.psi.impl.ExUnorderedGroupsTestLanguageFileImpl;
import org.eclipse.xtext.parser.unorderedGroups.services.ExUnorderedGroupsTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class ExUnorderedGroupsTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<ExUnorderedGroupsTestLanguageFileImpl>>(ExUnorderedGroupsTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final ExUnorderedGroupsTestLanguageGrammarAccess GRAMMAR_ACCESS = ExUnorderedGroupsTestLanguageLanguage.INSTANCE.getInstance(ExUnorderedGroupsTestLanguageGrammarAccess.class);

	private static class DelegateModelFactory {
		public static IGrammarAwareElementType createDelegateModelElementType() {
			return new IGrammarAwareElementType("DelegateModel_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDelegateModelRule());
		}
		public static IGrammarAwareElementType createDelegateModel_ModelParserRuleCallElementType() {
			return new IGrammarAwareElementType("DelegateModel_ModelParserRuleCall_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDelegateModelAccess().getModelParserRuleCall());
		}
	}

	public static final IGrammarAwareElementType DelegateModel_ELEMENT_TYPE = associate(DelegateModelFactory.createDelegateModelElementType());

	public static final IGrammarAwareElementType DelegateModel_ModelParserRuleCall_ELEMENT_TYPE = associate(DelegateModelFactory.createDelegateModel_ModelParserRuleCallElementType());

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_GroupElementType() {
			return new IGrammarAwareElementType("Model_Group_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup());
		}
		public static IGrammarAwareElementType createModel_ModelAction_0ElementType() {
			return new IGrammarAwareElementType("Model_ModelAction_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getModelAction_0());
		}
		public static IGrammarAwareElementType createModel_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("Model_Alternatives_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createModel_Group_1_0ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1_0());
		}
		public static IGrammarAwareElementType createModel_DigitOneKeyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitOneKeyword_1_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitOneKeyword_1_0_0());
		}
		public static IGrammarAwareElementType createModel_UnorderedGroup_1_0_1ElementType() {
			return new IGrammarAwareElementType("Model_UnorderedGroup_1_0_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getUnorderedGroup_1_0_1());
		}
		public static IGrammarAwareElementType createModel_FirstAssignment_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAssignment_1_0_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAssignment_1_0_1_0());
		}
		public static IGrammarAwareElementType createModel_FirstAKeyword_1_0_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAKeyword_1_0_1_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAKeyword_1_0_1_0_0());
		}
		public static IGrammarAwareElementType createModel_SecondAssignment_1_0_1_1ElementType() {
			return new IGrammarAwareElementType("Model_SecondAssignment_1_0_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAssignment_1_0_1_1());
		}
		public static IGrammarAwareElementType createModel_SecondBKeyword_1_0_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_SecondBKeyword_1_0_1_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondBKeyword_1_0_1_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_1_1ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createModel_DigitTwoKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitTwoKeyword_1_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitTwoKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createModel_UnorderedGroup_1_1_1ElementType() {
			return new IGrammarAwareElementType("Model_UnorderedGroup_1_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getUnorderedGroup_1_1_1());
		}
		public static IGrammarAwareElementType createModel_FirstAssignment_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAssignment_1_1_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAssignment_1_1_1_0());
		}
		public static IGrammarAwareElementType createModel_FirstAKeyword_1_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAKeyword_1_1_1_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAKeyword_1_1_1_0_0());
		}
		public static IGrammarAwareElementType createModel_SecondAssignment_1_1_1_1ElementType() {
			return new IGrammarAwareElementType("Model_SecondAssignment_1_1_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAssignment_1_1_1_1());
		}
		public static IGrammarAwareElementType createModel_SecondBKeyword_1_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_SecondBKeyword_1_1_1_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondBKeyword_1_1_1_1_0());
		}
		public static IGrammarAwareElementType createModel_ThirdAssignment_1_1_1_2ElementType() {
			return new IGrammarAwareElementType("Model_ThirdAssignment_1_1_1_2_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getThirdAssignment_1_1_1_2());
		}
		public static IGrammarAwareElementType createModel_ThirdCKeyword_1_1_1_2_0ElementType() {
			return new IGrammarAwareElementType("Model_ThirdCKeyword_1_1_1_2_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getThirdCKeyword_1_1_1_2_0());
		}
		public static IGrammarAwareElementType createModel_ForthAssignment_1_1_1_3ElementType() {
			return new IGrammarAwareElementType("Model_ForthAssignment_1_1_1_3_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getForthAssignment_1_1_1_3());
		}
		public static IGrammarAwareElementType createModel_ForthDKeyword_1_1_1_3_0ElementType() {
			return new IGrammarAwareElementType("Model_ForthDKeyword_1_1_1_3_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getForthDKeyword_1_1_1_3_0());
		}
		public static IGrammarAwareElementType createModel_Group_1_2ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_2_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1_2());
		}
		public static IGrammarAwareElementType createModel_DigitThreeKeyword_1_2_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitThreeKeyword_1_2_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitThreeKeyword_1_2_0());
		}
		public static IGrammarAwareElementType createModel_UnorderedGroup_1_2_1ElementType() {
			return new IGrammarAwareElementType("Model_UnorderedGroup_1_2_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getUnorderedGroup_1_2_1());
		}
		public static IGrammarAwareElementType createModel_FirstAssignment_1_2_1_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAssignment_1_2_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAssignment_1_2_1_0());
		}
		public static IGrammarAwareElementType createModel_FirstAKeyword_1_2_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAKeyword_1_2_1_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAKeyword_1_2_1_0_0());
		}
		public static IGrammarAwareElementType createModel_SecondAssignment_1_2_1_1ElementType() {
			return new IGrammarAwareElementType("Model_SecondAssignment_1_2_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAssignment_1_2_1_1());
		}
		public static IGrammarAwareElementType createModel_SecondBKeyword_1_2_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_SecondBKeyword_1_2_1_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondBKeyword_1_2_1_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_1_3ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_3_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1_3());
		}
		public static IGrammarAwareElementType createModel_DigitFourKeyword_1_3_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitFourKeyword_1_3_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitFourKeyword_1_3_0());
		}
		public static IGrammarAwareElementType createModel_UnorderedGroup_1_3_1ElementType() {
			return new IGrammarAwareElementType("Model_UnorderedGroup_1_3_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getUnorderedGroup_1_3_1());
		}
		public static IGrammarAwareElementType createModel_FirstAssignment_1_3_1_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAssignment_1_3_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAssignment_1_3_1_0());
		}
		public static IGrammarAwareElementType createModel_FirstAKeyword_1_3_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAKeyword_1_3_1_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAKeyword_1_3_1_0_0());
		}
		public static IGrammarAwareElementType createModel_SecondAssignment_1_3_1_1ElementType() {
			return new IGrammarAwareElementType("Model_SecondAssignment_1_3_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAssignment_1_3_1_1());
		}
		public static IGrammarAwareElementType createModel_SecondBKeyword_1_3_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_SecondBKeyword_1_3_1_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondBKeyword_1_3_1_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_1_4ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_4_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1_4());
		}
		public static IGrammarAwareElementType createModel_DigitFiveKeyword_1_4_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitFiveKeyword_1_4_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitFiveKeyword_1_4_0());
		}
		public static IGrammarAwareElementType createModel_UnorderedGroup_1_4_1ElementType() {
			return new IGrammarAwareElementType("Model_UnorderedGroup_1_4_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getUnorderedGroup_1_4_1());
		}
		public static IGrammarAwareElementType createModel_FirstAssignment_1_4_1_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAssignment_1_4_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAssignment_1_4_1_0());
		}
		public static IGrammarAwareElementType createModel_FirstAKeyword_1_4_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAKeyword_1_4_1_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAKeyword_1_4_1_0_0());
		}
		public static IGrammarAwareElementType createModel_SecondAssignment_1_4_1_1ElementType() {
			return new IGrammarAwareElementType("Model_SecondAssignment_1_4_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAssignment_1_4_1_1());
		}
		public static IGrammarAwareElementType createModel_SecondBKeyword_1_4_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_SecondBKeyword_1_4_1_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondBKeyword_1_4_1_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_1_5ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_5_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1_5());
		}
		public static IGrammarAwareElementType createModel_DigitSixKeyword_1_5_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitSixKeyword_1_5_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitSixKeyword_1_5_0());
		}
		public static IGrammarAwareElementType createModel_UnorderedGroup_1_5_1ElementType() {
			return new IGrammarAwareElementType("Model_UnorderedGroup_1_5_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getUnorderedGroup_1_5_1());
		}
		public static IGrammarAwareElementType createModel_FirstAsListAssignment_1_5_1_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAsListAssignment_1_5_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAsListAssignment_1_5_1_0());
		}
		public static IGrammarAwareElementType createModel_FirstAsListAKeyword_1_5_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAsListAKeyword_1_5_1_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAsListAKeyword_1_5_1_0_0());
		}
		public static IGrammarAwareElementType createModel_SecondAsListAssignment_1_5_1_1ElementType() {
			return new IGrammarAwareElementType("Model_SecondAsListAssignment_1_5_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAsListAssignment_1_5_1_1());
		}
		public static IGrammarAwareElementType createModel_SecondAsListBKeyword_1_5_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_SecondAsListBKeyword_1_5_1_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAsListBKeyword_1_5_1_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_1_6ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_6_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1_6());
		}
		public static IGrammarAwareElementType createModel_DigitSevenKeyword_1_6_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitSevenKeyword_1_6_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitSevenKeyword_1_6_0());
		}
		public static IGrammarAwareElementType createModel_UnorderedGroup_1_6_1ElementType() {
			return new IGrammarAwareElementType("Model_UnorderedGroup_1_6_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getUnorderedGroup_1_6_1());
		}
		public static IGrammarAwareElementType createModel_FirstAsListAssignment_1_6_1_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAsListAssignment_1_6_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAsListAssignment_1_6_1_0());
		}
		public static IGrammarAwareElementType createModel_FirstAsListAKeyword_1_6_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAsListAKeyword_1_6_1_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAsListAKeyword_1_6_1_0_0());
		}
		public static IGrammarAwareElementType createModel_SecondAsListAssignment_1_6_1_1ElementType() {
			return new IGrammarAwareElementType("Model_SecondAsListAssignment_1_6_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAsListAssignment_1_6_1_1());
		}
		public static IGrammarAwareElementType createModel_SecondAsListBKeyword_1_6_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_SecondAsListBKeyword_1_6_1_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAsListBKeyword_1_6_1_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_1_7ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_7_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1_7());
		}
		public static IGrammarAwareElementType createModel_DigitEightKeyword_1_7_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitEightKeyword_1_7_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitEightKeyword_1_7_0());
		}
		public static IGrammarAwareElementType createModel_UnorderedGroup_1_7_1ElementType() {
			return new IGrammarAwareElementType("Model_UnorderedGroup_1_7_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getUnorderedGroup_1_7_1());
		}
		public static IGrammarAwareElementType createModel_Group_1_7_1_0ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_7_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1_7_1_0());
		}
		public static IGrammarAwareElementType createModel_AKeyword_1_7_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_AKeyword_1_7_1_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAKeyword_1_7_1_0_0());
		}
		public static IGrammarAwareElementType createModel_BKeyword_1_7_1_0_1ElementType() {
			return new IGrammarAwareElementType("Model_BKeyword_1_7_1_0_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getBKeyword_1_7_1_0_1());
		}
		public static IGrammarAwareElementType createModel_FirstAssignment_1_7_1_0_2ElementType() {
			return new IGrammarAwareElementType("Model_FirstAssignment_1_7_1_0_2_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAssignment_1_7_1_0_2());
		}
		public static IGrammarAwareElementType createModel_FirstCKeyword_1_7_1_0_2_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstCKeyword_1_7_1_0_2_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstCKeyword_1_7_1_0_2_0());
		}
		public static IGrammarAwareElementType createModel_Group_1_7_1_1ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_7_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1_7_1_1());
		}
		public static IGrammarAwareElementType createModel_AKeyword_1_7_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_AKeyword_1_7_1_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAKeyword_1_7_1_1_0());
		}
		public static IGrammarAwareElementType createModel_BKeyword_1_7_1_1_1ElementType() {
			return new IGrammarAwareElementType("Model_BKeyword_1_7_1_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getBKeyword_1_7_1_1_1());
		}
		public static IGrammarAwareElementType createModel_SecondAssignment_1_7_1_1_2ElementType() {
			return new IGrammarAwareElementType("Model_SecondAssignment_1_7_1_1_2_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAssignment_1_7_1_1_2());
		}
		public static IGrammarAwareElementType createModel_SecondDKeyword_1_7_1_1_2_0ElementType() {
			return new IGrammarAwareElementType("Model_SecondDKeyword_1_7_1_1_2_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondDKeyword_1_7_1_1_2_0());
		}
		public static IGrammarAwareElementType createModel_Group_1_8ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_8_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1_8());
		}
		public static IGrammarAwareElementType createModel_DigitNineKeyword_1_8_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitNineKeyword_1_8_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitNineKeyword_1_8_0());
		}
		public static IGrammarAwareElementType createModel_UnorderedGroup_1_8_1ElementType() {
			return new IGrammarAwareElementType("Model_UnorderedGroup_1_8_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getUnorderedGroup_1_8_1());
		}
		public static IGrammarAwareElementType createModel_FirstAsListAssignment_1_8_1_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAsListAssignment_1_8_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAsListAssignment_1_8_1_0());
		}
		public static IGrammarAwareElementType createModel_FirstAsListAKeyword_1_8_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAsListAKeyword_1_8_1_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAsListAKeyword_1_8_1_0_0());
		}
		public static IGrammarAwareElementType createModel_SecondAsListAssignment_1_8_1_1ElementType() {
			return new IGrammarAwareElementType("Model_SecondAsListAssignment_1_8_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAsListAssignment_1_8_1_1());
		}
		public static IGrammarAwareElementType createModel_SecondAsListBKeyword_1_8_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_SecondAsListBKeyword_1_8_1_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAsListBKeyword_1_8_1_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_1_9ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_9_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1_9());
		}
		public static IGrammarAwareElementType createModel_DigitOneDigitZeroKeyword_1_9_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitOneDigitZeroKeyword_1_9_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitOneDigitZeroKeyword_1_9_0());
		}
		public static IGrammarAwareElementType createModel_UnorderedGroup_1_9_1ElementType() {
			return new IGrammarAwareElementType("Model_UnorderedGroup_1_9_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getUnorderedGroup_1_9_1());
		}
		public static IGrammarAwareElementType createModel_FirstAsListAssignment_1_9_1_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAsListAssignment_1_9_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAsListAssignment_1_9_1_0());
		}
		public static IGrammarAwareElementType createModel_FirstAsListAKeyword_1_9_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAsListAKeyword_1_9_1_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAsListAKeyword_1_9_1_0_0());
		}
		public static IGrammarAwareElementType createModel_SecondAsListAssignment_1_9_1_1ElementType() {
			return new IGrammarAwareElementType("Model_SecondAsListAssignment_1_9_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAsListAssignment_1_9_1_1());
		}
		public static IGrammarAwareElementType createModel_SecondAsListBKeyword_1_9_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_SecondAsListBKeyword_1_9_1_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAsListBKeyword_1_9_1_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_1_10ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_10_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1_10());
		}
		public static IGrammarAwareElementType createModel_DigitOneDigitOneKeyword_1_10_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitOneDigitOneKeyword_1_10_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitOneDigitOneKeyword_1_10_0());
		}
		public static IGrammarAwareElementType createModel_UnorderedGroup_1_10_1ElementType() {
			return new IGrammarAwareElementType("Model_UnorderedGroup_1_10_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getUnorderedGroup_1_10_1());
		}
		public static IGrammarAwareElementType createModel_FirstAssignment_1_10_1_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAssignment_1_10_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAssignment_1_10_1_0());
		}
		public static IGrammarAwareElementType createModel_FirstAKeyword_1_10_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAKeyword_1_10_1_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAKeyword_1_10_1_0_0());
		}
		public static IGrammarAwareElementType createModel_SecondAssignment_1_10_1_1ElementType() {
			return new IGrammarAwareElementType("Model_SecondAssignment_1_10_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAssignment_1_10_1_1());
		}
		public static IGrammarAwareElementType createModel_SecondBKeyword_1_10_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_SecondBKeyword_1_10_1_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondBKeyword_1_10_1_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_1_11ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_11_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1_11());
		}
		public static IGrammarAwareElementType createModel_DigitOneDigitTwoKeyword_1_11_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitOneDigitTwoKeyword_1_11_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitOneDigitTwoKeyword_1_11_0());
		}
		public static IGrammarAwareElementType createModel_UnorderedGroup_1_11_1ElementType() {
			return new IGrammarAwareElementType("Model_UnorderedGroup_1_11_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getUnorderedGroup_1_11_1());
		}
		public static IGrammarAwareElementType createModel_FirstAsListAssignment_1_11_1_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAsListAssignment_1_11_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAsListAssignment_1_11_1_0());
		}
		public static IGrammarAwareElementType createModel_FirstAsListAKeyword_1_11_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAsListAKeyword_1_11_1_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAsListAKeyword_1_11_1_0_0());
		}
		public static IGrammarAwareElementType createModel_SecondAsListAssignment_1_11_1_1ElementType() {
			return new IGrammarAwareElementType("Model_SecondAsListAssignment_1_11_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAsListAssignment_1_11_1_1());
		}
		public static IGrammarAwareElementType createModel_SecondAsListBKeyword_1_11_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_SecondAsListBKeyword_1_11_1_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAsListBKeyword_1_11_1_1_0());
		}
		public static IGrammarAwareElementType createModel_UnorderedGroup_1_11_2ElementType() {
			return new IGrammarAwareElementType("Model_UnorderedGroup_1_11_2_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getUnorderedGroup_1_11_2());
		}
		public static IGrammarAwareElementType createModel_FirstAsListAssignment_1_11_2_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAsListAssignment_1_11_2_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAsListAssignment_1_11_2_0());
		}
		public static IGrammarAwareElementType createModel_FirstAsListAKeyword_1_11_2_0_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAsListAKeyword_1_11_2_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAsListAKeyword_1_11_2_0_0());
		}
		public static IGrammarAwareElementType createModel_SecondAsListAssignment_1_11_2_1ElementType() {
			return new IGrammarAwareElementType("Model_SecondAsListAssignment_1_11_2_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAsListAssignment_1_11_2_1());
		}
		public static IGrammarAwareElementType createModel_SecondAsListBKeyword_1_11_2_1_0ElementType() {
			return new IGrammarAwareElementType("Model_SecondAsListBKeyword_1_11_2_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAsListBKeyword_1_11_2_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_1_12ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_12_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1_12());
		}
		public static IGrammarAwareElementType createModel_DigitOneDigitThreeKeyword_1_12_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitOneDigitThreeKeyword_1_12_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitOneDigitThreeKeyword_1_12_0());
		}
		public static IGrammarAwareElementType createModel_UnorderedGroup_1_12_1ElementType() {
			return new IGrammarAwareElementType("Model_UnorderedGroup_1_12_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getUnorderedGroup_1_12_1());
		}
		public static IGrammarAwareElementType createModel_FirstAsListAssignment_1_12_1_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAsListAssignment_1_12_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAsListAssignment_1_12_1_0());
		}
		public static IGrammarAwareElementType createModel_FirstAsListAKeyword_1_12_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAsListAKeyword_1_12_1_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAsListAKeyword_1_12_1_0_0());
		}
		public static IGrammarAwareElementType createModel_SecondAsListAssignment_1_12_1_1ElementType() {
			return new IGrammarAwareElementType("Model_SecondAsListAssignment_1_12_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAsListAssignment_1_12_1_1());
		}
		public static IGrammarAwareElementType createModel_SecondAsListBKeyword_1_12_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_SecondAsListBKeyword_1_12_1_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAsListBKeyword_1_12_1_1_0());
		}
		public static IGrammarAwareElementType createModel_FirstAsListAssignment_1_12_2ElementType() {
			return new IGrammarAwareElementType("Model_FirstAsListAssignment_1_12_2_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAsListAssignment_1_12_2());
		}
		public static IGrammarAwareElementType createModel_FirstAsListAKeyword_1_12_2_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAsListAKeyword_1_12_2_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAsListAKeyword_1_12_2_0());
		}
		public static IGrammarAwareElementType createModel_SecondAsListAssignment_1_12_3ElementType() {
			return new IGrammarAwareElementType("Model_SecondAsListAssignment_1_12_3_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAsListAssignment_1_12_3());
		}
		public static IGrammarAwareElementType createModel_SecondAsListBKeyword_1_12_3_0ElementType() {
			return new IGrammarAwareElementType("Model_SecondAsListBKeyword_1_12_3_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAsListBKeyword_1_12_3_0());
		}
		public static IGrammarAwareElementType createModel_Group_1_13ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_13_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1_13());
		}
		public static IGrammarAwareElementType createModel_DigitOneDigitFourKeyword_1_13_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitOneDigitFourKeyword_1_13_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitOneDigitFourKeyword_1_13_0());
		}
		public static IGrammarAwareElementType createModel_UnorderedGroup_1_13_1ElementType() {
			return new IGrammarAwareElementType("Model_UnorderedGroup_1_13_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getUnorderedGroup_1_13_1());
		}
		public static IGrammarAwareElementType createModel_UnorderedGroup_1_13_1_0ElementType() {
			return new IGrammarAwareElementType("Model_UnorderedGroup_1_13_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getUnorderedGroup_1_13_1_0());
		}
		public static IGrammarAwareElementType createModel_FirstAsListAssignment_1_13_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAsListAssignment_1_13_1_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAsListAssignment_1_13_1_0_0());
		}
		public static IGrammarAwareElementType createModel_FirstAsListAKeyword_1_13_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAsListAKeyword_1_13_1_0_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAsListAKeyword_1_13_1_0_0_0());
		}
		public static IGrammarAwareElementType createModel_SecondAsListAssignment_1_13_1_0_1ElementType() {
			return new IGrammarAwareElementType("Model_SecondAsListAssignment_1_13_1_0_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAsListAssignment_1_13_1_0_1());
		}
		public static IGrammarAwareElementType createModel_SecondAsListBKeyword_1_13_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("Model_SecondAsListBKeyword_1_13_1_0_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAsListBKeyword_1_13_1_0_1_0());
		}
		public static IGrammarAwareElementType createModel_UnorderedGroup_1_13_1_1ElementType() {
			return new IGrammarAwareElementType("Model_UnorderedGroup_1_13_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getUnorderedGroup_1_13_1_1());
		}
		public static IGrammarAwareElementType createModel_ThirdAsListAssignment_1_13_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ThirdAsListAssignment_1_13_1_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getThirdAsListAssignment_1_13_1_1_0());
		}
		public static IGrammarAwareElementType createModel_ThirdAsListCKeyword_1_13_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("Model_ThirdAsListCKeyword_1_13_1_1_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getThirdAsListCKeyword_1_13_1_1_0_0());
		}
		public static IGrammarAwareElementType createModel_ForthAsListAssignment_1_13_1_1_1ElementType() {
			return new IGrammarAwareElementType("Model_ForthAsListAssignment_1_13_1_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getForthAsListAssignment_1_13_1_1_1());
		}
		public static IGrammarAwareElementType createModel_ForthAsListDKeyword_1_13_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ForthAsListDKeyword_1_13_1_1_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getForthAsListDKeyword_1_13_1_1_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_1_14ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_14_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1_14());
		}
		public static IGrammarAwareElementType createModel_DatatypesKeyword_1_14_0ElementType() {
			return new IGrammarAwareElementType("Model_DatatypesKeyword_1_14_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDatatypesKeyword_1_14_0());
		}
		public static IGrammarAwareElementType createModel_ValueAssignment_1_14_1ElementType() {
			return new IGrammarAwareElementType("Model_ValueAssignment_1_14_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueAssignment_1_14_1());
		}
		public static IGrammarAwareElementType createModel_ValueUnorderedDatatypeParserRuleCall_1_14_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ValueUnorderedDatatypeParserRuleCall_1_14_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueUnorderedDatatypeParserRuleCall_1_14_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_1_15ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_15_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1_15());
		}
		public static IGrammarAwareElementType createModel_SerializationKeyword_1_15_0ElementType() {
			return new IGrammarAwareElementType("Model_SerializationKeyword_1_15_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSerializationKeyword_1_15_0());
		}
		public static IGrammarAwareElementType createModel_SerializedAssignment_1_15_1ElementType() {
			return new IGrammarAwareElementType("Model_SerializedAssignment_1_15_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSerializedAssignment_1_15_1());
		}
		public static IGrammarAwareElementType createModel_SerializedUnorderedSerializationParserRuleCall_1_15_1_0ElementType() {
			return new IGrammarAwareElementType("Model_SerializedUnorderedSerializationParserRuleCall_1_15_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSerializedUnorderedSerializationParserRuleCall_1_15_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_1_16ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_16_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1_16());
		}
		public static IGrammarAwareElementType createModel_Bug302585Keyword_1_16_0ElementType() {
			return new IGrammarAwareElementType("Model_Bug302585Keyword_1_16_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getBug302585Keyword_1_16_0());
		}
		public static IGrammarAwareElementType createModel_NestedModelAssignment_1_16_1ElementType() {
			return new IGrammarAwareElementType("Model_NestedModelAssignment_1_16_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNestedModelAssignment_1_16_1());
		}
		public static IGrammarAwareElementType createModel_NestedModelNestedModelParserRuleCall_1_16_1_0ElementType() {
			return new IGrammarAwareElementType("Model_NestedModelNestedModelParserRuleCall_1_16_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNestedModelNestedModelParserRuleCall_1_16_1_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Group_ELEMENT_TYPE = associate(ModelFactory.createModel_GroupElementType());

	public static final IGrammarAwareElementType Model_ModelAction_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ModelAction_0ElementType());

	public static final IGrammarAwareElementType Model_Alternatives_1_ELEMENT_TYPE = associate(ModelFactory.createModel_Alternatives_1ElementType());

	public static final IGrammarAwareElementType Model_Group_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1_0ElementType());

	public static final IGrammarAwareElementType Model_DigitOneKeyword_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitOneKeyword_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_UnorderedGroup_1_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_UnorderedGroup_1_0_1ElementType());

	public static final IGrammarAwareElementType Model_FirstAssignment_1_0_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAssignment_1_0_1_0ElementType());

	public static final IGrammarAwareElementType Model_FirstAKeyword_1_0_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAKeyword_1_0_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_SecondAssignment_1_0_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAssignment_1_0_1_1ElementType());

	public static final IGrammarAwareElementType Model_SecondBKeyword_1_0_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondBKeyword_1_0_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1_1ElementType());

	public static final IGrammarAwareElementType Model_DigitTwoKeyword_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitTwoKeyword_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_UnorderedGroup_1_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_UnorderedGroup_1_1_1ElementType());

	public static final IGrammarAwareElementType Model_FirstAssignment_1_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAssignment_1_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_FirstAKeyword_1_1_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAKeyword_1_1_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_SecondAssignment_1_1_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAssignment_1_1_1_1ElementType());

	public static final IGrammarAwareElementType Model_SecondBKeyword_1_1_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondBKeyword_1_1_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_ThirdAssignment_1_1_1_2_ELEMENT_TYPE = associate(ModelFactory.createModel_ThirdAssignment_1_1_1_2ElementType());

	public static final IGrammarAwareElementType Model_ThirdCKeyword_1_1_1_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ThirdCKeyword_1_1_1_2_0ElementType());

	public static final IGrammarAwareElementType Model_ForthAssignment_1_1_1_3_ELEMENT_TYPE = associate(ModelFactory.createModel_ForthAssignment_1_1_1_3ElementType());

	public static final IGrammarAwareElementType Model_ForthDKeyword_1_1_1_3_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ForthDKeyword_1_1_1_3_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_2_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1_2ElementType());

	public static final IGrammarAwareElementType Model_DigitThreeKeyword_1_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitThreeKeyword_1_2_0ElementType());

	public static final IGrammarAwareElementType Model_UnorderedGroup_1_2_1_ELEMENT_TYPE = associate(ModelFactory.createModel_UnorderedGroup_1_2_1ElementType());

	public static final IGrammarAwareElementType Model_FirstAssignment_1_2_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAssignment_1_2_1_0ElementType());

	public static final IGrammarAwareElementType Model_FirstAKeyword_1_2_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAKeyword_1_2_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_SecondAssignment_1_2_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAssignment_1_2_1_1ElementType());

	public static final IGrammarAwareElementType Model_SecondBKeyword_1_2_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondBKeyword_1_2_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_3_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1_3ElementType());

	public static final IGrammarAwareElementType Model_DigitFourKeyword_1_3_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitFourKeyword_1_3_0ElementType());

	public static final IGrammarAwareElementType Model_UnorderedGroup_1_3_1_ELEMENT_TYPE = associate(ModelFactory.createModel_UnorderedGroup_1_3_1ElementType());

	public static final IGrammarAwareElementType Model_FirstAssignment_1_3_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAssignment_1_3_1_0ElementType());

	public static final IGrammarAwareElementType Model_FirstAKeyword_1_3_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAKeyword_1_3_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_SecondAssignment_1_3_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAssignment_1_3_1_1ElementType());

	public static final IGrammarAwareElementType Model_SecondBKeyword_1_3_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondBKeyword_1_3_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_4_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1_4ElementType());

	public static final IGrammarAwareElementType Model_DigitFiveKeyword_1_4_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitFiveKeyword_1_4_0ElementType());

	public static final IGrammarAwareElementType Model_UnorderedGroup_1_4_1_ELEMENT_TYPE = associate(ModelFactory.createModel_UnorderedGroup_1_4_1ElementType());

	public static final IGrammarAwareElementType Model_FirstAssignment_1_4_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAssignment_1_4_1_0ElementType());

	public static final IGrammarAwareElementType Model_FirstAKeyword_1_4_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAKeyword_1_4_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_SecondAssignment_1_4_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAssignment_1_4_1_1ElementType());

	public static final IGrammarAwareElementType Model_SecondBKeyword_1_4_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondBKeyword_1_4_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_5_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1_5ElementType());

	public static final IGrammarAwareElementType Model_DigitSixKeyword_1_5_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitSixKeyword_1_5_0ElementType());

	public static final IGrammarAwareElementType Model_UnorderedGroup_1_5_1_ELEMENT_TYPE = associate(ModelFactory.createModel_UnorderedGroup_1_5_1ElementType());

	public static final IGrammarAwareElementType Model_FirstAsListAssignment_1_5_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAsListAssignment_1_5_1_0ElementType());

	public static final IGrammarAwareElementType Model_FirstAsListAKeyword_1_5_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAsListAKeyword_1_5_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_SecondAsListAssignment_1_5_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAsListAssignment_1_5_1_1ElementType());

	public static final IGrammarAwareElementType Model_SecondAsListBKeyword_1_5_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAsListBKeyword_1_5_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_6_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1_6ElementType());

	public static final IGrammarAwareElementType Model_DigitSevenKeyword_1_6_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitSevenKeyword_1_6_0ElementType());

	public static final IGrammarAwareElementType Model_UnorderedGroup_1_6_1_ELEMENT_TYPE = associate(ModelFactory.createModel_UnorderedGroup_1_6_1ElementType());

	public static final IGrammarAwareElementType Model_FirstAsListAssignment_1_6_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAsListAssignment_1_6_1_0ElementType());

	public static final IGrammarAwareElementType Model_FirstAsListAKeyword_1_6_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAsListAKeyword_1_6_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_SecondAsListAssignment_1_6_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAsListAssignment_1_6_1_1ElementType());

	public static final IGrammarAwareElementType Model_SecondAsListBKeyword_1_6_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAsListBKeyword_1_6_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_7_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1_7ElementType());

	public static final IGrammarAwareElementType Model_DigitEightKeyword_1_7_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitEightKeyword_1_7_0ElementType());

	public static final IGrammarAwareElementType Model_UnorderedGroup_1_7_1_ELEMENT_TYPE = associate(ModelFactory.createModel_UnorderedGroup_1_7_1ElementType());

	public static final IGrammarAwareElementType Model_Group_1_7_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1_7_1_0ElementType());

	public static final IGrammarAwareElementType Model_AKeyword_1_7_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_AKeyword_1_7_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_BKeyword_1_7_1_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_BKeyword_1_7_1_0_1ElementType());

	public static final IGrammarAwareElementType Model_FirstAssignment_1_7_1_0_2_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAssignment_1_7_1_0_2ElementType());

	public static final IGrammarAwareElementType Model_FirstCKeyword_1_7_1_0_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstCKeyword_1_7_1_0_2_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_7_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1_7_1_1ElementType());

	public static final IGrammarAwareElementType Model_AKeyword_1_7_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_AKeyword_1_7_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_BKeyword_1_7_1_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_BKeyword_1_7_1_1_1ElementType());

	public static final IGrammarAwareElementType Model_SecondAssignment_1_7_1_1_2_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAssignment_1_7_1_1_2ElementType());

	public static final IGrammarAwareElementType Model_SecondDKeyword_1_7_1_1_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondDKeyword_1_7_1_1_2_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_8_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1_8ElementType());

	public static final IGrammarAwareElementType Model_DigitNineKeyword_1_8_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitNineKeyword_1_8_0ElementType());

	public static final IGrammarAwareElementType Model_UnorderedGroup_1_8_1_ELEMENT_TYPE = associate(ModelFactory.createModel_UnorderedGroup_1_8_1ElementType());

	public static final IGrammarAwareElementType Model_FirstAsListAssignment_1_8_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAsListAssignment_1_8_1_0ElementType());

	public static final IGrammarAwareElementType Model_FirstAsListAKeyword_1_8_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAsListAKeyword_1_8_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_SecondAsListAssignment_1_8_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAsListAssignment_1_8_1_1ElementType());

	public static final IGrammarAwareElementType Model_SecondAsListBKeyword_1_8_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAsListBKeyword_1_8_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_9_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1_9ElementType());

	public static final IGrammarAwareElementType Model_DigitOneDigitZeroKeyword_1_9_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitOneDigitZeroKeyword_1_9_0ElementType());

	public static final IGrammarAwareElementType Model_UnorderedGroup_1_9_1_ELEMENT_TYPE = associate(ModelFactory.createModel_UnorderedGroup_1_9_1ElementType());

	public static final IGrammarAwareElementType Model_FirstAsListAssignment_1_9_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAsListAssignment_1_9_1_0ElementType());

	public static final IGrammarAwareElementType Model_FirstAsListAKeyword_1_9_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAsListAKeyword_1_9_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_SecondAsListAssignment_1_9_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAsListAssignment_1_9_1_1ElementType());

	public static final IGrammarAwareElementType Model_SecondAsListBKeyword_1_9_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAsListBKeyword_1_9_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_10_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1_10ElementType());

	public static final IGrammarAwareElementType Model_DigitOneDigitOneKeyword_1_10_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitOneDigitOneKeyword_1_10_0ElementType());

	public static final IGrammarAwareElementType Model_UnorderedGroup_1_10_1_ELEMENT_TYPE = associate(ModelFactory.createModel_UnorderedGroup_1_10_1ElementType());

	public static final IGrammarAwareElementType Model_FirstAssignment_1_10_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAssignment_1_10_1_0ElementType());

	public static final IGrammarAwareElementType Model_FirstAKeyword_1_10_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAKeyword_1_10_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_SecondAssignment_1_10_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAssignment_1_10_1_1ElementType());

	public static final IGrammarAwareElementType Model_SecondBKeyword_1_10_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondBKeyword_1_10_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_11_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1_11ElementType());

	public static final IGrammarAwareElementType Model_DigitOneDigitTwoKeyword_1_11_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitOneDigitTwoKeyword_1_11_0ElementType());

	public static final IGrammarAwareElementType Model_UnorderedGroup_1_11_1_ELEMENT_TYPE = associate(ModelFactory.createModel_UnorderedGroup_1_11_1ElementType());

	public static final IGrammarAwareElementType Model_FirstAsListAssignment_1_11_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAsListAssignment_1_11_1_0ElementType());

	public static final IGrammarAwareElementType Model_FirstAsListAKeyword_1_11_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAsListAKeyword_1_11_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_SecondAsListAssignment_1_11_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAsListAssignment_1_11_1_1ElementType());

	public static final IGrammarAwareElementType Model_SecondAsListBKeyword_1_11_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAsListBKeyword_1_11_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_UnorderedGroup_1_11_2_ELEMENT_TYPE = associate(ModelFactory.createModel_UnorderedGroup_1_11_2ElementType());

	public static final IGrammarAwareElementType Model_FirstAsListAssignment_1_11_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAsListAssignment_1_11_2_0ElementType());

	public static final IGrammarAwareElementType Model_FirstAsListAKeyword_1_11_2_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAsListAKeyword_1_11_2_0_0ElementType());

	public static final IGrammarAwareElementType Model_SecondAsListAssignment_1_11_2_1_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAsListAssignment_1_11_2_1ElementType());

	public static final IGrammarAwareElementType Model_SecondAsListBKeyword_1_11_2_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAsListBKeyword_1_11_2_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_12_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1_12ElementType());

	public static final IGrammarAwareElementType Model_DigitOneDigitThreeKeyword_1_12_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitOneDigitThreeKeyword_1_12_0ElementType());

	public static final IGrammarAwareElementType Model_UnorderedGroup_1_12_1_ELEMENT_TYPE = associate(ModelFactory.createModel_UnorderedGroup_1_12_1ElementType());

	public static final IGrammarAwareElementType Model_FirstAsListAssignment_1_12_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAsListAssignment_1_12_1_0ElementType());

	public static final IGrammarAwareElementType Model_FirstAsListAKeyword_1_12_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAsListAKeyword_1_12_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_SecondAsListAssignment_1_12_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAsListAssignment_1_12_1_1ElementType());

	public static final IGrammarAwareElementType Model_SecondAsListBKeyword_1_12_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAsListBKeyword_1_12_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_FirstAsListAssignment_1_12_2_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAsListAssignment_1_12_2ElementType());

	public static final IGrammarAwareElementType Model_FirstAsListAKeyword_1_12_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAsListAKeyword_1_12_2_0ElementType());

	public static final IGrammarAwareElementType Model_SecondAsListAssignment_1_12_3_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAsListAssignment_1_12_3ElementType());

	public static final IGrammarAwareElementType Model_SecondAsListBKeyword_1_12_3_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAsListBKeyword_1_12_3_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_13_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1_13ElementType());

	public static final IGrammarAwareElementType Model_DigitOneDigitFourKeyword_1_13_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitOneDigitFourKeyword_1_13_0ElementType());

	public static final IGrammarAwareElementType Model_UnorderedGroup_1_13_1_ELEMENT_TYPE = associate(ModelFactory.createModel_UnorderedGroup_1_13_1ElementType());

	public static final IGrammarAwareElementType Model_UnorderedGroup_1_13_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_UnorderedGroup_1_13_1_0ElementType());

	public static final IGrammarAwareElementType Model_FirstAsListAssignment_1_13_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAsListAssignment_1_13_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_FirstAsListAKeyword_1_13_1_0_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAsListAKeyword_1_13_1_0_0_0ElementType());

	public static final IGrammarAwareElementType Model_SecondAsListAssignment_1_13_1_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAsListAssignment_1_13_1_0_1ElementType());

	public static final IGrammarAwareElementType Model_SecondAsListBKeyword_1_13_1_0_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAsListBKeyword_1_13_1_0_1_0ElementType());

	public static final IGrammarAwareElementType Model_UnorderedGroup_1_13_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_UnorderedGroup_1_13_1_1ElementType());

	public static final IGrammarAwareElementType Model_ThirdAsListAssignment_1_13_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ThirdAsListAssignment_1_13_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_ThirdAsListCKeyword_1_13_1_1_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ThirdAsListCKeyword_1_13_1_1_0_0ElementType());

	public static final IGrammarAwareElementType Model_ForthAsListAssignment_1_13_1_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ForthAsListAssignment_1_13_1_1_1ElementType());

	public static final IGrammarAwareElementType Model_ForthAsListDKeyword_1_13_1_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ForthAsListDKeyword_1_13_1_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_14_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1_14ElementType());

	public static final IGrammarAwareElementType Model_DatatypesKeyword_1_14_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DatatypesKeyword_1_14_0ElementType());

	public static final IGrammarAwareElementType Model_ValueAssignment_1_14_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueAssignment_1_14_1ElementType());

	public static final IGrammarAwareElementType Model_ValueUnorderedDatatypeParserRuleCall_1_14_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueUnorderedDatatypeParserRuleCall_1_14_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_15_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1_15ElementType());

	public static final IGrammarAwareElementType Model_SerializationKeyword_1_15_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SerializationKeyword_1_15_0ElementType());

	public static final IGrammarAwareElementType Model_SerializedAssignment_1_15_1_ELEMENT_TYPE = associate(ModelFactory.createModel_SerializedAssignment_1_15_1ElementType());

	public static final IGrammarAwareElementType Model_SerializedUnorderedSerializationParserRuleCall_1_15_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SerializedUnorderedSerializationParserRuleCall_1_15_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_16_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1_16ElementType());

	public static final IGrammarAwareElementType Model_Bug302585Keyword_1_16_0_ELEMENT_TYPE = associate(ModelFactory.createModel_Bug302585Keyword_1_16_0ElementType());

	public static final IGrammarAwareElementType Model_NestedModelAssignment_1_16_1_ELEMENT_TYPE = associate(ModelFactory.createModel_NestedModelAssignment_1_16_1ElementType());

	public static final IGrammarAwareElementType Model_NestedModelNestedModelParserRuleCall_1_16_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NestedModelNestedModelParserRuleCall_1_16_1_0ElementType());

	private static class NestedModelFactory {
		public static IGrammarAwareElementType createNestedModelElementType() {
			return new IGrammarAwareElementType("NestedModel_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedModelRule());
		}
		public static IGrammarAwareElementType createNestedModel_GroupElementType() {
			return new IGrammarAwareElementType("NestedModel_Group_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedModelAccess().getGroup());
		}
		public static IGrammarAwareElementType createNestedModel_NestedModelAction_0ElementType() {
			return new IGrammarAwareElementType("NestedModel_NestedModelAction_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedModelAccess().getNestedModelAction_0());
		}
		public static IGrammarAwareElementType createNestedModel_UnorderedGroup_1ElementType() {
			return new IGrammarAwareElementType("NestedModel_UnorderedGroup_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedModelAccess().getUnorderedGroup_1());
		}
		public static IGrammarAwareElementType createNestedModel_FirstAssignment_1_0ElementType() {
			return new IGrammarAwareElementType("NestedModel_FirstAssignment_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedModelAccess().getFirstAssignment_1_0());
		}
		public static IGrammarAwareElementType createNestedModel_FirstAKeyword_1_0_0ElementType() {
			return new IGrammarAwareElementType("NestedModel_FirstAKeyword_1_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedModelAccess().getFirstAKeyword_1_0_0());
		}
		public static IGrammarAwareElementType createNestedModel_SecondAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("NestedModel_SecondAssignment_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedModelAccess().getSecondAssignment_1_1());
		}
		public static IGrammarAwareElementType createNestedModel_SecondBKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("NestedModel_SecondBKeyword_1_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedModelAccess().getSecondBKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createNestedModel_NestedKeyword_2ElementType() {
			return new IGrammarAwareElementType("NestedModel_NestedKeyword_2_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedModelAccess().getNestedKeyword_2());
		}
	}

	public static final IGrammarAwareElementType NestedModel_ELEMENT_TYPE = associate(NestedModelFactory.createNestedModelElementType());

	public static final IGrammarAwareElementType NestedModel_Group_ELEMENT_TYPE = associate(NestedModelFactory.createNestedModel_GroupElementType());

	public static final IGrammarAwareElementType NestedModel_NestedModelAction_0_ELEMENT_TYPE = associate(NestedModelFactory.createNestedModel_NestedModelAction_0ElementType());

	public static final IGrammarAwareElementType NestedModel_UnorderedGroup_1_ELEMENT_TYPE = associate(NestedModelFactory.createNestedModel_UnorderedGroup_1ElementType());

	public static final IGrammarAwareElementType NestedModel_FirstAssignment_1_0_ELEMENT_TYPE = associate(NestedModelFactory.createNestedModel_FirstAssignment_1_0ElementType());

	public static final IGrammarAwareElementType NestedModel_FirstAKeyword_1_0_0_ELEMENT_TYPE = associate(NestedModelFactory.createNestedModel_FirstAKeyword_1_0_0ElementType());

	public static final IGrammarAwareElementType NestedModel_SecondAssignment_1_1_ELEMENT_TYPE = associate(NestedModelFactory.createNestedModel_SecondAssignment_1_1ElementType());

	public static final IGrammarAwareElementType NestedModel_SecondBKeyword_1_1_0_ELEMENT_TYPE = associate(NestedModelFactory.createNestedModel_SecondBKeyword_1_1_0ElementType());

	public static final IGrammarAwareElementType NestedModel_NestedKeyword_2_ELEMENT_TYPE = associate(NestedModelFactory.createNestedModel_NestedKeyword_2ElementType());

	private static class UnorderedDatatypeFactory {
		public static IGrammarAwareElementType createUnorderedDatatypeElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeRule());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_AlternativesElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_Alternatives_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_Group_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_Group_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_DigitOneKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_DigitOneKeyword_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getDigitOneKeyword_0_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_UnorderedGroup_0_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_UnorderedGroup_0_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getUnorderedGroup_0_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_AKeyword_0_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_AKeyword_0_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getAKeyword_0_1_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_BKeyword_0_1_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_BKeyword_0_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getBKeyword_0_1_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_Group_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_Group_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_DigitTwoKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_DigitTwoKeyword_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getDigitTwoKeyword_1_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_UnorderedGroup_1_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_UnorderedGroup_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getUnorderedGroup_1_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_AKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_AKeyword_1_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getAKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_BKeyword_1_1_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_BKeyword_1_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getBKeyword_1_1_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_CKeyword_1_1_2ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_CKeyword_1_1_2_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getCKeyword_1_1_2());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_DKeyword_1_1_3ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_DKeyword_1_1_3_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getDKeyword_1_1_3());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_Group_2ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_Group_2_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_DigitThreeKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_DigitThreeKeyword_2_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getDigitThreeKeyword_2_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_UnorderedGroup_2_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_UnorderedGroup_2_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getUnorderedGroup_2_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_AKeyword_2_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_AKeyword_2_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getAKeyword_2_1_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_BKeyword_2_1_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_BKeyword_2_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getBKeyword_2_1_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_Group_3ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_Group_3_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_DigitFourKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_DigitFourKeyword_3_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getDigitFourKeyword_3_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_UnorderedGroup_3_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_UnorderedGroup_3_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getUnorderedGroup_3_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_AKeyword_3_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_AKeyword_3_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getAKeyword_3_1_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_BKeyword_3_1_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_BKeyword_3_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getBKeyword_3_1_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_Group_4ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_Group_4_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getGroup_4());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_DigitFiveKeyword_4_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_DigitFiveKeyword_4_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getDigitFiveKeyword_4_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_UnorderedGroup_4_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_UnorderedGroup_4_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getUnorderedGroup_4_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_AKeyword_4_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_AKeyword_4_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getAKeyword_4_1_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_BKeyword_4_1_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_BKeyword_4_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getBKeyword_4_1_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_Group_5ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_Group_5_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getGroup_5());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_DigitSixKeyword_5_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_DigitSixKeyword_5_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getDigitSixKeyword_5_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_UnorderedGroup_5_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_UnorderedGroup_5_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getUnorderedGroup_5_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_AKeyword_5_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_AKeyword_5_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getAKeyword_5_1_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_BKeyword_5_1_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_BKeyword_5_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getBKeyword_5_1_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_Group_6ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_Group_6_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getGroup_6());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_DigitSevenKeyword_6_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_DigitSevenKeyword_6_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getDigitSevenKeyword_6_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_UnorderedGroup_6_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_UnorderedGroup_6_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getUnorderedGroup_6_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_AKeyword_6_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_AKeyword_6_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getAKeyword_6_1_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_BKeyword_6_1_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_BKeyword_6_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getBKeyword_6_1_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_Group_7ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_Group_7_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getGroup_7());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_DigitEightKeyword_7_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_DigitEightKeyword_7_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getDigitEightKeyword_7_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_UnorderedGroup_7_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_UnorderedGroup_7_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getUnorderedGroup_7_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_Group_7_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_Group_7_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getGroup_7_1_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_AKeyword_7_1_0_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_AKeyword_7_1_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getAKeyword_7_1_0_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_BKeyword_7_1_0_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_BKeyword_7_1_0_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getBKeyword_7_1_0_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_CKeyword_7_1_0_2ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_CKeyword_7_1_0_2_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getCKeyword_7_1_0_2());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_Group_7_1_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_Group_7_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getGroup_7_1_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_AKeyword_7_1_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_AKeyword_7_1_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getAKeyword_7_1_1_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_BKeyword_7_1_1_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_BKeyword_7_1_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getBKeyword_7_1_1_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_DKeyword_7_1_1_2ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_DKeyword_7_1_1_2_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getDKeyword_7_1_1_2());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_Group_8ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_Group_8_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getGroup_8());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_DigitNineKeyword_8_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_DigitNineKeyword_8_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getDigitNineKeyword_8_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_UnorderedGroup_8_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_UnorderedGroup_8_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getUnorderedGroup_8_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_AKeyword_8_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_AKeyword_8_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getAKeyword_8_1_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_BKeyword_8_1_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_BKeyword_8_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getBKeyword_8_1_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_Group_9ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_Group_9_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getGroup_9());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_DigitOneDigitZeroKeyword_9_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_DigitOneDigitZeroKeyword_9_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getDigitOneDigitZeroKeyword_9_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_UnorderedGroup_9_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_UnorderedGroup_9_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getUnorderedGroup_9_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_AKeyword_9_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_AKeyword_9_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getAKeyword_9_1_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_BKeyword_9_1_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_BKeyword_9_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getBKeyword_9_1_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_Group_10ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_Group_10_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getGroup_10());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_DigitOneDigitOneKeyword_10_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_DigitOneDigitOneKeyword_10_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getDigitOneDigitOneKeyword_10_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_UnorderedGroup_10_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_UnorderedGroup_10_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getUnorderedGroup_10_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_AKeyword_10_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_AKeyword_10_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getAKeyword_10_1_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_BKeyword_10_1_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_BKeyword_10_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getBKeyword_10_1_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_Group_11ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_Group_11_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getGroup_11());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_DigitOneDigitTwoKeyword_11_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_DigitOneDigitTwoKeyword_11_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getDigitOneDigitTwoKeyword_11_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_UnorderedGroup_11_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_UnorderedGroup_11_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getUnorderedGroup_11_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_AKeyword_11_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_AKeyword_11_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getAKeyword_11_1_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_BKeyword_11_1_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_BKeyword_11_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getBKeyword_11_1_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_UnorderedGroup_11_2ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_UnorderedGroup_11_2_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getUnorderedGroup_11_2());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_AKeyword_11_2_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_AKeyword_11_2_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getAKeyword_11_2_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_BKeyword_11_2_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_BKeyword_11_2_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getBKeyword_11_2_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_Group_12ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_Group_12_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getGroup_12());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_DigitOneDigitThreeKeyword_12_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_DigitOneDigitThreeKeyword_12_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getDigitOneDigitThreeKeyword_12_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_UnorderedGroup_12_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_UnorderedGroup_12_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getUnorderedGroup_12_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_AKeyword_12_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_AKeyword_12_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getAKeyword_12_1_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_BKeyword_12_1_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_BKeyword_12_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getBKeyword_12_1_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_AKeyword_12_2ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_AKeyword_12_2_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getAKeyword_12_2());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_BKeyword_12_3ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_BKeyword_12_3_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getBKeyword_12_3());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_Group_13ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_Group_13_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getGroup_13());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_DigitOneDigitFourKeyword_13_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_DigitOneDigitFourKeyword_13_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getDigitOneDigitFourKeyword_13_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_UnorderedGroup_13_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_UnorderedGroup_13_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getUnorderedGroup_13_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_UnorderedGroup_13_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_UnorderedGroup_13_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getUnorderedGroup_13_1_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_AKeyword_13_1_0_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_AKeyword_13_1_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getAKeyword_13_1_0_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_BKeyword_13_1_0_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_BKeyword_13_1_0_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getBKeyword_13_1_0_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_UnorderedGroup_13_1_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_UnorderedGroup_13_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getUnorderedGroup_13_1_1());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_CKeyword_13_1_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_CKeyword_13_1_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getCKeyword_13_1_1_0());
		}
		public static IGrammarAwareElementType createUnorderedDatatype_DKeyword_13_1_1_1ElementType() {
			return new IGrammarAwareElementType("UnorderedDatatype_DKeyword_13_1_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedDatatypeAccess().getDKeyword_13_1_1_1());
		}
	}

	public static final IGrammarAwareElementType UnorderedDatatype_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatypeElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_Alternatives_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_AlternativesElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_Group_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_Group_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_DigitOneKeyword_0_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_DigitOneKeyword_0_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_UnorderedGroup_0_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_UnorderedGroup_0_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_AKeyword_0_1_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_AKeyword_0_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_BKeyword_0_1_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_BKeyword_0_1_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_Group_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_Group_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_DigitTwoKeyword_1_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_DigitTwoKeyword_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_UnorderedGroup_1_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_UnorderedGroup_1_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_AKeyword_1_1_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_AKeyword_1_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_BKeyword_1_1_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_BKeyword_1_1_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_CKeyword_1_1_2_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_CKeyword_1_1_2ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_DKeyword_1_1_3_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_DKeyword_1_1_3ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_Group_2_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_Group_2ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_DigitThreeKeyword_2_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_DigitThreeKeyword_2_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_UnorderedGroup_2_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_UnorderedGroup_2_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_AKeyword_2_1_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_AKeyword_2_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_BKeyword_2_1_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_BKeyword_2_1_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_Group_3_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_Group_3ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_DigitFourKeyword_3_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_DigitFourKeyword_3_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_UnorderedGroup_3_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_UnorderedGroup_3_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_AKeyword_3_1_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_AKeyword_3_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_BKeyword_3_1_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_BKeyword_3_1_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_Group_4_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_Group_4ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_DigitFiveKeyword_4_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_DigitFiveKeyword_4_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_UnorderedGroup_4_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_UnorderedGroup_4_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_AKeyword_4_1_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_AKeyword_4_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_BKeyword_4_1_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_BKeyword_4_1_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_Group_5_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_Group_5ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_DigitSixKeyword_5_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_DigitSixKeyword_5_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_UnorderedGroup_5_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_UnorderedGroup_5_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_AKeyword_5_1_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_AKeyword_5_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_BKeyword_5_1_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_BKeyword_5_1_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_Group_6_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_Group_6ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_DigitSevenKeyword_6_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_DigitSevenKeyword_6_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_UnorderedGroup_6_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_UnorderedGroup_6_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_AKeyword_6_1_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_AKeyword_6_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_BKeyword_6_1_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_BKeyword_6_1_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_Group_7_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_Group_7ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_DigitEightKeyword_7_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_DigitEightKeyword_7_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_UnorderedGroup_7_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_UnorderedGroup_7_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_Group_7_1_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_Group_7_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_AKeyword_7_1_0_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_AKeyword_7_1_0_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_BKeyword_7_1_0_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_BKeyword_7_1_0_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_CKeyword_7_1_0_2_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_CKeyword_7_1_0_2ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_Group_7_1_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_Group_7_1_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_AKeyword_7_1_1_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_AKeyword_7_1_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_BKeyword_7_1_1_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_BKeyword_7_1_1_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_DKeyword_7_1_1_2_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_DKeyword_7_1_1_2ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_Group_8_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_Group_8ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_DigitNineKeyword_8_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_DigitNineKeyword_8_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_UnorderedGroup_8_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_UnorderedGroup_8_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_AKeyword_8_1_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_AKeyword_8_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_BKeyword_8_1_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_BKeyword_8_1_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_Group_9_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_Group_9ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_DigitOneDigitZeroKeyword_9_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_DigitOneDigitZeroKeyword_9_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_UnorderedGroup_9_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_UnorderedGroup_9_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_AKeyword_9_1_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_AKeyword_9_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_BKeyword_9_1_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_BKeyword_9_1_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_Group_10_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_Group_10ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_DigitOneDigitOneKeyword_10_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_DigitOneDigitOneKeyword_10_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_UnorderedGroup_10_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_UnorderedGroup_10_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_AKeyword_10_1_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_AKeyword_10_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_BKeyword_10_1_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_BKeyword_10_1_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_Group_11_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_Group_11ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_DigitOneDigitTwoKeyword_11_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_DigitOneDigitTwoKeyword_11_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_UnorderedGroup_11_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_UnorderedGroup_11_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_AKeyword_11_1_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_AKeyword_11_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_BKeyword_11_1_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_BKeyword_11_1_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_UnorderedGroup_11_2_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_UnorderedGroup_11_2ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_AKeyword_11_2_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_AKeyword_11_2_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_BKeyword_11_2_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_BKeyword_11_2_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_Group_12_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_Group_12ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_DigitOneDigitThreeKeyword_12_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_DigitOneDigitThreeKeyword_12_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_UnorderedGroup_12_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_UnorderedGroup_12_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_AKeyword_12_1_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_AKeyword_12_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_BKeyword_12_1_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_BKeyword_12_1_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_AKeyword_12_2_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_AKeyword_12_2ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_BKeyword_12_3_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_BKeyword_12_3ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_Group_13_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_Group_13ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_DigitOneDigitFourKeyword_13_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_DigitOneDigitFourKeyword_13_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_UnorderedGroup_13_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_UnorderedGroup_13_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_UnorderedGroup_13_1_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_UnorderedGroup_13_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_AKeyword_13_1_0_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_AKeyword_13_1_0_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_BKeyword_13_1_0_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_BKeyword_13_1_0_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_UnorderedGroup_13_1_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_UnorderedGroup_13_1_1ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_CKeyword_13_1_1_0_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_CKeyword_13_1_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedDatatype_DKeyword_13_1_1_1_ELEMENT_TYPE = associate(UnorderedDatatypeFactory.createUnorderedDatatype_DKeyword_13_1_1_1ElementType());

	private static class UnorderedSerializationFactory {
		public static IGrammarAwareElementType createUnorderedSerializationElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationRule());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_GroupElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_Group_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getGroup());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_UnorderedSerializationAction_0ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_UnorderedSerializationAction_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getUnorderedSerializationAction_0());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_Alternatives_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_UnorderedGroup_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_UnorderedGroup_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getUnorderedGroup_1_0());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_Group_1_0_0ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_Group_1_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getGroup_1_0_0());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_DigitOneKeyword_1_0_0_0ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_DigitOneKeyword_1_0_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getDigitOneKeyword_1_0_0_0());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_FirstAssignment_1_0_0_1ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_FirstAssignment_1_0_0_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getFirstAssignment_1_0_0_1());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_FirstAKeyword_1_0_0_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_FirstAKeyword_1_0_0_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getFirstAKeyword_1_0_0_1_0());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_SecondAssignment_1_0_1ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_SecondAssignment_1_0_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getSecondAssignment_1_0_1());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_SecondBKeyword_1_0_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_SecondBKeyword_1_0_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getSecondBKeyword_1_0_1_0());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_ThirdAssignment_1_0_2ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_ThirdAssignment_1_0_2_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getThirdAssignment_1_0_2());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_ThirdCKeyword_1_0_2_0ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_ThirdCKeyword_1_0_2_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getThirdCKeyword_1_0_2_0());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_ForthAssignment_1_0_3ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_ForthAssignment_1_0_3_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getForthAssignment_1_0_3());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_ForthDKeyword_1_0_3_0ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_ForthDKeyword_1_0_3_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getForthDKeyword_1_0_3_0());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_Group_1_1ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_Group_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getGroup_1_1());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_DigitTwoKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_DigitTwoKeyword_1_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getDigitTwoKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_UnorderedGroup_1_1_1ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_UnorderedGroup_1_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getUnorderedGroup_1_1_1());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_FirstAsListAssignment_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_FirstAsListAssignment_1_1_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getFirstAsListAssignment_1_1_1_0());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_FirstAsListAKeyword_1_1_1_0_0ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_FirstAsListAKeyword_1_1_1_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getFirstAsListAKeyword_1_1_1_0_0());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_SecondAsListAssignment_1_1_1_1ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_SecondAsListAssignment_1_1_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getSecondAsListAssignment_1_1_1_1());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_SecondAsListBKeyword_1_1_1_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_SecondAsListBKeyword_1_1_1_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getSecondAsListBKeyword_1_1_1_1_0());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_Group_1_2ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_Group_1_2_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getGroup_1_2());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_DigitThreeKeyword_1_2_0ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_DigitThreeKeyword_1_2_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getDigitThreeKeyword_1_2_0());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_UnorderedGroup_1_2_1ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_UnorderedGroup_1_2_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getUnorderedGroup_1_2_1());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_FirstAsListAssignment_1_2_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_FirstAsListAssignment_1_2_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getFirstAsListAssignment_1_2_1_0());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_FirstAsListAKeyword_1_2_1_0_0ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_FirstAsListAKeyword_1_2_1_0_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getFirstAsListAKeyword_1_2_1_0_0());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_SecondAssignment_1_2_1_1ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_SecondAssignment_1_2_1_1_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getSecondAssignment_1_2_1_1());
		}
		public static IGrammarAwareElementType createUnorderedSerialization_SecondBKeyword_1_2_1_1_0ElementType() {
			return new IGrammarAwareElementType("UnorderedSerialization_SecondBKeyword_1_2_1_1_0_ELEMENT_TYPE", ExUnorderedGroupsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getUnorderedSerializationAccess().getSecondBKeyword_1_2_1_1_0());
		}
	}

	public static final IGrammarAwareElementType UnorderedSerialization_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerializationElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_Group_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_GroupElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_UnorderedSerializationAction_0_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_UnorderedSerializationAction_0ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_Alternatives_1_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_Alternatives_1ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_UnorderedGroup_1_0_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_UnorderedGroup_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_Group_1_0_0_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_Group_1_0_0ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_DigitOneKeyword_1_0_0_0_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_DigitOneKeyword_1_0_0_0ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_FirstAssignment_1_0_0_1_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_FirstAssignment_1_0_0_1ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_FirstAKeyword_1_0_0_1_0_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_FirstAKeyword_1_0_0_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_SecondAssignment_1_0_1_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_SecondAssignment_1_0_1ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_SecondBKeyword_1_0_1_0_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_SecondBKeyword_1_0_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_ThirdAssignment_1_0_2_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_ThirdAssignment_1_0_2ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_ThirdCKeyword_1_0_2_0_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_ThirdCKeyword_1_0_2_0ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_ForthAssignment_1_0_3_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_ForthAssignment_1_0_3ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_ForthDKeyword_1_0_3_0_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_ForthDKeyword_1_0_3_0ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_Group_1_1_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_Group_1_1ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_DigitTwoKeyword_1_1_0_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_DigitTwoKeyword_1_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_UnorderedGroup_1_1_1_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_UnorderedGroup_1_1_1ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_FirstAsListAssignment_1_1_1_0_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_FirstAsListAssignment_1_1_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_FirstAsListAKeyword_1_1_1_0_0_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_FirstAsListAKeyword_1_1_1_0_0ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_SecondAsListAssignment_1_1_1_1_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_SecondAsListAssignment_1_1_1_1ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_SecondAsListBKeyword_1_1_1_1_0_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_SecondAsListBKeyword_1_1_1_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_Group_1_2_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_Group_1_2ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_DigitThreeKeyword_1_2_0_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_DigitThreeKeyword_1_2_0ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_UnorderedGroup_1_2_1_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_UnorderedGroup_1_2_1ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_FirstAsListAssignment_1_2_1_0_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_FirstAsListAssignment_1_2_1_0ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_FirstAsListAKeyword_1_2_1_0_0_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_FirstAsListAKeyword_1_2_1_0_0ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_SecondAssignment_1_2_1_1_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_SecondAssignment_1_2_1_1ElementType());

	public static final IGrammarAwareElementType UnorderedSerialization_SecondBKeyword_1_2_1_1_0_ELEMENT_TYPE = associate(UnorderedSerializationFactory.createUnorderedSerialization_SecondBKeyword_1_2_1_1_0ElementType());

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

	public IGrammarAwareElementType getModel_Alternatives_1ElementType() {
		return Model_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1_0ElementType() {
		return Model_Group_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitOneKeyword_1_0_0ElementType() {
		return Model_DigitOneKeyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_UnorderedGroup_1_0_1ElementType() {
		return Model_UnorderedGroup_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAssignment_1_0_1_0ElementType() {
		return Model_FirstAssignment_1_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAKeyword_1_0_1_0_0ElementType() {
		return Model_FirstAKeyword_1_0_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAssignment_1_0_1_1ElementType() {
		return Model_SecondAssignment_1_0_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondBKeyword_1_0_1_1_0ElementType() {
		return Model_SecondBKeyword_1_0_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1_1ElementType() {
		return Model_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitTwoKeyword_1_1_0ElementType() {
		return Model_DigitTwoKeyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_UnorderedGroup_1_1_1ElementType() {
		return Model_UnorderedGroup_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAssignment_1_1_1_0ElementType() {
		return Model_FirstAssignment_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAKeyword_1_1_1_0_0ElementType() {
		return Model_FirstAKeyword_1_1_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAssignment_1_1_1_1ElementType() {
		return Model_SecondAssignment_1_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondBKeyword_1_1_1_1_0ElementType() {
		return Model_SecondBKeyword_1_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ThirdAssignment_1_1_1_2ElementType() {
		return Model_ThirdAssignment_1_1_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ThirdCKeyword_1_1_1_2_0ElementType() {
		return Model_ThirdCKeyword_1_1_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ForthAssignment_1_1_1_3ElementType() {
		return Model_ForthAssignment_1_1_1_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ForthDKeyword_1_1_1_3_0ElementType() {
		return Model_ForthDKeyword_1_1_1_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1_2ElementType() {
		return Model_Group_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitThreeKeyword_1_2_0ElementType() {
		return Model_DigitThreeKeyword_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_UnorderedGroup_1_2_1ElementType() {
		return Model_UnorderedGroup_1_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAssignment_1_2_1_0ElementType() {
		return Model_FirstAssignment_1_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAKeyword_1_2_1_0_0ElementType() {
		return Model_FirstAKeyword_1_2_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAssignment_1_2_1_1ElementType() {
		return Model_SecondAssignment_1_2_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondBKeyword_1_2_1_1_0ElementType() {
		return Model_SecondBKeyword_1_2_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1_3ElementType() {
		return Model_Group_1_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitFourKeyword_1_3_0ElementType() {
		return Model_DigitFourKeyword_1_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_UnorderedGroup_1_3_1ElementType() {
		return Model_UnorderedGroup_1_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAssignment_1_3_1_0ElementType() {
		return Model_FirstAssignment_1_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAKeyword_1_3_1_0_0ElementType() {
		return Model_FirstAKeyword_1_3_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAssignment_1_3_1_1ElementType() {
		return Model_SecondAssignment_1_3_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondBKeyword_1_3_1_1_0ElementType() {
		return Model_SecondBKeyword_1_3_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1_4ElementType() {
		return Model_Group_1_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitFiveKeyword_1_4_0ElementType() {
		return Model_DigitFiveKeyword_1_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_UnorderedGroup_1_4_1ElementType() {
		return Model_UnorderedGroup_1_4_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAssignment_1_4_1_0ElementType() {
		return Model_FirstAssignment_1_4_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAKeyword_1_4_1_0_0ElementType() {
		return Model_FirstAKeyword_1_4_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAssignment_1_4_1_1ElementType() {
		return Model_SecondAssignment_1_4_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondBKeyword_1_4_1_1_0ElementType() {
		return Model_SecondBKeyword_1_4_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1_5ElementType() {
		return Model_Group_1_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitSixKeyword_1_5_0ElementType() {
		return Model_DigitSixKeyword_1_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_UnorderedGroup_1_5_1ElementType() {
		return Model_UnorderedGroup_1_5_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAsListAssignment_1_5_1_0ElementType() {
		return Model_FirstAsListAssignment_1_5_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAsListAKeyword_1_5_1_0_0ElementType() {
		return Model_FirstAsListAKeyword_1_5_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAsListAssignment_1_5_1_1ElementType() {
		return Model_SecondAsListAssignment_1_5_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAsListBKeyword_1_5_1_1_0ElementType() {
		return Model_SecondAsListBKeyword_1_5_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1_6ElementType() {
		return Model_Group_1_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitSevenKeyword_1_6_0ElementType() {
		return Model_DigitSevenKeyword_1_6_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_UnorderedGroup_1_6_1ElementType() {
		return Model_UnorderedGroup_1_6_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAsListAssignment_1_6_1_0ElementType() {
		return Model_FirstAsListAssignment_1_6_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAsListAKeyword_1_6_1_0_0ElementType() {
		return Model_FirstAsListAKeyword_1_6_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAsListAssignment_1_6_1_1ElementType() {
		return Model_SecondAsListAssignment_1_6_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAsListBKeyword_1_6_1_1_0ElementType() {
		return Model_SecondAsListBKeyword_1_6_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1_7ElementType() {
		return Model_Group_1_7_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitEightKeyword_1_7_0ElementType() {
		return Model_DigitEightKeyword_1_7_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_UnorderedGroup_1_7_1ElementType() {
		return Model_UnorderedGroup_1_7_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1_7_1_0ElementType() {
		return Model_Group_1_7_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AKeyword_1_7_1_0_0ElementType() {
		return Model_AKeyword_1_7_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_BKeyword_1_7_1_0_1ElementType() {
		return Model_BKeyword_1_7_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAssignment_1_7_1_0_2ElementType() {
		return Model_FirstAssignment_1_7_1_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstCKeyword_1_7_1_0_2_0ElementType() {
		return Model_FirstCKeyword_1_7_1_0_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1_7_1_1ElementType() {
		return Model_Group_1_7_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_AKeyword_1_7_1_1_0ElementType() {
		return Model_AKeyword_1_7_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_BKeyword_1_7_1_1_1ElementType() {
		return Model_BKeyword_1_7_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAssignment_1_7_1_1_2ElementType() {
		return Model_SecondAssignment_1_7_1_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondDKeyword_1_7_1_1_2_0ElementType() {
		return Model_SecondDKeyword_1_7_1_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1_8ElementType() {
		return Model_Group_1_8_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitNineKeyword_1_8_0ElementType() {
		return Model_DigitNineKeyword_1_8_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_UnorderedGroup_1_8_1ElementType() {
		return Model_UnorderedGroup_1_8_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAsListAssignment_1_8_1_0ElementType() {
		return Model_FirstAsListAssignment_1_8_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAsListAKeyword_1_8_1_0_0ElementType() {
		return Model_FirstAsListAKeyword_1_8_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAsListAssignment_1_8_1_1ElementType() {
		return Model_SecondAsListAssignment_1_8_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAsListBKeyword_1_8_1_1_0ElementType() {
		return Model_SecondAsListBKeyword_1_8_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1_9ElementType() {
		return Model_Group_1_9_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitOneDigitZeroKeyword_1_9_0ElementType() {
		return Model_DigitOneDigitZeroKeyword_1_9_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_UnorderedGroup_1_9_1ElementType() {
		return Model_UnorderedGroup_1_9_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAsListAssignment_1_9_1_0ElementType() {
		return Model_FirstAsListAssignment_1_9_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAsListAKeyword_1_9_1_0_0ElementType() {
		return Model_FirstAsListAKeyword_1_9_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAsListAssignment_1_9_1_1ElementType() {
		return Model_SecondAsListAssignment_1_9_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAsListBKeyword_1_9_1_1_0ElementType() {
		return Model_SecondAsListBKeyword_1_9_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1_10ElementType() {
		return Model_Group_1_10_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitOneDigitOneKeyword_1_10_0ElementType() {
		return Model_DigitOneDigitOneKeyword_1_10_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_UnorderedGroup_1_10_1ElementType() {
		return Model_UnorderedGroup_1_10_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAssignment_1_10_1_0ElementType() {
		return Model_FirstAssignment_1_10_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAKeyword_1_10_1_0_0ElementType() {
		return Model_FirstAKeyword_1_10_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAssignment_1_10_1_1ElementType() {
		return Model_SecondAssignment_1_10_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondBKeyword_1_10_1_1_0ElementType() {
		return Model_SecondBKeyword_1_10_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1_11ElementType() {
		return Model_Group_1_11_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitOneDigitTwoKeyword_1_11_0ElementType() {
		return Model_DigitOneDigitTwoKeyword_1_11_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_UnorderedGroup_1_11_1ElementType() {
		return Model_UnorderedGroup_1_11_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAsListAssignment_1_11_1_0ElementType() {
		return Model_FirstAsListAssignment_1_11_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAsListAKeyword_1_11_1_0_0ElementType() {
		return Model_FirstAsListAKeyword_1_11_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAsListAssignment_1_11_1_1ElementType() {
		return Model_SecondAsListAssignment_1_11_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAsListBKeyword_1_11_1_1_0ElementType() {
		return Model_SecondAsListBKeyword_1_11_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_UnorderedGroup_1_11_2ElementType() {
		return Model_UnorderedGroup_1_11_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAsListAssignment_1_11_2_0ElementType() {
		return Model_FirstAsListAssignment_1_11_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAsListAKeyword_1_11_2_0_0ElementType() {
		return Model_FirstAsListAKeyword_1_11_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAsListAssignment_1_11_2_1ElementType() {
		return Model_SecondAsListAssignment_1_11_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAsListBKeyword_1_11_2_1_0ElementType() {
		return Model_SecondAsListBKeyword_1_11_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1_12ElementType() {
		return Model_Group_1_12_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitOneDigitThreeKeyword_1_12_0ElementType() {
		return Model_DigitOneDigitThreeKeyword_1_12_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_UnorderedGroup_1_12_1ElementType() {
		return Model_UnorderedGroup_1_12_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAsListAssignment_1_12_1_0ElementType() {
		return Model_FirstAsListAssignment_1_12_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAsListAKeyword_1_12_1_0_0ElementType() {
		return Model_FirstAsListAKeyword_1_12_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAsListAssignment_1_12_1_1ElementType() {
		return Model_SecondAsListAssignment_1_12_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAsListBKeyword_1_12_1_1_0ElementType() {
		return Model_SecondAsListBKeyword_1_12_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAsListAssignment_1_12_2ElementType() {
		return Model_FirstAsListAssignment_1_12_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAsListAKeyword_1_12_2_0ElementType() {
		return Model_FirstAsListAKeyword_1_12_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAsListAssignment_1_12_3ElementType() {
		return Model_SecondAsListAssignment_1_12_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAsListBKeyword_1_12_3_0ElementType() {
		return Model_SecondAsListBKeyword_1_12_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1_13ElementType() {
		return Model_Group_1_13_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitOneDigitFourKeyword_1_13_0ElementType() {
		return Model_DigitOneDigitFourKeyword_1_13_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_UnorderedGroup_1_13_1ElementType() {
		return Model_UnorderedGroup_1_13_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_UnorderedGroup_1_13_1_0ElementType() {
		return Model_UnorderedGroup_1_13_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAsListAssignment_1_13_1_0_0ElementType() {
		return Model_FirstAsListAssignment_1_13_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstAsListAKeyword_1_13_1_0_0_0ElementType() {
		return Model_FirstAsListAKeyword_1_13_1_0_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAsListAssignment_1_13_1_0_1ElementType() {
		return Model_SecondAsListAssignment_1_13_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAsListBKeyword_1_13_1_0_1_0ElementType() {
		return Model_SecondAsListBKeyword_1_13_1_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_UnorderedGroup_1_13_1_1ElementType() {
		return Model_UnorderedGroup_1_13_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ThirdAsListAssignment_1_13_1_1_0ElementType() {
		return Model_ThirdAsListAssignment_1_13_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ThirdAsListCKeyword_1_13_1_1_0_0ElementType() {
		return Model_ThirdAsListCKeyword_1_13_1_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ForthAsListAssignment_1_13_1_1_1ElementType() {
		return Model_ForthAsListAssignment_1_13_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ForthAsListDKeyword_1_13_1_1_1_0ElementType() {
		return Model_ForthAsListDKeyword_1_13_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1_14ElementType() {
		return Model_Group_1_14_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DatatypesKeyword_1_14_0ElementType() {
		return Model_DatatypesKeyword_1_14_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueAssignment_1_14_1ElementType() {
		return Model_ValueAssignment_1_14_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueUnorderedDatatypeParserRuleCall_1_14_1_0ElementType() {
		return Model_ValueUnorderedDatatypeParserRuleCall_1_14_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1_15ElementType() {
		return Model_Group_1_15_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SerializationKeyword_1_15_0ElementType() {
		return Model_SerializationKeyword_1_15_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SerializedAssignment_1_15_1ElementType() {
		return Model_SerializedAssignment_1_15_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SerializedUnorderedSerializationParserRuleCall_1_15_1_0ElementType() {
		return Model_SerializedUnorderedSerializationParserRuleCall_1_15_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1_16ElementType() {
		return Model_Group_1_16_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Bug302585Keyword_1_16_0ElementType() {
		return Model_Bug302585Keyword_1_16_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NestedModelAssignment_1_16_1ElementType() {
		return Model_NestedModelAssignment_1_16_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NestedModelNestedModelParserRuleCall_1_16_1_0ElementType() {
		return Model_NestedModelNestedModelParserRuleCall_1_16_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedModelElementType() {
		return NestedModel_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedModel_GroupElementType() {
		return NestedModel_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedModel_NestedModelAction_0ElementType() {
		return NestedModel_NestedModelAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedModel_UnorderedGroup_1ElementType() {
		return NestedModel_UnorderedGroup_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedModel_FirstAssignment_1_0ElementType() {
		return NestedModel_FirstAssignment_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedModel_FirstAKeyword_1_0_0ElementType() {
		return NestedModel_FirstAKeyword_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedModel_SecondAssignment_1_1ElementType() {
		return NestedModel_SecondAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedModel_SecondBKeyword_1_1_0ElementType() {
		return NestedModel_SecondBKeyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedModel_NestedKeyword_2ElementType() {
		return NestedModel_NestedKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatypeElementType() {
		return UnorderedDatatype_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_AlternativesElementType() {
		return UnorderedDatatype_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_Group_0ElementType() {
		return UnorderedDatatype_Group_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_DigitOneKeyword_0_0ElementType() {
		return UnorderedDatatype_DigitOneKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_UnorderedGroup_0_1ElementType() {
		return UnorderedDatatype_UnorderedGroup_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_AKeyword_0_1_0ElementType() {
		return UnorderedDatatype_AKeyword_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_BKeyword_0_1_1ElementType() {
		return UnorderedDatatype_BKeyword_0_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_Group_1ElementType() {
		return UnorderedDatatype_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_DigitTwoKeyword_1_0ElementType() {
		return UnorderedDatatype_DigitTwoKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_UnorderedGroup_1_1ElementType() {
		return UnorderedDatatype_UnorderedGroup_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_AKeyword_1_1_0ElementType() {
		return UnorderedDatatype_AKeyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_BKeyword_1_1_1ElementType() {
		return UnorderedDatatype_BKeyword_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_CKeyword_1_1_2ElementType() {
		return UnorderedDatatype_CKeyword_1_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_DKeyword_1_1_3ElementType() {
		return UnorderedDatatype_DKeyword_1_1_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_Group_2ElementType() {
		return UnorderedDatatype_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_DigitThreeKeyword_2_0ElementType() {
		return UnorderedDatatype_DigitThreeKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_UnorderedGroup_2_1ElementType() {
		return UnorderedDatatype_UnorderedGroup_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_AKeyword_2_1_0ElementType() {
		return UnorderedDatatype_AKeyword_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_BKeyword_2_1_1ElementType() {
		return UnorderedDatatype_BKeyword_2_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_Group_3ElementType() {
		return UnorderedDatatype_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_DigitFourKeyword_3_0ElementType() {
		return UnorderedDatatype_DigitFourKeyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_UnorderedGroup_3_1ElementType() {
		return UnorderedDatatype_UnorderedGroup_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_AKeyword_3_1_0ElementType() {
		return UnorderedDatatype_AKeyword_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_BKeyword_3_1_1ElementType() {
		return UnorderedDatatype_BKeyword_3_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_Group_4ElementType() {
		return UnorderedDatatype_Group_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_DigitFiveKeyword_4_0ElementType() {
		return UnorderedDatatype_DigitFiveKeyword_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_UnorderedGroup_4_1ElementType() {
		return UnorderedDatatype_UnorderedGroup_4_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_AKeyword_4_1_0ElementType() {
		return UnorderedDatatype_AKeyword_4_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_BKeyword_4_1_1ElementType() {
		return UnorderedDatatype_BKeyword_4_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_Group_5ElementType() {
		return UnorderedDatatype_Group_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_DigitSixKeyword_5_0ElementType() {
		return UnorderedDatatype_DigitSixKeyword_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_UnorderedGroup_5_1ElementType() {
		return UnorderedDatatype_UnorderedGroup_5_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_AKeyword_5_1_0ElementType() {
		return UnorderedDatatype_AKeyword_5_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_BKeyword_5_1_1ElementType() {
		return UnorderedDatatype_BKeyword_5_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_Group_6ElementType() {
		return UnorderedDatatype_Group_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_DigitSevenKeyword_6_0ElementType() {
		return UnorderedDatatype_DigitSevenKeyword_6_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_UnorderedGroup_6_1ElementType() {
		return UnorderedDatatype_UnorderedGroup_6_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_AKeyword_6_1_0ElementType() {
		return UnorderedDatatype_AKeyword_6_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_BKeyword_6_1_1ElementType() {
		return UnorderedDatatype_BKeyword_6_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_Group_7ElementType() {
		return UnorderedDatatype_Group_7_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_DigitEightKeyword_7_0ElementType() {
		return UnorderedDatatype_DigitEightKeyword_7_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_UnorderedGroup_7_1ElementType() {
		return UnorderedDatatype_UnorderedGroup_7_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_Group_7_1_0ElementType() {
		return UnorderedDatatype_Group_7_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_AKeyword_7_1_0_0ElementType() {
		return UnorderedDatatype_AKeyword_7_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_BKeyword_7_1_0_1ElementType() {
		return UnorderedDatatype_BKeyword_7_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_CKeyword_7_1_0_2ElementType() {
		return UnorderedDatatype_CKeyword_7_1_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_Group_7_1_1ElementType() {
		return UnorderedDatatype_Group_7_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_AKeyword_7_1_1_0ElementType() {
		return UnorderedDatatype_AKeyword_7_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_BKeyword_7_1_1_1ElementType() {
		return UnorderedDatatype_BKeyword_7_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_DKeyword_7_1_1_2ElementType() {
		return UnorderedDatatype_DKeyword_7_1_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_Group_8ElementType() {
		return UnorderedDatatype_Group_8_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_DigitNineKeyword_8_0ElementType() {
		return UnorderedDatatype_DigitNineKeyword_8_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_UnorderedGroup_8_1ElementType() {
		return UnorderedDatatype_UnorderedGroup_8_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_AKeyword_8_1_0ElementType() {
		return UnorderedDatatype_AKeyword_8_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_BKeyword_8_1_1ElementType() {
		return UnorderedDatatype_BKeyword_8_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_Group_9ElementType() {
		return UnorderedDatatype_Group_9_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_DigitOneDigitZeroKeyword_9_0ElementType() {
		return UnorderedDatatype_DigitOneDigitZeroKeyword_9_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_UnorderedGroup_9_1ElementType() {
		return UnorderedDatatype_UnorderedGroup_9_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_AKeyword_9_1_0ElementType() {
		return UnorderedDatatype_AKeyword_9_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_BKeyword_9_1_1ElementType() {
		return UnorderedDatatype_BKeyword_9_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_Group_10ElementType() {
		return UnorderedDatatype_Group_10_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_DigitOneDigitOneKeyword_10_0ElementType() {
		return UnorderedDatatype_DigitOneDigitOneKeyword_10_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_UnorderedGroup_10_1ElementType() {
		return UnorderedDatatype_UnorderedGroup_10_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_AKeyword_10_1_0ElementType() {
		return UnorderedDatatype_AKeyword_10_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_BKeyword_10_1_1ElementType() {
		return UnorderedDatatype_BKeyword_10_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_Group_11ElementType() {
		return UnorderedDatatype_Group_11_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_DigitOneDigitTwoKeyword_11_0ElementType() {
		return UnorderedDatatype_DigitOneDigitTwoKeyword_11_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_UnorderedGroup_11_1ElementType() {
		return UnorderedDatatype_UnorderedGroup_11_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_AKeyword_11_1_0ElementType() {
		return UnorderedDatatype_AKeyword_11_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_BKeyword_11_1_1ElementType() {
		return UnorderedDatatype_BKeyword_11_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_UnorderedGroup_11_2ElementType() {
		return UnorderedDatatype_UnorderedGroup_11_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_AKeyword_11_2_0ElementType() {
		return UnorderedDatatype_AKeyword_11_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_BKeyword_11_2_1ElementType() {
		return UnorderedDatatype_BKeyword_11_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_Group_12ElementType() {
		return UnorderedDatatype_Group_12_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_DigitOneDigitThreeKeyword_12_0ElementType() {
		return UnorderedDatatype_DigitOneDigitThreeKeyword_12_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_UnorderedGroup_12_1ElementType() {
		return UnorderedDatatype_UnorderedGroup_12_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_AKeyword_12_1_0ElementType() {
		return UnorderedDatatype_AKeyword_12_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_BKeyword_12_1_1ElementType() {
		return UnorderedDatatype_BKeyword_12_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_AKeyword_12_2ElementType() {
		return UnorderedDatatype_AKeyword_12_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_BKeyword_12_3ElementType() {
		return UnorderedDatatype_BKeyword_12_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_Group_13ElementType() {
		return UnorderedDatatype_Group_13_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_DigitOneDigitFourKeyword_13_0ElementType() {
		return UnorderedDatatype_DigitOneDigitFourKeyword_13_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_UnorderedGroup_13_1ElementType() {
		return UnorderedDatatype_UnorderedGroup_13_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_UnorderedGroup_13_1_0ElementType() {
		return UnorderedDatatype_UnorderedGroup_13_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_AKeyword_13_1_0_0ElementType() {
		return UnorderedDatatype_AKeyword_13_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_BKeyword_13_1_0_1ElementType() {
		return UnorderedDatatype_BKeyword_13_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_UnorderedGroup_13_1_1ElementType() {
		return UnorderedDatatype_UnorderedGroup_13_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_CKeyword_13_1_1_0ElementType() {
		return UnorderedDatatype_CKeyword_13_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedDatatype_DKeyword_13_1_1_1ElementType() {
		return UnorderedDatatype_DKeyword_13_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerializationElementType() {
		return UnorderedSerialization_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_GroupElementType() {
		return UnorderedSerialization_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_UnorderedSerializationAction_0ElementType() {
		return UnorderedSerialization_UnorderedSerializationAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_Alternatives_1ElementType() {
		return UnorderedSerialization_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_UnorderedGroup_1_0ElementType() {
		return UnorderedSerialization_UnorderedGroup_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_Group_1_0_0ElementType() {
		return UnorderedSerialization_Group_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_DigitOneKeyword_1_0_0_0ElementType() {
		return UnorderedSerialization_DigitOneKeyword_1_0_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_FirstAssignment_1_0_0_1ElementType() {
		return UnorderedSerialization_FirstAssignment_1_0_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_FirstAKeyword_1_0_0_1_0ElementType() {
		return UnorderedSerialization_FirstAKeyword_1_0_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_SecondAssignment_1_0_1ElementType() {
		return UnorderedSerialization_SecondAssignment_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_SecondBKeyword_1_0_1_0ElementType() {
		return UnorderedSerialization_SecondBKeyword_1_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_ThirdAssignment_1_0_2ElementType() {
		return UnorderedSerialization_ThirdAssignment_1_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_ThirdCKeyword_1_0_2_0ElementType() {
		return UnorderedSerialization_ThirdCKeyword_1_0_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_ForthAssignment_1_0_3ElementType() {
		return UnorderedSerialization_ForthAssignment_1_0_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_ForthDKeyword_1_0_3_0ElementType() {
		return UnorderedSerialization_ForthDKeyword_1_0_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_Group_1_1ElementType() {
		return UnorderedSerialization_Group_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_DigitTwoKeyword_1_1_0ElementType() {
		return UnorderedSerialization_DigitTwoKeyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_UnorderedGroup_1_1_1ElementType() {
		return UnorderedSerialization_UnorderedGroup_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_FirstAsListAssignment_1_1_1_0ElementType() {
		return UnorderedSerialization_FirstAsListAssignment_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_FirstAsListAKeyword_1_1_1_0_0ElementType() {
		return UnorderedSerialization_FirstAsListAKeyword_1_1_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_SecondAsListAssignment_1_1_1_1ElementType() {
		return UnorderedSerialization_SecondAsListAssignment_1_1_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_SecondAsListBKeyword_1_1_1_1_0ElementType() {
		return UnorderedSerialization_SecondAsListBKeyword_1_1_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_Group_1_2ElementType() {
		return UnorderedSerialization_Group_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_DigitThreeKeyword_1_2_0ElementType() {
		return UnorderedSerialization_DigitThreeKeyword_1_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_UnorderedGroup_1_2_1ElementType() {
		return UnorderedSerialization_UnorderedGroup_1_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_FirstAsListAssignment_1_2_1_0ElementType() {
		return UnorderedSerialization_FirstAsListAssignment_1_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_FirstAsListAKeyword_1_2_1_0_0ElementType() {
		return UnorderedSerialization_FirstAsListAKeyword_1_2_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_SecondAssignment_1_2_1_1ElementType() {
		return UnorderedSerialization_SecondAssignment_1_2_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getUnorderedSerialization_SecondBKeyword_1_2_1_1_0ElementType() {
		return UnorderedSerialization_SecondBKeyword_1_2_1_1_0_ELEMENT_TYPE;
	}

}
