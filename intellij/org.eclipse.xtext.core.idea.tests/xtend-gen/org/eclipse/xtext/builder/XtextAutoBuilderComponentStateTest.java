package org.eclipse.xtext.builder;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.build.Source2GeneratedMapping;
import org.eclipse.xtext.idea.build.XtextAutoBuilderComponentState;
import org.eclipse.xtext.index.IndexTestLanguageInjectorProvider;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(IndexTestLanguageInjectorProvider.class)
@SuppressWarnings("all")
public class XtextAutoBuilderComponentStateTest {
  @Extension
  private final XtextAutoBuilderComponentState.Codec _codec = new XtextAutoBuilderComponentState.Codec();
  
  @Inject
  @Extension
  private ParseHelper<?> _parseHelper;
  
  @Inject
  @Extension
  private IResourceDescription.Manager _manager;
  
  @Test
  public void testSource2GeneratedMap() {
    final Source2GeneratedMapping s2g0 = new Source2GeneratedMapping();
    URI _createURI = URI.createURI("foo");
    URI _createURI_1 = URI.createURI("foo_");
    s2g0.addSource2Generated(_createURI, _createURI_1);
    URI _createURI_2 = URI.createURI("foo");
    URI _createURI_3 = URI.createURI("baz_");
    s2g0.addSource2Generated(_createURI_2, _createURI_3);
    URI _createURI_4 = URI.createURI("bar");
    URI _createURI_5 = URI.createURI("bar_");
    s2g0.addSource2Generated(_createURI_4, _createURI_5);
    URI _createURI_6 = URI.createURI("bar");
    URI _createURI_7 = URI.createURI("baz_");
    s2g0.addSource2Generated(_createURI_6, _createURI_7);
    final Source2GeneratedMapping s2g1 = new Source2GeneratedMapping();
    URI _createURI_8 = URI.createURI("foobar");
    URI _createURI_9 = URI.createURI("foobar_");
    s2g1.addSource2Generated(_createURI_8, _createURI_9);
    URI _createURI_10 = URI.createURI("foobar");
    URI _createURI_11 = URI.createURI("foobar2_");
    s2g1.addSource2Generated(_createURI_10, _createURI_11);
    Pair<String, Source2GeneratedMapping> _mappedTo = Pair.<String, Source2GeneratedMapping>of("module0", s2g0);
    Pair<String, Source2GeneratedMapping> _mappedTo_1 = Pair.<String, Source2GeneratedMapping>of("module1", s2g1);
    final Map<String, Source2GeneratedMapping> map = Collections.<String, Source2GeneratedMapping>unmodifiableMap(CollectionLiterals.<String, Source2GeneratedMapping>newHashMap(_mappedTo, _mappedTo_1));
    ChunkedResourceDescriptions _chunkedResourceDescriptions = new ChunkedResourceDescriptions();
    final XtextAutoBuilderComponentState state = this._codec.encode(_chunkedResourceDescriptions, map);
    final Map<String, Source2GeneratedMapping> decodedState = this._codec.decodeModuleToGenerated(state);
    Set<String> _keySet = decodedState.keySet();
    int _size = _keySet.size();
    Assert.assertEquals(2, _size);
    final Source2GeneratedMapping _s2g0 = decodedState.get("module0");
    Assert.assertNotNull(_s2g0);
    URI _createURI_12 = URI.createURI("foo_");
    URI _createURI_13 = URI.createURI("bar_");
    URI _createURI_14 = URI.createURI("baz_");
    List<URI> _allGenerated = _s2g0.getAllGenerated();
    Set<URI> _set = IterableExtensions.<URI>toSet(_allGenerated);
    Assert.assertEquals(Collections.<URI>unmodifiableSet(CollectionLiterals.<URI>newHashSet(_createURI_12, _createURI_13, _createURI_14)), _set);
    URI _createURI_15 = URI.createURI("foo_");
    URI _createURI_16 = URI.createURI("baz_");
    URI _createURI_17 = URI.createURI("foo");
    List<URI> _generated = _s2g0.getGenerated(_createURI_17);
    Set<URI> _set_1 = IterableExtensions.<URI>toSet(_generated);
    Assert.assertEquals(Collections.<URI>unmodifiableSet(CollectionLiterals.<URI>newHashSet(_createURI_15, _createURI_16)), _set_1);
    URI _createURI_18 = URI.createURI("bar_");
    URI _createURI_19 = URI.createURI("baz_");
    URI _createURI_20 = URI.createURI("bar");
    List<URI> _generated_1 = _s2g0.getGenerated(_createURI_20);
    Set<URI> _set_2 = IterableExtensions.<URI>toSet(_generated_1);
    Assert.assertEquals(Collections.<URI>unmodifiableSet(CollectionLiterals.<URI>newHashSet(_createURI_18, _createURI_19)), _set_2);
    URI _createURI_21 = URI.createURI("foo");
    URI _createURI_22 = URI.createURI("foo_");
    List<URI> _source = _s2g0.getSource(_createURI_22);
    Set<URI> _set_3 = IterableExtensions.<URI>toSet(_source);
    Assert.assertEquals(Collections.<URI>unmodifiableSet(CollectionLiterals.<URI>newHashSet(_createURI_21)), _set_3);
    URI _createURI_23 = URI.createURI("bar");
    URI _createURI_24 = URI.createURI("bar_");
    List<URI> _source_1 = _s2g0.getSource(_createURI_24);
    Set<URI> _set_4 = IterableExtensions.<URI>toSet(_source_1);
    Assert.assertEquals(Collections.<URI>unmodifiableSet(CollectionLiterals.<URI>newHashSet(_createURI_23)), _set_4);
    URI _createURI_25 = URI.createURI("foo");
    URI _createURI_26 = URI.createURI("bar");
    URI _createURI_27 = URI.createURI("baz_");
    List<URI> _source_2 = _s2g0.getSource(_createURI_27);
    Set<URI> _set_5 = IterableExtensions.<URI>toSet(_source_2);
    Assert.assertEquals(Collections.<URI>unmodifiableSet(CollectionLiterals.<URI>newHashSet(_createURI_25, _createURI_26)), _set_5);
    final Source2GeneratedMapping _s2g1 = decodedState.get("module1");
    Assert.assertNotNull(_s2g1);
    URI _createURI_28 = URI.createURI("foobar_");
    URI _createURI_29 = URI.createURI("foobar2_");
    List<URI> _allGenerated_1 = _s2g1.getAllGenerated();
    Set<URI> _set_6 = IterableExtensions.<URI>toSet(_allGenerated_1);
    Assert.assertEquals(Collections.<URI>unmodifiableSet(CollectionLiterals.<URI>newHashSet(_createURI_28, _createURI_29)), _set_6);
    URI _createURI_30 = URI.createURI("foobar_");
    URI _createURI_31 = URI.createURI("foobar2_");
    URI _createURI_32 = URI.createURI("foobar");
    List<URI> _generated_2 = _s2g1.getGenerated(_createURI_32);
    Set<URI> _set_7 = IterableExtensions.<URI>toSet(_generated_2);
    Assert.assertEquals(Collections.<URI>unmodifiableSet(CollectionLiterals.<URI>newHashSet(_createURI_30, _createURI_31)), _set_7);
    URI _createURI_33 = URI.createURI("foobar");
    URI _createURI_34 = URI.createURI("foobar_");
    List<URI> _source_3 = _s2g1.getSource(_createURI_34);
    Set<URI> _set_8 = IterableExtensions.<URI>toSet(_source_3);
    Assert.assertEquals(Collections.<URI>unmodifiableSet(CollectionLiterals.<URI>newHashSet(_createURI_33)), _set_8);
    URI _createURI_35 = URI.createURI("foobar");
    URI _createURI_36 = URI.createURI("foobar2_");
    List<URI> _source_4 = _s2g1.getSource(_createURI_36);
    Set<URI> _set_9 = IterableExtensions.<URI>toSet(_source_4);
    Assert.assertEquals(Collections.<URI>unmodifiableSet(CollectionLiterals.<URI>newHashSet(_createURI_35)), _set_9);
  }
  
