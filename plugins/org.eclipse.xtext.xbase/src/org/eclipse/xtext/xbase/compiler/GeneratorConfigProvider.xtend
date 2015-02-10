/** 
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.compiler

import java.util.Iterator
import org.eclipse.emf.common.notify.Adapter
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

/** 
 * @author Holger Schill - Initial contribution and API
 * @author Moritz Eysholdt - introduced adapter
 */
class GeneratorConfigProvider implements IGeneratorConfigProvider {
	@FinalFieldsConstructor @Accessors protected static class ConfigAdapter extends AdapterImpl {
		val GeneratorConfig config
		
		override isAdapterForType(Object type) {
			type === ConfigAdapter
		}
	}

	def static void install(ResourceSet resourceSet, GeneratorConfig config) {
		var EList<Adapter> adapters = resourceSet.eAdapters
		var Iterator<Adapter> iterator = adapters.iterator
		while (iterator.hasNext)
			if(iterator.next instanceof ConfigAdapter) iterator.remove()
		adapters += new ConfigAdapter(config)
	}

	@Override override GeneratorConfig get(EObject context) {
		val adapters = context?.eResource?.resourceSet?.eAdapters() ?: emptyList
		adapters.filter(ConfigAdapter).head?.config ?: new GeneratorConfig()
	}
}
