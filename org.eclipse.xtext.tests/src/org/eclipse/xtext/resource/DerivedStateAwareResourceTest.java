/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DerivedStateAwareResourceTest extends AbstractXtextTests {

	public static final class TestedResource extends DerivedStateAwareResource {
		
		public TestedResource() {
			operationCanceledManager = new OperationCanceledManager();
		}
		
		public void setIsLoaded() {
			this.isLoaded = true;
		}
	}

	@Test public void testInitialization() throws Exception {
		TestedResource resource = new TestedResource();
		assertTrue(resource.getContents().isEmpty());
		resource.setDerivedStateComputer(new IDerivedStateComputer() {
			@Override
			public void installDerivedState(DerivedStateAwareResource resource, boolean resolve) {
				fail("shouldn't be called after initialization");
			}

			@Override
			public void discardDerivedState(DerivedStateAwareResource resource) {
				fail("shouldn't be called after initialization");
			}
		});
		resource.getContents();
		resource.setIsLoaded();
		resource.eAdapters().add(new AdapterImpl(){
			@Override
			public void notifyChanged(Notification msg) {
				fail("notification received");
				super.notifyChanged(msg);
			}
		});
		resource.setDerivedStateComputer(new IDerivedStateComputer() {
			
			@Override
			public void installDerivedState(DerivedStateAwareResource resource, boolean resolve) {
				resource.getContents().add(EcoreFactory.eINSTANCE.createEObject());
			}

			@Override
			public void discardDerivedState(DerivedStateAwareResource resource) {
				resource.getContents().clear();
			}
		});
		assertEquals(1, resource.getContents().size());
	}
	
	@Test public void testErrorBehavior() throws Exception {
		TestedResource resource = new TestedResource();
		resource.setIsLoaded();
		resource.setDerivedStateComputer(new IDerivedStateComputer() {
			@Override
			public void installDerivedState(DerivedStateAwareResource resource, boolean resolve) {
				resource.getContents().add(EcoreFactory.eINSTANCE.createEClass());
				throw new IllegalStateException();
			}

			@Override
			public void discardDerivedState(DerivedStateAwareResource resource) {
			}
		});
		try {
			resource.getContents();
			fail("exception expected");
		} catch (IllegalStateException e) {
			// expected
		}
		
		// no exception on subsequent calls
		assertTrue(resource.getContents().get(0) instanceof EClass);
		
		// there is one exception error
		assertEquals(1, resource.getErrors().size());
		assertTrue(((ExceptionDiagnostic)resource.getErrors().get(0)).getException() instanceof IllegalStateException);
	}
	
	@Test public void testOperationCanceledExceptionOnInstall() {
		TestedResource resource = new TestedResource();
		resource.setIsLoaded();
		resource.setDerivedStateComputer(new IDerivedStateComputer() {
			
			private boolean canceled = true;
			
			@Override
			public void installDerivedState(DerivedStateAwareResource resource, boolean resolve) {
				resource.getContents().add(EcoreFactory.eINSTANCE.createEObject());
				if (canceled) {
					canceled = false;
					throw new OperationCanceledException();
				}
			}

			@Override
			public void discardDerivedState(DerivedStateAwareResource resource) {
				resource.getContents().clear();
			}
		});
		
		assertFalse(resource.isFullyInitialized());
		
		try {
			resource.getContents();
			fail("exception expected");
		} catch (OperationCanceledError e) {
			// expected
		}
		assertFalse(resource.isFullyInitialized());
		assertTrue(resource.getErrors().isEmpty());
		
		assertFalse(resource.getContents().isEmpty());
		assertTrue(resource.isFullyInitialized());
		assertTrue(resource.getErrors().isEmpty());
	}
	
	@Test public void testOperationCanceledExceptionOnInstallAndDiscard() {
		TestedResource resource = new TestedResource();
		resource.setIsLoaded();
		resource.setDerivedStateComputer(new IDerivedStateComputer() {
			
			@Override
			public void installDerivedState(DerivedStateAwareResource resource, boolean resolve) {
				resource.getContents().add(EcoreFactory.eINSTANCE.createEObject());
				throw new OperationCanceledException();
			}

			@Override
			public void discardDerivedState(DerivedStateAwareResource resource) {
				throw new OperationCanceledException();
			}
		});
		
		assertFalse(resource.isFullyInitialized());
		
		try {
			resource.getContents();
			fail("exception expected");
		} catch (IllegalStateException e) {
			// expected
		}
		
		assertTrue(resource.isFullyInitialized());
		assertFalse(resource.getContents().isEmpty());

		assertEquals(1, resource.getErrors().size());
		assertTrue(((ExceptionDiagnostic)resource.getErrors().get(0)).getException() instanceof IllegalStateException);
	}
}
