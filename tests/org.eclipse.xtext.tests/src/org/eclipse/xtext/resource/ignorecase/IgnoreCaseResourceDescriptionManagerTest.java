/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ignorecase;

import java.util.Collection;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.impl.DefaultResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IgnoreCaseResourceDescriptionManagerTest extends TestCase {

	private Resource resource;
	private DefaultResourceDescription resourceDescription;
	private IgnoreCaseResourceDescriptionManager manager;
	private Collection<String> importedNames;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		EObject copy = EcoreUtil.copy(EcorePackage.eINSTANCE);
		resource = new ResourceImpl();
		resource.getContents().add(copy);
		IQualifiedNameProvider nameProvider = new IQualifiedNameProvider.AbstractImpl() {
			public String getQualifiedName(EObject obj) {
				if (obj instanceof ENamedElement)
					return ((ENamedElement) obj).getName();
				return null;
			}
		};
		resourceDescription = new DefaultResourceDescription(resource, nameProvider) {
			@Override
			public Iterable<String> getImportedNames() {
				return importedNames;
			}
		};
		manager = new IgnoreCaseResourceDescriptionManager();
		importedNames = Collections.emptySet();
	}
	
	public void testIsAffected() {
		DefaultResourceDescriptionDelta delta = new DefaultResourceDescriptionDelta(null, resourceDescription);
		assertFalse(manager.isAffected(delta, resourceDescription));
		importedNames = Collections.singleton("eclass");
		assertTrue(manager.isAffected(delta, resourceDescription));
		importedNames = Collections.singleton("ECLASS");
		assertTrue(manager.isAffected(delta, resourceDescription));
	}
	
}
