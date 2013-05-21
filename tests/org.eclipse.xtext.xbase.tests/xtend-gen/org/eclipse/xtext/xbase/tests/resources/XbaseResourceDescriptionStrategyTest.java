/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.resources;

import com.google.common.collect.Sets;
import com.google.inject.Inject;
import java.util.Collections;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class XbaseResourceDescriptionStrategyTest extends AbstractXbaseTestCase {
  @Inject
  private /* XbaseResourceDescriptionStrategy */Object descriptionStrategy;
  
  @Inject
  private Manager resourceDescriptionManager;
  
  @Test
  public void testInterfaceDescription_01() {
    throw new Error("Unresolved compilation problems:"
      + "\nXbaseResourceDescriptionStrategy cannot be resolved to a type."
      + "\ncreateEObjectDescriptions cannot be resolved"
      + "\nIS_INTERFACE cannot be resolved");
  }
  
  @Test
  public void testInterfaceDescription_02() {
    throw new Error("Unresolved compilation problems:"
      + "\nXbaseResourceDescriptionStrategy cannot be resolved to a type."
      + "\ncreateEObjectDescriptions cannot be resolved"
      + "\nIS_INTERFACE cannot be resolved");
  }
  
  @Test
  public void testNoReferenceDescriptionsForPackageFragments() {
    try {
      final XExpression expression = this.expression("java::lang::String::valueOf(\"\")");
      final Resource resource = expression.eResource();
      final IResourceDescription description = this.resourceDescriptionManager.getResourceDescription(resource);
      Iterable<IReferenceDescription> _referenceDescriptions = description.getReferenceDescriptions();
      final Function1<IReferenceDescription,String> _function = new Function1<IReferenceDescription,String>() {
          public String apply(final IReferenceDescription it) {
            URI _targetEObjectUri = it.getTargetEObjectUri();
            String _string = _targetEObjectUri.toString();
            return _string;
          }
        };
      Iterable<String> _map = IterableExtensions.<IReferenceDescription, String>map(_referenceDescriptions, _function);
      final Set<String> referenceDescriptions = IterableExtensions.<String>toSet(_map);
      int _size = referenceDescriptions.size();
      Assert.assertEquals(2, _size);
      final Set<String> expectation = Collections.<String>unmodifiableSet(Sets.<String>newHashSet("java:/Objects/java.lang.String#java.lang.String", "java:/Objects/java.lang.String#java.lang.String.valueOf(java.lang.Object)"));
      Assert.assertEquals(expectation, referenceDescriptions);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
