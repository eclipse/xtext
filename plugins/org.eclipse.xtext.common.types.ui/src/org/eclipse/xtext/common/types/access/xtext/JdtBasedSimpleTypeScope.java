/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.xtext;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.TypeNameRequestor;
import org.eclipse.xtext.common.types.IdentifyableElement;
import org.eclipse.xtext.common.types.Type;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.TypeNotFoundException;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopedElement;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.eclipse.xtext.scoping.impl.ScopedElement;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JdtBasedSimpleTypeScope extends AbstractScope {

	private final JdtTypeProvider typeProvider;

	public JdtBasedSimpleTypeScope(JdtTypeProvider typeProvider) {
		this.typeProvider = typeProvider;
	}

	public Iterable<IScopedElement> getContents() {
		IJavaSearchScope searchScope = SearchEngine.createJavaSearchScope(new IJavaElement[] { typeProvider.getJavaProject() });
		final List<IScopedElement> allScopedElements = Lists.newArrayListWithExpectedSize(25000);
		TypeNameRequestor nameMatchRequestor = new TypeNameRequestor() {
			@Override
			public void acceptType(int modifiers, char[] packageName, char[] simpleTypeName,
					char[][] enclosingTypeNames, String path) {
				StringBuilder fqName = new StringBuilder(packageName.length + simpleTypeName.length + 1);
				if (packageName.length != 0) {
					fqName.append(packageName);
					fqName.append('.');
				}
				for(char[] enclosingType: enclosingTypeNames) {
					fqName.append(enclosingType);
					fqName.append('$');
				}
				fqName.append(simpleTypeName);
				String typeSignature = Signature.createTypeSignature(fqName.toString(), true);
				try {
					URI uri = typeProvider.getTypeUriHelper().getFullURI(typeSignature, null);
					InternalEObject proxy = (InternalEObject) TypesFactory.eINSTANCE.createVoid();
					proxy.eSetProxyURI(uri);
					IScopedElement scopedElement = ScopedElement.create(fqName.toString(), proxy);
					allScopedElements.add(scopedElement);
				}
				catch (JavaModelException e) {
					// ignore scoped element
				}
			}
		};
		try {
			collectContents(searchScope, nameMatchRequestor);
		}
		catch (JavaModelException e) {
			// ignore
		}
		return allScopedElements;
	}
	
	public void collectContents(IJavaSearchScope searchScope, TypeNameRequestor nameMatchRequestor) throws JavaModelException {
		new SearchEngine().searchAllTypeNames(
				null, 0, // match all package names
				null, 0, // and all type names,
				IJavaSearchConstants.TYPE, // search for types
				searchScope, // in the scope of the current project
				nameMatchRequestor, 
				IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, // wait for the jdt index to be ready
				new NullProgressMonitor());
	}
	
	@Override
	public IScopedElement getContentByName(String name) {
		try {
			Type type = typeProvider.findTypeByName(name);
			if (type == null)
				return null;
			return ScopedElement.create(name, type);
		} catch (TypeNotFoundException e) {
			return null;
		}
	}
	
	@Override
	public IScopedElement getContentByEObject(EObject object) {
		if (object instanceof IdentifyableElement) {
			return ScopedElement.create(((IdentifyableElement) object).getCanonicalName(), object);
		}
		return null;
	}

	public IScope getOuterScope() {
		return IScope.NULLSCOPE;
	}
	
	public JdtTypeProvider getTypeProvider() {
		return typeProvider;
	}

}
