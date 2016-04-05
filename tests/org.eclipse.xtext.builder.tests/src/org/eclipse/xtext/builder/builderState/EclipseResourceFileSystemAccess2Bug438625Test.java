/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.lang.reflect.Field;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.builder.tests.Activator;
import org.eclipse.xtext.builder.tests.BuilderTestLanguageRuntimeModule;
import org.eclipse.xtext.builder.tests.ui.BuilderTestLanguageUiModule;
import org.eclipse.xtext.ui.generator.trace.ITraceForStorageProvider;
import org.eclipse.xtext.ui.generator.trace.TraceForStorageProvider;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.util.Modules2;
import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Tests that ITraceForStorageProvider.Null or other ITraceForStorageProvider implementations can be injected
 * into EclipseResourceFileSystemAccess2.
 * @author Karsten Thoms - Initial contribution and API
 */
public class EclipseResourceFileSystemAccess2Bug438625Test extends Assert {
	static class Bug438625UiModule extends BuilderTestLanguageUiModule {
		public Bug438625UiModule(AbstractUIPlugin plugin) {
			super(plugin);
		}
		public Class<? extends ITraceForStorageProvider> bindITraceForStorageProvider () {
			return ITraceForStorageProvider.Null.class;
		}
	}

	@Test
	public void testDefaultTraceForStorageProvider() throws Exception {
		Injector injector = Guice.createInjector(Modules2.mixin(
				new BuilderTestLanguageRuntimeModule()
				, new SharedStateModule()
				, new BuilderTestLanguageUiModule(Activator.getInstance())
				)); 
				
		EclipseResourceFileSystemAccess2 fsa = injector.getInstance(EclipseResourceFileSystemAccess2.class);
		assertEquals(TraceForStorageProvider.class, getTraceForStorageProvider(fsa).getClass());
	}
	
	@Test
	public void testNullTraceForStorageProvider() throws Exception {
		Injector injector = Guice.createInjector(Modules2.mixin(
				new BuilderTestLanguageRuntimeModule()
				, new SharedStateModule()
				, new Bug438625UiModule(Activator.getInstance())
				)); 
				
		EclipseResourceFileSystemAccess2 fsa = injector.getInstance(EclipseResourceFileSystemAccess2.class);
		assertEquals(ITraceForStorageProvider.Null.class, getTraceForStorageProvider(fsa).getClass());
	}
	
	private ITraceForStorageProvider getTraceForStorageProvider (EclipseResourceFileSystemAccess2 fsa) throws Exception {
		Field field = fsa.getClass().getDeclaredField("fileBasedTraceInformation");
		try {
			field.setAccessible(true);
			ITraceForStorageProvider traceForStorageProvider = (ITraceForStorageProvider) field.get(fsa);
			return traceForStorageProvider;
		} finally {
			field.setAccessible(false);
		}
	}

}
