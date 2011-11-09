package org.eclipse.xtext.parser.antlr.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.bug296889Test.Bug296889TestPackage;
import org.eclipse.xtext.parser.antlr.bug296889Test.Model;
import org.eclipse.xtext.parser.antlr.bug296889Test.Postop;
import org.eclipse.xtext.parser.antlr.bug296889Test.Preop;
import org.eclipse.xtext.parser.antlr.bug296889Test.Variable;
import org.eclipse.xtext.parser.antlr.services.Bug296889TestLanguageGrammarAccess;
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
public class AbstractBug296889TestLanguageSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected Bug296889TestLanguageGrammarAccess grammarAccess;
	
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
		if(semanticObject.eClass().getEPackage() == Bug296889TestPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case Bug296889TestPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case Bug296889TestPackage.POSTOP:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getPostopRule()) {
					sequence_Postop(context, (Postop) semanticObject); 
					return; 
				}
				else break;
			case Bug296889TestPackage.PREOP:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getPreopRule()) {
					sequence_Preop(context, (Preop) semanticObject); 
					return; 
				}
				else break;
			case Bug296889TestPackage.VARIABLE:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getPostopRule() ||
				   context == grammarAccess.getPostopAccess().getPostopExprAction_1_0() ||
				   context == grammarAccess.getVariableRule()) {
					sequence_Variable(context, (Variable) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (expressions+=Expression* | values+=DataTypeExpression*)
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expr=Postop_Postop_1_0 functionName='--')
	 */
	protected void sequence_Postop(EObject context, Postop semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug296889TestPackage.Literals.POSTOP__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug296889TestPackage.Literals.POSTOP__EXPR));
			if(transientValues.isValueTransient(semanticObject, Bug296889TestPackage.Literals.POSTOP__FUNCTION_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug296889TestPackage.Literals.POSTOP__FUNCTION_NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPostopAccess().getPostopExprAction_1_0(), semanticObject.getExpr());
		feeder.accept(grammarAccess.getPostopAccess().getFunctionNameHyphenMinusHyphenMinusKeyword_1_1_0(), semanticObject.getFunctionName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (functionName='--' expr=Variable)
	 */
	protected void sequence_Preop(EObject context, Preop semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug296889TestPackage.Literals.PREOP__FUNCTION_NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug296889TestPackage.Literals.PREOP__FUNCTION_NAME));
			if(transientValues.isValueTransient(semanticObject, Bug296889TestPackage.Literals.PREOP__EXPR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug296889TestPackage.Literals.PREOP__EXPR));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPreopAccess().getFunctionNameHyphenMinusHyphenMinusKeyword_1_0(), semanticObject.getFunctionName());
		feeder.accept(grammarAccess.getPreopAccess().getExprVariableParserRuleCall_2_0(), semanticObject.getExpr());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_Variable(EObject context, Variable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug296889TestPackage.Literals.VARIABLE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug296889TestPackage.Literals.VARIABLE__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
}
