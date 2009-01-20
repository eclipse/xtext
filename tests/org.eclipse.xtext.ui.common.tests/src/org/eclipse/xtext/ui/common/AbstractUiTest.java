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

import org.eclipse.xtext.example.DomainmodelStandaloneSetup;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.service.IServiceRegistrationFactory.IServiceRegistration;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Michael Clay - Initial contribution and API
 */
public abstract class AbstractUiTest extends AbstractGeneratorTest {
	
	public final static Class<?>[] ADDITIONAL_UI_TEST_CLASSES = new Class[] { 
		DomainmodelStandaloneSetup.class,
	};
	
	static {
		for (Class<?> testClass : ADDITIONAL_UI_TEST_CLASSES) {
			try {
				Method doSetupMethod = testClass.getMethod("doSetup");
				doSetupMethod.invoke(null);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * used to populate the serviceRegistry
	 */
	@SuppressWarnings("unchecked")
	protected void withUi(Class<?> standaloneSetup, Class<?> uiConfig) throws Exception {
		super.with(standaloneSetup);
		Method registrationsMethod = uiConfig.getMethod("registrations");
		Set<IServiceRegistration> uiServiceRegistrationSet = (Set<IServiceRegistration>) registrationsMethod
				.invoke(uiConfig.newInstance());
		try {
			for (IServiceRegistration serviceRegistration : uiServiceRegistrationSet) {
				ServiceRegistry.registerFactory(serviceRegistration.scope(), serviceRegistration.serviceFactory(),
						serviceRegistration.priority());
			}
		}
		catch (Exception e) {}
	}
}
