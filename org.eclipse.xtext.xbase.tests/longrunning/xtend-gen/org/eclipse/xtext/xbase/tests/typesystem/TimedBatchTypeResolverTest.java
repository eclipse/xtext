/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import org.eclipse.xtext.tests.StopwatchRule;
import org.eclipse.xtext.tests.Timed;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractBatchTypeResolverTest;
import org.eclipse.xtext.xbase.tests.typesystem.TimedBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@Ignore
@SuppressWarnings("all")
public class TimedBatchTypeResolverTest extends AbstractBatchTypeResolverTest {
  @Rule
  public final StopwatchRule rule = new StopwatchRule(false);
  
  @Inject
  private TimedBatchTypeResolver typeResolver;
  
  @Override
  public IBatchTypeResolver getTypeResolver() {
    return this.typeResolver;
  }
  
  @Test
  @Timed
  @Override
  public void testFeatureCall_15_n() throws Exception {
    super.testFeatureCall_15_n();
  }
  
  @Test
  @Timed
  @Override
  public void testFeatureCall_15_n_1() throws Exception {
    super.testFeatureCall_15_n_1();
  }
  
  @Test
  @Timed
  @Override
  public void testFeatureCall_15_n_2() throws Exception {
    super.testFeatureCall_15_n_2();
  }
}
