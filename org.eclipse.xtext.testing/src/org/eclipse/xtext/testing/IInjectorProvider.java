/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.testing;

import com.google.inject.Injector;

/**
 * Producer strategy for {@link Injector Injector's}
 * 
 * @author Michael Clay - Initial contribution and API
 * 
 * @see com.google.inject.Injector
 */
public interface IInjectorProvider {

	Injector getInjector();

}
