/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class TypeResolutionCancelTest extends AbstractXbaseTestCase {
  @Inject
  private IBatchTypeResolver resolver;
  
  @Test
  public void testCancelTypeResolution() {
    try {
      final XExpression exp = this.expression("true");
      try {
        final CancelIndicator _function = () -> {
          return true;
        };
        this.resolver.resolveTypes(exp, _function);
        Assert.fail("Type resolution should have been canceled");
      } catch (final Throwable _t) {
        if (_t instanceof OperationCanceledError) {
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRunTypeResolution() {
    try {
      final XExpression exp = this.expression("true");
      try {
        final CancelIndicator _function = () -> {
          return false;
        };
        this.resolver.resolveTypes(exp, _function);
      } catch (final Throwable _t) {
        if (_t instanceof OperationCanceledError) {
          Assert.fail("Type resolution should not have been canceled");
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
