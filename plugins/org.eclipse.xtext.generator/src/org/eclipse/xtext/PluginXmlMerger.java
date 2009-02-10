/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class PluginXmlMerger {

	public Document readXml(File file) throws Exception {
		return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
	}
	
	public Document mergePluginXml(Document target, Document additions) {
		NodeList pluginNodes = target.getElementsByTagName("plugin");
		if(pluginNodes.getLength() != 1) {
			throw new IllegalArgumentException("Target plugin.xml has multiple <plugin> nodes");
		}
		Node targetPluginNode = pluginNodes.item(0);
		NodeList childNodes = additions.getElementsByTagName("extension");
		for(int i=0; i<childNodes.getLength(); ++i) {
			targetPluginNode.appendChild(childNodes.item(i));
		}
		return target;
	}
	
	public void writeXml(Document doc, File file) throws Exception {
		Source source = new DOMSource(doc);
		Result result = new StreamResult(file);
		Transformer xformer = TransformerFactory.newInstance().newTransformer();
		xformer.transform(source, result);
	}
}
