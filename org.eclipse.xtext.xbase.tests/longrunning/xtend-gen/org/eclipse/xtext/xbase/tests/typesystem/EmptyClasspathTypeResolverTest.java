/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractTypeResolverTest;
import org.eclipse.xtext.xbase.tests.typesystem.EmptyClasspathXbaseInjectorProvider;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.runner.RunWith;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(EmptyClasspathXbaseInjectorProvider.class)
@SuppressWarnings("all")
public class EmptyClasspathTypeResolverTest extends AbstractTypeResolverTest<LightweightTypeReference> {
  @Inject
  @Extension
  private IBatchTypeResolver _iBatchTypeResolver;
  
  @Inject
  @Extension
  private ParseHelper<EObject> _parseHelper;
  
  @Override
  public LightweightTypeReference resolvesTo(final String expression, final String type) {
    try {
      this._iBatchTypeResolver.resolveTypes(this._parseHelper.parse(expression));
      return null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void isFunctionAndEquivalentTo(final LightweightTypeReference reference, final String type) {
  }
}
