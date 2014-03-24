/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.findrefs;

import static com.google.common.collect.Lists.*;
import static java.util.Collections.*;

import java.io.IOException;
import java.util.Queue;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.ui.editor.findrefs.DefaultReferenceFinder;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder;
import org.eclipse.xtext.ui.editor.findrefs.SimpleLocalResourceAccess;
import org.eclipse.xtext.ui.tests.refactoring.RefactoringTestLanguageStandaloneSetup;
import org.eclipse.xtext.ui.tests.refactoring.refactoring.RefactoringPackage;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Holger Schill
 */
//TODO these tests fail on Windows, it's not yet clear why
public class DefaultReferenceFinderTest extends AbstractXtextTests {

	private ResourceSet resourceSet;
	private Resource resource;
	private EObject elementA;
	private EObject elementB;
	private EObject elementC;

	private DefaultReferenceFinder referenceFinder;
	private CheckingAcceptor acceptor;
	private IReferenceFinder.ILocalResourceAccess localResourceAccess;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(RefactoringTestLanguageStandaloneSetup.class);
		resourceSet = get(XtextResourceSet.class);
		resource = loadResource("test.refactoringtestlanguage", "A { B { ref A } } C");
		elementA = resource.getContents().get(0).eContents().get(0);
		elementB = elementA.eContents().get(0);
		elementC = resource.getContents().get(0).eContents().get(1);
		resourceSet.getResources().add(resource);

		ResourceSetBasedResourceDescriptions resourceDescriptions = get(ResourceSetBasedResourceDescriptions.class);
		resourceDescriptions.setContext(resourceSet);
		referenceFinder = new DefaultReferenceFinder(resourceDescriptions, get(IResourceServiceProvider.Registry.class));
		localResourceAccess = new SimpleLocalResourceAccess(resourceSet);
		acceptor = new CheckingAcceptor();
	}

	protected Resource loadResource(String pathName, String content) throws IOException {
		Resource resource = resourceSet.createResource(URI.createFileURI("/" + pathName));
		resource.load(new StringInputStream(content), null);
		assertTrue(resource.getErrors().isEmpty());
		return resource;
	}

	@Test public void testLocalRefs() throws Exception {
		acceptor.expect(new DefaultReferenceDescription(elementB, elementA,
				RefactoringPackage.Literals.ELEMENT__REFERENCED, 0, EcoreUtil.getURI(elementB)));
		findAllRefs(elementA, localResourceAccess);
		acceptor.assertFinished();

		acceptor.expect(new DefaultReferenceDescription(elementB, elementA,
				RefactoringPackage.Literals.ELEMENT__REFERENCED, 0, EcoreUtil.getURI(elementB)));
		findRefs(elementA, resource, localResourceAccess);
		acceptor.assertFinished();
	}

	@Test public void testExternalRefs() throws Exception {
		Resource refResource = loadResource("ref.refactoringtestlanguage", "D { ref C }");
		EObject elementD = refResource.getContents().get(0).eContents().get(0);

		findRefs(elementC, resource, localResourceAccess);
		acceptor.assertFinished();

		acceptor.expect(new DefaultReferenceDescription(elementD, elementC,
				RefactoringPackage.Literals.ELEMENT__REFERENCED, 0, EcoreUtil.getURI(elementD)));
		findAllRefs(elementC, localResourceAccess);
		acceptor.assertFinished();

		acceptor.expect(new DefaultReferenceDescription(elementD, elementC,
				RefactoringPackage.Literals.ELEMENT__REFERENCED, 0, EcoreUtil.getURI(elementD)));
		findRefs(elementC, refResource, localResourceAccess);
		acceptor.assertFinished();
	}

	@Test public void testLocalAndExternalRefs() throws Exception {
		Resource refResource = loadResource("ref.refactoringtestlanguage", "D { ref A }");
		EObject elementD = refResource.getContents().get(0).eContents().get(0);

		acceptor.expect(new DefaultReferenceDescription(elementB, elementA,
				RefactoringPackage.Literals.ELEMENT__REFERENCED, 0, EcoreUtil.getURI(elementB)));
		findRefs(elementA, resource, localResourceAccess);
		acceptor.assertFinished();

		acceptor.expect(new DefaultReferenceDescription(elementB, elementA,
				RefactoringPackage.Literals.ELEMENT__REFERENCED, 0, EcoreUtil.getURI(elementB)));
		acceptor.expect(new DefaultReferenceDescription(elementD, elementA,
				RefactoringPackage.Literals.ELEMENT__REFERENCED, 0, EcoreUtil.getURI(elementD)));
		findAllRefs(elementA, localResourceAccess);
		acceptor.assertFinished();

		acceptor.expect(new DefaultReferenceDescription(elementD, elementA,
				RefactoringPackage.Literals.ELEMENT__REFERENCED, 0, EcoreUtil.getURI(elementD)));
		findRefs(elementA, refResource, localResourceAccess);
		acceptor.assertFinished();
	}

	@Test public void testExcludeLocalRefs() throws Exception {
		Resource refResource = loadResource("ref.refactoringtestlanguage", "D { ref A }");
		EObject elementD = refResource.getContents().get(0).eContents().get(0);

		findRefs(elementA, resource, null);
		acceptor.assertFinished();

		acceptor.expect(new DefaultReferenceDescription(elementD, elementA,
				RefactoringPackage.Literals.ELEMENT__REFERENCED, 0, EcoreUtil.getURI(elementD)));
		findAllRefs(elementA, null);
		acceptor.assertFinished();

		acceptor.expect(new DefaultReferenceDescription(elementD, elementA,
				RefactoringPackage.Literals.ELEMENT__REFERENCED, 0, EcoreUtil.getURI(elementD)));
		findRefs(elementA, refResource, null);
		acceptor.assertFinished();
	}

	protected void findAllRefs(EObject target, IReferenceFinder.ILocalResourceAccess localResourceAccess) {
		referenceFinder.findAllReferences(singleton(EcoreUtil2.getPlatformResourceOrNormalizedURI(target)), localResourceAccess,
				acceptor, null);
	}

	protected void findRefs(EObject target, Resource sourceResource, IReferenceFinder.ILocalResourceAccess localResourceAccess) {
		referenceFinder.findReferences(singleton(EcoreUtil2.getPlatformResourceOrNormalizedURI(target)),
				singleton(sourceResource.getURI()), localResourceAccess, acceptor, null);
	}

	public static class CheckingAcceptor implements IAcceptor<IReferenceDescription> {

		private Queue<IReferenceDescription> expectationQueue = newLinkedList();

		public void expect(IReferenceDescription expected) {
			expectationQueue.add(expected);
		}

		public void assertFinished() {
			assertTrue(expectationQueue.isEmpty());
		}

		public void accept(IReferenceDescription description) {
			IReferenceDescription nextExpected = expectationQueue.poll();
			assertNotNull(nextExpected);
			assertEquals(nextExpected.getContainerEObjectURI(), description.getContainerEObjectURI());
			assertEquals(nextExpected.getSourceEObjectUri(), description.getSourceEObjectUri());
			assertEquals(nextExpected.getTargetEObjectUri(), description.getTargetEObjectUri());
			assertEquals(nextExpected.getIndexInList(), description.getIndexInList());
			assertEquals(nextExpected.getEReference(), description.getEReference());
		}

	}
}
