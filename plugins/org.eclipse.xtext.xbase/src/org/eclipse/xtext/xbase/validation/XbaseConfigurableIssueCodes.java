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


	public static final PreferenceKey FORBIDDEN_REFERENCE = createDelegate(IssueCodes.FORBIDDEN_REFERENCE, JavaCore.COMPILER_PB_FORBIDDEN_REFERENCE);
	public static final PreferenceKey DISCOURAGED_REFERENCE = createDelegate(IssueCodes.DISCOURAGED_REFERENCE, JavaCore.COMPILER_PB_DISCOURAGED_REFERENCE);
	public static final PreferenceKey IMPORT_WILDCARD_DEPRECATED = create(IssueCodes.IMPORT_WILDCARD_DEPRECATED, SeverityConverter.SEVERITY_WARNING);
	 
	public static final PreferenceKey OBSOLETE_INSTANCEOF = createDelegate(IssueCodes.OBSOLETE_INSTANCEOF, JavaCore.COMPILER_PB_UNNECESSARY_TYPE_CHECK);
	public static final PreferenceKey IMPORT_UNUSED = createDelegate(IssueCodes.IMPORT_UNUSED, JavaCore.COMPILER_PB_UNUSED_IMPORT);
	public static final PreferenceKey UNUSED_LOCAL_VARIABLE = createDelegate(IssueCodes.UNUSED_LOCAL_VARIABLE, JavaCore.COMPILER_PB_UNUSED_LOCAL);
	public static final PreferenceKey IMPORT_DUPLICATE = create(IssueCodes.IMPORT_DUPLICATE, SeverityConverter.SEVERITY_WARNING);
	
	
	/**
	 * If you would like to a add a new IssueCode use this method,<br>
	 * this method creates a new {@link PreferenceKey} and adds it to the inner registry map.
	 */
	protected static PreferenceKey create(String id, String defaultValue) {
		PreferenceKey prefKey = new PreferenceKey(id, defaultValue);
		_allConfigurableCodes.put(prefKey.getId(), prefKey);
		return prefKey;
	}

	protected static PreferenceKey createDelegate(String id, String delegationKey) {
		return createDelegate(id, delegationKey, SeverityConverter.SEVERITY_WARNING);
	}

	protected static PreferenceKey createDelegate(String id, String delegationKey, String defaultSeverity) {
		String encodedDelegation = XbaseSeverityConverter.encodeDefaultSeverity(delegationKey, defaultSeverity);
		return create(id, encodedDelegation);
	}

	@Override
	public Map<String, PreferenceKey> getConfigurableIssueCodes() {
		return _allConfigurableCodes;
	}

}
