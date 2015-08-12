package org.eclipse.xtext.linking.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.linking.idea.lang.psi.impl.Bug313089TestLanguageFileImpl;
import org.eclipse.xtext.linking.services.Bug313089TestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class Bug313089TestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<Bug313089TestLanguageFileImpl>>(Bug313089TestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final Bug313089TestLanguageGrammarAccess GRAMMAR_ACCESS = Bug313089TestLanguageLanguage.INSTANCE.getInstance(Bug313089TestLanguageGrammarAccess.class);

	private static class FooFactory {
		public static IGrammarAwareElementType createFooElementType() {
			return new IGrammarAwareElementType("Foo_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooRule());
		}
		public static IGrammarAwareElementType createFoo_GroupElementType() {
			return new IGrammarAwareElementType("Foo_Group_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getGroup());
		}
		public static IGrammarAwareElementType createFoo_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("Foo_NameAssignment_0_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createFoo_NameIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Foo_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getNameIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createFoo_Alternatives_1ElementType() {
			return new IGrammarAwareElementType("Foo_Alternatives_1_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getAlternatives_1());
		}
		public static IGrammarAwareElementType createFoo_BarAssignment_1_0ElementType() {
			return new IGrammarAwareElementType("Foo_BarAssignment_1_0_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getBarAssignment_1_0());
		}
		public static IGrammarAwareElementType createFoo_BarBarParserRuleCall_1_0_0ElementType() {
			return new IGrammarAwareElementType("Foo_BarBarParserRuleCall_1_0_0_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getBarBarParserRuleCall_1_0_0());
		}
		public static IGrammarAwareElementType createFoo_BazAssignment_1_1ElementType() {
			return new IGrammarAwareElementType("Foo_BazAssignment_1_1_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getBazAssignment_1_1());
		}
		public static IGrammarAwareElementType createFoo_BazBazParserRuleCall_1_1_0ElementType() {
			return new IGrammarAwareElementType("Foo_BazBazParserRuleCall_1_1_0_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getBazBazParserRuleCall_1_1_0());
		}
		public static IGrammarAwareElementType createFoo_RefAssignment_2ElementType() {
			return new IGrammarAwareElementType("Foo_RefAssignment_2_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getRefAssignment_2());
		}
		public static IGrammarAwareElementType createFoo_RefFooCrossReference_2_0ElementType() {
			return new IGrammarAwareElementType("Foo_RefFooCrossReference_2_0_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getRefFooCrossReference_2_0());
		}
		public static IGrammarAwareElementType createFoo_RefFooIDTerminalRuleCall_2_0_1ElementType() {
			return new IGrammarAwareElementType("Foo_RefFooIDTerminalRuleCall_2_0_1_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getRefFooIDTerminalRuleCall_2_0_1());
		}
	}

	public static final IGrammarAwareElementType Foo_ELEMENT_TYPE = associate(FooFactory.createFooElementType());

	public static final IGrammarAwareElementType Foo_Group_ELEMENT_TYPE = associate(FooFactory.createFoo_GroupElementType());

	public static final IGrammarAwareElementType Foo_NameAssignment_0_ELEMENT_TYPE = associate(FooFactory.createFoo_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType Foo_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(FooFactory.createFoo_NameIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Foo_Alternatives_1_ELEMENT_TYPE = associate(FooFactory.createFoo_Alternatives_1ElementType());

	public static final IGrammarAwareElementType Foo_BarAssignment_1_0_ELEMENT_TYPE = associate(FooFactory.createFoo_BarAssignment_1_0ElementType());

	public static final IGrammarAwareElementType Foo_BarBarParserRuleCall_1_0_0_ELEMENT_TYPE = associate(FooFactory.createFoo_BarBarParserRuleCall_1_0_0ElementType());

	public static final IGrammarAwareElementType Foo_BazAssignment_1_1_ELEMENT_TYPE = associate(FooFactory.createFoo_BazAssignment_1_1ElementType());

	public static final IGrammarAwareElementType Foo_BazBazParserRuleCall_1_1_0_ELEMENT_TYPE = associate(FooFactory.createFoo_BazBazParserRuleCall_1_1_0ElementType());

	public static final IGrammarAwareElementType Foo_RefAssignment_2_ELEMENT_TYPE = associate(FooFactory.createFoo_RefAssignment_2ElementType());

	public static final IGrammarAwareElementType Foo_RefFooCrossReference_2_0_ELEMENT_TYPE = associate(FooFactory.createFoo_RefFooCrossReference_2_0ElementType());

	public static final IGrammarAwareElementType Foo_RefFooIDTerminalRuleCall_2_0_1_ELEMENT_TYPE = associate(FooFactory.createFoo_RefFooIDTerminalRuleCall_2_0_1ElementType());

	private static class BarFactory {
		public static IGrammarAwareElementType createBarElementType() {
			return new IGrammarAwareElementType("Bar_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBarRule());
		}
		public static IGrammarAwareElementType createBar_GroupElementType() {
			return new IGrammarAwareElementType("Bar_Group_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBarAccess().getGroup());
		}
		public static IGrammarAwareElementType createBar_BarAction_0ElementType() {
			return new IGrammarAwareElementType("Bar_BarAction_0_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBarAccess().getBarAction_0());
		}
		public static IGrammarAwareElementType createBar_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Bar_NameAssignment_1_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBarAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createBar_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Bar_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBarAccess().getNameIDTerminalRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Bar_ELEMENT_TYPE = associate(BarFactory.createBarElementType());

	public static final IGrammarAwareElementType Bar_Group_ELEMENT_TYPE = associate(BarFactory.createBar_GroupElementType());

	public static final IGrammarAwareElementType Bar_BarAction_0_ELEMENT_TYPE = associate(BarFactory.createBar_BarAction_0ElementType());

	public static final IGrammarAwareElementType Bar_NameAssignment_1_ELEMENT_TYPE = associate(BarFactory.createBar_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Bar_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(BarFactory.createBar_NameIDTerminalRuleCall_1_0ElementType());

	private static class BazFactory {
		public static IGrammarAwareElementType createBazElementType() {
			return new IGrammarAwareElementType("Baz_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBazRule());
		}
		public static IGrammarAwareElementType createBaz_GroupElementType() {
			return new IGrammarAwareElementType("Baz_Group_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBazAccess().getGroup());
		}
		public static IGrammarAwareElementType createBaz_BazKeyword_0ElementType() {
			return new IGrammarAwareElementType("Baz_BazKeyword_0_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBazAccess().getBazKeyword_0());
		}
		public static IGrammarAwareElementType createBaz_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Baz_NameAssignment_1_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBazAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createBaz_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Baz_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBazAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createBaz_Group_2ElementType() {
			return new IGrammarAwareElementType("Baz_Group_2_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBazAccess().getGroup_2());
		}
		public static IGrammarAwareElementType createBaz_BazChildAction_2_0ElementType() {
			return new IGrammarAwareElementType("Baz_BazChildAction_2_0_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBazAccess().getBazChildAction_2_0());
		}
		public static IGrammarAwareElementType createBaz_BazKeyword_2_1ElementType() {
			return new IGrammarAwareElementType("Baz_BazKeyword_2_1_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBazAccess().getBazKeyword_2_1());
		}
		public static IGrammarAwareElementType createBaz_NameAssignment_2_2ElementType() {
			return new IGrammarAwareElementType("Baz_NameAssignment_2_2_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBazAccess().getNameAssignment_2_2());
		}
		public static IGrammarAwareElementType createBaz_NameIDTerminalRuleCall_2_2_0ElementType() {
			return new IGrammarAwareElementType("Baz_NameIDTerminalRuleCall_2_2_0_ELEMENT_TYPE", Bug313089TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBazAccess().getNameIDTerminalRuleCall_2_2_0());
		}
	}

	public static final IGrammarAwareElementType Baz_ELEMENT_TYPE = associate(BazFactory.createBazElementType());

	public static final IGrammarAwareElementType Baz_Group_ELEMENT_TYPE = associate(BazFactory.createBaz_GroupElementType());

	public static final IGrammarAwareElementType Baz_BazKeyword_0_ELEMENT_TYPE = associate(BazFactory.createBaz_BazKeyword_0ElementType());

	public static final IGrammarAwareElementType Baz_NameAssignment_1_ELEMENT_TYPE = associate(BazFactory.createBaz_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Baz_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(BazFactory.createBaz_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Baz_Group_2_ELEMENT_TYPE = associate(BazFactory.createBaz_Group_2ElementType());

	public static final IGrammarAwareElementType Baz_BazChildAction_2_0_ELEMENT_TYPE = associate(BazFactory.createBaz_BazChildAction_2_0ElementType());

	public static final IGrammarAwareElementType Baz_BazKeyword_2_1_ELEMENT_TYPE = associate(BazFactory.createBaz_BazKeyword_2_1ElementType());

	public static final IGrammarAwareElementType Baz_NameAssignment_2_2_ELEMENT_TYPE = associate(BazFactory.createBaz_NameAssignment_2_2ElementType());

	public static final IGrammarAwareElementType Baz_NameIDTerminalRuleCall_2_2_0_ELEMENT_TYPE = associate(BazFactory.createBaz_NameIDTerminalRuleCall_2_2_0ElementType());

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

	public IGrammarAwareElementType getFoo_Alternatives_1ElementType() {
		return Foo_Alternatives_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFoo_BarAssignment_1_0ElementType() {
		return Foo_BarAssignment_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFoo_BarBarParserRuleCall_1_0_0ElementType() {
		return Foo_BarBarParserRuleCall_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFoo_BazAssignment_1_1ElementType() {
		return Foo_BazAssignment_1_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFoo_BazBazParserRuleCall_1_1_0ElementType() {
		return Foo_BazBazParserRuleCall_1_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFoo_RefAssignment_2ElementType() {
		return Foo_RefAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFoo_RefFooCrossReference_2_0ElementType() {
		return Foo_RefFooCrossReference_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFoo_RefFooIDTerminalRuleCall_2_0_1ElementType() {
		return Foo_RefFooIDTerminalRuleCall_2_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBarElementType() {
		return Bar_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBar_GroupElementType() {
		return Bar_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBar_BarAction_0ElementType() {
		return Bar_BarAction_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBar_NameAssignment_1ElementType() {
		return Bar_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBar_NameIDTerminalRuleCall_1_0ElementType() {
		return Bar_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBazElementType() {
		return Baz_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBaz_GroupElementType() {
		return Baz_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBaz_BazKeyword_0ElementType() {
		return Baz_BazKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBaz_NameAssignment_1ElementType() {
		return Baz_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBaz_NameIDTerminalRuleCall_1_0ElementType() {
		return Baz_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBaz_Group_2ElementType() {
		return Baz_Group_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBaz_BazChildAction_2_0ElementType() {
		return Baz_BazChildAction_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBaz_BazKeyword_2_1ElementType() {
		return Baz_BazKeyword_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBaz_NameAssignment_2_2ElementType() {
		return Baz_NameAssignment_2_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBaz_NameIDTerminalRuleCall_2_2_0ElementType() {
		return Baz_NameIDTerminalRuleCall_2_2_0_ELEMENT_TYPE;
	}

}
