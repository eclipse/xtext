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
import org.eclipse.xtext.workspace.ISourceFolder
import org.eclipse.xtext.workspace.IProjectConfig
import org.eclipse.xtext.workspace.IWorkspaceConfig

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
	def static fromAbsolute(URI uri) {
		if (uri.isRelative) {
			throw new IllegalArgumentException(uri.toString)
		}
		return new SourceRelativeURI(uri.path.substring(1))
	} 
	new(URI sourceRelativeURI) {
		super(sourceRelativeURI)
		if (!sourceRelativeURI.isRelative || sourceRelativeURI.path.startsWith('/')) {
			throw new IllegalArgumentException(String.valueOf(sourceRelativeURI))
		}
	}
	new(String relativeURI) {
		this(URI::createURI(relativeURI));
	}
	
	override equals(Object obj) {
		if (obj !== null && obj.getClass != SourceRelativeURI) {
			throw new IllegalArgumentException(String.valueOf(obj) + " instanceof " + obj?.class?.name)
		}
		return super.equals(obj)
	}
}

/**
 * An absolute URI that allows to obtain a resource in a {@link IWorkspaceConfig workspace}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class AbsoluteURI extends AbstractURIWrapper {
	
	new(URI absoluteURI) {
		super(absoluteURI)
		if (absoluteURI.isRelative || !absoluteURI.isHierarchical) {
			throw new IllegalArgumentException(String.valueOf(absoluteURI))
		}
	}
	
	new(String absoluteURI) {
		this(URI::createURI(absoluteURI));
	}
	
	def deresolve(URI sourceFolderURI) {
		try {
			return new SourceRelativeURI(URI.deresolve(sourceFolderURI))
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Base URI was "+URI, e)
		}
	}
	
	def deresolve(ISourceFolder sourceFolder) {
		return deresolve(sourceFolder.getPath());
	}
	
	def deresolve(IProjectConfig projectConfig) {
		val sourceFolder = projectConfig.findSourceFolderContaining(URI);
		return sourceFolder?.deresolve
	}
	
	def deresolve(IWorkspaceConfig workspaceConfig) {
		val project = workspaceConfig.findProjectContaining(URI);
		return project?.deresolve
	}
	
	override equals(Object obj) {
		if (obj !== null && obj.getClass != AbsoluteURI) {
			throw new IllegalArgumentException(String.valueOf(obj) + " instanceof " + obj?.class?.name)
		}
		return super.equals(obj)
	}
	
}