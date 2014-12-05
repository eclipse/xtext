/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.persistence;

import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @since 2.8
 */
@SuppressWarnings("all")
class SerializationExtensions {
  public static <T extends ENamedElement> T readEcoreElement(final ObjectInput in) {
    final URI uri = SerializationExtensions.readURI(in);
    URI _trimFragment = uri.trimFragment();
    String _string = _trimFragment.toString();
    final EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(_string);
    Resource _eResource = ePackage.eResource();
    String _fragment = uri.fragment();
    EObject _eObject = _eResource.getEObject(_fragment);
    return ((T) _eObject);
  }
  
  public static void writeEcoreElement(final ObjectOutput out, final ENamedElement namedElement) {
    final URI uri = EcoreUtil.getURI(namedElement);
    SerializationExtensions.writeURI(out, uri);
  }
  
  public static <T extends Object> T readCastedObject(final ObjectInput in) {
    try {
      Object _readObject = in.readObject();
      return ((T) _readObject);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static URI readURI(final ObjectInput in) {
    try {
      String _readUTF = in.readUTF();
      return URI.createURI(_readUTF);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void writeURI(final ObjectOutput out, final URI uri) {
    try {
      String _string = uri.toString();
      out.writeUTF(_string);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static QualifiedName readQualifiedName(final ObjectInput in) {
    try {
      Object _readObject = in.readObject();
      return QualifiedName.create(((ArrayList<String>) _readObject));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void writeQualifiedName(final ObjectOutput out, final QualifiedName name) {
    try {
      List<String> _segments = name.getSegments();
      ArrayList<String> _arrayList = new ArrayList<String>(_segments);
      out.writeObject(_arrayList);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
