/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Add;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Atom;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.C1;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.C2;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.C3;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.ComplexrewritetestPackage;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.Minus;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyB;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyC;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyD;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyE;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyF;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyG;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyG1;
import org.eclipse.xtext.parsetree.reconstr.complexrewritetest.TrickyG2;
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class ComplexReconstrTestLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ComplexReconstrTestLanguageGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == ComplexrewritetestPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case ComplexrewritetestPackage.ADD:
				sequence_Op_Parens(context, (Add) semanticObject); 
				return; 
			case ComplexrewritetestPackage.ATOM:
				if (rule == grammarAccess.getAtomRule()) {
					sequence_Atom(context, (Atom) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getRootRule()
						|| rule == grammarAccess.getOpRule()
						|| action == grammarAccess.getOpAccess().getAddAddOperandsAction_1_0_0()
						|| action == grammarAccess.getOpAccess().getMinusMinusOperandsAction_1_1_0()
						|| rule == grammarAccess.getTermRule()
						|| rule == grammarAccess.getParensRule()) {
					sequence_Atom_Parens(context, (Atom) semanticObject); 
					return; 
				}
				else break;
			case ComplexrewritetestPackage.C1:
				sequence_TrickyC(context, (C1) semanticObject); 
				return; 
			case ComplexrewritetestPackage.C2:
				sequence_TrickyC(context, (C2) semanticObject); 
				return; 
			case ComplexrewritetestPackage.C3:
				sequence_TrickyC(context, (C3) semanticObject); 
				return; 
			case ComplexrewritetestPackage.MINUS:
				sequence_Op_Parens(context, (Minus) semanticObject); 
				return; 
			case ComplexrewritetestPackage.TRICKY_B:
				sequence_TrickyB(context, (TrickyB) semanticObject); 
				return; 
			case ComplexrewritetestPackage.TRICKY_C:
				sequence_TrickyC(context, (TrickyC) semanticObject); 
				return; 
			case ComplexrewritetestPackage.TRICKY_D:
				sequence_TrickyD(context, (TrickyD) semanticObject); 
				return; 
			case ComplexrewritetestPackage.TRICKY_E:
				sequence_TrickyE(context, (TrickyE) semanticObject); 
				return; 
			case ComplexrewritetestPackage.TRICKY_F:
				sequence_TrickyF(context, (TrickyF) semanticObject); 
				return; 
			case ComplexrewritetestPackage.TRICKY_G:
				sequence_TrickyG(context, (TrickyG) semanticObject); 
				return; 
			case ComplexrewritetestPackage.TRICKY_G1:
				sequence_TrickyG1(context, (TrickyG1) semanticObject); 
				return; 
			case ComplexrewritetestPackage.TRICKY_G2:
				sequence_TrickyG2(context, (TrickyG2) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Atom returns Atom
	 *
	 * Constraint:
	 *     name=ID
	 * </pre>
	 */
	protected void sequence_Atom(ISerializationContext context, Atom semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ComplexrewritetestPackage.Literals.ATOM__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ComplexrewritetestPackage.Literals.ATOM__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAtomAccess().getNameIDTerminalRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Root returns Atom
	 *     Op returns Atom
	 *     Op.Add_1_0_0 returns Atom
	 *     Op.Minus_1_1_0 returns Atom
	 *     Term returns Atom
	 *     Parens returns Atom
	 *
	 * Constraint:
	 *     (name=ID em='!'*)
	 * </pre>
	 */
	protected void sequence_Atom_Parens(ISerializationContext context, Atom semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Root returns Add
	 *     Op returns Add
	 *     Op.Add_1_0_0 returns Add
	 *     Op.Minus_1_1_0 returns Add
	 *     Term returns Add
	 *     Parens returns Add
	 *
	 * Constraint:
	 *     (addOperands+=Op_Add_1_0_0 addOperands+=Term em='!'*)
	 * </pre>
	 */
	protected void sequence_Op_Parens(ISerializationContext context, Add semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Root returns Minus
	 *     Op returns Minus
	 *     Op.Add_1_0_0 returns Minus
	 *     Op.Minus_1_1_0 returns Minus
	 *     Term returns Minus
	 *     Parens returns Minus
	 *
	 * Constraint:
	 *     (minusOperands+=Op_Minus_1_1_0 minusOperands+=Term em='!'*)
	 * </pre>
	 */
	protected void sequence_Op_Parens(ISerializationContext context, Minus semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TrickyB returns TrickyB
	 *
	 * Constraint:
	 *     ((name=ID type+=INT type+=INT+) | type+=INT+)?
	 * </pre>
	 */
	protected void sequence_TrickyB(ISerializationContext context, TrickyB semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TrickyC returns C1
	 *     TrickyC.C2_3_0 returns C1
	 *     TrickyC.C3_4_0 returns C1
	 *
	 * Constraint:
	 *     x=TrickyC_C1_2_0
	 * </pre>
	 */
	protected void sequence_TrickyC(ISerializationContext context, C1 semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ComplexrewritetestPackage.Literals.C1__X) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ComplexrewritetestPackage.Literals.C1__X));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTrickyCAccess().getC1XAction_2_0(), semanticObject.getX());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TrickyC returns C2
	 *     TrickyC.C3_4_0 returns C2
	 *
	 * Constraint:
	 *     y=TrickyC_C2_3_0
	 * </pre>
	 */
	protected void sequence_TrickyC(ISerializationContext context, C2 semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ComplexrewritetestPackage.Literals.C2__Y) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ComplexrewritetestPackage.Literals.C2__Y));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTrickyCAccess().getC2YAction_3_0(), semanticObject.getY());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TrickyC returns C3
	 *
	 * Constraint:
	 *     z=TrickyC_C3_4_0
	 * </pre>
	 */
	protected void sequence_TrickyC(ISerializationContext context, C3 semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ComplexrewritetestPackage.Literals.C3__Z) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ComplexrewritetestPackage.Literals.C3__Z));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTrickyCAccess().getC3ZAction_4_0(), semanticObject.getZ());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TrickyC returns TrickyC
	 *     TrickyC.C1_2_0 returns TrickyC
	 *     TrickyC.C2_3_0 returns TrickyC
	 *     TrickyC.C3_4_0 returns TrickyC
	 *
	 * Constraint:
	 *     name=ID
	 * </pre>
	 */
	protected void sequence_TrickyC(ISerializationContext context, TrickyC semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ComplexrewritetestPackage.Literals.TRICKY_C__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ComplexrewritetestPackage.Literals.TRICKY_C__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTrickyCAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TrickyD returns TrickyD
	 *
	 * Constraint:
	 *     ((name+=INT foo=STRING type+=ID ((name+=INT type+=ID type+=ID+) | type+=ID+)) | (name+=INT type+=ID type+=ID+) | type+=ID+)?
	 * </pre>
	 */
	protected void sequence_TrickyD(ISerializationContext context, TrickyD semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TrickyE returns TrickyE
	 *
	 * Constraint:
	 *     ((name+=INT foo+=STRING type+=ID)* (name+=INT type+=ID)*)
	 * </pre>
	 */
	protected void sequence_TrickyE(ISerializationContext context, TrickyE semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TrickyF returns TrickyF
	 *
	 * Constraint:
	 *     ((name+=ID type+=INT)* (name+=ID | type+=INT))
	 * </pre>
	 */
	protected void sequence_TrickyF(ISerializationContext context, TrickyF semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TrickyG1 returns TrickyG1
	 *     TrickyG2 returns TrickyG1
	 *
	 * Constraint:
	 *     (vals+=TrickyG2 vals+=TrickyG2*)
	 * </pre>
	 */
	protected void sequence_TrickyG1(ISerializationContext context, TrickyG1 semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     TrickyG2 returns TrickyG2
	 *
	 * Constraint:
	 *     val=INT
	 * </pre>
	 */
	protected void sequence_TrickyG2(ISerializationContext context, TrickyG2 semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ComplexrewritetestPackage.Literals.TRICKY_G2__VAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ComplexrewritetestPackage.Literals.TRICKY_G2__VAL));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTrickyG2Access().getValINTTerminalRuleCall_1_0(), semanticObject.getVal());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Root returns TrickyG
	 *     TrickyG returns TrickyG
	 *
	 * Constraint:
	 *     tree=TrickyG1
	 * </pre>
	 */
	protected void sequence_TrickyG(ISerializationContext context, TrickyG semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ComplexrewritetestPackage.Literals.TRICKY_G__TREE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ComplexrewritetestPackage.Literals.TRICKY_G__TREE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTrickyGAccess().getTreeTrickyG1ParserRuleCall_1_0(), semanticObject.getTree());
		feeder.finish();
	}
	
	
}
