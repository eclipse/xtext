/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.lib.AbstractWorkflowComponent2;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;
import org.openarchitectureware.workflow.util.ResourceLoaderFactory;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class CopyImages extends AbstractWorkflowComponent2 {

    private Log log = LogFactory.getLog(getClass());

    private String targetDir = null;

    public void setTargetDir(String targetDir) {
        this.targetDir = targetDir;
    }

    @Override
    protected void checkConfigurationInternal(Issues issues) {
        if (targetDir == null || !new File(targetDir).getParentFile().exists()) {
            issues.addError("Property targetDir not configured properly");
        }
    }

    @Override
    protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
        copyFiles(new String[] { "editor.gif" });
    }

    private void copyFiles(String[] files) {
        File target = new File(targetDir);
        if (!target.exists()) {
            target.mkdir();
        }
        for (String file : files) {
            File copy = new File(target.getAbsolutePath() + File.separatorChar + file);
            if (!copy.exists()) {
                String uri = "org/eclipse/xtext/ui/" + file;
                InputStream is = ResourceLoaderFactory.createResourceLoader().getResourceAsStream(uri);
                try {
                    copy.createNewFile();
                    FileOutputStream fwr = new FileOutputStream(copy);
                    byte[] buff = new byte[1024];
                    int read;
                    while ((read = is.read(buff)) != -1) {
                        fwr.write(buff, 0, read);
                    }
                    if (log.isDebugEnabled()) {
                        log.debug("Copied " + copy);
                    }
                }
                catch (IOException e) {
                    log.error(e);
                }
            }
        }
    }

}
