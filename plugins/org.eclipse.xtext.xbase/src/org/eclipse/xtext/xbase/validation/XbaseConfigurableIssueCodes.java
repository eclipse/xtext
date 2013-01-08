/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import static com.google.common.collect.Maps.*;

import java.util.Map;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;
import org.eclipse.xtext.validation.SeverityConverter;

/**
 * This class holds all the configurable issue codes for the Xbase language.<br>
 * Use {@link #getConfigurableIssueCodes()} to get all registered codes.<br>
 * 
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Dennis Huebner
 */
public class XbaseConfigurableIssueCodes extends ConfigurableIssueCodesProvider {

	private static final Map<String, PreferenceKey> _allConfigurableCodes = newLinkedHashMap();


	public static final PreferenceKey FORBIDDEN_REFERENCE = create(IssueCodes.FORBIDDEN_REFERENCE, JavaCore.COMPILER_PB_FORBIDDEN_REFERENCE);
	public static final PreferenceKey DISCOURAGED_REFERENCE = create(IssueCodes.DISCOURAGED_REFERENCE, JavaCore.COMPILER_PB_DISCOURAGED_REFERENCE);
	public static final PreferenceKey IMPORT_WILDCARD_DEPRECATED = create(IssueCodes.IMPORT_WILDCARD_DEPRECATED, SeverityConverter.SEVERITY_WARNING);
	 
	public static final PreferenceKey OBSOLETE_INSTANCEOF = create(IssueCodes.OBSOLETE_INSTANCEOF, JavaCore.COMPILER_PB_UNNECESSARY_TYPE_CHECK);
	public static final PreferenceKey IMPORT_UNUSED = create(IssueCodes.IMPORT_UNUSED, JavaCore.COMPILER_PB_UNUSED_IMPORT);
	public static final PreferenceKey UNUSED_LOCAL_VARIABLE = create(IssueCodes.UNUSED_LOCAL_VARIABLE, JavaCore.COMPILER_PB_UNUSED_LOCAL);
	
	/**
	 * If you would like to a add a new IssueCode use this method,<br>
	 * this method creates a new {@link PreferenceKey} and adds it to the inner registry map.
	 */
	private static PreferenceKey create(String id, String defaultvalue) {
		PreferenceKey prefKey = new PreferenceKey(id, defaultvalue);
		_allConfigurableCodes.put(prefKey.getId(), prefKey);
		return prefKey;
	}

	@Override
	public Map<String, PreferenceKey> getConfigurableIssueCodes() {
		return _allConfigurableCodes;
	}

}
