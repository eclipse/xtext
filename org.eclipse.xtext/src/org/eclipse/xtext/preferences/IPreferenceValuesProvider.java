/*******************************************************************************
 * Copyright (c) 2012, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.preferences;

import java.util.LinkedHashMap;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.LanguageInfo;

import com.google.common.collect.Maps;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Moritz Eysholdt
 * 
 * @since 2.26
 */
@ImplementedBy(IPreferenceValuesProvider.DefaultPreferenceValuesProvider.class)
public interface IPreferenceValuesProvider {

	IPreferenceValues getPreferenceValues(Resource context);

	public static class SimplePreferenceValuesProvider implements IPreferenceValuesProvider {
		@Override
		public IPreferenceValues getPreferenceValues(Resource context) {
			return new MapBasedPreferenceValues(new LinkedHashMap<String, String>());
		}
	}
	
	public static class DefaultPreferenceValuesProvider implements IPreferenceValuesProvider {
		@Inject private LanguageInfo language;

		@Override
		public IPreferenceValues getPreferenceValues(Resource context) {
			if (context == null) {
				return empty();
			}
			PreferenceValuesByLanguage valuesByLanguage = PreferenceValuesByLanguage.findInEmfObject(context.getResourceSet());
			if (valuesByLanguage == null)
				return empty();
			IPreferenceValues values = valuesByLanguage.get(language.getLanguageName());
			if (values == null) 
				return empty();
			return values;
		}
		
		private IPreferenceValues empty() {
			return new MapBasedPreferenceValues(Maps.<String, String> newLinkedHashMap());
		}
		
	}

	@Singleton
	public class SingletonPreferenceValuesProvider implements IPreferenceValuesProvider {
		private MapBasedPreferenceValues preferences = new MapBasedPreferenceValues(Maps.<String, String> newLinkedHashMap());

		@Override
		public MapBasedPreferenceValues getPreferenceValues(Resource context) {
			return preferences;
		}
	}
}
