/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.preferences;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.name.Names;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class PreferenceStoreAccessTest extends Assert implements IPreferenceStoreInitializer {

	private static final String LANGUAGE_ID = "org.xtext.MyLanguage";
	private IPreferenceStoreAccess preferenceStoreAccess;

	@Override
	public void initialize(IPreferenceStoreAccess access) {
		access.getWritablePreferenceStore().setDefault("someBoolean", true);
	}
	
	@Before
	public void setUp() throws Exception {
		preferenceStoreAccess = Guice.createInjector(new AbstractGenericModule() {
			@SuppressWarnings("unused")
			public void configureModule(Binder binder) {
				binder.bind(String.class).annotatedWith(Names.named(Constants.LANGUAGE_NAME)).toInstance(LANGUAGE_ID);
				binder.bind(IPreferenceStoreInitializer.class).toInstance(PreferenceStoreAccessTest.this);
			}
		}).getInstance(IPreferenceStoreAccess.class);
	}
	
	@After
	public void tearDown() throws Exception {
		getWritable().setToDefault("someBoolean");
		getWritable().setToDefault("someInt");
		getWritable().setToDefault("anotherInt");
		getWritable().setToDefault("thirdInt");
		getWritable().setToDefault("newValue");
	}

	@Test public void testDefault() {
		IPreferenceStore readable = getReadable();
		assertTrue(readable.getDefaultBoolean("someBoolean"));
		assertTrue(readable.getBoolean("someBoolean"));
		IPreferenceStore writable = getWritable();
		writable.setValue("someBoolean", "false");
		assertFalse(readable.getBoolean("someBoolean"));
		writable.setToDefault("someBoolean");
		assertTrue(readable.getBoolean("someBoolean"));
	}

	@SuppressWarnings("deprecation")
	@Test public void testScope() {
		ScopedPreferenceStore scopedPreferenceStore = new ScopedPreferenceStore(new ConfigurationScope(), "org");
		assertFalse("partial keys are not supported", scopedPreferenceStore.getBoolean("xtext.MyLanguage.someBoolean"));
	}
	
	@SuppressWarnings("deprecation")
	@Test public void testScopeWithAnotherInstance() {
		// ensure initialization
		getWritable();
		ScopedPreferenceStore scopedPreferenceStore = new ScopedPreferenceStore(new ConfigurationScope(), LANGUAGE_ID);
		assertTrue(scopedPreferenceStore.getBoolean("someBoolean"));
	}
	
	@SuppressWarnings("deprecation")
	@Test public void testChainedPreferenceStore() {
		ScopedPreferenceStore configurationStore = new ScopedPreferenceStore(new ConfigurationScope(), LANGUAGE_ID);
		configurationStore.setValue("someInt", 12);
		configurationStore.setValue("anotherInt", 12);
		configurationStore.setDefault("thirdInt", 12);
		ScopedPreferenceStore instanceStore = new ScopedPreferenceStore(new InstanceScope(), LANGUAGE_ID);
		instanceStore.setValue("someInt", 13);
		instanceStore.setDefault("anotherInt", 13);
		ChainedPreferenceStore chainedStore = new ChainedPreferenceStore(new IPreferenceStore[] { instanceStore, configurationStore });
		assertEquals(13, chainedStore.getInt("someInt"));
		assertEquals(13, chainedStore.getInt("anotherInt"));
		assertEquals(12, chainedStore.getInt("thirdInt"));
	}
	
	@Test public void testScopedEvents() {
		final List<String> keys = Lists.newArrayList();
		getReadable().addPropertyChangeListener(new IPropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				keys.add(event.getProperty());
			}
		});
		getWritable().setValue("newValue", true);
		assertEquals(1, keys.size());
		assertEquals("newValue", keys.get(0));
	}

	@Test public void testProjectScope() throws Exception {
		try {
			IProject project = IResourcesSetupUtil.createProject("test");
			final List<String> keys = Lists.newArrayList();
			preferenceStoreAccess.getContextPreferenceStore(project).addPropertyChangeListener(new IPropertyChangeListener() {
				@Override
				public void propertyChange(PropertyChangeEvent event) {
					keys.add(event.getProperty());
				}
			});
			getWritable().setValue("newValue", 1);
			assertEquals(0, keys.size());
			preferenceStoreAccess.getWritablePreferenceStore(project).setValue("newValue", 2);
			assertEquals(1, keys.size());
			assertEquals("newValue", keys.get(0));
			assertEquals(1, getReadable().getInt("newValue"));
			assertEquals(2, preferenceStoreAccess.getContextPreferenceStore(project).getInt("newValue"));
		} finally {
			IResourcesSetupUtil.cleanWorkspace();
		}
	}

	protected IPreferenceStore getReadable() {
		return preferenceStoreAccess.getPreferenceStore();
	}

	protected IPreferenceStore getWritable() {
		return preferenceStoreAccess.getWritablePreferenceStore();
	}
	
	
}

