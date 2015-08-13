/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.parser.fragments;

import com.google.inject.Injector;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractFragmentsPlainParsingTest extends AbstractXtextTests {
  @Override
  protected void setInjector(final Injector injector) {
    super.setInjector(injector);
    this.injectMembers(this);
  }
  
  @Override
  protected boolean shouldTestSerializer(final XtextResource resource) {
    return false;
  }
  
  @Test
  public void testSimpleModel() {
    try {
      this.getModel("#1 myName");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testReference() {
    try {
      this.getModel("#2 myName -> myName");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testReference_02() {
    try {
      this.getModel("#1 myName : myName");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testReferenceInFragment() {
    try {
      this.getModel("#1 myName - myName");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testReferenceBeforeFragment() {
    try {
      this.getModel("#3 myName <- myName");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAction() {
    try {
      this.getModel("#4 prev current");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testActionAndReference() {
    try {
      this.getModel("#4 prev current prev current");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testActionInFragment_01() {
    try {
      this.getModel("#5 prev current");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testActionInFragment_02() {
    try {
      this.getModel("#6 prev current");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testActionInFragmentAndReference_01() {
    try {
      this.getModel("#5 prev current current - prev");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testActionInFragmentAndReference_02() {
    try {
      this.getModel("#6 prev current current - prev");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testActionInFragmentAndReferenceLoop() {
    try {
      this.getModel("#7 root -> a a -> b b -> c c - root");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDatatypeRule_01() {
    try {
      this.getModel("#8 a - a");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDatatypeRule_02() {
    try {
      this.getModel("#8 a.b.c.d");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDatatypeRule_03() {
    try {
      this.getModel("#8 a.b.c.d - a.b.c.d");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
