/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.resources;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.descriptions.JvmTypesResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.resource.XbaseResourceDescriptionStrategy;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class XbaseResourceDescriptionStrategyTest extends AbstractXbaseTestCase {
  @Inject
  private XbaseResourceDescriptionStrategy descriptionStrategy;
  
  @Inject
  private IResourceDescription.Manager resourceDescriptionManager;
  
  @Test
  public void testInterfaceDescription_01() {
    final JvmGenericType interfaceType = TypesFactory.eINSTANCE.createJvmGenericType();
    interfaceType.setInterface(true);
    interfaceType.setPackageName("foo");
    interfaceType.setSimpleName("MyType");
    final ArrayList<IEObjectDescription> list = CollectionLiterals.<IEObjectDescription>newArrayList();
    final IAcceptor<IEObjectDescription> _function = (IEObjectDescription it) -> {
      list.add(it);
    };
    this.descriptionStrategy.createEObjectDescriptions(interfaceType, _function);
    final Function1<IEObjectDescription, Boolean> _function_1 = (IEObjectDescription it) -> {
      String _userData = it.getUserData(JvmTypesResourceDescriptionStrategy.IS_INTERFACE);
      return Boolean.valueOf(Objects.equal("true", _userData));
    };
    boolean _exists = IterableExtensions.<IEObjectDescription>exists(list, _function_1);
    Assert.assertTrue(_exists);
  }
  
  @Test
  public void testInterfaceDescription_02() {
    final JvmGenericType interfaceType = TypesFactory.eINSTANCE.createJvmGenericType();
    interfaceType.setInterface(false);
    interfaceType.setPackageName("foo");
    interfaceType.setSimpleName("MyType");
    final ArrayList<IEObjectDescription> list = CollectionLiterals.<IEObjectDescription>newArrayList();
    final IAcceptor<IEObjectDescription> _function = (IEObjectDescription it) -> {
      list.add(it);
    };
    this.descriptionStrategy.createEObjectDescriptions(interfaceType, _function);
    final Function1<IEObjectDescription, Boolean> _function_1 = (IEObjectDescription it) -> {
      String _userData = it.getUserData(JvmTypesResourceDescriptionStrategy.IS_INTERFACE);
      return Boolean.valueOf(Objects.equal("true", _userData));
    };
    boolean _exists = IterableExtensions.<IEObjectDescription>exists(list, _function_1);
    Assert.assertFalse(_exists);
  }
  
  @Test
  public void testNoReferenceDescriptionsForPackageFragments() {
    try {
      final XExpression expression = this.expression("java::lang::String::valueOf(\"\")");
      final Resource resource = expression.eResource();
      final IResourceDescription description = this.resourceDescriptionManager.getResourceDescription(resource);
      Iterable<IReferenceDescription> _referenceDescriptions = description.getReferenceDescriptions();
      final Function1<IReferenceDescription, String> _function = (IReferenceDescription it) -> {
        URI _targetEObjectUri = it.getTargetEObjectUri();
        return _targetEObjectUri.toString();
      };
      Iterable<String> _map = IterableExtensions.<IReferenceDescription, String>map(_referenceDescriptions, _function);
      final Set<String> referenceDescriptions = IterableExtensions.<String>toSet(_map);
      int _size = referenceDescriptions.size();
      Assert.assertEquals(2, _size);
      final Set<String> expectation = Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("java:/Objects/java.lang.String#java.lang.String", "java:/Objects/java.lang.String#java.lang.String.valueOf(java.lang.Object)"));
      Assert.assertEquals(expectation, referenceDescriptions);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
