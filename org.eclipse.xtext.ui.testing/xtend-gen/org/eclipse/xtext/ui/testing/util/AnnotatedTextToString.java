/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.testing.util;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import java.util.Collections;
import java.util.List;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ui.MarkerTypes;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("all")
public class AnnotatedTextToString {
  @FinalFieldsConstructor
  protected static class CommentedRegion {
    private final int start;
    
    private final int end;
    
    private final String text;
    
    public CommentedRegion(final int start, final int end, final String text) {
      super();
      this.start = start;
      this.end = end;
      this.text = text;
    }
  }
  
  @Accessors
  private String contents;
  
  @Accessors
  private IFile file;
  
  @Accessors
  private final List<AnnotatedTextToString.CommentedRegion> regions = CollectionLiterals.<AnnotatedTextToString.CommentedRegion>newArrayList();
  
  @Accessors
  private final List<String> emptyMessage = CollectionLiterals.<String>newArrayList();
  
  public String getContents() {
    try {
      if ((this.contents != null)) {
        return this.contents;
      }
      if ((this.file != null)) {
        return IResourcesSetupUtil.fileToString(this.file);
      }
      return null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public AnnotatedTextToString withFile(final IFile file) {
    this.file = file;
    return this;
  }
  
  public AnnotatedTextToString withMarkers(final IMarker[] markers) {
    return this.withMarkers(markers, IMarker.MESSAGE);
  }
  
  public AnnotatedTextToString withMarkers(final IMarker[] markers, final String... attributes) {
    try {
      for (final IMarker marker : markers) {
        {
          final Function1<String, String> _function = (String it) -> {
            try {
              Object _attribute = marker.getAttribute(it);
              return ((it + "=") + _attribute);
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          };
          final String comment = IterableExtensions.join(ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(attributes)), _function), ", ");
          Object _attribute = marker.getAttribute(IMarker.CHAR_START);
          final Integer offset = ((Integer) _attribute);
          Object _attribute_1 = marker.getAttribute(IMarker.CHAR_END);
          final Integer length = ((Integer) _attribute_1);
          AnnotatedTextToString.CommentedRegion _commentedRegion = new AnnotatedTextToString.CommentedRegion((offset).intValue(), (length).intValue(), comment);
          this.regions.add(_commentedRegion);
        }
      }
      this.emptyMessage.add("(no markers found)");
      return this;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public AnnotatedTextToString withMarkersFromFile(final String type, final String... attributes) {
    try {
      return this.withMarkers(this.file.findMarkers(type, true, IResource.DEPTH_INFINITE), attributes);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public AnnotatedTextToString withMarkersFromFile() {
    return this.withMarkersFromFile(MarkerTypes.FAST_VALIDATION, IMarker.MESSAGE);
  }
  
  @Override
  public String toString() {
    final String cnt = this.getContents();
    final Function1<AnnotatedTextToString.CommentedRegion, Integer> _function = (AnnotatedTextToString.CommentedRegion it) -> {
      return Integer.valueOf(it.start);
    };
    final Iterable<Pair<Integer, AnnotatedTextToString.CommentedRegion>> sorted = IterableExtensions.<AnnotatedTextToString.CommentedRegion>indexed(IterableExtensions.<AnnotatedTextToString.CommentedRegion, Integer>sortBy(this.regions, _function));
    final Function1<Pair<Integer, AnnotatedTextToString.CommentedRegion>, List<Pair<Integer, String>>> _function_1 = (Pair<Integer, AnnotatedTextToString.CommentedRegion> it) -> {
      Integer _key = it.getKey();
      String _plus = ("<" + _key);
      String _plus_1 = (_plus + "<");
      Pair<Integer, String> _mappedTo = Pair.<Integer, String>of(Integer.valueOf(it.getValue().start), _plus_1);
      Integer _key_1 = it.getKey();
      String _plus_2 = (">" + _key_1);
      String _plus_3 = (_plus_2 + ">");
      Pair<Integer, String> _mappedTo_1 = Pair.<Integer, String>of(Integer.valueOf(it.getValue().end), _plus_3);
      return Collections.<Pair<Integer, String>>unmodifiableList(CollectionLiterals.<Pair<Integer, String>>newArrayList(_mappedTo, _mappedTo_1));
    };
    final Function1<Pair<Integer, String>, Integer> _function_2 = (Pair<Integer, String> it) -> {
      return it.getKey();
    };
    final List<Pair<Integer, String>> locations = IterableExtensions.<Pair<Integer, String>, Integer>sortBy(Iterables.<Pair<Integer, String>>concat(IterableExtensions.<Pair<Integer, AnnotatedTextToString.CommentedRegion>, List<Pair<Integer, String>>>map(sorted, _function_1)), _function_2);
    final StringBuilder result = new StringBuilder();
    int lastOffset = 0;
    for (int i = 0; (i < ((Object[])Conversions.unwrapArray(locations, Object.class)).length); i++) {
      {
        final Pair<Integer, String> l = locations.get(i);
        final Integer offset = l.getKey();
        final String comment = l.getValue();
        result.append(cnt.substring(lastOffset, (offset).intValue()));
        result.append(comment);
        lastOffset = (offset).intValue();
      }
    }
    result.append(cnt.substring(lastOffset, cnt.length()));
    final Function1<String, Integer> _function_3 = (String it) -> {
      return Integer.valueOf(it.length());
    };
    final Integer maxLineLenght = IterableExtensions.<Integer>max(ListExtensions.<String, Integer>map(((List<String>)Conversions.doWrapArray(result.toString().replace("\t", "    ").split("\n"))), _function_3));
    int _length = result.length();
    int _minus = (_length - 1);
    String _substring = result.substring(_minus, result.length());
    boolean _notEquals = (!Objects.equal(_substring, "\n"));
    if (_notEquals) {
      result.append("\n");
    }
    result.append(Strings.repeat("-", (maxLineLenght).intValue()));
    boolean _isEmpty = IterableExtensions.isEmpty(sorted);
    if (_isEmpty) {
      for (final String c : this.emptyMessage) {
        {
          result.append("\n");
          result.append(c);
        }
      }
    } else {
      for (final Pair<Integer, AnnotatedTextToString.CommentedRegion> c_1 : sorted) {
        {
          result.append("\n");
          result.append(c_1.getKey());
          result.append(": ");
          result.append(c_1.getValue().text);
        }
      }
    }
    return result.toString();
  }
  
  public void setContents(final String contents) {
    this.contents = contents;
  }
  
  @Pure
  public IFile getFile() {
    return this.file;
  }
  
  public void setFile(final IFile file) {
    this.file = file;
  }
  
  @Pure
  public List<AnnotatedTextToString.CommentedRegion> getRegions() {
    return this.regions;
  }
  
  @Pure
  public List<String> getEmptyMessage() {
    return this.emptyMessage;
  }
}
