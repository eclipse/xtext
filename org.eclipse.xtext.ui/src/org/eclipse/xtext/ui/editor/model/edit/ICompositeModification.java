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

/**
 * Implementations of this interfaces can modify the AST during execution of a QuickFix.
 * 
 * The model changes will be translated into textual changes by the {@link IChangeSerializer}. Changes may be applied to any EMF Resource.
 * 
 * This modification supports being executed in batch mode when a user triggers a QuickFix on multiple markers at the same time from the
 * Problems View.
 * 
 * Example:
 * 
 * <code>
 * acceptor.acceptMulti("label", "desc" (MyElement ele, ICompositeModificationContext<MyElement> ctx) -> {
 *     
 *     // don't modify the model here yet!
 *     // (read the line above again!)
 *     // here you may configure the change serializer
 *     // this part is executed *before* any modification is applied to the model. 
 *     // Therefore this is the perfect place to resolve model elements for later modification in #addModification();
 *     ctx.setUpdateCrossReferences(true);
 *     ctx.setRelatedFiles(true);
 *     ctx.addModification(element, resource -> {
 *     
 *         // here you may modify 'element' or any of its children.
 *         element.setMyAttribute("foo");
 *     }); 
 * }
 * </code>
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @since 2.13
 */
public interface ICompositeModification<T extends EObject> {

	void apply(T element, ICompositeModificationContext<T> context);

}
