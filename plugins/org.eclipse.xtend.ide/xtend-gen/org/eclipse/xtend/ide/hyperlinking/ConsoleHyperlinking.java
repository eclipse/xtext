package org.eclipse.xtend.ide.hyperlinking;

import com.google.inject.Inject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.console.IPatternMatchListenerDelegate;
import org.eclipse.ui.console.PatternMatchEvent;
import org.eclipse.ui.console.TextConsole;
import org.eclipse.xtend.ide.hyperlinking.XtendFileHyperlink;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class ConsoleHyperlinking implements IPatternMatchListenerDelegate {
  private TextConsole console;
  
  @Inject(optional = true)
  private IWorkbench workbench;
  
  public void matchFound(final PatternMatchEvent event) {
    try {
      final int offset = event.getOffset();
      final int length = event.getLength();
      IDocument _document = this.console.getDocument();
      String _get = _document.get(offset, length);
      final XtendFileHyperlink link = new XtendFileHyperlink(_get, this.workbench, this.console);
      this.console.addHyperlink(link, offset, length);
    } catch (final Throwable _t) {
      if (_t instanceof BadLocationException) {
        final BadLocationException e = (BadLocationException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  public void connect(final TextConsole console) {
    this.console = console;
  }
  
  public void disconnect() {
    this.console = null;
  }
}
