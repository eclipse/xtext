package org.eclipse.xtext.parser.assignments.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.parser.assignments.idea.lang.psi.impl.Bug288432TestLanguageFileImpl;
import org.eclipse.xtext.parser.assignments.services.Bug288432TestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class Bug288432TestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<Bug288432TestLanguageFileImpl>>(Bug288432TestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final Bug288432TestLanguageGrammarAccess GRAMMAR_ACCESS = Bug288432TestLanguageLanguage.INSTANCE.getInstance(Bug288432TestLanguageGrammarAccess.class);

	private static class BodyFactory {
		public static IGrammarAwareElementType createBodyElementType() {
			return new IGrammarAwareElementType("Body_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBodyRule());
		}
		public static IGrammarAwareElementType createBody_GroupElementType() {
			return new IGrammarAwareElementType("Body_Group_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBodyAccess().getGroup());
		}
		public static IGrammarAwareElementType createBody_Group_0ElementType() {
			return new IGrammarAwareElementType("Body_Group_0_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBodyAccess().getGroup_0());
		}
		public static IGrammarAwareElementType createBody_LeftParenthesisKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("Body_LeftParenthesisKeyword_0_0_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBodyAccess().getLeftParenthesisKeyword_0_0());
		}
		public static IGrammarAwareElementType createBody_ParameterAssignment_0_1ElementType() {
			return new IGrammarAwareElementType("Body_ParameterAssignment_0_1_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBodyAccess().getParameterAssignment_0_1());
		}
		public static IGrammarAwareElementType createBody_ParameterParameterParserRuleCall_0_1_0ElementType() {
			return new IGrammarAwareElementType("Body_ParameterParameterParserRuleCall_0_1_0_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBodyAccess().getParameterParameterParserRuleCall_0_1_0());
		}
		public static IGrammarAwareElementType createBody_Group_0_2ElementType() {
			return new IGrammarAwareElementType("Body_Group_0_2_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBodyAccess().getGroup_0_2());
		}
		public static IGrammarAwareElementType createBody_CommaKeyword_0_2_0ElementType() {
			return new IGrammarAwareElementType("Body_CommaKeyword_0_2_0_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBodyAccess().getCommaKeyword_0_2_0());
		}
		public static IGrammarAwareElementType createBody_ParameterAssignment_0_2_1ElementType() {
			return new IGrammarAwareElementType("Body_ParameterAssignment_0_2_1_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBodyAccess().getParameterAssignment_0_2_1());
		}
		public static IGrammarAwareElementType createBody_ParameterParameterParserRuleCall_0_2_1_0ElementType() {
			return new IGrammarAwareElementType("Body_ParameterParameterParserRuleCall_0_2_1_0_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBodyAccess().getParameterParameterParserRuleCall_0_2_1_0());
		}
		public static IGrammarAwareElementType createBody_RightParenthesisKeyword_0_3ElementType() {
			return new IGrammarAwareElementType("Body_RightParenthesisKeyword_0_3_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBodyAccess().getRightParenthesisKeyword_0_3());
		}
		public static IGrammarAwareElementType createBody_BodyKeyword_1ElementType() {
			return new IGrammarAwareElementType("Body_BodyKeyword_1_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBodyAccess().getBodyKeyword_1());
		}
		public static IGrammarAwareElementType createBody_ContentAssignment_2ElementType() {
			return new IGrammarAwareElementType("Body_ContentAssignment_2_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBodyAccess().getContentAssignment_2());
		}
		public static IGrammarAwareElementType createBody_ContentAlternatives_2_0ElementType() {
			return new IGrammarAwareElementType("Body_ContentAlternatives_2_0_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBodyAccess().getContentAlternatives_2_0());
		}
		public static IGrammarAwareElementType createBody_ContentContentParserRuleCall_2_0_0ElementType() {
			return new IGrammarAwareElementType("Body_ContentContentParserRuleCall_2_0_0_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBodyAccess().getContentContentParserRuleCall_2_0_0());
		}
		public static IGrammarAwareElementType createBody_ContentParameterRefParserRuleCall_2_0_1ElementType() {
			return new IGrammarAwareElementType("Body_ContentParameterRefParserRuleCall_2_0_1_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBodyAccess().getContentParameterRefParserRuleCall_2_0_1());
		}
		public static IGrammarAwareElementType createBody_FooAssignment_3ElementType() {
			return new IGrammarAwareElementType("Body_FooAssignment_3_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBodyAccess().getFooAssignment_3());
		}
		public static IGrammarAwareElementType createBody_FooFooParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("Body_FooFooParserRuleCall_3_0_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBodyAccess().getFooFooParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createBody_EndBodyKeyword_4ElementType() {
			return new IGrammarAwareElementType("Body_EndBodyKeyword_4_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getBodyAccess().getEndBodyKeyword_4());
		}
	}

	public static final IGrammarAwareElementType Body_ELEMENT_TYPE = associate(BodyFactory.createBodyElementType());

	public static final IGrammarAwareElementType Body_Group_ELEMENT_TYPE = associate(BodyFactory.createBody_GroupElementType());

	public static final IGrammarAwareElementType Body_Group_0_ELEMENT_TYPE = associate(BodyFactory.createBody_Group_0ElementType());

	public static final IGrammarAwareElementType Body_LeftParenthesisKeyword_0_0_ELEMENT_TYPE = associate(BodyFactory.createBody_LeftParenthesisKeyword_0_0ElementType());

	public static final IGrammarAwareElementType Body_ParameterAssignment_0_1_ELEMENT_TYPE = associate(BodyFactory.createBody_ParameterAssignment_0_1ElementType());

	public static final IGrammarAwareElementType Body_ParameterParameterParserRuleCall_0_1_0_ELEMENT_TYPE = associate(BodyFactory.createBody_ParameterParameterParserRuleCall_0_1_0ElementType());

	public static final IGrammarAwareElementType Body_Group_0_2_ELEMENT_TYPE = associate(BodyFactory.createBody_Group_0_2ElementType());

	public static final IGrammarAwareElementType Body_CommaKeyword_0_2_0_ELEMENT_TYPE = associate(BodyFactory.createBody_CommaKeyword_0_2_0ElementType());

	public static final IGrammarAwareElementType Body_ParameterAssignment_0_2_1_ELEMENT_TYPE = associate(BodyFactory.createBody_ParameterAssignment_0_2_1ElementType());

	public static final IGrammarAwareElementType Body_ParameterParameterParserRuleCall_0_2_1_0_ELEMENT_TYPE = associate(BodyFactory.createBody_ParameterParameterParserRuleCall_0_2_1_0ElementType());

	public static final IGrammarAwareElementType Body_RightParenthesisKeyword_0_3_ELEMENT_TYPE = associate(BodyFactory.createBody_RightParenthesisKeyword_0_3ElementType());

	public static final IGrammarAwareElementType Body_BodyKeyword_1_ELEMENT_TYPE = associate(BodyFactory.createBody_BodyKeyword_1ElementType());

	public static final IGrammarAwareElementType Body_ContentAssignment_2_ELEMENT_TYPE = associate(BodyFactory.createBody_ContentAssignment_2ElementType());

	public static final IGrammarAwareElementType Body_ContentAlternatives_2_0_ELEMENT_TYPE = associate(BodyFactory.createBody_ContentAlternatives_2_0ElementType());

	public static final IGrammarAwareElementType Body_ContentContentParserRuleCall_2_0_0_ELEMENT_TYPE = associate(BodyFactory.createBody_ContentContentParserRuleCall_2_0_0ElementType());

	public static final IGrammarAwareElementType Body_ContentParameterRefParserRuleCall_2_0_1_ELEMENT_TYPE = associate(BodyFactory.createBody_ContentParameterRefParserRuleCall_2_0_1ElementType());

	public static final IGrammarAwareElementType Body_FooAssignment_3_ELEMENT_TYPE = associate(BodyFactory.createBody_FooAssignment_3ElementType());

	public static final IGrammarAwareElementType Body_FooFooParserRuleCall_3_0_ELEMENT_TYPE = associate(BodyFactory.createBody_FooFooParserRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType Body_EndBodyKeyword_4_ELEMENT_TYPE = associate(BodyFactory.createBody_EndBodyKeyword_4ElementType());

	private static class FooFactory {
		public static IGrammarAwareElementType createFooElementType() {
			return new IGrammarAwareElementType("Foo_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooRule());
		}
		public static IGrammarAwareElementType createFoo_FooValueAssignmentElementType() {
			return new IGrammarAwareElementType("Foo_FooValueAssignment_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getFooValueAssignment());
		}
		public static IGrammarAwareElementType createFoo_FooValueSTRINGTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Foo_FooValueSTRINGTerminalRuleCall_0_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFooAccess().getFooValueSTRINGTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType Foo_ELEMENT_TYPE = associate(FooFactory.createFooElementType());

	public static final IGrammarAwareElementType Foo_FooValueAssignment_ELEMENT_TYPE = associate(FooFactory.createFoo_FooValueAssignmentElementType());

	public static final IGrammarAwareElementType Foo_FooValueSTRINGTerminalRuleCall_0_ELEMENT_TYPE = associate(FooFactory.createFoo_FooValueSTRINGTerminalRuleCall_0ElementType());

	private static class ContentFactory {
		public static IGrammarAwareElementType createContentElementType() {
			return new IGrammarAwareElementType("Content_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContentRule());
		}
		public static IGrammarAwareElementType createContent_GroupElementType() {
			return new IGrammarAwareElementType("Content_Group_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContentAccess().getGroup());
		}
		public static IGrammarAwareElementType createContent_ContentKeyword_0ElementType() {
			return new IGrammarAwareElementType("Content_ContentKeyword_0_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContentAccess().getContentKeyword_0());
		}
		public static IGrammarAwareElementType createContent_MyElementParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Content_MyElementParserRuleCall_1_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContentAccess().getMyElementParserRuleCall_1());
		}
		public static IGrammarAwareElementType createContent_EndContentKeyword_2ElementType() {
			return new IGrammarAwareElementType("Content_EndContentKeyword_2_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getContentAccess().getEndContentKeyword_2());
		}
	}

	public static final IGrammarAwareElementType Content_ELEMENT_TYPE = associate(ContentFactory.createContentElementType());

	public static final IGrammarAwareElementType Content_Group_ELEMENT_TYPE = associate(ContentFactory.createContent_GroupElementType());

	public static final IGrammarAwareElementType Content_ContentKeyword_0_ELEMENT_TYPE = associate(ContentFactory.createContent_ContentKeyword_0ElementType());

	public static final IGrammarAwareElementType Content_MyElementParserRuleCall_1_ELEMENT_TYPE = associate(ContentFactory.createContent_MyElementParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType Content_EndContentKeyword_2_ELEMENT_TYPE = associate(ContentFactory.createContent_EndContentKeyword_2ElementType());

	private static class MyElementFactory {
		public static IGrammarAwareElementType createMyElementElementType() {
			return new IGrammarAwareElementType("MyElement_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMyElementRule());
		}
		public static IGrammarAwareElementType createMyElement_GroupElementType() {
			return new IGrammarAwareElementType("MyElement_Group_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMyElementAccess().getGroup());
		}
		public static IGrammarAwareElementType createMyElement_ElementKeyword_0ElementType() {
			return new IGrammarAwareElementType("MyElement_ElementKeyword_0_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMyElementAccess().getElementKeyword_0());
		}
		public static IGrammarAwareElementType createMyElement_BarAssignment_1ElementType() {
			return new IGrammarAwareElementType("MyElement_BarAssignment_1_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMyElementAccess().getBarAssignment_1());
		}
		public static IGrammarAwareElementType createMyElement_BarAlternatives_1_0ElementType() {
			return new IGrammarAwareElementType("MyElement_BarAlternatives_1_0_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMyElementAccess().getBarAlternatives_1_0());
		}
		public static IGrammarAwareElementType createMyElement_BarMyIntParserRuleCall_1_0_0ElementType() {
			return new IGrammarAwareElementType("MyElement_BarMyIntParserRuleCall_1_0_0_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMyElementAccess().getBarMyIntParserRuleCall_1_0_0());
		}
		public static IGrammarAwareElementType createMyElement_BarParameterRefParserRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("MyElement_BarParameterRefParserRuleCall_1_0_1_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMyElementAccess().getBarParameterRefParserRuleCall_1_0_1());
		}
	}

	public static final IGrammarAwareElementType MyElement_ELEMENT_TYPE = associate(MyElementFactory.createMyElementElementType());

	public static final IGrammarAwareElementType MyElement_Group_ELEMENT_TYPE = associate(MyElementFactory.createMyElement_GroupElementType());

	public static final IGrammarAwareElementType MyElement_ElementKeyword_0_ELEMENT_TYPE = associate(MyElementFactory.createMyElement_ElementKeyword_0ElementType());

	public static final IGrammarAwareElementType MyElement_BarAssignment_1_ELEMENT_TYPE = associate(MyElementFactory.createMyElement_BarAssignment_1ElementType());

	public static final IGrammarAwareElementType MyElement_BarAlternatives_1_0_ELEMENT_TYPE = associate(MyElementFactory.createMyElement_BarAlternatives_1_0ElementType());

	public static final IGrammarAwareElementType MyElement_BarMyIntParserRuleCall_1_0_0_ELEMENT_TYPE = associate(MyElementFactory.createMyElement_BarMyIntParserRuleCall_1_0_0ElementType());

	public static final IGrammarAwareElementType MyElement_BarParameterRefParserRuleCall_1_0_1_ELEMENT_TYPE = associate(MyElementFactory.createMyElement_BarParameterRefParserRuleCall_1_0_1ElementType());

	private static class ParameterObjectFactory {
		public static IGrammarAwareElementType createParameterObjectElementType() {
			return new IGrammarAwareElementType("ParameterObject_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParameterObjectRule());
		}
		public static IGrammarAwareElementType createParameterObject_AlternativesElementType() {
			return new IGrammarAwareElementType("ParameterObject_Alternatives_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParameterObjectAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createParameterObject_MyIntParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("ParameterObject_MyIntParserRuleCall_0_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParameterObjectAccess().getMyIntParserRuleCall_0());
		}
		public static IGrammarAwareElementType createParameterObject_ContentParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("ParameterObject_ContentParserRuleCall_1_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParameterObjectAccess().getContentParserRuleCall_1());
		}
		public static IGrammarAwareElementType createParameterObject_ParameterRefParserRuleCall_2ElementType() {
			return new IGrammarAwareElementType("ParameterObject_ParameterRefParserRuleCall_2_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParameterObjectAccess().getParameterRefParserRuleCall_2());
		}
	}

	public static final IGrammarAwareElementType ParameterObject_ELEMENT_TYPE = associate(ParameterObjectFactory.createParameterObjectElementType());

	public static final IGrammarAwareElementType ParameterObject_Alternatives_ELEMENT_TYPE = associate(ParameterObjectFactory.createParameterObject_AlternativesElementType());

	public static final IGrammarAwareElementType ParameterObject_MyIntParserRuleCall_0_ELEMENT_TYPE = associate(ParameterObjectFactory.createParameterObject_MyIntParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType ParameterObject_ContentParserRuleCall_1_ELEMENT_TYPE = associate(ParameterObjectFactory.createParameterObject_ContentParserRuleCall_1ElementType());

	public static final IGrammarAwareElementType ParameterObject_ParameterRefParserRuleCall_2_ELEMENT_TYPE = associate(ParameterObjectFactory.createParameterObject_ParameterRefParserRuleCall_2ElementType());

	private static class ParameterFactory {
		public static IGrammarAwareElementType createParameterElementType() {
			return new IGrammarAwareElementType("Parameter_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParameterRule());
		}
		public static IGrammarAwareElementType createParameter_GroupElementType() {
			return new IGrammarAwareElementType("Parameter_Group_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParameterAccess().getGroup());
		}
		public static IGrammarAwareElementType createParameter_NameAssignment_0ElementType() {
			return new IGrammarAwareElementType("Parameter_NameAssignment_0_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParameterAccess().getNameAssignment_0());
		}
		public static IGrammarAwareElementType createParameter_NameIDTerminalRuleCall_0_0ElementType() {
			return new IGrammarAwareElementType("Parameter_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParameterAccess().getNameIDTerminalRuleCall_0_0());
		}
		public static IGrammarAwareElementType createParameter_ValueAssignment_1ElementType() {
			return new IGrammarAwareElementType("Parameter_ValueAssignment_1_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParameterAccess().getValueAssignment_1());
		}
		public static IGrammarAwareElementType createParameter_ValueParameterObjectCrossReference_1_0ElementType() {
			return new IGrammarAwareElementType("Parameter_ValueParameterObjectCrossReference_1_0_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParameterAccess().getValueParameterObjectCrossReference_1_0());
		}
		public static IGrammarAwareElementType createParameter_ValueParameterObjectIDTerminalRuleCall_1_0_1ElementType() {
			return new IGrammarAwareElementType("Parameter_ValueParameterObjectIDTerminalRuleCall_1_0_1_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParameterAccess().getValueParameterObjectIDTerminalRuleCall_1_0_1());
		}
	}

	public static final IGrammarAwareElementType Parameter_ELEMENT_TYPE = associate(ParameterFactory.createParameterElementType());

	public static final IGrammarAwareElementType Parameter_Group_ELEMENT_TYPE = associate(ParameterFactory.createParameter_GroupElementType());

	public static final IGrammarAwareElementType Parameter_NameAssignment_0_ELEMENT_TYPE = associate(ParameterFactory.createParameter_NameAssignment_0ElementType());

	public static final IGrammarAwareElementType Parameter_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE = associate(ParameterFactory.createParameter_NameIDTerminalRuleCall_0_0ElementType());

	public static final IGrammarAwareElementType Parameter_ValueAssignment_1_ELEMENT_TYPE = associate(ParameterFactory.createParameter_ValueAssignment_1ElementType());

	public static final IGrammarAwareElementType Parameter_ValueParameterObjectCrossReference_1_0_ELEMENT_TYPE = associate(ParameterFactory.createParameter_ValueParameterObjectCrossReference_1_0ElementType());

	public static final IGrammarAwareElementType Parameter_ValueParameterObjectIDTerminalRuleCall_1_0_1_ELEMENT_TYPE = associate(ParameterFactory.createParameter_ValueParameterObjectIDTerminalRuleCall_1_0_1ElementType());

	private static class ParameterRefFactory {
		public static IGrammarAwareElementType createParameterRefElementType() {
			return new IGrammarAwareElementType("ParameterRef_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParameterRefRule());
		}
		public static IGrammarAwareElementType createParameterRef_ParameterAssignmentElementType() {
			return new IGrammarAwareElementType("ParameterRef_ParameterAssignment_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParameterRefAccess().getParameterAssignment());
		}
		public static IGrammarAwareElementType createParameterRef_ParameterParameterCrossReference_0ElementType() {
			return new IGrammarAwareElementType("ParameterRef_ParameterParameterCrossReference_0_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParameterRefAccess().getParameterParameterCrossReference_0());
		}
		public static IGrammarAwareElementType createParameterRef_ParameterParameterIDTerminalRuleCall_0_1ElementType() {
			return new IGrammarAwareElementType("ParameterRef_ParameterParameterIDTerminalRuleCall_0_1_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getParameterRefAccess().getParameterParameterIDTerminalRuleCall_0_1());
		}
	}

	public static final IGrammarAwareElementType ParameterRef_ELEMENT_TYPE = associate(ParameterRefFactory.createParameterRefElementType());

	public static final IGrammarAwareElementType ParameterRef_ParameterAssignment_ELEMENT_TYPE = associate(ParameterRefFactory.createParameterRef_ParameterAssignmentElementType());

	public static final IGrammarAwareElementType ParameterRef_ParameterParameterCrossReference_0_ELEMENT_TYPE = associate(ParameterRefFactory.createParameterRef_ParameterParameterCrossReference_0ElementType());

	public static final IGrammarAwareElementType ParameterRef_ParameterParameterIDTerminalRuleCall_0_1_ELEMENT_TYPE = associate(ParameterRefFactory.createParameterRef_ParameterParameterIDTerminalRuleCall_0_1ElementType());

	private static class MyIntFactory {
		public static IGrammarAwareElementType createMyIntElementType() {
			return new IGrammarAwareElementType("MyInt_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMyIntRule());
		}
		public static IGrammarAwareElementType createMyInt_IntAssignmentElementType() {
			return new IGrammarAwareElementType("MyInt_IntAssignment_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMyIntAccess().getIntAssignment());
		}
		public static IGrammarAwareElementType createMyInt_IntINTTerminalRuleCall_0ElementType() {
			return new IGrammarAwareElementType("MyInt_IntINTTerminalRuleCall_0_ELEMENT_TYPE", Bug288432TestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getMyIntAccess().getIntINTTerminalRuleCall_0());
		}
	}

	public static final IGrammarAwareElementType MyInt_ELEMENT_TYPE = associate(MyIntFactory.createMyIntElementType());

	public static final IGrammarAwareElementType MyInt_IntAssignment_ELEMENT_TYPE = associate(MyIntFactory.createMyInt_IntAssignmentElementType());

	public static final IGrammarAwareElementType MyInt_IntINTTerminalRuleCall_0_ELEMENT_TYPE = associate(MyIntFactory.createMyInt_IntINTTerminalRuleCall_0ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getBodyElementType() {
		return Body_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBody_GroupElementType() {
		return Body_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBody_Group_0ElementType() {
		return Body_Group_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBody_LeftParenthesisKeyword_0_0ElementType() {
		return Body_LeftParenthesisKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBody_ParameterAssignment_0_1ElementType() {
		return Body_ParameterAssignment_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBody_ParameterParameterParserRuleCall_0_1_0ElementType() {
		return Body_ParameterParameterParserRuleCall_0_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBody_Group_0_2ElementType() {
		return Body_Group_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBody_CommaKeyword_0_2_0ElementType() {
		return Body_CommaKeyword_0_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBody_ParameterAssignment_0_2_1ElementType() {
		return Body_ParameterAssignment_0_2_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBody_ParameterParameterParserRuleCall_0_2_1_0ElementType() {
		return Body_ParameterParameterParserRuleCall_0_2_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBody_RightParenthesisKeyword_0_3ElementType() {
		return Body_RightParenthesisKeyword_0_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBody_BodyKeyword_1ElementType() {
		return Body_BodyKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBody_ContentAssignment_2ElementType() {
		return Body_ContentAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBody_ContentAlternatives_2_0ElementType() {
		return Body_ContentAlternatives_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBody_ContentContentParserRuleCall_2_0_0ElementType() {
		return Body_ContentContentParserRuleCall_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBody_ContentParameterRefParserRuleCall_2_0_1ElementType() {
		return Body_ContentParameterRefParserRuleCall_2_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBody_FooAssignment_3ElementType() {
		return Body_FooAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBody_FooFooParserRuleCall_3_0ElementType() {
		return Body_FooFooParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getBody_EndBodyKeyword_4ElementType() {
		return Body_EndBodyKeyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFooElementType() {
		return Foo_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFoo_FooValueAssignmentElementType() {
		return Foo_FooValueAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFoo_FooValueSTRINGTerminalRuleCall_0ElementType() {
		return Foo_FooValueSTRINGTerminalRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContentElementType() {
		return Content_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContent_GroupElementType() {
		return Content_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContent_ContentKeyword_0ElementType() {
		return Content_ContentKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContent_MyElementParserRuleCall_1ElementType() {
		return Content_MyElementParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getContent_EndContentKeyword_2ElementType() {
		return Content_EndContentKeyword_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMyElementElementType() {
		return MyElement_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMyElement_GroupElementType() {
		return MyElement_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMyElement_ElementKeyword_0ElementType() {
		return MyElement_ElementKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMyElement_BarAssignment_1ElementType() {
		return MyElement_BarAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMyElement_BarAlternatives_1_0ElementType() {
		return MyElement_BarAlternatives_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMyElement_BarMyIntParserRuleCall_1_0_0ElementType() {
		return MyElement_BarMyIntParserRuleCall_1_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMyElement_BarParameterRefParserRuleCall_1_0_1ElementType() {
		return MyElement_BarParameterRefParserRuleCall_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParameterObjectElementType() {
		return ParameterObject_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParameterObject_AlternativesElementType() {
		return ParameterObject_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParameterObject_MyIntParserRuleCall_0ElementType() {
		return ParameterObject_MyIntParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParameterObject_ContentParserRuleCall_1ElementType() {
		return ParameterObject_ContentParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParameterObject_ParameterRefParserRuleCall_2ElementType() {
		return ParameterObject_ParameterRefParserRuleCall_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParameterElementType() {
		return Parameter_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParameter_GroupElementType() {
		return Parameter_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParameter_NameAssignment_0ElementType() {
		return Parameter_NameAssignment_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParameter_NameIDTerminalRuleCall_0_0ElementType() {
		return Parameter_NameIDTerminalRuleCall_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParameter_ValueAssignment_1ElementType() {
		return Parameter_ValueAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParameter_ValueParameterObjectCrossReference_1_0ElementType() {
		return Parameter_ValueParameterObjectCrossReference_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParameter_ValueParameterObjectIDTerminalRuleCall_1_0_1ElementType() {
		return Parameter_ValueParameterObjectIDTerminalRuleCall_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParameterRefElementType() {
		return ParameterRef_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParameterRef_ParameterAssignmentElementType() {
		return ParameterRef_ParameterAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParameterRef_ParameterParameterCrossReference_0ElementType() {
		return ParameterRef_ParameterParameterCrossReference_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getParameterRef_ParameterParameterIDTerminalRuleCall_0_1ElementType() {
		return ParameterRef_ParameterParameterIDTerminalRuleCall_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMyIntElementType() {
		return MyInt_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMyInt_IntAssignmentElementType() {
		return MyInt_IntAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getMyInt_IntINTTerminalRuleCall_0ElementType() {
		return MyInt_IntINTTerminalRuleCall_0_ELEMENT_TYPE;
	}

}
