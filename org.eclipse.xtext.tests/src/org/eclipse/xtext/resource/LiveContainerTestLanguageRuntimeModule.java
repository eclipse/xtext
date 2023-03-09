/*******************************************************************************
 * Copyright (c) 2012, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.xtext.workspace.IProjectConfigProvider;
import org.eclipse.xtext.workspace.ProjectConfigProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class LiveContainerTestLanguageRuntimeModule extends org.eclipse.xtext.resource.AbstractLiveContainerTestLanguageRuntimeModule {

	public Class<? extends IProjectConfigProvider> bindIProjectConfigProvider() {
		return ProjectConfigProvider.class;
	}
}
