/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.diagnostic;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.serializer.analysis.ISemanticSequencerNfaProvider.ISemState;
import org.eclipse.xtext.util.formallang.Nfa;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(SequencerDiagnosticProvider.class)
public interface ISemanticSequencerDiagnosticProvider {

	ISerializationDiagnostic createInvalidContextOrTypeDiagnostic(EObject semanticObject, EObject context);

	ISerializationDiagnostic createFeatureValueMissing(EObject semanticObject, EStructuralFeature feature);

	ISerializationDiagnostic createBacktrackingFailedDiagnostic(EObject semanticObject, EObject context,
			Nfa<ISemState> nfa);
}
