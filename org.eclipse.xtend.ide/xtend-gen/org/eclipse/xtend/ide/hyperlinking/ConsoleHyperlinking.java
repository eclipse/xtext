/**
 * Copyright (c) 2013, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.hyperlinking;

import com.google.inject.Inject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.console.IPatternMatchListenerDelegate;
import org.eclipse.ui.console.PatternMatchEvent;
import org.eclipse.ui.console.TextConsole;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class ConsoleHyperlinking implements IPatternMatchListenerDelegate {
  private TextConsole console;

  @Inject(optional = true)
  private IWorkbench workbench;

  @Override
  public void matchFound(final PatternMatchEvent event) {
    try {
      final int offset = event.getOffset();
      final int length = event.getLength();
      String _get = this.console.getDocument().get(offset, length);
      final XtendFileHyperlink link = new XtendFileHyperlink(_get, this.workbench, this.console);
      this.console.addHyperlink(link, offset, length);
    } catch (final Throwable _t) {
      if (_t instanceof BadLocationException || _t instanceof NumberFormatException) {
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }

  @Override
  public void connect(final TextConsole console) {
    this.console = console;
  }

  @Override
  public void disconnect() {
    this.console = null;
  }
}
