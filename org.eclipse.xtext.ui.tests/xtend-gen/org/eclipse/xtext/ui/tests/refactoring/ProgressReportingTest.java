/**
 * Copyright (c) 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.tests.refactoring;

import java.util.ArrayList;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ltk.core.refactoring.resource.RenameResourceDescriptor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.tests.refactoring.AbstractResourceRelocationTest;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.junit.Test;

/**
 * @author Christian Schneider - Initial contribution and API
 */
@SuppressWarnings("all")
public class ProgressReportingTest extends AbstractResourceRelocationTest {
  public static class TestProgressMonitor extends NullProgressMonitor {
    private final ArrayList<String> events = CollectionLiterals.<String>newArrayList();
    
    private double accumulatedWork = 0.0d;
    
    @Override
    public void worked(final int work) {
      double _accumulatedWork = this.accumulatedWork;
      this.accumulatedWork = (_accumulatedWork + work);
      this.events.add((((("Worked " + Integer.valueOf(work)) + " (") + Double.valueOf(this.accumulatedWork)) + ")"));
    }
    
    @Override
    public void internalWorked(final double work) {
      double _accumulatedWork = this.accumulatedWork;
      this.accumulatedWork = (_accumulatedWork + work);
      this.events.add((((("InternalWorked " + Double.valueOf(work)) + " (") + Double.valueOf(this.accumulatedWork)) + ")"));
    }
    
    @Override
    public void beginTask(final String name, final int totalWork) {
      String _xifexpression = null;
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(name);
      if (_isNullOrEmpty) {
        _xifexpression = "(";
      } else {
        _xifexpression = " (";
      }
      String _plus = (("BeginTask " + name) + _xifexpression);
      String _plus_1 = (_plus + Integer.valueOf(totalWork));
      String _plus_2 = (_plus_1 + ")");
      this.events.add(_plus_2);
    }
    
    @Override
    public void subTask(final String name) {
      this.events.add(("SubTask " + name));
    }
    
    @Override
    public void setTaskName(final String name) {
      this.events.add(("SetTaskName " + name));
    }
    
    @Override
    public void done() {
      this.events.add("Done");
    }
    
    @Override
    public void setCanceled(final boolean value) {
      super.setCanceled(value);
      this.events.add("Canceled");
    }
    
    public void assertLogged(final String expectation) {
      final String eventsDump = IterableExtensions.join(this.events, "\n");
      boolean _startsWith = eventsDump.startsWith(Strings.toUnixLineSeparator(expectation));
      boolean _not = (!_startsWith);
      if (_not) {
        String _unixLineSeparator = Strings.toUnixLineSeparator(expectation);
        throw new ComparisonFailure("", _unixLineSeparator, eventsDump);
      }
    }
  }
  
  @Test
  public void testProgressReportOfRenameCommonDir() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo.bar");
    _builder.newLine();
    _builder.append("element X {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ref X");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IFile x = this.file("foo/X.fileawaretestlanguage", _builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo");
    _builder_1.newLine();
    _builder_1.append("element Y {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("ref bar.X");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final IFile y = this.file("foo/Y.fileawaretestlanguage", _builder_1);
    final ProgressReportingTest.TestProgressMonitor monitor = new ProgressReportingTest.TestProgressMonitor();
    this.performRename(x.getParent(), "baz", monitor);
    Assert.assertFalse(x.exists());
    Assert.assertFalse(y.exists());
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("BeginTask (44)");
    _builder_2.newLine();
    _builder_2.append("SetTaskName Checking preconditions...");
    _builder_2.newLine();
    _builder_2.append("InternalWorked 4.0 (4.0)");
    _builder_2.newLine();
    _builder_2.append("SetTaskName Checking preconditions...");
    _builder_2.newLine();
    _builder_2.append("InternalWorked 22.22222222222222 (26.22222222222222)");
    _builder_2.newLine();
    _builder_2.append("SetTaskName Preparing the refactoring...");
    _builder_2.newLine();
    _builder_2.append("InternalWorked 1.777777777777778 (28.0)");
    _builder_2.newLine();
    _builder_2.append("SetTaskName Preparing and applying file changes...");
    _builder_2.newLine();
    _builder_2.append("InternalWorked 0.8355555555555556 (28.835555555555555)");
    _builder_2.newLine();
    _builder_2.append("InternalWorked 0.8355555555555556 (29.67111111111111)");
    _builder_2.newLine();
    _builder_2.append("InternalWorked 0.4177777777777778 (30.08888888888889)");
    _builder_2.newLine();
    _builder_2.append("InternalWorked 0.4177777777777778 (30.506666666666668)");
    _builder_2.newLine();
    _builder_2.append("InternalWorked 0.4177777777777778 (30.924444444444447)");
    _builder_2.newLine();
    _builder_2.append("InternalWorked 0.4177777777777778 (31.342222222222226)");
    _builder_2.newLine();
    _builder_2.append("SetTaskName Creating text changes...");
    _builder_2.newLine();
    _builder_2.append("InternalWorked 2.088888888888889 (33.431111111111115)");
    _builder_2.newLine();
    _builder_2.append("InternalWorked 0.8444444444444444 (34.275555555555556)");
    _builder_2.newLine();
    _builder_2.append("InternalWorked 0.8355555555555556 (35.111111111111114)");
    _builder_2.newLine();
    _builder_2.append("InternalWorked 2.2222222222222223 (37.333333333333336)");
    _builder_2.newLine();
    _builder_2.append("InternalWorked 6.666666666666664 (44.0)");
    _builder_2.newLine();
    _builder_2.append("Done");
    _builder_2.newLine();
    monitor.assertLogged(_builder_2.toString());
  }
  
  protected void performRename(final IResource theResource, final String theNewName, final IProgressMonitor monitor) {
    RenameResourceDescriptor _renameResourceDescriptor = new RenameResourceDescriptor();
    final Procedure1<RenameResourceDescriptor> _function = (RenameResourceDescriptor it) -> {
      it.setResourcePath(theResource.getFullPath());
      it.setNewName(theNewName);
      it.setProject(this.project.getName());
    };
    RenameResourceDescriptor _doubleArrow = ObjectExtensions.<RenameResourceDescriptor>operator_doubleArrow(_renameResourceDescriptor, _function);
    this.performRefactoring(_doubleArrow, monitor);
  }
}
