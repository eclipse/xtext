/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build;

import java.util.Collection;
import java.util.HashSet;

public class XtextIdeaRefreshComponent {
    private final Collection<String> filesToReferesh;
    
    public XtextIdeaRefreshComponent() {
		filesToReferesh = new HashSet<String>();
	}

    public void refresh(String path) {
        filesToReferesh.add(path);
    }

    public Collection<String> getFilesToRefresh() {
        return filesToReferesh;
    }
}