  @Test
  public void testIndex() {
    try {
      final HashMap<String, ResourceDescriptionsData> map = CollectionLiterals.<String, ResourceDescriptionsData>newHashMap();
      IntegerRange _upTo = new IntegerRange(0, 1);
      for (final Integer j : _upTo) {
        {
          final XtextResourceSet rs = new XtextResourceSet();
          final ArrayList<IResourceDescription> descriptions = CollectionLiterals.<IResourceDescription>newArrayList();
          IntegerRange _upTo_1 = new IntegerRange(0, 1);
          for (final Integer i : _upTo_1) {
            {
              StringConcatenation _builder = new StringConcatenation();
              _builder.append("entity Foo1{}");
              _builder.newLine();
              URI _createURI = URI.createURI((("Foo" + i) + ".indextestlanguage"));
              EObject _parse = this._parseHelper.parse(_builder, _createURI, rs);
              final Resource r = _parse.eResource();
              IResourceDescription _resourceDescription = this._manager.getResourceDescription(r);
              descriptions.add(_resourceDescription);
            }
          }
          ResourceDescriptionsData _resourceDescriptionsData = new ResourceDescriptionsData(descriptions);
          map.put(("module" + j), _resourceDescriptionsData);
        }
      }
      final ChunkedResourceDescriptions index = new ChunkedResourceDescriptions(map);
      Map<String, Source2GeneratedMapping> _emptyMap = CollectionLiterals.<String, Source2GeneratedMapping>emptyMap();
      final XtextAutoBuilderComponentState state = this._codec.encode(index, _emptyMap);
      final ChunkedResourceDescriptions _index = this._codec.decodeIndex(state);
      Iterable<IResourceDescription> _allResourceDescriptions = index.getAllResourceDescriptions();
      int _size = IterableExtensions.size(_allResourceDescriptions);
      Iterable<IResourceDescription> _allResourceDescriptions_1 = _index.getAllResourceDescriptions();
      int _size_1 = IterableExtensions.size(_allResourceDescriptions_1);
      Assert.assertEquals(_size, _size_1);
      Iterable<IResourceDescription> _allResourceDescriptions_2 = index.getAllResourceDescriptions();
      for (final IResourceDescription desc : _allResourceDescriptions_2) {
        URI _uRI = desc.getURI();
        IResourceDescription _resourceDescription = _index.getResourceDescription(_uRI);
        IResourceDescription.Delta _createDelta = this._manager.createDelta(desc, _resourceDescription);
        boolean _haveEObjectDescriptionsChanged = _createDelta.haveEObjectDescriptionsChanged();
        Assert.assertFalse(_haveEObjectDescriptionsChanged);
      }
      ResourceDescriptionsData _container = _index.getContainer("module1");
      final Iterable<IResourceDescription> _module0 = _container.getAllResourceDescriptions();
      final Function1<IResourceDescription, String> _function = new Function1<IResourceDescription, String>() {
        @Override
        public String apply(final IResourceDescription it) {
          URI _uRI = it.getURI();
          String _lastSegment = _uRI.lastSegment();
          return _lastSegment.toString();
        }
      };
      Iterable<String> _map = IterableExtensions.<IResourceDescription, String>map(_module0, _function);
      Set<String> _set = IterableExtensions.<String>toSet(_map);
      Assert.assertEquals(Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("Foo0.indextestlanguage", "Foo1.indextestlanguage")), _set);
      ResourceDescriptionsData _container_1 = _index.getContainer("module1");
      final Iterable<IResourceDescription> _module1 = _container_1.getAllResourceDescriptions();
      final Function1<IResourceDescription, String> _function_1 = new Function1<IResourceDescription, String>() {
        @Override
        public String apply(final IResourceDescription it) {
          URI _uRI = it.getURI();
          String _lastSegment = _uRI.lastSegment();
          return _lastSegment.toString();
        }
      };
      Iterable<String> _map_1 = IterableExtensions.<IResourceDescription, String>map(_module1, _function_1);
      Set<String> _set_1 = IterableExtensions.<String>toSet(_map_1);
      Assert.assertEquals(Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("Foo0.indextestlanguage", "Foo1.indextestlanguage")), _set_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
