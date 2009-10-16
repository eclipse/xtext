/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.quickfix;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolution2;
import org.eclipse.ui.IMarkerResolutionGenerator2;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.xtext.concurrent.IUnitOfWork;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.IImageHelper;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.XtextDocumentUtil;
import org.eclipse.xtext.ui.core.editor.model.edit.IDocumentEditor;
import org.eclipse.xtext.ui.core.editor.validation.IXtextResourceChecker;
import org.eclipse.xtext.util.SimpleCache;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class AbstractDeclarativeQuickfixProvider implements IMarkerResolutionGenerator2 {

	@Inject
	private IDocumentEditor documentEditor;

	public IDocumentEditor getDocumentEditor() {
		return documentEditor;
	}

	@Inject
	private IImageHelper imageHelper;

	public IImageHelper getImageHelper() {
		return imageHelper;
	}

	@Inject
	@Named("file.extensions")
	private String fileExtensions;

	protected String[] getFileExtensions() {
		return fileExtensions.split(",");
	}

	protected boolean isLanguageResource(IResource resource) {
		String fileExtension = resource.getFullPath().getFileExtension();
		for (String ext : getFileExtensions()) {
			if (ext.equals(fileExtension))
				return true;
		}
		return false;
	}

	protected IXtextDocument getDocument(IMarker marker) {
		return XtextDocumentUtil.get(marker.getResource());
	}

	protected Integer getCode(final IMarker marker) {
		Integer code = marker.getAttribute(IXtextResourceChecker.CODE_KEY, -1);
		return code;
	}

	protected EObject getContext(XtextResource resource, final IMarker marker) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null && parseResult.getRootNode() != null) {
			AbstractNode lastVisibleNode = ParseTreeUtil.getLastCompleteNodeByOffset(parseResult.getRootNode(),
					MarkerUtilities.getCharStart(marker));
			if (lastVisibleNode != null)
				return NodeUtil.getNearestSemanticObject(lastVisibleNode);
		}
		String uri = marker.getAttribute(EValidator.URI_ATTRIBUTE, null);
		return uri == null ? null : resource.getEObject(URI.createURI(uri).fragment());
	}

	protected EObject getContext(final IMarker marker) {
		final IXtextDocument document = getDocument(marker);
		if (document == null)
			return null;

		final EObject context = document.readOnly(new IUnitOfWork<EObject, XtextResource>() {
			public EObject exec(XtextResource state) throws Exception {
				return getContext(state, marker);
			}
		});
		return context;
	}

	protected Predicate<Method> getFixMethodPredicate(final IMarker marker) {
		return new Predicate<Method>() {
			public boolean apply(Method input) {
				Fix annotation = input.getAnnotation(Fix.class);
				return input.getParameterTypes().length == 2 && Void.TYPE == input.getReturnType()
						&& annotation != null && annotation.code() == getCode(marker);
			}
		};
	}

	private volatile Set<Method> fixMethods = null;

	private final SimpleCache<Class<?>, List<Method>> methodsForType = new SimpleCache<Class<?>, List<Method>>(
			new Function<Class<?>, List<Method>>() {
				public List<Method> apply(Class<?> param) {
					List<Method> result = Lists.newArrayList();
					for (Method m : fixMethods) {
						if (methodMatched(m, param))
							result.add(m);
					}
					return result;
				}

				private boolean methodMatched(Method method, Class<?> param) {
					return method.getParameterTypes()[0].isAssignableFrom(param);
				}
			});

	protected IMarkerResolution[] getMarkerResolutions(final IMarker marker, List<Method> fixMethods) {
		return Lists.transform(fixMethods, new Function<Method, IMarkerResolution>() {
			public IMarkerResolution apply(final Method from) {
				return new IMarkerResolution2() {
					private final Fix annotation = from.getAnnotation(Fix.class);

					public void run(IMarker marker) {
						executeFixMethod(from, marker);
					}

					public String getLabel() {
						return annotation.label();
					}

					public Image getImage() {
						String image = annotation.image();
						return AbstractDeclarativeQuickfixProvider.this.getImage(image);
					}

					public String getDescription() {
						return annotation.description();
					}
				};
			}
		}).toArray(new IMarkerResolution[fixMethods.size()]);
	}

	protected Image getImage(String image) {
		return image != null ? getImageHelper().getImage(image) : null;
	}

	protected void executeFixMethod(final Method method, final IMarker marker) {
		IXtextDocument document = getDocument(marker);
		getDocumentEditor().process(new IUnitOfWork<Void, XtextResource>() {
			public java.lang.Void exec(XtextResource state) throws Exception {
				EObject context = getContext(state, marker);
				method.invoke(AbstractDeclarativeQuickfixProvider.this, new Object[] { context, marker });
				return null;
			}
		}, document);
	}

	private Iterable<Method> collectMethods(Class<? extends AbstractDeclarativeQuickfixProvider> clazz, IMarker marker) {
		List<Method> methods = Lists.newArrayList(clazz.getMethods());
		return Iterables.filter(methods, getFixMethodPredicate(marker));
	}

	protected List<Method> getFixMethods(final IMarker marker) {
		final EObject context = getContext(marker);
		if (context == null)
			return Collections.emptyList();

		if (fixMethods == null) {
			synchronized (this) {
				if (fixMethods == null) {
					Set<Method> methods = Sets.newLinkedHashSet(collectMethods(getClass(), marker));
					this.fixMethods = methods;
				}
			}
		}

		final List<Method> fixMethods = methodsForType.get(context.getClass());
		return fixMethods;
	}

	public boolean hasResolutions(final IMarker marker) {
		try {
			if (!marker.isSubtypeOf(EValidator.MARKER))
				return false;
		} catch (CoreException e) {
			return false;
		}
		if (!isLanguageResource(marker.getResource()))
			return false;
		if (getCode(marker) == null)
			return false;

		List<Method> fixMethods = getFixMethods(marker);
		return !fixMethods.isEmpty();
	}

	public IMarkerResolution[] getResolutions(IMarker marker) {
		List<Method> fixMethods = getFixMethods(marker);
		return getMarkerResolutions(marker, fixMethods);
	}

}
