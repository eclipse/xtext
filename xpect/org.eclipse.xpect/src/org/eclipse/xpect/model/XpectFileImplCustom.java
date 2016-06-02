/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xpect.model;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xpect.Member;
import org.eclipse.xpect.XpectIgnore;
import org.eclipse.xpect.XpectInvocation;
import org.eclipse.xpect.XpectJavaModel;
import org.eclipse.xpect.XpectTest;
import org.eclipse.xpect.parameter.IStatementRelatedRegion;
import org.eclipse.xpect.registry.ITestSuiteInfo;
import org.eclipse.xpect.registry.LazyClass;
import org.eclipse.xpect.setup.ISetupInitializer;
import org.eclipse.xpect.setup.SetupInitializer;
import org.eclipse.xpect.util.XpectJavaModelManager;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class XpectFileImplCustom extends XpectFileImpl {

	private Map<String, XpectInvocation> id2invocation;

	private XpectJavaModel javaModel;

	@Override
	public <T> ISetupInitializer<T> createSetupInitializer() {
		XpectTest test = getTest();
		if (test != null && !test.eIsProxy())
			return new SetupInitializer<T>(test);
		return new ISetupInitializer.Null<T>();
	}

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
	public XpectInvocation getInvocationAt(int offset) {
		if (offset < 0)
			return null;
		EList<Member> members = getMembers();
		for (Member member : members) {
			if (member instanceof XpectInvocation) {
				XpectInvocation invocation = (XpectInvocation) member;
				IStatementRelatedRegion region = invocation.getExtendedRegion();
				int o = region.getOffset();
				int e = o + region.getLength();
				if (o <= offset && offset <= e)
					return invocation;
			}
		}
		return null;
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
