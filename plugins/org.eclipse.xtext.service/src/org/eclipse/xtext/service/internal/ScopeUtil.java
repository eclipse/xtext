/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.service.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class ScopeUtil {
	
	private final static Log log = LogFactory.getLog(ScopeUtil.class);

    public static List<ScopeDescriptor> sortScopeDescriptors(List<ScopeDescriptor> descriptors) {
        List<ScopeDescriptor> result = new ArrayList<ScopeDescriptor>();
        List<ScopeDescriptor> currentParents = null;
        do {
            currentParents = getDirectChildren(currentParents, descriptors);
            result.addAll(currentParents);
            descriptors.removeAll(currentParents);
        } while (!currentParents.isEmpty());
        if (!descriptors.isEmpty()) {
            StringBuffer error = new StringBuffer();
            for (ScopeDescriptor descriptor : descriptors) {
                error.append("\n\t");
                error.append(descriptor.id);
            }
            log.error(error.toString(), new IllegalArgumentException(
                    "Error in hierarchy of registered language descriptors. Skipping registration of "));
        }
        return result;
    }

    public static List<ScopeDescriptor> getDirectChildren(List<ScopeDescriptor> parents,
            List<ScopeDescriptor> remainingDescriptors) {
        List<ScopeDescriptor> directChildren = new ArrayList<ScopeDescriptor>();
        for (ScopeDescriptor descriptor : remainingDescriptors) {
            if (parents == null) {
                if (descriptor.parentScope == null) {
                    directChildren.add(descriptor);
                }
            } else {
                for (ScopeDescriptor parent : parents) {
                    if (parent.id.equals(descriptor.parentScope)) {
                        directChildren.add(descriptor);
                    }
                }
            }
        }
        return directChildren;
    }

	public static void validateAndCleanUpDescriptors(List<ScopeDescriptor> scopes) {
		Iterator<ScopeDescriptor> iter = scopes.iterator();
		while (iter.hasNext()) {
			ScopeDescriptor next = iter.next();
			if (next.parentScope!=null) {
				boolean found = false;
				for (ScopeDescriptor scopeDescriptor : scopes) {
					if (scopeDescriptor.id.equals(next.parentScope)) {
						found=true;
					}
				}
				if (!found) {
					log.error("The parent scope "+next.parentScope+" of scope "+next.id+" is not registered. The scope "+next.id+" has been removed.");
					iter.remove();
				}
			}
		}
	}
}
