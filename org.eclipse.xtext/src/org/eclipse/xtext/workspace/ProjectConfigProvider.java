/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.workspace;

import org.eclipse.emf.ecore.resource.ResourceSet;

public class ProjectConfigProvider implements IProjectConfigProvider {
	@Override
	public IProjectConfig getProjectConfig(ResourceSet context) {
		ProjectConfigAdapter adapter = ProjectConfigAdapter.findInEmfObject(context);
		return adapter != null ? adapter.getProjectConfig() : null;
	}
}
