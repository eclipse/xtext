/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.example.entities.idea.highlighting;

import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;
import org.eclipse.xtext.idea.highlighting.SemanticHighlightVisitor;

public class EntitiesSemanticHighlightVisitor extends SemanticHighlightVisitor {
	public EntitiesSemanticHighlightVisitor() {
		EntitiesLanguage.INSTANCE.injectMembers(this);
	}
}
