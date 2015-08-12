/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.serializer

import com.google.inject.Inject
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.generator.Naming
import org.eclipse.xtext.serializer.analysis.Context2NameFunction
import org.eclipse.xtext.serializer.analysis.IContextPDAProvider
import org.eclipse.xtext.serializer.analysis.IContextProvider
import org.eclipse.xtext.serializer.analysis.IContextTypePDAProvider
import org.eclipse.xtext.serializer.analysis.ISemanticSequencerNfaProvider
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider
import org.eclipse.xtext.util.formallang.PdaToDot
import org.eclipse.xtext.xbase.lib.Pair
import org.eclipse.xtext.util.formallang.NfaToDot

class DebugGraphGenerator { 
	
	@Inject extension IContextProvider contextProvider
	
	@Inject Grammar grammar
	
	@Inject extension Naming naming
	
	@Inject extension Context2NameFunction nameFunction
	
	@Inject IContextPDAProvider contextPDAProvider
	
	@Inject IContextTypePDAProvider contextTypePDAProvider
	
	@Inject ISyntacticSequencerPDAProvider syntacticSequencerPDAProvider
	
	@Inject ISemanticSequencerNfaProvider semanticSequencerNFAProvider
	
	@Inject SyntacticSequencerPDA2ExtendedDot syntacticSequencerPDA2Dot
	
	@Inject SyntacticSequencerUtil syntacticSequencerUtil
	
	@Inject PdaToDot<?,?> pdaToDot
	
	@Inject NfaToDot<?> nfaToDot
	
	def Iterable<Pair<String, String>> generateDebugGraphs() {
		val result = <Pair<String, String>>newArrayList()
		for(context: contextProvider.getAllContexts(grammar)) {
			try {
				result.add(file("context", context) -> pdaToDot.draw(contextPDAProvider.getContextPDA(context)))
				for(type: contextProvider.getTypesForContext(context)) {
					try {
						result.add(file("context_type", context, type) -> pdaToDot.draw(contextTypePDAProvider.getContextTypePDA(context, type)))
						result.add(file("syntactic_sequencer", context, type) -> syntacticSequencerPDA2Dot.draw(syntacticSequencerPDAProvider.getPDA(context, type)))
						result.add(file("semantic_sequencer", context, type) -> nfaToDot.draw(semanticSequencerNFAProvider.getNFA(context, type)))
					} catch(Throwable t) {
						System.out.println("Context: " + getContextName(grammar, context) + " Type:" + type?.name)
						t.printStackTrace
					}
				}
			} catch(Throwable t) {
				System.out.println("Context: " + getContextName(grammar, context))
				t.printStackTrace
			}
		}
		try {
			var i = 0
			val trans2id = newHashMap()
			for (transition : syntacticSequencerUtil.allAmbiguousTransitions) {
				val name = "ambiguity_" + i
				result.add(directory("syntactic_sequencer") + name + ".dot" -> nfaToDot.draw(transition.ambiguousNfa))
				trans2id.put(transition, name)
				i = i + 1
			}
			val ambiguities = new StringBuffer()
			for (group : syntacticSequencerUtil.allAmbiguousTransitionsBySyntax) {
				ambiguities.append('''
					id: «group.identifyer»
					    Ambiguous syntax:»:
					        «group.elementAlias.toString.replace("\n", "\n        ")»
					    This ambiguous syntax occurs at:
						«FOR trans : group.transitions»
							«trans2id.get(trans)»:
							    «group.ambiguityInsideTransition(trans).replace("\n", "\n        ")»
						«ENDFOR»
						
					
				''')
			}
			result.add(directory("syntactic_sequencer") + "ambiguities.txt" -> ambiguities.toString)
		} catch (Throwable t) {
			t.printStackTrace
		}
		return result
	}
	
	def String directory(String name) {
		grammar.basePackageRuntime.asPath + "/serializer/" + grammar.name.toSimpleName.toLowerCase + "_" + name + "/"
	}
	
	def String file(String name, EObject ctx, EClass type) {
		directory(name) + getContextName(grammar, ctx) + "_" + type?.name + ".dot";
	}
	
	def String file(String name, EObject ctx) {
		directory(name) + getContextName(grammar, ctx) + ".dot";
	}
}