/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.shared.internal;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.builder.impl.javasupport.ProjectClasspathChangeListener;
import org.eclipse.xtext.ui.resource.Storage2UriMapperJavaImpl;
import org.eclipse.xtext.ui.shared.contribution.IEagerContribution;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JavaCoreListenerRegistrar implements IEagerContribution {

	@Inject
	private ProjectClasspathChangeListener classpathChangeListener;
	
	@Inject
	private Storage2UriMapperJavaImpl storage2UriMapperJavaImpl;
	
	@Override
	public void initialize() {
		JavaCore.addElementChangedListener(classpathChangeListener);
		storage2UriMapperJavaImpl.asyncInitializeCache();
		JavaCore.addElementChangedListener(storage2UriMapperJavaImpl);
	}

	@Override
	public void discard() {
		JavaCore.removeElementChangedListener(classpathChangeListener);
		JavaCore.removeElementChangedListener(storage2UriMapperJavaImpl);
	}
	
}
