/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Maps.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.plugin.RegistryReader;

import com.google.inject.ImplementedBy;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(JvmModelInferrerRegistry.SingletonDelegatingRegistry.class)
public class JvmModelInferrerRegistry {
	
	public final static JvmModelInferrerRegistry INSTANCE = new JvmModelInferrerRegistry(); 
	
	private final static Logger log = Logger.getLogger(JvmModelInferrerRegistry.class);
	
	private volatile Map<String, List<IJvmModelInferrer>> map = null;
	
	private synchronized Map<String,List<IJvmModelInferrer>> getMap() {
		if (map == null) {
			map = initialize();
		}
		return map;
	}
	
	private boolean isUseRegistry = true;
	
	public void setUseRegistry(boolean isUseRegistry) {
		this.isUseRegistry = isUseRegistry;
	}
	
	public boolean isUseRegistry() {
		return isUseRegistry;
	}

	private Map<String, List<IJvmModelInferrer>> initialize() {
		Map<String,List<IJvmModelInferrer>> result = newLinkedHashMap(); 
		if (isUseRegistry)
			initializeFromRegistry(result);
		return result;
	}

	public List<? extends IJvmModelInferrer> getModelInferrer(String extension) {
		if (!getMap().containsKey(extension))
			return Collections.emptyList();
		return newArrayList(getMap().get(extension));
	}
	
	public void register(String extension, IJvmModelInferrer inferrer) {
		register(extension, inferrer, getMap());
	}
	
	protected void register(String extension, IJvmModelInferrer inferrer, Map<String, List<IJvmModelInferrer>> map) {
		if (!map.containsKey(extension)) {
			map.put(extension, new ArrayList<IJvmModelInferrer>());
		}
		List<IJvmModelInferrer> list = map.get(extension);
		int index = list.indexOf(inferrer);
		if (index == -1)
			list.add(inferrer);
		else {
			list.set(index, inferrer);
			log.error("Java translator "+inferrer+" for extension '"+extension+"' was already registered. Replaced it.");
		}
	}
	
	public void deregister(String extension, IJvmModelInferrer inferrer) {
		List<IJvmModelInferrer> list = getMap().get(extension);
		if (list != null)
			list.remove(inferrer);
	}
	
	private void initializeFromRegistry(final Map<String, List<IJvmModelInferrer>> map) {
		IExtensionRegistry eReg = Platform.getExtensionRegistry();
		new RegistryReader(eReg, "org.eclipse.xtext.xbase", "java_translation_participant") {
			
			@Override
			protected boolean readElement(IConfigurationElement element, boolean add) {
				if (element.getName().equals("javaTranslator")) {
					String fileExtension = element.getAttribute("fileExtension");
					if (fileExtension == null) {
						logMissingAttribute(element, "fileExtension");
					} else if (element.getAttribute("class") == null) {
						logMissingAttribute(element, "class");
					} else if (add) {
						register(fileExtension, new JvmModelInferrerDescriptor(element), map);
						return true;
					} else {
						return true;
					}
				}
				return false;
			}
		}.readRegistry();
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
		
		@Override
		public void deregister(String extension, IJvmModelInferrer inferrer) {
			INSTANCE.deregister(extension, inferrer);
		}
	}
}
