/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.model;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.web.server.model.DocumentSynchronizer;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class XtextWebDocument implements IXtextWebDocument {
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final List<Issue> issues = CollectionLiterals.<Issue>newArrayList();
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String resourceId;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private XtextResource resource;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String text;
  
  @Accessors
  private boolean dirty;
  
  @Accessors
  private boolean processingCompleted;
  
  @Accessors(AccessorType.PACKAGE_GETTER)
  @Inject
  private DocumentSynchronizer synchronizer;
  
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
  
  public String setInput(final XtextResource resource, final String resourceId) {
    String _xblockexpression = null;
    {
      this.resource = resource;
      this.resourceId = resourceId;
      _xblockexpression = this.refresh();
    }
    return _xblockexpression;
  }
  
  protected String refresh() {
    String _xblockexpression = null;
    {
      this.issues.clear();
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
      _xblockexpression = this.text = _elvis;
    }
    return _xblockexpression;
  }
  
  @Override
  public String getStateId() {
    long _modificationStamp = this.resource.getModificationStamp();
    return Long.toString(_modificationStamp, 16);
  }
  
  @Override
  public void setText(final String text) {
    try {
      this.resource.reparse(text);
      this.refresh();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void updateText(final String text, final int offset, final int replaceLength) {
    this.resource.update(offset, replaceLength, text);
    this.refresh();
  }
  
  @Override
  public void createNewStateId() {
    long _modificationStamp = this.resource.getModificationStamp();
    final long newStateId = (_modificationStamp + 1);
    this.resource.setModificationStamp(newStateId);
  }
  
  @Pure
  public List<Issue> getIssues() {
    return this.issues;
  }
  
  @Pure
  public String getResourceId() {
    return this.resourceId;
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
  
  @Pure
  public boolean isProcessingCompleted() {
    return this.processingCompleted;
  }
  
  public void setProcessingCompleted(final boolean processingCompleted) {
    this.processingCompleted = processingCompleted;
  }
  
  @Pure
  DocumentSynchronizer getSynchronizer() {
    return this.synchronizer;
  }
}
