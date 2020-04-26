/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.index;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.index.indexTestLanguage.Entity;

public class IndexTestLanguageGenerator extends AbstractGenerator {
	@Override
	public void doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		TreeIterator<EObject> iter = input.getAllContents();
		while (iter.hasNext()) {
			EObject e = iter.next();
			if (e instanceof Entity) {
				Entity entity = (Entity) e;
				StringConcatenation builder = new StringConcatenation();
				builder.append("Hello ");
				builder.append(entity.getName());
				builder.append("!");
				builder.newLineIfNotEmpty();
				fsa.generateFile(entity.getName() + ".txt", builder);
			}
		}
	}
}
