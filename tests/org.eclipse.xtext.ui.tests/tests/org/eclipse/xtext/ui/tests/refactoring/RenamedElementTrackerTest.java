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

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.IRenamedElementTracker;
import org.eclipse.xtext.ui.refactoring.impl.RenamedElementTracker;
import org.eclipse.xtext.ui.tests.editor.contentassist.BacktrackingContentAssistTestLanguageStandaloneSetup;
import org.eclipse.xtext.ui.tests.refactoring.refactoring.Element;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author koehnlein - Initial contribution and API
 */
public class RenamedElementTrackerTest extends AbstractXtextTests {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(getSetup());
	}

	public static class NameBasedFragmentProvider implements IFragmentProvider {

		public String getFragment(EObject obj, Fallback fallback) {
			if (obj instanceof Element)
				return ((Element) obj).getName();
			else
				return fallback.getFragment(obj);
		}

		public EObject getEObject(Resource resource, String fragment, Fallback fallback) {
			for (TreeIterator<EObject> i = resource.getAllContents(); i.hasNext();) {
				EObject obj = i.next();
				if (obj instanceof Element && fragment.equals(((Element) obj).getName()))
					return obj;
			}
			return fallback.getEObject(fragment);
		}

	}

	public ISetup getSetup() {
		return new BacktrackingContentAssistTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new RefactoringTestLanguageRuntimeModule() {
					@Override
					public Class<? extends IFragmentProvider> bindIFragmentProvider() {
						return NameBasedFragmentProvider.class;
					}
				});
			}
		};
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
		IRenameStrategy renameStrategy = get(IRenameStrategy.Provider.class).get(elementB);

		IRenamedElementTracker renamedElementTracker = new RenamedElementTracker();
		Map<URI, URI> original2newElementURIs = renamedElementTracker.renameAndTrack(renamedElementURIs, newName,
				resource.getResourceSet(), renameStrategy, null);

		assertEquals(newName, elementB.getName());
		assertEquals(2, original2newElementURIs.size());
		assertEquals(resourceURI.appendFragment(newName), original2newElementURIs.get(uriB));
		assertEquals(uriC, original2newElementURIs.get(uriC));
	}
}
