/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

import com.google.common.collect.Sets;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public class EcoreUtil2Test extends AbstractXtextTests {
	static private final EClass EOBJECT = EcorePackage.Literals.EOBJECT; 
	
	private EClass createEClass(String name) {
		EClass result = EcoreFactory.eINSTANCE.createEClass();
		result.setName(name);
		return result;
	}
	
	private EDataType createEDataType(String name, Class<?> instanceClass) {
		EDataType result = EcoreFactory.eINSTANCE.createEDataType();
		result.setName(name);
		result.setInstanceClass(instanceClass);
		return result;
	}
	
	@Test public void testSimple() throws Exception {
		ResourceSet rs = new ResourceSetImpl();
		Resource foo = rs.createResource(URI.createURI("foo.xmi"), ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		foo.getContents().add(ePackage);
		Resource bar = rs.createResource(URI.createURI("bar.xmi"), ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		bar.getContents().add(EcoreFactory.eINSTANCE.createEAttribute());
		
		assertEquals(true, EcoreUtil2.isValidUri(ePackage, URI.createURI("bar.xmi")));
	}

	@Test public void testEPackageURI() throws Exception {
		ResourceSet rs = new ResourceSetImpl();
		Resource foo = rs.createResource(URI.createURI("foo.xmi"), ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		foo.getContents().add(ePackage);
		
		assertEquals(true, EcoreUtil2.isValidUri(ePackage, URI.createURI(EcorePackage.eNS_URI)));
	}
	
	@Test public void testClone() throws Exception {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,
				new XMIResourceFactoryImpl());
		EPackage.Registry.INSTANCE.put(EcorePackage.eINSTANCE.getNsURI(), EcorePackage.eINSTANCE);
		
		ResourceSetImpl rs = new ResourceSetImpl();
		Resource r1 = rs.createResource(URI.createURI("foo.xmi"), ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		Resource r2 = rs.createResource(URI.createURI("bar.xmi"), ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		EClass a = EcoreFactory.eINSTANCE.createEClass();
		a.setName("a");
		EClass b = EcoreFactory.eINSTANCE.createEClass();
		r1.getContents().add(a);
		b.setName("b");
		b.getESuperTypes().add(a);
		r2.getContents().add(b);
		
		ResourceSetImpl clone = EcoreUtil2.clone(new ResourceSetImpl(), rs);
		EList<Resource> list = clone.getResources();
		
		Resource resA = list.get(0);
		assertEquals(URI.createURI("foo.xmi"),resA.getURI());
		assertNotSame(resA, r1);
		
		Resource resB = list.get(1);
		assertEquals(URI.createURI("bar.xmi"),resB.getURI());
		assertNotSame(resB, r2);
		
		EClass a1 = (EClass)resA.getContents().get(0);
		EClass b1 = (EClass)resB.getContents().get(0);
		assertEquals("a", a1.getName());
		assertNotSame(a, a1);
		assertEquals("b", b1.getName());
		assertNotSame(b, b1);
		assertSame(b1.getESuperTypes().get(0),a1);
		assertSame(b.getESuperTypes().get(0),a);
	}

	@Test
	public void testClone_2() throws Exception {
		ResourceSetImpl sourceSet = new DerivedStateAwareResourceSet();
		DerivedStateAwareResource resource = (DerivedStateAwareResource) sourceSet.createResource(URI
				.createURI("http://derived.res"));
		boolean stateToCheck = !resource.isFullyInitialized();
		resource.setFullyInitialized(stateToCheck);
		
		Resource targetRes = EcoreUtil2.clone(new DerivedStateAwareResourceSet(), sourceSet).getResources().get(0);
		
		assertTrue(targetRes instanceof DerivedStateAwareResource);
		assertEquals("FullyInitialized flag not copied ", stateToCheck, ((DerivedStateAwareResource) targetRes).isFullyInitialized());
	}
	
	private final class DerivedStateAwareResourceSet extends ResourceSetImpl {
		@Override
		public Resource createResource(URI uri) {
			DerivedStateAwareResource result = new DerivedStateAwareResource();
			getResources().add(result);
			return result;
		}
	}
	
	@Test public void testCommonCompatibleType01() {
		EClass a = createEClass("a");
		EClass b = createEClass("b");
		EClass c = createEClass("c");
		EClass d = createEClass("d");
		EClass e = createEClass("e");
		EClass f = createEClass("f");

		c.getESuperTypes().add(a);
		d.getESuperTypes().add(c);
		d.getESuperTypes().add(b);
		e.getESuperTypes().add(c);
		f.getESuperTypes().add(a);
		f.getESuperTypes().add(b);
		f.getESuperTypes().add(e);

		assertSame(a, EcoreUtil2.getCompatibleType(a, a));
		assertSame(EOBJECT, EcoreUtil2.getCompatibleType(d, f));
		assertSame(c, EcoreUtil2.getCompatibleType(d, e));
		assertSame(b, EcoreUtil2.getCompatibleType(b, f));
		assertSame(EOBJECT, EcoreUtil2.getCompatibleType(b, c));
	}

	@Test public void testCommonCompatibleType02() {
		EClass a = createEClass("a");
		EClass b = createEClass("b");
		EClass c = createEClass("c");
		EClass d = createEClass("d");
		EClass e = createEClass("e");

		b.getESuperTypes().add(a);
		c.getESuperTypes().add(a);
		d.getESuperTypes().add(b);
		d.getESuperTypes().add(c);
		e.getESuperTypes().add(b);
		e.getESuperTypes().add(c);

		assertSame(a, EcoreUtil2.getCompatibleType(a, a));

		assertSame(a, EcoreUtil2.getCompatibleType(b, c));
		assertSame(b, EcoreUtil2.getCompatibleType(b, d));
		assertSame(a, EcoreUtil2.getCompatibleType(d, e));
	}
	
	@Test public void testGetCompatibleType_01() {
		EDataType aString = createEDataType("a", String.class);
		EDataType anotherString = createEDataType("b", String.class);
		
		assertSame(aString, EcoreUtil2.getCompatibleType(aString, anotherString, null));
		assertSame(anotherString, EcoreUtil2.getCompatibleType(anotherString, aString, null));
	}
	
	@Test public void testGetCompatibleType_02() {
		EDataType aString = createEDataType("a", String.class);
		EDataType anObject = createEDataType("b", Object.class);
		
		assertSame(anObject, EcoreUtil2.getCompatibleType(aString, anObject, null));
		assertSame(anObject, EcoreUtil2.getCompatibleType(anObject, aString, null));
	}
	
	@Test public void testGetCompatibleType_03() {
		EDataType aCharSequence = createEDataType("a", CharSequence.class);
		EDataType anAppendable = createEDataType("b", Appendable.class);
		
		assertSame(null, EcoreUtil2.getCompatibleType(aCharSequence, anAppendable, null));
		assertSame(null, EcoreUtil2.getCompatibleType(anAppendable, aCharSequence, null));
	}
	
	@Test public void testGetCompatibleType_04() {
		EDataType aString = createEDataType("a", String.class);
		EDataType anotherString = createEDataType("b", String.class);
		
		assertSame(aString, EcoreUtil2.getCompatibleType(aString, anotherString));
		assertSame(anotherString, EcoreUtil2.getCompatibleType(anotherString, aString));
	}
	
	@Test public void testGetCompatibleType_05() {
		EDataType aString = createEDataType("a", String.class);
		EDataType anObject = createEDataType("b", Object.class);
		
		assertSame(anObject, EcoreUtil2.getCompatibleType(aString, anObject));
		assertSame(anObject, EcoreUtil2.getCompatibleType(anObject, aString));
	}
	
	@Test public void testGetCompatibleType_06() {
		EDataType aCharSequence = createEDataType("a", CharSequence.class);
		EDataType anAppendable = createEDataType("b", Appendable.class);
		
		assertSame(null, EcoreUtil2.getCompatibleType(aCharSequence, anAppendable));
		assertSame(null, EcoreUtil2.getCompatibleType(anAppendable, aCharSequence));
	}
	
	@Test public void testGetAllSuperTypesWithCycle() {
		EClass a = createEClass("a");
		EClass b = createEClass("b");
		b.getESuperTypes().add(a);
		a.getESuperTypes().add(b);
		
		// inconsistent and quasi-unpredictable in complex scenarios due to caching
		assertTrue(a.getEAllSuperTypes().contains(a));
		assertFalse(b.getEAllSuperTypes().contains(b));
		
		// always stable
		assertTrue(EcoreUtil2.getAllSuperTypes(a).contains(a));
		assertTrue(EcoreUtil2.getAllSuperTypes(b).contains(b));
	}
	
	@Test public void testGetAllReferencedObjects() {
		EClass a = createEClass("a");
		EClass b = createEClass("b");
		
		EPackage pack = EcoreFactory.eINSTANCE.createEPackage();
		pack.setName("empty");
		pack.setNsPrefix("empty");
		pack.setNsURI("empty");
		pack.getEClassifiers().add(a);
		pack.getEClassifiers().add(b);
		
		EReference ref = EcoreFactory.eINSTANCE.createEReference();
		a.getEStructuralFeatures().add(ref);
		ref.setUpperBound(1);
		ref.setEType(b);
		EObject objA = pack.getEFactoryInstance().create(a);
		EObject objB = pack.getEFactoryInstance().create(b);
		List<EObject> res = EcoreUtil2.getAllReferencedObjects(objA, ref);
		assertNotNull(res);
		assertTrue(res.isEmpty());
		res = EcoreUtil2.getAllReferencedObjects(objA, ref);
		assertNotNull(res);
		objA.eSet(ref, objB);
	}
	
	@Test public void testExternalFormOfEReference() throws Exception {
		Registry registry = EPackage.Registry.INSTANCE;
		Set<String> uris = Sets.newHashSet(registry.keySet());
		for (String string : uris) {
			EPackage ePackage = registry.getEPackage(string);
			TreeIterator<Object> iterator = EcoreUtil.getAllProperContents(ePackage, true);
			while (iterator.hasNext()) {
				Object next = iterator.next();
				if (next instanceof EReference) {
					EReference ref = (EReference) next;
					String externalForm = EcoreUtil2.toExternalForm(ref);
					assertEquals(ref.toString() + " - " + externalForm, ref, EcoreUtil2.getEReferenceFromExternalForm(registry,externalForm));
				}
			}
		}
	}
	
	/**
	 * This test assumes that an EPackage with indexed references is no longer available.
	 */
	@Test public void testExternalFormOfEReferenceNoNPE() throws Exception {
		EReference reference = EcorePackage.Literals.EATTRIBUTE__EATTRIBUTE_TYPE;
		URI uri = EcoreUtil.getURI(reference);
		String externalForm = uri.toString();
		EReference foundReference = EcoreUtil2.getEReferenceFromExternalForm(EPackage.Registry.INSTANCE, externalForm);
		assertSame(reference, foundReference);
		String brokenExternalFrom = makeInvalid(externalForm);
		assertNull(EcoreUtil2.getEReferenceFromExternalForm(EPackage.Registry.INSTANCE, brokenExternalFrom));
		String shortExternalForm = EcoreUtil2.toExternalForm(reference);
		foundReference = EcoreUtil2.getEReferenceFromExternalForm(EPackage.Registry.INSTANCE, shortExternalForm);
		assertSame(reference, foundReference);
		String brokenShortExternalFrom = makeInvalid(shortExternalForm);
		assertNull(EcoreUtil2.getEReferenceFromExternalForm(EPackage.Registry.INSTANCE, brokenShortExternalFrom));
		brokenShortExternalFrom = shortExternalForm.replace('A', 'a');
		assertNull(EcoreUtil2.getEReferenceFromExternalForm(EPackage.Registry.INSTANCE, brokenShortExternalFrom));
	}

	protected String makeInvalid(String externalForm) {
		// this used to be Strings.toFirstUpper but the spec does not impose case sensitivity constraints on the scheme
		// so Ed decided to change that. In that sense, we now use another scheme instead of http:// which is xhttp://
		return 'x' + externalForm;
	}
}
