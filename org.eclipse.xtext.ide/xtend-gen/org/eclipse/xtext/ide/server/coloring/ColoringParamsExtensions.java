/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.coloring;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.lsp4j.ColoringInformation;
import org.eclipse.lsp4j.ColoringParams;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Extension for creating empty {@link ColoringParams coloring parameter}
 * instances or checking whether existing ones are
 * {@link ColoringParamsExtensions#isEmpty empty} or not.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class ColoringParamsExtensions {
  /**
   * Unique URI that is being used when creating an empty parameter instance for
   * an unknown resource.
   */
  private final static String UNKNOWN_URI = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("missing://");
      String _name = ColoringParamsExtensions.class.getName();
      _builder.append(_name, "");
      return _builder.toString();
    }
  }.apply();
  
  private final static ColoringParams EMPTY = ColoringParamsExtensions.emptyColoringParams(ColoringParamsExtensions.UNKNOWN_URI);
  
  /**
   * Returns with an empty coloring parameter instance.
   */
  public static ColoringParams emptyColoringParams() {
    return ColoringParamsExtensions.EMPTY;
  }
  
  /**
   * Creates a new, empty coloring parameter instance for the resource given with
   * the resource URI argument.
   */
  public static ColoringParams emptyColoringParams(final String resourceUri) {
    if ((resourceUri == null)) {
      return ColoringParamsExtensions.emptyColoringParams();
    }
    List<ColoringInformation> _emptyList = CollectionLiterals.<ColoringInformation>emptyList();
    return new ColoringParams(resourceUri, _emptyList);
  }
  
  /**
   * Creates a new, empty coloring parameter instance with the URI of the resource
   * argument. If either the resource or its URI is {@code null}, then the
   * {@link ColoringParamsExtensions#UNKNOWN_URI unknown URI} will be used as the
   * resource URI instead.
   */
  public static ColoringParams emptyColoringParams(final XtextResource resource) {
    URI _uRI = null;
    if (resource!=null) {
      _uRI=resource.getURI();
    }
    String _string = null;
    if (_uRI!=null) {
      _string=_uRI.toString();
    }
    return ColoringParamsExtensions.emptyColoringParams(_string);
  }
  
  /**
   * Returns with {@code true} if any of the followings are {@code true}:
   * <ul>
   * <li>The coloring parameter argument is {@code null} or</li>
   * <li>the URI of the argument equals with the
   * {@link ColoringParamsExtensions#UNKNOWN_URI unknown URI} or</li>
   * <li>the underlying {@link ColoringParams#getInfos() info} list is
   * {@code null} or empty.</li>
   * </ul>
   * Otherwise returns with {@code false}.
   */
  public static boolean isEmpty(final ColoringParams params) {
    return (((params == null) || Objects.equal(params.getUri(), ColoringParamsExtensions.UNKNOWN_URI)) || IterableExtensions.isNullOrEmpty(params.getInfos()));
  }
  
  private ColoringParamsExtensions() {
  }
}
