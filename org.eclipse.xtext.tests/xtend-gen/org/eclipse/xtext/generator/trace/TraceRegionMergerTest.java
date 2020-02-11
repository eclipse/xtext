/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.trace;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.generator.trace.TraceRegion;
import org.eclipse.xtext.generator.trace.TraceRegionMerger;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class TraceRegionMergerTest {
  @Accessors
  public static class TestBuilder {
    private List<AbstractTraceRegion> roots = CollectionLiterals.<AbstractTraceRegion>newArrayList();
    
    public TraceRegionMergerTest.TestBuilder traceTo(final String uri, final Function1<? super TraceRegionMergerTest.TraceBuilder, ? extends AbstractTraceRegion> init) {
      TraceRegionMergerTest.TestBuilder _xblockexpression = null;
      {
        final TraceRegionMergerTest.TraceBuilder traceBuilder = new TraceRegionMergerTest.TraceBuilder(this, uri);
        this.roots.add(init.apply(traceBuilder));
        _xblockexpression = this;
      }
      return _xblockexpression;
    }
    
    public void assertMerged(final Procedure1<? super TraceRegionMergerTest.AssertBuilder> init) {
      final AbstractTraceRegion mergedRoot = new TraceRegionMerger().mergeTraceRegions(this.roots);
      Assert.assertNotNull(mergedRoot);
      LinkedList<AbstractTraceRegion> _newLinkedList = CollectionLiterals.<AbstractTraceRegion>newLinkedList(mergedRoot);
      final TraceRegionMergerTest.AssertBuilder assertBuilder = new TraceRegionMergerTest.AssertBuilder(this, _newLinkedList);
      init.apply(assertBuilder);
      assertBuilder.thatsIt();
    }
    
    @Pure
    public List<AbstractTraceRegion> getRoots() {
      return this.roots;
    }
    
    public void setRoots(final List<AbstractTraceRegion> roots) {
      this.roots = roots;
    }
  }
  
  @FinalFieldsConstructor
  public static class TraceBuilder {
    private final TraceRegionMergerTest.TestBuilder testBuilder;
    
    private final SourceRelativeURI uri;
    
    private final AbstractTraceRegion root;
    
    public TraceBuilder(final TraceRegionMergerTest.TestBuilder testBuilder, final String uri) {
      this(testBuilder, new SourceRelativeURI(URI.createURI(uri)), null);
    }
    
    public AbstractTraceRegion region(final int offset, final int length, final int startLine, final int endLine) {
      return this.region(offset, length, startLine, endLine, null);
    }
    
    public AbstractTraceRegion region(final int offset, final int length, final int startLine, final int endLine, final Procedure1<? super TraceRegionMergerTest.TraceBuilder> init) {
      TraceRegion _xblockexpression = null;
      {
        final TraceRegion root = new TraceRegion(offset, length, startLine, endLine, true, 0, 0, 0, 0, this.root, this.uri);
        if ((init != null)) {
          final TraceRegionMergerTest.TraceBuilder child = new TraceRegionMergerTest.TraceBuilder(this.testBuilder, this.uri, root);
          init.apply(child);
        }
        _xblockexpression = root;
      }
      return _xblockexpression;
    }
    
    public TraceBuilder(final TraceRegionMergerTest.TestBuilder testBuilder, final SourceRelativeURI uri, final AbstractTraceRegion root) {
      super();
      this.testBuilder = testBuilder;
      this.uri = uri;
      this.root = root;
    }
  }
  
  @FinalFieldsConstructor
  public static class AssertBuilder {
    private final TraceRegionMergerTest.TestBuilder testBuilder;
    
    private final Queue<AbstractTraceRegion> regions;
    
    public TraceRegionMergerTest.AssertBuilder region(final int offset, final int length, final int startLine, final int endLine, final String... uris) {
      return this.region(offset, length, startLine, endLine, ((List<String>)Conversions.doWrapArray(uris)), null);
    }
    
    public TraceRegionMergerTest.AssertBuilder region(final int offset, final int length, final int startLine, final int endLine, final String uri, final Procedure1<? super TraceRegionMergerTest.AssertBuilder> init) {
      return this.region(offset, length, startLine, endLine, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(uri)), null);
    }
    
    public TraceRegionMergerTest.AssertBuilder region(final int offset, final int length, final int startLine, final int endLine, final Procedure1<? super TraceRegionMergerTest.AssertBuilder> init) {
      return this.region(offset, length, startLine, endLine, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList()), init);
    }
    
    public TraceRegionMergerTest.AssertBuilder region(final int offset, final int length, final int startLine, final int endLine, final List<String> uris, final Procedure1<? super TraceRegionMergerTest.AssertBuilder> init) {
      TraceRegionMergerTest.AssertBuilder _xblockexpression = null;
      {
        final AbstractTraceRegion head = this.regions.poll();
        Assert.assertEquals(head.toString(), offset, head.getMyOffset());
        Assert.assertEquals(head.toString(), length, head.getMyLength());
        Assert.assertEquals(head.toString(), startLine, head.getMyLineNumber());
        Assert.assertEquals(head.toString(), endLine, head.getMyEndLineNumber());
        final Function1<ILocationData, SourceRelativeURI> _function = (ILocationData it) -> {
          return it.getSrcRelativePath();
        };
        final Set<SourceRelativeURI> associatedLocations = IterableExtensions.<SourceRelativeURI>toSet(ListExtensions.<ILocationData, SourceRelativeURI>map(head.getAssociatedLocations(), _function));
        Assert.assertEquals(head.toString(), ((Object[])Conversions.unwrapArray(uris, Object.class)).length, ((Object[])Conversions.unwrapArray(associatedLocations, Object.class)).length);
        for (final String uri : uris) {
          URI _createURI = URI.createURI(uri);
          SourceRelativeURI _sourceRelativeURI = new SourceRelativeURI(_createURI);
          Assert.assertTrue(("Missing " + uri), associatedLocations.contains(_sourceRelativeURI));
        }
        if ((init == null)) {
          Assert.assertTrue(head.getNestedRegions().isEmpty());
        } else {
          LinkedList<AbstractTraceRegion> _newLinkedList = CollectionLiterals.<AbstractTraceRegion>newLinkedList(((AbstractTraceRegion[])Conversions.unwrapArray(head.getNestedRegions(), AbstractTraceRegion.class)));
          final TraceRegionMergerTest.AssertBuilder child = new TraceRegionMergerTest.AssertBuilder(this.testBuilder, _newLinkedList);
          init.apply(child);
          child.thatsIt();
        }
        _xblockexpression = this;
      }
      return _xblockexpression;
    }
    
    public void thatsIt() {
      Assert.assertTrue(this.regions.toString(), this.regions.isEmpty());
    }
    
    public AssertBuilder(final TraceRegionMergerTest.TestBuilder testBuilder, final Queue<AbstractTraceRegion> regions) {
      super();
      this.testBuilder = testBuilder;
      this.regions = regions;
    }
  }
  
  @Test
  public void testSingleFile() {
    final Function1<TraceRegionMergerTest.TraceBuilder, AbstractTraceRegion> _function = (TraceRegionMergerTest.TraceBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.TraceBuilder> _function_1 = (TraceRegionMergerTest.TraceBuilder it_1) -> {
        it_1.region(2, 2, 1, 2);
        it_1.region(4, 2, 2, 2);
      };
      return it.region(2, 6, 1, 3, _function_1);
    };
    final Procedure1<TraceRegionMergerTest.AssertBuilder> _function_1 = (TraceRegionMergerTest.AssertBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.AssertBuilder> _function_2 = (TraceRegionMergerTest.AssertBuilder it_1) -> {
        it_1.region(2, 2, 1, 2, "foo");
        it_1.region(4, 2, 2, 2, "foo");
        it_1.region(6, 2, 2, 3, "foo");
      };
      it.region(2, 6, 1, 3, _function_2);
    };
    this.traceTo("foo", _function).assertMerged(_function_1);
  }
  
  @Test
  public void testSame() {
    final Function1<TraceRegionMergerTest.TraceBuilder, AbstractTraceRegion> _function = (TraceRegionMergerTest.TraceBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.TraceBuilder> _function_1 = (TraceRegionMergerTest.TraceBuilder it_1) -> {
        it_1.region(0, 2, 0, 1);
        it_1.region(2, 2, 1, 2);
      };
      return it.region(0, 4, 0, 2, _function_1);
    };
    final Function1<TraceRegionMergerTest.TraceBuilder, AbstractTraceRegion> _function_1 = (TraceRegionMergerTest.TraceBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.TraceBuilder> _function_2 = (TraceRegionMergerTest.TraceBuilder it_1) -> {
        it_1.region(0, 2, 0, 1);
        it_1.region(2, 2, 1, 2);
      };
      return it.region(0, 4, 0, 2, _function_2);
    };
    final Procedure1<TraceRegionMergerTest.AssertBuilder> _function_2 = (TraceRegionMergerTest.AssertBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.AssertBuilder> _function_3 = (TraceRegionMergerTest.AssertBuilder it_1) -> {
        it_1.region(0, 2, 0, 1, "foo", "bar");
        it_1.region(2, 2, 1, 2, "foo", "bar");
      };
      it.region(0, 4, 0, 2, _function_3);
    };
    this.traceTo("foo", _function).traceTo("bar", _function_1).assertMerged(_function_2);
  }
  
  @Test
  public void testDisjunctive() {
    final Function1<TraceRegionMergerTest.TraceBuilder, AbstractTraceRegion> _function = (TraceRegionMergerTest.TraceBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.TraceBuilder> _function_1 = (TraceRegionMergerTest.TraceBuilder it_1) -> {
        it_1.region(0, 2, 0, 1);
      };
      return it.region(0, 2, 0, 1, _function_1);
    };
    final Function1<TraceRegionMergerTest.TraceBuilder, AbstractTraceRegion> _function_1 = (TraceRegionMergerTest.TraceBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.TraceBuilder> _function_2 = (TraceRegionMergerTest.TraceBuilder it_1) -> {
        it_1.region(2, 2, 1, 2);
      };
      return it.region(2, 2, 1, 2, _function_2);
    };
    final Procedure1<TraceRegionMergerTest.AssertBuilder> _function_2 = (TraceRegionMergerTest.AssertBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.AssertBuilder> _function_3 = (TraceRegionMergerTest.AssertBuilder it_1) -> {
        it_1.region(0, 2, 0, 1, "foo");
        it_1.region(2, 2, 1, 2, "bar");
      };
      it.region(0, 4, 0, 2, _function_3);
    };
    this.traceTo("foo", _function).traceTo("bar", _function_1).assertMerged(_function_2);
  }
  
  @Test
  public void testOneInCommon() {
    final Function1<TraceRegionMergerTest.TraceBuilder, AbstractTraceRegion> _function = (TraceRegionMergerTest.TraceBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.TraceBuilder> _function_1 = (TraceRegionMergerTest.TraceBuilder it_1) -> {
        it_1.region(0, 2, 0, 1);
        it_1.region(2, 2, 1, 2);
      };
      return it.region(0, 4, 0, 2, _function_1);
    };
    final Function1<TraceRegionMergerTest.TraceBuilder, AbstractTraceRegion> _function_1 = (TraceRegionMergerTest.TraceBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.TraceBuilder> _function_2 = (TraceRegionMergerTest.TraceBuilder it_1) -> {
        it_1.region(2, 2, 1, 2);
      };
      return it.region(2, 2, 1, 2, _function_2);
    };
    final Procedure1<TraceRegionMergerTest.AssertBuilder> _function_2 = (TraceRegionMergerTest.AssertBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.AssertBuilder> _function_3 = (TraceRegionMergerTest.AssertBuilder it_1) -> {
        it_1.region(0, 2, 0, 1, "foo");
        it_1.region(2, 2, 1, 2, "foo", "bar");
      };
      it.region(0, 4, 0, 2, _function_3);
    };
    this.traceTo("foo", _function).traceTo("bar", _function_1).assertMerged(_function_2);
  }
  
  @Test
  public void testSplit() {
    final Function1<TraceRegionMergerTest.TraceBuilder, AbstractTraceRegion> _function = (TraceRegionMergerTest.TraceBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.TraceBuilder> _function_1 = (TraceRegionMergerTest.TraceBuilder it_1) -> {
        it_1.region(2, 2, 1, 2);
        it_1.region(4, 2, 2, 2);
      };
      return it.region(2, 6, 1, 3, _function_1);
    };
    final Function1<TraceRegionMergerTest.TraceBuilder, AbstractTraceRegion> _function_1 = (TraceRegionMergerTest.TraceBuilder it) -> {
      return it.region(0, 3, 0, 1);
    };
    final Procedure1<TraceRegionMergerTest.AssertBuilder> _function_2 = (TraceRegionMergerTest.AssertBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.AssertBuilder> _function_3 = (TraceRegionMergerTest.AssertBuilder it_1) -> {
        it_1.region(0, 2, 0, 1, "bar");
        it_1.region(2, 1, 1, 1, "foo", "bar");
        it_1.region(3, 1, 1, 2, "foo");
        it_1.region(4, 2, 2, 2, "foo");
        it_1.region(6, 2, 2, 3, "foo");
      };
      it.region(0, 8, 0, 3, _function_3);
    };
    this.traceTo("foo", _function).traceTo("bar", _function_1).assertMerged(_function_2);
  }
  
  @Test
  public void testContainedSplitBeforeNewline() {
    final Function1<TraceRegionMergerTest.TraceBuilder, AbstractTraceRegion> _function = (TraceRegionMergerTest.TraceBuilder it) -> {
      return it.region(0, 6, 0, 2);
    };
    final Function1<TraceRegionMergerTest.TraceBuilder, AbstractTraceRegion> _function_1 = (TraceRegionMergerTest.TraceBuilder it) -> {
      return it.region(2, 2, 0, 1);
    };
    final Procedure1<TraceRegionMergerTest.AssertBuilder> _function_2 = (TraceRegionMergerTest.AssertBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.AssertBuilder> _function_3 = (TraceRegionMergerTest.AssertBuilder it_1) -> {
        it_1.region(0, 2, 0, 0, "foo");
        it_1.region(2, 2, 0, 1, "foo", "bar");
        it_1.region(4, 2, 1, 2, "foo");
      };
      it.region(0, 6, 0, 2, _function_3);
    };
    this.traceTo("foo", _function).traceTo("bar", _function_1).assertMerged(_function_2);
  }
  
  @Test
  public void testContainedSplitAfterNewline() {
    final Function1<TraceRegionMergerTest.TraceBuilder, AbstractTraceRegion> _function = (TraceRegionMergerTest.TraceBuilder it) -> {
      return it.region(0, 6, 0, 2);
    };
    final Function1<TraceRegionMergerTest.TraceBuilder, AbstractTraceRegion> _function_1 = (TraceRegionMergerTest.TraceBuilder it) -> {
      return it.region(3, 2, 1, 1);
    };
    final Procedure1<TraceRegionMergerTest.AssertBuilder> _function_2 = (TraceRegionMergerTest.AssertBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.AssertBuilder> _function_3 = (TraceRegionMergerTest.AssertBuilder it_1) -> {
        it_1.region(0, 3, 0, 1, "foo");
        it_1.region(3, 2, 1, 1, "foo", "bar");
        it_1.region(5, 1, 1, 2, "foo");
      };
      it.region(0, 6, 0, 2, _function_3);
    };
    this.traceTo("foo", _function).traceTo("bar", _function_1).assertMerged(_function_2);
  }
  
  @Test
  public void testOverlapSplitBeforeNewline() {
    final Function1<TraceRegionMergerTest.TraceBuilder, AbstractTraceRegion> _function = (TraceRegionMergerTest.TraceBuilder it) -> {
      return it.region(0, 4, 0, 1);
    };
    final Function1<TraceRegionMergerTest.TraceBuilder, AbstractTraceRegion> _function_1 = (TraceRegionMergerTest.TraceBuilder it) -> {
      return it.region(2, 4, 0, 2);
    };
    final Procedure1<TraceRegionMergerTest.AssertBuilder> _function_2 = (TraceRegionMergerTest.AssertBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.AssertBuilder> _function_3 = (TraceRegionMergerTest.AssertBuilder it_1) -> {
        it_1.region(0, 2, 0, 0, "foo");
        it_1.region(2, 2, 0, 1, "foo", "bar");
        it_1.region(4, 2, 1, 2, "bar");
      };
      it.region(0, 6, 0, 2, _function_3);
    };
    this.traceTo("foo", _function).traceTo("bar", _function_1).assertMerged(_function_2);
  }
  
  @Test
  public void testOverlapSplitAfterNewline() {
    final Function1<TraceRegionMergerTest.TraceBuilder, AbstractTraceRegion> _function = (TraceRegionMergerTest.TraceBuilder it) -> {
      return it.region(0, 4, 0, 1);
    };
    final Function1<TraceRegionMergerTest.TraceBuilder, AbstractTraceRegion> _function_1 = (TraceRegionMergerTest.TraceBuilder it) -> {
      return it.region(3, 3, 1, 2);
    };
    final Procedure1<TraceRegionMergerTest.AssertBuilder> _function_2 = (TraceRegionMergerTest.AssertBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.AssertBuilder> _function_3 = (TraceRegionMergerTest.AssertBuilder it_1) -> {
        it_1.region(0, 3, 0, 1, "foo");
        it_1.region(3, 1, 1, 1, "foo", "bar");
        it_1.region(4, 2, 1, 2, "bar");
      };
      it.region(0, 6, 0, 2, _function_3);
    };
    this.traceTo("foo", _function).traceTo("bar", _function_1).assertMerged(_function_2);
  }
  
  @Test
  public void testOverlapChain_SplitAfterNewline() {
    final Function1<TraceRegionMergerTest.TraceBuilder, AbstractTraceRegion> _function = (TraceRegionMergerTest.TraceBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.TraceBuilder> _function_1 = (TraceRegionMergerTest.TraceBuilder it_1) -> {
        it_1.region(0, 3, 0, 1);
        it_1.region(3, 3, 1, 2);
        it_1.region(6, 3, 2, 3);
      };
      return it.region(0, 9, 0, 3, _function_1);
    };
    final Function1<TraceRegionMergerTest.TraceBuilder, AbstractTraceRegion> _function_1 = (TraceRegionMergerTest.TraceBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.TraceBuilder> _function_2 = (TraceRegionMergerTest.TraceBuilder it_1) -> {
        it_1.region(1, 3, 0, 1);
        it_1.region(4, 3, 1, 2);
      };
      return it.region(1, 6, 0, 2, _function_2);
    };
    final Procedure1<TraceRegionMergerTest.AssertBuilder> _function_2 = (TraceRegionMergerTest.AssertBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.AssertBuilder> _function_3 = (TraceRegionMergerTest.AssertBuilder it_1) -> {
        it_1.region(0, 1, 0, 0, "foo");
        it_1.region(1, 2, 0, 1, "foo", "bar");
        it_1.region(3, 1, 1, 1, "foo", "bar");
        it_1.region(4, 2, 1, 2, "foo", "bar");
        it_1.region(6, 1, 2, 2, "foo", "bar");
        it_1.region(7, 2, 2, 3, "foo");
      };
      it.region(0, 9, 0, 3, _function_3);
    };
    this.traceTo("foo", _function).traceTo("bar", _function_1).assertMerged(_function_2);
  }
  
  @Test
  public void testOverlapChain_SplitBeforeNewline() {
    final Function1<TraceRegionMergerTest.TraceBuilder, AbstractTraceRegion> _function = (TraceRegionMergerTest.TraceBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.TraceBuilder> _function_1 = (TraceRegionMergerTest.TraceBuilder it_1) -> {
        it_1.region(0, 3, 0, 1);
        it_1.region(3, 3, 1, 2);
        it_1.region(6, 3, 2, 3);
      };
      return it.region(0, 9, 0, 3, _function_1);
    };
    final Function1<TraceRegionMergerTest.TraceBuilder, AbstractTraceRegion> _function_1 = (TraceRegionMergerTest.TraceBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.TraceBuilder> _function_2 = (TraceRegionMergerTest.TraceBuilder it_1) -> {
        it_1.region(2, 3, 0, 1);
        it_1.region(5, 3, 1, 2);
      };
      return it.region(2, 6, 0, 2, _function_2);
    };
    final Procedure1<TraceRegionMergerTest.AssertBuilder> _function_2 = (TraceRegionMergerTest.AssertBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.AssertBuilder> _function_3 = (TraceRegionMergerTest.AssertBuilder it_1) -> {
        it_1.region(0, 2, 0, 0, "foo");
        it_1.region(2, 1, 0, 1, "foo", "bar");
        it_1.region(3, 2, 1, 1, "foo", "bar");
        it_1.region(5, 1, 1, 2, "foo", "bar");
        it_1.region(6, 2, 2, 2, "foo", "bar");
        it_1.region(8, 1, 2, 3, "foo");
      };
      it.region(0, 9, 0, 3, _function_3);
    };
    this.traceTo("foo", _function).traceTo("bar", _function_1).assertMerged(_function_2);
  }
  
  @Test
  public void testThree() {
    final Function1<TraceRegionMergerTest.TraceBuilder, AbstractTraceRegion> _function = (TraceRegionMergerTest.TraceBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.TraceBuilder> _function_1 = (TraceRegionMergerTest.TraceBuilder it_1) -> {
        it_1.region(0, 3, 0, 1);
        it_1.region(3, 3, 1, 2);
        it_1.region(6, 3, 2, 3);
      };
      return it.region(0, 9, 0, 3, _function_1);
    };
    final Function1<TraceRegionMergerTest.TraceBuilder, AbstractTraceRegion> _function_1 = (TraceRegionMergerTest.TraceBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.TraceBuilder> _function_2 = (TraceRegionMergerTest.TraceBuilder it_1) -> {
        it_1.region(1, 3, 0, 1);
        it_1.region(4, 3, 1, 2);
      };
      return it.region(1, 6, 0, 2, _function_2);
    };
    final Function1<TraceRegionMergerTest.TraceBuilder, AbstractTraceRegion> _function_2 = (TraceRegionMergerTest.TraceBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.TraceBuilder> _function_3 = (TraceRegionMergerTest.TraceBuilder it_1) -> {
        it_1.region(2, 3, 0, 1);
        it_1.region(5, 3, 1, 2);
      };
      return it.region(2, 6, 0, 2, _function_3);
    };
    final Procedure1<TraceRegionMergerTest.AssertBuilder> _function_3 = (TraceRegionMergerTest.AssertBuilder it) -> {
      final Procedure1<TraceRegionMergerTest.AssertBuilder> _function_4 = (TraceRegionMergerTest.AssertBuilder it_1) -> {
        it_1.region(0, 1, 0, 0, "foo");
        it_1.region(1, 1, 0, 0, "foo", "bar");
        it_1.region(2, 1, 0, 1, "foo", "bar", "baz");
        it_1.region(3, 1, 1, 1, "foo", "bar", "baz");
        it_1.region(4, 1, 1, 1, "foo", "bar", "baz");
        it_1.region(5, 1, 1, 2, "foo", "bar", "baz");
        it_1.region(6, 1, 2, 2, "foo", "bar", "baz");
        it_1.region(7, 1, 2, 2, "foo", "baz");
        it_1.region(8, 1, 2, 3, "foo");
      };
      it.region(0, 9, 0, 3, _function_4);
    };
    this.traceTo("foo", _function).traceTo("bar", _function_1).traceTo("baz", _function_2).assertMerged(_function_3);
  }
  
  public TraceRegionMergerTest.TestBuilder traceTo(final String uri, final Function1<? super TraceRegionMergerTest.TraceBuilder, ? extends AbstractTraceRegion> init) {
    return new TraceRegionMergerTest.TestBuilder().traceTo(uri, init);
  }
}
