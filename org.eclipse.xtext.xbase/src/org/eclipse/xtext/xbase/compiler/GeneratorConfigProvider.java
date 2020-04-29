/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.compiler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.Constants;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Holger Schill - Initial contribution and API
 * @author Moritz Eysholdt - introduced adapter
 */
public class GeneratorConfigProvider implements IGeneratorConfigProvider {
	public static class GeneratorConfigAdapter {
		public static class GeneratorConfigAdapterAdapter extends AdapterImpl {
			private GeneratorConfigAdapter element;

			public GeneratorConfigAdapterAdapter(GeneratorConfigAdapter element) {
				this.element = element;
			}

			public GeneratorConfigAdapter get() {
				return element;
			}

			@Override
			public boolean isAdapterForType(Object object) {
				return object == GeneratorConfigAdapter.class;
			}
		}

		private final Map<String, GeneratorConfig> language2GeneratorConfig = new HashMap<>();

		public static GeneratorConfigAdapter findInEmfObject(Notifier emfObject) {
			for (Adapter adapter : emfObject.eAdapters()) {
				if (adapter instanceof GeneratorConfigAdapterAdapter) {
					return ((GeneratorConfigAdapterAdapter) adapter).get();
				}
			}
			return null;
		}

		public static GeneratorConfigAdapter removeFromEmfObject(Notifier emfObject) {
			List<Adapter> adapters = emfObject.eAdapters();
			for (int i = 0, max = adapters.size(); i < max; i++) {
				Adapter adapter = adapters.get(i);
				if (adapter instanceof GeneratorConfigAdapterAdapter) {
					emfObject.eAdapters().remove(i);
					return ((GeneratorConfigAdapterAdapter) adapter).get();
				}
			}
			return null;
		}

		public void attachToEmfObject(Notifier emfObject) {
			GeneratorConfigAdapter result = findInEmfObject(emfObject);
			if (result != null)
				throw new IllegalStateException(
						"The given EMF object already contains an adapter for GeneratorConfigAdapter");
			GeneratorConfigAdapterAdapter adapter = new GeneratorConfigAdapterAdapter(this);
			emfObject.eAdapters().add(adapter);
		}

		public Map<String, GeneratorConfig> getLanguage2GeneratorConfig() {
			return language2GeneratorConfig;
		}
	}

	@Inject
	@Named(Constants.LANGUAGE_NAME)
	private String languageId;

	public GeneratorConfig install(ResourceSet resourceSet, GeneratorConfig config) {
		GeneratorConfigAdapter adapter = GeneratorConfigAdapter.findInEmfObject(resourceSet);
		if (adapter == null) {
			adapter = new GeneratorConfigAdapter();
			adapter.attachToEmfObject(resourceSet);
		}
		return adapter.language2GeneratorConfig.put(languageId, config);
	}

	@Override
	public GeneratorConfig get(EObject context) {
		if (context != null) {
			Resource resource = context.eResource();
			if (resource != null) {
				ResourceSet resourceSet = resource.getResourceSet();
				if (resourceSet != null) {
					GeneratorConfigAdapter adapter = GeneratorConfigAdapter.findInEmfObject(resourceSet);
					if (adapter != null && adapter.language2GeneratorConfig.containsKey(languageId)) {
						return adapter.language2GeneratorConfig.get(languageId);
					}
				}
			}
		}
		return new GeneratorConfig();
	}
}
