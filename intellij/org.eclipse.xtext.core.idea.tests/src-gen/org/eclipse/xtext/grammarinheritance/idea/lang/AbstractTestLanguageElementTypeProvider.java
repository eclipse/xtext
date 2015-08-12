package org.eclipse.xtext.grammarinheritance.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.grammarinheritance.idea.lang.psi.impl.AbstractTestLanguageFileImpl;
import org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class AbstractTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<AbstractTestLanguageFileImpl>>(AbstractTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final AbstractTestLanguageGrammarAccess GRAMMAR_ACCESS = AbstractTestLanguageLanguage.INSTANCE.getInstance(AbstractTestLanguageGrammarAccess.class);

	private static class InheritedParserRuleFactory {
		public static IGrammarAwareElementType createInheritedParserRuleElementType() {
			return new IGrammarAwareElementType("InheritedParserRule_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritedParserRuleRule());
		}
		public static IGrammarAwareElementType createInheritedParserRule_GroupElementType() {
			return new IGrammarAwareElementType("InheritedParserRule_Group_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritedParserRuleAccess().getGroup());
		}
		public static IGrammarAwareElementType createInheritedParserRule_ElementKeyword_0ElementType() {
			return new IGrammarAwareElementType("InheritedParserRule_ElementKeyword_0_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritedParserRuleAccess().getElementKeyword_0());
		}
		public static IGrammarAwareElementType createInheritedParserRule_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("InheritedParserRule_NameAssignment_1_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritedParserRuleAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createInheritedParserRule_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("InheritedParserRule_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getInheritedParserRuleAccess().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType InheritedParserRule_ELEMENT_TYPE = associate(InheritedParserRuleFactory.createInheritedParserRuleElementType());

	public static final IGrammarAwareElementType InheritedParserRule_Group_ELEMENT_TYPE = associate(InheritedParserRuleFactory.createInheritedParserRule_GroupElementType());

	public static final IGrammarAwareElementType InheritedParserRule_ElementKeyword_0_ELEMENT_TYPE = associate(InheritedParserRuleFactory.createInheritedParserRule_ElementKeyword_0ElementType());

	public static final IGrammarAwareElementType InheritedParserRule_NameAssignment_1_ELEMENT_TYPE = associate(InheritedParserRuleFactory.createInheritedParserRule_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType InheritedParserRule_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(InheritedParserRuleFactory.createInheritedParserRule_NameIDTerminalRuleCall_1_0ElementType());

	private static class AbstractCallOverridenParserRuleFactory {
		public static IGrammarAwareElementType createAbstractCallOverridenParserRuleElementType() {
			return new IGrammarAwareElementType("AbstractCallOverridenParserRule_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractCallOverridenParserRuleRule());
		}
		public static IGrammarAwareElementType createAbstractCallOverridenParserRule_GroupElementType() {
			return new IGrammarAwareElementType("AbstractCallOverridenParserRule_Group_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractCallOverridenParserRuleAccess().getGroup());
		}
		public static IGrammarAwareElementType createAbstractCallOverridenParserRule_OverridemodelKeyword_0ElementType() {
			return new IGrammarAwareElementType("AbstractCallOverridenParserRule_OverridemodelKeyword_0_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractCallOverridenParserRuleAccess().getOverridemodelKeyword_0());
		}
		public static IGrammarAwareElementType createAbstractCallOverridenParserRule_ElementsAssignment_1ElementType() {
			return new IGrammarAwareElementType("AbstractCallOverridenParserRule_ElementsAssignment_1_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractCallOverridenParserRuleAccess().getElementsAssignment_1());
		}
		public static IGrammarAwareElementType createAbstractCallOverridenParserRule_ElementsOverridableParserRuleParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("AbstractCallOverridenParserRule_ElementsOverridableParserRuleParserRuleCall_1_0_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractCallOverridenParserRuleAccess().getElementsOverridableParserRuleParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType AbstractCallOverridenParserRule_ELEMENT_TYPE = associate(AbstractCallOverridenParserRuleFactory.createAbstractCallOverridenParserRuleElementType());

	public static final IGrammarAwareElementType AbstractCallOverridenParserRule_Group_ELEMENT_TYPE = associate(AbstractCallOverridenParserRuleFactory.createAbstractCallOverridenParserRule_GroupElementType());

	public static final IGrammarAwareElementType AbstractCallOverridenParserRule_OverridemodelKeyword_0_ELEMENT_TYPE = associate(AbstractCallOverridenParserRuleFactory.createAbstractCallOverridenParserRule_OverridemodelKeyword_0ElementType());

	public static final IGrammarAwareElementType AbstractCallOverridenParserRule_ElementsAssignment_1_ELEMENT_TYPE = associate(AbstractCallOverridenParserRuleFactory.createAbstractCallOverridenParserRule_ElementsAssignment_1ElementType());

	public static final IGrammarAwareElementType AbstractCallOverridenParserRule_ElementsOverridableParserRuleParserRuleCall_1_0_ELEMENT_TYPE = associate(AbstractCallOverridenParserRuleFactory.createAbstractCallOverridenParserRule_ElementsOverridableParserRuleParserRuleCall_1_0ElementType());

	private static class OverridableParserRuleFactory {
		public static IGrammarAwareElementType createOverridableParserRuleElementType() {
			return new IGrammarAwareElementType("OverridableParserRule_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridableParserRuleRule());
		}
		public static IGrammarAwareElementType createOverridableParserRule_GroupElementType() {
			return new IGrammarAwareElementType("OverridableParserRule_Group_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridableParserRuleAccess().getGroup());
		}
		public static IGrammarAwareElementType createOverridableParserRule_ElementKeyword_0ElementType() {
			return new IGrammarAwareElementType("OverridableParserRule_ElementKeyword_0_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridableParserRuleAccess().getElementKeyword_0());
		}
		public static IGrammarAwareElementType createOverridableParserRule_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("OverridableParserRule_NameAssignment_1_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridableParserRuleAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createOverridableParserRule_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("OverridableParserRule_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridableParserRuleAccess().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType OverridableParserRule_ELEMENT_TYPE = associate(OverridableParserRuleFactory.createOverridableParserRuleElementType());

	public static final IGrammarAwareElementType OverridableParserRule_Group_ELEMENT_TYPE = associate(OverridableParserRuleFactory.createOverridableParserRule_GroupElementType());

	public static final IGrammarAwareElementType OverridableParserRule_ElementKeyword_0_ELEMENT_TYPE = associate(OverridableParserRuleFactory.createOverridableParserRule_ElementKeyword_0ElementType());

	public static final IGrammarAwareElementType OverridableParserRule_NameAssignment_1_ELEMENT_TYPE = associate(OverridableParserRuleFactory.createOverridableParserRule_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType OverridableParserRule_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(OverridableParserRuleFactory.createOverridableParserRule_NameIDTerminalRuleCall_1_0ElementType());

	private static class OverridableParserRule2Factory {
		public static IGrammarAwareElementType createOverridableParserRule2ElementType() {
			return new IGrammarAwareElementType("OverridableParserRule2_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridableParserRule2Rule());
		}
		public static IGrammarAwareElementType createOverridableParserRule2_GroupElementType() {
			return new IGrammarAwareElementType("OverridableParserRule2_Group_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridableParserRule2Access().getGroup());
		}
		public static IGrammarAwareElementType createOverridableParserRule2_OtherElementKeyword_0ElementType() {
			return new IGrammarAwareElementType("OverridableParserRule2_OtherElementKeyword_0_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridableParserRule2Access().getOtherElementKeyword_0());
		}
		public static IGrammarAwareElementType createOverridableParserRule2_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("OverridableParserRule2_NameAssignment_1_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridableParserRule2Access().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createOverridableParserRule2_NameSTRINGTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("OverridableParserRule2_NameSTRINGTerminalRuleCall_1_0_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getOverridableParserRule2Access().getNameSTRINGTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType OverridableParserRule2_ELEMENT_TYPE = associate(OverridableParserRule2Factory.createOverridableParserRule2ElementType());

	public static final IGrammarAwareElementType OverridableParserRule2_Group_ELEMENT_TYPE = associate(OverridableParserRule2Factory.createOverridableParserRule2_GroupElementType());

	public static final IGrammarAwareElementType OverridableParserRule2_OtherElementKeyword_0_ELEMENT_TYPE = associate(OverridableParserRule2Factory.createOverridableParserRule2_OtherElementKeyword_0ElementType());

	public static final IGrammarAwareElementType OverridableParserRule2_NameAssignment_1_ELEMENT_TYPE = associate(OverridableParserRule2Factory.createOverridableParserRule2_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType OverridableParserRule2_NameSTRINGTerminalRuleCall_1_0_ELEMENT_TYPE = associate(OverridableParserRule2Factory.createOverridableParserRule2_NameSTRINGTerminalRuleCall_1_0ElementType());

	private static class AbstractCallExtendedParserRuleFactory {
		public static IGrammarAwareElementType createAbstractCallExtendedParserRuleElementType() {
			return new IGrammarAwareElementType("AbstractCallExtendedParserRule_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractCallExtendedParserRuleRule());
		}
		public static IGrammarAwareElementType createAbstractCallExtendedParserRule_GroupElementType() {
			return new IGrammarAwareElementType("AbstractCallExtendedParserRule_Group_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractCallExtendedParserRuleAccess().getGroup());
		}
		public static IGrammarAwareElementType createAbstractCallExtendedParserRule_ExtendedmodelKeyword_0ElementType() {
			return new IGrammarAwareElementType("AbstractCallExtendedParserRule_ExtendedmodelKeyword_0_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractCallExtendedParserRuleAccess().getExtendedmodelKeyword_0());
		}
		public static IGrammarAwareElementType createAbstractCallExtendedParserRule_ElementsAssignment_1ElementType() {
			return new IGrammarAwareElementType("AbstractCallExtendedParserRule_ElementsAssignment_1_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractCallExtendedParserRuleAccess().getElementsAssignment_1());
		}
		public static IGrammarAwareElementType createAbstractCallExtendedParserRule_ElementsExtendableParserRuleParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("AbstractCallExtendedParserRule_ElementsExtendableParserRuleParserRuleCall_1_0_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractCallExtendedParserRuleAccess().getElementsExtendableParserRuleParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType AbstractCallExtendedParserRule_ELEMENT_TYPE = associate(AbstractCallExtendedParserRuleFactory.createAbstractCallExtendedParserRuleElementType());

	public static final IGrammarAwareElementType AbstractCallExtendedParserRule_Group_ELEMENT_TYPE = associate(AbstractCallExtendedParserRuleFactory.createAbstractCallExtendedParserRule_GroupElementType());

	public static final IGrammarAwareElementType AbstractCallExtendedParserRule_ExtendedmodelKeyword_0_ELEMENT_TYPE = associate(AbstractCallExtendedParserRuleFactory.createAbstractCallExtendedParserRule_ExtendedmodelKeyword_0ElementType());

	public static final IGrammarAwareElementType AbstractCallExtendedParserRule_ElementsAssignment_1_ELEMENT_TYPE = associate(AbstractCallExtendedParserRuleFactory.createAbstractCallExtendedParserRule_ElementsAssignment_1ElementType());

	public static final IGrammarAwareElementType AbstractCallExtendedParserRule_ElementsExtendableParserRuleParserRuleCall_1_0_ELEMENT_TYPE = associate(AbstractCallExtendedParserRuleFactory.createAbstractCallExtendedParserRule_ElementsExtendableParserRuleParserRuleCall_1_0ElementType());

	private static class ExtendableParserRuleFactory {
		public static IGrammarAwareElementType createExtendableParserRuleElementType() {
			return new IGrammarAwareElementType("ExtendableParserRule_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExtendableParserRuleRule());
		}
		public static IGrammarAwareElementType createExtendableParserRule_GroupElementType() {
			return new IGrammarAwareElementType("ExtendableParserRule_Group_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExtendableParserRuleAccess().getGroup());
		}
		public static IGrammarAwareElementType createExtendableParserRule_ElementKeyword_0ElementType() {
			return new IGrammarAwareElementType("ExtendableParserRule_ElementKeyword_0_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExtendableParserRuleAccess().getElementKeyword_0());
		}
		public static IGrammarAwareElementType createExtendableParserRule_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("ExtendableParserRule_NameAssignment_1_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExtendableParserRuleAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createExtendableParserRule_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("ExtendableParserRule_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", AbstractTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getExtendableParserRuleAccess().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType ExtendableParserRule_ELEMENT_TYPE = associate(ExtendableParserRuleFactory.createExtendableParserRuleElementType());

	public static final IGrammarAwareElementType ExtendableParserRule_Group_ELEMENT_TYPE = associate(ExtendableParserRuleFactory.createExtendableParserRule_GroupElementType());

	public static final IGrammarAwareElementType ExtendableParserRule_ElementKeyword_0_ELEMENT_TYPE = associate(ExtendableParserRuleFactory.createExtendableParserRule_ElementKeyword_0ElementType());

	public static final IGrammarAwareElementType ExtendableParserRule_NameAssignment_1_ELEMENT_TYPE = associate(ExtendableParserRuleFactory.createExtendableParserRule_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType ExtendableParserRule_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(ExtendableParserRuleFactory.createExtendableParserRule_NameIDTerminalRuleCall_1_0ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getInheritedParserRuleElementType() {
		return InheritedParserRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritedParserRule_GroupElementType() {
		return InheritedParserRule_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritedParserRule_ElementKeyword_0ElementType() {
		return InheritedParserRule_ElementKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritedParserRule_NameAssignment_1ElementType() {
		return InheritedParserRule_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getInheritedParserRule_NameIDTerminalRuleCall_1_0ElementType() {
		return InheritedParserRule_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractCallOverridenParserRuleElementType() {
		return AbstractCallOverridenParserRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractCallOverridenParserRule_GroupElementType() {
		return AbstractCallOverridenParserRule_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractCallOverridenParserRule_OverridemodelKeyword_0ElementType() {
		return AbstractCallOverridenParserRule_OverridemodelKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractCallOverridenParserRule_ElementsAssignment_1ElementType() {
		return AbstractCallOverridenParserRule_ElementsAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractCallOverridenParserRule_ElementsOverridableParserRuleParserRuleCall_1_0ElementType() {
		return AbstractCallOverridenParserRule_ElementsOverridableParserRuleParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridableParserRuleElementType() {
		return OverridableParserRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridableParserRule_GroupElementType() {
		return OverridableParserRule_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridableParserRule_ElementKeyword_0ElementType() {
		return OverridableParserRule_ElementKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridableParserRule_NameAssignment_1ElementType() {
		return OverridableParserRule_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridableParserRule_NameIDTerminalRuleCall_1_0ElementType() {
		return OverridableParserRule_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridableParserRule2ElementType() {
		return OverridableParserRule2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridableParserRule2_GroupElementType() {
		return OverridableParserRule2_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridableParserRule2_OtherElementKeyword_0ElementType() {
		return OverridableParserRule2_OtherElementKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridableParserRule2_NameAssignment_1ElementType() {
		return OverridableParserRule2_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getOverridableParserRule2_NameSTRINGTerminalRuleCall_1_0ElementType() {
		return OverridableParserRule2_NameSTRINGTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractCallExtendedParserRuleElementType() {
		return AbstractCallExtendedParserRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractCallExtendedParserRule_GroupElementType() {
		return AbstractCallExtendedParserRule_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractCallExtendedParserRule_ExtendedmodelKeyword_0ElementType() {
		return AbstractCallExtendedParserRule_ExtendedmodelKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractCallExtendedParserRule_ElementsAssignment_1ElementType() {
		return AbstractCallExtendedParserRule_ElementsAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractCallExtendedParserRule_ElementsExtendableParserRuleParserRuleCall_1_0ElementType() {
		return AbstractCallExtendedParserRule_ElementsExtendableParserRuleParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExtendableParserRuleElementType() {
		return ExtendableParserRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExtendableParserRule_GroupElementType() {
		return ExtendableParserRule_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExtendableParserRule_ElementKeyword_0ElementType() {
		return ExtendableParserRule_ElementKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExtendableParserRule_NameAssignment_1ElementType() {
		return ExtendableParserRule_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getExtendableParserRule_NameIDTerminalRuleCall_1_0ElementType() {
		return ExtendableParserRule_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

}
