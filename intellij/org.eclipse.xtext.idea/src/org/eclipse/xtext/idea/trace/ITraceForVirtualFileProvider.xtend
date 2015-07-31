/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.trace

import org.eclipse.xtext.generator.trace.internal.IPlatformSpecificTraceProvider
import org.eclipse.xtext.generator.trace.internal.NoTraces
import java.util.List
import com.intellij.psi.PsiElement

/**
 * Provides read access to the available trace information for generated resources or input resources.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 * @since 2.9
 */
interface ITraceForVirtualFileProvider extends IPlatformSpecificTraceProvider<VirtualFileInProject, IIdeaTrace> {
	
	class Null extends NoTraces<VirtualFileInProject, IIdeaTrace> implements ITraceForVirtualFileProvider {
		
		override getOriginalElements(PsiElement element) {
			return emptyList
		}
		
		override getGeneratedElements(PsiElement element) {
			return emptyList
		}
		
		override isGenerated(VirtualFileInProject file) {
			false
		}
		
	}
	
	def boolean isGenerated(VirtualFileInProject file)
	
	def List<? extends PsiElement> getOriginalElements(PsiElement element)
	
	def List<? extends PsiElement> getGeneratedElements(PsiElement element)
	
}
