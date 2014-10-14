package org.xtext.idea.build;

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
