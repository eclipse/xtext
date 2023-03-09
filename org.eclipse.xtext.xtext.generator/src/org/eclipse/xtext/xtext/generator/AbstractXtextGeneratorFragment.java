/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Convenience class for implementing generator fragments. Provides access to
 * the {@link IXtextProjectConfig project configuration} and the
 * {@link IXtextGeneratorLanguage language configuration}.
 */
public abstract class AbstractXtextGeneratorFragment implements IXtextGeneratorFragment {
	@Inject
	private IXtextProjectConfig projectConfig;

	@Inject
	private IXtextGeneratorLanguage language;

	@Inject
	private Grammar grammar;

	@Override
	public void checkConfiguration(Issues issues) {
	}

	@Override
	public void initialize(Injector injector) {
		injector.injectMembers(this);
	}

	protected IXtextProjectConfig getProjectConfig() {
		return projectConfig;
	}

	protected IXtextGeneratorLanguage getLanguage() {
		return language;
	}

	protected Grammar getGrammar() {
		return grammar;
	}
}
