/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.model;

import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.model.AbstractCachedService;
import org.eclipse.xtext.web.server.model.DocumentSynchronizer;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Container for an {@link XtextResource}.
 */
@Log
@FinalFieldsConstructor
@SuppressWarnings("all")
public class XtextWebDocument implements IXtextWebDocument {
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final String resourceId;
  
  @Accessors(AccessorType.PACKAGE_GETTER)
  private final DocumentSynchronizer synchronizer;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private XtextResource resource;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String text;
  
  @Accessors
  private boolean dirty;
  
  private final Map<Class<?>, IServiceResult> cachedServiceResults = CollectionLiterals.<Class<?>, IServiceResult>newHashMap();
  
  /**
   * Clear any cached result of {@link AbstractCachedService}. This method is called whenever the text
   * content of the resource is modified, but it may be necessary to clear the cached services in other
   * cases, too.
   */
  public void clearCachedServiceResults() {
    this.cachedServiceResults.clear();
  }
  
  public <T extends IServiceResult> T getCachedServiceResult(final AbstractCachedService<T> service, final CancelIndicator cancelIndicator, final boolean logCacheMiss) {
    T _elvis = null;
    Class<? extends AbstractCachedService> _class = service.getClass();
    IServiceResult _get = this.cachedServiceResults.get(_class);
    if (((T) _get) != null) {
      _elvis = ((T) _get);
    } else {
      T _xblockexpression = null;
      {
        if (logCacheMiss) {
          Class<? extends AbstractCachedService> _class_1 = service.getClass();
          String _simpleName = _class_1.getSimpleName();
          String _plus = ("Cache miss for " + _simpleName);
          XtextWebDocument.LOG.trace(_plus);
        }
        final T result = service.compute(this, cancelIndicator);
        Class<? extends AbstractCachedService> _class_2 = service.getClass();
        this.cachedServiceResults.put(_class_2, result);
        _xblockexpression = result;
      }
      _elvis = _xblockexpression;
    }
    return _elvis;
  }
  
  @Override
  public String toString() {
    String _xblockexpression = null;
    {
      if ((this.resourceId != null)) {
        Class<? extends XtextWebDocument> _class = this.getClass();
        String _simpleName = _class.getSimpleName();
        String _plus = (_simpleName + "(");
        String _plus_1 = (_plus + this.resourceId);
        return (_plus_1 + ")");
      }
      _xblockexpression = super.toString();
    }
    return _xblockexpression;
  }
  
  public String setInput(final XtextResource resource) {
    String _xblockexpression = null;
    {
      this.clearCachedServiceResults();
      this.resource = resource;
      _xblockexpression = this.refreshText();
    }
    return _xblockexpression;
  }
  
  protected String refreshText() {
    String _elvis = null;
    IParseResult _parseResult = this.resource.getParseResult();
    ICompositeNode _rootNode = null;
    if (_parseResult!=null) {
      _rootNode=_parseResult.getRootNode();
    }
    String _text = null;
    if (_rootNode!=null) {
      _text=_rootNode.getText();
    }
    if (_text != null) {
      _elvis = _text;
    } else {
      _elvis = "";
    }
    return this.text = _elvis;
  }
  
  @Override
  public String getStateId() {
    long _modificationStamp = this.resource.getModificationStamp();
    return Long.toString(_modificationStamp, 16);
  }
  
  /**
   * Replace the text contents of the contained resource with the given text.
   */
  @Override
  public void setText(final String text) {
    try {
      this.clearCachedServiceResults();
      this.resource.reparse(text);
      this.refreshText();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Update a part of the text.
   */
  @Override
  public void updateText(final String text, final int offset, final int replaceLength) {
    this.clearCachedServiceResults();
    this.resource.update(offset, replaceLength, text);
    this.refreshText();
  }
  
  /**
   * A new state id should be created whenever the text content is changed. The client must know
   * the correct state id in order to send proper requests. If a request with an outdated state id
   * is received by the server, the request is rejected.
   */
  @Override
  public void createNewStateId() {
    long _modificationStamp = this.resource.getModificationStamp();
    final long newStateId = (_modificationStamp + 1);
    this.resource.setModificationStamp(newStateId);
  }
  
  private final static Logger LOG = Logger.getLogger(XtextWebDocument.class);
  
  public XtextWebDocument(final String resourceId, final DocumentSynchronizer synchronizer) {
    super();
    this.resourceId = resourceId;
    this.synchronizer = synchronizer;
  }
  
  @Pure
  public String getResourceId() {
    return this.resourceId;
  }
  
  @Pure
  DocumentSynchronizer getSynchronizer() {
    return this.synchronizer;
  }
  
  @Pure
  public XtextResource getResource() {
    return this.resource;
  }
  
  @Pure
  public String getText() {
    return this.text;
  }
  
  @Pure
  public boolean isDirty() {
    return this.dirty;
  }
  
  public void setDirty(final boolean dirty) {
    this.dirty = dirty;
  }
}
