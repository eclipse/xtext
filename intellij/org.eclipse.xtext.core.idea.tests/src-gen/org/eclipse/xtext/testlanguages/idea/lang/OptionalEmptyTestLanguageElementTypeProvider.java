package org.eclipse.xtext.testlanguages.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.testlanguages.idea.lang.psi.impl.OptionalEmptyTestLanguageFileImpl;
import org.eclipse.xtext.testlanguages.services.OptionalEmptyTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class OptionalEmptyTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<OptionalEmptyTestLanguageFileImpl>>(OptionalEmptyTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final OptionalEmptyTestLanguageGrammarAccess GRAMMAR_ACCESS = OptionalEmptyTestLanguageLanguage.INSTANCE.getInstance(OptionalEmptyTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", OptionalEmptyTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_ChildAssignmentElementType() {
			return new IGrammarAwareElementType("Model_ChildAssignment_ELEMENT_TYPE", OptionalEmptyTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getChildAssignment());
		}
		public static IGrammarAwareElementType createModel_ChildGreetingParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Model_ChildGreetingParserRuleCall_0_ELEMENT_TYPE", OptionalEmptyTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getChildGreetingParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_ChildAssignment_ELEMENT_TYPE = associate(ModelFactory.createModel_ChildAssignmentElementType());

	public static final IGrammarAwareElementType Model_ChildGreetingParserRuleCall_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ChildGreetingParserRuleCall_0ElementType());

	private static class GreetingFactory {
		public static IGrammarAwareElementType createGreetingElementType() {
			return new IGrammarAwareElementType("Greeting_ELEMENT_TYPE", OptionalEmptyTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGreetingRule());
		}
		public static IGrammarAwareElementType createGreeting_GroupElementType() {
			return new IGrammarAwareElementType("Greeting_Group_ELEMENT_TYPE", OptionalEmptyTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGreetingAccess().getGroup());
		}
		public static IGrammarAwareElementType createGreeting_HalloKeyword_0ElementType() {
			return new IGrammarAwareElementType("Greeting_HalloKeyword_0_ELEMENT_TYPE", OptionalEmptyTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGreetingAccess().getHalloKeyword_0());
		}
		public static IGrammarAwareElementType createGreeting_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Greeting_NameAssignment_1_ELEMENT_TYPE", OptionalEmptyTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGreetingAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createGreeting_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Greeting_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", OptionalEmptyTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getGreetingAccess().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Greeting_ELEMENT_TYPE = associate(GreetingFactory.createGreetingElementType());

	public static final IGrammarAwareElementType Greeting_Group_ELEMENT_TYPE = associate(GreetingFactory.createGreeting_GroupElementType());

	public static final IGrammarAwareElementType Greeting_HalloKeyword_0_ELEMENT_TYPE = associate(GreetingFactory.createGreeting_HalloKeyword_0ElementType());

	public static final IGrammarAwareElementType Greeting_NameAssignment_1_ELEMENT_TYPE = associate(GreetingFactory.createGreeting_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Greeting_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(GreetingFactory.createGreeting_NameIDTerminalRuleCall_1_0ElementType());

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

	public IGrammarAwareElementType getModel_ChildAssignmentElementType() {
		return Model_ChildAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ChildGreetingParserRuleCall_0ElementType() {
		return Model_ChildGreetingParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGreetingElementType() {
		return Greeting_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGreeting_GroupElementType() {
		return Greeting_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGreeting_HalloKeyword_0ElementType() {
		return Greeting_HalloKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGreeting_NameAssignment_1ElementType() {
		return Greeting_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGreeting_NameIDTerminalRuleCall_1_0ElementType() {
		return Greeting_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

}
