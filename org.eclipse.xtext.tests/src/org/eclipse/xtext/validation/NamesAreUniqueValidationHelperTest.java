/*******************************************************************************
 * Copyright (c) 2009, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.util.CancelIndicator;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NamesAreUniqueValidationHelperTest extends AbstractValidationMessageAcceptingTestCase implements CancelIndicator {
	
	private NamesAreUniqueValidationHelper helper;
	private int callCount;
	private int maxCallCount;
	private List<EObject> expected;
	private int created;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		helper = new NamesAreUniqueValidationHelper() {
			@Override 
			protected ImmutableSet<EClass> getClusterTypes() {
				return ImmutableSet.of(EcorePackage.Literals.ECLASSIFIER);
			}
		};
		callCount = 0;
		maxCallCount = 0;
		created = 0;
		expected = Lists.newArrayList();
	}
	
	@SuppressWarnings("deprecation")
	@Test public void testCancel_01() {
		maxCallCount = 1;
		try {
			helper.checkUniqueNames(
				Scopes.scopedElementsFor(ImmutableList.of(
						createEClass(),
						createEClass()
				)), 
				this, this);
			fail("should be canceled");
		} catch (OperationCanceledError e) {
		}
		assertEquals(maxCallCount, callCount);
	}
	
	@SuppressWarnings("deprecation")
	@Test public void testCancel_02() {
		maxCallCount = 0;
		helper.checkUniqueNames(
				Scopes.scopedElementsFor(ImmutableList.of(
						createEClass(),
						createEClass()
				)), 
				this, this);
		assertEquals(2, callCount);
	}
	
	@SuppressWarnings("deprecation")
	@Test public void testCancel_03() {
		maxCallCount = 0;
		helper.checkUniqueNames(
				Scopes.scopedElementsFor(ImmutableList.of(
						createEClass(),
						createEClass()
				)), 
				null, this);
		assertEquals(0, callCount);
	}
	
	@SuppressWarnings("deprecation")
	@Test public void testCreatedErrors_01() {
		maxCallCount = 0;
		ImmutableList<EClass> classes = ImmutableList.of(
				createEClass(),
				createEClass()
		);
		for(EClass clazz: classes) {
			clazz.setName("Same");
		}
		expected.addAll(classes);
		helper.checkUniqueNames(
				Scopes.scopedElementsFor(classes), 
				this, this);
		assertEquals(classes.size(), callCount);
		assertTrue(expected.isEmpty());
	}
	
	@Test public void testCreatedErrors_01_context() {
		maxCallCount = 0;
		ImmutableList<EClass> classes = ImmutableList.of(
				createEClass(),
				createEClass()
		);
		for(EClass clazz: classes) {
			clazz.setName("Same");
		}
		expected.addAll(classes);
		helper.checkUniqueNames(
				new LocalUniqueNameContext(classes, this), this);
		assertEquals(classes.size(), callCount);
		assertTrue(expected.isEmpty());
	}
	
	@SuppressWarnings("deprecation")
	@Test public void testCreatedErrors_02() {
		maxCallCount = 0;
		ImmutableList<EClassifier> classifiers = ImmutableList.of(
				createEClass(),
				createEDataType()
		);
		for(EClassifier classifier: classifiers) {
			classifier.setName("Same");
		}
		expected.addAll(classifiers);
		helper.checkUniqueNames(
				Scopes.scopedElementsFor(classifiers), 
				this, this);
		assertEquals(classifiers.size(), callCount);
		assertTrue(expected.isEmpty());
	}
	
	@Test public void testCreatedErrors_02_context() {
		maxCallCount = 0;
		ImmutableList<EClassifier> classifiers = ImmutableList.of(
				createEClass(),
				createEDataType()
				);
		for(EClassifier classifier: classifiers) {
			classifier.setName("Same");
		}
		expected.addAll(classifiers);
		helper.checkUniqueNames(
				new LocalUniqueNameContext(classifiers, this), this);
		assertEquals(classifiers.size(), callCount);
		assertTrue(expected.isEmpty());
	}
	
	@SuppressWarnings("deprecation")
	@Test public void testCreatedErrors_03() {
		maxCallCount = 0;
		ImmutableList<ENamedElement> elements = ImmutableList.of(
				createEClass(),
				createEDataType(),
				createEPackage()
		);
		for(ENamedElement classifier: elements) {
			classifier.setName("Same");
		}
		expected.addAll(elements.subList(0, 2));
		helper.checkUniqueNames(
				Scopes.scopedElementsFor(elements), 
				this, this);
		assertEquals(elements.size(), callCount);
		assertTrue(expected.isEmpty());
	}
	
	@Test public void testCreatedErrors_03_context() {
		maxCallCount = 0;
		ImmutableList<ENamedElement> elements = ImmutableList.of(
				createEClass(),
				createEDataType(),
				createEPackage()
		);
		for(ENamedElement classifier: elements) {
			classifier.setName("Same");
		}
		expected.addAll(elements.subList(0, 2));
		helper.checkUniqueNames(
				new LocalUniqueNameContext(elements, this), this);
		assertEquals(elements.size(), callCount);
		assertTrue(expected.isEmpty());
	}
	
	@SuppressWarnings("deprecation")
	@Test public void testCreatedErrors_04() {
		maxCallCount = 0;
		ImmutableList<ENamedElement> elements = ImmutableList.of(
				createEClass(),
				createEDataType(),
				createEPackage(),
				createEPackage()
		);
		for(ENamedElement classifier: elements) {
			classifier.setName("Same");
		}
		expected.addAll(elements);
		helper.checkUniqueNames(
				Scopes.scopedElementsFor(elements), 
				this, this);
		assertEquals(elements.size(), callCount);
		assertTrue(expected.isEmpty());
	}
	
	@Test public void testCreatedErrors_04_context() {
		maxCallCount = 0;
		ImmutableList<ENamedElement> elements = ImmutableList.of(
				createEClass(),
				createEDataType(),
				createEPackage(),
				createEPackage()
				);
		for(ENamedElement classifier: elements) {
			classifier.setName("Same");
		}
		expected.addAll(elements);
		helper.checkUniqueNames(
				new LocalUniqueNameContext(elements, this), this);
		assertEquals(elements.size(), callCount);
		assertTrue(expected.isEmpty());
	}
	
	@SuppressWarnings("deprecation")
	@Test public void testCreatedErrors_05() {
		maxCallCount = 0;
		ImmutableList<ENamedElement> elements = ImmutableList.of(
				createEPackage(),
				createEDataType(),
				createEPackage()
		);
		for(ENamedElement classifier: elements) {
			classifier.setName("Same");
		}
		expected.add(elements.get(0));
		expected.add(elements.get(2));
		helper.checkUniqueNames(
				Scopes.scopedElementsFor(elements), 
				this, this);
		assertEquals(elements.size(), callCount);
		assertTrue(expected.isEmpty());
	}
	
	@Test public void testCreatedErrors_05_context() {
		maxCallCount = 0;
		ImmutableList<ENamedElement> elements = ImmutableList.of(
				createEPackage(),
				createEDataType(),
				createEPackage()
				);
		for(ENamedElement classifier: elements) {
			classifier.setName("Same");
		}
		expected.add(elements.get(0));
		expected.add(elements.get(2));
		helper.checkUniqueNames(
				new LocalUniqueNameContext(elements, this), this);
		assertEquals(elements.size(), callCount);
		assertTrue(expected.isEmpty());
	}
	
	@SuppressWarnings("deprecation")
	@Test public void testCreatedErrors_06() {
		maxCallCount = 1;
		ImmutableList<ENamedElement> elements = ImmutableList.of(
				createEPackage(),
				createEDataType(),
				createEPackage()
		);
		for(ENamedElement classifier: elements) {
			classifier.setName("Same");
		}
		try {
			helper.checkUniqueNames(
					Scopes.scopedElementsFor(elements), 
					this, this);
			fail("cancellation expected");
		} catch (OperationCanceledError e) {
		}
		assertEquals(1, callCount);
	}
	
	@Test public void testCreatedErrors_06_context() {
		maxCallCount = 1;
		ImmutableList<ENamedElement> elements = ImmutableList.of(
				createEPackage(),
				createEDataType(),
				createEPackage()
				);
		for(ENamedElement classifier: elements) {
			classifier.setName("Same");
		}
		try {
			helper.checkUniqueNames(
					new LocalUniqueNameContext(elements, this), this);
			fail("cancellation expected");
		} catch (OperationCanceledError e) {
		}
		assertEquals(1, callCount);
	}
	
	@SuppressWarnings("deprecation")
	@Test public void testCreatedErrors_07() {
		maxCallCount = 0;
		ImmutableList<ENamedElement> elements = ImmutableList.of(
				createEPackage(),
				createEDataType(),
				EcoreFactory.eINSTANCE.createEEnumLiteral()
		);
		for(ENamedElement classifier: elements) {
			classifier.setName("Same");
		}
		expected.add(elements.get(0));
		expected.add(elements.get(2));
		helper.checkUniqueNames(
				Scopes.scopedElementsFor(elements), 
				this, this);
		assertEquals(elements.size(), callCount);
		assertTrue(expected.isEmpty());
	}
	
	@Test public void testCreatedErrors_07_context() {
		maxCallCount = 0;
		ImmutableList<ENamedElement> elements = ImmutableList.of(
				createEPackage(),
				createEDataType(),
				EcoreFactory.eINSTANCE.createEEnumLiteral()
				);
		for(ENamedElement classifier: elements) {
			classifier.setName("Same");
		}
		expected.add(elements.get(0));
		expected.add(elements.get(2));
		helper.checkUniqueNames(
				new LocalUniqueNameContext(elements, this), this);
		assertEquals(elements.size(), callCount);
		assertTrue(expected.isEmpty());
	}
	
	@SuppressWarnings("deprecation")
	@Test public void testManyUnique() {
		List<ENamedElement> elements = new ArrayList<>();
		for(int i = 0; i < 1_000_000; i++) {
			EClass c = createEClass();
			c.setName("i" + i);
			elements.add(c);
		}
		maxCallCount = 0;
		helper.checkUniqueNames(
				Scopes.scopedElementsFor(elements), 
				this, this);
	}
	
	@Test public void testManyUnique_context() {
		List<ENamedElement> elements = new ArrayList<>();
		for(int i = 0; i < 1_000_000; i++) {
			EClass c = createEClass();
			c.setName("i" + i);
			elements.add(c);
		}
		maxCallCount = 0;
		helper.checkUniqueNames(
				new LocalUniqueNameContext(elements, this), this);
	}
	
	@SuppressWarnings("deprecation")
	@Test public void testManyOneDup() {
		List<ENamedElement> elements = new ArrayList<>();
		for(int i = 0; i < 100_000; i++) {
			EClass c = createEClass();
			if (i == 99_999) {
				c.setName("i1234");
			} else {
				c.setName("i" + i);
			}
			elements.add(c);
		}
		maxCallCount = 0;
		expected.add(elements.get(1_234));
		expected.add(elements.get(99_999));
		helper.checkUniqueNames(
				Scopes.scopedElementsFor(elements), 
				this, this);
	}
	
	@Test public void testManyOneDup_context() {
		List<ENamedElement> elements = new ArrayList<>();
		for(int i = 0; i < 100_000; i++) {
			EClass c = createEClass();
			if (i == 99_999) {
				c.setName("i1234");
			} else {
				c.setName("i" + i);
			}
			elements.add(c);
		}
		maxCallCount = 0;
		expected.add(elements.get(1_234));
		expected.add(elements.get(99_999));
		helper.checkUniqueNames(
				new LocalUniqueNameContext(elements, this), this);
	}
	
	@SuppressWarnings("deprecation")
	@Test public void testManyManyDup() {
		List<ENamedElement> elements = new ArrayList<>();
		for(int i = 0, j = 0; i < 100_000; i++) {
			if (i % 100 == 0) {
				j++;
			}
			EClass c = createEClass();
			c.setName("i" + j);
			elements.add(c);
		}
		maxCallCount = 0;
		expected.addAll(elements);
		helper.checkUniqueNames(
				Scopes.scopedElementsFor(elements), 
				this, this);
	}
	
	@Test public void testManyManyDup_context() {
		List<ENamedElement> elements = new ArrayList<>();
		for(int i = 0, j = 0; i < 100_000; i++) {
			if (i % 100 == 0) {
				j++;
			}
			EClass c = createEClass();
			c.setName("i" + j);
			elements.add(c);
		}
		maxCallCount = 0;
		expected.addAll(elements);
		helper.checkUniqueNames(
				new LocalUniqueNameContext(elements, this), this);
	}
	
	@Test public void testErrorMessage_01() {
		EClass eClass = createEClass();
		eClass.setName("EClassName");
		IEObjectDescription description = EObjectDescription.create(QualifiedName.create(eClass.getName()), eClass);
		String errorMessage = helper.getDuplicateNameErrorMessage(description, EcorePackage.Literals.ECLASSIFIER, EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		assertEquals("Duplicate EClassifier 'EClassName'", errorMessage);
	}
	
	@Test public void testErrorMessage_02() {
		EClass eClass = createEClass();
		eClass.setName("EClassName");
		IEObjectDescription description = EObjectDescription.create(QualifiedName.create(eClass.getName()), eClass);
		String errorMessage = helper.getDuplicateNameErrorMessage(description, EcorePackage.Literals.ECLASS, EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		assertEquals("Duplicate EClass 'EClassName'", errorMessage);
	}
	
	@Test public void testErrorMessage_03() {
		EClass eClass = createEClass();
		eClass.setName("EClassName");
		EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
		attribute.setName("Attribute");
		eClass.getEStructuralFeatures().add(attribute);
		IEObjectDescription description = EObjectDescription.create(QualifiedName.create(eClass.getName(), attribute.getName()), attribute);
		String errorMessage = helper.getDuplicateNameErrorMessage(description, EcorePackage.Literals.EATTRIBUTE, EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		assertEquals("Duplicate EAttribute 'Attribute' in EClass 'EClassName'", errorMessage);
	}
	
	@Test public void testErrorMessage_04() {
		EClass eClass = createEClass();
		eClass.setName("EClassName");
		EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
		attribute.setName("Attribute");
		eClass.getEStructuralFeatures().add(attribute);
		IEObjectDescription description = EObjectDescription.create(QualifiedName.create(attribute.getName()), attribute);
		String errorMessage = helper.getDuplicateNameErrorMessage(description, EcorePackage.Literals.EATTRIBUTE, EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		assertEquals("Duplicate EAttribute 'Attribute' in EClass 'EClassName'", errorMessage);
	}

	private EClass createEClass() {
		EClass result = EcoreFactory.eINSTANCE.createEClass();
		result.setName(String.valueOf(created++));
		return result;
	}
	
	private EDataType createEDataType() {
		EDataType result = EcoreFactory.eINSTANCE.createEDataType();
		result.setName(String.valueOf(created++));
		return result;
	}
	
	private EPackage createEPackage() {
		EPackage result = EcoreFactory.eINSTANCE.createEPackage();
		result.setName(String.valueOf(created++));
		return result;
	}

	@Override
	public boolean isCanceled() {
		callCount++;
		if (callCount == maxCallCount)
			return true;
		return false;
	}

	@Override
	public void acceptError(String message, EObject object, EStructuralFeature feature, int index, String code, String... issueData) {
		assertFalse("Did not expected: " + message, expected.isEmpty());
		assertSame(expected.remove(0), object);
		assertEquals(EcorePackage.ENAMED_ELEMENT__NAME, object.eClass().getFeatureID(feature));
		assertEquals(EcorePackage.Literals.ENAMED_ELEMENT__NAME, feature);
		assertNull(code);
		assertNotNull(message);
	}

}
