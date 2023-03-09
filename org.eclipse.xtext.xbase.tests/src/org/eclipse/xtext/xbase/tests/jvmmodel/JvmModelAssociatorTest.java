/**
 * Copyright (c) 2017, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.jvmmodel;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.MembersInjector;

public class JvmModelAssociatorTest extends AbstractJvmModelTest {
	@Inject
	private JvmTypesBuilder jvmTypesBuilder;

	@Inject
	private MembersInjector<JvmModelAssociator> associatorInjector;

	private JvmModelAssociator assoc;

	@Inject
	private XtextResourceSet resourceSet;

	@Inject
	private DerivedStateAwareResource resource;

	@Before
	public void createAssociator() {
		assoc = new JvmModelAssociator();
		associatorInjector.injectMembers(assoc);
	}

	@After
	public void discardAssociator() {
		assoc = null;
	}

	@Test
	public void testInference() {
		assoc.setInferrerProvider(() -> {
			return new IJvmModelInferrer() {

				@Override
				public void infer(EObject obj, IJvmDeclaredTypeAcceptor acceptor, boolean preIndexing) {
					JvmGenericType firstType = jvmTypesBuilder.toClass(obj, "foo.Bar");
					JvmGenericType secondType = jvmTypesBuilder.toClass(obj, "foo.Baz");
					Assert.assertNull(secondType.eResource());
					acceptor.accept(firstType, (JvmGenericType it) -> {
						it.setAbstract(true);
						Assert.assertNotNull(firstType.eResource());
						Assert.assertNotNull(secondType.eResource());
					});
					acceptor.accept(secondType, (JvmGenericType it) -> {
						it.setAbstract(true);
						Assert.assertNotNull(firstType.eResource());
					});

				}

			};
		});
		resource.setDerivedStateComputer(null);
		resource.setURI(URI.createURI("foo.txt"));
		resourceSet.setClasspathURIContext(getClass());
		resourceSet.getResources().add(resource);
		resource.getContents().add(EcoreFactory.eINSTANCE.createEClass());
		assoc.installDerivedState(resource, true);
		Assert.assertFalse(((JvmDeclaredType) resource.getContents().get(1)).isAbstract());
		resource.getContents().clear();
		resource.getContents().add(EcoreFactory.eINSTANCE.createEClass());
		assoc.installDerivedState(resource, false);
		JvmGenericType type = ((JvmGenericType) resource.getContents().get(1));
		Assert.assertTrue(type.isAbstract());
		Assert.assertEquals(1, Iterables.size(Iterables.filter(type.getMembers(), JvmConstructor.class)));
		JvmTypeReference head = Iterables.getFirst(type.getSuperTypes(), null);
		String qualifiedName = null;
		if (head != null) {
			qualifiedName = head.getQualifiedName();
		}
		Assert.assertEquals("java.lang.Object", qualifiedName);
	}

	@Test
	public void testRemoveAssociation() {
		assoc.setInferrerProvider(() -> {
			return new IJvmModelInferrer() {

				@Override
				public void infer(EObject obj, IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase) {
					JvmGenericType firstType = jvmTypesBuilder.toClass(obj, "foo.Bar");
					JvmGenericType secondType = jvmTypesBuilder.toClass(obj, "foo.Baz");
					Assert.assertNull(secondType.eResource());
					acceptor.accept(firstType, (JvmGenericType it) -> {
						it.setAbstract(true);
						Assert.assertNotNull(firstType.eResource());
						Assert.assertNotNull(secondType.eResource());
					});
					acceptor.accept(secondType, (JvmGenericType it) -> {
						it.setAbstract(true);
						Assert.assertNotNull(firstType.eResource());
					});
				}

			};
		});
		resource.setDerivedStateComputer(null);
		resource.setURI(URI.createURI("foo.txt"));
		resourceSet.setClasspathURIContext(getClass());
		resourceSet.getResources().add(resource);
		EClass root = EcoreFactory.eINSTANCE.createEClass();
		resource.getContents().add(root);
		assoc.installDerivedState(resource, true);
		List<EObject> jvmElements = Lists.newArrayList(assoc.getJvmElements(root));
		Assert.assertEquals(2, jvmElements.size());
		EObject jvmElement1 = jvmElements.get(0);
		EObject jvmElement2 = jvmElements.get(1);
		List<EObject> sources1 = Lists.newArrayList(assoc.getSourceElements(jvmElement1));
		Assert.assertEquals(1, sources1.size());
		Assert.assertEquals(root, sources1.get(0));
		List<EObject> sources2 = Lists.newArrayList(assoc.getSourceElements(jvmElement2));
		Assert.assertEquals(1, sources2.size());
		Assert.assertEquals(root, sources2.get(0));
		assoc.removeAssociation(root, jvmElement2);
		jvmElements = Lists.newArrayList(assoc.getJvmElements(root));
		Assert.assertEquals(1, jvmElements.size());
		sources1 = Lists.newArrayList(assoc.getSourceElements(jvmElement1));
		Assert.assertEquals(1, sources1.size());
		Assert.assertEquals(root, sources1.get(0));
		sources2 = Lists.newArrayList(assoc.getSourceElements(jvmElement2));
		Assert.assertEquals(0, sources2.size());
	}
}
