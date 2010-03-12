/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.ui.navigation;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.common.types.xtext.ui.JdtHyperlink;
import org.eclipse.xtext.example.domainmodel.DomainmodelPackage;
import org.eclipse.xtext.example.domainmodel.Entity;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkAcceptor;
import org.eclipse.xtext.util.TextLocation;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DomainmodelHyperlinkHelper extends HyperlinkHelper {

	private static final Logger logger = Logger.getLogger(DomainmodelHyperlinkHelper.class);
	
	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;
	
	@Inject
	private Provider<JdtHyperlink> jdtHyperlinkProvider;
	
	@Override
	public void createHyperlinksByOffset(XtextResource resource, int offset, IHyperlinkAcceptor acceptor) {
		super.createHyperlinksByOffset(resource, offset, acceptor);
		TextLocation loc = new TextLocation();
		EObject eObject = EObjectAtOffsetHelper.resolveElementAt(resource, offset, loc);
		if (eObject instanceof Entity) {
			List<AbstractNode> nodes = NodeUtil.findNodesForFeature(eObject, DomainmodelPackage.Literals.TYPE__NAME);
			if (!nodes.isEmpty()) {
				AbstractNode node = nodes.get(0);
				if (node.getOffset() <= offset && node.getOffset() + node.getLength() > offset) {
					String qualifiedName = qualifiedNameProvider.getQualifiedName(eObject);
					if (resource.getResourceSet() instanceof XtextResourceSet) {
						XtextResourceSet resourceSet = (XtextResourceSet) resource.getResourceSet();
						Object uriContext = resourceSet.getClasspathURIContext();
						if (uriContext instanceof IJavaProject) {
							IJavaProject javaProject = (IJavaProject) uriContext;
							try {
								IType type = javaProject.findType(qualifiedName);
								if (type != null) {
									JdtHyperlink hyperlink = jdtHyperlinkProvider.get();
									hyperlink.setJavaElement(type);
									hyperlink.setTypeLabel("Navigate to generated source code.");
									hyperlink.setHyperlinkText("Go to type " + qualifiedName);
									hyperlink.setHyperlinkRegion(new Region(node.getOffset(), node.getLength()));
									acceptor.accept(hyperlink);
								}
							} catch(JavaModelException e) {
								logger.error(e.getMessage(), e);
							}
						}
					}
				}
			}
		}
	}
	
}
