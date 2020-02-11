/*******************************************************************************
 * Copyright (c) 2012, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.documentation;

import java.util.List;

import org.eclipse.xtext.documentation.impl.MultiLineJavaDocTypeReferenceProvider;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
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

	/**
	 * Returns the referenced element in javadoc comment at a given <i>offset</i>.
	 * Returns null in case no element is referenced at the given <i>offset</i>.
	 * 
	 * @since 2.16
	 */
	default EObjectInComment computeEObjectReferencedInComment(XtextResource resource, int offset) {
		return null;
	}

}
