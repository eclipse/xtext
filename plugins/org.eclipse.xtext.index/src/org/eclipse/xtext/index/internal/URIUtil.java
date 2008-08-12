/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.index.internal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class URIUtil {

	public static URI createContainerURI(IProject project) {
		return URI.createPlatformResourceURI(project.getFullPath().toString(), true);
	}
	
	public static List<URI> createURIsFromResult(ResultSet result) throws SQLException {
		List<URI> uris = new ArrayList<URI>();
		while (result.next()) {
			StringBuffer uriBuffer = new StringBuffer();
			uriBuffer.append(result.getString(1));
			uriBuffer.append('/');
			uriBuffer.append(result.getString(2));
			uriBuffer.append('#');
			uriBuffer.append(result.getString(3));
			URI uri = URI.createURI(uriBuffer.toString());
			uris.add(uri);
		}
		return uris;
	}

	public static String getURI(EObject eObject) {
		return EcoreUtil.getURI(eObject).toString();
	}
	
	public static String trimTrailingSlash(URI uri) {
		String uriString = uri.toString();
		return trimTrailingSlash(uriString);
	}

	public static String trimTrailingSlash(String uriString) {
		if(uriString.endsWith("/")) {
			uriString = uriString.substring(0, uriString.length()-1);
		}
		return uriString;
	}
	
	public static String trimLeadingSlash(String pathString) {
		if(pathString.startsWith("/")) {
			pathString = pathString.substring(1);
		}
		return pathString;
	}
	
	public static URI createResourceContainerURI(String uriString) {
		if(uriString.startsWith("jar:") && uriString.endsWith("!")) {
			uriString += "/";
		}
		return URI.createURI(uriString);
	}
}
