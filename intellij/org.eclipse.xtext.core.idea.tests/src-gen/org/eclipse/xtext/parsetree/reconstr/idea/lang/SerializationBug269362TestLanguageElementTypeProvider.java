package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.psi.impl.SerializationBug269362TestLanguageFileImpl;
import org.eclipse.xtext.parsetree.reconstr.services.SerializationBug269362TestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class SerializationBug269362TestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<SerializationBug269362TestLanguageFileImpl>>(SerializationBug269362TestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final SerializationBug269362TestLanguageGrammarAccess GRAMMAR_ACCESS = SerializationBug269362TestLanguageLanguage.INSTANCE.getInstance(SerializationBug269362TestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", SerializationBug269362TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_AlternativesElementType() {
			return new IGrammarAwareElementType("Model_Alternatives_ELEMENT_TYPE", SerializationBug269362TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createModel_Group_0ElementType() {
			return new IGrammarAwareElementType("Model_Group_0_ELEMENT_TYPE", SerializationBug269362TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createModel_FooKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("Model_FooKeyword_0_0_ELEMENT_TYPE", SerializationBug269362TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFooKeyword_0_0());
		}
		public static IGrammarAwareElementType createModel_FooAssignment_0_1ElementType() {
			return new IGrammarAwareElementType("Model_FooAssignment_0_1_ELEMENT_TYPE", SerializationBug269362TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFooAssignment_0_1());
		}
		public static IGrammarAwareElementType createModel_FooIDTerminalRuleCall_0_1_0ElementType() {
			return new IGrammarAwareElementType("Model_FooIDTerminalRuleCall_0_1_0_ELEMENT_TYPE", SerializationBug269362TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFooIDTerminalRuleCall_0_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_0_2ElementType() {
			return new IGrammarAwareElementType("Model_Group_0_2_ELEMENT_TYPE", SerializationBug269362TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_0_2());
		}
		public static IGrammarAwareElementType createModel_BarKeyword_0_2_0ElementType() {
			return new IGrammarAwareElementType("Model_BarKeyword_0_2_0_ELEMENT_TYPE", SerializationBug269362TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getBarKeyword_0_2_0());
		}
		public static IGrammarAwareElementType createModel_BarAssignment_0_2_1ElementType() {
			return new IGrammarAwareElementType("Model_BarAssignment_0_2_1_ELEMENT_TYPE", SerializationBug269362TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getBarAssignment_0_2_1());
		}
		public static IGrammarAwareElementType createModel_BarIDTerminalRuleCall_0_2_1_0ElementType() {
			return new IGrammarAwareElementType("Model_BarIDTerminalRuleCall_0_2_1_0_ELEMENT_TYPE", SerializationBug269362TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getBarIDTerminalRuleCall_0_2_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_1ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_ELEMENT_TYPE", SerializationBug269362TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createModel_BarKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Model_BarKeyword_1_0_ELEMENT_TYPE", SerializationBug269362TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getBarKeyword_1_0());
		}
		public static IGrammarAwareElementType createModel_BarAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Model_BarAssignment_1_1_ELEMENT_TYPE", SerializationBug269362TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getBarAssignment_1_1());
		}
		public static IGrammarAwareElementType createModel_BarIDTerminalRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_BarIDTerminalRuleCall_1_1_0_ELEMENT_TYPE", SerializationBug269362TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getBarIDTerminalRuleCall_1_1_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Alternatives_ELEMENT_TYPE = associate(ModelFactory.createModel_AlternativesElementType());

	public static final IGrammarAwareElementType Model_Group_0_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_0ElementType());

	public static final IGrammarAwareElementType Model_FooKeyword_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FooKeyword_0_0ElementType());

	public static final IGrammarAwareElementType Model_FooAssignment_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_FooAssignment_0_1ElementType());

	public static final IGrammarAwareElementType Model_FooIDTerminalRuleCall_0_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FooIDTerminalRuleCall_0_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_0_2_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_0_2ElementType());

	public static final IGrammarAwareElementType Model_BarKeyword_0_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_BarKeyword_0_2_0ElementType());

	public static final IGrammarAwareElementType Model_BarAssignment_0_2_1_ELEMENT_TYPE = associate(ModelFactory.createModel_BarAssignment_0_2_1ElementType());

	public static final IGrammarAwareElementType Model_BarIDTerminalRuleCall_0_2_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_BarIDTerminalRuleCall_0_2_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1ElementType());

	public static final IGrammarAwareElementType Model_BarKeyword_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_BarKeyword_1_0ElementType());

	public static final IGrammarAwareElementType Model_BarAssignment_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_BarAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Model_BarIDTerminalRuleCall_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_BarIDTerminalRuleCall_1_1_0ElementType());

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

	public IGrammarAwareElementType getModel_FooKeyword_0_0ElementType() {
		return Model_FooKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FooAssignment_0_1ElementType() {
		return Model_FooAssignment_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FooIDTerminalRuleCall_0_1_0ElementType() {
		return Model_FooIDTerminalRuleCall_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_0_2ElementType() {
		return Model_Group_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_BarKeyword_0_2_0ElementType() {
		return Model_BarKeyword_0_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_BarAssignment_0_2_1ElementType() {
		return Model_BarAssignment_0_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_BarIDTerminalRuleCall_0_2_1_0ElementType() {
		return Model_BarIDTerminalRuleCall_0_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1ElementType() {
		return Model_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_BarKeyword_1_0ElementType() {
		return Model_BarKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_BarAssignment_1_1ElementType() {
		return Model_BarAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_BarIDTerminalRuleCall_1_1_0ElementType() {
		return Model_BarIDTerminalRuleCall_1_1_0_ELEMENT_TYPE;
	}

}
