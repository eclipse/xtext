/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.persistence;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;
import org.eclipse.xtext.resource.persistence.SerializableEObjectDescription;
import org.eclipse.xtext.resource.persistence.SerializableReferenceDescription;
import org.eclipse.xtext.resource.persistence.SerializationExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.8
 */
@Accessors
@SuppressWarnings("all")
public class SerializableResourceDescription extends AbstractResourceDescription implements Externalizable {
  public static SerializableResourceDescription createCopy(final IResourceDescription desc) {
    SerializableResourceDescription _serializableResourceDescription = new SerializableResourceDescription();
    final Procedure1<SerializableResourceDescription> _function = new Procedure1<SerializableResourceDescription>() {
      @Override
      public void apply(final SerializableResourceDescription it) {
        URI _uRI = desc.getURI();
        it.setURI(_uRI);
        Iterable<IEObjectDescription> _exportedObjects = desc.getExportedObjects();
        final Function1<IEObjectDescription, SerializableEObjectDescription> _function = new Function1<IEObjectDescription, SerializableEObjectDescription>() {
          @Override
          public SerializableEObjectDescription apply(final IEObjectDescription it) {
            return SerializableResourceDescription.createCopy(it);
          }
        };
        Iterable<SerializableEObjectDescription> _map = IterableExtensions.<IEObjectDescription, SerializableEObjectDescription>map(_exportedObjects, _function);
        List<SerializableEObjectDescription> _list = IterableExtensions.<SerializableEObjectDescription>toList(_map);
        it.descriptions = _list;
        Iterable<IReferenceDescription> _referenceDescriptions = desc.getReferenceDescriptions();
        final Function1<IReferenceDescription, SerializableReferenceDescription> _function_1 = new Function1<IReferenceDescription, SerializableReferenceDescription>() {
          @Override
          public SerializableReferenceDescription apply(final IReferenceDescription it) {
            return SerializableResourceDescription.createCopy(it);
          }
        };
        Iterable<SerializableReferenceDescription> _map_1 = IterableExtensions.<IReferenceDescription, SerializableReferenceDescription>map(_referenceDescriptions, _function_1);
        List<SerializableReferenceDescription> _list_1 = IterableExtensions.<SerializableReferenceDescription>toList(_map_1);
        it.references = _list_1;
        Iterable<QualifiedName> _importedNames = desc.getImportedNames();
        ArrayList<QualifiedName> _newArrayList = CollectionLiterals.<QualifiedName>newArrayList(((QualifiedName[])Conversions.unwrapArray(_importedNames, QualifiedName.class)));
        it.importedNames = _newArrayList;
      }
    };
    return ObjectExtensions.<SerializableResourceDescription>operator_doubleArrow(_serializableResourceDescription, _function);
  }
  
  private static SerializableEObjectDescription createCopy(final IEObjectDescription desc) {
    SerializableEObjectDescription _serializableEObjectDescription = new SerializableEObjectDescription();
    final Procedure1<SerializableEObjectDescription> _function = new Procedure1<SerializableEObjectDescription>() {
      @Override
      public void apply(final SerializableEObjectDescription it) {
        EClass _eClass = desc.getEClass();
        it.setEClass(_eClass);
        URI _eObjectURI = desc.getEObjectURI();
        it.setEObjectURI(_eObjectURI);
        QualifiedName _qualifiedName = desc.getQualifiedName();
        it.setQualifiedName(_qualifiedName);
        String[] _userDataKeys = desc.getUserDataKeys();
        int _size = ((List<String>)Conversions.doWrapArray(_userDataKeys)).size();
        HashMap<String, String> _hashMap = new HashMap<String, String>(_size);
        it.setUserData(_hashMap);
        String[] _userDataKeys_1 = desc.getUserDataKeys();
        for (final String key : _userDataKeys_1) {
          HashMap<String, String> _userData = it.getUserData();
          String _userData_1 = desc.getUserData(key);
          _userData.put(key, _userData_1);
        }
      }
    };
    return ObjectExtensions.<SerializableEObjectDescription>operator_doubleArrow(_serializableEObjectDescription, _function);
  }
  
  private static SerializableReferenceDescription createCopy(final IReferenceDescription desc) {
    SerializableReferenceDescription _serializableReferenceDescription = new SerializableReferenceDescription();
    final Procedure1<SerializableReferenceDescription> _function = new Procedure1<SerializableReferenceDescription>() {
      @Override
      public void apply(final SerializableReferenceDescription it) {
        URI _sourceEObjectUri = desc.getSourceEObjectUri();
        it.setSourceEObjectUri(_sourceEObjectUri);
        URI _targetEObjectUri = desc.getTargetEObjectUri();
        it.setTargetEObjectUri(_targetEObjectUri);
        EReference _eReference = desc.getEReference();
        it.setEReference(_eReference);
        int _indexInList = desc.getIndexInList();
        it.setIndexInList(_indexInList);
        URI _containerEObjectURI = desc.getContainerEObjectURI();
        it.setContainerEObjectURI(_containerEObjectURI);
      }
    };
    return ObjectExtensions.<SerializableReferenceDescription>operator_doubleArrow(_serializableReferenceDescription, _function);
  }
  
