/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.resource;

import com.google.common.base.Objects;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.openapi.vfs.encoding.EncodingRegistry;
import java.nio.charset.Charset;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.idea.resource.VirtualFileURIUtil;
import org.eclipse.xtext.parser.IEncodingProvider;

@SuppressWarnings("all")
public class IdeaEncodingProvider implements IEncodingProvider {
  @Override
  public String getEncoding(final URI uri) {
    Application _application = ApplicationManager.getApplication();
    final VirtualFileManager fileManager = _application.<VirtualFileManager>getComponent(VirtualFileManager.class);
    boolean _equals = Objects.equal(fileManager, null);
    if (_equals) {
      IEncodingProvider.Runtime _runtime = new IEncodingProvider.Runtime();
      return _runtime.getEncoding(uri);
    }
    String _elvis = null;
    Charset _charset = this.getCharset(uri);
    String _name = null;
    if (_charset!=null) {
      _name=_charset.name();
    }
    if (_name != null) {
      _elvis = _name;
    } else {
      _elvis = "UTF-8";
    }
    return _elvis;
  }
  
  protected Charset getCharset(final URI uri) {
    Charset _elvis = null;
    VirtualFile _findVirtualFile = this.findVirtualFile(uri);
    Charset _charset = null;
    if (_findVirtualFile!=null) {
      _charset=_findVirtualFile.getCharset();
    }
    if (_charset != null) {
      _elvis = _charset;
    } else {
      EncodingRegistry _instance = EncodingRegistry.getInstance();
      Charset _defaultCharset = _instance.getDefaultCharset();
      _elvis = _defaultCharset;
    }
    return _elvis;
  }
  
  protected VirtualFile findVirtualFile(final URI uri) {
    VirtualFile _xblockexpression = null;
    {
      if ((uri == null)) {
        return null;
      }
      final VirtualFile file = VirtualFileURIUtil.getVirtualFile(uri);
      if ((file != null)) {
        return file;
      }
      int _segmentCount = uri.segmentCount();
      boolean _equals = (_segmentCount == 0);
      if (_equals) {
        return null;
      }
      URI _trimSegments = uri.trimSegments(1);
      _xblockexpression = this.findVirtualFile(_trimSegments);
    }
    return _xblockexpression;
  }
}
