/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.example.entities.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class EntitiesLanguage extends AbstractXtextLanguage {

	public static final EntitiesLanguage INSTANCE = new EntitiesLanguage();

	private EntitiesLanguage() {
		super("org.eclipse.xtext.idea.example.entities.Entities");
	}

}
