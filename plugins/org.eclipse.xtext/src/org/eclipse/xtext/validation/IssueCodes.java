/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.4
 */
public class IssueCodes {

	private Map<String, ConfigurableIssueCode> issueCodesMap;

	protected Map<String, ConfigurableIssueCode> collectKeys() {
		Map<String, ConfigurableIssueCode> result = Maps.newLinkedHashMap();
		for (Field field : getClass().getFields()) {
			if (ConfigurableIssueCode.class.isAssignableFrom(field.getType())) {
				try {
					ConfigurableIssueCode key = (ConfigurableIssueCode) field.get(this);
					result.put(key.getCode(), key);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public IssueCode getIssueCode(String code) {
		return issueCodesMap().get(code);
	}

	public Collection<ConfigurableIssueCode> getIssueCodes() {
		return issueCodesMap().values();
	}

	protected Map<String, ConfigurableIssueCode> issueCodesMap() {
		if (issueCodesMap == null)
			issueCodesMap = collectKeys();
		return issueCodesMap;
	}

}
