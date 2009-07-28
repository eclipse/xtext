/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.templates;

import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.common.editor.contentassist.DefaultFollowElementCalculator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FollowElementCalculatorForTemplates extends DefaultFollowElementCalculator implements IFollowElementCalculatorForTemplates {

	@Override
	protected FirstSetCalculator createFirstSetCalculator(IFollowElementAcceptor acceptor) {
		return new FirstSetCalculatorForTemplates(acceptor);
	}
	
	public static class FirstSetCalculatorForTemplates extends FirstSetCalculator {

		public FirstSetCalculatorForTemplates(IFollowElementAcceptor acceptor) {
			super(acceptor);
		}
		@Override
		public FirstSetCalculator caseRuleCall(RuleCall ruleCall) {
			acceptor.accept(ruleCall);
			return super.caseRuleCall(ruleCall);
		}
	}
}
