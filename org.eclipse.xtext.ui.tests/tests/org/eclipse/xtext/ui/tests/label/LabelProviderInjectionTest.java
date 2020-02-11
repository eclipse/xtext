/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.label;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.xtext.ui.resource.ResourceServiceDescriptionLabelProvider;
import org.junit.Assert;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class LabelProviderInjectionTest extends Assert {

	@org.junit.Test public void testLabelProviderInjection() throws Exception {
		Module module = new Module() {
			@Override
			public void configure(Binder binder) {
				binder.bind(ILabelProvider.class).annotatedWith(ResourceServiceDescriptionLabelProvider.class).to(LabelProvider.class);
			}
		};
		Injector injector = Guice.createInjector(module);
		Test instance = injector.getInstance(Test.class);
		assertTrue(instance.labelProvider instanceof LabelProvider);
	}
	
	static class Test {
		@Inject
		@ResourceServiceDescriptionLabelProvider
		ILabelProvider labelProvider;
	}
}
