/**
 * Copyright (c) 2016, 2022 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.ide;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.jsonrpc.Endpoint;
import org.eclipse.lsp4j.jsonrpc.json.JsonRpcMethod;
import org.eclipse.lsp4j.jsonrpc.json.JsonRpcMethodProvider;
import org.eclipse.lsp4j.jsonrpc.services.JsonNotification;
import org.eclipse.lsp4j.jsonrpc.services.JsonRequest;
import org.eclipse.lsp4j.jsonrpc.services.ServiceEndpoints;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.ILanguageServerAccess.IndexContext;
import org.eclipse.xtext.ide.server.ILanguageServerExtension;
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TestLanguagePackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.inject.ImplementedBy;

/**
 * @author efftinge - Initial contribution and API
 */
@ImplementedBy(TestLangLSPExtension.Impl.class)
public interface TestLangLSPExtension extends ILanguageServerExtension {
	class TextOfLineResult {
		public String text;
	}

	class TextOfLineParam {
		public String uri;

		public int line;
	}

	class BuildNotification {
		public String message;

		@Override
		public String toString() {
			ToStringBuilder b = new ToStringBuilder(this);
			b.add("message", message);
			return b.toString();
		}
	}

	interface CustomClient {
		@JsonNotification
		void buildHappened(BuildNotification notification);
	}

	class Impl implements ILanguageServerExtension, TestLangLSPExtension, ILanguageServerAccess.IBuildListener,
			JsonRpcMethodProvider {
		private ILanguageServerAccess access;

		private CustomClient client;

		@Override
		public CompletableFuture<TextOfLineResult> getTextOfLine(TextOfLineParam param) {
			return access.doRead(param.uri, (ILanguageServerAccess.Context ctx) -> {
				int start = ctx.getDocument().getOffSet(new Position(param.line, 0));
				int end = ctx.getDocument().getOffSet(new Position(param.line + 1, 0))
						- System.lineSeparator().length();
				TextOfLineResult textOfLineResult = new TextOfLineResult();
				textOfLineResult.text = ctx.getDocument().getContents().substring(start, end);
				return textOfLineResult;
			});
		}

		@Override
		public void initialize(ILanguageServerAccess access) {
			this.access = access;
			this.access.addBuildListener(this);
		}

		@Override
		public void afterBuild(List<IResourceDescription.Delta> deltas) {
			BuildNotification buildNotification = new BuildNotification();
			buildNotification.message = "Built "
					+ Joiner.on(", ").join(Lists.transform(deltas, d -> d.getUri().toString()), ", ");
			if (client == null) {
				client = ServiceEndpoints.toServiceObject((Endpoint) access.getLanguageClient(), CustomClient.class);
			}
			client.buildHappened(buildNotification);
		}

		@Override
		public Map<String, JsonRpcMethod> supportedMethods() {
			HashMap<String, JsonRpcMethod> result = new HashMap<>();
			result.putAll(ServiceEndpoints.getSupportedMethods(getClass()));
			result.putAll(ServiceEndpoints.getSupportedMethods(CustomClient.class));
			return result;
		}

		@Override
		public CompletableFuture<Set<String>> getAllOpNames() {
			return access
					.doReadIndex((Function<IndexContext, Set<String>>) (ILanguageServerAccess.IndexContext context) -> {
						Set<String> result = new HashSet<>();
						for (IResourceDescription rd : context.getIndex().getAllResourceDescriptions()) {
							for (IEObjectDescription o : rd.getExportedObjects()) {
								if (TestLanguagePackage.Literals.OPERATION == o.getEClass()) {
									result.add(o.getName().getLastSegment());
								}
							}
						}
						return result;
					});
		}
	}

	@JsonRequest
	CompletableFuture<TextOfLineResult> getTextOfLine(TextOfLineParam param);

	@JsonRequest
	CompletableFuture<Set<String>> getAllOpNames();
}
