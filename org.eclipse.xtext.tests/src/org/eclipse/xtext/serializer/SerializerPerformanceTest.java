/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.serializer;

import java.util.concurrent.TimeUnit;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.serializer.hiddentokensequencertest.Entity;
import org.eclipse.xtext.serializer.hiddentokensequencertest.Model;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(HiddenTokenSequencerTestLanguageInjectorProvider.class)
public class SerializerPerformanceTest {
	@Inject
	private ParseHelper<Model> parseHelper;

	@Inject
	private ISerializer serializer;

	@Rule
	public Timeout timeout = new Timeout(5000, TimeUnit.MILLISECONDS);

	private static int numberOfElements = 1000;

	private static int editEvery = 100;

	private Model model;

	@Before
	public void setup() throws Exception {
		StringBuilder builder = new StringBuilder();
		builder.append("entities\n");
		for (int i = 0; i < numberOfElements; i++) {
			builder.append("	//comment before element\n");
			builder.append("	Foo /* comment between elements*/ \"Bar\" //comment after element \n");
		}
		builder.append("end\n");
		model = parseHelper.parse(builder.toString());
		EList<Entity> entities = model.getDomainModel().getEntities();
		Iterable<Entity> removeUs = Iterables.transform(
				Iterables.filter(new ExclusiveRange(0, SerializerPerformanceTest.numberOfElements, true),
						it -> it.intValue() % SerializerPerformanceTest.editEvery == 0),
				it -> entities.get(it.intValue()));
		Iterables.removeAll(entities, Sets.newHashSet(removeUs));
	}

	@Test
	public void test() {
		serializer.serialize(model);
	}
}
