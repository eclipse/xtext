/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.preferences;

import java.util.List;

import com.google.inject.Binding;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * a preference store initialize can be used to set programmatic defaults 
 * in one of the preference stores. 
 */
public interface IPreferenceStoreInitializer {
	/**
	 * Initialize preference values with the given {@link IPreferenceStoreAccess}
	 */
	public void initialize(IPreferenceStoreAccess access);
	
	/**
	 * a composite initialize calling all registered {@link IPreferenceStoreInitializer}s
	 */
	static class CompositeImpl implements IPreferenceStoreInitializer {

		private Injector injector;
		
		@Inject
		public void setInjector(Injector injector) {
			this.injector = injector;
		}
		
		@Override
		public void initialize(IPreferenceStoreAccess access) {
			List<Binding<IPreferenceStoreInitializer>> list = injector.findBindingsByType(TypeLiteral
					.get(IPreferenceStoreInitializer.class));
			for (Binding<IPreferenceStoreInitializer> binding : list) {
				IPreferenceStoreInitializer storeInitializer = injector.getInstance(binding.getKey());
				storeInitializer.initialize(access);
			}
		}
		
	}
}
