/**
 * Copyright (c) 2012, 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.refactoring;

import org.eclipse.xtend.ide.tests.refactoring.AbstractXtendRenameRefactoringTest;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Test;

@SuppressWarnings("all")
public class RenameResourceTest extends AbstractXtendRenameRefactoringTest {
  @Test
  public void testRenameClassWithSameName() {
    try {
      try {
        this.fileAsserts.assertFileContains(this.renameTo(this.testHelper.createFile("Foo", "class Foo {}"), "Bar.xtend"), "class Bar {}");
      } finally {
        this.testHelper.getFile("Bar.xtend").delete(true, null);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDontRenameClassWithDifferenName() {
    try {
      try {
        this.fileAsserts.assertFileContains(this.renameTo(this.testHelper.createFile("Foo", "class FooBar {}"), "Bar.xtend"), "class FooBar {}");
      } finally {
        this.testHelper.getFile("Bar.xtend").delete(true, null);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testGuardMissingFileExtension() {
    try {
      try {
        this.fileAsserts.assertFileContains(this.renameTo(this.testHelper.createFile("Foo", "class Foo {}"), "Bar"), "class Foo {}");
      } finally {
        this.testHelper.getFile("Bar").delete(true, null);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
