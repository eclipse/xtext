/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.m2e;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public class Languages implements Iterable<Language> {
	private List<Language> languages = Lists.<Language> newArrayList();

	public void addLanguage(Language lang) {
		this.languages.add(lang);
	}

	public Iterator<Language> iterator() {
		return languages.iterator();
	}
}
