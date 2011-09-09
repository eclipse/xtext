/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.parser.IParseResult;

import com.google.inject.Inject;

/**
 * 
 * Adds a hook for late initialization on first access of {@link #getContents()}
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.1
 */
public class LateInitializingLazyLinkingResource extends LazyLinkingResource {

	@Inject(optional=true)
	private ILateInitialization lateInitialization;
	
	public void setLateInitialization(ILateInitialization lateInitialization) {
		this.lateInitialization = lateInitialization;
	}
	
	protected boolean fullyInitialized = false;

	@Override
	public EList<EObject> getContents() {
		if (isLoaded && !isLoading && !isUpdating && !fullyInitialized) {
			try {
				eSetDeliver(false);
				isLoading = true;
				lateInitialize();
				fullyInitialized = true;
			} finally {
				isLoading = false;
				eSetDeliver(true);
			}
		}
		return super.getContents();
	}

	@Override
	protected void updateInternalState(IParseResult parseResult) {
		if (fullyInitialized) {
			discardLateInitializedState();
		}
		if (contents != null)
			contents.clear();
		fullyInitialized = false;
		super.updateInternalState(parseResult);
	}

	protected void discardLateInitializedState() {
		if (lateInitialization != null)
			lateInitialization.discardLateInitialization(super.getContents());
	}

	protected void lateInitialize() {
		if (lateInitialization != null)
			lateInitialization.doLateInitialization(super.getContents());
	}

}
