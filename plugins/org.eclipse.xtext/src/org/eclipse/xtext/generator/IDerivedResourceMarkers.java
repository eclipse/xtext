/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.3
 */
public interface IDerivedResourceMarkers {

	boolean installMarker(IFile file, String source) throws CoreException;

	String getSource(IMarker marker);

	IMarker findDerivedResourceMarker(IFile file, String source) throws CoreException;

	IMarker[] findDerivedResourceMarkers(IFile file) throws CoreException;

	List<IFile> findDerivedResources(IContainer container, String source) throws CoreException;

}
