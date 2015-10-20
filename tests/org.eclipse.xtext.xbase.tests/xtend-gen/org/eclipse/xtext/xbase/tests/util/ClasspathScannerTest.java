/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.util;

import com.google.common.base.Objects;
import java.io.File;
import java.net.URI;
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
import org.junit.Test;

@SuppressWarnings("all")
public class ClasspathScannerTest {
  private final ClasspathScanner scanner = new ClasspathScanner();
  
  @Test
  public void testBootClasspathScanning() {
    final Iterable<ITypeDescriptor> javaUtil = this.scanner.getBootClasspathDescriptors(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("java.util")));
    final Function1<ITypeDescriptor, Boolean> _function = new Function1<ITypeDescriptor, Boolean>() {
      @Override
      public Boolean apply(final ITypeDescriptor it) {
        String _simpleName = it.getSimpleName();
        return Boolean.valueOf(Objects.equal(_simpleName, "BitSet"));
      }
    };
    boolean _exists = IterableExtensions.<ITypeDescriptor>exists(javaUtil, _function);
    Assert.assertTrue(_exists);
  }
  
  @Test
  public void testClasspathScanning() {
    try {
      final File bootstrapJar = new File("../org.eclipse.xtext.bootstrap/lastversion.jar");
      URI _uRI = bootstrapJar.toURI();
      URL _uRL = _uRI.toURL();
      final URLClassLoader classloader = new URLClassLoader(new URL[] { _uRL });
      final Iterable<ITypeDescriptor> utilPackage = this.scanner.getDescriptors(classloader, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("org.eclipse.xtext.util")));
      final Function1<ITypeDescriptor, Boolean> _function = new Function1<ITypeDescriptor, Boolean>() {
        @Override
        public Boolean apply(final ITypeDescriptor it) {
          String _name = it.getName();
          return Boolean.valueOf(Objects.equal(_name, "org.eclipse.xtext.util.Arrays"));
        }
      };
      boolean _exists = IterableExtensions.<ITypeDescriptor>exists(utilPackage, _function);
      Assert.assertTrue(_exists);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
