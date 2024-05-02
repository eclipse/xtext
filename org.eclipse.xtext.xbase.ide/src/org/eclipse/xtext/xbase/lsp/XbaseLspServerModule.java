/*******************************************************************************
 * Copyright (c) 2024 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.lsp;

import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.ide.server.ProjectManager;
import org.eclipse.xtext.util.IFileSystemScanner;

import com.google.inject.AbstractModule;

/**
 * @since 2.35
 */
public class XbaseLspServerModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(ProjectManager.class).to(ClasspathPropertiesBasedXbaseProjectManager.class);
		bind(IFileSystemScanner.class).to(ClasspathPropertiesBasedFileSystemScanner.class);
		
		bind(ClassLoader.class).toInstance(ClassLoader.getPlatformClassLoader());
		bind(IJvmTypeProvider.Factory.class).to(NonSealedClasspathTypeProviderFactory.class);
	}
}