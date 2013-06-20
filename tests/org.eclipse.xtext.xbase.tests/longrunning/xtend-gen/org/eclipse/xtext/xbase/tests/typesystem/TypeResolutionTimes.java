/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.StoppedTask;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class TypeResolutionTimes {
  public final StoppedTask getFeatureTask = new Function0<StoppedTask>() {
    public StoppedTask apply() {
      StoppedTask _forTask = Stopwatches.forTask("StackedResolvedTypes.getFeature");
      return _forTask;
    }
  }.apply();
  
  public final StoppedTask getHintsTask = new Function0<StoppedTask>() {
    public StoppedTask apply() {
      StoppedTask _forTask = Stopwatches.forTask("StackedResolvedTypes.getHints");
      return _forTask;
    }
  }.apply();
  
  public final StoppedTask getActualTypeTask = new Function0<StoppedTask>() {
    public StoppedTask apply() {
      StoppedTask _forTask = Stopwatches.forTask("StackedResolvedTypes.getActualType(identifiable)");
      return _forTask;
    }
  }.apply();
  
  public final StoppedTask getActualExpressionTypeTask = new Function0<StoppedTask>() {
    public StoppedTask apply() {
      StoppedTask _forTask = Stopwatches.forTask("StackedResolvedTypes.getActualType(expression)");
      return _forTask;
    }
  }.apply();
}
