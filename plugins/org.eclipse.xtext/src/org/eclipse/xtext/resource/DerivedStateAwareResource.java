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
 * Adds a hook for late initialization to be used to create derived state
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.1
 */
public class DerivedStateAwareResource extends LazyLinkingResource {

	@Inject(optional=true)
	private IDerivedStateComputer derivedStateComputer;
	
	public void setDerivedStateComputer(IDerivedStateComputer lateInitialization) {
		this.derivedStateComputer = lateInitialization;
	}
	
	protected volatile boolean fullyInitialized = false;
	protected volatile boolean isInitializing = false;

	@Override
	public synchronized EList<EObject> getContents() {
		if (isLoaded && !isLoading && !isInitializing && !isUpdating && !fullyInitialized) {
			try {
				eSetDeliver(false);
				installDerivedState(false);
			} finally {
				eSetDeliver(true);
			}
		}
		return super.getContents();
	}

	@Override
	protected void updateInternalState(IParseResult oldParseResult, IParseResult newParseResult) {
		if (fullyInitialized) {
			discardDerivedState();
		}
		super.updateInternalState(oldParseResult, newParseResult);
	}

	public void discardDerivedState() {
		if (fullyInitialized && !isInitializing) {
			try {
				isInitializing = true;
				if (derivedStateComputer != null)
					derivedStateComputer.discardDerivedState(this);
				fullyInitialized = false;
			} finally {
				isInitializing = false;
			}
		}
	}

	public void installDerivedState(boolean isPrelinkingPhase) {
		if (!fullyInitialized && !isInitializing) {
			try {
				isInitializing = true;
				if (derivedStateComputer != null)
					derivedStateComputer.installDerivedState(this, isPrelinkingPhase);
				fullyInitialized = true;
			} finally {
				isInitializing = false;
			}
		}
	}

}
