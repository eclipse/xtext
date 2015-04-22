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
import com.google.inject.Injector;
import com.google.inject.Provider;
import java.io.IOException;
import java.util.Map;
import java.util.StringTokenizer;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.web.server.ISessionStore;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.contentassist.ContentAssistService;
import org.eclipse.xtext.web.server.data.ContentAssistResult;
import org.eclipse.xtext.web.server.data.JsonObject;
import org.eclipse.xtext.web.server.data.ResourceContent;
import org.eclipse.xtext.web.server.data.UpdateDocumentResult;
import org.eclipse.xtext.web.server.data.ValidationResult;
import org.eclipse.xtext.web.server.model.UpdateDocumentService;
import org.eclipse.xtext.web.server.model.XtextDocument;
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler;
import org.eclipse.xtext.web.server.persistence.ResourcePersistenceService;
import org.eclipse.xtext.web.server.validation.ValidationService;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class XtextServiceDispatcher {
  @Accessors
  public static class ServiceDescriptor {
    private String type;
    
    private Function0<? extends JsonObject> service;
    
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
    public Function0<? extends JsonObject> getService() {
      return this.service;
    }
    
    public void setService(final Function0<? extends JsonObject> service) {
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
  
  private final IResourceServiceProvider.Registry serviceProviderRegistry = IResourceServiceProvider.Registry.INSTANCE;
  
  @Inject
  private IServerResourceHandler resourceHandler;
  
  public XtextServiceDispatcher.ServiceDescriptor getService(final String path, final Map<String, String> parameters, final ISessionStore sessionStore) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final String requestType = this.getRequestType(path, parameters);
      final Injector injector = this.getInjector(parameters);
      XtextServiceDispatcher.ServiceDescriptor _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(requestType, "load")) {
          _matched=true;
          _switchResult = this.getLoadResourceService(false, parameters, injector, sessionStore);
        }
      }
      if (!_matched) {
        if (Objects.equal(requestType, "revert")) {
          _matched=true;
          _switchResult = this.getLoadResourceService(true, parameters, injector, sessionStore);
        }
      }
      if (!_matched) {
        if (Objects.equal(requestType, "save")) {
          _matched=true;
          _switchResult = this.getSaveResourceService(parameters, injector, sessionStore);
        }
      }
      if (!_matched) {
        if (Objects.equal(requestType, "update")) {
          _matched=true;
          _switchResult = this.getUpdateDocumentService(parameters, injector, sessionStore);
        }
      }
      if (!_matched) {
        if (Objects.equal(requestType, "validation")) {
          _matched=true;
          _switchResult = this.getValidationService(parameters, injector, sessionStore);
        }
      }
      if (!_matched) {
        if (Objects.equal(requestType, "content-assist")) {
          _matched=true;
          _switchResult = this.getContentAssistService(parameters, injector, sessionStore);
        }
      }
      if (!_matched) {
        throw new InvalidRequestException(400, (("The request type \'" + requestType) + "\' is not supported."));
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
  
  protected Injector getInjector(final Map<String, String> parameters) throws InvalidRequestException {
    IResourceServiceProvider resourceServiceProvider = null;
    String _elvis = null;
    String _get = parameters.get("resource");
    if (_get != null) {
      _elvis = _get;
    } else {
      _elvis = "";
    }
    final URI emfURI = URI.createURI(_elvis);
    final String contentType = parameters.get("contentType");
    if ((contentType == null)) {
      IResourceServiceProvider _resourceServiceProvider = this.serviceProviderRegistry.getResourceServiceProvider(emfURI);
      resourceServiceProvider = _resourceServiceProvider;
    } else {
      IResourceServiceProvider _resourceServiceProvider_1 = this.serviceProviderRegistry.getResourceServiceProvider(emfURI, contentType);
      resourceServiceProvider = _resourceServiceProvider_1;
    }
    boolean _equals = Objects.equal(resourceServiceProvider, null);
    if (_equals) {
      throw new InvalidRequestException(400, "Unable to identify the resource type.");
    }
    return resourceServiceProvider.<Injector>get(Injector.class);
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
  
  protected XtextServiceDispatcher.ServiceDescriptor getLoadResourceService(final boolean revert, final Map<String, String> parameters, final Injector injector, final ISessionStore sessionStore) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final ResourcePersistenceService service = injector.<ResourcePersistenceService>getInstance(ResourcePersistenceService.class);
      final String resourceId = parameters.get("resource");
      if ((resourceId == null)) {
        throw new InvalidRequestException(400, "The parameter \'resource\' is required.");
      }
      XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor = new XtextServiceDispatcher.ServiceDescriptor();
      final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
        @Override
        public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
          final Function0<JsonObject> _function = new Function0<JsonObject>() {
            @Override
            public JsonObject apply() {
              try {
                JsonObject _xifexpression = null;
                if (revert) {
                  String _get = parameters.get("newState");
                  ResourceContent _revert = service.revert(resourceId, _get, XtextServiceDispatcher.this.resourceHandler, sessionStore);
                  _xifexpression = XtextServiceDispatcher.this.forRequestId(_revert, parameters);
                } else {
                  ResourceContent _load = service.load(resourceId, XtextServiceDispatcher.this.resourceHandler, sessionStore);
                  _xifexpression = XtextServiceDispatcher.this.forRequestId(_load, parameters);
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
  
  protected XtextServiceDispatcher.ServiceDescriptor getSaveResourceService(final Map<String, String> parameters, final Injector injector, final ISessionStore sessionStore) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final ResourcePersistenceService service = injector.<ResourcePersistenceService>getInstance(ResourcePersistenceService.class);
      final XtextDocument document = this.getDocument(parameters, injector, sessionStore);
      final String requiredStateId = parameters.get("requiredState");
      XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor = new XtextServiceDispatcher.ServiceDescriptor();
      final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
        @Override
        public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
          final Function0<JsonObject> _function = new Function0<JsonObject>() {
            @Override
            public JsonObject apply() {
              try {
                JsonObject _save = service.save(document, XtextServiceDispatcher.this.resourceHandler, requiredStateId);
                return XtextServiceDispatcher.this.forRequestId(_save, parameters);
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
  
  protected XtextServiceDispatcher.ServiceDescriptor getUpdateDocumentService(final Map<String, String> parameters, final Injector injector, final ISessionStore sessionStore) throws InvalidRequestException {
    final UpdateDocumentService service = injector.<UpdateDocumentService>getInstance(UpdateDocumentService.class);
    final String resourceId = parameters.get("resource");
    if ((resourceId == null)) {
      throw new InvalidRequestException(400, "The parameter \'resource\' is required.");
    }
    final String fullText = parameters.get("fullText");
    final Provider<XtextDocument> _function = new Provider<XtextDocument>() {
      @Override
      public XtextDocument get() {
        try {
          XtextDocument _xifexpression = null;
          if ((fullText != null)) {
            _xifexpression = XtextServiceDispatcher.this.getFullTextDocument(fullText, resourceId, injector, sessionStore);
          } else {
            throw new InvalidRequestException(404, "The requested resource was not found.");
          }
          return _xifexpression;
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    final XtextDocument document = this.getResourceDocument(resourceId, injector, sessionStore, _function);
    final String requiredStateId = parameters.get("requiredState");
    final String newStateId = parameters.get("newState");
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
        throw new InvalidRequestException(400, "At least one of the parameters \'deltaText\' and \'fullText\' must be specified.");
      }
      Optional<Integer> _absent = Optional.<Integer>absent();
      final Integer deltaOffset = this.getInt(parameters, "deltaOffset", _absent);
      if (((deltaOffset).intValue() < 0)) {
        throw new InvalidRequestException(400, "The parameter \'deltaOffset\' must not be negative.");
      }
      Optional<Integer> _absent_1 = Optional.<Integer>absent();
      final Integer deltaReplaceLength = this.getInt(parameters, "deltaReplaceLength", _absent_1);
      if (((deltaReplaceLength).intValue() < 0)) {
        throw new InvalidRequestException(400, "The parameter \'deltaReplaceLength\' must not be negative.");
      }
      final Function0<JsonObject> _function_2 = new Function0<JsonObject>() {
        @Override
        public JsonObject apply() {
          try {
            UpdateDocumentResult _updateDeltaText = service.updateDeltaText(document, deltaText, (deltaOffset).intValue(), (deltaReplaceLength).intValue(), requiredStateId, newStateId);
            return XtextServiceDispatcher.this.forRequestId(_updateDeltaText, parameters);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      result.service = _function_2;
    } else {
      final Function0<JsonObject> _function_3 = new Function0<JsonObject>() {
        @Override
        public JsonObject apply() {
          try {
            return service.updateFullText(document, fullText, requiredStateId, newStateId);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      result.service = _function_3;
    }
    return result;
  }
  
  protected XtextServiceDispatcher.ServiceDescriptor getValidationService(final Map<String, String> parameters, final Injector injector, final ISessionStore sessionStore) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final ValidationService service = injector.<ValidationService>getInstance(ValidationService.class);
      final XtextDocument document = this.getDocument(parameters, injector, sessionStore);
      final String requiredStateId = parameters.get("requiredState");
      XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor = new XtextServiceDispatcher.ServiceDescriptor();
      final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
        @Override
        public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
          final Function0<JsonObject> _function = new Function0<JsonObject>() {
            @Override
            public JsonObject apply() {
              try {
                ValidationResult _validate = service.validate(document, requiredStateId);
                return XtextServiceDispatcher.this.forRequestId(_validate, parameters);
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
  
  protected XtextServiceDispatcher.ServiceDescriptor getContentAssistService(final Map<String, String> parameters, final Injector injector, final ISessionStore sessionStore) throws InvalidRequestException {
    XtextServiceDispatcher.ServiceDescriptor _xblockexpression = null;
    {
      final ContentAssistService service = injector.<ContentAssistService>getInstance(ContentAssistService.class);
      Optional<Integer> _of = Optional.<Integer>of(Integer.valueOf(0));
      final Integer offset = this.getInt(parameters, "caretOffset", _of);
      final XtextDocument document = this.getDocument(parameters, injector, sessionStore);
      Optional<Integer> _of_1 = Optional.<Integer>of(Integer.valueOf(0));
      final Integer selectionStart = this.getInt(parameters, "selectionStart", _of_1);
      Optional<Integer> _of_2 = Optional.<Integer>of(Integer.valueOf(0));
      final Integer selectionEnd = this.getInt(parameters, "selectionEnd", _of_2);
      int _max = Math.max(((selectionEnd).intValue() - (selectionStart).intValue()), 0);
      final TextRegion selection = new TextRegion((selectionStart).intValue(), _max);
      final String requiredStateId = parameters.get("requiredState");
      XtextServiceDispatcher.ServiceDescriptor _serviceDescriptor = new XtextServiceDispatcher.ServiceDescriptor();
      final Procedure1<XtextServiceDispatcher.ServiceDescriptor> _function = new Procedure1<XtextServiceDispatcher.ServiceDescriptor>() {
        @Override
        public void apply(final XtextServiceDispatcher.ServiceDescriptor it) {
          final Function0<JsonObject> _function = new Function0<JsonObject>() {
            @Override
            public JsonObject apply() {
              try {
                ContentAssistResult _createProposals = service.createProposals(document, selection, (offset).intValue(), requiredStateId);
                return XtextServiceDispatcher.this.forRequestId(_createProposals, parameters);
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
  
  protected XtextDocument getDocument(final Map<String, String> parameters, final Injector injector, final ISessionStore sessionStore) throws InvalidRequestException {
    boolean _containsKey = parameters.containsKey("fullText");
    if (_containsKey) {
      String _get = parameters.get("fullText");
      String _get_1 = parameters.get("resource");
      return this.getFullTextDocument(_get, _get_1, injector, sessionStore);
    } else {
      boolean _containsKey_1 = parameters.containsKey("resource");
      if (_containsKey_1) {
        String _get_2 = parameters.get("resource");
        final Provider<XtextDocument> _function = new Provider<XtextDocument>() {
          @Override
          public XtextDocument get() {
            try {
              throw new InvalidRequestException(404, "The requested resource was not found.");
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          }
        };
        return this.getResourceDocument(_get_2, injector, sessionStore, _function);
      } else {
        throw new InvalidRequestException(400, "At least one of the parameters \'resource\' and \'fullText\' must be specified.");
      }
    }
  }
  
  protected XtextDocument getFullTextDocument(final String fullText, final String resourceId, final Injector injector, final ISessionStore sessionStore) {
    try {
      final XtextResourceSet resourceSet = injector.<XtextResourceSet>getInstance(XtextResourceSet.class);
      String _elvis = null;
      if (resourceId != null) {
        _elvis = resourceId;
      } else {
        FileExtensionProvider _instance = injector.<FileExtensionProvider>getInstance(FileExtensionProvider.class);
        String _primaryFileExtension = _instance.getPrimaryFileExtension();
        String _plus = ("fullText." + _primaryFileExtension);
        _elvis = _plus;
      }
      final URI uri = URI.createURI(_elvis);
      IResourceFactory _instance_1 = injector.<IResourceFactory>getInstance(IResourceFactory.class);
      Resource _createResource = _instance_1.createResource(uri);
      final XtextResource resource = ((XtextResource) _createResource);
      EList<Resource> _resources = resourceSet.getResources();
      _resources.add(resource);
      StringInputStream _stringInputStream = new StringInputStream(fullText);
      resource.load(_stringInputStream, null);
      final XtextDocument document = new XtextDocument(resource, resourceId);
      if ((resourceId != null)) {
        Pair<Class<XtextDocument>, String> _mappedTo = Pair.<Class<XtextDocument>, String>of(XtextDocument.class, resourceId);
        sessionStore.put(_mappedTo, document);
      }
      return document;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected XtextDocument getResourceDocument(final String resourceId, final Injector injector, final ISessionStore sessionStore, final Provider<XtextDocument> alternativeDocumentProvider) {
    injector.<XtextDocument.CreationLock>getInstance(XtextDocument.CreationLock.class);
    synchronized (injector.<XtextDocument.CreationLock>getInstance(XtextDocument.CreationLock.class)) {
      Pair<Class<XtextDocument>, String> _mappedTo = Pair.<Class<XtextDocument>, String>of(XtextDocument.class, resourceId);
      final Function0<XtextDocument> _function = new Function0<XtextDocument>() {
        @Override
        public XtextDocument apply() {
          try {
            final XtextResourceSet resourceSet = injector.<XtextResourceSet>getInstance(XtextResourceSet.class);
            return XtextServiceDispatcher.this.resourceHandler.get(resourceId, resourceSet);
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
      return ISessionStore.Extensions.<XtextDocument>get(sessionStore, _mappedTo, _function);
    }
  }
  
  protected Integer getInt(final Map<String, String> parameters, final String key, final Optional<Integer> defaultValue) throws InvalidRequestException {
    final String stringValue = parameters.get(key);
    if ((stringValue == null)) {
      boolean _isPresent = defaultValue.isPresent();
      boolean _not = (!_isPresent);
      if (_not) {
        throw new InvalidRequestException(400, (("The parameter \'" + key) + "\' must be specified."));
      }
      return defaultValue.get();
    }
    try {
      return Integer.valueOf(Integer.parseInt(stringValue));
    } catch (final Throwable _t) {
      if (_t instanceof NumberFormatException) {
        final NumberFormatException nfe = (NumberFormatException)_t;
        throw new InvalidRequestException(400, (("The parameter \'" + key) + "\' must contain an integer value."));
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
        throw new InvalidRequestException(400, (("The parameter \'" + key) + "\' must be specified."));
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
    throw new InvalidRequestException(400, (("The parameter \'" + key) + "\' must contain a Boolean value."));
  }
  
  protected JsonObject forRequestId(final JsonObject jsonObject, final Map<String, String> parameters) {
    final String requestId = parameters.get("requestId");
    if ((requestId != null)) {
      jsonObject.setRequestId(requestId);
    }
    return jsonObject;
  }
}
