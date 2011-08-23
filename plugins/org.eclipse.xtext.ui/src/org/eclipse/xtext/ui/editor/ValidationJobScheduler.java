/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.DescriptionUtils;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
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
		IResourceDescription description = resourceDescriptions.getResourceDescription(uri);
		if (description == null) {
			// resource was just created - build is likely to be running in background
			return;
		}
		Set<URI> outgoingReferences = descriptionUtils.collectOutgoingReferences(description);
		for(URI outgoing: outgoingReferences) {
			if (isDirty(outgoing)) {
				document.checkAndUpdateAnnotations();
				return;
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
