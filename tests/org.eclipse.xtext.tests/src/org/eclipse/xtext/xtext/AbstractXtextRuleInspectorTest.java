/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
}
