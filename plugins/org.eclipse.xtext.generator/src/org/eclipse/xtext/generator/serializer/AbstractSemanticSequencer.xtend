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
import com.google.inject.Provider
import java.util.Map
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.generator.grammarAccess.GrammarAccess
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder
import org.eclipse.xtext.serializer.analysis.Context2NameFunction
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider$IConstraint
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic$Acceptor
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer
import org.eclipse.xtext.serializer.sequencer.GenericSequencer
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider$INodesForEObjectProvider
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer
import org.eclipse.xtext.serializer.sequencer.ITransientValueService
import org.eclipse.xtext.serializer.sequencer.ITransientValueService$ValueTransient
import org.eclipse.xtext.xbase.lib.Pair
import org.eclipse.emf.ecore.ENamedElement
import java.util.List

class AbstractSemanticSequencer extends GeneratedFile {
	
	@Inject Grammar grammar
	
	@Inject extension GrammarAccess grammarAccess
	
	@Inject extension SemanticSequencerUtil sequencerUtil
	
	@Inject SerializerGenFileNames names
	
	@Inject extension Context2NameFunction ctx2name
	
	def <T extends ENamedElement> List<T> sortByName(Iterable<T> iterable) {
		iterable.sort(p1, p2|p1.name.compareTo(p2.name))
	}
	
	def Iterable<EPackage> getAccessedPackages() {
		grammar.grammarConstraints.filter(e|e.type != null).map(e|e.type.EPackage).toSet.sortByName
	}
	
	def Iterable<EClass> getAccessedClasses(EPackage pkg) {
		grammar.grammarConstraints.map(e|e.type).filter(e|e != null && e.EPackage == pkg).toSet.sortByName
	}
	
	def getAccessedConstraints(EClass clazz) {
		grammar.getGrammarConstraints(clazz)
	}
	
//	def getAccessedConstraints() {
//		grammar.getGrammarConstraints()
//	}
	
//	def usesSuperGrammar() {
//		val localConstraints = accessedConstraints
//		val superConstraints = grammar.superGrammar.grammarConstraints
//		localConstraints.exists[superConstraints.contains(it)]
//	}
	
	override getFileContents(SerializerGenFileNames$GenFileName filename) {
		val file = new JavaEMFFile(grammar.eResource.resourceSet, filename.packageName);
		
		file.imported(typeof(EObject))
		file.imported(typeof(GenericSequencer))
		file.imported(typeof(ISemanticSequencer))
		file.imported(typeof(ITransientValueService))
		file.imported(typeof(ISemanticSequenceAcceptor))
		file.imported(typeof(ISemanticSequencerDiagnosticProvider))
		file.imported(typeof(ISerializationDiagnostic$Acceptor))
		file.imported(typeof(Inject))
		file.imported(typeof(Provider))
		
		val localConstraints = grammar.grammarConstraints
		val superConstraints = grammar.superGrammar.grammarConstraints
		
		val superGrammar = if(localConstraints.exists[superConstraints.contains(it)]) 
				file.imported(names.semanticSequencer.getQualifiedName(grammar.usedGrammars.head))
			else
				file.imported(typeof(AbstractDelegatingSemanticSequencer))
		val _abstract = if (filename.isAbstract) "abstract " else "" 
		file.body = '''
			@SuppressWarnings("all")
			public «_abstract»class «filename.simpleName» extends «superGrammar» {
			
				@Inject
				private «file.imported(grammar.gaFQName)» grammarAccess;
				
				«file.genMethodCreateSequence()»
				
				«localConstraints.filter(e|e.type!=null && !superConstraints.contains(e)).sort.join("\n\n",[e|file.genMethodSequence(e)])»
			}
		'''.toString; 
		file.toString 
	}
	
	def <K, V> Map<K, V> toMap(Iterable<Pair<K, V>> items) {
		val result = <K, V>newHashMap()
		for(i:items) 
			result.put(i.key, i.value)
		result
	}
	
	def genMethodCreateSequence(JavaEMFFile file) '''
		public void createSequence(EObject context, EObject semanticObject) {
			«val superConstraints = grammar.superGrammar.grammarConstraints.map[it->it].toMap»
			«var pkgi = 0 »
			«FOR pkg:accessedPackages /* ITERATOR i */»
			«IF (pkgi = pkgi + 1) > 1 /*!i.firstIteration */»else «ENDIF»if(semanticObject.eClass().getEPackage() == «file.importedGenTypeLiteral(pkg)») switch(semanticObject.eClass().getClassifierID()) {
				«FOR type:pkg.accessedClasses»
				case «file.importedGenIntLiteral(type)»:
					«var ctxi = 0»
					«FOR ctx: type.accessedConstraints.entrySet.sortBy(e|e.key.name) /* ITERATOR j-  */»
						«IF (ctxi = ctxi + 1) > 1 /*!j.firstIteration  */»else «ENDIF»if(«FOR c:ctx.value.sortBy(e|e.contextName) SEPARATOR " ||\n   "»context == grammarAccess.«c.gaAccessor»«ENDFOR») {
							«val superConstraint = superConstraints.get(ctx.key)»
							«val constraint = if(superConstraint == null) ctx.key else superConstraint»
							sequence_«constraint.simpleName»(context, («file.importedGenTypeName(type)») semanticObject); 
							return; 
						}
					«ENDFOR»
					else break;
				«ENDFOR»
				}
			«ENDFOR»
			if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
		}
	'''
	
	def genMethodSequence(JavaEMFFile file, IGrammarConstraintProvider$IConstraint c) '''
		/**
		 * Constraint:
		 *     «if(c.body == null) "{"+c.type.name+"}" else c.body.toString().replaceAll("\\n","\n*     ")»
		 */
		protected void sequence_«c.simpleName»(EObject context, «file.importedGenTypeName(c.type)» semanticObject) {
			«val cast = file.getEObjectCast(c.type)»
			«IF c.canGenerate()»
				if(errorAcceptor != null) {
					«FOR f:c.features.filter(e|e != null)»
						if(transientValues.isValueTransient(«cast»semanticObject, «file.importedGenTypeLiteral(f.feature)») == «file.imported(typeof(ITransientValueService$ValueTransient))».YES)
							errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(«cast»semanticObject, «file.importedGenTypeLiteral(f.feature)»));
					«ENDFOR»
				}
				«file.imported(typeof(ISemanticNodeProvider$INodesForEObjectProvider))» nodes = createNodeProvider(«cast»semanticObject);
				«file.imported(typeof(SequenceFeeder))» feeder = createSequencerFeeder(«cast»semanticObject, nodes);
				«FOR f: if(c.body.featureInfo != null) newArrayList(c.body.featureInfo) else c.body.children.filter(e|e.featureInfo != null).map(e|e.featureInfo)»
					«val assignment=f.assignments.get(0)»
					feeder.accept(grammarAccess.«assignment.grammarElement.gaAccessor()», semanticObject.«file.getGetAccessor(f.feature)»());
				«ENDFOR»
				feeder.finish();
			«ELSE»
				genericSequencer.createSequence(context, «cast»semanticObject);
			«ENDIF»
		}
	'''
}


