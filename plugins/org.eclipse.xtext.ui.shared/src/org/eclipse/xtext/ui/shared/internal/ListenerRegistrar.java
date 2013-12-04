/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.internal;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.xtext.builder.impl.ProjectOpenedOrClosedListener;
import org.eclipse.xtext.ui.shared.contribution.IEagerContribution;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ListenerRegistrar implements IEagerContribution {
	
	@Inject
	private ProjectOpenedOrClosedListener listener;
	@Inject
	private IWorkspace workspace;

	public void initialize() {
		workspace.addResourceChangeListener(listener);
	}

	public void discard() {
		workspace.removeResourceChangeListener(listener);
	}
	
}
