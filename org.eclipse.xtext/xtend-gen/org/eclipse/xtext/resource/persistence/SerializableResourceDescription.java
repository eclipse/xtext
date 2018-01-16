/**
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;
import org.eclipse.xtext.resource.persistence.SerializableEObjectDescription;
import org.eclipse.xtext.resource.persistence.SerializableEObjectDescriptionProvider;
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
    final Procedure1<SerializableResourceDescription> _function = (SerializableResourceDescription it) -> {
      it.setURI(desc.getURI());
      final Function1<IEObjectDescription, SerializableEObjectDescription> _function_1 = (IEObjectDescription it_1) -> {
        return SerializableResourceDescription.createCopy(it_1);
      };
      it.descriptions = IterableExtensions.<SerializableEObjectDescription>toList(IterableExtensions.<IEObjectDescription, SerializableEObjectDescription>map(desc.getExportedObjects(), _function_1));
      final Function1<IReferenceDescription, SerializableReferenceDescription> _function_2 = (IReferenceDescription it_1) -> {
        return SerializableResourceDescription.createCopy(it_1);
      };
      it.references = IterableExtensions.<SerializableReferenceDescription>toList(IterableExtensions.<IReferenceDescription, SerializableReferenceDescription>map(desc.getReferenceDescriptions(), _function_2));
      it.importedNames = CollectionLiterals.<QualifiedName>newArrayList(((QualifiedName[])Conversions.unwrapArray(desc.getImportedNames(), QualifiedName.class)));
    };
    return ObjectExtensions.<SerializableResourceDescription>operator_doubleArrow(_serializableResourceDescription, _function);
  }
  
  private static SerializableEObjectDescription createCopy(final IEObjectDescription desc) {
    if ((desc instanceof SerializableEObjectDescriptionProvider)) {
      return ((SerializableEObjectDescriptionProvider)desc).toSerializableEObjectDescription();
    }
    SerializableEObjectDescription _serializableEObjectDescription = new SerializableEObjectDescription();
    final Procedure1<SerializableEObjectDescription> _function = (SerializableEObjectDescription it) -> {
      it.setEClass(desc.getEClass());
      it.setEObjectURI(desc.getEObjectURI());
      it.qualifiedName = desc.getQualifiedName();
      int _size = ((List<String>)Conversions.doWrapArray(desc.getUserDataKeys())).size();
      HashMap<String, String> _hashMap = new HashMap<String, String>(_size);
      it.userData = _hashMap;
      String[] _userDataKeys = desc.getUserDataKeys();
      for (final String key : _userDataKeys) {
        it.userData.put(key, desc.getUserData(key));
      }
    };
    return ObjectExtensions.<SerializableEObjectDescription>operator_doubleArrow(_serializableEObjectDescription, _function);
  }
  
  private static SerializableReferenceDescription createCopy(final IReferenceDescription desc) {
    SerializableReferenceDescription _serializableReferenceDescription = new SerializableReferenceDescription();
    final Procedure1<SerializableReferenceDescription> _function = (SerializableReferenceDescription it) -> {
      it.setSourceEObjectUri(desc.getSourceEObjectUri());
      it.setTargetEObjectUri(desc.getTargetEObjectUri());
      it.setEReference(desc.getEReference());
      it.setIndexInList(desc.getIndexInList());
      it.setContainerEObjectURI(desc.getContainerEObjectURI());
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
    this.setURI(SerializationExtensions.readURI(in));
    final int descriptionsSize = in.readInt();
    ArrayList<SerializableEObjectDescription> _arrayList = new ArrayList<SerializableEObjectDescription>(descriptionsSize);
    this.descriptions = _arrayList;
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, descriptionsSize, true);
    for (final Integer i : _doubleDotLessThan) {
      this.descriptions.add(SerializationExtensions.<SerializableEObjectDescription>readCastedObject(in));
    }
    final int referencesSize = in.readInt();
    ArrayList<SerializableReferenceDescription> _arrayList_1 = new ArrayList<SerializableReferenceDescription>(referencesSize);
    this.references = _arrayList_1;
    ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, referencesSize, true);
    for (final Integer i_1 : _doubleDotLessThan_1) {
      this.references.add(SerializationExtensions.<SerializableReferenceDescription>readCastedObject(in));
    }
    final int importedNamesSize = in.readInt();
    ArrayList<QualifiedName> _arrayList_2 = new ArrayList<QualifiedName>(importedNamesSize);
    this.importedNames = _arrayList_2;
    ExclusiveRange _doubleDotLessThan_2 = new ExclusiveRange(0, importedNamesSize, true);
    for (final Integer i_2 : _doubleDotLessThan_2) {
      this.importedNames.add(SerializationExtensions.readQualifiedName(in));
    }
  }
  
  @Override
  public void writeExternal(final ObjectOutput out) throws IOException {
    SerializationExtensions.writeURI(out, this.uRI);
    out.writeInt(this.descriptions.size());
    for (final SerializableEObjectDescription desc : this.descriptions) {
      out.writeObject(desc);
    }
    out.writeInt(this.references.size());
    for (final SerializableReferenceDescription ref : this.references) {
      out.writeObject(ref);
    }
    out.writeInt(this.importedNames.size());
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
