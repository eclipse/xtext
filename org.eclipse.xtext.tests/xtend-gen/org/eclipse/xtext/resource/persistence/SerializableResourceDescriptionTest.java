/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.persistence;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
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
          URI _appendFragment = uri.appendFragment("foo");
          it_1.setSourceEObjectUri(_appendFragment);
          URI _appendFragment_1 = uri.appendFragment("hubble");
          it_1.setTargetEObjectUri(_appendFragment_1);
          URI _appendFragment_2 = uri.appendFragment("baz");
          it_1.setContainerEObjectURI(_appendFragment_2);
          EReference _eAnnotation_Contents = EcorePackage.eINSTANCE.getEAnnotation_Contents();
          it_1.setEReference(_eAnnotation_Contents);
          it_1.setIndexInList(1);
        };
        SerializableReferenceDescription _doubleArrow = ObjectExtensions.<SerializableReferenceDescription>operator_doubleArrow(_serializableReferenceDescription, _function_1);
        SerializableReferenceDescription _serializableReferenceDescription_1 = new SerializableReferenceDescription();
        final Procedure1<SerializableReferenceDescription> _function_2 = (SerializableReferenceDescription it_1) -> {
          URI _appendFragment = uri.appendFragment("foo2");
          it_1.setSourceEObjectUri(_appendFragment);
          URI _appendFragment_1 = uri.appendFragment("hubble2");
          it_1.setTargetEObjectUri(_appendFragment_1);
          URI _appendFragment_2 = uri.appendFragment("baz2");
          it_1.setContainerEObjectURI(_appendFragment_2);
          EReference _eAnnotation_Contents = EcorePackage.eINSTANCE.getEAnnotation_Contents();
          it_1.setEReference(_eAnnotation_Contents);
          it_1.setIndexInList(2);
        };
        SerializableReferenceDescription _doubleArrow_1 = ObjectExtensions.<SerializableReferenceDescription>operator_doubleArrow(_serializableReferenceDescription_1, _function_2);
        it.setReferences(Collections.<SerializableReferenceDescription>unmodifiableList(CollectionLiterals.<SerializableReferenceDescription>newArrayList(_doubleArrow, _doubleArrow_1)));
        SerializableEObjectDescription _serializableEObjectDescription = new SerializableEObjectDescription();
        final Procedure1<SerializableEObjectDescription> _function_3 = (SerializableEObjectDescription it_1) -> {
          URI _appendFragment = uri.appendFragment("baz");
          it_1.setEObjectURI(_appendFragment);
          QualifiedName _create = QualifiedName.create("foo", "baz");
          it_1.setQualifiedName(_create);
          EClass _eAttribute = EcorePackage.eINSTANCE.getEAttribute();
          it_1.setEClass(_eAttribute);
          Pair<String, String> _mappedTo = Pair.<String, String>of("myKey", "myValue");
          HashMap<String, String> _newHashMap = CollectionLiterals.<String, String>newHashMap(_mappedTo);
          it_1.setUserData(_newHashMap);
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
    URI _uRI = before.getURI();
    URI _uRI_1 = after.getURI();
    Assert.assertEquals(_uRI, _uRI_1);
    Iterable<QualifiedName> _importedNames = before.getImportedNames();
    Iterable<QualifiedName> _importedNames_1 = after.getImportedNames();
    Assert.assertEquals(_importedNames, _importedNames_1);
    List<SerializableReferenceDescription> _references = before.getReferences();
    int _size = _references.size();
    List<SerializableReferenceDescription> _references_1 = after.getReferences();
    int _size_1 = _references_1.size();
    Assert.assertEquals(_size, _size_1);
    List<SerializableReferenceDescription> _references_2 = before.getReferences();
    int _size_2 = _references_2.size();
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size_2, true);
    for (final int i : _doubleDotLessThan) {
      {
        List<SerializableReferenceDescription> _references_3 = before.getReferences();
        final SerializableReferenceDescription beforeRef = _references_3.get(i);
        List<SerializableReferenceDescription> _references_4 = after.getReferences();
        final SerializableReferenceDescription afterRef = _references_4.get(i);
        URI _containerEObjectURI = beforeRef.getContainerEObjectURI();
        URI _containerEObjectURI_1 = afterRef.getContainerEObjectURI();
        Assert.assertEquals(_containerEObjectURI, _containerEObjectURI_1);
        URI _sourceEObjectUri = beforeRef.getSourceEObjectUri();
        URI _sourceEObjectUri_1 = afterRef.getSourceEObjectUri();
        Assert.assertEquals(_sourceEObjectUri, _sourceEObjectUri_1);
        URI _targetEObjectUri = beforeRef.getTargetEObjectUri();
        URI _targetEObjectUri_1 = afterRef.getTargetEObjectUri();
        Assert.assertEquals(_targetEObjectUri, _targetEObjectUri_1);
        EReference _eReference = beforeRef.getEReference();
        EReference _eReference_1 = afterRef.getEReference();
        Assert.assertEquals(_eReference, _eReference_1);
        int _indexInList = beforeRef.getIndexInList();
        int _indexInList_1 = afterRef.getIndexInList();
        Assert.assertEquals(_indexInList, _indexInList_1);
      }
    }
    List<SerializableEObjectDescription> _descriptions = before.getDescriptions();
    int _size_3 = _descriptions.size();
    List<SerializableEObjectDescription> _descriptions_1 = after.getDescriptions();
    int _size_4 = _descriptions_1.size();
    Assert.assertEquals(_size_3, _size_4);
    List<SerializableEObjectDescription> _descriptions_2 = before.getDescriptions();
    int _size_5 = _descriptions_2.size();
    ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _size_5, true);
    for (final int i_1 : _doubleDotLessThan_1) {
      {
        List<SerializableEObjectDescription> _descriptions_3 = before.getDescriptions();
        final SerializableEObjectDescription beforeDesc = _descriptions_3.get(i_1);
        List<SerializableEObjectDescription> _descriptions_4 = after.getDescriptions();
        final SerializableEObjectDescription afterDesc = _descriptions_4.get(i_1);
        EClass _eClass = beforeDesc.getEClass();
        EClass _eClass_1 = afterDesc.getEClass();
        Assert.assertEquals(_eClass, _eClass_1);
        QualifiedName _name = beforeDesc.getName();
        QualifiedName _name_1 = afterDesc.getName();
        Assert.assertEquals(_name, _name_1);
        QualifiedName _qualifiedName = beforeDesc.getQualifiedName();
        QualifiedName _qualifiedName_1 = afterDesc.getQualifiedName();
        Assert.assertEquals(_qualifiedName, _qualifiedName_1);
        HashMap<String, String> _userData = beforeDesc.getUserData();
        HashMap<String, String> _userData_1 = afterDesc.getUserData();
        Assert.assertEquals(_userData, _userData_1);
        URI _eObjectURI = beforeDesc.getEObjectURI();
        URI _eObjectURI_1 = afterDesc.getEObjectURI();
        Assert.assertEquals(_eObjectURI, _eObjectURI_1);
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
          URI _appendFragment = uri.appendFragment("foo");
          it_1.setSourceEObjectUri(_appendFragment);
          it_1.setTargetEObjectUri(null);
          URI _appendFragment_1 = uri.appendFragment("baz");
          it_1.setContainerEObjectURI(_appendFragment_1);
          EReference _eAnnotation_Contents = EcorePackage.eINSTANCE.getEAnnotation_Contents();
          it_1.setEReference(_eAnnotation_Contents);
          it_1.setIndexInList(1);
        };
        SerializableReferenceDescription _doubleArrow = ObjectExtensions.<SerializableReferenceDescription>operator_doubleArrow(_serializableReferenceDescription, _function_1);
        SerializableReferenceDescription _serializableReferenceDescription_1 = new SerializableReferenceDescription();
        final Procedure1<SerializableReferenceDescription> _function_2 = (SerializableReferenceDescription it_1) -> {
          it_1.setSourceEObjectUri(null);
          URI _appendFragment = uri.appendFragment("hubble2");
          it_1.setTargetEObjectUri(_appendFragment);
          URI _appendFragment_1 = uri.appendFragment("baz2");
          it_1.setContainerEObjectURI(_appendFragment_1);
          EReference _eAnnotation_Contents = EcorePackage.eINSTANCE.getEAnnotation_Contents();
          it_1.setEReference(_eAnnotation_Contents);
          it_1.setIndexInList(2);
        };
        SerializableReferenceDescription _doubleArrow_1 = ObjectExtensions.<SerializableReferenceDescription>operator_doubleArrow(_serializableReferenceDescription_1, _function_2);
        SerializableReferenceDescription _serializableReferenceDescription_2 = new SerializableReferenceDescription();
        final Procedure1<SerializableReferenceDescription> _function_3 = (SerializableReferenceDescription it_1) -> {
          URI _appendFragment = uri.appendFragment("foo");
          it_1.setSourceEObjectUri(_appendFragment);
          URI _appendFragment_1 = uri.appendFragment("hubble2");
          it_1.setTargetEObjectUri(_appendFragment_1);
          it_1.setContainerEObjectURI(null);
          EReference _eAnnotation_Contents = EcorePackage.eINSTANCE.getEAnnotation_Contents();
          it_1.setEReference(_eAnnotation_Contents);
          it_1.setIndexInList(2);
        };
        SerializableReferenceDescription _doubleArrow_2 = ObjectExtensions.<SerializableReferenceDescription>operator_doubleArrow(_serializableReferenceDescription_2, _function_3);
        SerializableReferenceDescription _serializableReferenceDescription_3 = new SerializableReferenceDescription();
        final Procedure1<SerializableReferenceDescription> _function_4 = (SerializableReferenceDescription it_1) -> {
          URI _appendFragment = uri.appendFragment("foo");
          it_1.setSourceEObjectUri(_appendFragment);
          it_1.setTargetEObjectUri(null);
          it_1.setContainerEObjectURI(null);
          EReference _eAnnotation_Contents = EcorePackage.eINSTANCE.getEAnnotation_Contents();
          it_1.setEReference(_eAnnotation_Contents);
          it_1.setIndexInList(2);
        };
        SerializableReferenceDescription _doubleArrow_3 = ObjectExtensions.<SerializableReferenceDescription>operator_doubleArrow(_serializableReferenceDescription_3, _function_4);
        SerializableReferenceDescription _serializableReferenceDescription_4 = new SerializableReferenceDescription();
        final Procedure1<SerializableReferenceDescription> _function_5 = (SerializableReferenceDescription it_1) -> {
          it_1.setSourceEObjectUri(null);
          it_1.setTargetEObjectUri(null);
          it_1.setContainerEObjectURI(null);
          EReference _eAnnotation_Contents = EcorePackage.eINSTANCE.getEAnnotation_Contents();
          it_1.setEReference(_eAnnotation_Contents);
          it_1.setIndexInList(2);
        };
        SerializableReferenceDescription _doubleArrow_4 = ObjectExtensions.<SerializableReferenceDescription>operator_doubleArrow(_serializableReferenceDescription_4, _function_5);
        it.setReferences(Collections.<SerializableReferenceDescription>unmodifiableList(CollectionLiterals.<SerializableReferenceDescription>newArrayList(_doubleArrow, _doubleArrow_1, _doubleArrow_2, _doubleArrow_3, _doubleArrow_4)));
        SerializableEObjectDescription _serializableEObjectDescription = new SerializableEObjectDescription();
        final Procedure1<SerializableEObjectDescription> _function_6 = (SerializableEObjectDescription it_1) -> {
          URI _appendFragment = uri.appendFragment("baz");
          it_1.setEObjectURI(_appendFragment);
          QualifiedName _create = QualifiedName.create("foo", "baz");
          it_1.setQualifiedName(_create);
          EClass _eAttribute = EcorePackage.eINSTANCE.getEAttribute();
          it_1.setEClass(_eAttribute);
          Pair<String, String> _mappedTo = Pair.<String, String>of("myKey", "myValue");
          HashMap<String, String> _newHashMap = CollectionLiterals.<String, String>newHashMap(_mappedTo);
          it_1.setUserData(_newHashMap);
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
