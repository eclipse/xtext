/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.serializer;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.testlanguages.FowlerDslTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.fowlerdsl.Event;
import org.eclipse.xtext.testlanguages.fowlerdsl.FowlerdslFactory;
import org.eclipse.xtext.testlanguages.fowlerdsl.Statemachine;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=424027
 */
@SuppressWarnings("all")
public class SerializationAfterModelChangeTest extends AbstractXtextTests {
  @Before
  public void setup() {
    try {
      this.with(FowlerDslTestLanguageStandaloneSetup.class);
      this.injectMembers(this);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void smokeTest() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("events");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//before existing element");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo /* within existing element */ Bar /* after existing element*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//unrelated comment");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//before deleted element");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Baz Fizzle /* after deleted element */");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//between deleted elements");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//another deleted element");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Blurb /* a comment within a deleted element */ Bla");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//before inserted element");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      _builder.append("commands");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      EObject _model = this.getModel(_builder.toString());
      final Statemachine model = ((Statemachine) _model);
      Event _createEvent = FowlerdslFactory.eINSTANCE.createEvent();
      final Procedure1<Event> _function = new Procedure1<Event>() {
        public void apply(final Event it) {
          it.setName("AAA");
          it.setCode("BBB");
        }
      };
      final Event event = ObjectExtensions.<Event>operator_doubleArrow(_createEvent, _function);
      EList<Event> _events = model.getEvents();
      _events.remove(1);
      EList<Event> _events_1 = model.getEvents();
      _events_1.remove(1);
      EList<Event> _events_2 = model.getEvents();
      _events_2.add(event);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("events");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("//before existing element");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo /* within existing element */ Bar /* after existing element*/");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("//unrelated comment");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("//between deleted elements");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("//before inserted element");
      _builder_1.newLine();
      _builder_1.append("AAA BBB end");
      _builder_1.newLine();
      _builder_1.append("commands");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      this.assertSerializesTo(model, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * TODO does not work yet, because HiddenTokenSequencer
   * always searches in one direction,
   * but the order of the elements has changed here.
   */
  @Test
  @Ignore
  public void testMoveElement() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("events");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo Bar");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//comment between elements");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Baz Fizzle");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      _builder.append("commands");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      EObject _model = this.getModel(_builder.toString());
      final Statemachine model = ((Statemachine) _model);
      EList<Event> _events = model.getEvents();
      final Event head = IterableExtensions.<Event>head(_events);
      EList<Event> _events_1 = model.getEvents();
      _events_1.move(1, head);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("events");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Baz Fizzle");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("//comment between elements");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo Bar");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.append("commands");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      this.assertSerializesTo(model, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testWhiteSpaceOnly() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("events");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo Bar");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      _builder.append("commands");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      EObject _model = this.getModel(_builder.toString());
      final Statemachine model = ((Statemachine) _model);
      Event _createEvent = FowlerdslFactory.eINSTANCE.createEvent();
      final Procedure1<Event> _function = new Procedure1<Event>() {
        public void apply(final Event it) {
          it.setName("Baz");
          it.setCode("Fizzle");
        }
      };
      final Event event = ObjectExtensions.<Event>operator_doubleArrow(_createEvent, _function);
      EList<Event> _events = model.getEvents();
      _events.add(event);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("events");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo Bar");
      _builder_1.newLine();
      _builder_1.append("Baz Fizzle end");
      _builder_1.newLine();
      _builder_1.append("commands");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      this.assertSerializesTo(model, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCommentBeforeInsertedElement() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("events");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo Bar");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//comment before inserted element");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      _builder.append("commands");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      EObject _model = this.getModel(_builder.toString());
      final Statemachine model = ((Statemachine) _model);
      Event _createEvent = FowlerdslFactory.eINSTANCE.createEvent();
      final Procedure1<Event> _function = new Procedure1<Event>() {
        public void apply(final Event it) {
          it.setName("Baz");
          it.setCode("Fizzle");
        }
      };
      final Event event = ObjectExtensions.<Event>operator_doubleArrow(_createEvent, _function);
      EList<Event> _events = model.getEvents();
      _events.add(event);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("events");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo Bar");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("//comment before inserted element");
      _builder_1.newLine();
      _builder_1.append("Baz Fizzle end");
      _builder_1.newLine();
      _builder_1.append("commands");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      this.assertSerializesTo(model, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAddElementAfterInlineComment() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("events");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo Bar\t//inline comment before inserted element");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      _builder.append("commands");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      EObject _model = this.getModel(_builder.toString());
      final Statemachine model = ((Statemachine) _model);
      Event _createEvent = FowlerdslFactory.eINSTANCE.createEvent();
      final Procedure1<Event> _function = new Procedure1<Event>() {
        public void apply(final Event it) {
          it.setName("Baz");
          it.setCode("Fizzle");
        }
      };
      final Event event = ObjectExtensions.<Event>operator_doubleArrow(_createEvent, _function);
      EList<Event> _events = model.getEvents();
      _events.add(event);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("events");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo Bar\t//inline comment before inserted element");
      _builder_1.newLine();
      _builder_1.append("Baz Fizzle end");
      _builder_1.newLine();
      _builder_1.append("commands");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      this.assertSerializesTo(model, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCommentOnRemovedElement() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("events");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo Bar");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//comment on deleted element");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("/**");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("* another comment on the deleted element");
      _builder.newLine();
      _builder.append("\t ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Baz Fizzle");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      _builder.append("commands");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      EObject _model = this.getModel(_builder.toString());
      final Statemachine model = ((Statemachine) _model);
      EList<Event> _events = model.getEvents();
      _events.remove(1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("events");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo Bar");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.append("commands");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      this.assertSerializesTo(model, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnrelatedCommentBeforeRemovedElement() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("events");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo Bar");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//unrelated comment before deleted element");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Baz Fizzle");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      _builder.append("commands");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      EObject _model = this.getModel(_builder.toString());
      final Statemachine model = ((Statemachine) _model);
      EList<Event> _events = model.getEvents();
      _events.remove(1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("events");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo Bar");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("//unrelated comment before deleted element");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.append("commands");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      this.assertSerializesTo(model, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRemoveElementAfterInlineComment() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("events");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo Bar //inline comment before deleted element");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Baz Fizzle");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      _builder.append("commands");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      EObject _model = this.getModel(_builder.toString());
      final Statemachine model = ((Statemachine) _model);
      EList<Event> _events = model.getEvents();
      _events.remove(1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("events");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo Bar //inline comment before deleted element");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.append("commands");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      this.assertSerializesTo(model, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRemoveElementWithInlineComment() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("events");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo Bar");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Baz Fizzle //inline comment after deleted element");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      _builder.append("commands");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      EObject _model = this.getModel(_builder.toString());
      final Statemachine model = ((Statemachine) _model);
      EList<Event> _events = model.getEvents();
      _events.remove(1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("events");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo Bar");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.append("commands");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      this.assertSerializesTo(model, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRemoveElementInSameLine() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("events");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo Bar /* the foo */ Baz Fizzle");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      _builder.append("commands");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      EObject _model = this.getModel(_builder.toString());
      final Statemachine model = ((Statemachine) _model);
      EList<Event> _events = model.getEvents();
      _events.remove(1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("events");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo Bar /* the foo */");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.append("commands");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      this.assertSerializesTo(model, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAddElementBeforeCommentedElement() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("events");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//the comment");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo Bar");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      _builder.append("commands");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      EObject _model = this.getModel(_builder.toString());
      final Statemachine model = ((Statemachine) _model);
      Event _createEvent = FowlerdslFactory.eINSTANCE.createEvent();
      final Procedure1<Event> _function = new Procedure1<Event>() {
        public void apply(final Event it) {
          it.setName("Baz");
          it.setCode("Fizzle");
        }
      };
      final Event event = ObjectExtensions.<Event>operator_doubleArrow(_createEvent, _function);
      EList<Event> _events = model.getEvents();
      _events.add(0, event);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("events Baz Fizzle");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("//the comment");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo Bar");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      _builder_1.append("commands");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      this.assertSerializesTo(model, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void assertSerializesTo(final Statemachine model, final CharSequence expectation) {
    String _string = expectation.toString();
    String _serialize = this.serialize(model);
    Assert.assertEquals(_string, _serialize);
  }
}
