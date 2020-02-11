/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.util.internal.Stopwatches;

@SuppressWarnings("all")
public class TypeResolutionTimes {
  public final Stopwatches.StoppedTask getFeatureTask = Stopwatches.forTask("StackedResolvedTypes.getFeature");
  
  public final Stopwatches.StoppedTask getHintsTask = Stopwatches.forTask("StackedResolvedTypes.getHints");
  
  public final Stopwatches.StoppedTask getActualTypeTask = Stopwatches.forTask("StackedResolvedTypes.getActualType(identifiable)");
  
  public final Stopwatches.StoppedTask getActualExpressionTypeTask = Stopwatches.forTask("StackedResolvedTypes.getActualType(expression)");
}
