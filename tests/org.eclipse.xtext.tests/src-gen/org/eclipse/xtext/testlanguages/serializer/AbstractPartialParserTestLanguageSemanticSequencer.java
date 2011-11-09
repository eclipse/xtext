package org.eclipse.xtext.testlanguages.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.AbstractChildren;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.Child;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.Children;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.FirstConcrete;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.Named;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.Nested;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.PartialParserTestLanguagePackage;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.SecondConcrete;
import org.eclipse.xtext.testlanguages.partialParserTestLanguage.SomeContainer;
import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess;

@SuppressWarnings("restriction")
public class AbstractPartialParserTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected PartialParserTestLanguageGrammarAccess grammarAccess;
	
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
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == PartialParserTestLanguagePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case PartialParserTestLanguagePackage.ABSTRACT_CHILDREN:
				if(context == grammarAccess.getAbstractChildrenRule() ||
				   context == grammarAccess.getContentRule()) {
					sequence_AbstractChildren(context, (AbstractChildren) semanticObject); 
					return; 
				}
				else break;
			case PartialParserTestLanguagePackage.CHILD:
				if(context == grammarAccess.getChildRule()) {
					sequence_Child(context, (Child) semanticObject); 
					return; 
				}
				else break;
			case PartialParserTestLanguagePackage.CHILDREN:
				if(context == grammarAccess.getChildrenRule() ||
				   context == grammarAccess.getContentRule()) {
					sequence_Children(context, (Children) semanticObject); 
					return; 
				}
				else break;
			case PartialParserTestLanguagePackage.FIRST_CONCRETE:
				if(context == grammarAccess.getAbstractChildRule() ||
				   context == grammarAccess.getFirstConcreteRule()) {
					sequence_FirstConcrete(context, (FirstConcrete) semanticObject); 
					return; 
				}
				else break;
			case PartialParserTestLanguagePackage.NAMED:
				if(context == grammarAccess.getNamedRule()) {
					sequence_Named(context, (Named) semanticObject); 
					return; 
				}
				else break;
			case PartialParserTestLanguagePackage.NESTED:
				if(context == grammarAccess.getNestedRule()) {
					sequence_Nested(context, (Nested) semanticObject); 
					return; 
				}
				else break;
			case PartialParserTestLanguagePackage.SECOND_CONCRETE:
				if(context == grammarAccess.getAbstractChildRule() ||
				   context == grammarAccess.getSecondConcreteRule()) {
					sequence_SecondConcrete(context, (SecondConcrete) semanticObject); 
					return; 
				}
				else break;
			case PartialParserTestLanguagePackage.SOME_CONTAINER:
				if(context == grammarAccess.getSomeContainerRule()) {
					sequence_SomeContainer(context, (SomeContainer) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     abstractChildren+=AbstractChild+
	 */
	protected void sequence_AbstractChildren(EObject context, AbstractChildren semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=Named
	 */
	protected void sequence_Child(EObject context, Child semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, PartialParserTestLanguagePackage.Literals.CHILD__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PartialParserTestLanguagePackage.Literals.CHILD__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getChildAccess().getValueNamedParserRuleCall_3_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (children+=Child children+=Child*)
	 */
	protected void sequence_Children(EObject context, Children semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value=Named referencedContainer=[SomeContainer|ID]?)
	 */
	protected void sequence_FirstConcrete(EObject context, FirstConcrete semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Named(EObject context, Named semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, PartialParserTestLanguagePackage.Literals.NAMED__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, PartialParserTestLanguagePackage.Literals.NAMED__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNamedAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     nested+=SomeContainer+
	 */
	protected void sequence_Nested(EObject context, Nested semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (value=Named referencedChildren+=[Child|ID]?)
	 */
	protected void sequence_SecondConcrete(EObject context, SecondConcrete semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID (nested+=Nested | content+=Content)*)
	 */
	protected void sequence_SomeContainer(EObject context, SomeContainer semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
