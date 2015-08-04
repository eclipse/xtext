/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.trace;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
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
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
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
    URI _uRI = uri.getURI();
    return _uRI.toString();
  }
  
  protected boolean shouldInclude(final AbstractTraceRegion region) {
    final ITextRegion frame = this.getLocalFrame();
    boolean _equals = Objects.equal(frame, null);
    if (_equals) {
      return true;
    } else {
      ITextRegionWithLineInformation _myRegion = region.getMyRegion();
      return frame.contains(_myRegion);
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
    boolean _equals = Objects.equal(frame, null);
    if (_equals) {
      return true;
    } else {
      return frame.contains(location);
    }
  }
  
  protected void add(final Map<SourceRelativeURI, AbstractTraceRegionToString.File> files, final SourceRelativeURI uri, final ITextRegion it, final AbstractTraceRegionToString.RegionHandle region, final AbstractTraceRegionToString.LocationHandle location) {
    AbstractTraceRegionToString.File file = files.get(uri);
    if ((file == null)) {
      files.put(uri, file = new AbstractTraceRegionToString.File(uri));
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
      ITextRegionWithLineInformation _myRegion = reg.getMyRegion();
      this.add(lFile, _myRegion, regHandle, null);
      List<ILocationData> _associatedLocations = reg.getAssociatedLocations();
      final Function1<ILocationData, Boolean> _function = new Function1<ILocationData, Boolean>() {
        @Override
        public Boolean apply(final ILocationData it) {
          return Boolean.valueOf(AbstractTraceRegionToString.this.shouldInclude(reg, it));
        }
      };
      Iterable<ILocationData> _filter = IterableExtensions.<ILocationData>filter(_associatedLocations, _function);
      final List<ILocationData> locs = IterableExtensions.<ILocationData>toList(_filter);
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
      int _collect = this.collect(child, i, lFile, rFiles, childResult);
      i = _collect;
    }
    return i;
  }
  
  protected String render(final AbstractTraceRegionToString.Insert it, final int width) {
    String _string = Integer.toString(it.region.id, this.radix);
    final String first = Strings.padStart(_string, width, '0');
    String _xifexpression = null;
    if (((it.location != null) && (it.location.id >= 0))) {
      String _string_1 = Integer.toString(it.location.id, this.radix);
      _xifexpression = ((first + "_") + _string_1);
    } else {
      _xifexpression = first;
    }
    return _xifexpression;
  }
  
  protected int sortKey(final AbstractTraceRegionToString.Insert it) {
    final int base = (it.region.id * Short.MAX_VALUE);
    int _xifexpression = (int) 0;
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(it.location, null));
    if (!_notEquals) {
      _and = false;
    } else {
      _and = (it.location.id >= 0);
    }
    if (_and) {
      _xifexpression = (base + it.location.id);
    } else {
      _xifexpression = base;
    }
    return _xifexpression;
  }
  
  protected String render(final Collection<AbstractTraceRegionToString.Insert> inserts, final int width) {
    final Function1<AbstractTraceRegionToString.Insert, Boolean> _function = new Function1<AbstractTraceRegionToString.Insert, Boolean>() {
      @Override
      public Boolean apply(final AbstractTraceRegionToString.Insert it) {
        return Boolean.valueOf(it.open);
      }
    };
    Iterable<AbstractTraceRegionToString.Insert> _filter = IterableExtensions.<AbstractTraceRegionToString.Insert>filter(inserts, _function);
    final Function1<AbstractTraceRegionToString.Insert, Integer> _function_1 = new Function1<AbstractTraceRegionToString.Insert, Integer>() {
      @Override
      public Integer apply(final AbstractTraceRegionToString.Insert it) {
        return Integer.valueOf(AbstractTraceRegionToString.this.sortKey(it));
      }
    };
    List<AbstractTraceRegionToString.Insert> _sortBy = IterableExtensions.<AbstractTraceRegionToString.Insert, Integer>sortBy(_filter, _function_1);
    final Function1<AbstractTraceRegionToString.Insert, String> _function_2 = new Function1<AbstractTraceRegionToString.Insert, String>() {
      @Override
      public String apply(final AbstractTraceRegionToString.Insert it) {
        return AbstractTraceRegionToString.this.render(it, width);
      }
    };
    List<String> _map = ListExtensions.<AbstractTraceRegionToString.Insert, String>map(_sortBy, _function_2);
    final String opens = IterableExtensions.join(_map, ",");
    final Function1<AbstractTraceRegionToString.Insert, Boolean> _function_3 = new Function1<AbstractTraceRegionToString.Insert, Boolean>() {
      @Override
      public Boolean apply(final AbstractTraceRegionToString.Insert it) {
        return Boolean.valueOf((!it.open));
      }
    };
    Iterable<AbstractTraceRegionToString.Insert> _filter_1 = IterableExtensions.<AbstractTraceRegionToString.Insert>filter(inserts, _function_3);
    final Function1<AbstractTraceRegionToString.Insert, Integer> _function_4 = new Function1<AbstractTraceRegionToString.Insert, Integer>() {
      @Override
      public Integer apply(final AbstractTraceRegionToString.Insert it) {
        int _sortKey = AbstractTraceRegionToString.this.sortKey(it);
        return Integer.valueOf((-_sortKey));
      }
    };
    List<AbstractTraceRegionToString.Insert> _sortBy_1 = IterableExtensions.<AbstractTraceRegionToString.Insert, Integer>sortBy(_filter_1, _function_4);
    final Function1<AbstractTraceRegionToString.Insert, String> _function_5 = new Function1<AbstractTraceRegionToString.Insert, String>() {
      @Override
      public String apply(final AbstractTraceRegionToString.Insert it) {
        return AbstractTraceRegionToString.this.render(it, width);
      }
    };
    List<String> _map_1 = ListExtensions.<AbstractTraceRegionToString.Insert, String>map(_sortBy_1, _function_5);
    final String closes = IterableExtensions.join(_map_1, ",");
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
      boolean _equals = Objects.equal(file.uri, null);
      if (_equals) {
        _xifexpression = this.getLocalText();
      } else {
        _xifexpression = this.getRemoteText(file.uri);
      }
      final String text = _xifexpression;
      ITextRegion _elvis = null;
      ITextRegion _xifexpression_1 = null;
      boolean _equals_1 = Objects.equal(file.uri, null);
      if (_equals_1) {
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
      final Function1<AbstractTraceRegionToString.Insert, Boolean> _function = new Function1<AbstractTraceRegionToString.Insert, Boolean>() {
        @Override
        public Boolean apply(final AbstractTraceRegionToString.Insert it) {
          boolean _and = false;
          int _offset = frame.getOffset();
          boolean _greaterEqualsThan = (it.offset >= _offset);
          if (!_greaterEqualsThan) {
            _and = false;
          } else {
            int _offset_1 = frame.getOffset();
            int _length = frame.getLength();
            int _plus = (_offset_1 + _length);
            boolean _lessEqualsThan = (it.offset <= _plus);
            _and = _lessEqualsThan;
          }
          return Boolean.valueOf(_and);
        }
      };
      final Iterable<AbstractTraceRegionToString.Insert> inframe = IterableExtensions.<AbstractTraceRegionToString.Insert>filter(file.inserts, _function);
      final Function<AbstractTraceRegionToString.Insert, Integer> _function_1 = new Function<AbstractTraceRegionToString.Insert, Integer>() {
        @Override
        public Integer apply(final AbstractTraceRegionToString.Insert it) {
          return Integer.valueOf(it.offset);
        }
      };
      ImmutableListMultimap<Integer, AbstractTraceRegionToString.Insert> _index = Multimaps.<Integer, AbstractTraceRegionToString.Insert>index(inframe, _function_1);
      ImmutableMap<Integer, Collection<AbstractTraceRegionToString.Insert>> _asMap = _index.asMap();
      ImmutableSet<Map.Entry<Integer, Collection<AbstractTraceRegionToString.Insert>>> _entrySet = _asMap.entrySet();
      List<Map.Entry<Integer, Collection<AbstractTraceRegionToString.Insert>>> _list = IterableExtensions.<Map.Entry<Integer, Collection<AbstractTraceRegionToString.Insert>>>toList(_entrySet);
      final Function1<Map.Entry<Integer, Collection<AbstractTraceRegionToString.Insert>>, Integer> _function_2 = new Function1<Map.Entry<Integer, Collection<AbstractTraceRegionToString.Insert>>, Integer>() {
        @Override
        public Integer apply(final Map.Entry<Integer, Collection<AbstractTraceRegionToString.Insert>> it) {
          return it.getKey();
        }
      };
      final List<Map.Entry<Integer, Collection<AbstractTraceRegionToString.Insert>>> offsets = IterableExtensions.<Map.Entry<Integer, Collection<AbstractTraceRegionToString.Insert>>, Integer>sortBy(_list, _function_2);
      int last = frame.getOffset();
      final StringBuilder result = new StringBuilder();
      for (final Map.Entry<Integer, Collection<AbstractTraceRegionToString.Insert>> e : offsets) {
        {
          final Integer offset = e.getKey();
          Collection<AbstractTraceRegionToString.Insert> _value = e.getValue();
          final String insert = this.render(_value, width);
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
        String _substring = text.substring(last, end);
        result.append(_substring);
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
    LinkedHashSet<T> _newLinkedHashSet = CollectionLiterals.<T>newLinkedHashSet();
    return this.<LinkedHashSet<T>, T>collect(start, reachable, _newLinkedHashSet);
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
    Class<? extends ILocationData> _class = loc.location.getClass();
    final String name = _class.getSimpleName();
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
    String _string = Integer.toString(region.id, this.radix);
    final String id = Strings.padStart(_string, idW, '0');
    String _xifexpression = null;
    boolean _isUseForDebugging = region.region.isUseForDebugging();
    if (_isUseForDebugging) {
      _xifexpression = "D";
    } else {
      _xifexpression = " ";
    }
    final String debug = _xifexpression;
    int _myOffset = region.region.getMyOffset();
    String _string_1 = Integer.toString(_myOffset);
    final String offset = Strings.padStart(_string_1, offsetW, '0');
    int _myLength = region.region.getMyLength();
    String _string_2 = Integer.toString(_myLength);
    final String length = Strings.padStart(_string_2, lengthW, '0');
    final String space = Strings.repeat(" ", indent);
    Class<? extends AbstractTraceRegion> _class = region.region.getClass();
    final String name = _class.getSimpleName();
    final Function1<AbstractTraceRegionToString.LocationHandle, String> _function = new Function1<AbstractTraceRegionToString.LocationHandle, String>() {
      @Override
      public String apply(final AbstractTraceRegionToString.LocationHandle it) {
        return AbstractTraceRegionToString.this.render(it);
      }
    };
    List<String> _map = ListExtensions.<AbstractTraceRegionToString.LocationHandle, String>map(region.locations, _function);
    final String locations = IterableExtensions.join(_map, ", ");
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
      int _length = loc.length();
      String _repeat = Strings.repeat(" ", _length);
      String _plus = ((id + ": ") + _repeat);
      String _plus_1 = (_plus + "}");
      result.add(_plus_1);
    }
  }
  
  protected String render() {
    final AbstractTraceRegionToString.File localFile = new AbstractTraceRegionToString.File(null);
    final LinkedHashMap<SourceRelativeURI, AbstractTraceRegionToString.File> remoteFiles = CollectionLiterals.<SourceRelativeURI, AbstractTraceRegionToString.File>newLinkedHashMap();
    final List<AbstractTraceRegionToString.RegionHandle> roothandles = CollectionLiterals.<AbstractTraceRegionToString.RegionHandle>newArrayList();
    AbstractTraceRegion _trace = this.getTrace();
    final int maxid = this.collect(_trace, 1, localFile, remoteFiles, roothandles);
    String _string = Integer.toString(maxid, this.radix);
    final int idwidth = _string.length();
    List<String> _render = this.render(localFile, idwidth);
    Iterables.<String>addAll(localFile.lines, _render);
    Collection<AbstractTraceRegionToString.File> _values = remoteFiles.values();
    for (final AbstractTraceRegionToString.File file : _values) {
      List<String> _render_1 = this.render(file, idwidth);
      Iterables.<String>addAll(file.lines, _render_1);
    }
    final Function1<String, Integer> _function = new Function1<String, Integer>() {
      @Override
      public Integer apply(final String it) {
        return Integer.valueOf(it.length());
      }
    };
    List<Integer> _map = ListExtensions.<String, Integer>map(localFile.lines, _function);
    Integer _max = IterableExtensions.<Integer>max(_map);
    String _localTitle = this.getLocalTitle();
    int _length = _localTitle.length();
    int _plus = (_length + 2);
    final int localWidth = Math.max((_max).intValue(), _plus);
    Collection<AbstractTraceRegionToString.File> _values_1 = remoteFiles.values();
    final Function1<AbstractTraceRegionToString.File, Integer> _function_1 = new Function1<AbstractTraceRegionToString.File, Integer>() {
      @Override
      public Integer apply(final AbstractTraceRegionToString.File it) {
        final Function1<String, Integer> _function = new Function1<String, Integer>() {
          @Override
          public Integer apply(final String it) {
            return Integer.valueOf(it.length());
          }
        };
        List<Integer> _map = ListExtensions.<String, Integer>map(it.lines, _function);
        Integer _max = IterableExtensions.<Integer>max(_map);
        String _remoteTitle = AbstractTraceRegionToString.this.getRemoteTitle(it.uri);
        int _length = _remoteTitle.length();
        int _plus = (_length + 2);
        return Integer.valueOf(Math.max((_max).intValue(), _plus));
      }
    };
    Iterable<Integer> _map_1 = IterableExtensions.<AbstractTraceRegionToString.File, Integer>map(_values_1, _function_1);
    final Integer remoteWidth = IterableExtensions.<Integer>max(_map_1);
    String _title = this.title(null, localWidth);
    localFile.lines.add(0, _title);
    Collection<AbstractTraceRegionToString.File> _values_2 = remoteFiles.values();
    for (final AbstractTraceRegionToString.File file_1 : _values_2) {
      String _title_1 = this.title(file_1.uri, (remoteWidth).intValue());
      file_1.lines.add(0, _title_1);
    }
    final List<String> left = localFile.lines;
    Collection<AbstractTraceRegionToString.File> _values_3 = remoteFiles.values();
    final Function1<AbstractTraceRegionToString.File, List<String>> _function_2 = new Function1<AbstractTraceRegionToString.File, List<String>>() {
      @Override
      public List<String> apply(final AbstractTraceRegionToString.File it) {
        return it.lines;
      }
    };
    Iterable<List<String>> _map_2 = IterableExtensions.<AbstractTraceRegionToString.File, List<String>>map(_values_3, _function_2);
    Iterable<String> _flatten = Iterables.<String>concat(_map_2);
    final List<String> right = IterableExtensions.<String>toList(_flatten);
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
      final Function1<AbstractTraceRegionToString.RegionHandle, Set<AbstractTraceRegionToString.RegionHandle>> _function_3 = new Function1<AbstractTraceRegionToString.RegionHandle, Set<AbstractTraceRegionToString.RegionHandle>>() {
        @Override
        public Set<AbstractTraceRegionToString.RegionHandle> apply(final AbstractTraceRegionToString.RegionHandle it) {
          final Function1<AbstractTraceRegionToString.RegionHandle, Iterable<AbstractTraceRegionToString.RegionHandle>> _function = new Function1<AbstractTraceRegionToString.RegionHandle, Iterable<AbstractTraceRegionToString.RegionHandle>>() {
            @Override
            public Iterable<AbstractTraceRegionToString.RegionHandle> apply(final AbstractTraceRegionToString.RegionHandle it) {
              return it.children;
            }
          };
          return AbstractTraceRegionToString.this.<AbstractTraceRegionToString.RegionHandle>collect(it, _function);
        }
      };
      List<Set<AbstractTraceRegionToString.RegionHandle>> _map_3 = ListExtensions.<AbstractTraceRegionToString.RegionHandle, Set<AbstractTraceRegionToString.RegionHandle>>map(roothandles, _function_3);
      final Iterable<AbstractTraceRegionToString.RegionHandle> allhandles = Iterables.<AbstractTraceRegionToString.RegionHandle>concat(_map_3);
      final Function1<AbstractTraceRegionToString.RegionHandle, Integer> _function_4 = new Function1<AbstractTraceRegionToString.RegionHandle, Integer>() {
        @Override
        public Integer apply(final AbstractTraceRegionToString.RegionHandle it) {
          return Integer.valueOf(it.region.getMyOffset());
        }
      };
      Iterable<Integer> _map_4 = IterableExtensions.<AbstractTraceRegionToString.RegionHandle, Integer>map(allhandles, _function_4);
      Integer _max_1 = IterableExtensions.<Integer>max(_map_4);
      String _valueOf = String.valueOf(_max_1);
      final int offsetWidth = _valueOf.length();
      final Function1<AbstractTraceRegionToString.RegionHandle, Integer> _function_5 = new Function1<AbstractTraceRegionToString.RegionHandle, Integer>() {
        @Override
        public Integer apply(final AbstractTraceRegionToString.RegionHandle it) {
          return Integer.valueOf(it.region.getMyLength());
        }
      };
      Iterable<Integer> _map_5 = IterableExtensions.<AbstractTraceRegionToString.RegionHandle, Integer>map(allhandles, _function_5);
      Integer _max_2 = IterableExtensions.<Integer>max(_map_5);
      String _valueOf_1 = String.valueOf(_max_2);
      final int lengthWidth = _valueOf_1.length();
      for (final AbstractTraceRegionToString.RegionHandle handle : roothandles) {
        this.render(handle, idwidth, offsetWidth, lengthWidth, 1, result);
      }
    }
    String _newLine = org.eclipse.xtext.util.Strings.newLine();
    return IterableExtensions.join(result, _newLine);
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
