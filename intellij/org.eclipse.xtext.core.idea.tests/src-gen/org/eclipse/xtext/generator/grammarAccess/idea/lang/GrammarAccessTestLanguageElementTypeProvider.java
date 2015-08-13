package org.eclipse.xtext.generator.grammarAccess.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.generator.grammarAccess.idea.lang.psi.impl.GrammarAccessTestLanguageFileImpl;
import org.eclipse.xtext.generator.grammarAccess.services.GrammarAccessTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class GrammarAccessTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<GrammarAccessTestLanguageFileImpl>>(GrammarAccessTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final GrammarAccessTestLanguageGrammarAccess GRAMMAR_ACCESS = GrammarAccessTestLanguageLanguage.INSTANCE.getInstance(GrammarAccessTestLanguageGrammarAccess.class);

	private static class RootFactory {
		public static IGrammarAwareElementType createRootElementType() {
			return new IGrammarAwareElementType("Root_ELEMENT_TYPE", GrammarAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootRule());
		}
		public static IGrammarAwareElementType createRoot_ElementsAssignmentElementType() {
			return new IGrammarAwareElementType("Root_ElementsAssignment_ELEMENT_TYPE", GrammarAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getElementsAssignment());
		}
		public static IGrammarAwareElementType createRoot_ElementsTypeParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Root_ElementsTypeParserRuleCall_0_ELEMENT_TYPE", GrammarAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getElementsTypeParserRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Root_ELEMENT_TYPE = associate(RootFactory.createRootElementType());

	public static final IGrammarAwareElementType Root_ElementsAssignment_ELEMENT_TYPE = associate(RootFactory.createRoot_ElementsAssignmentElementType());

	public static final IGrammarAwareElementType Root_ElementsTypeParserRuleCall_0_ELEMENT_TYPE = associate(RootFactory.createRoot_ElementsTypeParserRuleCall_0ElementType());

	private static class TypeFactory {
		public static IGrammarAwareElementType createTypeElementType() {
			return new IGrammarAwareElementType("Type_ELEMENT_TYPE", GrammarAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeRule());
		}
		public static IGrammarAwareElementType createType_AlternativesElementType() {
			return new IGrammarAwareElementType("Type_Alternatives_ELEMENT_TYPE", GrammarAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createType_ATypeParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Type_ATypeParserRuleCall_0_ELEMENT_TYPE", GrammarAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getATypeParserRuleCall_0());
		}
		public static IGrammarAwareElementType createType_AnotherTypeParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Type_AnotherTypeParserRuleCall_1_ELEMENT_TYPE", GrammarAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getTypeAccess().getAnotherTypeParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType Type_ELEMENT_TYPE = associate(TypeFactory.createTypeElementType());

	public static final IGrammarAwareElementType Type_Alternatives_ELEMENT_TYPE = associate(TypeFactory.createType_AlternativesElementType());

	public static final IGrammarAwareElementType Type_ATypeParserRuleCall_0_ELEMENT_TYPE = associate(TypeFactory.createType_ATypeParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Type_AnotherTypeParserRuleCall_1_ELEMENT_TYPE = associate(TypeFactory.createType_AnotherTypeParserRuleCall_1ElementType());

	private static class ATypeFactory {
		public static IGrammarAwareElementType createATypeElementType() {
			return new IGrammarAwareElementType("AType_ELEMENT_TYPE", GrammarAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getATypeRule());
		}
		public static IGrammarAwareElementType createAType_GroupElementType() {
			return new IGrammarAwareElementType("AType_Group_ELEMENT_TYPE", GrammarAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getATypeAccess().getGroup());
		}
		public static IGrammarAwareElementType createAType_FooKeyword_0ElementType() {
			return new IGrammarAwareElementType("AType_FooKeyword_0_ELEMENT_TYPE", GrammarAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getATypeAccess().getFooKeyword_0());
		}
		public static IGrammarAwareElementType createAType_ATypeAction_1ElementType() {
			return new IGrammarAwareElementType("AType_ATypeAction_1_ELEMENT_TYPE", GrammarAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getATypeAccess().getATypeAction_1());
		}
	}

	public static final IGrammarAwareElementType AType_ELEMENT_TYPE = associate(ATypeFactory.createATypeElementType());

	public static final IGrammarAwareElementType AType_Group_ELEMENT_TYPE = associate(ATypeFactory.createAType_GroupElementType());

	public static final IGrammarAwareElementType AType_FooKeyword_0_ELEMENT_TYPE = associate(ATypeFactory.createAType_FooKeyword_0ElementType());

	public static final IGrammarAwareElementType AType_ATypeAction_1_ELEMENT_TYPE = associate(ATypeFactory.createAType_ATypeAction_1ElementType());

	private static class AnotherTypeFactory {
		public static IGrammarAwareElementType createAnotherTypeElementType() {
			return new IGrammarAwareElementType("AnotherType_ELEMENT_TYPE", GrammarAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAnotherTypeRule());
		}
		public static IGrammarAwareElementType createAnotherType_GroupElementType() {
			return new IGrammarAwareElementType("AnotherType_Group_ELEMENT_TYPE", GrammarAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAnotherTypeAccess().getGroup());
		}
		public static IGrammarAwareElementType createAnotherType_BarKeyword_0ElementType() {
			return new IGrammarAwareElementType("AnotherType_BarKeyword_0_ELEMENT_TYPE", GrammarAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAnotherTypeAccess().getBarKeyword_0());
		}
		public static IGrammarAwareElementType createAnotherType_AnotherTypeAction_1ElementType() {
			return new IGrammarAwareElementType("AnotherType_AnotherTypeAction_1_ELEMENT_TYPE", GrammarAccessTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAnotherTypeAccess().getAnotherTypeAction_1());
		}
	}

	public static final IGrammarAwareElementType AnotherType_ELEMENT_TYPE = associate(AnotherTypeFactory.createAnotherTypeElementType());

	public static final IGrammarAwareElementType AnotherType_Group_ELEMENT_TYPE = associate(AnotherTypeFactory.createAnotherType_GroupElementType());

	public static final IGrammarAwareElementType AnotherType_BarKeyword_0_ELEMENT_TYPE = associate(AnotherTypeFactory.createAnotherType_BarKeyword_0ElementType());

	public static final IGrammarAwareElementType AnotherType_AnotherTypeAction_1_ELEMENT_TYPE = associate(AnotherTypeFactory.createAnotherType_AnotherTypeAction_1ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getRootElementType() {
		return Root_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_ElementsAssignmentElementType() {
		return Root_ElementsAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_ElementsTypeParserRuleCall_0ElementType() {
		return Root_ElementsTypeParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTypeElementType() {
		return Type_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_AlternativesElementType() {
		return Type_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_ATypeParserRuleCall_0ElementType() {
		return Type_ATypeParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getType_AnotherTypeParserRuleCall_1ElementType() {
		return Type_AnotherTypeParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getATypeElementType() {
		return AType_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAType_GroupElementType() {
		return AType_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAType_FooKeyword_0ElementType() {
		return AType_FooKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAType_ATypeAction_1ElementType() {
		return AType_ATypeAction_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAnotherTypeElementType() {
		return AnotherType_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAnotherType_GroupElementType() {
		return AnotherType_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAnotherType_BarKeyword_0ElementType() {
		return AnotherType_BarKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAnotherType_AnotherTypeAction_1ElementType() {
		return AnotherType_AnotherTypeAction_1_ELEMENT_TYPE;
	}

}
