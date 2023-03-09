/**
 * Copyright (c) 2011, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.impl;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IProjectConfigProvider;
import org.eclipse.xtext.workspace.IWorkspaceConfig;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.14
 */
public class LiveShadowedChunkedResourceDescriptions extends LiveShadowedResourceDescriptions {
	@Inject(optional = true)
	private IProjectConfigProvider projectConfigProvider;

	private IWorkspaceConfig workspaceConfig;

	@Override
	public void setContext(Notifier ctx) {
		ResourceSetBasedResourceDescriptions localDescriptions = (ResourceSetBasedResourceDescriptions) getLocalDescriptions();
		localDescriptions.setContext(ctx);
		localDescriptions.setData(null);
		ResourceSet resourceSet = EcoreUtil2.getResourceSet(ctx);
		setGlobalDescriptions(ChunkedResourceDescriptions.findInEmfObject(resourceSet));
		if (projectConfigProvider == null) {
			workspaceConfig = null;
		} else {
			IProjectConfig projectConfig = projectConfigProvider.getProjectConfig(resourceSet);
			workspaceConfig = projectConfig == null ? null : projectConfig.getWorkspaceConfig();
		}
	}

	public IWorkspaceConfig getWorkspaceConfig() {
		return workspaceConfig;
	}
}
