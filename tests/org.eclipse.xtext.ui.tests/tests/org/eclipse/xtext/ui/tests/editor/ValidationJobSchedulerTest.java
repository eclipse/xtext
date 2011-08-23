/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.builder.builderState.BuilderStateFactory;
import org.eclipse.xtext.builder.builderState.impl.ReferenceDescriptionImpl;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.DescriptionUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;
import org.eclipse.xtext.ui.editor.DirtyStateManager;
import org.eclipse.xtext.ui.editor.IDirtyResource;
import org.eclipse.xtext.ui.editor.ValidationJobScheduler;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class ValidationJobSchedulerTest extends AbstractXtextTests implements IResourceDescriptions, IDirtyResource {

	private List<IReferenceDescription> referenceDescriptions;
	private DirtyStateManager dirtyStateManager;
	private ValidationJobScheduler testMe;
	private XtextDocument document;
	private boolean validationScheduled;
	private URI documentURI;
	private IResourceDescription documentResource;
	private boolean noDocumentDescription;
	private URI targetURI;
	private IResourceDescription targetResource;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		referenceDescriptions = Lists.newArrayList();
		dirtyStateManager = new DirtyStateManager();
		testMe = new ValidationJobScheduler();
		testMe.setDirtyStateManager(dirtyStateManager);
		testMe.setDescriptionUtils(new DescriptionUtils());
		testMe.setResourceDescriptions(this);
		DocumentTokenSource nullSource = new DocumentTokenSource() {
			@Override
			protected IRegion computeDamageRegion(DocumentEvent e) {
				return new Region(0, 0);
			}
		};
		document = new XtextDocument(nullSource, null) {

			@Override
			public URI getResourceURI() {
				return documentURI;
			}
			
			@Override
			public void checkAndUpdateAnnotations() {
				validationScheduled = true;
			}
		};
		documentResource = new AbstractResourceDescription() {
			
			public URI getURI() {
				return documentURI;
			}
			
			public Iterable<IReferenceDescription> getReferenceDescriptions() {
				return referenceDescriptions;
			}
			
			public Iterable<QualifiedName> getImportedNames() {
				throw new UnsupportedOperationException();
			}
			
			@Override
			protected List<IEObjectDescription> computeExportedObjects() {
				throw new UnsupportedOperationException();
			}
		};
		targetResource = new AbstractResourceDescription() {
			
			public URI getURI() {
				return targetURI;
			}
			
			public Iterable<IReferenceDescription> getReferenceDescriptions() {
				throw new UnsupportedOperationException();
			}
			
			public Iterable<QualifiedName> getImportedNames() {
				throw new UnsupportedOperationException();
			}
			
			@Override
			protected List<IEObjectDescription> computeExportedObjects() {
				throw new UnsupportedOperationException();
			}
		};
	}
	
	@Override
	protected void tearDown() throws Exception {
		targetURI = null;
		referenceDescriptions = null;
		dirtyStateManager = null;
		targetResource = null;
		documentResource = null;
		testMe = null;
		document = null;
		super.tearDown();
	}
	
	public void testNoResourceInDocument() {
		documentURI = null;
		validationScheduled = false;
		testMe.scheduleInitialValidation(document);
		assertFalse(validationScheduled);
	}
	
	public void testNoResourceDescription() {
		documentURI = URI.createURI("document");
		noDocumentDescription = true;
		validationScheduled = false;
		testMe.scheduleInitialValidation(document);
		assertFalse(validationScheduled);
	}
	
	public void testNoOutgoingReferences() {
		documentURI = URI.createURI("document");
		validationScheduled = false;
		testMe.scheduleInitialValidation(document);
		assertFalse(validationScheduled);
	}
	
	public void testOutgoingReferencesToCleanResource() {
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
	
	public void testOutgoingReferencesToDirtyResource() {
		documentURI = URI.createURI("document");
		targetURI = URI.createURI("target");
		ReferenceDescriptionImpl reference = (ReferenceDescriptionImpl) BuilderStateFactory.eINSTANCE.createReferenceDescription();
		reference.setTargetEObjectUri(targetURI);
		referenceDescriptions.add(reference);
		noDocumentDescription = false;
		dirtyStateManager.announceDirtyStateChanged(this);
		validationScheduled = false;
		testMe.scheduleInitialValidation(document);
		assertTrue(validationScheduled);
	}
	
	public void testOutgoingReferencesToAnotherResource() {
		documentURI = URI.createURI("document");
		targetURI = URI.createURI("target");
		ReferenceDescriptionImpl reference = (ReferenceDescriptionImpl) BuilderStateFactory.eINSTANCE.createReferenceDescription();
		reference.setTargetEObjectUri(URI.createURI("anothertarget"));
		referenceDescriptions.add(reference);
		noDocumentDescription = false;
		dirtyStateManager.announceDirtyStateChanged(this);
		validationScheduled = false;
		testMe.scheduleInitialValidation(document);
		assertFalse(validationScheduled);
	}

	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		return referenceDescriptions;
	}

	public IResourceDescription getDescription() {
		return targetResource;
	}

	public URI getURI() {
		return targetURI;
	}

	public IResourceDescription getResourceDescription(URI normalizedURI) {
		if (noDocumentDescription)
			return null;
		if (documentURI.equals(normalizedURI))
			return documentResource;
		throw new UnsupportedOperationException();
	}
	
	public boolean isEmpty() {
		throw new UnsupportedOperationException();
	}

	public Iterable<IEObjectDescription> getExportedObjects() {
		throw new UnsupportedOperationException();
	}

	public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
		throw new UnsupportedOperationException();
	}

	public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
		throw new UnsupportedOperationException();
	}

	public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
		throw new UnsupportedOperationException();
	}

	public Iterable<QualifiedName> getImportedNames() {
		throw new UnsupportedOperationException();
	}
	
	public String getContents() {
		throw new UnsupportedOperationException();
	}

	public String getActualContents() {
		throw new UnsupportedOperationException();
	}

	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		throw new UnsupportedOperationException();
	}

}
