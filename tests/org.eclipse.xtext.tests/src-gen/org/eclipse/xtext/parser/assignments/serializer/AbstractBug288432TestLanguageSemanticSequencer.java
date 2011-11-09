package org.eclipse.xtext.parser.assignments.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.assignments.bug288432Test.Body;
import org.eclipse.xtext.parser.assignments.bug288432Test.Bug288432TestPackage;
import org.eclipse.xtext.parser.assignments.bug288432Test.Foo;
import org.eclipse.xtext.parser.assignments.bug288432Test.MyElement;
import org.eclipse.xtext.parser.assignments.bug288432Test.MyInt;
import org.eclipse.xtext.parser.assignments.bug288432Test.Parameter;
import org.eclipse.xtext.parser.assignments.bug288432Test.ParameterRef;
import org.eclipse.xtext.parser.assignments.services.Bug288432TestLanguageGrammarAccess;
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
public class AbstractBug288432TestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected Bug288432TestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == Bug288432TestPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case Bug288432TestPackage.BODY:
				if(context == grammarAccess.getBodyRule()) {
					sequence_Body(context, (Body) semanticObject); 
					return; 
				}
				else break;
			case Bug288432TestPackage.FOO:
				if(context == grammarAccess.getFooRule()) {
					sequence_Foo(context, (Foo) semanticObject); 
					return; 
				}
				else break;
			case Bug288432TestPackage.MY_ELEMENT:
				if(context == grammarAccess.getContentRule() ||
				   context == grammarAccess.getMyElementRule() ||
				   context == grammarAccess.getParameterObjectRule()) {
					sequence_MyElement(context, (MyElement) semanticObject); 
					return; 
				}
				else break;
			case Bug288432TestPackage.MY_INT:
				if(context == grammarAccess.getMyIntRule() ||
				   context == grammarAccess.getParameterObjectRule()) {
					sequence_MyInt(context, (MyInt) semanticObject); 
					return; 
				}
				else break;
			case Bug288432TestPackage.PARAMETER:
				if(context == grammarAccess.getParameterRule()) {
					sequence_Parameter(context, (Parameter) semanticObject); 
					return; 
				}
				else break;
			case Bug288432TestPackage.PARAMETER_REF:
				if(context == grammarAccess.getParameterObjectRule() ||
				   context == grammarAccess.getParameterRefRule()) {
					sequence_ParameterRef(context, (ParameterRef) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     ((parameter+=Parameter parameter+=Parameter*)? (content=Content | content=ParameterRef) foo+=Foo+)
	 */
	protected void sequence_Body(EObject context, Body semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     fooValue=STRING
	 */
	protected void sequence_Foo(EObject context, Foo semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug288432TestPackage.Literals.FOO__FOO_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug288432TestPackage.Literals.FOO__FOO_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFooAccess().getFooValueSTRINGTerminalRuleCall_0(), semanticObject.getFooValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (bar=MyInt | bar=ParameterRef)
	 */
	protected void sequence_MyElement(EObject context, MyElement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     int=INT
	 */
	protected void sequence_MyInt(EObject context, MyInt semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug288432TestPackage.Literals.MY_INT__INT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug288432TestPackage.Literals.MY_INT__INT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMyIntAccess().getIntINTTerminalRuleCall_0(), semanticObject.getInt());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     parameter=[Parameter|ID]
	 */
	protected void sequence_ParameterRef(EObject context, ParameterRef semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug288432TestPackage.Literals.PARAMETER_REF__PARAMETER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug288432TestPackage.Literals.PARAMETER_REF__PARAMETER));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getParameterRefAccess().getParameterParameterIDTerminalRuleCall_0_1(), semanticObject.getParameter());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID value=[ParameterObject|ID]?)
	 */
	protected void sequence_Parameter(EObject context, Parameter semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
