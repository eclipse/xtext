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
    VirtualFile file = VirtualFileURIUtil.getVirtualFile(uri);
    URI parent = uri;
    while ((Objects.equal(file, null) && (parent.segmentCount() > 0))) {
      {
        URI _trimSegments = parent.trimSegments(1);
        parent = _trimSegments;
        VirtualFile _virtualFile = VirtualFileURIUtil.getVirtualFile(parent);
        file = _virtualFile;
      }
    }
    String _elvis = null;
    Charset _charset = null;
    if (file!=null) {
      _charset=file.getCharset();
    }
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
}
