package org.eclipse.xtend.web;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.xtend.web.server.java2xtend.Java2XtendService;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.web.server.IRequestData;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.ISessionStore;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@Singleton
@Log
@SuppressWarnings("all")
public class XtendServiceDispatcher extends XtextServiceDispatcher {
  @Inject
  private Java2XtendService java2xtendService;
  
  @Override
  protected XtextServiceDispatcher.ServiceDescriptor createServiceDescriptor(final String serviceType, final IRequestData request, final ISessionStore sessionStore) {
    XtextServiceDispatcher.ServiceDescriptor _switchResult = null;
    switch (serviceType) {
      case "java2xtend":
        _switchResult = this.getJava2XtendService(request, sessionStore);
        break;
      default:
        _switchResult = super.createServiceDescriptor(serviceType, request, sessionStore);
        break;
    }
    return _switchResult;
  }
  
  public XtextServiceDispatcher.ServiceDescriptor getJava2XtendService(final IRequestData request, final ISessionStore sessionStore) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final XtextWebDocumentAccess document = this.getDocumentAccess(request, sessionStore);
      final String srcJava = request.getParameter("srcJava");
      XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor = new XtextServiceDispatcher.ServiceDescriptor();
      final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
        @Override
        public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
          final Function0<IServiceResult> _function = new Function0<IServiceResult>() {
            @Override
            public IServiceResult apply() {
              IServiceResult _xtrycatchfinallyexpression = null;
              try {
                _xtrycatchfinallyexpression = XtendServiceDispatcher.this.java2xtendService.generate(srcJava, document);
              } catch (final Throwable _t) {
                if (_t instanceof Throwable) {
                  final Throwable throwable = (Throwable)_t;
                  _xtrycatchfinallyexpression = XtendServiceDispatcher.this.handleError(it, throwable);
                } else {
                  throw Exceptions.sneakyThrow(_t);
                }
              }
              return _xtrycatchfinallyexpression;
            }
          };
          it.setService(_function);
          Set<String> _parameterKeys = request.getParameterKeys();
          boolean _contains = _parameterKeys.contains("fullText");
          it.setHasTextInput(_contains);
        }
      };
      _xblockexpression = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function);
    }
    return _xblockexpression;
  }
  
  private final static Logger LOG = Logger.getLogger(XtendServiceDispatcher.class);
}
