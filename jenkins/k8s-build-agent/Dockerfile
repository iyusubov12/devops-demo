FROM docker

ENV VERSION v2.14.3

#Install curl
RUN apk add --update bash libstdc++ curl zip \
 && rm -rf /var/cache/apk/*

#Intsall Java
RUN apk --update add openjdk8
RUN rm /bin/sh \
 && ln -s /bin/bash /bin/sh
ENV JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk

#Install python
RUN apk add --update python

#Install GIT
RUN apk add --update git

# Install Gcloud
RUN curl https://dl.google.com/dl/cloudsdk/release/google-cloud-sdk.tar.gz > /tmp/google-cloud-sdk.tar.gz
RUN mkdir -p /usr/local/gcloud &&\
  tar -C /usr/local/gcloud -xvf /tmp/google-cloud-sdk.tar.gz &&\
  /usr/local/gcloud/google-cloud-sdk/install.sh

# Install Helm
ENV FILENAME helm-${VERSION}-linux-amd64.tar.gz
ENV HELM_URL https://storage.googleapis.com/kubernetes-helm/${FILENAME}

RUN echo $HELM_URL

RUN curl -o /tmp/$FILENAME ${HELM_URL} \
  && tar -zxvf /tmp/${FILENAME} -C /tmp \
  && mv /tmp/linux-amd64/helm /bin/helm \
  && rm -rf /tmp

RUN helm init --client-only

ENV PATH $PATH:/usr/local/gcloud/google-cloud-sdk/bin
ENV PATH $PATH:$JAVA_HOME/bin

RUN mkdir /data
WORKDIR /data

CMD ["/usr/bin/java -version"]
