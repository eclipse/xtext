/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.label;

import junit.framework.TestCase;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.xtext.ui.resource.ResourceServiceDescriptionLabelProvider;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * @author koehnlein - Initial contribution and API
 */
public class LabelProviderInjectionTest extends TestCase {

	public void testLabelProviderInjection() throws Exception {
		Module module = new Module() {
			public void configure(Binder binder) {
				binder.bind(ILabelProvider.class).annotatedWith(ResourceServiceDescriptionLabelProvider.class).to(LabelProvider.class);
			}
		};
		Injector injector = Guice.createInjector(module);
		Test instance = injector.getInstance(Test.class);
		assertTrue(instance.labelProvider instanceof LabelProvider);
	}
	
	static class Test {
		@Inject@ResourceServiceDescriptionLabelProvider
		ILabelProvider labelProvider;
	}
}
