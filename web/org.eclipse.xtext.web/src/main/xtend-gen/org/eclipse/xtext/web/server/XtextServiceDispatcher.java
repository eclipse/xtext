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
import com.google.inject.Singleton;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtext.formatting2.FormatterPreferenceKeys;
import org.eclipse.xtext.formatting2.FormatterPreferences;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.web.server.IServiceContext;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.ISession;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.ServiceConflictResult;
import org.eclipse.xtext.web.server.contentassist.ContentAssistService;
import org.eclipse.xtext.web.server.formatting.FormattingService;
import org.eclipse.xtext.web.server.generator.GeneratorService;
import org.eclipse.xtext.web.server.hover.HoverResult;
import org.eclipse.xtext.web.server.hover.HoverService;
import org.eclipse.xtext.web.server.model.DocumentStateResult;
import org.eclipse.xtext.web.server.model.IWebDocumentProvider;
import org.eclipse.xtext.web.server.model.IWebResourceSetProvider;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
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
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * The entry class for Xtext service invocations. Use {@link #getService(IServiceContext)}
 * to obtain a {@link XtextServiceDispatcher.ServiceDescriptor} for a client request. The service
 * descriptor has some metadata that may influence the message format expected for the request, and
 * may lead to a rejection of the request.
 * 
 * <p> A typical usage can look like this:</p>
 * <pre>
 * val serviceDispatcher = injector.getInstance(XtextServiceDispatcher)
 * val serviceDescriptor = serviceDispatcher.getService(serviceContext)
 * // Check whether the service metadata fits to the request format
 * ...
 * val result = serviceDescriptor.service.apply()
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
     * Context information such as request parameters and session data.
     */
    private IServiceContext context;
    
    /**
     * The function for invoking the service.
     */
    private Function0<? extends IServiceResult> service;
    
    /**
     * Whether the service has any side effects apart from initializing data in the session.
     */
    private boolean hasSideEffects;
    
    /**
     * Whether one of the preconditions of the service does not match, e.g. because it is in
     * conflict with another request.
     */
    private boolean hasConflict;
    
    @Pure
    public IServiceContext getContext() {
      return this.context;
    }
    
    public void setContext(final IServiceContext context) {
      this.context = context;
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
      b.add("context", this.context);
      b.add("service", this.service);
      b.add("hasSideEffects", this.hasSideEffects);
      b.add("hasConflict", this.hasConflict);
      return b.toString();
    }
  }
  
  @Inject
  @FormatterPreferences
  private IPreferenceValuesProvider formatterPreferencesProvider;
  
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
  private IWebDocumentProvider documentProvider;
  
  @Inject
  private FileExtensionProvider fileExtensionProvider;
  
  @Inject
  private IResourceFactory resourceFactory;
  
  @Inject
  private OperationCanceledManager operationCanceledManager;
  
  @Inject
  private XtextWebDocumentAccess.Factory documentAccessFactory;
  
  private final Random randomGenerator = new Random();
  
  @Inject
  protected void registerPreComputedServices(final PrecomputedServiceRegistry registry) {
    registry.addPrecomputedService(this.highlightingService);
    registry.addPrecomputedService(this.validationService);
  }
  
  /**
   * Create a service descriptor according to the parameters given in the service context.
   */
  public XtextServiceDispatcher.ServiceDescriptor getService(final IServiceContext context) throws InvalidRequestException {
    final String serviceType = context.getParameter(IServiceContext.SERVICE_TYPE);
    if ((serviceType == null)) {
      throw new InvalidRequestException.InvalidParametersException("The parameter \'serviceType\' is required.");
    }
    boolean _isTraceEnabled = XtextServiceDispatcher.LOG.isTraceEnabled();
    if (_isTraceEnabled) {
      Set<String> _parameterKeys = context.getParameterKeys();
      List<String> _sort = IterableExtensions.<String>sort(_parameterKeys);
      final Function1<String, CharSequence> _function = new Function1<String, CharSequence>() {
        @Override
        public CharSequence apply(final String key) {
          String _xblockexpression = null;
          {
            final String value = context.getParameter(key);
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
      XtextServiceDispatcher.ServiceDescriptor _createServiceDescriptor = this.createServiceDescriptor(serviceType, context);
      final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function_1 = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
        @Override
        public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
          it.context = context;
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
            it.context = context;
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
  protected XtextServiceDispatcher.ServiceDescriptor createServiceDescriptor(final String serviceType, final IServiceContext context) {
    XtextServiceDispatcher.ServiceDescriptor _switchResult = null;
    boolean _matched = false;
    if (Objects.equal(serviceType, "load")) {
      _matched=true;
      _switchResult = this.getLoadResourceService(false, context);
    }
    if (!_matched) {
      if (Objects.equal(serviceType, "revert")) {
        _matched=true;
        _switchResult = this.getLoadResourceService(true, context);
      }
    }
    if (!_matched) {
      if (Objects.equal(serviceType, "save")) {
        _matched=true;
        _switchResult = this.getSaveResourceService(context);
      }
    }
    if (!_matched) {
      if (Objects.equal(serviceType, "update")) {
        _matched=true;
        _switchResult = this.getUpdateDocumentService(context);
      }
    }
    if (!_matched) {
      if (Objects.equal(serviceType, "assist")) {
        _matched=true;
        _switchResult = this.getContentAssistService(context);
      }
    }
    if (!_matched) {
      if (Objects.equal(serviceType, "validate")) {
        _matched=true;
        _switchResult = this.getValidationService(context);
      }
    }
    if (!_matched) {
      if (Objects.equal(serviceType, "hover")) {
        _matched=true;
        _switchResult = this.getHoverService(context);
      }
    }
    if (!_matched) {
      if (Objects.equal(serviceType, "highlight")) {
        _matched=true;
        _switchResult = this.getHighlightingService(context);
      }
    }
    if (!_matched) {
      if (Objects.equal(serviceType, "occurrences")) {
        _matched=true;
        _switchResult = this.getOccurrencesService(context);
      }
    }
    if (!_matched) {
      if (Objects.equal(serviceType, "format")) {
        _matched=true;
        _switchResult = this.getFormattingService(context);
      }
    }
    if (!_matched) {
      if (Objects.equal(serviceType, "generate")) {
        _matched=true;
        _switchResult = this.getGeneratorService(context);
      }
    }
    if (!_matched) {
      throw new InvalidRequestException.InvalidParametersException((("The service type \'" + serviceType) + "\' is not supported."));
    }
    return _switchResult;
  }
  
  protected XtextServiceDispatcher.ServiceDescriptor getLoadResourceService(final boolean revert, final IServiceContext context) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final String resourceId = this.getResourceID(context);
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
                  _xifexpression = XtextServiceDispatcher.this.resourcePersistenceService.revert(resourceId, XtextServiceDispatcher.this.resourceHandler, context);
                } else {
                  _xifexpression = XtextServiceDispatcher.this.resourcePersistenceService.load(resourceId, XtextServiceDispatcher.this.resourceHandler, context);
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
  
  protected XtextServiceDispatcher.ServiceDescriptor getSaveResourceService(final IServiceContext context) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final XtextWebDocumentAccess document = this.getDocumentAccess(context);
      XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor = new XtextServiceDispatcher.ServiceDescriptor();
      final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
        @Override
        public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
          final Function0<IServiceResult> _function = new Function0<IServiceResult>() {
            @Override
            public IServiceResult apply() {
              IServiceResult _xtrycatchfinallyexpression = null;
              try {
                _xtrycatchfinallyexpression = XtextServiceDispatcher.this.resourcePersistenceService.save(document, XtextServiceDispatcher.this.resourceHandler, context);
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
        }
      };
      _xblockexpression = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function);
    }
    return _xblockexpression;
  }
  
  protected XtextServiceDispatcher.ServiceDescriptor getUpdateDocumentService(final IServiceContext context) throws InvalidRequestException {
    final String resourceId = this.getResourceID(context);
    if ((resourceId == null)) {
      throw new InvalidRequestException.InvalidParametersException("The parameter \'resource\' is required.");
    }
    final String fullText = context.getParameter("fullText");
    XtextWebDocument document = this.getResourceDocument(resourceId, context);
    final boolean initializedFromFullText = (document == null);
    if (initializedFromFullText) {
      if ((fullText == null)) {
        throw new InvalidRequestException.ResourceNotFoundException("The requested resource was not found.");
      }
      XtextWebDocument _fullTextDocument = this.getFullTextDocument(fullText, resourceId, context);
      document = _fullTextDocument;
    }
    String _parameter = context.getParameter("requiredStateId");
    final XtextWebDocumentAccess documentAccess = this.documentAccessFactory.create(document, _parameter, false);
    XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor = new XtextServiceDispatcher.ServiceDescriptor();
    final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
      @Override
      public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
        it.hasSideEffects = true;
      }
    };
    final XtextServiceDispatcher.ServiceDescriptor result = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function);
    if ((fullText == null)) {
      final String deltaText = context.getParameter("deltaText");
      if ((deltaText == null)) {
        throw new InvalidRequestException.InvalidParametersException("One of the parameters \'deltaText\' and \'fullText\' must be specified.");
      }
      Optional<Integer> _absent = Optional.<Integer>absent();
      final int deltaOffset = this.getInt(context, "deltaOffset", _absent);
      if ((deltaOffset < 0)) {
        throw new InvalidRequestException.InvalidParametersException("The parameter \'deltaOffset\' must not be negative.");
      }
      Optional<Integer> _absent_1 = Optional.<Integer>absent();
      final int deltaReplaceLength = this.getInt(context, "deltaReplaceLength", _absent_1);
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
      Set<String> _parameterKeys = context.getParameterKeys();
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
  
  protected XtextServiceDispatcher.ServiceDescriptor getContentAssistService(final IServiceContext context) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      Optional<Integer> _of = Optional.<Integer>of(Integer.valueOf(0));
      final int offset = this.getInt(context, "caretOffset", _of);
      if ((offset < 0)) {
        throw new InvalidRequestException.InvalidParametersException("The parameter \'offset\' must not be negative.");
      }
      final XtextWebDocumentAccess document = this.getDocumentAccess(context);
      Optional<Integer> _of_1 = Optional.<Integer>of(Integer.valueOf(ContentAssistService.DEFAULT_PROPOSALS_LIMIT));
      final int proposalsLimit = this.getInt(context, "proposalsLimit", _of_1);
      if ((proposalsLimit <= 0)) {
        throw new InvalidRequestException.InvalidParametersException("The parameter \'proposalsLimit\' must contain a positive integer.");
      }
      Optional<Integer> _of_2 = Optional.<Integer>of(Integer.valueOf(offset));
      final int selectionStart = this.getInt(context, "selectionStart", _of_2);
      Optional<Integer> _of_3 = Optional.<Integer>of(Integer.valueOf(selectionStart));
      final int selectionEnd = this.getInt(context, "selectionEnd", _of_3);
      int _max = Math.max((selectionEnd - selectionStart), 0);
      final TextRegion selection = new TextRegion(selectionStart, _max);
      final String deltaText = context.getParameter("deltaText");
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
          }
        };
        _xifexpression = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function);
      } else {
        XtextServiceDispatcher.ServiceDescriptor _xblockexpression_1 = null;
        {
          Set<String> _parameterKeys = context.getParameterKeys();
          boolean _contains = _parameterKeys.contains("fullText");
          if (_contains) {
            throw new InvalidRequestException.InvalidParametersException("The parameters \'deltaText\' and \'fullText\' cannot be set in the same request.");
          }
          Optional<Integer> _absent = Optional.<Integer>absent();
          final int deltaOffset = this.getInt(context, "deltaOffset", _absent);
          if ((deltaOffset < 0)) {
            throw new InvalidRequestException.InvalidParametersException("The parameter \'deltaOffset\' must not be negative.");
          }
          Optional<Integer> _absent_1 = Optional.<Integer>absent();
          final int deltaReplaceLength = this.getInt(context, "deltaReplaceLength", _absent_1);
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
  
  protected XtextServiceDispatcher.ServiceDescriptor getValidationService(final IServiceContext context) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final XtextWebDocumentAccess document = this.getDocumentAccess(context);
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
        }
      };
      _xblockexpression = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function);
    }
    return _xblockexpression;
  }
  
  protected XtextServiceDispatcher.ServiceDescriptor getHoverService(final IServiceContext context) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final XtextWebDocumentAccess document = this.getDocumentAccess(context);
      Optional<Integer> _of = Optional.<Integer>of(Integer.valueOf(0));
      final int offset = this.getInt(context, "caretOffset", _of);
      if ((offset < 0)) {
        throw new InvalidRequestException.InvalidParametersException("The parameter \'offset\' must not be negative.");
      }
      Optional<Integer> _of_1 = Optional.<Integer>of(Integer.valueOf(offset));
      final int selectionStart = this.getInt(context, "selectionStart", _of_1);
      Optional<Integer> _of_2 = Optional.<Integer>of(Integer.valueOf(selectionStart));
      final int selectionEnd = this.getInt(context, "selectionEnd", _of_2);
      int _max = Math.max((selectionEnd - selectionStart), 0);
      final TextRegion selection = new TextRegion(selectionStart, _max);
      final String proposal = context.getParameter("proposal");
      XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor = new XtextServiceDispatcher.ServiceDescriptor();
      final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
        @Override
        public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
          final Function0<IServiceResult> _function = new Function0<IServiceResult>() {
            @Override
            public IServiceResult apply() {
              IServiceResult _xtrycatchfinallyexpression = null;
              try {
                HoverResult _xifexpression = null;
                boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(proposal);
                if (_isNullOrEmpty) {
                  _xifexpression = XtextServiceDispatcher.this.hoverService.getHover(document, offset);
                } else {
                  _xifexpression = XtextServiceDispatcher.this.hoverService.getHover(document, proposal, selection, offset);
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
        }
      };
      _xblockexpression = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function);
    }
    return _xblockexpression;
  }
  
  protected XtextServiceDispatcher.ServiceDescriptor getHighlightingService(final IServiceContext context) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final XtextWebDocumentAccess document = this.getDocumentAccess(context);
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
        }
      };
      _xblockexpression = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function);
    }
    return _xblockexpression;
  }
  
  protected XtextServiceDispatcher.ServiceDescriptor getOccurrencesService(final IServiceContext context) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final XtextWebDocumentAccess document = this.getDocumentAccess(context);
      Optional<Integer> _of = Optional.<Integer>of(Integer.valueOf(0));
      final int offset = this.getInt(context, "caretOffset", _of);
      if ((offset < 0)) {
        throw new InvalidRequestException.InvalidParametersException("The parameter \'offset\' must not be negative.");
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
        }
      };
      _xblockexpression = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function);
    }
    return _xblockexpression;
  }
  
  /**
   * @see FormatterPreferenceKeys
   */
  protected XtextServiceDispatcher.ServiceDescriptor getFormattingService(final IServiceContext context) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final XtextWebDocumentAccess document = this.getDocumentAccess(context);
      Optional<Integer> _of = Optional.<Integer>of(Integer.valueOf(0));
      final int selectionStart = this.getInt(context, "selectionStart", _of);
      Optional<Integer> _of_1 = Optional.<Integer>of(Integer.valueOf(selectionStart));
      final int selectionEnd = this.getInt(context, "selectionEnd", _of_1);
      final String lineSeparator = context.getParameter("lineSeparator");
      final String indentation = context.getParameter("indentation");
      Optional<Integer> _of_2 = Optional.<Integer>of(Integer.valueOf(4));
      final int indentationLength = this.getInt(context, "indentationLength", _of_2);
      Optional<Integer> _of_3 = Optional.<Integer>of(Integer.valueOf(120));
      final int maxLineWidth = this.getInt(context, "maxLineWidth", _of_3);
      final CancelableUnitOfWork<IPreferenceValues, IXtextWebDocument> _function = new CancelableUnitOfWork<IPreferenceValues, IXtextWebDocument>() {
        @Override
        public IPreferenceValues exec(final IXtextWebDocument $0, final CancelIndicator $1) throws Exception {
          XtextResource _resource = $0.getResource();
          return XtextServiceDispatcher.this.formatterPreferencesProvider.getPreferenceValues(_resource);
        }
      };
      final IPreferenceValues formatterPreferences = document.<IPreferenceValues>readOnly(_function);
      LinkedHashMap<String, String> _newLinkedHashMap = CollectionLiterals.<String, String>newLinkedHashMap();
      final MapBasedPreferenceValues preferences = new MapBasedPreferenceValues(formatterPreferences, _newLinkedHashMap);
      preferences.<String>put(FormatterPreferenceKeys.lineSeparator, lineSeparator);
      preferences.<String>put(FormatterPreferenceKeys.indentation, indentation);
      preferences.<Integer>put(FormatterPreferenceKeys.indentationLength, Integer.valueOf(indentationLength));
      preferences.<Integer>put(FormatterPreferenceKeys.maxLineWidth, Integer.valueOf(maxLineWidth));
      TextRegion _xifexpression = null;
      if ((selectionEnd > selectionStart)) {
        _xifexpression = new TextRegion(selectionStart, (selectionEnd - selectionStart));
      } else {
        _xifexpression = null;
      }
      final TextRegion selection = _xifexpression;
      XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor = new XtextServiceDispatcher.ServiceDescriptor();
      final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function_1 = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
        @Override
        public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
          final Function0<IServiceResult> _function = new Function0<IServiceResult>() {
            @Override
            public IServiceResult apply() {
              IServiceResult _xtrycatchfinallyexpression = null;
              try {
                _xtrycatchfinallyexpression = XtextServiceDispatcher.this.formattingService.format(document, selection, preferences);
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
        }
      };
      _xblockexpression = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function_1);
    }
    return _xblockexpression;
  }
  
  protected XtextServiceDispatcher.ServiceDescriptor getGeneratorService(final IServiceContext context) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final XtextWebDocumentAccess document = this.getDocumentAccess(context);
      Optional<Boolean> _of = Optional.<Boolean>of(Boolean.valueOf(false));
      final boolean allArtifacts = this.getBoolean(context, "allArtifacts", _of);
      Optional<Boolean> _of_1 = Optional.<Boolean>of(Boolean.valueOf(true));
      final boolean includeContent = this.getBoolean(context, "includeContent", _of_1);
      XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor = new XtextServiceDispatcher.ServiceDescriptor();
      final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
        @Override
        public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
          if (allArtifacts) {
            final Function0<IServiceResult> _function = new Function0<IServiceResult>() {
              @Override
              public IServiceResult apply() {
                IServiceResult _xtrycatchfinallyexpression = null;
                try {
                  _xtrycatchfinallyexpression = XtextServiceDispatcher.this.generatorService.getResult(document, includeContent);
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
          } else {
            final String artifactId = context.getParameter("artifact");
            final Function0<IServiceResult> _function_1 = new Function0<IServiceResult>() {
              @Override
              public IServiceResult apply() {
                IServiceResult _xtrycatchfinallyexpression = null;
                try {
                  _xtrycatchfinallyexpression = XtextServiceDispatcher.this.generatorService.getArtifact(document, artifactId, includeContent);
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
            it.service = _function_1;
          }
        }
      };
      _xblockexpression = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function);
    }
    return _xblockexpression;
  }
  
  /**
   * Retrieve the document access for the given service context. If the 'fullText' parameter is given,
   * a new document containing that text is created. Otherwise the 'resource' parameter is used
   * to load a resource and put it into the session store.
   */
  protected XtextWebDocumentAccess getDocumentAccess(final IServiceContext context) throws InvalidRequestException {
    XtextWebDocument document = null;
    boolean initializedFromFullText = false;
    Set<String> _parameterKeys = context.getParameterKeys();
    boolean _contains = _parameterKeys.contains("fullText");
    if (_contains) {
      String _parameter = context.getParameter("fullText");
      String _resourceID = this.getResourceID(context);
      XtextWebDocument _fullTextDocument = this.getFullTextDocument(_parameter, _resourceID, context);
      document = _fullTextDocument;
      initializedFromFullText = true;
    } else {
      Set<String> _parameterKeys_1 = context.getParameterKeys();
      boolean _contains_1 = _parameterKeys_1.contains("resource");
      if (_contains_1) {
        String _resourceID_1 = this.getResourceID(context);
        XtextWebDocument _resourceDocument = this.getResourceDocument(_resourceID_1, context);
        document = _resourceDocument;
        if ((document == null)) {
          throw new InvalidRequestException.ResourceNotFoundException("The requested resource was not found.");
        }
      } else {
        throw new InvalidRequestException.InvalidParametersException("At least one of the parameters \'resource\' and \'fullText\' must be specified.");
      }
    }
    String _parameter_1 = context.getParameter("requiredStateId");
    return this.documentAccessFactory.create(document, _parameter_1, initializedFromFullText);
  }
  
  /**
   * Returns the resource ID from the service context. Potentially null.
   */
  protected String getResourceID(final IServiceContext context) {
    return context.getParameter("resource");
  }
  
  /**
   * Create a new document containing the given text.
   */
  protected XtextWebDocument getFullTextDocument(final String fullText, final String resourceId, final IServiceContext context) {
    try {
      final ResourceSet resourceSet = this.resourceSetProvider.get(resourceId, context);
      String _elvis = null;
      if (resourceId != null) {
        _elvis = resourceId;
      } else {
        int _nextInt = this.randomGenerator.nextInt();
        String _hexString = Integer.toHexString(_nextInt);
        String _plus = (_hexString + ".");
        String _primaryFileExtension = this.fileExtensionProvider.getPrimaryFileExtension();
        String _plus_1 = (_plus + _primaryFileExtension);
        _elvis = _plus_1;
      }
      final URI uri = URI.createURI(_elvis);
      Resource _createResource = this.resourceFactory.createResource(uri);
      final XtextResource resource = ((XtextResource) _createResource);
      final Resource existingResource = resourceSet.getResource(uri, false);
      if ((existingResource != null)) {
        EList<Resource> _resources = resourceSet.getResources();
        _resources.remove(existingResource);
      }
      EList<Resource> _resources_1 = resourceSet.getResources();
      _resources_1.add(resource);
      StringInputStream _stringInputStream = new StringInputStream(fullText);
      Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
      resource.load(_stringInputStream, _emptyMap);
      final XtextWebDocument document = this.documentProvider.get(resourceId, context);
      document.setInput(resource);
      if ((resourceId != null)) {
        ISession _session = context.getSession();
        Pair<Class<XtextWebDocument>, String> _mappedTo = Pair.<Class<XtextWebDocument>, String>of(XtextWebDocument.class, resourceId);
        _session.put(_mappedTo, document);
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
  protected XtextWebDocument getResourceDocument(final String resourceId, final IServiceContext context) {
    try {
      ISession _session = context.getSession();
      Pair<Class<XtextWebDocument>, String> _mappedTo = Pair.<Class<XtextWebDocument>, String>of(XtextWebDocument.class, resourceId);
      final Function0<XtextWebDocument> _function = new Function0<XtextWebDocument>() {
        @Override
        public XtextWebDocument apply() {
          try {
            return XtextServiceDispatcher.this.resourceHandler.get(resourceId, context);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      final XtextWebDocument document = _session.<XtextWebDocument>get(_mappedTo, _function);
      return document;
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
   * Read an string-valued parameter. If the parameter is not available, the
   * {@code defaultValue} is returned.
   * 
   * @throws InvalidRequestException.InvalidParametersException if the parameter
   * 		is not available and {@code defaultValue} is absent
   */
  protected String getString(final IServiceContext context, final String key, final Optional<String> defaultValue) throws InvalidRequestException.InvalidParametersException {
    final String stringValue = context.getParameter(key);
    if ((stringValue == null)) {
      boolean _isPresent = defaultValue.isPresent();
      boolean _not = (!_isPresent);
      if (_not) {
        throw new InvalidRequestException.InvalidParametersException((("The parameter \'" + key) + "\' must be specified."));
      }
      return defaultValue.get();
    }
    return stringValue;
  }
  
  /**
   * Read an integer-valued parameter. If the parameter is not available, the
   * {@code defaultValue} is returned.
   * 
   * @throws InvalidRequestException.InvalidParametersException if the parameter
   * 		is not available and {@code defaultValue} is absent
   */
  protected int getInt(final IServiceContext context, final String key, final Optional<Integer> defaultValue) throws InvalidRequestException.InvalidParametersException {
    final String stringValue = context.getParameter(key);
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
  protected boolean getBoolean(final IServiceContext context, final String key, final Optional<Boolean> defaultValue) throws InvalidRequestException.InvalidParametersException {
    final String stringValue = context.getParameter(key);
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
    if (Objects.equal(_lowerCase, "true")) {
      _matched=true;
      return true;
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
        String _parameter = service.context.getParameter(IServiceContext.SERVICE_TYPE);
        String _plus = ("Service canceled (" + _parameter);
        String _plus_1 = (_plus + ")");
        XtextServiceDispatcher.LOG.trace(_plus_1);
        return new ServiceConflictResult("canceled");
      }
      throw throwable;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected ServiceConflictResult _handleError(final XtextServiceDispatcher.ServiceDescriptor service, final InvalidRequestException.InvalidDocumentStateException exception) {
    String _parameter = service.context.getParameter(IServiceContext.SERVICE_TYPE);
    String _plus = ("Invalid document state (" + _parameter);
    String _plus_1 = (_plus + ")");
    XtextServiceDispatcher.LOG.trace(_plus_1);
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
