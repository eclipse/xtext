/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.xtend2.lib.StringConcatenationClient;

/**
 * Configuration object for the generated standalone setup class. This class is
 * responsible for adding required EMF packages to the global registries.
 */
public class StandaloneSetupAccess {
	private final List<StringConcatenationClient> registrations = new ArrayList<>();

	@Deprecated
	private final Set<TypeReference> imports = new HashSet<>();

	/**
	 * @deprecated this set is required for backwards-compatibility to Xpand
	 * templates included with
	 * {@code org.eclipse.xtext.generator.adapter.FragmentAdapter}.
	 */
	@Deprecated
	public Set<TypeReference> getImports() {
		return imports;
	}

	public List<StringConcatenationClient> getRegistrations() {
		return registrations;
	}
}
