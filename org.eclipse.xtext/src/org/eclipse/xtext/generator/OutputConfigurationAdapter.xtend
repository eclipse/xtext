/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator

import java.util.Set
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.xtend.lib.annotations.Data
import java.util.Map

/**
 * @noreference
 */
@Data
class OutputConfigurationAdapter extends AdapterImpl {
	Map<String, Set<OutputConfiguration>> outputConfigurationsPerLanguage 
	
	override isAdapterForType(Object type) {
		type == OutputConfigurationAdapter
	}
	
}