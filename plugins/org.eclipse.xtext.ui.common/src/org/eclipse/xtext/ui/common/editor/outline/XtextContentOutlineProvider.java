/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;
import org.eclipse.xtext.ui.core.editor.model.XtextDocument;

public class XtextContentOutlineProvider extends LabelProvider implements ITreeContentProvider {

	private final static Logger logger = Logger.getLogger(XtextContentOutlineProvider.class);

	private ComposedAdapterFactory factory;
	private XtextDocument document;

	public XtextContentOutlineProvider(ComposedAdapterFactory adapterFactory) {
		this.factory = adapterFactory;
	}

	public Object[] getChildren(final Object parentElement) {
		return document.readOnly(new UnitOfWork<URI[]>() {

			public URI[] exec(XtextResource resource) throws Exception {
				EObject obj = resolveEObject(resource,parentElement);
				ITreeContentProvider tcp = getITreeContentProvider(obj);
				Object[] children = tcp.getChildren(obj);
				URI[] uris = new URI[children.length];
				for (int i = 0; i < children.length; i++) {
					EObject child = (EObject) children[i];
					if (child == null) {
						logger
								.error("tree content provider returned an array of children containing null references : "
										+ Arrays.toString(children));
						return new URI[0];
					}
					uris[i] = EcoreUtil.getURI(child);

				}
				return uris;
			}
		});
	}

	protected EObject resolveEObject(XtextResource resource, Object element) {
		if (element instanceof URI) {
			return resource.getResourceSet().getEObject((URI) element, true);
		}
		logger.error("Expected URI but was "+element);
		return null;
	}

	private ITreeContentProvider getITreeContentProvider(Object current) {
		ITreeContentProvider treeProvider = (ITreeContentProvider) factory.adapt(current, ITreeContentProvider.class);
		if (treeProvider == null)
			treeProvider = new NodeBasedTreeContentProvider(new AdapterFactoryContentProvider(
					new ReflectiveItemProviderAdapterFactory()));
		return treeProvider;
	}

	private ILabelProvider getLabelProvider(Object current) {
		ILabelProvider adapt = (ILabelProvider) factory.adapt(current, ILabelProvider.class);
		if (adapt == null)
			adapt = new AdapterFactoryLabelProvider(new ReflectiveItemProviderAdapterFactory());
		return adapt;
	}

	public Object getParent(final Object element) {
		return document.readOnly(new UnitOfWork<URI>() {

			public URI exec(XtextResource resource) throws Exception {
				EObject obj = resolveEObject(resource,element);
				Object parent = getITreeContentProvider(obj).getParent(obj);
				if (parent == null)
					return null;
				if (!(parent instanceof EObject)) {
					logger.error("Exepecting instance of EObject");
					return null;
				}
				return EcoreUtil.getURI((EObject) parent);
			}
		});
	}

	public boolean hasChildren(final Object element) {
		return document.readOnly(new UnitOfWork<Boolean>() {

			public Boolean exec(XtextResource resource) throws Exception {
				EObject obj = resolveEObject(resource,element);
				return getITreeContentProvider(obj).hasChildren(obj);
			}
		});
	}

	public Object[] getElements(Object inputElement) {
		if (inputElement != document) {
			logger.error("Get elements was passed as " + inputElement + ". the xtext document is expected.");
			return new Object[0];
		}
		return document.readOnly(new UnitOfWork<URI[]>() {
			public URI[] exec(XtextResource resource) throws Exception {
				EObject root = resource.getParseResult().getRootASTElement();
				URI uri = EcoreUtil.getURI(root);
				return root != null ? new URI[] { uri } : new URI[0];
			}
		});
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		logger.debug("Outline input has changed: " + newInput);
		this.document = (XtextDocument) newInput;
	}

	@Override
	public String getText(final Object element) {
		return document.readOnly(new UnitOfWork<String>() {
			public String exec(XtextResource resource) throws Exception {
				EObject obj = resolveEObject(resource,element);
				return getLabelProvider(obj).getText(obj);
			}
		});
	}

	@Override
	public Image getImage(final Object element) {
		return document.readOnly(new UnitOfWork<Image>() {
			public Image exec(XtextResource resource) throws Exception {
				EObject obj = resolveEObject(resource,element);
				return getLabelProvider(obj).getImage(obj);
			}
		});
	}

}