/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace

import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Data

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
abstract class AbstractURIWrapper {
	URI URI
	
	override toString() {
		return URI.toString
	}
}

/**
 * A source relative URI.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class SourceRelativeURI extends AbstractURIWrapper {
	new(URI sourceRelativeURI) {
		super(sourceRelativeURI)
		if (!sourceRelativeURI.isRelative) {
			throw new IllegalArgumentException(String.valueOf(sourceRelativeURI))
		}
	}
	
	override equals(Object obj) {
		if (obj !== null && obj.getClass == AbsoluteURI) {
			throw new IllegalArgumentException(String.valueOf(obj))
		}
		return super.equals(obj)
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class AbsoluteURI extends AbstractURIWrapper {
	new(URI absoluteURI) {
		super(absoluteURI)
		if (absoluteURI.isRelative) {
			throw new IllegalArgumentException(String.valueOf(absoluteURI))
		}
	}
	
	override equals(Object obj) {
		if (obj !== null && obj.getClass == SourceRelativeURI) {
			throw new IllegalArgumentException(String.valueOf(obj))
		}
		return super.equals(obj)
	}
	
}