/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.util;

import com.google.common.base.Objects;
import java.util.Collections;
import org.eclipse.xtext.xbase.ide.types.ClasspathScanner;
import org.eclipse.xtext.xbase.ide.types.ITypeDescriptor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
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
    Class<? extends ClasspathScannerTest> _class = this.getClass();
    ClassLoader _classLoader = _class.getClassLoader();
    final Iterable<ITypeDescriptor> thisPackage = this.scanner.getDescriptors(_classLoader, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("org.eclipse.xtext.xbase.tests.util")));
    final Function1<ITypeDescriptor, Boolean> _function = new Function1<ITypeDescriptor, Boolean>() {
      @Override
      public Boolean apply(final ITypeDescriptor it) {
        String _simpleName = it.getSimpleName();
        return Boolean.valueOf(Objects.equal(_simpleName, "ClasspathScannerTest"));
      }
    };
    boolean _exists = IterableExtensions.<ITypeDescriptor>exists(thisPackage, _function);
    Assert.assertTrue(_exists);
  }
}
