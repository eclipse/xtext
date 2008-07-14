/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.preferences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.Assert;

public final class PreferencesQualifiedName {
	private static final char SEPARATOR = '.';
	private List<String> parts = new ArrayList<String>();

	static final public PreferencesQualifiedName parse(String qualifiedNameAsString) {
		StringTokenizer tokenizer = new StringTokenizer(qualifiedNameAsString, String.valueOf(SEPARATOR));
		List<String> parts = new ArrayList<String>();
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			parts.add(token);
		}
		return new PreferencesQualifiedName(parts);
	}

	public String lastQualifier() {
		return parts.get(parts.size() - 1);
	}

	private List<String> getParts() {
		return new ArrayList<String>(parts);
	}

	private PreferencesQualifiedName(List<String> parts) {
		this.parts = parts;
	}

	public PreferencesQualifiedName(String name) {
		Assert.isLegal(name != null);
		this.parts.add(name);
	}

	private PreferencesQualifiedName(List<String> parts, String name) {
		this.parts = parts;
		this.parts.add(name);
	}

	public PreferencesQualifiedName append(String name) {
		return new PreferencesQualifiedName(this.getParts(), name);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Iterator<String> iter = parts.iterator(); iter.hasNext();) {
			sb.append(iter.next());
			if (iter.hasNext())
				sb.append(SEPARATOR);
		}
		return sb.toString();
	}
}