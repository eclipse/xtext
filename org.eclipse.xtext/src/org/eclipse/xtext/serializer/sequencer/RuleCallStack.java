/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.util.AbstractLinkedStack;

public class RuleCallStack extends AbstractLinkedStack<RuleCallStack, RuleCall> {

	@Override
	protected RuleCallStack createStack() {
		return new RuleCallStack();
	}

	@Override
	public String elementToStr(RuleCall value) {
		if (value == null)
			return "(null)";
		return new GrammarElementTitleSwitch().showAssignments().doSwitch(value);
	}

}