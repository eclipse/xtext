/**
 * Copyright (c) 2009, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.builder.tests;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.builder.tests.builderTestLanguage.Element;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

import com.google.common.collect.Iterables;

public class MyGenerator implements IGenerator {
	@Override
	public void doGenerate(Resource input, IFileSystemAccess fsa) {
		for (Element ele : Iterables.filter(IteratorExtensions.toIterable(input.getAllContents()),
				Element.class)) {
			String fileName = ele.getName() + ".txt";
			if (fsa instanceof IFileSystemAccess2) {
				if (((IFileSystemAccess2) fsa).isFile(fileName)) {
					((IFileSystemAccess2) fsa).readTextFile(fileName);
				}
			}
			String content = "object " + ele.getName();
			if (ele.getReferences() != null) {
				content = content + " -> " + ele.getReferences().getName();
			}
			fsa.generateFile(fileName, content);
		}
	}
}
