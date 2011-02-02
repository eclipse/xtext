/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.findrefs;

import static com.google.common.collect.Lists.*;
import static java.util.Collections.*;

import java.io.IOException;
import java.util.Queue;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.ui.editor.findrefs.DefaultReferenceFinder;
import org.eclipse.xtext.ui.editor.findrefs.ResourceSetLocalContextProvider;
import org.eclipse.xtext.ui.tests.refactoring.RefactoringTestLanguageStandaloneSetup;
import org.eclipse.xtext.ui.tests.refactoring.refactoring.RefactoringPackage;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Holger Schill
 */
public class DefaultReferenceFinderTest extends AbstractXtextTests {

	private ResourceSet resourceSet;
	private Resource resource;
	private EObject elementA;
	private EObject elementB;
	private EObject elementC;

	private DefaultReferenceFinder referenceFinder;
	private MockAcceptor acceptor;
	private ResourceSetLocalContextProvider localContextProvider;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(RefactoringTestLanguageStandaloneSetup.class);
		resourceSet = get(XtextResourceSet.class);
		resource = loadResource("test.refactoringtestlanguage", "A { B { ref A } } C");
		elementA = resource.getContents().get(0).eContents().get(0);
		elementB = elementA.eContents().get(0);
		elementC = resource.getContents().get(0).eContents().get(1);

		ResourceSetBasedResourceDescriptions resourceDescriptions = get(ResourceSetBasedResourceDescriptions.class);
		resourceDescriptions.setContext(resourceSet);
		referenceFinder = new DefaultReferenceFinder(resourceDescriptions);
		localContextProvider = new ResourceSetLocalContextProvider(resourceSet);
		acceptor = new MockAcceptor();
	}

	protected Resource loadResource(String pathName, String content) throws IOException {
		Resource resource = resourceSet.createResource(URI.createFileURI("/" + pathName));
		resource.load(new StringInputStream(content), null);
		assertTrue(resource.getErrors().isEmpty());
		return resource;
	}

	public void testLocalRefs() throws Exception {
		acceptor.expect(new DefaultReferenceDescription(elementB, elementA,
				RefactoringPackage.Literals.ELEMENT__REFERENCED, 0, EcoreUtil.getURI(elementB)));
		referenceFinder.findLocalReferences(elementA.eResource(), elementA, acceptor, new NullProgressMonitor());
		acceptor.assertFinished();
		referenceFinder.findIndexedReferences(singleton(EcoreUtil.getURI(elementA)), acceptor, new NullProgressMonitor());
		acceptor.assertFinished();

		acceptor.expect(new DefaultReferenceDescription(elementB, elementA,
				RefactoringPackage.Literals.ELEMENT__REFERENCED, 0, EcoreUtil.getURI(elementB)));
		referenceFinder.findAllReferences(EcoreUtil.getURI(elementA), localContextProvider, acceptor,
				new NullProgressMonitor());
		acceptor.assertFinished();
	}

	public void testIndexedRefs() throws Exception {
		Resource refResource = loadResource("ref.refactoringtestlanguage", "D { ref C }");
		EObject elementD = refResource.getContents().get(0).eContents().get(0);
		
		referenceFinder.findLocalReferences(elementC.eResource(), elementC, acceptor, new NullProgressMonitor());
		acceptor.assertFinished();
		acceptor.expect(new DefaultReferenceDescription(elementD, elementC,
				RefactoringPackage.Literals.ELEMENT__REFERENCED, 0, EcoreUtil.getURI(elementD)));
		referenceFinder.findIndexedReferences(singleton(EcoreUtil.getURI(elementC)), acceptor, new NullProgressMonitor());
		acceptor.assertFinished();

		acceptor.expect(new DefaultReferenceDescription(elementD, elementC,
				RefactoringPackage.Literals.ELEMENT__REFERENCED, 0, EcoreUtil.getURI(elementD)));
		referenceFinder.findAllReferences(EcoreUtil.getURI(elementC), localContextProvider, acceptor,
				new NullProgressMonitor());
		acceptor.assertFinished();
	}

	public void testLocalAndIndexed()  throws Exception {
		Resource refResource = loadResource("ref.refactoringtestlanguage", "D { ref A }");
		EObject elementD = refResource.getContents().get(0).eContents().get(0);
		
		acceptor.expect(new DefaultReferenceDescription(elementB, elementA,
				RefactoringPackage.Literals.ELEMENT__REFERENCED, 0, EcoreUtil.getURI(elementB)));
		referenceFinder.findLocalReferences(elementA.eResource(), elementA, acceptor, new NullProgressMonitor());
		acceptor.assertFinished();
		acceptor.expect(new DefaultReferenceDescription(elementD, elementA,
				RefactoringPackage.Literals.ELEMENT__REFERENCED, 0, EcoreUtil.getURI(elementD)));
		referenceFinder.findIndexedReferences(singleton(EcoreUtil.getURI(elementA)), acceptor, new NullProgressMonitor());
		acceptor.assertFinished();

		acceptor.expect(new DefaultReferenceDescription(elementB, elementA,
				RefactoringPackage.Literals.ELEMENT__REFERENCED, 0, EcoreUtil.getURI(elementB)));
		acceptor.expect(new DefaultReferenceDescription(elementD, elementA,
				RefactoringPackage.Literals.ELEMENT__REFERENCED, 0, EcoreUtil.getURI(elementD)));
		referenceFinder.findAllReferences(EcoreUtil.getURI(elementA), localContextProvider, acceptor,
				new NullProgressMonitor());
		acceptor.assertFinished();
		
	}
	
	public static class MockAcceptor implements IAcceptor<IReferenceDescription> {

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
