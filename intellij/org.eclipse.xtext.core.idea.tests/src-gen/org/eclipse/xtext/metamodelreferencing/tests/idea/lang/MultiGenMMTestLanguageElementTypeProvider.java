package org.eclipse.xtext.metamodelreferencing.tests.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.psi.impl.MultiGenMMTestLanguageFileImpl;
import org.eclipse.xtext.metamodelreferencing.tests.services.MultiGenMMTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class MultiGenMMTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<MultiGenMMTestLanguageFileImpl>>(MultiGenMMTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final MultiGenMMTestLanguageGrammarAccess GRAMMAR_ACCESS = MultiGenMMTestLanguageLanguage.INSTANCE.getInstance(MultiGenMMTestLanguageGrammarAccess.class);

	private static class FooFactory {
		public static IGrammarAwareElementType createFooElementType() {
			return new IGrammarAwareElementType("Foo_ELEMENT_TYPE", MultiGenMMTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooRule());
		}
		public static IGrammarAwareElementType createFoo_GroupElementType() {
			return new IGrammarAwareElementType("Foo_Group_ELEMENT_TYPE", MultiGenMMTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getGroup());
		}
		public static IGrammarAwareElementType createFoo_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("Foo_NameAssignment_0_ELEMENT_TYPE", MultiGenMMTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createFoo_NameIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Foo_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE", MultiGenMMTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getNameIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createFoo_NameRefsAssignment_1ElementType() {
			return new IGrammarAwareElementType("Foo_NameRefsAssignment_1_ELEMENT_TYPE", MultiGenMMTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getNameRefsAssignment_1());
		}
		public static IGrammarAwareElementType createFoo_NameRefsNameRefParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Foo_NameRefsNameRefParserRuleCall_1_0_ELEMENT_TYPE", MultiGenMMTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getNameRefsNameRefParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Foo_ELEMENT_TYPE = associate(FooFactory.createFooElementType());

	public static final IGrammarAwareElementType Foo_Group_ELEMENT_TYPE = associate(FooFactory.createFoo_GroupElementType());

	public static final IGrammarAwareElementType Foo_NameAssignment_0_ELEMENT_TYPE = associate(FooFactory.createFoo_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType Foo_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(FooFactory.createFoo_NameIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Foo_NameRefsAssignment_1_ELEMENT_TYPE = associate(FooFactory.createFoo_NameRefsAssignment_1ElementType());

	public static final IGrammarAwareElementType Foo_NameRefsNameRefParserRuleCall_1_0_ELEMENT_TYPE = associate(FooFactory.createFoo_NameRefsNameRefParserRuleCall_1_0ElementType());

	private static class NameRefFactory {
		public static IGrammarAwareElementType createNameRefElementType() {
			return new IGrammarAwareElementType("NameRef_ELEMENT_TYPE", MultiGenMMTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNameRefRule());
		}
		public static IGrammarAwareElementType createNameRef_NameAssignmentElementType() {
			return new IGrammarAwareElementType("NameRef_NameAssignment_ELEMENT_TYPE", MultiGenMMTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNameRefAccess().getNameAssignment());
		}
		public static IGrammarAwareElementType createNameRef_NameSTRINGTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("NameRef_NameSTRINGTerminalRuleCall_0_ELEMENT_TYPE", MultiGenMMTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNameRefAccess().getNameSTRINGTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType NameRef_ELEMENT_TYPE = associate(NameRefFactory.createNameRefElementType());

	public static final IGrammarAwareElementType NameRef_NameAssignment_ELEMENT_TYPE = associate(NameRefFactory.createNameRef_NameAssignmentElementType());

	public static final IGrammarAwareElementType NameRef_NameSTRINGTerminalRuleCall_0_ELEMENT_TYPE = associate(NameRefFactory.createNameRef_NameSTRINGTerminalRuleCall_0ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getFooElementType() {
		return Foo_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFoo_GroupElementType() {
		return Foo_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFoo_NameAssignment_0ElementType() {
		return Foo_NameAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFoo_NameIDTerminalRuleCall_0_0ElementType() {
		return Foo_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFoo_NameRefsAssignment_1ElementType() {
		return Foo_NameRefsAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFoo_NameRefsNameRefParserRuleCall_1_0ElementType() {
		return Foo_NameRefsNameRefParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNameRefElementType() {
		return NameRef_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNameRef_NameAssignmentElementType() {
		return NameRef_NameAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNameRef_NameSTRINGTerminalRuleCall_0ElementType() {
		return NameRef_NameSTRINGTerminalRuleCall_0_ELEMENT_TYPE;
	}

}
