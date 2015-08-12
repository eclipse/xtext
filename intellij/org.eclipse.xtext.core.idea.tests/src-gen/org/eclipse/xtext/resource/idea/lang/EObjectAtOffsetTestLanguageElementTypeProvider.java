package org.eclipse.xtext.resource.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.resource.idea.lang.psi.impl.EObjectAtOffsetTestLanguageFileImpl;
import org.eclipse.xtext.resource.services.EObjectAtOffsetTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class EObjectAtOffsetTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<EObjectAtOffsetTestLanguageFileImpl>>(EObjectAtOffsetTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final EObjectAtOffsetTestLanguageGrammarAccess GRAMMAR_ACCESS = EObjectAtOffsetTestLanguageLanguage.INSTANCE.getInstance(EObjectAtOffsetTestLanguageGrammarAccess.class);

	private static class ModelFactory {
		public static IGrammarAwareElementType createModelElementType() {
			return new IGrammarAwareElementType("Model_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelRule());
		}
		public static IGrammarAwareElementType createModel_AlternativesElementType() {
			return new IGrammarAwareElementType("Model_Alternatives_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createModel_FoosAssignment_0ElementType() {
			return new IGrammarAwareElementType("Model_FoosAssignment_0_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFoosAssignment_0());
		}
		public static IGrammarAwareElementType createModel_FoosFooParserRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Model_FoosFooParserRuleCall_0_0_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getFoosFooParserRuleCall_0_0());
		}
		public static IGrammarAwareElementType createModel_BarsAssignment_1ElementType() {
			return new IGrammarAwareElementType("Model_BarsAssignment_1_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getBarsAssignment_1());
		}
		public static IGrammarAwareElementType createModel_BarsAbstractBarParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Model_BarsAbstractBarParserRuleCall_1_0_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getModelAccess().getBarsAbstractBarParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Model_ELEMENT_TYPE = associate(ModelFactory.createModelElementType());

	public static final IGrammarAwareElementType Model_Alternatives_ELEMENT_TYPE = associate(ModelFactory.createModel_AlternativesElementType());

	public static final IGrammarAwareElementType Model_FoosAssignment_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FoosAssignment_0ElementType());

	public static final IGrammarAwareElementType Model_FoosFooParserRuleCall_0_0_ELEMENT_TYPE = associate(ModelFactory.createModel_FoosFooParserRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Model_BarsAssignment_1_ELEMENT_TYPE = associate(ModelFactory.createModel_BarsAssignment_1ElementType());

	public static final IGrammarAwareElementType Model_BarsAbstractBarParserRuleCall_1_0_ELEMENT_TYPE = associate(ModelFactory.createModel_BarsAbstractBarParserRuleCall_1_0ElementType());

	private static class AbstractBarFactory {
		public static IGrammarAwareElementType createAbstractBarElementType() {
			return new IGrammarAwareElementType("AbstractBar_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractBarRule());
		}
		public static IGrammarAwareElementType createAbstractBar_GroupElementType() {
			return new IGrammarAwareElementType("AbstractBar_Group_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractBarAccess().getGroup());
		}
		public static IGrammarAwareElementType createAbstractBar_ZonkKeyword_0ElementType() {
			return new IGrammarAwareElementType("AbstractBar_ZonkKeyword_0_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractBarAccess().getZonkKeyword_0());
		}
		public static IGrammarAwareElementType createAbstractBar_INTTerminalRuleCall_1ElementType() {
			return new IGrammarAwareElementType("AbstractBar_INTTerminalRuleCall_1_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractBarAccess().getINTTerminalRuleCall_1());
		}
		public static IGrammarAwareElementType createAbstractBar_BarParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("AbstractBar_BarParserRuleCall_2_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractBarAccess().getBarParserRuleCall_2());
		}
		public static IGrammarAwareElementType createAbstractBar_Group_3ElementType() {
			return new IGrammarAwareElementType("AbstractBar_Group_3_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractBarAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createAbstractBar_FooBarBarAction_3_0ElementType() {
			return new IGrammarAwareElementType("AbstractBar_FooBarBarAction_3_0_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractBarAccess().getFooBarBarAction_3_0());
		}
		public static IGrammarAwareElementType createAbstractBar_FoobarKeyword_3_1ElementType() {
			return new IGrammarAwareElementType("AbstractBar_FoobarKeyword_3_1_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractBarAccess().getFoobarKeyword_3_1());
		}
		public static IGrammarAwareElementType createAbstractBar_FooAssignment_3_2ElementType() {
			return new IGrammarAwareElementType("AbstractBar_FooAssignment_3_2_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractBarAccess().getFooAssignment_3_2());
		}
		public static IGrammarAwareElementType createAbstractBar_FooFooCrossReference_3_2_0ElementType() {
			return new IGrammarAwareElementType("AbstractBar_FooFooCrossReference_3_2_0_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractBarAccess().getFooFooCrossReference_3_2_0());
		}
		public static IGrammarAwareElementType createAbstractBar_FooFooQualifiedNameWithOtherDelimParserRuleCall_3_2_0_1ElementType() {
			return new IGrammarAwareElementType("AbstractBar_FooFooQualifiedNameWithOtherDelimParserRuleCall_3_2_0_1_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractBarAccess().getFooFooQualifiedNameWithOtherDelimParserRuleCall_3_2_0_1());
		}
		public static IGrammarAwareElementType createAbstractBar_FooAssignment_4ElementType() {
			return new IGrammarAwareElementType("AbstractBar_FooAssignment_4_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractBarAccess().getFooAssignment_4());
		}
		public static IGrammarAwareElementType createAbstractBar_FooFooCrossReference_4_0ElementType() {
			return new IGrammarAwareElementType("AbstractBar_FooFooCrossReference_4_0_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractBarAccess().getFooFooCrossReference_4_0());
		}
		public static IGrammarAwareElementType createAbstractBar_FooFooQualifiedNameWithOtherDelimParserRuleCall_4_0_1ElementType() {
			return new IGrammarAwareElementType("AbstractBar_FooFooQualifiedNameWithOtherDelimParserRuleCall_4_0_1_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getAbstractBarAccess().getFooFooQualifiedNameWithOtherDelimParserRuleCall_4_0_1());
		}
	}

	public static final IGrammarAwareElementType AbstractBar_ELEMENT_TYPE = associate(AbstractBarFactory.createAbstractBarElementType());

	public static final IGrammarAwareElementType AbstractBar_Group_ELEMENT_TYPE = associate(AbstractBarFactory.createAbstractBar_GroupElementType());

	public static final IGrammarAwareElementType AbstractBar_ZonkKeyword_0_ELEMENT_TYPE = associate(AbstractBarFactory.createAbstractBar_ZonkKeyword_0ElementType());

	public static final IGrammarAwareElementType AbstractBar_INTTerminalRuleCall_1_ELEMENT_TYPE = associate(AbstractBarFactory.createAbstractBar_INTTerminalRuleCall_1ElementType());

	public static final IGrammarAwareElementType AbstractBar_BarParserRuleCall_2_ELEMENT_TYPE = associate(AbstractBarFactory.createAbstractBar_BarParserRuleCall_2ElementType());

	public static final IGrammarAwareElementType AbstractBar_Group_3_ELEMENT_TYPE = associate(AbstractBarFactory.createAbstractBar_Group_3ElementType());

	public static final IGrammarAwareElementType AbstractBar_FooBarBarAction_3_0_ELEMENT_TYPE = associate(AbstractBarFactory.createAbstractBar_FooBarBarAction_3_0ElementType());

	public static final IGrammarAwareElementType AbstractBar_FoobarKeyword_3_1_ELEMENT_TYPE = associate(AbstractBarFactory.createAbstractBar_FoobarKeyword_3_1ElementType());

	public static final IGrammarAwareElementType AbstractBar_FooAssignment_3_2_ELEMENT_TYPE = associate(AbstractBarFactory.createAbstractBar_FooAssignment_3_2ElementType());

	public static final IGrammarAwareElementType AbstractBar_FooFooCrossReference_3_2_0_ELEMENT_TYPE = associate(AbstractBarFactory.createAbstractBar_FooFooCrossReference_3_2_0ElementType());

	public static final IGrammarAwareElementType AbstractBar_FooFooQualifiedNameWithOtherDelimParserRuleCall_3_2_0_1_ELEMENT_TYPE = associate(AbstractBarFactory.createAbstractBar_FooFooQualifiedNameWithOtherDelimParserRuleCall_3_2_0_1ElementType());

	public static final IGrammarAwareElementType AbstractBar_FooAssignment_4_ELEMENT_TYPE = associate(AbstractBarFactory.createAbstractBar_FooAssignment_4ElementType());

	public static final IGrammarAwareElementType AbstractBar_FooFooCrossReference_4_0_ELEMENT_TYPE = associate(AbstractBarFactory.createAbstractBar_FooFooCrossReference_4_0ElementType());

	public static final IGrammarAwareElementType AbstractBar_FooFooQualifiedNameWithOtherDelimParserRuleCall_4_0_1_ELEMENT_TYPE = associate(AbstractBarFactory.createAbstractBar_FooFooQualifiedNameWithOtherDelimParserRuleCall_4_0_1ElementType());

	private static class BarFactory {
		public static IGrammarAwareElementType createBarElementType() {
			return new IGrammarAwareElementType("Bar_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBarRule());
		}
		public static IGrammarAwareElementType createBar_GroupElementType() {
			return new IGrammarAwareElementType("Bar_Group_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBarAccess().getGroup());
		}
		public static IGrammarAwareElementType createBar_BarKeyword_0ElementType() {
			return new IGrammarAwareElementType("Bar_BarKeyword_0_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBarAccess().getBarKeyword_0());
		}
		public static IGrammarAwareElementType createBar_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Bar_NameAssignment_1_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBarAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createBar_NameIDTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Bar_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBarAccess().getNameIDTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createBar_FooAssignment_2ElementType() {
			return new IGrammarAwareElementType("Bar_FooAssignment_2_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBarAccess().getFooAssignment_2());
		}
		public static IGrammarAwareElementType createBar_FooFooCrossReference_2_0ElementType() {
			return new IGrammarAwareElementType("Bar_FooFooCrossReference_2_0_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBarAccess().getFooFooCrossReference_2_0());
		}
		public static IGrammarAwareElementType createBar_FooFooQualifiedNameWithOtherDelimParserRuleCall_2_0_1ElementType() {
			return new IGrammarAwareElementType("Bar_FooFooQualifiedNameWithOtherDelimParserRuleCall_2_0_1_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBarAccess().getFooFooQualifiedNameWithOtherDelimParserRuleCall_2_0_1());
		}
		public static IGrammarAwareElementType createBar_Group_3ElementType() {
			return new IGrammarAwareElementType("Bar_Group_3_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBarAccess().getGroup_3());
		}
		public static IGrammarAwareElementType createBar_CommaKeyword_3_0ElementType() {
			return new IGrammarAwareElementType("Bar_CommaKeyword_3_0_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBarAccess().getCommaKeyword_3_0());
		}
		public static IGrammarAwareElementType createBar_FooAssignment_3_1ElementType() {
			return new IGrammarAwareElementType("Bar_FooAssignment_3_1_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBarAccess().getFooAssignment_3_1());
		}
		public static IGrammarAwareElementType createBar_FooFooCrossReference_3_1_0ElementType() {
			return new IGrammarAwareElementType("Bar_FooFooCrossReference_3_1_0_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBarAccess().getFooFooCrossReference_3_1_0());
		}
		public static IGrammarAwareElementType createBar_FooFooQualifiedNameWithOtherDelimParserRuleCall_3_1_0_1ElementType() {
			return new IGrammarAwareElementType("Bar_FooFooQualifiedNameWithOtherDelimParserRuleCall_3_1_0_1_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBarAccess().getFooFooQualifiedNameWithOtherDelimParserRuleCall_3_1_0_1());
		}
	}

	public static final IGrammarAwareElementType Bar_ELEMENT_TYPE = associate(BarFactory.createBarElementType());

	public static final IGrammarAwareElementType Bar_Group_ELEMENT_TYPE = associate(BarFactory.createBar_GroupElementType());

	public static final IGrammarAwareElementType Bar_BarKeyword_0_ELEMENT_TYPE = associate(BarFactory.createBar_BarKeyword_0ElementType());

	public static final IGrammarAwareElementType Bar_NameAssignment_1_ELEMENT_TYPE = associate(BarFactory.createBar_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Bar_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE = associate(BarFactory.createBar_NameIDTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Bar_FooAssignment_2_ELEMENT_TYPE = associate(BarFactory.createBar_FooAssignment_2ElementType());

	public static final IGrammarAwareElementType Bar_FooFooCrossReference_2_0_ELEMENT_TYPE = associate(BarFactory.createBar_FooFooCrossReference_2_0ElementType());

	public static final IGrammarAwareElementType Bar_FooFooQualifiedNameWithOtherDelimParserRuleCall_2_0_1_ELEMENT_TYPE = associate(BarFactory.createBar_FooFooQualifiedNameWithOtherDelimParserRuleCall_2_0_1ElementType());

	public static final IGrammarAwareElementType Bar_Group_3_ELEMENT_TYPE = associate(BarFactory.createBar_Group_3ElementType());

	public static final IGrammarAwareElementType Bar_CommaKeyword_3_0_ELEMENT_TYPE = associate(BarFactory.createBar_CommaKeyword_3_0ElementType());

	public static final IGrammarAwareElementType Bar_FooAssignment_3_1_ELEMENT_TYPE = associate(BarFactory.createBar_FooAssignment_3_1ElementType());

	public static final IGrammarAwareElementType Bar_FooFooCrossReference_3_1_0_ELEMENT_TYPE = associate(BarFactory.createBar_FooFooCrossReference_3_1_0ElementType());

	public static final IGrammarAwareElementType Bar_FooFooQualifiedNameWithOtherDelimParserRuleCall_3_1_0_1_ELEMENT_TYPE = associate(BarFactory.createBar_FooFooQualifiedNameWithOtherDelimParserRuleCall_3_1_0_1ElementType());

	private static class FooFactory {
		public static IGrammarAwareElementType createFooElementType() {
			return new IGrammarAwareElementType("Foo_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooRule());
		}
		public static IGrammarAwareElementType createFoo_GroupElementType() {
			return new IGrammarAwareElementType("Foo_Group_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getGroup());
		}
		public static IGrammarAwareElementType createFoo_FooKeyword_0ElementType() {
			return new IGrammarAwareElementType("Foo_FooKeyword_0_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getFooKeyword_0());
		}
		public static IGrammarAwareElementType createFoo_NameAssignment_1ElementType() {
			return new IGrammarAwareElementType("Foo_NameAssignment_1_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getNameAssignment_1());
		}
		public static IGrammarAwareElementType createFoo_NameQualifiedNameWithOtherDelimParserRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Foo_NameQualifiedNameWithOtherDelimParserRuleCall_1_0_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getNameQualifiedNameWithOtherDelimParserRuleCall_1_0());
		}
	}

	public static final IGrammarAwareElementType Foo_ELEMENT_TYPE = associate(FooFactory.createFooElementType());

	public static final IGrammarAwareElementType Foo_Group_ELEMENT_TYPE = associate(FooFactory.createFoo_GroupElementType());

	public static final IGrammarAwareElementType Foo_FooKeyword_0_ELEMENT_TYPE = associate(FooFactory.createFoo_FooKeyword_0ElementType());

	public static final IGrammarAwareElementType Foo_NameAssignment_1_ELEMENT_TYPE = associate(FooFactory.createFoo_NameAssignment_1ElementType());

	public static final IGrammarAwareElementType Foo_NameQualifiedNameWithOtherDelimParserRuleCall_1_0_ELEMENT_TYPE = associate(FooFactory.createFoo_NameQualifiedNameWithOtherDelimParserRuleCall_1_0ElementType());

	private static class QualifiedNameWithOtherDelimFactory {
		public static IGrammarAwareElementType createQualifiedNameWithOtherDelimElementType() {
			return new IGrammarAwareElementType("QualifiedNameWithOtherDelim_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameWithOtherDelimRule());
		}
		public static IGrammarAwareElementType createQualifiedNameWithOtherDelim_GroupElementType() {
			return new IGrammarAwareElementType("QualifiedNameWithOtherDelim_Group_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameWithOtherDelimAccess().getGroup());
		}
		public static IGrammarAwareElementType createQualifiedNameWithOtherDelim_QualifiedNameParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("QualifiedNameWithOtherDelim_QualifiedNameParserRuleCall_0_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameWithOtherDelimAccess().getQualifiedNameParserRuleCall_0());
		}
		public static IGrammarAwareElementType createQualifiedNameWithOtherDelim_Group_1ElementType() {
			return new IGrammarAwareElementType("QualifiedNameWithOtherDelim_Group_1_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameWithOtherDelimAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createQualifiedNameWithOtherDelim_EqualsSignKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("QualifiedNameWithOtherDelim_EqualsSignKeyword_1_0_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameWithOtherDelimAccess().getEqualsSignKeyword_1_0());
		}
		public static IGrammarAwareElementType createQualifiedNameWithOtherDelim_QualifiedNameParserRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("QualifiedNameWithOtherDelim_QualifiedNameParserRuleCall_1_1_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameWithOtherDelimAccess().getQualifiedNameParserRuleCall_1_1());
		}
	}

	public static final IGrammarAwareElementType QualifiedNameWithOtherDelim_ELEMENT_TYPE = associate(QualifiedNameWithOtherDelimFactory.createQualifiedNameWithOtherDelimElementType());

	public static final IGrammarAwareElementType QualifiedNameWithOtherDelim_Group_ELEMENT_TYPE = associate(QualifiedNameWithOtherDelimFactory.createQualifiedNameWithOtherDelim_GroupElementType());

	public static final IGrammarAwareElementType QualifiedNameWithOtherDelim_QualifiedNameParserRuleCall_0_ELEMENT_TYPE = associate(QualifiedNameWithOtherDelimFactory.createQualifiedNameWithOtherDelim_QualifiedNameParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType QualifiedNameWithOtherDelim_Group_1_ELEMENT_TYPE = associate(QualifiedNameWithOtherDelimFactory.createQualifiedNameWithOtherDelim_Group_1ElementType());

	public static final IGrammarAwareElementType QualifiedNameWithOtherDelim_EqualsSignKeyword_1_0_ELEMENT_TYPE = associate(QualifiedNameWithOtherDelimFactory.createQualifiedNameWithOtherDelim_EqualsSignKeyword_1_0ElementType());

	public static final IGrammarAwareElementType QualifiedNameWithOtherDelim_QualifiedNameParserRuleCall_1_1_ELEMENT_TYPE = associate(QualifiedNameWithOtherDelimFactory.createQualifiedNameWithOtherDelim_QualifiedNameParserRuleCall_1_1ElementType());

	private static class QualifiedNameFactory {
		public static IGrammarAwareElementType createQualifiedNameElementType() {
			return new IGrammarAwareElementType("QualifiedName_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameRule());
		}
		public static IGrammarAwareElementType createQualifiedName_GroupElementType() {
			return new IGrammarAwareElementType("QualifiedName_Group_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameAccess().getGroup());
		}
		public static IGrammarAwareElementType createQualifiedName_IDTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("QualifiedName_IDTerminalRuleCall_0_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameAccess().getIDTerminalRuleCall_0());
		}
		public static IGrammarAwareElementType createQualifiedName_Group_1ElementType() {
			return new IGrammarAwareElementType("QualifiedName_Group_1_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameAccess().getGroup_1());
		}
		public static IGrammarAwareElementType createQualifiedName_FullStopKeyword_1_0ElementType() {
			return new IGrammarAwareElementType("QualifiedName_FullStopKeyword_1_0_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameAccess().getFullStopKeyword_1_0());
		}
		public static IGrammarAwareElementType createQualifiedName_IDTerminalRuleCall_1_1ElementType() {
			return new IGrammarAwareElementType("QualifiedName_IDTerminalRuleCall_1_1_ELEMENT_TYPE", EObjectAtOffsetTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
		}
	}

	public static final IGrammarAwareElementType QualifiedName_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedNameElementType());

	public static final IGrammarAwareElementType QualifiedName_Group_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedName_GroupElementType());

	public static final IGrammarAwareElementType QualifiedName_IDTerminalRuleCall_0_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedName_IDTerminalRuleCall_0ElementType());

	public static final IGrammarAwareElementType QualifiedName_Group_1_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedName_Group_1ElementType());

	public static final IGrammarAwareElementType QualifiedName_FullStopKeyword_1_0_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedName_FullStopKeyword_1_0ElementType());

	public static final IGrammarAwareElementType QualifiedName_IDTerminalRuleCall_1_1_ELEMENT_TYPE = associate(QualifiedNameFactory.createQualifiedName_IDTerminalRuleCall_1_1ElementType());

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

	public IGrammarAwareElementType getModel_FoosAssignment_0ElementType() {
		return Model_FoosAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_FoosFooParserRuleCall_0_0ElementType() {
		return Model_FoosFooParserRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_BarsAssignment_1ElementType() {
		return Model_BarsAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getModel_BarsAbstractBarParserRuleCall_1_0ElementType() {
		return Model_BarsAbstractBarParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractBarElementType() {
		return AbstractBar_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractBar_GroupElementType() {
		return AbstractBar_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractBar_ZonkKeyword_0ElementType() {
		return AbstractBar_ZonkKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractBar_INTTerminalRuleCall_1ElementType() {
		return AbstractBar_INTTerminalRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractBar_BarParserRuleCall_2ElementType() {
		return AbstractBar_BarParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractBar_Group_3ElementType() {
		return AbstractBar_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractBar_FooBarBarAction_3_0ElementType() {
		return AbstractBar_FooBarBarAction_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractBar_FoobarKeyword_3_1ElementType() {
		return AbstractBar_FoobarKeyword_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractBar_FooAssignment_3_2ElementType() {
		return AbstractBar_FooAssignment_3_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractBar_FooFooCrossReference_3_2_0ElementType() {
		return AbstractBar_FooFooCrossReference_3_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractBar_FooFooQualifiedNameWithOtherDelimParserRuleCall_3_2_0_1ElementType() {
		return AbstractBar_FooFooQualifiedNameWithOtherDelimParserRuleCall_3_2_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractBar_FooAssignment_4ElementType() {
		return AbstractBar_FooAssignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractBar_FooFooCrossReference_4_0ElementType() {
		return AbstractBar_FooFooCrossReference_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getAbstractBar_FooFooQualifiedNameWithOtherDelimParserRuleCall_4_0_1ElementType() {
		return AbstractBar_FooFooQualifiedNameWithOtherDelimParserRuleCall_4_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBarElementType() {
		return Bar_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBar_GroupElementType() {
		return Bar_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBar_BarKeyword_0ElementType() {
		return Bar_BarKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBar_NameAssignment_1ElementType() {
		return Bar_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBar_NameIDTerminalRuleCall_1_0ElementType() {
		return Bar_NameIDTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBar_FooAssignment_2ElementType() {
		return Bar_FooAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBar_FooFooCrossReference_2_0ElementType() {
		return Bar_FooFooCrossReference_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBar_FooFooQualifiedNameWithOtherDelimParserRuleCall_2_0_1ElementType() {
		return Bar_FooFooQualifiedNameWithOtherDelimParserRuleCall_2_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBar_Group_3ElementType() {
		return Bar_Group_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBar_CommaKeyword_3_0ElementType() {
		return Bar_CommaKeyword_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBar_FooAssignment_3_1ElementType() {
		return Bar_FooAssignment_3_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBar_FooFooCrossReference_3_1_0ElementType() {
		return Bar_FooFooCrossReference_3_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBar_FooFooQualifiedNameWithOtherDelimParserRuleCall_3_1_0_1ElementType() {
		return Bar_FooFooQualifiedNameWithOtherDelimParserRuleCall_3_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFooElementType() {
		return Foo_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFoo_GroupElementType() {
		return Foo_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFoo_FooKeyword_0ElementType() {
		return Foo_FooKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFoo_NameAssignment_1ElementType() {
		return Foo_NameAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFoo_NameQualifiedNameWithOtherDelimParserRuleCall_1_0ElementType() {
		return Foo_NameQualifiedNameWithOtherDelimParserRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQualifiedNameWithOtherDelimElementType() {
		return QualifiedNameWithOtherDelim_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQualifiedNameWithOtherDelim_GroupElementType() {
		return QualifiedNameWithOtherDelim_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQualifiedNameWithOtherDelim_QualifiedNameParserRuleCall_0ElementType() {
		return QualifiedNameWithOtherDelim_QualifiedNameParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQualifiedNameWithOtherDelim_Group_1ElementType() {
		return QualifiedNameWithOtherDelim_Group_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQualifiedNameWithOtherDelim_EqualsSignKeyword_1_0ElementType() {
		return QualifiedNameWithOtherDelim_EqualsSignKeyword_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getQualifiedNameWithOtherDelim_QualifiedNameParserRuleCall_1_1ElementType() {
		return QualifiedNameWithOtherDelim_QualifiedNameParserRuleCall_1_1_ELEMENT_TYPE;
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

}
