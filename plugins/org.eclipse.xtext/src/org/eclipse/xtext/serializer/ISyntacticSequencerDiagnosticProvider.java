/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import java.util.Stack;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.IPDAAbsorberState;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.IPDAEmitterState;
import org.eclipse.xtext.serializer.impl.SyntacticSequencerDiagnosticProvider;

import com.google.inject.ImplementedBy;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */

@ImplementedBy(SyntacticSequencerDiagnosticProvider.class)
public interface ISyntacticSequencerDiagnosticProvider {
	ISerializationDiagnostic createInvalidFollowingAbsorberDiagnostic(IPDAAbsorberState from, AbstractElement to,
			boolean toReturning);

	ISerializationDiagnostic createUnexpectedStackStateDiagnostic(IPDAEmitterState toConsume, Stack<RuleCall> stack);
}
