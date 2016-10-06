/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * @author Christian Schneider - Initial contribution and API
 */
public final class AnnotationNames {

	public static final String OVERRIDE = "Override";
	
	public static final List<String> VALID_ANNOTATIONS_NAMES = ImmutableList.of(OVERRIDE);
	
	private AnnotationNames() {
	}
}
