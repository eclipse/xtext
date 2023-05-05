/*******************************************************************************
 * Copyright (c) 2020, 2023 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.quickfix;

import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.server.rename.ChangeConverter2;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

/**
 * @author Heinrich Weichert

 * @since 2.24
 */
public class DiagnosticModificationContext {

	private IChangeSerializer serializer;
	private ChangeConverter2.Factory converterFactory;

	IChangeSerializer getSerializer() {
		return serializer;
	}

	void setSerializer(IChangeSerializer serializer) {
		this.serializer = serializer;
	}

	ChangeConverter2.Factory getConverterFactory() {
		return converterFactory;
	}

	void setConverterFactory(ChangeConverter2.Factory converterFactory) {
		this.converterFactory = converterFactory;
	}

	@ImplementedBy(Factory.Default.class)
	public interface Factory {

		DiagnosticModificationContext createModificationContext();

		public static class Default implements Factory {

			@Inject
			IChangeSerializer serializer;
			@Inject
			ChangeConverter2.Factory converterFactory;

			@Override
			public DiagnosticModificationContext createModificationContext() {
				DiagnosticModificationContext ctx = new DiagnosticModificationContext();
				ctx.setConverterFactory(converterFactory);
				ctx.setSerializer(serializer);
				return ctx;
			}

		}

	}
}