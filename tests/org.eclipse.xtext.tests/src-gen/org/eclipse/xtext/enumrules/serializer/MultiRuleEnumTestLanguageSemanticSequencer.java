package org.eclipse.xtext.enumrules.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.enumrules.multiRuleenums.Model;
import org.eclipse.xtext.enumrules.multiRuleenums.MultiRuleenumsPackage;
import org.eclipse.xtext.enumrules.services.MultiRuleEnumTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class MultiRuleEnumTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private MultiRuleEnumTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == MultiRuleenumsPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case MultiRuleenumsPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (a=EnumRuleA b=EnumRuleB c=EnumRuleC)
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, MultiRuleenumsPackage.Literals.MODEL__A) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MultiRuleenumsPackage.Literals.MODEL__A));
			if(transientValues.isValueTransient(semanticObject, MultiRuleenumsPackage.Literals.MODEL__B) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MultiRuleenumsPackage.Literals.MODEL__B));
			if(transientValues.isValueTransient(semanticObject, MultiRuleenumsPackage.Literals.MODEL__C) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MultiRuleenumsPackage.Literals.MODEL__C));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getModelAccess().getAEnumRuleAEnumRuleCall_1_0(), semanticObject.getA());
		feeder.accept(grammarAccess.getModelAccess().getBEnumRuleBEnumRuleCall_2_0(), semanticObject.getB());
		feeder.accept(grammarAccess.getModelAccess().getCEnumRuleCEnumRuleCall_3_0(), semanticObject.getC());
		feeder.finish();
	}
}
