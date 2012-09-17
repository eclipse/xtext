/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import static com.google.common.collect.Maps.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.inject.ImplementedBy;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(JvmModelInferrerRegistry.SingletonDelegatingRegistry.class)
public class JvmModelInferrerRegistry {
	
	public final static JvmModelInferrerRegistry INSTANCE = new JvmModelInferrerRegistry(); 
	
	private final static Logger log = Logger.getLogger(JvmModelInferrerRegistry.class);
	
	private Map<String, List<IJvmModelInferrer>> map = newHashMap();

	public List<? extends IJvmModelInferrer> getModelInferrer(String extension) {
		if (!map.containsKey(extension))
			return Collections.emptyList();
		return Collections.unmodifiableList(map.get(extension));
	}
	
	public void register(String extension, IJvmModelInferrer inferrer) {
		if (!map.containsKey(extension)) {
			map.put(extension, new ArrayList<IJvmModelInferrer>());
		}
		List<IJvmModelInferrer> list = map.get(extension);
		if (!list.contains(inferrer))
			list.add(inferrer);
		else 
			log.error("Java translator "+inferrer+" for extension '"+extension+"' was already registered.");
	}
	
	
	@Singleton
	public static class SingletonDelegatingRegistry extends JvmModelInferrerRegistry {
		
		@Override
		public void register(String extension, IJvmModelInferrer inferrer) {
			INSTANCE.register(extension, inferrer);
		}
		
		@Override
		public List<? extends IJvmModelInferrer> getModelInferrer(String extension) {
			return INSTANCE.getModelInferrer(extension);
		}
	}
}
