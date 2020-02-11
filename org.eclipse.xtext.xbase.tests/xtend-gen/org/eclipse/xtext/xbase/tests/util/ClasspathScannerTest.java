/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.util;

import com.google.common.base.Objects;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;
import org.eclipse.xtext.common.types.descriptions.ClasspathScanner;
import org.eclipse.xtext.common.types.descriptions.ITypeDescriptor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ClasspathScannerTest {
  private final ClasspathScanner scanner = new ClasspathScanner();
  
  @Test
  public void testBootClasspathScanning() {
    final Iterable<ITypeDescriptor> javaUtil = this.scanner.getBootClasspathDescriptors(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("java.util")));
    final Function1<ITypeDescriptor, Boolean> _function = (ITypeDescriptor it) -> {
      String _simpleName = it.getSimpleName();
      return Boolean.valueOf(Objects.equal(_simpleName, "BitSet"));
    };
    Assert.assertTrue(IterableExtensions.join(javaUtil, ", "), IterableExtensions.<ITypeDescriptor>exists(javaUtil, _function));
    final Function1<ITypeDescriptor, Boolean> _function_1 = (ITypeDescriptor it) -> {
      String _simpleName = it.getSimpleName();
      return Boolean.valueOf(Objects.equal(_simpleName, "String"));
    };
    Assert.assertFalse(IterableExtensions.join(javaUtil, ", "), IterableExtensions.<ITypeDescriptor>exists(javaUtil, _function_1));
  }
  
  @Test
  public void testArrayDeque() {
    final Iterable<ITypeDescriptor> javaUtil = this.scanner.getBootClasspathDescriptors(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("java")));
    final Function1<ITypeDescriptor, Boolean> _function = (ITypeDescriptor it) -> {
      String _simpleName = it.getSimpleName();
      return Boolean.valueOf(Objects.equal(_simpleName, "ArrayDeque"));
    };
    Assert.assertTrue(IterableExtensions.join(javaUtil, ", "), IterableExtensions.<ITypeDescriptor>exists(javaUtil, _function));
    final Function1<ITypeDescriptor, Boolean> _function_1 = (ITypeDescriptor it) -> {
      String _simpleName = it.getSimpleName();
      return Boolean.valueOf(Objects.equal(_simpleName, "ArrayDeque"));
    };
    Assert.assertEquals(IterableExtensions.join(javaUtil, ", "), 1, IterableExtensions.size(IterableExtensions.<ITypeDescriptor>filter(javaUtil, _function_1)));
  }
  
  @Test
  public void testClasspathScanning() {
    try {
      final File bootstrapJar = new File("./somelib/sample.jar");
      URL _uRL = bootstrapJar.toURI().toURL();
      final URLClassLoader classloader = new URLClassLoader(new URL[] { _uRL });
      final Iterable<ITypeDescriptor> utilPackage = this.scanner.getDescriptors(classloader, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("sample")));
      final Function1<ITypeDescriptor, Boolean> _function = (ITypeDescriptor it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, "sample.Sample"));
      };
      Assert.assertTrue(IterableExtensions.<ITypeDescriptor>exists(utilPackage, _function));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNoSystemClassesInUserClassLoader() {
    try {
      final File bootstrapJar = new File("./somelib/sample.jar");
      URL _uRL = bootstrapJar.toURI().toURL();
      final URLClassLoader classloader = new URLClassLoader(new URL[] { _uRL });
      final Iterable<ITypeDescriptor> fromJar = this.scanner.getDescriptors(classloader, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList()));
      final Function1<ITypeDescriptor, Boolean> _function = (ITypeDescriptor it) -> {
        String _simpleName = it.getSimpleName();
        return Boolean.valueOf(Objects.equal(_simpleName, "ArrayList"));
      };
      Assert.assertFalse(IterableExtensions.join(fromJar, ", "), IterableExtensions.<ITypeDescriptor>exists(fromJar, _function));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFoundInParent() {
    try {
      final File bootstrapJar = new File("./somelib/sample.jar");
      URL _uRL = bootstrapJar.toURI().toURL();
      final URLClassLoader parentLoader = new URLClassLoader(new URL[] { _uRL });
      final URLClassLoader classloader = new URLClassLoader(new URL[] {}, parentLoader);
      final Iterable<ITypeDescriptor> fromJar = this.scanner.getDescriptors(classloader, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList()));
      final Function1<ITypeDescriptor, Boolean> _function = (ITypeDescriptor it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, "sample.Sample"));
      };
      Assert.assertTrue(IterableExtensions.<ITypeDescriptor>exists(fromJar, _function));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
