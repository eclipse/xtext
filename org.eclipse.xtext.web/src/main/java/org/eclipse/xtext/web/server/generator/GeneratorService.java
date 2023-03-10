/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.xtext.generator.GeneratorDelegate;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.model.AbstractCachedService;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocumentAccess;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * Service class for code generation. The resulting documents are sent back to
 * the client; if exactly one document is generated, the result should be
 * unwrapped, i.e. the response body is the generated document.
 * 
 * <p>
 * Results of this service are cached in the session state. However, the service
 * is <em>not</em> invoked automatically after a document change (in contrast to
 * e.g. validation), but only after an explicit request.
 * </p>
 */
@Singleton
public class GeneratorService extends AbstractCachedService<GeneratorService.GeneratedArtifacts> {
	/**
	 * This service result class is just a wrapper to store all generated documents.
	 */
	public static class GeneratedArtifacts implements IServiceResult {
		private final List<GeneratorResult> artifacts = new ArrayList<>();

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((artifacts == null) ? 0 : artifacts.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			GeneratedArtifacts other = (GeneratedArtifacts) obj;
			if (artifacts == null) {
				if (other.artifacts != null)
					return false;
			} else if (!artifacts.equals(other.artifacts))
				return false;
			return true;
		}

		@Override
		public String toString() {
			ToStringBuilder b = new ToStringBuilder(this);
			b.add("artifacts", artifacts);
			return b.toString();
		}

		public List<GeneratorResult> getArtifacts() {
			return artifacts;
		}
	}

	/**
	 * The default artifact name that is accessed when no specific artifact is
	 * requested. Value: "DEFAULT_OUTPUT/DEFAULT_ARTIFACT"
	 */
	public static final String DEFAULT_ARTIFACT = IFileSystemAccess.DEFAULT_OUTPUT + "/DEFAULT_ARTIFACT";

	@Inject
	private GeneratorDelegate generator;

	@Inject
	private IContentTypeProvider contentTypeProvider;

	@Inject
	private Provider<InMemoryFileSystemAccess> fileSystemAccessProvider;

	/**
	 * Generate artifacts for the given document. The result can be fetched with
	 * {@link #getResult(XtextWebDocumentAccess)}.
	 */
	@Override
	public GeneratedArtifacts compute(IXtextWebDocument doc, CancelIndicator cancelIndicator) {
		InMemoryFileSystemAccess fileSystemAccess = fileSystemAccessProvider.get();
		generator.generate(doc.getResource(), fileSystemAccess, () -> cancelIndicator);
		GeneratedArtifacts result = new GeneratedArtifacts();
		for (Entry<String, CharSequence> e : fileSystemAccess.getTextFiles().entrySet()) {
			String contentType = contentTypeProvider.getContentType(e.getKey());
			result.artifacts.add(new GeneratorResult(e.getKey(), contentType, e.getValue().toString()));
		}
		return result;
	}

	/**
	 * Retrieve the generated artifact with given identifier. The identifier must
	 * match the name of one of the generator results; each name is created by
	 * concatenating the output configuration name and the file name (see
	 * {@link InMemoryFileSystemAccess#getFileName(String,String)}). If artifactId
	 * is null, {@link #DEFAULT_ARTIFACT} is used as identifier. If the requested
	 * artifact is in {@link IFileSystemAccess#DEFAULT_OUTPUT}, the output
	 * configuration prefix may be omitted.
	 */
	public GeneratorResult getArtifact(XtextWebDocumentAccess document, String artifactId) {
		List<GeneratorResult> artifacts = getResult(document).artifacts;
		final String searchString;
		if (artifactId != null) {
			searchString = artifactId;
		} else {
			searchString = GeneratorService.DEFAULT_ARTIFACT;
		}
		for (GeneratorResult r : artifacts) {
			if (searchString.equals(r.getName())) {
				return r;
			}
		}
		if (!searchString.startsWith(IFileSystemAccess.DEFAULT_OUTPUT)) {
			String defaultSearchString = IFileSystemAccess.DEFAULT_OUTPUT + searchString;
			for (GeneratorResult r : artifacts) {
				if (defaultSearchString.equals(r.getName())) {
					return r;
				}
			}
		}
		throw new InvalidRequestException.ResourceNotFoundException("The requested generator artifact was not found.");
	}

	/**
	 * Retrieve the generated artifact with given identifier. If
	 * {@code includeContent} is false, only the metadata is included in the service
	 * result.
	 */
	public GeneratorResult getArtifact(XtextWebDocumentAccess document, String artifactId, boolean includeContent) {
		GeneratorResult result = getArtifact(document, artifactId);
		if (includeContent) {
			return result;
		} else {
			return new GeneratorResult(result.getName(), result.getContentType(), null);
		}
	}

	/**
	 * Returns a {@link GeneratedArtifacts} result with or without content. If
	 * {@code includeContent} is false, only the metadata is included in the service
	 * result, which is useful to explore the generated artifacts.
	 */
	public GeneratedArtifacts getResult(XtextWebDocumentAccess document, boolean includeContent) {
		if (includeContent) {
			return getResult(document);
		} else {
			List<GeneratorResult> artifacts = getResult(document).artifacts;
			GeneratedArtifacts result = new GeneratedArtifacts();
			for (GeneratorResult r : artifacts) {
				result.artifacts.add(new GeneratorResult(r.getName(), r.getContentType(), null));
			}
			return result;
		}
	}
}
