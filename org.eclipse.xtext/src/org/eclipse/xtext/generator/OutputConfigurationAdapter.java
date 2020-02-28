/**
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.impl.AdapterImpl;

import com.google.common.base.Preconditions;

/**
 * @noreference
 */
public class OutputConfigurationAdapter extends AdapterImpl {
	private final Map<String, Set<OutputConfiguration>> outputConfigurationsPerLanguage;

	public OutputConfigurationAdapter(Map<String, Set<OutputConfiguration>> outputConfigurationsPerLanguage) {
		Preconditions.checkNotNull(outputConfigurationsPerLanguage);
		this.outputConfigurationsPerLanguage = outputConfigurationsPerLanguage;
	}

	public Map<String, Set<OutputConfiguration>> getOutputConfigurationsPerLanguage() {
		return outputConfigurationsPerLanguage;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return OutputConfigurationAdapter.class.equals(type);
	}

	@Override
	public int hashCode() {
		return 31 * 1 + outputConfigurationsPerLanguage.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OutputConfigurationAdapter other = (OutputConfigurationAdapter) obj;
		if (!outputConfigurationsPerLanguage.equals(other.outputConfigurationsPerLanguage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OutputConfigurationAdapter [outputConfigurationsPerLanguage=" + outputConfigurationsPerLanguage + "]";
	}

}
