/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import java.util.Stack;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.serializer.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.ISyntacticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.IPDAAbsorberState;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.IPDAEmitterState;

/**
 * @author meysholdt - Initial contribution and API
 */
public class SyntacticSequencerDiagnosticProvider implements ISyntacticSequencerDiagnosticProvider {

	public ISerializationDiagnostic createInvalidFollowingAbsorberDiagnostic(IPDAAbsorberState from,
			AbstractElement to, boolean toReturning) {
		return null;
	}

	public ISerializationDiagnostic createUnexpectedStackStateDiagnostic(IPDAEmitterState toConsume,
			Stack<RuleCall> stack) {
		return null;
	}

}
