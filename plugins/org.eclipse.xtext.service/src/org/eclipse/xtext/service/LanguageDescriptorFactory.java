/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext.service;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.xtext.service.internal.LanguageDescriptor;

/**
 * 
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class LanguageDescriptorFactory {
    
    private static Map<String, ILanguageDescriptor> id2descriptorMap = new HashMap<String, ILanguageDescriptor>();
    
    public static ILanguageDescriptor get(String languageId) {
        ILanguageDescriptor languageDescriptor = id2descriptorMap.get(languageId);
        return languageDescriptor;
    }

    public static ILanguageDescriptor getByNamespace(String namespace) {
        for (ILanguageDescriptor languageDescriptor : id2descriptorMap.values()) {
            if(namespace.equals(languageDescriptor.getNameSpace())) {
                return languageDescriptor;
            }
        }
        return null;
    }
    
    public static ILanguageDescriptor createLanguageDescriptor(String languageId, String languageName, String namespace, ILanguageDescriptor superLanguage) {
        ILanguageDescriptor existingLanguageDescriptor = id2descriptorMap.get(languageId);
        if(existingLanguageDescriptor != null) {
            throw new IllegalArgumentException("LanguageDescriptor " + languageId + "already registered.");
        }
		LanguageDescriptor languageDescriptor = new LanguageDescriptor(languageId, languageName, namespace, superLanguage);
        id2descriptorMap.put(languageId, languageDescriptor);
        return languageDescriptor;
    }
    
    protected static void resetInternal() {
        id2descriptorMap.clear();
    }
}
