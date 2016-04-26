/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.example.entities.idea.lang;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import javax.swing.Icon;
import org.eclipse.xtext.idea.Icons;
import org.jetbrains.annotations.NonNls;

public class AbstractEntitiesFileType extends LanguageFileType {

	@NonNls 
	public static final String DEFAULT_EXTENSION = "entities";

	protected AbstractEntitiesFileType(final Language language) {
		super(language);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "Entities files";
	}

	@Override
	public Icon getIcon() {
		return Icons.DSL_FILE_TYPE;
	}

	@Override
	public String getName() {
		return "Entities";
	}

}
