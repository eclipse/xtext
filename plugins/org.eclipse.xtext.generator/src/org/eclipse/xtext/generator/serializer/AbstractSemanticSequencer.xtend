package org.eclipse.xtext.generator.serializer

import org.eclipse.xtext.generator.grammarAccess.GrammarAccess
import java.util.List
import org.eclipse.xtext.serializer.analysis.GrammarConstraintProvider
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider$IConstraint
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider$IConstraintElement
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
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.serializer.sequencer.GenericSequencer
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider$INodesForEObjectProvider
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer
import org.eclipse.xtext.serializer.sequencer.ITransientValueService
import org.eclipse.xtext.serializer.sequencer.ITransientValueService$ValueTransient
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic$Acceptor
import com.google.inject.Provider
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider
import org.eclipse.emf.ecore.ENamedElement

class AbstractSemanticSequencer extends GeneratedFile {
	
	@Inject Grammar grammar
	
	@Inject extension GrammarAccess grammarAccess
	
	@Inject extension SemanticSequencerUtil sequencerUtil
	
	@Inject SemanticSequencer sequencer
	
	override String getQualifiedName(Grammar grammar) {
		grammar.getName("Abstract", "SemanticSequencer");		
	}
	
	def <T extends ENamedElement> List<T> sort(Iterable<T> iterable) {
		iterable.sort(p1, p2|p1.name.compareTo(p2.name))
	}
	
	def Iterable<EPackage> getAccessedPackages() {
		grammar.grammarConstraints.filter(e|e.type != null).map(e|e.type.EPackage).toSet.sort
	}
	
	def Iterable<EClass> getAccessedClasses(EPackage pkg) {
		grammar.grammarConstraints.map(e|e.type).filter(e|e != null && e.EPackage == pkg).toSet.sort
	}
	
	def Iterable<EClass> getAccessedClasses() {
		grammar.grammarConstraints.map(e|e.type).toSet.sort
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
	
	def getResourceSet() {
		grammar.eResource.resourceSet
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
		accessedConstraints.map(c|c.mostConcreteGrammar).exists(g| g != null && g != grammar)
	}
	
	override getFileContents() {
		val file = new JavaFile(packageName);
		
		file.imported(typeof(EObject))
		file.imported(typeof(GenericSequencer))
		file.imported(typeof(ISemanticSequencer))
		file.imported(typeof(ITransientValueService))
		file.imported(typeof(ISemanticSequenceAcceptor))
		file.imported(typeof(ISemanticSequencerDiagnosticProvider))
		file.imported(typeof(ISerializationDiagnostic$Acceptor))
		file.imported(typeof(org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer))
		file.imported(typeof(Inject))
		file.imported(typeof(Provider))
		
		file.body = '''
			@SuppressWarnings("restriction")
			public class «simpleName» extends AbstractSemanticSequencer {
			
				@Inject
				protected «file.imported(grammar.gaFQName)» grammarAccess;
				
				@Inject
				protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
				
				@Inject
				protected ITransientValueService transientValues;
				
				@Inject
				@GenericSequencer
				protected Provider<ISemanticSequencer> genericSequencerProvider;
				
				protected ISemanticSequencer genericSequencer;
				
				«IF usesSuperGrammar»
					«val superGrammar = file.imported(sequencer.getQualifiedName(grammar.usedGrammars.head))»
					@Inject
					protected Provider<«superGrammar»> superSequencerProvider;
					 
					protected «superGrammar» superSequencer; 
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
				
				«file.genMethodCreateSequence()»
				
				«accessedConstraints.filter(e|e.type!=null).join("\n\n",[e|file.genMethodSequence(e)])»
			}
		'''.toString; 
		file.toString 
	}
	
	def genMethodCreateSequence(JavaFile file) '''
		public void createSequence(EObject context, EObject semanticObject) {
			«var pkgi = 0 »
			«FOR pkg:accessedPackages /* ITERATOR i */»
			«IF (pkgi = pkgi + 1) > 1 /*!i.firstIteration */»else «ENDIF»if(semanticObject.eClass().getEPackage() == «file.imported(pkg.getGenPackage(resourceSet).qualifiedPackageInterfaceName)».eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
				«FOR type:pkg.accessedClasses»
				case «type.getGenIntLiteral(resourceSet)»:
					«var ctxi = 0»
					«FOR ctx: type.accessedConstraints.entrySet /* ITERATOR j-  */»
						«IF (ctxi = ctxi + 1) > 1 /*!j.firstIteration  */»else «ENDIF»if(«FOR c:ctx.value SEPARATOR " ||\n   "»context == grammarAccess.«c.gaAccessor»«ENDFOR») {
							sequence_«ctx.key.name»(context, («file.imported(type.getGenClass(resourceSet).qualifiedInterfaceName)») semanticObject); 
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
	
	def genMethodSequence(JavaFile file, IGrammarConstraintProvider$IConstraint c) '''
		/**
		 * Constraint:
		 *     «if(c.body == null) "{"+c.type.name+"}" else c.body.toString().replaceAll("\\n","\n*     ")»
		 *
		 * Features:
		«FOR f:c.features.filter(e|e != null)»
			«" *    "»«f.toString().replaceAll("\\n","\n *     ")»
		«ENDFOR»
		 */
		protected void sequence_«c.name»(EObject context, «file.imported(c.type.getGenClass(resourceSet).qualifiedInterfaceName)» semanticObject) {
			«IF !newHashSet(grammar, null).contains(c.mostConcreteGrammar)»
				superSequencer.createSequence(context, semanticObject);
			«ELSEIF c.canGenerate()»
				if(errorAcceptor != null) {
					«FOR f:c.features.filter(e|e != null)»
						«val x = file.imported(f.feature.EContainingClass.EPackage.getGenPackage(resourceSet).qualifiedPackageInterfaceName)»
						if(transientValues.isValueTransient(semanticObject, «f.feature.getGenTypeLiteral(resourceSet)») == «file.imported(typeof(ITransientValueService$ValueTransient))».YES)
							errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, «f.feature.getGenTypeLiteral(resourceSet)»));
					«ENDFOR»
				}
				«file.imported(typeof(ISemanticNodeProvider$INodesForEObjectProvider))» nodes = createNodeProvider(semanticObject);
				«file.imported(typeof(SequenceFeeder))» feeder = createSequencerFeeder(semanticObject, nodes);
				«FOR f: if(c.body.featureInfo != null) newArrayList(c.body.featureInfo) else c.body.children.filter(e|e.featureInfo != null).map(e|e.featureInfo)»
					«val assignment=f.assignments.get(0)»
					feeder.accept(grammarAccess.«assignment.grammarElement.gaAccessor()», semanticObject.«f.feature.getGenFeature(resourceSet).getAccessor»());
				«ENDFOR»
				feeder.finish();
			«ELSE»
				genericSequencer.createSequence(context, semanticObject);
			«ENDIF»
		}
	'''
}


