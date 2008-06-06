/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.ui.core.internal.CoreLog;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class LanguageDescriptorHierarchyUtil {

    public static class LanguageDescriptorDescriptor {
        public String languageId;
        public String languageName;
        public String namespace;
        public String superLanguageID;
    }

    public static List<LanguageDescriptorDescriptor> sortLanguageDescriptors(List<LanguageDescriptorDescriptor> descriptors) {
        List<LanguageDescriptorDescriptor> result = new ArrayList<LanguageDescriptorDescriptor>();
        List<LanguageDescriptorDescriptor> currentParents = null;
        do {
            currentParents = getDirectChildren(currentParents, descriptors);
            result.addAll(currentParents);
            descriptors.removeAll(currentParents);
        } while (!currentParents.isEmpty());
        if (!descriptors.isEmpty()) {
            StringBuffer error = new StringBuffer();
            for (LanguageDescriptorDescriptor descriptor : descriptors) {
                error.append("\n\t");
                error.append(descriptor.languageId);
            }
            CoreLog.logError(error.toString(), new IllegalArgumentException(
                    "Error in hierarchy of registered language descriptors. Skipping registration of "));
        }
        return result;
    }

    public static List<LanguageDescriptorDescriptor> getDirectChildren(List<LanguageDescriptorDescriptor> parents,
            List<LanguageDescriptorDescriptor> remainingDescriptors) {
        List<LanguageDescriptorDescriptor> directChildren = new ArrayList<LanguageDescriptorDescriptor>();
        for (LanguageDescriptorDescriptor descriptor : remainingDescriptors) {
            if (parents == null) {
                if (descriptor.superLanguageID == null) {
                    directChildren.add(descriptor);
                }
            } else {
                for (LanguageDescriptorDescriptor parent : parents) {
                    if (parent.languageId.equals(descriptor.superLanguageID)) {
                        directChildren.add(descriptor);
                    }
                }
            }
        }
        return directChildren;
    }
}
