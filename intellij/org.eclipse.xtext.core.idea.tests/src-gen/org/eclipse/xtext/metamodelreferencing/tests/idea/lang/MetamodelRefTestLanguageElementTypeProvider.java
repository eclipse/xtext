package org.eclipse.xtext.metamodelreferencing.tests.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.psi.impl.MetamodelRefTestLanguageFileImpl;
import org.eclipse.xtext.metamodelreferencing.tests.services.MetamodelRefTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class MetamodelRefTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<MetamodelRefTestLanguageFileImpl>>(MetamodelRefTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final MetamodelRefTestLanguageGrammarAccess GRAMMAR_ACCESS = MetamodelRefTestLanguageLanguage.INSTANCE.getInstance(MetamodelRefTestLanguageGrammarAccess.class);

	private static class FooFactory {
		public static IGrammarAwareElementType createFooElementType() {
			return new IGrammarAwareElementType("Foo_ELEMENT_TYPE", MetamodelRefTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooRule());
		}
		public static IGrammarAwareElementType createFoo_GroupElementType() {
			return new IGrammarAwareElementType("Foo_Group_ELEMENT_TYPE", MetamodelRefTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getGroup());
		}
		public static IGrammarAwareElementType createFoo_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("Foo_NameAssignment_0_ELEMENT_TYPE", MetamodelRefTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createFoo_NameIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Foo_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE", MetamodelRefTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getNameIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createFoo_NameRefsAssignment_1ElementType() {
			return new IGrammarAwareElementType("Foo_NameRefsAssignment_1_ELEMENT_TYPE", MetamodelRefTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getNameRefsAssignment_1());
		}
		public static IGrammarAwareElementType createFoo_NameRefsNameRefParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Foo_NameRefsNameRefParserRuleCall_1_0_ELEMENT_TYPE", MetamodelRefTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getNameRefsNameRefParserRuleCall_1_0());
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
			return new IGrammarAwareElementType("NameRef_ELEMENT_TYPE", MetamodelRefTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNameRefRule());
		}
		public static IGrammarAwareElementType createNameRef_RuleAssignmentElementType() {
			return new IGrammarAwareElementType("NameRef_RuleAssignment_ELEMENT_TYPE", MetamodelRefTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNameRefAccess().getRuleAssignment());
		}
		public static IGrammarAwareElementType createNameRef_RuleParserRuleCrossReference_0ElementType() {
			return new IGrammarAwareElementType("NameRef_RuleParserRuleCrossReference_0_ELEMENT_TYPE", MetamodelRefTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNameRefAccess().getRuleParserRuleCrossReference_0());
		}
		public static IGrammarAwareElementType createNameRef_RuleParserRuleIDTerminalRuleCall_0_1ElementType() {
			return new IGrammarAwareElementType("NameRef_RuleParserRuleIDTerminalRuleCall_0_1_ELEMENT_TYPE", MetamodelRefTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getNameRefAccess().getRuleParserRuleIDTerminalRuleCall_0_1());
		}
	}

	public static final IGrammarAwareElementType NameRef_ELEMENT_TYPE = associate(NameRefFactory.createNameRefElementType());

	public static final IGrammarAwareElementType NameRef_RuleAssignment_ELEMENT_TYPE = associate(NameRefFactory.createNameRef_RuleAssignmentElementType());

	public static final IGrammarAwareElementType NameRef_RuleParserRuleCrossReference_0_ELEMENT_TYPE = associate(NameRefFactory.createNameRef_RuleParserRuleCrossReference_0ElementType());

	public static final IGrammarAwareElementType NameRef_RuleParserRuleIDTerminalRuleCall_0_1_ELEMENT_TYPE = associate(NameRefFactory.createNameRef_RuleParserRuleIDTerminalRuleCall_0_1ElementType());

	private static class MyRuleFactory {
		public static IGrammarAwareElementType createMyRuleElementType() {
			return new IGrammarAwareElementType("MyRule_ELEMENT_TYPE", MetamodelRefTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMyRuleRule());
		}
		public static IGrammarAwareElementType createMyRule_NameAssignmentElementType() {
			return new IGrammarAwareElementType("MyRule_NameAssignment_ELEMENT_TYPE", MetamodelRefTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMyRuleAccess().getNameAssignment());
		}
		public static IGrammarAwareElementType createMyRule_NameIDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("MyRule_NameIDTerminalRuleCall_0_ELEMENT_TYPE", MetamodelRefTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMyRuleAccess().getNameIDTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType MyRule_ELEMENT_TYPE = associate(MyRuleFactory.createMyRuleElementType());

	public static final IGrammarAwareElementType MyRule_NameAssignment_ELEMENT_TYPE = associate(MyRuleFactory.createMyRule_NameAssignmentElementType());

	public static final IGrammarAwareElementType MyRule_NameIDTerminalRuleCall_0_ELEMENT_TYPE = associate(MyRuleFactory.createMyRule_NameIDTerminalRuleCall_0ElementType());

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

	public IGrammarAwareElementType getNameRef_RuleAssignmentElementType() {
		return NameRef_RuleAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNameRef_RuleParserRuleCrossReference_0ElementType() {
		return NameRef_RuleParserRuleCrossReference_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getNameRef_RuleParserRuleIDTerminalRuleCall_0_1ElementType() {
		return NameRef_RuleParserRuleIDTerminalRuleCall_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMyRuleElementType() {
		return MyRule_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMyRule_NameAssignmentElementType() {
		return MyRule_NameAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMyRule_NameIDTerminalRuleCall_0ElementType() {
		return MyRule_NameIDTerminalRuleCall_0_ELEMENT_TYPE;
	}

}
