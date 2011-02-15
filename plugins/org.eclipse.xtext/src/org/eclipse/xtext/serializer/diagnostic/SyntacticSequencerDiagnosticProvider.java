/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.diagnostic;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynAbsorberState;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynState;
import org.eclipse.xtext.serializer.impl.RCStack;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SyntacticSequencerDiagnosticProvider implements ISyntacticSequencerDiagnosticProvider {

	public ISerializationDiagnostic createInvalidFollowingAbsorberDiagnostic(ISynAbsorberState from,
			AbstractElement to, boolean toReturning) {
		return null;
	}

	public ISerializationDiagnostic createUnexpectedStackStateDiagnostic(ISynState toConsume, RCStack stack) {
		return null;
	}

	public ISerializationDiagnostic createUnexpectedEmitterDiagnostic(ISynNavigable currentState,
			AbstractElement target, RCStack stack) {
		return null;
	}

}
