/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.validation;


import java.util.Map;

import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;
import org.eclipse.xtext.validation.SeverityConverter;
import org.eclipse.xtext.xbase.validation.IssueCodesStore;
import org.eclipse.xtext.xbase.validation.XbaseConfigurableIssueCodes;

/**
 * 
 * @author Dennis Huebner - Initial contribution and API
 */
public class XtendConfigurableIssueCodes extends ConfigurableIssueCodesProvider {
	private static final IssueCodesStore _CACHE = new IssueCodesStore(new XbaseConfigurableIssueCodes().getConfigurableIssueCodes());

	public static final PreferenceKey SINGLE_DISPATCH_FUNCTION = create(IssueCodes.SINGLE_DISPATCH_FUNCTION, SeverityConverter.SEVERITY_WARNING);
	
	public static final PreferenceKey DISPATCH_PLAIN_FUNCTION_NAME_CLASH = create(IssueCodes.DISPATCH_PLAIN_FUNCTION_NAME_CLASH, SeverityConverter.SEVERITY_WARNING);
	public static final PreferenceKey FIELD_LOCALLY_NEVER_READ = create(IssueCodes.FIELD_LOCALLY_NEVER_READ, SeverityConverter.SEVERITY_WARNING);
	public static final PreferenceKey FUNCTION_LOCALLY_NEVER_USED = create(IssueCodes.FUNCTION_LOCALLY_NEVER_USED, SeverityConverter.SEVERITY_WARNING);


	/**
	 * If you would like to a add a new IssueCode use this method,<br>
	 * this method creates a new {@link PreferenceKey} and adds it to the inner registry map.
	 */
	private static PreferenceKey create(String id, String defaultValue) {
		return _CACHE.add(id, defaultValue);
	}

	@Override
	public Map<String, PreferenceKey> getConfigurableIssueCodes() {
		return _CACHE.getImmutableCopy();
	}
}
