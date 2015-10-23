/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.util.CancelIndicator;

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
	
	public void generate(Resource input, IFileSystemAccess2 fsa, CancelIndicator cancelIndicator) {
		try {
			beforeGenerate(input, fsa, cancelIndicator);
			doGenerate(input, fsa, cancelIndicator);
		} finally {
			afterGenerate(input, fsa, cancelIndicator);
		}
	}

	@Override
	public void doGenerate(Resource input, IFileSystemAccess2 fsa, CancelIndicator cancelIndicator) {
		if (generator != null) {
			generator.doGenerate(input, fsa, cancelIndicator);
		} else if (getLegacyGenerator() != null) {
			getLegacyGenerator().doGenerate(input, fsa);
		}
	}

	@Override
	public void beforeGenerate(Resource input, IFileSystemAccess2 fsa, CancelIndicator cancelIndicator) {
		if (generator != null) {
			generator.beforeGenerate(input, fsa, cancelIndicator);
		}
	}

	@Override
	public void afterGenerate(Resource input, IFileSystemAccess2 fsa, CancelIndicator cancelIndicator) {
		if (generator != null) {
			generator.afterGenerate(input, fsa, cancelIndicator);
		}
	}

	@Override
	public void doGenerate(Resource input, IFileSystemAccess fsa) {
		IFileSystemAccess2 casted = (IFileSystemAccess2) fsa;
		try {
			beforeGenerate(input, casted, CancelIndicator.NullImpl);
			doGenerate(input, casted, CancelIndicator.NullImpl);
		} finally {
			afterGenerate(input, casted, CancelIndicator.NullImpl);
		}
	}
}
