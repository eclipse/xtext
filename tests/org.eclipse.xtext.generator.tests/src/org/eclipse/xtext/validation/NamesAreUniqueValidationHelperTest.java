/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NamesAreUniqueValidationHelperTest extends AbstractXtextTests implements CancelIndicator, ValidationMessageAcceptor {
	
	private NamesAreUniqueValidationHelper helper;
	private int callCount;
	private int maxCallCount;
	private List<EObject> expected;
	private int created;

	@Override
	protected void setUp() throws Exception {
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
	
	public void testCancel_01() {
		maxCallCount = 1;
		helper.checkUniqueNames(
				Scopes.scopedElementsFor(ImmutableList.of(
						createEClass(),
						createEClass()
				)), 
				this, this);
		assertEquals(maxCallCount, callCount);
	}
	
	public void testCancel_02() {
		maxCallCount = 0;
		helper.checkUniqueNames(
				Scopes.scopedElementsFor(ImmutableList.of(
						createEClass(),
						createEClass()
				)), 
				this, this);
		assertEquals(2, callCount);
	}
	
	public void testCancel_03() {
		maxCallCount = 0;
		helper.checkUniqueNames(
				Scopes.scopedElementsFor(ImmutableList.of(
						createEClass(),
						createEClass()
				)), 
				null, this);
		assertEquals(0, callCount);
	}
	
	public void testCreatedErrors_01() {
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
	
	public void testCreatedErrors_02() {
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
	
	public void testCreatedErrors_03() {
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
	
	public void testCreatedErrors_04() {
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
	
	public void testCreatedErrors_05() {
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
	
	public void testCreatedErrors_06() {
		maxCallCount = 1;
		ImmutableList<ENamedElement> elements = ImmutableList.of(
				createEPackage(),
				createEDataType(),
				createEPackage()
		);
		for(ENamedElement classifier: elements) {
			classifier.setName("Same");
		}
		helper.checkUniqueNames(
				Scopes.scopedElementsFor(elements), 
				this, this);
		assertEquals(1, callCount);
	}
	
	public void testCreatedErrors_07() {
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
	
	public void testErrorMessage_01() {
		EClass eClass = createEClass();
		eClass.setName("EClassName");
		IEObjectDescription description = EObjectDescription.create(eClass.getName(), eClass);
		String errorMessage = helper.getDuplicateNameErrorMessage(description, EcorePackage.Literals.ECLASSIFIER, EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		assertEquals("Duplicate EClassifier 'EClassName'", errorMessage);
	}
	
	public void testErrorMessage_02() {
		EClass eClass = createEClass();
		eClass.setName("EClassName");
		IEObjectDescription description = EObjectDescription.create(eClass.getName(), eClass);
		String errorMessage = helper.getDuplicateNameErrorMessage(description, EcorePackage.Literals.ECLASS, EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		assertEquals("Duplicate EClass 'EClassName'", errorMessage);
	}
	
	public void testErrorMessage_03() {
		EClass eClass = createEClass();
		eClass.setName("EClassName");
		EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
		attribute.setName("Attribute");
		eClass.getEStructuralFeatures().add(attribute);
		IEObjectDescription description = EObjectDescription.create(eClass.getName() + "." + attribute.getName(), attribute);
		String errorMessage = helper.getDuplicateNameErrorMessage(description, EcorePackage.Literals.EATTRIBUTE, EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		assertEquals("Duplicate EAttribute 'Attribute' in EClass 'EClassName'", errorMessage);
	}
	
	public void testErrorMessage_04() {
		EClass eClass = createEClass();
		eClass.setName("EClassName");
		EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
		attribute.setName("Attribute");
		eClass.getEStructuralFeatures().add(attribute);
		IEObjectDescription description = EObjectDescription.create(attribute.getName(), attribute);
		String errorMessage = helper.getDuplicateNameErrorMessage(description, EcorePackage.Literals.EATTRIBUTE, EcorePackage.Literals.ENAMED_ELEMENT__NAME);
		assertEquals("Duplicate EAttribute 'Attribute'", errorMessage);
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

	public boolean isCanceled() {
		callCount++;
		if (callCount == maxCallCount)
			return true;
		return false;
	}

	public void acceptError(String message, EObject object, Integer feature, Integer code) {
		assertFalse("Did not expected: " + message, expected.isEmpty());
		assertSame(expected.remove(0), object);
		assertEquals(EcorePackage.ENAMED_ELEMENT__NAME, feature.intValue());
		assertNull(code);
		assertNotNull(message);
	}

	public void acceptWarning(String message, EObject object, Integer feature, Integer code) {
		fail("unexpected");
	}

}
