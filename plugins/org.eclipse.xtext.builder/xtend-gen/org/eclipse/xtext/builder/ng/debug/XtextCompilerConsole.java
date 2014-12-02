/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.ng.debug;

import com.google.common.base.Throwables;
import com.google.common.collect.Iterables;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleDocumentPartitioner;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.TextConsole;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtextCompilerConsole extends TextConsole {
  public static class Partitioner extends FastPartitioner implements IConsoleDocumentPartitioner {
    public Partitioner(final XtextCompilerConsole console) {
      super(new RuleBasedPartitionScanner(), null);
      IDocument _document = console.getDocument();
      _document.setDocumentPartitioner(this);
    }
    
    public boolean isReadOnly(final int offset) {
      return true;
    }
    
    public StyleRange[] getStyleRanges(final int offset, final int length) {
      return null;
    }
  }
  
  private XtextCompilerConsole.Partitioner partitioner;
  
  public XtextCompilerConsole() {
    super("Xtext Compiler", "xtextCompilerConsole", null, true);
    XtextCompilerConsole.Partitioner _partitioner = new XtextCompilerConsole.Partitioner(this);
    this.partitioner = _partitioner;
    IDocument _document = this.getDocument();
    this.partitioner.connect(_document);
  }
  
  protected IConsoleDocumentPartitioner getPartitioner() {
    return this.partitioner;
  }
  
  public void println(final String it) {
    try {
      IDocument _document = this.getDocument();
      IDocument _document_1 = this.getDocument();
      int _length = _document_1.getLength();
      _document.replace(_length, 0, it);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void log(final Object it) {
    ConsolePlugin _default = ConsolePlugin.getDefault();
    IConsoleManager _consoleManager = _default.getConsoleManager();
    IConsole[] _consoles = _consoleManager.getConsoles();
    Iterable<XtextCompilerConsole> _filter = Iterables.<XtextCompilerConsole>filter(((Iterable<?>)Conversions.doWrapArray(_consoles)), XtextCompilerConsole.class);
    final XtextCompilerConsole console = IterableExtensions.<XtextCompilerConsole>head(_filter);
    if (console!=null) {
      String _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (it instanceof Throwable) {
          _matched=true;
          _switchResult = Throwables.getStackTraceAsString(((Throwable)it));
        }
      }
      if (!_matched) {
        _switchResult = it.toString();
      }
      console.println(_switchResult);
    }
  }
}
