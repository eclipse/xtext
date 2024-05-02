/**
 * Copyright (c) 2024 Sigasi (http://www.sigasi.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.textmate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.emf.mwe2.runtime.Mandatory;

import com.google.gson.annotations.Expose;

/**
 * See the <a href="https://macromates.com/manual/en/language_grammars#rule_keys">TextMate specification</a>.
 * 
 * @author David Medina
 * @author Sebastian Zarnekow
 * @since 2.35
 */
public class BeginEndRule extends TextMateRule {

	@Expose private List<TextMateRule> patterns;
	@Expose private String begin;
	@Expose private String end;
	@Expose private String contentName;
	@Expose private Map<Integer, Capture> captures;
	@Expose private Map<Integer, Capture> beginCaptures;
	@Expose private Map<Integer, Capture> endCaptures;
	
	@Mandatory
	@Override
	public void setName(String name) {
		super.setName(name);
	}
	
	public String getBegin() {
		return begin;
	}
	@Mandatory
	public void setBegin(String begin) {
		this.begin = begin;
	}
	public String getEnd() {
		return end;
	}
	@Mandatory
	public void setEnd(String end) {
		this.end = end;
	}	
	
	public void addMatchPattern(MatchRule rule) {
		if (patterns == null) {
			patterns = new ArrayList<>();
		}
		this.patterns.add(rule);
	}
	
	public void addBeginEndPattern(BeginEndRule rule) {
		if (patterns == null) {
			patterns = new ArrayList<>();
		}
		this.patterns.add(rule);
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}
	
	public void addInclude(String include) {
		if (patterns == null) {
			patterns = new ArrayList<>();
		}
		this.patterns.add(new IncludeRule(include));
	}
	
	public void addBeginEndCapture(Capture c) {
		if (beginCaptures == null) {
			beginCaptures = new TreeMap<>();
		}
		beginCaptures.put(c.getGroup(), c);
	}
	
	public void addEndCapture(Capture c) {
		if (endCaptures == null) {
			endCaptures = new TreeMap<>();
		}
		endCaptures.put(c.getGroup(), c);
	}
	
	public void addCapture(Capture c) {
		if (captures == null) {
			captures = new TreeMap<>();
		}
		captures.put(c.getGroup(), c);
	}
	
	
}