/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.diagnostic;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynAbsorberState;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynState;
import org.eclipse.xtext.serializer.impl.RCStack;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */

@ImplementedBy(SyntacticSequencerDiagnosticProvider.class)
public interface ISyntacticSequencerDiagnosticProvider {
	ISerializationDiagnostic createInvalidFollowingAbsorberDiagnostic(EObject context, EObject semanticObject,
			ISynAbsorberState from, AbstractElement to);

	ISerializationDiagnostic createUnexpectedStackStateDiagnostic(ISynState toConsume, RCStack stack);

	ISerializationDiagnostic createUnexpectedEmitterDiagnostic(ISynNavigable currentState, AbstractElement target,
			RCStack stack);
}
