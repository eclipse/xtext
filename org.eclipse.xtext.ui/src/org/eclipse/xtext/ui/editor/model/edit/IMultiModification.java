/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model.edit;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.resource.XtextResource;

/**
 * Implementations of this interfaces can modify the AST during execution of a QuickFix.
 * 
 * The model changes will be translated into textual changes by the {@link IChangeSerializer}. Changes may only be applied to the
 * {@link XtextResource} that contains the <code>context</code> EObject. However, incoming references from other resources will also be
 * updated.
 * 
 * The name <i>multi</i> pays tribute to the fact that this modification can be executed in batch mode when a user triggers a QuickFix on
 * multiple markers at the same time from the Problems View.
 * 
 * For more fine-grained control, use {@link ICompositeModification}.
 * 
 * The code
 * 
 * <code>
 * acceptor.acceptMulti("label", "desc" (MyElement ele) -> {
 *     ele.setMyAttribute("foo");
 * }
 * </code>
 * 
 * is equivalent to
 * 
 * <code>
 * acceptor.acceptMulti("label", "desc" (MyElement ele, ICompositeModificationContext<MyElement> ctx) -> {
 *     ctx.setUpdateCrossReferences(true);
 *     ctx.setUpdateRelatedFiles(true);
 *     ctx.addModification(ele.eResource(), resource -> {
 *         ele.setMyAttribute("foo");
 *     }); 
 * }
 * </code>
 * 
 * @author Dennis Huebner - Initial contribution and API
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @since 2.13
 */
public interface IMultiModification<T extends EObject> {
	void apply(T context);
}
