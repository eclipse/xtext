/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.web.example.statemachine.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.web.example.statemachine.ide.contentassist.antlr.internal.InternalStatemachineParser;
import org.eclipse.xtext.web.example.statemachine.services.StatemachineGrammarAccess;

public class StatemachineParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(StatemachineGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, StatemachineGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getSignalAccess().getAlternatives_0(), "rule__Signal__Alternatives_0");
			builder.put(grammarAccess.getStatemachineAccess().getGroup(), "rule__Statemachine__Group__0");
			builder.put(grammarAccess.getSignalAccess().getGroup(), "rule__Signal__Group__0");
			builder.put(grammarAccess.getInputSignalAccess().getGroup(), "rule__InputSignal__Group__0");
			builder.put(grammarAccess.getOutputSignalAccess().getGroup(), "rule__OutputSignal__Group__0");
			builder.put(grammarAccess.getStateAccess().getGroup(), "rule__State__Group__0");
			builder.put(grammarAccess.getTransitionAccess().getGroup(), "rule__Transition__Group__0");
			builder.put(grammarAccess.getConditionAccess().getGroup(), "rule__Condition__Group__0");
			builder.put(grammarAccess.getConditionAccess().getGroup_1(), "rule__Condition__Group_1__0");
			builder.put(grammarAccess.getEventAccess().getGroup(), "rule__Event__Group__0");
			builder.put(grammarAccess.getCommandAccess().getGroup(), "rule__Command__Group__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
			builder.put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
			builder.put(grammarAccess.getStatemachineAccess().getSignalsAssignment_1(), "rule__Statemachine__SignalsAssignment_1");
			builder.put(grammarAccess.getStatemachineAccess().getStatesAssignment_2(), "rule__Statemachine__StatesAssignment_2");
			builder.put(grammarAccess.getSignalAccess().getNameAssignment_2(), "rule__Signal__NameAssignment_2");
			builder.put(grammarAccess.getStateAccess().getNameAssignment_1(), "rule__State__NameAssignment_1");
			builder.put(grammarAccess.getStateAccess().getCommandsAssignment_2(), "rule__State__CommandsAssignment_2");
			builder.put(grammarAccess.getStateAccess().getTransitionsAssignment_3(), "rule__State__TransitionsAssignment_3");
			builder.put(grammarAccess.getStateAccess().getNestedStatesAssignment_4(), "rule__State__NestedStatesAssignment_4");
			builder.put(grammarAccess.getTransitionAccess().getConditionAssignment_1(), "rule__Transition__ConditionAssignment_1");
			builder.put(grammarAccess.getTransitionAccess().getStateAssignment_3(), "rule__Transition__StateAssignment_3");
			builder.put(grammarAccess.getConditionAccess().getEventsAssignment_0(), "rule__Condition__EventsAssignment_0");
			builder.put(grammarAccess.getConditionAccess().getEventsAssignment_1_1(), "rule__Condition__EventsAssignment_1_1");
			builder.put(grammarAccess.getEventAccess().getSignalAssignment_0(), "rule__Event__SignalAssignment_0");
			builder.put(grammarAccess.getEventAccess().getValueAssignment_2(), "rule__Event__ValueAssignment_2");
			builder.put(grammarAccess.getCommandAccess().getSignalAssignment_1(), "rule__Command__SignalAssignment_1");
			builder.put(grammarAccess.getCommandAccess().getNewValueAssignment_3(), "rule__Command__NewValueAssignment_3");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private StatemachineGrammarAccess grammarAccess;

	@Override
	protected InternalStatemachineParser createParser() {
		InternalStatemachineParser result = new InternalStatemachineParser(null);
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

	public StatemachineGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(StatemachineGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
