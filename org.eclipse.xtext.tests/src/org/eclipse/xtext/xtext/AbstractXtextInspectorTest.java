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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractXtextInspectorTest extends AbstractXtextTests implements ValidationMessageAcceptor  {

	protected List<Triple<String, EObject, EStructuralFeature>> warnings;
	protected List<Triple<String, EObject, EStructuralFeature>> errors;
	protected List<Triple<String, EObject, EStructuralFeature>> infos;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
		warnings = Lists.newArrayList();
		errors = Lists.newArrayList();
		infos = Lists.newArrayList();
	}

	@Override
	public void tearDown() throws Exception {
		infos = null;
		warnings = null;
		errors = null;
		super.tearDown();
	}
	
	protected abstract boolean isExpectingErrors();
	
	protected abstract boolean isExpectingWarnings();
	
	protected abstract boolean isExpectingInfos();

	@Override
	public void acceptError(String message, EObject object, EStructuralFeature feature, int index, String code, String... issueData) {
		if (!isExpectingErrors())
			fail("unexpected call to acceptError");
		Triple<String,EObject,EStructuralFeature> error = Tuples.create(message, object, feature);
		errors.add(error);
	}

	@Override
	public void acceptWarning(String message, EObject object, EStructuralFeature feature, int index, String code, String... issueData) {
		if (!isExpectingWarnings())
			fail("unexpected call to acceptWarning");
		Triple<String,EObject,EStructuralFeature> warning = Tuples.create(message, object, feature);
		warnings.add(warning);
	}
	
	@Override
	public void acceptInfo(String message, EObject object, EStructuralFeature feature, int index, String code, String... issueData) {
		if (!isExpectingInfos())
			fail("unexpected call to acceptInfo");
		Triple<String,EObject,EStructuralFeature> warning = Tuples.create(message, object, feature);
		infos.add(warning);
	}

	protected Grammar getGrammar(String grammar) throws Exception {
		XtextResource resourceFromString = getResourceFromString(grammar);
		assertTrue(resourceFromString.getErrors().toString(), resourceFromString.getErrors().isEmpty());
		return (Grammar) resourceFromString.getContents().get(0);
	}
	
	protected Grammar getGrammarWithErrors(String grammar, int expectedErrors) throws Exception {
		XtextResource resourceFromString = getResourceFromStringAndExpect(grammar, expectedErrors);
		return (Grammar) resourceFromString.getContents().get(0);
	}

	@Override
	public void acceptError(String message, EObject object, int offset, int length, String code, String... issueData) {
		fail(message);
	}
	
	@Override
	public void acceptWarning(String message, EObject object, int offset, int length, String code, String... issueData) {
		fail(message);
	}
	
	@Override
	public void acceptInfo(String message, EObject object, int offset, int length, String code, String... issueData) {
		fail(message);
	}
	
}
