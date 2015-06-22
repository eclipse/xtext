/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.extensions;

import com.intellij.openapi.extensions.AbstractExtensionPointBean;
import com.intellij.openapi.extensions.ExtensionPointName;
import com.intellij.util.xmlb.annotations.Attribute;
import java.lang.reflect.Field;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class EPackageEP extends AbstractExtensionPointBean implements EPackage.Descriptor {
  public final static ExtensionPointName<EPackageEP> EP_NAME = ExtensionPointName.<EPackageEP>create(
    "org.eclipse.xtext.idea.package");
  
  @Attribute("uri")
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String nsURI;
  
  @Attribute("class")
  private String packageClass;
  
  public EPackageEP createDescriptor() {
    return this;
  }
  
  @Override
  public EFactory getEFactory() {
    return null;
  }
  
  @Override
  public EPackage getEPackage() {
    try {
      Class<Object> _findClass = this.<Object>findClass(this.packageClass);
      Field _field = _findClass.getField("eINSTANCE");
      Object _get = _field.get(null);
      return ((EPackage) _get);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Pure
  public String getNsURI() {
    return this.nsURI;
  }
}
