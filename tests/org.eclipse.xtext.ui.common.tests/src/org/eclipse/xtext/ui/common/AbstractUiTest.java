/*******************************************************************************
 * __  ___            _   
 * \ \/ / |_ _____  __ |_
 *  \  /| __/ _ \ \/ / __|
 *  /  \| |_  __/>  <| |_
 * /_/\_\\__\___/_/\_\\__|
 * 
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common;

import java.lang.reflect.Method;
import java.util.Set;

import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.service.IServiceRegistrationFactory.IServiceRegistration;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class AbstractUiTest extends AbstractGeneratorTest {

	/**
	 * used to populate the serviceRegistry
	 */
	@SuppressWarnings("unchecked")
	protected void withUi(Class<?> standaloneSetup, Class<?> uiConfig) throws Exception {
		super.with(standaloneSetup);
		Method registrationsMethod = uiConfig.getMethod("registrations");
		Set<IServiceRegistration> uiServiceRegistrationSet = (Set<IServiceRegistration>) registrationsMethod
				.invoke(uiConfig.newInstance());
		for (IServiceRegistration serviceRegistration : uiServiceRegistrationSet) {
			ServiceRegistry.registerFactory(serviceRegistration.scope(), serviceRegistration.serviceFactory(),
					serviceRegistration.priority());
		}
	}
}
