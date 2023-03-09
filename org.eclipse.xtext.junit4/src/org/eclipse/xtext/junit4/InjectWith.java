/*******************************************************************************
 * Copyright (c) 2011, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Class level annotation to configure an {@link IInjectorProvider} to resolve dependencies via Guice.
 * 
 * @author Michael Clay - Initial contribution and API
 * @see org.eclipse.xtext.junit4.model.IInjectorProvider
 * @deprecated Use org.eclipse.xtext.testing.InjectWith instead
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE})
@Inherited
@Documented
@Deprecated(forRemoval = true)
public @interface InjectWith {
	/**
	 * the IInjectorProvider class which will be used to create an {@link Injector Injector}.
	 */
	Class<? extends IInjectorProvider> value();
}
