/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import static com.google.common.collect.Maps.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.generator.trace.LineMappingProvider.LineMapping;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.smap.SDEInstaller;
import org.eclipse.xtext.smap.SmapGenerator;
import org.eclipse.xtext.smap.SmapStratum;
import org.eclipse.xtext.util.Files;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class SmapSupport {
	
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(SmapSupport.class);
	
	@Inject private IResourceServiceProvider.Registry serviceProviderRegistry;
	
	@Inject private LineMappingProvider lineMappingProvider;

	public @Nullable String generateSmap(AbstractTraceRegion rootTraceRegion, String outputFileName) {
		List<LineMapping> lineInfo = lineMappingProvider.getLineMapping(rootTraceRegion);
		if (lineInfo == null || lineInfo.isEmpty())
			return null;
		return toSmap(outputFileName, lineInfo);
	}

	protected String toSmap(String outputFileName, List<LineMapping> lineInfo) {
		SmapGenerator generator = new SmapGenerator();
		generator.setOutputFileName(outputFileName);
		Map<String,SmapStratum> strata = newHashMap(); 
		for (LineMapping lm : lineInfo) {
			String stratumName = getStratumName(lm.source);
			if (!"Java".equals(stratumName)) {
				final String path = getPath(lm.source);
				if (path != null) {
					SmapStratum stratum = strata.get(stratumName);
					if (stratum == null) {
						stratum = new SmapStratum(stratumName);
						strata.put(stratumName, stratum);
						generator.addStratum(stratum, true);
					}
					final String fileName = lm.source.lastSegment();
					stratum.addFile(fileName, path);
					stratum.addLineData(lm.sourceStartLine, fileName, 1, lm.targetStartLine+1, lm.targetEndLine - lm.targetStartLine + 1);
				}
			}
		}
		return generator.getString();
	}
	
	protected String getStratumName(final URI path) {
		IResourceServiceProvider provider = serviceProviderRegistry.getResourceServiceProvider(path.trimFragment());
		if (provider == null) {
			// it might happen that trace data is in the workspace but the corresponding language is not installed.
			// we use the file extension then.
			return path.fileExtension() != null ? path.fileExtension() : "unknown";
		}
		final LanguageInfo languageInfo = provider.get(LanguageInfo.class);
		String name = languageInfo.getShortName();
		return name;
	}

	protected String getPath(URI path) {
		if (!path.isPlatformResource())
			return null;
		String fullPath = path.trimFragment().toPlatformString(true);
		final String substring = fullPath.substring(fullPath.substring(1).indexOf('/')+1);
		return substring;
	}
	
	/**
	 * Installs the given SMAP as source debug extension on the given byte code.
	 */
	public InputStream getModifiedByteCode(String smap, InputStream originalByteCode) throws CoreException, IOException {
		byte[] byteCode = Files.readStreamIntoByteArray(originalByteCode);
		byte[] updatedByteCode = new SDEInstaller(byteCode, smap.getBytes()).getUpdatedByteCode();
		InputStream newByteCode = new ByteArrayInputStream(
				updatedByteCode);
		return newByteCode;
	}
}
