/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import static com.google.common.collect.Iterables.*;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.linking.LangATestLanguageStandaloneSetup;
import org.eclipse.xtext.linking.langATestLanguage.LangATestLanguagePackage;
import org.eclipse.xtext.linking.langATestLanguage.Main;
import org.eclipse.xtext.linking.lazy.LazyURIEncoder;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultReferenceDescriptionTest extends AbstractXtextTests {
	
	@Test public void testgetReferenceDescriptions() throws Exception {
		with(new LangATestLanguageStandaloneSetup());
		XtextResource targetResource = getResource("type C", "bar.langatestlanguage");
		EObject typeC = targetResource.getContents().get(0).eContents().get(0);
		XtextResource resource = (XtextResource) targetResource.getResourceSet().createResource(URI.createURI("foo.langatestlanguage"));
		resource.load(new StringInputStream("type A extends C type B extends A"), null);
		EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl);
		IResourceDescription resDesc = resource.getResourceServiceProvider().getResourceDescriptionManager().getResourceDescription(resource);
		Iterable<IReferenceDescription> descriptions = resDesc.getReferenceDescriptions();
		Collection<IReferenceDescription> collection = Lists.newArrayList(descriptions);
		assertEquals(1,collection.size());
		IReferenceDescription refDesc = descriptions.iterator().next();
		Main m = (Main) resource.getParseResult().getRootASTElement();
		assertEquals(m.getTypes().get(0),resource.getResourceSet().getEObject(refDesc.getSourceEObjectUri(),false));
		assertEquals(typeC, resource.getResourceSet().getEObject(refDesc.getTargetEObjectUri(),false));
		assertEquals(-1,refDesc.getIndexInList());
		assertEquals(LangATestLanguagePackage.Literals.TYPE__EXTENDS,refDesc.getEReference());
	}
	
	@Test public void testgetReferenceDescriptionForMultiValue() throws Exception {
		with(new LangATestLanguageStandaloneSetup());
		XtextResource targetResource = getResource("type C type D", "bar.langatestlanguage");
		EObject typeC = targetResource.getContents().get(0).eContents().get(0);
		EObject typeD = targetResource.getContents().get(0).eContents().get(1);
		XtextResource resource = (XtextResource) targetResource.getResourceSet().createResource(URI.createURI("foo.langatestlanguage"));
		resource.load(new StringInputStream("type A implements B,C,D type B"), null);
		EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl);
		IResourceDescription resDesc = resource.getResourceServiceProvider().getResourceDescriptionManager().getResourceDescription(resource);
		Iterable<IReferenceDescription> descriptions = resDesc.getReferenceDescriptions();
		Collection<IReferenceDescription> collection = Lists.newArrayList(descriptions);
		assertEquals(2,collection.size());
		Iterator<IReferenceDescription> iterator = descriptions.iterator();
		IReferenceDescription refDesc1 = iterator.next();
		IReferenceDescription refDesc2 = iterator.next();
		Main m = (Main) resource.getParseResult().getRootASTElement();
		assertEquals(m.getTypes().get(0),resource.getResourceSet().getEObject(refDesc1.getSourceEObjectUri(),false));
		assertEquals(typeC,resource.getResourceSet().getEObject(refDesc1.getTargetEObjectUri(),false));
		assertEquals(1,refDesc1.getIndexInList());
		assertEquals(LangATestLanguagePackage.Literals.TYPE__IMPLEMENTS,refDesc1.getEReference());
		assertEquals(m.getTypes().get(0),resource.getResourceSet().getEObject(refDesc2.getSourceEObjectUri(),false));
		assertEquals(typeD,resource.getResourceSet().getEObject(refDesc2.getTargetEObjectUri(),false));
		assertEquals(2,refDesc2.getIndexInList());
		assertEquals(LangATestLanguagePackage.Literals.TYPE__IMPLEMENTS,refDesc2.getEReference());
	}
	
	@Test public void testSpecialReferences() {
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName("test");
		ePackage.setNsPrefix("test");
		ePackage.setNsURI("test");

		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName("Test");
		eClass.getESuperTypes().add(EcorePackage.Literals.EPACKAGE);
		ePackage.getEClassifiers().add(eClass);

		EReference eReference1 = EcoreFactory.eINSTANCE.createEReference();
		eReference1.setContainment(false);
		eReference1.setName("onlyExportedRef");
		eReference1.setEType(EcorePackage.Literals.EPACKAGE);
		eClass.getEStructuralFeatures().add(eReference1);

		EReference eReference2 = EcoreFactory.eINSTANCE.createEReference();
		eReference2.setContainment(true);
		eReference2.setName("containmentRef");
		eReference2.setEType(EcorePackage.Literals.EPACKAGE);
		eClass.getEStructuralFeatures().add(eReference2);

		EReference eReference3 = EcoreFactory.eINSTANCE.createEReference();
		eReference3.setContainment(false);
		eReference3.setTransient(true);
		eReference3.setName("transientRef");
		eReference3.setEType(EcorePackage.Literals.EPACKAGE);
		eClass.getEStructuralFeatures().add(eReference3);

		EReference eReference4 = EcoreFactory.eINSTANCE.createEReference();
		eReference4.setContainment(false);
		eReference4.setVolatile(true);
		eReference4.setName("volatileRef");
		eReference4.setEType(EcorePackage.Literals.EPACKAGE);
		eClass.getEStructuralFeatures().add(eReference4);

		EReference eReference5 = EcoreFactory.eINSTANCE.createEReference();
		eReference5.setContainment(false);
		eReference5.setDerived(true);
		eReference5.setName("derivedRef");
		eReference5.setEType(EcorePackage.Literals.EPACKAGE);
		eClass.getEStructuralFeatures().add(eReference5);

		EObject object = ePackage.getEFactoryInstance().create(eClass);
		object.eSet(EcorePackage.Literals.ENAMED_ELEMENT__NAME, "testname");
		object.eSet(eReference1, EcorePackage.eINSTANCE);
		object.eSet(eReference2, ePackage.getEFactoryInstance().create(eClass));
		object.eSet(eReference3, EcorePackage.eINSTANCE);
		object.eSet(eReference4, EcorePackage.eINSTANCE);
		object.eSet(eReference5, EcorePackage.eINSTANCE);

		Resource testResource = new XMIResourceImpl(URI.createPlatformResourceURI("test.ecore", true));
		testResource.getContents().add(object);
		IResourceDescription resourceDescription = createResourceDescription(testResource);
		assertEquals("Only one external reference expected", 1, size(resourceDescription.getReferenceDescriptions()));
		IReferenceDescription referenceDescription = resourceDescription.getReferenceDescriptions().iterator().next();
		assertEquals(-1, referenceDescription.getIndexInList());
		assertEquals(EcoreUtil.getURI(object), referenceDescription.getSourceEObjectUri());
		assertEquals(eReference1, referenceDescription.getEReference());
		assertEquals(EcoreUtil.getURI(EcorePackage.eINSTANCE), referenceDescription.getTargetEObjectUri());
		assertEquals(EcoreUtil.getURI(object), referenceDescription.getContainerEObjectURI());
	}
	
	@Test public void testCrossResourceContainment() {
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName("test");
		ePackage.setNsPrefix("test");
		ePackage.setNsURI("test");

		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName("Test");
		ePackage.getEClassifiers().add(eClass);
		
		EAttribute nameAttribute = EcoreFactory.eINSTANCE.createEAttribute();
		nameAttribute.setName("name");
		nameAttribute.setID(true);
		nameAttribute.setEType(EcorePackage.Literals.ESTRING);
		eClass.getEStructuralFeatures().add(nameAttribute);

		EReference containmentRef = EcoreFactory.eINSTANCE.createEReference();
		containmentRef.setContainment(true);
		containmentRef.setName("crossResourceContainment");
		containmentRef.setEType(eClass);
		containmentRef.setResolveProxies(true);
		eClass.getEStructuralFeatures().add(containmentRef);
		
		EReference containerRef = EcoreFactory.eINSTANCE.createEReference();
		containerRef.setName("containerRef");
		containerRef.setEType(eClass);
		containerRef.setResolveProxies(true);
		containerRef.setEOpposite(containmentRef);
		containmentRef.setEOpposite(containerRef);
		eClass.getEStructuralFeatures().add(containerRef);

		EObject container = ePackage.getEFactoryInstance().create(eClass);
		EObject child = ePackage.getEFactoryInstance().create(eClass);
		
		Resource containerResource = new XMIResourceImpl(URI.createPlatformResourceURI("container.ecore", true));
		Resource childResource = new XMIResourceImpl(URI.createPlatformResourceURI("child.ecore", true));
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResources().add(containerResource);
		resourceSet.getResources().add(childResource);
		
		containerResource.getContents().add(container);
		childResource.getContents().add(child);
		
		container.eSet(containmentRef, child);
		assertTrue(container.eResource() != child.eResource());
		
		{ 
			IResourceDescription containerDescription = createResourceDescription(containerResource);
			IReferenceDescription onlyContainerElement = Iterables.getOnlyElement(containerDescription.getReferenceDescriptions());
			assertEquals(-1, onlyContainerElement.getIndexInList());
			assertEquals(EcoreUtil.getURI(container), onlyContainerElement.getSourceEObjectUri());
			assertEquals(containmentRef, onlyContainerElement.getEReference());
			assertEquals(EcoreUtil.getURI(child), onlyContainerElement.getTargetEObjectUri());
		}
		{
			IResourceDescription childDescription = createResourceDescription(childResource);
			IReferenceDescription onlyChildElement = Iterables.getOnlyElement(childDescription.getReferenceDescriptions());
			assertEquals(-1, onlyChildElement.getIndexInList());
			assertEquals(EcoreUtil.getURI(child), onlyChildElement.getSourceEObjectUri());
			assertEquals(containerRef, onlyChildElement.getEReference());
			assertEquals(EcoreUtil.getURI(container), onlyChildElement.getTargetEObjectUri());
		}
	}
	
	/** @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=330812 */
	@Test public void testLazyLinkingProxyReferences() {
		URI resourceUri = URI.createPlatformResourceURI("test.ecore", true);
		LazyURIEncoder lazyURIEncoder = new LazyURIEncoder();

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource testResource = resourceSet.createResource(resourceUri);

		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName("test");
		ePackage.setNsPrefix("test");
		ePackage.setNsURI("test");
		testResource.getContents().add(ePackage);

		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName("Test");
		ePackage.getEClassifiers().add(eClass);

		EClass multiRefType = EcoreFactory.eINSTANCE.createEClass();
		((InternalEObject) multiRefType).eSetProxyURI(EcoreUtil.getURI(EcorePackage.Literals.EPACKAGE));
		eClass.getESuperTypes().add(multiRefType);

		EClass multiRefType2 = EcoreFactory.eINSTANCE.createEClass();
		URI dummyProxyUri = resourceUri.appendFragment(lazyURIEncoder.encode(eClass, EcorePackage.Literals.ECLASS__ESUPER_TYPES, null));
		((InternalEObject) multiRefType2).eSetProxyURI(dummyProxyUri);
		eClass.getESuperTypes().add(multiRefType2);

		EAttribute nameAttribute = EcoreFactory.eINSTANCE.createEAttribute();
		nameAttribute.setName("name");
		eClass.getEStructuralFeatures().add(nameAttribute);
		EDataType singleRefType = EcoreFactory.eINSTANCE.createEDataType();
		((InternalEObject) singleRefType).eSetProxyURI(EcoreUtil.getURI(EcorePackage.Literals.ESTRING));
		nameAttribute.setEType(singleRefType);

		assertTrue(multiRefType.eIsProxy());
		assertTrue(multiRefType2.eIsProxy());
		assertTrue(lazyURIEncoder.isCrossLinkFragment(testResource, EcoreUtil.getURI(multiRefType2).fragment()));
		assertTrue(singleRefType.eIsProxy());

		IResourceDescription resourceDescription = createResourceDescription(testResource);
		Iterable<IReferenceDescription> referenceDescriptions = resourceDescription.getReferenceDescriptions();
		assertEquals("Unexpected additional resources were loaded", 1, resourceSet.getResources().size());
		assertEquals("Unexpected reference was exported", 3, Iterables.size(referenceDescriptions));

		IReferenceDescription referenceDescription = Iterables.get(referenceDescriptions, 0);
		assertEquals(0, referenceDescription.getIndexInList());
		assertEquals(EcoreUtil.getURI(eClass), referenceDescription.getSourceEObjectUri());
		assertEquals(EcorePackage.Literals.ECLASS__ESUPER_TYPES, referenceDescription.getEReference());
		assertEquals(EcoreUtil.getURI(EcorePackage.Literals.EPACKAGE), referenceDescription.getTargetEObjectUri());

		referenceDescription = Iterables.get(referenceDescriptions, 1);
		assertEquals(-1, referenceDescription.getIndexInList());
		assertEquals(EcoreUtil.getURI(nameAttribute.getEGenericType()), referenceDescription.getSourceEObjectUri());
		assertEquals(EcorePackage.Literals.EGENERIC_TYPE__ECLASSIFIER, referenceDescription.getEReference());
		assertEquals(EcoreUtil.getURI(EcorePackage.Literals.ESTRING), referenceDescription.getTargetEObjectUri());

		referenceDescription = Iterables.get(referenceDescriptions, 2);
		assertEquals(-1, referenceDescription.getIndexInList());
		assertEquals(EcoreUtil.getURI(eClass.getEGenericSuperTypes().get(0)), referenceDescription.getSourceEObjectUri());
		assertEquals(EcorePackage.Literals.EGENERIC_TYPE__ECLASSIFIER, referenceDescription.getEReference());
		assertEquals(EcoreUtil.getURI(EcorePackage.Literals.EPACKAGE), referenceDescription.getTargetEObjectUri());
	}

	protected IResourceDescription createResourceDescription(Resource testResource) {
		DefaultResourceDescriptionStrategy strategy = new DefaultResourceDescriptionStrategy();
		strategy.setQualifiedNameProvider(new IQualifiedNameProvider.AbstractImpl() {
			@Override
			public QualifiedName getFullyQualifiedName(EObject obj) {
				String name = SimpleAttributeResolver.NAME_RESOLVER.apply(obj);
				return (name != null) ? QualifiedName.create(name) : null;
			}
		});
		strategy.setLazyURIEncoder(new LazyURIEncoder());
		IResourceDescription resourceDescription = new DefaultResourceDescription(testResource, strategy);
		return resourceDescription;
	}

}
