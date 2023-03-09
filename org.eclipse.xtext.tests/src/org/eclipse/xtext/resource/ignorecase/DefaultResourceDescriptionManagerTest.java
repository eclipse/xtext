/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.ignorecase;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.impl.DefaultResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionManager;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultResourceDescriptionManagerTest extends Assert {

	private Resource resource;
	private DefaultResourceDescription resourceDescription;
	private DefaultResourceDescriptionManager manager;
	private Collection<QualifiedName> importedNames;

	@Before
	public void setUp() throws Exception {
		EObject copy = EcoreUtil.copy(EcorePackage.eINSTANCE);
		resource = new ResourceImpl();
		resource.getContents().add(copy);
		IQualifiedNameProvider nameProvider = new IQualifiedNameProvider.AbstractImpl() {
			@Override
			public QualifiedName getFullyQualifiedName(EObject obj) {
				if (obj instanceof ENamedElement)
					return QualifiedName.create(((ENamedElement) obj).getName());
				return null;
			}
		};
		DefaultResourceDescriptionStrategy descriptionStrategy = new DefaultResourceDescriptionStrategy();
		descriptionStrategy.setQualifiedNameProvider(nameProvider);
		resourceDescription = new DefaultResourceDescription(resource, descriptionStrategy) {
			@Override
			public Iterable<QualifiedName> getImportedNames() {
				return importedNames;
			}
		};
		manager = new DefaultResourceDescriptionManager();
		importedNames = Collections.emptySet();
	}
	
	@Test public void testIsAffected() {
		DefaultResourceDescriptionDelta delta = new DefaultResourceDescriptionDelta(null, resourceDescription);
		assertFalse(manager.isAffected(delta, resourceDescription));
		importedNames = Collections.singleton(QualifiedName.create("eclass"));
		assertTrue(manager.isAffected(delta, resourceDescription));
		importedNames = Collections.singleton(QualifiedName.create("ECLASS"));
		assertFalse(manager.isAffected(delta, resourceDescription));
	}
	
}
