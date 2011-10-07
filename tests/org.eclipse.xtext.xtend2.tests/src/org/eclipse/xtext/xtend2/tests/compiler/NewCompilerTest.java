/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.compiler;

import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class NewCompilerTest extends CompilerTest {

	@Inject
	protected JvmModelGenerator generator;

	@Inject
	private IXtend2JvmAssociations associations;
	
	@Override
	protected String compileToJavaCode(String xtendCode) {
		try {
			XtendFile file = parseHelper.parse(xtendCode);
			validationHelper.assertNoErrors(file);
			JvmGenericType inferredType = associations.getInferredType(file.getXtendClass());
			StringConcatenation javaCode = generator.generateType(inferredType);
			return javaCode.toString();
		} catch (Exception exc) {
			throw new RuntimeException("Xtend compilation failed:\n" + xtendCode, exc);
		}
	}

}
