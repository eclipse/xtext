package org.eclipse.xtext.generator.serializer

import org.eclipse.xtext.generator.grammarAccess.GrammarAccess
import java.util.List
import org.eclipse.xtext.serializer.impl.GrammarConstraintProvider
import org.eclipse.xtext.serializer.IGrammarConstraintProvider$IConstraint
import org.eclipse.xtext.serializer.IGrammarConstraintProvider$IConstraintElement
import org.eclipse.xtext.Grammar
import static extension org.eclipse.xtext.generator.GenModelAccess.*
import static extension org.eclipse.xtext.GrammarUtil.*
import org.eclipse.xtext.generator.serializer.SemanticSequencerUtil.*
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EClass
import com.google.common.collect.Lists
import java.util.Map
import org.eclipse.xtext.serializer.IGrammarConstraintProvider
import org.eclipse.emf.ecore.EcorePackage
import com.google.inject.Inject

class AbstractSemanticSequencer extends GeneratedFile {
	
	@Inject Grammar grammar
	
	@Inject extension GrammarAccess grammarAccess
	
	@Inject extension SemanticSequencerUtil sequencerUtil
	
	@Inject SemanticSequencer sequencer
	
	override String getQualifiedName(Grammar grammar) {
		grammar.getName("Abstract", "SemanticSequencer");		
	}
	
	def Iterable<EPackage> getAccessedPackages() {
		grammar.grammarConstraints.filter(e|e.type != null).map(e|e.type.EPackage).toSet
	}
	
	def Iterable<EClass> getAccessedClasses(EPackage pkg) {
		grammar.grammarConstraints.map(e|e.type).filter(e|e != null && e.EPackage == pkg).toSet
	}
	
	def Iterable<EClass> getAccessedClasses() {
		grammar.grammarConstraints.map(e|e.type).toSet
	}
	
	def getAccessedConstraints(EClass clazz) {
		grammar.getGrammarConstraints(clazz)
	}
	
	def getAccessedContexts(EClass clazz) {
		grammar.getGrammarContexts(clazz)
	}
	
	def getAccessedContexts() {
		grammar.getGrammarContexts()
	}
	
	def getAccessedConstraints() {
		grammar.getGrammarConstraints()
	}
	
	def getGrammars(IGrammarConstraintProvider$IConstraintElement ele) {
		val result = <Grammar>newHashSet();
		if(ele != null && ele.grammarElement != null) result.add(ele.grammarElement.grammar);
		if(ele != null && ele.children != null) for(g:ele.children.map(c|c.grammars).flatten) result.add(g);
		return result;
	}
	
	def uses(Grammar g1, Grammar g2) {
		g1 != null && g1.usedGrammars.exists(e|e == g2 || e.uses(g2))
	}
	
	def getMostConcreteGrammar(IGrammarConstraintProvider$IConstraint constraint) {
		constraint.body.grammars.reduce(x, y | if(x.uses(y)) x else y)
	}
	
	def usesSuperGrammar() {
		accessedConstraints.map(c|c.mostConcreteGrammar).exists(g|g!=grammar)
	}
	
