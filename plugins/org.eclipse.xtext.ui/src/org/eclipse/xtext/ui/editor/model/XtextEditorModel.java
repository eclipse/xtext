/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ISynchronizable;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.SyntaxError;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class XtextEditorModel extends AbstractDocumentDelegation implements IEditorModel {
	
	private static final Logger log = Logger.getLogger(XtextEditorModel.class);

    private final IDocument document;
    private IDocumentListener dirtyListener;
    private final IServiceScope languageDescriptor;
    private XtextResource resource;

    public XtextEditorModel(XtextResource resource, IDocument document, IServiceScope languageDescriptor) {
        this.document = document;
        this.resource = resource;
        if (resource.getParseResult() == null) {
            try {
                resource.load(new StringInputStream(document.get()), null);
            }
            catch (IOException e) {
                log.error("IO Exception", e);
            }
        }
        this.languageDescriptor = languageDescriptor;
    }

    public IServiceScope getLanguageDescriptor() {
        return languageDescriptor;
    }

    private Object getLockObject() {
        if (document instanceof ISynchronizable) {
            Object lock = ((ISynchronizable) document).getLockObject();
            if (lock != null) {
                return lock;
            }
        }
        return this;
    }

    public void reconcile(IRegion region) {
        synchronized (dirtyLock) {
            if (!dirty) {
                return;
            }
            else {
                dirty = false;
            }
        }
        synchronized (getLockObject()) {
            internalReconcile(region);
        }
    }

    private void internalReconcile(IRegion region) {
        try {
            if (Activator.DEBUG_PARSING)
                log.debug("EditorModel Parsing...");
            long start = System.currentTimeMillis();
            resource.update(region.getOffset(), document.get(region.getOffset(), region.getLength()));
            if (Activator.DEBUG_PARSING)
                log.debug("...took " + (System.currentTimeMillis() - start) + "ms.");
        }
        catch (Exception e) {
            if (Activator.DEBUG_PARSING) {
                log.warn("Reconciling failed.", e);
            }
        }
        finally {
            notifyModelListeners(new XtextEditorModelChangeEvent(this));
        }
    }

    public AbstractNode getParseTreeRootNode() {
        return resource.getParseResult().getRootNode();
    }

    public AbstractNode getParseTreeRootNode(boolean reconcile) {
        if (reconcile) {
            if (document != null) {
                reconcile(new Region(0, document.getLength()));
            }
        }
        return getParseTreeRootNode();
    }

    public EObject getAstRoot() {
        return resource.getParseResult().getRootASTElement();
    }

    public EObject getAstRoot(boolean reconcile) {
        if (reconcile) {
            if (document != null) {
                reconcile(new Region(0, document.getLength()));
            }
        }
        return getAstRoot();
    }

    protected boolean dirty = true;
    protected Object dirtyLock = new Object();

    public void install() {
        dirtyListener = new IDocumentListener() {

            public void documentAboutToBeChanged(DocumentEvent event) {
                synchronized (dirtyLock) {
                    dirty = true;
                }
            }

            public void documentChanged(DocumentEvent event) {
            }
        };
        document.addDocumentListener(dirtyListener);
    }

    public void uninstall() {
        document.removeDocumentListener(dirtyListener);
    }

    private Set<IXtextEditorModelListener> xtextModelListeners = new HashSet<IXtextEditorModelListener>();

    public void addModelListener(IXtextEditorModelListener listener) {
        synchronized (xtextModelListeners) {
            if (!xtextModelListeners.add(listener)) {
                throw new IllegalStateException("Can't add editor model listener because it already exists.");
            }
        }
    }

    public void removeModelListener(IXtextEditorModelListener listener) {
        synchronized (xtextModelListeners) {
            if (!xtextModelListeners.remove(listener)) {
                throw new IllegalStateException("Can't remove editor model listener because it does not exist.");
            }
        }
    }

    private void notifyModelListeners(XtextEditorModelChangeEvent event) {
        Iterator<IXtextEditorModelListener> iterator;
        synchronized (xtextModelListeners) {
            iterator = xtextModelListeners.iterator();
        }
        while (iterator.hasNext()) {
            IXtextEditorModelListener listener = iterator.next();
            listener.modelChanged(event);
        }
    }

    public List<SyntaxError> getSyntaxErrors() {
        return resource.getParseResult().getParseErrors();
    }

    public boolean hasErrors() {
        return getSyntaxErrors() != null && !getSyntaxErrors().isEmpty();
    }

    public XtextResource getResource() {
        return resource;
    }

}
