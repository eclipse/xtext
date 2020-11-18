/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.serializer;

import org.eclipse.xtext.serializer.hiddentokensequencertest.Entity;
import org.eclipse.xtext.serializer.hiddentokensequencertest.HiddentokensequencertestFactory;
import org.eclipse.xtext.serializer.hiddentokensequencertest.Model;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.util.Strings;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=424027
 */
@RunWith(XtextRunner.class)
@InjectWith(HiddenTokenSequencerTestLanguageInjectorProvider.class)
public class SerializationAfterModelChangeTest {
	@Inject
	private ParseHelper<Model> parseHelper;

	@Inject
	private ISerializer serializer;

	@Test
	public void smokeTest() throws Exception {
		Model model = parseHelper.parse(
				"entities\n" +
				"	//before existing element\n" +
				"	Foo /* within existing element */ \"Bar\" /* after existing element*/\n" +
				"	\n" +
				"	//unrelated comment\n" +
				"	\n" +
				"	//before deleted element\n" +
				"	Baz \"Fizzle\" /* after deleted element */\n" +
				"	\n" +
				"	//between deleted elements\n" +
				"	\n" +
				"	//another deleted element\n" +
				"	Blurb /* a comment within a deleted element */ \"Bla\"\n" +
				"	\n" +
				"	//before inserted element\n" +
				"end\n");
		Entity event = HiddentokensequencertestFactory.eINSTANCE.createEntity();
		event.setName("AAA");
		event.setDescription("BBB");
		model.getDomainModel().getEntities().remove(1);
		model.getDomainModel().getEntities().remove(1);
		model.getDomainModel().getEntities().add(event);
		assertSerializesTo(model,
				"entities\n" +
				"	//before existing element\n" +
				"	Foo /* within existing element */ \"Bar\" /* after existing element*/\n" +
				"	\n" +
				"	//unrelated comment\n" +
				"	\n" +
				"	\n" +
				"	\n" +
				"	//between deleted elements\n" +
				"	\n" +
				"	\n" +
				"	\n" +
				"	//before inserted element\n" +
				"AAA \"BBB\" end");
	}

	/**
	 * TODO does not work yet, because HiddenTokenSequencer always searches in
	 * one direction, but the order of the elements has changed here.
	 */
	@Test
	@Ignore
	public void testMoveElement() throws Exception {
		Model model = parseHelper.parse(
				"entities\n" +
				"	Foo \"Bar\"\n" +
				"\n	//comment between elements\n" +
				"	\n" +
				"	Baz \"Fizzle\"\n" +
				"end\n");
		Entity head = Iterables.getFirst(model.getDomainModel().getEntities(), null);
		model.getDomainModel().getEntities().move(1, head);
		assertSerializesTo(model,
				"entities\n" +
				"	Baz \"Fizzle\"\n" +
				"\n	//comment between elements\n" +
				"	\n" +
				"	Foo \"Bar\"\n" +
				"end\n");
	}

	@Test
	public void testWhiteSpaceOnly() throws Exception {
		Model model = parseHelper.parse(
				"entities\n" +
				"	Foo \"Bar\"\n" +
				"end\n");
		Entity event = HiddentokensequencertestFactory.eINSTANCE.createEntity();
		event.setName("Baz");
		event.setDescription("Fizzle");
		model.getDomainModel().getEntities().add(event);
		assertSerializesTo(model,
				"entities\n" +
				"	Foo \"Bar\"\n" +
				"Baz \"Fizzle\" end");
	}

	@Test
	public void testCommentBeforeInsertedElement() throws Exception {
		Model model = parseHelper.parse(
				"entities\n" +
				"	Foo \"Bar\"\n" +
				"	\n" +
				"	//comment before inserted element\n" +
				"end\n");
		Entity event = HiddentokensequencertestFactory.eINSTANCE.createEntity();
		event.setName("Baz");
		event.setDescription("Fizzle");
		model.getDomainModel().getEntities().add(event);
		assertSerializesTo(model,
				"entities\n" +
				"	Foo \"Bar\"\n" +
				"	\n" +
				"	//comment before inserted element\n" +
				"Baz \"Fizzle\" end");
	}

