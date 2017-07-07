/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.formatting2.IFormatter2;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionDiffBuilder;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.ide.serializer.impl.ChangeSerializer;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.ImplementedBy;

/**
 * Converts changes from EMF models to the smallest possible text changes.
 * 
 * The ChangeSerializer records changes that are being made to EMF models between the calls of
 * {@link #beginRecordChanges(Resource)} and {@link #endRecordChanges(IAcceptor)}. The result of the recording are
 * {@link ITextDocumentChange}s which the describe the changes as {@link ITextReplacement}s. The TextReplacements may
 * then be applied to an editor's contents or to a persisted file.
 * 
 * In contrast to {@link ISerializer}, the ChangeSerializer aims to produce the smallest text changes possible, can
 * handle changes that span multiple files, and is able to update cross references in related files.
 * 
 * Just like {@link ISerializer}, the ChangeSerializer applies the {@link IFormatter2} before returning
 * TextReplacements.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
@ImplementedBy(ChangeSerializer.class)
public interface IChangeSerializer {

	ITextRegionDiffBuilder beginRecordChanges(Resource resource);

	void endRecordChanges(IAcceptor<IEmfResourceChange> changeAcceptor);

	void setUpdateCrossReferences(boolean value);

	void setUpdateRelatedFiles(boolean value);

	boolean isUpdateCrossReferences();

	boolean isUpdateRelatedFiles();
}
