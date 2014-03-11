/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder;

import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;

import com.google.inject.ImplementedBy;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
@ImplementedBy(ProjectRootAsSourceFolderProvider.class)
public interface EclipseSourceFolderProvider {

	List<? extends IContainer> getSourceFolders(IProject project);

}
