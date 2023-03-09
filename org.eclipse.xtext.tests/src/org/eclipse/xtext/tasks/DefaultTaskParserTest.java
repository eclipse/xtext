/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.tasks;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
public class DefaultTaskParserTest {
	private ITaskParser parser;

	private TaskTags definitions;

	private final TaskTag TODO = new TaskTag("TODO", Priority.NORMAL);

	private final TaskTag todo = new TaskTag("todo", Priority.NORMAL);

	@Before
	public void setup() {
		parser = new DefaultTaskParser();
		definitions = new DefaultTaskTagProvider().getTaskTags(null);
	}

	@Test
	public void testTasksWithDifferentCase() {
		parser = new DefaultTaskParser();
		definitions = new TaskTags();
		definitions.setCaseSensitive(true);
		definitions.getTaskTags().addAll(Lists.newArrayList(TODO, todo));
		Task task1 = new Task();
		task1.setTag(TODO);
		task1.setDescription(" uppercase match");
		task1.setLineNumber(2);
		task1.setOffset(6);
		Task task2 = new Task();
		task2.setTag(todo);
		task2.setDescription(" lowercase match");
		task2.setLineNumber(3);
		task2.setOffset(30);
		assertContainsTasks(
				"/*\n" +
				" * TODO uppercase match\n" +
				" * todo lowercase match\n" +
				" */\n",
				Lists.newArrayList(task1, task2));
	}

	@Test
	public void testTasksWithDifferentCaseCaseInsensitive() {
		parser = new DefaultTaskParser();
		definitions = new TaskTags();
		definitions.setCaseSensitive(false);
		definitions.getTaskTags().addAll(Lists.newArrayList(TODO, todo));
		Task task1 = new Task();
		task1.setTag(TODO);
		task1.setDescription(" uppercase match");
		task1.setLineNumber(2);
		task1.setOffset(6);
		Task task2 = new Task();
		task2.setTag(TODO);
		task2.setDescription(" lowercase match");
		task2.setLineNumber(3);
		task2.setOffset(30);
		assertContainsTasks(
				"/*\n" +
				" * TODO uppercase match\n" +
				" * todo lowercase match\n" +
				" */\n",
				Lists.newArrayList(task1, task2));
	}

	@Test
	public void testTasksWithDifferentCasePriorityMergeIfHigher() {
		parser = new DefaultTaskParser();
		definitions = new TaskTags();
		definitions.setCaseSensitive(false);
		definitions.getTaskTags().addAll(Lists.newArrayList(TODO, new TaskTag("todo", Priority.HIGH)));
		Task task1 = new Task();
		task1.setTag(new TaskTag("todo", Priority.HIGH));
		task1.setDescription(" uppercase match");
		task1.setLineNumber(2);
		task1.setOffset(6);
		Task task2 = new Task();
		task2.setTag(new TaskTag("todo", Priority.HIGH));
		task2.setDescription(" lowercase match");
		task2.setLineNumber(3);
		task2.setOffset(30);
		assertContainsTasks(
				"/*\n" +
				" * TODO uppercase match\n" +
				" * todo lowercase match\n" +
				" */\n",
				Lists.newArrayList(task1, task2));
	}

	@Test
	public void testTasksWithDifferentCasePriorityNoMergeIfLower() {
		parser = new DefaultTaskParser();
		definitions = new TaskTags();
		definitions.setCaseSensitive(false);
		definitions.getTaskTags().addAll(Lists.newArrayList(TODO, new TaskTag("todo", Priority.LOW)));
		Task task1 = new Task();
		task1.setTag(TODO);
		task1.setDescription(" uppercase match");
		task1.setLineNumber(2);
		task1.setOffset(6);
		Task task2 = new Task();
		task2.setTag(TODO);
		task2.setDescription(" lowercase match");
		task2.setLineNumber(3);
		task2.setOffset(30);
		assertContainsTasks(
				"/*\n" +
				" * TODO uppercase match\n" +
				" * todo lowercase match\n" +
				" */\n",
				Lists.newArrayList(task1, task2));
	}

	@Test
	public void testTasksWithDifferentCasePriorityNoMergeIfSame() {
		parser = new DefaultTaskParser();
		definitions = new TaskTags();
		definitions.setCaseSensitive(false);
		definitions.getTaskTags().addAll(Lists.newArrayList(TODO, todo));
		Task task1 = new Task();
		task1.setTag(TODO);
		task1.setDescription(" uppercase match");
		task1.setLineNumber(2);
		task1.setOffset(6);
		Task task2 = new Task();
		task2.setTag(TODO);
		task2.setDescription(" lowercase match");
		task2.setLineNumber(3);
		task2.setOffset(30);
		assertContainsTasks(
				"/*\n" +
				" * TODO uppercase match\n" +
				" * todo lowercase match\n" +
				" */\n",
				Lists.newArrayList(task1, task2));
	}

	@Test
	public void testCaseInSensitive() {
		definitions.setCaseSensitive(false);
		Task task = new Task();
		task.setTag(new TaskTag("FIXME", Priority.HIGH));
		task.setDescription(" case insensitive match");
		task.setLineNumber(2);
		task.setOffset(6);
		assertContainsTasks(
				"/*\n" +
				" * FixMe case insensitive match\n" +
				" */\n",
				Lists.newArrayList(task));
	}

	@Test
	public void testCaseSensitive() {
		Task task1 = new Task();
		task1.setTag(TODO);
		task1.setDescription(" this is a task");
		task1.setLineNumber(1);
		task1.setOffset(3);
		Task task2 = new Task();
		task2.setTag(new TaskTag("FIXME", Priority.HIGH));
		task2.setDescription(" this cannot work");
		task2.setLineNumber(2);
		task2.setOffset(26);
		Task task3 = new Task();
		task3.setTag(new TaskTag("XXX", Priority.NORMAL));
		task3.setDescription(": god, this is bad");
		task3.setLineNumber(3);
		task3.setOffset(52);
		Task task4 = new Task();
		task4.setTag(TODO);
		task4.setDescription("");
		task4.setLineNumber(4);
		task4.setOffset(77);
		assertContainsTasks(
				"/* TODO this is a task\n" +
				" * FIXME this cannot work\n" +
				" * XXX: god, this is bad\n" +
				" * TODO\n" +
				" * FixMe this should not match\n" +
				" */\n",
				Lists.newArrayList(task1, task2, task3, task4));
	}

	@Test
	public void testLongInputManyTasks() {
		int expectation = 100000;
		StringBuilder builder = new StringBuilder();
		builder.append("/*\n");
		for (int i = 1; i <= expectation; i++) {
			builder.append(" * FIXME this cannot work\n");
		}
		builder.append(" */\n");
		String source = builder.toString();
		List<Task> parsed = parser.parseTasks(source, definitions);
		Assert.assertEquals(expectation, parsed.size());
		for (int i = 0; i < expectation; i++) {
			Assert.assertEquals(i+ 2, parsed.get(i).getLineNumber());
		}
	}

	private void assertContainsTasks(String source, List<Task> expectedTasks) {
		List<Task> actualTasks = parser.parseTasks(source, definitions);
		Assert.assertEquals(expectedTasks.size(), actualTasks.size());
		for (int i = 0; i < expectedTasks.size(); i++) {
			Assert.assertEquals(expectedTasks.get(i), actualTasks.get(i));
		}
	}
}
