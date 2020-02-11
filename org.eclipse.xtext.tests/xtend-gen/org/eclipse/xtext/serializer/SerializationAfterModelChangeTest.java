/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.serializer;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.serializer.HiddenTokenSequencerTestLanguageInjectorProvider;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.hiddentokensequencertest.Entity;
import org.eclipse.xtext.serializer.hiddentokensequencertest.HiddentokensequencertestFactory;
import org.eclipse.xtext.serializer.hiddentokensequencertest.Model;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=424027
 */
@RunWith(XtextRunner.class)
@InjectWith(HiddenTokenSequencerTestLanguageInjectorProvider.class)
@SuppressWarnings("all")
public class SerializationAfterModelChangeTest {
  @Inject
  @Extension
  private ParseHelper<Model> _parseHelper;
  
  @Inject
  @Extension
  private ISerializer _iSerializer;
  
  @Test
  public void smokeTest() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("entities");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//before existing element");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo /* within existing element */ \"Bar\" /* after existing element*/");
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
      _builder.append("Baz \"Fizzle\" /* after deleted element */");
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
      _builder.append("Blurb /* a comment within a deleted element */ \"Bla\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//before inserted element");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      final Model model = this._parseHelper.parse(_builder);
      Entity _createEntity = HiddentokensequencertestFactory.eINSTANCE.createEntity();
      final Procedure1<Entity> _function = (Entity it) -> {
        it.setName("AAA");
        it.setDescription("BBB");
      };
      final Entity event = ObjectExtensions.<Entity>operator_doubleArrow(_createEntity, _function);
      model.getDomainModel().getEntities().remove(1);
      model.getDomainModel().getEntities().remove(1);
      model.getDomainModel().getEntities().add(event);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("entities");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("//before existing element");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo /* within existing element */ \"Bar\" /* after existing element*/");
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
      _builder_1.append("AAA \"BBB\" end");
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
      _builder.append("entities");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo \"Bar\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//comment between elements");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Baz \"Fizzle\"");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      final Model model = this._parseHelper.parse(_builder);
      final Entity head = IterableExtensions.<Entity>head(model.getDomainModel().getEntities());
      model.getDomainModel().getEntities().move(1, head);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("entities");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Baz \"Fizzle\"");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("//comment between elements");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo \"Bar\"");
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
      _builder.append("entities");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo \"Bar\"");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      final Model model = this._parseHelper.parse(_builder);
      Entity _createEntity = HiddentokensequencertestFactory.eINSTANCE.createEntity();
      final Procedure1<Entity> _function = (Entity it) -> {
        it.setName("Baz");
        it.setDescription("Fizzle");
      };
      final Entity event = ObjectExtensions.<Entity>operator_doubleArrow(_createEntity, _function);
      model.getDomainModel().getEntities().add(event);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("entities");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo \"Bar\"");
      _builder_1.newLine();
      _builder_1.append("Baz \"Fizzle\" end");
      this.assertSerializesTo(model, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCommentBeforeInsertedElement() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("entities");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo \"Bar\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//comment before inserted element");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      final Model model = this._parseHelper.parse(_builder);
      Entity _createEntity = HiddentokensequencertestFactory.eINSTANCE.createEntity();
      final Procedure1<Entity> _function = (Entity it) -> {
        it.setName("Baz");
        it.setDescription("Fizzle");
      };
      final Entity event = ObjectExtensions.<Entity>operator_doubleArrow(_createEntity, _function);
      model.getDomainModel().getEntities().add(event);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("entities");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo \"Bar\"");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("//comment before inserted element");
      _builder_1.newLine();
      _builder_1.append("Baz \"Fizzle\" end");
      this.assertSerializesTo(model, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAddElementAfterInlineComment() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("entities");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo \"Bar\"\t//inline comment before inserted element");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      final Model model = this._parseHelper.parse(_builder);
      Entity _createEntity = HiddentokensequencertestFactory.eINSTANCE.createEntity();
      final Procedure1<Entity> _function = (Entity it) -> {
        it.setName("Baz");
        it.setDescription("Fizzle");
      };
      final Entity event = ObjectExtensions.<Entity>operator_doubleArrow(_createEntity, _function);
      model.getDomainModel().getEntities().add(event);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("entities");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo \"Bar\"\t//inline comment before inserted element");
      _builder_1.newLine();
      _builder_1.append("Baz \"Fizzle\" end");
      this.assertSerializesTo(model, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCommentOnRemovedElement() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("entities");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo \"Bar\" //inline comment before deleted element");
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
      _builder.append("Baz \"Fizzle\"");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      final Model model = this._parseHelper.parse(_builder);
      model.getDomainModel().getEntities().remove(1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("entities");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo \"Bar\" //inline comment before deleted element");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("end");
      this.assertSerializesTo(model, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testUnrelatedCommentBeforeRemovedElement() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("entities");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo \"Bar\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//unrelated comment before deleted element");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Baz \"Fizzle\"");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      final Model model = this._parseHelper.parse(_builder);
      model.getDomainModel().getEntities().remove(1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("entities");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo \"Bar\"");
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
      this.assertSerializesTo(model, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRemoveElementAfterInlineComment() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("entities");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo \"Bar\" //inline comment before deleted element");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Baz \"Fizzle\"");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      final Model model = this._parseHelper.parse(_builder);
      model.getDomainModel().getEntities().remove(1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("entities");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo \"Bar\" //inline comment before deleted element");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("end");
      this.assertSerializesTo(model, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRemoveElementWithInlineComment() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("entities");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo \"Bar\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Baz \"Fizzle\" //inline comment after deleted element");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      final Model model = this._parseHelper.parse(_builder);
      model.getDomainModel().getEntities().remove(1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("entities");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo \"Bar\"");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("end");
      this.assertSerializesTo(model, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRemoveElementInSameLine() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("entities");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo \"Bar\" /* the foo */ Baz \"Fizzle\"");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      final Model model = this._parseHelper.parse(_builder);
      model.getDomainModel().getEntities().remove(1);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("entities");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo \"Bar\" /* the foo */");
      _builder_1.newLine();
      _builder_1.append("end");
      this.assertSerializesTo(model, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAddElementBeforeCommentedElement() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("entities");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("//the comment");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo \"Bar\"");
      _builder.newLine();
      _builder.append("end");
      _builder.newLine();
      final Model model = this._parseHelper.parse(_builder);
      Entity _createEntity = HiddentokensequencertestFactory.eINSTANCE.createEntity();
      final Procedure1<Entity> _function = (Entity it) -> {
        it.setName("Baz");
        it.setDescription("Fizzle");
      };
      final Entity event = ObjectExtensions.<Entity>operator_doubleArrow(_createEntity, _function);
      model.getDomainModel().getEntities().add(0, event);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("entities Baz \"Fizzle\"");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("//the comment");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo \"Bar\"");
      _builder_1.newLine();
      _builder_1.append("end");
      _builder_1.newLine();
      this.assertSerializesTo(model, _builder_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void assertSerializesTo(final Model model, final CharSequence expectation) {
    Assert.assertEquals(expectation.toString(), this._iSerializer.serialize(model));
  }
}
