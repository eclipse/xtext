/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.trace;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.base.Throwables;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimaps;
import com.google.common.io.CharStreams;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Accessors
@SuppressWarnings("all")
public abstract class AbstractTraceRegionToString {
  @Accessors
  protected static class Insert {
    private final int offset;
    
    private final boolean open;
    
    private final AbstractTraceRegionToString.RegionHandle region;
    
    private final AbstractTraceRegionToString.LocationHandle location;
    
    public Insert(final int offset, final boolean open, final AbstractTraceRegionToString.RegionHandle region, final AbstractTraceRegionToString.LocationHandle location) {
      super();
      this.offset = offset;
      this.open = open;
      this.region = region;
      this.location = location;
    }
    
    @Pure
    public int getOffset() {
      return this.offset;
    }
    
    @Pure
    public boolean isOpen() {
      return this.open;
    }
    
    @Pure
    public AbstractTraceRegionToString.RegionHandle getRegion() {
      return this.region;
    }
    
    @Pure
    public AbstractTraceRegionToString.LocationHandle getLocation() {
      return this.location;
    }
  }
  
  @Accessors
  protected static class File {
    private final SourceRelativeURI uri;
    
    private final List<AbstractTraceRegionToString.Insert> inserts = CollectionLiterals.<AbstractTraceRegionToString.Insert>newArrayList();
    
    private final List<String> lines = CollectionLiterals.<String>newArrayList();
    
    public File(final SourceRelativeURI uri) {
      super();
      this.uri = uri;
    }
    
    @Pure
    public SourceRelativeURI getUri() {
      return this.uri;
    }
    
    @Pure
    public List<AbstractTraceRegionToString.Insert> getInserts() {
      return this.inserts;
    }
    
    @Pure
    public List<String> getLines() {
      return this.lines;
    }
  }
  
  @Accessors
  protected static class RegionHandle {
    private final int id;
    
    private final AbstractTraceRegion region;
    
    private final List<AbstractTraceRegionToString.LocationHandle> locations = CollectionLiterals.<AbstractTraceRegionToString.LocationHandle>newArrayList();
    
    private final List<AbstractTraceRegionToString.RegionHandle> children = CollectionLiterals.<AbstractTraceRegionToString.RegionHandle>newArrayList();
    
    public RegionHandle(final int id, final AbstractTraceRegion region) {
      super();
      this.id = id;
      this.region = region;
    }
    
    @Pure
    public int getId() {
      return this.id;
    }
    
    @Pure
    public AbstractTraceRegion getRegion() {
      return this.region;
    }
    
    @Pure
    public List<AbstractTraceRegionToString.LocationHandle> getLocations() {
      return this.locations;
    }
    
    @Pure
    public List<AbstractTraceRegionToString.RegionHandle> getChildren() {
      return this.children;
    }
  }
  
  @Accessors
  protected static class LocationHandle {
    private final AbstractTraceRegionToString.RegionHandle region;
    
    private final int id;
    
    private final ILocationData location;
    
    public LocationHandle(final AbstractTraceRegionToString.RegionHandle region, final int id, final ILocationData location) {
      super();
      this.region = region;
      this.id = id;
      this.location = location;
    }
    
    @Pure
    public AbstractTraceRegionToString.RegionHandle getRegion() {
      return this.region;
    }
    
    @Pure
    public int getId() {
      return this.id;
    }
    
    @Pure
    public ILocationData getLocation() {
      return this.location;
    }
  }
  
  private int radix = 10;
  
  private boolean showTree = true;
  
  private boolean showLegend = true;
  
  protected abstract String getRemoteText(final SourceRelativeURI uri);
  
  protected abstract String getLocalText();
  
  protected abstract AbstractTraceRegion getTrace();
  
  protected ITextRegion getLocalFrame() {
    return null;
  }
  
  protected ITextRegion getRemoteFrame(final SourceRelativeURI uri) {
    return null;
  }
  
  protected String getLocalTitle() {
    return "generated.java";
  }
  
  protected String getRemoteTitle(final SourceRelativeURI uri) {
    return uri.getURI().toString();
  }
  
  protected boolean shouldInclude(final AbstractTraceRegion region) {
    final ITextRegion frame = this.getLocalFrame();
    if ((frame == null)) {
      return true;
    } else {
      return frame.contains(region.getMyRegion());
    }
  }
  
