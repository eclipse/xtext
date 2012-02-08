/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.trace;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ITraceToSource;
import org.eclipse.xtext.generator.trace.ITraceToTarget;
import org.eclipse.xtext.util.ITextRegion;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.io.Closeables;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FileBasedTraceToSource extends AbstractTrace implements ITraceToSource {

	private static final Logger log = Logger.getLogger(FileBasedTraceToSource.class);
	
	protected class TraceRegionsByLanguage implements Iterable<AbstractTraceRegion> {
		private final Iterable<AbstractTraceRegion> allTraceRegions;
		private final LanguageInfo language;

		protected TraceRegionsByLanguage(Iterable<AbstractTraceRegion> allTraceRegions, LanguageInfo language) {
			this.allTraceRegions = allTraceRegions;
			this.language = language;
		}

		public Iterator<AbstractTraceRegion> iterator() {
			Iterator<AbstractTraceRegion> result = allTraceRegions.iterator();
			Iterator<AbstractTraceRegion> languageSpecific = Iterators.transform(result, new Function<AbstractTraceRegion, AbstractTraceRegion>() {
				public AbstractTraceRegion apply(AbstractTraceRegion input) {
					return findParentByLanguage(input, language);
				}
			});
			Iterator<AbstractTraceRegion> withoutDuplicates = Iterators.filter(languageSpecific, new Predicate<AbstractTraceRegion>() {
				private AbstractTraceRegion previous = null;
				public boolean apply(AbstractTraceRegion input) {
					if (input == null || input.equals(previous))
						return false;
					previous = input;
					return true;
				}
			});
			return withoutDuplicates;
		}
	}

	@Inject
	private TraceRegionSerializer traceRegionSerializer;
	
	private IStorage derivedResource;

	public IStorage getDerivedResource() {
		return derivedResource;
	}

	public Iterable<ITraceToTarget> getAllSources() {
		throw new UnsupportedOperationException();
	}

	public Iterable<ITraceToTarget> getAllSources(LanguageInfo language) {
		throw new UnsupportedOperationException();
	}

	public ILocationInResource getBestAssociatedLocation(ITextRegion region, LanguageInfo language) {
		AbstractTraceRegion left = findLeafAtLeftOffset(region.getOffset());
		left = findParentByLanguage(left, language);
		AbstractTraceRegion right = findLeafAtRightOffset(region.getOffset() + region.getLength());
		right = findParentByLanguage(left, language);
		return mergeRegions(left, right);
	}
	
	protected boolean isLanguage(AbstractTraceRegion region, LanguageInfo info) {
		if (info.equals(findLanguage(region.getToPath())))
			return true;
		return false;
	}
	
	protected AbstractTraceRegion findParentByLanguage(AbstractTraceRegion region, LanguageInfo info) {
		while(region != null && !isLanguage(region, info)) {
			region = region.getParent();
		}
		return region;
	}

	public Iterable<ILocationInResource> getAllAssociatedLocations(ITextRegion region, LanguageInfo language) {
		final Iterable<AbstractTraceRegion> allTraceRegions = getAllTraceRegions(region);
		Iterable<AbstractTraceRegion> filteredByLangauge = new TraceRegionsByLanguage(allTraceRegions, language);
		return toLocations(filteredByLangauge);
	}

	public Iterable<ILocationInResource> getAllLocations(LanguageInfo language) {
		final Iterable<AbstractTraceRegion> allTraceRegions = getAllTraceRegions();
		Iterable<AbstractTraceRegion> filteredByLangauge = new TraceRegionsByLanguage(allTraceRegions, language);
		return toLocations(filteredByLangauge);
	}

	@Override
	protected AbstractTraceRegion getRootTraceRegion() {
		IStorage resource = getDerivedResource();
		if (resource instanceof IResource) {
			IPath tracePath = resource.getFullPath().removeFileExtension().addFileExtension(FileBasedTraceInformation.TRACE_FILE_EXTENSION);
			IResource traceStorage = ((IResource) resource).getProject().findMember(tracePath);
			if (traceStorage instanceof IStorage && traceStorage.exists()) {
				InputStream contents = null;
				try {
					contents = ((IStorage) traceStorage).getContents();
					return traceRegionSerializer.readTraceRegionFrom(contents);
				} catch (CoreException e) {
					log.error(e.getMessage(), e);
					return null;
				} catch (IOException e) {
					log.error(e.getMessage(), e);
					return null;
				} finally {
					Closeables.closeQuietly(contents);
				}
			}
		}
		return null;
	}

	protected void setResource(IStorage derivedResource) {
		this.derivedResource = derivedResource;
	}

}
