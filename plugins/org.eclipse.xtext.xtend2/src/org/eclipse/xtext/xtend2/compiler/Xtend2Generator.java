/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.compiler;

import java.io.StringWriter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Xtend2Generator implements IGenerator {
	
	@Inject
	private Xtend2Compiler compiler;
	
	public void doGenerate(Resource input, IFileSystemAccess fsa) {
		if (input == null || input.getContents().size() < 2)
			return;
		Object contents = input.getContents().get(0);
		if (!(contents instanceof XtendFile)) 
			return;
		final EObject derived = input.getContents().get(1);
		if (!(derived instanceof JvmType))
			return;
		JvmType derivedType = (JvmType) derived;
		XtendFile file = (XtendFile) contents;
		final StringWriter writer = new StringWriter();
		compiler.compile(file, writer);
		final String fileName = derivedType.getIdentifier().replace('.', '/')+".java";
		fsa.generateFile(fileName, writer.getBuffer().toString());
	}

}
