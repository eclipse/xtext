package org.eclipse.xtext.generator.serializer

import org.eclipse.xtext.generator.grammarAccess.GrammarAccess
import java.util.List
import org.eclipse.xtext.serializer.impl.GrammarConstraintProvider
import org.eclipse.xtext.serializer.IGrammarConstraintProvider$IConstraint
import org.eclipse.xtext.Grammar
import static extension org.eclipse.xtext.generator.GenModelAccess.*
import org.eclipse.xtext.generator.serializer.SemanticSequencerUtil.*
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EClass
import com.google.common.collect.Lists
import java.util.Map
import org.eclipse.xtext.serializer.IGrammarConstraintProvider
import org.eclipse.emf.ecore.EcorePackage

class AbstractSemanticSequencer extends GeneratedFile {
	
	@Inject Grammar
	
	@Inject extension GrammarAccess
	
	@Inject extension SemanticSequencerUtil
	
	override String getQualifiedName() {
		getName("Abstract", "SemanticSequencer");		
	}
	
	Iterable<EPackage> getAccessedPackages() {
		grammar.grammarConstraints.map(e|e.type.EPackage).toSet
	}
	
	Iterable<EClass> getAccessedClasses(EPackage pkg) {
		grammar.grammarConstraints.map(e|e.type).filter(e|e.EPackage == pkg).toSet
	}
	
	Iterable<EClass> getAccessedClasses() {
		grammar.grammarConstraints.map(e|e.type).toSet
	}
	
	getAccessedConstraints(EClass clazz) {
		grammar.getGrammarConstraints(clazz)
	}
	
	getAccessedContexts(EClass clazz) {
		grammar.getGrammarContexts(clazz)
	}
	
	getAccessedContexts() {
		grammar.getGrammarContexts()
	}
	
	getAccessedConstraints() {
		grammar.getGrammarConstraints()
	}
	
	
	override getFileContents() { '''
		package «packageName»;
		
		import java.util.Collections;
		import static java.util.Collections.singleton;
		
		import org.eclipse.emf.ecore.EObject;
		import org.eclipse.xtext.nodemodel.ICompositeNode;
		import org.eclipse.xtext.nodemodel.ILeafNode;
		import org.eclipse.xtext.serializer.GenericSequencer;
		import org.eclipse.xtext.serializer.ISemanticNodeProvider;
		import org.eclipse.xtext.serializer.ISemanticNodeProvider.INodesForEObjectProvider;
		import org.eclipse.xtext.serializer.ISemanticSequencer;
		import org.eclipse.xtext.serializer.ITransientValueService;
		import org.eclipse.xtext.serializer.ITransientValueService.ValueTransient;
		import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
		import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
		import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
		import org.eclipse.xtext.serializer.impl.AbstractSemanticSequencer;
		import «grammar.gaFQName»;
		«FOR e:accessedPackages»
			import «e.genPackage.qualifiedPackageName».*;
		«ENDFOR»
		
		import com.google.inject.Inject;
		import com.google.inject.Provider;	
		
		@SuppressWarnings("restriction")
		public class «simpleName» extends AbstractSemanticSequencer {
		
			@Inject
			protected «grammar.gaSimpleName» grammarAccess;
			
			@Inject
			protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
			
			@Inject
			protected ITransientValueService transientValues;
			
			@Inject
			protected ISemanticNodeProvider nodeProvider;
			
			@Inject
			@GenericSequencer
			protected Provider<ISemanticSequencer> genericSequencerProvider;
			
			protected ISemanticSequencer genericSequencer;
			
			@Override
			public void init(ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
				super.init(sequenceAcceptor, errorAcceptor);
				this.genericSequencer = genericSequencerProvider.get();
				this.genericSequencer.init(sequenceAcceptor, errorAcceptor);
			}
			
			«genMethodFindContext»	
			
			«accessedClasses.filter(e|e.accessedContexts.size > 1).join("\n\n", [e|e.genMethodFindContextType()])»
			
			«genMethodCreateSequence»
			
			«accessedConstraints.join("\n\n",[e|e.genMethodSequence])»
		}
	'''.toString }
	
