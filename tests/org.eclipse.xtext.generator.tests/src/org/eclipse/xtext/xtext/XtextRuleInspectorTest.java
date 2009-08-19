/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class XtextRuleInspectorTest<Result, Rule extends AbstractRule> extends AbstractXtextTests implements ValidationMessageAcceptor {

	protected List<Triple<String, EObject, Integer>> warnings;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
		warnings = Lists.newArrayList();
	}
	
	@Override
	protected void tearDown() throws Exception {
		warnings = null;
		super.tearDown();
	}
	
	public void validateRule(Rule rule) {
		assertNotNull("rule", rule);
		warnings.clear();
		XtextRuleInspector<Result, Rule> inspector = createInspector();
		inspector.inspect(rule);
	}
	
	protected abstract XtextRuleInspector<Result, Rule> createInspector();

	public void acceptError(String message, EObject object, Integer feature) {
		fail("unexpected call to acceptWarning");		
	}

	public void acceptWarning(String message, EObject object, Integer feature) {
		Triple<String,EObject,Integer> warning = Tuples.create(message, object, feature);
		warnings.add(warning);
	}
	
	protected Grammar getGrammar(String grammar) throws Exception {
		XtextResource resourceFromString = getResourceFromString(grammar);
		assertTrue(resourceFromString.getErrors().toString(), resourceFromString.getErrors().isEmpty());
		return (Grammar) resourceFromString.getContents().get(0);
	}
}
