/**
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.compiler;

import com.google.inject.Inject;
import org.apache.log4j.Level;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.logging.LoggingTester;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.resource.BatchLinkableResourceStorageWritable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author cdietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class ExtrasIssue695Test extends AbstractXtendUITestCase {
  @Inject
  private WorkbenchTestHelper workbenchTestHelper;

  @Before
  @After
  public void cleanUp() {
    try {
      this.workbenchTestHelper.tearDown();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testBatchLinkableResourceStorageWritableNoOrphansWithDataAA() {
    final Runnable _function = () -> {
      try {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package somePackage");
        _builder.newLine();
        _builder.newLine();
        _builder.append("@Data");
        _builder.newLine();
        _builder.append("class MyClass {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("String name");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        this.workbenchTestHelper.createFile("somePackage/MyClass.xtend", _builder.toString());
        IResourcesSetupUtil.waitForBuild();
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    final LoggingTester.LogCapture loggings = LoggingTester.captureLogging(Level.ERROR, BatchLinkableResourceStorageWritable.class, _function);
    loggings.assertNoLogEntries();
  }
}
