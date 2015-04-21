/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.formatting2.regionaccess.internal;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.RegionAccessTestLanguageInjectorProvider;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.AssignedAction;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(RegionAccessTestLanguageInjectorProvider.class)
@SuppressWarnings("all")
public class RegionAccessAccessTest {
  @Inject
  @Extension
  private ParseHelper<Root> parseHelper;
  
  @Inject
  private Provider<TextRegionAccessBuilder> textRegionAccessBuilder;
  
  @Inject
  @Extension
  private ValidationTestHelper validationTestHelper;
  
  @Test
  public void regionForFeatureAttribute() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    final ITextRegionAccess access = this.toAccess(mixed);
    final ISemanticRegion actual = access.regionForFeature(mixed, RegionaccesstestlanguagePackage.Literals.MIXED__NAME);
    String _text = actual.getText();
    Assert.assertEquals("foo", _text);
  }
  
  @Test
  public void regionForFeatureCrossReference() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (ref foo) action (foo) end");
    final AssignedAction mixed = this.<AssignedAction>parseAs(_builder, AssignedAction.class);
    final ITextRegionAccess access = this.toAccess(mixed);
    Mixed _child = mixed.getChild();
    final ISemanticRegion actual = access.regionForFeature(_child, RegionaccesstestlanguagePackage.Literals.MIXED__REF);
    String _text = actual.getText();
    Assert.assertEquals("foo", _text);
  }
  
  @Test(expected = IllegalStateException.class)
  public void regionForFeatureContainmentReference() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (foo) action");
    final AssignedAction mixed = this.<AssignedAction>parseAs(_builder, AssignedAction.class);
    final ITextRegionAccess access = this.toAccess(mixed);
    final ISemanticRegion actual = access.regionForFeature(mixed, RegionaccesstestlanguagePackage.Literals.ASSIGNED_ACTION__CHILD);
    String _text = actual.getText();
    Assert.assertEquals("foo", _text);
  }
  
  @Test
  public void regionsForFeaturesAttribute() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    final ITextRegionAccess access = this.toAccess(mixed);
    final List<ISemanticRegion> actual = access.regionsForFeatures(mixed, RegionaccesstestlanguagePackage.Literals.MIXED__NAME);
    final Function1<ISemanticRegion, String> _function = new Function1<ISemanticRegion, String>() {
      @Override
      public String apply(final ISemanticRegion it) {
        return it.getText();
      }
    };
    List<String> _map = ListExtensions.<ISemanticRegion, String>map(actual, _function);
    String _join = IterableExtensions.join(_map);
    Assert.assertEquals("foo", _join);
  }
  
  @Test
  public void regionsForFeaturesCrossReference() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (ref foo) action (foo) end");
    final AssignedAction mixed = this.<AssignedAction>parseAs(_builder, AssignedAction.class);
    final ITextRegionAccess access = this.toAccess(mixed);
    Mixed _child = mixed.getChild();
    final List<ISemanticRegion> actual = access.regionsForFeatures(_child, RegionaccesstestlanguagePackage.Literals.MIXED__REF);
    final Function1<ISemanticRegion, String> _function = new Function1<ISemanticRegion, String>() {
      @Override
      public String apply(final ISemanticRegion it) {
        return it.getText();
      }
    };
    List<String> _map = ListExtensions.<ISemanticRegion, String>map(actual, _function);
    String _join = IterableExtensions.join(_map);
    Assert.assertEquals("foo", _join);
  }
  
  @Test(expected = IllegalStateException.class)
  public void regionsForFeaturesContainmentReference() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (foo) action");
    final AssignedAction mixed = this.<AssignedAction>parseAs(_builder, AssignedAction.class);
    final ITextRegionAccess access = this.toAccess(mixed);
    final List<ISemanticRegion> actual = access.regionsForFeatures(mixed, RegionaccesstestlanguagePackage.Literals.ASSIGNED_ACTION__CHILD);
    final Function1<ISemanticRegion, String> _function = new Function1<ISemanticRegion, String>() {
      @Override
      public String apply(final ISemanticRegion it) {
        return it.getText();
      }
    };
    List<String> _map = ListExtensions.<ISemanticRegion, String>map(actual, _function);
    String _join = IterableExtensions.join(_map);
    Assert.assertEquals("foo", _join);
  }
  
  private <T extends EObject> T parseAs(final CharSequence seq, final Class<T> cls) {
    try {
      final Root result = this.parseHelper.parse(seq);
      this.validationTestHelper.assertNoErrors(result);
      return cls.cast(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private ITextRegionAccess toAccess(final EObject obj) {
    TextRegionAccessBuilder _get = this.textRegionAccessBuilder.get();
    Resource _eResource = obj.eResource();
    TextRegionAccessBuilder _forNodeModel = _get.forNodeModel(((XtextResource) _eResource));
    return _forNodeModel.create();
  }
}
