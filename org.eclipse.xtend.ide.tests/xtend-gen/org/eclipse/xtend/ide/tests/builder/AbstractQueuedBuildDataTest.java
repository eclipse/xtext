/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.builder;

import com.google.inject.Inject;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.function.Consumer;
import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.builder.impl.QueuedBuildData;
import org.eclipse.xtext.builder.impl.javasupport.BuilderDeltaConverter;
import org.eclipse.xtext.builder.impl.javasupport.JavaChangeQueueFiller;
import org.eclipse.xtext.builder.impl.javasupport.JdtQueuedBuildData;
import org.eclipse.xtext.builder.impl.javasupport.UnconfirmedStructuralChangesDelta;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.junit.Assert;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractQueuedBuildDataTest extends AbstractXtendUITestCase {
  /**
   * <p>
   * To print events into the console set <code>VERBOSE</code> flag of <code>JavaEditorExtension</code> as <code>true</code>.
   * </p>
   */
  @Inject
  @Extension
  protected JavaEditorExtension _javaEditorExtension;

  @Inject
  @Extension
  protected WorkbenchTestHelper testHelper;

  @Inject
  private IStorage2UriMapper mapper;

  @Inject
  protected BuilderDeltaConverter converter;

  protected QueuedBuildData queuedBuildData;

  protected JdtQueuedBuildData queuedBuildDataContribution;

  protected JavaChangeQueueFiller queueFiller;

  @Override
  public void setUp() throws Exception {
    super.setUp();
    JdtQueuedBuildData _jdtQueuedBuildData = new JdtQueuedBuildData();
    this.queuedBuildDataContribution = _jdtQueuedBuildData;
    QueuedBuildData _queuedBuildData = new QueuedBuildData(this.mapper, this.queuedBuildDataContribution);
    this.queuedBuildData = _queuedBuildData;
    JavaChangeQueueFiller _javaChangeQueueFiller = new JavaChangeQueueFiller(this.queuedBuildData, this.converter);
    this.queueFiller = _javaChangeQueueFiller;
    JavaCore.addElementChangedListener(this.queueFiller, ElementChangedEvent.POST_CHANGE);
  }

  @Override
  public void tearDown() throws Exception {
    JavaCore.removeElementChangedListener(this.queueFiller);
    this.queueFiller = null;
    this.queuedBuildData = null;
    this.testHelper.tearDown();
    super.tearDown();
  }

  public Collection<? extends IResourceDescription.Delta> assertThereAreDeltas(final Procedure0 producer, final String... expectedExportedNames) {
    return this.assertThereAreDeltas(this.assertDeltas(producer), expectedExportedNames);
  }

  public Collection<? extends IResourceDescription.Delta> assertThereAreDeltas(final Collection<? extends IResourceDescription.Delta> deltas, final String... expectedExportedNames) {
    Collection<? extends IResourceDescription.Delta> _xblockexpression = null;
    {
      int _size = deltas.size();
      boolean _notEquals = (0 != _size);
      Assert.assertTrue("There are not deltas", _notEquals);
      int _length = expectedExportedNames.length;
      boolean _notEquals_1 = (_length != 0);
      if (_notEquals_1) {
        final HashSet<String> remainingExportedNames = CollectionLiterals.<String>newHashSet(expectedExportedNames);
        final HashSet<String> unexpectedExportedNames = CollectionLiterals.<String>newHashSet();
        HashSet<String> _exportedNames = this.getExportedNames(deltas);
        for (final String exportedName : _exportedNames) {
          {
            final Function1<String, Boolean> _function = (String it) -> {
              return Boolean.valueOf(Objects.equals(exportedName, it));
            };
            final String qualifiedName = IterableExtensions.<String>findFirst(((Iterable<String>)Conversions.doWrapArray(expectedExportedNames)), _function);
            if ((qualifiedName == null)) {
              unexpectedExportedNames.add(exportedName);
            } else {
              remainingExportedNames.remove(qualifiedName);
            }
          }
        }
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("There are unexpected exported names: ");
        _builder.append(unexpectedExportedNames);
        Assert.assertEquals(_builder.toString(), 0, 
          ((Object[])Conversions.unwrapArray(unexpectedExportedNames, Object.class)).length);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("There are not expected exported names ");
        _builder_1.append(remainingExportedNames);
        Assert.assertEquals(_builder_1.toString(), 0, 
          ((Object[])Conversions.unwrapArray(remainingExportedNames, Object.class)).length);
      }
      _xblockexpression = deltas;
    }
    return _xblockexpression;
  }

  public Collection<? extends IResourceDescription.Delta> assertThereAreNotDeltas(final Procedure0 producer) {
    Collection<? extends IResourceDescription.Delta> _xblockexpression = null;
    {
      final Collection<IResourceDescription.Delta> deltas = this.assertDeltas(producer);
      _xblockexpression = this.assertThereAreNotDeltas(deltas);
    }
    return _xblockexpression;
  }

  public Collection<? extends IResourceDescription.Delta> assertThereAreNotDeltas(final Collection<? extends IResourceDescription.Delta> deltas) {
    Collection<? extends IResourceDescription.Delta> _xblockexpression = null;
    {
      HashSet<String> _exportedNames = this.getExportedNames(deltas);
      String _plus = ("There are deltas: " + _exportedNames);
      Assert.assertEquals(_plus, 0, deltas.size());
      _xblockexpression = deltas;
    }
    return _xblockexpression;
  }

  public HashSet<String> getExportedNames(final Collection<? extends IResourceDescription.Delta> deltas) {
    final Function1<IResourceDescription.Delta, HashSet<String>> _function = (IResourceDescription.Delta it) -> {
      HashSet<String> _xblockexpression = null;
      {
        final HashSet<String> names = CollectionLiterals.<String>newHashSet();
        boolean _haveEObjectDescriptionsChanged = it.haveEObjectDescriptionsChanged();
        boolean _not = (!_haveEObjectDescriptionsChanged);
        if (_not) {
          return names;
        }
        IResourceDescription _new = it.getNew();
        Iterable<IEObjectDescription> _exportedObjects = null;
        if (_new!=null) {
          _exportedObjects=_new.getExportedObjects();
        }
        if (_exportedObjects!=null) {
          final Consumer<IEObjectDescription> _function_1 = (IEObjectDescription it_1) -> {
            String _string = it_1.getName().toString();
            names.add(_string);
          };
          _exportedObjects.forEach(_function_1);
        }
        IResourceDescription _old = it.getOld();
        Iterable<IEObjectDescription> _exportedObjects_1 = null;
        if (_old!=null) {
          _exportedObjects_1=_old.getExportedObjects();
        }
        if (_exportedObjects_1!=null) {
          final Consumer<IEObjectDescription> _function_2 = (IEObjectDescription it_1) -> {
            String _string = it_1.getName().toString();
            names.add(_string);
          };
          _exportedObjects_1.forEach(_function_2);
        }
        _xblockexpression = names;
      }
      return _xblockexpression;
    };
    final Function2<HashSet<String>, HashSet<String>, HashSet<String>> _function_1 = (HashSet<String> t, HashSet<String> t2) -> {
      HashSet<String> _xblockexpression = null;
      {
        t.addAll(t2);
        _xblockexpression = t;
      }
      return _xblockexpression;
    };
    return IterableExtensions.<HashSet<String>>reduce(IterableExtensions.map(deltas, _function), _function_1);
  }

  public Collection<IResourceDescription.Delta> assertDeltas(final Procedure0 producer) {
    Collection<IResourceDescription.Delta> _xblockexpression = null;
    {
      this.reset();
      producer.apply();
      this.confirmDeltas();
      _xblockexpression = this.queuedBuildData.getAndRemovePendingDeltas();
    }
    return _xblockexpression;
  }

  public void reset() {
    IResourcesSetupUtil.waitForBuild();
    this.queuedBuildData.reset();
  }

  public void confirmDeltas() {
    final boolean result = this.tryConfirmDeltas();
    final Collection<UnconfirmedStructuralChangesDelta> deltas = this.queuedBuildDataContribution.getUnconfirmedDeltas();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("There are unconfirmed changes: ");
    HashSet<String> _exportedNames = this.getExportedNames(deltas);
    _builder.append(_exportedNames);
    Assert.assertTrue(_builder.toString(), result);
  }

  public boolean tryConfirmDeltas() {
    boolean _xblockexpression = false;
    {
      IResourcesSetupUtil.waitForBuild();
      boolean _needRebuild = this.queuedBuildData.needRebuild(this.testHelper.getProject());
      _xblockexpression = (!_needRebuild);
    }
    return _xblockexpression;
  }
}
