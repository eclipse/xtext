/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.ide.contentassist.antlr.internal.InternalBug332217TestLanguageParser;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.Bug332217TestLanguageGrammarAccess;

public class Bug332217TestLanguageParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(Bug332217TestLanguageGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, Bug332217TestLanguageGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getPropertyPathPartAccess().getAlternatives(), "rule__PropertyPathPart__Alternatives");
			builder.put(grammarAccess.getExpressionAccess().getAlternatives(), "rule__Expression__Alternatives");
			builder.put(grammarAccess.getScalarExpressionAccess().getAlternatives(), "rule__ScalarExpression__Alternatives");
			builder.put(grammarAccess.getCollectionExpressionAccess().getAlternatives(), "rule__CollectionExpression__Alternatives");
			builder.put(grammarAccess.getStringFunctionAccess().getAlternatives(), "rule__StringFunction__Alternatives");
			builder.put(grammarAccess.getViewContentElementAccess().getAlternatives(), "rule__ViewContentElement__Alternatives");
			builder.put(grammarAccess.getViewActionAccess().getAlternatives(), "rule__ViewAction__Alternatives");
			builder.put(grammarAccess.getTableViewStyleAccess().getAlternatives(), "rule__TableViewStyle__Alternatives");
			builder.put(grammarAccess.getCellTypeAccess().getAlternatives(), "rule__CellType__Alternatives");
			builder.put(grammarAccess.getCellAccessoryAccess().getAlternatives(), "rule__CellAccessory__Alternatives");
			builder.put(grammarAccess.getTypeDescriptionAccess().getGroup(), "rule__TypeDescription__Group__0");
			builder.put(grammarAccess.getParameterAccess().getGroup(), "rule__Parameter__Group__0");
			builder.put(grammarAccess.getObjectReferenceAccess().getGroup(), "rule__ObjectReference__Group__0");
			builder.put(grammarAccess.getNestedObjectReferenceAccess().getGroup(), "rule__NestedObjectReference__Group__0");
			builder.put(grammarAccess.getStringFunctionAccess().getGroup_0(), "rule__StringFunction__Group_0__0");
			builder.put(grammarAccess.getStringFunctionAccess().getGroup_1(), "rule__StringFunction__Group_1__0");
			builder.put(grammarAccess.getStringFunctionAccess().getGroup_2(), "rule__StringFunction__Group_2__0");
			builder.put(grammarAccess.getCollectionLiteralAccess().getGroup(), "rule__CollectionLiteral__Group__0");
			builder.put(grammarAccess.getCollectionLiteralAccess().getGroup_2(), "rule__CollectionLiteral__Group_2__0");
			builder.put(grammarAccess.getCollectionFunctionAccess().getGroup(), "rule__CollectionFunction__Group__0");
			builder.put(grammarAccess.getTableViewAccess().getGroup(), "rule__TableView__Group__0");
			builder.put(grammarAccess.getTableViewAccess().getGroup_2(), "rule__TableView__Group_2__0");
			builder.put(grammarAccess.getTableViewAccess().getGroup_4_0(), "rule__TableView__Group_4_0__0");
			builder.put(grammarAccess.getTableViewAccess().getGroup_4_1(), "rule__TableView__Group_4_1__0");
			builder.put(grammarAccess.getTableViewAccess().getGroup_4_2(), "rule__TableView__Group_4_2__0");
			builder.put(grammarAccess.getSectionAccess().getGroup(), "rule__Section__Group__0");
			builder.put(grammarAccess.getSectionAccess().getGroup_3(), "rule__Section__Group_3__0");
			builder.put(grammarAccess.getCellAccess().getGroup(), "rule__Cell__Group__0");
			builder.put(grammarAccess.getCellAccess().getGroup_4_0(), "rule__Cell__Group_4_0__0");
			builder.put(grammarAccess.getCellAccess().getGroup_4_1(), "rule__Cell__Group_4_1__0");
			builder.put(grammarAccess.getCellAccess().getGroup_4_2(), "rule__Cell__Group_4_2__0");
			builder.put(grammarAccess.getCellAccess().getGroup_4_3(), "rule__Cell__Group_4_3__0");
			builder.put(grammarAccess.getCellAccess().getGroup_4_4(), "rule__Cell__Group_4_4__0");
			builder.put(grammarAccess.getCollectionIteratorAccess().getGroup(), "rule__CollectionIterator__Group__0");
			builder.put(grammarAccess.getSelectorNameAccess().getGroup(), "rule__SelectorName__Group__0");
			builder.put(grammarAccess.getSelectorNameAccess().getGroup_1(), "rule__SelectorName__Group_1__0");
			builder.put(grammarAccess.getSelectorAccess().getGroup(), "rule__Selector__Group__0");
			builder.put(grammarAccess.getModelAccess().getElementsAssignment(), "rule__Model__ElementsAssignment");
			builder.put(grammarAccess.getTypeDescriptionAccess().getTypeAssignment_0(), "rule__TypeDescription__TypeAssignment_0");
			builder.put(grammarAccess.getTypeDescriptionAccess().getManyAssignment_1(), "rule__TypeDescription__ManyAssignment_1");
			builder.put(grammarAccess.getParameterAccess().getDescriptionAssignment_0(), "rule__Parameter__DescriptionAssignment_0");
			builder.put(grammarAccess.getParameterAccess().getNameAssignment_1(), "rule__Parameter__NameAssignment_1");
			builder.put(grammarAccess.getObjectReferenceAccess().getObjectAssignment_0(), "rule__ObjectReference__ObjectAssignment_0");
			builder.put(grammarAccess.getObjectReferenceAccess().getTailAssignment_1(), "rule__ObjectReference__TailAssignment_1");
			builder.put(grammarAccess.getNestedObjectReferenceAccess().getObjectAssignment_1(), "rule__NestedObjectReference__ObjectAssignment_1");
			builder.put(grammarAccess.getNestedObjectReferenceAccess().getTailAssignment_2(), "rule__NestedObjectReference__TailAssignment_2");
			builder.put(grammarAccess.getStringLiteralAccess().getValueAssignment(), "rule__StringLiteral__ValueAssignment");
			builder.put(grammarAccess.getStringFunctionAccess().getValuesAssignment_0_2(), "rule__StringFunction__ValuesAssignment_0_2");
			builder.put(grammarAccess.getStringFunctionAccess().getValueAssignment_1_2(), "rule__StringFunction__ValueAssignment_1_2");
			builder.put(grammarAccess.getStringFunctionAccess().getMatchAssignment_1_4(), "rule__StringFunction__MatchAssignment_1_4");
			builder.put(grammarAccess.getStringFunctionAccess().getReplacementAssignment_1_6(), "rule__StringFunction__ReplacementAssignment_1_6");
			builder.put(grammarAccess.getStringFunctionAccess().getValueAssignment_2_2(), "rule__StringFunction__ValueAssignment_2_2");
			builder.put(grammarAccess.getCollectionLiteralAccess().getItemsAssignment_1(), "rule__CollectionLiteral__ItemsAssignment_1");
			builder.put(grammarAccess.getCollectionLiteralAccess().getItemsAssignment_2_1(), "rule__CollectionLiteral__ItemsAssignment_2_1");
			builder.put(grammarAccess.getCollectionFunctionAccess().getValueAssignment_2(), "rule__CollectionFunction__ValueAssignment_2");
			builder.put(grammarAccess.getCollectionFunctionAccess().getDelimiterAssignment_4(), "rule__CollectionFunction__DelimiterAssignment_4");
			builder.put(grammarAccess.getTableViewAccess().getNameAssignment_1(), "rule__TableView__NameAssignment_1");
			builder.put(grammarAccess.getTableViewAccess().getContentAssignment_2_1(), "rule__TableView__ContentAssignment_2_1");
			builder.put(grammarAccess.getTableViewAccess().getTitleAssignment_4_0_1(), "rule__TableView__TitleAssignment_4_0_1");
			builder.put(grammarAccess.getTableViewAccess().getTitleImageAssignment_4_1_1(), "rule__TableView__TitleImageAssignment_4_1_1");
			builder.put(grammarAccess.getTableViewAccess().getStyleAssignment_4_2_1(), "rule__TableView__StyleAssignment_4_2_1");
			builder.put(grammarAccess.getTableViewAccess().getSectionsAssignment_5(), "rule__TableView__SectionsAssignment_5");
			builder.put(grammarAccess.getSectionAccess().getIteratorAssignment_1(), "rule__Section__IteratorAssignment_1");
			builder.put(grammarAccess.getSectionAccess().getTitleAssignment_3_1(), "rule__Section__TitleAssignment_3_1");
			builder.put(grammarAccess.getSectionAccess().getCellsAssignment_4(), "rule__Section__CellsAssignment_4");
			builder.put(grammarAccess.getCellAccess().getTypeAssignment_1(), "rule__Cell__TypeAssignment_1");
			builder.put(grammarAccess.getCellAccess().getIteratorAssignment_2(), "rule__Cell__IteratorAssignment_2");
			builder.put(grammarAccess.getCellAccess().getTextAssignment_4_0_1(), "rule__Cell__TextAssignment_4_0_1");
			builder.put(grammarAccess.getCellAccess().getDetailsAssignment_4_1_1(), "rule__Cell__DetailsAssignment_4_1_1");
			builder.put(grammarAccess.getCellAccess().getImageAssignment_4_2_1(), "rule__Cell__ImageAssignment_4_2_1");
			builder.put(grammarAccess.getCellAccess().getActionAssignment_4_3_1(), "rule__Cell__ActionAssignment_4_3_1");
			builder.put(grammarAccess.getCellAccess().getAccessoryAssignment_4_4_1(), "rule__Cell__AccessoryAssignment_4_4_1");
			builder.put(grammarAccess.getCollectionIteratorAccess().getNameAssignment_1(), "rule__CollectionIterator__NameAssignment_1");
			builder.put(grammarAccess.getCollectionIteratorAccess().getCollectionAssignment_3(), "rule__CollectionIterator__CollectionAssignment_3");
			builder.put(grammarAccess.getSelectorAccess().getNameAssignment_2(), "rule__Selector__NameAssignment_2");
			builder.put(grammarAccess.getExternalOpenAccess().getUrlAssignment(), "rule__ExternalOpen__UrlAssignment");
			builder.put(grammarAccess.getTableViewAccess().getUnorderedGroup_4(), "rule__TableView__UnorderedGroup_4");
			builder.put(grammarAccess.getCellAccess().getUnorderedGroup_4(), "rule__Cell__UnorderedGroup_4");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private Bug332217TestLanguageGrammarAccess grammarAccess;

	@Override
	protected InternalBug332217TestLanguageParser createParser() {
		InternalBug332217TestLanguageParser result = new InternalBug332217TestLanguageParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public Bug332217TestLanguageGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(Bug332217TestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
