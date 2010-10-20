/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.scoping.newAPI;

import static org.eclipse.emf.ecore.EcorePackage.Literals.*;

import java.util.Iterator;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.scoping.newapi.INewScope;
import org.eclipse.xtext.xbase.scoping.newapi.IterableBasedScope;
import org.eclipse.xtext.xbase.scoping.newapi.Selectors;

import com.google.common.collect.Sets;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IterableBasedScopeTest extends TestCase {
	
	public void testSelectByName() throws Exception {
		IEObjectDescription description = description(EATTRIBUTE);
		IterableBasedScope scope = new IterableBasedScope(Sets.newHashSet(description,description(ETYPED_ELEMENT__LOWER_BOUND)),
				new IterableBasedScope(Sets.newHashSet(description,description(EMODEL_ELEMENT)), INewScope.NULL_SCOPE));
		QualifiedName eAttributeQN = QualifiedName.create(EATTRIBUTE.getName());
		assertSame(description, scope.getFirstElement(Selectors.byName(eAttributeQN)));
		Iterator<? extends IEObjectDescription> iterable = scope.getElements(Selectors.byName(eAttributeQN)).iterator();
		assertSame(description, iterable.next());
		assertFalse(iterable.hasNext());
	}
	
	public void testSelectByEObject() throws Exception {
		IEObjectDescription description = description(EATTRIBUTE);
		IterableBasedScope scope = new IterableBasedScope(Sets.newHashSet(description,description(ETYPED_ELEMENT__LOWER_BOUND)),
				new IterableBasedScope(Sets.newHashSet(description,description(EMODEL_ELEMENT)), INewScope.NULL_SCOPE));
		assertSame(description, scope.getFirstElement(Selectors.byEObject(EATTRIBUTE)));
		Iterator<? extends IEObjectDescription> iterable = scope.getElements(Selectors.byEObject(EATTRIBUTE)).iterator();
		assertSame(description, iterable.next());
		assertFalse(iterable.hasNext());
	}

	protected IEObjectDescription description(ENamedElement element) {
		return EObjectDescription.create(QualifiedName.create(element.getName()), element, null);
	}
	
}
