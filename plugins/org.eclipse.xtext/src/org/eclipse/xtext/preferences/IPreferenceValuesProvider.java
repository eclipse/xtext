/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.preferences;

import java.util.LinkedHashMap;

import org.eclipse.emf.ecore.resource.Resource;

import com.google.common.collect.Maps;
import com.google.inject.ImplementedBy;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Moritz Eysholdt
 */
@ImplementedBy(IPreferenceValuesProvider.SimplePreferenceValuesProvider.class)
public interface IPreferenceValuesProvider {

	IPreferenceValues getPreferenceValues(Resource context);

	public static class SimplePreferenceValuesProvider implements IPreferenceValuesProvider {
		@Override
		public IPreferenceValues getPreferenceValues(Resource context) {
			return new MapBasedPreferenceValues(new LinkedHashMap<String, String>());
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
