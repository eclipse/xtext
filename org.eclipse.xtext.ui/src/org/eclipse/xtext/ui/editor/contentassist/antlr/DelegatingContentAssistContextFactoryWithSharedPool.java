/*******************************************************************************
 * Copyright (c) 2021 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist.antlr;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.contentassist.AbstractContentAssistContextFactory;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.antlr.DelegatingContentAssistContextFactory.StatefulFactory;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.26
 */

@Singleton
public class DelegatingContentAssistContextFactoryWithSharedPool extends AbstractContentAssistContextFactory {
	/**
	 * Register in UI module via 
	 * <pre>
	 * public Provider<? extends SharedExecutorServiceAccess> provideSharedExecutorServiceAccess() {
	 * 	return Access.provider(SharedExecutorServiceAccess.class);
	 * }
	 * </pre>
	 */
	@Singleton
	public static class SharedExecutorServiceAccess {
		ExecutorService pool = Executors.newFixedThreadPool(3, new ThreadFactoryBuilder().setNameFormat("ContentAssistContextFactorySharedPool-%d").build());

		ExecutorService pool() {
			return pool;
		}
	}

	private final Provider<StatefulFactory> statefulFactoryProvider;
	private final ExecutorService pool;

	@Inject
	public DelegatingContentAssistContextFactoryWithSharedPool(Provider<StatefulFactory> statefulFactoryProvider,
			SharedExecutorServiceAccess access) {
		this.pool = access.pool();
		this.statefulFactoryProvider = statefulFactoryProvider;
	}

	public Provider<? extends StatefulFactory> getStatefulFactoryProvider() {
		return statefulFactoryProvider;
	}

	protected ExecutorService getPool() {
		return pool;
	}

	@Override
	public ContentAssistContext[] create(ITextViewer viewer, int offset, XtextResource resource) {
		StatefulFactory factory = getStatefulFactoryProvider().get();
		factory.setPool(pool);
		return factory.create(viewer, offset, resource);
	}
}