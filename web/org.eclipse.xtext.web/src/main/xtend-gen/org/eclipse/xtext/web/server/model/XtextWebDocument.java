/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.model;

import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class XtextWebDocument implements IXtextWebDocument {
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final String resourceId;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final XtextResource resource;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private String text;
  
  @Accessors
  private boolean dirty;
  
  public XtextWebDocument(final XtextResource resource, final String resourceId) {
    this.resource = resource;
    this.resourceId = resourceId;
    this.refresh();
  }
  
  protected void refresh() {
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
    this.text = _elvis;
    final long stateId = this.computeStateId(this.text);
    this.resource.setModificationStamp(stateId);
  }
  
  @Override
  public String getStateId() {
    long _modificationStamp = this.resource.getModificationStamp();
    return Long.toString(_modificationStamp, 16);
  }
  
  protected long computeStateId(final String text) {
    long hash = 0l;
    for (int i = 0; (i < text.length()); i++) {
      char _charAt = text.charAt(i);
      long _plus = ((31 * hash) + _charAt);
      hash = _plus;
    }
    return hash;
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
}
