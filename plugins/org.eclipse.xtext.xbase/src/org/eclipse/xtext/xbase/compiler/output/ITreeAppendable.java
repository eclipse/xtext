/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler.output;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.xbase.compiler.IAppendable;

/**
 * A specialized appendable that can be used to trace the source location
 * for the written output.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public interface ITreeAppendable extends IAppendable, ITraceRegionProvider {

	ITreeAppendable trace(EObject object);
	
	/**
	 * @param objects the list of objects that contribute output. May not be empty.
	 */
	ITreeAppendable trace(List<EObject> objects);
	
	ITreeAppendable append(ITreeAppendable other);
	
	ITreeAppendable append(JvmType type);
	
	ITreeAppendable append(String string);
	
	ITreeAppendable decreaseIndentation();
	
	ITreeAppendable increaseIndentation();
	
	ITreeAppendable newLine();
	
}
