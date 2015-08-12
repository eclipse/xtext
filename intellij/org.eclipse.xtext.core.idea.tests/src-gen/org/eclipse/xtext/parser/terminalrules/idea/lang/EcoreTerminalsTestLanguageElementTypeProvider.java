package org.eclipse.xtext.parser.terminalrules.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.terminalrules.idea.lang.psi.impl.EcoreTerminalsTestLanguageFileImpl;
import org.eclipse.xtext.parser.terminalrules.services.EcoreTerminalsTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class EcoreTerminalsTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<EcoreTerminalsTestLanguageFileImpl>>(EcoreTerminalsTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final EcoreTerminalsTestLanguageGrammarAccess GRAMMAR_ACCESS = EcoreTerminalsTestLanguageLanguage.INSTANCE.getInstance(EcoreTerminalsTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", EcoreTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_AlternativesElementType() {
			return new IGrammarAwareElementType("Model_Alternatives_ELEMENT_TYPE", EcoreTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createModel_Group_0ElementType() {
			return new IGrammarAwareElementType("Model_Group_0_ELEMENT_TYPE", EcoreTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createModel_IntKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("Model_IntKeyword_0_0_ELEMENT_TYPE", EcoreTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getIntKeyword_0_0());
		}
		public static IGrammarAwareElementType createModel_IntValuesAssignment_0_1ElementType() {
			return new IGrammarAwareElementType("Model_IntValuesAssignment_0_1_ELEMENT_TYPE", EcoreTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getIntValuesAssignment_0_1());
		}
		public static IGrammarAwareElementType createModel_IntValuesEINTTerminalRuleCall_0_1_0ElementType() {
			return new IGrammarAwareElementType("Model_IntValuesEINTTerminalRuleCall_0_1_0_ELEMENT_TYPE", EcoreTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getIntValuesEINTTerminalRuleCall_0_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_1ElementType() {
			return new IGrammarAwareElementType("Model_Group_1_ELEMENT_TYPE", EcoreTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createModel_DoubleKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("Model_DoubleKeyword_1_0_ELEMENT_TYPE", EcoreTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDoubleKeyword_1_0());
		}
		public static IGrammarAwareElementType createModel_DoubleValuesAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Model_DoubleValuesAssignment_1_1_ELEMENT_TYPE", EcoreTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDoubleValuesAssignment_1_1());
		}
		public static IGrammarAwareElementType createModel_DoubleValuesEDOUBLETerminalRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("Model_DoubleValuesEDOUBLETerminalRuleCall_1_1_0_ELEMENT_TYPE", EcoreTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDoubleValuesEDOUBLETerminalRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createModel_Group_2ElementType() {
			return new IGrammarAwareElementType("Model_Group_2_ELEMENT_TYPE", EcoreTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createModel_DateKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("Model_DateKeyword_2_0_ELEMENT_TYPE", EcoreTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDateKeyword_2_0());
		}
		public static IGrammarAwareElementType createModel_DateValuesAssignment_2_1ElementType() {
			return new IGrammarAwareElementType("Model_DateValuesAssignment_2_1_ELEMENT_TYPE", EcoreTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDateValuesAssignment_2_1());
		}
		public static IGrammarAwareElementType createModel_DateValuesEDATETerminalRuleCall_2_1_0ElementType() {
			return new IGrammarAwareElementType("Model_DateValuesEDATETerminalRuleCall_2_1_0_ELEMENT_TYPE", EcoreTerminalsTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getDateValuesEDATETerminalRuleCall_2_1_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Alternatives_ELEMENT_TYPE = associate(ModelFactory.createModel_AlternativesElementType());

	public static final IGrammarAwareElementType Model_Group_0_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_0ElementType());

	public static final IGrammarAwareElementType Model_IntKeyword_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_IntKeyword_0_0ElementType());

	public static final IGrammarAwareElementType Model_IntValuesAssignment_0_1_ELEMENT_TYPE = associate(ModelFactory.createModel_IntValuesAssignment_0_1ElementType());

	public static final IGrammarAwareElementType Model_IntValuesEINTTerminalRuleCall_0_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_IntValuesEINTTerminalRuleCall_0_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_1_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_1ElementType());

	public static final IGrammarAwareElementType Model_DoubleKeyword_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DoubleKeyword_1_0ElementType());

	public static final IGrammarAwareElementType Model_DoubleValuesAssignment_1_1_ELEMENT_TYPE = associate(ModelFactory.createModel_DoubleValuesAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Model_DoubleValuesEDOUBLETerminalRuleCall_1_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DoubleValuesEDOUBLETerminalRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType Model_Group_2_ELEMENT_TYPE = associate(ModelFactory.createModel_Group_2ElementType());

	public static final IGrammarAwareElementType Model_DateKeyword_2_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DateKeyword_2_0ElementType());

	public static final IGrammarAwareElementType Model_DateValuesAssignment_2_1_ELEMENT_TYPE = associate(ModelFactory.createModel_DateValuesAssignment_2_1ElementType());

	public static final IGrammarAwareElementType Model_DateValuesEDATETerminalRuleCall_2_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_DateValuesEDATETerminalRuleCall_2_1_0ElementType());

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

	public IGrammarAwareElementType getModel_IntKeyword_0_0ElementType() {
		return Model_IntKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_IntValuesAssignment_0_1ElementType() {
		return Model_IntValuesAssignment_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_IntValuesEINTTerminalRuleCall_0_1_0ElementType() {
		return Model_IntValuesEINTTerminalRuleCall_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_1ElementType() {
		return Model_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DoubleKeyword_1_0ElementType() {
		return Model_DoubleKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DoubleValuesAssignment_1_1ElementType() {
		return Model_DoubleValuesAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DoubleValuesEDOUBLETerminalRuleCall_1_1_0ElementType() {
		return Model_DoubleValuesEDOUBLETerminalRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_Group_2ElementType() {
		return Model_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DateKeyword_2_0ElementType() {
		return Model_DateKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DateValuesAssignment_2_1ElementType() {
		return Model_DateValuesAssignment_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_DateValuesEDATETerminalRuleCall_2_1_0ElementType() {
		return Model_DateValuesEDATETerminalRuleCall_2_1_0_ELEMENT_TYPE;
	}

}
