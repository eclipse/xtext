/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.tests.typesystem.TimedRootResolvedTypes;
import org.eclipse.xtext.xbase.tests.typesystem.TypeResolutionTimes;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver;
import org.eclipse.xtext.xbase.typesystem.internal.RootResolvedTypes;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public class TimedReentrantTypeResolver extends DefaultReentrantTypeResolver {
  @Override
  public RootResolvedTypes createResolvedTypes(final CancelIndicator monitor) {
    TypeResolutionTimes _typeResolutionTimes = new TypeResolutionTimes();
    return new TimedRootResolvedTypes(this, _typeResolutionTimes, monitor);
  }
}
