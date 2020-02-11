/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.build;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.IFileSystemAccess;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Source2GeneratedMapping implements Externalizable {
	private final Multimap<URI, URI> source2generated;

	private final Multimap<URI, URI> generated2source;

	private final Map<URI, String> generated2OutputConfigName;

	public Source2GeneratedMapping() {
		this(HashMultimap.create(), HashMultimap.create(), new HashMap<>());
	}

	public Source2GeneratedMapping(Multimap<URI, URI> source2generated, Multimap<URI, URI> generated2source,
			Map<URI, String> generated2OutputConfigName) {
		this.source2generated = source2generated;
		this.generated2source = generated2source;
		this.generated2OutputConfigName = generated2OutputConfigName;
	}

	public Source2GeneratedMapping copy() {
		return new Source2GeneratedMapping(HashMultimap.create(source2generated), HashMultimap.create(generated2source),
				new HashMap<>(generated2OutputConfigName));
	}

	/**
	 * Add a mapping in the {@link IFileSystemAccess#DEFAULT_OUTPUT default output}.
	 */
	public void addSource2Generated(URI source, URI generated) {
		addSource2Generated(source, generated, IFileSystemAccess.DEFAULT_OUTPUT);
	}

	public void addSource2Generated(URI source, URI generated, String outputCfgName) {
		source2generated.put(source, generated);
		generated2source.put(generated, source);
		generated2OutputConfigName.put(generated,
				outputCfgName == null ? IFileSystemAccess.DEFAULT_OUTPUT : outputCfgName);
	}

	public void removeSource2Generated(URI source, URI generated) {
		source2generated.remove(source, generated);
		generated2source.remove(generated, source);
		if (!generated2source.containsKey(generated)) {
			generated2OutputConfigName.remove(generated);
		}
	}

	/**
	 * Mark the source as deleted and return all the former generated uris.
	 */
	public Set<URI> deleteSource(URI source) {
		Set<URI> generated = new HashSet<>(source2generated.removeAll(source));
		for (URI gen : generated) {
			generated2source.remove(gen, source);
			if (!generated2source.containsKey(gen)) {
				generated2OutputConfigName.remove(gen);
			}
		}
		return generated;
	}
	
	/**
	 * Mark the source as deleted and return all the former generated uris.
	 */
	public Map<URI, String> deleteSourceAndGetOutputConfigs(URI source) {
		Set<URI> generated = new HashSet<>(source2generated.removeAll(source));
		Map<URI, String> result = new HashMap<>();
		for (URI gen : generated) {
			generated2source.remove(gen, source);
			result.put(gen, generated2OutputConfigName.get(gen));
			if (!generated2source.containsKey(gen)) {
				generated2OutputConfigName.remove(gen);
			}
		}
		return result;
	}

	/**
	 * Remove the generated file from this mapping.
	 */
	public void deleteGenerated(URI generated) {
		generated2source.removeAll(generated).forEach(it -> {
			source2generated.remove(it, generated);
		});
		generated2OutputConfigName.remove(generated);
	}

	/**
	 * Get the output configuration that led to the given generated URI.
	 */
	public String getOutputConfigName(URI generated) {
		return generated2OutputConfigName.get(generated);
	}

	/**
	 * Return all the generated resources for the given source.
	 */
	public List<URI> getGenerated(URI source) {
		return new ArrayList<>(source2generated.get(source));
	}

	/**
	 * Return all the source resources for the given generated resource.
	 */
	public List<URI> getSource(URI generated) {
		return new ArrayList<>(generated2source.get(generated));
	}

	/**
	 * Return all the generated resources.
	 */
	public List<URI> getAllGenerated() {
		return new ArrayList<>(generated2source.keySet());
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		int numEntries = in.readInt();
		while (numEntries > 0) {
			numEntries--;
			URI source = URI.createURI(in.readUTF());
			int numGenerated = in.readInt();
			while (numGenerated > 0) {
				numGenerated--;
				URI generated = URI.createURI(in.readUTF());
				String outputConfig = in.readUTF();
				this.addSource2Generated(source, generated, outputConfig);
			}
		}
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		Set<Map.Entry<URI, Collection<URI>>> entries = source2generated.asMap().entrySet();
		out.writeInt(entries.size());
		for (Map.Entry<URI, Collection<URI>> it : entries) {
			out.writeUTF(it.getKey().toString());
			out.writeInt(it.getValue().size());
			for (URI value : it.getValue()) {
				out.writeUTF(value.toString());
				out.writeUTF(generated2OutputConfigName.get(value));
			}
		}
	}

}
