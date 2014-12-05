/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.impl;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.impl.SerializationExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @since 2.8
 */
@Accessors
@SuppressWarnings("all")
public class SerializableReferenceDescription implements IReferenceDescription, Externalizable {
  private URI sourceEObjectUri;
  
  private URI targetEObjectUri;
  
  private URI containerEObjectURI;
  
  private EReference eReference;
  
  private int indexInList;
  
  public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
    URI _readURI = SerializationExtensions.readURI(in);
    this.sourceEObjectUri = _readURI;
    URI _readURI_1 = SerializationExtensions.readURI(in);
    this.targetEObjectUri = _readURI_1;
    URI _readURI_2 = SerializationExtensions.readURI(in);
    this.containerEObjectURI = _readURI_2;
    EReference _readEcoreElement = SerializationExtensions.<EReference>readEcoreElement(in);
    this.eReference = _readEcoreElement;
    int _readInt = in.readInt();
    this.indexInList = _readInt;
  }
  
  public void writeExternal(final ObjectOutput out) throws IOException {
    SerializationExtensions.writeURI(out, this.sourceEObjectUri);
    SerializationExtensions.writeURI(out, this.targetEObjectUri);
    SerializationExtensions.writeURI(out, this.containerEObjectURI);
    SerializationExtensions.writeEcoreElement(out, this.eReference);
    out.writeInt(this.indexInList);
  }
  
  @Pure
  public URI getSourceEObjectUri() {
    return this.sourceEObjectUri;
  }
  
  public void setSourceEObjectUri(final URI sourceEObjectUri) {
    this.sourceEObjectUri = sourceEObjectUri;
  }
  
  @Pure
  public URI getTargetEObjectUri() {
    return this.targetEObjectUri;
  }
  
  public void setTargetEObjectUri(final URI targetEObjectUri) {
    this.targetEObjectUri = targetEObjectUri;
  }
  
  @Pure
  public URI getContainerEObjectURI() {
    return this.containerEObjectURI;
  }
  
  public void setContainerEObjectURI(final URI containerEObjectURI) {
    this.containerEObjectURI = containerEObjectURI;
  }
  
  @Pure
  public EReference getEReference() {
    return this.eReference;
  }
  
  public void setEReference(final EReference eReference) {
    this.eReference = eReference;
  }
  
  @Pure
  public int getIndexInList() {
    return this.indexInList;
  }
  
  public void setIndexInList(final int indexInList) {
    this.indexInList = indexInList;
  }
}
