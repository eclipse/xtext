package org.eclipse.xtext.linking.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.linking.idea.lang.psi.impl.Bug362902FileImpl;
import org.eclipse.xtext.linking.services.Bug362902GrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class Bug362902ElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<Bug362902FileImpl>>(Bug362902Language.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final Bug362902GrammarAccess GRAMMAR_ACCESS = Bug362902Language.INSTANCE.getInstance(Bug362902GrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", Bug362902Language.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_GroupElementType() {
			return new IGrammarAwareElementType("Model_Group_ELEMENT_TYPE", Bug362902Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup());
		}
		public static IGrammarAwareElementType createModel_GreetingsAssignment_0ElementType() {
			return new IGrammarAwareElementType("Model_GreetingsAssignment_0_ELEMENT_TYPE", Bug362902Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGreetingsAssignment_0());
		}
		public static IGrammarAwareElementType createModel_GreetingsGreetingParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Model_GreetingsGreetingParserRuleCall_0_0_ELEMENT_TYPE", Bug362902Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGreetingsGreetingParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createModel_FavouriteKeyword_1ElementType() {
			return new IGrammarAwareElementType("Model_FavouriteKeyword_1_ELEMENT_TYPE", Bug362902Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFavouriteKeyword_1());
		}
		public static IGrammarAwareElementType createModel_FavouriteAssignment_2ElementType() {
			return new IGrammarAwareElementType("Model_FavouriteAssignment_2_ELEMENT_TYPE", Bug362902Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFavouriteAssignment_2());
		}
		public static IGrammarAwareElementType createModel_FavouriteGreetingCrossReference_2_0ElementType() {
			return new IGrammarAwareElementType("Model_FavouriteGreetingCrossReference_2_0_ELEMENT_TYPE", Bug362902Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFavouriteGreetingCrossReference_2_0());
		}
		public static IGrammarAwareElementType createModel_FavouriteGreetingMyIdParserRuleCall_2_0_1ElementType() {
			return new IGrammarAwareElementType("Model_FavouriteGreetingMyIdParserRuleCall_2_0_1_ELEMENT_TYPE", Bug362902Language.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFavouriteGreetingMyIdParserRuleCall_2_0_1());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Group_ELEMENT_TYPE = associate(ModelFactory.createModel_GroupElementType());

	public static final IGrammarAwareElementType Model_GreetingsAssignment_0_ELEMENT_TYPE = associate(ModelFactory.createModel_GreetingsAssignment_0ElementType());

	public static final IGrammarAwareElementType Model_GreetingsGreetingParserRuleCall_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_GreetingsGreetingParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Model_FavouriteKeyword_1_ELEMENT_TYPE = associate(ModelFactory.createModel_FavouriteKeyword_1ElementType());

	public static final IGrammarAwareElementType Model_FavouriteAssignment_2_ELEMENT_TYPE = associate(ModelFactory.createModel_FavouriteAssignment_2ElementType());

	public static final IGrammarAwareElementType Model_FavouriteGreetingCrossReference_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FavouriteGreetingCrossReference_2_0ElementType());

	public static final IGrammarAwareElementType Model_FavouriteGreetingMyIdParserRuleCall_2_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_FavouriteGreetingMyIdParserRuleCall_2_0_1ElementType());

	private static class GreetingFactory {
		public static IGrammarAwareElementType createGreetingElementType() {
			return new IGrammarAwareElementType("Greeting_ELEMENT_TYPE", Bug362902Language.INSTANCE, GRAMMAR_ACCESS.getGreetingRule());
		}
		public static IGrammarAwareElementType createGreeting_GroupElementType() {
			return new IGrammarAwareElementType("Greeting_Group_ELEMENT_TYPE", Bug362902Language.INSTANCE, GRAMMAR_ACCESS.getGreetingAccess().getGroup());
		}
		public static IGrammarAwareElementType createGreeting_HelloKeyword_0ElementType() {
			return new IGrammarAwareElementType("Greeting_HelloKeyword_0_ELEMENT_TYPE", Bug362902Language.INSTANCE, GRAMMAR_ACCESS.getGreetingAccess().getHelloKeyword_0());
		}
		public static IGrammarAwareElementType createGreeting_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Greeting_NameAssignment_1_ELEMENT_TYPE", Bug362902Language.INSTANCE, GRAMMAR_ACCESS.getGreetingAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createGreeting_NameMyIdParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Greeting_NameMyIdParserRuleCall_1_0_ELEMENT_TYPE", Bug362902Language.INSTANCE, GRAMMAR_ACCESS.getGreetingAccess().getNameMyIdParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createGreeting_ExclamationMarkKeyword_2ElementType() {
			return new IGrammarAwareElementType("Greeting_ExclamationMarkKeyword_2_ELEMENT_TYPE", Bug362902Language.INSTANCE, GRAMMAR_ACCESS.getGreetingAccess().getExclamationMarkKeyword_2());
		}
	}

	public static final IGrammarAwareElementType Greeting_ELEMENT_TYPE = associate(GreetingFactory.createGreetingElementType());

	public static final IGrammarAwareElementType Greeting_Group_ELEMENT_TYPE = associate(GreetingFactory.createGreeting_GroupElementType());

	public static final IGrammarAwareElementType Greeting_HelloKeyword_0_ELEMENT_TYPE = associate(GreetingFactory.createGreeting_HelloKeyword_0ElementType());

	public static final IGrammarAwareElementType Greeting_NameAssignment_1_ELEMENT_TYPE = associate(GreetingFactory.createGreeting_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Greeting_NameMyIdParserRuleCall_1_0_ELEMENT_TYPE = associate(GreetingFactory.createGreeting_NameMyIdParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Greeting_ExclamationMarkKeyword_2_ELEMENT_TYPE = associate(GreetingFactory.createGreeting_ExclamationMarkKeyword_2ElementType());

	private static class MyIdFactory {
		public static IGrammarAwareElementType createMyIdElementType() {
			return new IGrammarAwareElementType("MyId_ELEMENT_TYPE", Bug362902Language.INSTANCE, GRAMMAR_ACCESS.getMyIdRule());
		}
		public static IGrammarAwareElementType createMyId_IDTerminalRuleCallElementType() {
			return new IGrammarAwareElementType("MyId_IDTerminalRuleCall_ELEMENT_TYPE", Bug362902Language.INSTANCE, GRAMMAR_ACCESS.getMyIdAccess().getIDTerminalRuleCall());
		}
	}

	public static final IGrammarAwareElementType MyId_ELEMENT_TYPE = associate(MyIdFactory.createMyIdElementType());

	public static final IGrammarAwareElementType MyId_IDTerminalRuleCall_ELEMENT_TYPE = associate(MyIdFactory.createMyId_IDTerminalRuleCallElementType());

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

	public IGrammarAwareElementType getModel_GroupElementType() {
		return Model_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_GreetingsAssignment_0ElementType() {
		return Model_GreetingsAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_GreetingsGreetingParserRuleCall_0_0ElementType() {
		return Model_GreetingsGreetingParserRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FavouriteKeyword_1ElementType() {
		return Model_FavouriteKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FavouriteAssignment_2ElementType() {
		return Model_FavouriteAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FavouriteGreetingCrossReference_2_0ElementType() {
		return Model_FavouriteGreetingCrossReference_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FavouriteGreetingMyIdParserRuleCall_2_0_1ElementType() {
		return Model_FavouriteGreetingMyIdParserRuleCall_2_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGreetingElementType() {
		return Greeting_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGreeting_GroupElementType() {
		return Greeting_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGreeting_HelloKeyword_0ElementType() {
		return Greeting_HelloKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGreeting_NameAssignment_1ElementType() {
		return Greeting_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGreeting_NameMyIdParserRuleCall_1_0ElementType() {
		return Greeting_NameMyIdParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getGreeting_ExclamationMarkKeyword_2ElementType() {
		return Greeting_ExclamationMarkKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMyIdElementType() {
		return MyId_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMyId_IDTerminalRuleCallElementType() {
		return MyId_IDTerminalRuleCall_ELEMENT_TYPE;
	}

}
