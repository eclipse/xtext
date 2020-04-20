/**
 * Copyright (c) 2017, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Injector;

/**
 * Generator fragment that wraps another fragment and can be toggled via a
 * property
 * 
 * @author Christian Dietrich - Initial contribution and API
 * 
 * @since 2.13
 */
public class ConditionalXtextGeneratorFragment implements IXtextGeneratorFragment {
	private IXtextGeneratorFragment fragment;

	private boolean enabled = true;

	@Override
	public void checkConfiguration(Issues issues) {
		if (fragment == null) {
			issues.addError("The property 'fragment' must be set.", this);
		} else {
			fragment.checkConfiguration(issues);
		}
	}

	@Override
	public void generate() {
		if (enabled) {
			fragment.generate();
		}
	}

	@Override
	public void initialize(Injector injector) {
		fragment.initialize(injector);
	}

	public IXtextGeneratorFragment getFragment() {
		return fragment;
	}

	public void setFragment(IXtextGeneratorFragment fragment) {
		this.fragment = fragment;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
