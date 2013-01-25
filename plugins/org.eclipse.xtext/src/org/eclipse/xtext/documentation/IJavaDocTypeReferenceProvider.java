/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.documentation;

import java.util.List;

import org.eclipse.xtext.documentation.impl.MultiLineJavaDocTypeReferenceProvider;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.ReplaceRegion;

import com.google.inject.ImplementedBy;

/**
 * @author Holger Schill - Initial contribution and API
 * @author Jan Koehnlein
 * @since 2.4
 */
@ImplementedBy(MultiLineJavaDocTypeReferenceProvider.class)
public interface IJavaDocTypeReferenceProvider {

	public static final String SEE_TAG = "@see";

	public static final String SEE_TAG_WITH_SUFFIX = SEE_TAG + " ";

	public static final String LINK_TAG = "@link";

	public static final String LINK_TAG_WITH_SUFFIX = LINK_TAG + " ";

	public List<ReplaceRegion> computeTypeRefRegions(INode commentNode);

	public List<ReplaceRegion> computeParameterTypeRefRegions(INode commentNode);
}
