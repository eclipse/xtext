/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.serializer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.serializer.analysis.GrammarAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider;
import org.eclipse.xtext.util.formallang.Production;
import org.eclipse.xtext.util.formallang.ProductionFormatter;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class EqualAmbiguousTransitions implements Comparable<EqualAmbiguousTransitions> {
	private final String identifier;

	private final List<ISyntacticSequencerPDAProvider.ISynTransition> transitions = new ArrayList<>();

	private final GrammarAlias.AbstractElementAlias elementAlias;

	public EqualAmbiguousTransitions(String identifier, GrammarAlias.AbstractElementAlias elementAlias) {
		this.identifier = identifier;
		this.elementAlias = elementAlias;
	}

	public String getIdentifier() {
		return identifier;
	}

	public List<ISyntacticSequencerPDAProvider.ISynTransition> getTransitions() {
		return transitions;
	}

	public GrammarAlias.AbstractElementAlias getElementAlias() {
		return elementAlias;
	}

	@Override
	public int compareTo(EqualAmbiguousTransitions o) {
		return identifier.compareTo(o.identifier);
	}

	public String ambiguityInsideTransition(ISyntacticSequencerPDAProvider.ISynTransition trans) {
		try {
			GrammarElementTitleSwitch tokenToString = new GrammarElementTitleSwitch().showAssignments()
					.hideCardinality().setValueForNull("");
			ProductionFormatter<GrammarAlias.AbstractElementAlias, AbstractElement> formatter = new ProductionFormatter<GrammarAlias.AbstractElementAlias, AbstractElement>() {
				@Override
				public String format(Production<GrammarAlias.AbstractElementAlias, AbstractElement> adapter,
						GrammarAlias.AbstractElementAlias grammarElement, boolean needParenthesis) {
					if (Objects.equal(grammarElement, elementAlias)) {
						return "(ambiguity)";
					}
					if (grammarElement instanceof GrammarAlias.TokenAlias) {
						if (isStart((GrammarAlias.TokenAlias) grammarElement)) {
							return "(rule start)";
						}
					}
					if (grammarElement instanceof GrammarAlias.TokenAlias) {
						if (isStop((GrammarAlias.TokenAlias) grammarElement)) {
							return "(rule end)";
						}
					}
					return super.format(adapter, grammarElement, needParenthesis);
				}
			}.setTokenToString(tokenToString).setAutoWrapChars(200).setAutoWrapChildren(20);
			GrammarAlias.GrammarAliasAdapter adapter = new GrammarAlias.GrammarAliasAdapter(trans.getAmbiguousSyntax());
			return formatter.format(adapter, adapter.getRoot(), false);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	private boolean isStart(GrammarAlias.TokenAlias it) {
		return (it.getToken() == null && it.getParent() instanceof GrammarAlias.GroupAlias && Objects.equal(it,
				Iterables.getFirst(((GrammarAlias.GroupAlias) it.getParent()).getChildren(), null)));
	}

	private boolean isStop(GrammarAlias.TokenAlias it) {
		return (it.getToken() == null && it.getParent() instanceof GrammarAlias.GroupAlias
				&& Objects.equal(it, IterableExtensions.<GrammarAlias.AbstractElementAlias>last(
						((GrammarAlias.GroupAlias) it.getParent()).getChildren())));
	}

}
