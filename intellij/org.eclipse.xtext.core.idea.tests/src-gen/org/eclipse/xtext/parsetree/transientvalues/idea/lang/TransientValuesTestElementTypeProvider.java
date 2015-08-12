package org.eclipse.xtext.parsetree.transientvalues.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parsetree.transientvalues.idea.lang.psi.impl.TransientValuesTestFileImpl;
import org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class TransientValuesTestElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<TransientValuesTestFileImpl>>(TransientValuesTestLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final TransientValuesTestGrammarAccess GRAMMAR_ACCESS = TransientValuesTestLanguage.INSTANCE.getInstance(TransientValuesTestGrammarAccess.class);

	private static class RootFactory {
		public static IGrammarAwareElementType createRootElementType() {
			return new IGrammarAwareElementType("Root_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getRootRule());
		}
		public static IGrammarAwareElementType createRoot_GroupElementType() {
			return new IGrammarAwareElementType("Root_Group_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getGroup());
		}
		public static IGrammarAwareElementType createRoot_TestKeyword_0ElementType() {
			return new IGrammarAwareElementType("Root_TestKeyword_0_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getTestKeyword_0());
		}
		public static IGrammarAwareElementType createRoot_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("Root_Alternatives_1_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createRoot_TestRequiredParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Root_TestRequiredParserRuleCall_1_0_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getTestRequiredParserRuleCall_1_0());
		}
		public static IGrammarAwareElementType createRoot_TestOptionalParserRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("Root_TestOptionalParserRuleCall_1_1_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getTestOptionalParserRuleCall_1_1());
		}
		public static IGrammarAwareElementType createRoot_TestListParserRuleCall_1_2ElementType() {
			return new IGrammarAwareElementType("Root_TestListParserRuleCall_1_2_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getRootAccess().getTestListParserRuleCall_1_2());
		}
	}

	public static final IGrammarAwareElementType Root_ELEMENT_TYPE = associate(RootFactory.createRootElementType());

	public static final IGrammarAwareElementType Root_Group_ELEMENT_TYPE = associate(RootFactory.createRoot_GroupElementType());

	public static final IGrammarAwareElementType Root_TestKeyword_0_ELEMENT_TYPE = associate(RootFactory.createRoot_TestKeyword_0ElementType());

	public static final IGrammarAwareElementType Root_Alternatives_1_ELEMENT_TYPE = associate(RootFactory.createRoot_Alternatives_1ElementType());

	public static final IGrammarAwareElementType Root_TestRequiredParserRuleCall_1_0_ELEMENT_TYPE = associate(RootFactory.createRoot_TestRequiredParserRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Root_TestOptionalParserRuleCall_1_1_ELEMENT_TYPE = associate(RootFactory.createRoot_TestOptionalParserRuleCall_1_1ElementType());

	public static final IGrammarAwareElementType Root_TestListParserRuleCall_1_2_ELEMENT_TYPE = associate(RootFactory.createRoot_TestListParserRuleCall_1_2ElementType());

	private static class TestRequiredFactory {
		public static IGrammarAwareElementType createTestRequiredElementType() {
			return new IGrammarAwareElementType("TestRequired_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getTestRequiredRule());
		}
		public static IGrammarAwareElementType createTestRequired_GroupElementType() {
			return new IGrammarAwareElementType("TestRequired_Group_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getTestRequiredAccess().getGroup());
		}
		public static IGrammarAwareElementType createTestRequired_TestRequiredAction_0ElementType() {
			return new IGrammarAwareElementType("TestRequired_TestRequiredAction_0_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getTestRequiredAccess().getTestRequiredAction_0());
		}
		public static IGrammarAwareElementType createTestRequired_RequiredKeyword_1ElementType() {
			return new IGrammarAwareElementType("TestRequired_RequiredKeyword_1_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getTestRequiredAccess().getRequiredKeyword_1());
		}
		public static IGrammarAwareElementType createTestRequired_Required1Assignment_2ElementType() {
			return new IGrammarAwareElementType("TestRequired_Required1Assignment_2_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getTestRequiredAccess().getRequired1Assignment_2());
		}
		public static IGrammarAwareElementType createTestRequired_Required1INTTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("TestRequired_Required1INTTerminalRuleCall_2_0_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getTestRequiredAccess().getRequired1INTTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createTestRequired_Required2Assignment_3ElementType() {
			return new IGrammarAwareElementType("TestRequired_Required2Assignment_3_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getTestRequiredAccess().getRequired2Assignment_3());
		}
		public static IGrammarAwareElementType createTestRequired_Required2INTTerminalRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("TestRequired_Required2INTTerminalRuleCall_3_0_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getTestRequiredAccess().getRequired2INTTerminalRuleCall_3_0());
		}
	}

	public static final IGrammarAwareElementType TestRequired_ELEMENT_TYPE = associate(TestRequiredFactory.createTestRequiredElementType());

	public static final IGrammarAwareElementType TestRequired_Group_ELEMENT_TYPE = associate(TestRequiredFactory.createTestRequired_GroupElementType());

	public static final IGrammarAwareElementType TestRequired_TestRequiredAction_0_ELEMENT_TYPE = associate(TestRequiredFactory.createTestRequired_TestRequiredAction_0ElementType());

	public static final IGrammarAwareElementType TestRequired_RequiredKeyword_1_ELEMENT_TYPE = associate(TestRequiredFactory.createTestRequired_RequiredKeyword_1ElementType());

	public static final IGrammarAwareElementType TestRequired_Required1Assignment_2_ELEMENT_TYPE = associate(TestRequiredFactory.createTestRequired_Required1Assignment_2ElementType());

	public static final IGrammarAwareElementType TestRequired_Required1INTTerminalRuleCall_2_0_ELEMENT_TYPE = associate(TestRequiredFactory.createTestRequired_Required1INTTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType TestRequired_Required2Assignment_3_ELEMENT_TYPE = associate(TestRequiredFactory.createTestRequired_Required2Assignment_3ElementType());

	public static final IGrammarAwareElementType TestRequired_Required2INTTerminalRuleCall_3_0_ELEMENT_TYPE = associate(TestRequiredFactory.createTestRequired_Required2INTTerminalRuleCall_3_0ElementType());

	private static class TestOptionalFactory {
		public static IGrammarAwareElementType createTestOptionalElementType() {
			return new IGrammarAwareElementType("TestOptional_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getTestOptionalRule());
		}
		public static IGrammarAwareElementType createTestOptional_GroupElementType() {
			return new IGrammarAwareElementType("TestOptional_Group_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getTestOptionalAccess().getGroup());
		}
		public static IGrammarAwareElementType createTestOptional_TestOptionalAction_0ElementType() {
			return new IGrammarAwareElementType("TestOptional_TestOptionalAction_0_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getTestOptionalAccess().getTestOptionalAction_0());
		}
		public static IGrammarAwareElementType createTestOptional_OptionalKeyword_1ElementType() {
			return new IGrammarAwareElementType("TestOptional_OptionalKeyword_1_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getTestOptionalAccess().getOptionalKeyword_1());
		}
		public static IGrammarAwareElementType createTestOptional_Opt1Assignment_2ElementType() {
			return new IGrammarAwareElementType("TestOptional_Opt1Assignment_2_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getTestOptionalAccess().getOpt1Assignment_2());
		}
		public static IGrammarAwareElementType createTestOptional_Opt1INTTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("TestOptional_Opt1INTTerminalRuleCall_2_0_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getTestOptionalAccess().getOpt1INTTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createTestOptional_Group_3ElementType() {
			return new IGrammarAwareElementType("TestOptional_Group_3_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getTestOptionalAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createTestOptional_ColonKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("TestOptional_ColonKeyword_3_0_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getTestOptionalAccess().getColonKeyword_3_0());
		}
		public static IGrammarAwareElementType createTestOptional_Opt2Assignment_3_1ElementType() {
			return new IGrammarAwareElementType("TestOptional_Opt2Assignment_3_1_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getTestOptionalAccess().getOpt2Assignment_3_1());
		}
		public static IGrammarAwareElementType createTestOptional_Opt2INTTerminalRuleCall_3_1_0ElementType() {
			return new IGrammarAwareElementType("TestOptional_Opt2INTTerminalRuleCall_3_1_0_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getTestOptionalAccess().getOpt2INTTerminalRuleCall_3_1_0());
		}
	}

	public static final IGrammarAwareElementType TestOptional_ELEMENT_TYPE = associate(TestOptionalFactory.createTestOptionalElementType());

	public static final IGrammarAwareElementType TestOptional_Group_ELEMENT_TYPE = associate(TestOptionalFactory.createTestOptional_GroupElementType());

	public static final IGrammarAwareElementType TestOptional_TestOptionalAction_0_ELEMENT_TYPE = associate(TestOptionalFactory.createTestOptional_TestOptionalAction_0ElementType());

	public static final IGrammarAwareElementType TestOptional_OptionalKeyword_1_ELEMENT_TYPE = associate(TestOptionalFactory.createTestOptional_OptionalKeyword_1ElementType());

	public static final IGrammarAwareElementType TestOptional_Opt1Assignment_2_ELEMENT_TYPE = associate(TestOptionalFactory.createTestOptional_Opt1Assignment_2ElementType());

	public static final IGrammarAwareElementType TestOptional_Opt1INTTerminalRuleCall_2_0_ELEMENT_TYPE = associate(TestOptionalFactory.createTestOptional_Opt1INTTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType TestOptional_Group_3_ELEMENT_TYPE = associate(TestOptionalFactory.createTestOptional_Group_3ElementType());

	public static final IGrammarAwareElementType TestOptional_ColonKeyword_3_0_ELEMENT_TYPE = associate(TestOptionalFactory.createTestOptional_ColonKeyword_3_0ElementType());

	public static final IGrammarAwareElementType TestOptional_Opt2Assignment_3_1_ELEMENT_TYPE = associate(TestOptionalFactory.createTestOptional_Opt2Assignment_3_1ElementType());

	public static final IGrammarAwareElementType TestOptional_Opt2INTTerminalRuleCall_3_1_0_ELEMENT_TYPE = associate(TestOptionalFactory.createTestOptional_Opt2INTTerminalRuleCall_3_1_0ElementType());

	private static class TestListFactory {
		public static IGrammarAwareElementType createTestListElementType() {
			return new IGrammarAwareElementType("TestList_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getTestListRule());
		}
		public static IGrammarAwareElementType createTestList_GroupElementType() {
			return new IGrammarAwareElementType("TestList_Group_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getTestListAccess().getGroup());
		}
		public static IGrammarAwareElementType createTestList_TestListAction_0ElementType() {
			return new IGrammarAwareElementType("TestList_TestListAction_0_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getTestListAccess().getTestListAction_0());
		}
		public static IGrammarAwareElementType createTestList_ListKeyword_1ElementType() {
			return new IGrammarAwareElementType("TestList_ListKeyword_1_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getTestListAccess().getListKeyword_1());
		}
		public static IGrammarAwareElementType createTestList_ItemAssignment_2ElementType() {
			return new IGrammarAwareElementType("TestList_ItemAssignment_2_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getTestListAccess().getItemAssignment_2());
		}
		public static IGrammarAwareElementType createTestList_ItemINTTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("TestList_ItemINTTerminalRuleCall_2_0_ELEMENT_TYPE", TransientValuesTestLanguage.INSTANCE, GRAMMAR_ACCESS.getTestListAccess().getItemINTTerminalRuleCall_2_0());
		}
	}

	public static final IGrammarAwareElementType TestList_ELEMENT_TYPE = associate(TestListFactory.createTestListElementType());

	public static final IGrammarAwareElementType TestList_Group_ELEMENT_TYPE = associate(TestListFactory.createTestList_GroupElementType());

	public static final IGrammarAwareElementType TestList_TestListAction_0_ELEMENT_TYPE = associate(TestListFactory.createTestList_TestListAction_0ElementType());

	public static final IGrammarAwareElementType TestList_ListKeyword_1_ELEMENT_TYPE = associate(TestListFactory.createTestList_ListKeyword_1ElementType());

	public static final IGrammarAwareElementType TestList_ItemAssignment_2_ELEMENT_TYPE = associate(TestListFactory.createTestList_ItemAssignment_2ElementType());

	public static final IGrammarAwareElementType TestList_ItemINTTerminalRuleCall_2_0_ELEMENT_TYPE = associate(TestListFactory.createTestList_ItemINTTerminalRuleCall_2_0ElementType());

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

	public IGrammarAwareElementType getRoot_GroupElementType() {
		return Root_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_TestKeyword_0ElementType() {
		return Root_TestKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_Alternatives_1ElementType() {
		return Root_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_TestRequiredParserRuleCall_1_0ElementType() {
		return Root_TestRequiredParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_TestOptionalParserRuleCall_1_1ElementType() {
		return Root_TestOptionalParserRuleCall_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getRoot_TestListParserRuleCall_1_2ElementType() {
		return Root_TestListParserRuleCall_1_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestRequiredElementType() {
		return TestRequired_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestRequired_GroupElementType() {
		return TestRequired_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestRequired_TestRequiredAction_0ElementType() {
		return TestRequired_TestRequiredAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestRequired_RequiredKeyword_1ElementType() {
		return TestRequired_RequiredKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestRequired_Required1Assignment_2ElementType() {
		return TestRequired_Required1Assignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestRequired_Required1INTTerminalRuleCall_2_0ElementType() {
		return TestRequired_Required1INTTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestRequired_Required2Assignment_3ElementType() {
		return TestRequired_Required2Assignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestRequired_Required2INTTerminalRuleCall_3_0ElementType() {
		return TestRequired_Required2INTTerminalRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestOptionalElementType() {
		return TestOptional_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestOptional_GroupElementType() {
		return TestOptional_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestOptional_TestOptionalAction_0ElementType() {
		return TestOptional_TestOptionalAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestOptional_OptionalKeyword_1ElementType() {
		return TestOptional_OptionalKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestOptional_Opt1Assignment_2ElementType() {
		return TestOptional_Opt1Assignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestOptional_Opt1INTTerminalRuleCall_2_0ElementType() {
		return TestOptional_Opt1INTTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestOptional_Group_3ElementType() {
		return TestOptional_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestOptional_ColonKeyword_3_0ElementType() {
		return TestOptional_ColonKeyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestOptional_Opt2Assignment_3_1ElementType() {
		return TestOptional_Opt2Assignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestOptional_Opt2INTTerminalRuleCall_3_1_0ElementType() {
		return TestOptional_Opt2INTTerminalRuleCall_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestListElementType() {
		return TestList_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestList_GroupElementType() {
		return TestList_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestList_TestListAction_0ElementType() {
		return TestList_TestListAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestList_ListKeyword_1ElementType() {
		return TestList_ListKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestList_ItemAssignment_2ElementType() {
		return TestList_ItemAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getTestList_ItemINTTerminalRuleCall_2_0ElementType() {
		return TestList_ItemINTTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

}
