/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.persistence;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class SerializableResourceDescriptionTest {
	@Test
	public void testSerialization() throws Exception {
		URI uri = URI.createURI("file:/foo/bar.baz.foo");
		SerializableResourceDescription before = new SerializableResourceDescription();
		before.setURI(uri);
		SerializableReferenceDescription rd1 = new SerializableReferenceDescription();
		rd1.setSourceEObjectUri(uri.appendFragment("foo"));
		rd1.setTargetEObjectUri(uri.appendFragment("hubble"));
		rd1.setContainerEObjectURI(uri.appendFragment("baz"));
		rd1.setEReference(EcorePackage.eINSTANCE.getEAnnotation_Contents());
		rd1.setIndexInList(1);
		SerializableReferenceDescription rd2 = new SerializableReferenceDescription();
		rd2.setSourceEObjectUri(uri.appendFragment("foo2"));
		rd2.setTargetEObjectUri(uri.appendFragment("hubble2"));
		rd2.setContainerEObjectURI(uri.appendFragment("baz2"));
		rd2.setEReference(EcorePackage.eINSTANCE.getEAnnotation_Contents());
		rd2.setIndexInList(2);
		before.setReferences(Lists.newArrayList(rd1, rd2));
		SerializableEObjectDescription od1 = new SerializableEObjectDescription();
		od1.setEObjectURI(uri.appendFragment("baz"));
		od1.qualifiedName = QualifiedName.create("foo", "baz");
		od1.setEClass(EcorePackage.eINSTANCE.getEAttribute());
		od1.userData = new HashMap<>();
		od1.userData.put("myKey", "myValue");
		before.setDescriptions(Lists.newArrayList(od1));
		before.setImportedNames(Lists.newArrayList(QualifiedName.create("foo"), QualifiedName.create("foo", "bar")));
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream objectOut = new ObjectOutputStream(bout);
		objectOut.writeObject(before);
		ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
		SerializableResourceDescription after = (SerializableResourceDescription) in.readObject();
		assertDescriptionsEqual(before, after);
	}

	public void assertDescriptionsEqual(SerializableResourceDescription before, SerializableResourceDescription after) {
		Assert.assertEquals(before.getURI(), after.getURI());
		Assert.assertEquals(before.getImportedNames(), after.getImportedNames());
		Assert.assertEquals(before.getReferences().size(), after.getReferences().size());
		for (int i = 0; i < before.getReferences().size(); i++) {
			SerializableReferenceDescription beforeRef = before.getReferences().get(i);
			SerializableReferenceDescription afterRef = after.getReferences().get(i);
			Assert.assertEquals(beforeRef.getContainerEObjectURI(), afterRef.getContainerEObjectURI());
			Assert.assertEquals(beforeRef.getSourceEObjectUri(), afterRef.getSourceEObjectUri());
			Assert.assertEquals(beforeRef.getTargetEObjectUri(), afterRef.getTargetEObjectUri());
			Assert.assertEquals(beforeRef.getEReference(), afterRef.getEReference());
			Assert.assertEquals(beforeRef.getIndexInList(), afterRef.getIndexInList());
		}
		Assert.assertEquals(before.getDescriptions().size(), after.getDescriptions().size());
		for (int i_1 = 0; i_1 < before.getDescriptions().size(); i_1++) {
			SerializableEObjectDescription beforeDesc = before.getDescriptions().get(i_1);
			SerializableEObjectDescription afterDesc = after.getDescriptions().get(i_1);
			Assert.assertEquals(beforeDesc.getEClass(), afterDesc.getEClass());
			Assert.assertEquals(beforeDesc.getName(), afterDesc.getName());
			Assert.assertEquals(beforeDesc.qualifiedName, afterDesc.qualifiedName);
			Assert.assertEquals(beforeDesc.userData, afterDesc.userData);
			Assert.assertEquals(beforeDesc.getEObjectURI(), afterDesc.getEObjectURI());
		}
	}

	@Test
	public void testNullSafeSerialization() throws Exception {
		URI uri = URI.createURI("file:/foo/bar.baz.foo");
		SerializableResourceDescription before = new SerializableResourceDescription();
		before.setURI(uri);
		SerializableReferenceDescription rd1 = new SerializableReferenceDescription();
		rd1.setSourceEObjectUri(uri.appendFragment("foo"));
		rd1.setTargetEObjectUri(null);
		rd1.setContainerEObjectURI(uri.appendFragment("baz"));
		rd1.setEReference(EcorePackage.eINSTANCE.getEAnnotation_Contents());
		rd1.setIndexInList(1);
		SerializableReferenceDescription rd2 = new SerializableReferenceDescription();
		rd2.setSourceEObjectUri(null);
		rd2.setTargetEObjectUri(uri.appendFragment("hubble2"));
		rd2.setContainerEObjectURI(uri.appendFragment("baz2"));
		rd2.setEReference(EcorePackage.eINSTANCE.getEAnnotation_Contents());
		rd2.setIndexInList(2);
		SerializableReferenceDescription rd3 = new SerializableReferenceDescription();
		rd3.setSourceEObjectUri(uri.appendFragment("foo"));
		rd3.setTargetEObjectUri(uri.appendFragment("hubble2"));
		rd3.setContainerEObjectURI(null);
		rd3.setEReference(EcorePackage.eINSTANCE.getEAnnotation_Contents());
		rd3.setIndexInList(2);
		SerializableReferenceDescription rd4 = new SerializableReferenceDescription();
		rd4.setSourceEObjectUri(uri.appendFragment("foo"));
		rd4.setTargetEObjectUri(null);
		rd4.setContainerEObjectURI(null);
		rd4.setEReference(EcorePackage.eINSTANCE.getEAnnotation_Contents());
		rd4.setIndexInList(2);
		SerializableReferenceDescription rd5 = new SerializableReferenceDescription();
		rd5.setSourceEObjectUri(null);
		rd5.setTargetEObjectUri(null);
		rd5.setContainerEObjectURI(null);
		rd5.setEReference(EcorePackage.eINSTANCE.getEAnnotation_Contents());
		rd5.setIndexInList(2);
		before.setReferences(Lists.newArrayList(rd1, rd2, rd3, rd4, rd5));
		SerializableEObjectDescription od1 = new SerializableEObjectDescription();
		od1.setEObjectURI(uri.appendFragment("baz"));
		od1.qualifiedName = QualifiedName.create("foo", "baz");
		od1.setEClass(EcorePackage.eINSTANCE.getEAttribute());
		od1.userData = new HashMap<>();
		od1.userData.put("myKey", "myValue");
		before.setDescriptions(Lists.newArrayList(od1));
		before.setImportedNames(Lists.newArrayList(QualifiedName.create("foo"), QualifiedName.create("foo", "bar")));
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream objectOut = new ObjectOutputStream(bout);
		objectOut.writeObject(before);
		ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
		SerializableResourceDescription after = (SerializableResourceDescription) in.readObject();
		assertDescriptionsEqual(before, after);
	}
}
