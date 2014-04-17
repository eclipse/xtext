/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.navigation;

import java.util.List;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.corext.util.JdtFlags;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.text.JavaWordFinder;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.DefaultHyperlinkDetector;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.resource.JvmElementAtOffsetHelper;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class XbaseHyperlinkDetector extends DefaultHyperlinkDetector {

	@Inject
	private JvmElementAtOffsetHelper jvmElementAtOffsetHelper;
	@Inject
	private IJavaElementFinder javaElementFinder;
	@Inject
	private JvmImplementationOpener implOpener;

	@Override
	public IHyperlink[] detectHyperlinks(final ITextViewer textViewer, final IRegion region, final boolean canShowMultipleHyperlinks) {
		List<IHyperlink> links = Lists.newArrayList();
		IHyperlink[] detectedHyperlinks = super.detectHyperlinks(textViewer, region, canShowMultipleHyperlinks);
		IHyperlink  implementatorLink= null;
		if(canShowMultipleHyperlinks) {
			 implementatorLink =  ((IXtextDocument)textViewer.getDocument()).readOnly(new IUnitOfWork<IHyperlink ,XtextResource>() {
				public IHyperlink  exec(XtextResource resource) throws Exception {
					IRegion word = JavaWordFinder.findWord(textViewer.getDocument(), region.getOffset());
					JvmIdentifiableElement jvmIdentifiableElement = jvmElementAtOffsetHelper.getJvmIdentifiableElement(resource, region.getOffset());
					if(jvmIdentifiableElement != null && word != null)
						return createHyperlink(textViewer, jvmIdentifiableElement, word);
					return null;
				}

				private IHyperlink createHyperlink(final ITextViewer textViewer, JvmIdentifiableElement candidate, IRegion word) {
					IJavaElement javaElement = javaElementFinder.findExactElementFor(candidate);
					if (javaElement != null && (javaElement.getElementType() == IJavaElement.METHOD && canBeOverridden((IMethod) javaElement))) {
						return new XbaseImplementatorsHyperlink(javaElement, word, textViewer, implOpener);
					}
					return null;
				}

				private boolean canBeOverridden(IMethod method) {
					try {
						return !(JdtFlags.isPrivate(method) || JdtFlags.isFinal(method) || JdtFlags.isStatic(method)
								|| method.isConstructor() || JdtFlags.isFinal((IMember) method.getParent()));
					} catch (JavaModelException e) {
						JavaPlugin.log(e);
						return false;
					}
				}
			});

		}
		if(detectedHyperlinks == null && implementatorLink == null)
			return null;
		if(detectedHyperlinks != null && detectedHyperlinks.length > 0)
			links.addAll(Lists.newArrayList(detectedHyperlinks));
		if(implementatorLink != null)
			links.add(implementatorLink);
		return Iterables.toArray(links, IHyperlink.class);

	}
}
