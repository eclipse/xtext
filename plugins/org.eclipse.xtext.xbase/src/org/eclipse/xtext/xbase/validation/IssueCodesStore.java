/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import static com.google.common.collect.Maps.*;

import java.util.Map;

import org.eclipse.xtext.preferences.PreferenceKey;

import com.google.common.collect.ImmutableMap;

public class IssueCodesStore {

	private final Map<String, PreferenceKey> issueCodesCache ;
	private ImmutableMap<String, PreferenceKey> immutableCopy;

	public IssueCodesStore() {
		this.issueCodesCache = newLinkedHashMap();
	}
	
	public IssueCodesStore(Map<String, PreferenceKey> issueCodes) {
		this.issueCodesCache = newLinkedHashMap(issueCodes);
	}

	public PreferenceKey add(String id, String defaultValue) {
		PreferenceKey prefKey = new PreferenceKey(id, defaultValue);
		issueCodesCache.put(prefKey.getId(), prefKey);
		return prefKey;
	}

	public Map<String, PreferenceKey> getImmutableCopy() {
		if (immutableCopy == null) {
			immutableCopy = ImmutableMap.copyOf(issueCodesCache);
		}
		return immutableCopy;
	}
}