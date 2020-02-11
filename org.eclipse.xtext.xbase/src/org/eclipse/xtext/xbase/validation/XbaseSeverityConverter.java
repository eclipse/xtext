/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import java.util.List;

import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.validation.SeverityConverter;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class XbaseSeverityConverter extends SeverityConverter {

	private static final char DEFAULT_SEVERITY_SEPARATOR = ':';
	


	@Override
	public Severity stringToSeverity(final String severityAsString) {
		String valueToConvert = severityAsString;
		if (severityAsString.startsWith(XbaseConfigurableIssueCodes.JDT_CORE_PLUGIN_ID)) {
			valueToConvert = delegatedValue(decodeDelegationKey(severityAsString));
		}
		return super.stringToSeverity(valueToConvert);
	}

	/**
	 * 
	 * @param pair
	 *            holds first=delegationKey, second=defaultValue. delegationKey starts with {@link XbaseConfigurableIssueCodes#JDT_CORE_PLUGIN_ID}
	 * @return resolved delegated value
	 */
	protected String delegatedValue(Pair<String, String> pair) {
		return pair.getSecond();
	}

	/**
	 * @return String delegationKey:defaultSeverity
	 */
	public static String encodeDefaultSeverity(String delegationKey, String defaultSeverity) {
		return new StringBuilder(delegationKey).append(DEFAULT_SEVERITY_SEPARATOR).append(defaultSeverity).toString();
	}

	/**
	 * Returns decoded delegation key or <code>null</code> if encodedValue can not be parsed.
	 * @return {@link Pair} where getFirst() is delegationKey and getSecond() is the defaultSeverity.
	 * @see XbaseSeverityConverter#encodeDefaultSeverity(String, String)
	 */
	public static Pair<String, String> decodeDelegationKey(String encodedValue) {
		List<String> split = Strings.split(encodedValue, DEFAULT_SEVERITY_SEPARATOR);
		if (split.size() == 2) {
			return Tuples.create(split.get(0), split.get(1));
		} else if (split.size() == 1) {
			return Tuples.create(split.get(0), SeverityConverter.SEVERITY_WARNING);
		} else {
			return null;
		}
	}
}