  protected boolean shouldInclude(final AbstractTraceRegion region, final ILocationData location) {
    SourceRelativeURI _elvis = null;
    SourceRelativeURI _srcRelativePath = location.getSrcRelativePath();
    if (_srcRelativePath != null) {
      _elvis = _srcRelativePath;
    } else {
      SourceRelativeURI _associatedSrcRelativePath = region.getAssociatedSrcRelativePath();
      _elvis = _associatedSrcRelativePath;
    }
    final ITextRegion frame = this.getRemoteFrame(_elvis);
    if ((frame == null)) {
      return true;
    } else {
      return frame.contains(location);
    }
  }
  
  protected void add(final Map<SourceRelativeURI, AbstractTraceRegionToString.File> files, final SourceRelativeURI uri, final ITextRegion it, final AbstractTraceRegionToString.RegionHandle region, final AbstractTraceRegionToString.LocationHandle location) {
    AbstractTraceRegionToString.File file = files.get(uri);
    if ((file == null)) {
      AbstractTraceRegionToString.File _file = new AbstractTraceRegionToString.File(uri);
      AbstractTraceRegionToString.File _file_1 = file = _file;
      files.put(uri, _file_1);
    }
    this.add(file, it, region, location);
  }
  
  protected void add(final AbstractTraceRegionToString.File file, final ITextRegion it, final AbstractTraceRegionToString.RegionHandle region, final AbstractTraceRegionToString.LocationHandle location) {
    int _offset = it.getOffset();
    AbstractTraceRegionToString.Insert _insert = new AbstractTraceRegionToString.Insert(_offset, true, region, location);
    file.inserts.add(_insert);
    int _offset_1 = it.getOffset();
    int _length = it.getLength();
    int _plus = (_offset_1 + _length);
    AbstractTraceRegionToString.Insert _insert_1 = new AbstractTraceRegionToString.Insert(_plus, false, region, location);
    file.inserts.add(_insert_1);
  }
  
  protected int collect(final AbstractTraceRegion reg, final int nextID, final AbstractTraceRegionToString.File lFile, final Map<SourceRelativeURI, AbstractTraceRegionToString.File> rFiles, final List<AbstractTraceRegionToString.RegionHandle> result) {
    int i = nextID;
    List<AbstractTraceRegionToString.RegionHandle> childResult = result;
    boolean _shouldInclude = this.shouldInclude(reg);
    if (_shouldInclude) {
      int _plusPlus = i++;
      final AbstractTraceRegionToString.RegionHandle regHandle = new AbstractTraceRegionToString.RegionHandle(_plusPlus, reg);
      result.add(regHandle);
      childResult = regHandle.children;
      this.add(lFile, reg.getMyRegion(), regHandle, null);
      final Function1<ILocationData, Boolean> _function = (ILocationData it) -> {
        return Boolean.valueOf(this.shouldInclude(reg, it));
      };
      final List<ILocationData> locs = IterableExtensions.<ILocationData>toList(IterableExtensions.<ILocationData>filter(reg.getAssociatedLocations(), _function));
      for (int j = 0; (j < locs.size()); j++) {
        {
          final ILocationData loc = locs.get(j);
          int _xifexpression = (int) 0;
          int _size = locs.size();
          boolean _greaterThan = (_size > 1);
          if (_greaterThan) {
            _xifexpression = (j + 1);
          } else {
            _xifexpression = (-1);
          }
          final AbstractTraceRegionToString.LocationHandle locHandle = new AbstractTraceRegionToString.LocationHandle(regHandle, _xifexpression, loc);
          regHandle.locations.add(locHandle);
          SourceRelativeURI _elvis = null;
          SourceRelativeURI _srcRelativePath = loc.getSrcRelativePath();
          if (_srcRelativePath != null) {
            _elvis = _srcRelativePath;
          } else {
            SourceRelativeURI _associatedSrcRelativePath = reg.getAssociatedSrcRelativePath();
            _elvis = _associatedSrcRelativePath;
          }
          final SourceRelativeURI path = _elvis;
          this.add(rFiles, path, loc, regHandle, locHandle);
        }
      }
    }
    List<AbstractTraceRegion> _nestedRegions = reg.getNestedRegions();
    for (final AbstractTraceRegion child : _nestedRegions) {
      i = this.collect(child, i, lFile, rFiles, childResult);
    }
    return i;
  }
  
