/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.testing;

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
 * @see org.eclipse.xtext.testing.IInjectorProvider
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE})
@Inherited
@Documented
public @interface InjectWith {
	/**
	 * the IInjectorProvider class which will be used to create an {@link Injector Injector}.
	 */
	Class<? extends IInjectorProvider> value();
}
