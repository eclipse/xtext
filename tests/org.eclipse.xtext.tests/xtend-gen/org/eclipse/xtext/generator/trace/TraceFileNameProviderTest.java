/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.trace;

import org.eclipse.xtext.generator.trace.TraceFileNameProvider;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class TraceFileNameProviderTest {
  private final TraceFileNameProvider nameProvider = new TraceFileNameProvider();
  
  @Test
  public void testTraceFileNameOnWindows() {
    boolean _isTraceFileName = this.nameProvider.isTraceFileName("C:\\workspace\\.Foo.java._trace");
    Assert.assertTrue(_isTraceFileName);
  }
  
  @Test
  public void testTraceFileNameOnUnix() {
    boolean _isTraceFileName = this.nameProvider.isTraceFileName("/workspace/.Foo.java._trace");
    Assert.assertTrue(_isTraceFileName);
  }
  
  @Test
  public void testTraceFromJavaSimple() {
    final String trace = this.nameProvider.getTraceFromJava("Foo.java");
    Assert.assertEquals(".Foo.java._trace", trace);
  }
  
  @Test
  public void testTraceFromJavaOnWindows() {
    final String trace = this.nameProvider.getTraceFromJava("C:\\workspace\\Foo.java");
    Assert.assertEquals("C:\\workspace\\.Foo.java._trace", trace);
  }
  
  @Test
  public void testTraceFromJavaOnUnix() {
    final String trace = this.nameProvider.getTraceFromJava("/workspace/Foo.java");
    Assert.assertEquals("/workspace/.Foo.java._trace", trace);
  }
  
  @Test
  public void testJavaFromTraceSimple() {
    final String java = this.nameProvider.getJavaFromTrace(".Foo.java._trace");
    Assert.assertEquals("Foo.java", java);
  }
  
  @Test
  public void testJavaFromTraceOnWindows() {
    final String java = this.nameProvider.getJavaFromTrace("C:\\workspace\\.Foo.java._trace");
    Assert.assertEquals("C:\\workspace\\Foo.java", java);
  }
  
  @Test
  public void testJavaFromTraceOnUnix() {
    final String java = this.nameProvider.getJavaFromTrace("/workspace/.Foo.java._trace");
    Assert.assertEquals("/workspace/Foo.java", java);
  }
}
