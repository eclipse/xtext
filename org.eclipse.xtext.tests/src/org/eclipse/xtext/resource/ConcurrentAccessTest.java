/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.io.File;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.xtext.testing.GlobalRegistries;
import org.eclipse.xtext.testing.GlobalRegistries.GlobalStateMemento;
import org.eclipse.xtext.tests.TemporaryFolder;
import org.eclipse.xtext.util.concurrent.AbstractReadWriteAcces;
import org.eclipse.xtext.util.concurrent.IReadAccess;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ConcurrentAccessTest extends Assert {

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();
	
	private Resource resource;

	private GlobalStateMemento globalStateMemento;

	static {
		new StandaloneSetup();
	}

	@Before
	public void setUp() throws Exception {
		globalStateMemento = GlobalRegistries.makeCopyOfGlobalState();
		EPackage.Registry.INSTANCE.put(XMLTypePackage.eNS_URI, XMLTypePackage.eINSTANCE);
		ResourceSet resourceSet = new ResourceSetImpl();
		resource = new XtextResource(URI.createFileURI("something.ecore"));
		resourceSet.getResources().add(resource);
		EPackage start = EcoreFactory.eINSTANCE.createEPackage();
		resource.getContents().add(start);
		for (int i = 0; i < 100; i++) {
			File tempFile = temporaryFolder.createTempFile("Package" + i, ".ecore");
			URI fileURI = URI.createFileURI(tempFile.getAbsolutePath());
			Resource toBeProxified = resourceSet.createResource(fileURI);
			EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
			ePackage.setNsURI("http://www.test.me/" + i);
			toBeProxified.getContents().add(ePackage);
			for (int j = 0; j < 100; j++) {
				EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
				annotation.setSource("Source" + j);
				start.getEAnnotations().add(annotation);
				EClass superClass = EcoreFactory.eINSTANCE.createEClass();
				superClass.setName("SuperClass" + j);
				ePackage.getEClassifiers().add(superClass);
				annotation.getReferences().add(superClass);
			}
			toBeProxified.save(null);
		}
		EcoreUtil.resolveAll(resourceSet);
		for (int i = 100; i >= 1; i--) {
			Resource toBeProxified = resourceSet.getResources().get(i);
			toBeProxified.unload();
			resourceSet.getResources().remove(toBeProxified);
		}
	}

	@After
	public void tearDown() throws Exception {
		resource = null;
		globalStateMemento.restoreGlobalState();
	}
	
	@Test public void testDummy() {
		assertEquals(1, resource.getResourceSet().getResources().size());
		EcoreUtil.resolveAll(resource);
		assertEquals(101, resource.getResourceSet().getResources().size());
	}
	
	@Test public void testResolveSingleThreaded() {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResources().add(resource);
		assertEquals(1, resourceSet.getResources().size());
		EPackage pack = (EPackage) resource.getContents().get(0);
		doResolveAllReferences(pack);
		assertEquals(101, resourceSet.getResources().size());
	}
	
	@Ignore @Test public void testMultiThreaded() throws InterruptedException {
		ResourceSet resourceSet = new XtextResourceSet();
		resourceSet.getResources().add(resource);
		boolean wasOk = resolveAllReferencesMultithreaded((EPackage) resource.getContents().get(0));
		if (wasOk)
			assertFalse(101 == resourceSet.getResources().size());
		assertFalse("unresolvedProxy", wasOk);
	}
	
	@Test public void testMultiThreadedSynchronized() throws InterruptedException {
		ResourceSet resourceSet = new SynchronizedXtextResourceSet();
		resourceSet.getResources().add(resource);
		boolean wasOk = resolveAllReferencesMultithreaded((EPackage) resource.getContents().get(0));
		assertEquals(101, resourceSet.getResources().size());
		assertTrue("unresolvedProxy", wasOk);
	}
	
	@Ignore @Test public void testMultiThreadedUnitOfWork() throws InterruptedException {
		ResourceSet resourceSet = new XtextResourceSet();
		resourceSet.getResources().add(resource);
		boolean wasOk = resolveAllReferencesStateAccess((EPackage) resource.getContents().get(0));
		if (wasOk)
			assertFalse(101 == resourceSet.getResources().size());
		assertFalse("unresolvedProxy", wasOk);
	}
	
	@Test public void testMultiThreadedSynchronizedUnitOfWork() throws InterruptedException {
		ResourceSet resourceSet = new SynchronizedXtextResourceSet();
		resourceSet.getResources().add(resource);
		boolean wasOk = resolveAllReferencesStateAccess((EPackage) resource.getContents().get(0));
		assertEquals(101, resourceSet.getResources().size());
		assertTrue("unresolvedProxy or concurrent modification or no such element", wasOk);
	}
	
	@Ignore @Test public void testMultiThreadedListAccess() throws InterruptedException {
		XtextResourceSet resourceSet = new XtextResourceSet();
		final List<Resource> resources = resourceSet.getResources();
		List<List<Resource>> resourcesToAdd = Lists.newArrayList();
		for(int i = 0; i < 5; i++) {
			List<Resource> threadList = Lists.newArrayList();
			for(int j = 0; j < 500; j++) {
				threadList.add((new ResourceImpl(URI.createURI("file:/" + i + "_" + j + ".xmi"))));
			}
			resourcesToAdd.add(threadList);
		}
		List<Thread> threads = Lists.newArrayList();
		for (int i = 0; i < 5; i++) {
			final List<Resource> addUs = resourcesToAdd.get(i);
			threads.add(new Thread() {
				@Override
				public void run() {
					for(Resource addMe: addUs) {
						resources.add(addMe);
					}
				}
			});
		}
		for (Thread thread : threads) {
			thread.start();
		}

		for (Thread thread : threads) {
			thread.join();
		}
		assertEquals(2500, resources.size());
		assertEquals(2500, resourceSet.getURIResourceMap().size());
	}
	
	@Test public void testMultiThreadedSynchronizedListAccess() throws InterruptedException {
		XtextResourceSet resourceSet = new SynchronizedXtextResourceSet();
		final List<Resource> resources = resourceSet.getResources();
		List<List<Resource>> resourcesToAdd = Lists.newArrayList();
		for(int i = 0; i < 5; i++) {
			List<Resource> threadList = Lists.newArrayList();
			for(int j = 0; j < 500; j++) {
				threadList.add((new ResourceImpl(URI.createURI("file:/" + i + "_" + j + ".xmi"))));
			}
			resourcesToAdd.add(threadList);
		}
		List<Thread> threads = Lists.newArrayList();
		for (int i = 0; i < 5; i++) {
			final List<Resource> addUs = resourcesToAdd.get(i);
			threads.add(new Thread() {
				@Override
				public void run() {
					for(Resource addMe: addUs) {
						resources.add(addMe);
					}
				}
			});
		}
		for (Thread thread : threads) {
			thread.start();
		}

		for (Thread thread : threads) {
			thread.join();
		}
		assertEquals(2500, resources.size());
		assertEquals(2500, resourceSet.getURIResourceMap().size());
	}

	/**
	 * @return <code>true</code> if everything was ok.
	 */
	protected boolean resolveAllReferencesMultithreaded(final EPackage pack) throws InterruptedException {
		final AtomicBoolean wasExceptionOrProxy = new AtomicBoolean(false);
		List<Thread> threads = Lists.newArrayList();
		for (int i = 0; i < 3; i++) {
			threads.add(new Thread() {
				@Override
				public void run() {
					boolean failed = doResolveAllReferences(pack);
					if (failed)
						wasExceptionOrProxy.set(failed);
				}
			});
		}
		for (Thread thread : threads) {
			thread.start();
		}

		for (Thread thread : threads) {
			thread.join();
		}
		return !wasExceptionOrProxy.get();
	}
	
	/**
	 * @return <code>true</code> if everything was ok.
	 */
	protected boolean resolveAllReferencesStateAccess(final EPackage pack) throws InterruptedException {
		final IReadAccess<EPackage> stateAccess = new AbstractReadWriteAcces<EPackage>() {
			@Override
			protected EPackage getState() {
				return pack;
			}
		};
		final AtomicBoolean wasExceptionOrProxy = new AtomicBoolean(false);
		List<Thread> threads = Lists.newArrayList();
		for (int i = 0; i < 3; i++) {
			threads.add(new Thread() {
				@Override
				public void run() {
					Boolean failed = stateAccess.readOnly(new IUnitOfWork<Boolean, EPackage>() {
						@Override
						public Boolean exec(EPackage state) throws Exception {
							return doResolveAllReferences(pack);
						}
					});
					if (failed == null || failed)
						wasExceptionOrProxy.set(true);
				}
			});
		}
		for (Thread thread : threads) {
			thread.start();
		}

		for (Thread thread : threads) {
			thread.join();
		}
		return !wasExceptionOrProxy.get();
	}

	protected boolean doResolveAllReferences(final EPackage pack) {
		boolean failed = false;
		try {
			for(EAnnotation annotation: pack.getEAnnotations()) {
				EList<EObject> references = annotation.getReferences();
				for(EObject reference: references) {
					if (reference == null)
						failed = true;
					else if (reference.eIsProxy())
						failed = true;
				}
			}
		} catch(ConcurrentModificationException e) {
			failed = true;
		} catch(NoSuchElementException e) {
			failed = true;
		}
		return failed;
	}

}
