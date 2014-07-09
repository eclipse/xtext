/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro;

import org.eclipse.xtend.lib.macro.TransformationParticipant;
import org.eclipse.xtend.lib.macro.file.FileLocations;
import org.eclipse.xtend.lib.macro.file.FileSystemSupport;
import org.eclipse.xtend.lib.macro.services.AnnotationReferenceProvider;
import org.eclipse.xtend.lib.macro.services.ProblemSupport;
import org.eclipse.xtend.lib.macro.services.Tracability;
import org.eclipse.xtend.lib.macro.services.TypeLookup;
import org.eclipse.xtend.lib.macro.services.TypeReferenceProvider;

/**
 * Services provided during the validation phase
 *  
 * @see ValidationParticipant
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ValidationContext extends Tracability, ProblemSupport, TypeReferenceProvider, TypeLookup, FileSystemSupport, FileLocations, AnnotationReferenceProvider {

}
