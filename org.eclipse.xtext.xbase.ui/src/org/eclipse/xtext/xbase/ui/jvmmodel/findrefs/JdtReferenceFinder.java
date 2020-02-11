/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.findrefs;

import static com.google.common.collect.Iterables.*;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.internal.ui.actions.ActionUtil;
import org.eclipse.jdt.internal.ui.search.JavaSearchQuery;
import org.eclipse.jdt.internal.ui.search.JavaSearchScopeFactory;
import org.eclipse.jdt.internal.ui.search.SearchMessages;
import org.eclipse.jdt.internal.ui.search.SearchUtil;
import org.eclipse.jdt.internal.ui.util.ExceptionHandler;
import org.eclipse.jdt.ui.search.ElementQuerySpecification;
import org.eclipse.jdt.ui.search.QuerySpecification;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;

import com.google.inject.Inject;

/**
 * Mostly copied and adapted from {@link org.eclipse.jdt.ui.actions.FindReferencesAction}.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class JdtReferenceFinder {

	@Inject(optional = true)
	private IWorkbench workbench;
	
	public void run(String label, Iterable<? extends IJavaElement> elements) {
		for(IJavaElement element: elements)
			if (!ActionUtil.isProcessable(getShell(), element))
				return;
		try {
			performNewSearch(label, elements);
		} catch (JavaModelException ex) {
			ExceptionHandler.handle(ex, getShell(), SearchMessages.Search_Error_search_notsuccessful_title, SearchMessages.Search_Error_search_notsuccessful_message);
		} catch (InterruptedException e) {
			// cancelled
		}
	}
	
	private Shell getShell() {
		return workbench.getActiveWorkbenchWindow().getShell();
	}

	@SuppressWarnings("all")
	protected QuerySpecification createQuery(IJavaElement element) throws JavaModelException, InterruptedException {
		JavaSearchScopeFactory factory= JavaSearchScopeFactory.getInstance();
		boolean isInsideJRE= factory.isInsideJRE(element);

		IJavaSearchScope scope= factory.createWorkspaceScope(isInsideJRE);
		String description= factory.getWorkspaceScopeDescription(isInsideJRE);
		return new ElementQuerySpecification(element, IJavaSearchConstants.REFERENCES, scope, description);
	}

	protected void performNewSearch(String label, Iterable<? extends IJavaElement> elements) throws JavaModelException, InterruptedException {
		CompositeSearchQuery compositeSearchQuery = createCompositeQuery(label, elements);
		if (compositeSearchQuery.canRunInBackground()) {
			SearchUtil.runQueryInBackground(compositeSearchQuery);
		} else {
			IProgressService progressService= PlatformUI.getWorkbench().getProgressService();
			IStatus status= SearchUtil.runQueryInForeground(progressService, compositeSearchQuery);
			if (status.matches(IStatus.ERROR | IStatus.INFO | IStatus.WARNING)) {
				ErrorDialog.openError(getShell(), SearchMessages.Search_Error_search_title, SearchMessages.Search_Error_search_message, status);
			}
		}
	}

	public CompositeSearchQuery createCompositeQuery(String label, Iterable<? extends IJavaElement> elements)
			throws JavaModelException, InterruptedException {
		CompositeSearchQuery compositeSearchQuery = new CompositeSearchQuery(createQuery(getFirst(elements, null)));
		compositeSearchQuery.setLabel(label);
		for(IJavaElement element: elements) {
			JavaSearchQuery query= new JavaSearchQuery(createQuery(element));
			compositeSearchQuery.addChild(query);
		}
		return compositeSearchQuery;
	}
}
