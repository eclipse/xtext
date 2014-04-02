/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tasks

import org.eclipse.xtext.tasks.DefaultTaskFinder
import org.eclipse.xtext.nodemodel.ILeafNode
import com.google.inject.Inject
import org.eclipse.xtext.xbase.services.XtypeGrammarAccess

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
class XTypeTaskFinder extends DefaultTaskFinder {
	
	@Inject
	XtypeGrammarAccess grammar
	
	override protected canContainTaskTags(ILeafNode node) {
		node.grammarElement == grammar.getSL_COMMENTRule || node.grammarElement == grammar.getML_COMMENTRule
	}
	
}