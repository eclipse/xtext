/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.workspace;

import org.eclipse.emf.common.util.URI;

public interface ISourceFolder {
	/**
	 * The logical name of the source folder, like "src/main/java"
	 */
	String getName();

	/**
	 * The (platform dependent) physical location of the source folder. The path will always end in a trailing
	 * separator. It will never be null.
	 */
	URI getPath();
}
