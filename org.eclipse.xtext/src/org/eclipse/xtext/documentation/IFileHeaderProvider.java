/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.documentation;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.documentation.impl.MultiLineFileHeaderProvider;
import org.eclipse.xtext.nodemodel.INode;

import com.google.inject.ImplementedBy;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.4
 */
@ImplementedBy(MultiLineFileHeaderProvider.class)
public interface IFileHeaderProvider {
	
	public String getFileHeader(Resource resource);
	
	public List<INode> getFileHeaderNodes(Resource resource);
	
}
