#!/bin/bash

# process all the xtext repositories
cat <(cat locations.properties | head -n 1 | sed 's/xtext-[^/]*/xtext-eclipse/') <(cat locations.properties) | cut -d "=" -f2- | while read -r line
do
	directory=$(echo $line | tr -d '\r')
	upstream=$(echo $directory/gradle/upstream-repositories.gradle)
# if the directory has a gradle build with upstream dependencies
        if [[ -e $upstream ]]
	then
		pushd $directory > /dev/null
		if [[ $? = 0 ]]
		then
			git show-branch "$1" &> /dev/null
			if [[ $? = 0 ]]
			then
				echo "Redirecting job configuration in $upstream to $1"
# if there exists a local branch in the repository
				popd > /dev/null
				cat <(cat locations.properties | head -n 1 | sed 's/xtext-[^/]*/xtext-eclipse/') <(cat locations.properties) | cut -d "=" -f2- | while read -r repo
				do
# loop over all potential 
					repository=$(echo $repo | tr -d '\r')
					if [[ $directory != $repository ]]
					then
						logicalname=$(echo $repo | sed 's/^.*\/\(xtext-[^/]*\)\/.*$/\1/')
						pushd $repository > /dev/null
						if [[ $? = 0 ]]
						then
							sed -i '' "s%'http://services.typefox.io/open-source/jenkins/job/$logicalname/job/[^/]*/lastSuccessfulBuild/artifact/build/maven-repository/'%jenkinsPipelineRepo('$logicalname')%" $upstream
							if [[ $1 != master ]]
							then
								git show-branch "$1" &> /dev/null && sed -i '' "s%jenkinsPipelineRepo('$logicalname')%'http://services.typefox.io/open-source/jenkins/job/$logicalname/job/$1/lastSuccessfulBuild/artifact/build/maven-repository/'%" $upstream 
							fi
							popd > /dev/null
						fi
					fi
				done
			else
				popd > /dev/null
			fi
		fi
	fi	
done 
