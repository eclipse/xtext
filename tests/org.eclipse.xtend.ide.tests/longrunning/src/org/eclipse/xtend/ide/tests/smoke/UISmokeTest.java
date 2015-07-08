/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.smoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.tests.smoke.AbstractSmokeTest;
import org.eclipse.xtend.ide.common.highlighting.XtendHighlightingCalculator;
import org.eclipse.xtend.ide.internal.XtendActivator;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings({ "unused", "deprecation" })
public abstract class UISmokeTest extends AbstractSmokeTest {

//	@Inject
//	private WorkbenchTestHelper testHelper;
//	
//	@Inject
//	private XtendHighlightingCalculator highlighter;
//	
//	@Inject
//	private IOutlineTreeProvider outlineTreeProvider;
//
//	private IProject project;
//	
//	@BeforeClass
//	public void createProject() throws Exception {
//		project = WorkbenchTestHelper.createPluginProject("test");
//	}
//	
//	@AfterClass
//	public void removeProject() throws Exception {
//		WorkbenchTestHelper.deleteProject(project);
//	}
//	
//	@Override
//	public Injector doGetInjector() {
//		return XtendActivator.getInstance().getInjector("org.eclipse.xtend.core.Xtend");
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