	override getFileContents() {
		val file = new JavaFile(packageName);
		
		file.imports += "org.eclipse.emf.ecore.EObject";
		file.imports += "org.eclipse.xtext.serializer.GenericSequencer";
		file.imports += "org.eclipse.xtext.serializer.ISemanticNodeProvider";
		file.imports += "org.eclipse.xtext.serializer.ISemanticNodeProvider.INodesForEObjectProvider";
		file.imports += "org.eclipse.xtext.serializer.ISemanticSequencer";
		file.imports += "org.eclipse.xtext.serializer.ITransientValueService";
		file.imports += "org.eclipse.xtext.serializer.acceptor.SequenceFeeder";
		file.imports += "org.eclipse.xtext.serializer.ITransientValueService.ValueTransient";
		file.imports += "org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor";
		file.imports += "org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider";
		file.imports += "org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor";
		file.imports += "org.eclipse.xtext.serializer.impl.AbstractSemanticSequencer";
		file.imports += grammar.gaFQName;
		file.imports += "com.google.inject.Inject";
		file.imports += "com.google.inject.Provider";
		file.imports.addAll(accessedPackages.map(e|e.genPackage.qualifiedPackageName + ".*"));
		
		if(usesSuperGrammar) file.imports += sequencer.getQualifiedName(grammar.usedGrammars.head);
		file.body = '''
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
				
				«IF usesSuperGrammar»
					@Inject
					protected Provider<«sequencer.getSimpleName(grammar.usedGrammars.head)»> superSequencerProvider;
					 
					protected «sequencer.getSimpleName(grammar.usedGrammars.head)» superSequencer; 
				«ENDIF»
				
				@Override
				public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
					super.init(sequencer, sequenceAcceptor, errorAcceptor);
					this.genericSequencer = genericSequencerProvider.get();
					this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
					«IF usesSuperGrammar»
						this.superSequencer = superSequencerProvider.get();
						this.superSequencer.init(sequencer, sequenceAcceptor, errorAcceptor); 
					«ENDIF»
				}
				
				« /* genMethodFindContext */ ""»
				
				« /* accessedClasses.filter(e|e.accessedContexts.size > 1).join("\n\n", [e|e.genMethodFindContextType()]) */ ""»
				
				«genMethodCreateSequence»
				
				«accessedConstraints.filter(e|e.type!=null).join("\n\n",[e|e.genMethodSequence])»
			}
		'''.toString; 
		file.toString 
	}
	
//	genMethodFindContext() '''
//		public Iterable<EObject> findContexts(EObject semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
//			«var pkgi = 0»
//			«FOR pkg:accessedPackages  /* ITERATOR i */»
//				«IF (pkgi = pkgi + 1) > 1 /* !i.firstIteration */»else «ENDIF»if(semanticObject.eClass().getEPackage() == «pkg.genPackage.packageInterfaceName».eINSTANCE) 
//					switch(semanticObject.eClass().getClassifierID()) {
//						«val width = pkg.accessedClasses.fold(0, [max, type | Math::max(type.genIntLiteral.length, max)])»
//						«FOR type:pkg.accessedClasses»
//							case «type.genIntLiteral»:«(type.genIntLiteral.length..width).fold("",[s, i|s + " "])»return «IF type.accessedContexts.size == 1»singleton((EObject)grammarAccess.«type.accessedContexts.iterator.next.gaAccessor()»)«ELSE»findContexts((«type.getGenClass().interfaceName»)semanticObject, consultContainer, contextCandidates)«ENDIF»;
//						«ENDFOR»
//					}
//			«ENDFOR»	
//			return Collections.emptyList();
//		}
//	'''
//		
//	
//	genMethodFindContextType(EClass type) '''
//		/**
//		 * Potential Result Contexts:
//		 *     «FOR ctx:type.accessedContexts SEPARATOR "\n*     "»«ctx.gaAccessor»«ENDFOR»
//		 */
//		protected Iterable<EObject> findContexts(«type.genClass().interfaceName» semanticObject, boolean consultContainer, Iterable<EObject> contextCandidates) {
//			return genericSequencer.findContexts(semanticObject, consultContainer, contextCandidates);
//		}
//	'''
	
	def genMethodCreateSequence() '''
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
	
	def genMethodSequence(IGrammarConstraintProvider$IConstraint c) '''
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
			«IF !newHashSet(grammar, null).contains(c.mostConcreteGrammar)»
				superSequencer.createSequence(context, semanticObject);
			«ELSEIF c.canGenerate()»
				if(errorAcceptor != null) {
					«FOR f:c.features.filter(e|e != null)»
						if(transientValues.isValueTransient(semanticObject, «f.feature.genTypeLiteral») == ValueTransient.YES)
							errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, «f.feature.genTypeLiteral»));
					«ENDFOR»
				}
				INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
				SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
				«FOR f: if(c.body.featureInfo != null) newArrayList(c.body.featureInfo) else c.body.children.filter(e|e.featureInfo != null).map(e|e.featureInfo)»
					«val assignment=f.assignments.get(0)»
					feeder.accept(grammarAccess.«assignment.grammarElement.gaAccessor()», semanticObject.«f.feature.getGenFeature().getAccessor»());
				«ENDFOR»
				feeder.finish();
			«ELSE»
				genericSequencer.createSequence(context, semanticObject);
			«ENDIF»
		}
	'''
}


