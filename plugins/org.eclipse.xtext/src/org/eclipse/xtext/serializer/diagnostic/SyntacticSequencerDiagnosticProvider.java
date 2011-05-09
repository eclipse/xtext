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
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementFullTitleSwitch;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynAbsorberState;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynState;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.impl.RuleCallStack;

import com.google.common.collect.Lists;
import com.google.inject.internal.Join;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SyntacticSequencerDiagnosticProvider implements ISyntacticSequencerDiagnosticProvider {

	public ISerializationDiagnostic createUnexpectedStackStateDiagnostic(ISynState toConsume, RuleCallStack stack) {
		return null;
	}

	public ISerializationDiagnostic createUnexpectedEmitterDiagnostic(ISynNavigable currentState,
			AbstractElement target, RuleCallStack stack) {
		return null;
	}

	public ISerializationDiagnostic createInvalidFollowingAbsorberDiagnostic(EObject context, EObject semanticObject,
			ISynAbsorberState from, AbstractElement to) {
		String fromName = from.toString();
		String toName = to == null ? "stop" : new GrammarElementFullTitleSwitch().doSwitch(to);

		List<String> targets = Lists.newArrayList();
		for (ISynTransition trans : from.getOutTransitions())
			targets.add(trans.getTarget().toString());

		StringBuilder msg = new StringBuilder();
		msg.append("State '" + toName + "' may not follow '" + fromName + "'.\n");
		msg.append("Valid followers are: " + Join.join(", ", targets));

		return new SerializationDiagnostic(semanticObject, context, msg.toString());
	}
}
