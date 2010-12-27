/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ecore;

import static com.google.common.collect.Iterables.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.generic.EmfResourceDescription;
import org.eclipse.xtext.util.SimpleAttributeResolver;

/**
 * @author koehnlein - Initial contribution and API
 */
public class EmfResourceDescriptionTest extends AbstractXtextTests {

	public void testClasspathURIIsNormalized() {
		XtextResourceSet xtextResourceSet = new XtextResourceSet();
		xtextResourceSet.setClasspathURIContext(this);
		URI classpathURI = URI.createURI("classpath:/org/eclipse/xtext/XtextGrammarTestLanguage.ecore");
		Resource resource = xtextResourceSet.getResource(classpathURI, true);
		EmfResourceDescription ecoreResourceDescription = new EmfResourceDescription(resource,
				getQualifiedNameProvider());
		assertNotSame(classpathURI, ecoreResourceDescription.getURI());
		assertEquals(xtextResourceSet.getURIConverter().normalize(classpathURI), ecoreResourceDescription.getURI());
	}

	public void testReferences() {
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		ePackage.setName("test");
		ePackage.setNsPrefix("test");
		ePackage.setNsURI("test");

		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		eClass.setName("Test");
		eClass.getESuperTypes().add(EcorePackage.Literals.EPACKAGE);
		ePackage.getEClassifiers().add(eClass);

		EAttribute nameAttribute = EcoreFactory.eINSTANCE.createEAttribute();
		nameAttribute.setName("name");
		nameAttribute.setEType(EcorePackage.Literals.ESTRING);
		eClass.getEStructuralFeatures().add(nameAttribute);

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
		object.eSet(nameAttribute, "testname");
		object.eSet(eReference1, EcorePackage.Literals.EPACKAGE);
		object.eSet(eReference2, ePackage.getEFactoryInstance().create(eClass));
		object.eSet(eReference3, EcorePackage.Literals.EPACKAGE);
		object.eSet(eReference4, EcorePackage.Literals.EPACKAGE);
		object.eSet(eReference5, EcorePackage.Literals.EPACKAGE);

		Resource testResource = new XMIResourceImpl(URI.createFileURI("test.ecore"));
		testResource.getContents().add(object);
		IResourceDescription resourceDescription = new EmfResourceDescription(testResource, getQualifiedNameProvider());
		assertEquals("Only one external reference expected", 1, size(resourceDescription.getReferenceDescriptions()));
		IReferenceDescription referenceDescription = resourceDescription.getReferenceDescriptions().iterator().next();
		assertEquals(0, referenceDescription.getIndexInList());
		assertEquals(EcoreUtil.getURI(object), referenceDescription.getSourceEObjectUri());
		assertEquals(eReference1, referenceDescription.getEReference());
		assertEquals(EcoreUtil.getURI(EcorePackage.Literals.EPACKAGE), referenceDescription.getTargetEObjectUri());
		assertEquals(EcoreUtil.getURI(object), referenceDescription.getContainerEObjectURI());
	}

	protected IQualifiedNameProvider.AbstractImpl getQualifiedNameProvider() {
		IQualifiedNameProvider.AbstractImpl nameProvider = new IQualifiedNameProvider.AbstractImpl() {
			public QualifiedName getFullyQualifiedName(EObject obj) {
				String name = SimpleAttributeResolver.NAME_RESOLVER.apply(obj);
				return (name != null) ? QualifiedName.create(name) : null;
			}
		};
		return nameProvider;
	}

}
