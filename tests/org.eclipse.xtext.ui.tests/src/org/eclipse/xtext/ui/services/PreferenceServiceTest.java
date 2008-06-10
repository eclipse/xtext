/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.services;

import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.xtext.ui.core.service.IPreferenceStoreService;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class PreferenceServiceTest extends AbstractServiceTest {
	private String defaultKey = "testDefaultKey";
	private String defaultValue = "testDefaultValue";
	private String simpleKey = "testKey";
	private String simpleValue = "testValue";

	public void testPreferenceStore() throws Exception {
		IPreferenceStoreService preferenceStoreService = getServiceForDefaultLanguage(IPreferenceStoreService.class);
		assertNotNull(preferenceStoreService);
		IPersistentPreferenceStore persitablePreferenceStore = preferenceStoreService.getPersitablePreferenceStore();
		assertNotNull(preferenceStoreService);
		// default
		persitablePreferenceStore.setDefault(defaultKey, defaultValue);
		assertEquals(defaultValue, getServiceForDefaultLanguage(IPreferenceStoreService.class)
				.getPersitablePreferenceStore().getString(defaultKey));
		// overwrite default
		persitablePreferenceStore.setValue(defaultKey, simpleValue);
		assertEquals(simpleValue, getServiceForDefaultLanguage(IPreferenceStoreService.class)
				.getPersitablePreferenceStore().getString(defaultKey));
		// simple value
		persitablePreferenceStore.setValue(simpleKey, simpleValue);
		assertEquals(simpleValue, getServiceForDefaultLanguage(IPreferenceStoreService.class)
				.getPersitablePreferenceStore().getString(simpleKey));
	}

}
