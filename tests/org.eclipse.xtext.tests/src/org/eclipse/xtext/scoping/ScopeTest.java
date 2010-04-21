/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping;

import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.eclipse.xtext.scoping.impl.MapBasedScope;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Holger Schill - Contribution to Bug 309764
 */
public class ScopeTest extends TestCase {

	private AbstractScope scope;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		scope = getEcoreClassifiersScope();
	}

	public void testContentByEObject_existent() throws Exception {
		assertNotNull(scope.getContentByEObject(EcorePackage.eINSTANCE.getEAnnotation()));
	}

	public void testContentByEObject_nonExistent() throws Exception {
		assertNull(scope.getContentByEObject(EcorePackage.eINSTANCE.getEAnnotation_Contents()));
	}

	public void testContentByEObject_withProxy() throws Exception {
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		((InternalEObject) eClass).eSetProxyURI(EcoreUtil.getURI(EcorePackage.eINSTANCE.getEAnnotation()));
		assertNotNull(scope.getContentByEObject(eClass));
	}

	public void testContentByName_existent() throws Exception {
		String name = EcorePackage.eINSTANCE.getEAnnotation().getName();
		assertEquals(name, scope.getContentByName(name).getName());
	}

	public void testContentByName_nonExistent() throws Exception {
		assertNull(scope.getContentByName("unknown_name"));
	}

	public void testContentByEObject_NotShadowed() throws Exception {
		AbstractScope scopeWithEqualNamedElements = getScopeWithSimpleNames(true);
		assertNotNull(scopeWithEqualNamedElements.getContentByEObject(EcorePackage.eINSTANCE.getEBigDecimal()));
	}
	
	public void testContentByEObject_Shadowed() throws Exception {
		AbstractScope scopeWithEqualNamedElements = getScopeWithSimpleNames(false);
		assertNull(scopeWithEqualNamedElements.getContentByEObject(EcorePackage.eINSTANCE.getEBigDecimal()));
	}

	private AbstractScope getEcoreClassifiersScope() {
		return new AbstractScope() {
			public IScope getOuterScope() {
				return getEcoreClassesScope();
			}

			@Override
			public Iterable<IEObjectDescription> internalGetContents() {
				return Scopes.scopedElementsFor(Iterables.filter(EcorePackage.eINSTANCE.getEClassifiers(),
						EDataType.class));
			}
		};
	}

	private AbstractScope getEcoreClassesScope() {
		return new AbstractScope() {
			public IScope getOuterScope() {
				return IScope.NULLSCOPE;
			}

			@Override
			public Iterable<IEObjectDescription> internalGetContents() {
				return Scopes.scopedElementsFor(Iterables
						.filter(EcorePackage.eINSTANCE.getEClassifiers(), EClass.class));
			}
		};
	}

	private AbstractScope getScopeWithSimpleNames(boolean thirdLevelElementsEnabled) {
		String prefix = "prefix.";
		String simpleName = "test";
		Map<String, IEObjectDescription> mapFirstLevel = Maps.newHashMap();
		mapFirstLevel.put(simpleName,new EObjectDescription(simpleName,EcorePackage.eINSTANCE.getEBigInteger(), null));
		Map<String, IEObjectDescription> mapSecondLevel =  Maps.newHashMap();
		mapSecondLevel.put(simpleName,new EObjectDescription(simpleName,EcorePackage.eINSTANCE.getEBigDecimal(), null));
		Map<String, IEObjectDescription> thirdLevel =  Maps.newHashMap();
		thirdLevel.put(prefix + simpleName,new EObjectDescription(prefix + simpleName,EcorePackage.eINSTANCE.getEBigDecimal(), null));
		MapBasedScope grandParent = new MapBasedScope(IScope.NULLSCOPE, thirdLevel);
		MapBasedScope parent = new MapBasedScope(thirdLevelElementsEnabled?grandParent:IScope.NULLSCOPE, mapSecondLevel);
		return new MapBasedScope(parent,mapFirstLevel);
	}
	
}
