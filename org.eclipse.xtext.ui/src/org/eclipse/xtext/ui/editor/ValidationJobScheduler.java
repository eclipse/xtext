/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
import com.google.inject.Provider;
import com.google.inject.name.Named;

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

	// Languages without a builder may not have persisted descriptions
	@Inject(optional=true)
	@Named(ResourceDescriptionsProvider.PERSISTED_DESCRIPTIONS)
	private Provider<IResourceDescriptions> builderStateProvider;

	@Inject
	private IResourceDescription.Manager resourceDescriptionManager;

	@Inject
	private DescriptionUtils descriptionUtils;
	
	@Override
	public void scheduleInitialValidation(IXtextDocument document) {
		if (!(document instanceof XtextDocument))
			return;
		doScheduleInitialValidation((XtextDocument) document);
	}
	
	protected void doScheduleInitialValidation(XtextDocument document) {
		URI uri = document.getResourceURI();
		if (uri == null)
			return;
		IResourceDescription documentDescription = resourceDescriptions.getResourceDescription(uri);
		if (documentDescription == null) {
			// resource was just created - build is likely to be running in background
			return;
		}
		if (dirtyStateManager instanceof IDirtyStateManagerExtension && builderStateProvider != null) {
			IResourceDescriptions persistedDescriptions = builderStateProvider.get();
			List<URI> dirtyResourceURIs = ((IDirtyStateManagerExtension) dirtyStateManager).getDirtyResourceURIs();
			for(URI dirtyResourceURI: dirtyResourceURIs) {
				IResourceDescription dirtyDescription = dirtyStateManager.getDirtyResourceDescription(dirtyResourceURI);
				if (dirtyDescription != null) {
					IResourceDescription persistedDescription = persistedDescriptions.getResourceDescription(dirtyResourceURI);
					// Shortcut to make sure we don't waste time with more involving haveEObjectDescriptionChanged computation
					ChangedResourceDescriptionDelta delta = new ChangedResourceDescriptionDelta(persistedDescription, dirtyDescription);
					if(resourceDescriptionManager.isAffected(delta, documentDescription)) {
						document.checkAndUpdateAnnotations();
						return;
					}
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

	/**
	 * @noreference This method is not intended to be referenced by clients.
	 * @since 2.7
	 */
	public void setBuilderStateProvider(Provider<IResourceDescriptions> provider) {
		builderStateProvider = provider;
	}
	
	/**
	 * @noreference This method is not intended to be referenced by clients.
	 * @since 2.7
	 */
	public void setResourceDescriptionManager(IResourceDescription.Manager resourceDescriptionManager) {
		this.resourceDescriptionManager = resourceDescriptionManager;
	}
}
