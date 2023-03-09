/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.serializer

import com.google.common.base.Throwables
import com.google.inject.Inject
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
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
		val extension names = new NamedSerializationContextProvider(grammar)
		
		val dir_context = directory('context')
		val dir_context_type = directory('context_type')
		val dir_syntactic_sequencer = directory('syntactic_sequencer')
		val dir_semantic_sequencer = directory('semantic_sequencer')

		for (e : contextPDAProvider.getContextPDAs(grammar).namedContexts) {
			result.add(dir_context + e.name + ".dot" -> pdaToDot.drawSafe(e.value))
			result.add(dir_context + e.name + ".txt" -> e.contexts.join("\n"))
		}
		for (e : contextTypePDAProvider.getContextTypePDAs(grammar).namedContexts) {
			result.add(dir_context_type + e.name + ".dot" -> pdaToDot.drawSafe(e.value))
			result.add(dir_context_type + e.name + ".txt" -> e.contexts.join("\n"))
		}
		for (e : syntacticSequencerPDAProvider.getSyntacticSequencerPDAs(grammar).namedContexts) {
			result.add(dir_syntactic_sequencer + e.name + ".dot" -> syntacticSequencerPDA2Dot.drawSafe(e.value))
			result.add(dir_syntactic_sequencer + e.name + ".txt" -> e.contexts.join("\n"))
		}
		for (e : semanticSequencerNFAProvider.getSemanticSequencerNFAs(grammar).namedContexts) {
			result.add(dir_semantic_sequencer + e.name + ".dot" -> nfaToDot.drawSafe(e.value))
			result.add(dir_semantic_sequencer + e.name + ".txt" -> e.contexts.join("\n"))
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
	
	private def String drawSafe(GraphvizDotBuilder builder, Object graph) {
		try {
			builder.draw(graph)
		} catch (Exception e) {
			println("Error rendering")
			e.printStackTrace
			return Throwables.getStackTraceAsString(e)
		}
	}

	private def String directory(String name) {
		grammar.runtimeBasePackage.replace('.', '/') + '/serializer/' + GrammarUtil.getSimpleName(grammar).toLowerCase +
			'_' + name + '/'
	}

}
