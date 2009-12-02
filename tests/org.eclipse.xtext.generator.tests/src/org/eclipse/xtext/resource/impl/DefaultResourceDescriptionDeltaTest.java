/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultResourceDescriptionDeltaTest extends TestCase {
	static class TestResDesc extends AbstractResourceDescription {

		public List<IEObjectDescription> exported = Lists.newArrayList();
		public Set<String> imported = Sets.newHashSet();

		public Iterable<IEObjectDescription> getExportedObjects() {
			return exported;
		}

		public IEObjectDescription getExportedObjectForName(String name) {
			throw new UnsupportedOperationException();
		}

		public Iterable<String> getImportedNames() {
			return imported;
		}

		public URI getURI() {
			return URI.createURI("foo://test");
		}

		public Iterable<IReferenceDescription> getReferenceDescriptions() {
			return Iterables.emptyIterable();
		}
	}
	
	public void testHasChanges_1() throws Exception {
		TestResDesc resourceDesc = new TestResDesc();
		TestResDesc resourceDesc2 = new TestResDesc();
		assertFalse(new DefaultResourceDescriptionDelta(resourceDesc, resourceDesc2).hasChanges());
	}
	
	public void testHasChanges_2() throws Exception {
		TestResDesc resourceDesc = new TestResDesc();
		resourceDesc.imported.add("foo");
		
		TestResDesc resourceDesc2 = new TestResDesc();
		resourceDesc2.imported.add("foo");
		
		assertFalse(new DefaultResourceDescriptionDelta(resourceDesc, resourceDesc2).hasChanges());
	}
	
	public void testHasChanges_3() throws Exception {
		TestResDesc resourceDesc = new TestResDesc();
		resourceDesc.imported.add("foo");
		resourceDesc.exported.add(new EObjectDescription("bar", EcorePackage.Literals.EANNOTATION, null));
		
		TestResDesc resourceDesc2 = new TestResDesc();
		resourceDesc2.imported.add("foo");
		resourceDesc2.exported.add(new EObjectDescription("bar", EcorePackage.Literals.EANNOTATION, null));
		
		assertFalse(new DefaultResourceDescriptionDelta(resourceDesc, resourceDesc2).hasChanges());
	}
	public void testHasChanges_4() throws Exception {
		TestResDesc resourceDesc = new TestResDesc();
		resourceDesc.imported.add("foo");
		resourceDesc.imported.add("bar");
		resourceDesc.exported.add(new EObjectDescription("bar", EcorePackage.Literals.EANNOTATION, null));
		
		TestResDesc resourceDesc2 = new TestResDesc();
		resourceDesc2.imported.add("foo");
		resourceDesc2.imported.add("bar");
		resourceDesc2.exported.add(new EObjectDescription("bar", EcorePackage.Literals.EANNOTATION, null));
		
		assertFalse(new DefaultResourceDescriptionDelta(resourceDesc, resourceDesc2).hasChanges());
	}
	
	public void testHasChanges_5() throws Exception {
		TestResDesc resourceDesc = new TestResDesc();
		resourceDesc.imported.add("foo");
		resourceDesc.exported.add(new EObjectDescription("bar", EcorePackage.Literals.EANNOTATION, null));
		
		TestResDesc resourceDesc2 = new TestResDesc();
		resourceDesc2.imported.add("fop");
		resourceDesc2.exported.add(new EObjectDescription("bar", EcorePackage.Literals.EANNOTATION, null));
		
		assertFalse(new DefaultResourceDescriptionDelta(resourceDesc, resourceDesc2).hasChanges());
	}
	
	public void testHasChanges_6() throws Exception {
		TestResDesc resourceDesc = new TestResDesc();
		resourceDesc.exported.add(new EObjectDescription("bar", EcorePackage.Literals.EANNOTATION, null));
		
		TestResDesc resourceDesc2 = new TestResDesc();
		resourceDesc2.imported.add("fop");
		resourceDesc2.exported.add(new EObjectDescription("bar", EcorePackage.Literals.EANNOTATION, null));
		
		assertFalse(new DefaultResourceDescriptionDelta(resourceDesc, resourceDesc2).hasChanges());
	}
	
	public void testHasChanges_7() throws Exception {
		TestResDesc resourceDesc = new TestResDesc();
		resourceDesc.imported.add("foo");
		resourceDesc.exported.add(new EObjectDescription("bar", EcorePackage.Literals.EANNOTATION, Collections.singletonMap("foo", "bar")));
		
		TestResDesc resourceDesc2 = new TestResDesc();
		resourceDesc2.imported.add("foo");
		resourceDesc2.exported.add(new EObjectDescription("bar", EcorePackage.Literals.EANNOTATION, null));
		
		assertTrue(new DefaultResourceDescriptionDelta(resourceDesc, resourceDesc2).hasChanges());
	}
	
	public void testHasChanges_DifferentTypes() throws Exception {
		TestResDesc resourceDesc = new TestResDesc();
		resourceDesc.imported.add("foo");
		resourceDesc.exported.add(new EObjectDescription("bar", EcorePackage.Literals.EANNOTATION, Collections.singletonMap("foo", "bar")));
		
		TestResDesc resourceDesc2 = new TestResDesc();
		resourceDesc2.imported.add("foo");
		resourceDesc2.exported.add(new EObjectDescription("bar", EcorePackage.Literals.EANNOTATION__CONTENTS, Collections.singletonMap("foo", "bar")){
			@Override
			public URI getEObjectURI() {
				return EcoreUtil.getURI(EcorePackage.Literals.EANNOTATION);
			}
		}
		);
		
		assertTrue(new DefaultResourceDescriptionDelta(resourceDesc, resourceDesc2).hasChanges());
	}
	
	public void testHasChanges_DifferentURIs() throws Exception {
		TestResDesc resourceDesc = new TestResDesc();
		resourceDesc.imported.add("foo");
		resourceDesc.exported.add(new EObjectDescription("bar", EcorePackage.Literals.EANNOTATION, Collections.singletonMap("foo", "bar")));
		
		TestResDesc resourceDesc2 = new TestResDesc();
		resourceDesc2.imported.add("foo");
		resourceDesc2.exported.add(new EObjectDescription("bar", EcorePackage.Literals.EANNOTATION, Collections.singletonMap("foo", "bar")){
			@Override
			public URI getEObjectURI() {
				return super.getEObjectURI().appendFragment("foo");
			}
		}
		);
		
		assertTrue(new DefaultResourceDescriptionDelta(resourceDesc, resourceDesc2).hasChanges());
	}
	
	public void testHasChanges_MultipleEObjects() throws Exception {
		TestResDesc resourceDesc = new TestResDesc();
		resourceDesc.imported.add("foo");
		resourceDesc.exported.add(new EObjectDescription("bar", EcorePackage.Literals.EANNOTATION, Collections.singletonMap("foo", "bar")));
		resourceDesc.exported.add(new EObjectDescription("foo", EcorePackage.Literals.EANNOTATION, Collections.singletonMap("foo", "bar")));
		
		TestResDesc resourceDesc2 = new TestResDesc();
		resourceDesc2.imported.add("foo");
		resourceDesc2.exported.add(new EObjectDescription("bar", EcorePackage.Literals.EANNOTATION, Collections.singletonMap("foo", "bar")));
		resourceDesc2.exported.add(new EObjectDescription("foo", EcorePackage.Literals.EANNOTATION, Collections.singletonMap("foo", "bar")));
		
		assertFalse(new DefaultResourceDescriptionDelta(resourceDesc, resourceDesc2).hasChanges());
	}
	
	public void testHasChanged_differentOrder() throws Exception {
		TestResDesc resourceDesc = new TestResDesc();
		resourceDesc.imported.add("foo");
		resourceDesc.exported.add(new EObjectDescription("bar", EcorePackage.Literals.EANNOTATION, Collections.singletonMap("foo", "bar")));
		resourceDesc.exported.add(new EObjectDescription("foo", EcorePackage.Literals.EANNOTATION, Collections.singletonMap("foo", "bar")));
		
		TestResDesc resourceDesc2 = new TestResDesc();
		resourceDesc2.imported.add("foo");
		resourceDesc2.exported.add(new EObjectDescription("foo", EcorePackage.Literals.EANNOTATION, Collections.singletonMap("foo", "bar")));
		resourceDesc2.exported.add(new EObjectDescription("bar", EcorePackage.Literals.EANNOTATION, Collections.singletonMap("foo", "bar")));
		
		assertTrue(new DefaultResourceDescriptionDelta(resourceDesc, resourceDesc2).hasChanges());
	}
	
}
