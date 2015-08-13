package org.eclipse.xtext.parser.antlr.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.antlr.idea.lang.psi.impl.Bug443221TestLanguageFileImpl;
import org.eclipse.xtext.parser.antlr.services.Bug443221TestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class Bug443221TestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<Bug443221TestLanguageFileImpl>>(Bug443221TestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final Bug443221TestLanguageGrammarAccess GRAMMAR_ACCESS = Bug443221TestLanguageLanguage.INSTANCE.getInstance(Bug443221TestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", Bug443221TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_GroupElementType() {
			return new IGrammarAwareElementType("Model_Group_ELEMENT_TYPE", Bug443221TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup());
		}
		public static IGrammarAwareElementType createModel_ModelAction_0ElementType() {
			return new IGrammarAwareElementType("Model_ModelAction_0_ELEMENT_TYPE", Bug443221TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getModelAction_0());
		}
		public static IGrammarAwareElementType createModel_DummyKeyword_1ElementType() {
			return new IGrammarAwareElementType("Model_DummyKeyword_1_ELEMENT_TYPE", Bug443221TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDummyKeyword_1());
		}
		public static IGrammarAwareElementType createModel_NameAssignment_2ElementType() {
			return new IGrammarAwareElementType("Model_NameAssignment_2_ELEMENT_TYPE", Bug443221TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNameAssignment_2());
		}
		public static IGrammarAwareElementType createModel_NameIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Model_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE", Bug443221TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNameIDTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createModel__Keyword_3ElementType() {
			return new IGrammarAwareElementType("Model__Keyword_3_ELEMENT_TYPE", Bug443221TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().get_Keyword_3());
		}
		public static IGrammarAwareElementType createModel__dummy_Keyword_4ElementType() {
			return new IGrammarAwareElementType("Model__dummy_Keyword_4_ELEMENT_TYPE", Bug443221TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().get_dummy_Keyword_4());
		}
		public static IGrammarAwareElementType createModel___dummy__Keyword_5ElementType() {
			return new IGrammarAwareElementType("Model___dummy__Keyword_5_ELEMENT_TYPE", Bug443221TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().get__dummy__Keyword_5());
		}
		public static IGrammarAwareElementType createModel___dummy__Keyword_6ElementType() {
			return new IGrammarAwareElementType("Model___dummy__Keyword_6_ELEMENT_TYPE", Bug443221TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().get__dummy__Keyword_6());
		}
		public static IGrammarAwareElementType createModel_DollarSignKeyword_7ElementType() {
			return new IGrammarAwareElementType("Model_DollarSignKeyword_7_ELEMENT_TYPE", Bug443221TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDollarSignKeyword_7());
		}
		public static IGrammarAwareElementType createModel_DollarSignKeyword_8ElementType() {
			return new IGrammarAwareElementType("Model_DollarSignKeyword_8_ELEMENT_TYPE", Bug443221TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDollarSignKeyword_8());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Group_ELEMENT_TYPE = associate(ModelFactory.createModel_GroupElementType());

	public static final IGrammarAwareElementType Model_ModelAction_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ModelAction_0ElementType());

	public static final IGrammarAwareElementType Model_DummyKeyword_1_ELEMENT_TYPE = associate(ModelFactory.createModel_DummyKeyword_1ElementType());

	public static final IGrammarAwareElementType Model_NameAssignment_2_ELEMENT_TYPE = associate(ModelFactory.createModel_NameAssignment_2ElementType());

	public static final IGrammarAwareElementType Model_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NameIDTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType Model__Keyword_3_ELEMENT_TYPE = associate(ModelFactory.createModel__Keyword_3ElementType());

	public static final IGrammarAwareElementType Model__dummy_Keyword_4_ELEMENT_TYPE = associate(ModelFactory.createModel__dummy_Keyword_4ElementType());

	public static final IGrammarAwareElementType Model___dummy__Keyword_5_ELEMENT_TYPE = associate(ModelFactory.createModel___dummy__Keyword_5ElementType());

	public static final IGrammarAwareElementType Model___dummy__Keyword_6_ELEMENT_TYPE = associate(ModelFactory.createModel___dummy__Keyword_6ElementType());

	public static final IGrammarAwareElementType Model_DollarSignKeyword_7_ELEMENT_TYPE = associate(ModelFactory.createModel_DollarSignKeyword_7ElementType());

	public static final IGrammarAwareElementType Model_DollarSignKeyword_8_ELEMENT_TYPE = associate(ModelFactory.createModel_DollarSignKeyword_8ElementType());

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

	public IGrammarAwareElementType getModel_ModelAction_0ElementType() {
		return Model_ModelAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DummyKeyword_1ElementType() {
		return Model_DummyKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NameAssignment_2ElementType() {
		return Model_NameAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NameIDTerminalRuleCall_2_0ElementType() {
		return Model_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel__Keyword_3ElementType() {
		return Model__Keyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel__dummy_Keyword_4ElementType() {
		return Model__dummy_Keyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel___dummy__Keyword_5ElementType() {
		return Model___dummy__Keyword_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel___dummy__Keyword_6ElementType() {
		return Model___dummy__Keyword_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DollarSignKeyword_7ElementType() {
		return Model_DollarSignKeyword_7_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DollarSignKeyword_8ElementType() {
		return Model_DollarSignKeyword_8_ELEMENT_TYPE;
	}

}
