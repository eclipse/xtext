/*******************************************************************************
 * Copyright (c) 2011, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4;

import com.google.inject.Injector;

/**
 * Producer strategy for {@link Injector Injector's}
 * 
 * @author Michael Clay - Initial contribution and API
 * 
 * @see com.google.inject.Injector
 * @deprecated Use org.eclipse.xtext.testing.IInjectorProvider instead
 */
@Deprecated(forRemoval = true)
public interface IInjectorProvider {

	Injector getInjector();

}
