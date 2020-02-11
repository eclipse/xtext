/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.grammarAccess;

import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.AsubpackagePackage;
import org.eclipse.xtext.generator.grammarAccess.ametamodel.asubpackage.emptyPackage.subsubpackage.SubsubpackagePackage;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class FragmentFakingEcoreResourceTest extends AbstractXtextTests {

	private EPackage metamodel;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		XtextResourceSet set = new XtextResourceSet();
		set.setClasspathURIContext(getClass());
		Resource resource = set.getResource(URI.createURI("classpath:/org/eclipse/xtext/generator/grammarAccess/ametamodel.ecore"), true);
		metamodel = (EPackage) resource.getContents().get(0);
	}
	
	@Override
	public void tearDown() throws Exception {
		metamodel = null;
		super.tearDown();
	}
	
	@Test public void testFakedURIs_01() {
		ResourceSaveIndicator indicator = new ResourceSaveIndicator();
		EPackage sub = metamodel.getESubpackages().get(0);
		Resource resource = new FragmentFakingEcoreResource(URI.createURI(sub.getNsURI()), indicator);
		resource.getContents().add(sub);
		Iterator<Object> contents = EcoreUtil.getAllContents(sub, true);
		indicator.set(Boolean.TRUE);
		while(contents.hasNext()) {
			Object content = contents.next();
			if (content instanceof EClassifier) {
				EClassifier classifier = (EClassifier) content;
				if (classifier.getName().equals(SubsubpackagePackage.Literals.ANOTHER_TYPE.getName())) {
					assertEquals(EcoreUtil.getURI(classifier), EcoreUtil.getURI(SubsubpackagePackage.Literals.ANOTHER_TYPE));
				}
				if (classifier.getName().equals(AsubpackagePackage.Literals.ATYPE.getName())) {
					assertEquals(EcoreUtil.getURI(classifier), EcoreUtil.getURI(AsubpackagePackage.Literals.ATYPE));
				}
				if (classifier.getName().equals(AsubpackagePackage.Literals.AMODEL.getName())) {
					assertEquals(EcoreUtil.getURI(classifier), EcoreUtil.getURI(AsubpackagePackage.Literals.AMODEL));
				}
			}
		}
	}
	
	@Test public void testFakedURIs_02() {
		ResourceSaveIndicator indicator = new ResourceSaveIndicator();
		EPackage sub = metamodel.getESubpackages().get(0);
		Resource resource = new FragmentFakingEcoreResource(URI.createURI(sub.getNsURI()), indicator);
		resource.getContents().add(sub);
		Iterator<Object> contents = EcoreUtil.getAllContents(sub, true);
		indicator.set(Boolean.FALSE);
		while(contents.hasNext()) {
			Object content = contents.next();
			if (content instanceof EClassifier) {
				EClassifier classifier = (EClassifier) content;
				if (classifier.getName().equals(SubsubpackagePackage.Literals.ANOTHER_TYPE.getName())) {
					assertFalse(EcoreUtil.getURI(classifier).equals(EcoreUtil.getURI(SubsubpackagePackage.Literals.ANOTHER_TYPE)));
				}
				if (classifier.getName().equals(AsubpackagePackage.Literals.ATYPE.getName())) {
					assertEquals(EcoreUtil.getURI(classifier), EcoreUtil.getURI(AsubpackagePackage.Literals.ATYPE));
				}
				if (classifier.getName().equals(AsubpackagePackage.Literals.AMODEL.getName())) {
					assertEquals(EcoreUtil.getURI(classifier), EcoreUtil.getURI(AsubpackagePackage.Literals.AMODEL));
				}
			}
		}
	}
	
	@Test public void testSetup() {
		assertNotNull(metamodel);
		assertTrue(metamodel.getEClassifiers().isEmpty());
		assertFalse(metamodel.getESubpackages().isEmpty());
		assertEquals(1, metamodel.getESubpackages().size());
	}
	
}
