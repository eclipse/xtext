/*
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.generator;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
public class IndentationAwareUiTestLanguageGenerator extends AbstractGenerator {

	@Override
	public void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
//		Iterator<Greeting> filtered = Iterators.filter(resource.getAllContents(), Greeting.class);
//		Iterator<String> names = Iterators.transform(filtered, new Function<Greeting, String>() {
//
//			@Override
//			public String apply(Greeting greeting) {
//				return greeting.getName();
//			}
//		});
//		fsa.generateFile("greetings.txt", "People to greet: " + IteratorExtensions.join(names, ", "));
	}
}
