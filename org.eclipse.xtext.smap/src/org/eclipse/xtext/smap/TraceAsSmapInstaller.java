/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.smap;

import static com.google.common.collect.Maps.newHashMap;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ITraceToBytecodeInstaller;
import org.eclipse.xtext.generator.trace.LineMappingProvider;
import org.eclipse.xtext.generator.trace.LineMappingProvider.LineMapping;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TraceAsSmapInstaller implements ITraceToBytecodeInstaller {

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(TraceAsSmapInstaller.class);

	@Inject
	private LineMappingProvider lineMappingProvider;

	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;
	
	protected String smap;

	protected String generateSmap(AbstractTraceRegion rootTraceRegion, String outputFileName) {
		List<LineMapping> lineInfo = lineMappingProvider.getLineMapping(rootTraceRegion);
		if (lineInfo == null || lineInfo.isEmpty())
			return null;
		return toSmap(outputFileName, lineInfo);
	}

	protected String getStratumName(final SourceRelativeURI path) {
		IResourceServiceProvider provider = serviceProviderRegistry.getResourceServiceProvider(path.getURI());
		if (provider == null) {
			// it might happen that trace data is in the workspace but the corresponding language is not installed.
			// we use the file extension then.
			String result = path.getURI().fileExtension();
			if (result != null) {
				return result;
			}
			return "unknown";
		}
		final LanguageInfo languageInfo = provider.get(LanguageInfo.class);
		String name = languageInfo.getShortName();
		return name;
	}

	@Override
	public byte[] installTrace(byte[] javaClassBytecode) throws IOException {
		if (smap == null)
			return null;
		byte[] updatedByteCode = new SDEInstaller(javaClassBytecode, smap.getBytes()).getUpdatedByteCode();
		return updatedByteCode;
	}

	@Override
	public void setTrace(String javaFileName, AbstractTraceRegion trace) {
		smap = generateSmap(trace, javaFileName);
	}

	protected String toSmap(String outputFileName, List<LineMapping> lineInfo) {
		SmapGenerator generator = new SmapGenerator();
		generator.setOutputFileName(outputFileName);
		Map<String, SmapStratum> strata = newHashMap();
		for (LineMapping lm : lineInfo) {
			String stratumName = getStratumName(lm.source);
			if (!"Java".equals(stratumName)) {
				final String path = lm.source.getURI().path();
				if (path != null) {
					SmapStratum stratum = strata.get(stratumName);
					if (stratum == null) {
						stratum = new SmapStratum(stratumName);
						strata.put(stratumName, stratum);
						generator.addStratum(stratum, true);
					}
					final String sourceFileName = lm.source.getURI().lastSegment();
					stratum.addFile(sourceFileName, path);
					stratum.addLineData(lm.sourceStartLine, sourceFileName, 1, lm.targetStartLine + 1, lm.targetEndLine
							- lm.targetStartLine + 1);
				}
			}
		}
		return generator.getString();
	}
}
