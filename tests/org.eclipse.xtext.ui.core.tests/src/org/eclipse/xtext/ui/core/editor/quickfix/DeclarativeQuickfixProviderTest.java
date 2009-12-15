/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.quickfix;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.IssueContext;
import org.eclipse.xtext.validation.IssueResolution;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DeclarativeQuickfixProviderTest extends TestCase implements ILanguageResourceHelper {

	private static final int DUMMY_CODE = 42;

	public void testHasNoResolutionsForOutdatedSignatures() throws Exception {
		AbstractDeclarativeQuickfixProvider provider = new AbstractDeclarativeQuickfixProvider() {
			@Fix(code = DUMMY_CODE)
			@SuppressWarnings("unused")
			public void outdatedSignature(EObject obj, IMarker marker) {
			}
		};
		
		provider.setLanguageResourceHelper(this);
		assertFalse(provider.hasResolutionFor(DUMMY_CODE+1));
		assertFalse(provider.hasResolutionFor(DUMMY_CODE));
	}

	public void testHasResolutions() throws Exception {
		AbstractDeclarativeQuickfixProvider provider = new AbstractDeclarativeQuickfixProvider() {
			@Fix(code = DUMMY_CODE)
			@SuppressWarnings("unused")
			public void outdatedSignature(EObject obj, IssueContext context) {
			}
		};
		
		provider.setLanguageResourceHelper(this);
		assertFalse(provider.hasResolutionFor(DUMMY_CODE+1));
		assertTrue(provider.hasResolutionFor(DUMMY_CODE));
	}

	public void testGetResolutions() throws Exception {
		AbstractDeclarativeQuickfixProvider generator = new AbstractDeclarativeQuickfixProvider() {
			@Fix(code = DUMMY_CODE, label = "fixError1")
			@SuppressWarnings("unused")
			public void fixError1(EObject obj, IssueContext context) {
			}

			@Fix(code = DUMMY_CODE, label = "fixError2")
			@SuppressWarnings("unused")
			public void fixError2(EPackage obj, IssueContext context) {
			}

			@Fix(code = DUMMY_CODE, label = "fixError3")
			@SuppressWarnings("unused")
			public void fixError3(EClass obj, IssueContext context) {
			}
		};
		generator.setLanguageResourceHelper(this);
		Iterable<IssueResolution> resolutionsIterable = generator.getResolutions(
				createIssueContext(EcoreFactory.eINSTANCE.createEObject(), 0));
		assertFalse(resolutionsIterable.iterator().hasNext());

		ArrayList<IssueResolution> resolutions = new ArrayList<IssueResolution>(generator.getResolutions(
				createIssueContext(EcoreFactory.eINSTANCE.createEClass(), DUMMY_CODE)));
		assertEquals(2, resolutions.size());
		assertEquals("fixError1", resolutions.get(0).getLabel());
		assertEquals("fixError3", resolutions.get(1).getLabel());
	}

	private IssueContext createIssueContext(EObject context, Integer code) {
		Issue.IssueImpl issue = new Issue.IssueImpl();
		issue.setCode(code);
		if(context != null)
			issue.setUriToProblem(EcoreUtil.getURI(context));
		return new IssueContext.IssueContextImpl(context, issue, "");
	}
	
	public boolean isLanguageResource(IResource resource) {
		return resource == null;
	}

}
