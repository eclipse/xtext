package org.eclipse.xtext.web.server.hover;

import com.google.inject.Singleton;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.hover.HoverResult;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;

@Singleton
@SuppressWarnings("all")
public class HoverService {
  public HoverResult getHover(final XtextWebDocumentAccess document, final int offset) {
    final CancelableUnitOfWork<HoverResult, IXtextWebDocument> _function = new CancelableUnitOfWork<HoverResult, IXtextWebDocument>() {
      @Override
      public HoverResult exec(final IXtextWebDocument it, final CancelIndicator cancelIndicator) throws Exception {
        return new HoverResult("Title", "Hi from server");
      }
    };
    return document.<HoverResult>readOnly(_function);
  }
}
