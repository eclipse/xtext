/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.service;

import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ILanguageService;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public interface IPreferenceStoreService extends ILanguageService {
	IPersistentPreferenceStore getPersitablePreferenceStore();

	void initializeDefaults();
	
	void setLanguageDescriptor(ILanguageDescriptor languageDescriptor);

}