	@Test
	public void testAddElementAfterInlineComment() throws Exception {
		Model model = parseHelper.parse(
				"entities\n" +
				"	Foo \"Bar\"	//inline comment before inserted element\n" +
				"end\n");
		Entity event = HiddentokensequencertestFactory.eINSTANCE.createEntity();
		event.setName("Baz");
		event.setDescription("Fizzle");
		model.getDomainModel().getEntities().add(event);
		assertSerializesTo(model,
				"entities\n" +
				"	Foo \"Bar\"	//inline comment before inserted element\n" +
				"Baz \"Fizzle\" end");
	}

	@Test
	public void testCommentOnRemovedElement() throws Exception {
		Model model = parseHelper.parse(
				"entities\n" +
				"	Foo \"Bar\" //inline comment before deleted element\n" +
				"	//comment on deleted element\n" +
				"	/**\n" +
				"	 * another comment on the deleted element\n" +
				"	 */\n" +
				"	Baz \"Fizzle\"\n" +
				"end\n");
		model.getDomainModel().getEntities().remove(1);
		assertSerializesTo(model,
				"entities\n" +
				"	Foo \"Bar\" //inline comment before deleted element\n" +
				"\nend");
	}

	@Test
	public void testUnrelatedCommentBeforeRemovedElement() throws Exception {
		Model model = parseHelper.parse(
				"entities\n" +
				"	Foo \"Bar\"\n" +
				"	\n" +
				"	//unrelated comment before deleted element\n" +
				"	\n" +
				"	Baz \"Fizzle\"\n" +
				"end\n");
		model.getDomainModel().getEntities().remove(1);
		assertSerializesTo(model,
				"entities\n" +
				"	Foo \"Bar\"\n" +
				"	\n" +
				"	//unrelated comment before deleted element\n" +
				"	\n" +
				"	\n" +
				"end");
	}

	@Test
	public void testRemoveElementAfterInlineComment() throws Exception {
		Model model = parseHelper.parse(
				"entities\n" +
				"	Foo \"Bar\" //inline comment before deleted element\n" +
				"	\n" +
				"	Baz \"Fizzle\"\n" +
				"end\n");
		model.getDomainModel().getEntities().remove(1);
		assertSerializesTo(model,
				"entities\n" +
				"	Foo \"Bar\" //inline comment before deleted element\n" +
				"	\n" +
				"	\n" +
				"end");
	}

	@Test
	public void testRemoveElementWithInlineComment() throws Exception {
		Model model = parseHelper.parse(
				"entities\n" +
				"	Foo \"Bar\"\n" +
				"	\n" +
				"	Baz \"Fizzle\" //inline comment after deleted element\n" +
				"end\n");
		model.getDomainModel().getEntities().remove(1);
		assertSerializesTo(model,
				"entities\n" +
				"	Foo \"Bar\"\n" +
				"	\n" +
				"	end");
	}

	@Test
	public void testRemoveElementInSameLine() throws Exception {
		Model model = parseHelper.parse(
				"entities\n" +
				"	Foo \"Bar\" /* the foo */ Baz \"Fizzle\"\n" +
				"end\n");
		model.getDomainModel().getEntities().remove(1);
		assertSerializesTo(model,
				"entities\n" +
				"	Foo \"Bar\" /* the foo */\n" +
				"end");
	}

	@Test
	public void testAddElementBeforeCommentedElement() throws Exception {
		Model model = parseHelper.parse(
				"entities\n" +
				"	//the comment\n" +
				"	Foo \"Bar\"\n" +
				"end\n");
		Entity event = HiddentokensequencertestFactory.eINSTANCE.createEntity();
		event.setName("Baz");
		event.setDescription("Fizzle");
		model.getDomainModel().getEntities().add(0, event);
		assertSerializesTo(model,
				"entities Baz \"Fizzle\"\n" +
				"	//the comment\n" +
				"	Foo \"Bar\"\n" +
				"end\n");
	}

	private void assertSerializesTo(Model model, CharSequence expectation) {
		Assert.assertEquals(expectation.toString(), Strings.toUnixLineSeparator(serializer.serialize(model)));
	}
}
