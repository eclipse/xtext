package org.eclipse.xtext.testlanguages.idea.lang;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.testlanguages.idea.lang.psi.impl.ReferenceGrammarTestLanguageFileImpl;
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;

import com.intellij.psi.tree.IFileElementType;

public class ReferenceGrammarTestLanguageElementTypeProvider implements IElementTypeProvider {

	public static final IFileElementType FILE_TYPE = new XtextFileElementType<XtextFileStub<ReferenceGrammarTestLanguageFileImpl>>(ReferenceGrammarTestLanguageLanguage.INSTANCE);

	private static final Map<EObject, IGrammarAwareElementType> GRAMMAR_ELEMENT_TYPE = new HashMap<EObject, IGrammarAwareElementType>();

	private static IGrammarAwareElementType associate(IGrammarAwareElementType grammarAwareElementType) {
		GRAMMAR_ELEMENT_TYPE.put(grammarAwareElementType.getGrammarElement(), grammarAwareElementType);
		return grammarAwareElementType;
	}

	private static final ReferenceGrammarTestLanguageGrammarAccess GRAMMAR_ACCESS = ReferenceGrammarTestLanguageLanguage.INSTANCE.getInstance(ReferenceGrammarTestLanguageGrammarAccess.class);

	private static class SpielplatzFactory {
		public static IGrammarAwareElementType createSpielplatzElementType() {
			return new IGrammarAwareElementType("Spielplatz_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielplatzRule());
		}
		public static IGrammarAwareElementType createSpielplatz_GroupElementType() {
			return new IGrammarAwareElementType("Spielplatz_Group_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielplatzAccess().getGroup());
		}
		public static IGrammarAwareElementType createSpielplatz_SpielplatzKeyword_0ElementType() {
			return new IGrammarAwareElementType("Spielplatz_SpielplatzKeyword_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielplatzAccess().getSpielplatzKeyword_0());
		}
		public static IGrammarAwareElementType createSpielplatz_GroesseAssignment_1ElementType() {
			return new IGrammarAwareElementType("Spielplatz_GroesseAssignment_1_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielplatzAccess().getGroesseAssignment_1());
		}
		public static IGrammarAwareElementType createSpielplatz_GroesseINTTerminalRuleCall_1_0ElementType() {
			return new IGrammarAwareElementType("Spielplatz_GroesseINTTerminalRuleCall_1_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielplatzAccess().getGroesseINTTerminalRuleCall_1_0());
		}
		public static IGrammarAwareElementType createSpielplatz_BeschreibungAssignment_2ElementType() {
			return new IGrammarAwareElementType("Spielplatz_BeschreibungAssignment_2_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielplatzAccess().getBeschreibungAssignment_2());
		}
		public static IGrammarAwareElementType createSpielplatz_BeschreibungSTRINGTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Spielplatz_BeschreibungSTRINGTerminalRuleCall_2_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielplatzAccess().getBeschreibungSTRINGTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createSpielplatz_LeftCurlyBracketKeyword_3ElementType() {
			return new IGrammarAwareElementType("Spielplatz_LeftCurlyBracketKeyword_3_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielplatzAccess().getLeftCurlyBracketKeyword_3());
		}
		public static IGrammarAwareElementType createSpielplatz_Alternatives_4ElementType() {
			return new IGrammarAwareElementType("Spielplatz_Alternatives_4_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielplatzAccess().getAlternatives_4());
		}
		public static IGrammarAwareElementType createSpielplatz_KinderAssignment_4_0ElementType() {
			return new IGrammarAwareElementType("Spielplatz_KinderAssignment_4_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielplatzAccess().getKinderAssignment_4_0());
		}
		public static IGrammarAwareElementType createSpielplatz_KinderKindParserRuleCall_4_0_0ElementType() {
			return new IGrammarAwareElementType("Spielplatz_KinderKindParserRuleCall_4_0_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielplatzAccess().getKinderKindParserRuleCall_4_0_0());
		}
		public static IGrammarAwareElementType createSpielplatz_ErzieherAssignment_4_1ElementType() {
			return new IGrammarAwareElementType("Spielplatz_ErzieherAssignment_4_1_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielplatzAccess().getErzieherAssignment_4_1());
		}
		public static IGrammarAwareElementType createSpielplatz_ErzieherErwachsenerParserRuleCall_4_1_0ElementType() {
			return new IGrammarAwareElementType("Spielplatz_ErzieherErwachsenerParserRuleCall_4_1_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielplatzAccess().getErzieherErwachsenerParserRuleCall_4_1_0());
		}
		public static IGrammarAwareElementType createSpielplatz_SpielzeugeAssignment_4_2ElementType() {
			return new IGrammarAwareElementType("Spielplatz_SpielzeugeAssignment_4_2_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielplatzAccess().getSpielzeugeAssignment_4_2());
		}
		public static IGrammarAwareElementType createSpielplatz_SpielzeugeSpielzeugParserRuleCall_4_2_0ElementType() {
			return new IGrammarAwareElementType("Spielplatz_SpielzeugeSpielzeugParserRuleCall_4_2_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielplatzAccess().getSpielzeugeSpielzeugParserRuleCall_4_2_0());
		}
		public static IGrammarAwareElementType createSpielplatz_FamilieAssignment_4_3ElementType() {
			return new IGrammarAwareElementType("Spielplatz_FamilieAssignment_4_3_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielplatzAccess().getFamilieAssignment_4_3());
		}
		public static IGrammarAwareElementType createSpielplatz_FamilieFamilieParserRuleCall_4_3_0ElementType() {
			return new IGrammarAwareElementType("Spielplatz_FamilieFamilieParserRuleCall_4_3_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielplatzAccess().getFamilieFamilieParserRuleCall_4_3_0());
		}
		public static IGrammarAwareElementType createSpielplatz_RightCurlyBracketKeyword_5ElementType() {
			return new IGrammarAwareElementType("Spielplatz_RightCurlyBracketKeyword_5_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielplatzAccess().getRightCurlyBracketKeyword_5());
		}
	}

	public static final IGrammarAwareElementType Spielplatz_ELEMENT_TYPE = associate(SpielplatzFactory.createSpielplatzElementType());

	public static final IGrammarAwareElementType Spielplatz_Group_ELEMENT_TYPE = associate(SpielplatzFactory.createSpielplatz_GroupElementType());

	public static final IGrammarAwareElementType Spielplatz_SpielplatzKeyword_0_ELEMENT_TYPE = associate(SpielplatzFactory.createSpielplatz_SpielplatzKeyword_0ElementType());

	public static final IGrammarAwareElementType Spielplatz_GroesseAssignment_1_ELEMENT_TYPE = associate(SpielplatzFactory.createSpielplatz_GroesseAssignment_1ElementType());

	public static final IGrammarAwareElementType Spielplatz_GroesseINTTerminalRuleCall_1_0_ELEMENT_TYPE = associate(SpielplatzFactory.createSpielplatz_GroesseINTTerminalRuleCall_1_0ElementType());

	public static final IGrammarAwareElementType Spielplatz_BeschreibungAssignment_2_ELEMENT_TYPE = associate(SpielplatzFactory.createSpielplatz_BeschreibungAssignment_2ElementType());

	public static final IGrammarAwareElementType Spielplatz_BeschreibungSTRINGTerminalRuleCall_2_0_ELEMENT_TYPE = associate(SpielplatzFactory.createSpielplatz_BeschreibungSTRINGTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType Spielplatz_LeftCurlyBracketKeyword_3_ELEMENT_TYPE = associate(SpielplatzFactory.createSpielplatz_LeftCurlyBracketKeyword_3ElementType());

	public static final IGrammarAwareElementType Spielplatz_Alternatives_4_ELEMENT_TYPE = associate(SpielplatzFactory.createSpielplatz_Alternatives_4ElementType());

	public static final IGrammarAwareElementType Spielplatz_KinderAssignment_4_0_ELEMENT_TYPE = associate(SpielplatzFactory.createSpielplatz_KinderAssignment_4_0ElementType());

	public static final IGrammarAwareElementType Spielplatz_KinderKindParserRuleCall_4_0_0_ELEMENT_TYPE = associate(SpielplatzFactory.createSpielplatz_KinderKindParserRuleCall_4_0_0ElementType());

	public static final IGrammarAwareElementType Spielplatz_ErzieherAssignment_4_1_ELEMENT_TYPE = associate(SpielplatzFactory.createSpielplatz_ErzieherAssignment_4_1ElementType());

	public static final IGrammarAwareElementType Spielplatz_ErzieherErwachsenerParserRuleCall_4_1_0_ELEMENT_TYPE = associate(SpielplatzFactory.createSpielplatz_ErzieherErwachsenerParserRuleCall_4_1_0ElementType());

	public static final IGrammarAwareElementType Spielplatz_SpielzeugeAssignment_4_2_ELEMENT_TYPE = associate(SpielplatzFactory.createSpielplatz_SpielzeugeAssignment_4_2ElementType());

	public static final IGrammarAwareElementType Spielplatz_SpielzeugeSpielzeugParserRuleCall_4_2_0_ELEMENT_TYPE = associate(SpielplatzFactory.createSpielplatz_SpielzeugeSpielzeugParserRuleCall_4_2_0ElementType());

	public static final IGrammarAwareElementType Spielplatz_FamilieAssignment_4_3_ELEMENT_TYPE = associate(SpielplatzFactory.createSpielplatz_FamilieAssignment_4_3ElementType());

	public static final IGrammarAwareElementType Spielplatz_FamilieFamilieParserRuleCall_4_3_0_ELEMENT_TYPE = associate(SpielplatzFactory.createSpielplatz_FamilieFamilieParserRuleCall_4_3_0ElementType());

	public static final IGrammarAwareElementType Spielplatz_RightCurlyBracketKeyword_5_ELEMENT_TYPE = associate(SpielplatzFactory.createSpielplatz_RightCurlyBracketKeyword_5ElementType());

	private static class PersonFactory {
		public static IGrammarAwareElementType createPersonElementType() {
			return new IGrammarAwareElementType("Person_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPersonRule());
		}
		public static IGrammarAwareElementType createPerson_AlternativesElementType() {
			return new IGrammarAwareElementType("Person_Alternatives_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPersonAccess().getAlternatives());
		}
		public static IGrammarAwareElementType createPerson_KindParserRuleCall_0ElementType() {
			return new IGrammarAwareElementType("Person_KindParserRuleCall_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPersonAccess().getKindParserRuleCall_0());
		}
		public static IGrammarAwareElementType createPerson_ErwachsenerParserRuleCall_1ElementType() {
			return new IGrammarAwareElementType("Person_ErwachsenerParserRuleCall_1_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getPersonAccess().getErwachsenerParserRuleCall_1());
		}
	}

	public static final IGrammarAwareElementType Person_ELEMENT_TYPE = associate(PersonFactory.createPersonElementType());

	public static final IGrammarAwareElementType Person_Alternatives_ELEMENT_TYPE = associate(PersonFactory.createPerson_AlternativesElementType());

	public static final IGrammarAwareElementType Person_KindParserRuleCall_0_ELEMENT_TYPE = associate(PersonFactory.createPerson_KindParserRuleCall_0ElementType());

	public static final IGrammarAwareElementType Person_ErwachsenerParserRuleCall_1_ELEMENT_TYPE = associate(PersonFactory.createPerson_ErwachsenerParserRuleCall_1ElementType());

	private static class KindFactory {
		public static IGrammarAwareElementType createKindElementType() {
			return new IGrammarAwareElementType("Kind_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKindRule());
		}
		public static IGrammarAwareElementType createKind_GroupElementType() {
			return new IGrammarAwareElementType("Kind_Group_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKindAccess().getGroup());
		}
		public static IGrammarAwareElementType createKind_KindKeyword_0ElementType() {
			return new IGrammarAwareElementType("Kind_KindKeyword_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKindAccess().getKindKeyword_0());
		}
		public static IGrammarAwareElementType createKind_LeftParenthesisKeyword_1ElementType() {
			return new IGrammarAwareElementType("Kind_LeftParenthesisKeyword_1_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKindAccess().getLeftParenthesisKeyword_1());
		}
		public static IGrammarAwareElementType createKind_NameAssignment_2ElementType() {
			return new IGrammarAwareElementType("Kind_NameAssignment_2_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKindAccess().getNameAssignment_2());
		}
		public static IGrammarAwareElementType createKind_NameIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Kind_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKindAccess().getNameIDTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createKind_AgeAssignment_3ElementType() {
			return new IGrammarAwareElementType("Kind_AgeAssignment_3_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKindAccess().getAgeAssignment_3());
		}
		public static IGrammarAwareElementType createKind_AgeINTTerminalRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("Kind_AgeINTTerminalRuleCall_3_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKindAccess().getAgeINTTerminalRuleCall_3_0());
		}
		public static IGrammarAwareElementType createKind_RightParenthesisKeyword_4ElementType() {
			return new IGrammarAwareElementType("Kind_RightParenthesisKeyword_4_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getKindAccess().getRightParenthesisKeyword_4());
		}
	}

	public static final IGrammarAwareElementType Kind_ELEMENT_TYPE = associate(KindFactory.createKindElementType());

	public static final IGrammarAwareElementType Kind_Group_ELEMENT_TYPE = associate(KindFactory.createKind_GroupElementType());

	public static final IGrammarAwareElementType Kind_KindKeyword_0_ELEMENT_TYPE = associate(KindFactory.createKind_KindKeyword_0ElementType());

	public static final IGrammarAwareElementType Kind_LeftParenthesisKeyword_1_ELEMENT_TYPE = associate(KindFactory.createKind_LeftParenthesisKeyword_1ElementType());

	public static final IGrammarAwareElementType Kind_NameAssignment_2_ELEMENT_TYPE = associate(KindFactory.createKind_NameAssignment_2ElementType());

	public static final IGrammarAwareElementType Kind_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(KindFactory.createKind_NameIDTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType Kind_AgeAssignment_3_ELEMENT_TYPE = associate(KindFactory.createKind_AgeAssignment_3ElementType());

	public static final IGrammarAwareElementType Kind_AgeINTTerminalRuleCall_3_0_ELEMENT_TYPE = associate(KindFactory.createKind_AgeINTTerminalRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType Kind_RightParenthesisKeyword_4_ELEMENT_TYPE = associate(KindFactory.createKind_RightParenthesisKeyword_4ElementType());

	private static class ErwachsenerFactory {
		public static IGrammarAwareElementType createErwachsenerElementType() {
			return new IGrammarAwareElementType("Erwachsener_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getErwachsenerRule());
		}
		public static IGrammarAwareElementType createErwachsener_GroupElementType() {
			return new IGrammarAwareElementType("Erwachsener_Group_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getErwachsenerAccess().getGroup());
		}
		public static IGrammarAwareElementType createErwachsener_ErwachsenerKeyword_0ElementType() {
			return new IGrammarAwareElementType("Erwachsener_ErwachsenerKeyword_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getErwachsenerAccess().getErwachsenerKeyword_0());
		}
		public static IGrammarAwareElementType createErwachsener_LeftParenthesisKeyword_1ElementType() {
			return new IGrammarAwareElementType("Erwachsener_LeftParenthesisKeyword_1_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getErwachsenerAccess().getLeftParenthesisKeyword_1());
		}
		public static IGrammarAwareElementType createErwachsener_NameAssignment_2ElementType() {
			return new IGrammarAwareElementType("Erwachsener_NameAssignment_2_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getErwachsenerAccess().getNameAssignment_2());
		}
		public static IGrammarAwareElementType createErwachsener_NameIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Erwachsener_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getErwachsenerAccess().getNameIDTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createErwachsener_AgeAssignment_3ElementType() {
			return new IGrammarAwareElementType("Erwachsener_AgeAssignment_3_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getErwachsenerAccess().getAgeAssignment_3());
		}
		public static IGrammarAwareElementType createErwachsener_AgeINTTerminalRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("Erwachsener_AgeINTTerminalRuleCall_3_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getErwachsenerAccess().getAgeINTTerminalRuleCall_3_0());
		}
		public static IGrammarAwareElementType createErwachsener_RightParenthesisKeyword_4ElementType() {
			return new IGrammarAwareElementType("Erwachsener_RightParenthesisKeyword_4_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getErwachsenerAccess().getRightParenthesisKeyword_4());
		}
	}

	public static final IGrammarAwareElementType Erwachsener_ELEMENT_TYPE = associate(ErwachsenerFactory.createErwachsenerElementType());

	public static final IGrammarAwareElementType Erwachsener_Group_ELEMENT_TYPE = associate(ErwachsenerFactory.createErwachsener_GroupElementType());

	public static final IGrammarAwareElementType Erwachsener_ErwachsenerKeyword_0_ELEMENT_TYPE = associate(ErwachsenerFactory.createErwachsener_ErwachsenerKeyword_0ElementType());

	public static final IGrammarAwareElementType Erwachsener_LeftParenthesisKeyword_1_ELEMENT_TYPE = associate(ErwachsenerFactory.createErwachsener_LeftParenthesisKeyword_1ElementType());

	public static final IGrammarAwareElementType Erwachsener_NameAssignment_2_ELEMENT_TYPE = associate(ErwachsenerFactory.createErwachsener_NameAssignment_2ElementType());

	public static final IGrammarAwareElementType Erwachsener_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(ErwachsenerFactory.createErwachsener_NameIDTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType Erwachsener_AgeAssignment_3_ELEMENT_TYPE = associate(ErwachsenerFactory.createErwachsener_AgeAssignment_3ElementType());

	public static final IGrammarAwareElementType Erwachsener_AgeINTTerminalRuleCall_3_0_ELEMENT_TYPE = associate(ErwachsenerFactory.createErwachsener_AgeINTTerminalRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType Erwachsener_RightParenthesisKeyword_4_ELEMENT_TYPE = associate(ErwachsenerFactory.createErwachsener_RightParenthesisKeyword_4ElementType());

	private static class SpielzeugFactory {
		public static IGrammarAwareElementType createSpielzeugElementType() {
			return new IGrammarAwareElementType("Spielzeug_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielzeugRule());
		}
		public static IGrammarAwareElementType createSpielzeug_GroupElementType() {
			return new IGrammarAwareElementType("Spielzeug_Group_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielzeugAccess().getGroup());
		}
		public static IGrammarAwareElementType createSpielzeug_SpielzeugKeyword_0ElementType() {
			return new IGrammarAwareElementType("Spielzeug_SpielzeugKeyword_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielzeugAccess().getSpielzeugKeyword_0());
		}
		public static IGrammarAwareElementType createSpielzeug_LeftParenthesisKeyword_1ElementType() {
			return new IGrammarAwareElementType("Spielzeug_LeftParenthesisKeyword_1_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielzeugAccess().getLeftParenthesisKeyword_1());
		}
		public static IGrammarAwareElementType createSpielzeug_NameAssignment_2ElementType() {
			return new IGrammarAwareElementType("Spielzeug_NameAssignment_2_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielzeugAccess().getNameAssignment_2());
		}
		public static IGrammarAwareElementType createSpielzeug_NameIDTerminalRuleCall_2_0ElementType() {
			return new IGrammarAwareElementType("Spielzeug_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielzeugAccess().getNameIDTerminalRuleCall_2_0());
		}
		public static IGrammarAwareElementType createSpielzeug_FarbeAssignment_3ElementType() {
			return new IGrammarAwareElementType("Spielzeug_FarbeAssignment_3_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielzeugAccess().getFarbeAssignment_3());
		}
		public static IGrammarAwareElementType createSpielzeug_FarbeFarbeParserRuleCall_3_0ElementType() {
			return new IGrammarAwareElementType("Spielzeug_FarbeFarbeParserRuleCall_3_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielzeugAccess().getFarbeFarbeParserRuleCall_3_0());
		}
		public static IGrammarAwareElementType createSpielzeug_RightParenthesisKeyword_4ElementType() {
			return new IGrammarAwareElementType("Spielzeug_RightParenthesisKeyword_4_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getSpielzeugAccess().getRightParenthesisKeyword_4());
		}
	}

	public static final IGrammarAwareElementType Spielzeug_ELEMENT_TYPE = associate(SpielzeugFactory.createSpielzeugElementType());

	public static final IGrammarAwareElementType Spielzeug_Group_ELEMENT_TYPE = associate(SpielzeugFactory.createSpielzeug_GroupElementType());

	public static final IGrammarAwareElementType Spielzeug_SpielzeugKeyword_0_ELEMENT_TYPE = associate(SpielzeugFactory.createSpielzeug_SpielzeugKeyword_0ElementType());

	public static final IGrammarAwareElementType Spielzeug_LeftParenthesisKeyword_1_ELEMENT_TYPE = associate(SpielzeugFactory.createSpielzeug_LeftParenthesisKeyword_1ElementType());

	public static final IGrammarAwareElementType Spielzeug_NameAssignment_2_ELEMENT_TYPE = associate(SpielzeugFactory.createSpielzeug_NameAssignment_2ElementType());

	public static final IGrammarAwareElementType Spielzeug_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE = associate(SpielzeugFactory.createSpielzeug_NameIDTerminalRuleCall_2_0ElementType());

	public static final IGrammarAwareElementType Spielzeug_FarbeAssignment_3_ELEMENT_TYPE = associate(SpielzeugFactory.createSpielzeug_FarbeAssignment_3ElementType());

	public static final IGrammarAwareElementType Spielzeug_FarbeFarbeParserRuleCall_3_0_ELEMENT_TYPE = associate(SpielzeugFactory.createSpielzeug_FarbeFarbeParserRuleCall_3_0ElementType());

	public static final IGrammarAwareElementType Spielzeug_RightParenthesisKeyword_4_ELEMENT_TYPE = associate(SpielzeugFactory.createSpielzeug_RightParenthesisKeyword_4ElementType());

	private static class FarbeFactory {
		public static IGrammarAwareElementType createFarbeElementType() {
			return new IGrammarAwareElementType("Farbe_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFarbeRule());
		}
		public static IGrammarAwareElementType createFarbe_WertAssignmentElementType() {
			return new IGrammarAwareElementType("Farbe_WertAssignment_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFarbeAccess().getWertAssignment());
		}
		public static IGrammarAwareElementType createFarbe_WertAlternatives_0ElementType() {
			return new IGrammarAwareElementType("Farbe_WertAlternatives_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFarbeAccess().getWertAlternatives_0());
		}
		public static IGrammarAwareElementType createFarbe_WertROTKeyword_0_0ElementType() {
			return new IGrammarAwareElementType("Farbe_WertROTKeyword_0_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFarbeAccess().getWertROTKeyword_0_0());
		}
		public static IGrammarAwareElementType createFarbe_WertBLAUKeyword_0_1ElementType() {
			return new IGrammarAwareElementType("Farbe_WertBLAUKeyword_0_1_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFarbeAccess().getWertBLAUKeyword_0_1());
		}
		public static IGrammarAwareElementType createFarbe_WertGELBKeyword_0_2ElementType() {
			return new IGrammarAwareElementType("Farbe_WertGELBKeyword_0_2_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFarbeAccess().getWertGELBKeyword_0_2());
		}
		public static IGrammarAwareElementType createFarbe_WertGRÜNKeyword_0_3ElementType() {
			return new IGrammarAwareElementType("Farbe_WertGRÜNKeyword_0_3_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFarbeAccess().getWertGRÜNKeyword_0_3());
		}
	}

	public static final IGrammarAwareElementType Farbe_ELEMENT_TYPE = associate(FarbeFactory.createFarbeElementType());

	public static final IGrammarAwareElementType Farbe_WertAssignment_ELEMENT_TYPE = associate(FarbeFactory.createFarbe_WertAssignmentElementType());

	public static final IGrammarAwareElementType Farbe_WertAlternatives_0_ELEMENT_TYPE = associate(FarbeFactory.createFarbe_WertAlternatives_0ElementType());

	public static final IGrammarAwareElementType Farbe_WertROTKeyword_0_0_ELEMENT_TYPE = associate(FarbeFactory.createFarbe_WertROTKeyword_0_0ElementType());

	public static final IGrammarAwareElementType Farbe_WertBLAUKeyword_0_1_ELEMENT_TYPE = associate(FarbeFactory.createFarbe_WertBLAUKeyword_0_1ElementType());

	public static final IGrammarAwareElementType Farbe_WertGELBKeyword_0_2_ELEMENT_TYPE = associate(FarbeFactory.createFarbe_WertGELBKeyword_0_2ElementType());

	public static final IGrammarAwareElementType Farbe_WertGRÜNKeyword_0_3_ELEMENT_TYPE = associate(FarbeFactory.createFarbe_WertGRÜNKeyword_0_3ElementType());

	private static class FamilieFactory {
		public static IGrammarAwareElementType createFamilieElementType() {
			return new IGrammarAwareElementType("Familie_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFamilieRule());
		}
		public static IGrammarAwareElementType createFamilie_GroupElementType() {
			return new IGrammarAwareElementType("Familie_Group_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFamilieAccess().getGroup());
		}
		public static IGrammarAwareElementType createFamilie_FamilieKeyword_0ElementType() {
			return new IGrammarAwareElementType("Familie_FamilieKeyword_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFamilieAccess().getFamilieKeyword_0());
		}
		public static IGrammarAwareElementType createFamilie_LeftParenthesisKeyword_1ElementType() {
			return new IGrammarAwareElementType("Familie_LeftParenthesisKeyword_1_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFamilieAccess().getLeftParenthesisKeyword_1());
		}
		public static IGrammarAwareElementType createFamilie_NameAssignment_2ElementType() {
			return new IGrammarAwareElementType("Familie_NameAssignment_2_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFamilieAccess().getNameAssignment_2());
		}
		public static IGrammarAwareElementType createFamilie_NameAlternatives_2_0ElementType() {
			return new IGrammarAwareElementType("Familie_NameAlternatives_2_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFamilieAccess().getNameAlternatives_2_0());
		}
		public static IGrammarAwareElementType createFamilie_NameKeywordKeyword_2_0_0ElementType() {
			return new IGrammarAwareElementType("Familie_NameKeywordKeyword_2_0_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFamilieAccess().getNameKeywordKeyword_2_0_0());
		}
		public static IGrammarAwareElementType createFamilie_NameSTRINGTerminalRuleCall_2_0_1ElementType() {
			return new IGrammarAwareElementType("Familie_NameSTRINGTerminalRuleCall_2_0_1_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFamilieAccess().getNameSTRINGTerminalRuleCall_2_0_1());
		}
		public static IGrammarAwareElementType createFamilie_NameIDTerminalRuleCall_2_0_2ElementType() {
			return new IGrammarAwareElementType("Familie_NameIDTerminalRuleCall_2_0_2_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFamilieAccess().getNameIDTerminalRuleCall_2_0_2());
		}
		public static IGrammarAwareElementType createFamilie_MutterAssignment_3ElementType() {
			return new IGrammarAwareElementType("Familie_MutterAssignment_3_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFamilieAccess().getMutterAssignment_3());
		}
		public static IGrammarAwareElementType createFamilie_MutterErwachsenerCrossReference_3_0ElementType() {
			return new IGrammarAwareElementType("Familie_MutterErwachsenerCrossReference_3_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFamilieAccess().getMutterErwachsenerCrossReference_3_0());
		}
		public static IGrammarAwareElementType createFamilie_MutterErwachsenerIDTerminalRuleCall_3_0_1ElementType() {
			return new IGrammarAwareElementType("Familie_MutterErwachsenerIDTerminalRuleCall_3_0_1_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFamilieAccess().getMutterErwachsenerIDTerminalRuleCall_3_0_1());
		}
		public static IGrammarAwareElementType createFamilie_VaterAssignment_4ElementType() {
			return new IGrammarAwareElementType("Familie_VaterAssignment_4_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFamilieAccess().getVaterAssignment_4());
		}
		public static IGrammarAwareElementType createFamilie_VaterErwachsenerCrossReference_4_0ElementType() {
			return new IGrammarAwareElementType("Familie_VaterErwachsenerCrossReference_4_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFamilieAccess().getVaterErwachsenerCrossReference_4_0());
		}
		public static IGrammarAwareElementType createFamilie_VaterErwachsenerIDTerminalRuleCall_4_0_1ElementType() {
			return new IGrammarAwareElementType("Familie_VaterErwachsenerIDTerminalRuleCall_4_0_1_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFamilieAccess().getVaterErwachsenerIDTerminalRuleCall_4_0_1());
		}
		public static IGrammarAwareElementType createFamilie_KinderAssignment_5ElementType() {
			return new IGrammarAwareElementType("Familie_KinderAssignment_5_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFamilieAccess().getKinderAssignment_5());
		}
		public static IGrammarAwareElementType createFamilie_KinderKindCrossReference_5_0ElementType() {
			return new IGrammarAwareElementType("Familie_KinderKindCrossReference_5_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFamilieAccess().getKinderKindCrossReference_5_0());
		}
		public static IGrammarAwareElementType createFamilie_KinderKindIDTerminalRuleCall_5_0_1ElementType() {
			return new IGrammarAwareElementType("Familie_KinderKindIDTerminalRuleCall_5_0_1_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFamilieAccess().getKinderKindIDTerminalRuleCall_5_0_1());
		}
		public static IGrammarAwareElementType createFamilie_Group_6ElementType() {
			return new IGrammarAwareElementType("Familie_Group_6_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFamilieAccess().getGroup_6());
		}
		public static IGrammarAwareElementType createFamilie_CommaKeyword_6_0ElementType() {
			return new IGrammarAwareElementType("Familie_CommaKeyword_6_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFamilieAccess().getCommaKeyword_6_0());
		}
		public static IGrammarAwareElementType createFamilie_KinderAssignment_6_1ElementType() {
			return new IGrammarAwareElementType("Familie_KinderAssignment_6_1_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFamilieAccess().getKinderAssignment_6_1());
		}
		public static IGrammarAwareElementType createFamilie_KinderKindCrossReference_6_1_0ElementType() {
			return new IGrammarAwareElementType("Familie_KinderKindCrossReference_6_1_0_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFamilieAccess().getKinderKindCrossReference_6_1_0());
		}
		public static IGrammarAwareElementType createFamilie_KinderKindIDTerminalRuleCall_6_1_0_1ElementType() {
			return new IGrammarAwareElementType("Familie_KinderKindIDTerminalRuleCall_6_1_0_1_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFamilieAccess().getKinderKindIDTerminalRuleCall_6_1_0_1());
		}
		public static IGrammarAwareElementType createFamilie_RightParenthesisKeyword_7ElementType() {
			return new IGrammarAwareElementType("Familie_RightParenthesisKeyword_7_ELEMENT_TYPE", ReferenceGrammarTestLanguageLanguage.INSTANCE, GRAMMAR_ACCESS.getFamilieAccess().getRightParenthesisKeyword_7());
		}
	}

	public static final IGrammarAwareElementType Familie_ELEMENT_TYPE = associate(FamilieFactory.createFamilieElementType());

	public static final IGrammarAwareElementType Familie_Group_ELEMENT_TYPE = associate(FamilieFactory.createFamilie_GroupElementType());

	public static final IGrammarAwareElementType Familie_FamilieKeyword_0_ELEMENT_TYPE = associate(FamilieFactory.createFamilie_FamilieKeyword_0ElementType());

	public static final IGrammarAwareElementType Familie_LeftParenthesisKeyword_1_ELEMENT_TYPE = associate(FamilieFactory.createFamilie_LeftParenthesisKeyword_1ElementType());

	public static final IGrammarAwareElementType Familie_NameAssignment_2_ELEMENT_TYPE = associate(FamilieFactory.createFamilie_NameAssignment_2ElementType());

	public static final IGrammarAwareElementType Familie_NameAlternatives_2_0_ELEMENT_TYPE = associate(FamilieFactory.createFamilie_NameAlternatives_2_0ElementType());

	public static final IGrammarAwareElementType Familie_NameKeywordKeyword_2_0_0_ELEMENT_TYPE = associate(FamilieFactory.createFamilie_NameKeywordKeyword_2_0_0ElementType());

	public static final IGrammarAwareElementType Familie_NameSTRINGTerminalRuleCall_2_0_1_ELEMENT_TYPE = associate(FamilieFactory.createFamilie_NameSTRINGTerminalRuleCall_2_0_1ElementType());

	public static final IGrammarAwareElementType Familie_NameIDTerminalRuleCall_2_0_2_ELEMENT_TYPE = associate(FamilieFactory.createFamilie_NameIDTerminalRuleCall_2_0_2ElementType());

	public static final IGrammarAwareElementType Familie_MutterAssignment_3_ELEMENT_TYPE = associate(FamilieFactory.createFamilie_MutterAssignment_3ElementType());

	public static final IGrammarAwareElementType Familie_MutterErwachsenerCrossReference_3_0_ELEMENT_TYPE = associate(FamilieFactory.createFamilie_MutterErwachsenerCrossReference_3_0ElementType());

	public static final IGrammarAwareElementType Familie_MutterErwachsenerIDTerminalRuleCall_3_0_1_ELEMENT_TYPE = associate(FamilieFactory.createFamilie_MutterErwachsenerIDTerminalRuleCall_3_0_1ElementType());

	public static final IGrammarAwareElementType Familie_VaterAssignment_4_ELEMENT_TYPE = associate(FamilieFactory.createFamilie_VaterAssignment_4ElementType());

	public static final IGrammarAwareElementType Familie_VaterErwachsenerCrossReference_4_0_ELEMENT_TYPE = associate(FamilieFactory.createFamilie_VaterErwachsenerCrossReference_4_0ElementType());

	public static final IGrammarAwareElementType Familie_VaterErwachsenerIDTerminalRuleCall_4_0_1_ELEMENT_TYPE = associate(FamilieFactory.createFamilie_VaterErwachsenerIDTerminalRuleCall_4_0_1ElementType());

	public static final IGrammarAwareElementType Familie_KinderAssignment_5_ELEMENT_TYPE = associate(FamilieFactory.createFamilie_KinderAssignment_5ElementType());

	public static final IGrammarAwareElementType Familie_KinderKindCrossReference_5_0_ELEMENT_TYPE = associate(FamilieFactory.createFamilie_KinderKindCrossReference_5_0ElementType());

	public static final IGrammarAwareElementType Familie_KinderKindIDTerminalRuleCall_5_0_1_ELEMENT_TYPE = associate(FamilieFactory.createFamilie_KinderKindIDTerminalRuleCall_5_0_1ElementType());

	public static final IGrammarAwareElementType Familie_Group_6_ELEMENT_TYPE = associate(FamilieFactory.createFamilie_Group_6ElementType());

	public static final IGrammarAwareElementType Familie_CommaKeyword_6_0_ELEMENT_TYPE = associate(FamilieFactory.createFamilie_CommaKeyword_6_0ElementType());

	public static final IGrammarAwareElementType Familie_KinderAssignment_6_1_ELEMENT_TYPE = associate(FamilieFactory.createFamilie_KinderAssignment_6_1ElementType());

	public static final IGrammarAwareElementType Familie_KinderKindCrossReference_6_1_0_ELEMENT_TYPE = associate(FamilieFactory.createFamilie_KinderKindCrossReference_6_1_0ElementType());

	public static final IGrammarAwareElementType Familie_KinderKindIDTerminalRuleCall_6_1_0_1_ELEMENT_TYPE = associate(FamilieFactory.createFamilie_KinderKindIDTerminalRuleCall_6_1_0_1ElementType());

	public static final IGrammarAwareElementType Familie_RightParenthesisKeyword_7_ELEMENT_TYPE = associate(FamilieFactory.createFamilie_RightParenthesisKeyword_7ElementType());

	@Override
	public IFileElementType getFileType() {
		return FILE_TYPE;
	}

	@Override
	public IGrammarAwareElementType findElementType(EObject grammarElement) {
		return GRAMMAR_ELEMENT_TYPE.get(grammarElement);
	}

	public IGrammarAwareElementType getSpielplatzElementType() {
		return Spielplatz_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielplatz_GroupElementType() {
		return Spielplatz_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielplatz_SpielplatzKeyword_0ElementType() {
		return Spielplatz_SpielplatzKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielplatz_GroesseAssignment_1ElementType() {
		return Spielplatz_GroesseAssignment_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielplatz_GroesseINTTerminalRuleCall_1_0ElementType() {
		return Spielplatz_GroesseINTTerminalRuleCall_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielplatz_BeschreibungAssignment_2ElementType() {
		return Spielplatz_BeschreibungAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielplatz_BeschreibungSTRINGTerminalRuleCall_2_0ElementType() {
		return Spielplatz_BeschreibungSTRINGTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielplatz_LeftCurlyBracketKeyword_3ElementType() {
		return Spielplatz_LeftCurlyBracketKeyword_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielplatz_Alternatives_4ElementType() {
		return Spielplatz_Alternatives_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielplatz_KinderAssignment_4_0ElementType() {
		return Spielplatz_KinderAssignment_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielplatz_KinderKindParserRuleCall_4_0_0ElementType() {
		return Spielplatz_KinderKindParserRuleCall_4_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielplatz_ErzieherAssignment_4_1ElementType() {
		return Spielplatz_ErzieherAssignment_4_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielplatz_ErzieherErwachsenerParserRuleCall_4_1_0ElementType() {
		return Spielplatz_ErzieherErwachsenerParserRuleCall_4_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielplatz_SpielzeugeAssignment_4_2ElementType() {
		return Spielplatz_SpielzeugeAssignment_4_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielplatz_SpielzeugeSpielzeugParserRuleCall_4_2_0ElementType() {
		return Spielplatz_SpielzeugeSpielzeugParserRuleCall_4_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielplatz_FamilieAssignment_4_3ElementType() {
		return Spielplatz_FamilieAssignment_4_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielplatz_FamilieFamilieParserRuleCall_4_3_0ElementType() {
		return Spielplatz_FamilieFamilieParserRuleCall_4_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielplatz_RightCurlyBracketKeyword_5ElementType() {
		return Spielplatz_RightCurlyBracketKeyword_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPersonElementType() {
		return Person_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPerson_AlternativesElementType() {
		return Person_Alternatives_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPerson_KindParserRuleCall_0ElementType() {
		return Person_KindParserRuleCall_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getPerson_ErwachsenerParserRuleCall_1ElementType() {
		return Person_ErwachsenerParserRuleCall_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKindElementType() {
		return Kind_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKind_GroupElementType() {
		return Kind_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKind_KindKeyword_0ElementType() {
		return Kind_KindKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKind_LeftParenthesisKeyword_1ElementType() {
		return Kind_LeftParenthesisKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKind_NameAssignment_2ElementType() {
		return Kind_NameAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKind_NameIDTerminalRuleCall_2_0ElementType() {
		return Kind_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKind_AgeAssignment_3ElementType() {
		return Kind_AgeAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKind_AgeINTTerminalRuleCall_3_0ElementType() {
		return Kind_AgeINTTerminalRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getKind_RightParenthesisKeyword_4ElementType() {
		return Kind_RightParenthesisKeyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getErwachsenerElementType() {
		return Erwachsener_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getErwachsener_GroupElementType() {
		return Erwachsener_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getErwachsener_ErwachsenerKeyword_0ElementType() {
		return Erwachsener_ErwachsenerKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getErwachsener_LeftParenthesisKeyword_1ElementType() {
		return Erwachsener_LeftParenthesisKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getErwachsener_NameAssignment_2ElementType() {
		return Erwachsener_NameAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getErwachsener_NameIDTerminalRuleCall_2_0ElementType() {
		return Erwachsener_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getErwachsener_AgeAssignment_3ElementType() {
		return Erwachsener_AgeAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getErwachsener_AgeINTTerminalRuleCall_3_0ElementType() {
		return Erwachsener_AgeINTTerminalRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getErwachsener_RightParenthesisKeyword_4ElementType() {
		return Erwachsener_RightParenthesisKeyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielzeugElementType() {
		return Spielzeug_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielzeug_GroupElementType() {
		return Spielzeug_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielzeug_SpielzeugKeyword_0ElementType() {
		return Spielzeug_SpielzeugKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielzeug_LeftParenthesisKeyword_1ElementType() {
		return Spielzeug_LeftParenthesisKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielzeug_NameAssignment_2ElementType() {
		return Spielzeug_NameAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielzeug_NameIDTerminalRuleCall_2_0ElementType() {
		return Spielzeug_NameIDTerminalRuleCall_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielzeug_FarbeAssignment_3ElementType() {
		return Spielzeug_FarbeAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielzeug_FarbeFarbeParserRuleCall_3_0ElementType() {
		return Spielzeug_FarbeFarbeParserRuleCall_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getSpielzeug_RightParenthesisKeyword_4ElementType() {
		return Spielzeug_RightParenthesisKeyword_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFarbeElementType() {
		return Farbe_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFarbe_WertAssignmentElementType() {
		return Farbe_WertAssignment_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFarbe_WertAlternatives_0ElementType() {
		return Farbe_WertAlternatives_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFarbe_WertROTKeyword_0_0ElementType() {
		return Farbe_WertROTKeyword_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFarbe_WertBLAUKeyword_0_1ElementType() {
		return Farbe_WertBLAUKeyword_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFarbe_WertGELBKeyword_0_2ElementType() {
		return Farbe_WertGELBKeyword_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFarbe_WertGRÜNKeyword_0_3ElementType() {
		return Farbe_WertGRÜNKeyword_0_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFamilieElementType() {
		return Familie_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFamilie_GroupElementType() {
		return Familie_Group_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFamilie_FamilieKeyword_0ElementType() {
		return Familie_FamilieKeyword_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFamilie_LeftParenthesisKeyword_1ElementType() {
		return Familie_LeftParenthesisKeyword_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFamilie_NameAssignment_2ElementType() {
		return Familie_NameAssignment_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFamilie_NameAlternatives_2_0ElementType() {
		return Familie_NameAlternatives_2_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFamilie_NameKeywordKeyword_2_0_0ElementType() {
		return Familie_NameKeywordKeyword_2_0_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFamilie_NameSTRINGTerminalRuleCall_2_0_1ElementType() {
		return Familie_NameSTRINGTerminalRuleCall_2_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFamilie_NameIDTerminalRuleCall_2_0_2ElementType() {
		return Familie_NameIDTerminalRuleCall_2_0_2_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFamilie_MutterAssignment_3ElementType() {
		return Familie_MutterAssignment_3_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFamilie_MutterErwachsenerCrossReference_3_0ElementType() {
		return Familie_MutterErwachsenerCrossReference_3_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFamilie_MutterErwachsenerIDTerminalRuleCall_3_0_1ElementType() {
		return Familie_MutterErwachsenerIDTerminalRuleCall_3_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFamilie_VaterAssignment_4ElementType() {
		return Familie_VaterAssignment_4_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFamilie_VaterErwachsenerCrossReference_4_0ElementType() {
		return Familie_VaterErwachsenerCrossReference_4_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFamilie_VaterErwachsenerIDTerminalRuleCall_4_0_1ElementType() {
		return Familie_VaterErwachsenerIDTerminalRuleCall_4_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFamilie_KinderAssignment_5ElementType() {
		return Familie_KinderAssignment_5_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFamilie_KinderKindCrossReference_5_0ElementType() {
		return Familie_KinderKindCrossReference_5_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFamilie_KinderKindIDTerminalRuleCall_5_0_1ElementType() {
		return Familie_KinderKindIDTerminalRuleCall_5_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFamilie_Group_6ElementType() {
		return Familie_Group_6_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFamilie_CommaKeyword_6_0ElementType() {
		return Familie_CommaKeyword_6_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFamilie_KinderAssignment_6_1ElementType() {
		return Familie_KinderAssignment_6_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFamilie_KinderKindCrossReference_6_1_0ElementType() {
		return Familie_KinderKindCrossReference_6_1_0_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFamilie_KinderKindIDTerminalRuleCall_6_1_0_1ElementType() {
		return Familie_KinderKindIDTerminalRuleCall_6_1_0_1_ELEMENT_TYPE;
	}

	public IGrammarAwareElementType getFamilie_RightParenthesisKeyword_7ElementType() {
		return Familie_RightParenthesisKeyword_7_ELEMENT_TYPE;
	}

}
