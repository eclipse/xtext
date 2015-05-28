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
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
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
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.ISessionStore;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.ServiceConflictResult;
import org.eclipse.xtext.web.server.contentassist.ContentAssistService;
import org.eclipse.xtext.web.server.model.IWebResourceSetProvider;
import org.eclipse.xtext.web.server.model.UpdateDocumentService;
import org.eclipse.xtext.web.server.model.XtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler;
import org.eclipse.xtext.web.server.persistence.ResourceContentResult;
import org.eclipse.xtext.web.server.persistence.ResourcePersistenceService;
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

@Singleton
@SuppressWarnings("all")
public class XtextServiceDispatcher {
  @Accessors
  @ToString
  public static class ServiceDescriptor {
    private String type;
    
    private Function0<? extends IServiceResult> service;
    
    private boolean hasSideEffects;
    
    private boolean hasTextInput;
    
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
  
  private final static Logger LOG = Logger.getLogger(XtextServiceDispatcher.class);
  
  @Inject
  private ResourcePersistenceService resourcePersistenceService;
  
  @Inject
  private UpdateDocumentService updateDocumentService;
  
  @Inject
  private ContentAssistService contentAssistService;
  
  @Inject
  private ValidationService validationService;
  
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
  
  public XtextServiceDispatcher.ServiceDescriptor getService(final String path, final Map<String, String> parameters, final ISessionStore sessionStore) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final String requestType = this.getRequestType(path, parameters);
      boolean _isTraceEnabled = XtextServiceDispatcher.LOG.isTraceEnabled();
      if (_isTraceEnabled) {
        Set<Map.Entry<String, String>> _entrySet = parameters.entrySet();
        final Function1<Map.Entry<String, String>, String> _function = new Function1<Map.Entry<String, String>, String>() {
          @Override
          public String apply(final Map.Entry<String, String> it) {
            return it.getKey();
          }
        };
        List<Map.Entry<String, String>> _sortBy = IterableExtensions.<Map.Entry<String, String>, String>sortBy(_entrySet, _function);
        final Function1<Map.Entry<String, String>, CharSequence> _function_1 = new Function1<Map.Entry<String, String>, CharSequence>() {
          @Override
          public CharSequence apply(final Map.Entry<String, String> it) {
            String _xifexpression = null;
            String _value = it.getValue();
            int _length = _value.length();
            boolean _greaterThan = (_length > 18);
            if (_greaterThan) {
              String _key = it.getKey();
              String _plus = (_key + "=\'");
              String _value_1 = it.getValue();
              String _substring = _value_1.substring(0, 16);
              String _plus_1 = (_plus + _substring);
              _xifexpression = (_plus_1 + "...\'");
            } else {
              String _xifexpression_1 = null;
              String _value_2 = it.getValue();
              boolean _matches = _value_2.matches(".*\\s+.*");
              if (_matches) {
                String _key_1 = it.getKey();
                String _plus_2 = (_key_1 + "=\'");
                String _value_3 = it.getValue();
                String _plus_3 = (_plus_2 + _value_3);
                _xifexpression_1 = (_plus_3 + "\'");
              } else {
                String _key_2 = it.getKey();
                String _plus_4 = (_key_2 + "=");
                String _value_4 = it.getValue();
                _xifexpression_1 = (_plus_4 + _value_4);
              }
              _xifexpression = _xifexpression_1;
            }
            return _xifexpression;
          }
        };
        String _join = IterableExtensions.<Map.Entry<String, String>>join(_sortBy, ": ", ", ", "", _function_1);
        final String stringParams = _join.replaceAll("(\\n|\\f|\\r)+", " ");
        XtextServiceDispatcher.LOG.trace((("xtext-service/" + requestType) + stringParams));
      }
      XtextServiceDispatcher.ServiceDescriptor _xtrycatchfinallyexpression = null;
      try {
        XtextServiceDispatcher.ServiceDescriptor _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          if (Objects.equal(requestType, "load")) {
            _matched=true;
            _switchResult = this.getLoadResourceService(false, parameters, sessionStore);
          }
        }
        if (!_matched) {
          if (Objects.equal(requestType, "revert")) {
            _matched=true;
            _switchResult = this.getLoadResourceService(true, parameters, sessionStore);
          }
        }
        if (!_matched) {
          if (Objects.equal(requestType, "save")) {
            _matched=true;
            _switchResult = this.getSaveResourceService(parameters, sessionStore);
          }
        }
        if (!_matched) {
          if (Objects.equal(requestType, "update")) {
            _matched=true;
            _switchResult = this.getUpdateDocumentService(parameters, sessionStore);
          }
        }
        if (!_matched) {
          if (Objects.equal(requestType, "validation")) {
            _matched=true;
            _switchResult = this.getValidationService(parameters, sessionStore);
          }
        }
        if (!_matched) {
          if (Objects.equal(requestType, "content-assist")) {
            _matched=true;
            _switchResult = this.getContentAssistService(parameters, sessionStore);
          }
        }
        if (!_matched) {
          throw new InvalidRequestException(InvalidRequestException.Type.INVALID_PARAMETERS, (("The request type \'" + requestType) + "\' is not supported."));
        }
        final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function_2 = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
          @Override
          public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
            it.type = requestType;
          }
        };
        _xtrycatchfinallyexpression = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_switchResult, _function_2);
      } catch (final Throwable _t) {
        if (_t instanceof InvalidRequestException) {
          final InvalidRequestException ire = (InvalidRequestException)_t;
          InvalidRequestException.Type _type = ire.getType();
          boolean _equals = Objects.equal(_type, InvalidRequestException.Type.INVALID_DOCUMENT_STATE);
          if (_equals) {
            XtextServiceDispatcher.LOG.trace((("Invalid document state (" + requestType) + ")"));
            XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor = new XtextServiceDispatcher.ServiceDescriptor();
            final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function_3 = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
              @Override
              public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
                it.type = requestType;
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
            return ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function_3);
          }
          throw ire;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  protected String getRequestType(final String contextPath, final Map<String, String> parameters) {
    if ((contextPath != null)) {
      final StringTokenizer tokenizer = new StringTokenizer(contextPath, "/");
      boolean _hasMoreTokens = tokenizer.hasMoreTokens();
      if (_hasMoreTokens) {
        return tokenizer.nextToken();
      }
    }
    String _elvis = null;
    String _get = parameters.get("requestType");
    if (_get != null) {
      _elvis = _get;
    } else {
      _elvis = "";
    }
    return _elvis;
  }
  
  protected XtextServiceDispatcher.ServiceDescriptor getLoadResourceService(final boolean revert, final Map<String, String> parameters, final ISessionStore sessionStore) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final String resourceId = parameters.get("resource");
      if ((resourceId == null)) {
        throw new InvalidRequestException(InvalidRequestException.Type.INVALID_PARAMETERS, "The parameter \'resource\' is required.");
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
  
  protected XtextServiceDispatcher.ServiceDescriptor getSaveResourceService(final Map<String, String> parameters, final ISessionStore sessionStore) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final XtextWebDocumentAccess document = this.getDocumentAccess(parameters, sessionStore);
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
          boolean _containsKey = parameters.containsKey("fullText");
          it.hasTextInput = _containsKey;
        }
      };
      _xblockexpression = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function);
    }
    return _xblockexpression;
  }
  
  protected XtextServiceDispatcher.ServiceDescriptor getUpdateDocumentService(final Map<String, String> parameters, final ISessionStore sessionStore) throws InvalidRequestException {
    final String resourceId = parameters.get("resource");
    if ((resourceId == null)) {
      throw new InvalidRequestException(InvalidRequestException.Type.INVALID_PARAMETERS, "The parameter \'resource\' is required.");
    }
    final String fullText = parameters.get("fullText");
    final boolean[] initializedFromFullText = new boolean[1];
    final Provider<XtextWebDocument> _function = new Provider<XtextWebDocument>() {
      @Override
      public XtextWebDocument get() {
        try {
          XtextWebDocument _xifexpression = null;
          if ((fullText != null)) {
            XtextWebDocument _xblockexpression = null;
            {
              initializedFromFullText[0] = true;
              _xblockexpression = XtextServiceDispatcher.this.getFullTextDocument(fullText, resourceId, sessionStore);
            }
            _xifexpression = _xblockexpression;
          } else {
            throw new InvalidRequestException(InvalidRequestException.Type.RESOURCE_NOT_FOUND, "The requested resource was not found.");
          }
          return _xifexpression;
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    XtextWebDocument _resourceDocument = this.getResourceDocument(resourceId, sessionStore, _function);
    String _get = parameters.get("requiredStateId");
    final XtextWebDocumentAccess document = new XtextWebDocumentAccess(_resourceDocument, _get);
    XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor = new XtextServiceDispatcher.ServiceDescriptor();
    final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function_1 = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
      @Override
      public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
        it.hasSideEffects = true;
        it.hasTextInput = true;
      }
    };
    final XtextServiceDispatcher.ServiceDescriptor result = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function_1);
    if ((fullText == null)) {
      final String deltaText = parameters.get("deltaText");
      if ((deltaText == null)) {
        throw new InvalidRequestException(InvalidRequestException.Type.INVALID_PARAMETERS, "One of the parameters \'deltaText\' and \'fullText\' must be specified.");
      }
      Optional<Integer> _absent = Optional.<Integer>absent();
      final int deltaOffset = this.getInt(parameters, "deltaOffset", _absent);
      if ((deltaOffset < 0)) {
        throw new InvalidRequestException(InvalidRequestException.Type.INVALID_PARAMETERS, "The parameter \'deltaOffset\' must not be negative.");
      }
      Optional<Integer> _absent_1 = Optional.<Integer>absent();
      final int deltaReplaceLength = this.getInt(parameters, "deltaReplaceLength", _absent_1);
      if ((deltaReplaceLength < 0)) {
        throw new InvalidRequestException(InvalidRequestException.Type.INVALID_PARAMETERS, "The parameter \'deltaReplaceLength\' must not be negative.");
      }
      final Function0<IServiceResult> _function_2 = new Function0<IServiceResult>() {
        @Override
        public IServiceResult apply() {
          IServiceResult _xtrycatchfinallyexpression = null;
          try {
            _xtrycatchfinallyexpression = XtextServiceDispatcher.this.updateDocumentService.updateDeltaText(document, deltaText, deltaOffset, deltaReplaceLength);
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
    } else {
      boolean _containsKey = parameters.containsKey("deltaText");
      if (_containsKey) {
        throw new InvalidRequestException(InvalidRequestException.Type.INVALID_PARAMETERS, "The parameters \'deltaText\' and \'fullText\' cannot be set in the same request.");
      }
      final Function0<IServiceResult> _function_3 = new Function0<IServiceResult>() {
        @Override
        public IServiceResult apply() {
          IServiceResult _xtrycatchfinallyexpression = null;
          try {
            boolean _get = initializedFromFullText[0];
            boolean _not = (!_get);
            _xtrycatchfinallyexpression = XtextServiceDispatcher.this.updateDocumentService.updateFullText(document, fullText, _not);
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
      result.service = _function_3;
    }
    return result;
  }
  
  protected XtextServiceDispatcher.ServiceDescriptor getContentAssistService(final Map<String, String> parameters, final ISessionStore sessionStore) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      Optional<Integer> _of = Optional.<Integer>of(Integer.valueOf(0));
      final int offset = this.getInt(parameters, "caretOffset", _of);
      final XtextWebDocumentAccess document = this.getDocumentAccess(parameters, sessionStore);
      Optional<Integer> _of_1 = Optional.<Integer>of(Integer.valueOf(offset));
      final int selectionStart = this.getInt(parameters, "selectionStart", _of_1);
      Optional<Integer> _of_2 = Optional.<Integer>of(Integer.valueOf(selectionStart));
      final int selectionEnd = this.getInt(parameters, "selectionEnd", _of_2);
      int _max = Math.max((selectionEnd - selectionStart), 0);
      final TextRegion selection = new TextRegion(selectionStart, _max);
      final String deltaText = parameters.get("deltaText");
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
                  _xtrycatchfinallyexpression = XtextServiceDispatcher.this.contentAssistService.createProposals(document, selection, offset);
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
            boolean _containsKey = parameters.containsKey("fullText");
            it.hasTextInput = _containsKey;
          }
        };
        _xifexpression = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function);
      } else {
        XtextServiceDispatcher.ServiceDescriptor _xblockexpression_1 = null;
        {
          boolean _containsKey = parameters.containsKey("fullText");
          if (_containsKey) {
            throw new InvalidRequestException(InvalidRequestException.Type.INVALID_PARAMETERS, "The parameters \'deltaText\' and \'fullText\' cannot be set in the same request.");
          }
          Optional<Integer> _absent = Optional.<Integer>absent();
          final int deltaOffset = this.getInt(parameters, "deltaOffset", _absent);
          if ((deltaOffset < 0)) {
            throw new InvalidRequestException(InvalidRequestException.Type.INVALID_PARAMETERS, "The parameter \'deltaOffset\' must not be negative.");
          }
          Optional<Integer> _absent_1 = Optional.<Integer>absent();
          final int deltaReplaceLength = this.getInt(parameters, "deltaReplaceLength", _absent_1);
          if ((deltaReplaceLength < 0)) {
            throw new InvalidRequestException(InvalidRequestException.Type.INVALID_PARAMETERS, "The parameter \'deltaReplaceLength\' must not be negative.");
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
                    _xtrycatchfinallyexpression = XtextServiceDispatcher.this.contentAssistService.createProposalsWithUpdate(document, deltaText, deltaOffset, deltaReplaceLength, selection, offset);
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
  
  protected XtextServiceDispatcher.ServiceDescriptor getValidationService(final Map<String, String> parameters, final ISessionStore sessionStore) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final XtextWebDocumentAccess document = this.getDocumentAccess(parameters, sessionStore);
      XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor = new XtextServiceDispatcher.ServiceDescriptor();
      final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
        @Override
        public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
          final Function0<IServiceResult> _function = new Function0<IServiceResult>() {
            @Override
            public IServiceResult apply() {
              IServiceResult _xtrycatchfinallyexpression = null;
              try {
                _xtrycatchfinallyexpression = XtextServiceDispatcher.this.validationService.validate(document);
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
          boolean _containsKey = parameters.containsKey("fullText");
          it.hasTextInput = _containsKey;
        }
      };
      _xblockexpression = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_serviceDescriptor, _function);
    }
    return _xblockexpression;
  }
  
  protected XtextWebDocumentAccess getDocumentAccess(final Map<String, String> parameters, final ISessionStore sessionStore) throws InvalidRequestException {
    XtextWebDocument document = null;
    boolean _containsKey = parameters.containsKey("fullText");
    if (_containsKey) {
      String _get = parameters.get("fullText");
      XtextWebDocument _fullTextDocument = this.getFullTextDocument(_get, null, sessionStore);
      document = _fullTextDocument;
    } else {
      boolean _containsKey_1 = parameters.containsKey("resource");
      if (_containsKey_1) {
        String _get_1 = parameters.get("resource");
        final Provider<XtextWebDocument> _function = new Provider<XtextWebDocument>() {
          @Override
          public XtextWebDocument get() {
            try {
              throw new InvalidRequestException(InvalidRequestException.Type.RESOURCE_NOT_FOUND, "The requested resource was not found.");
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          }
        };
        XtextWebDocument _resourceDocument = this.getResourceDocument(_get_1, sessionStore, _function);
        document = _resourceDocument;
      } else {
        throw new InvalidRequestException(InvalidRequestException.Type.INVALID_PARAMETERS, "At least one of the parameters \'resource\' and \'fullText\' must be specified.");
      }
    }
    String _get_2 = parameters.get("requiredStateId");
    return new XtextWebDocumentAccess(document, _get_2);
  }
  
  protected XtextWebDocument getFullTextDocument(final String fullText, final String resourceId, final ISessionStore sessionStore) {
    try {
      final ResourceSet resourceSet = this.resourceSetProvider.get(resourceId);
      String _elvis = null;
      if (resourceId != null) {
        _elvis = resourceId;
      } else {
        String _primaryFileExtension = this.fileExtensionProvider.getPrimaryFileExtension();
        String _plus = ("fullText." + _primaryFileExtension);
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
  
  protected XtextWebDocument getResourceDocument(final String resourceId, final ISessionStore sessionStore, final Provider<XtextWebDocument> alternativeDocumentProvider) {
    Pair<Class<XtextWebDocument>, String> _mappedTo = Pair.<Class<XtextWebDocument>, String>of(XtextWebDocument.class, resourceId);
    final Function0<XtextWebDocument> _function = new Function0<XtextWebDocument>() {
      @Override
      public XtextWebDocument apply() {
        try {
          return XtextServiceDispatcher.this.resourceHandler.get(resourceId);
        } catch (final Throwable _t) {
          if (_t instanceof IOException) {
            final IOException ioe = (IOException)_t;
            return alternativeDocumentProvider.get();
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    };
    return sessionStore.<XtextWebDocument>get(_mappedTo, _function);
  }
  
  protected int getInt(final Map<String, String> parameters, final String key, final Optional<Integer> defaultValue) throws InvalidRequestException {
    final String stringValue = parameters.get(key);
    if ((stringValue == null)) {
      boolean _isPresent = defaultValue.isPresent();
      boolean _not = (!_isPresent);
      if (_not) {
        throw new InvalidRequestException(InvalidRequestException.Type.INVALID_PARAMETERS, (("The parameter \'" + key) + "\' must be specified."));
      }
      Integer _get = defaultValue.get();
      return _get.intValue();
    }
    try {
      return Integer.parseInt(stringValue);
    } catch (final Throwable _t) {
      if (_t instanceof NumberFormatException) {
        final NumberFormatException nfe = (NumberFormatException)_t;
        throw new InvalidRequestException(InvalidRequestException.Type.INVALID_PARAMETERS, (("The parameter \'" + key) + "\' must contain an integer value."));
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected boolean getBoolean(final Map<String, String> parameters, final String key, final Optional<Boolean> defaultValue) throws InvalidRequestException {
    final String stringValue = parameters.get(key);
    if ((stringValue == null)) {
      boolean _isPresent = defaultValue.isPresent();
      boolean _not = (!_isPresent);
      if (_not) {
        throw new InvalidRequestException(InvalidRequestException.Type.INVALID_PARAMETERS, (("The parameter \'" + key) + "\' must be specified."));
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
    throw new InvalidRequestException(InvalidRequestException.Type.INVALID_PARAMETERS, (("The parameter \'" + key) + "\' must contain a Boolean value."));
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
  
  protected ServiceConflictResult _handleError(final XtextServiceDispatcher.ServiceDescriptor service, final InvalidRequestException exception) {
    try {
      InvalidRequestException.Type _type = exception.getType();
      boolean _equals = Objects.equal(_type, InvalidRequestException.Type.INVALID_DOCUMENT_STATE);
      if (_equals) {
        XtextServiceDispatcher.LOG.trace((("Invalid document state (" + service.type) + ")"));
        return new ServiceConflictResult("invalidStateId");
      }
      throw exception;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected ServiceConflictResult handleError(final XtextServiceDispatcher.ServiceDescriptor service, final Throwable exception) {
    if (exception instanceof InvalidRequestException) {
      return _handleError(service, (InvalidRequestException)exception);
    } else if (exception != null) {
      return _handleError(service, exception);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(service, exception).toString());
    }
  }
}
