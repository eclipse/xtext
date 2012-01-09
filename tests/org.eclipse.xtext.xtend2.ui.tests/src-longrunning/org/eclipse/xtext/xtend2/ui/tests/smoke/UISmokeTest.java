/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.smoke;

import org.eclipse.xtext.xtend2.tests.smoke.AbstractSmokeTest;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class UISmokeTest extends AbstractSmokeTest {

//	public static Test suite() {
//		return WorkbenchTestHelper.suite(UISmokeTest.class);
//	}
//	
//	@Inject
//	private WorkbenchTestHelper testHelper;
//	
//	@Inject
//	private XtendHighlightingCalculator highlighter;
//	
//	@Inject
//	private IOutlineTreeProvider outlineTreeProvider;
//	
//	@Override
//	public Injector doGetInjector() {
//		return Xtend2Activator.getInstance().getInjector("org.eclipse.xtext.xtend2.Xtend2");
//	}
//	
//	@Override
//	protected void checkForSmoke(final String model, final LazyLinkingResource resource) {
//		highlighter.provideHighlightingFor(resource, new IHighlightedPositionAcceptor() {
//			public void addPosition(int offset, int length, String... id) {
//			}
//		});
//		IXtextDocument document = (IXtextDocument) Proxy.newProxyInstance(
//				getClass().getClassLoader(), new Class[] { IXtextDocument.class }, new InvocationHandler() {
//			
//			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//				if ("readOnly".equals(method.getName())) {
//					@SuppressWarnings("unchecked")
//					IUnitOfWork<?, Resource> unit = (IUnitOfWork<?, Resource>) args[0];
//					Object result = unit.exec(resource);
//					return result;
//				}
//				if ("getLength".equals(method.getName())) {
//					return model.length();
//				}
//				return null;
//			}
//		});
//		IOutlineNode node = outlineTreeProvider.createRoot(document);
//		traverseNode(node);
//	}
//	
//	private void traverseNode(IOutlineNode node) {
//		node.getText();
//		for(IOutlineNode child: node.getChildren()) {
//			traverseNode(child);
//		}
//	}
//
//	@Override
//	protected XtextResourceSet getResourceSet() {
//		ResourceSet resourceSet = testHelper.getResourceSet();
//		return (XtextResourceSet) resourceSet;
//	}
	
}
