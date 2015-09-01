/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.web.server.IRequestData;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.ISessionStore;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.ServiceConflictResult;
import org.eclipse.xtext.web.server.contentassist.ContentAssistService;
import org.eclipse.xtext.web.server.formatting.FormattingService;
import org.eclipse.xtext.web.server.generator.GeneratorService;
import org.eclipse.xtext.web.server.hover.HoverService;
import org.eclipse.xtext.web.server.model.DocumentStateResult;
import org.eclipse.xtext.web.server.model.IWebResourceSetProvider;
import org.eclipse.xtext.web.server.model.PrecomputedServiceRegistry;
import org.eclipse.xtext.web.server.model.UpdateDocumentService;
import org.eclipse.xtext.web.server.model.XtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.web.server.occurrences.OccurrencesService;
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler;
import org.eclipse.xtext.web.server.persistence.ResourceContentResult;
import org.eclipse.xtext.web.server.persistence.ResourcePersistenceService;
import org.eclipse.xtext.web.server.syntaxcoloring.HighlightingService;
import org.eclipse.xtext.web.server.validation.ValidationService;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * The entry class for Xtext service invocations. Use {@link #getService(IRequestData, ISessionStore)}
 * to obtain a {@link XtextServiceDispatcher.ServiceDescriptor} for a client request. The service
 * descriptor has some metadata that may influence the message format expected for the request, and
 * may lead to a rejection of the request.
 * 
 * <p> A typical usage can look like this:</p>
 * <pre>
 * val serviceDispatcher = injector.getInstance(XtextServiceDispatcher)
 * val service = serviceDispatcher.getService(requestData, sessionStore)
 * // Check the service metadata and permissions to invoke the service
 * ...
 * val result = service.service.apply()
 * // Serialize and send the result back to the client
 * ...
 * </pre>
 */
@Singleton
@Log
@SuppressWarnings("all")
public class XtextServiceDispatcher {
  /**
   * Service metadata, including a function for actually invoking the service.
   */
  @Accessors
  @ToString
  public static class ServiceDescriptor {
    /**
     * The service type according to the 'serviceType' parameter.
     */
    private String type;
    
    /**
     * The function for invoking the service.
     */
    private Function0<? extends IServiceResult> service;
    
    /**
     * Whether the service has any side effects apart from initializing data in the session store.
     */
    private boolean hasSideEffects;
    
    /**
     * Whether any text parts of the document have been sent with the request. Requests that
     * contain text parts may be required to be transmitted with a different format.
     */
    private boolean hasTextInput;
    
    /**
     * Whether one of the preconditions of the service does not match, e.g. because it is in
     * conflict with another request.
     */
    private boolean hasConflict;
    
    @Pure
    public String getType() {
      return this.type;
    }
    
    public void setType(final String type) {
      this.type = type;
    }
    
    @Pure
    public Function0<? extends IServiceResult> getService() {
      return this.service;
    }
    
    public void setService(final Function0<? extends IServiceResult> service) {
      this.service = service;
    }
    
    @Pure
    public boolean isHasSideEffects() {
      return this.hasSideEffects;
    }
    
    public void setHasSideEffects(final boolean hasSideEffects) {
      this.hasSideEffects = hasSideEffects;
    }
    
    @Pure
    public boolean isHasTextInput() {
      return this.hasTextInput;
    }
    
    public void setHasTextInput(final boolean hasTextInput) {
      this.hasTextInput = hasTextInput;
    }
    
    @Pure
    public boolean isHasConflict() {
      return this.hasConflict;
    }
    
    public void setHasConflict(final boolean hasConflict) {
      this.hasConflict = hasConflict;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("type", this.type);
      b.add("service", this.service);
      b.add("hasSideEffects", this.hasSideEffects);
      b.add("hasTextInput", this.hasTextInput);
      b.add("hasConflict", this.hasConflict);
      return b.toString();
    }
  }
  
  @Inject
  private ResourcePersistenceService resourcePersistenceService;
  
  @Inject
  private UpdateDocumentService updateDocumentService;
  
  @Inject
  private ContentAssistService contentAssistService;
  
  @Inject
  private ValidationService validationService;
  
  @Inject
  private HighlightingService highlightingService;
  
  @Inject
  private HoverService hoverService;
  
  @Inject
  private OccurrencesService occurrencesService;
  
  @Inject
  private FormattingService formattingService;
  
  @Inject
  private GeneratorService generatorService;
  
  @Inject
  private IServerResourceHandler resourceHandler;
  
  @Inject
  private IWebResourceSetProvider resourceSetProvider;
  
  @Inject
  private Provider<XtextWebDocument> documentProvider;
  
  @Inject
  private FileExtensionProvider fileExtensionProvider;
  
  @Inject
  private IResourceFactory resourceFactory;
  
  @Inject
  private OperationCanceledManager operationCanceledManager;
  
  @Inject
  private XtextWebDocumentAccess.Factory documentAccessFactory;
  
  @Inject
  protected void registerPreComputedServices(final PrecomputedServiceRegistry registry) {
    registry.addPrecomputedService(this.highlightingService);
    registry.addPrecomputedService(this.validationService);
  }
  
  /**
   * Get the service descriptor for the given request.
   */
  public XtextServiceDispatcher.ServiceDescriptor getService(final IRequestData request, final ISessionStore sessionStore) throws InvalidRequestException {
    final String serviceType = request.getParameter(IRequestData.SERVICE_TYPE);
    if ((serviceType == null)) {
      throw new InvalidRequestException.InvalidParametersException("The parameter \'serviceType\' is required.");
    }
    boolean _isTraceEnabled = XtextServiceDispatcher.LOG.isTraceEnabled();
    if (_isTraceEnabled) {
      Set<String> _parameterKeys = request.getParameterKeys();
      List<String> _sort = IterableExtensions.<String>sort(_parameterKeys);
      final Function1<String, CharSequence> _function = new Function1<String, CharSequence>() {
        @Override
        public CharSequence apply(final String key) {
          String _xblockexpression = null;
          {
            final String value = request.getParameter(key);
            String _xifexpression = null;
            int _length = value.length();
            boolean _greaterThan = (_length > 18);
            if (_greaterThan) {
              String _substring = value.substring(0, 16);
              String _plus = ((key + "=\'") + _substring);
              _xifexpression = (_plus + "...\'");
            } else {
              String _xifexpression_1 = null;
              boolean _matches = value.matches(".*\\s+.*");
              if (_matches) {
                _xifexpression_1 = (((key + "=\'") + value) + "\'");
              } else {
                _xifexpression_1 = ((key + "=") + value);
              }
              _xifexpression = _xifexpression_1;
            }
            _xblockexpression = _xifexpression;
          }
          return _xblockexpression;
        }
      };
      String _join = IterableExtensions.<String>join(_sort, ": ", ", ", "", _function);
      final String stringParams = _join.replaceAll("(\\n|\\f|\\r)+", " ");
      XtextServiceDispatcher.LOG.trace((("xtext-service/" + serviceType) + stringParams));
    }
    try {
      XtextServiceDispatcher.ServiceDescriptor _createServiceDescriptor = this.createServiceDescriptor(serviceType, request, sessionStore);
      final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function_1 = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
        @Override
        public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
          it.type = serviceType;
        }
      };
      return ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_createServiceDescriptor, _function_1);
    } catch (final Throwable _t) {
      if (_t instanceof InvalidRequestException.InvalidDocumentStateException) {
        final InvalidRequestException.InvalidDocumentStateException ire = (InvalidRequestException.InvalidDocumentStateException)_t;
        XtextServiceDispatcher.LOG.trace((("Invalid document state (" + serviceType) + ")"));
        XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor = new XtextServiceDispatcher.ServiceDescriptor();
        final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function_2 = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
          @Override
          public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
            it.type = serviceType;
            final Function0<IServiceResult> _function = new Function0<IServiceResult>() {
              @Override
              public IServiceResult apply() {
                return new ServiceConflictResult("invalidStateId");
              }
            };
            it.service = _function;
            it.hasConflict = true;
          }
        };
        return ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function_2);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * Do the actual dispatching by delegating to a service descriptor creation method depending on the service type.
   * Override this method if you want to add more services to the dispatcher.
   */
  protected XtextServiceDispatcher.ServiceDescriptor createServiceDescriptor(final String serviceType, final IRequestData request, final ISessionStore sessionStore) {
    XtextServiceDispatcher.ServiceDescriptor _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(serviceType, "load")) {
        _matched=true;
        _switchResult = this.getLoadResourceService(false, request, sessionStore);
      }
    }
    if (!_matched) {
      if (Objects.equal(serviceType, "revert")) {
        _matched=true;
        _switchResult = this.getLoadResourceService(true, request, sessionStore);
      }
    }
    if (!_matched) {
      if (Objects.equal(serviceType, "save")) {
        _matched=true;
        _switchResult = this.getSaveResourceService(request, sessionStore);
      }
    }
    if (!_matched) {
      if (Objects.equal(serviceType, "update")) {
        _matched=true;
        _switchResult = this.getUpdateDocumentService(request, sessionStore);
      }
    }
    if (!_matched) {
      if (Objects.equal(serviceType, "assist")) {
        _matched=true;
        _switchResult = this.getContentAssistService(request, sessionStore);
      }
    }
    if (!_matched) {
      if (Objects.equal(serviceType, "validate")) {
        _matched=true;
        _switchResult = this.getValidationService(request, sessionStore);
      }
    }
    if (!_matched) {
      if (Objects.equal(serviceType, "hover")) {
        _matched=true;
        _switchResult = this.getHoverService(request, sessionStore);
      }
    }
    if (!_matched) {
      if (Objects.equal(serviceType, "highlight")) {
        _matched=true;
        _switchResult = this.getHighlightingService(request, sessionStore);
      }
    }
    if (!_matched) {
      if (Objects.equal(serviceType, "occurrences")) {
        _matched=true;
        _switchResult = this.getOccurrencesService(request, sessionStore);
      }
    }
    if (!_matched) {
      if (Objects.equal(serviceType, "format")) {
        _matched=true;
        _switchResult = this.getFormattingService(request, sessionStore);
      }
    }
    if (!_matched) {
      if (Objects.equal(serviceType, "generate")) {
        _matched=true;
        _switchResult = this.getGeneratorService(request, sessionStore);
      }
    }
    if (!_matched) {
      throw new InvalidRequestException.InvalidParametersException((("The service type \'" + serviceType) + "\' is not supported."));
    }
    return _switchResult;
  }
  
  protected XtextServiceDispatcher.ServiceDescriptor getLoadResourceService(final boolean revert, final IRequestData request, final ISessionStore sessionStore) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final String resourceId = request.getParameter("resource");
      if ((resourceId == null)) {
        throw new InvalidRequestException.InvalidParametersException("The parameter \'resource\' is required.");
      }
      XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor = new XtextServiceDispatcher.ServiceDescriptor();
      final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
        @Override
        public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
          final Function0<IServiceResult> _function = new Function0<IServiceResult>() {
            @Override
            public IServiceResult apply() {
              IServiceResult _xtrycatchfinallyexpression = null;
              try {
                ResourceContentResult _xifexpression = null;
                if (revert) {
                  _xifexpression = XtextServiceDispatcher.this.resourcePersistenceService.revert(resourceId, XtextServiceDispatcher.this.resourceHandler, sessionStore);
                } else {
                  _xifexpression = XtextServiceDispatcher.this.resourcePersistenceService.load(resourceId, XtextServiceDispatcher.this.resourceHandler, sessionStore);
                }
                _xtrycatchfinallyexpression = _xifexpression;
              } catch (final Throwable _t) {
                if (_t instanceof Throwable) {
                  final Throwable throwable = (Throwable)_t;
                  _xtrycatchfinallyexpression = XtextServiceDispatcher.this.handleError(it, throwable);
                } else {
                  throw Exceptions.sneakyThrow(_t);
                }
              }
              return _xtrycatchfinallyexpression;
            }
          };
          it.service = _function;
          it.hasSideEffects = revert;
        }
      };
      _xblockexpression = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function);
    }
    return _xblockexpression;
  }
  
  protected XtextServiceDispatcher.ServiceDescriptor getSaveResourceService(final IRequestData request, final ISessionStore sessionStore) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final XtextWebDocumentAccess document = this.getDocumentAccess(request, sessionStore);
      XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor = new XtextServiceDispatcher.ServiceDescriptor();
      final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
        @Override
        public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
          final Function0<IServiceResult> _function = new Function0<IServiceResult>() {
            @Override
            public IServiceResult apply() {
              IServiceResult _xtrycatchfinallyexpression = null;
              try {
                _xtrycatchfinallyexpression = XtextServiceDispatcher.this.resourcePersistenceService.save(document, XtextServiceDispatcher.this.resourceHandler);
              } catch (final Throwable _t) {
                if (_t instanceof Throwable) {
                  final Throwable throwable = (Throwable)_t;
                  _xtrycatchfinallyexpression = XtextServiceDispatcher.this.handleError(it, throwable);
                } else {
                  throw Exceptions.sneakyThrow(_t);
                }
              }
              return _xtrycatchfinallyexpression;
            }
          };
          it.service = _function;
          it.hasSideEffects = true;
          Set<String> _parameterKeys = request.getParameterKeys();
          boolean _contains = _parameterKeys.contains("fullText");
          it.hasTextInput = _contains;
        }
      };
      _xblockexpression = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function);
    }
    return _xblockexpression;
  }
  
  protected XtextServiceDispatcher.ServiceDescriptor getUpdateDocumentService(final IRequestData request, final ISessionStore sessionStore) throws InvalidRequestException {
    final String resourceId = request.getParameter("resource");
    if ((resourceId == null)) {
      throw new InvalidRequestException.InvalidParametersException("The parameter \'resource\' is required.");
    }
    final String fullText = request.getParameter("fullText");
    XtextWebDocument document = this.getResourceDocument(resourceId, sessionStore);
    final boolean initializedFromFullText = (document == null);
    if (initializedFromFullText) {
      if ((fullText == null)) {
        throw new InvalidRequestException.ResourceNotFoundException("The requested resource was not found.");
      }
      XtextWebDocument _fullTextDocument = this.getFullTextDocument(fullText, resourceId, sessionStore);
      document = _fullTextDocument;
    }
    String _parameter = request.getParameter("requiredStateId");
    final XtextWebDocumentAccess documentAccess = this.documentAccessFactory.create(document, _parameter, false);
    XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor = new XtextServiceDispatcher.ServiceDescriptor();
    final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
      @Override
      public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
        it.hasSideEffects = true;
        it.hasTextInput = true;
      }
    };
    final XtextServiceDispatcher.ServiceDescriptor result = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function);
    if ((fullText == null)) {
      final String deltaText = request.getParameter("deltaText");
      if ((deltaText == null)) {
        throw new InvalidRequestException.InvalidParametersException("One of the parameters \'deltaText\' and \'fullText\' must be specified.");
      }
      Optional<Integer> _absent = Optional.<Integer>absent();
      final int deltaOffset = this.getInt(request, "deltaOffset", _absent);
      if ((deltaOffset < 0)) {
        throw new InvalidRequestException.InvalidParametersException("The parameter \'deltaOffset\' must not be negative.");
      }
      Optional<Integer> _absent_1 = Optional.<Integer>absent();
      final int deltaReplaceLength = this.getInt(request, "deltaReplaceLength", _absent_1);
      if ((deltaReplaceLength < 0)) {
        throw new InvalidRequestException.InvalidParametersException("The parameter \'deltaReplaceLength\' must not be negative.");
      }
      final Function0<IServiceResult> _function_1 = new Function0<IServiceResult>() {
        @Override
        public IServiceResult apply() {
          IServiceResult _xtrycatchfinallyexpression = null;
          try {
            _xtrycatchfinallyexpression = XtextServiceDispatcher.this.updateDocumentService.updateDeltaText(documentAccess, deltaText, deltaOffset, deltaReplaceLength);
          } catch (final Throwable _t) {
            if (_t instanceof Throwable) {
              final Throwable throwable = (Throwable)_t;
              _xtrycatchfinallyexpression = XtextServiceDispatcher.this.handleError(result, throwable);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
          return _xtrycatchfinallyexpression;
        }
      };
      result.service = _function_1;
    } else {
      Set<String> _parameterKeys = request.getParameterKeys();
      boolean _contains = _parameterKeys.contains("deltaText");
      if (_contains) {
        throw new InvalidRequestException.InvalidParametersException("The parameters \'deltaText\' and \'fullText\' cannot be set in the same request.");
      }
      final Function0<IServiceResult> _function_2 = new Function0<IServiceResult>() {
        @Override
        public IServiceResult apply() {
          IServiceResult _xtrycatchfinallyexpression = null;
          try {
            DocumentStateResult _xifexpression = null;
            if (initializedFromFullText) {
              _xifexpression = XtextServiceDispatcher.this.updateDocumentService.getStateId(documentAccess);
            } else {
              _xifexpression = XtextServiceDispatcher.this.updateDocumentService.updateFullText(documentAccess, fullText);
            }
            _xtrycatchfinallyexpression = _xifexpression;
          } catch (final Throwable _t) {
            if (_t instanceof Throwable) {
              final Throwable throwable = (Throwable)_t;
              _xtrycatchfinallyexpression = XtextServiceDispatcher.this.handleError(result, throwable);
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
          return _xtrycatchfinallyexpression;
        }
      };
      result.service = _function_2;
    }
    return result;
  }
  
  protected XtextServiceDispatcher.ServiceDescriptor getContentAssistService(final IRequestData request, final ISessionStore sessionStore) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      Optional<Integer> _of = Optional.<Integer>of(Integer.valueOf(0));
      final int offset = this.getInt(request, "caretOffset", _of);
      final XtextWebDocumentAccess document = this.getDocumentAccess(request, sessionStore);
      Optional<Integer> _of_1 = Optional.<Integer>of(Integer.valueOf(ContentAssistService.DEFAULT_PROPOSALS_LIMIT));
      final int proposalsLimit = this.getInt(request, "proposalsLimit", _of_1);
      if ((proposalsLimit <= 0)) {
        throw new InvalidRequestException.InvalidParametersException("The parameter \'proposalsLimit\' must contain a positive integer.");
      }
      Optional<Integer> _of_2 = Optional.<Integer>of(Integer.valueOf(offset));
      final int selectionStart = this.getInt(request, "selectionStart", _of_2);
      Optional<Integer> _of_3 = Optional.<Integer>of(Integer.valueOf(selectionStart));
      final int selectionEnd = this.getInt(request, "selectionEnd", _of_3);
      int _max = Math.max((selectionEnd - selectionStart), 0);
      final TextRegion selection = new TextRegion(selectionStart, _max);
      final String deltaText = request.getParameter("deltaText");
      XtextServiceDispatcher.ServiceDescriptor _xifexpression = null;
      if ((deltaText == null)) {
        XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor = new XtextServiceDispatcher.ServiceDescriptor();
        final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
          @Override
          public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
            final Function0<IServiceResult> _function = new Function0<IServiceResult>() {
              @Override
              public IServiceResult apply() {
                IServiceResult _xtrycatchfinallyexpression = null;
                try {
                  _xtrycatchfinallyexpression = XtextServiceDispatcher.this.contentAssistService.createProposals(document, selection, offset, proposalsLimit);
                } catch (final Throwable _t) {
                  if (_t instanceof Throwable) {
                    final Throwable throwable = (Throwable)_t;
                    _xtrycatchfinallyexpression = XtextServiceDispatcher.this.handleError(it, throwable);
                  } else {
                    throw Exceptions.sneakyThrow(_t);
                  }
                }
                return _xtrycatchfinallyexpression;
              }
            };
            it.service = _function;
            Set<String> _parameterKeys = request.getParameterKeys();
            boolean _contains = _parameterKeys.contains("fullText");
            it.hasTextInput = _contains;
          }
        };
        _xifexpression = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function);
      } else {
        XtextServiceDispatcher.ServiceDescriptor _xblockexpression_1 = null;
        {
          Set<String> _parameterKeys = request.getParameterKeys();
          boolean _contains = _parameterKeys.contains("fullText");
          if (_contains) {
            throw new InvalidRequestException.InvalidParametersException("The parameters \'deltaText\' and \'fullText\' cannot be set in the same request.");
          }
          Optional<Integer> _absent = Optional.<Integer>absent();
          final int deltaOffset = this.getInt(request, "deltaOffset", _absent);
          if ((deltaOffset < 0)) {
            throw new InvalidRequestException.InvalidParametersException("The parameter \'deltaOffset\' must not be negative.");
          }
          Optional<Integer> _absent_1 = Optional.<Integer>absent();
          final int deltaReplaceLength = this.getInt(request, "deltaReplaceLength", _absent_1);
          if ((deltaReplaceLength < 0)) {
            throw new InvalidRequestException.InvalidParametersException("The parameter \'deltaReplaceLength\' must not be negative.");
          }
          XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor_1 = new XtextServiceDispatcher.ServiceDescriptor();
          final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function_1 = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
            @Override
            public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
              final Function0<IServiceResult> _function = new Function0<IServiceResult>() {
                @Override
                public IServiceResult apply() {
                  IServiceResult _xtrycatchfinallyexpression = null;
                  try {
                    _xtrycatchfinallyexpression = XtextServiceDispatcher.this.contentAssistService.createProposalsWithUpdate(document, deltaText, deltaOffset, deltaReplaceLength, selection, offset, proposalsLimit);
                  } catch (final Throwable _t) {
                    if (_t instanceof Throwable) {
                      final Throwable throwable = (Throwable)_t;
                      _xtrycatchfinallyexpression = XtextServiceDispatcher.this.handleError(it, throwable);
                    } else {
                      throw Exceptions.sneakyThrow(_t);
                    }
                  }
                  return _xtrycatchfinallyexpression;
                }
              };
              it.service = _function;
              it.hasSideEffects = true;
              it.hasTextInput = true;
            }
          };
          _xblockexpression_1 = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor_1, _function_1);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected XtextServiceDispatcher.ServiceDescriptor getValidationService(final IRequestData request, final ISessionStore sessionStore) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final XtextWebDocumentAccess document = this.getDocumentAccess(request, sessionStore);
      XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor = new XtextServiceDispatcher.ServiceDescriptor();
      final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
        @Override
        public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
          final Function0<IServiceResult> _function = new Function0<IServiceResult>() {
            @Override
            public IServiceResult apply() {
              IServiceResult _xtrycatchfinallyexpression = null;
              try {
                _xtrycatchfinallyexpression = XtextServiceDispatcher.this.validationService.getResult(document);
              } catch (final Throwable _t) {
                if (_t instanceof Throwable) {
                  final Throwable throwable = (Throwable)_t;
                  _xtrycatchfinallyexpression = XtextServiceDispatcher.this.handleError(it, throwable);
                } else {
                  throw Exceptions.sneakyThrow(_t);
                }
              }
              return _xtrycatchfinallyexpression;
            }
          };
          it.service = _function;
          Set<String> _parameterKeys = request.getParameterKeys();
          boolean _contains = _parameterKeys.contains("fullText");
          it.hasTextInput = _contains;
        }
      };
      _xblockexpression = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function);
    }
    return _xblockexpression;
  }
  
  protected XtextServiceDispatcher.ServiceDescriptor getHoverService(final IRequestData request, final ISessionStore sessionStore) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final XtextWebDocumentAccess document = this.getDocumentAccess(request, sessionStore);
      Optional<Integer> _of = Optional.<Integer>of(Integer.valueOf(0));
      final int offset = this.getInt(request, "caretOffset", _of);
      XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor = new XtextServiceDispatcher.ServiceDescriptor();
      final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
        @Override
        public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
          final Function0<IServiceResult> _function = new Function0<IServiceResult>() {
            @Override
            public IServiceResult apply() {
              IServiceResult _xtrycatchfinallyexpression = null;
              try {
                _xtrycatchfinallyexpression = XtextServiceDispatcher.this.hoverService.getHover(document, offset);
              } catch (final Throwable _t) {
                if (_t instanceof Throwable) {
                  final Throwable throwable = (Throwable)_t;
                  _xtrycatchfinallyexpression = XtextServiceDispatcher.this.handleError(it, throwable);
                } else {
                  throw Exceptions.sneakyThrow(_t);
                }
              }
              return _xtrycatchfinallyexpression;
            }
          };
          it.service = _function;
          Set<String> _parameterKeys = request.getParameterKeys();
          boolean _contains = _parameterKeys.contains("fullText");
          it.hasTextInput = _contains;
        }
      };
      _xblockexpression = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function);
    }
    return _xblockexpression;
  }
  
  protected XtextServiceDispatcher.ServiceDescriptor getHighlightingService(final IRequestData request, final ISessionStore sessionStore) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final XtextWebDocumentAccess document = this.getDocumentAccess(request, sessionStore);
      XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor = new XtextServiceDispatcher.ServiceDescriptor();
      final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
        @Override
        public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
          final Function0<IServiceResult> _function = new Function0<IServiceResult>() {
            @Override
            public IServiceResult apply() {
              IServiceResult _xtrycatchfinallyexpression = null;
              try {
                _xtrycatchfinallyexpression = XtextServiceDispatcher.this.highlightingService.getResult(document);
              } catch (final Throwable _t) {
                if (_t instanceof Throwable) {
                  final Throwable throwable = (Throwable)_t;
                  _xtrycatchfinallyexpression = XtextServiceDispatcher.this.handleError(it, throwable);
                } else {
                  throw Exceptions.sneakyThrow(_t);
                }
              }
              return _xtrycatchfinallyexpression;
            }
          };
          it.service = _function;
          Set<String> _parameterKeys = request.getParameterKeys();
          boolean _contains = _parameterKeys.contains("fullText");
          it.hasTextInput = _contains;
        }
      };
      _xblockexpression = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function);
    }
    return _xblockexpression;
  }
  
  protected XtextServiceDispatcher.ServiceDescriptor getOccurrencesService(final IRequestData request, final ISessionStore sessionStore) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final XtextWebDocumentAccess document = this.getDocumentAccess(request, sessionStore);
      Optional<Integer> _of = Optional.<Integer>of(Integer.valueOf(0));
      final int offset = this.getInt(request, "caretOffset", _of);
      XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor = new XtextServiceDispatcher.ServiceDescriptor();
      final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
        @Override
        public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
          final Function0<IServiceResult> _function = new Function0<IServiceResult>() {
            @Override
            public IServiceResult apply() {
              IServiceResult _xtrycatchfinallyexpression = null;
              try {
                _xtrycatchfinallyexpression = XtextServiceDispatcher.this.occurrencesService.findOccurrences(document, offset);
              } catch (final Throwable _t) {
                if (_t instanceof Throwable) {
                  final Throwable throwable = (Throwable)_t;
                  _xtrycatchfinallyexpression = XtextServiceDispatcher.this.handleError(it, throwable);
                } else {
                  throw Exceptions.sneakyThrow(_t);
                }
              }
              return _xtrycatchfinallyexpression;
            }
          };
          it.service = _function;
          Set<String> _parameterKeys = request.getParameterKeys();
          boolean _contains = _parameterKeys.contains("fullText");
          it.hasTextInput = _contains;
        }
      };
      _xblockexpression = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function);
    }
    return _xblockexpression;
  }
  
  protected XtextServiceDispatcher.ServiceDescriptor getFormattingService(final IRequestData request, final ISessionStore sessionStore) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final XtextWebDocumentAccess document = this.getDocumentAccess(request, sessionStore);
      Optional<Integer> _of = Optional.<Integer>of(Integer.valueOf(0));
      final int selectionStart = this.getInt(request, "selectionStart", _of);
      Optional<Integer> _of_1 = Optional.<Integer>of(Integer.valueOf(selectionStart));
      final int selectionEnd = this.getInt(request, "selectionEnd", _of_1);
      TextRegion _xifexpression = null;
      if ((selectionEnd > selectionStart)) {
        _xifexpression = new TextRegion(selectionStart, (selectionEnd - selectionStart));
      } else {
        _xifexpression = null;
      }
      final TextRegion selection = _xifexpression;
      XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor = new XtextServiceDispatcher.ServiceDescriptor();
      final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
        @Override
        public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
          final Function0<IServiceResult> _function = new Function0<IServiceResult>() {
            @Override
            public IServiceResult apply() {
              IServiceResult _xtrycatchfinallyexpression = null;
              try {
                _xtrycatchfinallyexpression = XtextServiceDispatcher.this.formattingService.format(document, selection);
              } catch (final Throwable _t) {
                if (_t instanceof Throwable) {
                  final Throwable throwable = (Throwable)_t;
                  _xtrycatchfinallyexpression = XtextServiceDispatcher.this.handleError(it, throwable);
                } else {
                  throw Exceptions.sneakyThrow(_t);
                }
              }
              return _xtrycatchfinallyexpression;
            }
          };
          it.service = _function;
          Set<String> _parameterKeys = request.getParameterKeys();
          boolean _contains = _parameterKeys.contains("fullText");
          it.hasTextInput = _contains;
          it.hasSideEffects = true;
        }
      };
      _xblockexpression = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function);
    }
    return _xblockexpression;
  }
  
  protected XtextServiceDispatcher.ServiceDescriptor getGeneratorService(final IRequestData request, final ISessionStore sessionStore) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final XtextWebDocumentAccess document = this.getDocumentAccess(request, sessionStore);
      XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor = new XtextServiceDispatcher.ServiceDescriptor();
      final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
        @Override
        public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
          final Function0<IServiceResult> _function = new Function0<IServiceResult>() {
            @Override
            public IServiceResult apply() {
              IServiceResult _xtrycatchfinallyexpression = null;
              try {
                _xtrycatchfinallyexpression = XtextServiceDispatcher.this.generatorService.getResult(document);
              } catch (final Throwable _t) {
                if (_t instanceof Throwable) {
                  final Throwable throwable = (Throwable)_t;
                  _xtrycatchfinallyexpression = XtextServiceDispatcher.this.handleError(it, throwable);
                } else {
                  throw Exceptions.sneakyThrow(_t);
                }
              }
              return _xtrycatchfinallyexpression;
            }
          };
          it.service = _function;
          Set<String> _parameterKeys = request.getParameterKeys();
          boolean _contains = _parameterKeys.contains("fullText");
          it.hasTextInput = _contains;
        }
      };
      _xblockexpression = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function);
    }
    return _xblockexpression;
  }
  
  /**
   * Retrieve the document access for the given request. If the 'fullText' parameter is given,
   * a new document containing that text is created. Otherwise the 'resource' parameter is used
   * to load a resource and put it into the session store.
   */
  protected XtextWebDocumentAccess getDocumentAccess(final IRequestData request, final ISessionStore sessionStore) throws InvalidRequestException {
    XtextWebDocument document = null;
    boolean initializedFromFullText = false;
    Set<String> _parameterKeys = request.getParameterKeys();
    boolean _contains = _parameterKeys.contains("fullText");
    if (_contains) {
      String _parameter = request.getParameter("fullText");
      XtextWebDocument _fullTextDocument = this.getFullTextDocument(_parameter, null, sessionStore);
      document = _fullTextDocument;
      initializedFromFullText = true;
    } else {
      Set<String> _parameterKeys_1 = request.getParameterKeys();
      boolean _contains_1 = _parameterKeys_1.contains("resource");
      if (_contains_1) {
        String _parameter_1 = request.getParameter("resource");
        XtextWebDocument _resourceDocument = this.getResourceDocument(_parameter_1, sessionStore);
        document = _resourceDocument;
        if ((document == null)) {
          throw new InvalidRequestException.ResourceNotFoundException("The requested resource was not found.");
        }
      } else {
        throw new InvalidRequestException.InvalidParametersException("At least one of the parameters \'resource\' and \'fullText\' must be specified.");
      }
    }
    String _parameter_2 = request.getParameter("requiredStateId");
    return this.documentAccessFactory.create(document, _parameter_2, initializedFromFullText);
  }
  
  /**
   * Create a new document containing the given text.
   */
  protected XtextWebDocument getFullTextDocument(final String fullText, final String resourceId, final ISessionStore sessionStore) {
    try {
      final ResourceSet resourceSet = this.resourceSetProvider.get(resourceId);
      String _elvis = null;
      if (resourceId != null) {
        _elvis = resourceId;
      } else {
        String _primaryFileExtension = this.fileExtensionProvider.getPrimaryFileExtension();
        String _plus = ("fulltext." + _primaryFileExtension);
        _elvis = _plus;
      }
      final URI uri = URI.createURI(_elvis);
      Resource _createResource = this.resourceFactory.createResource(uri);
      final XtextResource resource = ((XtextResource) _createResource);
      EList<Resource> _resources = resourceSet.getResources();
      _resources.add(resource);
      StringInputStream _stringInputStream = new StringInputStream(fullText);
      resource.load(_stringInputStream, null);
      final XtextWebDocument document = this.documentProvider.get();
      document.setInput(resource, resourceId);
      if ((resourceId != null)) {
        Pair<Class<XtextWebDocument>, String> _mappedTo = Pair.<Class<XtextWebDocument>, String>of(XtextWebDocument.class, resourceId);
        sessionStore.put(_mappedTo, document);
      }
      return document;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Obtain a document from the session store, and if it is not present there, ask the
   * {@link IServerResourceHandler} to provide it. In case that resource handler fails
   * to provide the document, {@code null} is returned instead.
   */
  protected XtextWebDocument getResourceDocument(final String resourceId, final ISessionStore sessionStore) {
    try {
      Pair<Class<XtextWebDocument>, String> _mappedTo = Pair.<Class<XtextWebDocument>, String>of(XtextWebDocument.class, resourceId);
      final Function0<XtextWebDocument> _function = new Function0<XtextWebDocument>() {
        @Override
        public XtextWebDocument apply() {
          try {
            return XtextServiceDispatcher.this.resourceHandler.get(resourceId);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      return sessionStore.<XtextWebDocument>get(_mappedTo, _function);
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException ioe = (IOException)_t;
        return null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * Read an integer-valued parameter. If the parameter is not available, the
   * {@code defaultValue} is returned.
   * 
   * @throws InvalidRequestException.InvalidParametersException if the parameter
   * 		is not available and {@code defaultValue} is absent
   */
  protected int getInt(final IRequestData request, final String key, final Optional<Integer> defaultValue) throws InvalidRequestException.InvalidParametersException {
    final String stringValue = request.getParameter(key);
    if ((stringValue == null)) {
      boolean _isPresent = defaultValue.isPresent();
      boolean _not = (!_isPresent);
      if (_not) {
        throw new InvalidRequestException.InvalidParametersException((("The parameter \'" + key) + "\' must be specified."));
      }
      Integer _get = defaultValue.get();
      return _get.intValue();
    }
    try {
      return Integer.parseInt(stringValue);
    } catch (final Throwable _t) {
      if (_t instanceof NumberFormatException) {
        final NumberFormatException nfe = (NumberFormatException)_t;
        throw new InvalidRequestException.InvalidParametersException((("The parameter \'" + key) + "\' must contain an integer value."));
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * Read a Boolean-valued parameter. If the parameter is not available, the
   * {@code defaultValue} is returned.
   * 
   * @throws InvalidRequestException.InvalidParametersException if the parameter
   * 		is not available and {@code defaultValue} is absent
   */
  protected boolean getBoolean(final IRequestData request, final String key, final Optional<Boolean> defaultValue) throws InvalidRequestException.InvalidParametersException {
    final String stringValue = request.getParameter(key);
    if ((stringValue == null)) {
      boolean _isPresent = defaultValue.isPresent();
      boolean _not = (!_isPresent);
      if (_not) {
        throw new InvalidRequestException.InvalidParametersException((("The parameter \'" + key) + "\' must be specified."));
      }
      Boolean _get = defaultValue.get();
      return _get.booleanValue();
    }
    String _lowerCase = stringValue.toLowerCase();
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_lowerCase, "true")) {
        _matched=true;
        return true;
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase, "false")) {
        _matched=true;
        return false;
      }
    }
    throw new InvalidRequestException.InvalidParametersException((("The parameter \'" + key) + "\' must contain a Boolean value."));
  }
  
  protected ServiceConflictResult _handleError(final XtextServiceDispatcher.ServiceDescriptor service, final Throwable throwable) {
    try {
      boolean _isOperationCanceledException = this.operationCanceledManager.isOperationCanceledException(throwable);
      if (_isOperationCanceledException) {
        XtextServiceDispatcher.LOG.trace((("Service canceled (" + service.type) + ")"));
        return new ServiceConflictResult("canceled");
      }
      throw throwable;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected ServiceConflictResult _handleError(final XtextServiceDispatcher.ServiceDescriptor service, final InvalidRequestException.InvalidDocumentStateException exception) {
    XtextServiceDispatcher.LOG.trace((("Invalid document state (" + service.type) + ")"));
    return new ServiceConflictResult("invalidStateId");
  }
  
  protected ServiceConflictResult handleError(final XtextServiceDispatcher.ServiceDescriptor service, final Throwable exception) {
    if (exception instanceof InvalidRequestException.InvalidDocumentStateException) {
      return _handleError(service, (InvalidRequestException.InvalidDocumentStateException)exception);
    } else if (exception != null) {
      return _handleError(service, exception);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(service, exception).toString());
    }
  }
  
  private final static Logger LOG = Logger.getLogger(XtextServiceDispatcher.class);
}
