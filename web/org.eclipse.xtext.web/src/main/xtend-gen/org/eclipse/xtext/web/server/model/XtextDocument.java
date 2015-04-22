/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.model;

import com.google.common.base.Objects;
import com.google.inject.Singleton;
import java.util.concurrent.locks.ReentrantLock;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class XtextDocument {
  public static class ReadAccess {
    protected final XtextDocument document;
    
    private ReadAccess(final XtextDocument document) {
      this.document = document;
    }
    
    public XtextDocument getDocument() {
      return this.document;
    }
    
    public XtextResource getResource() {
      return this.document.resource;
    }
    
    public String getText() {
      return this.document.text;
    }
    
    public String getStateId() {
      return this.document.stateId;
    }
    
    public void checkStateId(final String requiredStateId) throws InvalidRequestException {
      boolean _and = false;
      if (!(requiredStateId != null)) {
        _and = false;
      } else {
        boolean _notEquals = (!Objects.equal(requiredStateId, this.document.stateId));
        _and = _notEquals;
      }
      if (_and) {
        throw new InvalidRequestException(409, "The given state id does not match the current state.");
      }
    }
    
    public boolean isDirty() {
      return this.document.dirty;
    }
  }
  
  public static class ModifyAccess extends XtextDocument.ReadAccess {
    private ModifyAccess(final XtextDocument document) {
      super(document);
    }
    
    public String setText(final String text) {
      try {
        String _xblockexpression = null;
        {
          this.document.resource.reparse(text);
          _xblockexpression = this.document.text = text;
        }
        return _xblockexpression;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
    
    public String setStateId(final String stateId) {
      return this.document.stateId = stateId;
    }
    
    public boolean setDirty(final boolean dirty) {
      return this.document.dirty = dirty;
    }
  }
  
  @Singleton
  public static class CreationLock {
  }
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final String resourceId;
  
  private final XtextResource resource;
  
  private String text;
  
  private String stateId;
  
  private boolean dirty;
  
  private final ReentrantLock lock = new ReentrantLock();
  
  private final XtextDocument.ReadAccess readOnlyAccess = new XtextDocument.ReadAccess(this);
  
  private final XtextDocument.ModifyAccess modifyAccess = new XtextDocument.ModifyAccess(this);
  
  public XtextDocument(final XtextResource resource, final String resourceId) {
    this.resource = resource;
    this.resourceId = resourceId;
    String _elvis = null;
    IParseResult _parseResult = resource.getParseResult();
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
  }
  
  public <T extends Object> T readOnly(final IUnitOfWork<T, XtextDocument.ReadAccess> work) {
    try {
      T _xblockexpression = null;
      {
        this.lock.lock();
        T _xtrycatchfinallyexpression = null;
        try {
          _xtrycatchfinallyexpression = work.exec(this.readOnlyAccess);
        } finally {
          this.lock.unlock();
        }
        _xblockexpression = _xtrycatchfinallyexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public <T extends Object> T modify(final IUnitOfWork<T, XtextDocument.ModifyAccess> work) {
    try {
      T _xblockexpression = null;
      {
        this.lock.lock();
        T _xtrycatchfinallyexpression = null;
        try {
          _xtrycatchfinallyexpression = work.exec(this.modifyAccess);
        } finally {
          this.lock.unlock();
        }
        _xblockexpression = _xtrycatchfinallyexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Pure
  public String getResourceId() {
    return this.resourceId;
  }
}
