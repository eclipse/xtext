package org.eclipse.xtext.valueconverter.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.valueconverter.idea.lang.psi.impl.QualifiedNameTestLanguageFileImpl;
import org.eclipse.xtext.valueconverter.services.QualifiedNameTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class QualifiedNameTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<QualifiedNameTestLanguageFileImpl>>(QualifiedNameTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final QualifiedNameTestLanguageGrammarAccess GRAMMAR_ACCESS = QualifiedNameTestLanguageLanguage.INSTANCE.getInstance(QualifiedNameTestLanguageGrammarAccess.class);

	private static class ElementFactory {
		public static IGrammarAwareElementType createElementElementType() {
			return new IGrammarAwareElementType("Element_ELEMENT_TYPE", QualifiedNameTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementRule());
		}
		public static IGrammarAwareElementType createElement_GroupElementType() {
			return new IGrammarAwareElementType("Element_Group_ELEMENT_TYPE", QualifiedNameTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getGroup());
		}
		public static IGrammarAwareElementType createElement_KeywordKeyword_0ElementType() {
			return new IGrammarAwareElementType("Element_KeywordKeyword_0_ELEMENT_TYPE", QualifiedNameTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getKeywordKeyword_0());
		}
		public static IGrammarAwareElementType createElement_QualifiedNameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Element_QualifiedNameAssignment_1_ELEMENT_TYPE", QualifiedNameTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getQualifiedNameAssignment_1());
		}
		public static IGrammarAwareElementType createElement_QualifiedNameQualifiedNameParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Element_QualifiedNameQualifiedNameParserRuleCall_1_0_ELEMENT_TYPE", QualifiedNameTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getElementAccess().getQualifiedNameQualifiedNameParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Element_ELEMENT_TYPE = associate(ElementFactory.createElementElementType());

	public static final IGrammarAwareElementType Element_Group_ELEMENT_TYPE = associate(ElementFactory.createElement_GroupElementType());

	public static final IGrammarAwareElementType Element_KeywordKeyword_0_ELEMENT_TYPE = associate(ElementFactory.createElement_KeywordKeyword_0ElementType());

	public static final IGrammarAwareElementType Element_QualifiedNameAssignment_1_ELEMENT_TYPE = associate(ElementFactory.createElement_QualifiedNameAssignment_1ElementType());

	public static final IGrammarAwareElementType Element_QualifiedNameQualifiedNameParserRuleCall_1_0_ELEMENT_TYPE = associate(ElementFactory.createElement_QualifiedNameQualifiedNameParserRuleCall_1_0ElementType());

	private static class QualifiedNameFactory {
		public static IGrammarAwareElementType createQualifiedNameElementType() {
			return new IGrammarAwareElementType("QualifiedName_ELEMENT_TYPE", QualifiedNameTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameRule());
		}
		public static IGrammarAwareElementType createQualifiedName_GroupElementType() {
			return new IGrammarAwareElementType("QualifiedName_Group_ELEMENT_TYPE", QualifiedNameTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameAccess().getGroup());
		}
		public static IGrammarAwareElementType createQualifiedName_IDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("QualifiedName_IDTerminalRuleCall_0_ELEMENT_TYPE", QualifiedNameTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameAccess().getIDTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createQualifiedName_Group_1ElementType() {
			return new IGrammarAwareElementType("QualifiedName_Group_1_ELEMENT_TYPE", QualifiedNameTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createQualifiedName_FullStopKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("QualifiedName_FullStopKeyword_1_0_ELEMENT_TYPE", QualifiedNameTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameAccess().getFullStopKeyword_1_0());
		}
		public static IGrammarAwareElementType createQualifiedName_IDTerminalRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("QualifiedName_IDTerminalRuleCall_1_1_ELEMENT_TYPE", QualifiedNameTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
		}
		public static IGrammarAwareElementType createQualifiedName_Group_2ElementType() {
			return new IGrammarAwareElementType("QualifiedName_Group_2_ELEMENT_TYPE", QualifiedNameTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createQualifiedName_FullStopKeyword_2_0ElementType() {
			return new IGrammarAwareElementType("QualifiedName_FullStopKeyword_2_0_ELEMENT_TYPE", QualifiedNameTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameAccess().getFullStopKeyword_2_0());
		}
		public static IGrammarAwareElementType createQualifiedName_AsteriskKeyword_2_1ElementType() {
			return new IGrammarAwareElementType("QualifiedName_AsteriskKeyword_2_1_ELEMENT_TYPE", QualifiedNameTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameAccess().getAsteriskKeyword_2_1());
		}
	}

	public static final IGrammarAwareElementType QualifiedName_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedNameElementType());

	public static final IGrammarAwareElementType QualifiedName_Group_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedName_GroupElementType());

	public static final IGrammarAwareElementType QualifiedName_IDTerminalRuleCall_0_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedName_IDTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType QualifiedName_Group_1_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedName_Group_1ElementType());

	public static final IGrammarAwareElementType QualifiedName_FullStopKeyword_1_0_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedName_FullStopKeyword_1_0ElementType());

	public static final IGrammarAwareElementType QualifiedName_IDTerminalRuleCall_1_1_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedName_IDTerminalRuleCall_1_1ElementType());

	public static final IGrammarAwareElementType QualifiedName_Group_2_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedName_Group_2ElementType());

	public static final IGrammarAwareElementType QualifiedName_FullStopKeyword_2_0_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedName_FullStopKeyword_2_0ElementType());

	public static final IGrammarAwareElementType QualifiedName_AsteriskKeyword_2_1_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedName_AsteriskKeyword_2_1ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getElementElementType() {
		return Element_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_GroupElementType() {
		return Element_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_KeywordKeyword_0ElementType() {
		return Element_KeywordKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_QualifiedNameAssignment_1ElementType() {
		return Element_QualifiedNameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getElement_QualifiedNameQualifiedNameParserRuleCall_1_0ElementType() {
		return Element_QualifiedNameQualifiedNameParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQualifiedNameElementType() {
		return QualifiedName_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQualifiedName_GroupElementType() {
		return QualifiedName_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQualifiedName_IDTerminalRuleCall_0ElementType() {
		return QualifiedName_IDTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQualifiedName_Group_1ElementType() {
		return QualifiedName_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQualifiedName_FullStopKeyword_1_0ElementType() {
		return QualifiedName_FullStopKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQualifiedName_IDTerminalRuleCall_1_1ElementType() {
		return QualifiedName_IDTerminalRuleCall_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQualifiedName_Group_2ElementType() {
		return QualifiedName_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQualifiedName_FullStopKeyword_2_0ElementType() {
		return QualifiedName_FullStopKeyword_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQualifiedName_AsteriskKeyword_2_1ElementType() {
		return QualifiedName_AsteriskKeyword_2_1_ELEMENT_TYPE;
	}

}
