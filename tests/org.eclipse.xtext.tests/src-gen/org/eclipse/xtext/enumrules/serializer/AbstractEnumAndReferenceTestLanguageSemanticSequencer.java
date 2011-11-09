package org.eclipse.xtext.enumrules.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EntityWithEnumAndReference;
import org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EnumAndReferenceTestLanguagePackage;
import org.eclipse.xtext.enumrules.services.EnumAndReferenceTestLanguageGrammarAccess;
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

@SuppressWarnings("restriction")
public class AbstractEnumAndReferenceTestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected EnumAndReferenceTestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == EnumAndReferenceTestLanguagePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case EnumAndReferenceTestLanguagePackage.ENTITY_WITH_ENUM_AND_REFERENCE:
				if(context == grammarAccess.getEntityWithEnumAndReferenceRule()) {
					sequence_EntityWithEnumAndReference(context, (EntityWithEnumAndReference) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (type=KindOfKeyword name=ID ref=[EntityWithEnumAndReference|ID])
	 */
	protected void sequence_EntityWithEnumAndReference(EObject context, EntityWithEnumAndReference semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, EnumAndReferenceTestLanguagePackage.Literals.ENTITY_WITH_ENUM_AND_REFERENCE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EnumAndReferenceTestLanguagePackage.Literals.ENTITY_WITH_ENUM_AND_REFERENCE__TYPE));
			if(transientValues.isValueTransient(semanticObject, EnumAndReferenceTestLanguagePackage.Literals.ENTITY_WITH_ENUM_AND_REFERENCE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EnumAndReferenceTestLanguagePackage.Literals.ENTITY_WITH_ENUM_AND_REFERENCE__NAME));
			if(transientValues.isValueTransient(semanticObject, EnumAndReferenceTestLanguagePackage.Literals.ENTITY_WITH_ENUM_AND_REFERENCE__REF) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, EnumAndReferenceTestLanguagePackage.Literals.ENTITY_WITH_ENUM_AND_REFERENCE__REF));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEntityWithEnumAndReferenceAccess().getTypeKindOfKeywordEnumRuleCall_0_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getEntityWithEnumAndReferenceAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getEntityWithEnumAndReferenceAccess().getRefEntityWithEnumAndReferenceIDTerminalRuleCall_3_0_1(), semanticObject.getRef());
		feeder.finish();
	}
}
