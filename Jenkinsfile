pipeline {
  agent {
    kubernetes {
      inheritFrom 'centos-8-6gb'
    }
  }

  parameters {
    choice(name: 'TARGET_PLATFORM', choices: ['r202203', 'r202206', 'r202209', 'r202212', 'r202303', 'latest'], description: 'Which Target Platform should be used?')
    // see https://wiki.eclipse.org/Jenkins#JDK
    choice(name: 'JDK_VERSION', description: 'Which JDK should be used?', choices: [
       'temurin-jdk11-latest', 'temurin-jdk17-latest'
    ])
  }

  triggers {
    parameterizedCron(env.BRANCH_NAME == 'main' ? '''
      H H(0-1) * * * %TARGET_PLATFORM=r202203;JDK_VERSION=temurin-jdk17-latest
      H H(3-4) * * * %TARGET_PLATFORM=latest;JDK_VERSION=temurin-jdk17-latest
      ''' : '')
  }

  options {
    buildDiscarder(logRotator(numToKeepStr:'10'))
    disableConcurrentBuilds()
    timeout(time: 360, unit: 'MINUTES')
  }

  tools {
     maven "apache-maven-3.8.6"
     jdk "temurin-jdk17-latest"
  }

  stages {
    stage('Initialize') {
      steps {
        checkout scm

        script {
          currentBuild.displayName = String.format("#%s(JDK%s,Eclipse%s)", BUILD_NUMBER, javaVersion(), eclipseVersion())
        }

        sh '''
            if [ -f "/sys/fs/cgroup/memory/memory.limit_in_bytes" ]; then
                echo "Available memory: $(cat /sys/fs/cgroup/memory/memory.limit_in_bytes | numfmt --to iec --format '%f')"
            fi

            sed_inplace() {
                if [[ "$OSTYPE" == "darwin"* ]]; then
                    sed -i '' "$@"
                else
                    sed -i "$@"
                fi
            }
        '''
      }
    }

    stage('Maven/Tycho Build & Test') {
      environment {
        MAVEN_OPTS = "-Xmx1500m"
        JAVA_HOME_11_X64 = tool(type:'jdk', name:'temurin-jdk11-latest')
        JAVA_HOME_17_X64 = tool(type:'jdk', name:'temurin-jdk17-latest')
      }
      steps {
        xvnc(useXauthority: true) {
          sh """
            ./full-build.sh --tp=${selectedTargetPlatform()} \
              ${javaVersion() == 17 ? '' : '--toolchains releng/toolchains.xml -Pstrict-release-jdk'}
          """
        }
      }// END steps
    } // END stage
  } // END stages

  post {
    always {
      junit testResults: '**/target/surefire-reports/*.xml'
    }
    success {
      archiveArtifacts artifacts: 'build/**, **/target/work/data/.metadata/.log'
    }
    unsuccessful {
      archiveArtifacts artifacts: 'org.eclipse.xtend.ide.swtbot.tests/screenshots/**, **/target/work/data/.metadata/.log, **/hs_err_pid*.log'
    }
    cleanup {
      script {
        def curResult = currentBuild.currentResult
        def lastResult = 'NEW'
        if (currentBuild.previousBuild != null) {
          lastResult = currentBuild.previousBuild.result
        }

        if (curResult != 'SUCCESS' || lastResult != 'SUCCESS') {
          def color = ''
          switch (curResult) {
            case 'SUCCESS':
              color = '#00FF00'
              break
            case 'UNSTABLE':
              color = '#FFFF00'
              break
            case 'FAILURE':
              color = '#FF0000'
              break
            default: // e.g. ABORTED
              color = '#666666'
          }

          slackSend (
            message: "${lastResult} => ${curResult}: <${env.BUILD_URL}|${env.JOB_NAME}#${env.BUILD_NUMBER}>",
            botUser: true,
            channel: 'xtext-builds',
            color: "${color}"
          )
        }
      }
    }
  }
}

/** return the Java version as Integer (8, 11, ...) */
def javaVersion() {
  return Integer.parseInt(params.JDK_VERSION.replaceAll(".*-jdk(\\d+).*", "\$1"))
}

/** returns true when this build was triggered by an upstream build */
def isTriggeredByUpstream() {
  return !"[]".equals(currentBuild.getBuildCauses('org.jenkinsci.plugins.workflow.support.steps.build.BuildUpstreamCause').toString())
}

/**
 * Returns the Eclipse version dependent on the selected target platform.
 * Result: '4.XX'
 */
def eclipseVersion() {
  def targetPlatform = selectedTargetPlatform()
  if (targetPlatform == 'latest') {
    return "4.28"
  } else {
    def baseDate = java.time.LocalDate.parse("2018-06-01") // 4.8 Photon
    def df = java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd")
    def targetDate = java.time.LocalDate.parse(targetPlatform.substring(1)+"01", df)
    long monthsBetween = java.time.temporal.ChronoUnit.MONTHS.between(baseDate, targetDate);
    return "4."+ (8+(monthsBetween/3))
  }
}

/**
 * The target platform is primarily defined by the build parameter TARGET_PLATFORM.
 * But when the build is triggered by upstream with at least Java version 11, 'latest'
 * is returned.
 */
def selectedTargetPlatform() {
    def tp = params.TARGET_PLATFORM
    def isUpstream = isTriggeredByUpstream()
    def javaVersion = javaVersion()

    if (isTriggeredByUpstream() && javaVersion>=17) {
        println("Choosing 'latest' target since this build was triggered by upstream with Java ${javaVersion}")
        return 'latest'
    } else if (isTriggeredByUpstream() && javaVersion>=11) {
        println("Choosing 'r202203' target since this build was triggered by upstream with Java ${javaVersion}")
        return 'r202203'
    } else {
        return tp
    }
}
