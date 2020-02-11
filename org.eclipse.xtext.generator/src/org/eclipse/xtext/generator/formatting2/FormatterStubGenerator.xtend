/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.formatting2

import com.google.common.collect.LinkedHashMultimap
import com.google.common.collect.Multimap
import com.google.inject.Inject
import java.util.Collection
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.generator.Naming
import org.eclipse.xtext.generator.grammarAccess.GrammarAccessUtil
import org.eclipse.xtext.generator.serializer.JavaEMFFile

import static extension org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.generator.IInheriting.Util.*
import java.util.Set

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Deprecated
@FinalFieldsConstructor class FormatterStubGenerator {
	@Accessors(PUBLIC_GETTER) static class Service {
		@Inject Naming naming

		def FormatterStubGenerator createGenerator(Grammar grammar) {
			new FormatterStubGenerator(this, grammar)
		}
	}

	val FormatterStubGenerator.Service service
	val Grammar grammar

	def String getStubSimpleName() {
		'''«service.naming.toSimpleName(grammar.name)»Formatter'''
	}

	def String getStubPackageName() {
		'''«service.naming.toPackageName(grammar.name)».formatting2'''
	}

	def String getStubQualifiedName() {
		'''«stubPackageName».«stubSimpleName»'''
	}

	def String getStubFileName() {
		'''«service.naming.asPath(getStubQualifiedName)».xtend'''
	}

	def String getStubSuperClassName() {
		val superGrammar = grammar.nonTerminalsSuperGrammar
		if (superGrammar !== null)
			return service.createGenerator(superGrammar).stubQualifiedName
		else
			return AbstractFormatter2.name
	}

	protected def void getLocallyAssignedContainmentReferences(Grammar grammar, Multimap<EClass, EReference> type2ref) {
		for (assignment : grammar.containedAssignments) {
			val type = assignment.findCurrentType
			if (type instanceof EClass) {
				val feature = type.getEStructuralFeature(assignment.feature)
				if (feature instanceof EReference && (feature as EReference).isContainment) {
					type2ref.put(type, feature as EReference)
				}
			}
		}
		for (action : grammar.containedActions) {
			val featureName = action.feature
			if (featureName !== null) {
				val type = action.type.classifier
				if (type instanceof EClass) {
					val feature = type.getEStructuralFeature(featureName)
					if (feature instanceof EReference && (feature as EReference).isContainment) {
						type2ref.put(type, feature as EReference)
					}
				}
			}
		}
	}
	
	protected def void getInheritedContainmentReferences(Grammar grammar, Multimap<EClass, EReference> type2ref, Set<Grammar> visitedGrammars) {
		visitedGrammars.add(grammar)
		for (Grammar usedGrammar : grammar.usedGrammars) {
			if (!visitedGrammars.contains(usedGrammar)) {
				getLocallyAssignedContainmentReferences(usedGrammar, type2ref)
				getInheritedContainmentReferences(usedGrammar, type2ref, visitedGrammars)
			}
		}
	}

	def String generateStubFileContents() {
		val extension file = new JavaEMFFile(grammar.eResource.resourceSet, stubPackageName, service.naming.fileHeader);
		file.imported(IFormattableDocument)

		val type2ref = LinkedHashMultimap.<EClass, EReference>create
		getLocallyAssignedContainmentReferences(grammar, type2ref)
		val inheritedTypes = LinkedHashMultimap.<EClass, EReference>create
		getInheritedContainmentReferences(grammar, inheritedTypes, newHashSet)
		
		file.body = '''
			class «stubSimpleName» extends «stubSuperClassName.imported» {
				
				@«Inject.imported» extension «GrammarAccessUtil.getGrammarAccessFQName(grammar, service.naming).imported»
				«FOR type : type2ref.keySet»

					«type.generateFormatMethod(file, type2ref.get(type), inheritedTypes.containsKey(type))»
				«ENDFOR»	
			}
		'''
		return file.toString
	}
	
	protected def String toName(EClass clazz) {
		clazz.name.toLowerCase
	}
	
	protected def generateFormatMethod(EClass clazz, extension JavaEMFFile file, Collection<EReference> containmentRefs, boolean isOverriding) '''
		«IF isOverriding»override«ELSE»def«ENDIF» dispatch void format(«clazz.importedGenTypeName» «clazz.toName», extension IFormattableDocument document) {
			// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
			«FOR ref:containmentRefs»
				«IF ref.isMany»
					for («ref.EReferenceType.importedGenTypeName» «ref.name» : «clazz.toName».«ref.getAccessor»()) {
						format(«ref.name», document);
					}
				«ELSE»
					format(«clazz.toName».«ref.getAccessor»(), document);
				«ENDIF»
			«ENDFOR»
		}
	'''
}
