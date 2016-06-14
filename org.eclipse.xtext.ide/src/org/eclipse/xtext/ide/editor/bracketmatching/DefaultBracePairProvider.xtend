/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.bracketmatching

import com.google.inject.Singleton
import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@Accessors
@FinalFieldsConstructor
class DefaultBracePairProvider implements IBracePairProvider {

	val Set<BracePair> pairs

	new() {
		this(#{
			new BracePair("(", ")", true),
			new BracePair("{", "}", true),
			new BracePair("[", "]", true)
		})
	}

}