  protected String render(final AbstractTraceRegionToString.Insert it, final int width) {
    final String first = Strings.padStart(Integer.toString(it.region.id, this.radix), width, '0');
    String _xifexpression = null;
    if (((it.location != null) && (it.location.id >= 0))) {
      String _string = Integer.toString(it.location.id, this.radix);
      _xifexpression = ((first + "_") + _string);
    } else {
      _xifexpression = first;
    }
    return _xifexpression;
  }
  
  protected int sortKey(final AbstractTraceRegionToString.Insert it) {
    final int base = (it.region.id * Short.MAX_VALUE);
    int _xifexpression = (int) 0;
    if (((it.location != null) && (it.location.id >= 0))) {
      _xifexpression = (base + it.location.id);
    } else {
      _xifexpression = base;
    }
    return _xifexpression;
  }
  
  protected String render(final Collection<AbstractTraceRegionToString.Insert> inserts, final int width) {
    final Function1<AbstractTraceRegionToString.Insert, Boolean> _function = (AbstractTraceRegionToString.Insert it) -> {
      return Boolean.valueOf(it.open);
    };
    final Function1<AbstractTraceRegionToString.Insert, Integer> _function_1 = (AbstractTraceRegionToString.Insert it) -> {
      return Integer.valueOf(this.sortKey(it));
    };
    final Function1<AbstractTraceRegionToString.Insert, String> _function_2 = (AbstractTraceRegionToString.Insert it) -> {
      return this.render(it, width);
    };
    final String opens = IterableExtensions.join(ListExtensions.<AbstractTraceRegionToString.Insert, String>map(IterableExtensions.<AbstractTraceRegionToString.Insert, Integer>sortBy(IterableExtensions.<AbstractTraceRegionToString.Insert>filter(inserts, _function), _function_1), _function_2), ",");
    final Function1<AbstractTraceRegionToString.Insert, Boolean> _function_3 = (AbstractTraceRegionToString.Insert it) -> {
      return Boolean.valueOf((!it.open));
    };
    final Function1<AbstractTraceRegionToString.Insert, Integer> _function_4 = (AbstractTraceRegionToString.Insert it) -> {
      int _sortKey = this.sortKey(it);
      return Integer.valueOf((-_sortKey));
    };
    final Function1<AbstractTraceRegionToString.Insert, String> _function_5 = (AbstractTraceRegionToString.Insert it) -> {
      return this.render(it, width);
    };
    final String closes = IterableExtensions.join(ListExtensions.<AbstractTraceRegionToString.Insert, String>map(IterableExtensions.<AbstractTraceRegionToString.Insert, Integer>sortBy(IterableExtensions.<AbstractTraceRegionToString.Insert>filter(inserts, _function_3), _function_4), _function_5), ",");
    String _xifexpression = null;
    boolean _isEmpty = opens.isEmpty();
    if (_isEmpty) {
      _xifexpression = "";
    } else {
      _xifexpression = (("[" + opens) + "[");
    }
    final String s1 = _xifexpression;
    String _xifexpression_1 = null;
    boolean _isEmpty_1 = closes.isEmpty();
    if (_isEmpty_1) {
      _xifexpression_1 = "";
    } else {
      _xifexpression_1 = (("]" + closes) + "]");
    }
    final String s2 = _xifexpression_1;
    return (s2 + s1);
  }
  
