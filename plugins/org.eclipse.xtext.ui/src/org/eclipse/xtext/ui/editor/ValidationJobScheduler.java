/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.DescriptionUtils;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ChangedResourceDescriptionDelta;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

import com.google.inject.Inject;

/**
 * Default implementation of the {@link IValidationJobScheduler validation job scheduler}.
 * It will put a validation job into the job queue if the resource in newly opened has
 * a known reference to a currently dirty resource in another editor.
 * 
 * This implementation can be easily specialized by overriding {@link #isDirty(URI)} or 
 * the more coarse template method {@link #doScheduleInitialValidation(XtextDocument)}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.1
 */
public class ValidationJobScheduler implements IValidationJobScheduler {

	@Inject
	private IDirtyStateManager dirtyStateManager;
	
	@Inject
	private IResourceDescriptions resourceDescriptions;

	@Inject
	private ResourceDescriptionsProvider resourceDescriptionsProvider;

	@Inject
	private IResourceDescription.Manager resourceDescriptionManager;

	@Inject
	private DescriptionUtils descriptionUtils;
	
	public void scheduleInitialValidation(IXtextDocument document) {
		if (!(document instanceof XtextDocument))
			return;
		doScheduleInitialValidation((XtextDocument) document);
	}
	
	protected void doScheduleInitialValidation(XtextDocument document) {
		URI uri = document.getResourceURI();
		if (uri == null)
			return;
		IResourceDescriptions persistedDescriptions = resourceDescriptionsProvider.createPersistedResourceDescriptions();
		IResourceDescription documentDescription = resourceDescriptions.getResourceDescription(uri);
		if (documentDescription == null) {
			// resource was just created - build is likely to be running in background
			return;
		}
		if (dirtyStateManager instanceof IDirtyStateManagerExtension) {
			List<URI> dirtyResourceURIs = ((IDirtyStateManagerExtension) dirtyStateManager).getDirtyResourceURIs();
			for(URI dirtyResourceURI: dirtyResourceURIs) {
				IResourceDescription dirtyDescription = dirtyStateManager.getDirtyResourceDescription(dirtyResourceURI);
				IResourceDescription persistedDescription = persistedDescriptions.getResourceDescription(dirtyResourceURI);
				ChangedResourceDescriptionDelta delta = new ChangedResourceDescriptionDelta(persistedDescription, dirtyDescription);
				if(resourceDescriptionManager.isAffected(delta, documentDescription)) {
					document.checkAndUpdateAnnotations();
					return;
				}
			}
		} else {
			Set<URI> outgoingReferences = descriptionUtils.collectOutgoingReferences(documentDescription);
			for(URI outgoing: outgoingReferences) {
				if (isDirty(outgoing)) {
					document.checkAndUpdateAnnotations();
					return;
				}
			}
		}
	}

	protected boolean isDirty(URI uri) {
		if (dirtyStateManager.hasContent(uri)) {
			return true;
		}
		return false;
	}

	protected IDirtyStateManager getDirtyStateManager() {
		return dirtyStateManager;
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void setDirtyStateManager(IDirtyStateManager dirtyStateManager) {
		this.dirtyStateManager = dirtyStateManager;
	}

	protected IResourceDescriptions getResourceDescriptions() {
		return resourceDescriptions;
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void setResourceDescriptions(IResourceDescriptions resourceDescriptions) {
		this.resourceDescriptions = resourceDescriptions;
	}

	protected DescriptionUtils getDescriptionUtils() {
		return descriptionUtils;
	}

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public void setDescriptionUtils(DescriptionUtils descriptionUtils) {
		this.descriptionUtils = descriptionUtils;
	}

}
