/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring;

import static com.google.common.collect.Lists.*;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.IRenamedElementTracker;
import org.eclipse.xtext.ui.refactoring.impl.RenamedElementTracker;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.tests.refactoring.refactoring.Element;
import org.eclipse.xtext.ui.tests.refactoring.resource.RefactoringTestLanguageFragmentProvider;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class RenamedElementTrackerTest extends AbstractXtextTests {

	@Inject 
	private RefactoringTestLanguageFragmentProvider fragmentProvider;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setInjector(Activator.getInstance().getInjector("org.eclipse.xtext.ui.tests.refactoring.RefactoringTestLanguage"));
		getInjector().injectMembers(this);
		fragmentProvider.setUseNames(true);
	}
	
	@Override
	protected void tearDown() throws Exception {
		fragmentProvider.setUseNames(false);
		super.tearDown();
	}
	
	public void testResolveElements() throws Exception {
		URI resourceURI = URI.createFileURI("testresource.refactoringtestlanguage");
		String textualModel = "A { B { C { ref A.B } } ref B }";
		XtextResource resource = getResource(textualModel, resourceURI.toString());
		Element elementA = (Element) resource.getContents().get(0).eContents().get(0);
		Element elementB = elementA.getContained().get(0);
		Element elementC = elementB.getContained().get(0);

		URI uriB = EcoreUtil.getURI(elementB);
		URI uriC = EcoreUtil.getURI(elementC);
		String newName = "newB";

		List<URI> renamedElementURIs = newArrayList(uriB, uriC);
		IRenameStrategy renameStrategy = getInjector().getInstance(IRenameStrategy.Provider.class).get(elementB, null);

		IRenamedElementTracker renamedElementTracker = new RenamedElementTracker();
		Map<URI, URI> original2newElementURIs = renamedElementTracker.renameAndTrack(renamedElementURIs, newName,
				resource.getResourceSet(), renameStrategy, null);

		assertEquals("B", elementB.getName());
		assertEquals(2, original2newElementURIs.size());
		assertEquals(resourceURI.appendFragment(newName), original2newElementURIs.get(uriB));
		assertEquals(uriC, original2newElementURIs.get(uriC));
	}
}
