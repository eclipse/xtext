/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.util;

import com.google.common.base.Objects;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;
import org.eclipse.xtext.xbase.ide.types.ClasspathScanner;
import org.eclipse.xtext.xbase.ide.types.ITypeDescriptor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

@SuppressWarnings("all")
public class ClasspathScannerTest {
  private final ClasspathScanner scanner = new ClasspathScanner();
  
  @Test
  public void testBootClasspathScanning() {
    final Iterable<ITypeDescriptor> javaUtil = this.scanner.getBootClasspathDescriptors(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("java.util")));
    Assume.assumeFalse("Should be possible to find descriptors", IterableExtensions.isEmpty(javaUtil));
    final Function1<ITypeDescriptor, Boolean> _function = (ITypeDescriptor it) -> {
      String _simpleName = it.getSimpleName();
      return Boolean.valueOf(Objects.equal(_simpleName, "BitSet"));
    };
    Assert.assertTrue(IterableExtensions.join(javaUtil, ", "), IterableExtensions.<ITypeDescriptor>exists(javaUtil, _function));
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
}
