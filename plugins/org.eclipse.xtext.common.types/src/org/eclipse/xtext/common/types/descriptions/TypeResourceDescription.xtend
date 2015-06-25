/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.descriptions

import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.impl.AbstractResourceDescription
import org.eclipse.xtext.resource.impl.ChangedResourceDescriptionDelta
import org.eclipse.xtext.util.Strings

/**
 * More or less copied from NameBasedResourceDescription and TypeResourceDescription
 * to avoid dependency on common.types.ui
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
class TypeResourceDescription extends AbstractResourceDescription {
	
	static class ChangedDelta extends ChangedResourceDescriptionDelta {
	
		new(QualifiedName javaTypeName) {
			super(null, new TypeResourceDescription(javaTypeName))
		}
	}
	
	List<IEObjectDescription> exportedObjects
	
	URI uri
	
	new(QualifiedName typeName) {
		uri = URIHelperConstants.OBJECTS_URI.appendSegment(typeName.toString('.'))
		exportedObjects = #[new ClassDescription(typeName)]
	}
	
	override protected computeExportedObjects() {
		exportedObjects
	}
	
	override getImportedNames() {
		#[]
	}
	
	override getReferenceDescriptions() {
		#[]
	}
	
	override getURI() {
		uri
	}

	@Data	
	static class ClassDescription implements IEObjectDescription {
		
		val QualifiedName qualifiedName
		
		override getEClass() {
			null
		}
		
		override getEObjectOrProxy() {
			throw new UnsupportedOperationException("TODO: auto-generated method stub")
		}
		
		override getEObjectURI() {
			throw new UnsupportedOperationException("TODO: auto-generated method stub")
		}
		
		override getName() {
			qualifiedName
		}
		
		override getUserData(String key) {
			null
		}
		
		override getUserDataKeys() {
			Strings.EMPTY_ARRAY
		}
	}
}
