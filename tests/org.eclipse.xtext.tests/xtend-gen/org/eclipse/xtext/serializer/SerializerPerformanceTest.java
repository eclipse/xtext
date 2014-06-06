/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.serializer;

import com.google.inject.Inject;
import java.util.Random;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.serializer.HiddenTokenSequencerTestLanguageInjectorProvider;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.hiddentokensequencertest.DomainModel;
import org.eclipse.xtext.serializer.hiddentokensequencertest.Entity;
import org.eclipse.xtext.serializer.hiddentokensequencertest.Model;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
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
  public final Timeout timeout = new Timeout(5000);
  
  private final static int numberOfElements = 1000;
  
  private final static int numberOfEdits = (SerializerPerformanceTest.numberOfElements / 100);
  
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
      Model _parse = this._parseHelper.parse(_builder);
      this.model = _parse;
      final Random rand = new Random();
      DomainModel _domainModel = this.model.getDomainModel();
      final EList<Entity> entities = _domainModel.getEntities();
      ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, SerializerPerformanceTest.numberOfEdits, true);
      for (final Integer i_1 : _doubleDotLessThan_1) {
        int _size = entities.size();
        int _nextInt = rand.nextInt(_size);
        entities.remove(_nextInt);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test() {
    this._iSerializer.serialize(this.model);
  }
}
