/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.noJdt.generator;

import java.util.Iterator;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.testlanguages.noJdt.noJdt.Greeting;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
public class NoJdtTestLanguageGenerator extends AbstractGenerator {

	@Override
	public void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		Iterator<Greeting> filtered = Iterators.filter(resource.getAllContents(), Greeting.class);
		Iterator<String> names = Iterators.transform(filtered, new Function<Greeting, String>() {

			@Override
			public String apply(Greeting greeting) {
				return greeting.getName();
			}
		});
		String fileName = resource.getURI().lastSegment();
		if(fileName == null) fileName = "greetings";
		fsa.generateFile(fileName+".txt", "People to greet: " + IteratorExtensions.join(names, ", "));
	}
}
