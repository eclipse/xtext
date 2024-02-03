/*******************************************************************************
 * Copyright (c) 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.tests.internal;

import org.eclipse.xtext.Constants;
import org.eclipse.xtext.builder.tests.BuilderTestLanguageRuntimeModule;
import org.eclipse.xtext.builder.tests.ui.BuilderTestLanguageUiModule;
import org.eclipse.xtext.ui.shared.JdtHelper;
import org.eclipse.xtext.ui.util.IJdtHelper;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.name.Names;

/**
 * This allows customizations in the UI, specific for some test scenarions, without creating new languages.
 * 
 * @author Lorenzo Bettini - Initial contribution and API
 */
public class TestsActivatorCustom extends TestsActivator {

	public static final String ORG_ECLIPSE_XTEXT_BUILDER_TESTS_BUILDERTESTLANGUAGE_GH2920 = ORG_ECLIPSE_XTEXT_BUILDER_TESTS_BUILDERTESTLANGUAGE
			+ "GH2920";

	@Override
	protected Module getRuntimeModule(String grammar) {
		if (ORG_ECLIPSE_XTEXT_BUILDER_TESTS_BUILDERTESTLANGUAGE_GH2920.equals(grammar))
			return new BuilderTestLanguageRuntimeModule() {
				@Override
				public void configureFileExtensions(Binder binder) {
					if (properties == null || properties.getProperty(Constants.FILE_EXTENSIONS) == null)
						binder.bind(String.class).annotatedWith(Names.named(Constants.FILE_EXTENSIONS))
								.toInstance("buildertestlanguageGH2920");
				}
			};
		return super.getRuntimeModule(grammar);
	}

	@Override
	protected Module getUiModule(String grammar) {
		if (ORG_ECLIPSE_XTEXT_BUILDER_TESTS_BUILDERTESTLANGUAGE_GH2920.equals(grammar))
			return new BuilderTestLanguageUiModule(this) {
				/**
				 * By default, the {@link IJdtHelper} is bound by the {@link org.eclipse.xtext.ui.shared.SharedStateModule}, but since the
				 * UI module is mixed as the last one in {@link TestsActivator}, we can "override" its binding here.
				 */
				@SuppressWarnings("unused")
				public Provider<IJdtHelper> provideJdtHelper() {
					return new Provider<>() {
						@Override
						public IJdtHelper get() {
							return new JdtHelper() {
								@Override
								protected boolean computeJavaCoreAvailable() {
									return false;
								}
							};
						}
					};
				}
			};
		return super.getUiModule(grammar);
	}
}
