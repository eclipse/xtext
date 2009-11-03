/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.index;

import static com.google.common.collect.Iterables.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Singleton
public class NamesToURIs {

	private Set<Pair<String, URI>> namesToURIs = new HashSet<Pair<String, URI>>();

	public Iterable<URI> findURIs(final Set<String> names) {
		return transform(filter(namesToURIs, new Predicate<Pair<String, URI>>() {
			public boolean apply(Pair<String, URI> input) {
				return names.contains(input.getFirst());
			}
		}), new Function<Pair<String, URI>, URI>() {

			public URI apply(Pair<String, URI> from) {
				return from.getSecond();
			}
		});
	}

	public void deleteEntries(URI uri) {
		Iterator<Pair<String, URI>> iterator = namesToURIs.iterator();
		while (iterator.hasNext()) {
			Pair<String, URI> pair = iterator.next();
			if (pair.getSecond().equals(uri))
				iterator.remove();
		}
	}

	public void insert(URI uri, String name) {
		namesToURIs.add(Tuples.pair(name, uri));
	}

	protected void save() throws IOException {
		File file = getFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for (Pair<String, URI> element : namesToURIs) {
			writer.append(element.getFirst() + "|" + element.getSecond() + "\n");
		}
	}

	protected void load() throws IOException {
		File file = getFile();
		if (file.exists()) {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] strings = line.split("\\|");
				namesToURIs.add(Tuples.create(strings[0], URI.createURI(strings[1])));
			}
			file.delete();
		}
	}

	private File getFile() {
		IPath path = org.eclipse.xtext.ui.core.internal.Activator.getDefault().getStateLocation();
		File file = new File(path + "/namesToURI.data");
		return file;
	}

}
