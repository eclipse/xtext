/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.google.common.annotations.Beta;

/**
 * The active annotation is used to register compilation participants
 * with annotations. 
 * 
 *  They allow for enhancing and changing how Xtend code is translated to Java.
 *  
 *  There are two compiler phases in which an active annotation can participate, each with different possibilities and constraints:
 *  <ul>
 *  	<li>Phase 1: Register Globals {@link RegisterGlobalsParticipant}</li>
 *  	<li>Phase 2: Transformation {@link TransformationParticipant}</li>
 *  	<li>Phase 3: Generate Code {@link CodeGenerationParticipant}</li>
 *  </ul>
 *  
 *  Note, that in the IDE phase one and two are executed in the editor as you type, while phase 3 (code generation) only gets executed when 
 *  the editor's contents gets saved to disk.
 * 
 * @author Sven Efftinge
 */
@Beta
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Active {

	/**
	 * @return the processor to call during compilation. should implement one or
	 *         more of the processor interfaces {@link RegisterGlobalsParticipant},
	 *         {@link TransformationParticipant}.
	 */
	Class<?> value();
}
