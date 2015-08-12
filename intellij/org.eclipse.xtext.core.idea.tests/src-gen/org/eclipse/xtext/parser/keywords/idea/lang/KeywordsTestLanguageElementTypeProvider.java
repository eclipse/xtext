package org.eclipse.xtext.parser.keywords.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.keywords.idea.lang.psi.impl.KeywordsTestLanguageFileImpl;
import org.eclipse.xtext.parser.keywords.services.KeywordsTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class KeywordsTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<KeywordsTestLanguageFileImpl>>(KeywordsTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final KeywordsTestLanguageGrammarAccess GRAMMAR_ACCESS = KeywordsTestLanguageLanguage.INSTANCE.getInstance(KeywordsTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", KeywordsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_AlternativesElementType() {
			return new IGrammarAwareElementType("Model_Alternatives_ELEMENT_TYPE", KeywordsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createModel_FirstAssignment_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstAssignment_0_ELEMENT_TYPE", KeywordsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstAssignment_0());
		}
		public static IGrammarAwareElementType createModel_FirstFooBarKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("Model_FirstFooBarKeyword_0_0_ELEMENT_TYPE", KeywordsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFirstFooBarKeyword_0_0());
		}
		public static IGrammarAwareElementType createModel_SecondAssignment_1ElementType() {
			return new IGrammarAwareElementType("Model_SecondAssignment_1_ELEMENT_TYPE", KeywordsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondAssignment_1());
		}
		public static IGrammarAwareElementType createModel_SecondFooKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Model_SecondFooKeyword_1_0_ELEMENT_TYPE", KeywordsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSecondFooKeyword_1_0());
		}
		public static IGrammarAwareElementType createModel_ThirdAssignment_2ElementType() {
			return new IGrammarAwareElementType("Model_ThirdAssignment_2_ELEMENT_TYPE", KeywordsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getThirdAssignment_2());
		}
		public static IGrammarAwareElementType createModel_ThirdBarKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Model_ThirdBarKeyword_2_0_ELEMENT_TYPE", KeywordsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getThirdBarKeyword_2_0());
		}
		public static IGrammarAwareElementType createModel_ForthAssignment_3ElementType() {
			return new IGrammarAwareElementType("Model_ForthAssignment_3_ELEMENT_TYPE", KeywordsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getForthAssignment_3());
		}
		public static IGrammarAwareElementType createModel_ForthReverseSolidusKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("Model_ForthReverseSolidusKeyword_3_0_ELEMENT_TYPE", KeywordsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getForthReverseSolidusKeyword_3_0());
		}
		public static IGrammarAwareElementType createModel_FifthAssignment_4ElementType() {
			return new IGrammarAwareElementType("Model_FifthAssignment_4_ELEMENT_TYPE", KeywordsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFifthAssignment_4());
		}
		public static IGrammarAwareElementType createModel_FifthAKeyword_4_0ElementType() {
			return new IGrammarAwareElementType("Model_FifthAKeyword_4_0_ELEMENT_TYPE", KeywordsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFifthAKeyword_4_0());
		}
		public static IGrammarAwareElementType createModel_SixthAssignment_5ElementType() {
			return new IGrammarAwareElementType("Model_SixthAssignment_5_ELEMENT_TYPE", KeywordsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSixthAssignment_5());
		}
		public static IGrammarAwareElementType createModel_SixthBKeyword_5_0ElementType() {
			return new IGrammarAwareElementType("Model_SixthBKeyword_5_0_ELEMENT_TYPE", KeywordsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSixthBKeyword_5_0());
		}
		public static IGrammarAwareElementType createModel_SeventhAssignment_6ElementType() {
			return new IGrammarAwareElementType("Model_SeventhAssignment_6_ELEMENT_TYPE", KeywordsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSeventhAssignment_6());
		}
		public static IGrammarAwareElementType createModel_SeventhCKeyword_6_0ElementType() {
			return new IGrammarAwareElementType("Model_SeventhCKeyword_6_0_ELEMENT_TYPE", KeywordsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getSeventhCKeyword_6_0());
		}
		public static IGrammarAwareElementType createModel_EighthAssignment_7ElementType() {
			return new IGrammarAwareElementType("Model_EighthAssignment_7_ELEMENT_TYPE", KeywordsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getEighthAssignment_7());
		}
		public static IGrammarAwareElementType createModel_EighthDKeyword_7_0ElementType() {
			return new IGrammarAwareElementType("Model_EighthDKeyword_7_0_ELEMENT_TYPE", KeywordsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getEighthDKeyword_7_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Alternatives_ELEMENT_TYPE = associate(ModelFactory.createModel_AlternativesElementType());

	public static final IGrammarAwareElementType Model_FirstAssignment_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstAssignment_0ElementType());

	public static final IGrammarAwareElementType Model_FirstFooBarKeyword_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FirstFooBarKeyword_0_0ElementType());

	public static final IGrammarAwareElementType Model_SecondAssignment_1_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondAssignment_1ElementType());

	public static final IGrammarAwareElementType Model_SecondFooKeyword_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SecondFooKeyword_1_0ElementType());

	public static final IGrammarAwareElementType Model_ThirdAssignment_2_ELEMENT_TYPE = associate(ModelFactory.createModel_ThirdAssignment_2ElementType());

	public static final IGrammarAwareElementType Model_ThirdBarKeyword_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ThirdBarKeyword_2_0ElementType());

	public static final IGrammarAwareElementType Model_ForthAssignment_3_ELEMENT_TYPE = associate(ModelFactory.createModel_ForthAssignment_3ElementType());

	public static final IGrammarAwareElementType Model_ForthReverseSolidusKeyword_3_0_ELEMENT_TYPE = associate(ModelFactory.createModel_ForthReverseSolidusKeyword_3_0ElementType());

	public static final IGrammarAwareElementType Model_FifthAssignment_4_ELEMENT_TYPE = associate(ModelFactory.createModel_FifthAssignment_4ElementType());

	public static final IGrammarAwareElementType Model_FifthAKeyword_4_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FifthAKeyword_4_0ElementType());

	public static final IGrammarAwareElementType Model_SixthAssignment_5_ELEMENT_TYPE = associate(ModelFactory.createModel_SixthAssignment_5ElementType());

	public static final IGrammarAwareElementType Model_SixthBKeyword_5_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SixthBKeyword_5_0ElementType());

	public static final IGrammarAwareElementType Model_SeventhAssignment_6_ELEMENT_TYPE = associate(ModelFactory.createModel_SeventhAssignment_6ElementType());

	public static final IGrammarAwareElementType Model_SeventhCKeyword_6_0_ELEMENT_TYPE = associate(ModelFactory.createModel_SeventhCKeyword_6_0ElementType());

	public static final IGrammarAwareElementType Model_EighthAssignment_7_ELEMENT_TYPE = associate(ModelFactory.createModel_EighthAssignment_7ElementType());

	public static final IGrammarAwareElementType Model_EighthDKeyword_7_0_ELEMENT_TYPE = associate(ModelFactory.createModel_EighthDKeyword_7_0ElementType());

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

	public IGrammarAwareElementType getModel_FirstAssignment_0ElementType() {
		return Model_FirstAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FirstFooBarKeyword_0_0ElementType() {
		return Model_FirstFooBarKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondAssignment_1ElementType() {
		return Model_SecondAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SecondFooKeyword_1_0ElementType() {
		return Model_SecondFooKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ThirdAssignment_2ElementType() {
		return Model_ThirdAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ThirdBarKeyword_2_0ElementType() {
		return Model_ThirdBarKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ForthAssignment_3ElementType() {
		return Model_ForthAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_ForthReverseSolidusKeyword_3_0ElementType() {
		return Model_ForthReverseSolidusKeyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FifthAssignment_4ElementType() {
		return Model_FifthAssignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FifthAKeyword_4_0ElementType() {
		return Model_FifthAKeyword_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SixthAssignment_5ElementType() {
		return Model_SixthAssignment_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SixthBKeyword_5_0ElementType() {
		return Model_SixthBKeyword_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SeventhAssignment_6ElementType() {
		return Model_SeventhAssignment_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_SeventhCKeyword_6_0ElementType() {
		return Model_SeventhCKeyword_6_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_EighthAssignment_7ElementType() {
		return Model_EighthAssignment_7_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_EighthDKeyword_7_0ElementType() {
		return Model_EighthDKeyword_7_0_ELEMENT_TYPE;
	}

}
