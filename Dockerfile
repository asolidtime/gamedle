FROM gitpod/workspace-full-vnc
                    
USER gitpod

# Install custom tools, runtime, etc. using apt-get
# For example, the command below would install "bastet" - a command line tetris clone:
#
# RUN sudo apt-get -q update && #     sudo apt-get install -yq bastet && #     sudo rm -rf /var/lib/apt/lists/*
#
# More information: https://www.gitpod.io/docs/42_config_docker/

ENV ANDROID_HOME /opt/android-sdk-linux

USER root

RUN apt update -qq && apt install zip unzip

RUN cd /opt && \
    wget https://dl.google.com/android/repository/sdk-tools-linux-4333796.zip && \
    unzip -q *.zip -d ${ANDROID_HOME} && \
    rm *.zip

RUN chmod -R 777 ${ANDROID_HOME}

RUN apt clean -qq

USER gitpod

ENV PATH ${PATH}:${ANDROID_HOME}/tools:${ANDROID_HOME}/tools/bin:${ANDROID_HOME}/platform-tools

RUN bash -c "source ~/.sdkman/bin/sdkman-init.sh && \
                sdk install java 8.0.232-open"

RUN yes | sdkmanager --licenses

RUN yes | sdkmanager --update --channel=3
Please keep all sections in descending order!
RUN yes | sdkmanager \
   "platforms;android-29" \
   "build-tools;29.0.3" \
   "system-images;android-29;google_apis;x86" \
   "extras;android;m2repository" \
   "extras;google;m2repository" \
   "extras;google;google_play_services" \
   "extras;m2repository;com;android;support;constraint;constraint-layout;1.0.2" \
   "extras;m2repository;com;android;support;constraint;constraint-layout;1.0.1" \
   "add-ons;addon-google_apis-google-23" \
   "add-ons;addon-google_apis-google-22" \
   "add-ons;addon-google_apis-google-21"