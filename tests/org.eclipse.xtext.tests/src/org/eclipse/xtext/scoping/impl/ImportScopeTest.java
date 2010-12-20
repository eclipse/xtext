/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import static com.google.common.collect.Lists.*;
import static org.eclipse.xtext.scoping.Selectors.*;

import java.util.Iterator;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.ISelector;

import junit.framework.TestCase;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ImportScopeTest extends TestCase {
	
	public void testImports_01() throws Exception {
		final IEObjectDescription desc1 = EObjectDescription.create(QualifiedName.create("com","foo","bar"), EcorePackage.Literals.EANNOTATION);
		final IEObjectDescription desc2 = EObjectDescription.create(QualifiedName.create("de","foo"), EcorePackage.Literals.EATTRIBUTE);
		SimpleScope outer = new SimpleScope(newArrayList(desc1,desc2), false);
		ImportNormalizer n1 = new ImportNormalizer(QualifiedName.create("com"), true);
		ImportNormalizer n2 = new ImportNormalizer(QualifiedName.create("de","foo"), false);
		ImportScope scope = new ImportScope(newArrayList(n1,n2), outer, new ScopeBasedSelectable(outer), EcorePackage.Literals.EOBJECT, false);
		
		final Iterable<IEObjectDescription> elements = scope.getElements(ISelector.SELECT_ALL);
		Iterator<IEObjectDescription> iterator = elements.iterator();
		assertEquals("foo.bar", iterator.next().getName().toString());
		assertEquals("foo", iterator.next().getName().toString());
		assertSame(desc1,iterator.next());
		assertSame(desc2,iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	public void testRelativeImports_01() throws Exception {
		final IEObjectDescription desc1 = EObjectDescription.create(QualifiedName.create("com","foo","bar"), EcorePackage.Literals.EANNOTATION);
		final IEObjectDescription desc2 = EObjectDescription.create(QualifiedName.create("de","foo"), EcorePackage.Literals.EATTRIBUTE);
		IScope outer = new SimpleScope(newArrayList(desc1,desc2), false);
		ImportNormalizer n1 = new ImportNormalizer(QualifiedName.create("com"), true);
		ImportNormalizer n2 = new ImportNormalizer(QualifiedName.create("de"), true);
		outer = new ImportScope(newArrayList(n1,n2), outer, new ScopeBasedSelectable(outer), EcorePackage.Literals.EOBJECT, false);
		
		n1 = new ImportNormalizer(QualifiedName.create("foo"), true);
		n2 = new ImportNormalizer(QualifiedName.create("foo"), false);
		ImportScope scope = new ImportScope(newArrayList(n1,n2), outer, new ScopeBasedSelectable(outer), EcorePackage.Literals.EOBJECT, false);
		
		final Iterable<IEObjectDescription> elements = scope.getElements(ISelector.SELECT_ALL);
		Iterator<IEObjectDescription> iterator = elements.iterator();
		assertEquals("bar", iterator.next().getName().toString());
		assertEquals("foo", iterator.next().getName().toString());
		assertEquals("foo.bar", iterator.next().getName().toString());
		assertSame(desc1,iterator.next());
		assertSame(desc2,iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	public void testDuplicatesNotVisible_01() throws Exception {
		final IEObjectDescription desc1 = EObjectDescription.create(QualifiedName.create("com","foo"), EcorePackage.Literals.EANNOTATION);
		final IEObjectDescription desc2 = EObjectDescription.create(QualifiedName.create("de","foo"), EcorePackage.Literals.EATTRIBUTE);
		SimpleScope outer = new SimpleScope(newArrayList(desc1,desc2), false);
		ImportNormalizer n1 = new ImportNormalizer(QualifiedName.create("com"), true);
		ImportNormalizer n2 = new ImportNormalizer(QualifiedName.create("de"), true);
		ImportScope scope = new ImportScope(newArrayList(n1,n2), outer, new ScopeBasedSelectable(outer), EcorePackage.Literals.EOBJECT, false);
		
		Iterator<IEObjectDescription> iterator = scope.getElements(ISelector.SELECT_ALL).iterator();
		assertSame(desc1,iterator.next());
		assertSame(desc2,iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	public void testDuplicatesNotVisible_01_IgnoreCase() throws Exception {
		final IEObjectDescription desc1 = new EObjectDescription(QualifiedName.create("com","foo"), EcorePackage.Literals.EANNOTATION, null);
		final IEObjectDescription desc2 = new EObjectDescription(QualifiedName.create("de","Foo"), EcorePackage.Literals.EATTRIBUTE, null);
		SimpleScope outer = new SimpleScope(newArrayList(desc1,desc2), true);
		ImportNormalizer n1 = new ImportNormalizer(QualifiedName.create("com"), true);
		ImportNormalizer n2 = new ImportNormalizer(QualifiedName.create("de"), true);
		ImportScope scope = new ImportScope(newArrayList(n1,n2), outer, new ScopeBasedSelectable(outer), EcorePackage.Literals.EOBJECT, true);
		
		Iterator<IEObjectDescription> iterator = scope.getElements(ISelector.SELECT_ALL).iterator();
		assertSame(desc1,iterator.next());
		assertSame(desc2,iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	public void testDuplicatesNotVisible_02() throws Exception {
		final IEObjectDescription desc1 = EObjectDescription.create(QualifiedName.create("com","foo"), EcorePackage.Literals.EANNOTATION);
		final IEObjectDescription desc2 = EObjectDescription.create(QualifiedName.create("de","foo"), EcorePackage.Literals.EATTRIBUTE);
		SimpleScope outer = new SimpleScope(newArrayList(desc1,desc2), false);
		ImportNormalizer n1 = new ImportNormalizer(QualifiedName.create("com"), true);
		ImportNormalizer n2 = new ImportNormalizer(QualifiedName.create("de"), true);
		ImportScope scope = new ImportScope(newArrayList(n1,n2), outer, new ScopeBasedSelectable(outer), EcorePackage.Literals.EOBJECT, false);
		
		assertNull(scope.getSingleElement(selectByName(QualifiedName.create("foo"))));
		assertNotNull(scope.getSingleElement(selectByName(QualifiedName.create("com","foo"))));
		assertNotNull(scope.getSingleElement(selectByName(QualifiedName.create("de","foo"))));
	}
	
	public void testDuplicatesNotVisible_02_IgnoreCase() throws Exception {
		final IEObjectDescription desc1 = new EObjectDescription(QualifiedName.create("com","foo"), EcorePackage.Literals.EANNOTATION, null);
		final IEObjectDescription desc2 = new EObjectDescription(QualifiedName.create("de","foo"), EcorePackage.Literals.EATTRIBUTE, null);
		SimpleScope outer = new SimpleScope(newArrayList(desc1,desc2), true);
		ImportNormalizer n1 = new ImportNormalizer(QualifiedName.create("com"), true);
		ImportNormalizer n2 = new ImportNormalizer(QualifiedName.create("de"), true);
		ImportScope scope = new ImportScope(newArrayList(n1,n2), outer, new ScopeBasedSelectable(outer), EcorePackage.Literals.EOBJECT, true);
		
		assertNull(scope.getSingleElement(selectByName(QualifiedName.create("Foo"))));
		assertNotNull(scope.getSingleElement(selectByName(QualifiedName.create("com","Foo"))));
		assertNotNull(scope.getSingleElement(selectByName(QualifiedName.create("de","Foo"))));
	}
}
