/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.lib;

import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.xtext.xbase.lib.FunctionExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class FunctionCompositionTest {
  private final Function2<Integer, Integer, Integer> binaryFun = ((Function2<Integer, Integer, Integer>) (Integer e, Integer e2) -> {
    return Integer.valueOf((e * e2));
  });
  
  private final Function1<Integer, Integer> times2 = ((Function1<Integer, Integer>) (Integer e) -> {
    return Integer.valueOf((e * 2));
  });
  
  private final Function1<Integer, Integer> squared = ((Function1<Integer, Integer>) (Integer e) -> {
    return Integer.valueOf((e * e));
  });
  
  @Test
  public void testCompose() {
    Assert.assertEquals(32, (FunctionExtensions.<Integer, Integer, Integer>compose(this.times2, this.squared).apply(Integer.valueOf(4))).intValue());
  }
  
  @Test
  public void testAndThen() {
    Assert.assertEquals(64, (FunctionExtensions.<Integer, Integer, Integer>andThen(this.times2, this.squared).apply(Integer.valueOf(4))).intValue());
  }
  
  @Test
  public void testAndThen2() {
    Assert.assertEquals(4, (FunctionExtensions.<Integer, Integer, Integer, Integer>andThen(this.binaryFun, this.squared).apply(Integer.valueOf(2), Integer.valueOf(1))).intValue());
  }
  
  @Test
  public void testAndThenProcedure() {
    final Procedure1<AtomicInteger> _function = (AtomicInteger it) -> {
      it.incrementAndGet();
    };
    final Procedure1<? super AtomicInteger> incrementer = _function;
    final AtomicInteger counter = new AtomicInteger();
    final Procedure1<AtomicInteger> _function_1 = (AtomicInteger it) -> {
      Assert.assertEquals(2, it.incrementAndGet());
    };
    FunctionExtensions.<AtomicInteger>andThen(incrementer, _function_1).apply(counter);
    Assert.assertEquals(3, counter.incrementAndGet());
  }
}
