/**
 * Copyright (c) 2011, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.jvmmodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.descriptions.JvmDeclaredTypeSignatureHashProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Assert;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * The remaining tests are in xtend.core.tests, as it is a lot easier to specify JvmModels in Xtend ;-)
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class TypeSignatureHashTest extends AbstractXbaseTestCase {
	@Inject
	private JvmDeclaredTypeSignatureHashProvider jvmDeclaredTypeSignatureHashProvider;

	@Inject
	private JvmTypesBuilder jvmTypesBuilder;

	@Inject
	private TypeReferences typeReferences;

	@Test
	public void testSubType() {
		EObject eObject = EcoreFactory.eINSTANCE.createEObject();
		JvmGenericType bar = jvmTypesBuilder.toClass(eObject, "Bar");
		JvmGenericType foo = jvmTypesBuilder.toClass(eObject, "Foo", (JvmGenericType it) -> {
			it.getMembers().add(bar);
		});
		String hash = jvmDeclaredTypeSignatureHashProvider.getHash(foo);
		bar.getMembers().add(jvmTypesBuilder.toConstructor(eObject, (JvmConstructor it) -> {
		}));
		Assert.assertEquals(hash, jvmDeclaredTypeSignatureHashProvider.getHash(foo));
		bar.setSimpleName("Baz");
		Assert.assertNotEquals("Expected different hashes", hash, jvmDeclaredTypeSignatureHashProvider.getHash(foo));
	}

	@Test
	public void testUnsealedType() {
		EObject eObject = EcoreFactory.eINSTANCE.createEObject();
		JvmGenericType bar = jvmTypesBuilder.toClass(eObject, "Bar");
		Assert.assertNotEquals("Bar", jvmDeclaredTypeSignatureHashProvider.getHash(bar));
	}

	@Test
	public void testRecursiveInheritance() {
		EObject eObject = EcoreFactory.eINSTANCE.createEObject();
		JvmGenericType bar = jvmTypesBuilder.toClass(eObject, "Bar");
		JvmGenericType foo = jvmTypesBuilder.toClass(eObject, "Foo");
		bar.getSuperTypes().add(typeReferences.createTypeRef(foo));
		foo.getSuperTypes().add(typeReferences.createTypeRef(bar));
		Assert.assertNotNull(jvmDeclaredTypeSignatureHashProvider.getHash(foo));
		Assert.assertNotEquals(jvmDeclaredTypeSignatureHashProvider.getHash(foo), jvmDeclaredTypeSignatureHashProvider.getHash(bar));
	}

	@Test
	public void testSealedType() throws Exception {
		XExpression e = expression("null");
		Assert.assertEquals("java.lang.String",
				jvmDeclaredTypeSignatureHashProvider.getHash(((JvmDeclaredType) typeReferences.findDeclaredType(String.class, e))));
	}
}
