/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.generator.parser.antlr;

import com.google.common.base.Objects;
import com.google.inject.Singleton;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.Output;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.NewlineNormalizer;
import org.eclipse.xtext.generator.Xtend2ExecutionContext;

@Singleton
@SuppressWarnings("all")
public class XtextIDEAGeneratorExtensions {
  private final String IDEA_SRC = "IDEA_SRC";
  
  private final String IDEA_SRC_GEN = "IDEA_SRC_GEN";
  
  public Outlet getOutlet(final Xtend2ExecutionContext it, final String outletName) {
    XpandExecutionContext _xpandExecutionContext = it.getXpandExecutionContext();
    Output _output = _xpandExecutionContext.getOutput();
    return _output.getOutlet(outletName);
  }
  
  public Outlet getSrcOutlet(final Xtend2ExecutionContext it) {
    return this.getOutlet(it, this.IDEA_SRC);
  }
  
  public Outlet getSrcGenOutlet(final Xtend2ExecutionContext it) {
    return this.getOutlet(it, this.IDEA_SRC_GEN);
  }
  
  protected void installOutlet(final Xtend2ExecutionContext it, final String pathIdeaPluginProject, final String outletName, final String projectPath, final String encoding, final boolean overwrite, final String defaultOutletName, final String lineDelimiter) {
    Outlet _outlet = this.getOutlet(it, outletName);
    boolean _notEquals = (!Objects.equal(_outlet, null));
    if (_notEquals) {
      return;
    }
    final Outlet outlet = new Outlet(outletName);
    outlet.setName(outletName);
    outlet.setOverwrite(overwrite);
    String _xifexpression = null;
    boolean _notEquals_1 = (!Objects.equal(encoding, null));
    if (_notEquals_1) {
      _xifexpression = encoding;
    } else {
      Outlet _outlet_1 = this.getOutlet(it, defaultOutletName);
      _xifexpression = _outlet_1.getFileEncoding();
    }
    outlet.setFileEncoding(_xifexpression);
    String _xifexpression_1 = null;
    boolean _notEquals_2 = (!Objects.equal(pathIdeaPluginProject, null));
    if (_notEquals_2) {
      _xifexpression_1 = (pathIdeaPluginProject + projectPath);
    } else {
      Outlet _outlet_2 = this.getOutlet(it, defaultOutletName);
      _xifexpression_1 = _outlet_2.getPath();
    }
    outlet.setPath(_xifexpression_1);
    NewlineNormalizer _newlineNormalizer = new NewlineNormalizer(lineDelimiter);
    outlet.addPostprocessor(_newlineNormalizer);
    XpandExecutionContext _xpandExecutionContext = it.getXpandExecutionContext();
    Output _output = _xpandExecutionContext.getOutput();
    _output.addOutlet(outlet);
  }
  
  public void installOutlets(final Xtend2ExecutionContext it, final String pathIdeaPluginProject, final String encoding, final String lineDelimiter) {
    this.installOutlet(it, pathIdeaPluginProject, this.IDEA_SRC, "/src", encoding, false, Generator.SRC, lineDelimiter);
    this.installOutlet(it, pathIdeaPluginProject, this.IDEA_SRC_GEN, "/src-gen", encoding, true, Generator.SRC_GEN, lineDelimiter);
  }
}
