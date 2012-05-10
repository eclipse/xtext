package org.eclipse.xtext.parser.assignments.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.assignments.bug287184Test.AssociatedDetail;
import org.eclipse.xtext.parser.assignments.bug287184Test.Bug287184TestPackage;
import org.eclipse.xtext.parser.assignments.bug287184Test.Detail;
import org.eclipse.xtext.parser.assignments.bug287184Test.Model;
import org.eclipse.xtext.parser.assignments.services.Bug287184TestLanguageGrammarAccess;
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
public class Bug287184TestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private Bug287184TestLanguageGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == Bug287184TestPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case Bug287184TestPackage.ASSOCIATED_DETAIL:
				if(context == grammarAccess.getAbstractDetailRule() ||
				   context == grammarAccess.getAssociatedDetailRule()) {
					sequence_AssociatedDetail(context, (AssociatedDetail) semanticObject); 
					return; 
				}
				else break;
			case Bug287184TestPackage.DETAIL:
				if(context == grammarAccess.getAbstractDetailRule() ||
				   context == grammarAccess.getDetailRule()) {
					sequence_Detail(context, (Detail) semanticObject); 
					return; 
				}
				else break;
			case Bug287184TestPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     detailClass=[Model|FQN]
	 */
	protected void sequence_AssociatedDetail(EObject context, AssociatedDetail semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug287184TestPackage.Literals.ABSTRACT_DETAIL__DETAIL_CLASS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug287184TestPackage.Literals.ABSTRACT_DETAIL__DETAIL_CLASS));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAssociatedDetailAccess().getDetailClassModelFQNParserRuleCall_1_0_1(), semanticObject.getDetailClass());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ((visibility='private' | visibility='protected' | visibility='public')? detailClass=[Model|FQN])
	 */
	protected void sequence_Detail(EObject context, Detail semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=FQN (detail+=Detail | detail+=AssociatedDetail)+)
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
