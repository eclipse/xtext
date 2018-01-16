/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.generator.parser.antlr;

import com.google.inject.Singleton;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xtext.generator.Generator;
import org.eclipse.xtext.generator.NewlineNormalizer;
import org.eclipse.xtext.generator.Xtend2ExecutionContext;

@Singleton
@SuppressWarnings("all")
public class XtextIDEAGeneratorExtensions {
  private final String IDEA_SRC = "IDEA_SRC";
  
  private final String IDEA_SRC_GEN = "IDEA_SRC_GEN";
  
  public Outlet getOutlet(final Xtend2ExecutionContext it, final String outletName) {
    return it.getXpandExecutionContext().getOutput().getOutlet(outletName);
  }
  
  public Outlet getSrcOutlet(final Xtend2ExecutionContext it) {
    return this.getOutlet(it, this.IDEA_SRC);
  }
  
  public Outlet getSrcGenOutlet(final Xtend2ExecutionContext it) {
    return this.getOutlet(it, this.IDEA_SRC_GEN);
  }
  
  protected void installOutlet(final Xtend2ExecutionContext it, final String pathIdeaPluginProject, final String outletName, final String projectPath, final String encoding, final boolean overwrite, final String defaultOutletName, final String lineDelimiter) {
    Outlet _outlet = this.getOutlet(it, outletName);
    boolean _tripleNotEquals = (_outlet != null);
    if (_tripleNotEquals) {
      return;
    }
    final Outlet outlet = new Outlet(outletName);
    outlet.setName(outletName);
    outlet.setOverwrite(overwrite);
    String _xifexpression = null;
    if ((encoding != null)) {
      _xifexpression = encoding;
    } else {
      _xifexpression = this.getOutlet(it, defaultOutletName).getFileEncoding();
    }
    outlet.setFileEncoding(_xifexpression);
    String _xifexpression_1 = null;
    if ((pathIdeaPluginProject != null)) {
      _xifexpression_1 = (pathIdeaPluginProject + projectPath);
    } else {
      _xifexpression_1 = this.getOutlet(it, defaultOutletName).getPath();
    }
    outlet.setPath(_xifexpression_1);
    NewlineNormalizer _newlineNormalizer = new NewlineNormalizer(lineDelimiter);
    outlet.addPostprocessor(_newlineNormalizer);
    it.getXpandExecutionContext().getOutput().addOutlet(outlet);
  }
  
  public void installOutlets(final Xtend2ExecutionContext it, final String pathIdeaPluginProject, final String encoding, final String lineDelimiter) {
    this.installOutlet(it, pathIdeaPluginProject, this.IDEA_SRC, "/src", encoding, false, Generator.SRC, lineDelimiter);
    this.installOutlet(it, pathIdeaPluginProject, this.IDEA_SRC_GEN, "/src-gen", encoding, true, Generator.SRC_GEN, lineDelimiter);
  }
}
