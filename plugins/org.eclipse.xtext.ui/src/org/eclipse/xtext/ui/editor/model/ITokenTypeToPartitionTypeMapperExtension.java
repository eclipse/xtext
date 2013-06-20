/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.folding.DefaultFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.reconciler.XtextSpellingReconcileStrategy;

import com.google.inject.ImplementedBy;

/**
 * Extension to {@link ITokenTypeToPartitionTypeMapper} that allow to query
 * for the characteristics of a given partition type, e.g. whether it is
 * a comment or not.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.4
 */
@ImplementedBy(TerminalsTokenTypeToPartitionMapper.class)
public interface ITokenTypeToPartitionTypeMapperExtension {

	/**
	 * Returns true of the given partitionType is to be treated as 
	 * as a multi line comment.
	 * @see DefaultFoldingRegionProvider#computeCommentFolding
	 * @see XtextEditor SmartLineStartAction in XtextEditor
	 * @see XtextSpellingReconcileStrategy
	 */
	boolean isMultiLineComment(String partitionType);
	
	/**
	 * Returns true of the given partitionType is to be treated as 
	 * as a single line comment.
	 * @see XtextEditor SmartLineStartAction in XtextEditor
	 * @see XtextSpellingReconcileStrategy
	 */
	boolean isSingleLineComment(String partitionType);
	
}
