/**
 * Copyright (c) 2015, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.preferences;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

/**
 * @since 2.26 
 */
public class PreferenceValuesByLanguage {
	private final Map<String, IPreferenceValues> preferencesByLanguage = new HashMap<>();

	public IPreferenceValues get(String languageId) {
		return preferencesByLanguage.get(languageId);
	}

	public IPreferenceValues put(String languageId, IPreferenceValues values) {
		return preferencesByLanguage.put(languageId, values);
	}

	public static PreferenceValuesByLanguage findInEmfObject(Notifier emfObject) {
		for (Adapter adapter : emfObject.eAdapters())
			if (adapter instanceof PreferenceValuesByLanguageAdapter)
				return ((PreferenceValuesByLanguageAdapter) adapter).get();
		return null;
	}

	public static PreferenceValuesByLanguage removeFromEmfObject(Notifier emfObject) {
		List<Adapter> adapters = emfObject.eAdapters();
		for (int i = 0; i < adapters.size(); i++) {
			Adapter adapter = adapters.get(i);
			if (adapter instanceof PreferenceValuesByLanguageAdapter)
				return ((PreferenceValuesByLanguageAdapter) emfObject.eAdapters().remove(i)).get();
		}
		return null;
	}

	public void attachToEmfObject(Notifier emfObject) {
		if (findInEmfObject(emfObject) != null)
			throw new IllegalStateException(
					"The given EMF object already contains an adapter for PreferenceValuesByLanguage");
		PreferenceValuesByLanguageAdapter adapter = new PreferenceValuesByLanguageAdapter(this);
		emfObject.eAdapters().add(adapter);
	}

	public static class PreferenceValuesByLanguageAdapter extends AdapterImpl {
		private PreferenceValuesByLanguage element;

		public PreferenceValuesByLanguageAdapter(PreferenceValuesByLanguage element) {
			this.element = element;
		}

		public PreferenceValuesByLanguage get() {
			return element;
		}

		@Override
		public boolean isAdapterForType(Object object) {
			return object == PreferenceValuesByLanguage.class;
		}
	}

}
