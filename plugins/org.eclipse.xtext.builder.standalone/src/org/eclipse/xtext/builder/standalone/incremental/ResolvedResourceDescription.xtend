/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental

import com.google.common.collect.ImmutableList
import com.google.common.collect.Maps
import java.util.List
import java.util.Map
import org.apache.log4j.Logger
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.IReferenceDescription
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.impl.AbstractResourceDescription

/**
 * Copied from org.eclipse.xtext.builder.clustering.CopiedResourceDescription to avoid a 
 * dependency on org.eclipse.xtext.builder plug-in
 * 
 * @author koehnlein - Initial contribution and API
 */
class ResolvedResourceDescription extends AbstractResourceDescription {

	static val LOG = Logger.getLogger(ResolvedResourceDescription)

	@Accessors(PUBLIC_GETTER)
	URI URI

	ImmutableList<IEObjectDescription> exported

	new(IResourceDescription original) {
		this.URI = original.URI
		this.exported = ImmutableList.copyOf(
			original.exportedObjects.map[ IEObjectDescription from |
				if (from.EObjectOrProxy.eIsProxy) 
					return from
				var result = EcoreUtil.create(from.getEClass()) as InternalEObject
				result.eSetProxyURI(from.EObjectURI)
				var Map<String, String> userData = null
				for (key : from.userDataKeys) {
					if (userData == null) 
						userData = Maps.newHashMapWithExpectedSize(2)
					userData.put(key, from.getUserData(key))
				}
				return EObjectDescription.create(from.name, result, userData)
			])
	}

	override protected List<IEObjectDescription> computeExportedObjects() {
		return exported
	}

	override Iterable<QualifiedName> getImportedNames() {
		// TODO see https://bugs.eclipse.org/bugs/show_bug.cgi?id=344373
		var IllegalStateException exception = new IllegalStateException('''getImportedNames «URI»''')
		LOG.error(exception, exception)
		return emptyList
	}

	override Iterable<IReferenceDescription> getReferenceDescriptions() {
		// TODO see https://bugs.eclipse.org/bugs/show_bug.cgi?id=344373
		var IllegalStateException exception = new IllegalStateException('''getReferenceDescriptions «URI»''')
		LOG.error(exception, exception)
		return emptyList
	}
}