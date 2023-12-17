# Mutual TLS Client Library

## Purpose

The purpose of the library is to prove the mtlsRestTemplate for clients so they can easily communicate to Api's
using mTls.

## Usage

The library using Spring Boot 3.2 and Java 21 so the set up now uses SslBundles. The usage in the consumer of the
library is:

`application.properties`

```yaml
mtls.enabled=true // will activate the mtlsRestTemplate
mtls.private-key-passwd=password // password of the consumber-private-key.pem file
```

The following files need to be added to the resources directory of the library consumer:

--> consumer-certs

|----> apicert.pem - is the certificate from the api

|----> consumer-private-key.pem - is the private key from the library consumer / api consumer

|----> consumercert.pem - is the certificate from the consumer / api consumer

## Generating the files

#### Create the consumer's public / private keypair
```commandline
 keytool -genkeypair -alias my-alias -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore client-keystore-local.p12 -validity 365
```
#### Extract the public key to a certificate in the form of a pem file
```commandline
keytool -exportcert -rfc -keystore client-keystore-local.p12 -storetype PKCS12 -storepass mysecret -alias my-alias -file consumercert.pem
```
#### Extract the private key to a pem file
```commandline
openssl pkcs12 -in client-keystore-local.p12 -out consumer-private-key.pem -nocerts
```

