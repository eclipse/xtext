/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.model;

import java.util.Map;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.xpect.XpectIgnore;
import org.xpect.XpectInvocation;
import org.xpect.XpectJavaModel;
import org.xpect.XpectTest;
import org.xpect.registry.ITestSuiteInfo;
import org.xpect.registry.LazyClass;
import org.xpect.util.XpectJavaModelManager;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class XpectFileImplCustom extends XpectFileImpl {

	private Map<String, XpectInvocation> id2invocation;

	private XpectJavaModel javaModel;

	private XpectJavaModel findJavaModel() {
		XtextResource resource = (XtextResource) eResource();
		ResourceSet resourceSet = (XtextResourceSet) resource.getResourceSet();
		XpectTest test = getTest();
		if (test != null) {
			JvmDeclaredType suite = test.getDeclaredSuite();
			if (suite != null) {
				if (suite.eIsProxy())
					return null;
				return XpectJavaModelManager.getOrCreate(suite);
			}
		}
		ITestSuiteInfo suiteInfo = ITestSuiteInfo.Registry.INSTANCE.getTestSuite(eResource());
		if (suiteInfo == null)
			return null;
		LazyClass<Object> lazyClass = suiteInfo.getClazz();
		if (lazyClass.getLoader() == null) {
			IJvmTypeProvider iJvmTypeProvider = resource.getResourceServiceProvider().get(IJvmTypeProvider.Factory.class).findOrCreateTypeProvider(resourceSet);
			JvmType eObject = iJvmTypeProvider.findTypeByName(lazyClass.getName());
			if (eObject instanceof JvmDeclaredType)
				return XpectJavaModelManager.getOrCreate((JvmDeclaredType) eObject);
		} else {
			Class<Object> clazz = lazyClass.load();
			return XpectJavaModelManager.getOrCreate(resourceSet, clazz);
		}
		return null;
	}

	public String getDocument() {
		return ((XtextResource) eResource()).getParseResult().getRootNode().getText();
	}

	@Override
	public XpectInvocation getInvocation(String id) {
		if (id2invocation == null)
			initalizeInvocationsIDs();
		return id2invocation.get(id);
	}

	@Override
	public Iterable<XpectInvocation> getInvocations() {
		return Iterables.filter(getMembers(), XpectInvocation.class);
	}

	@Override
	public XpectJavaModel getJavaModel() {
		if (javaModel == null)
			javaModel = findJavaModel();
		return javaModel;
	}

	@Override
	public XpectTest getTest() {
		return Iterables.getFirst(Iterables.filter(getMembers(), XpectTest.class), null);
	}

	public void initalizeInvocationsIDs() {
		Map<String, XpectInvocation> id2invocation = Maps.newHashMap();
		Map<String, Integer> counter = Maps.newHashMap();
		for (XpectInvocation inv : getInvocations()) {
			XpectInvocationImplCustom impl = (XpectInvocationImplCustom) inv;
			String name = impl.getMethodName();
			Integer count = counter.get(name);
			count = count == null ? 0 : count + 1;
			counter.put(name, count);
			String id = name + "~" + count;
			impl.setId(id);
			id2invocation.put(id, inv);
		}
		this.id2invocation = id2invocation;
	}

	@Override
	public boolean isIgnore() {
		return !Iterables.isEmpty(Iterables.filter(getMembers(), XpectIgnore.class));
	}

	public void unsetInvocationIDs() {
		if (id2invocation != null) {
			id2invocation = null;
			for (XpectInvocation inv : getInvocations())
				((XpectInvocationImplCustom) inv).setId(null);
		}
	}

	public void unsetJavaModel() {
		javaModel = null;
	}

}
