/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer;

import java.util.List;

import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.resource.XtextResource;

/**
 * Represents a an {@link XtextResource} that has been directly modified or is affected by a change from
 * {@link IChangeSerializer}.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * 
 * @since 2.13
 */
public interface ITextDocumentChange extends IEmfResourceChange {

	@Override
	XtextResource getResource();

	List<ITextReplacement> getReplacements();
}
