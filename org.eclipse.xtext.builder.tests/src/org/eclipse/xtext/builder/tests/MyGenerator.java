/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.builder.tests;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.builder.tests.builderTestLanguage.Element;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGenerator;

public class MyGenerator implements IGenerator {
	@Override
	public void doGenerate(Resource input, IFileSystemAccess fsa) {
		TreeIterator<EObject> allContents = input.getAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			if (next instanceof Element) {
				Element ele = (Element) next;
				String fileName = ele.getName() + ".txt";
				if (fsa instanceof IFileSystemAccess2) {
					IFileSystemAccess2 fileSystemAccess2 = (IFileSystemAccess2) fsa;
					if (fileSystemAccess2.isFile(fileName)) {
						fileSystemAccess2.readTextFile(fileName);
					}
				}
				fsa.generateFile(fileName, "object " + ele.getName());
			}
		}
	}
}
