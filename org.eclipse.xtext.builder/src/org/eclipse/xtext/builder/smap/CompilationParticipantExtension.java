/*******************************************************************************
 * Copyright (c) 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

package org.eclipse.xtext.builder.smap;

import java.io.ByteArrayInputStream;
import java.util.Optional;

import org.eclipse.jdt.core.compiler.BuildContext;

/**
 * Adapter to new CompilationParticipant interface in 2023-06+
 * 
 * @author dietrich - Initial contribution and API
 */
public interface CompilationParticipantExtension {
	
	Optional<byte[]> postProcess(BuildContext ctx, ByteArrayInputStream bytes);
	boolean isPostProcessor();
	
}