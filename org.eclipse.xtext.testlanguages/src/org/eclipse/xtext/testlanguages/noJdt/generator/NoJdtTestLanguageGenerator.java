/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.noJdt.generator;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.testlanguages.noJdt.noJdt.Greeting;
import org.eclipse.xtext.util.Strings;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
public class NoJdtTestLanguageGenerator extends AbstractGenerator {

	@Inject private IEObjectDocumentationProvider documentationProvider;
	
	@Override
	public void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		Iterable<Greeting> filtered = ()->Iterators.filter(resource.getAllContents(), Greeting.class);
		List<String> names = Lists.newArrayList(Iterables.transform(filtered, new Function<Greeting, String>() {
			@Override
			public String apply(Greeting greeting) {
				return greeting.getName();
			}
		}));
		String fileName = resource.getURI().lastSegment();
		if(fileName == null) fileName = "greetings";
		String prefix = "";
		Greeting firstGreeting = Iterables.getFirst(filtered, null);
		if (firstGreeting != null) {
			String documentation = documentationProvider.getDocumentation(firstGreeting);
			if (documentation != null && documentation.contains("@Timestamp")) {
				prefix = "@" + System.currentTimeMillis() + Strings.newLine();
			}
		}
		fsa.generateFile(fileName+".txt", prefix + "People to greet: " + String.join(", ", names));
	}
}
