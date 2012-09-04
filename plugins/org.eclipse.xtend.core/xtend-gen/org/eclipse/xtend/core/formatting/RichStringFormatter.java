package org.eclipse.xtend.core.formatting;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.xtend.core.formatting.FormattableDocument;
import org.eclipse.xtend.core.formatting.RichStringFormatterImpl;
import org.eclipse.xtend.core.formatting.XtendFormatter;
import org.eclipse.xtend.core.richstring.DefaultIndentationHandler;
import org.eclipse.xtend.core.richstring.RichStringProcessor;
import org.eclipse.xtend.core.xtend.RichString;

@SuppressWarnings("all")
public class RichStringFormatter {
  @Inject
  private Provider<RichStringFormatterImpl> provider;
  
  @Inject
  private RichStringProcessor richStringProcessor;
  
  public void format(final XtendFormatter formatter, final FormattableDocument doc, final RichString richString) {
    final RichStringFormatterImpl impl = this.provider.get();
    impl.setFormatter(formatter);
    impl.setDocument(doc);
    DefaultIndentationHandler _defaultIndentationHandler = new DefaultIndentationHandler();
    this.richStringProcessor.process(richString, impl, _defaultIndentationHandler);
  }
}
