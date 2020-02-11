/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
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
import java.util.Collections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.persistence.SerializableEObjectDescription;
import org.eclipse.xtext.resource.persistence.SerializableReferenceDescription;
import org.eclipse.xtext.resource.persistence.SerializableResourceDescription;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class SerializableResourceDescriptionTest {
  @Test
  public void testSerialization() {
    try {
      final URI uri = URI.createURI("file:/foo/bar.baz.foo");
      SerializableResourceDescription _serializableResourceDescription = new SerializableResourceDescription();
      final Procedure1<SerializableResourceDescription> _function = (SerializableResourceDescription it) -> {
        it.setURI(uri);
        SerializableReferenceDescription _serializableReferenceDescription = new SerializableReferenceDescription();
        final Procedure1<SerializableReferenceDescription> _function_1 = (SerializableReferenceDescription it_1) -> {
          it_1.setSourceEObjectUri(uri.appendFragment("foo"));
          it_1.setTargetEObjectUri(uri.appendFragment("hubble"));
          it_1.setContainerEObjectURI(uri.appendFragment("baz"));
          it_1.setEReference(EcorePackage.eINSTANCE.getEAnnotation_Contents());
          it_1.setIndexInList(1);
        };
        SerializableReferenceDescription _doubleArrow = ObjectExtensions.<SerializableReferenceDescription>operator_doubleArrow(_serializableReferenceDescription, _function_1);
        SerializableReferenceDescription _serializableReferenceDescription_1 = new SerializableReferenceDescription();
        final Procedure1<SerializableReferenceDescription> _function_2 = (SerializableReferenceDescription it_1) -> {
          it_1.setSourceEObjectUri(uri.appendFragment("foo2"));
          it_1.setTargetEObjectUri(uri.appendFragment("hubble2"));
          it_1.setContainerEObjectURI(uri.appendFragment("baz2"));
          it_1.setEReference(EcorePackage.eINSTANCE.getEAnnotation_Contents());
          it_1.setIndexInList(2);
        };
        SerializableReferenceDescription _doubleArrow_1 = ObjectExtensions.<SerializableReferenceDescription>operator_doubleArrow(_serializableReferenceDescription_1, _function_2);
        it.setReferences(Collections.<SerializableReferenceDescription>unmodifiableList(CollectionLiterals.<SerializableReferenceDescription>newArrayList(_doubleArrow, _doubleArrow_1)));
        SerializableEObjectDescription _serializableEObjectDescription = new SerializableEObjectDescription();
        final Procedure1<SerializableEObjectDescription> _function_3 = (SerializableEObjectDescription it_1) -> {
          it_1.setEObjectURI(uri.appendFragment("baz"));
          it_1.qualifiedName = QualifiedName.create("foo", "baz");
          it_1.setEClass(EcorePackage.eINSTANCE.getEAttribute());
          Pair<String, String> _mappedTo = Pair.<String, String>of("myKey", "myValue");
          it_1.userData = CollectionLiterals.<String, String>newHashMap(_mappedTo);
        };
        SerializableEObjectDescription _doubleArrow_2 = ObjectExtensions.<SerializableEObjectDescription>operator_doubleArrow(_serializableEObjectDescription, _function_3);
        it.setDescriptions(Collections.<SerializableEObjectDescription>unmodifiableList(CollectionLiterals.<SerializableEObjectDescription>newArrayList(_doubleArrow_2)));
        QualifiedName _create = QualifiedName.create("foo");
        QualifiedName _create_1 = QualifiedName.create("foo", "bar");
        it.setImportedNames(Collections.<QualifiedName>unmodifiableList(CollectionLiterals.<QualifiedName>newArrayList(_create, _create_1)));
      };
      final SerializableResourceDescription before = ObjectExtensions.<SerializableResourceDescription>operator_doubleArrow(_serializableResourceDescription, _function);
      final ByteArrayOutputStream bout = new ByteArrayOutputStream();
      final ObjectOutputStream objectOut = new ObjectOutputStream(bout);
      objectOut.writeObject(before);
      byte[] _byteArray = bout.toByteArray();
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_byteArray);
      final ObjectInputStream in = new ObjectInputStream(_byteArrayInputStream);
      Object _readObject = in.readObject();
      final SerializableResourceDescription after = ((SerializableResourceDescription) _readObject);
      this.assertDescriptionsEqual(before, after);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void assertDescriptionsEqual(final SerializableResourceDescription before, final SerializableResourceDescription after) {
    Assert.assertEquals(before.getURI(), after.getURI());
    Assert.assertEquals(before.getImportedNames(), after.getImportedNames());
    Assert.assertEquals(before.getReferences().size(), after.getReferences().size());
    int _size = before.getReferences().size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
    for (final int i : _doubleDotLessThan) {
      {
        final SerializableReferenceDescription beforeRef = before.getReferences().get(i);
        final SerializableReferenceDescription afterRef = after.getReferences().get(i);
        Assert.assertEquals(beforeRef.getContainerEObjectURI(), afterRef.getContainerEObjectURI());
        Assert.assertEquals(beforeRef.getSourceEObjectUri(), afterRef.getSourceEObjectUri());
        Assert.assertEquals(beforeRef.getTargetEObjectUri(), afterRef.getTargetEObjectUri());
        Assert.assertEquals(beforeRef.getEReference(), afterRef.getEReference());
        Assert.assertEquals(beforeRef.getIndexInList(), afterRef.getIndexInList());
      }
    }
    Assert.assertEquals(before.getDescriptions().size(), after.getDescriptions().size());
    int _size_1 = before.getDescriptions().size();
    ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_1, true);
    for (final int i_1 : _doubleDotLessThan_1) {
      {
        final SerializableEObjectDescription beforeDesc = before.getDescriptions().get(i_1);
        final SerializableEObjectDescription afterDesc = after.getDescriptions().get(i_1);
        Assert.assertEquals(beforeDesc.getEClass(), afterDesc.getEClass());
        Assert.assertEquals(beforeDesc.getName(), afterDesc.getName());
        Assert.assertEquals(beforeDesc.qualifiedName, afterDesc.qualifiedName);
        Assert.assertEquals(beforeDesc.userData, afterDesc.userData);
        Assert.assertEquals(beforeDesc.getEObjectURI(), afterDesc.getEObjectURI());
      }
    }
  }
  
  @Test
  public void testNullSafeSerialization() {
    try {
      final URI uri = URI.createURI("file:/foo/bar.baz.foo");
      SerializableResourceDescription _serializableResourceDescription = new SerializableResourceDescription();
      final Procedure1<SerializableResourceDescription> _function = (SerializableResourceDescription it) -> {
        it.setURI(uri);
        SerializableReferenceDescription _serializableReferenceDescription = new SerializableReferenceDescription();
        final Procedure1<SerializableReferenceDescription> _function_1 = (SerializableReferenceDescription it_1) -> {
          it_1.setSourceEObjectUri(uri.appendFragment("foo"));
          it_1.setTargetEObjectUri(null);
          it_1.setContainerEObjectURI(uri.appendFragment("baz"));
          it_1.setEReference(EcorePackage.eINSTANCE.getEAnnotation_Contents());
          it_1.setIndexInList(1);
        };
        SerializableReferenceDescription _doubleArrow = ObjectExtensions.<SerializableReferenceDescription>operator_doubleArrow(_serializableReferenceDescription, _function_1);
        SerializableReferenceDescription _serializableReferenceDescription_1 = new SerializableReferenceDescription();
        final Procedure1<SerializableReferenceDescription> _function_2 = (SerializableReferenceDescription it_1) -> {
          it_1.setSourceEObjectUri(null);
          it_1.setTargetEObjectUri(uri.appendFragment("hubble2"));
          it_1.setContainerEObjectURI(uri.appendFragment("baz2"));
          it_1.setEReference(EcorePackage.eINSTANCE.getEAnnotation_Contents());
          it_1.setIndexInList(2);
        };
        SerializableReferenceDescription _doubleArrow_1 = ObjectExtensions.<SerializableReferenceDescription>operator_doubleArrow(_serializableReferenceDescription_1, _function_2);
        SerializableReferenceDescription _serializableReferenceDescription_2 = new SerializableReferenceDescription();
        final Procedure1<SerializableReferenceDescription> _function_3 = (SerializableReferenceDescription it_1) -> {
          it_1.setSourceEObjectUri(uri.appendFragment("foo"));
          it_1.setTargetEObjectUri(uri.appendFragment("hubble2"));
          it_1.setContainerEObjectURI(null);
          it_1.setEReference(EcorePackage.eINSTANCE.getEAnnotation_Contents());
          it_1.setIndexInList(2);
        };
        SerializableReferenceDescription _doubleArrow_2 = ObjectExtensions.<SerializableReferenceDescription>operator_doubleArrow(_serializableReferenceDescription_2, _function_3);
        SerializableReferenceDescription _serializableReferenceDescription_3 = new SerializableReferenceDescription();
        final Procedure1<SerializableReferenceDescription> _function_4 = (SerializableReferenceDescription it_1) -> {
          it_1.setSourceEObjectUri(uri.appendFragment("foo"));
          it_1.setTargetEObjectUri(null);
          it_1.setContainerEObjectURI(null);
          it_1.setEReference(EcorePackage.eINSTANCE.getEAnnotation_Contents());
          it_1.setIndexInList(2);
        };
        SerializableReferenceDescription _doubleArrow_3 = ObjectExtensions.<SerializableReferenceDescription>operator_doubleArrow(_serializableReferenceDescription_3, _function_4);
        SerializableReferenceDescription _serializableReferenceDescription_4 = new SerializableReferenceDescription();
        final Procedure1<SerializableReferenceDescription> _function_5 = (SerializableReferenceDescription it_1) -> {
          it_1.setSourceEObjectUri(null);
          it_1.setTargetEObjectUri(null);
          it_1.setContainerEObjectURI(null);
          it_1.setEReference(EcorePackage.eINSTANCE.getEAnnotation_Contents());
          it_1.setIndexInList(2);
        };
        SerializableReferenceDescription _doubleArrow_4 = ObjectExtensions.<SerializableReferenceDescription>operator_doubleArrow(_serializableReferenceDescription_4, _function_5);
        it.setReferences(Collections.<SerializableReferenceDescription>unmodifiableList(CollectionLiterals.<SerializableReferenceDescription>newArrayList(_doubleArrow, _doubleArrow_1, _doubleArrow_2, _doubleArrow_3, _doubleArrow_4)));
        SerializableEObjectDescription _serializableEObjectDescription = new SerializableEObjectDescription();
        final Procedure1<SerializableEObjectDescription> _function_6 = (SerializableEObjectDescription it_1) -> {
          it_1.setEObjectURI(uri.appendFragment("baz"));
          it_1.qualifiedName = QualifiedName.create("foo", "baz");
          it_1.setEClass(EcorePackage.eINSTANCE.getEAttribute());
          Pair<String, String> _mappedTo = Pair.<String, String>of("myKey", "myValue");
          it_1.userData = CollectionLiterals.<String, String>newHashMap(_mappedTo);
        };
        SerializableEObjectDescription _doubleArrow_5 = ObjectExtensions.<SerializableEObjectDescription>operator_doubleArrow(_serializableEObjectDescription, _function_6);
        it.setDescriptions(Collections.<SerializableEObjectDescription>unmodifiableList(CollectionLiterals.<SerializableEObjectDescription>newArrayList(_doubleArrow_5)));
        QualifiedName _create = QualifiedName.create("foo");
        QualifiedName _create_1 = QualifiedName.create("foo", "bar");
        it.setImportedNames(Collections.<QualifiedName>unmodifiableList(CollectionLiterals.<QualifiedName>newArrayList(_create, _create_1)));
      };
      final SerializableResourceDescription before = ObjectExtensions.<SerializableResourceDescription>operator_doubleArrow(_serializableResourceDescription, _function);
      final ByteArrayOutputStream bout = new ByteArrayOutputStream();
      final ObjectOutputStream objectOut = new ObjectOutputStream(bout);
      objectOut.writeObject(before);
      byte[] _byteArray = bout.toByteArray();
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_byteArray);
      final ObjectInputStream in = new ObjectInputStream(_byteArrayInputStream);
      Object _readObject = in.readObject();
      final SerializableResourceDescription after = ((SerializableResourceDescription) _readObject);
      this.assertDescriptionsEqual(before, after);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
