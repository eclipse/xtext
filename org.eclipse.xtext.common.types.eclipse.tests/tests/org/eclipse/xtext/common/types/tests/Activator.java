/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.tests;

import org.eclipse.xtext.common.types.access.jdt.MockJavaProjectProvider;
import org.eclipse.xtext.common.types.eclipse.tests.internal.TestsActivator;
import org.osgi.framework.BundleContext;

public class Activator extends TestsActivator {

	@Override
	public void stop(BundleContext context) throws Exception {
		MockJavaProjectProvider.tearDown();
		super.stop(context);
	}

}
