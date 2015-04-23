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
import java.util.Map;
import java.util.StringTokenizer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.ISessionStore;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.contentassist.ContentAssistService;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.UpdateDocumentService;
import org.eclipse.xtext.web.server.model.XtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler;
import org.eclipse.xtext.web.server.persistence.ResourceContentResult;
import org.eclipse.xtext.web.server.persistence.ResourcePersistenceService;
import org.eclipse.xtext.web.server.validation.ValidationService;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@Singleton
@SuppressWarnings("all")
public class XtextServiceDispatcher {
  @Accessors
  public static class ServiceDescriptor {
    private String type;
    
    private Function0<? extends IServiceResult> service;
    
    private boolean hasSideEffects;
    
    private boolean hasTextInput;
    
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
  }
  
  @Inject
  private ResourcePersistenceService resourcePersistenceService;
  
  @Inject
  private UpdateDocumentService updateDocumentService;
  
  @Inject
  private ValidationService validationService;
  
  @Inject
  private ContentAssistService contentAssistService;
  
  @Inject
  private IServerResourceHandler resourceHandler;
  
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  private FileExtensionProvider fileExtensionProvider;
  
  @Inject
  private IResourceFactory resourceFactory;
  
  public XtextServiceDispatcher.ServiceDescriptor getService(final String path, final Map<String, String> parameters, final ISessionStore sessionStore) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final String requestType = this.getRequestType(path, parameters);
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
      final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
        @Override
        public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
          it.type = requestType;
        }
      };
      _xblockexpression = ObjectExtensions.<XtextServiceDispatcher.ServiceDescriptor>operator_doubleArrow(_switchResult, _function);
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
              try {
                ResourceContentResult _xifexpression = null;
                if (revert) {
                  _xifexpression = XtextServiceDispatcher.this.resourcePersistenceService.revert(resourceId, XtextServiceDispatcher.this.resourceHandler, sessionStore);
                } else {
                  _xifexpression = XtextServiceDispatcher.this.resourcePersistenceService.load(resourceId, XtextServiceDispatcher.this.resourceHandler, sessionStore);
                }
                return _xifexpression;
              } catch (Throwable _e) {
                throw Exceptions.sneakyThrow(_e);
              }
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
              try {
                return XtextServiceDispatcher.this.resourcePersistenceService.save(document, XtextServiceDispatcher.this.resourceHandler);
              } catch (Throwable _e) {
                throw Exceptions.sneakyThrow(_e);
              }
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
    final Provider<XtextWebDocument> _function = new Provider<XtextWebDocument>() {
      @Override
      public XtextWebDocument get() {
        try {
          XtextWebDocument _xifexpression = null;
          if ((fullText != null)) {
            _xifexpression = XtextServiceDispatcher.this.getFullTextDocument(fullText, resourceId, sessionStore);
          } else {
            throw new InvalidRequestException(InvalidRequestException.Type.RESOURCE_NOT_FOUND, "The requested resource was not found.");
          }
          return _xifexpression;
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    IXtextWebDocument _resourceDocument = this.getResourceDocument(resourceId, sessionStore, _function);
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
        throw new InvalidRequestException(InvalidRequestException.Type.INVALID_PARAMETERS, "At least one of the parameters \'deltaText\' and \'fullText\' must be specified.");
      }
      Optional<Integer> _absent = Optional.<Integer>absent();
      final Integer deltaOffset = this.getInt(parameters, "deltaOffset", _absent);
      if (((deltaOffset).intValue() < 0)) {
        throw new InvalidRequestException(InvalidRequestException.Type.INVALID_PARAMETERS, "The parameter \'deltaOffset\' must not be negative.");
      }
      Optional<Integer> _absent_1 = Optional.<Integer>absent();
      final Integer deltaReplaceLength = this.getInt(parameters, "deltaReplaceLength", _absent_1);
      if (((deltaReplaceLength).intValue() < 0)) {
        throw new InvalidRequestException(InvalidRequestException.Type.INVALID_PARAMETERS, "The parameter \'deltaReplaceLength\' must not be negative.");
      }
      final Function0<IServiceResult> _function_2 = new Function0<IServiceResult>() {
        @Override
        public IServiceResult apply() {
          try {
            return XtextServiceDispatcher.this.updateDocumentService.updateDeltaText(document, deltaText, (deltaOffset).intValue(), (deltaReplaceLength).intValue());
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      result.service = _function_2;
    } else {
      final Function0<IServiceResult> _function_3 = new Function0<IServiceResult>() {
        @Override
        public IServiceResult apply() {
          try {
            return XtextServiceDispatcher.this.updateDocumentService.updateFullText(document, fullText);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      result.service = _function_3;
    }
    return result;
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
              try {
                return XtextServiceDispatcher.this.validationService.validate(document);
              } catch (Throwable _e) {
                throw Exceptions.sneakyThrow(_e);
              }
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
  
  protected XtextServiceDispatcher.ServiceDescriptor getContentAssistService(final Map<String, String> parameters, final ISessionStore sessionStore) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      Optional<Integer> _of = Optional.<Integer>of(Integer.valueOf(0));
      final Integer offset = this.getInt(parameters, "caretOffset", _of);
      final XtextWebDocumentAccess document = this.getDocumentAccess(parameters, sessionStore);
      Optional<Integer> _of_1 = Optional.<Integer>of(offset);
      final Integer selectionStart = this.getInt(parameters, "selectionStart", _of_1);
      Optional<Integer> _of_2 = Optional.<Integer>of(selectionStart);
      final Integer selectionEnd = this.getInt(parameters, "selectionEnd", _of_2);
      int _max = Math.max(((selectionEnd).intValue() - (selectionStart).intValue()), 0);
      final TextRegion selection = new TextRegion((selectionStart).intValue(), _max);
      XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor = new XtextServiceDispatcher.ServiceDescriptor();
      final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
        @Override
        public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
          final Function0<IServiceResult> _function = new Function0<IServiceResult>() {
            @Override
            public IServiceResult apply() {
              try {
                return XtextServiceDispatcher.this.contentAssistService.createProposals(document, selection, (offset).intValue());
              } catch (Throwable _e) {
                throw Exceptions.sneakyThrow(_e);
              }
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
    final String resourceId = parameters.get("resource");
    IXtextWebDocument document = null;
    boolean _containsKey = parameters.containsKey("fullText");
    if (_containsKey) {
      String _get = parameters.get("fullText");
      XtextWebDocument _fullTextDocument = this.getFullTextDocument(_get, resourceId, sessionStore);
      document = _fullTextDocument;
    } else {
      if ((resourceId != null)) {
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
        IXtextWebDocument _resourceDocument = this.getResourceDocument(resourceId, sessionStore, _function);
        document = _resourceDocument;
      } else {
        throw new InvalidRequestException(InvalidRequestException.Type.INVALID_PARAMETERS, "At least one of the parameters \'resource\' and \'fullText\' must be specified.");
      }
    }
    String _get_1 = parameters.get("requiredStateId");
    return new XtextWebDocumentAccess(document, _get_1);
  }
  
  protected XtextWebDocument getFullTextDocument(final String fullText, final String resourceId, final ISessionStore sessionStore) {
    try {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
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
      final XtextWebDocument document = new XtextWebDocument(resource, resourceId);
      if ((resourceId != null)) {
        Pair<Class<XtextWebDocument>, String> _mappedTo = Pair.<Class<XtextWebDocument>, String>of(XtextWebDocument.class, resourceId);
        sessionStore.put(_mappedTo, document);
      }
      return document;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected IXtextWebDocument getResourceDocument(final String resourceId, final ISessionStore sessionStore, final Provider<XtextWebDocument> alternativeDocumentProvider) {
    Pair<Class<XtextWebDocument>, String> _mappedTo = Pair.<Class<XtextWebDocument>, String>of(XtextWebDocument.class, resourceId);
    final Function0<IXtextWebDocument> _function = new Function0<IXtextWebDocument>() {
      @Override
      public IXtextWebDocument apply() {
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
    return sessionStore.<IXtextWebDocument>get(_mappedTo, _function);
  }
  
  protected Integer getInt(final Map<String, String> parameters, final String key, final Optional<Integer> defaultValue) throws InvalidRequestException {
    final String stringValue = parameters.get(key);
    if ((stringValue == null)) {
      boolean _isPresent = defaultValue.isPresent();
      boolean _not = (!_isPresent);
      if (_not) {
        throw new InvalidRequestException(InvalidRequestException.Type.INVALID_PARAMETERS, (("The parameter \'" + key) + "\' must be specified."));
      }
      return defaultValue.get();
    }
    try {
      return Integer.valueOf(Integer.parseInt(stringValue));
    } catch (final Throwable _t) {
      if (_t instanceof NumberFormatException) {
        final NumberFormatException nfe = (NumberFormatException)_t;
        throw new InvalidRequestException(InvalidRequestException.Type.INVALID_PARAMETERS, (("The parameter \'" + key) + "\' must contain an integer value."));
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected Boolean getBoolean(final Map<String, String> parameters, final String key, final Optional<Boolean> defaultValue) throws InvalidRequestException {
    final String stringValue = parameters.get(key);
    if ((stringValue == null)) {
      boolean _isPresent = defaultValue.isPresent();
      boolean _not = (!_isPresent);
      if (_not) {
        throw new InvalidRequestException(InvalidRequestException.Type.INVALID_PARAMETERS, (("The parameter \'" + key) + "\' must be specified."));
      }
      return defaultValue.get();
    }
    String _lowerCase = stringValue.toLowerCase();
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_lowerCase, "true")) {
        _matched=true;
        return Boolean.valueOf(true);
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase, "false")) {
        _matched=true;
        return Boolean.valueOf(false);
      }
    }
    throw new InvalidRequestException(InvalidRequestException.Type.INVALID_PARAMETERS, (("The parameter \'" + key) + "\' must contain a Boolean value."));
  }
}
