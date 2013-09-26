/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.builder;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend.ide.tests.builder.JavaEditorExtension;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.builder.impl.QueuedBuildData;
import org.eclipse.xtext.builder.impl.javasupport.JavaChangeQueueFiller;
import org.eclipse.xtext.builder.impl.javasupport.UnconfirmedStructuralChangesDelta;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
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
  protected QueuedBuildData queuedBuildData;
  
  @Inject
  protected JavaChangeQueueFiller javaChangeQueueFiller;
  
  public void tearDown() throws Exception {
    this.testHelper.tearDown();
    super.tearDown();
  }
  
  public Collection<? extends Delta> assertThereAreDeltas(final Procedure0 producer, final String... expectedStructucalChangedTypes) {
    Collection<Delta> _assertDeltas = this.assertDeltas(producer);
    Collection<? extends Delta> _assertThereAreDeltas = this.assertThereAreDeltas(_assertDeltas, expectedStructucalChangedTypes);
    return _assertThereAreDeltas;
  }
  
  public Collection<? extends Delta> assertThereAreDeltas(final Collection<? extends Delta> deltas, final String... expectedStructucalChangedTypes) {
    Collection<? extends Delta> _xblockexpression = null;
    {
      int _size = deltas.size();
      boolean _notEquals = (0 != _size);
      Assert.assertTrue("There are not deltas", _notEquals);
      int _length = expectedStructucalChangedTypes.length;
      boolean _notEquals_1 = (_length != 0);
      if (_notEquals_1) {
        final HashSet<String> remainingQualifiedNames = CollectionLiterals.<String>newHashSet(expectedStructucalChangedTypes);
        Set<String> _types = this.getTypes(deltas);
        for (final String type : _types) {
          {
            final Function1<String,Boolean> _function = new Function1<String,Boolean>() {
              public Boolean apply(final String it) {
                boolean _equals = Objects.equal(type, it);
                return Boolean.valueOf(_equals);
              }
            };
            final String qualifiedName = IterableExtensions.<String>findFirst(((Iterable<String>)Conversions.doWrapArray(expectedStructucalChangedTypes)), _function);
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("There are deltas for the following type: ");
            _builder.append(type, "");
            Assert.assertNotNull(_builder.toString(), qualifiedName);
            remainingQualifiedNames.remove(qualifiedName);
          }
        }
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("There are not deltas for the following types: ");
        _builder.append(remainingQualifiedNames, "");
        int _length_1 = ((Object[])Conversions.unwrapArray(remainingQualifiedNames, Object.class)).length;
        Assert.assertEquals(_builder.toString(), 0, _length_1);
      }
      _xblockexpression = (deltas);
    }
    return _xblockexpression;
  }
  
  public Collection<? extends Delta> assertThereAreNotDeltas(final Procedure0 producer) {
    Collection<? extends Delta> _xblockexpression = null;
    {
      final Collection<Delta> deltas = this.assertDeltas(producer);
      Collection<? extends Delta> _assertThereAreNotDeltas = this.assertThereAreNotDeltas(deltas);
      _xblockexpression = (_assertThereAreNotDeltas);
    }
    return _xblockexpression;
  }
  
  public Collection<? extends Delta> assertThereAreNotDeltas(final Collection<? extends Delta> deltas) {
    Collection<? extends Delta> _xblockexpression = null;
    {
      Set<String> _types = this.getTypes(deltas);
      String _plus = ("There are deltas: " + _types);
      int _size = deltas.size();
      Assert.assertEquals(_plus, 0, _size);
      _xblockexpression = (deltas);
    }
    return _xblockexpression;
  }
  
  public Set<String> getTypes(final Collection<? extends Delta> deltas) {
    final Function1<Delta,String> _function = new Function1<Delta,String>() {
      public String apply(final Delta it) {
        String _xblockexpression = null;
        {
          URI _uri = it.getUri();
          final String uri = _uri.toString();
          int _lastIndexOf = uri.lastIndexOf("/");
          int _plus = (_lastIndexOf + 1);
          String _substring = uri.substring(_plus);
          _xblockexpression = (_substring);
        }
        return _xblockexpression;
      }
    };
    Iterable<String> _map = IterableExtensions.map(deltas, _function);
    Set<String> _set = IterableExtensions.<String>toSet(_map);
    return _set;
  }
  
  public Collection<Delta> assertDeltas(final Procedure0 producer) {
    Collection<Delta> _xblockexpression = null;
    {
      this.reset();
      producer.apply();
      this.confirmDeltas();
      Collection<Delta> _andRemovePendingDeltas = this.queuedBuildData.getAndRemovePendingDeltas();
      _xblockexpression = (_andRemovePendingDeltas);
    }
    return _xblockexpression;
  }
  
  public void reset() {
    IResourcesSetupUtil.waitForAutoBuild();
    this.queuedBuildData.reset();
  }
  
  public void confirmDeltas() {
    final boolean result = this.tryConfirmDeltas();
    final Collection<UnconfirmedStructuralChangesDelta> deltas = this.queuedBuildData.getUnconfirmedDeltas();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("There are unconfirmed changes: ");
    Set<String> _types = this.getTypes(deltas);
    _builder.append(_types, "");
    Assert.assertTrue(_builder.toString(), result);
  }
  
  public boolean tryConfirmDeltas() {
    boolean _xblockexpression = false;
    {
      IResourcesSetupUtil.waitForAutoBuild();
      IProject _project = this.testHelper.getProject();
      boolean _tryConfirmAllChanges = this.queuedBuildData.tryConfirmAllChanges(_project);
      _xblockexpression = (_tryConfirmAllChanges);
    }
    return _xblockexpression;
  }
}
