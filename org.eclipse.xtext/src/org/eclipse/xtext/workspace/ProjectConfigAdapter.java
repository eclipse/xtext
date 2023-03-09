/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.workspace;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class ProjectConfigAdapter {
	public static class ProjectConfigAdapterAdapter extends AdapterImpl {
		private final ProjectConfigAdapter element;

		public ProjectConfigAdapterAdapter(ProjectConfigAdapter element) {
			this.element = element;
		}

		public ProjectConfigAdapter get() {
			return element;
		}

		@Override
		public boolean isAdapterForType(Object object) {
			return object == ProjectConfigAdapter.class;
		}
	}

	private final IProjectConfig projectConfig;

	protected ProjectConfigAdapter(IProjectConfig projectConfig) {
		this.projectConfig = projectConfig;
	}

	public static void install(ResourceSet resourceSet, IProjectConfig config) {
		new ProjectConfigAdapter(config).attachToEmfObject(resourceSet);
	}

	public static ProjectConfigAdapter findInEmfObject(Notifier emfObject) {
		for (Adapter adapter : emfObject.eAdapters()) {
			if (adapter instanceof ProjectConfigAdapterAdapter) {
				return ((ProjectConfigAdapterAdapter) adapter).get();
			}
		}
		return null;
	}

	public static ProjectConfigAdapter removeFromEmfObject(Notifier emfObject) {
		List<Adapter> adapters = emfObject.eAdapters();
		for (int i = 0, max = adapters.size(); i < max; i++) {
			Adapter adapter = adapters.get(i);
			if (adapter instanceof ProjectConfigAdapterAdapter) {
				emfObject.eAdapters().remove(i);
				return ((ProjectConfigAdapterAdapter) adapter).get();
			}
		}
		return null;
	}

	public void attachToEmfObject(Notifier emfObject) {
		ProjectConfigAdapter result = findInEmfObject(emfObject);
		if (result != null) {
			throw new IllegalStateException(
					"The given EMF object already contains an adapter for ProjectConfigAdapter");
		}
		ProjectConfigAdapterAdapter adapter = new ProjectConfigAdapterAdapter(this);
		emfObject.eAdapters().add(adapter);
	}

	public IProjectConfig getProjectConfig() {
		return projectConfig;
	}
}
