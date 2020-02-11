/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring.ui;

import static com.google.inject.Guice.*;
import static com.google.inject.util.Modules.*;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.eclipse.xtext.ui.resource.generic.EmfUiModule;
import org.eclipse.xtext.ui.tests.internal.TestsActivator;
import org.eclipse.xtext.ui.tests.refactoring.ReferringXmiResourceModule;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ReferringXmiExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return TestsActivator.getInstance().getBundle();
	}

	@Override
	protected Injector getInjector() {
		return createInjector(override(
				override(new ReferringXmiResourceModule()).with(new org.eclipse.xtext.ui.shared.SharedStateModule()))
				.with(new EmfUiModule(TestsActivator.getInstance())));
	}

}
