/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary.signatures;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.Signature;
import org.eclipse.xtext.common.types.access.binary.BinaryClass;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.5
 */
public class SignatureURIHelper implements URIHelperConstants {

	public URI createResourceURI(BinaryClass binary) {
		if (binary.isArray()) {
			return createResourceURI(binary.getRootComponentType());
		}
		if (binary.isPrimitive()) {
			return URIHelperConstants.PRIMITIVES_URI;
		} else {
			return URIHelperConstants.OBJECTS_URI.appendSegment(binary.getOutermostClassName());
		}
	}
	
	protected StringBuilder createURIBuilder() {
		StringBuilder builder = new StringBuilder(48);
		builder.append(URIHelperConstants.PROTOCOL);
		builder.append(':');
		return builder;
	}

	protected URI createURI(StringBuilder uriBuilder) {
		return URI.createURI(uriBuilder.toString());
	}

	public URI getFullURI(char[] signature) {
		StringBuilder uriBuilder = createURIBuilder();
		createResourceURI(signature, uriBuilder);
		uriBuilder.append('#');
		createFragment(signature, uriBuilder);
		return createURI(uriBuilder);
	}
	
	public String getFragment(BinaryClass type) {
		StringBuilder uriBuilder = new StringBuilder(32);
		createFragment(type, uriBuilder);
		return uriBuilder.toString();
	}

	protected void createFragment(BinaryClass type, StringBuilder uriBuilder) {
		if (type.isArray()) {
			uriBuilder.append(type.getRootComponentType().getName());
			for(int i = 0; i < type.getArrayDimensions(); i++) {
				uriBuilder.append("[]");
			}
		} else {
			uriBuilder.append(type.getName());
		}
	}

	protected void createFragment(char[] signature, StringBuilder uriBuilder) {
		char[] elementType = Signature.getElementType(signature);
		if (elementType != signature) {
			createFragment(elementType, uriBuilder);
			int dim = Signature.getArrayCount(signature);
			for(int i = 0; i < dim; i++) {
				uriBuilder.append("[]");
			}
		} else {
			if (elementType.length == 1) {
				switch(elementType[0]) {
					case 'B':
						uriBuilder.append("byte");
						return;
					case 'C':
						uriBuilder.append("char");
						return;
					case 'D':
						uriBuilder.append("double");
						return;
					case 'F':
						uriBuilder.append("float");
						return;
					case 'I':
						uriBuilder.append("int");
						return;
					case 'J':
						uriBuilder.append("long");
						return;
					case 'S':
						uriBuilder.append("short");
						return;
					case 'Z':
						uriBuilder.append("boolean");
						return;
					case 'V':
						uriBuilder.append("void");
						return;
				}
			}
			uriBuilder.append(signature);
		}
	}

	protected void createResourceURI(char[] signature, StringBuilder uriBuilder) {
		char[] erasure = Signature.getTypeErasure(signature);
		char[] elementType = Signature.getElementType(erasure);
		if (elementType.length == 1) {
			switch(elementType[0]) {
				case 'B':
				case 'C':
				case 'D':
				case 'F':
				case 'I':
				case 'J':
				case 'S':
				case 'Z':
				case 'V': {
					uriBuilder.append(URIHelperConstants.PRIMITIVES);
					return;
				}
			}
		}
		uriBuilder.append(Signature.toCharArray(elementType));
	}

}
