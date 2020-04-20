/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Injector;

/**
 * A generator fragment that delegates to a list of contained fragments. This
 * can be useful for extracting parts of a language configuration to a separate
 * mwe2 file, for example.
 */
public class CompositeGeneratorFragment2 implements IXtextGeneratorFragment {
	private final List<IXtextGeneratorFragment> fragments = new ArrayList<>();

	public void addFragment(IXtextGeneratorFragment fragment) {
		if (fragment == this) {
			throw new IllegalArgumentException();
		}
		fragments.add(fragment);
	}

	@Override
	public void checkConfiguration(Issues issues) {
		for (IXtextGeneratorFragment fragment : fragments) {
			fragment.checkConfiguration(issues);
		}
	}

	@Override
	public void generate() {
		CompositeGeneratorException composite = new CompositeGeneratorException();
		for (IXtextGeneratorFragment fragment : fragments) {
			try {
				fragment.generate();
			} catch (Exception e) {
				composite.addException(e);
			}
		}
		if (composite.hasExceptions()) {
			throw composite;
		}
	}

	@Override
	public void initialize(Injector injector) {
		for (IXtextGeneratorFragment fragment : fragments) {
			fragment.initialize(injector);
		}
	}

	protected List<IXtextGeneratorFragment> getFragments() {
		return fragments;
	}
}
