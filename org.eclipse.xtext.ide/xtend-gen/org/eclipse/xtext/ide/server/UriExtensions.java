/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.inject.Singleton;
import java.io.FileNotFoundException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
@SuppressWarnings("all")
public class UriExtensions {
  private final static String ESCAPED_FILE_SCHEME = new Function0<String>() {
    public String apply() {
      try {
        String _encode = URLEncoder.encode("file:", StandardCharsets.UTF_8.name());
        return _encode;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
  }.apply();
  
  /**
   * Converts any non-{@code null} arguments, representing a URI as a string, into a EMF based URI where the following
   * rules apply:
   * <p>
   * <ul>
   * <li>If the argument has a {@code file} scheme:
   * <ul>
   * <li>and the {@code host} is not set (e.g.: {@code localhost} can be omitted) then it returns with a EMF URI with the
   * following form: {@code file:///path/to/resource}.</li>
   * <li>and the {@code host} is set (e.g.: {@code localhost} can be omitted) then drops the URI host and returns with a
   * EMF URI with the following form: {@code file:///path/to/resource}.</li>
   * <li>if the URI starts with two forward-slashes ({@code file://path/to/resource}), the method will treat it with a URI
   * with {@code localhost} scheme and will omit it, producing the {@code file:///path/to/resource} result.</li>
   * </ul>
   * <li>If the has any other scheme then it will return with EMF URI {@link URI#createURI(String) created} from the
   * argument.</li>
   * <li>This method takes care of the encoding and the URI path escaping.</li>
   * </ul>
   * </p>
   */
  public URI toUri(final String pathWithScheme) {
    final URI uri = URI.createURI(Preconditions.<String>checkNotNull(pathWithScheme, "pathWithScheme"));
    boolean _isFile = uri.isFile();
    if (_isFile) {
      final ImmutableList<String> segments = this.toSegments(uri);
      boolean _xtrycatchfinallyexpression = false;
      try {
        _xtrycatchfinallyexpression = Files.isDirectory(Paths.get(uri.toFileString()), LinkOption.NOFOLLOW_LINKS);
      } catch (final Throwable _t) {
        if (_t instanceof FileNotFoundException) {
          final FileNotFoundException e = (FileNotFoundException)_t;
          _xtrycatchfinallyexpression = false;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      final boolean prefix = _xtrycatchfinallyexpression;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("file:///");
      String _join = IterableExtensions.join(segments, "/");
      _builder.append(_join);
      {
        if (prefix) {
          _builder.append("/");
        }
      }
      return URI.createURI(_builder.toString());
    }
    return uri;
  }
  
  /**
   * Converts the EMF URI argument into a string path.
   * <p>
   * If the argument is a URI with {@link URI#isFile() file} scheme, then the produced result value will always have this
   * form {@code file:///path/to/resource, otherwise it returns with the string representation
   * of the argument.
   */
  public String toPath(final URI uri) {
    boolean _isFile = uri.isFile();
    if (_isFile) {
      final ImmutableList<String> segments = this.toSegments(uri);
      final String path = IterableExtensions.join(segments, "/");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("file:///");
      _builder.append(path);
      return _builder.toString();
    }
    return uri.toString();
  }
  
  /**
   * Converts the {@code java.net} URI argument into a string path.
   */
  public String toPath(final java.net.URI uri) {
    return this.toPath(URI.createURI(uri.toString()));
  }
  
  private ImmutableList<String> toSegments(final URI it) {
    final ImmutableList.Builder<String> builder = ImmutableList.<String>builder();
    if (((!StringExtensions.isNullOrEmpty(it.host())) && (!Objects.equal(it.host(), "localhost")))) {
      builder.add(it.host());
    }
    builder.addAll(IterableExtensions.<String>drop(((Iterable<String>)Conversions.doWrapArray(it.segments())), this.getSegmentsToDrop(it)));
    return builder.build();
  }
  
  /**
   * Calculates how many segments should be dropped.
   * 
   * <p>
   * EMF file URI cannot interpret {@code file:///} scheme and will be parsed differently.
   * 
   * <p>
   * Handles different file URI cases, such as:
   * <ul>
   * <li>URI is created as URI#createURI('file://foo'),</li>
   * <li>URI is created as URI#createURI('file:///foo'),</li>
   * <li>URI is created as URI#createFileURI('file://foo') and</li>
   * <li>URI is created as URI#createFileURI('file://foo').</li>
   * </ul>
   * Does nothing and returns with 0, when the URI is not a file URI.
   */
  private int getSegmentsToDrop(final URI it) {
    if ((((it.scheme() == null) && it.isFile()) && Objects.equal(IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(it.segments()))), UriExtensions.ESCAPED_FILE_SCHEME))) {
      int toDrop = 1;
      while (StringExtensions.isNullOrEmpty(it.segment(toDrop))) {
        toDrop++;
      }
      return toDrop;
    }
    return 0;
  }
}
