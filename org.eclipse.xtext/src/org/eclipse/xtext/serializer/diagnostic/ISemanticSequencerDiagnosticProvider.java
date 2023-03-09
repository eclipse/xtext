/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.diagnostic;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraint;
import org.eclipse.xtext.serializer.analysis.ISemanticSequencerNfaProvider.ISemState;
import org.eclipse.xtext.serializer.sequencer.BacktrackingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.BacktrackingSemanticSequencer.SerializableObject;
import org.eclipse.xtext.util.formallang.Nfa;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(SequencerDiagnosticProvider.class)
public interface ISemanticSequencerDiagnosticProvider {

	String INVALID_CONTEXT_OR_TYPE = "invalid context or type";
	String FEATURE_VALUE_MISSING = "feature value missing";
	String BACKTRACKING_FAILED = "backtracking failed";

	/**
	 * @deprecated use {@link #createInvalidContextOrTypeDiagnostic(EObject, ISerializationContext)}
	 */
	@Deprecated
	ISerializationDiagnostic createInvalidContextOrTypeDiagnostic(EObject semanticObject, EObject context);

	ISerializationDiagnostic createInvalidContextOrTypeDiagnostic(EObject semanticObject, ISerializationContext context);

	ISerializationDiagnostic createFeatureValueMissing(EObject semanticObject, EStructuralFeature feature);

	/**
	 * @deprecated use {@link #createBacktrackingFailedDiagnostic(BacktrackingSemanticSequencer.SerializableObject, ISerializationContext, IGrammarConstraintProvider.IConstraint)}
	 */
	@Deprecated
	ISerializationDiagnostic createBacktrackingFailedDiagnostic(SerializableObject semanticObject, EObject context,
			Nfa<ISemState> nfa);

	ISerializationDiagnostic createBacktrackingFailedDiagnostic(SerializableObject obj, ISerializationContext ctx,
			IConstraint constraint);
}
