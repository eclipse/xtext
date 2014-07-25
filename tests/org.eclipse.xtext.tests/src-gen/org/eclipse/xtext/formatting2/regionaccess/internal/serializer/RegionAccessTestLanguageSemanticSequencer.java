package org.eclipse.xtext.formatting2.regionaccess.internal.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.regionaccess.internal.formattertestlanguage.Delegate;
import org.eclipse.xtext.formatting2.regionaccess.internal.formattertestlanguage.Delegation;
import org.eclipse.xtext.formatting2.regionaccess.internal.formattertestlanguage.FormattertestlanguagePackage;
import org.eclipse.xtext.formatting2.regionaccess.internal.formattertestlanguage.PrefixedUnassigned;
import org.eclipse.xtext.formatting2.regionaccess.internal.formattertestlanguage.Simple;
import org.eclipse.xtext.formatting2.regionaccess.internal.services.RegionAccessTestLanguageGrammarAccess;
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
public class RegionAccessTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private RegionAccessTestLanguageGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == FormattertestlanguagePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case FormattertestlanguagePackage.DELEGATE:
				if(context == grammarAccess.getDelegateRule() ||
				   context == grammarAccess.getPrefixedDelegateRule() ||
				   context == grammarAccess.getRootRule() ||
				   context == grammarAccess.getUnassignedRule()) {
					sequence_Delegate(context, (Delegate) semanticObject); 
					return; 
				}
				else break;
			case FormattertestlanguagePackage.DELEGATION:
				if(context == grammarAccess.getDelegationRule() ||
				   context == grammarAccess.getRootRule()) {
					sequence_Delegation(context, (Delegation) semanticObject); 
					return; 
				}
				else break;
			case FormattertestlanguagePackage.PREFIXED_UNASSIGNED:
				if(context == grammarAccess.getPrefixedUnassignedRule() ||
				   context == grammarAccess.getRootRule()) {
					sequence_PrefixedUnassigned(context, (PrefixedUnassigned) semanticObject); 
					return; 
				}
				else break;
			case FormattertestlanguagePackage.SIMPLE:
				if(context == grammarAccess.getRootRule() ||
				   context == grammarAccess.getSimpleRule()) {
					sequence_Simple(context, (Simple) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Delegate(EObject context, Delegate semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FormattertestlanguagePackage.Literals.DELEGATE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FormattertestlanguagePackage.Literals.DELEGATE__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDelegateAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     delegate=Delegate
	 */
	protected void sequence_Delegation(EObject context, Delegation semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FormattertestlanguagePackage.Literals.DELEGATION__DELEGATE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FormattertestlanguagePackage.Literals.DELEGATION__DELEGATE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDelegationAccess().getDelegateDelegateParserRuleCall_1_0(), semanticObject.getDelegate());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     delegate=PrefixedDelegate
	 */
	protected void sequence_PrefixedUnassigned(EObject context, PrefixedUnassigned semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FormattertestlanguagePackage.Literals.PREFIXED_UNASSIGNED__DELEGATE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FormattertestlanguagePackage.Literals.PREFIXED_UNASSIGNED__DELEGATE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPrefixedUnassignedAccess().getDelegatePrefixedDelegateParserRuleCall_1_0(), semanticObject.getDelegate());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Simple(EObject context, Simple semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, FormattertestlanguagePackage.Literals.SIMPLE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, FormattertestlanguagePackage.Literals.SIMPLE__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSimpleAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
}
