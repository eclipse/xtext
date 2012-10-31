/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractFeatureCallTypeTest;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseNewTypeSystemInjectorProvider;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow
 */
@RunWith(value = XtextRunner.class)
@InjectWith(value = XbaseNewTypeSystemInjectorProvider.class)
@SuppressWarnings("all")
public class BatchFeatureCallTypeTest extends AbstractFeatureCallTypeTest {
  @Inject
  private IBatchTypeResolver batchTypeResolver;
  
  public IBatchTypeResolver getTypeResolver() {
    return this.batchTypeResolver;
  }
  
  public void resolvesFeatureCallsTo(final String expression, final String... types) {
    final String expressionWithQualifiedNames = expression.replace("$$", "org::eclipse::xtext::xbase::lib::");
    final List<XAbstractFeatureCall> featureCalls = this.findFeatureCalls(expressionWithQualifiedNames);
    boolean _isEmpty = featureCalls.isEmpty();
    Assert.assertFalse(_isEmpty);
    int _size = ((List<String>)Conversions.doWrapArray(types)).size();
    int _size_1 = featureCalls.size();
    Assert.assertEquals(_size, _size_1);
    IBatchTypeResolver _typeResolver = this.getTypeResolver();
    XAbstractFeatureCall _head = IterableExtensions.<XAbstractFeatureCall>head(featureCalls);
    final IResolvedTypes resolvedTypes = _typeResolver.resolveTypes(_head);
    final Procedure2<XAbstractFeatureCall,Integer> _function = new Procedure2<XAbstractFeatureCall,Integer>() {
        public void apply(final XAbstractFeatureCall featureCall, final Integer index) {
          final LightweightTypeReference type = resolvedTypes.getActualType(featureCall);
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("failed for feature call at ");
          _builder.append(index, "");
          String _get = ((List<String>)Conversions.doWrapArray(types)).get((index).intValue());
          String _simpleName = type.getSimpleName();
          Assert.assertEquals(_builder.toString(), _get, _simpleName);
        }
      };
    IterableExtensions.<XAbstractFeatureCall>forEach(featureCalls, _function);
  }
}
