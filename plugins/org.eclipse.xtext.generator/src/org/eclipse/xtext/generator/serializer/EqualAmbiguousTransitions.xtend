/** 
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.serializer

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.AbstractElement
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GrammarAliasAdapter
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition
import org.eclipse.xtext.util.formallang.Production
import org.eclipse.xtext.util.formallang.ProductionFormatter

/** 
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Accessors @FinalFieldsConstructor class EqualAmbiguousTransitions implements Comparable<EqualAmbiguousTransitions> {
	val String identifyer
	val List<ISynTransition> transitions = newArrayList()
	val AbstractElementAlias elementAlias

	override compareTo(EqualAmbiguousTransitions o) {
		identifyer.compareTo(o.identifyer)
	}

	def String ambiguityInsideTransition(ISynTransition trans) {
		val tokenToString = new GrammarElementTitleSwitch().showAssignments().hideCardinality().setValueForNull("");
		val formatter = new ProductionFormatter<AbstractElementAlias, AbstractElement>() {
			override format(Production<AbstractElementAlias, AbstractElement> adapter,
				AbstractElementAlias grammarElement, boolean needParenthesis) {
				switch (grammarElement) {
					case grammarElement == elementAlias: return "(ambiguity)"
					TokenAlias case grammarElement.token == null: return "" // start or stop
					default: super.format(adapter, grammarElement, needParenthesis)
				}
			}
		}.setTokenToString(tokenToString)
		val adapter = new GrammarAliasAdapter(trans.ambiguousSyntax)
		return formatter.format(adapter, adapter.root, false);
	}

}
