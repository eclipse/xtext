/*******************************************************************************
 * Copyright (c) 2011, 2016 Sigasi N.V. (http://www.sigasi.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Mark Christiaens
 * @author Christian Dietrich
 */

public class SerializationUtilTest extends Assert {
	
	@Test
	public void testFillIdToEObjectMap() {
		EPackage pack = EcoreFactory.eINSTANCE.createEPackage();
		EClass root = createEClass(pack, "Root");
		EClass someType = createEClass(pack, "SomeType");

		EReference ref1 = addEReference(root, someType, "ref1", false);
		EReference ref2 = addEReference(root, someType, "ref2", true);

		EFactory factory = pack.getEFactoryInstance();
		EObject rootObject = factory.create(root);
		EObject someTypeObject1 = factory.create(someType);
		EObject someTypeObject2 = factory.create(someType);
		rootObject.eSet(ref1, someTypeObject1);
		rootObject.eSet(ref2, someTypeObject2);

		List<EObject> map = new ArrayList<>();
		SerializationUtil.fillIdToEObjectMap(rootObject, map);
		assertTrue(map.contains(rootObject));
		assertTrue(map.contains(someTypeObject1));
		assertFalse(map.contains(someTypeObject2));
		assertEquals(2, map.size());
	}

	private EClass createEClass(EPackage pack, String name) {
		EClass clazz = EcoreFactory.eINSTANCE.createEClass();
		clazz.setName(name);
		pack.getEClassifiers().add(clazz);
		return clazz;
	}

	private EReference addEReference(EClass from, EClass to, String name, boolean isTransient) {
		EReference ref = EcoreFactory.eINSTANCE.createEReference();
		ref.setName("ref2");
		ref.setEType(to);
		ref.setContainment(true);
		if (isTransient) {
			ref.setTransient(true);
			ref.setDerived(true);
		}
		ref.setChangeable(true);
		from.getEStructuralFeatures().add(ref);
		return ref;
	}

	@Test
	public void testSyntaxErrorMessage() throws IOException {
		final String message = "hi";
		String [] issueCodes = { null, "issue" };
		String [][] issueDatas = { null, {null}, {"issue data"}};
		
		for (String[] issueData : issueDatas) {
			for (String issueCode : issueCodes) {
				SyntaxErrorMessage sem = new SyntaxErrorMessage(message, issueCode, issueData);
				ByteArrayOutputStream out = new ByteArrayOutputStream ();
				DataOutputStream dout = new DataOutputStream(out);
				SerializationUtil.writeSyntaxErrorMessage(dout, null, sem);
				dout.close();
				byte[] array = out.toByteArray();
				ByteArrayInputStream in = new ByteArrayInputStream(array); 
				DataInputStream din = new DataInputStream(in);
				SyntaxErrorMessage sem2 = SerializationUtil.readSyntaxErrorMessage(din, null);
				assertEquals(sem, sem2); 
			}
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream ();
		DataOutputStream dout = new DataOutputStream(out);
		SerializationUtil.writeSyntaxErrorMessage(dout, null, null);
		dout.close();
		byte[] array = out.toByteArray();
		ByteArrayInputStream in = new ByteArrayInputStream(array); 
		DataInputStream din = new DataInputStream(in);
		SyntaxErrorMessage readMessage = SerializationUtil.readSyntaxErrorMessage(din, null);
		assertNull(readMessage);
	}
}
