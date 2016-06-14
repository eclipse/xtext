/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.serializer

import com.google.common.base.Throwables
import com.google.inject.Inject
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.serializer.ISerializationContext
import org.eclipse.xtext.serializer.analysis.IContextPDAProvider
import org.eclipse.xtext.serializer.analysis.IContextTypePDAProvider
import org.eclipse.xtext.serializer.analysis.ISemanticSequencerNfaProvider
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider
import org.eclipse.xtext.util.GraphvizDotBuilder
import org.eclipse.xtext.util.formallang.NfaToDot
import org.eclipse.xtext.util.formallang.PdaToDot
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming

class DebugGraphGenerator {

	@Inject Grammar grammar
	@Inject extension XtextGeneratorNaming
	@Inject IContextPDAProvider contextPDAProvider
	@Inject IContextTypePDAProvider contextTypePDAProvider
	@Inject ISyntacticSequencerPDAProvider syntacticSequencerPDAProvider
	@Inject ISemanticSequencerNfaProvider semanticSequencerNFAProvider
	@Inject SyntacticSequencerPDA2ExtendedDot syntacticSequencerPDA2Dot
	@Inject SyntacticSequencerExtensions syntacticSequencerUtil
	@Inject PdaToDot<?, ?> pdaToDot
	@Inject NfaToDot<?> nfaToDot

	def Iterable<Pair<String, String>> generateDebugGraphs() {
		val result = <Pair<String, String>>newArrayList
		for (e : contextPDAProvider.getContextPDAs(grammar).entrySet) {
			result.add(file('context', e.key) -> pdaToDot.drawSafe(e.key, e.value))
		}
		for (e : contextTypePDAProvider.getContextTypePDAs(grammar).entrySet) {
			result.add(file('context_type', e.key) -> pdaToDot.drawSafe(e.key, e.value))
		}
		for (e : syntacticSequencerPDAProvider.getSyntacticSequencerPDAs(grammar).entrySet) {
			result.add(file('syntactic_sequencer', e.key) -> syntacticSequencerPDA2Dot.drawSafe(e.key, e.value))
		}
		for (e : semanticSequencerNFAProvider.getSemanticSequencerNFAs(grammar).entrySet) {
			result.add(file('semantic_sequencer', e.key) -> nfaToDot.drawSafe(e.key, e.value))
		}

		try {
			var i = 0
			val trans2id = newHashMap()
			for (transition : syntacticSequencerUtil.allAmbiguousTransitions) {
				val name = 'ambiguity_' + i
				result.add(directory('syntactic_sequencer') + name + '.dot' -> nfaToDot.draw(transition.ambiguousNfa))
				trans2id.put(transition, name)
				i = i + 1
			}
			val ambiguities = new StringBuffer
			for (group : syntacticSequencerUtil.allAmbiguousTransitionsBySyntax) {
				ambiguities.append('''
					id: «group.identifier»
					    Ambiguous syntax:»:
					        «group.elementAlias.toString.replace('\n', '\n        ')»
					    This ambiguous syntax occurs at:
						«FOR trans : group.transitions»
							«trans2id.get(trans)»:
							    «group.ambiguityInsideTransition(trans).replace('\n', '\n        ')»
						«ENDFOR»
						
					
				''')
			}
			result.add(directory('syntactic_sequencer') + 'ambiguities.txt' -> ambiguities.toString)
		} catch (Exception e) {
			e.printStackTrace
		}
		return result
	}

	private def String drawSafe(GraphvizDotBuilder builder, ISerializationContext context, Object graph) {
		try {
			builder.draw(graph)
		} catch (Exception e) {
			println("Error rendering " + context)
			e.printStackTrace
			return Throwables.getStackTraceAsString(e)
		}
	}

	private def String directory(String name) {
		grammar.runtimeBasePackage.replace('.', '/') + '/serializer/' + GrammarUtil.getSimpleName(grammar).toLowerCase +
			'_' + name + '/'
	}

	private def String file(String name, ISerializationContext contexts) {
		directory(name) + contexts + '.dot';
	}
}
					