	genMethodFindContext() '''
		public Iterable<EObject> findContexts(EObject semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
			«var pkgi = 0»
			«FOR pkg:accessedPackages  /* ITERATOR i */»
				«IF (pkgi = pkgi + 1) > 1 /* !i.firstIteration */»else «ENDIF»if(semanticObject.eClass().getEPackage() == «pkg.genPackage.packageInterfaceName».eINSTANCE) 
					switch(semanticObject.eClass().getClassifierID()) {
						«val width = pkg.accessedClasses.fold(0, [max, type | Math::max(type.genIntLiteral.length, max)])»
						«FOR type:pkg.accessedClasses»
							case «type.genIntLiteral»:«(type.genIntLiteral.length..width).fold("",[s, i|s + " "])»return «IF type.accessedContexts.size == 1»singleton((EObject)grammarAccess.«type.accessedContexts.iterator.next.gaAccessor()»)«ELSE»findContexts((«type.getGenClass().interfaceName»)semanticObject, consultContainer, contextCandidates)«ENDIF»;
						«ENDFOR»
					}
			«ENDFOR»	
			return Collections.emptyList();
		}
	'''
		
	
	genMethodFindContextType(EClass type) '''
		/**
		 * Potential Result Contexts:
		 *     «FOR ctx:type.accessedContexts SEPARATOR "\n*     "»«ctx.gaAccessor»«ENDFOR»
		 */
		protected Iterable<EObject> findContexts(«type.genClass().interfaceName» semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
			return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
		}
	'''
	
	genMethodCreateSequence() '''
		public void createSequence(EObject context, EObject semanticObject) {
			«var pkgi = 0 »
			«FOR pkg:accessedPackages /* ITERATOR i */»
			«IF (pkgi = pkgi + 1) > 1 /*!i.firstIteration */»else «ENDIF»if(semanticObject.eClass().getEPackage() == «pkg.getGenPackage().packageInterfaceName».eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
				«FOR type:pkg.accessedClasses»
				case «type.genIntLiteral»:
					«var ctxi = 0»
					«FOR ctx: type.accessedConstraints.entrySet /* ITERATOR j-  */»
						«IF (ctxi = ctxi + 1) > 1 /*!j.firstIteration  */»else «ENDIF»if(«FOR c:ctx.value SEPARATOR " ||\n   "»context == grammarAccess.«c.gaAccessor»«ENDFOR») {
							sequence_«ctx.key.name»(context, («type.name») semanticObject); 
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
	
	genMethodSequence(IGrammarConstraintProvider$IConstraint c) '''
		/**
		 * Constraint:
		 *     «if(c.body == null) "{"+c.type.name+"}" else c.body.toString().replaceAll("\\n","\n*     ")»
		 *
		 * Features:
		«FOR f:c.features.filter(e|e != null)»
			«" *    "»«f.toString().replaceAll("\\n","\n *     ")»
		«ENDFOR»
		 */
		protected void sequence_«c.name»(EObject context, «c.type.getGenClass().interfaceName» semanticObject) {
			«IF c.canGenerate()»
				if(errorAcceptor != null) {
					«FOR f:c.features.filter(e|e != null)»
						if(transientValues.isValueTransient(semanticObject, «f.feature.genTypeLiteral») == ValueTransient.YES)
							errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, «f.feature.genTypeLiteral»));
					«ENDFOR»
				}
				INodesForEObjectProvider nodes = nodeProvider.getNodesForSemanticObject(semanticObject, null);
				«FOR f: if(c.body.featureInfo != null) newArrayList(c.body.featureInfo) else c.body.children.filter(e|e.featureInfo != null).map(e|e.featureInfo)»
					«val assignment=f.assignments.get(0)»
					«assignment.type.toAcceptMethod()»(semanticObject, grammarAccess.«assignment.grammarElement.gaAccessor()», semanticObject.«f.feature.getGenFeature().getAccessor»(), -1, («assignment.type.toNodeType»)nodes.getNodeForSingelValue(«f.feature.genTypeLiteral», semanticObject.«f.feature.getGenFeature().getAccessor»()));
				«ENDFOR»
				acceptFinish();
			«ELSE»
				genericSequencer.createSequence(context, semanticObject);
			«ENDIF»
		}
	'''
}