  private List<SerializableEObjectDescription> descriptions = CollectionLiterals.<SerializableEObjectDescription>emptyList();
  
  private List<SerializableReferenceDescription> references = CollectionLiterals.<SerializableReferenceDescription>emptyList();
  
  private List<QualifiedName> importedNames = CollectionLiterals.<QualifiedName>emptyList();
  
  private URI uRI;
  
  public void updateResourceURI(final URI uri) {
    for (final SerializableReferenceDescription ref : this.references) {
      ref.updateResourceURI(uri, this.uRI);
    }
    for (final SerializableEObjectDescription desc : this.descriptions) {
      desc.updateResourceURI(uri);
    }
    this.uRI = uri;
  }
  
  @Override
  protected List<IEObjectDescription> computeExportedObjects() {
    return ((List<IEObjectDescription>) ((List<?>) this.descriptions));
  }
  
  @Override
  public Iterable<QualifiedName> getImportedNames() {
    return this.importedNames;
  }
  
  @Override
  public Iterable<IReferenceDescription> getReferenceDescriptions() {
    return ((Iterable<IReferenceDescription>) ((Iterable<?>) this.references));
  }
  
  @Override
  public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
    URI _readURI = SerializationExtensions.readURI(in);
    this.setURI(_readURI);
    final int descriptionsSize = in.readInt();
    ArrayList<SerializableEObjectDescription> _arrayList = new ArrayList<SerializableEObjectDescription>(descriptionsSize);
    this.descriptions = _arrayList;
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, descriptionsSize, true);
    for (final Integer i : _doubleDotLessThan) {
      SerializableEObjectDescription _readCastedObject = SerializationExtensions.<SerializableEObjectDescription>readCastedObject(in);
      this.descriptions.add(_readCastedObject);
    }
    final int referencesSize = in.readInt();
    ArrayList<SerializableReferenceDescription> _arrayList_1 = new ArrayList<SerializableReferenceDescription>(referencesSize);
    this.references = _arrayList_1;
    ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, referencesSize, true);
    for (final Integer i_1 : _doubleDotLessThan_1) {
      SerializableReferenceDescription _readCastedObject_1 = SerializationExtensions.<SerializableReferenceDescription>readCastedObject(in);
      this.references.add(_readCastedObject_1);
    }
    final int importedNamesSize = in.readInt();
    ArrayList<QualifiedName> _arrayList_2 = new ArrayList<QualifiedName>(importedNamesSize);
    this.importedNames = _arrayList_2;
    ExclusiveRange _doubleDotLessThan_2 = new ExclusiveRange(0, importedNamesSize, true);
    for (final Integer i_2 : _doubleDotLessThan_2) {
      QualifiedName _readQualifiedName = SerializationExtensions.readQualifiedName(in);
      this.importedNames.add(_readQualifiedName);
    }
  }
  
  @Override
  public void writeExternal(final ObjectOutput out) throws IOException {
    SerializationExtensions.writeURI(out, this.uRI);
    int _size = this.descriptions.size();
    out.writeInt(_size);
    for (final SerializableEObjectDescription desc : this.descriptions) {
      out.writeObject(desc);
    }
    int _size_1 = this.references.size();
    out.writeInt(_size_1);
    for (final SerializableReferenceDescription ref : this.references) {
      out.writeObject(ref);
    }
    int _size_2 = this.importedNames.size();
    out.writeInt(_size_2);
    for (final QualifiedName name : this.importedNames) {
      SerializationExtensions.writeQualifiedName(out, name);
    }
  }
  
  @Pure
  public List<SerializableEObjectDescription> getDescriptions() {
    return this.descriptions;
  }
  
  public void setDescriptions(final List<SerializableEObjectDescription> descriptions) {
    this.descriptions = descriptions;
  }
  
  @Pure
  public List<SerializableReferenceDescription> getReferences() {
    return this.references;
  }
  
  public void setReferences(final List<SerializableReferenceDescription> references) {
    this.references = references;
  }
  
  public void setImportedNames(final List<QualifiedName> importedNames) {
    this.importedNames = importedNames;
  }
  
  @Pure
  public URI getURI() {
    return this.uRI;
  }
  
  public void setURI(final URI uRI) {
    this.uRI = uRI;
  }
}
