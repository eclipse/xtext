/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.shared;

import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.shared.contribution.SharedStateContribution;
import org.eclipse.xtext.ui.shared.internal.SharedStateContributionRegistryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SharedStateContributionRegistryImplTest {

	private Injector injector;

	@Before
	public void createParentInjector() {
		injector = Guice.createInjector(new Module() {
			public void configure(Binder binder) {
				binder.bind(CharSequence.class).to(String.class);
				binder.bind(String.class).toInstance("fromParentInjector");
			}
		});
	}
	
	@Test
	public void testCreateContributingInjector() {
		SharedStateContributionRegistryImpl registry = new SharedStateContributionRegistryImpl(injector);
		Injector myInjector = registry.createInjectorWithoutJITBindings(new Module() {
			public void configure(Binder binder) {
				binder.bind(CharSequenceClient.class).to(CharSequenceClientImpl.class);
			}
		});
		Assert.assertEquals("fromParentInjector", myInjector.getInstance(CharSequenceClient.class).getSeq());
		
		Assert.assertNotNull(myInjector.getExistingBinding(Key.get(CharSequenceClientImpl.class)));
		Assert.assertNotNull(myInjector.getExistingBinding(Key.get(CharSequenceClient.class)));
		Assert.assertNotNull(myInjector.getExistingBinding(Key.get(CharSequence.class)));
		Assert.assertNotNull(myInjector.getExistingBinding(Key.get(String.class)));
		
		Assert.assertNull(injector.getExistingBinding(Key.get(CharSequenceClientImpl.class)));
		Assert.assertNull(injector.getExistingBinding(Key.get(CharSequenceClient.class)));
		Assert.assertNotNull(injector.getExistingBinding(Key.get(CharSequence.class)));
		Assert.assertNotNull(injector.getExistingBinding(Key.get(String.class)));
	}
	
	@Test
	public void testCreateContribution() {
		SharedStateContributionRegistryImpl registry = new SharedStateContributionRegistryImpl(injector);
		SharedStateContribution contribution = registry.createContribution(new Module() {
			public void configure(Binder binder) {
				binder.bind(CharSequenceClient.class).to(CharSequenceClientImpl.class);
			}
		});
		Assert.assertTrue(contribution.isContributionSupported(CharSequenceClient.class));
		Assert.assertFalse(contribution.isContributionSupported(IXtextDocument.class));
		Assert.assertEquals("fromParentInjector", contribution.getContribution(CharSequenceClient.class).getSeq());
	}
	
	interface CharSequenceClient {
		CharSequence getSeq();
	}
	static class CharSequenceClientImpl implements CharSequenceClient {
		@Inject
		CharSequence seq;

		public CharSequence getSeq() {
			return seq;
		}
		
	}
	
}
