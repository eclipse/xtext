/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.serializer;

import com.google.inject.Inject;
import java.util.concurrent.TimeUnit;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.serializer.HiddenTokenSequencerTestLanguageInjectorProvider;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.hiddentokensequencertest.Entity;
import org.eclipse.xtext.serializer.hiddentokensequencertest.Model;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(HiddenTokenSequencerTestLanguageInjectorProvider.class)
@SuppressWarnings("all")
public class SerializerPerformanceTest {
  @Inject
  @Extension
  private ParseHelper<Model> _parseHelper;
  
  @Inject
  @Extension
  private ISerializer _iSerializer;
  
  @Rule
  public final Timeout timeout = new Timeout(5000, TimeUnit.MILLISECONDS);
  
  private static final int numberOfElements = 1000;
  
  private static final int editEvery = 100;
  
  private Model model;
  
  @Before
  public void setup() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("entities");
      _builder.newLine();
      {
        ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, SerializerPerformanceTest.numberOfElements, true);
        for(final Integer i : _doubleDotLessThan) {
          _builder.append("\t");
          _builder.append("//comment before element");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("Foo /* comment between elements*/ \"Bar\" //comment after element ");
          _builder.newLine();
        }
      }
      _builder.append("end");
      _builder.newLine();
      this.model = this._parseHelper.parse(_builder);
      final EList<Entity> entities = this.model.getDomainModel().getEntities();
      final Function1<Integer, Boolean> _function = (Integer it) -> {
        return Boolean.valueOf((((it).intValue() % SerializerPerformanceTest.editEvery) == 0));
      };
      final Function1<Integer, Entity> _function_1 = (Integer it) -> {
        return entities.get((it).intValue());
      };
      final Iterable<Entity> removeUs = IterableExtensions.<Integer, Entity>map(IterableExtensions.<Integer>filter(new ExclusiveRange(0, SerializerPerformanceTest.numberOfElements, true), _function), _function_1);
      CollectionExtensions.<Entity>removeAll(entities, removeUs);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test() {
    this._iSerializer.serialize(this.model);
  }
}
