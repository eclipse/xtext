/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Collections;
import java.util.Map;

import org.eclipse.xtext.preferences.PreferenceKey;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.4
 */
public class ConfigurableIssueCodesProvider {

	/**
	 * @return all configurable issue codes.
	 */
	public Map<String, PreferenceKey> getConfigurableIssueCodes() {
		return Collections.emptyMap();
	}
	
}