  protected List<String> render(final AbstractTraceRegionToString.File file, final int width) {
    try {
      String _xifexpression = null;
      if ((file.uri == null)) {
        _xifexpression = this.getLocalText();
      } else {
        _xifexpression = this.getRemoteText(file.uri);
      }
      final String text = _xifexpression;
      ITextRegion _elvis = null;
      ITextRegion _xifexpression_1 = null;
      if ((file.uri == null)) {
        _xifexpression_1 = this.getLocalFrame();
      } else {
        _xifexpression_1 = this.getRemoteFrame(file.uri);
      }
      if (_xifexpression_1 != null) {
        _elvis = _xifexpression_1;
      } else {
        int _length = text.length();
        TextRegion _textRegion = new TextRegion(0, _length);
        _elvis = _textRegion;
      }
      final ITextRegion frame = _elvis;
      final Function1<AbstractTraceRegionToString.Insert, Boolean> _function = (AbstractTraceRegionToString.Insert it) -> {
        return Boolean.valueOf(((it.offset >= frame.getOffset()) && (it.offset <= (frame.getOffset() + frame.getLength()))));
      };
      final Iterable<AbstractTraceRegionToString.Insert> inframe = IterableExtensions.<AbstractTraceRegionToString.Insert>filter(file.inserts, _function);
      final Function<AbstractTraceRegionToString.Insert, Integer> _function_1 = (AbstractTraceRegionToString.Insert it) -> {
        return Integer.valueOf(it.offset);
      };
      final Function1<Map.Entry<Integer, Collection<AbstractTraceRegionToString.Insert>>, Integer> _function_2 = (Map.Entry<Integer, Collection<AbstractTraceRegionToString.Insert>> it) -> {
        return it.getKey();
      };
      final List<Map.Entry<Integer, Collection<AbstractTraceRegionToString.Insert>>> offsets = IterableExtensions.<Map.Entry<Integer, Collection<AbstractTraceRegionToString.Insert>>, Integer>sortBy(IterableExtensions.<Map.Entry<Integer, Collection<AbstractTraceRegionToString.Insert>>>toList(Multimaps.<Integer, AbstractTraceRegionToString.Insert>index(inframe, _function_1).asMap().entrySet()), _function_2);
      int last = frame.getOffset();
      final StringBuilder result = new StringBuilder();
      for (final Map.Entry<Integer, Collection<AbstractTraceRegionToString.Insert>> e : offsets) {
        {
          final Integer offset = e.getKey();
          final String insert = this.render(e.getValue(), width);
          final String prefix = text.substring(last, (offset).intValue());
          result.append(prefix);
          result.append(insert);
          last = (offset).intValue();
        }
      }
      int _offset = frame.getOffset();
      int _length_1 = frame.getLength();
      final int end = (_offset + _length_1);
      if ((last < end)) {
        result.append(text.substring(last, end));
      }
      String _string = result.toString();
      StringReader _stringReader = new StringReader(_string);
      return CharStreams.readLines(_stringReader);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String title(final SourceRelativeURI uri, final int width) {
    String _xifexpression = null;
    if ((uri == null)) {
      _xifexpression = this.getLocalTitle();
    } else {
      _xifexpression = this.getRemoteTitle(uri);
    }
    String _plus = (" " + _xifexpression);
    final String s = (_plus + " ");
    int _length = s.length();
    int _minus = (width - _length);
    int _divide = (_minus / 2);
    final String left = Strings.repeat("-", _divide);
    int _length_1 = s.length();
    int _length_2 = left.length();
    int _plus_1 = (_length_1 + _length_2);
    int _minus_1 = (width - _plus_1);
    final String right = Strings.repeat("-", _minus_1);
    return ((left + s) + right);
  }
  
  protected <T extends Object> Set<T> collect(final T start, final Function1<? super T, ? extends Iterable<T>> reachable) {
    return this.<LinkedHashSet<T>, T>collect(start, reachable, CollectionLiterals.<T>newLinkedHashSet());
  }
  
  protected <R extends Collection<? super T>, T extends Object> R collect(final T start, final Function1<? super T, ? extends Iterable<T>> reachable, final R collector) {
    boolean _add = collector.add(start);
    if (_add) {
      Iterable<T> _apply = reachable.apply(start);
      for (final T r : _apply) {
        this.<R, T>collect(r, reachable, collector);
      }
    }
    return collector;
  }
  
  protected String render(final AbstractTraceRegionToString.LocationHandle loc) {
    String _xifexpression = null;
    if ((loc.id >= 0)) {
      String _string = Integer.toString(loc.id, this.radix);
      _xifexpression = (_string + ": ");
    } else {
      _xifexpression = "";
    }
    final String prefix = _xifexpression;
    final String name = loc.location.getClass().getSimpleName();
    String _xifexpression_1 = null;
    SourceRelativeURI _srcRelativePath = loc.location.getSrcRelativePath();
    boolean _tripleNotEquals = (_srcRelativePath != null);
    if (_tripleNotEquals) {
      SourceRelativeURI _srcRelativePath_1 = loc.location.getSrcRelativePath();
      _xifexpression_1 = ("," + _srcRelativePath_1);
    } else {
      _xifexpression_1 = "";
    }
    final String path = _xifexpression_1;
    int _offset = loc.location.getOffset();
    String _plus = (((prefix + name) + "[") + Integer.valueOf(_offset));
    String _plus_1 = (_plus + ",");
    int _length = loc.location.getLength();
    String _plus_2 = (_plus_1 + Integer.valueOf(_length));
    String _plus_3 = (_plus_2 + path);
    return (_plus_3 + "]");
  }
  
  protected void render(final AbstractTraceRegionToString.RegionHandle region, final int idW, final int offsetW, final int lengthW, final int indent, final List<String> result) {
    final String id = Strings.padStart(Integer.toString(region.id, this.radix), idW, '0');
    String _xifexpression = null;
    boolean _isUseForDebugging = region.region.isUseForDebugging();
    if (_isUseForDebugging) {
      _xifexpression = "D";
    } else {
      _xifexpression = " ";
    }
    final String debug = _xifexpression;
    final String offset = Strings.padStart(Integer.toString(region.region.getMyOffset()), offsetW, '0');
    final String length = Strings.padStart(Integer.toString(region.region.getMyLength()), lengthW, '0');
    final String space = Strings.repeat(" ", indent);
    final String name = region.region.getClass().getSimpleName();
    final Function1<AbstractTraceRegionToString.LocationHandle, String> _function = (AbstractTraceRegionToString.LocationHandle it) -> {
      return this.render(it);
    };
    final String locations = IterableExtensions.join(ListExtensions.<AbstractTraceRegionToString.LocationHandle, String>map(region.locations, _function), ", ");
    final String loc = (((((debug + " ") + offset) + "-") + length) + space);
    final String header = (((((id + ": ") + loc) + name) + " -> ") + locations);
    boolean _isEmpty = region.children.isEmpty();
    if (_isEmpty) {
      result.add(header);
    } else {
      result.add((header + " {"));
      for (final AbstractTraceRegionToString.RegionHandle child : region.children) {
        this.render(child, idW, offsetW, lengthW, (indent + 2), result);
      }
      String _repeat = Strings.repeat(" ", loc.length());
      String _plus = ((id + ": ") + _repeat);
      String _plus_1 = (_plus + "}");
      result.add(_plus_1);
    }
  }
  
  protected String render() {
    final AbstractTraceRegionToString.File localFile = new AbstractTraceRegionToString.File(null);
    final LinkedHashMap<SourceRelativeURI, AbstractTraceRegionToString.File> remoteFiles = CollectionLiterals.<SourceRelativeURI, AbstractTraceRegionToString.File>newLinkedHashMap();
    final List<AbstractTraceRegionToString.RegionHandle> roothandles = CollectionLiterals.<AbstractTraceRegionToString.RegionHandle>newArrayList();
    final int maxid = this.collect(this.getTrace(), 1, localFile, remoteFiles, roothandles);
    final int idwidth = Integer.toString(maxid, this.radix).length();
    List<String> _render = this.render(localFile, idwidth);
    Iterables.<String>addAll(localFile.lines, _render);
    Collection<AbstractTraceRegionToString.File> _values = remoteFiles.values();
    for (final AbstractTraceRegionToString.File file : _values) {
      List<String> _render_1 = this.render(file, idwidth);
      Iterables.<String>addAll(file.lines, _render_1);
    }
    final Function1<String, Integer> _function = (String it) -> {
      return Integer.valueOf(it.length());
    };
    Integer _max = IterableExtensions.<Integer>max(ListExtensions.<String, Integer>map(localFile.lines, _function));
    int _length = this.getLocalTitle().length();
    int _plus = (_length + 2);
    final int localWidth = Math.max((_max).intValue(), _plus);
    final Function1<AbstractTraceRegionToString.File, Integer> _function_1 = (AbstractTraceRegionToString.File it) -> {
      final Function1<String, Integer> _function_2 = (String it_1) -> {
        return Integer.valueOf(it_1.length());
      };
      Integer _max_1 = IterableExtensions.<Integer>max(ListExtensions.<String, Integer>map(it.lines, _function_2));
      int _length_1 = this.getRemoteTitle(it.uri).length();
      int _plus_1 = (_length_1 + 2);
      return Integer.valueOf(Math.max((_max_1).intValue(), _plus_1));
    };
    final Integer remoteWidth = IterableExtensions.<Integer>max(IterableExtensions.<AbstractTraceRegionToString.File, Integer>map(remoteFiles.values(), _function_1));
    localFile.lines.add(0, this.title(null, localWidth));
    Collection<AbstractTraceRegionToString.File> _values_1 = remoteFiles.values();
    for (final AbstractTraceRegionToString.File file_1 : _values_1) {
      file_1.lines.add(0, this.title(file_1.uri, (remoteWidth).intValue()));
    }
    final List<String> left = localFile.lines;
    final Function1<AbstractTraceRegionToString.File, List<String>> _function_2 = (AbstractTraceRegionToString.File it) -> {
      return it.lines;
    };
    final List<String> right = IterableExtensions.<String>toList(Iterables.<String>concat(IterableExtensions.<AbstractTraceRegionToString.File, List<String>>map(remoteFiles.values(), _function_2)));
    final ArrayList<String> result = CollectionLiterals.<String>newArrayList();
    if (this.showLegend) {
      result.add(
        "Regions are surrounded by [N[ ... ]N]. Regions on the left and right with the same N are associated.");
    }
    for (int i = 0; ((i < ((Object[])Conversions.unwrapArray(left, Object.class)).length) || (i < ((Object[])Conversions.unwrapArray(right, Object.class)).length)); i++) {
      {
        String _xifexpression = null;
        int _size = left.size();
        boolean _lessThan = (i < _size);
        if (_lessThan) {
          _xifexpression = left.get(i);
        } else {
          _xifexpression = "";
        }
        final String l = Strings.padEnd(_xifexpression, localWidth, ' ');
        String _xifexpression_1 = null;
        int _size_1 = right.size();
        boolean _lessThan_1 = (i < _size_1);
        if (_lessThan_1) {
          _xifexpression_1 = right.get(i);
        } else {
          _xifexpression_1 = "";
        }
        final String r = _xifexpression_1;
        result.add(((l + " | ") + r));
      }
    }
    if (this.showTree) {
      String _repeat = Strings.repeat("-", ((localWidth + (remoteWidth).intValue()) + 3));
      result.add(_repeat);
      if (this.showLegend) {
        result.add(
          "<N>: <isDebug> <offset>-<length> <RegionJavaClass> -> <LocationJavaClass>[<offset>,<length>,<uri>]");
      }
      final Function1<AbstractTraceRegionToString.RegionHandle, Set<AbstractTraceRegionToString.RegionHandle>> _function_3 = (AbstractTraceRegionToString.RegionHandle it) -> {
        final Function1<AbstractTraceRegionToString.RegionHandle, Iterable<AbstractTraceRegionToString.RegionHandle>> _function_4 = (AbstractTraceRegionToString.RegionHandle it_1) -> {
          return it_1.children;
        };
        return this.<AbstractTraceRegionToString.RegionHandle>collect(it, _function_4);
      };
      final Iterable<AbstractTraceRegionToString.RegionHandle> allhandles = Iterables.<AbstractTraceRegionToString.RegionHandle>concat(ListExtensions.<AbstractTraceRegionToString.RegionHandle, Set<AbstractTraceRegionToString.RegionHandle>>map(roothandles, _function_3));
      final Function1<AbstractTraceRegionToString.RegionHandle, Integer> _function_4 = (AbstractTraceRegionToString.RegionHandle it) -> {
        return Integer.valueOf(it.region.getMyOffset());
      };
      final int offsetWidth = String.valueOf(IterableExtensions.<Integer>max(IterableExtensions.<AbstractTraceRegionToString.RegionHandle, Integer>map(allhandles, _function_4))).length();
      final Function1<AbstractTraceRegionToString.RegionHandle, Integer> _function_5 = (AbstractTraceRegionToString.RegionHandle it) -> {
        return Integer.valueOf(it.region.getMyLength());
      };
      final int lengthWidth = String.valueOf(IterableExtensions.<Integer>max(IterableExtensions.<AbstractTraceRegionToString.RegionHandle, Integer>map(allhandles, _function_5))).length();
      for (final AbstractTraceRegionToString.RegionHandle handle : roothandles) {
        this.render(handle, idwidth, offsetWidth, lengthWidth, 1, result);
      }
    }
    return IterableExtensions.join(result, org.eclipse.xtext.util.Strings.newLine());
  }
  
  @Override
  public String toString() {
    String _xtrycatchfinallyexpression = null;
    try {
      return this.render();
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        _xtrycatchfinallyexpression = Throwables.getStackTraceAsString(e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  @Pure
  public int getRadix() {
    return this.radix;
  }
  
  public void setRadix(final int radix) {
    this.radix = radix;
  }
  
  @Pure
  public boolean isShowTree() {
    return this.showTree;
  }
  
  public void setShowTree(final boolean showTree) {
    this.showTree = showTree;
  }
  
  @Pure
  public boolean isShowLegend() {
    return this.showLegend;
  }
  
  public void setShowLegend(final boolean showLegend) {
    this.showLegend = showLegend;
  }
}
