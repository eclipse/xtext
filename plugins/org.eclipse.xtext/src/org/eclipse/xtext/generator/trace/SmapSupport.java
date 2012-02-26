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
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.LanguageInfo;
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
	
	@Inject private IResourceServiceProvider.Registry serviceProviderRegistry;

	public String generateSmap(AbstractTraceRegion rootTraceRegion, String outputFileName) {
		SmapGenerator generator = new SmapGenerator();
		generator.setOutputFileName(outputFileName);
		Map<String,SmapStratum> strata = newHashMap(); 
		createSmapInfo(rootTraceRegion, strata, -1);

		for (SmapStratum stratum : strata.values()) {
			generator.addStratum(stratum, true);
		}
		return generator.getString();
	}

	public void createSmapInfo(AbstractTraceRegion targetRegion, Map<String,SmapStratum> strata, int mappedLine) {
		if (mappedLine == targetRegion.getMyLineNumber()) {
			if (mappedLine == targetRegion.getMyEndLineNumber())
				return; //SKIP
			for (AbstractTraceRegion nested: targetRegion.getNestedRegions()) {
				createSmapInfo(nested, strata, mappedLine);
			}
		}
		ILocationData location = targetRegion.getMergedAssociatedLocation();
		if (location != null) {
			final URI path = targetRegion.getAssociatedPath();
			if (path != null) {
				final String fileName = path.trimFragment().lastSegment();
				SmapStratum stratum = strata.get(fileName);
				if (stratum == null) {
					IResourceServiceProvider provider = serviceProviderRegistry.getResourceServiceProvider(path.trimFragment());
					String name = provider.get(LanguageInfo.class).getShortName();
					stratum = new SmapStratum(name);
					strata.put(fileName, stratum);
				}
				stratum.addFile(fileName, getPath(path));
				stratum.addLineData(location.getLineNumber()+1, fileName, 1, targetRegion.getMyLineNumber()+1, 1);
			}
		}
		if (targetRegion.getMyLineNumber() != targetRegion.getMyEndLineNumber()) {
			for (AbstractTraceRegion nested: targetRegion.getNestedRegions()) {
				createSmapInfo(nested, strata, targetRegion.getMyLineNumber());
			}
		}
	}

	protected String getPath(URI path) {
		String fullPath = path.trimFragment().toPlatformString(true);
		final String substring = fullPath.substring(fullPath.substring(1).indexOf('/')+1);
		System.out.println(substring);
		return substring;
	}
	
	/**
	 * Installs the given SMAP as source debug extension on the given byte code.
	 */
	public InputStream getModifiedByteCode(String smap, InputStream originalByteCode) throws CoreException, IOException {
		byte[] byteCode = Files.readStreamIntoByteArray(originalByteCode);
		InputStream newByteCode = new ByteArrayInputStream(
				new SDEInstaller(byteCode, smap.getBytes()).getUpdatedByteCode());
		return newByteCode;
	}

}
