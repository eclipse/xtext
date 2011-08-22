/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.tests;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.builder.tests.builderTestLanguage.Element;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class MyGenerator implements IGenerator {

	/**
	 * poor man's generator used in {@link org.eclipse.xtext.builder.impl.BuilderParticipantTest}
	 */
	public void doGenerate(Resource input, IFileSystemAccess fsa) {
		Element ele = (Element) input.getContents().get(0);
		fsa.generateFile(ele.getName()+".txt", "object "+ele.getName());
		
	}

}
