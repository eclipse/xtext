/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.services;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import junit.framework.TestCase;

import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.ParsetreeFactory;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.LanguageDescriptorFactory;
import org.eclipse.xtext.service.ServiceRegistry;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public abstract class AbstractServiceTest extends TestCase {

	static {
		Thread.currentThread().setContextClassLoader(AbstractServiceTest.class.getClassLoader());
	}
	private static final String DEFAULT_LANGUAGE = "org.eclipse.xtext.reference.ReferenceGrammar";
	private ILanguageDescriptor languageDescriptor;

	protected ILanguageDescriptor getDefaultTestLanguage() {
		if (languageDescriptor == null)
			languageDescriptor = LanguageDescriptorFactory.get(DEFAULT_LANGUAGE);
		return languageDescriptor;
	}

	protected <T extends ILanguageService> T getServiceForDefaultLanguage(Class<T> clazz) {
		return ServiceRegistry.getService(getDefaultTestLanguage(), clazz);
	}

	protected IParseResult getModelForDefaultLanguage(String model) {
		IParser parser = getServiceForDefaultLanguage(IParser.class);
		return parser.parse(new StringInputStream(model));
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected LeafNode createLeafNode() {
		return ParsetreeFactory.eINSTANCE.createLeafNode();
	}

	/**
	 * use at your own risk
	 * 
	 * @param <T>
	 * @param service
	 * @param handler
	 * @return mock
	 */
	@SuppressWarnings("unchecked")
	protected <T> T createMock(Class<T> service, InvocationHandler handler) {
		try {
			if (service.isInterface())
				return (T) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] { service }, handler);
			else if (service.isPrimitive()) {
				String name = service.getName();
				if (name.equals(Integer.TYPE.getName())) {
					return (T) Integer.valueOf(0);
				}
				else if (name.equals(Boolean.TYPE.getName())) {
					return (T) Boolean.valueOf(false);
				}
				return (T) Class.forName(service.getName()).newInstance();
			}
			else {
				return service.newInstance();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	protected final class InvocationHandlerImpl implements InvocationHandler {
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if (!method.getReturnType().equals(Void.TYPE))
				return createMock(method.getReturnType(), this);
			return null;
		}
	}
}
