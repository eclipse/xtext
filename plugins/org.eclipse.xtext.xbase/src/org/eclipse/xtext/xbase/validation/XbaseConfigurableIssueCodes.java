/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import java.util.Map;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;
import org.eclipse.xtext.validation.SeverityConverter;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.inject.Singleton;

/**
 * This class holds all the configurable issue codes for the Xbase language.<br>
 * Use {@link #getConfigurableIssueCodes()} to get all registered codes.<br>
 * 
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Dennis Huebner
 */
@Singleton
public class XbaseConfigurableIssueCodes extends ConfigurableIssueCodesProvider {

	private Map<String, PreferenceKey> issueCodes;

	public XbaseConfigurableIssueCodes() {
		final Map<String, PreferenceKey> map = Maps.newLinkedHashMap();
		initialize(new IAcceptor<PreferenceKey>() {

			public void accept(PreferenceKey prefKey) {
				map.put(prefKey.getId(), prefKey);
			}
		});
		this.issueCodes = ImmutableMap.copyOf(map);
	}

	protected void initialize(IAcceptor<PreferenceKey> iAcceptor) {
		iAcceptor.accept(createDelegate(IssueCodes.FORBIDDEN_REFERENCE, JavaCore.COMPILER_PB_FORBIDDEN_REFERENCE));
		iAcceptor.accept(createDelegate(IssueCodes.DISCOURAGED_REFERENCE, JavaCore.COMPILER_PB_DISCOURAGED_REFERENCE));
		iAcceptor.accept(create(IssueCodes.IMPORT_WILDCARD_DEPRECATED, SeverityConverter.SEVERITY_WARNING));

		iAcceptor.accept(createDelegate(IssueCodes.OBSOLETE_INSTANCEOF, JavaCore.COMPILER_PB_UNNECESSARY_TYPE_CHECK));
		iAcceptor.accept(createDelegate(IssueCodes.OBSOLETE_CAST, JavaCore.COMPILER_PB_UNNECESSARY_TYPE_CHECK));
		iAcceptor.accept(createDelegate(IssueCodes.IMPORT_UNUSED, JavaCore.COMPILER_PB_UNUSED_IMPORT));
		iAcceptor.accept(createDelegate(IssueCodes.UNUSED_LOCAL_VARIABLE, JavaCore.COMPILER_PB_UNUSED_LOCAL));
		iAcceptor.accept(create(IssueCodes.IMPORT_DUPLICATE, SeverityConverter.SEVERITY_WARNING));
	}

	protected final PreferenceKey create(String id, String defaultValue) {
		return new PreferenceKey(id, defaultValue);
	}

	protected PreferenceKey createDelegate(String id, String delegationKey) {
		return createDelegate(id, delegationKey, SeverityConverter.SEVERITY_WARNING);
	}

	protected PreferenceKey createDelegate(String id, String delegationKey, String defaultSeverity) {
		String encodedDelegation = XbaseSeverityConverter.encodeDefaultSeverity(delegationKey, defaultSeverity);
		return create(id, encodedDelegation);
	}

	@Override
	public Map<String, PreferenceKey> getConfigurableIssueCodes() {
		return issueCodes;
	}
}
