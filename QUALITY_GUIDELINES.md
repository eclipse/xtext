This page lists criteria that code, commits, and pull requests should fulfill.

## Commits and Pull Requests
 1. Commit messages should have a short message and a description. The description should explain: (a) What's changed. (b) What problem is fixed, or what feature does work now (c) What alternative solutions were discarded and why.
 2. Commit messages should refer to the Github Issue; if there is one, you can do so by prefixing your commit title with `[#issueTicketNr]`, e.g., `[#123]`. You can refer to a GitHub issue in another GitHub repository by prefixing the title of your commit with `[githubUser/githubRepo#issueTicketNr]`, e.g., `[eclipse/xtext#123]`.
 3. Pull Requests must have a cleaned-up sequence of commits. Please don't put unrelated changes in the same commit. Squash commits if they contribute to the exact logical change.
 4. Commits must be reviewable by a human. Do not re-format code that's otherwise not changed. Make sure commits don't become too large.
 5. Avoid putting generated and hand-written source codes in the same commit, except for small changes.
 6. Changes must have unit tests.
 7. Good changes are the ones that do not cause or even minimize future effort, e.g., bug fixes and follow-up feature requests.
 8. (Xtext Committers Only) PRs with peer reviews are required for changes to existing code, Xtext core, and new features, except for trivial changes (typo, docs).

## Source Code
 1. Readable and understandable source code is good source code.
 2. Keep the source code well-formatted, preferably with the Eclipse formatter.
 3. Put high-level comments in the code to explain your intention, solved use cases, design decisions, rejected solutions, etc. Do *not* duplicate what is obvious from the code itself. People will read code + documentation; therefore, documentation does not need to be self-contained.

## API
 1. We must not break binary backward compatibility of runtime artifacts. These are the artifacts an Xtext DSL user has installed. This does *not* include `xtext.generator` and test utilities.
 2. If we introduce breaking changes without violating the first rule, the DSL developer should be guided as well as possible through the migration efforts. E.g., through comments on `@Deprecated` annotations or log messages.
 3. We should be careful about what we make API because we will need to maintain it for a long time. When we introduce a new accessible class or method, these must be annotated with `@since <major>.<minor>`, where `<major>.<minor>` is the current major and minor versions, respectively.
