/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.xtext.xbase.tests.typesystem.ValidatingReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.AbstractRootedReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultBatchTypeResolver;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class InvariantCheckingBatchTypeResolver extends DefaultBatchTypeResolver {
  @Inject
  private Provider<ValidatingReentrantTypeResolver> resolverProvider;
  
  @Override
  protected AbstractRootedReentrantTypeResolver createResolver() {
    return this.resolverProvider.get();
  }
}
