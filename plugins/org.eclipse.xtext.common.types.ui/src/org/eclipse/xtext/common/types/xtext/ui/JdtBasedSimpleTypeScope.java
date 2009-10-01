/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.TypeNameRequestor;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.impl.Primitives;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProvider;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScope;
import org.eclipse.xtext.scoping.IScopedElement;
import org.eclipse.xtext.scoping.impl.ScopedElement;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JdtBasedSimpleTypeScope extends AbstractTypeScope {

	public JdtBasedSimpleTypeScope(JdtTypeProvider typeProvider) {
		super(typeProvider);
	}

	@Override
	public Iterable<IScopedElement> getContents() {
		final List<IScopedElement> allScopedElements = Lists.newArrayListWithExpectedSize(25000);
		try {
			IJavaSearchScope searchScope = SearchEngine.createJavaSearchScope(new IJavaElement[] { getTypeProvider().getJavaProject() });
			for(Class<?> clazz: Primitives.ALL_PRIMITIVE_TYPES) {
				IScopedElement primitive = createScopedElement(clazz.getName());
				if (primitive != null)
					allScopedElements.add(primitive);
			}
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
					IScopedElement scopedElement = createScopedElement(fqName.toString());
					if (scopedElement != null)
						allScopedElements.add(scopedElement);
				}
			};
			collectContents(searchScope, nameMatchRequestor);
		}
		catch (JavaModelException e) {
			// ignore
		}
		return allScopedElements;
	}
	
	public IScopedElement createScopedElement(String fullyQualifiedName) {
		String typeSignature = Signature.createTypeSignature(fullyQualifiedName, true);
		try {
			URI uri = getTypeProvider().getTypeUriHelper().getFullURI(typeSignature, null);
			InternalEObject proxy = (InternalEObject) TypesFactory.eINSTANCE.createVoid();
			proxy.eSetProxyURI(uri);
			IScopedElement scopedElement = ScopedElement.create(fullyQualifiedName, proxy);
			return scopedElement;
		}
		catch (JavaModelException e) {
			return null;
		}
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
	public JdtTypeProvider getTypeProvider() {
		return (JdtTypeProvider) super.getTypeProvider();
	}

}
