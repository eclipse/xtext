package org.eclipse.xtext.parser.antlr.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.antlr.idea.lang.psi.impl.Bug301935ExTestLanguageFileImpl;
import org.eclipse.xtext.parser.antlr.services.Bug301935ExTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class Bug301935ExTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<Bug301935ExTestLanguageFileImpl>>(Bug301935ExTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final Bug301935ExTestLanguageGrammarAccess GRAMMAR_ACCESS = Bug301935ExTestLanguageLanguage.INSTANCE.getInstance(Bug301935ExTestLanguageGrammarAccess.class);

	private static class DelegateModelFactory {
		public static IGrammarAwareElementType createDelegateModelElementType() {
			return new IGrammarAwareElementType("DelegateModel_ELEMENT_TYPE", Bug301935ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDelegateModelRule());
		}
		public static IGrammarAwareElementType createDelegateModel_ModelParserRuleCallElementType() {
			return new IGrammarAwareElementType("DelegateModel_ModelParserRuleCall_ELEMENT_TYPE", Bug301935ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getDelegateModelAccess().getModelParserRuleCall());
		}
	}

	public static final IGrammarAwareElementType DelegateModel_ELEMENT_TYPE = associate(DelegateModelFactory.createDelegateModelElementType());

	public static final IGrammarAwareElementType DelegateModel_ModelParserRuleCall_ELEMENT_TYPE = associate(DelegateModelFactory.createDelegateModel_ModelParserRuleCallElementType());

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", Bug301935ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_GroupElementType() {
			return new IGrammarAwareElementType("Model_Group_ELEMENT_TYPE", Bug301935ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup());
		}
		public static IGrammarAwareElementType createModel_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("Model_NameAssignment_0_ELEMENT_TYPE", Bug301935ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createModel_NameIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Model_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE", Bug301935ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNameIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createModel_WSTerminalRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Model_WSTerminalRuleCall_1_ELEMENT_TYPE", Bug301935ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getWSTerminalRuleCall_1());
		}
		public static IGrammarAwareElementType createModel_ValueAssignment_2ElementType() {
			return new IGrammarAwareElementType("Model_ValueAssignment_2_ELEMENT_TYPE", Bug301935ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueAssignment_2());
		}
		public static IGrammarAwareElementType createModel_ValueIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Model_ValueIDTerminalRuleCall_2_0_ELEMENT_TYPE", Bug301935ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueIDTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createModel_NLParserRuleCall_3ElementType() {
			return new IGrammarAwareElementType("Model_NLParserRuleCall_3_ELEMENT_TYPE", Bug301935ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getNLParserRuleCall_3());
		}
		public static IGrammarAwareElementType createModel_Value2Assignment_4ElementType() {
			return new IGrammarAwareElementType("Model_Value2Assignment_4_ELEMENT_TYPE", Bug301935ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValue2Assignment_4());
		}
		public static IGrammarAwareElementType createModel_Value2IDTerminalRuleCall_4_0ElementType() {
			return new IGrammarAwareElementType("Model_Value2IDTerminalRuleCall_4_0_ELEMENT_TYPE", Bug301935ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValue2IDTerminalRuleCall_4_0());
		}
		public static IGrammarAwareElementType createModel_WSTerminalRuleCall_5ElementType() {
			return new IGrammarAwareElementType("Model_WSTerminalRuleCall_5_ELEMENT_TYPE", Bug301935ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getWSTerminalRuleCall_5());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Group_ELEMENT_TYPE = associate(ModelFactory.createModel_GroupElementType());

	public static final IGrammarAwareElementType Model_NameAssignment_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType Model_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_NameIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Model_WSTerminalRuleCall_1_ELEMENT_TYPE = associate(ModelFactory.createModel_WSTerminalRuleCall_1ElementType());

	public static final IGrammarAwareElementType Model_ValueAssignment_2_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueAssignment_2ElementType());

	public static final IGrammarAwareElementType Model_ValueIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueIDTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType Model_NLParserRuleCall_3_ELEMENT_TYPE = associate(ModelFactory.createModel_NLParserRuleCall_3ElementType());

	public static final IGrammarAwareElementType Model_Value2Assignment_4_ELEMENT_TYPE = associate(ModelFactory.createModel_Value2Assignment_4ElementType());

	public static final IGrammarAwareElementType Model_Value2IDTerminalRuleCall_4_0_ELEMENT_TYPE = associate(ModelFactory.createModel_Value2IDTerminalRuleCall_4_0ElementType());

	public static final IGrammarAwareElementType Model_WSTerminalRuleCall_5_ELEMENT_TYPE = associate(ModelFactory.createModel_WSTerminalRuleCall_5ElementType());

	private static class NLFactory {
		public static IGrammarAwareElementType createNLElementType() {
			return new IGrammarAwareElementType("NL_ELEMENT_TYPE", Bug301935ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNLRule());
		}
		public static IGrammarAwareElementType createNL_GroupElementType() {
			return new IGrammarAwareElementType("NL_Group_ELEMENT_TYPE", Bug301935ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNLAccess().getGroup());
		}
		public static IGrammarAwareElementType createNL_WSTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("NL_WSTerminalRuleCall_0_ELEMENT_TYPE", Bug301935ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNLAccess().getWSTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createNL_Group_1ElementType() {
			return new IGrammarAwareElementType("NL_Group_1_ELEMENT_TYPE", Bug301935ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNLAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createNL_Control000dKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("NL_Control000dKeyword_1_0_ELEMENT_TYPE", Bug301935ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNLAccess().getControl000dKeyword_1_0());
		}
		public static IGrammarAwareElementType createNL_Control000aKeyword_1_1ElementType() {
			return new IGrammarAwareElementType("NL_Control000aKeyword_1_1_ELEMENT_TYPE", Bug301935ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNLAccess().getControl000aKeyword_1_1());
		}
		public static IGrammarAwareElementType createNL_WSTerminalRuleCall_2ElementType() {
			return new IGrammarAwareElementType("NL_WSTerminalRuleCall_2_ELEMENT_TYPE", Bug301935ExTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNLAccess().getWSTerminalRuleCall_2());
		}
	}

	public static final IGrammarAwareElementType NL_ELEMENT_TYPE = associate(NLFactory.createNLElementType());

	public static final IGrammarAwareElementType NL_Group_ELEMENT_TYPE = associate(NLFactory.createNL_GroupElementType());

	public static final IGrammarAwareElementType NL_WSTerminalRuleCall_0_ELEMENT_TYPE = associate(NLFactory.createNL_WSTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType NL_Group_1_ELEMENT_TYPE = associate(NLFactory.createNL_Group_1ElementType());

	public static final IGrammarAwareElementType NL_Control000dKeyword_1_0_ELEMENT_TYPE = associate(NLFactory.createNL_Control000dKeyword_1_0ElementType());

	public static final IGrammarAwareElementType NL_Control000aKeyword_1_1_ELEMENT_TYPE = associate(NLFactory.createNL_Control000aKeyword_1_1ElementType());

	public static final IGrammarAwareElementType NL_WSTerminalRuleCall_2_ELEMENT_TYPE = associate(NLFactory.createNL_WSTerminalRuleCall_2ElementType());

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

	public IGrammarAwareElementType getModel_NameAssignment_0ElementType() {
		return Model_NameAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NameIDTerminalRuleCall_0_0ElementType() {
		return Model_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_WSTerminalRuleCall_1ElementType() {
		return Model_WSTerminalRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueAssignment_2ElementType() {
		return Model_ValueAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueIDTerminalRuleCall_2_0ElementType() {
		return Model_ValueIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_NLParserRuleCall_3ElementType() {
		return Model_NLParserRuleCall_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Value2Assignment_4ElementType() {
		return Model_Value2Assignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Value2IDTerminalRuleCall_4_0ElementType() {
		return Model_Value2IDTerminalRuleCall_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_WSTerminalRuleCall_5ElementType() {
		return Model_WSTerminalRuleCall_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNLElementType() {
		return NL_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNL_GroupElementType() {
		return NL_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNL_WSTerminalRuleCall_0ElementType() {
		return NL_WSTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNL_Group_1ElementType() {
		return NL_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNL_Control000dKeyword_1_0ElementType() {
		return NL_Control000dKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNL_Control000aKeyword_1_1ElementType() {
		return NL_Control000aKeyword_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNL_WSTerminalRuleCall_2ElementType() {
		return NL_WSTerminalRuleCall_2_ELEMENT_TYPE;
	}

}
