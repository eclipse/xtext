/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.builder.builderState.BuilderStateFactory;
import org.eclipse.xtext.builder.builderState.impl.ReferenceDescriptionImpl;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.DescriptionUtils;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.OutdatedStateManager;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionManager;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.ui.editor.DirtyStateManager;
import org.eclipse.xtext.ui.editor.IDirtyResource;
import org.eclipse.xtext.ui.editor.ValidationJobScheduler;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.util.Providers;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ValidationJobSchedulerTest extends AbstractXtextTests implements IResourceDescriptions, IDirtyResource {

	private List<IReferenceDescription> referenceDescriptions;
	private DirtyStateManager dirtyStateManager;
	private ValidationJobScheduler testMe;
	private XtextDocument document;
	private boolean validationScheduled;
	private URI documentURI;
	private TestableDocumentResource documentResource;
	private boolean noDocumentDescription;
	private URI targetURI;
	private IResourceDescription targetResource;
	@Inject
	private OutdatedStateManager outdatedStateManager;
	@Inject
	private OperationCanceledManager operationCanceledManager;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		referenceDescriptions = Lists.newArrayList();
		dirtyStateManager = new DirtyStateManager();
		testMe = new ValidationJobScheduler();
		testMe.setDirtyStateManager(dirtyStateManager);
		testMe.setDescriptionUtils(new DescriptionUtils());
		testMe.setResourceDescriptions(this);
		testMe.setResourceDescriptionManager(new DefaultResourceDescriptionManager());
		DocumentTokenSource nullSource = new DocumentTokenSource() {
			@Override
			protected IRegion computeDamageRegion(DocumentEvent e) {
				return new Region(0, 0);
			}
		};
		document = new XtextDocument(nullSource, null, outdatedStateManager, operationCanceledManager) {

			@Override
			public URI getResourceURI() {
				return documentURI;
			}
			
			@Override
			public void checkAndUpdateAnnotations() {
				validationScheduled = true;
			}
		};
		documentResource = new TestableDocumentResource();
		targetResource = new AbstractResourceDescription() {
			
			@Override
			public URI getURI() {
				return targetURI;
			}
			
			@Override
			public Iterable<IReferenceDescription> getReferenceDescriptions() {
				throw new UnsupportedOperationException();
			}
			
			@Override
			public Iterable<QualifiedName> getImportedNames() {
				throw new UnsupportedOperationException();
			}
			
			@Override
			protected List<IEObjectDescription> computeExportedObjects() {
				if (documentResource.importedName == null)
					throw new UnsupportedOperationException();
				return Collections.emptyList();
			}
		};
	}
	
	@Override
	public void tearDown() throws Exception {
		targetURI = null;
		referenceDescriptions = null;
		dirtyStateManager = null;
		targetResource = null;
		documentResource = null;
		testMe = null;
		document = null;
		super.tearDown();
	}
	
	@Test public void testNoResourceInDocument() {
		documentURI = null;
		validationScheduled = false;
		testMe.scheduleInitialValidation(document);
		assertFalse(validationScheduled);
	}
	
	@Test public void testNoResourceDescription() {
		documentURI = URI.createURI("document");
		noDocumentDescription = true;
		validationScheduled = false;
		testMe.scheduleInitialValidation(document);
		assertFalse(validationScheduled);
	}
	
	@Test public void testNoOutgoingReferences() {
		documentURI = URI.createURI("document");
		validationScheduled = false;
		testMe.scheduleInitialValidation(document);
		assertFalse(validationScheduled);
	}
	
	@Test public void testOutgoingReferencesToCleanResource() {
		documentURI = URI.createURI("document");
		targetURI = URI.createURI("target");
		ReferenceDescriptionImpl reference = (ReferenceDescriptionImpl) BuilderStateFactory.eINSTANCE.createReferenceDescription();
		reference.setTargetEObjectUri(targetURI);
		referenceDescriptions.add(reference);
		noDocumentDescription = false;
		validationScheduled = false;
		testMe.scheduleInitialValidation(document);
		assertFalse(validationScheduled);
	}
	
	@Test public void testOutgoingReferencesToDirtyResource() {
		documentURI = URI.createURI("document");
		targetURI = URI.createURI("target");
		ReferenceDescriptionImpl reference = (ReferenceDescriptionImpl) BuilderStateFactory.eINSTANCE.createReferenceDescription();
		reference.setTargetEObjectUri(targetURI);
		referenceDescriptions.add(reference);
		noDocumentDescription = false;
		announceDirtyStateChanged();
		validationScheduled = false;
		testMe.scheduleInitialValidation(document);
		assertTrue(validationScheduled);
	}

	private void announceDirtyStateChanged() {
		assertTrue(dirtyStateManager.manageDirtyState(this));
		dirtyStateManager.announceDirtyStateChanged(this);
	}
	
	@Test public void testOutgoingReferencesToAnotherResourceNoBuilderState() {
		documentURI = URI.createURI("document");
		targetURI = URI.createURI("target");
		ReferenceDescriptionImpl reference = (ReferenceDescriptionImpl) BuilderStateFactory.eINSTANCE.createReferenceDescription();
		reference.setTargetEObjectUri(URI.createURI("anothertarget"));
		referenceDescriptions.add(reference);
		noDocumentDescription = false;
		announceDirtyStateChanged();
		validationScheduled = false;
		testMe.scheduleInitialValidation(document);
		assertFalse(validationScheduled);
	}

	@Test public void testOutgoingReferencesToAnotherResourceWithBuilderState() {
		String exportedName = "exportedName";
		testMe.setBuilderStateProvider(Providers.<IResourceDescriptions>of(new MyBuilderState(exportedName)));
		documentResource.importedName = exportedName;
		documentURI = URI.createURI("document");
		targetURI = URI.createURI("target");
		ReferenceDescriptionImpl reference = (ReferenceDescriptionImpl) BuilderStateFactory.eINSTANCE.createReferenceDescription();
		reference.setTargetEObjectUri(URI.createURI("anothertarget"));
		referenceDescriptions.add(reference);
		noDocumentDescription = false;
		announceDirtyStateChanged();
		validationScheduled = false;
		testMe.scheduleInitialValidation(document);
		assertTrue(validationScheduled);
	}
	
	@Test public void testOutgoingReferencesToAnotherResourceWithBuilderStateNoAffection() {
		String exportedName = "exportedName";
		String importedName = "importedName";
		testMe.setBuilderStateProvider(Providers.<IResourceDescriptions>of(new MyBuilderState(exportedName)));
		documentResource.importedName = importedName;
		documentURI = URI.createURI("document");
		targetURI = URI.createURI("target");
		ReferenceDescriptionImpl reference = (ReferenceDescriptionImpl) BuilderStateFactory.eINSTANCE.createReferenceDescription();
		reference.setTargetEObjectUri(URI.createURI("anothertarget"));
		referenceDescriptions.add(reference);
		noDocumentDescription = false;
		announceDirtyStateChanged();
		validationScheduled = false;
		testMe.scheduleInitialValidation(document);
		assertFalse(validationScheduled);
	}
	
	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		return referenceDescriptions;
	}

	@Override
	public IResourceDescription getDescription() {
		return targetResource;
	}

	@Override
	public URI getURI() {
		return targetURI;
	}

	@Override
	public IResourceDescription getResourceDescription(URI normalizedURI) {
		if (noDocumentDescription)
			return null;
		if (documentURI.equals(normalizedURI))
			return documentResource;
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean isEmpty() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjects() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
		throw new UnsupportedOperationException();
	}

	public Iterable<QualifiedName> getImportedNames() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String getContents() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getActualContents() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		throw new UnsupportedOperationException();
	}
	
	private class TestableDocumentResource extends AbstractResourceDescription {
		
		private String importedName;
		
		@Override
		public URI getURI() {
			return documentURI;
		}

		@Override
		public Iterable<IReferenceDescription> getReferenceDescriptions() {
			return referenceDescriptions;
		}

		@Override
		public Iterable<QualifiedName> getImportedNames() {
			if (importedName == null)
				throw new UnsupportedOperationException();
			return Collections.singleton(QualifiedName.create(importedName).toLowerCase());
		}

		@Override
		protected List<IEObjectDescription> computeExportedObjects() {
			throw new UnsupportedOperationException();
		}
	}

	public static class MyBuilderState implements IResourceDescriptions {

		private final String exportedName;
		
		public MyBuilderState(String exportedName) {
			this.exportedName = exportedName;
		}
		
		@Override
		public boolean isEmpty() {
			return false;
		}

		@Override
		public Iterable<IEObjectDescription> getExportedObjects() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
			throw new UnsupportedOperationException();
		}

		@Override
		public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
			throw new UnsupportedOperationException();
		}

		@Override
		public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
			throw new UnsupportedOperationException();
		}

		@Override
		public Iterable<IResourceDescription> getAllResourceDescriptions() {
			throw new UnsupportedOperationException();
		}

		@Override
		public IResourceDescription getResourceDescription(final URI uri) {
			return new AbstractResourceDescription() {

				@Override
				public Iterable<QualifiedName> getImportedNames() {
					return Collections.emptyList();
				}

				@Override
				public Iterable<IReferenceDescription> getReferenceDescriptions() {
					return Collections.emptyList();
				}

				@Override
				public URI getURI() {
					return uri;
				}

				@Override
				protected List<IEObjectDescription> computeExportedObjects() {
					return Collections.singletonList(EObjectDescription.create(exportedName, EcoreFactory.eINSTANCE.createEObject()));
				}
				
			};
		}
		
	}

}
