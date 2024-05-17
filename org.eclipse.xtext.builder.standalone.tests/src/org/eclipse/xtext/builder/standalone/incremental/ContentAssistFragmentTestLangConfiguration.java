/*******************************************************************************
 * Copyright (c) 2024 Lorenzo Bettini and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental;

import java.util.Set;

import org.eclipse.xtext.builder.standalone.ILanguageConfiguration;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.OutputConfiguration;

import com.google.common.collect.ImmutableSet;

public class ContentAssistFragmentTestLangConfiguration implements ILanguageConfiguration {

	public ContentAssistFragmentTestLangConfiguration() {
	}

	@Override
	public String getSetup() {
		return "org.eclipse.xtext.xbase.testlanguages.ContentAssistFragmentTestLangStandaloneSetup";
	}

	@Override
	public Set<OutputConfiguration> getOutputConfigurations() {
		OutputConfiguration config = new OutputConfiguration(IFileSystemAccess.DEFAULT_OUTPUT);
		config.setOutputDirectory("src-gen");
		return ImmutableSet.of(config);
	}

	@Override
	public boolean isJavaSupport() {
		return true;
	}
}