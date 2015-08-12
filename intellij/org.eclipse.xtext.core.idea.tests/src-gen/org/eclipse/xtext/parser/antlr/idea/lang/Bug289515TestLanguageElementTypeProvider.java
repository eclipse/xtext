package org.eclipse.xtext.parser.antlr.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.antlr.idea.lang.psi.impl.Bug289515TestLanguageFileImpl;
import org.eclipse.xtext.parser.antlr.services.Bug289515TestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class Bug289515TestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<Bug289515TestLanguageFileImpl>>(Bug289515TestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final Bug289515TestLanguageGrammarAccess GRAMMAR_ACCESS = Bug289515TestLanguageLanguage.INSTANCE.getInstance(Bug289515TestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_AlternativesElementType() {
			return new IGrammarAwareElementType("Model_Alternatives_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createModel_Group_0ElementType() {
			return new IGrammarAwareElementType("Model_Group_0_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createModel_DigitOneKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitOneKeyword_0_0_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitOneKeyword_0_0());
		}
		public static IGrammarAwareElementType createModel_ValueAssignment_0_1ElementType() {
			return new IGrammarAwareElementType("Model_ValueAssignment_0_1_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueAssignment_0_1());
		}
		public static IGrammarAwareElementType createModel_ValuePercentSignKeyword_0_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ValuePercentSignKeyword_0_1_0_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValuePercentSignKeyword_0_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_1ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createModel_DigitTwoKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitTwoKeyword_1_0_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitTwoKeyword_1_0());
		}
		public static IGrammarAwareElementType createModel_ValueAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Model_ValueAssignment_1_1_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueAssignment_1_1());
		}
		public static IGrammarAwareElementType createModel_ValuePercentSignKeyword_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ValuePercentSignKeyword_1_1_0_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValuePercentSignKeyword_1_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_2ElementType() {
			return new IGrammarAwareElementType("Model_Group_2_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createModel_DigitThreeKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitThreeKeyword_2_0_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitThreeKeyword_2_0());
		}
		public static IGrammarAwareElementType createModel_ValueAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("Model_ValueAssignment_2_1_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueAssignment_2_1());
		}
		public static IGrammarAwareElementType createModel_ValueReverseSolidusPercentSignKeyword_2_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ValueReverseSolidusPercentSignKeyword_2_1_0_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueReverseSolidusPercentSignKeyword_2_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_3ElementType() {
			return new IGrammarAwareElementType("Model_Group_3_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createModel_DigitFourKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitFourKeyword_3_0_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitFourKeyword_3_0());
		}
		public static IGrammarAwareElementType createModel_ValueAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("Model_ValueAssignment_3_1_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueAssignment_3_1());
		}
		public static IGrammarAwareElementType createModel_ValueReverseSolidusPercentSignKeyword_3_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ValueReverseSolidusPercentSignKeyword_3_1_0_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueReverseSolidusPercentSignKeyword_3_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_4ElementType() {
			return new IGrammarAwareElementType("Model_Group_4_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_4());
		}
		public static IGrammarAwareElementType createModel_DigitFiveKeyword_4_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitFiveKeyword_4_0_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitFiveKeyword_4_0());
		}
		public static IGrammarAwareElementType createModel_ValueAssignment_4_1ElementType() {
			return new IGrammarAwareElementType("Model_ValueAssignment_4_1_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueAssignment_4_1());
		}
		public static IGrammarAwareElementType createModel_ValuePercentSignPercentSignKeyword_4_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ValuePercentSignPercentSignKeyword_4_1_0_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValuePercentSignPercentSignKeyword_4_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_5ElementType() {
			return new IGrammarAwareElementType("Model_Group_5_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_5());
		}
		public static IGrammarAwareElementType createModel_DigitSixKeyword_5_0ElementType() {
			return new IGrammarAwareElementType("Model_DigitSixKeyword_5_0_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDigitSixKeyword_5_0());
		}
		public static IGrammarAwareElementType createModel_ValueAssignment_5_1ElementType() {
			return new IGrammarAwareElementType("Model_ValueAssignment_5_1_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValueAssignment_5_1());
		}
		public static IGrammarAwareElementType createModel_ValuePercentSignPercentSignKeyword_5_1_0ElementType() {
			return new IGrammarAwareElementType("Model_ValuePercentSignPercentSignKeyword_5_1_0_ELEMENT_TYPE", Bug289515TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getValuePercentSignPercentSignKeyword_5_1_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Alternatives_ELEMENT_TYPE = associate(ModelFactory.createModel_AlternativesElementType());

	public static final IGrammarAwareElementType Model_Group_0_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_0ElementType());

	public static final IGrammarAwareElementType Model_DigitOneKeyword_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitOneKeyword_0_0ElementType());

	public static final IGrammarAwareElementType Model_ValueAssignment_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueAssignment_0_1ElementType());

	public static final IGrammarAwareElementType Model_ValuePercentSignKeyword_0_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ValuePercentSignKeyword_0_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1ElementType());

	public static final IGrammarAwareElementType Model_DigitTwoKeyword_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitTwoKeyword_1_0ElementType());

	public static final IGrammarAwareElementType Model_ValueAssignment_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Model_ValuePercentSignKeyword_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ValuePercentSignKeyword_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_2_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_2ElementType());

	public static final IGrammarAwareElementType Model_DigitThreeKeyword_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitThreeKeyword_2_0ElementType());

	public static final IGrammarAwareElementType Model_ValueAssignment_2_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueAssignment_2_1ElementType());

	public static final IGrammarAwareElementType Model_ValueReverseSolidusPercentSignKeyword_2_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueReverseSolidusPercentSignKeyword_2_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_3_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_3ElementType());

	public static final IGrammarAwareElementType Model_DigitFourKeyword_3_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitFourKeyword_3_0ElementType());

	public static final IGrammarAwareElementType Model_ValueAssignment_3_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueAssignment_3_1ElementType());

	public static final IGrammarAwareElementType Model_ValueReverseSolidusPercentSignKeyword_3_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueReverseSolidusPercentSignKeyword_3_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_4_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_4ElementType());

	public static final IGrammarAwareElementType Model_DigitFiveKeyword_4_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitFiveKeyword_4_0ElementType());

	public static final IGrammarAwareElementType Model_ValueAssignment_4_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueAssignment_4_1ElementType());

	public static final IGrammarAwareElementType Model_ValuePercentSignPercentSignKeyword_4_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ValuePercentSignPercentSignKeyword_4_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_5_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_5ElementType());

	public static final IGrammarAwareElementType Model_DigitSixKeyword_5_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DigitSixKeyword_5_0ElementType());

	public static final IGrammarAwareElementType Model_ValueAssignment_5_1_ELEMENT_TYPE = associate(ModelFactory.createModel_ValueAssignment_5_1ElementType());

	public static final IGrammarAwareElementType Model_ValuePercentSignPercentSignKeyword_5_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ValuePercentSignPercentSignKeyword_5_1_0ElementType());

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

	public IGrammarAwareElementType getModel_AlternativesElementType() {
		return Model_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_0ElementType() {
		return Model_Group_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitOneKeyword_0_0ElementType() {
		return Model_DigitOneKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueAssignment_0_1ElementType() {
		return Model_ValueAssignment_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValuePercentSignKeyword_0_1_0ElementType() {
		return Model_ValuePercentSignKeyword_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1ElementType() {
		return Model_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitTwoKeyword_1_0ElementType() {
		return Model_DigitTwoKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueAssignment_1_1ElementType() {
		return Model_ValueAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValuePercentSignKeyword_1_1_0ElementType() {
		return Model_ValuePercentSignKeyword_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_2ElementType() {
		return Model_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitThreeKeyword_2_0ElementType() {
		return Model_DigitThreeKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueAssignment_2_1ElementType() {
		return Model_ValueAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueReverseSolidusPercentSignKeyword_2_1_0ElementType() {
		return Model_ValueReverseSolidusPercentSignKeyword_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_3ElementType() {
		return Model_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitFourKeyword_3_0ElementType() {
		return Model_DigitFourKeyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueAssignment_3_1ElementType() {
		return Model_ValueAssignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueReverseSolidusPercentSignKeyword_3_1_0ElementType() {
		return Model_ValueReverseSolidusPercentSignKeyword_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_4ElementType() {
		return Model_Group_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitFiveKeyword_4_0ElementType() {
		return Model_DigitFiveKeyword_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueAssignment_4_1ElementType() {
		return Model_ValueAssignment_4_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValuePercentSignPercentSignKeyword_4_1_0ElementType() {
		return Model_ValuePercentSignPercentSignKeyword_4_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_5ElementType() {
		return Model_Group_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DigitSixKeyword_5_0ElementType() {
		return Model_DigitSixKeyword_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValueAssignment_5_1ElementType() {
		return Model_ValueAssignment_5_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ValuePercentSignPercentSignKeyword_5_1_0ElementType() {
		return Model_ValuePercentSignPercentSignKeyword_5_1_0_ELEMENT_TYPE;
	}

}
