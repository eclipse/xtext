package org.eclipse.xtext.generator.serializer

import com.google.inject.Inject
import com.google.inject.Provider
import java.util.List
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.generator.grammarAccess.GrammarAccess
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder
import org.eclipse.xtext.serializer.analysis.Context2NameFunction
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer
import org.eclipse.xtext.serializer.sequencer.GenericSequencer
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer
import org.eclipse.xtext.serializer.sequencer.ITransientValueService

import static extension org.eclipse.xtext.GrammarUtil.*

class AbstractSemanticSequencer extends GeneratedFile {
	
	@Inject Grammar grammar
	
	@Inject extension GrammarAccess grammarAccess
	
	@Inject extension SemanticSequencerUtil sequencerUtil
	
	@Inject SemanticSequencer sequencer
	
	@Inject extension Context2NameFunction ctx2name
	
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
		val file = new JavaEMFFile(grammar.eResource.resourceSet, packageName);
		
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
	
	def genMethodCreateSequence(JavaEMFFile file) '''
		public void createSequence(EObject context, EObject semanticObject) {
			«var pkgi = 0 »
			«FOR pkg:accessedPackages /* ITERATOR i */»
			«IF (pkgi = pkgi + 1) > 1 /*!i.firstIteration */»else «ENDIF»if(semanticObject.eClass().getEPackage() == «file.importedGenTypeLiteral(pkg)») switch(semanticObject.eClass().getClassifierID()) {
				«FOR type:pkg.accessedClasses»
				case «file.importedGenIntLiteral(type)»:
					«var ctxi = 0»
					«FOR ctx: type.accessedConstraints.entrySet.sortBy(e|e.key.name) /* ITERATOR j-  */»
						«IF (ctxi = ctxi + 1) > 1 /*!j.firstIteration  */»else «ENDIF»if(«FOR c:ctx.value.sortBy(e|e.contextName) SEPARATOR " ||\n   "»context == grammarAccess.«c.gaAccessor»«ENDFOR») {
							sequence_«ctx.key.simpleName»(context, («file.importedGenTypeName(type)») semanticObject); 
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
		 *
		 * Features:
		«FOR f:c.features.filter(e|e != null)»
			«" *    "»«f.toString().replaceAll("\\n","\n *     ")»
		«ENDFOR»
		 */
		protected void sequence_«c.simpleName»(EObject context, «file.importedGenTypeName(c.type)» semanticObject) {
			«val cast = file.getEObjectCast(c.type)»
			«IF !newHashSet(grammar, null).contains(c.mostConcreteGrammar)»
				superSequencer.createSequence(context, «cast»semanticObject);
			«ELSEIF c.canGenerate()»
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


