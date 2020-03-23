/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.navigation;

import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.hyperlink.AbstractHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.generator.trace.ITraceForStorageProvider;
import org.eclipse.xtext.ui.resource.IResourceUIServiceProvider;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * Navigates to the original source element if the selected Java type was generated
 * from an Xbase language (e.g. {@link ITraceForStorageProvider} is available).
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LinkToOriginDetector extends AbstractHyperlinkDetector {

	@Inject
	private ITraceForStorageProvider traceInformation;
	
	@Inject
	private IResourceUIServiceProvider.Registry serviceProviderRegistry;
	
	@Override
	public IHyperlink[] detectHyperlinks(ITextViewer textViewer, IRegion region, boolean canShowMultipleHyperlinks) {
		try {
			// very pessimistic guards - most things should never happen
			ITextEditor textEditor = getAdapter(ITextEditor.class);
			if (textEditor == null)
				return null;
			IEditorInput editorInput = textEditor.getEditorInput();
			if (editorInput == null)
				return null;
			IJavaElement adaptedJavaElement = Platform.getAdapterManager().getAdapter(editorInput, IJavaElement.class);
			if (adaptedJavaElement == null)
				return null;
			ICompilationUnit compilationUnit = (ICompilationUnit) adaptedJavaElement.getAncestor(IJavaElement.COMPILATION_UNIT);
			if (compilationUnit == null)
				return null;
			try {
				IRegion selectedWord = org.eclipse.jdt.internal.ui.text.JavaWordFinder.findWord(
						textViewer.getDocument(), region.getOffset());
				// the actual implementation - find the referenced Java type under the cursor and link
				// to its origin if it's contained in a 'derived' resource
				IJavaElement[] javaElements = compilationUnit.codeSelect(selectedWord.getOffset(), selectedWord.getLength());
				for(IJavaElement javaElement: javaElements) {
					/**
					 * if IDE 3.8 is available the default 'Open Declaration' navigation will already open the original editor
					 * So we don't need the additional hyperlinks.
					 */
					boolean provideHyperlinkOnReferences = !is_ORG_ECLIPSE_UI_IDE_3_8_Enabled() || compilationUnit.equals(((IMember) javaElement).getCompilationUnit());
					if (javaElement instanceof IMember && provideHyperlinkOnReferences) {
						IMember selectedMember = (IMember) javaElement;
						IResource resource = selectedMember.getResource();
						if (resource instanceof IFile) {
							ITrace traceToSource = traceInformation.getTraceToSource((IStorage) resource);
							if (traceToSource == null) {
								return null;
							}
							ILocationInResource sourceInformation = Iterables.getFirst(traceToSource.getAllAssociatedLocations(), null);
							if(sourceInformation != null) {
								try {
									URI resourceURI = sourceInformation.getAbsoluteResourceURI().getURI();
									if (resourceURI != null) {
										IResourceServiceProvider serviceProvider = serviceProviderRegistry.getResourceServiceProvider(resourceURI);
										if (serviceProvider == null)
											return null;
										LinkToOriginProvider provider = serviceProvider.get(LinkToOriginProvider.class);
										LinkToOrigin hyperlink = provider.createLinkToOrigin(sourceInformation, selectedWord, selectedMember, compilationUnit, Collections.<LinkToOrigin>emptyList());
										if (hyperlink != null) {
											return new IHyperlink[]{hyperlink};
										}
									}
								} catch(IllegalArgumentException e) { /* invalid URI - ignore */ }
							}
							return null;
						}
					}
				}
				return null;
			} catch (JavaModelException e) {
				return null;
			}
		} catch(Throwable t) {
			return null;
		}
	}

	private boolean is_ORG_ECLIPSE_UI_IDE_3_8_Enabled() {
		try {
			Class<?> clazz = getClass().getClassLoader().loadClass("org.eclipse.ui.ide.IDE");
			return clazz != null;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}

}
