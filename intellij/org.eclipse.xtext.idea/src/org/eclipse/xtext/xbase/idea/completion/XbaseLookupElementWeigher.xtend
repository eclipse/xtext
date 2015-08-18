/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.completion

import com.intellij.codeInsight.completion.JavaPsiClassReferenceElement
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementWeigher
import org.eclipse.xtext.idea.completion.AbstractCompletionContributor.KeywordLookupElement

/**
 * @author kosyakov - Initial contribution and API
 */
class XbaseLookupElementWeigher extends LookupElementWeigher {

	enum LookupElementKind {
		DEFAULT,
		KEYWORD,
		JAVA_TYPE
	}

	new() {
		super("xbaseWeigher")
	}

	override LookupElementKind weigh(LookupElement element) {
		switch element {
			KeywordLookupElement:
				LookupElementKind.KEYWORD
			JavaPsiClassReferenceElement:
				LookupElementKind.JAVA_TYPE
			default:
				LookupElementKind.DEFAULT
		}
	}

}