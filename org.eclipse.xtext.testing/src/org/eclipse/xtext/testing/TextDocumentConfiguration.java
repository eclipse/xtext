/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testing;

import java.util.Collections;
import java.util.Map;

import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public class TextDocumentConfiguration {
	private Map<String, CharSequence> filesInScope = Collections.emptyMap();

	private String model;

	private String filePath;

	private Procedure1<? super InitializeParams> initializer;

	public Map<String, CharSequence> getFilesInScope() {
		return filesInScope;
	}

	public void setFilesInScope(Map<String, CharSequence> filesInScope) {
		this.filesInScope = filesInScope;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Procedure1<? super InitializeParams> getInitializer() {
		return initializer;
	}

	public void setInitializer(Procedure1<? super InitializeParams> initializer) {
		this.initializer = initializer;
	}
}
