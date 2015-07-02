/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.facet

import org.eclipse.xtext.idea.facet.GeneratorConfigurationState
import org.eclipse.xtext.generator.OutputConfiguration

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class XbaseGeneratorConfigurationState extends GeneratorConfigurationState {
	
	new() {}
	
	new(OutputConfiguration defOutput) {
		super(defOutput)
	}
	
}