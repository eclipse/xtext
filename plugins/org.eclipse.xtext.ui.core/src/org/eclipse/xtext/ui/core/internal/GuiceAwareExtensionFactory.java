/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.internal;

import org.eclipse.xtext.ui.core.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.eclipse.xtext.ui.core.guice.IGuiceAwareActivator;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class GuiceAwareExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected IGuiceAwareActivator getActivator() {
		return Activator.getDefault();
	}

}
