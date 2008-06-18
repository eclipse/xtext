/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.ParsetreeFactory;

import junit.framework.TestCase;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public abstract class AbstractEasyMockTest extends TestCase {

	private IMocksControl control = null;

	public AbstractEasyMockTest() {
		super();
	}

	public AbstractEasyMockTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		control = EasyMock.createNiceControl();
	}

	@Override
	protected void runTest() throws Throwable {
		super.runTest();
		control.verify();
	}

	protected <T> T createMock(Class<T> clazz) {
		return control.createMock(clazz);
	}

	protected <T> T createMock(String name, Class<T> clazz) {
		return control.createMock(name, clazz);
	}

	protected void replay() {
		control.replay();
	}

	protected LeafNode createLeafNode() {
		return ParsetreeFactory.eINSTANCE.createLeafNode();
	}

	protected LeafNode createSLComment() {
		LeafNode leafNode = createLeafNode();
		Grammar grammar = new XtextBuiltinGrammarAccess().getGrammar();
		LexerRule lr = (LexerRule) GrammarUtil.findRuleForName(grammar, "SL_COMMENT");
		leafNode.setGrammarElement(lr);
		leafNode.setText("//single line comment\n");
		return leafNode;
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
	protected <T> T createVeryNiceMock(Class<T> service) {
		InvocationHandler handler = new InvocationHandlerImpl();

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

	private final class InvocationHandlerImpl implements InvocationHandler {
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if (!method.getReturnType().equals(Void.TYPE))
				return createVeryNiceMock(method.getReturnType());
			return null;
		}
	}

}