/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.diagnostic;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.IConstraintContext;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(SequencerDiagnosticProvider.class)
public interface ISemanticSequencerDiagnosticProvider {

	ISerializationDiagnostic createInvalidContextOrTypeDiagnostic(EObject semanticObject, EObject context,
			List<IConstraintContext> constraints, Grammar grammar);
}
