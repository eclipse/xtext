/*******************************************************************************
 * Copyright (c) 2019 Sebastian Zarnekow (szarnekow) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.buildship;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.eclipse.xtext.ui.shared.Access;
import org.eclipse.xtext.ui.shared.contribution.ISharedStateContributionRegistry;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 * Executable extension factory that can provide a shared instance of
 * {@link IgnoreBuildDirContribution}.
 */
public class IgnoreBuildDirExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return Platform.getBundle("org.eclipse.xtext.buildship");
	}

	@Override
	protected Injector getInjector() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object create() throws CoreException {
		if (!clazzName.equals(IgnoreBuildDirContribution.class.getName())) {
			throw new CoreException(new Status(IStatus.ERROR, "org.eclipse.xtext.buildship",
					"Cannot create an instance of type " + clazzName));
		}
		ISharedStateContributionRegistry registry = Access.getSharedStateContributionRegistry().get();
		return registry.getSingleContributedInstance(IgnoreBuildDirContribution.class);
	}

}
