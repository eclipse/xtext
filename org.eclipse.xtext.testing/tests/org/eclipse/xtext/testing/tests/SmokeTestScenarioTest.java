/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.testing.tests;

import java.util.List;

import org.eclipse.xtext.testing.smoketest.DeltaScenarioProcessor;
import org.eclipse.xtext.testing.smoketest.Scenario;
import org.eclipse.xtext.testing.smoketest.ScenarioProcessor;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow
 */
public class SmokeTestScenarioTest {

	@Test public void testSkipLastCharacters_01() throws Exception {
		RecordingScenarioProcessor processor = new RecordingScenarioProcessor();
		Scenario.SkipLastCharacters.processInput("abcde", processor);
		List<String> expectation = Lists.newArrayList("", "a", "ab", "abc", "abcd", "abcde");
		
		Assert.assertEquals(join(expectation), join(processor.recorded));
	}
	
	@Test public void testSkipLastCharacters_02() throws Exception {
		RecordingScenarioDeltaProcessor processor = new RecordingScenarioDeltaProcessor();
		Scenario.SkipLastCharacters.processInput("abcde", processor);
		List<RecordingScenarioDeltaProcessor.Record> expectation = Lists.newArrayList(
				$("abcde", "", 0, 0, ""),
				$("abcde", "", 0, 0, "a"),
				$("abcde", "a", 1, 0, "b"),
				$("abcde", "ab", 2, 0, "c"),
				$("abcde", "abc", 3, 0, "d"),
				$("abcde", "abcd", 4, 0, "e")
		);
		
		Assert.assertEquals(join(expectation), join(processor.recorded));
	}
	
	@Test public void testSkipFirstCharacters_01() throws Exception {
		RecordingScenarioProcessor processor = new RecordingScenarioProcessor();
		Scenario.SkipFirstCharacters.processInput("abcde", processor);
		List<String> expectation = Lists.newArrayList("abcde", "bcde", "cde", "de", "e", "");
		
		Assert.assertEquals(join(expectation), join(processor.recorded));
	}
	
	@Test public void testSkipFirstCharacters_02() throws Exception {
		RecordingScenarioDeltaProcessor processor = new RecordingScenarioDeltaProcessor();
		Scenario.SkipFirstCharacters.processInput("abcde", processor);
		List<RecordingScenarioDeltaProcessor.Record> expectation = Lists.newArrayList(
				$("abcde", "abcde", 0, 0, ""),
				$("abcde", "abcde", 0, 1, ""),
				$("abcde", "bcde", 0, 1, ""),
				$("abcde", "cde", 0, 1, ""),
				$("abcde", "de", 0, 1, ""),
				$("abcde", "e", 0, 1, "")
		);
		
		Assert.assertEquals(join(expectation), join(processor.recorded));
	}
	
	@Test public void testSkipCharacterInBetween_01() throws Exception {
		RecordingScenarioProcessor processor = new RecordingScenarioProcessor();
		Scenario.SkipCharacterInBetween.processInput("abcde", processor);
		List<String> expectation = Lists.newArrayList("acde", "abde", "abce", "abcd");
		
		Assert.assertEquals(join(expectation), join(processor.recorded));
	}
	
	@Test public void testSkipCharacterInBetween_02() throws Exception {
		RecordingScenarioDeltaProcessor processor = new RecordingScenarioDeltaProcessor();
		Scenario.SkipCharacterInBetween.processInput("abcde", processor);
		List<RecordingScenarioDeltaProcessor.Record> expectation = Lists.newArrayList(
				$("abcde", "bcde", 0, 1, "a"),
				$("abcde", "acde", 1, 1, "b"),
				$("abcde", "abde", 2, 1, "c"),
				$("abcde", "abce", 3, 1, "d")
		);
		
		Assert.assertEquals(join(expectation), join(processor.recorded));
	}
	
	@Test public void testSkipThreeCharactersInBetween_01() throws Exception {
		RecordingScenarioProcessor processor = new RecordingScenarioProcessor();
		Scenario.SkipThreeCharactersInBetween.processInput("abcdefg", processor);
		List<String> expectation = Lists.newArrayList("defg", "aefg", "abfg", "abcg", "abcd");
		
		Assert.assertEquals(join(expectation), join(processor.recorded));
	}
	
	@Test public void testSkipThreeCharactersInBetween_02() throws Exception {
		RecordingScenarioDeltaProcessor processor = new RecordingScenarioDeltaProcessor();
		Scenario.SkipThreeCharactersInBetween.processInput("abcdefg", processor);
		List<RecordingScenarioDeltaProcessor.Record> expectation = Lists.newArrayList(
				$("abcdefg", "defg", 0, 0, ""),
				$("abcdefg", "defg", 0, 1, "a"),
				$("abcdefg", "aefg", 1, 1, "b"),
				$("abcdefg", "abfg", 2, 1, "c"),
				$("abcdefg", "abcg", 3, 1, "d")
				);
		
		Assert.assertEquals(join(expectation), join(processor.recorded));
	}

	private String join(List<?> records) {
		return Joiner.on('\n').join(records);
	}
	
	private RecordingScenarioDeltaProcessor.Record $(String completeData, String data, int offset,
					int len, String change) {
		return new RecordingScenarioDeltaProcessor.Record(completeData, data, offset, len, change);
	}
	
	static class RecordingScenarioProcessor extends ScenarioProcessor {

		private List<String> recorded = Lists.newArrayList();
		
		@Override
		public void processFile(String data) throws Exception {
			recorded.add(data);
		}
		
	}
	
	static class RecordingScenarioDeltaProcessor extends DeltaScenarioProcessor {

		static class Record {
			String completeData;
			String data;
			int offset;
			int len;
			String change;
			public Record(String completeData, String data, int offset,
					int len, String change) {
				super();
				this.completeData = completeData;
				this.data = data;
				this.offset = offset;
				this.len = len;
				this.change = change;
			}
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result
						+ ((change == null) ? 0 : change.hashCode());
				result = prime
						* result
						+ ((completeData == null) ? 0 : completeData.hashCode());
				result = prime * result
						+ ((data == null) ? 0 : data.hashCode());
				result = prime * result + len;
				result = prime * result + offset;
				return result;
			}
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Record other = (Record) obj;
				if (change == null) {
					if (other.change != null)
						return false;
				} else if (!change.equals(other.change))
					return false;
				if (completeData == null) {
					if (other.completeData != null)
						return false;
				} else if (!completeData.equals(other.completeData))
					return false;
				if (data == null) {
					if (other.data != null)
						return false;
				} else if (!data.equals(other.data))
					return false;
				if (len != other.len)
					return false;
				if (offset != other.offset)
					return false;
				return true;
			}
			@Override
			public String toString() {
				StringBuilder builder = new StringBuilder();
				builder.append("Record [");
				if (completeData != null) {
					builder.append("completeData=");
					builder.append(completeData);
					builder.append(", ");
				}
				if (data != null) {
					builder.append("data=");
					builder.append(data);
					builder.append(", ");
				}
				builder.append("offset=");
				builder.append(offset);
				builder.append(", len=");
				builder.append(len);
				builder.append(", ");
				if (change != null) {
					builder.append("change=");
					builder.append(change);
				}
				builder.append("]");
				return builder.toString();
			}
		}
		
		private List<Record> recorded = Lists.newArrayList();
		
		@Override
		public String processFile(String completeData, String data, int offset,
				int len, String change) throws Exception {
			recorded.add(new Record(completeData, data, offset, len, change));
			return applyDelta(data, offset, len, change);
		}
		
	}
	
}
