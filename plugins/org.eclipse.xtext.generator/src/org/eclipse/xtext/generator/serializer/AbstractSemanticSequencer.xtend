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
import org.eclipse.xtext.serializer.sequencer.GenericSequencer
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer
import org.eclipse.xtext.serializer.sequencer.ITransientValueService

import static extension org.eclipse.xtext.GrammarUtil.*

class AbstractSemanticSequencer extends GeneratedFile {
	
	@Inject Grammar grammar
	
	@Inject extension GrammarAccess grammarAccess
	
	@Inject extension SemanticSequencerUtil sequencerUtil
	
	@Inject SerializerGenFileNames names
	
	@Inject extension Context2NameFunction ctx2name
	
	def <T extends ENamedElement> List<T> sort(Iterable<T> iterable) {
		iterable.sort(p1, p2|p1.name.compareTo(p2.name))
	}
	
	def Iterable<EPackage> getAccessedPackages() {
		grammar.grammarConstraints.filter(e|e.type != null).map(e|e.type.EPackage).toSet.sort
	}
	
	def Iterable<EClass> getAccessedClasses(EPackage pkg) {
		grammar.grammarConstraints.map(e|e.type).filter(e|e != null && e.EPackage == pkg).toSet.sort
	}
	
	def getAccessedConstraints(EClass clazz) {
		grammar.getGrammarConstraints(clazz)
	}
	
	def getAccessedConstraints() {
		grammar.getGrammarConstraints()
	}
	
	def usesSuperGrammar() {
		accessedConstraints.exists(c | c.declaringGrammar != grammar)
	}
	
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
		
		val superGrammar = if(usesSuperGrammar) 
				file.imported(names.semanticSequencer.getQualifiedName(grammar.usedGrammars.head))
			else
				file.imported(typeof(org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer)) 
		
		file.body = '''
			@SuppressWarnings("all")
			public class «filename.simpleName» extends «superGrammar» {
			
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
				
				
				@Override
				public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
					super.init(sequencer, sequenceAcceptor, errorAcceptor);
					this.genericSequencer = genericSequencerProvider.get();
					this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
				}
				
				«file.genMethodCreateSequence()»
				
				«accessedConstraints.filter(e|e.type!=null && e.declaringGrammar == grammar).join("\n\n",[e|file.genMethodSequence(e)])»
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


