/**
 * Copyright (c) 2013, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.hyperlinking;

import org.eclipse.core.resources.IFile;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.ISourceLocator;
import org.eclipse.debug.core.sourcelookup.AbstractSourceLookupDirector;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jface.text.IRegion;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.console.IHyperlink;
import org.eclipse.ui.console.TextConsole;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class XtendFileHyperlink implements IHyperlink {
  private String fileName;

  private int lineNumber;

  private IWorkbench workbench;

  private TextConsole console;

  public XtendFileHyperlink(final String fileName, final IWorkbench workbench, final TextConsole console) {
    final int indexOfColon = fileName.indexOf(":");
    if ((indexOfColon != (-1))) {
      this.fileName = fileName.substring(0, indexOfColon);
      this.lineNumber = (Integer.valueOf(fileName.substring((indexOfColon + 1)))).intValue();
    } else {
      this.fileName = fileName;
    }
    this.workbench = workbench;
    this.console = console;
  }

  @Override
  public void linkActivated() {
    try {
      try {
        ILaunch _launch = this.getLaunch();
        ISourceLocator _sourceLocator = null;
        if (_launch!=null) {
          _sourceLocator=_launch.getSourceLocator();
        }
        final ISourceLocator l = _sourceLocator;
        boolean _matched = false;
        if (l instanceof AbstractSourceLookupDirector) {
          _matched=true;
          final Object result = ((AbstractSourceLookupDirector)l).getSourceElement(this.fileName);
          boolean _matched_1 = false;
          if (result instanceof IFile) {
            _matched_1=true;
            final IEditorPart editor = IDE.openEditor(this.workbench.getActiveWorkbenchWindow().getActivePage(), ((IFile)result));
            boolean _matched_2 = false;
            if (editor instanceof XtextEditor) {
              _matched_2=true;
              final IRegion region = ((XtextEditor)editor).getDocument().getLineInformation((this.lineNumber - 1));
              ((XtextEditor)editor).selectAndReveal(region.getOffset(), region.getLength());
            }
          }
        }
      } catch (final Throwable _t) {
        if (_t instanceof NumberFormatException) {
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Override
  public void linkEntered() {
  }

  @Override
  public void linkExited() {
  }

  private ILaunch getLaunch() {
    Object _attribute = this.console.getAttribute(IDebugUIConstants.ATTR_CONSOLE_PROCESS);
    final IProcess process = ((IProcess) _attribute);
    if ((process != null)) {
      return process.getLaunch();
    }
    return null;
  }
}
