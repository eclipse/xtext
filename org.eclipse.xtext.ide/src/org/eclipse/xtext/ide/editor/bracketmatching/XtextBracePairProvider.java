/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.bracketmatching;

import java.util.Collections;

import com.google.common.collect.Sets;
import com.google.inject.Singleton;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
public class XtextBracePairProvider extends DefaultBracePairProvider {
	public XtextBracePairProvider() {
		super(Collections.unmodifiableSet(Sets.newHashSet(new BracePair(":", ";", true),
				new BracePair("(", ")", false), new BracePair("{", "}", true), new BracePair("[", "]", false))));
	}
}
