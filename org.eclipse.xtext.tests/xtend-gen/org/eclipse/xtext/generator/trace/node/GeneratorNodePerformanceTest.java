/**
 * Copyright (c) 2018 TypeFox (https://typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.trace.node;

import java.util.concurrent.TimeUnit;
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.generator.trace.node.CompositeGeneratorNode;
import org.eclipse.xtext.generator.trace.node.GeneratorNodeExtensions;
import org.eclipse.xtext.generator.trace.node.GeneratorNodeProcessor;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class GeneratorNodePerformanceTest {
  @Extension
  private GeneratorNodeExtensions exts = new GeneratorNodeExtensions();
  
  private static final int numberOfLines = 40_000;
  
  @Rule
  public final Timeout timeout = new Timeout(1000, TimeUnit.MILLISECONDS);
  
  @Test
  public void testBasicCreationAndProcessingPerformance() {
    final LocationData root = this.loc(0);
    CompositeGeneratorNode node = this.exts.appendNewLine(this.exts.append(this.exts.trace(root), "notindented"));
    ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, GeneratorNodePerformanceTest.numberOfLines, true);
    for (final Integer i : _doubleDotLessThan) {
      this.exts.appendNewLine(this.exts.append(this.exts.indent(this.exts.appendNewLine(this.exts.append(this.exts.trace(this.exts.indent(node), this.loc(1)), "indented1"))), "indented2"));
    }
    this.exts.append(this.exts.appendNewLine(node), "dedented");
    final GeneratorNodeProcessor processor = new GeneratorNodeProcessor();
    GeneratorNodeProcessor.Result _process = processor.process(node);
    String _string = null;
    if (_process!=null) {
      _string=_process.toString();
    }
    Assert.assertFalse(StringExtensions.isNullOrEmpty(_string));
  }
  
  private LocationData loc(final int idx) {
    SourceRelativeURI _sourceRelativeURI = new SourceRelativeURI("foo/mymodel.dsl");
    return new LocationData(idx, (100 - idx), 0, 0, _sourceRelativeURI);
  }
}
