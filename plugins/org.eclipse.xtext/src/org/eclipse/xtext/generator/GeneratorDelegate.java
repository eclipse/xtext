/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9
 */
public class GeneratorDelegate implements IGenerator, IGenerator2 {

	@Inject(optional = true)
	private IGenerator legacyGenerator;
	
	@Inject(optional = true)
	private IGenerator2 generator;
	
	public IGenerator getLegacyGenerator() {
		return legacyGenerator;
	}

	@Override
	public void doGenerate(Resource input, IFileSystemAccess2 fsa) {
		if (generator != null) {
			generator.doGenerate(input, fsa);
		} else if (getLegacyGenerator() != null) {
			getLegacyGenerator().doGenerate(input, fsa);
		}
	}

	@Override
	public void beforeGenerate(Resource input, IFileSystemAccess2 fsa) {
		if (generator != null) {
			generator.beforeGenerate(input, fsa);
		}
	}

	@Override
	public void afterGenerate(Resource input, IFileSystemAccess2 fsa) {
		if (generator != null) {
			generator.afterGenerate(input, fsa);
		}
	}
	
	public void generate(Resource input, IFileSystemAccess2 fsa) {
		try {
			beforeGenerate(input, fsa);
			doGenerate(input, fsa);
		} finally {
			afterGenerate(input, fsa);
		}
	}

	@Override
	public void doGenerate(Resource input, IFileSystemAccess fsa) {
		IFileSystemAccess2 casted = (IFileSystemAccess2) fsa;
		try {
			beforeGenerate(input, casted);
			doGenerate(input, casted);
		} finally {
			afterGenerate(input, casted);
		}
	}
	
}
