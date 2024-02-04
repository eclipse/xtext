/*******************************************************************************
 * Copyright (c) 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.tests.internal;

import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.builder.tests.BuilderTestLanguageRuntimeModule;
import org.eclipse.xtext.builder.tests.ui.BuilderTestLanguageUiModule;
import org.eclipse.xtext.resource.impl.DefaultResourceServiceProvider;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.resource.IResourceUIServiceProvider;

import com.google.inject.Binder;
import com.google.inject.Module;
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
				 * {@link IResourceUIServiceProvider} specifies its default implementation to be {@link org.eclipse.xtext.ui.resource.DefaultResourceUIServiceProvider}
				 * with no explicit binding in any module, so we can customize the binding here.
				 */
				@SuppressWarnings("unused")
				public Class<? extends IResourceUIServiceProvider> bindIResourceUIServiceProvider() {
					return ResourceNonUIServiceProvider.class;
				}
			};
		return super.getUiModule(grammar);
	}
	/** A provider that essentially mimics the behavior of {@link DefaultResourceServiceProvider} in the guise of a {@link IResourceUIServiceProvider}. */
	static class ResourceNonUIServiceProvider extends DefaultResourceServiceProvider implements IResourceUIServiceProvider {
		@Override
		public ILabelProvider getLabelProvider() {
			return null;
		}
		@Override
		public boolean canHandle(URI uri, IStorage storage) {
			// if we wouldn't implement IResourceUIServiceProvider then this method would be invoked in the first place:
			return canHandle(uri);
		}
		@Override
		public IURIEditorOpener getURIEditorOpener() {
			return null;
		}
		@SuppressWarnings({ "deprecation", "restriction" })
		@Override
		public org.eclipse.xtext.ui.refactoring.IReferenceUpdater getReferenceUpdater() {
			return null;
		}
	}
}
