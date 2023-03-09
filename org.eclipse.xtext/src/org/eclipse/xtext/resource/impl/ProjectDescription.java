/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

import com.google.common.annotations.Beta;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.9
 */
@Beta
public class ProjectDescription {

	/**
	 * A unique name for this project
	 */
	private String name;

	/**
	 * list of logical names of upstream dependencies
	 */
	private List<String> dependencies = new ArrayList<>();

	public static ProjectDescription findInEmfObject(Notifier emfObject) {
		for (Adapter adapter : emfObject.eAdapters()) {
			if (adapter instanceof ProjectDescriptionAdapter)
				return ((ProjectDescriptionAdapter) adapter).get();
		}
		return null;
	}

	public static ProjectDescription removeFromEmfObject(Notifier emfObject) {
		List<Adapter> adapters = emfObject.eAdapters();
		for (int i = 0; i < adapters.size(); i++) {
			Adapter adapter = adapters.get(i);
			if (adapter instanceof ProjectDescriptionAdapter)
				return ((ProjectDescriptionAdapter) emfObject.eAdapters().remove(i)).get();
		}
		return null;
	}

	public void attachToEmfObject(Notifier emfObject) {
		if (findInEmfObject(emfObject) != null)
			throw new IllegalStateException("The given EMF object already contains an adapter for ProjectDescription");
		emfObject.eAdapters().add(new ProjectDescriptionAdapter(this));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getDependencies() {
		return dependencies;
	}

	public void setDependencies(List<String> dependencies) {
		this.dependencies = dependencies;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).add("name", name).add("dependencies", dependencies).toString();
	}

	public static class ProjectDescriptionAdapter extends AdapterImpl {
		private ProjectDescription element;

		public ProjectDescriptionAdapter(ProjectDescription element) {
			this.element = element;
		}

		public ProjectDescription get() {
			return element;
		}

		@Override
		public boolean isAdapterForType(Object object) {
			return object == ProjectDescription.class;
		}
	}

}
