/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.serializer

import com.google.inject.Inject
import com.google.inject.name.Named

/**
 * @author Moritz Eyshold - Initial contribution and API 
 * @author Jan Koehnlein
 */
class SemanticSequencer extends GeneratedFile {
	
	@Inject SerializerGenFileNames names
	
	@Inject@Named("generateXtendStub") Boolean generateXtendStub
	
	@Inject@Named("fileHeader") String fileHeader
	
	override CharSequence getFileContents(SerializerGenFileNames$GenFileName filename) {
		if(generateXtendStub) '''
			/*
			 «fileHeader»
			 */
			package «filename.packageName»
			
			class «filename.simpleName» extends «names.abstractSemanticSequencer.simpleName» {
			}
		''' else '''
			/*
			 «fileHeader»
			 */
			package «filename.packageName»;
			
			public class «filename.simpleName» extends «names.abstractSemanticSequencer.simpleName» {
			}
		''' 
	}
}