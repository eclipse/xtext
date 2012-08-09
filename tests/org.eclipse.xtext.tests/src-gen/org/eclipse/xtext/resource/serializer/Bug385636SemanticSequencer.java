package org.eclipse.xtext.resource.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.bug385636.Bug385636Package;
import org.eclipse.xtext.resource.bug385636.DefineVariable;
import org.eclipse.xtext.resource.bug385636.DefineVariables;
import org.eclipse.xtext.resource.bug385636.Expression_Equal;
import org.eclipse.xtext.resource.bug385636.Expression_Larger_Equal;
import org.eclipse.xtext.resource.bug385636.Expression_Not_Equal;
import org.eclipse.xtext.resource.bug385636.Expression_Not_Greater;
import org.eclipse.xtext.resource.bug385636.Expression_Not_Less;
import org.eclipse.xtext.resource.bug385636.Expression_Smaller;
import org.eclipse.xtext.resource.bug385636.Expression_Smaller_Equal;
import org.eclipse.xtext.resource.bug385636.Expression_VariableName;
import org.eclipse.xtext.resource.bug385636.NVariableAccess;
import org.eclipse.xtext.resource.bug385636.Program;
import org.eclipse.xtext.resource.services.Bug385636GrammarAccess;
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
public class Bug385636SemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private Bug385636GrammarAccess grammarAccess;

	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == Bug385636Package.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case Bug385636Package.DEFINE_VARIABLE:
				if(context == grammarAccess.getDefineVariableRule()) {
					sequence_DefineVariable(context, (DefineVariable) semanticObject);
					return;
				}
				else break;
			case Bug385636Package.DEFINE_VARIABLES:
				if(context == grammarAccess.getDefineVariablesRule()) {
					sequence_DefineVariables(context, (DefineVariables) semanticObject);
					return;
				}
				else break;
			case Bug385636Package.EXPRESSION_EQUAL:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getStatementAccess().getExpression_EqualLeftAction_1_3_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Larger_EqualLeftAction_1_0_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Not_EqualLeftAction_1_4_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Not_GreaterLeftAction_1_6_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Not_LessLeftAction_1_5_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_SmallerLeftAction_1_1_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Smaller_EqualLeftAction_1_2_1()) {
					sequence_Statement(context, (Expression_Equal) semanticObject);
					return;
				}
				else break;
			case Bug385636Package.EXPRESSION_LARGER_EQUAL:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getStatementAccess().getExpression_EqualLeftAction_1_3_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Larger_EqualLeftAction_1_0_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Not_EqualLeftAction_1_4_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Not_GreaterLeftAction_1_6_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Not_LessLeftAction_1_5_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_SmallerLeftAction_1_1_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Smaller_EqualLeftAction_1_2_1()) {
					sequence_Statement(context, (Expression_Larger_Equal) semanticObject);
					return;
				}
				else break;
			case Bug385636Package.EXPRESSION_NOT_EQUAL:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getStatementAccess().getExpression_EqualLeftAction_1_3_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Larger_EqualLeftAction_1_0_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Not_EqualLeftAction_1_4_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Not_GreaterLeftAction_1_6_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Not_LessLeftAction_1_5_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_SmallerLeftAction_1_1_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Smaller_EqualLeftAction_1_2_1()) {
					sequence_Statement(context, (Expression_Not_Equal) semanticObject);
					return;
				}
				else break;
			case Bug385636Package.EXPRESSION_NOT_GREATER:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getStatementAccess().getExpression_EqualLeftAction_1_3_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Larger_EqualLeftAction_1_0_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Not_EqualLeftAction_1_4_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Not_GreaterLeftAction_1_6_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Not_LessLeftAction_1_5_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_SmallerLeftAction_1_1_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Smaller_EqualLeftAction_1_2_1()) {
					sequence_Statement(context, (Expression_Not_Greater) semanticObject);
					return;
				}
				else break;
			case Bug385636Package.EXPRESSION_NOT_LESS:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getStatementAccess().getExpression_EqualLeftAction_1_3_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Larger_EqualLeftAction_1_0_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Not_EqualLeftAction_1_4_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Not_GreaterLeftAction_1_6_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Not_LessLeftAction_1_5_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_SmallerLeftAction_1_1_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Smaller_EqualLeftAction_1_2_1()) {
					sequence_Statement(context, (Expression_Not_Less) semanticObject);
					return;
				}
				else break;
			case Bug385636Package.EXPRESSION_SMALLER:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getStatementAccess().getExpression_EqualLeftAction_1_3_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Larger_EqualLeftAction_1_0_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Not_EqualLeftAction_1_4_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Not_GreaterLeftAction_1_6_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Not_LessLeftAction_1_5_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_SmallerLeftAction_1_1_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Smaller_EqualLeftAction_1_2_1()) {
					sequence_Statement(context, (Expression_Smaller) semanticObject);
					return;
				}
				else break;
			case Bug385636Package.EXPRESSION_SMALLER_EQUAL:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getStatementAccess().getExpression_EqualLeftAction_1_3_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Larger_EqualLeftAction_1_0_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Not_EqualLeftAction_1_4_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Not_GreaterLeftAction_1_6_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Not_LessLeftAction_1_5_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_SmallerLeftAction_1_1_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Smaller_EqualLeftAction_1_2_1()) {
					sequence_Statement(context, (Expression_Smaller_Equal) semanticObject);
					return;
				}
				else break;
			case Bug385636Package.EXPRESSION_VARIABLE_NAME:
				if(context == grammarAccess.getExpression_VariableNameRule() ||
				   context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getStatementAccess().getExpression_EqualLeftAction_1_3_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Larger_EqualLeftAction_1_0_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Not_EqualLeftAction_1_4_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Not_GreaterLeftAction_1_6_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Not_LessLeftAction_1_5_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_SmallerLeftAction_1_1_1() ||
				   context == grammarAccess.getStatementAccess().getExpression_Smaller_EqualLeftAction_1_2_1()) {
					sequence_Expression_VariableName(context, (Expression_VariableName) semanticObject);
					return;
				}
				else break;
			case Bug385636Package.NVARIABLE_ACCESS:
				if(context == grammarAccess.getNVariableAccessRule()) {
					sequence_NVariableAccess(context, (NVariableAccess) semanticObject);
					return;
				}
				else break;
			case Bug385636Package.PROGRAM:
				if(context == grammarAccess.getProgramRule()) {
					sequence_Program(context, (Program) semanticObject);
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
	protected void sequence_DefineVariable(EObject context, DefineVariable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug385636Package.Literals.DEFINE_VARIABLE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug385636Package.Literals.DEFINE_VARIABLE__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDefineVariableAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}


	/**
	 * Constraint:
	 *     variables+=DefineVariable+
	 */
	protected void sequence_DefineVariables(EObject context, DefineVariables semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Constraint:
	 *     variable=NVariableAccess
	 */
	protected void sequence_Expression_VariableName(EObject context, Expression_VariableName semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug385636Package.Literals.EXPRESSION_VARIABLE_NAME__VARIABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug385636Package.Literals.EXPRESSION_VARIABLE_NAME__VARIABLE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getExpression_VariableNameAccess().getVariableNVariableAccessParserRuleCall_0(), semanticObject.getVariable());
		feeder.finish();
	}


	/**
	 * Constraint:
	 *     variable=[DefineVariable|ID]
	 */
	protected void sequence_NVariableAccess(EObject context, NVariableAccess semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug385636Package.Literals.NVARIABLE_ACCESS__VARIABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug385636Package.Literals.NVARIABLE_ACCESS__VARIABLE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNVariableAccessAccess().getVariableDefineVariableIDTerminalRuleCall_0_1(), semanticObject.getVariable());
		feeder.finish();
	}


	/**
	 * Constraint:
	 *     (define=DefineVariables statements+=Statement*)
	 */
	protected void sequence_Program(EObject context, Program semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}


	/**
	 * Constraint:
	 *     (left=Statement_Expression_Equal_1_3_1 right=Expression_VariableName)
	 */
	protected void sequence_Statement(EObject context, Expression_Equal semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug385636Package.Literals.EXPRESSION_EQUAL__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug385636Package.Literals.EXPRESSION_EQUAL__LEFT));
			if(transientValues.isValueTransient(semanticObject, Bug385636Package.Literals.EXPRESSION_EQUAL__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug385636Package.Literals.EXPRESSION_EQUAL__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStatementAccess().getExpression_EqualLeftAction_1_3_1(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getStatementAccess().getRightExpression_VariableNameParserRuleCall_1_3_2_0(), semanticObject.getRight());
		feeder.finish();
	}


	/**
	 * Constraint:
	 *     (left=Statement_Expression_Larger_Equal_1_0_1 right=Expression_VariableName)
	 */
	protected void sequence_Statement(EObject context, Expression_Larger_Equal semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug385636Package.Literals.EXPRESSION_LARGER_EQUAL__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug385636Package.Literals.EXPRESSION_LARGER_EQUAL__LEFT));
			if(transientValues.isValueTransient(semanticObject, Bug385636Package.Literals.EXPRESSION_LARGER_EQUAL__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug385636Package.Literals.EXPRESSION_LARGER_EQUAL__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStatementAccess().getExpression_Larger_EqualLeftAction_1_0_1(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getStatementAccess().getRightExpression_VariableNameParserRuleCall_1_0_2_0(), semanticObject.getRight());
		feeder.finish();
	}


	/**
	 * Constraint:
	 *     (left=Statement_Expression_Not_Equal_1_4_1 right=Expression_VariableName)
	 */
	protected void sequence_Statement(EObject context, Expression_Not_Equal semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug385636Package.Literals.EXPRESSION_NOT_EQUAL__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug385636Package.Literals.EXPRESSION_NOT_EQUAL__LEFT));
			if(transientValues.isValueTransient(semanticObject, Bug385636Package.Literals.EXPRESSION_NOT_EQUAL__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug385636Package.Literals.EXPRESSION_NOT_EQUAL__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStatementAccess().getExpression_Not_EqualLeftAction_1_4_1(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getStatementAccess().getRightExpression_VariableNameParserRuleCall_1_4_2_0(), semanticObject.getRight());
		feeder.finish();
	}


	/**
	 * Constraint:
	 *     (left=Statement_Expression_Not_Greater_1_6_1 right=Expression_VariableName)
	 */
	protected void sequence_Statement(EObject context, Expression_Not_Greater semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug385636Package.Literals.EXPRESSION_NOT_GREATER__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug385636Package.Literals.EXPRESSION_NOT_GREATER__LEFT));
			if(transientValues.isValueTransient(semanticObject, Bug385636Package.Literals.EXPRESSION_NOT_GREATER__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug385636Package.Literals.EXPRESSION_NOT_GREATER__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStatementAccess().getExpression_Not_GreaterLeftAction_1_6_1(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getStatementAccess().getRightExpression_VariableNameParserRuleCall_1_6_2_0(), semanticObject.getRight());
		feeder.finish();
	}


	/**
	 * Constraint:
	 *     (left=Statement_Expression_Not_Less_1_5_1 right=Expression_VariableName)
	 */
	protected void sequence_Statement(EObject context, Expression_Not_Less semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug385636Package.Literals.EXPRESSION_NOT_LESS__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug385636Package.Literals.EXPRESSION_NOT_LESS__LEFT));
			if(transientValues.isValueTransient(semanticObject, Bug385636Package.Literals.EXPRESSION_NOT_LESS__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug385636Package.Literals.EXPRESSION_NOT_LESS__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStatementAccess().getExpression_Not_LessLeftAction_1_5_1(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getStatementAccess().getRightExpression_VariableNameParserRuleCall_1_5_2_0(), semanticObject.getRight());
		feeder.finish();
	}


	/**
	 * Constraint:
	 *     (left=Statement_Expression_Smaller_1_1_1 right=Expression_VariableName)
	 */
	protected void sequence_Statement(EObject context, Expression_Smaller semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug385636Package.Literals.EXPRESSION_SMALLER__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug385636Package.Literals.EXPRESSION_SMALLER__LEFT));
			if(transientValues.isValueTransient(semanticObject, Bug385636Package.Literals.EXPRESSION_SMALLER__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug385636Package.Literals.EXPRESSION_SMALLER__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStatementAccess().getExpression_SmallerLeftAction_1_1_1(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getStatementAccess().getRightExpression_VariableNameParserRuleCall_1_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}


	/**
	 * Constraint:
	 *     (left=Statement_Expression_Smaller_Equal_1_2_1 right=Expression_VariableName)
	 */
	protected void sequence_Statement(EObject context, Expression_Smaller_Equal semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, Bug385636Package.Literals.EXPRESSION_SMALLER_EQUAL__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug385636Package.Literals.EXPRESSION_SMALLER_EQUAL__LEFT));
			if(transientValues.isValueTransient(semanticObject, Bug385636Package.Literals.EXPRESSION_SMALLER_EQUAL__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, Bug385636Package.Literals.EXPRESSION_SMALLER_EQUAL__RIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStatementAccess().getExpression_Smaller_EqualLeftAction_1_2_1(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getStatementAccess().getRightExpression_VariableNameParserRuleCall_1_2_2_0(), semanticObject.getRight());
		feeder.finish();
	}
}
