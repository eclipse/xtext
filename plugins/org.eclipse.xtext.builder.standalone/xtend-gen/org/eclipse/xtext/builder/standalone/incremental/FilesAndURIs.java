/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import com.google.common.base.Objects;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Comparator;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class FilesAndURIs {
  /**
   * Unfortunately, {@link File#toURI} does not append '/' to directories, making it useless for the {@link URLClassLoader}.
   */
  public static URI asURI(final File file) {
    try {
      URI _xblockexpression = null;
      {
        File _canonicalFile = file.getCanonicalFile();
        String _absolutePath = _canonicalFile.getAbsolutePath();
        final URI uri = URI.createFileURI(_absolutePath);
        URI _xifexpression = null;
        boolean _isDirectory = file.isDirectory();
        if (_isDirectory) {
          _xifexpression = uri.appendSegment("");
        } else {
          _xifexpression = uri;
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static File asFile(final URI uri) {
    try {
      File _xifexpression = null;
      boolean _isFile = uri.isFile();
      if (_isFile) {
        String _fileString = uri.toFileString();
        File _file = new File(_fileString);
        _xifexpression = _file.getCanonicalFile();
      } else {
        throw new IllegalArgumentException((("Cannot convert non-file URI " + uri) + " to file"));
      }
      return _xifexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static String asPath(final URI uri) {
    File _asFile = FilesAndURIs.asFile(uri);
    return _asFile.getPath();
  }
  
  public static URI asURI(final String uri) {
    return URI.createURI(uri);
  }
  
  public static URI asFileURI(final String path) {
    try {
      File _file = new File(path);
      String _canonicalPath = _file.getCanonicalPath();
      return URI.createFileURI(_canonicalPath);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static String asPath(final URL url) {
    String _string = url.toString();
    URI _asURI = FilesAndURIs.asURI(_string);
    return FilesAndURIs.asPath(_asURI);
  }
  
  public static URI findRelativeURI(final URI uri, final Iterable<URI> baseURIs) {
    final Function1<URI, URI> _function = new Function1<URI, URI>() {
      @Override
      public URI apply(final URI it) {
        return FilesAndURIs.getRelativeURI(it, uri);
      }
    };
    Iterable<URI> _map = IterableExtensions.<URI, URI>map(baseURIs, _function);
    final Iterable<URI> relativeURIs = IterableExtensions.<URI>filterNull(_map);
    boolean _isEmpty = IterableExtensions.isEmpty(relativeURIs);
    if (_isEmpty) {
      return null;
    } else {
      final Comparator<URI> _function_1 = new Comparator<URI>() {
        @Override
        public int compare(final URI $0, final URI $1) {
          int _segmentCount = $0.segmentCount();
          int _segmentCount_1 = $1.segmentCount();
          return (_segmentCount - _segmentCount_1);
        }
      };
      return IterableExtensions.<URI>min(relativeURIs, _function_1);
    }
  }
  
  private static URI getRelativeURI(final URI prefix, final URI uri) {
    URI _xblockexpression = null;
    {
      boolean _or = false;
      boolean _or_1 = false;
      String _scheme = uri.scheme();
      String _scheme_1 = prefix.scheme();
      boolean _notEquals = (!Objects.equal(_scheme, _scheme_1));
      if (_notEquals) {
        _or_1 = true;
      } else {
        int _segmentCount = uri.segmentCount();
        int _segmentCount_1 = prefix.segmentCount();
        boolean _lessThan = (_segmentCount < _segmentCount_1);
        _or_1 = _lessThan;
      }
      if (_or_1) {
        _or = true;
      } else {
        String _lastSegment = prefix.lastSegment();
        boolean _notEquals_1 = (!Objects.equal(_lastSegment, ""));
        _or = _notEquals_1;
      }
      if (_or) {
        return null;
      }
      int _segmentCount_2 = prefix.segmentCount();
      int _minus = (_segmentCount_2 - 1);
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _minus, true);
      for (final Integer i : _doubleDotLessThan) {
        String _segment = prefix.segment((i).intValue());
        String _segment_1 = uri.segment((i).intValue());
        boolean _notEquals_2 = (!Objects.equal(_segment, _segment_1));
        if (_notEquals_2) {
          return null;
        }
      }
      String[] _segments = uri.segments();
      int _segmentCount_3 = prefix.segmentCount();
      int _minus_1 = (_segmentCount_3 - 1);
      int _segmentCount_4 = uri.segmentCount();
      List<String> _subList = ((List<String>)Conversions.doWrapArray(_segments)).subList(_minus_1, _segmentCount_4);
      String _join = IterableExtensions.join(_subList, "/");
      _xblockexpression = URI.createURI(_join);
    }
    return _xblockexpression;
  }
}
