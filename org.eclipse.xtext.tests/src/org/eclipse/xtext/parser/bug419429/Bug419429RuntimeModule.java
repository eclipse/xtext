/*******************************************************************************
 * Copyright (c) 2013, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.bug419429;

import org.eclipse.xtext.linking.lazy.LazyURIEncoder;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class Bug419429RuntimeModule extends org.eclipse.xtext.parser.bug419429.AbstractBug419429RuntimeModule {

	@Override
	public void configureUseIndexFragmentsForLazyLinking(Binder binder) {
		binder.bind(Boolean.TYPE).annotatedWith(Names.named(LazyURIEncoder.USE_INDEXED_FRAGMENTS_BINDING)).toInstance(Boolean.FALSE);
	}
}
