/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.findrefs;

import static com.google.common.collect.Lists.*;
import static java.util.Collections.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.ui.ecore.Activator;
import org.eclipse.xtext.ui.editor.findrefs.DefaultReferenceFinder;
import org.eclipse.xtext.util.IAcceptor;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class FindReferenceURINormalizationTest extends TestCase {

	@Inject
	private ResourceSetBasedResourceDescriptions resourceDescriptions;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Activator.getDefault().getInjector().injectMembers(this);
	}
	
	public void testURIsAreNormalized() throws Exception {
		URI cpURI = URI.createURI("classpath:/org/eclipse/xtext/ui/tests/editor/findrefs/Test.ecore");
		XtextResourceSet resourceSet = new XtextResourceSet();
		resourceSet.setClasspathURIContext(this);
		Resource resource = resourceSet.getResource(cpURI, true);
		assertNotNull(resource);
		resourceDescriptions.setContext(resourceSet);
		EPackage ePackage = (EPackage) resource.getContents().get(0);
		EClass referrer = (EClass) ePackage.getEClassifier("Referrer");
		EStructuralFeature attribute = referrer.getEStructuralFeatures().get(0);
		EClassifier referenced = ePackage.getEClassifier("Referenced");

		final List<IReferenceDescription> matches = newArrayList();
		IAcceptor<IReferenceDescription> acceptor = new IAcceptor<IReferenceDescription>() {
			public void accept(IReferenceDescription t) {
				matches.add(t);				
			}
		};
		DefaultReferenceFinder defaultReferenceFinder = new DefaultReferenceFinder(resourceDescriptions);
		defaultReferenceFinder.findLocalReferences(singleton(referenced), acceptor, new Predicate<IReferenceDescription>() {
			public boolean apply(IReferenceDescription referenceDescription) {
				return !referenceDescription.getEReference().isDerived() && !referenceDescription.getEReference().isContainment();
			}
		}, null);
		assertEquals(4,matches.size());
		checkNormalizedURIs(matches, referrer, referenced, referrer, EcorePackage.Literals.ECLASS__ESUPER_TYPES);
		checkNormalizedURIs(matches, referrer.getEGenericSuperTypes().get(0), referenced, referrer, EcorePackage.Literals.EGENERIC_TYPE__ECLASSIFIER);
		checkNormalizedURIs(matches, attribute, referenced, attribute, EcorePackage.Literals.ETYPED_ELEMENT__ETYPE);
		checkNormalizedURIs(matches, attribute.getEGenericType(), referenced, attribute, EcorePackage.Literals.EGENERIC_TYPE__ECLASSIFIER);
	}

	protected void checkNormalizedURIs(List<IReferenceDescription> referenceDescriptions, EObject source,
			EObject target, EObject container, EReference reference) {
		for (IReferenceDescription referenceDescription : referenceDescriptions) {
			if (EcoreUtil2.getNormalizedURI(source).equals(referenceDescription.getSourceEObjectUri())) {
				assertNotNull(referenceDescription.getContainerEObjectURI());
				assertNotNull(referenceDescription.getSourceEObjectUri());
				assertNotNull(referenceDescription.getTargetEObjectUri());
				assertFalse(equal("classpath", referenceDescription.getContainerEObjectURI().scheme()));
				assertFalse(equal("classpath", referenceDescription.getSourceEObjectUri().scheme()));
				assertFalse(equal("classpath", referenceDescription.getTargetEObjectUri().scheme()));
				assertEquals(reference, referenceDescription.getEReference());
				assertEquals(EcoreUtil2.getNormalizedURI(target), referenceDescription.getTargetEObjectUri());
				assertEquals(EcoreUtil2.getNormalizedURI(container), referenceDescription.getContainerEObjectURI());
				return;
			}
		}
		fail("No matching reference found");
	}
}
