/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Map;

import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.util.IAcceptor;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.4
 */
public class ConfigurableIssueCodesProvider {
	
	private Map<String, PreferenceKey> issueCodes;

	public ConfigurableIssueCodesProvider() {
		final Map<String, PreferenceKey> map = Maps.newLinkedHashMap();
		initialize(new IAcceptor<PreferenceKey>() {

			@Override
			public void accept(PreferenceKey prefKey) {
				map.put(prefKey.getId(), prefKey);
			}
		});
		this.issueCodes = ImmutableMap.copyOf(map);
	}
	
	/**
	 * @since 2.14
	 */
	protected void initialize(IAcceptor<PreferenceKey> iAcceptor) {
		iAcceptor.accept(create(IssueCodes.COPY_JAVA_PROBLEMS, SeverityConverter.SEVERITY_IGNORE));
	}
	
	/**
	 * @since 2.14
	 */
	protected final PreferenceKey create(String id, String defaultValue) {
		return new PreferenceKey(id, defaultValue);
	}
	
	/**
	 * @return all configurable issue codes.
	 */
	public Map<String, PreferenceKey> getConfigurableIssueCodes() {
		return issueCodes;
	}
	
}
