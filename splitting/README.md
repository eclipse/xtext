# Repository Splitting

This project provides tools for splitting the Xtext repository as described [in the Wiki](https://github.com/eclipse/xtext/wiki/Restructuring). This is the proposed work flow:

 1. `../gradlew findProjects` creates `build/splitting/all-projects.txt`, a list of all projects (paths with a `.project` file) that have ever been in the history, and `build/splitting/unmapped-paths.txt`, a list of paths that are not covered by any project.
 2. Create `splitting.txt` based on the results of the previous step. This file must consist of lines of the form `path >> target-repos`, where `path` can be any file or directory in the repository and `target-repos` is either `delete` or a list of repository ids where that path should be included.
 3. `../gradlew clean validateSplitting` checks whether `splitting.txt` covers all files found in the history.
 4. `../gradlew generateRemovals` creates `build/splitting/removals-*.txt` for each target repository.

Now you have all necessary data to perform the actual splitting. In order to do this:

 1. Create and checkout a new branch.
 2. Run `../gradlew *FilterBranch`, where `*` is the target repository id.
 3. Find something else to do (on my machine the previous command takes more than one hour).
 4. Push the resulting branch to the corresponding repository.
