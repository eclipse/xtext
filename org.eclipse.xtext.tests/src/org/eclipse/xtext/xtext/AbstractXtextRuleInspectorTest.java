/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.xtext.AbstractRule;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractXtextRuleInspectorTest<Result, Rule extends AbstractRule> extends AbstractXtextInspectorTest {

	public void validateRule(Rule rule) {
		assertNotNull("rule", rule);
		warnings.clear();
		XtextRuleInspector<Result, Rule> inspector = createInspector();
		inspector.inspect(rule);
	}
	
	protected abstract XtextRuleInspector<Result, Rule> createInspector();
	
	@Override
	protected boolean isExpectingErrors() {
		return false;
	}
	
	@Override
	protected boolean isExpectingWarnings() {
		return true;
	}
	
	@Override
	protected boolean isExpectingInfos() {
		return false;
	}
}
