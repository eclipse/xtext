#!/usr/bin/env bash
if [ -z "$JENKINS_URL" ]; then
  # if not set in environment use default
  JENKINS_URL=https://ci.eclipse.org/xtext/
fi

if [ -f "/.dockerenv" ]; then
  export GRADLE_OPTS="-Dorg.gradle.daemon=false"
fi

./gradlew \
  clean cleanGenerateXtext build publish \
  -PuseJenkinsSnapshots=true \
  -PJENKINS_URL=$JENKINS_URL \
  -PcompileXtend=true \
  -PignoreTestFailures=true \
  --refresh-dependencies \
  --continue \
  $@
