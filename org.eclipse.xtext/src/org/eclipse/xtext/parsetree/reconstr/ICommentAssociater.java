/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultCommentAssociater;

import com.google.inject.ImplementedBy;

/**
 * Associates comments to semantic objects. Used in serialization to recover comments in the right places.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
@ImplementedBy(DefaultCommentAssociater.class)
public interface ICommentAssociater {

	Map<ILeafNode, EObject> associateCommentsWithSemanticEObjects(EObject model, Set<ICompositeNode> roots);

}
