/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.resource;

import com.google.common.base.Objects;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VfsUtilCore;
import com.intellij.openapi.vfs.VirtualFile;
import java.net.URL;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * Utilities to bridge URIs and VirtualFiles
 */
@SuppressWarnings("all")
public class VirtualFileURIUtil {
  /**
   * @return an EMF URI for a virtual file
   */
  public static URI getURI(final VirtualFile file) {
    boolean _isDirectory = file.isDirectory();
    if (_isDirectory) {
      String _url = file.getUrl();
      String _plus = (_url + "/");
      return URI.createURI(_plus);
    }
    String _url_1 = file.getUrl();
    return URI.createURI(_url_1);
  }
  
  /**
   * Returns a VirtualFile for the given EMF URI, or <code>null</code> if no VirtualFile exists.
   * Note that a non-existing VirtualFile could be returned as well.
   * 
   * @return a VirtualFile for the given EMF URI, or <code>null</code> if no VirtualFile exists.
   */
  public static VirtualFile getVirtualFile(final URI uri) {
    final URL url = VirtualFileURIUtil.toURL(uri);
    boolean _equals = Objects.equal(url, null);
    if (_equals) {
      return null;
    }
    return VfsUtil.findFileByURL(url);
  }
  
  /**
   * Will return a VirtualFile and create one if it doesn't already exist.
   * This method will also create all parent folders when needed.
   */
  public static VirtualFile getOrCreateVirtualFile(final URI uri) {
    return VirtualFileURIUtil.getOrCreateFile(uri, false);
  }
  
  private static VirtualFile getOrCreateFile(final URI uri, final boolean isDirectory) {
    try {
      final VirtualFile file = VirtualFileURIUtil.getVirtualFile(uri);
      boolean _notEquals = (!Objects.equal(file, null));
      if (_notEquals) {
        return file;
      }
      URI _trimSegments = uri.trimSegments(1);
      final VirtualFile parent = VirtualFileURIUtil.getOrCreateFile(_trimSegments, true);
      String _lastSegment = uri.lastSegment();
      return parent.createChildData(null, _lastSegment);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static URL toURL(final URI uri) {
    boolean _equals = Objects.equal(uri, null);
    if (_equals) {
      return null;
    }
    String _string = uri.toString();
    return VfsUtilCore.convertToURL(_string);
  }
}
