package org.eclipse.xtext.testlanguages.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.testlanguages.idea.lang.psi.impl.PartialParserTestLanguageFileImpl;
import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class PartialParserTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<PartialParserTestLanguageFileImpl>>(PartialParserTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final PartialParserTestLanguageGrammarAccess GRAMMAR_ACCESS = PartialParserTestLanguageLanguage.INSTANCE.getInstance(PartialParserTestLanguageGrammarAccess.class);

	private static class SomeContainerFactory {
		public static IGrammarAwareElementType createSomeContainerElementType() {
			return new IGrammarAwareElementType("SomeContainer_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSomeContainerRule());
		}
		public static IGrammarAwareElementType createSomeContainer_GroupElementType() {
			return new IGrammarAwareElementType("SomeContainer_Group_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSomeContainerAccess().getGroup());
		}
		public static IGrammarAwareElementType createSomeContainer_ContainerKeyword_0ElementType() {
			return new IGrammarAwareElementType("SomeContainer_ContainerKeyword_0_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSomeContainerAccess().getContainerKeyword_0());
		}
		public static IGrammarAwareElementType createSomeContainer_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("SomeContainer_NameAssignment_1_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSomeContainerAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createSomeContainer_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("SomeContainer_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSomeContainerAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createSomeContainer_LeftCurlyBracketKeyword_2ElementType() {
			return new IGrammarAwareElementType("SomeContainer_LeftCurlyBracketKeyword_2_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSomeContainerAccess().getLeftCurlyBracketKeyword_2());
		}
		public static IGrammarAwareElementType createSomeContainer_Alternatives_3ElementType() {
			return new IGrammarAwareElementType("SomeContainer_Alternatives_3_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSomeContainerAccess().getAlternatives_3());
		}
		public static IGrammarAwareElementType createSomeContainer_NestedAssignment_3_0ElementType() {
			return new IGrammarAwareElementType("SomeContainer_NestedAssignment_3_0_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSomeContainerAccess().getNestedAssignment_3_0());
		}
		public static IGrammarAwareElementType createSomeContainer_NestedNestedParserRuleCall_3_0_0ElementType() {
			return new IGrammarAwareElementType("SomeContainer_NestedNestedParserRuleCall_3_0_0_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSomeContainerAccess().getNestedNestedParserRuleCall_3_0_0());
		}
		public static IGrammarAwareElementType createSomeContainer_ContentAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("SomeContainer_ContentAssignment_3_1_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSomeContainerAccess().getContentAssignment_3_1());
		}
		public static IGrammarAwareElementType createSomeContainer_ContentContentParserRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("SomeContainer_ContentContentParserRuleCall_3_1_0_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSomeContainerAccess().getContentContentParserRuleCall_3_1_0());
		}
		public static IGrammarAwareElementType createSomeContainer_RightCurlyBracketKeyword_4ElementType() {
			return new IGrammarAwareElementType("SomeContainer_RightCurlyBracketKeyword_4_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSomeContainerAccess().getRightCurlyBracketKeyword_4());
		}
	}

	public static final IGrammarAwareElementType SomeContainer_ELEMENT_TYPE = associate(SomeContainerFactory.createSomeContainerElementType());

	public static final IGrammarAwareElementType SomeContainer_Group_ELEMENT_TYPE = associate(SomeContainerFactory.createSomeContainer_GroupElementType());

	public static final IGrammarAwareElementType SomeContainer_ContainerKeyword_0_ELEMENT_TYPE = associate(SomeContainerFactory.createSomeContainer_ContainerKeyword_0ElementType());

	public static final IGrammarAwareElementType SomeContainer_NameAssignment_1_ELEMENT_TYPE = associate(SomeContainerFactory.createSomeContainer_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType SomeContainer_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(SomeContainerFactory.createSomeContainer_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType SomeContainer_LeftCurlyBracketKeyword_2_ELEMENT_TYPE = associate(SomeContainerFactory.createSomeContainer_LeftCurlyBracketKeyword_2ElementType());

	public static final IGrammarAwareElementType SomeContainer_Alternatives_3_ELEMENT_TYPE = associate(SomeContainerFactory.createSomeContainer_Alternatives_3ElementType());

	public static final IGrammarAwareElementType SomeContainer_NestedAssignment_3_0_ELEMENT_TYPE = associate(SomeContainerFactory.createSomeContainer_NestedAssignment_3_0ElementType());

	public static final IGrammarAwareElementType SomeContainer_NestedNestedParserRuleCall_3_0_0_ELEMENT_TYPE = associate(SomeContainerFactory.createSomeContainer_NestedNestedParserRuleCall_3_0_0ElementType());

	public static final IGrammarAwareElementType SomeContainer_ContentAssignment_3_1_ELEMENT_TYPE = associate(SomeContainerFactory.createSomeContainer_ContentAssignment_3_1ElementType());

	public static final IGrammarAwareElementType SomeContainer_ContentContentParserRuleCall_3_1_0_ELEMENT_TYPE = associate(SomeContainerFactory.createSomeContainer_ContentContentParserRuleCall_3_1_0ElementType());

	public static final IGrammarAwareElementType SomeContainer_RightCurlyBracketKeyword_4_ELEMENT_TYPE = associate(SomeContainerFactory.createSomeContainer_RightCurlyBracketKeyword_4ElementType());

	private static class NestedFactory {
		public static IGrammarAwareElementType createNestedElementType() {
			return new IGrammarAwareElementType("Nested_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedRule());
		}
		public static IGrammarAwareElementType createNested_GroupElementType() {
			return new IGrammarAwareElementType("Nested_Group_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedAccess().getGroup());
		}
		public static IGrammarAwareElementType createNested_NestedKeyword_0ElementType() {
			return new IGrammarAwareElementType("Nested_NestedKeyword_0_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedAccess().getNestedKeyword_0());
		}
		public static IGrammarAwareElementType createNested_LeftCurlyBracketKeyword_1ElementType() {
			return new IGrammarAwareElementType("Nested_LeftCurlyBracketKeyword_1_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedAccess().getLeftCurlyBracketKeyword_1());
		}
		public static IGrammarAwareElementType createNested_NestedAssignment_2ElementType() {
			return new IGrammarAwareElementType("Nested_NestedAssignment_2_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedAccess().getNestedAssignment_2());
		}
		public static IGrammarAwareElementType createNested_NestedSomeContainerParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Nested_NestedSomeContainerParserRuleCall_2_0_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedAccess().getNestedSomeContainerParserRuleCall_2_0());
		}
		public static IGrammarAwareElementType createNested_RightCurlyBracketKeyword_3ElementType() {
			return new IGrammarAwareElementType("Nested_RightCurlyBracketKeyword_3_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNestedAccess().getRightCurlyBracketKeyword_3());
		}
	}

	public static final IGrammarAwareElementType Nested_ELEMENT_TYPE = associate(NestedFactory.createNestedElementType());

	public static final IGrammarAwareElementType Nested_Group_ELEMENT_TYPE = associate(NestedFactory.createNested_GroupElementType());

	public static final IGrammarAwareElementType Nested_NestedKeyword_0_ELEMENT_TYPE = associate(NestedFactory.createNested_NestedKeyword_0ElementType());

	public static final IGrammarAwareElementType Nested_LeftCurlyBracketKeyword_1_ELEMENT_TYPE = associate(NestedFactory.createNested_LeftCurlyBracketKeyword_1ElementType());

	public static final IGrammarAwareElementType Nested_NestedAssignment_2_ELEMENT_TYPE = associate(NestedFactory.createNested_NestedAssignment_2ElementType());

	public static final IGrammarAwareElementType Nested_NestedSomeContainerParserRuleCall_2_0_ELEMENT_TYPE = associate(NestedFactory.createNested_NestedSomeContainerParserRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType Nested_RightCurlyBracketKeyword_3_ELEMENT_TYPE = associate(NestedFactory.createNested_RightCurlyBracketKeyword_3ElementType());

	private static class ContentFactory {
		public static IGrammarAwareElementType createContentElementType() {
			return new IGrammarAwareElementType("Content_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContentRule());
		}
		public static IGrammarAwareElementType createContent_AlternativesElementType() {
			return new IGrammarAwareElementType("Content_Alternatives_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContentAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createContent_ChildrenParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Content_ChildrenParserRuleCall_0_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContentAccess().getChildrenParserRuleCall_0());
		}
		public static IGrammarAwareElementType createContent_AbstractChildrenParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Content_AbstractChildrenParserRuleCall_1_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContentAccess().getAbstractChildrenParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType Content_ELEMENT_TYPE = associate(ContentFactory.createContentElementType());

	public static final IGrammarAwareElementType Content_Alternatives_ELEMENT_TYPE = associate(ContentFactory.createContent_AlternativesElementType());

	public static final IGrammarAwareElementType Content_ChildrenParserRuleCall_0_ELEMENT_TYPE = associate(ContentFactory.createContent_ChildrenParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Content_AbstractChildrenParserRuleCall_1_ELEMENT_TYPE = associate(ContentFactory.createContent_AbstractChildrenParserRuleCall_1ElementType());

	private static class ChildrenFactory {
		public static IGrammarAwareElementType createChildrenElementType() {
			return new IGrammarAwareElementType("Children_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildrenRule());
		}
		public static IGrammarAwareElementType createChildren_GroupElementType() {
			return new IGrammarAwareElementType("Children_Group_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildrenAccess().getGroup());
		}
		public static IGrammarAwareElementType createChildren_ChildrenKeyword_0ElementType() {
			return new IGrammarAwareElementType("Children_ChildrenKeyword_0_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildrenAccess().getChildrenKeyword_0());
		}
		public static IGrammarAwareElementType createChildren_LeftCurlyBracketKeyword_1ElementType() {
			return new IGrammarAwareElementType("Children_LeftCurlyBracketKeyword_1_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildrenAccess().getLeftCurlyBracketKeyword_1());
		}
		public static IGrammarAwareElementType createChildren_ChildrenAssignment_2ElementType() {
			return new IGrammarAwareElementType("Children_ChildrenAssignment_2_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildrenAccess().getChildrenAssignment_2());
		}
		public static IGrammarAwareElementType createChildren_ChildrenChildParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Children_ChildrenChildParserRuleCall_2_0_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildrenAccess().getChildrenChildParserRuleCall_2_0());
		}
		public static IGrammarAwareElementType createChildren_Group_3ElementType() {
			return new IGrammarAwareElementType("Children_Group_3_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildrenAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createChildren_CommaKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("Children_CommaKeyword_3_0_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildrenAccess().getCommaKeyword_3_0());
		}
		public static IGrammarAwareElementType createChildren_ChildrenAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("Children_ChildrenAssignment_3_1_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildrenAccess().getChildrenAssignment_3_1());
		}
		public static IGrammarAwareElementType createChildren_ChildrenChildParserRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("Children_ChildrenChildParserRuleCall_3_1_0_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildrenAccess().getChildrenChildParserRuleCall_3_1_0());
		}
		public static IGrammarAwareElementType createChildren_RightCurlyBracketKeyword_4ElementType() {
			return new IGrammarAwareElementType("Children_RightCurlyBracketKeyword_4_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildrenAccess().getRightCurlyBracketKeyword_4());
		}
	}

	public static final IGrammarAwareElementType Children_ELEMENT_TYPE = associate(ChildrenFactory.createChildrenElementType());

	public static final IGrammarAwareElementType Children_Group_ELEMENT_TYPE = associate(ChildrenFactory.createChildren_GroupElementType());

	public static final IGrammarAwareElementType Children_ChildrenKeyword_0_ELEMENT_TYPE = associate(ChildrenFactory.createChildren_ChildrenKeyword_0ElementType());

	public static final IGrammarAwareElementType Children_LeftCurlyBracketKeyword_1_ELEMENT_TYPE = associate(ChildrenFactory.createChildren_LeftCurlyBracketKeyword_1ElementType());

	public static final IGrammarAwareElementType Children_ChildrenAssignment_2_ELEMENT_TYPE = associate(ChildrenFactory.createChildren_ChildrenAssignment_2ElementType());

	public static final IGrammarAwareElementType Children_ChildrenChildParserRuleCall_2_0_ELEMENT_TYPE = associate(ChildrenFactory.createChildren_ChildrenChildParserRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType Children_Group_3_ELEMENT_TYPE = associate(ChildrenFactory.createChildren_Group_3ElementType());

	public static final IGrammarAwareElementType Children_CommaKeyword_3_0_ELEMENT_TYPE = associate(ChildrenFactory.createChildren_CommaKeyword_3_0ElementType());

	public static final IGrammarAwareElementType Children_ChildrenAssignment_3_1_ELEMENT_TYPE = associate(ChildrenFactory.createChildren_ChildrenAssignment_3_1ElementType());

	public static final IGrammarAwareElementType Children_ChildrenChildParserRuleCall_3_1_0_ELEMENT_TYPE = associate(ChildrenFactory.createChildren_ChildrenChildParserRuleCall_3_1_0ElementType());

	public static final IGrammarAwareElementType Children_RightCurlyBracketKeyword_4_ELEMENT_TYPE = associate(ChildrenFactory.createChildren_RightCurlyBracketKeyword_4ElementType());

	private static class ChildFactory {
		public static IGrammarAwareElementType createChildElementType() {
			return new IGrammarAwareElementType("Child_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildRule());
		}
		public static IGrammarAwareElementType createChild_GroupElementType() {
			return new IGrammarAwareElementType("Child_Group_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildAccess().getGroup());
		}
		public static IGrammarAwareElementType createChild_HyphenMinusGreaterThanSignKeyword_0ElementType() {
			return new IGrammarAwareElementType("Child_HyphenMinusGreaterThanSignKeyword_0_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildAccess().getHyphenMinusGreaterThanSignKeyword_0());
		}
		public static IGrammarAwareElementType createChild_CKeyword_1ElementType() {
			return new IGrammarAwareElementType("Child_CKeyword_1_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildAccess().getCKeyword_1());
		}
		public static IGrammarAwareElementType createChild_LeftParenthesisKeyword_2ElementType() {
			return new IGrammarAwareElementType("Child_LeftParenthesisKeyword_2_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildAccess().getLeftParenthesisKeyword_2());
		}
		public static IGrammarAwareElementType createChild_ValueAssignment_3ElementType() {
			return new IGrammarAwareElementType("Child_ValueAssignment_3_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildAccess().getValueAssignment_3());
		}
		public static IGrammarAwareElementType createChild_ValueNamedParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("Child_ValueNamedParserRuleCall_3_0_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildAccess().getValueNamedParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createChild_RightParenthesisKeyword_4ElementType() {
			return new IGrammarAwareElementType("Child_RightParenthesisKeyword_4_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getChildAccess().getRightParenthesisKeyword_4());
		}
	}

	public static final IGrammarAwareElementType Child_ELEMENT_TYPE = associate(ChildFactory.createChildElementType());

	public static final IGrammarAwareElementType Child_Group_ELEMENT_TYPE = associate(ChildFactory.createChild_GroupElementType());

	public static final IGrammarAwareElementType Child_HyphenMinusGreaterThanSignKeyword_0_ELEMENT_TYPE = associate(ChildFactory.createChild_HyphenMinusGreaterThanSignKeyword_0ElementType());

	public static final IGrammarAwareElementType Child_CKeyword_1_ELEMENT_TYPE = associate(ChildFactory.createChild_CKeyword_1ElementType());

	public static final IGrammarAwareElementType Child_LeftParenthesisKeyword_2_ELEMENT_TYPE = associate(ChildFactory.createChild_LeftParenthesisKeyword_2ElementType());

	public static final IGrammarAwareElementType Child_ValueAssignment_3_ELEMENT_TYPE = associate(ChildFactory.createChild_ValueAssignment_3ElementType());

	public static final IGrammarAwareElementType Child_ValueNamedParserRuleCall_3_0_ELEMENT_TYPE = associate(ChildFactory.createChild_ValueNamedParserRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType Child_RightParenthesisKeyword_4_ELEMENT_TYPE = associate(ChildFactory.createChild_RightParenthesisKeyword_4ElementType());

	private static class AbstractChildrenFactory {
		public static IGrammarAwareElementType createAbstractChildrenElementType() {
			return new IGrammarAwareElementType("AbstractChildren_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractChildrenRule());
		}
		public static IGrammarAwareElementType createAbstractChildren_GroupElementType() {
			return new IGrammarAwareElementType("AbstractChildren_Group_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractChildrenAccess().getGroup());
		}
		public static IGrammarAwareElementType createAbstractChildren_AbstractChildrenKeyword_0ElementType() {
			return new IGrammarAwareElementType("AbstractChildren_AbstractChildrenKeyword_0_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractChildrenAccess().getAbstractChildrenKeyword_0());
		}
		public static IGrammarAwareElementType createAbstractChildren_LeftCurlyBracketKeyword_1ElementType() {
			return new IGrammarAwareElementType("AbstractChildren_LeftCurlyBracketKeyword_1_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractChildrenAccess().getLeftCurlyBracketKeyword_1());
		}
		public static IGrammarAwareElementType createAbstractChildren_AbstractChildrenAssignment_2ElementType() {
			return new IGrammarAwareElementType("AbstractChildren_AbstractChildrenAssignment_2_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractChildrenAccess().getAbstractChildrenAssignment_2());
		}
		public static IGrammarAwareElementType createAbstractChildren_AbstractChildrenAbstractChildParserRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("AbstractChildren_AbstractChildrenAbstractChildParserRuleCall_2_0_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractChildrenAccess().getAbstractChildrenAbstractChildParserRuleCall_2_0());
		}
		public static IGrammarAwareElementType createAbstractChildren_RightCurlyBracketKeyword_3ElementType() {
			return new IGrammarAwareElementType("AbstractChildren_RightCurlyBracketKeyword_3_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractChildrenAccess().getRightCurlyBracketKeyword_3());
		}
	}

	public static final IGrammarAwareElementType AbstractChildren_ELEMENT_TYPE = associate(AbstractChildrenFactory.createAbstractChildrenElementType());

	public static final IGrammarAwareElementType AbstractChildren_Group_ELEMENT_TYPE = associate(AbstractChildrenFactory.createAbstractChildren_GroupElementType());

	public static final IGrammarAwareElementType AbstractChildren_AbstractChildrenKeyword_0_ELEMENT_TYPE = associate(AbstractChildrenFactory.createAbstractChildren_AbstractChildrenKeyword_0ElementType());

	public static final IGrammarAwareElementType AbstractChildren_LeftCurlyBracketKeyword_1_ELEMENT_TYPE = associate(AbstractChildrenFactory.createAbstractChildren_LeftCurlyBracketKeyword_1ElementType());

	public static final IGrammarAwareElementType AbstractChildren_AbstractChildrenAssignment_2_ELEMENT_TYPE = associate(AbstractChildrenFactory.createAbstractChildren_AbstractChildrenAssignment_2ElementType());

	public static final IGrammarAwareElementType AbstractChildren_AbstractChildrenAbstractChildParserRuleCall_2_0_ELEMENT_TYPE = associate(AbstractChildrenFactory.createAbstractChildren_AbstractChildrenAbstractChildParserRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType AbstractChildren_RightCurlyBracketKeyword_3_ELEMENT_TYPE = associate(AbstractChildrenFactory.createAbstractChildren_RightCurlyBracketKeyword_3ElementType());

	private static class AbstractChildFactory {
		public static IGrammarAwareElementType createAbstractChildElementType() {
			return new IGrammarAwareElementType("AbstractChild_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractChildRule());
		}
		public static IGrammarAwareElementType createAbstractChild_AlternativesElementType() {
			return new IGrammarAwareElementType("AbstractChild_Alternatives_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractChildAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createAbstractChild_FirstConcreteParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("AbstractChild_FirstConcreteParserRuleCall_0_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractChildAccess().getFirstConcreteParserRuleCall_0());
		}
		public static IGrammarAwareElementType createAbstractChild_SecondConcreteParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("AbstractChild_SecondConcreteParserRuleCall_1_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractChildAccess().getSecondConcreteParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType AbstractChild_ELEMENT_TYPE = associate(AbstractChildFactory.createAbstractChildElementType());

	public static final IGrammarAwareElementType AbstractChild_Alternatives_ELEMENT_TYPE = associate(AbstractChildFactory.createAbstractChild_AlternativesElementType());

	public static final IGrammarAwareElementType AbstractChild_FirstConcreteParserRuleCall_0_ELEMENT_TYPE = associate(AbstractChildFactory.createAbstractChild_FirstConcreteParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType AbstractChild_SecondConcreteParserRuleCall_1_ELEMENT_TYPE = associate(AbstractChildFactory.createAbstractChild_SecondConcreteParserRuleCall_1ElementType());

	private static class FirstConcreteFactory {
		public static IGrammarAwareElementType createFirstConcreteElementType() {
			return new IGrammarAwareElementType("FirstConcrete_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFirstConcreteRule());
		}
		public static IGrammarAwareElementType createFirstConcrete_GroupElementType() {
			return new IGrammarAwareElementType("FirstConcrete_Group_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFirstConcreteAccess().getGroup());
		}
		public static IGrammarAwareElementType createFirstConcrete_HyphenMinusGreaterThanSignKeyword_0ElementType() {
			return new IGrammarAwareElementType("FirstConcrete_HyphenMinusGreaterThanSignKeyword_0_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFirstConcreteAccess().getHyphenMinusGreaterThanSignKeyword_0());
		}
		public static IGrammarAwareElementType createFirstConcrete_FKeyword_1ElementType() {
			return new IGrammarAwareElementType("FirstConcrete_FKeyword_1_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFirstConcreteAccess().getFKeyword_1());
		}
		public static IGrammarAwareElementType createFirstConcrete_LeftParenthesisKeyword_2ElementType() {
			return new IGrammarAwareElementType("FirstConcrete_LeftParenthesisKeyword_2_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFirstConcreteAccess().getLeftParenthesisKeyword_2());
		}
		public static IGrammarAwareElementType createFirstConcrete_ValueAssignment_3ElementType() {
			return new IGrammarAwareElementType("FirstConcrete_ValueAssignment_3_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFirstConcreteAccess().getValueAssignment_3());
		}
		public static IGrammarAwareElementType createFirstConcrete_ValueNamedParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("FirstConcrete_ValueNamedParserRuleCall_3_0_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFirstConcreteAccess().getValueNamedParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createFirstConcrete_ReferencedContainerAssignment_4ElementType() {
			return new IGrammarAwareElementType("FirstConcrete_ReferencedContainerAssignment_4_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFirstConcreteAccess().getReferencedContainerAssignment_4());
		}
		public static IGrammarAwareElementType createFirstConcrete_ReferencedContainerSomeContainerCrossReference_4_0ElementType() {
			return new IGrammarAwareElementType("FirstConcrete_ReferencedContainerSomeContainerCrossReference_4_0_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFirstConcreteAccess().getReferencedContainerSomeContainerCrossReference_4_0());
		}
		public static IGrammarAwareElementType createFirstConcrete_ReferencedContainerSomeContainerIDTerminalRuleCall_4_0_1ElementType() {
			return new IGrammarAwareElementType("FirstConcrete_ReferencedContainerSomeContainerIDTerminalRuleCall_4_0_1_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFirstConcreteAccess().getReferencedContainerSomeContainerIDTerminalRuleCall_4_0_1());
		}
		public static IGrammarAwareElementType createFirstConcrete_RightParenthesisKeyword_5ElementType() {
			return new IGrammarAwareElementType("FirstConcrete_RightParenthesisKeyword_5_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFirstConcreteAccess().getRightParenthesisKeyword_5());
		}
	}

	public static final IGrammarAwareElementType FirstConcrete_ELEMENT_TYPE = associate(FirstConcreteFactory.createFirstConcreteElementType());

	public static final IGrammarAwareElementType FirstConcrete_Group_ELEMENT_TYPE = associate(FirstConcreteFactory.createFirstConcrete_GroupElementType());

	public static final IGrammarAwareElementType FirstConcrete_HyphenMinusGreaterThanSignKeyword_0_ELEMENT_TYPE = associate(FirstConcreteFactory.createFirstConcrete_HyphenMinusGreaterThanSignKeyword_0ElementType());

	public static final IGrammarAwareElementType FirstConcrete_FKeyword_1_ELEMENT_TYPE = associate(FirstConcreteFactory.createFirstConcrete_FKeyword_1ElementType());

	public static final IGrammarAwareElementType FirstConcrete_LeftParenthesisKeyword_2_ELEMENT_TYPE = associate(FirstConcreteFactory.createFirstConcrete_LeftParenthesisKeyword_2ElementType());

	public static final IGrammarAwareElementType FirstConcrete_ValueAssignment_3_ELEMENT_TYPE = associate(FirstConcreteFactory.createFirstConcrete_ValueAssignment_3ElementType());

	public static final IGrammarAwareElementType FirstConcrete_ValueNamedParserRuleCall_3_0_ELEMENT_TYPE = associate(FirstConcreteFactory.createFirstConcrete_ValueNamedParserRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType FirstConcrete_ReferencedContainerAssignment_4_ELEMENT_TYPE = associate(FirstConcreteFactory.createFirstConcrete_ReferencedContainerAssignment_4ElementType());

	public static final IGrammarAwareElementType FirstConcrete_ReferencedContainerSomeContainerCrossReference_4_0_ELEMENT_TYPE = associate(FirstConcreteFactory.createFirstConcrete_ReferencedContainerSomeContainerCrossReference_4_0ElementType());

	public static final IGrammarAwareElementType FirstConcrete_ReferencedContainerSomeContainerIDTerminalRuleCall_4_0_1_ELEMENT_TYPE = associate(FirstConcreteFactory.createFirstConcrete_ReferencedContainerSomeContainerIDTerminalRuleCall_4_0_1ElementType());

	public static final IGrammarAwareElementType FirstConcrete_RightParenthesisKeyword_5_ELEMENT_TYPE = associate(FirstConcreteFactory.createFirstConcrete_RightParenthesisKeyword_5ElementType());

	private static class SecondConcreteFactory {
		public static IGrammarAwareElementType createSecondConcreteElementType() {
			return new IGrammarAwareElementType("SecondConcrete_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSecondConcreteRule());
		}
		public static IGrammarAwareElementType createSecondConcrete_GroupElementType() {
			return new IGrammarAwareElementType("SecondConcrete_Group_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSecondConcreteAccess().getGroup());
		}
		public static IGrammarAwareElementType createSecondConcrete_HyphenMinusGreaterThanSignKeyword_0ElementType() {
			return new IGrammarAwareElementType("SecondConcrete_HyphenMinusGreaterThanSignKeyword_0_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSecondConcreteAccess().getHyphenMinusGreaterThanSignKeyword_0());
		}
		public static IGrammarAwareElementType createSecondConcrete_FKeyword_1ElementType() {
			return new IGrammarAwareElementType("SecondConcrete_FKeyword_1_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSecondConcreteAccess().getFKeyword_1());
		}
		public static IGrammarAwareElementType createSecondConcrete_SKeyword_2ElementType() {
			return new IGrammarAwareElementType("SecondConcrete_SKeyword_2_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSecondConcreteAccess().getSKeyword_2());
		}
		public static IGrammarAwareElementType createSecondConcrete_LeftParenthesisKeyword_3ElementType() {
			return new IGrammarAwareElementType("SecondConcrete_LeftParenthesisKeyword_3_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSecondConcreteAccess().getLeftParenthesisKeyword_3());
		}
		public static IGrammarAwareElementType createSecondConcrete_ValueAssignment_4ElementType() {
			return new IGrammarAwareElementType("SecondConcrete_ValueAssignment_4_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSecondConcreteAccess().getValueAssignment_4());
		}
		public static IGrammarAwareElementType createSecondConcrete_ValueNamedParserRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("SecondConcrete_ValueNamedParserRuleCall_4_0_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSecondConcreteAccess().getValueNamedParserRuleCall_4_0());
		}
		public static IGrammarAwareElementType createSecondConcrete_ReferencedChildrenAssignment_5ElementType() {
			return new IGrammarAwareElementType("SecondConcrete_ReferencedChildrenAssignment_5_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSecondConcreteAccess().getReferencedChildrenAssignment_5());
		}
		public static IGrammarAwareElementType createSecondConcrete_ReferencedChildrenChildCrossReference_5_0ElementType() {
			return new IGrammarAwareElementType("SecondConcrete_ReferencedChildrenChildCrossReference_5_0_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSecondConcreteAccess().getReferencedChildrenChildCrossReference_5_0());
		}
		public static IGrammarAwareElementType createSecondConcrete_ReferencedChildrenChildIDTerminalRuleCall_5_0_1ElementType() {
			return new IGrammarAwareElementType("SecondConcrete_ReferencedChildrenChildIDTerminalRuleCall_5_0_1_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSecondConcreteAccess().getReferencedChildrenChildIDTerminalRuleCall_5_0_1());
		}
		public static IGrammarAwareElementType createSecondConcrete_RightParenthesisKeyword_6ElementType() {
			return new IGrammarAwareElementType("SecondConcrete_RightParenthesisKeyword_6_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSecondConcreteAccess().getRightParenthesisKeyword_6());
		}
	}

	public static final IGrammarAwareElementType SecondConcrete_ELEMENT_TYPE = associate(SecondConcreteFactory.createSecondConcreteElementType());

	public static final IGrammarAwareElementType SecondConcrete_Group_ELEMENT_TYPE = associate(SecondConcreteFactory.createSecondConcrete_GroupElementType());

	public static final IGrammarAwareElementType SecondConcrete_HyphenMinusGreaterThanSignKeyword_0_ELEMENT_TYPE = associate(SecondConcreteFactory.createSecondConcrete_HyphenMinusGreaterThanSignKeyword_0ElementType());

	public static final IGrammarAwareElementType SecondConcrete_FKeyword_1_ELEMENT_TYPE = associate(SecondConcreteFactory.createSecondConcrete_FKeyword_1ElementType());

	public static final IGrammarAwareElementType SecondConcrete_SKeyword_2_ELEMENT_TYPE = associate(SecondConcreteFactory.createSecondConcrete_SKeyword_2ElementType());

	public static final IGrammarAwareElementType SecondConcrete_LeftParenthesisKeyword_3_ELEMENT_TYPE = associate(SecondConcreteFactory.createSecondConcrete_LeftParenthesisKeyword_3ElementType());

	public static final IGrammarAwareElementType SecondConcrete_ValueAssignment_4_ELEMENT_TYPE = associate(SecondConcreteFactory.createSecondConcrete_ValueAssignment_4ElementType());

	public static final IGrammarAwareElementType SecondConcrete_ValueNamedParserRuleCall_4_0_ELEMENT_TYPE = associate(SecondConcreteFactory.createSecondConcrete_ValueNamedParserRuleCall_4_0ElementType());

	public static final IGrammarAwareElementType SecondConcrete_ReferencedChildrenAssignment_5_ELEMENT_TYPE = associate(SecondConcreteFactory.createSecondConcrete_ReferencedChildrenAssignment_5ElementType());

	public static final IGrammarAwareElementType SecondConcrete_ReferencedChildrenChildCrossReference_5_0_ELEMENT_TYPE = associate(SecondConcreteFactory.createSecondConcrete_ReferencedChildrenChildCrossReference_5_0ElementType());

	public static final IGrammarAwareElementType SecondConcrete_ReferencedChildrenChildIDTerminalRuleCall_5_0_1_ELEMENT_TYPE = associate(SecondConcreteFactory.createSecondConcrete_ReferencedChildrenChildIDTerminalRuleCall_5_0_1ElementType());

	public static final IGrammarAwareElementType SecondConcrete_RightParenthesisKeyword_6_ELEMENT_TYPE = associate(SecondConcreteFactory.createSecondConcrete_RightParenthesisKeyword_6ElementType());

	private static class NamedFactory {
		public static IGrammarAwareElementType createNamedElementType() {
			return new IGrammarAwareElementType("Named_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedRule());
		}
		public static IGrammarAwareElementType createNamed_NameAssignmentElementType() {
			return new IGrammarAwareElementType("Named_NameAssignment_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedAccess().getNameAssignment());
		}
		public static IGrammarAwareElementType createNamed_NameIDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Named_NameIDTerminalRuleCall_0_ELEMENT_TYPE", PartialParserTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNamedAccess().getNameIDTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Named_ELEMENT_TYPE = associate(NamedFactory.createNamedElementType());

	public static final IGrammarAwareElementType Named_NameAssignment_ELEMENT_TYPE = associate(NamedFactory.createNamed_NameAssignmentElementType());

	public static final IGrammarAwareElementType Named_NameIDTerminalRuleCall_0_ELEMENT_TYPE = associate(NamedFactory.createNamed_NameIDTerminalRuleCall_0ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getSomeContainerElementType() {
		return SomeContainer_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSomeContainer_GroupElementType() {
		return SomeContainer_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSomeContainer_ContainerKeyword_0ElementType() {
		return SomeContainer_ContainerKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSomeContainer_NameAssignment_1ElementType() {
		return SomeContainer_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSomeContainer_NameIDTerminalRuleCall_1_0ElementType() {
		return SomeContainer_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSomeContainer_LeftCurlyBracketKeyword_2ElementType() {
		return SomeContainer_LeftCurlyBracketKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSomeContainer_Alternatives_3ElementType() {
		return SomeContainer_Alternatives_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSomeContainer_NestedAssignment_3_0ElementType() {
		return SomeContainer_NestedAssignment_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSomeContainer_NestedNestedParserRuleCall_3_0_0ElementType() {
		return SomeContainer_NestedNestedParserRuleCall_3_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSomeContainer_ContentAssignment_3_1ElementType() {
		return SomeContainer_ContentAssignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSomeContainer_ContentContentParserRuleCall_3_1_0ElementType() {
		return SomeContainer_ContentContentParserRuleCall_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSomeContainer_RightCurlyBracketKeyword_4ElementType() {
		return SomeContainer_RightCurlyBracketKeyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNestedElementType() {
		return Nested_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNested_GroupElementType() {
		return Nested_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNested_NestedKeyword_0ElementType() {
		return Nested_NestedKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNested_LeftCurlyBracketKeyword_1ElementType() {
		return Nested_LeftCurlyBracketKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNested_NestedAssignment_2ElementType() {
		return Nested_NestedAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNested_NestedSomeContainerParserRuleCall_2_0ElementType() {
		return Nested_NestedSomeContainerParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNested_RightCurlyBracketKeyword_3ElementType() {
		return Nested_RightCurlyBracketKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContentElementType() {
		return Content_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContent_AlternativesElementType() {
		return Content_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContent_ChildrenParserRuleCall_0ElementType() {
		return Content_ChildrenParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContent_AbstractChildrenParserRuleCall_1ElementType() {
		return Content_AbstractChildrenParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChildrenElementType() {
		return Children_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChildren_GroupElementType() {
		return Children_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChildren_ChildrenKeyword_0ElementType() {
		return Children_ChildrenKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChildren_LeftCurlyBracketKeyword_1ElementType() {
		return Children_LeftCurlyBracketKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChildren_ChildrenAssignment_2ElementType() {
		return Children_ChildrenAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChildren_ChildrenChildParserRuleCall_2_0ElementType() {
		return Children_ChildrenChildParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChildren_Group_3ElementType() {
		return Children_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChildren_CommaKeyword_3_0ElementType() {
		return Children_CommaKeyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChildren_ChildrenAssignment_3_1ElementType() {
		return Children_ChildrenAssignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChildren_ChildrenChildParserRuleCall_3_1_0ElementType() {
		return Children_ChildrenChildParserRuleCall_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChildren_RightCurlyBracketKeyword_4ElementType() {
		return Children_RightCurlyBracketKeyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChildElementType() {
		return Child_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild_GroupElementType() {
		return Child_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild_HyphenMinusGreaterThanSignKeyword_0ElementType() {
		return Child_HyphenMinusGreaterThanSignKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild_CKeyword_1ElementType() {
		return Child_CKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild_LeftParenthesisKeyword_2ElementType() {
		return Child_LeftParenthesisKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild_ValueAssignment_3ElementType() {
		return Child_ValueAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild_ValueNamedParserRuleCall_3_0ElementType() {
		return Child_ValueNamedParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getChild_RightParenthesisKeyword_4ElementType() {
		return Child_RightParenthesisKeyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractChildrenElementType() {
		return AbstractChildren_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractChildren_GroupElementType() {
		return AbstractChildren_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractChildren_AbstractChildrenKeyword_0ElementType() {
		return AbstractChildren_AbstractChildrenKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractChildren_LeftCurlyBracketKeyword_1ElementType() {
		return AbstractChildren_LeftCurlyBracketKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractChildren_AbstractChildrenAssignment_2ElementType() {
		return AbstractChildren_AbstractChildrenAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractChildren_AbstractChildrenAbstractChildParserRuleCall_2_0ElementType() {
		return AbstractChildren_AbstractChildrenAbstractChildParserRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractChildren_RightCurlyBracketKeyword_3ElementType() {
		return AbstractChildren_RightCurlyBracketKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractChildElementType() {
		return AbstractChild_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractChild_AlternativesElementType() {
		return AbstractChild_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractChild_FirstConcreteParserRuleCall_0ElementType() {
		return AbstractChild_FirstConcreteParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractChild_SecondConcreteParserRuleCall_1ElementType() {
		return AbstractChild_SecondConcreteParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFirstConcreteElementType() {
		return FirstConcrete_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFirstConcrete_GroupElementType() {
		return FirstConcrete_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFirstConcrete_HyphenMinusGreaterThanSignKeyword_0ElementType() {
		return FirstConcrete_HyphenMinusGreaterThanSignKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFirstConcrete_FKeyword_1ElementType() {
		return FirstConcrete_FKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFirstConcrete_LeftParenthesisKeyword_2ElementType() {
		return FirstConcrete_LeftParenthesisKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFirstConcrete_ValueAssignment_3ElementType() {
		return FirstConcrete_ValueAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFirstConcrete_ValueNamedParserRuleCall_3_0ElementType() {
		return FirstConcrete_ValueNamedParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFirstConcrete_ReferencedContainerAssignment_4ElementType() {
		return FirstConcrete_ReferencedContainerAssignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFirstConcrete_ReferencedContainerSomeContainerCrossReference_4_0ElementType() {
		return FirstConcrete_ReferencedContainerSomeContainerCrossReference_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFirstConcrete_ReferencedContainerSomeContainerIDTerminalRuleCall_4_0_1ElementType() {
		return FirstConcrete_ReferencedContainerSomeContainerIDTerminalRuleCall_4_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFirstConcrete_RightParenthesisKeyword_5ElementType() {
		return FirstConcrete_RightParenthesisKeyword_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSecondConcreteElementType() {
		return SecondConcrete_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSecondConcrete_GroupElementType() {
		return SecondConcrete_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSecondConcrete_HyphenMinusGreaterThanSignKeyword_0ElementType() {
		return SecondConcrete_HyphenMinusGreaterThanSignKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSecondConcrete_FKeyword_1ElementType() {
		return SecondConcrete_FKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSecondConcrete_SKeyword_2ElementType() {
		return SecondConcrete_SKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSecondConcrete_LeftParenthesisKeyword_3ElementType() {
		return SecondConcrete_LeftParenthesisKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSecondConcrete_ValueAssignment_4ElementType() {
		return SecondConcrete_ValueAssignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSecondConcrete_ValueNamedParserRuleCall_4_0ElementType() {
		return SecondConcrete_ValueNamedParserRuleCall_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSecondConcrete_ReferencedChildrenAssignment_5ElementType() {
		return SecondConcrete_ReferencedChildrenAssignment_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSecondConcrete_ReferencedChildrenChildCrossReference_5_0ElementType() {
		return SecondConcrete_ReferencedChildrenChildCrossReference_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSecondConcrete_ReferencedChildrenChildIDTerminalRuleCall_5_0_1ElementType() {
		return SecondConcrete_ReferencedChildrenChildIDTerminalRuleCall_5_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSecondConcrete_RightParenthesisKeyword_6ElementType() {
		return SecondConcrete_RightParenthesisKeyword_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamedElementType() {
		return Named_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamed_NameAssignmentElementType() {
		return Named_NameAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNamed_NameIDTerminalRuleCall_0ElementType() {
		return Named_NameIDTerminalRuleCall_0_ELEMENT_TYPE;
	}

}
